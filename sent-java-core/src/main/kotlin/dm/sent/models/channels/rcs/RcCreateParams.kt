// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.rcs

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
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Asks for an RCS agent and records the order form the carriers vet it against. Always `202`: an
 * agent is approved by the carriers, not by this call, and nothing here can make that happen
 * sooner.
 *
 * ## What it asks for
 *
 * The RCS Agent Order Form — the same one our team fills in on your behalf today, so nothing has to
 * be collected from you twice. **All fields are required** and must be submitted together so the
 * carrier review has everything it needs. The only exception is `opt_in_screenshot_url`.
 *
 * **Agent identity:** `display_name`, `description`, `agent_use_case` (must be one of the accepted
 * use cases; the error names the set), `brand_color` (six-digit hex, `#RRGGBB`).
 *
 * **Brand identity:** `brand_name` — the brand this agent presents. Not taken from
 * `compliance.brand`: a business may present a different brand on RCS than the one its 10DLC
 * registration is filed against, and the carriers vet this one. `privacy_policy_url`,
 * `terms_and_conditions_url`, `website_url`, `logo_url`, and `banner_url` must be absolute
 * `http(s)` URLs that the carriers can fetch without authentication. The form specifies 224×224 px
 * and 50 KB for the logo and 1440×448 px and 200 KB for the banner; these cannot be checked without
 * the image bytes.
 *
 * **Contact details:** `brand_phone_number`, `customer_support_phone_number`, `brand_email`,
 * `customer_support_email`, `contact_name_and_title`.
 *
 * **Company:** `company_ein`, `entity_type`, `official_address` (street, city, state, postal_code,
 * country), `brief_company_description`.
 *
 * **Consent and messages:** `opt_in_process_description`, `start_message`, `help_message`,
 * `stop_message`, `sample_messages` (at least one example message).
 *
 * **Optional:** `opt_in_screenshot_url` (validated as an http(s) URL if supplied).
 *
 * Anything supplied is checked against accepted values rather than passed through: a value the
 * provider rejects would otherwise surface days later, to somebody who cannot fix it without asking
 * you.
 *
 * **A customer has one agent.** Asking again while you have one is `409`.
 *
 * ## What comes back, and what does not
 *
 * Returns **the agent** — the form as stored, plus `id` and `status`. Not your other channels,
 * which this call cannot have changed.
 *
 * `status` is `PROVISIONING` until the agent is handed to the carriers and approved. **`GET
 * /v3/channels` reports `rcs: null` until then** — a channel row is what routing reads to decide
 * you are sendable, and writing one for an unapproved agent would claim a channel that cannot carry
 * traffic.
 *
 * Send `x-profile-id` with an organization key to ask for one of your profiles' agents.
 */
