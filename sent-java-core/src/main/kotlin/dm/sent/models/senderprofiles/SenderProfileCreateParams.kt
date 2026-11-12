// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.sms.MarketCompliance
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a sender profile under your organization. A profile is a customer of yours: it sends
 * under its own or your identity, and your customers never see Sent.
 *
 * ## The minimum
 *
 * `{ "name": "Example Retail", "short_name": "Example" }`. `short_name` is the SMS sender id and is
 * required. Inbox and opt-out list come from your organization. Its brand and campaign are your
 * organization's only where `compliance` says `{ "inherit": true }` — omitted, the profile has
 * neither. Billing defaults to the profile's own balance, with your organization covering what it
 * cannot.
 *
 * **A sender is not one of them.** The brand and the campaign can be inherited; a number cannot. A
 * profile either has a sender of its own — `channels.sms` — or it has none and reaches only the
 * countries Sent runs a shared route for. The US has none: without a `TEN_DLC` number of its own, a
 * profile's SMS to US numbers ends as `FAILED` with `DELIVERY_003`.
 *
 * ## Saying what a profile owns
 *
 * Every capability is one of three things, and there is no flag per state:
 * - **Its own** — supply the capability's fields. Data is what owning looks like.
 * - **The organization's** — `{ "inherit": true }`, with nothing else.
 * - **None** — omit the block.
 *
 * There is no `"inherit": false` that also carries no data. A second way to say the same thing
 * would let a request contradict itself.
 *
 * Inheriting needs no id. A customer has exactly one brand, so `brand` resolves without one.
 *
 * **The campaign has no block of its own.** It is only ever a registration, and every field of one
 * is something a specific market demands — so it lives in `compliance`, alongside the rest of what
 * that market asks for, and it says whose it is there too: `"compliance": { "campaign": {
 * "inherit": true } }` runs the profile on your organization's campaign and brand, and stops this
 * call asking for any campaign field. `"brand": { "inherit": true }` alone inherits the brand only:
 * the campaign is then the profile's own. Inheriting takes *all* of your organization's, because
 * inheritance resolves an owner rather than a single row.
 *
 * A profile with a `brand` of its own **cannot** inherit the campaign, and asking is refused with
 * `400`: a campaign is filed against a brand registration, and your organization's campaign is
 * filed against your organization's brand rather than this profile's. Inherit both, own both, or
 * inherit the brand and own the campaign.
 *
 * `channels.sms` is the market the profile starts in — one `country` and `number_type`. It decides
 * what else this call asks for: the compliance catalog is keyed on that pair, and it determines
 * which fields `brand` accepts and what `compliance` answers for.
 *
 * **Several numbers in that market**: `channels.sms.numbers` lists them, one entry per area code,
 * e.g. `[{"area_code": "212", "quantity": 2}, {"quantity": 1}]` for two in 212 and one in any area
 * code. `quantity` defaults to 1, an entry without `area_code` means any area code, and the total
 * is at most 49. The market is created with **one campaign**, the one in `compliance.campaign`, and
 * a US `TEN_DLC` market's numbers are stored on it and assigned when it is approved. A profile
 * inheriting your organization's campaign keeps one number. Every number is listed in
 * `channels.sms[].numbers` with its area code and status.
 *
 * A profile is a tenant, not a market, so it can go on to send in several — but through `POST
 * /v3/channels/sms` with the `x-profile-id` header, one market and its compliance at a time. Reads
 * return every market as `channels.sms[]`, so the read shape is a list even where this one is not.
 *
 * `brand` is required when `number_type` is `TEN_DLC` — inherited or its own. A 10DLC registration
 * has nothing to attach to without one, and no later call can supply it, so omitting it is refused
 * with `400` rather than reported as outstanding.
 *
 * ## Use cases and volume
 *
 * A TCR campaign declares one to five `use_cases`, each with its own `sample_messages` — TCR
 * attributes samples to the use case they illustrate, so they travel together.
 *
 * How that set registers is derived from `volume` and never declared. Below the low-volume
 * threshold the campaign registers as `LOW_VOLUME` with every entry as a sub-use-case; above it,
 * one entry registers as that use case outright and several register as `MIXED` with sub-use-cases.
 * `MIXED` and `LOW_VOLUME` are therefore refused as `use_case` values: they describe the shape of a
 * set, which is ours to work out.
 *
 * **Leaving `volume` out is accepted and costs more.** An absent value registers the campaign at
 * the standard tier, which carries the higher fee — so say so when a campaign is low volume. Sole
 * proprietor brands are the exception: their fee is fixed by entity type, and volume only decides
 * the use case.
 *
 * ## Compliance
 *
 * `brand` is captured identically in every country. Everything a specific market demands on top of
 * it — including every field of the campaign — goes in `compliance`, as key/value entries whose
 * keys depend on the sender's country and type. US `TEN_DLC` registers with The Campaign Registry
 * and asks for a substantial set; an alphanumeric sender may pre-register with documents, or need
 * nothing at all.
 *
 * You do not have to know any of it. Omit `compliance` and the response lists exactly what is
 * outstanding, with types and accepted values — or call `GET /v3/compliance/requirements` first.
 * Anything Sent supplies on your behalf is never asked for, and is rejected if sent.
 *
 * Requirements can be conditional, and the condition is published as `required_when` so you can
 * render a form from it rather than discover the rule by being rejected. Every US `TEN_DLC`
 * campaign field carries `compliance.inherit != true` — send `"inherit": true` and none of them is
 * asked for or accepted, because the profile is running on your organization's campaign.
 *
 * ## Uploading documents
 *
 * Send `application/json` for everything except a market that pre-registers a sender with
 * supporting documents. For those, send `multipart/form-data` instead: put this entire document —
 * unchanged — in a single field named `profile`, and attach each file under a field named after the
 * compliance key it satisfies. Individual form fields per property are not read; the payload is
 * always the one `profile` field.
 *
 * A pre-registration market has no `brand` and no `campaign` — those are asked for only where a
 * regime registers one — so its `compliance` carries nothing at all, and the documents are the
 * request:
 * ```bash
 * curl -X POST https://api.sent.dm/v3/sender-profiles \
 *   -H 'x-api-key: YOUR_SECRET_TOKEN' \
 *   -F 'profile={
 *         "name": "Example Retail",
 *         "short_name": "EXAMPLE",
 *         "channels": {
 *           "sms": {
 *             "country": "XK",
 *             "number_type": "ALPHANUMERIC",
 *             "sender_value": "EXAMPLE"
 *           }
 *         }
 *       }' \
 *   -F 'business_registration=@registration.pdf' \
 *   -F 'letter_of_authorization=@loa.pdf'
 * ```
 *
 * `business_registration` and `letter_of_authorization` are illustrative. The real field names are
 * whatever that market configures, so read them from `GET /v3/compliance/requirements`, which lists
 * documents separately from the values — under `attachments`, each with the `field_name` to put the
 * file under.
 *
 * A document has no JSON form, so naming one in `compliance` is refused with `400` rather than
 * ignored: accepting it would report the requirement as satisfied while no file was ever stored.
 *
 * ## WhatsApp and RCS
 *
 * Neither can be inherited, so neither takes an `inherit`: the profile's WhatsApp account and RCS
 * agent are its own or it has none. Sharing your organization's would share its inbox and its
 * throughput, which makes the two indistinguishable to a recipient.
 *
 * `channels.whatsapp` names one of the accounts shared into your organization, and takes the two
 * identifiers nothing else can supply: `waba_id`, because your organization holds one account per
 * client, and `phone_number_id`, because naming the account's number is what assigns it to the
 * profile as the number it sends from.
 *
 * Everything else is resolved from your organization — the Multi-Partner Solution the account
 * arrived through, the client business portfolio that owns it, the access token and that token's
 * expiry. None of them is accepted here: the first two are Meta's answer about provenance, so a
 * value you sent could assert a partnership Meta disagrees with, and the token is minted per client
 * business and rotates roughly every sixty days.
 *
 * `phone_number_id` is optional. Omit it to connect the account now and settle the number later —
 * the channel reads as `ACTION_NEEDED` with `reason_code` `CHANNEL_007`, and the profile's WhatsApp
 * messages fail until a number is named. They do not fall back to your organization's account.
 * `POST /v3/channels/whatsapp` connects an account to an existing profile and resolves the same
 * fields the same way.
 *
 * An account of its own needs a sender of its own, so `channels.whatsapp` requires `channels.sms`.
 * A profile sending SMS on your organization's sender shares that inbox and opt-out list, and is
 * not a separate tenant to give an account to — asking is refused with `400`, before your
 * organization is asked to resolve anything.
 *
 * `channels.rcs` records the RCS agent. RCS (Rich Communication Services) is the next-generation
 * SMS standard built into Android — it lets you send branded messages with images, buttons and read
 * receipts over the carrier network, with no app install required. Learn more in the
 * [Google RCS documentation](https://developers.google.com/business-communications/rcs-business-messaging).
 *
 * All fields on the agent form are required except `opt_in_screenshot_url`. The full form must be
 * submitted in one go so the carrier review has everything it needs. A carrier approval no API call
 * can trigger is arranged offline, so the status reports `PROVISIONING` until it is.
 *
 * ## Responses
 *
 * `201` when the profile is complete on return — the fully-inherited case, where nothing needs
 * registering. `202` when something is still provisioning, with per-capability status and
 * outstanding requirements. `409` when the WhatsApp account supplied is already recorded. `400`
 * covers a wrong value as well as a missing one: a missing brand under `TEN_DLC`, a brand or
 * campaign inherited under `TEN_DLC` that your organization does not have yet, an unknown
 * compliance key, a bad type, a sender id the market does not allow, a `waba_id` that is not one of
 * the accounts shared into your organization, or a WhatsApp account Meta rejects. `502` when Meta
 * could not be reached to verify the WhatsApp account; nothing was created, so retry.
 */
class SenderProfileCreateParams
private constructor(
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Who pays for what a sender profile sends.
     *
     * Ownership reads the same way as BrandRequest and CampaignRequest: inherit: true is the
     * organization paying; inherit: false (or an empty block) is the profile paying for itself.
     *
     * An absent block is the one place billing differs from brand and campaign: a profile still has
     * to be paid for, so omitting billing stores ProfileAndOrganizationBilling — the profile pays
     * first and its organization covers what the profile's balance cannot (see ResolveStored). {
     * "name": "..." } stays a complete request.
     *
     * Billing carries no fields of its own yet, so a profile paying for itself is { "inherit":
     * false } — or an empty block, which means the same. That is thinner than brand and campaign,
     * where supplying data is the act of owning; it becomes ordinary the moment billing gains a
     * contact or a payment method to carry.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun billing(): Optional<SenderProfileBillingRequest> = body.billing()

    /**
     * The channels the profile sends on. Each is independently the profile's own or absent — none
     * can be inherited, so none carries a mode and presence is the whole of the request.
     *
     * A profile can send SMS in several markets, but create takes one — the market it starts in.
     * Further markets are added through POST /v3/channels/sms with x-profile-id, and a read returns
     * them all as a list. Create stays singular permanently rather than being a list that accepts
     * one entry: the constraint is in the type, and there is no later widening to break the
     * contract.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channels(): Optional<SenderProfileChannels> = body.channels()

    /**
     * The compliance values a market registers with. `brand` and `campaign` apply to US `TEN_DLC`;
     * other markets fill this map with the document keys their own requirements name.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<MarketCompliance> = body.compliance()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * Display name for the profile. Required.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Who is notified about this profile's events: ORGANIZATION, SENDER_PROFILE, or
     * ORGANIZATION_AND_SENDER_PROFILE. Omitting it leaves the profile on the Organization default.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun notifications(): Optional<String> = body.notifications()

    /**
     * Short name, which is also the SMS sender id — required. 3–11 characters of letters, numbers
     * and spaces, with at least one letter.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun shortName(): Optional<String> = body.shortName()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [billing].
     *
     * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _billing(): JsonField<SenderProfileBillingRequest> = body._billing()

    /**
     * Returns the raw JSON value of [channels].
     *
     * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channels(): JsonField<SenderProfileChannels> = body._channels()

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _compliance(): JsonField<MarketCompliance> = body._compliance()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [notifications].
     *
     * Unlike [notifications], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _notifications(): JsonField<String> = body._notifications()

    /**
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _shortName(): JsonField<String> = body._shortName()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): SenderProfileCreateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [SenderProfileCreateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(senderProfileCreateParams: SenderProfileCreateParams) = apply {
            idempotencyKey = senderProfileCreateParams.idempotencyKey
            body = senderProfileCreateParams.body.toBuilder()
            additionalHeaders = senderProfileCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = senderProfileCreateParams.additionalQueryParams.toBuilder()
        }

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [sandbox]
         * - [billing]
         * - [channels]
         * - [compliance]
         * - [description]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun sandbox(sandbox: Boolean) = apply { body.sandbox(sandbox) }

        /**
         * Sets [Builder.sandbox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sandbox(sandbox: JsonField<Boolean>) = apply { body.sandbox(sandbox) }

        /**
         * Who pays for what a sender profile sends.
         *
         * Ownership reads the same way as BrandRequest and CampaignRequest: inherit: true is the
         * organization paying; inherit: false (or an empty block) is the profile paying for itself.
         *
         * An absent block is the one place billing differs from brand and campaign: a profile still
         * has to be paid for, so omitting billing stores ProfileAndOrganizationBilling — the
         * profile pays first and its organization covers what the profile's balance cannot (see
         * ResolveStored). { "name": "..." } stays a complete request.
         *
         * Billing carries no fields of its own yet, so a profile paying for itself is { "inherit":
         * false } — or an empty block, which means the same. That is thinner than brand and
         * campaign, where supplying data is the act of owning; it becomes ordinary the moment
         * billing gains a contact or a payment method to carry.
         */
        fun billing(billing: SenderProfileBillingRequest?) = apply { body.billing(billing) }

        /** Alias for calling [Builder.billing] with `billing.orElse(null)`. */
        fun billing(billing: Optional<SenderProfileBillingRequest>) = billing(billing.getOrNull())

        /**
         * Sets [Builder.billing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billing] with a well-typed [SenderProfileBillingRequest]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun billing(billing: JsonField<SenderProfileBillingRequest>) = apply {
            body.billing(billing)
        }

        /**
         * The channels the profile sends on. Each is independently the profile's own or absent —
         * none can be inherited, so none carries a mode and presence is the whole of the request.
         *
         * A profile can send SMS in several markets, but create takes one — the market it starts
         * in. Further markets are added through POST /v3/channels/sms with x-profile-id, and a read
         * returns them all as a list. Create stays singular permanently rather than being a list
         * that accepts one entry: the constraint is in the type, and there is no later widening to
         * break the contract.
         */
        fun channels(channels: SenderProfileChannels?) = apply { body.channels(channels) }

        /** Alias for calling [Builder.channels] with `channels.orElse(null)`. */
        fun channels(channels: Optional<SenderProfileChannels>) = channels(channels.getOrNull())

        /**
         * Sets [Builder.channels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channels] with a well-typed [SenderProfileChannels]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun channels(channels: JsonField<SenderProfileChannels>) = apply { body.channels(channels) }

        /**
         * The compliance values a market registers with. `brand` and `campaign` apply to US
         * `TEN_DLC`; other markets fill this map with the document keys their own requirements
         * name.
         */
        fun compliance(compliance: MarketCompliance) = apply { body.compliance(compliance) }

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [MarketCompliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<MarketCompliance>) = apply {
            body.compliance(compliance)
        }

        fun description(description: String?) = apply { body.description(description) }

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        /** Display name for the profile. Required. */
        fun name(name: String) = apply { body.name(name) }

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * Who is notified about this profile's events: ORGANIZATION, SENDER_PROFILE, or
         * ORGANIZATION_AND_SENDER_PROFILE. Omitting it leaves the profile on the Organization
         * default.
         */
        fun notifications(notifications: String?) = apply { body.notifications(notifications) }

        /** Alias for calling [Builder.notifications] with `notifications.orElse(null)`. */
        fun notifications(notifications: Optional<String>) =
            notifications(notifications.getOrNull())

        /**
         * Sets [Builder.notifications] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notifications] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun notifications(notifications: JsonField<String>) = apply {
            body.notifications(notifications)
        }

        /**
         * Short name, which is also the SMS sender id — required. 3–11 characters of letters,
         * numbers and spaces, with at least one letter.
         */
        fun shortName(shortName: String) = apply { body.shortName(shortName) }

        /**
         * Sets [Builder.shortName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shortName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun shortName(shortName: JsonField<String>) = apply { body.shortName(shortName) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [SenderProfileCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfileCreateParams =
            SenderProfileCreateParams(
                idempotencyKey,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Create a sender profile under the authenticated organization.
     *
     * How ownership is expressed. Every capability is one of two things, and the request says which
     * without a flag per state: { "inherit": true } uses the organization's; supplying the
     * capability's own fields creates one for the profile; omitting the block entirely means the
     * profile has none. Ownership is one boolean — data is what owning looks like, and a second way
     * to say it would let a request contradict itself.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val billing: JsonField<SenderProfileBillingRequest>,
        private val channels: JsonField<SenderProfileChannels>,
        private val compliance: JsonField<MarketCompliance>,
        private val description: JsonField<String>,
        private val name: JsonField<String>,
        private val notifications: JsonField<String>,
        private val shortName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("billing")
            @ExcludeMissing
            billing: JsonField<SenderProfileBillingRequest> = JsonMissing.of(),
            @JsonProperty("channels")
            @ExcludeMissing
            channels: JsonField<SenderProfileChannels> = JsonMissing.of(),
            @JsonProperty("compliance")
            @ExcludeMissing
            compliance: JsonField<MarketCompliance> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("notifications")
            @ExcludeMissing
            notifications: JsonField<String> = JsonMissing.of(),
            @JsonProperty("short_name")
            @ExcludeMissing
            shortName: JsonField<String> = JsonMissing.of(),
        ) : this(
            sandbox,
            billing,
            channels,
            compliance,
            description,
            name,
            notifications,
            shortName,
            mutableMapOf(),
        )

        fun toMutationRequest(): MutationRequest =
            MutationRequest.builder().sandbox(sandbox).build()

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Who pays for what a sender profile sends.
         *
         * Ownership reads the same way as BrandRequest and CampaignRequest: inherit: true is the
         * organization paying; inherit: false (or an empty block) is the profile paying for itself.
         *
         * An absent block is the one place billing differs from brand and campaign: a profile still
         * has to be paid for, so omitting billing stores ProfileAndOrganizationBilling — the
         * profile pays first and its organization covers what the profile's balance cannot (see
         * ResolveStored). { "name": "..." } stays a complete request.
         *
         * Billing carries no fields of its own yet, so a profile paying for itself is { "inherit":
         * false } — or an empty block, which means the same. That is thinner than brand and
         * campaign, where supplying data is the act of owning; it becomes ordinary the moment
         * billing gains a contact or a payment method to carry.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun billing(): Optional<SenderProfileBillingRequest> = billing.getOptional("billing")

        /**
         * The channels the profile sends on. Each is independently the profile's own or absent —
         * none can be inherited, so none carries a mode and presence is the whole of the request.
         *
         * A profile can send SMS in several markets, but create takes one — the market it starts
         * in. Further markets are added through POST /v3/channels/sms with x-profile-id, and a read
         * returns them all as a list. Create stays singular permanently rather than being a list
         * that accepts one entry: the constraint is in the type, and there is no later widening to
         * break the contract.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channels(): Optional<SenderProfileChannels> = channels.getOptional("channels")

        /**
         * The compliance values a market registers with. `brand` and `campaign` apply to US
         * `TEN_DLC`; other markets fill this map with the document keys their own requirements
         * name.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun compliance(): Optional<MarketCompliance> = compliance.getOptional("compliance")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Display name for the profile. Required.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Who is notified about this profile's events: ORGANIZATION, SENDER_PROFILE, or
         * ORGANIZATION_AND_SENDER_PROFILE. Omitting it leaves the profile on the Organization
         * default.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun notifications(): Optional<String> = notifications.getOptional("notifications")

        /**
         * Short name, which is also the SMS sender id — required. 3–11 characters of letters,
         * numbers and spaces, with at least one letter.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortName(): Optional<String> = shortName.getOptional("short_name")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [billing].
         *
         * Unlike [billing], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("billing")
        @ExcludeMissing
        fun _billing(): JsonField<SenderProfileBillingRequest> = billing

        /**
         * Returns the raw JSON value of [channels].
         *
         * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channels")
        @ExcludeMissing
        fun _channels(): JsonField<SenderProfileChannels> = channels

        /**
         * Returns the raw JSON value of [compliance].
         *
         * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("compliance")
        @ExcludeMissing
        fun _compliance(): JsonField<MarketCompliance> = compliance

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [notifications].
         *
         * Unlike [notifications], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("notifications")
        @ExcludeMissing
        fun _notifications(): JsonField<String> = notifications

        /**
         * Returns the raw JSON value of [shortName].
         *
         * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("short_name") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var billing: JsonField<SenderProfileBillingRequest> = JsonMissing.of()
            private var channels: JsonField<SenderProfileChannels> = JsonMissing.of()
            private var compliance: JsonField<MarketCompliance> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var notifications: JsonField<String> = JsonMissing.of()
            private var shortName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                billing = body.billing
                channels = body.channels
                compliance = body.compliance
                description = body.description
                name = body.name
                notifications = body.notifications
                shortName = body.shortName
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Sandbox flag - when true, the operation is simulated without side effects Useful for
             * testing integrations without actual execution
             */
            fun sandbox(sandbox: Boolean) = sandbox(JsonField.of(sandbox))

            /**
             * Sets [Builder.sandbox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sandbox(sandbox: JsonField<Boolean>) = apply { this.sandbox = sandbox }

            /**
             * Who pays for what a sender profile sends.
             *
             * Ownership reads the same way as BrandRequest and CampaignRequest: inherit: true is
             * the organization paying; inherit: false (or an empty block) is the profile paying for
             * itself.
             *
             * An absent block is the one place billing differs from brand and campaign: a profile
             * still has to be paid for, so omitting billing stores ProfileAndOrganizationBilling —
             * the profile pays first and its organization covers what the profile's balance cannot
             * (see ResolveStored). { "name": "..." } stays a complete request.
             *
             * Billing carries no fields of its own yet, so a profile paying for itself is {
             * "inherit": false } — or an empty block, which means the same. That is thinner than
             * brand and campaign, where supplying data is the act of owning; it becomes ordinary
             * the moment billing gains a contact or a payment method to carry.
             */
            fun billing(billing: SenderProfileBillingRequest?) =
                billing(JsonField.ofNullable(billing))

            /** Alias for calling [Builder.billing] with `billing.orElse(null)`. */
            fun billing(billing: Optional<SenderProfileBillingRequest>) =
                billing(billing.getOrNull())

            /**
             * Sets [Builder.billing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billing] with a well-typed
             * [SenderProfileBillingRequest] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun billing(billing: JsonField<SenderProfileBillingRequest>) = apply {
                this.billing = billing
            }

            /**
             * The channels the profile sends on. Each is independently the profile's own or absent
             * — none can be inherited, so none carries a mode and presence is the whole of the
             * request.
             *
             * A profile can send SMS in several markets, but create takes one — the market it
             * starts in. Further markets are added through POST /v3/channels/sms with x-profile-id,
             * and a read returns them all as a list. Create stays singular permanently rather than
             * being a list that accepts one entry: the constraint is in the type, and there is no
             * later widening to break the contract.
             */
            fun channels(channels: SenderProfileChannels?) =
                channels(JsonField.ofNullable(channels))

            /** Alias for calling [Builder.channels] with `channels.orElse(null)`. */
            fun channels(channels: Optional<SenderProfileChannels>) = channels(channels.getOrNull())

            /**
             * Sets [Builder.channels] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channels] with a well-typed [SenderProfileChannels]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun channels(channels: JsonField<SenderProfileChannels>) = apply {
                this.channels = channels
            }

            /**
             * The compliance values a market registers with. `brand` and `campaign` apply to US
             * `TEN_DLC`; other markets fill this map with the document keys their own requirements
             * name.
             */
            fun compliance(compliance: MarketCompliance) = compliance(JsonField.of(compliance))

            /**
             * Sets [Builder.compliance] to an arbitrary JSON value.
             *
             * You should usually call [Builder.compliance] with a well-typed [MarketCompliance]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun compliance(compliance: JsonField<MarketCompliance>) = apply {
                this.compliance = compliance
            }

            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /** Display name for the profile. Required. */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Who is notified about this profile's events: ORGANIZATION, SENDER_PROFILE, or
             * ORGANIZATION_AND_SENDER_PROFILE. Omitting it leaves the profile on the Organization
             * default.
             */
            fun notifications(notifications: String?) =
                notifications(JsonField.ofNullable(notifications))

            /** Alias for calling [Builder.notifications] with `notifications.orElse(null)`. */
            fun notifications(notifications: Optional<String>) =
                notifications(notifications.getOrNull())

            /**
             * Sets [Builder.notifications] to an arbitrary JSON value.
             *
             * You should usually call [Builder.notifications] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun notifications(notifications: JsonField<String>) = apply {
                this.notifications = notifications
            }

            /**
             * Short name, which is also the SMS sender id — required. 3–11 characters of letters,
             * numbers and spaces, with at least one letter.
             */
            fun shortName(shortName: String) = shortName(JsonField.of(shortName))

            /**
             * Sets [Builder.shortName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shortName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    sandbox,
                    billing,
                    channels,
                    compliance,
                    description,
                    name,
                    notifications,
                    shortName,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws SentInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            sandbox()
            billing().ifPresent { it.validate() }
            channels().ifPresent { it.validate() }
            compliance().ifPresent { it.validate() }
            description()
            name()
            notifications()
            shortName()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: SentInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (sandbox.asKnown().isPresent) 1 else 0) +
                (billing.asKnown().getOrNull()?.validity() ?: 0) +
                (channels.asKnown().getOrNull()?.validity() ?: 0) +
                (compliance.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (notifications.asKnown().isPresent) 1 else 0) +
                (if (shortName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                billing == other.billing &&
                channels == other.channels &&
                compliance == other.compliance &&
                description == other.description &&
                name == other.name &&
                notifications == other.notifications &&
                shortName == other.shortName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                billing,
                channels,
                compliance,
                description,
                name,
                notifications,
                shortName,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, billing=$billing, channels=$channels, compliance=$compliance, description=$description, name=$name, notifications=$notifications, shortName=$shortName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfileCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "SenderProfileCreateParams{idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
