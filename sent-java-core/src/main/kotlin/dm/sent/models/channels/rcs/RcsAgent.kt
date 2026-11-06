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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * An RCS agent as its owner sees it: the order form back, plus where the submission stands.
 *
 * Not RcsSenderResponse. That one is the admin projection and carries the pipeline we track about a
 * customer's request — internalStatus, statusReason, isLaunched — and the S3 keys behind the
 * assets. None of that is the customer's to read: an internal status is a note to ourselves, and an
 * S3 key is a storage detail that would become a contract the moment it was published.
 *
 * What is here is what the caller sent, in the names it sent them under, plus the three things only
 * we can answer: the record's id, its status, and the number it sends from. So a read after a write
 * shows the form as stored rather than as echoed.
 */
class RcsAgent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val agentUseCase: JsonField<String>,
    private val brandColor: JsonField<String>,
    private val brandEmail: JsonField<String>,
    private val brandName: JsonField<String>,
    private val brandPhoneNumber: JsonField<String>,
    private val briefCompanyDescription: JsonField<String>,
    private val companyEin: JsonField<String>,
    private val contactNameAndTitle: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customerSupportEmail: JsonField<String>,
    private val customerSupportPhoneNumber: JsonField<String>,
    private val description: JsonField<String>,
    private val displayName: JsonField<String>,
    private val entityType: JsonField<String>,
    private val helpMessage: JsonField<String>,
    private val officialAddress: JsonField<RcsAddress>,
    private val optInProcessDescription: JsonField<String>,
    private val phoneNumber: JsonField<String>,
    private val privacyPolicyUrl: JsonField<String>,
    private val reason: JsonField<String>,
    private val reasonCode: JsonField<String>,
    private val sampleMessages: JsonField<List<String>>,
    private val startMessage: JsonField<String>,
    private val status: JsonField<Status>,
    private val stopMessage: JsonField<String>,
    private val termsAndConditionsUrl: JsonField<String>,
    private val websiteUrl: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_use_case")
        @ExcludeMissing
        agentUseCase: JsonField<String> = JsonMissing.of(),
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
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
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
        @JsonProperty("official_address")
        @ExcludeMissing
        officialAddress: JsonField<RcsAddress> = JsonMissing.of(),
        @JsonProperty("opt_in_process_description")
        @ExcludeMissing
        optInProcessDescription: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_number")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("privacy_policy_url")
        @ExcludeMissing
        privacyPolicyUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason_code")
        @ExcludeMissing
        reasonCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sample_messages")
        @ExcludeMissing
        sampleMessages: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("start_message")
        @ExcludeMissing
        startMessage: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
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
        id,
        agentUseCase,
        brandColor,
        brandEmail,
        brandName,
        brandPhoneNumber,
        briefCompanyDescription,
        companyEin,
        contactNameAndTitle,
        createdAt,
        customerSupportEmail,
        customerSupportPhoneNumber,
        description,
        displayName,
        entityType,
        helpMessage,
        officialAddress,
        optInProcessDescription,
        phoneNumber,
        privacyPolicyUrl,
        reason,
        reasonCode,
        sampleMessages,
        startMessage,
        status,
        stopMessage,
        termsAndConditionsUrl,
        websiteUrl,
        mutableMapOf(),
    )

    /**
     * The agent record. Stable across the whole approval, and what support will ask for.
     *
     * Nullable and omitted when absent: a sender profile with RCS intent records the channel but
     * has no agent until the order form is submitted, so no id exists to report. A zero GUID is not
     * a valid id and is worse than the field being absent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentUseCase(): Optional<String> = agentUseCase.getOptional("agent_use_case")

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
     * Omitted when no real agent record exists — the intent-only path has no creation timestamp.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

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
    fun description(): Optional<String> = description.getOptional("description")

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
     * The number the agent sends from, derived from brand_phone_number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun privacyPolicyUrl(): Optional<String> = privacyPolicyUrl.getOptional("privacy_policy_url")

    /**
     * A sentence for reason_code, saying what to do where it is yours. Omitted while ACTIVE.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Why the agent is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
     * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than on
     * reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
     * generic reason for the status.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reasonCode(): Optional<String> = reasonCode.getOptional("reason_code")

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
     * Where the agent stands, in terms of who is holding it up — PROVISIONING, ACTION_NEEDED,
     * PENDING_REVIEW or ACTIVE.
     *
     * Resolved from both of the provider's axes rather than reported raw: an agent whose
     * resubmission we have asked for reads ACTION_NEEDED however its carrier status still reads,
     * and an agent not yet handed over reads PROVISIONING rather than pending a review nobody has
     * started.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<Status> = status.getOptional("status")

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
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [agentUseCase].
     *
     * Unlike [agentUseCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_use_case")
    @ExcludeMissing
    fun _agentUseCase(): JsonField<String> = agentUseCase

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
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

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
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

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
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone_number")
    @ExcludeMissing
    fun _phoneNumber(): JsonField<String> = phoneNumber

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
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [reasonCode].
     *
     * Unlike [reasonCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason_code") @ExcludeMissing fun _reasonCode(): JsonField<String> = reasonCode

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
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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

        /** Returns a mutable builder for constructing an instance of [RcsAgent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RcsAgent]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var agentUseCase: JsonField<String> = JsonMissing.of()
        private var brandColor: JsonField<String> = JsonMissing.of()
        private var brandEmail: JsonField<String> = JsonMissing.of()
        private var brandName: JsonField<String> = JsonMissing.of()
        private var brandPhoneNumber: JsonField<String> = JsonMissing.of()
        private var briefCompanyDescription: JsonField<String> = JsonMissing.of()
        private var companyEin: JsonField<String> = JsonMissing.of()
        private var contactNameAndTitle: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customerSupportEmail: JsonField<String> = JsonMissing.of()
        private var customerSupportPhoneNumber: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var entityType: JsonField<String> = JsonMissing.of()
        private var helpMessage: JsonField<String> = JsonMissing.of()
        private var officialAddress: JsonField<RcsAddress> = JsonMissing.of()
        private var optInProcessDescription: JsonField<String> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var privacyPolicyUrl: JsonField<String> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var reasonCode: JsonField<String> = JsonMissing.of()
        private var sampleMessages: JsonField<MutableList<String>>? = null
        private var startMessage: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var stopMessage: JsonField<String> = JsonMissing.of()
        private var termsAndConditionsUrl: JsonField<String> = JsonMissing.of()
        private var websiteUrl: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(rcsAgent: RcsAgent) = apply {
            id = rcsAgent.id
            agentUseCase = rcsAgent.agentUseCase
            brandColor = rcsAgent.brandColor
            brandEmail = rcsAgent.brandEmail
            brandName = rcsAgent.brandName
            brandPhoneNumber = rcsAgent.brandPhoneNumber
            briefCompanyDescription = rcsAgent.briefCompanyDescription
            companyEin = rcsAgent.companyEin
            contactNameAndTitle = rcsAgent.contactNameAndTitle
            createdAt = rcsAgent.createdAt
            customerSupportEmail = rcsAgent.customerSupportEmail
            customerSupportPhoneNumber = rcsAgent.customerSupportPhoneNumber
            description = rcsAgent.description
            displayName = rcsAgent.displayName
            entityType = rcsAgent.entityType
            helpMessage = rcsAgent.helpMessage
            officialAddress = rcsAgent.officialAddress
            optInProcessDescription = rcsAgent.optInProcessDescription
            phoneNumber = rcsAgent.phoneNumber
            privacyPolicyUrl = rcsAgent.privacyPolicyUrl
            reason = rcsAgent.reason
            reasonCode = rcsAgent.reasonCode
            sampleMessages = rcsAgent.sampleMessages.map { it.toMutableList() }
            startMessage = rcsAgent.startMessage
            status = rcsAgent.status
            stopMessage = rcsAgent.stopMessage
            termsAndConditionsUrl = rcsAgent.termsAndConditionsUrl
            websiteUrl = rcsAgent.websiteUrl
            additionalProperties = rcsAgent.additionalProperties.toMutableMap()
        }

        /**
         * The agent record. Stable across the whole approval, and what support will ask for.
         *
         * Nullable and omitted when absent: a sender profile with RCS intent records the channel
         * but has no agent until the order form is submitted, so no id exists to report. A zero
         * GUID is not a valid id and is worse than the field being absent.
         */
        fun id(id: String?) = id(JsonField.ofNullable(id))

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

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

        /**
         * Omitted when no real agent record exists — the intent-only path has no creation
         * timestamp.
         */
        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        /** Alias for calling [Builder.createdAt] with `createdAt.orElse(null)`. */
        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

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

        fun description(description: String?) = description(JsonField.ofNullable(description))

        /** Alias for calling [Builder.description] with `description.orElse(null)`. */
        fun description(description: Optional<String>) = description(description.getOrNull())

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

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

        /** The number the agent sends from, derived from brand_phone_number. */
        fun phoneNumber(phoneNumber: String?) = phoneNumber(JsonField.ofNullable(phoneNumber))

        /** Alias for calling [Builder.phoneNumber] with `phoneNumber.orElse(null)`. */
        fun phoneNumber(phoneNumber: Optional<String>) = phoneNumber(phoneNumber.getOrNull())

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

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

        /**
         * A sentence for reason_code, saying what to do where it is yours. Omitted while ACTIVE.
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
         * Why the agent is not ACTIVE, as a stable code: an ErrorCodes CHANNEL_xxx value such as
         * CHANNEL_001 (something you owe) or CHANNEL_009 (under review). Switch on this rather than
         * on reason. Omitted while ACTIVE. Read-only; when nothing more specific is known it is the
         * generic reason for the status.
         */
        fun reasonCode(reasonCode: String?) = reasonCode(JsonField.ofNullable(reasonCode))

        /** Alias for calling [Builder.reasonCode] with `reasonCode.orElse(null)`. */
        fun reasonCode(reasonCode: Optional<String>) = reasonCode(reasonCode.getOrNull())

        /**
         * Sets [Builder.reasonCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasonCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasonCode(reasonCode: JsonField<String>) = apply { this.reasonCode = reasonCode }

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

        /**
         * Where the agent stands, in terms of who is holding it up — PROVISIONING, ACTION_NEEDED,
         * PENDING_REVIEW or ACTIVE.
         *
         * Resolved from both of the provider's axes rather than reported raw: an agent whose
         * resubmission we have asked for reads ACTION_NEEDED however its carrier status still
         * reads, and an agent not yet handed over reads PROVISIONING rather than pending a review
         * nobody has started.
         */
        fun status(status: Status?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

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
         * Returns an immutable instance of [RcsAgent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RcsAgent =
            RcsAgent(
                id,
                agentUseCase,
                brandColor,
                brandEmail,
                brandName,
                brandPhoneNumber,
                briefCompanyDescription,
                companyEin,
                contactNameAndTitle,
                createdAt,
                customerSupportEmail,
                customerSupportPhoneNumber,
                description,
                displayName,
                entityType,
                helpMessage,
                officialAddress,
                optInProcessDescription,
                phoneNumber,
                privacyPolicyUrl,
                reason,
                reasonCode,
                (sampleMessages ?: JsonMissing.of()).map { it.toImmutable() },
                startMessage,
                status,
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
    fun validate(): RcsAgent = apply {
        if (validated) {
            return@apply
        }

        id()
        agentUseCase()
        brandColor()
        brandEmail()
        brandName()
        brandPhoneNumber()
        briefCompanyDescription()
        companyEin()
        contactNameAndTitle()
        createdAt()
        customerSupportEmail()
        customerSupportPhoneNumber()
        description()
        displayName()
        entityType()
        helpMessage()
        officialAddress().ifPresent { it.validate() }
        optInProcessDescription()
        phoneNumber()
        privacyPolicyUrl()
        reason()
        reasonCode()
        sampleMessages()
        startMessage()
        status().ifPresent { it.validate() }
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (agentUseCase.asKnown().isPresent) 1 else 0) +
            (if (brandColor.asKnown().isPresent) 1 else 0) +
            (if (brandEmail.asKnown().isPresent) 1 else 0) +
            (if (brandName.asKnown().isPresent) 1 else 0) +
            (if (brandPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (briefCompanyDescription.asKnown().isPresent) 1 else 0) +
            (if (companyEin.asKnown().isPresent) 1 else 0) +
            (if (contactNameAndTitle.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customerSupportEmail.asKnown().isPresent) 1 else 0) +
            (if (customerSupportPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (displayName.asKnown().isPresent) 1 else 0) +
            (if (entityType.asKnown().isPresent) 1 else 0) +
            (if (helpMessage.asKnown().isPresent) 1 else 0) +
            (officialAddress.asKnown().getOrNull()?.validity() ?: 0) +
            (if (optInProcessDescription.asKnown().isPresent) 1 else 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (privacyPolicyUrl.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (reasonCode.asKnown().isPresent) 1 else 0) +
            (sampleMessages.asKnown().getOrNull()?.size ?: 0) +
            (if (startMessage.asKnown().isPresent) 1 else 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (stopMessage.asKnown().isPresent) 1 else 0) +
            (if (termsAndConditionsUrl.asKnown().isPresent) 1 else 0) +
            (if (websiteUrl.asKnown().isPresent) 1 else 0)

    /**
     * Where the agent stands, in terms of who is holding it up — PROVISIONING, ACTION_NEEDED,
     * PENDING_REVIEW or ACTIVE.
     *
     * Resolved from both of the provider's axes rather than reported raw: an agent whose
     * resubmission we have asked for reads ACTION_NEEDED however its carrier status still reads,
     * and an agent not yet handed over reads PROVISIONING rather than pending a review nobody has
     * started.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PROVISIONING = of("PROVISIONING")

            @JvmField val ACTION_NEEDED = of("ACTION_NEEDED")

            @JvmField val PENDING_REVIEW = of("PENDING_REVIEW")

            @JvmField val ACTIVE = of("ACTIVE")

            @JvmField val INACTIVE = of("INACTIVE")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PROVISIONING,
            ACTION_NEEDED,
            PENDING_REVIEW,
            ACTIVE,
            INACTIVE,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PROVISIONING,
            ACTION_NEEDED,
            PENDING_REVIEW,
            ACTIVE,
            INACTIVE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                PROVISIONING -> Value.PROVISIONING
                ACTION_NEEDED -> Value.ACTION_NEEDED
                PENDING_REVIEW -> Value.PENDING_REVIEW
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
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
                PROVISIONING -> Known.PROVISIONING
                ACTION_NEEDED -> Known.ACTION_NEEDED
                PENDING_REVIEW -> Known.PENDING_REVIEW
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                else -> throw SentInvalidDataException("Unknown Status: $value")
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
        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RcsAgent &&
            id == other.id &&
            agentUseCase == other.agentUseCase &&
            brandColor == other.brandColor &&
            brandEmail == other.brandEmail &&
            brandName == other.brandName &&
            brandPhoneNumber == other.brandPhoneNumber &&
            briefCompanyDescription == other.briefCompanyDescription &&
            companyEin == other.companyEin &&
            contactNameAndTitle == other.contactNameAndTitle &&
            createdAt == other.createdAt &&
            customerSupportEmail == other.customerSupportEmail &&
            customerSupportPhoneNumber == other.customerSupportPhoneNumber &&
            description == other.description &&
            displayName == other.displayName &&
            entityType == other.entityType &&
            helpMessage == other.helpMessage &&
            officialAddress == other.officialAddress &&
            optInProcessDescription == other.optInProcessDescription &&
            phoneNumber == other.phoneNumber &&
            privacyPolicyUrl == other.privacyPolicyUrl &&
            reason == other.reason &&
            reasonCode == other.reasonCode &&
            sampleMessages == other.sampleMessages &&
            startMessage == other.startMessage &&
            status == other.status &&
            stopMessage == other.stopMessage &&
            termsAndConditionsUrl == other.termsAndConditionsUrl &&
            websiteUrl == other.websiteUrl &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            agentUseCase,
            brandColor,
            brandEmail,
            brandName,
            brandPhoneNumber,
            briefCompanyDescription,
            companyEin,
            contactNameAndTitle,
            createdAt,
            customerSupportEmail,
            customerSupportPhoneNumber,
            description,
            displayName,
            entityType,
            helpMessage,
            officialAddress,
            optInProcessDescription,
            phoneNumber,
            privacyPolicyUrl,
            reason,
            reasonCode,
            sampleMessages,
            startMessage,
            status,
            stopMessage,
            termsAndConditionsUrl,
            websiteUrl,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RcsAgent{id=$id, agentUseCase=$agentUseCase, brandColor=$brandColor, brandEmail=$brandEmail, brandName=$brandName, brandPhoneNumber=$brandPhoneNumber, briefCompanyDescription=$briefCompanyDescription, companyEin=$companyEin, contactNameAndTitle=$contactNameAndTitle, createdAt=$createdAt, customerSupportEmail=$customerSupportEmail, customerSupportPhoneNumber=$customerSupportPhoneNumber, description=$description, displayName=$displayName, entityType=$entityType, helpMessage=$helpMessage, officialAddress=$officialAddress, optInProcessDescription=$optInProcessDescription, phoneNumber=$phoneNumber, privacyPolicyUrl=$privacyPolicyUrl, reason=$reason, reasonCode=$reasonCode, sampleMessages=$sampleMessages, startMessage=$startMessage, status=$status, stopMessage=$stopMessage, termsAndConditionsUrl=$termsAndConditionsUrl, websiteUrl=$websiteUrl, additionalProperties=$additionalProperties}"
}
