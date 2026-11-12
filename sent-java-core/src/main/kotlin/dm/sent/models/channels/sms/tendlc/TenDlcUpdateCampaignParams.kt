// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Changes **one campaign of your own** on the US `TEN_DLC` market, named by its `id` in the
 * market's `compliance.campaigns`.
 *
 * ## What to send
 *
 * The fields to change, at the top level of the body, under the `compliance.campaign.*` keys `GET
 * /v3/compliance/requirements?country=US&type=TEN_DLC` lists, without that prefix. A field you
 * leave out keeps its value, and a rejected one is keyed by its name. `id` and `"inherit": false`
 * are ignored, so an entry of `compliance.campaigns` can be sent as read; `"inherit": true` is
 * `400`, because this call changes a campaign's fields, not whose campaign you run on. The campaign
 * only: add numbers with `POST /v3/channels/sms/numbers/US/TEN_DLC`, and change the brand or
 * documents with `PATCH /v3/channels/sms/US/TEN_DLC`.
 *
 * ## When it can be changed
 *
 * Until it is filed with The Campaign Registry, and again when we ask you to correct it. That
 * correction sends it back for review. A filed campaign is otherwise `409`, and so is a change
 * between low and high volume once it is registered. A campaign you run on from your organization
 * is `409` too: it is the organization's to change. So is one out of service: expired, deactivated
 * or released.
 *
 * Returns **the market**, in the shape `GET /v3/channels/sms/US/TEN_DLC` returns.
 */
