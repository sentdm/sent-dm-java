// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Body of a channel event: where one of the customer's channels stands in provisioning and
 * compliance. Delivered when a milestone moves — a registration filed, a verdict returned, a
 * resubmission asked for, a sender gone live — so a customer's own onboarding UI does not have to
 * poll GET /v3/channels.
 *
 * The subject is one item, never the account. A customer's "SMS channel" has no status; a market
 * does. Country, NumberType and SenderValue name which one, so a customer terminating only to
 * Kosovo never receives an event about US 10DLC.
 *
 * Status is the stable half of the contract. It is the same four-value set GET /v3/channels
 * publishes, computed through the same code, so an event and a read of the same market cannot
 * disagree. A subscriber that reads nothing but the status and the subject fields is a correct
 * subscriber. The sub-type on the envelope names the specific milestone and is additive — that
 * vocabulary comes from registries and carriers, which are parties Sent does not control.
 *
 * Status means provisioning and compliance are complete, not that a send will succeed right now. An
 * account can be suspended, or a destination blocked by a routing rule, without either showing up
 * here. Those are separate surfaces and deliberately not modelled on this payload.
 */
class ChannelEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val country: JsonField<String>,
    private val accountId: JsonField<String>,
    private val channel: JsonField<String>,
    private val compliance: JsonField<Compliance>,
    private val numberType: JsonField<String>,
    private val reason: JsonField<String>,
    private val senderValue: JsonField<String>,
    private val status: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("compliance")
        @ExcludeMissing
        compliance: JsonField<Compliance> = JsonMissing.of(),
        @JsonProperty("number_type")
        @ExcludeMissing
        numberType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sender_value")
        @ExcludeMissing
        senderValue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        country,
        accountId,
        channel,
        compliance,
        numberType,
        reason,
        senderValue,
        status,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The market's destination country as an ISO 3166-1 alpha-2 code, for example XK. Always
     * present, and the property that identifies this payload among the delivered envelopes — see
     * DeliveredWebhookEvents. Every event in this family reports one market, and a market has a
     * country.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun country(): String = country.getRequired("country")

    /**
     * The account whose market this is, named as on every other family. When an organization
     * receives an event for one of its sender profiles this is the profile, so a reseller compares
     * it with its own id and anything different is one of its profiles. Matches customer_id on GET
     * /v3/channels and the sender profile's id. Together with channel, country, and number_type, it
     * identifies the market.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * The channel this market belongs to: sms, whatsapp, or rcs. Never sent — that value belongs to
     * message events, where it names the smart-routing brand rather than a channel that can be
     * provisioned.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * What a market has been given: the identity it registers under, its programme, and any
     * documents attached.
     *
     * What it does not carry is what the market asks for. That is the subject of GET
     * /v3/compliance/requirements, and it is the same answer for every caller — a description of
     * what a compliance regime wants, not a record of one customer's progress through it. It was
     * reported here as well for a while, which put the same array in six response shapes and left a
     * caller deciding which of two sources to believe.
     *
     * Present on a list read for markets that register (carrying brand and campaign), but with
     * documents absent — documents are not fetched for a list, because a catalog lookup and a
     * document read per market would multiply across a page. Absent documents is distinct from an
     * empty list: absent says they were not fetched; empty says the market has been given none. The
     * parent object is null only when the market registers with nobody and compliance was not
     * computed — nothing to show at all.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun compliance(): Optional<Compliance> = compliance.getOptional("compliance")

    /**
     * The kind of sender the market uses, for example TEN_DLC, LOCAL, or ALPHANUMERIC. Omitted when
     * the subject has no sender type of its own.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun numberType(): Optional<String> = numberType.getOptional("number_type")

    /**
     * Why the market reached this state, when a reason was given — a correction explained, or a
     * campaign lapse. Free text, passed through from the registry or carrier that wrote it, so
     * treat it as a message to show a human rather than a value to branch on.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * The sender itself — a number in E.164, or an alphanumeric sender ID.
     *
     * Always present, and null until a sender exists. The key is on every delivery so a subscriber
     * reads one shape rather than branching on whether the field arrived — the same choice
     * template_id makes on the message payload.
     *
     * It can carry a value at any point in the lifecycle, not only once the market is live: a
     * number ordered and not yet active at the carrier is already known during PROVISIONING, and an
     * alphanumeric sender the customer chose themselves is known before anything is filed. It is
     * null while the market is still waiting on a number, which for a US 10DLC registration is
     * every event up to channel.activated.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

    /**
     * Where the market stands: PENDING_REVIEW, ACTION_NEEDED, PROVISIONING, ACTIVE or INACTIVE.
     * PENDING_REVIEW means a registry or a carrier holds it and the wait is theirs; ACTION_NEEDED
     * means it is yours; PROVISIONING means the verdict is in and Sent is acquiring the sender;
     * INACTIVE means it had a working sender and no longer does.
     *
     * Each event name is the transition into one of these, but the two are separate fields and may
     * legitimately differ. A resubmission filed against a market whose sender is already live is
     * channel.submitted carrying ACTIVE: a correction is with the registry and the sender keeps
     * working. Read both.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * When the transition happened, in UTC (yyyy-MM-ddTHH:mm:ssZ).
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

    /**
     * Returns the raw JSON value of [country].
     *
     * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compliance")
    @ExcludeMissing
    fun _compliance(): JsonField<Compliance> = compliance

    /**
     * Returns the raw JSON value of [numberType].
     *
     * Unlike [numberType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number_type") @ExcludeMissing fun _numberType(): JsonField<String> = numberType

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [senderValue].
     *
     * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_value")
    @ExcludeMissing
    fun _senderValue(): JsonField<String> = senderValue

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

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

        /**
         * Returns a mutable builder for constructing an instance of [ChannelEventPayload].
         *
         * The following fields are required:
         * ```java
         * .country()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChannelEventPayload]. */
    class Builder internal constructor() {

        private var country: JsonField<String>? = null
        private var accountId: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var compliance: JsonField<Compliance> = JsonMissing.of()
        private var numberType: JsonField<String> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var senderValue: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(channelEventPayload: ChannelEventPayload) = apply {
            country = channelEventPayload.country
            accountId = channelEventPayload.accountId
            channel = channelEventPayload.channel
            compliance = channelEventPayload.compliance
            numberType = channelEventPayload.numberType
            reason = channelEventPayload.reason
            senderValue = channelEventPayload.senderValue
            status = channelEventPayload.status
            updatedAt = channelEventPayload.updatedAt
            additionalProperties = channelEventPayload.additionalProperties.toMutableMap()
        }

        /**
         * The market's destination country as an ISO 3166-1 alpha-2 code, for example XK. Always
         * present, and the property that identifies this payload among the delivered envelopes —
         * see DeliveredWebhookEvents. Every event in this family reports one market, and a market
         * has a country.
         */
        fun country(country: String) = country(JsonField.of(country))

        /**
         * Sets [Builder.country] to an arbitrary JSON value.
         *
         * You should usually call [Builder.country] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun country(country: JsonField<String>) = apply { this.country = country }

        /**
         * The account whose market this is, named as on every other family. When an organization
         * receives an event for one of its sender profiles this is the profile, so a reseller
         * compares it with its own id and anything different is one of its profiles. Matches
         * customer_id on GET /v3/channels and the sender profile's id. Together with channel,
         * country, and number_type, it identifies the market.
         */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /**
         * The channel this market belongs to: sms, whatsapp, or rcs. Never sent — that value
         * belongs to message events, where it names the smart-routing brand rather than a channel
         * that can be provisioned.
         */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /**
         * What a market has been given: the identity it registers under, its programme, and any
         * documents attached.
         *
         * What it does not carry is what the market asks for. That is the subject of GET
         * /v3/compliance/requirements, and it is the same answer for every caller — a description
         * of what a compliance regime wants, not a record of one customer's progress through it. It
         * was reported here as well for a while, which put the same array in six response shapes
         * and left a caller deciding which of two sources to believe.
         *
         * Present on a list read for markets that register (carrying brand and campaign), but with
         * documents absent — documents are not fetched for a list, because a catalog lookup and a
         * document read per market would multiply across a page. Absent documents is distinct from
         * an empty list: absent says they were not fetched; empty says the market has been given
         * none. The parent object is null only when the market registers with nobody and compliance
         * was not computed — nothing to show at all.
         */
        fun compliance(compliance: Compliance?) = compliance(JsonField.ofNullable(compliance))

        /** Alias for calling [Builder.compliance] with `compliance.orElse(null)`. */
        fun compliance(compliance: Optional<Compliance>) = compliance(compliance.getOrNull())

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [Compliance] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun compliance(compliance: JsonField<Compliance>) = apply { this.compliance = compliance }

        /**
         * The kind of sender the market uses, for example TEN_DLC, LOCAL, or ALPHANUMERIC. Omitted
         * when the subject has no sender type of its own.
         */
        fun numberType(numberType: String?) = numberType(JsonField.ofNullable(numberType))

        /** Alias for calling [Builder.numberType] with `numberType.orElse(null)`. */
        fun numberType(numberType: Optional<String>) = numberType(numberType.getOrNull())

        /**
         * Sets [Builder.numberType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numberType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun numberType(numberType: JsonField<String>) = apply { this.numberType = numberType }

        /**
         * Why the market reached this state, when a reason was given — a correction explained, or a
         * campaign lapse. Free text, passed through from the registry or carrier that wrote it, so
         * treat it as a message to show a human rather than a value to branch on.
         */
        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        /**
         * The sender itself — a number in E.164, or an alphanumeric sender ID.
         *
         * Always present, and null until a sender exists. The key is on every delivery so a
         * subscriber reads one shape rather than branching on whether the field arrived — the same
         * choice template_id makes on the message payload.
         *
         * It can carry a value at any point in the lifecycle, not only once the market is live: a
         * number ordered and not yet active at the carrier is already known during PROVISIONING,
         * and an alphanumeric sender the customer chose themselves is known before anything is
         * filed. It is null while the market is still waiting on a number, which for a US 10DLC
         * registration is every event up to channel.activated.
         */
        fun senderValue(senderValue: String?) = senderValue(JsonField.ofNullable(senderValue))

        /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
        fun senderValue(senderValue: Optional<String>) = senderValue(senderValue.getOrNull())

        /**
         * Sets [Builder.senderValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun senderValue(senderValue: JsonField<String>) = apply { this.senderValue = senderValue }

        /**
         * Where the market stands: PENDING_REVIEW, ACTION_NEEDED, PROVISIONING, ACTIVE or INACTIVE.
         * PENDING_REVIEW means a registry or a carrier holds it and the wait is theirs;
         * ACTION_NEEDED means it is yours; PROVISIONING means the verdict is in and Sent is
         * acquiring the sender; INACTIVE means it had a working sender and no longer does.
         *
         * Each event name is the transition into one of these, but the two are separate fields and
         * may legitimately differ. A resubmission filed against a market whose sender is already
         * live is channel.submitted carrying ACTIVE: a correction is with the registry and the
         * sender keeps working. Read both.
         */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** When the transition happened, in UTC (yyyy-MM-ddTHH:mm:ssZ). */
        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [ChannelEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .country()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChannelEventPayload =
            ChannelEventPayload(
                checkRequired("country", country),
                accountId,
                channel,
                compliance,
                numberType,
                reason,
                senderValue,
                status,
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): ChannelEventPayload = apply {
        if (validated) {
            return@apply
        }

        country()
        accountId()
        channel()
        compliance().ifPresent { it.validate() }
        numberType()
        reason()
        senderValue()
        status()
        updatedAt()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (country.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (compliance.asKnown().getOrNull()?.validity() ?: 0) +
            (if (numberType.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (senderValue.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    /**
     * What a market has been given: the identity it registers under, its programme, and any
     * documents attached.
     *
     * What it does not carry is what the market asks for. That is the subject of GET
     * /v3/compliance/requirements, and it is the same answer for every caller — a description of
     * what a compliance regime wants, not a record of one customer's progress through it. It was
     * reported here as well for a while, which put the same array in six response shapes and left a
     * caller deciding which of two sources to believe.
     *
     * Present on a list read for markets that register (carrying brand and campaign), but with
     * documents absent — documents are not fetched for a list, because a catalog lookup and a
     * document read per market would multiply across a page. Absent documents is distinct from an
     * empty list: absent says they were not fetched; empty says the market has been given none. The
     * parent object is null only when the market registers with nobody and compliance was not
     * computed — nothing to show at all.
     */
    class Compliance
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val brand: JsonField<Brand>,
        private val campaign: JsonField<Campaign>,
        private val documents: JsonField<List<Document>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("brand") @ExcludeMissing brand: JsonField<Brand> = JsonMissing.of(),
            @JsonProperty("campaign")
            @ExcludeMissing
            campaign: JsonField<Campaign> = JsonMissing.of(),
            @JsonProperty("documents")
            @ExcludeMissing
            documents: JsonField<List<Document>> = JsonMissing.of(),
        ) : this(brand, campaign, documents, mutableMapOf())

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brand(): Optional<Brand> = brand.getOptional("brand")

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun campaign(): Optional<Campaign> = campaign.getOptional("campaign")

        /**
         * What has been supplied for this market.
         *
         * Files, not values — the declared halves above carry the values. A document cannot be a
         * JSON value, so it is sent as multipart on the channel call and reported here as a
         * reference.
         *
         * Absent on a list read, which fetches identity but does not compute compliance documents
         * per market. Absent and empty mean different things: absent says the documents were not
         * fetched; empty says the market has been given none.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun documents(): Optional<List<Document>> = documents.getOptional("documents")

        /**
         * Returns the raw JSON value of [brand].
         *
         * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<Brand> = brand

        /**
         * Returns the raw JSON value of [campaign].
         *
         * Unlike [campaign], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaign") @ExcludeMissing fun _campaign(): JsonField<Campaign> = campaign

        /**
         * Returns the raw JSON value of [documents].
         *
         * Unlike [documents], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("documents")
        @ExcludeMissing
        fun _documents(): JsonField<List<Document>> = documents

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

            /** Returns a mutable builder for constructing an instance of [Compliance]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Compliance]. */
        class Builder internal constructor() {

            private var brand: JsonField<Brand> = JsonMissing.of()
            private var campaign: JsonField<Campaign> = JsonMissing.of()
            private var documents: JsonField<MutableList<Document>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(compliance: Compliance) = apply {
                brand = compliance.brand
                campaign = compliance.campaign
                documents = compliance.documents.map { it.toMutableList() }
                additionalProperties = compliance.additionalProperties.toMutableMap()
            }

            /**
             * The identity this market registers under, with inherit saying whose it is.
             *
             * Reported here rather than on the profile because it belongs to the registration this
             * market files, and only one market files one. It was a top-level block for a while,
             * which put a per-registration value beside a list of markets and left a caller to work
             * out which market it belonged to.
             *
             * Absent for a market that registers with nobody — such a market asks for no identity,
             * so there is none to report. Absent and null mean different things: absent says this
             * market does not ask, null would say it asks and nothing was supplied.
             *
             * Untyped, like the request side, because its members are declared by the market's own
             * schema rather than by a C# class. A typed pair here would be a second definition of
             * what a market wants, free to drift from the one that validates.
             */
            fun brand(brand: Brand?) = brand(JsonField.ofNullable(brand))

            /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
            fun brand(brand: Optional<Brand>) = brand(brand.getOrNull())

            /**
             * Sets [Builder.brand] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun brand(brand: JsonField<Brand>) = apply { this.brand = brand }

            /**
             * The programme this market registers, with inherit saying whose it is.
             *
             * One, not a list. TcrCampaigns permits several and an account built on the admin side
             * may hold them, but this surface offers one — which is what lets the market's PATCH be
             * an upsert rather than a collection with an addressable create behind it. An account
             * holding several is reported as its first and refused on write, rather than
             * half-edited.
             *
             * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused
             * if the caller sent this object back — which it is meant to be able to do.
             */
            fun campaign(campaign: Campaign?) = campaign(JsonField.ofNullable(campaign))

            /** Alias for calling [Builder.campaign] with `campaign.orElse(null)`. */
            fun campaign(campaign: Optional<Campaign>) = campaign(campaign.getOrNull())

            /**
             * Sets [Builder.campaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaign] with a well-typed [Campaign] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaign(campaign: JsonField<Campaign>) = apply { this.campaign = campaign }

            /**
             * What has been supplied for this market.
             *
             * Files, not values — the declared halves above carry the values. A document cannot be
             * a JSON value, so it is sent as multipart on the channel call and reported here as a
             * reference.
             *
             * Absent on a list read, which fetches identity but does not compute compliance
             * documents per market. Absent and empty mean different things: absent says the
             * documents were not fetched; empty says the market has been given none.
             */
            fun documents(documents: List<Document>?) = documents(JsonField.ofNullable(documents))

            /** Alias for calling [Builder.documents] with `documents.orElse(null)`. */
            fun documents(documents: Optional<List<Document>>) = documents(documents.getOrNull())

            /**
             * Sets [Builder.documents] to an arbitrary JSON value.
             *
             * You should usually call [Builder.documents] with a well-typed `List<Document>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun documents(documents: JsonField<List<Document>>) = apply {
                this.documents = documents.map { it.toMutableList() }
            }

            /**
             * Adds a single [Document] to [documents].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDocument(document: Document) = apply {
                documents =
                    (documents ?: JsonField.of(mutableListOf())).also {
                        checkKnown("documents", it).add(document)
                    }
            }

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
             * Returns an immutable instance of [Compliance].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Compliance =
                Compliance(
                    brand,
                    campaign,
                    (documents ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Compliance = apply {
            if (validated) {
                return@apply
            }

            brand().ifPresent { it.validate() }
            campaign().ifPresent { it.validate() }
            documents().ifPresent { it.forEach { it.validate() } }
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
            (brand.asKnown().getOrNull()?.validity() ?: 0) +
                (campaign.asKnown().getOrNull()?.validity() ?: 0) +
                (documents.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /**
         * The identity this market registers under, with inherit saying whose it is.
         *
         * Reported here rather than on the profile because it belongs to the registration this
         * market files, and only one market files one. It was a top-level block for a while, which
         * put a per-registration value beside a list of markets and left a caller to work out which
         * market it belonged to.
         *
         * Absent for a market that registers with nobody — such a market asks for no identity, so
         * there is none to report. Absent and null mean different things: absent says this market
         * does not ask, null would say it asks and nothing was supplied.
         *
         * Untyped, like the request side, because its members are declared by the market's own
         * schema rather than by a C# class. A typed pair here would be a second definition of what
         * a market wants, free to drift from the one that validates.
         */
        class Brand
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Brand]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Brand]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(brand: Brand) = apply {
                    additionalProperties = brand.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Brand].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Brand = Brand(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Brand = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Brand && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Brand{additionalProperties=$additionalProperties}"
        }

        /**
         * The programme this market registers, with inherit saying whose it is.
         *
         * One, not a list. TcrCampaigns permits several and an account built on the admin side may
         * hold them, but this surface offers one — which is what lets the market's PATCH be an
         * upsert rather than a collection with an addressable create behind it. An account holding
         * several is reported as its first and refused on write, rather than half-edited.
         *
         * Carries no id. Nothing addresses a campaign, and an undeclared key would be refused if
         * the caller sent this object back — which it is meant to be able to do.
         */
        class Campaign
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Campaign]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Campaign]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(campaign: Campaign) = apply {
                    additionalProperties = campaign.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Campaign].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Campaign = Campaign(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Campaign = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Campaign && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Campaign{additionalProperties=$additionalProperties}"
        }

        /** A document a market asked for and has been given. */
        class Document
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val documentId: JsonField<String>,
            private val fileName: JsonField<String>,
            private val key: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("document_id")
                @ExcludeMissing
                documentId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("file_name")
                @ExcludeMissing
                fileName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            ) : this(documentId, fileName, key, mutableMapOf())

            /**
             * Identifier of the upload, for fetching it back through the documents endpoints.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun documentId(): Optional<String> = documentId.getOptional("document_id")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileName(): Optional<String> = fileName.getOptional("file_name")

            /**
             * The catalog's name for this document, matching the requirement it satisfies.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun key(): Optional<String> = key.getOptional("key")

            /**
             * Returns the raw JSON value of [documentId].
             *
             * Unlike [documentId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("document_id")
            @ExcludeMissing
            fun _documentId(): JsonField<String> = documentId

            /**
             * Returns the raw JSON value of [fileName].
             *
             * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            /**
             * Returns the raw JSON value of [key].
             *
             * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

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

                /** Returns a mutable builder for constructing an instance of [Document]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Document]. */
            class Builder internal constructor() {

                private var documentId: JsonField<String> = JsonMissing.of()
                private var fileName: JsonField<String> = JsonMissing.of()
                private var key: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(document: Document) = apply {
                    documentId = document.documentId
                    fileName = document.fileName
                    key = document.key
                    additionalProperties = document.additionalProperties.toMutableMap()
                }

                /**
                 * Identifier of the upload, for fetching it back through the documents endpoints.
                 */
                fun documentId(documentId: String?) = documentId(JsonField.ofNullable(documentId))

                /** Alias for calling [Builder.documentId] with `documentId.orElse(null)`. */
                fun documentId(documentId: Optional<String>) = documentId(documentId.getOrNull())

                /**
                 * Sets [Builder.documentId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.documentId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun documentId(documentId: JsonField<String>) = apply {
                    this.documentId = documentId
                }

                fun fileName(fileName: String?) = fileName(JsonField.ofNullable(fileName))

                /** Alias for calling [Builder.fileName] with `fileName.orElse(null)`. */
                fun fileName(fileName: Optional<String>) = fileName(fileName.getOrNull())

                /**
                 * Sets [Builder.fileName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                /** The catalog's name for this document, matching the requirement it satisfies. */
                fun key(key: String) = key(JsonField.of(key))

                /**
                 * Sets [Builder.key] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.key] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun key(key: JsonField<String>) = apply { this.key = key }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Document].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Document =
                    Document(documentId, fileName, key, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Document = apply {
                if (validated) {
                    return@apply
                }

                documentId()
                fileName()
                key()
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
                (if (documentId.asKnown().isPresent) 1 else 0) +
                    (if (fileName.asKnown().isPresent) 1 else 0) +
                    (if (key.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Document &&
                    documentId == other.documentId &&
                    fileName == other.fileName &&
                    key == other.key &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(documentId, fileName, key, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Document{documentId=$documentId, fileName=$fileName, key=$key, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Compliance &&
                brand == other.brand &&
                campaign == other.campaign &&
                documents == other.documents &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(brand, campaign, documents, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Compliance{brand=$brand, campaign=$campaign, documents=$documents, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChannelEventPayload &&
            country == other.country &&
            accountId == other.accountId &&
            channel == other.channel &&
            compliance == other.compliance &&
            numberType == other.numberType &&
            reason == other.reason &&
            senderValue == other.senderValue &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            country,
            accountId,
            channel,
            compliance,
            numberType,
            reason,
            senderValue,
            status,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChannelEventPayload{country=$country, accountId=$accountId, channel=$channel, compliance=$compliance, numberType=$numberType, reason=$reason, senderValue=$senderValue, status=$status, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
