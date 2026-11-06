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
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.channels.rcs.RcsAddress
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Asks for an RCS agent of the profile's own, optionally with the full order form inline.
 *
 * Two modes, distinguished by whether any field is populated: "rcs": {} — intent only. Records that
 * the profile wants its own agent; the order form is submitted separately through POST
 * /v3/channels/rcs once the fields are ready. "rcs": { ...fields... } — full form. All required
 * fields must be present; the agent is created alongside the profile in one call. Omitting
 * opt_in_screenshot_url is allowed.
 */
class SenderProfileRcs
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val description: JsonField<String>,
    private val agentUseCase: JsonField<String>,
    private val bannerUrl: JsonField<String>,
    private val billingCategory: JsonField<String>,
    private val brandColor: JsonField<String>,
    private val brandEmail: JsonField<String>,
    private val brandName: JsonField<String>,
    private val brandPhoneNumber: JsonField<String>,
    private val briefCompanyDescription: JsonField<String>,
    private val companyEin: JsonField<String>,
    private val contactNameAndTitle: JsonField<String>,
    private val customerSupportEmail: JsonField<String>,
    private val customerSupportPhoneNumber: JsonField<String>,
    private val displayName: JsonField<String>,
    private val entityType: JsonField<String>,
    private val helpMessage: JsonField<String>,
    private val hostingRegion: JsonField<String>,
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
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_use_case")
        @ExcludeMissing
        agentUseCase: JsonField<String> = JsonMissing.of(),
        @JsonProperty("banner_url") @ExcludeMissing bannerUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("billing_category")
        @ExcludeMissing
        billingCategory: JsonField<String> = JsonMissing.of(),
        @JsonProperty("brand_color")
        @ExcludeMissing
        brandColor: JsonField<String> = JsonMissing.of(),
        @JsonProperty("brand_email")
        @ExcludeMissing
        brandEmail: JsonField<String> = JsonMissing.of(),
        @JsonProperty("brand_name") @ExcludeMissing brandName: JsonField<String> = JsonMissing.of(),
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
        @JsonProperty("display_name")
        @ExcludeMissing
        displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("entity_type")
        @ExcludeMissing
        entityType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("help_message")
        @ExcludeMissing
        helpMessage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("hosting_region")
        @ExcludeMissing
        hostingRegion: JsonField<String> = JsonMissing.of(),
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
        description,
        agentUseCase,
        bannerUrl,
        billingCategory,
        brandColor,
        brandEmail,
        brandName,
        brandPhoneNumber,
        briefCompanyDescription,
        companyEin,
        contactNameAndTitle,
        customerSupportEmail,
        customerSupportPhoneNumber,
        displayName,
        entityType,
        helpMessage,
        hostingRegion,
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

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun description(): String = description.getRequired("description")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentUseCase(): Optional<String> = agentUseCase.getOptional("agent_use_case")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun bannerUrl(): Optional<String> = bannerUrl.getOptional("banner_url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun billingCategory(): Optional<String> = billingCategory.getOptional("billing_category")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandColor(): Optional<String> = brandColor.getOptional("brand_color")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandEmail(): Optional<String> = brandEmail.getOptional("brand_email")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandName(): Optional<String> = brandName.getOptional("brand_name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brandPhoneNumber(): Optional<String> = brandPhoneNumber.getOptional("brand_phone_number")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun briefCompanyDescription(): Optional<String> =
        briefCompanyDescription.getOptional("brief_company_description")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun companyEin(): Optional<String> = companyEin.getOptional("company_ein")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactNameAndTitle(): Optional<String> =
        contactNameAndTitle.getOptional("contact_name_and_title")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerSupportEmail(): Optional<String> =
        customerSupportEmail.getOptional("customer_support_email")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerSupportPhoneNumber(): Optional<String> =
        customerSupportPhoneNumber.getOptional("customer_support_phone_number")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun displayName(): Optional<String> = displayName.getOptional("display_name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun entityType(): Optional<String> = entityType.getOptional("entity_type")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun helpMessage(): Optional<String> = helpMessage.getOptional("help_message")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun hostingRegion(): Optional<String> = hostingRegion.getOptional("hosting_region")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun logoUrl(): Optional<String> = logoUrl.getOptional("logo_url")

    /**
     * The registered address of the company behind the agent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun officialAddress(): Optional<RcsAddress> = officialAddress.getOptional("official_address")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optInProcessDescription(): Optional<String> =
        optInProcessDescription.getOptional("opt_in_process_description")

    /**
     * Optional — uploaded separately and its URL may not be known at submission time.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun optInScreenshotUrl(): Optional<String> =
        optInScreenshotUrl.getOptional("opt_in_screenshot_url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun privacyPolicyUrl(): Optional<String> = privacyPolicyUrl.getOptional("privacy_policy_url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sampleMessages(): Optional<List<String>> = sampleMessages.getOptional("sample_messages")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun startMessage(): Optional<String> = startMessage.getOptional("start_message")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun stopMessage(): Optional<String> = stopMessage.getOptional("stop_message")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun termsAndConditionsUrl(): Optional<String> =
        termsAndConditionsUrl.getOptional("terms_and_conditions_url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun websiteUrl(): Optional<String> = websiteUrl.getOptional("website_url")

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [agentUseCase].
     *
     * Unlike [agentUseCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_use_case")
    @ExcludeMissing
    fun _agentUseCase(): JsonField<String> = agentUseCase

    /**
     * Returns the raw JSON value of [bannerUrl].
     *
     * Unlike [bannerUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("banner_url") @ExcludeMissing fun _bannerUrl(): JsonField<String> = bannerUrl

    /**
     * Returns the raw JSON value of [billingCategory].
     *
     * Unlike [billingCategory], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing_category")
    @ExcludeMissing
    fun _billingCategory(): JsonField<String> = billingCategory

    /**
     * Returns the raw JSON value of [brandColor].
     *
     * Unlike [brandColor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brand_color") @ExcludeMissing fun _brandColor(): JsonField<String> = brandColor

    /**
     * Returns the raw JSON value of [brandEmail].
     *
     * Unlike [brandEmail], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brand_email") @ExcludeMissing fun _brandEmail(): JsonField<String> = brandEmail

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
    @JsonProperty("company_ein") @ExcludeMissing fun _companyEin(): JsonField<String> = companyEin

    /**
     * Returns the raw JSON value of [contactNameAndTitle].
     *
     * Unlike [contactNameAndTitle], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("contact_name_and_title")
    @ExcludeMissing
    fun _contactNameAndTitle(): JsonField<String> = contactNameAndTitle

    /**
     * Returns the raw JSON value of [customerSupportEmail].
     *
     * Unlike [customerSupportEmail], this method doesn't throw if the JSON field has an unexpected
     * type.
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
    @JsonProperty("entity_type") @ExcludeMissing fun _entityType(): JsonField<String> = entityType

    /**
     * Returns the raw JSON value of [helpMessage].
     *
     * Unlike [helpMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("help_message")
    @ExcludeMissing
    fun _helpMessage(): JsonField<String> = helpMessage

    /**
     * Returns the raw JSON value of [hostingRegion].
     *
     * Unlike [hostingRegion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hosting_region")
    @ExcludeMissing
    fun _hostingRegion(): JsonField<String> = hostingRegion

    /**
     * Returns the raw JSON value of [logoUrl].
     *
     * Unlike [logoUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logo_url") @ExcludeMissing fun _logoUrl(): JsonField<String> = logoUrl

    /**
     * Returns the raw JSON value of [officialAddress].
     *
     * Unlike [officialAddress], this method doesn't throw if the JSON field has an unexpected type.
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
     * Unlike [optInScreenshotUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
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
     * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sample_messages")
    @ExcludeMissing
    fun _sampleMessages(): JsonField<List<String>> = sampleMessages

    /**
     * Returns the raw JSON value of [startMessage].
     *
     * Unlike [startMessage], this method doesn't throw if the JSON field has an unexpected type.
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
     * Unlike [termsAndConditionsUrl], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("terms_and_conditions_url")
    @ExcludeMissing
    fun _termsAndConditionsUrl(): JsonField<String> = termsAndConditionsUrl

    /**
     * Returns the raw JSON value of [websiteUrl].
     *
     * Unlike [websiteUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("website_url") @ExcludeMissing fun _websiteUrl(): JsonField<String> = websiteUrl

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
         * Returns a mutable builder for constructing an instance of [SenderProfileRcs].
         *
         * The following fields are required:
         * ```java
         * .description()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileRcs]. */
    class Builder internal constructor() {

        private var description: JsonField<String>? = null
        private var agentUseCase: JsonField<String> = JsonMissing.of()
        private var bannerUrl: JsonField<String> = JsonMissing.of()
        private var billingCategory: JsonField<String> = JsonMissing.of()
        private var brandColor: JsonField<String> = JsonMissing.of()
        private var brandEmail: JsonField<String> = JsonMissing.of()
        private var brandName: JsonField<String> = JsonMissing.of()
        private var brandPhoneNumber: JsonField<String> = JsonMissing.of()
        private var briefCompanyDescription: JsonField<String> = JsonMissing.of()
        private var companyEin: JsonField<String> = JsonMissing.of()
        private var contactNameAndTitle: JsonField<String> = JsonMissing.of()
        private var customerSupportEmail: JsonField<String> = JsonMissing.of()
        private var customerSupportPhoneNumber: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var entityType: JsonField<String> = JsonMissing.of()
        private var helpMessage: JsonField<String> = JsonMissing.of()
        private var hostingRegion: JsonField<String> = JsonMissing.of()
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
        internal fun from(senderProfileRcs: SenderProfileRcs) = apply {
            description = senderProfileRcs.description
            agentUseCase = senderProfileRcs.agentUseCase
            bannerUrl = senderProfileRcs.bannerUrl
            billingCategory = senderProfileRcs.billingCategory
            brandColor = senderProfileRcs.brandColor
            brandEmail = senderProfileRcs.brandEmail
            brandName = senderProfileRcs.brandName
            brandPhoneNumber = senderProfileRcs.brandPhoneNumber
            briefCompanyDescription = senderProfileRcs.briefCompanyDescription
            companyEin = senderProfileRcs.companyEin
            contactNameAndTitle = senderProfileRcs.contactNameAndTitle
            customerSupportEmail = senderProfileRcs.customerSupportEmail
            customerSupportPhoneNumber = senderProfileRcs.customerSupportPhoneNumber
            displayName = senderProfileRcs.displayName
            entityType = senderProfileRcs.entityType
            helpMessage = senderProfileRcs.helpMessage
            hostingRegion = senderProfileRcs.hostingRegion
            logoUrl = senderProfileRcs.logoUrl
            officialAddress = senderProfileRcs.officialAddress
            optInProcessDescription = senderProfileRcs.optInProcessDescription
            optInScreenshotUrl = senderProfileRcs.optInScreenshotUrl
            privacyPolicyUrl = senderProfileRcs.privacyPolicyUrl
            sampleMessages = senderProfileRcs.sampleMessages.map { it.toMutableList() }
            startMessage = senderProfileRcs.startMessage
            stopMessage = senderProfileRcs.stopMessage
            termsAndConditionsUrl = senderProfileRcs.termsAndConditionsUrl
            websiteUrl = senderProfileRcs.websiteUrl
            additionalProperties = senderProfileRcs.additionalProperties.toMutableMap()
        }

        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun agentUseCase(agentUseCase: String?) = agentUseCase(JsonField.ofNullable(agentUseCase))

        /** Alias for calling [Builder.agentUseCase] with `agentUseCase.orElse(null)`. */
        fun agentUseCase(agentUseCase: Optional<String>) = agentUseCase(agentUseCase.getOrNull())

        /**
         * Sets [Builder.agentUseCase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentUseCase] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun agentUseCase(agentUseCase: JsonField<String>) = apply {
            this.agentUseCase = agentUseCase
        }

        fun bannerUrl(bannerUrl: String?) = bannerUrl(JsonField.ofNullable(bannerUrl))

        /** Alias for calling [Builder.bannerUrl] with `bannerUrl.orElse(null)`. */
        fun bannerUrl(bannerUrl: Optional<String>) = bannerUrl(bannerUrl.getOrNull())

        /**
         * Sets [Builder.bannerUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bannerUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bannerUrl(bannerUrl: JsonField<String>) = apply { this.bannerUrl = bannerUrl }

        fun billingCategory(billingCategory: String?) =
            billingCategory(JsonField.ofNullable(billingCategory))

        /** Alias for calling [Builder.billingCategory] with `billingCategory.orElse(null)`. */
        fun billingCategory(billingCategory: Optional<String>) =
            billingCategory(billingCategory.getOrNull())

        /**
         * Sets [Builder.billingCategory] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billingCategory] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun billingCategory(billingCategory: JsonField<String>) = apply {
            this.billingCategory = billingCategory
        }

        fun brandColor(brandColor: String?) = brandColor(JsonField.ofNullable(brandColor))

        /** Alias for calling [Builder.brandColor] with `brandColor.orElse(null)`. */
        fun brandColor(brandColor: Optional<String>) = brandColor(brandColor.getOrNull())

        /**
         * Sets [Builder.brandColor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandColor] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandColor(brandColor: JsonField<String>) = apply { this.brandColor = brandColor }

        fun brandEmail(brandEmail: String?) = brandEmail(JsonField.ofNullable(brandEmail))

        /** Alias for calling [Builder.brandEmail] with `brandEmail.orElse(null)`. */
        fun brandEmail(brandEmail: Optional<String>) = brandEmail(brandEmail.getOrNull())

        /**
         * Sets [Builder.brandEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandEmail] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandEmail(brandEmail: JsonField<String>) = apply { this.brandEmail = brandEmail }

        fun brandName(brandName: String?) = brandName(JsonField.ofNullable(brandName))

        /** Alias for calling [Builder.brandName] with `brandName.orElse(null)`. */
        fun brandName(brandName: Optional<String>) = brandName(brandName.getOrNull())

        /**
         * Sets [Builder.brandName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brandName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brandName(brandName: JsonField<String>) = apply { this.brandName = brandName }

        fun brandPhoneNumber(brandPhoneNumber: String?) =
            brandPhoneNumber(JsonField.ofNullable(brandPhoneNumber))

        /** Alias for calling [Builder.brandPhoneNumber] with `brandPhoneNumber.orElse(null)`. */
        fun brandPhoneNumber(brandPhoneNumber: Optional<String>) =
            brandPhoneNumber(brandPhoneNumber.getOrNull())

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

        fun briefCompanyDescription(briefCompanyDescription: String?) =
            briefCompanyDescription(JsonField.ofNullable(briefCompanyDescription))

        /**
         * Alias for calling [Builder.briefCompanyDescription] with
         * `briefCompanyDescription.orElse(null)`.
         */
        fun briefCompanyDescription(briefCompanyDescription: Optional<String>) =
            briefCompanyDescription(briefCompanyDescription.getOrNull())

        /**
         * Sets [Builder.briefCompanyDescription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.briefCompanyDescription] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun briefCompanyDescription(briefCompanyDescription: JsonField<String>) = apply {
            this.briefCompanyDescription = briefCompanyDescription
        }

        fun companyEin(companyEin: String?) = companyEin(JsonField.ofNullable(companyEin))

        /** Alias for calling [Builder.companyEin] with `companyEin.orElse(null)`. */
        fun companyEin(companyEin: Optional<String>) = companyEin(companyEin.getOrNull())

        /**
         * Sets [Builder.companyEin] to an arbitrary JSON value.
         *
         * You should usually call [Builder.companyEin] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun companyEin(companyEin: JsonField<String>) = apply { this.companyEin = companyEin }

        fun contactNameAndTitle(contactNameAndTitle: String?) =
            contactNameAndTitle(JsonField.ofNullable(contactNameAndTitle))

        /**
         * Alias for calling [Builder.contactNameAndTitle] with `contactNameAndTitle.orElse(null)`.
         */
        fun contactNameAndTitle(contactNameAndTitle: Optional<String>) =
            contactNameAndTitle(contactNameAndTitle.getOrNull())

        /**
         * Sets [Builder.contactNameAndTitle] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactNameAndTitle] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contactNameAndTitle(contactNameAndTitle: JsonField<String>) = apply {
            this.contactNameAndTitle = contactNameAndTitle
        }

        fun customerSupportEmail(customerSupportEmail: String?) =
            customerSupportEmail(JsonField.ofNullable(customerSupportEmail))

        /**
         * Alias for calling [Builder.customerSupportEmail] with
         * `customerSupportEmail.orElse(null)`.
         */
        fun customerSupportEmail(customerSupportEmail: Optional<String>) =
            customerSupportEmail(customerSupportEmail.getOrNull())

        /**
         * Sets [Builder.customerSupportEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerSupportEmail] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customerSupportEmail(customerSupportEmail: JsonField<String>) = apply {
            this.customerSupportEmail = customerSupportEmail
        }

        fun customerSupportPhoneNumber(customerSupportPhoneNumber: String?) =
            customerSupportPhoneNumber(JsonField.ofNullable(customerSupportPhoneNumber))

        /**
         * Alias for calling [Builder.customerSupportPhoneNumber] with
         * `customerSupportPhoneNumber.orElse(null)`.
         */
        fun customerSupportPhoneNumber(customerSupportPhoneNumber: Optional<String>) =
            customerSupportPhoneNumber(customerSupportPhoneNumber.getOrNull())

        /**
         * Sets [Builder.customerSupportPhoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerSupportPhoneNumber] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun customerSupportPhoneNumber(customerSupportPhoneNumber: JsonField<String>) = apply {
            this.customerSupportPhoneNumber = customerSupportPhoneNumber
        }

        fun displayName(displayName: String?) = displayName(JsonField.ofNullable(displayName))

        /** Alias for calling [Builder.displayName] with `displayName.orElse(null)`. */
        fun displayName(displayName: Optional<String>) = displayName(displayName.getOrNull())

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        fun entityType(entityType: String?) = entityType(JsonField.ofNullable(entityType))

        /** Alias for calling [Builder.entityType] with `entityType.orElse(null)`. */
        fun entityType(entityType: Optional<String>) = entityType(entityType.getOrNull())

        /**
         * Sets [Builder.entityType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entityType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun entityType(entityType: JsonField<String>) = apply { this.entityType = entityType }

        fun helpMessage(helpMessage: String?) = helpMessage(JsonField.ofNullable(helpMessage))

        /** Alias for calling [Builder.helpMessage] with `helpMessage.orElse(null)`. */
        fun helpMessage(helpMessage: Optional<String>) = helpMessage(helpMessage.getOrNull())

        /**
         * Sets [Builder.helpMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.helpMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun helpMessage(helpMessage: JsonField<String>) = apply { this.helpMessage = helpMessage }

        fun hostingRegion(hostingRegion: String?) =
            hostingRegion(JsonField.ofNullable(hostingRegion))

        /** Alias for calling [Builder.hostingRegion] with `hostingRegion.orElse(null)`. */
        fun hostingRegion(hostingRegion: Optional<String>) =
            hostingRegion(hostingRegion.getOrNull())

        /**
         * Sets [Builder.hostingRegion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hostingRegion] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hostingRegion(hostingRegion: JsonField<String>) = apply {
            this.hostingRegion = hostingRegion
        }

        fun logoUrl(logoUrl: String?) = logoUrl(JsonField.ofNullable(logoUrl))

        /** Alias for calling [Builder.logoUrl] with `logoUrl.orElse(null)`. */
        fun logoUrl(logoUrl: Optional<String>) = logoUrl(logoUrl.getOrNull())

        /**
         * Sets [Builder.logoUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logoUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logoUrl(logoUrl: JsonField<String>) = apply { this.logoUrl = logoUrl }

        /** The registered address of the company behind the agent. */
        fun officialAddress(officialAddress: RcsAddress?) =
            officialAddress(JsonField.ofNullable(officialAddress))

        /** Alias for calling [Builder.officialAddress] with `officialAddress.orElse(null)`. */
        fun officialAddress(officialAddress: Optional<RcsAddress>) =
            officialAddress(officialAddress.getOrNull())

        /**
         * Sets [Builder.officialAddress] to an arbitrary JSON value.
         *
         * You should usually call [Builder.officialAddress] with a well-typed [RcsAddress] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun officialAddress(officialAddress: JsonField<RcsAddress>) = apply {
            this.officialAddress = officialAddress
        }

        fun optInProcessDescription(optInProcessDescription: String?) =
            optInProcessDescription(JsonField.ofNullable(optInProcessDescription))

        /**
         * Alias for calling [Builder.optInProcessDescription] with
         * `optInProcessDescription.orElse(null)`.
         */
        fun optInProcessDescription(optInProcessDescription: Optional<String>) =
            optInProcessDescription(optInProcessDescription.getOrNull())

        /**
         * Sets [Builder.optInProcessDescription] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optInProcessDescription] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun optInProcessDescription(optInProcessDescription: JsonField<String>) = apply {
            this.optInProcessDescription = optInProcessDescription
        }

        /** Optional — uploaded separately and its URL may not be known at submission time. */
        fun optInScreenshotUrl(optInScreenshotUrl: String?) =
            optInScreenshotUrl(JsonField.ofNullable(optInScreenshotUrl))

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
            this.optInScreenshotUrl = optInScreenshotUrl
        }

        fun privacyPolicyUrl(privacyPolicyUrl: String?) =
            privacyPolicyUrl(JsonField.ofNullable(privacyPolicyUrl))

        /** Alias for calling [Builder.privacyPolicyUrl] with `privacyPolicyUrl.orElse(null)`. */
        fun privacyPolicyUrl(privacyPolicyUrl: Optional<String>) =
            privacyPolicyUrl(privacyPolicyUrl.getOrNull())

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

        fun sampleMessages(sampleMessages: List<String>?) =
            sampleMessages(JsonField.ofNullable(sampleMessages))

        /** Alias for calling [Builder.sampleMessages] with `sampleMessages.orElse(null)`. */
        fun sampleMessages(sampleMessages: Optional<List<String>>) =
            sampleMessages(sampleMessages.getOrNull())

        /**
         * Sets [Builder.sampleMessages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sampleMessages] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
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

        fun startMessage(startMessage: String?) = startMessage(JsonField.ofNullable(startMessage))

        /** Alias for calling [Builder.startMessage] with `startMessage.orElse(null)`. */
        fun startMessage(startMessage: Optional<String>) = startMessage(startMessage.getOrNull())

        /**
         * Sets [Builder.startMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun startMessage(startMessage: JsonField<String>) = apply {
            this.startMessage = startMessage
        }

        fun stopMessage(stopMessage: String?) = stopMessage(JsonField.ofNullable(stopMessage))

        /** Alias for calling [Builder.stopMessage] with `stopMessage.orElse(null)`. */
        fun stopMessage(stopMessage: Optional<String>) = stopMessage(stopMessage.getOrNull())

        /**
         * Sets [Builder.stopMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stopMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun stopMessage(stopMessage: JsonField<String>) = apply { this.stopMessage = stopMessage }

        fun termsAndConditionsUrl(termsAndConditionsUrl: String?) =
            termsAndConditionsUrl(JsonField.ofNullable(termsAndConditionsUrl))

        /**
         * Alias for calling [Builder.termsAndConditionsUrl] with
         * `termsAndConditionsUrl.orElse(null)`.
         */
        fun termsAndConditionsUrl(termsAndConditionsUrl: Optional<String>) =
            termsAndConditionsUrl(termsAndConditionsUrl.getOrNull())

        /**
         * Sets [Builder.termsAndConditionsUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.termsAndConditionsUrl] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun termsAndConditionsUrl(termsAndConditionsUrl: JsonField<String>) = apply {
            this.termsAndConditionsUrl = termsAndConditionsUrl
        }

        fun websiteUrl(websiteUrl: String?) = websiteUrl(JsonField.ofNullable(websiteUrl))

        /** Alias for calling [Builder.websiteUrl] with `websiteUrl.orElse(null)`. */
        fun websiteUrl(websiteUrl: Optional<String>) = websiteUrl(websiteUrl.getOrNull())

        /**
         * Sets [Builder.websiteUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.websiteUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [SenderProfileRcs].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .description()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SenderProfileRcs =
            SenderProfileRcs(
                checkRequired("description", description),
                agentUseCase,
                bannerUrl,
                billingCategory,
                brandColor,
                brandEmail,
                brandName,
                brandPhoneNumber,
                briefCompanyDescription,
                companyEin,
                contactNameAndTitle,
                customerSupportEmail,
                customerSupportPhoneNumber,
                displayName,
                entityType,
                helpMessage,
                hostingRegion,
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
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): SenderProfileRcs = apply {
        if (validated) {
            return@apply
        }

        description()
        agentUseCase()
        bannerUrl()
        billingCategory()
        brandColor()
        brandEmail()
        brandName()
        brandPhoneNumber()
        briefCompanyDescription()
        companyEin()
        contactNameAndTitle()
        customerSupportEmail()
        customerSupportPhoneNumber()
        displayName()
        entityType()
        helpMessage()
        hostingRegion()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (description.asKnown().isPresent) 1 else 0) +
            (if (agentUseCase.asKnown().isPresent) 1 else 0) +
            (if (bannerUrl.asKnown().isPresent) 1 else 0) +
            (if (billingCategory.asKnown().isPresent) 1 else 0) +
            (if (brandColor.asKnown().isPresent) 1 else 0) +
            (if (brandEmail.asKnown().isPresent) 1 else 0) +
            (if (brandName.asKnown().isPresent) 1 else 0) +
            (if (brandPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (briefCompanyDescription.asKnown().isPresent) 1 else 0) +
            (if (companyEin.asKnown().isPresent) 1 else 0) +
            (if (contactNameAndTitle.asKnown().isPresent) 1 else 0) +
            (if (customerSupportEmail.asKnown().isPresent) 1 else 0) +
            (if (customerSupportPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (displayName.asKnown().isPresent) 1 else 0) +
            (if (entityType.asKnown().isPresent) 1 else 0) +
            (if (helpMessage.asKnown().isPresent) 1 else 0) +
            (if (hostingRegion.asKnown().isPresent) 1 else 0) +
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

        return other is SenderProfileRcs &&
            description == other.description &&
            agentUseCase == other.agentUseCase &&
            bannerUrl == other.bannerUrl &&
            billingCategory == other.billingCategory &&
            brandColor == other.brandColor &&
            brandEmail == other.brandEmail &&
            brandName == other.brandName &&
            brandPhoneNumber == other.brandPhoneNumber &&
            briefCompanyDescription == other.briefCompanyDescription &&
            companyEin == other.companyEin &&
            contactNameAndTitle == other.contactNameAndTitle &&
            customerSupportEmail == other.customerSupportEmail &&
            customerSupportPhoneNumber == other.customerSupportPhoneNumber &&
            displayName == other.displayName &&
            entityType == other.entityType &&
            helpMessage == other.helpMessage &&
            hostingRegion == other.hostingRegion &&
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
            description,
            agentUseCase,
            bannerUrl,
            billingCategory,
            brandColor,
            brandEmail,
            brandName,
            brandPhoneNumber,
            briefCompanyDescription,
            companyEin,
            contactNameAndTitle,
            customerSupportEmail,
            customerSupportPhoneNumber,
            displayName,
            entityType,
            helpMessage,
            hostingRegion,
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
        "SenderProfileRcs{description=$description, agentUseCase=$agentUseCase, bannerUrl=$bannerUrl, billingCategory=$billingCategory, brandColor=$brandColor, brandEmail=$brandEmail, brandName=$brandName, brandPhoneNumber=$brandPhoneNumber, briefCompanyDescription=$briefCompanyDescription, companyEin=$companyEin, contactNameAndTitle=$contactNameAndTitle, customerSupportEmail=$customerSupportEmail, customerSupportPhoneNumber=$customerSupportPhoneNumber, displayName=$displayName, entityType=$entityType, helpMessage=$helpMessage, hostingRegion=$hostingRegion, logoUrl=$logoUrl, officialAddress=$officialAddress, optInProcessDescription=$optInProcessDescription, optInScreenshotUrl=$optInScreenshotUrl, privacyPolicyUrl=$privacyPolicyUrl, sampleMessages=$sampleMessages, startMessage=$startMessage, stopMessage=$stopMessage, termsAndConditionsUrl=$termsAndConditionsUrl, websiteUrl=$websiteUrl, additionalProperties=$additionalProperties}"
}