class TenDlcUpdateCampaignParams
private constructor(
    private val campaignId: String?,
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun campaignId(): Optional<String> = Optional.ofNullable(campaignId)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * What this programme sends. TCR description: what recipients will get and why, in a sentence.
     * The only one of these TCR takes verbatim as a description of the programme, which is why it
     * is asked for rather than derived from the customer's name. Required when
     * `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * Help keywords. TCR helpKeywords, comma separated, e.g. HELP,INFO. Required when
     * `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun helpKeywords(): Optional<String> = body.helpKeywords()

    /**
     * Help reply. TCR helpMessage. Its presence is what sets subscriberHelp. Required when
     * `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun helpMessage(): Optional<String> = body.helpMessage()

    /**
     * Consent narrative. TCR messageFlow: how recipients opt in, in prose. Under 40 characters is
     * refused, and carriers reject vague descriptions — say where opt-in happens, that the box is
     * unchecked by default, and that consent is not a condition of purchase. Required when
     * `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageFlow(): Optional<String> = body.messageFlow()

    /**
     * Opt-in keywords. TCR optinKeywords, comma separated, e.g. START,YES. Required when
     * `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optInKeywords(): Optional<String> = body.optInKeywords()

    /**
     * Opt-in confirmation. TCR optinMessage. Should state message frequency and that rates may
     * apply. Its presence is what sets subscriberOptin. Required when `compliance.campaign.inherit
     * != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optInMessage(): Optional<String> = body.optInMessage()

    /**
     * Opt-out keywords. TCR optoutKeywords, comma separated. STOP, END, CANCEL, UNSUBSCRIBE and
     * QUIT are honoured regardless of what is declared. Required when `compliance.campaign.inherit
     * != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optOutKeywords(): Optional<String> = body.optOutKeywords()

    /**
     * Opt-out confirmation. TCR optoutMessage. Its presence is what sets subscriberOptout. Required
     * when `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optOutMessage(): Optional<String> = body.optOutMessage()

    /**
     * Privacy policy URL. TCR privacyPolicyLink. Required when `compliance.campaign.inherit !=
     * true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun privacyPolicyLink(): Optional<String> = body.privacyPolicyLink()

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Terms and conditions URL. TCR termsAndConditionsLink. Required when
     * `compliance.campaign.inherit != true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun termsAndConditionsLink(): Optional<String> = body.termsAndConditionsLink()

    /**
     * Use cases. What the campaign sends, and an example of each. One to five entries; how they
     * register is decided by volume, never declared. Required when `compliance.campaign.inherit !=
     * true`.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun useCases(): Optional<List<UseCase>> = body.useCases()

    /**
     * Expected monthly volume. Decides how the campaign registers and which fee tier applies: below
     * the low-volume threshold it registers as LOW_VOLUME with sub-use-cases, above it as a single
     * use case or MIXED. Omitting it registers the campaign at the higher-fee standard tier.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun volume(): Optional<String> = body.volume()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [helpKeywords].
     *
     * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _helpKeywords(): JsonField<String> = body._helpKeywords()

    /**
     * Returns the raw JSON value of [helpMessage].
     *
     * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _helpMessage(): JsonField<String> = body._helpMessage()

    /**
     * Returns the raw JSON value of [messageFlow].
     *
     * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _messageFlow(): JsonField<String> = body._messageFlow()

    /**
     * Returns the raw JSON value of [optInKeywords].
     *
     * Unlike [optInKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _optInKeywords(): JsonField<String> = body._optInKeywords()

    /**
     * Returns the raw JSON value of [optInMessage].
     *
     * Unlike [optInMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _optInMessage(): JsonField<String> = body._optInMessage()

    /**
     * Returns the raw JSON value of [optOutKeywords].
     *
     * Unlike [optOutKeywords], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _optOutKeywords(): JsonField<String> = body._optOutKeywords()

    /**
     * Returns the raw JSON value of [optOutMessage].
     *
     * Unlike [optOutMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _optOutMessage(): JsonField<String> = body._optOutMessage()

    /**
     * Returns the raw JSON value of [privacyPolicyLink].
     *
     * Unlike [privacyPolicyLink], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _privacyPolicyLink(): JsonField<String> = body._privacyPolicyLink()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [termsAndConditionsLink].
     *
     * Unlike [termsAndConditionsLink], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _termsAndConditionsLink(): JsonField<String> = body._termsAndConditionsLink()

    /**
     * Returns the raw JSON value of [useCases].
     *
     * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _useCases(): JsonField<List<UseCase>> = body._useCases()

    /**
     * Returns the raw JSON value of [volume].
     *
     * Unlike [volume], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _volume(): JsonField<String> = body._volume()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TenDlcUpdateCampaignParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of [TenDlcUpdateCampaignParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TenDlcUpdateCampaignParams]. */
    class Builder internal constructor() {

        private var campaignId: String? = null
        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(tenDlcUpdateCampaignParams: TenDlcUpdateCampaignParams) = apply {
            campaignId = tenDlcUpdateCampaignParams.campaignId
            idempotencyKey = tenDlcUpdateCampaignParams.idempotencyKey
            xProfileId = tenDlcUpdateCampaignParams.xProfileId
            body = tenDlcUpdateCampaignParams.body.toBuilder()
            additionalHeaders = tenDlcUpdateCampaignParams.additionalHeaders.toBuilder()
            additionalQueryParams = tenDlcUpdateCampaignParams.additionalQueryParams.toBuilder()
        }

        fun campaignId(campaignId: String?) = apply { this.campaignId = campaignId }

        /** Alias for calling [Builder.campaignId] with `campaignId.orElse(null)`. */
        fun campaignId(campaignId: Optional<String>) = campaignId(campaignId.getOrNull())

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [description]
         * - [helpKeywords]
         * - [helpMessage]
         * - [messageFlow]
         * - [optInKeywords]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * What this programme sends. TCR description: what recipients will get and why, in a
         * sentence. The only one of these TCR takes verbatim as a description of the programme,
         * which is why it is asked for rather than derived from the customer's name. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun description(description: String) = apply { body.description(description) }

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        /**
         * Help keywords. TCR helpKeywords, comma separated, e.g. HELP,INFO. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun helpKeywords(helpKeywords: String) = apply { body.helpKeywords(helpKeywords) }

        /**
         * Sets [Builder.helpKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.helpKeywords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun helpKeywords(helpKeywords: JsonField<String>) = apply {
            body.helpKeywords(helpKeywords)
        }

        /**
         * Help reply. TCR helpMessage. Its presence is what sets subscriberHelp. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun helpMessage(helpMessage: String) = apply { body.helpMessage(helpMessage) }

        /**
         * Sets [Builder.helpMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.helpMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun helpMessage(helpMessage: JsonField<String>) = apply { body.helpMessage(helpMessage) }

        /**
         * Consent narrative. TCR messageFlow: how recipients opt in, in prose. Under 40 characters
         * is refused, and carriers reject vague descriptions — say where opt-in happens, that the
         * box is unchecked by default, and that consent is not a condition of purchase. Required
         * when `compliance.campaign.inherit != true`.
         */
        fun messageFlow(messageFlow: String) = apply { body.messageFlow(messageFlow) }

        /**
         * Sets [Builder.messageFlow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageFlow] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageFlow(messageFlow: JsonField<String>) = apply { body.messageFlow(messageFlow) }

        /**
         * Opt-in keywords. TCR optinKeywords, comma separated, e.g. START,YES. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun optInKeywords(optInKeywords: String) = apply { body.optInKeywords(optInKeywords) }

        /**
         * Sets [Builder.optInKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optInKeywords] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optInKeywords(optInKeywords: JsonField<String>) = apply {
            body.optInKeywords(optInKeywords)
        }

        /**
         * Opt-in confirmation. TCR optinMessage. Should state message frequency and that rates may
         * apply. Its presence is what sets subscriberOptin. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun optInMessage(optInMessage: String) = apply { body.optInMessage(optInMessage) }

        /**
         * Sets [Builder.optInMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optInMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optInMessage(optInMessage: JsonField<String>) = apply {
            body.optInMessage(optInMessage)
        }

        /**
         * Opt-out keywords. TCR optoutKeywords, comma separated. STOP, END, CANCEL, UNSUBSCRIBE and
         * QUIT are honoured regardless of what is declared. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun optOutKeywords(optOutKeywords: String) = apply { body.optOutKeywords(optOutKeywords) }

        /**
         * Sets [Builder.optOutKeywords] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optOutKeywords] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun optOutKeywords(optOutKeywords: JsonField<String>) = apply {
            body.optOutKeywords(optOutKeywords)
        }

        /**
         * Opt-out confirmation. TCR optoutMessage. Its presence is what sets subscriberOptout.
         * Required when `compliance.campaign.inherit != true`.
         */
        fun optOutMessage(optOutMessage: String) = apply { body.optOutMessage(optOutMessage) }

        /**
         * Sets [Builder.optOutMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optOutMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun optOutMessage(optOutMessage: JsonField<String>) = apply {
            body.optOutMessage(optOutMessage)
        }

        /**
         * Privacy policy URL. TCR privacyPolicyLink. Required when `compliance.campaign.inherit !=
         * true`.
         */
        fun privacyPolicyLink(privacyPolicyLink: String) = apply {
            body.privacyPolicyLink(privacyPolicyLink)
        }

        /**
         * Sets [Builder.privacyPolicyLink] to an arbitrary JSON value.
         *
         * You should usually call [Builder.privacyPolicyLink] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun privacyPolicyLink(privacyPolicyLink: JsonField<String>) = apply {
            body.privacyPolicyLink(privacyPolicyLink)
        }

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
         * Terms and conditions URL. TCR termsAndConditionsLink. Required when
         * `compliance.campaign.inherit != true`.
         */
        fun termsAndConditionsLink(termsAndConditionsLink: String) = apply {
            body.termsAndConditionsLink(termsAndConditionsLink)
        }

        /**
         * Sets [Builder.termsAndConditionsLink] to an arbitrary JSON value.
         *
         * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun termsAndConditionsLink(termsAndConditionsLink: JsonField<String>) = apply {
            body.termsAndConditionsLink(termsAndConditionsLink)
        }

        /**
         * Use cases. What the campaign sends, and an example of each. One to five entries; how they
         * register is decided by volume, never declared. Required when `compliance.campaign.inherit
         * != true`.
         */
        fun useCases(useCases: List<UseCase>) = apply { body.useCases(useCases) }

        /**
         * Sets [Builder.useCases] to an arbitrary JSON value.
         *
         * You should usually call [Builder.useCases] with a well-typed `List<UseCase>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun useCases(useCases: JsonField<List<UseCase>>) = apply { body.useCases(useCases) }

        /**
         * Adds a single [UseCase] to [useCases].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUseCase(useCase: UseCase) = apply { body.addUseCase(useCase) }

        /**
         * Expected monthly volume. Decides how the campaign registers and which fee tier applies:
         * below the low-volume threshold it registers as LOW_VOLUME with sub-use-cases, above it as
         * a single use case or MIXED. Omitting it registers the campaign at the higher-fee standard
         * tier.
         */
        fun volume(volume: String) = apply { body.volume(volume) }

        /**
         * Sets [Builder.volume] to an arbitrary JSON value.
         *
         * You should usually call [Builder.volume] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun volume(volume: JsonField<String>) = apply { body.volume(volume) }

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
         * Returns an immutable instance of [TenDlcUpdateCampaignParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TenDlcUpdateCampaignParams =
            TenDlcUpdateCampaignParams(
                campaignId,
                idempotencyKey,
                xProfileId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> campaignId ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * The fields of one campaign on the US `TEN_DLC` market, at the top level of the body. Adding a
     * campaign needs all of them; changing one takes only the fields to change.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val helpKeywords: JsonField<String>,
        private val helpMessage: JsonField<String>,
        private val messageFlow: JsonField<String>,
        private val optInKeywords: JsonField<String>,
        private val optInMessage: JsonField<String>,
        private val optOutKeywords: JsonField<String>,
        private val optOutMessage: JsonField<String>,
        private val privacyPolicyLink: JsonField<String>,
        private val sandbox: JsonField<Boolean>,
        private val termsAndConditionsLink: JsonField<String>,
        private val useCases: JsonField<List<UseCase>>,
        private val volume: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("help_keywords")
            @ExcludeMissing
            helpKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("help_message")
            @ExcludeMissing
            helpMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message_flow")
            @ExcludeMissing
            messageFlow: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_in_keywords")
            @ExcludeMissing
            optInKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_in_message")
            @ExcludeMissing
            optInMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_out_keywords")
            @ExcludeMissing
            optOutKeywords: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_out_message")
            @ExcludeMissing
            optOutMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("privacy_policy_link")
            @ExcludeMissing
            privacyPolicyLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("terms_and_conditions_link")
            @ExcludeMissing
            termsAndConditionsLink: JsonField<String> = JsonMissing.of(),
            @JsonProperty("use_cases")
            @ExcludeMissing
            useCases: JsonField<List<UseCase>> = JsonMissing.of(),
            @JsonProperty("volume") @ExcludeMissing volume: JsonField<String> = JsonMissing.of(),
        ) : this(
            description,
            helpKeywords,
            helpMessage,
            messageFlow,
            optInKeywords,
            optInMessage,
            optOutKeywords,
            optOutMessage,
            privacyPolicyLink,
            sandbox,
            termsAndConditionsLink,
            useCases,
            volume,
            mutableMapOf(),
        )

        /**
         * What this programme sends. TCR description: what recipients will get and why, in a
         * sentence. The only one of these TCR takes verbatim as a description of the programme,
         * which is why it is asked for rather than derived from the customer's name. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Help keywords. TCR helpKeywords, comma separated, e.g. HELP,INFO. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpKeywords(): Optional<String> = helpKeywords.getOptional("help_keywords")

        /**
         * Help reply. TCR helpMessage. Its presence is what sets subscriberHelp. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpMessage(): Optional<String> = helpMessage.getOptional("help_message")

        /**
         * Consent narrative. TCR messageFlow: how recipients opt in, in prose. Under 40 characters
         * is refused, and carriers reject vague descriptions — say where opt-in happens, that the
         * box is unchecked by default, and that consent is not a condition of purchase. Required
         * when `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun messageFlow(): Optional<String> = messageFlow.getOptional("message_flow")

        /**
         * Opt-in keywords. TCR optinKeywords, comma separated, e.g. START,YES. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optInKeywords(): Optional<String> = optInKeywords.getOptional("opt_in_keywords")

        /**
         * Opt-in confirmation. TCR optinMessage. Should state message frequency and that rates may
         * apply. Its presence is what sets subscriberOptin. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optInMessage(): Optional<String> = optInMessage.getOptional("opt_in_message")

        /**
         * Opt-out keywords. TCR optoutKeywords, comma separated. STOP, END, CANCEL, UNSUBSCRIBE and
         * QUIT are honoured regardless of what is declared. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optOutKeywords(): Optional<String> = optOutKeywords.getOptional("opt_out_keywords")

        /**
         * Opt-out confirmation. TCR optoutMessage. Its presence is what sets subscriberOptout.
         * Required when `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optOutMessage(): Optional<String> = optOutMessage.getOptional("opt_out_message")

        /**
         * Privacy policy URL. TCR privacyPolicyLink. Required when `compliance.campaign.inherit !=
         * true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun privacyPolicyLink(): Optional<String> =
            privacyPolicyLink.getOptional("privacy_policy_link")

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Terms and conditions URL. TCR termsAndConditionsLink. Required when
         * `compliance.campaign.inherit != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun termsAndConditionsLink(): Optional<String> =
            termsAndConditionsLink.getOptional("terms_and_conditions_link")

        /**
         * Use cases. What the campaign sends, and an example of each. One to five entries; how they
         * register is decided by volume, never declared. Required when `compliance.campaign.inherit
         * != true`.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun useCases(): Optional<List<UseCase>> = useCases.getOptional("use_cases")

        /**
         * Expected monthly volume. Decides how the campaign registers and which fee tier applies:
         * below the low-volume threshold it registers as LOW_VOLUME with sub-use-cases, above it as
         * a single use case or MIXED. Omitting it registers the campaign at the higher-fee standard
         * tier.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun volume(): Optional<String> = volume.getOptional("volume")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [helpKeywords].
         *
         * Unlike [helpKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("help_keywords")
        @ExcludeMissing
        fun _helpKeywords(): JsonField<String> = helpKeywords

        /**
         * Returns the raw JSON value of [helpMessage].
         *
         * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("help_message")
        @ExcludeMissing
        fun _helpMessage(): JsonField<String> = helpMessage

        /**
         * Returns the raw JSON value of [messageFlow].
         *
         * Unlike [messageFlow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message_flow")
        @ExcludeMissing
        fun _messageFlow(): JsonField<String> = messageFlow

        /**
         * Returns the raw JSON value of [optInKeywords].
         *
         * Unlike [optInKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_in_keywords")
        @ExcludeMissing
        fun _optInKeywords(): JsonField<String> = optInKeywords

        /**
         * Returns the raw JSON value of [optInMessage].
         *
         * Unlike [optInMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_in_message")
        @ExcludeMissing
        fun _optInMessage(): JsonField<String> = optInMessage

        /**
         * Returns the raw JSON value of [optOutKeywords].
         *
         * Unlike [optOutKeywords], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_out_keywords")
        @ExcludeMissing
        fun _optOutKeywords(): JsonField<String> = optOutKeywords

        /**
         * Returns the raw JSON value of [optOutMessage].
         *
         * Unlike [optOutMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("opt_out_message")
        @ExcludeMissing
        fun _optOutMessage(): JsonField<String> = optOutMessage

        /**
         * Returns the raw JSON value of [privacyPolicyLink].
         *
         * Unlike [privacyPolicyLink], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("privacy_policy_link")
        @ExcludeMissing
        fun _privacyPolicyLink(): JsonField<String> = privacyPolicyLink

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [termsAndConditionsLink].
         *
         * Unlike [termsAndConditionsLink], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("terms_and_conditions_link")
        @ExcludeMissing
        fun _termsAndConditionsLink(): JsonField<String> = termsAndConditionsLink

        /**
         * Returns the raw JSON value of [useCases].
         *
         * Unlike [useCases], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("use_cases")
        @ExcludeMissing
        fun _useCases(): JsonField<List<UseCase>> = useCases

        /**
         * Returns the raw JSON value of [volume].
         *
         * Unlike [volume], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("volume") @ExcludeMissing fun _volume(): JsonField<String> = volume

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

            private var description: JsonField<String> = JsonMissing.of()
            private var helpKeywords: JsonField<String> = JsonMissing.of()
            private var helpMessage: JsonField<String> = JsonMissing.of()
            private var messageFlow: JsonField<String> = JsonMissing.of()
            private var optInKeywords: JsonField<String> = JsonMissing.of()
            private var optInMessage: JsonField<String> = JsonMissing.of()
            private var optOutKeywords: JsonField<String> = JsonMissing.of()
            private var optOutMessage: JsonField<String> = JsonMissing.of()
            private var privacyPolicyLink: JsonField<String> = JsonMissing.of()
            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var termsAndConditionsLink: JsonField<String> = JsonMissing.of()
            private var useCases: JsonField<MutableList<UseCase>>? = null
            private var volume: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                description = body.description
                helpKeywords = body.helpKeywords
                helpMessage = body.helpMessage
                messageFlow = body.messageFlow
                optInKeywords = body.optInKeywords
                optInMessage = body.optInMessage
                optOutKeywords = body.optOutKeywords
                optOutMessage = body.optOutMessage
                privacyPolicyLink = body.privacyPolicyLink
                sandbox = body.sandbox
                termsAndConditionsLink = body.termsAndConditionsLink
                useCases = body.useCases.map { it.toMutableList() }
                volume = body.volume
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * What this programme sends. TCR description: what recipients will get and why, in a
             * sentence. The only one of these TCR takes verbatim as a description of the programme,
             * which is why it is asked for rather than derived from the customer's name. Required
             * when `compliance.campaign.inherit != true`.
             */
            fun description(description: String) = description(JsonField.of(description))

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

            /**
             * Help keywords. TCR helpKeywords, comma separated, e.g. HELP,INFO. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun helpKeywords(helpKeywords: String) = helpKeywords(JsonField.of(helpKeywords))

            /**
             * Sets [Builder.helpKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpKeywords(helpKeywords: JsonField<String>) = apply {
                this.helpKeywords = helpKeywords
            }

            /**
             * Help reply. TCR helpMessage. Its presence is what sets subscriberHelp. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun helpMessage(helpMessage: String) = helpMessage(JsonField.of(helpMessage))

            /**
             * Sets [Builder.helpMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.helpMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun helpMessage(helpMessage: JsonField<String>) = apply {
                this.helpMessage = helpMessage
            }

            /**
             * Consent narrative. TCR messageFlow: how recipients opt in, in prose. Under 40
             * characters is refused, and carriers reject vague descriptions — say where opt-in
             * happens, that the box is unchecked by default, and that consent is not a condition of
             * purchase. Required when `compliance.campaign.inherit != true`.
             */
            fun messageFlow(messageFlow: String) = messageFlow(JsonField.of(messageFlow))

            /**
             * Sets [Builder.messageFlow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageFlow] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageFlow(messageFlow: JsonField<String>) = apply {
                this.messageFlow = messageFlow
            }

            /**
             * Opt-in keywords. TCR optinKeywords, comma separated, e.g. START,YES. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun optInKeywords(optInKeywords: String) = optInKeywords(JsonField.of(optInKeywords))

            /**
             * Sets [Builder.optInKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optInKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optInKeywords(optInKeywords: JsonField<String>) = apply {
                this.optInKeywords = optInKeywords
            }

            /**
             * Opt-in confirmation. TCR optinMessage. Should state message frequency and that rates
             * may apply. Its presence is what sets subscriberOptin. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun optInMessage(optInMessage: String) = optInMessage(JsonField.of(optInMessage))

            /**
             * Sets [Builder.optInMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optInMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optInMessage(optInMessage: JsonField<String>) = apply {
                this.optInMessage = optInMessage
            }

            /**
             * Opt-out keywords. TCR optoutKeywords, comma separated. STOP, END, CANCEL, UNSUBSCRIBE
             * and QUIT are honoured regardless of what is declared. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun optOutKeywords(optOutKeywords: String) =
                optOutKeywords(JsonField.of(optOutKeywords))

            /**
             * Sets [Builder.optOutKeywords] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optOutKeywords] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optOutKeywords(optOutKeywords: JsonField<String>) = apply {
                this.optOutKeywords = optOutKeywords
            }

            /**
             * Opt-out confirmation. TCR optoutMessage. Its presence is what sets subscriberOptout.
             * Required when `compliance.campaign.inherit != true`.
             */
            fun optOutMessage(optOutMessage: String) = optOutMessage(JsonField.of(optOutMessage))

            /**
             * Sets [Builder.optOutMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optOutMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optOutMessage(optOutMessage: JsonField<String>) = apply {
                this.optOutMessage = optOutMessage
            }

            /**
             * Privacy policy URL. TCR privacyPolicyLink. Required when `compliance.campaign.inherit
             * != true`.
             */
            fun privacyPolicyLink(privacyPolicyLink: String) =
                privacyPolicyLink(JsonField.of(privacyPolicyLink))

            /**
             * Sets [Builder.privacyPolicyLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.privacyPolicyLink] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun privacyPolicyLink(privacyPolicyLink: JsonField<String>) = apply {
                this.privacyPolicyLink = privacyPolicyLink
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
             * Terms and conditions URL. TCR termsAndConditionsLink. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: String) =
                termsAndConditionsLink(JsonField.of(termsAndConditionsLink))

            /**
             * Sets [Builder.termsAndConditionsLink] to an arbitrary JSON value.
             *
             * You should usually call [Builder.termsAndConditionsLink] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun termsAndConditionsLink(termsAndConditionsLink: JsonField<String>) = apply {
                this.termsAndConditionsLink = termsAndConditionsLink
            }

            /**
             * Use cases. What the campaign sends, and an example of each. One to five entries; how
             * they register is decided by volume, never declared. Required when
             * `compliance.campaign.inherit != true`.
             */
            fun useCases(useCases: List<UseCase>) = useCases(JsonField.of(useCases))

            /**
             * Sets [Builder.useCases] to an arbitrary JSON value.
             *
             * You should usually call [Builder.useCases] with a well-typed `List<UseCase>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun useCases(useCases: JsonField<List<UseCase>>) = apply {
                this.useCases = useCases.map { it.toMutableList() }
            }

            /**
             * Adds a single [UseCase] to [useCases].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addUseCase(useCase: UseCase) = apply {
                useCases =
                    (useCases ?: JsonField.of(mutableListOf())).also {
                        checkKnown("useCases", it).add(useCase)
                    }
            }

            /**
             * Expected monthly volume. Decides how the campaign registers and which fee tier
             * applies: below the low-volume threshold it registers as LOW_VOLUME with
             * sub-use-cases, above it as a single use case or MIXED. Omitting it registers the
             * campaign at the higher-fee standard tier.
             */
            fun volume(volume: String) = volume(JsonField.of(volume))

            /**
             * Sets [Builder.volume] to an arbitrary JSON value.
             *
             * You should usually call [Builder.volume] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun volume(volume: JsonField<String>) = apply { this.volume = volume }

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
                    description,
                    helpKeywords,
                    helpMessage,
                    messageFlow,
                    optInKeywords,
                    optInMessage,
                    optOutKeywords,
                    optOutMessage,
                    privacyPolicyLink,
                    sandbox,
                    termsAndConditionsLink,
                    (useCases ?: JsonMissing.of()).map { it.toImmutable() },
                    volume,
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

            description()
            helpKeywords()
            helpMessage()
            messageFlow()
            optInKeywords()
            optInMessage()
            optOutKeywords()
            optOutMessage()
            privacyPolicyLink()
            sandbox()
            termsAndConditionsLink()
            useCases().ifPresent { it.forEach { it.validate() } }
            volume()
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (helpKeywords.asKnown().isPresent) 1 else 0) +
                (if (helpMessage.asKnown().isPresent) 1 else 0) +
                (if (messageFlow.asKnown().isPresent) 1 else 0) +
                (if (optInKeywords.asKnown().isPresent) 1 else 0) +
                (if (optInMessage.asKnown().isPresent) 1 else 0) +
                (if (optOutKeywords.asKnown().isPresent) 1 else 0) +
                (if (optOutMessage.asKnown().isPresent) 1 else 0) +
                (if (privacyPolicyLink.asKnown().isPresent) 1 else 0) +
                (if (sandbox.asKnown().isPresent) 1 else 0) +
                (if (termsAndConditionsLink.asKnown().isPresent) 1 else 0) +
                (useCases.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (volume.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                description == other.description &&
                helpKeywords == other.helpKeywords &&
                helpMessage == other.helpMessage &&
                messageFlow == other.messageFlow &&
                optInKeywords == other.optInKeywords &&
                optInMessage == other.optInMessage &&
                optOutKeywords == other.optOutKeywords &&
                optOutMessage == other.optOutMessage &&
                privacyPolicyLink == other.privacyPolicyLink &&
                sandbox == other.sandbox &&
                termsAndConditionsLink == other.termsAndConditionsLink &&
                useCases == other.useCases &&
                volume == other.volume &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                description,
                helpKeywords,
                helpMessage,
                messageFlow,
                optInKeywords,
                optInMessage,
                optOutKeywords,
                optOutMessage,
                privacyPolicyLink,
                sandbox,
                termsAndConditionsLink,
                useCases,
                volume,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{description=$description, helpKeywords=$helpKeywords, helpMessage=$helpMessage, messageFlow=$messageFlow, optInKeywords=$optInKeywords, optInMessage=$optInMessage, optOutKeywords=$optOutKeywords, optOutMessage=$optOutMessage, privacyPolicyLink=$privacyPolicyLink, sandbox=$sandbox, termsAndConditionsLink=$termsAndConditionsLink, useCases=$useCases, volume=$volume, additionalProperties=$additionalProperties}"
    }

    class UseCase
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sampleMessages: JsonField<List<JsonValue>>,
        private val useCase: JsonField<InnerUseCase>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sample_messages")
            @ExcludeMissing
            sampleMessages: JsonField<List<JsonValue>> = JsonMissing.of(),
            @JsonProperty("use_case")
            @ExcludeMissing
            useCase: JsonField<InnerUseCase> = JsonMissing.of(),
        ) : this(sampleMessages, useCase, mutableMapOf())

        /**
         * Sample messages. TCR sample1..sample5 for this use case. One to five, each carrying the
         * brand name and an opt-out instruction.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sampleMessages(): List<JsonValue> = sampleMessages.getRequired("sample_messages")

        /**
         * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides those.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun useCase(): InnerUseCase = useCase.getRequired("use_case")

        /**
         * Returns the raw JSON value of [sampleMessages].
         *
         * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sample_messages")
        @ExcludeMissing
        fun _sampleMessages(): JsonField<List<JsonValue>> = sampleMessages

        /**
         * Returns the raw JSON value of [useCase].
         *
         * Unlike [useCase], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("use_case") @ExcludeMissing fun _useCase(): JsonField<InnerUseCase> = useCase

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
             * Returns a mutable builder for constructing an instance of [UseCase].
             *
             * The following fields are required:
             * ```java
             * .sampleMessages()
             * .useCase()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [UseCase]. */
        class Builder internal constructor() {

            private var sampleMessages: JsonField<MutableList<JsonValue>>? = null
            private var useCase: JsonField<InnerUseCase>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(useCase: UseCase) = apply {
                sampleMessages = useCase.sampleMessages.map { it.toMutableList() }
                this.useCase = useCase.useCase
                additionalProperties = useCase.additionalProperties.toMutableMap()
            }

            /**
             * Sample messages. TCR sample1..sample5 for this use case. One to five, each carrying
             * the brand name and an opt-out instruction.
             */
            fun sampleMessages(sampleMessages: List<JsonValue>) =
                sampleMessages(JsonField.of(sampleMessages))

            /**
             * Sets [Builder.sampleMessages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sampleMessages] with a well-typed `List<JsonValue>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun sampleMessages(sampleMessages: JsonField<List<JsonValue>>) = apply {
                this.sampleMessages = sampleMessages.map { it.toMutableList() }
            }

            /**
             * Adds a single [JsonValue] to [sampleMessages].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSampleMessage(sampleMessage: JsonValue) = apply {
                sampleMessages =
                    (sampleMessages ?: JsonField.of(mutableListOf())).also {
                        checkKnown("sampleMessages", it).add(sampleMessage)
                    }
            }

            /**
             * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides
             * those.
             */
            fun useCase(useCase: InnerUseCase) = useCase(JsonField.of(useCase))

            /**
             * Sets [Builder.useCase] to an arbitrary JSON value.
             *
             * You should usually call [Builder.useCase] with a well-typed [InnerUseCase] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun useCase(useCase: JsonField<InnerUseCase>) = apply { this.useCase = useCase }

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
             * Returns an immutable instance of [UseCase].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .sampleMessages()
             * .useCase()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UseCase =
                UseCase(
                    checkRequired("sampleMessages", sampleMessages).map { it.toImmutable() },
                    checkRequired("useCase", useCase),
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
        fun validate(): UseCase = apply {
            if (validated) {
                return@apply
            }

            sampleMessages()
            useCase().validate()
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
            (sampleMessages.asKnown().getOrNull()?.size ?: 0) +
                (useCase.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides those.
         */
        class InnerUseCase @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val MARKETING = of("MARKETING")

                @JvmField val ACCOUNT_NOTIFICATION = of("ACCOUNT_NOTIFICATION")

                @JvmField val CUSTOMER_CARE = of("CUSTOMER_CARE")

                @JvmField val FRAUD_ALERT = of("FRAUD_ALERT")

                @JvmField val _2_FA = of("2FA")

                @JvmField val DELIVERY_NOTIFICATION = of("DELIVERY_NOTIFICATION")

                @JvmField val SECURITY_ALERT = of("SECURITY_ALERT")

                @JvmField val M2_M = of("M2M")

                @JvmField val HIGHER_EDUCATION = of("HIGHER_EDUCATION")

                @JvmField val POLLING_VOTING = of("POLLING_VOTING")

                @JvmField val PUBLIC_SERVICE_ANNOUNCEMENT = of("PUBLIC_SERVICE_ANNOUNCEMENT")

                @JvmStatic fun of(value: String) = InnerUseCase(JsonField.of(value))
            }

            /** An enum containing [InnerUseCase]'s known values. */
            enum class Known {
                MARKETING,
                ACCOUNT_NOTIFICATION,
                CUSTOMER_CARE,
                FRAUD_ALERT,
                _2_FA,
                DELIVERY_NOTIFICATION,
                SECURITY_ALERT,
                M2_M,
                HIGHER_EDUCATION,
                POLLING_VOTING,
                PUBLIC_SERVICE_ANNOUNCEMENT,
            }

            /**
             * An enum containing [InnerUseCase]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [InnerUseCase] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                MARKETING,
                ACCOUNT_NOTIFICATION,
                CUSTOMER_CARE,
                FRAUD_ALERT,
                _2_FA,
                DELIVERY_NOTIFICATION,
                SECURITY_ALERT,
                M2_M,
                HIGHER_EDUCATION,
                POLLING_VOTING,
                PUBLIC_SERVICE_ANNOUNCEMENT,
                /**
                 * An enum member indicating that [InnerUseCase] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    MARKETING -> Value.MARKETING
                    ACCOUNT_NOTIFICATION -> Value.ACCOUNT_NOTIFICATION
                    CUSTOMER_CARE -> Value.CUSTOMER_CARE
                    FRAUD_ALERT -> Value.FRAUD_ALERT
                    _2_FA -> Value._2_FA
                    DELIVERY_NOTIFICATION -> Value.DELIVERY_NOTIFICATION
                    SECURITY_ALERT -> Value.SECURITY_ALERT
                    M2_M -> Value.M2_M
                    HIGHER_EDUCATION -> Value.HIGHER_EDUCATION
                    POLLING_VOTING -> Value.POLLING_VOTING
                    PUBLIC_SERVICE_ANNOUNCEMENT -> Value.PUBLIC_SERVICE_ANNOUNCEMENT
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SentInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    MARKETING -> Known.MARKETING
                    ACCOUNT_NOTIFICATION -> Known.ACCOUNT_NOTIFICATION
                    CUSTOMER_CARE -> Known.CUSTOMER_CARE
                    FRAUD_ALERT -> Known.FRAUD_ALERT
                    _2_FA -> Known._2_FA
                    DELIVERY_NOTIFICATION -> Known.DELIVERY_NOTIFICATION
                    SECURITY_ALERT -> Known.SECURITY_ALERT
                    M2_M -> Known.M2_M
                    HIGHER_EDUCATION -> Known.HIGHER_EDUCATION
                    POLLING_VOTING -> Known.POLLING_VOTING
                    PUBLIC_SERVICE_ANNOUNCEMENT -> Known.PUBLIC_SERVICE_ANNOUNCEMENT
                    else -> throw SentInvalidDataException("Unknown InnerUseCase: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentInvalidDataException("Value is not a String")
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
            fun validate(): InnerUseCase = apply {
                if (validated) {
                    return@apply
                }

                known()
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
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is InnerUseCase && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UseCase &&
                sampleMessages == other.sampleMessages &&
                useCase == other.useCase &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sampleMessages, useCase, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UseCase{sampleMessages=$sampleMessages, useCase=$useCase, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TenDlcUpdateCampaignParams &&
            campaignId == other.campaignId &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            campaignId,
            idempotencyKey,
            xProfileId,
            body,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "TenDlcUpdateCampaignParams{campaignId=$campaignId, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