class RcCreateParams
private constructor(
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Which kind of traffic the agent carries. One of the accepted use cases; the error names the
     * set.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentUseCase(): Optional<AgentUseCase> = body.agentUseCase()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun bannerUrl(): Optional<String> = body.bannerUrl()

    /**
     * Primary brand colour, as #RRGGBB. Three-digit shorthand is refused: the value is submitted
     * verbatim, so two spellings of one colour is only a way for the stored value to disagree with
     * the form.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandColor(): Optional<String> = body.brandColor()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandEmail(): Optional<String> = body.brandEmail()

    /**
     * The brand this agent presents over RCS.
     *
     * Not taken from your compliance.brand: a business may present a different brand on RCS than
     * the one its 10DLC registration is filed against, and the carriers vet this one.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandName(): Optional<String> = body.brandName()

    /**
     * The brand's own number. Also becomes the agent's canonical sending number for routing, which
     * is why it is normalised to E.164 rather than stored as sent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandPhoneNumber(): Optional<String> = body.brandPhoneNumber()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun briefCompanyDescription(): Optional<String> = body.briefCompanyDescription()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun companyEin(): Optional<String> = body.companyEin()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactNameAndTitle(): Optional<String> = body.contactNameAndTitle()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerSupportEmail(): Optional<String> = body.customerSupportEmail()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerSupportPhoneNumber(): Optional<String> = body.customerSupportPhoneNumber()

    /**
     * What the agent is for, shown to recipients. Capped by the carriers, not by us.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * The name the agent shows in the messaging client.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun displayName(): Optional<String> = body.displayName()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun entityType(): Optional<String> = body.entityType()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun helpMessage(): Optional<String> = body.helpMessage()

    /**
     * Publicly reachable logo. It has to be fetchable without authentication at review time, so a
     * URL behind a login passes this call and fails the review.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun logoUrl(): Optional<String> = body.logoUrl()

    /**
     * The registered address of the company behind the agent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun officialAddress(): Optional<RcsAddress> = body.officialAddress()

    /**
     * How recipients opt in, in prose. The carriers read this one.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optInProcessDescription(): Optional<String> = body.optInProcessDescription()

    /**
     * A screenshot of the opt-in, as a publicly fetchable URL.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optInScreenshotUrl(): Optional<String> = body.optInScreenshotUrl()

    /**
     * Required by US carriers. Must be an absolute http(s) URL they can fetch.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun privacyPolicyUrl(): Optional<String> = body.privacyPolicyUrl()

    /**
     * Examples of what the agent will send, for the review.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sampleMessages(): Optional<List<String>> = body.sampleMessages()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun startMessage(): Optional<String> = body.startMessage()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun stopMessage(): Optional<String> = body.stopMessage()

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun termsAndConditionsUrl(): Optional<String> = body.termsAndConditionsUrl()

    /**
     * The brand's own site.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun websiteUrl(): Optional<String> = body.websiteUrl()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [agentUseCase].
     *
     * Unlike [agentUseCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agentUseCase(): JsonField<AgentUseCase> = body._agentUseCase()

    /**
     * Returns the raw JSON value of [bannerUrl].
     *
     * Unlike [bannerUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bannerUrl(): JsonField<String> = body._bannerUrl()

    /**
     * Returns the raw JSON value of [brandColor].
     *
     * Unlike [brandColor], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _brandColor(): JsonField<String> = body._brandColor()

    /**
     * Returns the raw JSON value of [brandEmail].
     *
     * Unlike [brandEmail], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _brandEmail(): JsonField<String> = body._brandEmail()

    /**
     * Returns the raw JSON value of [brandName].
     *
     * Unlike [brandName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _brandName(): JsonField<String> = body._brandName()

    /**
     * Returns the raw JSON value of [brandPhoneNumber].
     *
     * Unlike [brandPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _brandPhoneNumber(): JsonField<String> = body._brandPhoneNumber()

    /**
     * Returns the raw JSON value of [briefCompanyDescription].
     *
     * Unlike [briefCompanyDescription], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _briefCompanyDescription(): JsonField<String> = body._briefCompanyDescription()

    /**
     * Returns the raw JSON value of [companyEin].
     *
     * Unlike [companyEin], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _companyEin(): JsonField<String> = body._companyEin()

    /**
     * Returns the raw JSON value of [contactNameAndTitle].
     *
     * Unlike [contactNameAndTitle], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _contactNameAndTitle(): JsonField<String> = body._contactNameAndTitle()

    /**
     * Returns the raw JSON value of [customerSupportEmail].
     *
     * Unlike [customerSupportEmail], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _customerSupportEmail(): JsonField<String> = body._customerSupportEmail()

    /**
     * Returns the raw JSON value of [customerSupportPhoneNumber].
     *
     * Unlike [customerSupportPhoneNumber], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _customerSupportPhoneNumber(): JsonField<String> = body._customerSupportPhoneNumber()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [displayName].
     *
     * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _displayName(): JsonField<String> = body._displayName()

    /**
     * Returns the raw JSON value of [entityType].
     *
     * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _entityType(): JsonField<String> = body._entityType()

    /**
     * Returns the raw JSON value of [helpMessage].
     *
     * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _helpMessage(): JsonField<String> = body._helpMessage()

    /**
     * Returns the raw JSON value of [logoUrl].
     *
     * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _logoUrl(): JsonField<String> = body._logoUrl()

    /**
     * Returns the raw JSON value of [officialAddress].
     *
     * Unlike [officialAddress], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _officialAddress(): JsonField<RcsAddress> = body._officialAddress()

    /**
     * Returns the raw JSON value of [optInProcessDescription].
     *
     * Unlike [optInProcessDescription], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _optInProcessDescription(): JsonField<String> = body._optInProcessDescription()

    /**
     * Returns the raw JSON value of [optInScreenshotUrl].
     *
     * Unlike [optInScreenshotUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _optInScreenshotUrl(): JsonField<String> = body._optInScreenshotUrl()

    /**
     * Returns the raw JSON value of [privacyPolicyUrl].
     *
     * Unlike [privacyPolicyUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _privacyPolicyUrl(): JsonField<String> = body._privacyPolicyUrl()

    /**
     * Returns the raw JSON value of [sampleMessages].
     *
     * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sampleMessages(): JsonField<List<String>> = body._sampleMessages()

    /**
     * Returns the raw JSON value of [startMessage].
     *
     * Unlike [startMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _startMessage(): JsonField<String> = body._startMessage()

    /**
     * Returns the raw JSON value of [stopMessage].
     *
     * Unlike [stopMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _stopMessage(): JsonField<String> = body._stopMessage()

    /**
     * Returns the raw JSON value of [termsAndConditionsUrl].
     *
     * Unlike [termsAndConditionsUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _termsAndConditionsUrl(): JsonField<String> = body._termsAndConditionsUrl()

    /**
     * Returns the raw JSON value of [websiteUrl].
     *
     * Unlike [websiteUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _websiteUrl(): JsonField<String> = body._websiteUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): RcCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [RcCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RcCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(rcCreateParams: RcCreateParams) = apply {
            idempotencyKey = rcCreateParams.idempotencyKey
            xProfileId = rcCreateParams.xProfileId
            body = rcCreateParams.body.toBuilder()
            additionalHeaders = rcCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = rcCreateParams.additionalQueryParams.toBuilder()
        }

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
         * - [sandbox]
         * - [agentUseCase]
         * - [bannerUrl]
         * - [brandColor]
         * - [brandEmail]
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
         * Which kind of traffic the agent carries. One of the accepted use cases; the error names
         * the set.
         */
        fun agentUseCase(agentUseCase: AgentUseCase) = apply { body.agentUseCase(agentUseCase) }

        /**
         * Sets [Builder.agentUseCase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentUseCase] with a well-typed [AgentUseCase] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun agentUseCase(agentUseCase: JsonField<AgentUseCase>) = apply {
            body.agentUseCase(agentUseCase)
        }

        fun bannerUrl(bannerUrl: String) = apply { body.bannerUrl(bannerUrl) }

        /**
         * Sets [Builder.bannerUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bannerUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bannerUrl(bannerUrl: JsonField<String>) = apply { body.bannerUrl(bannerUrl) }

        /**
         * Primary brand colour, as #RRGGBB. Three-digit shorthand is refused: the value is
         * submitted verbatim, so two spellings of one colour is only a way for the stored value to
         * disagree with the form.
         */
        fun brandColor(brandColor: String) = apply { body.brandColor(brandColor) }

        /**
         * Sets [Builder.brandColor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandColor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandColor(brandColor: JsonField<String>) = apply { body.brandColor(brandColor) }

        fun brandEmail(brandEmail: String) = apply { body.brandEmail(brandEmail) }

        /**
         * Sets [Builder.brandEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandEmail] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandEmail(brandEmail: JsonField<String>) = apply { body.brandEmail(brandEmail) }

        /**
         * The brand this agent presents over RCS.
         *
         * Not taken from your compliance.brand: a business may present a different brand on RCS
         * than the one its 10DLC registration is filed against, and the carriers vet this one.
         */
        fun brandName(brandName: String) = apply { body.brandName(brandName) }

        /**
         * Sets [Builder.brandName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandName(brandName: JsonField<String>) = apply { body.brandName(brandName) }

        /**
         * The brand's own number. Also becomes the agent's canonical sending number for routing,
         * which is why it is normalised to E.164 rather than stored as sent.
         */
        fun brandPhoneNumber(brandPhoneNumber: String) = apply {
            body.brandPhoneNumber(brandPhoneNumber)
        }

        /**
         * Sets [Builder.brandPhoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandPhoneNumber] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun brandPhoneNumber(brandPhoneNumber: JsonField<String>) = apply {
            body.brandPhoneNumber(brandPhoneNumber)
        }

        fun briefCompanyDescription(briefCompanyDescription: String) = apply {
            body.briefCompanyDescription(briefCompanyDescription)
        }

        /**
         * Sets [Builder.briefCompanyDescription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.briefCompanyDescription] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun briefCompanyDescription(briefCompanyDescription: JsonField<String>) = apply {
            body.briefCompanyDescription(briefCompanyDescription)
        }

        fun companyEin(companyEin: String) = apply { body.companyEin(companyEin) }

        /**
         * Sets [Builder.companyEin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.companyEin] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun companyEin(companyEin: JsonField<String>) = apply { body.companyEin(companyEin) }

        fun contactNameAndTitle(contactNameAndTitle: String) = apply {
            body.contactNameAndTitle(contactNameAndTitle)
        }

        /**
         * Sets [Builder.contactNameAndTitle] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactNameAndTitle] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contactNameAndTitle(contactNameAndTitle: JsonField<String>) = apply {
            body.contactNameAndTitle(contactNameAndTitle)
        }

        fun customerSupportEmail(customerSupportEmail: String) = apply {
            body.customerSupportEmail(customerSupportEmail)
        }

        /**
         * Sets [Builder.customerSupportEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerSupportEmail] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customerSupportEmail(customerSupportEmail: JsonField<String>) = apply {
            body.customerSupportEmail(customerSupportEmail)
        }

        fun customerSupportPhoneNumber(customerSupportPhoneNumber: String) = apply {
            body.customerSupportPhoneNumber(customerSupportPhoneNumber)
        }

        /**
         * Sets [Builder.customerSupportPhoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerSupportPhoneNumber] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun customerSupportPhoneNumber(customerSupportPhoneNumber: JsonField<String>) = apply {
            body.customerSupportPhoneNumber(customerSupportPhoneNumber)
        }

        /** What the agent is for, shown to recipients. Capped by the carriers, not by us. */
        fun description(description: String) = apply { body.description(description) }

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { body.description(description) }

        /** The name the agent shows in the messaging client. */
        fun displayName(displayName: String) = apply { body.displayName(displayName) }

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { body.displayName(displayName) }

        fun entityType(entityType: String) = apply { body.entityType(entityType) }

        /**
         * Sets [Builder.entityType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entityType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun entityType(entityType: JsonField<String>) = apply { body.entityType(entityType) }

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
         * Publicly reachable logo. It has to be fetchable without authentication at review time, so
         * a URL behind a login passes this call and fails the review.
         */
        fun logoUrl(logoUrl: String) = apply { body.logoUrl(logoUrl) }

        /**
         * Sets [Builder.logoUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logoUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logoUrl(logoUrl: JsonField<String>) = apply { body.logoUrl(logoUrl) }

        /** The registered address of the company behind the agent. */
        fun officialAddress(officialAddress: RcsAddress) = apply {
            body.officialAddress(officialAddress)
        }

        /**
         * Sets [Builder.officialAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.officialAddress] with a well-typed [RcsAddress] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun officialAddress(officialAddress: JsonField<RcsAddress>) = apply {
            body.officialAddress(officialAddress)
        }

        /** How recipients opt in, in prose. The carriers read this one. */
        fun optInProcessDescription(optInProcessDescription: String) = apply {
            body.optInProcessDescription(optInProcessDescription)
        }

        /**
         * Sets [Builder.optInProcessDescription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optInProcessDescription] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun optInProcessDescription(optInProcessDescription: JsonField<String>) = apply {
            body.optInProcessDescription(optInProcessDescription)
        }

        /** A screenshot of the opt-in, as a publicly fetchable URL. */
        fun optInScreenshotUrl(optInScreenshotUrl: String?) = apply {
            body.optInScreenshotUrl(optInScreenshotUrl)
        }

        /**
         * Alias for calling [Builder.optInScreenshotUrl] with `optInScreenshotUrl.orElse(null)`.
         */
        fun optInScreenshotUrl(optInScreenshotUrl: Optional<String>) =
            optInScreenshotUrl(optInScreenshotUrl.getOrNull())

        /**
         * Sets [Builder.optInScreenshotUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optInScreenshotUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun optInScreenshotUrl(optInScreenshotUrl: JsonField<String>) = apply {
            body.optInScreenshotUrl(optInScreenshotUrl)
        }

        /** Required by US carriers. Must be an absolute http(s) URL they can fetch. */
        fun privacyPolicyUrl(privacyPolicyUrl: String) = apply {
            body.privacyPolicyUrl(privacyPolicyUrl)
        }

        /**
         * Sets [Builder.privacyPolicyUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.privacyPolicyUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun privacyPolicyUrl(privacyPolicyUrl: JsonField<String>) = apply {
            body.privacyPolicyUrl(privacyPolicyUrl)
        }

        /** Examples of what the agent will send, for the review. */
        fun sampleMessages(sampleMessages: List<String>) = apply {
            body.sampleMessages(sampleMessages)
        }

        /**
         * Sets [Builder.sampleMessages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sampleMessages] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sampleMessages(sampleMessages: JsonField<List<String>>) = apply {
            body.sampleMessages(sampleMessages)
        }

        /**
         * Adds a single [String] to [sampleMessages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSampleMessage(sampleMessage: String) = apply { body.addSampleMessage(sampleMessage) }

        fun startMessage(startMessage: String) = apply { body.startMessage(startMessage) }

        /**
         * Sets [Builder.startMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun startMessage(startMessage: JsonField<String>) = apply {
            body.startMessage(startMessage)
        }

        fun stopMessage(stopMessage: String) = apply { body.stopMessage(stopMessage) }

        /**
         * Sets [Builder.stopMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stopMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun stopMessage(stopMessage: JsonField<String>) = apply { body.stopMessage(stopMessage) }

        fun termsAndConditionsUrl(termsAndConditionsUrl: String) = apply {
            body.termsAndConditionsUrl(termsAndConditionsUrl)
        }

        /**
         * Sets [Builder.termsAndConditionsUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.termsAndConditionsUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun termsAndConditionsUrl(termsAndConditionsUrl: JsonField<String>) = apply {
            body.termsAndConditionsUrl(termsAndConditionsUrl)
        }

        /** The brand's own site. */
        fun websiteUrl(websiteUrl: String) = apply { body.websiteUrl(websiteUrl) }

        /**
         * Sets [Builder.websiteUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.websiteUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun websiteUrl(websiteUrl: JsonField<String>) = apply { body.websiteUrl(websiteUrl) }

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
         * Returns an immutable instance of [RcCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RcCreateParams =
            RcCreateParams(
                idempotencyKey,
                xProfileId,
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
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * The RCS Agent Order Form, as a customer sends it.
     *
     * The same form the admin side takes — POST /customers/{customerId}/rcs-senders and
     * CreateRcsSenderRequest — rather than a reduced one. It was three fields for a while, which
     * recorded a hosting region and a logo into a config blob and left everything a carrier
     * actually asks about to be collected by hand later. A customer can answer all of this; nobody
     * else can answer any of it.
     *
     * Named in this API's own casing. Every v3 body is snake_case, so the fields are mapped rather
     * than shared: logo_url, banner_url, brand_color.
     *
     * No customer_id. The internal form carries one because an admin names the customer it is
     * acting for; here the key does, and accepting one from the body would let a caller file an
     * agent against somebody else.
     *
     * All fields except opt_in_screenshot_url are required. The full order form must be submitted
     * in one go so the carrier review has everything it needs.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val agentUseCase: JsonField<AgentUseCase>,
        private val bannerUrl: JsonField<String>,
        private val brandColor: JsonField<String>,
        private val brandEmail: JsonField<String>,
        private val brandName: JsonField<String>,
        private val brandPhoneNumber: JsonField<String>,
        private val briefCompanyDescription: JsonField<String>,
        private val companyEin: JsonField<String>,
        private val contactNameAndTitle: JsonField<String>,
        private val customerSupportEmail: JsonField<String>,
        private val customerSupportPhoneNumber: JsonField<String>,
        private val description: JsonField<String>,
        private val displayName: JsonField<String>,
        private val entityType: JsonField<String>,
        private val helpMessage: JsonField<String>,
        private val logoUrl: JsonField<String>,
        private val officialAddress: JsonField<RcsAddress>,
        private val optInProcessDescription: JsonField<String>,
        private val optInScreenshotUrl: JsonField<String>,
        private val privacyPolicyUrl: JsonField<String>,
        private val sampleMessages: JsonField<List<String>>,
        private val startMessage: JsonField<String>,
        private val stopMessage: JsonField<String>,
        private val termsAndConditionsUrl: JsonField<String>,
        private val websiteUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("agent_use_case")
            @ExcludeMissing
            agentUseCase: JsonField<AgentUseCase> = JsonMissing.of(),
            @JsonProperty("banner_url")
            @ExcludeMissing
            bannerUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("brand_color")
            @ExcludeMissing
            brandColor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("brand_email")
            @ExcludeMissing
            brandEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("brand_name")
            @ExcludeMissing
            brandName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("brand_phone_number")
            @ExcludeMissing
            brandPhoneNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("brief_company_description")
            @ExcludeMissing
            briefCompanyDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("company_ein")
            @ExcludeMissing
            companyEin: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contact_name_and_title")
            @ExcludeMissing
            contactNameAndTitle: JsonField<String> = JsonMissing.of(),
            @JsonProperty("customer_support_email")
            @ExcludeMissing
            customerSupportEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("customer_support_phone_number")
            @ExcludeMissing
            customerSupportPhoneNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("display_name")
            @ExcludeMissing
            displayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("entity_type")
            @ExcludeMissing
            entityType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("help_message")
            @ExcludeMissing
            helpMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logo_url") @ExcludeMissing logoUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("official_address")
            @ExcludeMissing
            officialAddress: JsonField<RcsAddress> = JsonMissing.of(),
            @JsonProperty("opt_in_process_description")
            @ExcludeMissing
            optInProcessDescription: JsonField<String> = JsonMissing.of(),
            @JsonProperty("opt_in_screenshot_url")
            @ExcludeMissing
            optInScreenshotUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("privacy_policy_url")
            @ExcludeMissing
            privacyPolicyUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sample_messages")
            @ExcludeMissing
            sampleMessages: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("start_message")
            @ExcludeMissing
            startMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("stop_message")
            @ExcludeMissing
            stopMessage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("terms_and_conditions_url")
            @ExcludeMissing
            termsAndConditionsUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("website_url")
            @ExcludeMissing
            websiteUrl: JsonField<String> = JsonMissing.of(),
        ) : this(
            sandbox,
            agentUseCase,
            bannerUrl,
            brandColor,
            brandEmail,
            brandName,
            brandPhoneNumber,
            briefCompanyDescription,
            companyEin,
            contactNameAndTitle,
            customerSupportEmail,
            customerSupportPhoneNumber,
            description,
            displayName,
            entityType,
            helpMessage,
            logoUrl,
            officialAddress,
            optInProcessDescription,
            optInScreenshotUrl,
            privacyPolicyUrl,
            sampleMessages,
            startMessage,
            stopMessage,
            termsAndConditionsUrl,
            websiteUrl,
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
         * Which kind of traffic the agent carries. One of the accepted use cases; the error names
         * the set.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun agentUseCase(): Optional<AgentUseCase> = agentUseCase.getOptional("agent_use_case")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bannerUrl(): Optional<String> = bannerUrl.getOptional("banner_url")

        /**
         * Primary brand colour, as #RRGGBB. Three-digit shorthand is refused: the value is
         * submitted verbatim, so two spellings of one colour is only a way for the stored value to
         * disagree with the form.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brandColor(): Optional<String> = brandColor.getOptional("brand_color")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brandEmail(): Optional<String> = brandEmail.getOptional("brand_email")

        /**
         * The brand this agent presents over RCS.
         *
         * Not taken from your compliance.brand: a business may present a different brand on RCS
         * than the one its 10DLC registration is filed against, and the carriers vet this one.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brandName(): Optional<String> = brandName.getOptional("brand_name")

        /**
         * The brand's own number. Also becomes the agent's canonical sending number for routing,
         * which is why it is normalised to E.164 rather than stored as sent.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brandPhoneNumber(): Optional<String> =
            brandPhoneNumber.getOptional("brand_phone_number")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun briefCompanyDescription(): Optional<String> =
            briefCompanyDescription.getOptional("brief_company_description")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun companyEin(): Optional<String> = companyEin.getOptional("company_ein")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contactNameAndTitle(): Optional<String> =
            contactNameAndTitle.getOptional("contact_name_and_title")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun customerSupportEmail(): Optional<String> =
            customerSupportEmail.getOptional("customer_support_email")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun customerSupportPhoneNumber(): Optional<String> =
            customerSupportPhoneNumber.getOptional("customer_support_phone_number")

        /**
         * What the agent is for, shown to recipients. Capped by the carriers, not by us.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * The name the agent shows in the messaging client.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun displayName(): Optional<String> = displayName.getOptional("display_name")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun entityType(): Optional<String> = entityType.getOptional("entity_type")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun helpMessage(): Optional<String> = helpMessage.getOptional("help_message")

        /**
         * Publicly reachable logo. It has to be fetchable without authentication at review time, so
         * a URL behind a login passes this call and fails the review.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

        /**
         * The registered address of the company behind the agent.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun officialAddress(): Optional<RcsAddress> =
            officialAddress.getOptional("official_address")

        /**
         * How recipients opt in, in prose. The carriers read this one.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optInProcessDescription(): Optional<String> =
            optInProcessDescription.getOptional("opt_in_process_description")

        /**
         * A screenshot of the opt-in, as a publicly fetchable URL.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun optInScreenshotUrl(): Optional<String> =
            optInScreenshotUrl.getOptional("opt_in_screenshot_url")

        /**
         * Required by US carriers. Must be an absolute http(s) URL they can fetch.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun privacyPolicyUrl(): Optional<String> =
            privacyPolicyUrl.getOptional("privacy_policy_url")

        /**
         * Examples of what the agent will send, for the review.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sampleMessages(): Optional<List<String>> = sampleMessages.getOptional("sample_messages")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun startMessage(): Optional<String> = startMessage.getOptional("start_message")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun stopMessage(): Optional<String> = stopMessage.getOptional("stop_message")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun termsAndConditionsUrl(): Optional<String> =
            termsAndConditionsUrl.getOptional("terms_and_conditions_url")

        /**
         * The brand's own site.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun websiteUrl(): Optional<String> = websiteUrl.getOptional("website_url")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [agentUseCase].
         *
         * Unlike [agentUseCase], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("agent_use_case")
        @ExcludeMissing
        fun _agentUseCase(): JsonField<AgentUseCase> = agentUseCase

        /**
         * Returns the raw JSON value of [bannerUrl].
         *
         * Unlike [bannerUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("banner_url") @ExcludeMissing fun _bannerUrl(): JsonField<String> = bannerUrl

        /**
         * Returns the raw JSON value of [brandColor].
         *
         * Unlike [brandColor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("brand_color")
        @ExcludeMissing
        fun _brandColor(): JsonField<String> = brandColor

        /**
         * Returns the raw JSON value of [brandEmail].
         *
         * Unlike [brandEmail], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("brand_email")
        @ExcludeMissing
        fun _brandEmail(): JsonField<String> = brandEmail

        /**
         * Returns the raw JSON value of [brandName].
         *
         * Unlike [brandName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("brand_name") @ExcludeMissing fun _brandName(): JsonField<String> = brandName

        /**
         * Returns the raw JSON value of [brandPhoneNumber].
         *
         * Unlike [brandPhoneNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("brand_phone_number")
        @ExcludeMissing
        fun _brandPhoneNumber(): JsonField<String> = brandPhoneNumber

        /**
         * Returns the raw JSON value of [briefCompanyDescription].
         *
         * Unlike [briefCompanyDescription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("brief_company_description")
        @ExcludeMissing
        fun _briefCompanyDescription(): JsonField<String> = briefCompanyDescription

        /**
         * Returns the raw JSON value of [companyEin].
         *
         * Unlike [companyEin], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("company_ein")
        @ExcludeMissing
        fun _companyEin(): JsonField<String> = companyEin

        /**
         * Returns the raw JSON value of [contactNameAndTitle].
         *
         * Unlike [contactNameAndTitle], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("contact_name_and_title")
        @ExcludeMissing
        fun _contactNameAndTitle(): JsonField<String> = contactNameAndTitle

        /**
         * Returns the raw JSON value of [customerSupportEmail].
         *
         * Unlike [customerSupportEmail], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("customer_support_email")
        @ExcludeMissing
        fun _customerSupportEmail(): JsonField<String> = customerSupportEmail

        /**
         * Returns the raw JSON value of [customerSupportPhoneNumber].
         *
         * Unlike [customerSupportPhoneNumber], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("customer_support_phone_number")
        @ExcludeMissing
        fun _customerSupportPhoneNumber(): JsonField<String> = customerSupportPhoneNumber

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [displayName].
         *
         * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("display_name")
        @ExcludeMissing
        fun _displayName(): JsonField<String> = displayName

        /**
         * Returns the raw JSON value of [entityType].
         *
         * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("entity_type")
        @ExcludeMissing
        fun _entityType(): JsonField<String> = entityType

        /**
         * Returns the raw JSON value of [helpMessage].
         *
         * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("help_message")
        @ExcludeMissing
        fun _helpMessage(): JsonField<String> = helpMessage

        /**
         * Returns the raw JSON value of [logoUrl].
         *
         * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logo_url") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

        /**
         * Returns the raw JSON value of [officialAddress].
         *
         * Unlike [officialAddress], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("official_address")
        @ExcludeMissing
        fun _officialAddress(): JsonField<RcsAddress> = officialAddress

        /**
         * Returns the raw JSON value of [optInProcessDescription].
         *
         * Unlike [optInProcessDescription], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("opt_in_process_description")
        @ExcludeMissing
        fun _optInProcessDescription(): JsonField<String> = optInProcessDescription

        /**
         * Returns the raw JSON value of [optInScreenshotUrl].
         *
         * Unlike [optInScreenshotUrl], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("opt_in_screenshot_url")
        @ExcludeMissing
        fun _optInScreenshotUrl(): JsonField<String> = optInScreenshotUrl

        /**
         * Returns the raw JSON value of [privacyPolicyUrl].
         *
         * Unlike [privacyPolicyUrl], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("privacy_policy_url")
        @ExcludeMissing
        fun _privacyPolicyUrl(): JsonField<String> = privacyPolicyUrl

        /**
         * Returns the raw JSON value of [sampleMessages].
         *
         * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sample_messages")
        @ExcludeMissing
        fun _sampleMessages(): JsonField<List<String>> = sampleMessages

        /**
         * Returns the raw JSON value of [startMessage].
         *
         * Unlike [startMessage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("start_message")
        @ExcludeMissing
        fun _startMessage(): JsonField<String> = startMessage

        /**
         * Returns the raw JSON value of [stopMessage].
         *
         * Unlike [stopMessage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stop_message")
        @ExcludeMissing
        fun _stopMessage(): JsonField<String> = stopMessage

        /**
         * Returns the raw JSON value of [termsAndConditionsUrl].
         *
         * Unlike [termsAndConditionsUrl], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("terms_and_conditions_url")
        @ExcludeMissing
        fun _termsAndConditionsUrl(): JsonField<String> = termsAndConditionsUrl

        /**
         * Returns the raw JSON value of [websiteUrl].
         *
         * Unlike [websiteUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("website_url")
        @ExcludeMissing
        fun _websiteUrl(): JsonField<String> = websiteUrl

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
            private var agentUseCase: JsonField<AgentUseCase> = JsonMissing.of()
            private var bannerUrl: JsonField<String> = JsonMissing.of()
            private var brandColor: JsonField<String> = JsonMissing.of()
            private var brandEmail: JsonField<String> = JsonMissing.of()
            private var brandName: JsonField<String> = JsonMissing.of()
            private var brandPhoneNumber: JsonField<String> = JsonMissing.of()
            private var briefCompanyDescription: JsonField<String> = JsonMissing.of()
            private var companyEin: JsonField<String> = JsonMissing.of()
            private var contactNameAndTitle: JsonField<String> = JsonMissing.of()
            private var customerSupportEmail: JsonField<String> = JsonMissing.of()
            private var customerSupportPhoneNumber: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var displayName: JsonField<String> = JsonMissing.of()
            private var entityType: JsonField<String> = JsonMissing.of()
            private var helpMessage: JsonField<String> = JsonMissing.of()
            private var logoUrl: JsonField<String> = JsonMissing.of()
            private var officialAddress: JsonField<RcsAddress> = JsonMissing.of()
            private var optInProcessDescription: JsonField<String> = JsonMissing.of()
            private var optInScreenshotUrl: JsonField<String> = JsonMissing.of()
            private var privacyPolicyUrl: JsonField<String> = JsonMissing.of()
            private var sampleMessages: JsonField<MutableList<String>>? = null
            private var startMessage: JsonField<String> = JsonMissing.of()
            private var stopMessage: JsonField<String> = JsonMissing.of()
            private var termsAndConditionsUrl: JsonField<String> = JsonMissing.of()
            private var websiteUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                agentUseCase = body.agentUseCase
                bannerUrl = body.bannerUrl
                brandColor = body.brandColor
                brandEmail = body.brandEmail
                brandName = body.brandName
                brandPhoneNumber = body.brandPhoneNumber
                briefCompanyDescription = body.briefCompanyDescription
                companyEin = body.companyEin
                contactNameAndTitle = body.contactNameAndTitle
                customerSupportEmail = body.customerSupportEmail
                customerSupportPhoneNumber = body.customerSupportPhoneNumber
                description = body.description
                displayName = body.displayName
                entityType = body.entityType
                helpMessage = body.helpMessage
                logoUrl = body.logoUrl
                officialAddress = body.officialAddress
                optInProcessDescription = body.optInProcessDescription
                optInScreenshotUrl = body.optInScreenshotUrl
                privacyPolicyUrl = body.privacyPolicyUrl
                sampleMessages = body.sampleMessages.map { it.toMutableList() }
                startMessage = body.startMessage
                stopMessage = body.stopMessage
                termsAndConditionsUrl = body.termsAndConditionsUrl
                websiteUrl = body.websiteUrl
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
             * Which kind of traffic the agent carries. One of the accepted use cases; the error
             * names the set.
             */
            fun agentUseCase(agentUseCase: AgentUseCase) = agentUseCase(JsonField.of(agentUseCase))

            /**
             * Sets [Builder.agentUseCase] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agentUseCase] with a well-typed [AgentUseCase] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agentUseCase(agentUseCase: JsonField<AgentUseCase>) = apply {
                this.agentUseCase = agentUseCase
            }

            fun bannerUrl(bannerUrl: String) = bannerUrl(JsonField.of(bannerUrl))

            /**
             * Sets [Builder.bannerUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bannerUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bannerUrl(bannerUrl: JsonField<String>) = apply { this.bannerUrl = bannerUrl }

            /**
             * Primary brand colour, as #RRGGBB. Three-digit shorthand is refused: the value is
             * submitted verbatim, so two spellings of one colour is only a way for the stored value
             * to disagree with the form.
             */
            fun brandColor(brandColor: String) = brandColor(JsonField.of(brandColor))

            /**
             * Sets [Builder.brandColor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandColor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brandColor(brandColor: JsonField<String>) = apply { this.brandColor = brandColor }

            fun brandEmail(brandEmail: String) = brandEmail(JsonField.of(brandEmail))

            /**
             * Sets [Builder.brandEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandEmail] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brandEmail(brandEmail: JsonField<String>) = apply { this.brandEmail = brandEmail }

            /**
             * The brand this agent presents over RCS.
             *
             * Not taken from your compliance.brand: a business may present a different brand on RCS
             * than the one its 10DLC registration is filed against, and the carriers vet this one.
             */
            fun brandName(brandName: String) = brandName(JsonField.of(brandName))

            /**
             * Sets [Builder.brandName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brandName(brandName: JsonField<String>) = apply { this.brandName = brandName }

            /**
             * The brand's own number. Also becomes the agent's canonical sending number for
             * routing, which is why it is normalised to E.164 rather than stored as sent.
             */
            fun brandPhoneNumber(brandPhoneNumber: String) =
                brandPhoneNumber(JsonField.of(brandPhoneNumber))

            /**
             * Sets [Builder.brandPhoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brandPhoneNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brandPhoneNumber(brandPhoneNumber: JsonField<String>) = apply {
                this.brandPhoneNumber = brandPhoneNumber
            }

            fun briefCompanyDescription(briefCompanyDescription: String) =
                briefCompanyDescription(JsonField.of(briefCompanyDescription))

            /**
             * Sets [Builder.briefCompanyDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.briefCompanyDescription] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun briefCompanyDescription(briefCompanyDescription: JsonField<String>) = apply {
                this.briefCompanyDescription = briefCompanyDescription
            }

            fun companyEin(companyEin: String) = companyEin(JsonField.of(companyEin))

            /**
             * Sets [Builder.companyEin] to an arbitrary JSON value.
             *
             * You should usually call [Builder.companyEin] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun companyEin(companyEin: JsonField<String>) = apply { this.companyEin = companyEin }

            fun contactNameAndTitle(contactNameAndTitle: String) =
                contactNameAndTitle(JsonField.of(contactNameAndTitle))

            /**
             * Sets [Builder.contactNameAndTitle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contactNameAndTitle] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun contactNameAndTitle(contactNameAndTitle: JsonField<String>) = apply {
                this.contactNameAndTitle = contactNameAndTitle
            }

            fun customerSupportEmail(customerSupportEmail: String) =
                customerSupportEmail(JsonField.of(customerSupportEmail))

            /**
             * Sets [Builder.customerSupportEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customerSupportEmail] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun customerSupportEmail(customerSupportEmail: JsonField<String>) = apply {
                this.customerSupportEmail = customerSupportEmail
            }

            fun customerSupportPhoneNumber(customerSupportPhoneNumber: String) =
                customerSupportPhoneNumber(JsonField.of(customerSupportPhoneNumber))

            /**
             * Sets [Builder.customerSupportPhoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customerSupportPhoneNumber] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun customerSupportPhoneNumber(customerSupportPhoneNumber: JsonField<String>) = apply {
                this.customerSupportPhoneNumber = customerSupportPhoneNumber
            }

            /** What the agent is for, shown to recipients. Capped by the carriers, not by us. */
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

            /** The name the agent shows in the messaging client. */
            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            /**
             * Sets [Builder.displayName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            fun entityType(entityType: String) = entityType(JsonField.of(entityType))

            /**
             * Sets [Builder.entityType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.entityType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun entityType(entityType: JsonField<String>) = apply { this.entityType = entityType }

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
             * Publicly reachable logo. It has to be fetchable without authentication at review
             * time, so a URL behind a login passes this call and fails the review.
             */
            fun logoUrl(logoUrl: String) = logoUrl(JsonField.of(logoUrl))

            /**
             * Sets [Builder.logoUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logoUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

            /** The registered address of the company behind the agent. */
            fun officialAddress(officialAddress: RcsAddress) =
                officialAddress(JsonField.of(officialAddress))

            /**
             * Sets [Builder.officialAddress] to an arbitrary JSON value.
             *
             * You should usually call [Builder.officialAddress] with a well-typed [RcsAddress]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun officialAddress(officialAddress: JsonField<RcsAddress>) = apply {
                this.officialAddress = officialAddress
            }

            /** How recipients opt in, in prose. The carriers read this one. */
            fun optInProcessDescription(optInProcessDescription: String) =
                optInProcessDescription(JsonField.of(optInProcessDescription))

            /**
             * Sets [Builder.optInProcessDescription] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optInProcessDescription] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun optInProcessDescription(optInProcessDescription: JsonField<String>) = apply {
                this.optInProcessDescription = optInProcessDescription
            }

            /** A screenshot of the opt-in, as a publicly fetchable URL. */
            fun optInScreenshotUrl(optInScreenshotUrl: String?) =
                optInScreenshotUrl(JsonField.ofNullable(optInScreenshotUrl))

            /**
             * Alias for calling [Builder.optInScreenshotUrl] with
             * `optInScreenshotUrl.orElse(null)`.
             */
            fun optInScreenshotUrl(optInScreenshotUrl: Optional<String>) =
                optInScreenshotUrl(optInScreenshotUrl.getOrNull())

            /**
             * Sets [Builder.optInScreenshotUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.optInScreenshotUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun optInScreenshotUrl(optInScreenshotUrl: JsonField<String>) = apply {
                this.optInScreenshotUrl = optInScreenshotUrl
            }

            /** Required by US carriers. Must be an absolute http(s) URL they can fetch. */
            fun privacyPolicyUrl(privacyPolicyUrl: String) =
                privacyPolicyUrl(JsonField.of(privacyPolicyUrl))

            /**
             * Sets [Builder.privacyPolicyUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.privacyPolicyUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun privacyPolicyUrl(privacyPolicyUrl: JsonField<String>) = apply {
                this.privacyPolicyUrl = privacyPolicyUrl
            }

            /** Examples of what the agent will send, for the review. */
            fun sampleMessages(sampleMessages: List<String>) =
                sampleMessages(JsonField.of(sampleMessages))

            /**
             * Sets [Builder.sampleMessages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sampleMessages] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun sampleMessages(sampleMessages: JsonField<List<String>>) = apply {
                this.sampleMessages = sampleMessages.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [sampleMessages].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSampleMessage(sampleMessage: String) = apply {
                sampleMessages =
                    (sampleMessages ?: JsonField.of(mutableListOf())).also {
                        checkKnown("sampleMessages", it).add(sampleMessage)
                    }
            }

            fun startMessage(startMessage: String) = startMessage(JsonField.of(startMessage))

            /**
             * Sets [Builder.startMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startMessage(startMessage: JsonField<String>) = apply {
                this.startMessage = startMessage
            }

            fun stopMessage(stopMessage: String) = stopMessage(JsonField.of(stopMessage))

            /**
             * Sets [Builder.stopMessage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stopMessage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stopMessage(stopMessage: JsonField<String>) = apply {
                this.stopMessage = stopMessage
            }

            fun termsAndConditionsUrl(termsAndConditionsUrl: String) =
                termsAndConditionsUrl(JsonField.of(termsAndConditionsUrl))

            /**
             * Sets [Builder.termsAndConditionsUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.termsAndConditionsUrl] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun termsAndConditionsUrl(termsAndConditionsUrl: JsonField<String>) = apply {
                this.termsAndConditionsUrl = termsAndConditionsUrl
            }

            /** The brand's own site. */
            fun websiteUrl(websiteUrl: String) = websiteUrl(JsonField.of(websiteUrl))

            /**
             * Sets [Builder.websiteUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.websiteUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun websiteUrl(websiteUrl: JsonField<String>) = apply { this.websiteUrl = websiteUrl }

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
                    agentUseCase,
                    bannerUrl,
                    brandColor,
                    brandEmail,
                    brandName,
                    brandPhoneNumber,
                    briefCompanyDescription,
                    companyEin,
                    contactNameAndTitle,
                    customerSupportEmail,
                    customerSupportPhoneNumber,
                    description,
                    displayName,
                    entityType,
                    helpMessage,
                    logoUrl,
                    officialAddress,
                    optInProcessDescription,
                    optInScreenshotUrl,
                    privacyPolicyUrl,
                    (sampleMessages ?: JsonMissing.of()).map { it.toImmutable() },
                    startMessage,
                    stopMessage,
                    termsAndConditionsUrl,
                    websiteUrl,
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
            agentUseCase().ifPresent { it.validate() }
            bannerUrl()
            brandColor()
            brandEmail()
            brandName()
            brandPhoneNumber()
            briefCompanyDescription()
            companyEin()
            contactNameAndTitle()
            customerSupportEmail()
            customerSupportPhoneNumber()
            description()
            displayName()
            entityType()
            helpMessage()
            logoUrl()
            officialAddress().ifPresent { it.validate() }
            optInProcessDescription()
            optInScreenshotUrl()
            privacyPolicyUrl()
            sampleMessages()
            startMessage()
            stopMessage()
            termsAndConditionsUrl()
            websiteUrl()
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
                (agentUseCase.asKnown().getOrNull()?.validity() ?: 0) +
                (if (bannerUrl.asKnown().isPresent) 1 else 0) +
                (if (brandColor.asKnown().isPresent) 1 else 0) +
                (if (brandEmail.asKnown().isPresent) 1 else 0) +
                (if (brandName.asKnown().isPresent) 1 else 0) +
                (if (brandPhoneNumber.asKnown().isPresent) 1 else 0) +
                (if (briefCompanyDescription.asKnown().isPresent) 1 else 0) +
                (if (companyEin.asKnown().isPresent) 1 else 0) +
                (if (contactNameAndTitle.asKnown().isPresent) 1 else 0) +
                (if (customerSupportEmail.asKnown().isPresent) 1 else 0) +
                (if (customerSupportPhoneNumber.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (displayName.asKnown().isPresent) 1 else 0) +
                (if (entityType.asKnown().isPresent) 1 else 0) +
                (if (helpMessage.asKnown().isPresent) 1 else 0) +
                (if (logoUrl.asKnown().isPresent) 1 else 0) +
                (officialAddress.asKnown().getOrNull()?.validity() ?: 0) +
                (if (optInProcessDescription.asKnown().isPresent) 1 else 0) +
                (if (optInScreenshotUrl.asKnown().isPresent) 1 else 0) +
                (if (privacyPolicyUrl.asKnown().isPresent) 1 else 0) +
                (sampleMessages.asKnown().getOrNull()?.size ?: 0) +
                (if (startMessage.asKnown().isPresent) 1 else 0) +
                (if (stopMessage.asKnown().isPresent) 1 else 0) +
                (if (termsAndConditionsUrl.asKnown().isPresent) 1 else 0) +
                (if (websiteUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                agentUseCase == other.agentUseCase &&
                bannerUrl == other.bannerUrl &&
                brandColor == other.brandColor &&
                brandEmail == other.brandEmail &&
                brandName == other.brandName &&
                brandPhoneNumber == other.brandPhoneNumber &&
                briefCompanyDescription == other.briefCompanyDescription &&
                companyEin == other.companyEin &&
                contactNameAndTitle == other.contactNameAndTitle &&
                customerSupportEmail == other.customerSupportEmail &&
                customerSupportPhoneNumber == other.customerSupportPhoneNumber &&
                description == other.description &&
                displayName == other.displayName &&
                entityType == other.entityType &&
                helpMessage == other.helpMessage &&
                logoUrl == other.logoUrl &&
                officialAddress == other.officialAddress &&
                optInProcessDescription == other.optInProcessDescription &&
                optInScreenshotUrl == other.optInScreenshotUrl &&
                privacyPolicyUrl == other.privacyPolicyUrl &&
                sampleMessages == other.sampleMessages &&
                startMessage == other.startMessage &&
                stopMessage == other.stopMessage &&
                termsAndConditionsUrl == other.termsAndConditionsUrl &&
                websiteUrl == other.websiteUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                agentUseCase,
                bannerUrl,
                brandColor,
                brandEmail,
                brandName,
                brandPhoneNumber,
                briefCompanyDescription,
                companyEin,
                contactNameAndTitle,
                customerSupportEmail,
                customerSupportPhoneNumber,
                description,
                displayName,
                entityType,
                helpMessage,
                logoUrl,
                officialAddress,
                optInProcessDescription,
                optInScreenshotUrl,
                privacyPolicyUrl,
                sampleMessages,
                startMessage,
                stopMessage,
                termsAndConditionsUrl,
                websiteUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, agentUseCase=$agentUseCase, bannerUrl=$bannerUrl, brandColor=$brandColor, brandEmail=$brandEmail, brandName=$brandName, brandPhoneNumber=$brandPhoneNumber, briefCompanyDescription=$briefCompanyDescription, companyEin=$companyEin, contactNameAndTitle=$contactNameAndTitle, customerSupportEmail=$customerSupportEmail, customerSupportPhoneNumber=$customerSupportPhoneNumber, description=$description, displayName=$displayName, entityType=$entityType, helpMessage=$helpMessage, logoUrl=$logoUrl, officialAddress=$officialAddress, optInProcessDescription=$optInProcessDescription, optInScreenshotUrl=$optInScreenshotUrl, privacyPolicyUrl=$privacyPolicyUrl, sampleMessages=$sampleMessages, startMessage=$startMessage, stopMessage=$stopMessage, termsAndConditionsUrl=$termsAndConditionsUrl, websiteUrl=$websiteUrl, additionalProperties=$additionalProperties}"
    }

    /**
     * Which kind of traffic the agent carries. One of the accepted use cases; the error names the
     * set.
     */
    class AgentUseCase @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val VERIFICATION = of("VERIFICATION")

            @JvmField val NOTIFICATIONS = of("NOTIFICATIONS")

            @JvmField val MARKETING = of("MARKETING")

            @JvmField val MULTI_USE = of("MULTI_USE")

            @JvmStatic fun of(value: String) = AgentUseCase(JsonField.of(value))
        }

        /** An enum containing [AgentUseCase]'s known values. */
        enum class Known {
            VERIFICATION,
            NOTIFICATIONS,
            MARKETING,
            MULTI_USE,
        }

        /**
         * An enum containing [AgentUseCase]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AgentUseCase] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            VERIFICATION,
            NOTIFICATIONS,
            MARKETING,
            MULTI_USE,
            /**
             * An enum member indicating that [AgentUseCase] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                VERIFICATION -> Value.VERIFICATION
                NOTIFICATIONS -> Value.NOTIFICATIONS
                MARKETING -> Value.MARKETING
                MULTI_USE -> Value.MULTI_USE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                VERIFICATION -> Known.VERIFICATION
                NOTIFICATIONS -> Known.NOTIFICATIONS
                MARKETING -> Known.MARKETING
                MULTI_USE -> Known.MULTI_USE
                else -> throw SentInvalidDataException("Unknown AgentUseCase: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentInvalidDataException("Value is not a String") }

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
        fun validate(): AgentUseCase = apply {
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

            return other is AgentUseCase && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RcCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "RcCreateParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
