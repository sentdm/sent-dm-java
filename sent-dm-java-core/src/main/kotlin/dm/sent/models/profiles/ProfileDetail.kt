// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentDmInvalidDataException
import dm.sent.models.brands.BrandWithKyc
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Detailed profile response for v3 API */
class ProfileDetail
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val allowContactSharing: JsonField<Boolean>,
    private val allowNumberChangeDuringOnboarding: JsonField<Boolean>,
    private val allowTemplateSharing: JsonField<Boolean>,
    private val billingContact: JsonField<BillingContact>,
    private val billingModel: JsonField<String>,
    private val brand: JsonField<BrandWithKyc>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val description: JsonField<String>,
    private val email: JsonField<String>,
    private val icon: JsonField<String>,
    private val inheritContacts: JsonField<Boolean>,
    private val inheritTcrBrand: JsonField<Boolean>,
    private val inheritTcrCampaign: JsonField<Boolean>,
    private val inheritTemplates: JsonField<Boolean>,
    private val name: JsonField<String>,
    private val organizationId: JsonField<String>,
    private val sendingPhoneNumber: JsonField<String>,
    private val sendingPhoneNumberProfileId: JsonField<String>,
    private val sendingWhatsappNumberProfileId: JsonField<String>,
    private val shortName: JsonField<String>,
    private val status: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val wabaId: JsonField<String>,
    private val whatsappPhoneNumber: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("allow_contact_sharing")
        @ExcludeMissing
        allowContactSharing: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("allow_number_change_during_onboarding")
        @ExcludeMissing
        allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("allow_template_sharing")
        @ExcludeMissing
        allowTemplateSharing: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("billing_contact")
        @ExcludeMissing
        billingContact: JsonField<BillingContact> = JsonMissing.of(),
        @JsonProperty("billing_model")
        @ExcludeMissing
        billingModel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("brand") @ExcludeMissing brand: JsonField<BrandWithKyc> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("icon") @ExcludeMissing icon: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inherit_contacts")
        @ExcludeMissing
        inheritContacts: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inherit_tcr_brand")
        @ExcludeMissing
        inheritTcrBrand: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inherit_tcr_campaign")
        @ExcludeMissing
        inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("inherit_templates")
        @ExcludeMissing
        inheritTemplates: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("organization_id")
        @ExcludeMissing
        organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sending_phone_number")
        @ExcludeMissing
        sendingPhoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sending_phone_number_profile_id")
        @ExcludeMissing
        sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sending_whatsapp_number_profile_id")
        @ExcludeMissing
        sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("short_name") @ExcludeMissing shortName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("waba_id") @ExcludeMissing wabaId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("whatsapp_phone_number")
        @ExcludeMissing
        whatsappPhoneNumber: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        allowContactSharing,
        allowNumberChangeDuringOnboarding,
        allowTemplateSharing,
        billingContact,
        billingModel,
        brand,
        createdAt,
        description,
        email,
        icon,
        inheritContacts,
        inheritTcrBrand,
        inheritTcrCampaign,
        inheritTemplates,
        name,
        organizationId,
        sendingPhoneNumber,
        sendingPhoneNumberProfileId,
        sendingWhatsappNumberProfileId,
        shortName,
        status,
        updatedAt,
        wabaId,
        whatsappPhoneNumber,
        mutableMapOf(),
    )

    /**
     * Profile unique identifier
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Whether contacts are shared across profiles in the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowContactSharing(): Optional<Boolean> =
        allowContactSharing.getOptional("allow_contact_sharing")

    /**
     * Whether number changes are allowed during onboarding
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowNumberChangeDuringOnboarding(): Optional<Boolean> =
        allowNumberChangeDuringOnboarding.getOptional("allow_number_change_during_onboarding")

    /**
     * Whether templates are shared across profiles in the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowTemplateSharing(): Optional<Boolean> =
        allowTemplateSharing.getOptional("allow_template_sharing")

    /**
     * Billing contact for this profile. Present when billing_model is "profile" or
     * "profile_and_organization".
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun billingContact(): Optional<BillingContact> = billingContact.getOptional("billing_contact")

    /**
     * Billing model: profile, organization, or profile_and_organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun billingModel(): Optional<String> = billingModel.getOptional("billing_model")

    /**
     * Brand associated with this profile. Null if no brand has been configured yet. Includes KYC
     * information and TCR registration status.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun brand(): Optional<BrandWithKyc> = brand.getOptional("brand")

    /**
     * When the profile was created
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Profile description
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Profile email (inherited from organization)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * Profile icon URL
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun icon(): Optional<String> = icon.getOptional("icon")

    /**
     * Whether this profile inherits contacts from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritContacts(): Optional<Boolean> = inheritContacts.getOptional("inherit_contacts")

    /**
     * Whether this profile inherits TCR brand from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrBrand(): Optional<Boolean> = inheritTcrBrand.getOptional("inherit_tcr_brand")

    /**
     * Whether this profile inherits TCR campaign from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrCampaign(): Optional<Boolean> =
        inheritTcrCampaign.getOptional("inherit_tcr_campaign")

    /**
     * Whether this profile inherits templates from the organization
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTemplates(): Optional<Boolean> = inheritTemplates.getOptional("inherit_templates")

    /**
     * Profile name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Parent organization ID
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = organizationId.getOptional("organization_id")

    /**
     * Direct SMS phone number
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sendingPhoneNumber(): Optional<String> =
        sendingPhoneNumber.getOptional("sending_phone_number")

    /**
     * Reference to another profile for SMS/Telnyx configuration
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sendingPhoneNumberProfileId(): Optional<String> =
        sendingPhoneNumberProfileId.getOptional("sending_phone_number_profile_id")

    /**
     * Reference to another profile for WhatsApp configuration
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sendingWhatsappNumberProfileId(): Optional<String> =
        sendingWhatsappNumberProfileId.getOptional("sending_whatsapp_number_profile_id")

    /**
     * Profile short name/abbreviation. 3–11 characters: letters, numbers, and spaces only, with at
     * least one letter.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shortName(): Optional<String> = shortName.getOptional("short_name")

    /**
     * Profile setup status: incomplete, pending_review, approved, rejected
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * When the profile was last updated
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

    /**
     * WhatsApp Business Account ID associated with this profile. Present whether the WABA is
     * inherited from the organization or configured directly.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun wabaId(): Optional<String> = wabaId.getOptional("waba_id")

    /**
     * Direct WhatsApp phone number
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun whatsappPhoneNumber(): Optional<String> =
        whatsappPhoneNumber.getOptional("whatsapp_phone_number")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [allowContactSharing].
     *
     * Unlike [allowContactSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allow_contact_sharing")
    @ExcludeMissing
    fun _allowContactSharing(): JsonField<Boolean> = allowContactSharing

    /**
     * Returns the raw JSON value of [allowNumberChangeDuringOnboarding].
     *
     * Unlike [allowNumberChangeDuringOnboarding], this method doesn't throw if the JSON field has
     * an unexpected type.
     */
    @JsonProperty("allow_number_change_during_onboarding")
    @ExcludeMissing
    fun _allowNumberChangeDuringOnboarding(): JsonField<Boolean> = allowNumberChangeDuringOnboarding

    /**
     * Returns the raw JSON value of [allowTemplateSharing].
     *
     * Unlike [allowTemplateSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allow_template_sharing")
    @ExcludeMissing
    fun _allowTemplateSharing(): JsonField<Boolean> = allowTemplateSharing

    /**
     * Returns the raw JSON value of [billingContact].
     *
     * Unlike [billingContact], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing_contact")
    @ExcludeMissing
    fun _billingContact(): JsonField<BillingContact> = billingContact

    /**
     * Returns the raw JSON value of [billingModel].
     *
     * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billing_model")
    @ExcludeMissing
    fun _billingModel(): JsonField<String> = billingModel

    /**
     * Returns the raw JSON value of [brand].
     *
     * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<BrandWithKyc> = brand

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [icon].
     *
     * Unlike [icon], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("icon") @ExcludeMissing fun _icon(): JsonField<String> = icon

    /**
     * Returns the raw JSON value of [inheritContacts].
     *
     * Unlike [inheritContacts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inherit_contacts")
    @ExcludeMissing
    fun _inheritContacts(): JsonField<Boolean> = inheritContacts

    /**
     * Returns the raw JSON value of [inheritTcrBrand].
     *
     * Unlike [inheritTcrBrand], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inherit_tcr_brand")
    @ExcludeMissing
    fun _inheritTcrBrand(): JsonField<Boolean> = inheritTcrBrand

    /**
     * Returns the raw JSON value of [inheritTcrCampaign].
     *
     * Unlike [inheritTcrCampaign], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("inherit_tcr_campaign")
    @ExcludeMissing
    fun _inheritTcrCampaign(): JsonField<Boolean> = inheritTcrCampaign

    /**
     * Returns the raw JSON value of [inheritTemplates].
     *
     * Unlike [inheritTemplates], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("inherit_templates")
    @ExcludeMissing
    fun _inheritTemplates(): JsonField<Boolean> = inheritTemplates

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("organization_id")
    @ExcludeMissing
    fun _organizationId(): JsonField<String> = organizationId

    /**
     * Returns the raw JSON value of [sendingPhoneNumber].
     *
     * Unlike [sendingPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("sending_phone_number")
    @ExcludeMissing
    fun _sendingPhoneNumber(): JsonField<String> = sendingPhoneNumber

    /**
     * Returns the raw JSON value of [sendingPhoneNumberProfileId].
     *
     * Unlike [sendingPhoneNumberProfileId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("sending_phone_number_profile_id")
    @ExcludeMissing
    fun _sendingPhoneNumberProfileId(): JsonField<String> = sendingPhoneNumberProfileId

    /**
     * Returns the raw JSON value of [sendingWhatsappNumberProfileId].
     *
     * Unlike [sendingWhatsappNumberProfileId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("sending_whatsapp_number_profile_id")
    @ExcludeMissing
    fun _sendingWhatsappNumberProfileId(): JsonField<String> = sendingWhatsappNumberProfileId

    /**
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("short_name") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

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
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [wabaId].
     *
     * Unlike [wabaId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("waba_id") @ExcludeMissing fun _wabaId(): JsonField<String> = wabaId

    /**
     * Returns the raw JSON value of [whatsappPhoneNumber].
     *
     * Unlike [whatsappPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("whatsapp_phone_number")
    @ExcludeMissing
    fun _whatsappPhoneNumber(): JsonField<String> = whatsappPhoneNumber

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

        /** Returns a mutable builder for constructing an instance of [ProfileDetail]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProfileDetail]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var allowContactSharing: JsonField<Boolean> = JsonMissing.of()
        private var allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of()
        private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
        private var billingContact: JsonField<BillingContact> = JsonMissing.of()
        private var billingModel: JsonField<String> = JsonMissing.of()
        private var brand: JsonField<BrandWithKyc> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var icon: JsonField<String> = JsonMissing.of()
        private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
        private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
        private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
        private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var organizationId: JsonField<String> = JsonMissing.of()
        private var sendingPhoneNumber: JsonField<String> = JsonMissing.of()
        private var sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of()
        private var sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of()
        private var shortName: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var wabaId: JsonField<String> = JsonMissing.of()
        private var whatsappPhoneNumber: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(profileDetail: ProfileDetail) = apply {
            id = profileDetail.id
            allowContactSharing = profileDetail.allowContactSharing
            allowNumberChangeDuringOnboarding = profileDetail.allowNumberChangeDuringOnboarding
            allowTemplateSharing = profileDetail.allowTemplateSharing
            billingContact = profileDetail.billingContact
            billingModel = profileDetail.billingModel
            brand = profileDetail.brand
            createdAt = profileDetail.createdAt
            description = profileDetail.description
            email = profileDetail.email
            icon = profileDetail.icon
            inheritContacts = profileDetail.inheritContacts
            inheritTcrBrand = profileDetail.inheritTcrBrand
            inheritTcrCampaign = profileDetail.inheritTcrCampaign
            inheritTemplates = profileDetail.inheritTemplates
            name = profileDetail.name
            organizationId = profileDetail.organizationId
            sendingPhoneNumber = profileDetail.sendingPhoneNumber
            sendingPhoneNumberProfileId = profileDetail.sendingPhoneNumberProfileId
            sendingWhatsappNumberProfileId = profileDetail.sendingWhatsappNumberProfileId
            shortName = profileDetail.shortName
            status = profileDetail.status
            updatedAt = profileDetail.updatedAt
            wabaId = profileDetail.wabaId
            whatsappPhoneNumber = profileDetail.whatsappPhoneNumber
            additionalProperties = profileDetail.additionalProperties.toMutableMap()
        }

        /** Profile unique identifier */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Whether contacts are shared across profiles in the organization */
        fun allowContactSharing(allowContactSharing: Boolean) =
            allowContactSharing(JsonField.of(allowContactSharing))

        /**
         * Sets [Builder.allowContactSharing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowContactSharing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowContactSharing(allowContactSharing: JsonField<Boolean>) = apply {
            this.allowContactSharing = allowContactSharing
        }

        /** Whether number changes are allowed during onboarding */
        fun allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding: Boolean?) =
            allowNumberChangeDuringOnboarding(
                JsonField.ofNullable(allowNumberChangeDuringOnboarding)
            )

        /**
         * Alias for [Builder.allowNumberChangeDuringOnboarding].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding: Boolean) =
            allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding as Boolean?)

        /**
         * Alias for calling [Builder.allowNumberChangeDuringOnboarding] with
         * `allowNumberChangeDuringOnboarding.orElse(null)`.
         */
        fun allowNumberChangeDuringOnboarding(
            allowNumberChangeDuringOnboarding: Optional<Boolean>
        ) = allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding.getOrNull())

        /**
         * Sets [Builder.allowNumberChangeDuringOnboarding] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowNumberChangeDuringOnboarding] with a well-typed
         * [Boolean] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun allowNumberChangeDuringOnboarding(
            allowNumberChangeDuringOnboarding: JsonField<Boolean>
        ) = apply { this.allowNumberChangeDuringOnboarding = allowNumberChangeDuringOnboarding }

        /** Whether templates are shared across profiles in the organization */
        fun allowTemplateSharing(allowTemplateSharing: Boolean) =
            allowTemplateSharing(JsonField.of(allowTemplateSharing))

        /**
         * Sets [Builder.allowTemplateSharing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowTemplateSharing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowTemplateSharing(allowTemplateSharing: JsonField<Boolean>) = apply {
            this.allowTemplateSharing = allowTemplateSharing
        }

        /**
         * Billing contact for this profile. Present when billing_model is "profile" or
         * "profile_and_organization".
         */
        fun billingContact(billingContact: BillingContact?) =
            billingContact(JsonField.ofNullable(billingContact))

        /** Alias for calling [Builder.billingContact] with `billingContact.orElse(null)`. */
        fun billingContact(billingContact: Optional<BillingContact>) =
            billingContact(billingContact.getOrNull())

        /**
         * Sets [Builder.billingContact] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billingContact] with a well-typed [BillingContact] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun billingContact(billingContact: JsonField<BillingContact>) = apply {
            this.billingContact = billingContact
        }

        /** Billing model: profile, organization, or profile_and_organization */
        fun billingModel(billingModel: String) = billingModel(JsonField.of(billingModel))

        /**
         * Sets [Builder.billingModel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billingModel] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billingModel(billingModel: JsonField<String>) = apply {
            this.billingModel = billingModel
        }

        /**
         * Brand associated with this profile. Null if no brand has been configured yet. Includes
         * KYC information and TCR registration status.
         */
        fun brand(brand: BrandWithKyc?) = brand(JsonField.ofNullable(brand))

        /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
        fun brand(brand: Optional<BrandWithKyc>) = brand(brand.getOrNull())

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [BrandWithKyc] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun brand(brand: JsonField<BrandWithKyc>) = apply { this.brand = brand }

        /** When the profile was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** Profile description */
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

        /** Profile email (inherited from organization) */
        fun email(email: String?) = email(JsonField.ofNullable(email))

        /** Alias for calling [Builder.email] with `email.orElse(null)`. */
        fun email(email: Optional<String>) = email(email.getOrNull())

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** Profile icon URL */
        fun icon(icon: String?) = icon(JsonField.ofNullable(icon))

        /** Alias for calling [Builder.icon] with `icon.orElse(null)`. */
        fun icon(icon: Optional<String>) = icon(icon.getOrNull())

        /**
         * Sets [Builder.icon] to an arbitrary JSON value.
         *
         * You should usually call [Builder.icon] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun icon(icon: JsonField<String>) = apply { this.icon = icon }

        /** Whether this profile inherits contacts from the organization */
        fun inheritContacts(inheritContacts: Boolean) =
            inheritContacts(JsonField.of(inheritContacts))

        /**
         * Sets [Builder.inheritContacts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritContacts] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritContacts(inheritContacts: JsonField<Boolean>) = apply {
            this.inheritContacts = inheritContacts
        }

        /** Whether this profile inherits TCR brand from the organization */
        fun inheritTcrBrand(inheritTcrBrand: Boolean) =
            inheritTcrBrand(JsonField.of(inheritTcrBrand))

        /**
         * Sets [Builder.inheritTcrBrand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTcrBrand] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTcrBrand(inheritTcrBrand: JsonField<Boolean>) = apply {
            this.inheritTcrBrand = inheritTcrBrand
        }

        /** Whether this profile inherits TCR campaign from the organization */
        fun inheritTcrCampaign(inheritTcrCampaign: Boolean) =
            inheritTcrCampaign(JsonField.of(inheritTcrCampaign))

        /**
         * Sets [Builder.inheritTcrCampaign] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTcrCampaign] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: JsonField<Boolean>) = apply {
            this.inheritTcrCampaign = inheritTcrCampaign
        }

        /** Whether this profile inherits templates from the organization */
        fun inheritTemplates(inheritTemplates: Boolean) =
            inheritTemplates(JsonField.of(inheritTemplates))

        /**
         * Sets [Builder.inheritTemplates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTemplates] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTemplates(inheritTemplates: JsonField<Boolean>) = apply {
            this.inheritTemplates = inheritTemplates
        }

        /** Profile name */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Parent organization ID */
        fun organizationId(organizationId: String?) =
            organizationId(JsonField.ofNullable(organizationId))

        /** Alias for calling [Builder.organizationId] with `organizationId.orElse(null)`. */
        fun organizationId(organizationId: Optional<String>) =
            organizationId(organizationId.getOrNull())

        /**
         * Sets [Builder.organizationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun organizationId(organizationId: JsonField<String>) = apply {
            this.organizationId = organizationId
        }

        /** Direct SMS phone number */
        fun sendingPhoneNumber(sendingPhoneNumber: String?) =
            sendingPhoneNumber(JsonField.ofNullable(sendingPhoneNumber))

        /**
         * Alias for calling [Builder.sendingPhoneNumber] with `sendingPhoneNumber.orElse(null)`.
         */
        fun sendingPhoneNumber(sendingPhoneNumber: Optional<String>) =
            sendingPhoneNumber(sendingPhoneNumber.getOrNull())

        /**
         * Sets [Builder.sendingPhoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendingPhoneNumber] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sendingPhoneNumber(sendingPhoneNumber: JsonField<String>) = apply {
            this.sendingPhoneNumber = sendingPhoneNumber
        }

        /** Reference to another profile for SMS/Telnyx configuration */
        fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: String?) =
            sendingPhoneNumberProfileId(JsonField.ofNullable(sendingPhoneNumberProfileId))

        /**
         * Alias for calling [Builder.sendingPhoneNumberProfileId] with
         * `sendingPhoneNumberProfileId.orElse(null)`.
         */
        fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: Optional<String>) =
            sendingPhoneNumberProfileId(sendingPhoneNumberProfileId.getOrNull())

        /**
         * Sets [Builder.sendingPhoneNumberProfileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendingPhoneNumberProfileId] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: JsonField<String>) = apply {
            this.sendingPhoneNumberProfileId = sendingPhoneNumberProfileId
        }

        /** Reference to another profile for WhatsApp configuration */
        fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: String?) =
            sendingWhatsappNumberProfileId(JsonField.ofNullable(sendingWhatsappNumberProfileId))

        /**
         * Alias for calling [Builder.sendingWhatsappNumberProfileId] with
         * `sendingWhatsappNumberProfileId.orElse(null)`.
         */
        fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: Optional<String>) =
            sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId.getOrNull())

        /**
         * Sets [Builder.sendingWhatsappNumberProfileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sendingWhatsappNumberProfileId] with a well-typed
         * [String] value instead. This method is primarily for setting the field to an undocumented
         * or not yet supported value.
         */
        fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: JsonField<String>) =
            apply {
                this.sendingWhatsappNumberProfileId = sendingWhatsappNumberProfileId
            }

        /**
         * Profile short name/abbreviation. 3–11 characters: letters, numbers, and spaces only, with
         * at least one letter.
         */
        fun shortName(shortName: String?) = shortName(JsonField.ofNullable(shortName))

        /** Alias for calling [Builder.shortName] with `shortName.orElse(null)`. */
        fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

        /**
         * Sets [Builder.shortName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shortName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

        /** Profile setup status: incomplete, pending_review, approved, rejected */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** When the profile was last updated */
        fun updatedAt(updatedAt: OffsetDateTime?) = updatedAt(JsonField.ofNullable(updatedAt))

        /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
        fun updatedAt(updatedAt: Optional<OffsetDateTime>) = updatedAt(updatedAt.getOrNull())

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /**
         * WhatsApp Business Account ID associated with this profile. Present whether the WABA is
         * inherited from the organization or configured directly.
         */
        fun wabaId(wabaId: String?) = wabaId(JsonField.ofNullable(wabaId))

        /** Alias for calling [Builder.wabaId] with `wabaId.orElse(null)`. */
        fun wabaId(wabaId: Optional<String>) = wabaId(wabaId.getOrNull())

        /**
         * Sets [Builder.wabaId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.wabaId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun wabaId(wabaId: JsonField<String>) = apply { this.wabaId = wabaId }

        /** Direct WhatsApp phone number */
        fun whatsappPhoneNumber(whatsappPhoneNumber: String?) =
            whatsappPhoneNumber(JsonField.ofNullable(whatsappPhoneNumber))

        /**
         * Alias for calling [Builder.whatsappPhoneNumber] with `whatsappPhoneNumber.orElse(null)`.
         */
        fun whatsappPhoneNumber(whatsappPhoneNumber: Optional<String>) =
            whatsappPhoneNumber(whatsappPhoneNumber.getOrNull())

        /**
         * Sets [Builder.whatsappPhoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsappPhoneNumber] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun whatsappPhoneNumber(whatsappPhoneNumber: JsonField<String>) = apply {
            this.whatsappPhoneNumber = whatsappPhoneNumber
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
         * Returns an immutable instance of [ProfileDetail].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ProfileDetail =
            ProfileDetail(
                id,
                allowContactSharing,
                allowNumberChangeDuringOnboarding,
                allowTemplateSharing,
                billingContact,
                billingModel,
                brand,
                createdAt,
                description,
                email,
                icon,
                inheritContacts,
                inheritTcrBrand,
                inheritTcrCampaign,
                inheritTemplates,
                name,
                organizationId,
                sendingPhoneNumber,
                sendingPhoneNumberProfileId,
                sendingWhatsappNumberProfileId,
                shortName,
                status,
                updatedAt,
                wabaId,
                whatsappPhoneNumber,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ProfileDetail = apply {
        if (validated) {
            return@apply
        }

        id()
        allowContactSharing()
        allowNumberChangeDuringOnboarding()
        allowTemplateSharing()
        billingContact().ifPresent { it.validate() }
        billingModel()
        brand().ifPresent { it.validate() }
        createdAt()
        description()
        email()
        icon()
        inheritContacts()
        inheritTcrBrand()
        inheritTcrCampaign()
        inheritTemplates()
        name()
        organizationId()
        sendingPhoneNumber()
        sendingPhoneNumberProfileId()
        sendingWhatsappNumberProfileId()
        shortName()
        status()
        updatedAt()
        wabaId()
        whatsappPhoneNumber()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: SentDmInvalidDataException) {
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
            (if (allowContactSharing.asKnown().isPresent) 1 else 0) +
            (if (allowNumberChangeDuringOnboarding.asKnown().isPresent) 1 else 0) +
            (if (allowTemplateSharing.asKnown().isPresent) 1 else 0) +
            (billingContact.asKnown().getOrNull()?.validity() ?: 0) +
            (if (billingModel.asKnown().isPresent) 1 else 0) +
            (brand.asKnown().getOrNull()?.validity() ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (icon.asKnown().isPresent) 1 else 0) +
            (if (inheritContacts.asKnown().isPresent) 1 else 0) +
            (if (inheritTcrBrand.asKnown().isPresent) 1 else 0) +
            (if (inheritTcrCampaign.asKnown().isPresent) 1 else 0) +
            (if (inheritTemplates.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (organizationId.asKnown().isPresent) 1 else 0) +
            (if (sendingPhoneNumber.asKnown().isPresent) 1 else 0) +
            (if (sendingPhoneNumberProfileId.asKnown().isPresent) 1 else 0) +
            (if (sendingWhatsappNumberProfileId.asKnown().isPresent) 1 else 0) +
            (if (shortName.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (wabaId.asKnown().isPresent) 1 else 0) +
            (if (whatsappPhoneNumber.asKnown().isPresent) 1 else 0)

    /**
     * Billing contact for this profile. Present when billing_model is "profile" or
     * "profile_and_organization".
     */
    class BillingContact
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val address: JsonField<String>,
        private val email: JsonField<String>,
        private val name: JsonField<String>,
        private val phone: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
        ) : this(address, email, name, phone, mutableMapOf())

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun address(): Optional<String> = address.getOptional("address")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phone(): Optional<String> = phone.getOptional("phone")

        /**
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [phone].
         *
         * Unlike [phone], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

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

            /** Returns a mutable builder for constructing an instance of [BillingContact]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BillingContact]. */
        class Builder internal constructor() {

            private var address: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var phone: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(billingContact: BillingContact) = apply {
                address = billingContact.address
                email = billingContact.email
                name = billingContact.name
                phone = billingContact.phone
                additionalProperties = billingContact.additionalProperties.toMutableMap()
            }

            fun address(address: String?) = address(JsonField.ofNullable(address))

            /** Alias for calling [Builder.address] with `address.orElse(null)`. */
            fun address(address: Optional<String>) = address(address.getOrNull())

            /**
             * Sets [Builder.address] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address(address: JsonField<String>) = apply { this.address = address }

            fun email(email: String?) = email(JsonField.ofNullable(email))

            /** Alias for calling [Builder.email] with `email.orElse(null)`. */
            fun email(email: Optional<String>) = email(email.getOrNull())

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun phone(phone: String?) = phone(JsonField.ofNullable(phone))

            /** Alias for calling [Builder.phone] with `phone.orElse(null)`. */
            fun phone(phone: Optional<String>) = phone(phone.getOrNull())

            /**
             * Sets [Builder.phone] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phone] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phone(phone: JsonField<String>) = apply { this.phone = phone }

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
             * Returns an immutable instance of [BillingContact].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): BillingContact =
                BillingContact(address, email, name, phone, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): BillingContact = apply {
            if (validated) {
                return@apply
            }

            address()
            email()
            name()
            phone()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: SentDmInvalidDataException) {
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
            (if (address.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (phone.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BillingContact &&
                address == other.address &&
                email == other.email &&
                name == other.name &&
                phone == other.phone &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(address, email, name, phone, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BillingContact{address=$address, email=$email, name=$name, phone=$phone, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileDetail &&
            id == other.id &&
            allowContactSharing == other.allowContactSharing &&
            allowNumberChangeDuringOnboarding == other.allowNumberChangeDuringOnboarding &&
            allowTemplateSharing == other.allowTemplateSharing &&
            billingContact == other.billingContact &&
            billingModel == other.billingModel &&
            brand == other.brand &&
            createdAt == other.createdAt &&
            description == other.description &&
            email == other.email &&
            icon == other.icon &&
            inheritContacts == other.inheritContacts &&
            inheritTcrBrand == other.inheritTcrBrand &&
            inheritTcrCampaign == other.inheritTcrCampaign &&
            inheritTemplates == other.inheritTemplates &&
            name == other.name &&
            organizationId == other.organizationId &&
            sendingPhoneNumber == other.sendingPhoneNumber &&
            sendingPhoneNumberProfileId == other.sendingPhoneNumberProfileId &&
            sendingWhatsappNumberProfileId == other.sendingWhatsappNumberProfileId &&
            shortName == other.shortName &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            wabaId == other.wabaId &&
            whatsappPhoneNumber == other.whatsappPhoneNumber &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            allowContactSharing,
            allowNumberChangeDuringOnboarding,
            allowTemplateSharing,
            billingContact,
            billingModel,
            brand,
            createdAt,
            description,
            email,
            icon,
            inheritContacts,
            inheritTcrBrand,
            inheritTcrCampaign,
            inheritTemplates,
            name,
            organizationId,
            sendingPhoneNumber,
            sendingPhoneNumberProfileId,
            sendingWhatsappNumberProfileId,
            shortName,
            status,
            updatedAt,
            wabaId,
            whatsappPhoneNumber,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProfileDetail{id=$id, allowContactSharing=$allowContactSharing, allowNumberChangeDuringOnboarding=$allowNumberChangeDuringOnboarding, allowTemplateSharing=$allowTemplateSharing, billingContact=$billingContact, billingModel=$billingModel, brand=$brand, createdAt=$createdAt, description=$description, email=$email, icon=$icon, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, name=$name, organizationId=$organizationId, sendingPhoneNumber=$sendingPhoneNumber, sendingPhoneNumberProfileId=$sendingPhoneNumberProfileId, sendingWhatsappNumberProfileId=$sendingWhatsappNumberProfileId, shortName=$shortName, status=$status, updatedAt=$updatedAt, wabaId=$wabaId, whatsappPhoneNumber=$whatsappPhoneNumber, additionalProperties=$additionalProperties}"
}
