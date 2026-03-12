// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

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
import dm.sent.errors.SentDmInvalidDataException
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
    private val brand: JsonField<Brand>,
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
        @JsonProperty("brand") @ExcludeMissing brand: JsonField<Brand> = JsonMissing.of(),
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
     * Billing contact info returned in profile responses
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
     * Brand response with nested contact, business, and compliance sections — mirrors the request
     * structure.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun brand(): Optional<Brand> = brand.getOptional("brand")

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
    @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<Brand> = brand

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
        private var brand: JsonField<Brand> = JsonMissing.of()
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

        /** Billing contact info returned in profile responses */
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
         * Brand response with nested contact, business, and compliance sections — mirrors the
         * request structure.
         */
        fun brand(brand: Brand?) = brand(JsonField.ofNullable(brand))

        /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
        fun brand(brand: Optional<Brand>) = brand(brand.getOrNull())

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun brand(brand: JsonField<Brand>) = apply { this.brand = brand }

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

    /** Billing contact info returned in profile responses */
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

    /**
     * Brand response with nested contact, business, and compliance sections — mirrors the request
     * structure.
     */
    class Brand
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val business: JsonField<Business>,
        private val compliance: JsonField<Compliance>,
        private val contact: JsonField<Contact>,
        private val createdAt: JsonField<OffsetDateTime>,
        private val cspId: JsonField<String>,
        private val identityStatus: JsonField<IdentityStatus>,
        private val isInherited: JsonField<Boolean>,
        private val status: JsonField<Status>,
        private val submittedAt: JsonField<OffsetDateTime>,
        private val submittedToTcr: JsonField<Boolean>,
        private val tcrBrandId: JsonField<String>,
        private val universalEin: JsonField<String>,
        private val updatedAt: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("business")
            @ExcludeMissing
            business: JsonField<Business> = JsonMissing.of(),
            @JsonProperty("compliance")
            @ExcludeMissing
            compliance: JsonField<Compliance> = JsonMissing.of(),
            @JsonProperty("contact") @ExcludeMissing contact: JsonField<Contact> = JsonMissing.of(),
            @JsonProperty("created_at")
            @ExcludeMissing
            createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("csp_id") @ExcludeMissing cspId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("identity_status")
            @ExcludeMissing
            identityStatus: JsonField<IdentityStatus> = JsonMissing.of(),
            @JsonProperty("is_inherited")
            @ExcludeMissing
            isInherited: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
            @JsonProperty("submitted_at")
            @ExcludeMissing
            submittedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("submitted_to_tcr")
            @ExcludeMissing
            submittedToTcr: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("tcr_brand_id")
            @ExcludeMissing
            tcrBrandId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("universal_ein")
            @ExcludeMissing
            universalEin: JsonField<String> = JsonMissing.of(),
            @JsonProperty("updated_at")
            @ExcludeMissing
            updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(
            id,
            business,
            compliance,
            contact,
            createdAt,
            cspId,
            identityStatus,
            isInherited,
            status,
            submittedAt,
            submittedToTcr,
            tcrBrandId,
            universalEin,
            updatedAt,
            mutableMapOf(),
        )

        /**
         * Unique identifier for the brand
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Business details and address information
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun business(): Optional<Business> = business.getOptional("business")

        /**
         * Compliance and TCR-related information
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun compliance(): Optional<Compliance> = compliance.getOptional("compliance")

        /**
         * Contact information for the brand
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun contact(): Optional<Contact> = contact.getOptional("contact")

        /**
         * When the brand was created
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

        /**
         * CSP (Campaign Service Provider) ID
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cspId(): Optional<String> = cspId.getOptional("csp_id")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun identityStatus(): Optional<IdentityStatus> =
            identityStatus.getOptional("identity_status")

        /**
         * Whether this brand is inherited from the parent organization
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isInherited(): Optional<Boolean> = isInherited.getOptional("is_inherited")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * When the brand was submitted to TCR
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submittedAt(): Optional<OffsetDateTime> = submittedAt.getOptional("submitted_at")

        /**
         * Whether this brand has been submitted to TCR
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submittedToTcr(): Optional<Boolean> = submittedToTcr.getOptional("submitted_to_tcr")

        /**
         * TCR brand ID (populated after TCR submission)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tcrBrandId(): Optional<String> = tcrBrandId.getOptional("tcr_brand_id")

        /**
         * Universal EIN from TCR
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun universalEin(): Optional<String> = universalEin.getOptional("universal_ein")

        /**
         * When the brand was last updated
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [business].
         *
         * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("business") @ExcludeMissing fun _business(): JsonField<Business> = business

        /**
         * Returns the raw JSON value of [compliance].
         *
         * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("compliance")
        @ExcludeMissing
        fun _compliance(): JsonField<Compliance> = compliance

        /**
         * Returns the raw JSON value of [contact].
         *
         * Unlike [contact], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contact") @ExcludeMissing fun _contact(): JsonField<Contact> = contact

        /**
         * Returns the raw JSON value of [createdAt].
         *
         * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun _createdAt(): JsonField<OffsetDateTime> = createdAt

        /**
         * Returns the raw JSON value of [cspId].
         *
         * Unlike [cspId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("csp_id") @ExcludeMissing fun _cspId(): JsonField<String> = cspId

        /**
         * Returns the raw JSON value of [identityStatus].
         *
         * Unlike [identityStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("identity_status")
        @ExcludeMissing
        fun _identityStatus(): JsonField<IdentityStatus> = identityStatus

        /**
         * Returns the raw JSON value of [isInherited].
         *
         * Unlike [isInherited], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_inherited")
        @ExcludeMissing
        fun _isInherited(): JsonField<Boolean> = isInherited

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

        /**
         * Returns the raw JSON value of [submittedAt].
         *
         * Unlike [submittedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("submitted_at")
        @ExcludeMissing
        fun _submittedAt(): JsonField<OffsetDateTime> = submittedAt

        /**
         * Returns the raw JSON value of [submittedToTcr].
         *
         * Unlike [submittedToTcr], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("submitted_to_tcr")
        @ExcludeMissing
        fun _submittedToTcr(): JsonField<Boolean> = submittedToTcr

        /**
         * Returns the raw JSON value of [tcrBrandId].
         *
         * Unlike [tcrBrandId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tcr_brand_id")
        @ExcludeMissing
        fun _tcrBrandId(): JsonField<String> = tcrBrandId

        /**
         * Returns the raw JSON value of [universalEin].
         *
         * Unlike [universalEin], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("universal_ein")
        @ExcludeMissing
        fun _universalEin(): JsonField<String> = universalEin

        /**
         * Returns the raw JSON value of [updatedAt].
         *
         * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("updated_at")
        @ExcludeMissing
        fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

            /** Returns a mutable builder for constructing an instance of [Brand]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Brand]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var business: JsonField<Business> = JsonMissing.of()
            private var compliance: JsonField<Compliance> = JsonMissing.of()
            private var contact: JsonField<Contact> = JsonMissing.of()
            private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var cspId: JsonField<String> = JsonMissing.of()
            private var identityStatus: JsonField<IdentityStatus> = JsonMissing.of()
            private var isInherited: JsonField<Boolean> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var submittedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var submittedToTcr: JsonField<Boolean> = JsonMissing.of()
            private var tcrBrandId: JsonField<String> = JsonMissing.of()
            private var universalEin: JsonField<String> = JsonMissing.of()
            private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(brand: Brand) = apply {
                id = brand.id
                business = brand.business
                compliance = brand.compliance
                contact = brand.contact
                createdAt = brand.createdAt
                cspId = brand.cspId
                identityStatus = brand.identityStatus
                isInherited = brand.isInherited
                status = brand.status
                submittedAt = brand.submittedAt
                submittedToTcr = brand.submittedToTcr
                tcrBrandId = brand.tcrBrandId
                universalEin = brand.universalEin
                updatedAt = brand.updatedAt
                additionalProperties = brand.additionalProperties.toMutableMap()
            }

            /** Unique identifier for the brand */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Business details and address information */
            fun business(business: Business?) = business(JsonField.ofNullable(business))

            /** Alias for calling [Builder.business] with `business.orElse(null)`. */
            fun business(business: Optional<Business>) = business(business.getOrNull())

            /**
             * Sets [Builder.business] to an arbitrary JSON value.
             *
             * You should usually call [Builder.business] with a well-typed [Business] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun business(business: JsonField<Business>) = apply { this.business = business }

            /** Compliance and TCR-related information */
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
            fun compliance(compliance: JsonField<Compliance>) = apply {
                this.compliance = compliance
            }

            /** Contact information for the brand */
            fun contact(contact: Contact?) = contact(JsonField.ofNullable(contact))

            /** Alias for calling [Builder.contact] with `contact.orElse(null)`. */
            fun contact(contact: Optional<Contact>) = contact(contact.getOrNull())

            /**
             * Sets [Builder.contact] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contact] with a well-typed [Contact] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contact(contact: JsonField<Contact>) = apply { this.contact = contact }

            /** When the brand was created */
            fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

            /**
             * Sets [Builder.createdAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                this.createdAt = createdAt
            }

            /** CSP (Campaign Service Provider) ID */
            fun cspId(cspId: String?) = cspId(JsonField.ofNullable(cspId))

            /** Alias for calling [Builder.cspId] with `cspId.orElse(null)`. */
            fun cspId(cspId: Optional<String>) = cspId(cspId.getOrNull())

            /**
             * Sets [Builder.cspId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cspId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cspId(cspId: JsonField<String>) = apply { this.cspId = cspId }

            fun identityStatus(identityStatus: IdentityStatus?) =
                identityStatus(JsonField.ofNullable(identityStatus))

            /** Alias for calling [Builder.identityStatus] with `identityStatus.orElse(null)`. */
            fun identityStatus(identityStatus: Optional<IdentityStatus>) =
                identityStatus(identityStatus.getOrNull())

            /**
             * Sets [Builder.identityStatus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.identityStatus] with a well-typed [IdentityStatus]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun identityStatus(identityStatus: JsonField<IdentityStatus>) = apply {
                this.identityStatus = identityStatus
            }

            /** Whether this brand is inherited from the parent organization */
            fun isInherited(isInherited: Boolean) = isInherited(JsonField.of(isInherited))

            /**
             * Sets [Builder.isInherited] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isInherited] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isInherited(isInherited: JsonField<Boolean>) = apply {
                this.isInherited = isInherited
            }

            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

            /** When the brand was submitted to TCR */
            fun submittedAt(submittedAt: OffsetDateTime?) =
                submittedAt(JsonField.ofNullable(submittedAt))

            /** Alias for calling [Builder.submittedAt] with `submittedAt.orElse(null)`. */
            fun submittedAt(submittedAt: Optional<OffsetDateTime>) =
                submittedAt(submittedAt.getOrNull())

            /**
             * Sets [Builder.submittedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.submittedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun submittedAt(submittedAt: JsonField<OffsetDateTime>) = apply {
                this.submittedAt = submittedAt
            }

            /** Whether this brand has been submitted to TCR */
            fun submittedToTcr(submittedToTcr: Boolean) =
                submittedToTcr(JsonField.of(submittedToTcr))

            /**
             * Sets [Builder.submittedToTcr] to an arbitrary JSON value.
             *
             * You should usually call [Builder.submittedToTcr] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun submittedToTcr(submittedToTcr: JsonField<Boolean>) = apply {
                this.submittedToTcr = submittedToTcr
            }

            /** TCR brand ID (populated after TCR submission) */
            fun tcrBrandId(tcrBrandId: String?) = tcrBrandId(JsonField.ofNullable(tcrBrandId))

            /** Alias for calling [Builder.tcrBrandId] with `tcrBrandId.orElse(null)`. */
            fun tcrBrandId(tcrBrandId: Optional<String>) = tcrBrandId(tcrBrandId.getOrNull())

            /**
             * Sets [Builder.tcrBrandId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tcrBrandId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tcrBrandId(tcrBrandId: JsonField<String>) = apply { this.tcrBrandId = tcrBrandId }

            /** Universal EIN from TCR */
            fun universalEin(universalEin: String?) =
                universalEin(JsonField.ofNullable(universalEin))

            /** Alias for calling [Builder.universalEin] with `universalEin.orElse(null)`. */
            fun universalEin(universalEin: Optional<String>) =
                universalEin(universalEin.getOrNull())

            /**
             * Sets [Builder.universalEin] to an arbitrary JSON value.
             *
             * You should usually call [Builder.universalEin] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun universalEin(universalEin: JsonField<String>) = apply {
                this.universalEin = universalEin
            }

            /** When the brand was last updated */
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
            fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                this.updatedAt = updatedAt
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
             * Returns an immutable instance of [Brand].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Brand =
                Brand(
                    id,
                    business,
                    compliance,
                    contact,
                    createdAt,
                    cspId,
                    identityStatus,
                    isInherited,
                    status,
                    submittedAt,
                    submittedToTcr,
                    tcrBrandId,
                    universalEin,
                    updatedAt,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Brand = apply {
            if (validated) {
                return@apply
            }

            id()
            business().ifPresent { it.validate() }
            compliance().ifPresent { it.validate() }
            contact().ifPresent { it.validate() }
            createdAt()
            cspId()
            identityStatus().ifPresent { it.validate() }
            isInherited()
            status().ifPresent { it.validate() }
            submittedAt()
            submittedToTcr()
            tcrBrandId()
            universalEin()
            updatedAt()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (business.asKnown().getOrNull()?.validity() ?: 0) +
                (compliance.asKnown().getOrNull()?.validity() ?: 0) +
                (contact.asKnown().getOrNull()?.validity() ?: 0) +
                (if (createdAt.asKnown().isPresent) 1 else 0) +
                (if (cspId.asKnown().isPresent) 1 else 0) +
                (identityStatus.asKnown().getOrNull()?.validity() ?: 0) +
                (if (isInherited.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0) +
                (if (submittedAt.asKnown().isPresent) 1 else 0) +
                (if (submittedToTcr.asKnown().isPresent) 1 else 0) +
                (if (tcrBrandId.asKnown().isPresent) 1 else 0) +
                (if (universalEin.asKnown().isPresent) 1 else 0) +
                (if (updatedAt.asKnown().isPresent) 1 else 0)

        /** Business details and address information */
        class Business
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val city: JsonField<String>,
            private val country: JsonField<String>,
            private val countryOfRegistration: JsonField<String>,
            private val entityType: JsonField<String>,
            private val legalName: JsonField<String>,
            private val postalCode: JsonField<String>,
            private val state: JsonField<String>,
            private val street: JsonField<String>,
            private val taxId: JsonField<String>,
            private val taxIdType: JsonField<String>,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
                @JsonProperty("country")
                @ExcludeMissing
                country: JsonField<String> = JsonMissing.of(),
                @JsonProperty("country_of_registration")
                @ExcludeMissing
                countryOfRegistration: JsonField<String> = JsonMissing.of(),
                @JsonProperty("entity_type")
                @ExcludeMissing
                entityType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("legal_name")
                @ExcludeMissing
                legalName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("postal_code")
                @ExcludeMissing
                postalCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
                @JsonProperty("street")
                @ExcludeMissing
                street: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tax_id") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("tax_id_type")
                @ExcludeMissing
                taxIdType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(
                city,
                country,
                countryOfRegistration,
                entityType,
                legalName,
                postalCode,
                state,
                street,
                taxId,
                taxIdType,
                url,
                mutableMapOf(),
            )

            /**
             * City
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun city(): Optional<String> = city.getOptional("city")

            /**
             * Country code (e.g., US, CA)
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun country(): Optional<String> = country.getOptional("country")

            /**
             * Country where the business is registered
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun countryOfRegistration(): Optional<String> =
                countryOfRegistration.getOptional("country_of_registration")

            /**
             * Business entity type
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun entityType(): Optional<String> = entityType.getOptional("entity_type")

            /**
             * Legal business name
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun legalName(): Optional<String> = legalName.getOptional("legal_name")

            /**
             * Postal/ZIP code
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun postalCode(): Optional<String> = postalCode.getOptional("postal_code")

            /**
             * State/province code
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun state(): Optional<String> = state.getOptional("state")

            /**
             * Street address
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun street(): Optional<String> = street.getOptional("street")

            /**
             * Tax ID/EIN number
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun taxId(): Optional<String> = taxId.getOptional("tax_id")

            /**
             * Type of tax ID (e.g., us_ein, ca_bn)
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun taxIdType(): Optional<String> = taxIdType.getOptional("tax_id_type")

            /**
             * Business website URL
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * Returns the raw JSON value of [city].
             *
             * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

            /**
             * Returns the raw JSON value of [country].
             *
             * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

            /**
             * Returns the raw JSON value of [countryOfRegistration].
             *
             * Unlike [countryOfRegistration], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("country_of_registration")
            @ExcludeMissing
            fun _countryOfRegistration(): JsonField<String> = countryOfRegistration

            /**
             * Returns the raw JSON value of [entityType].
             *
             * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("entity_type")
            @ExcludeMissing
            fun _entityType(): JsonField<String> = entityType

            /**
             * Returns the raw JSON value of [legalName].
             *
             * Unlike [legalName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("legal_name")
            @ExcludeMissing
            fun _legalName(): JsonField<String> = legalName

            /**
             * Returns the raw JSON value of [postalCode].
             *
             * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("postal_code")
            @ExcludeMissing
            fun _postalCode(): JsonField<String> = postalCode

            /**
             * Returns the raw JSON value of [state].
             *
             * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

            /**
             * Returns the raw JSON value of [street].
             *
             * Unlike [street], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("street") @ExcludeMissing fun _street(): JsonField<String> = street

            /**
             * Returns the raw JSON value of [taxId].
             *
             * Unlike [taxId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("tax_id") @ExcludeMissing fun _taxId(): JsonField<String> = taxId

            /**
             * Returns the raw JSON value of [taxIdType].
             *
             * Unlike [taxIdType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("tax_id_type")
            @ExcludeMissing
            fun _taxIdType(): JsonField<String> = taxIdType

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

                /** Returns a mutable builder for constructing an instance of [Business]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Business]. */
            class Builder internal constructor() {

                private var city: JsonField<String> = JsonMissing.of()
                private var country: JsonField<String> = JsonMissing.of()
                private var countryOfRegistration: JsonField<String> = JsonMissing.of()
                private var entityType: JsonField<String> = JsonMissing.of()
                private var legalName: JsonField<String> = JsonMissing.of()
                private var postalCode: JsonField<String> = JsonMissing.of()
                private var state: JsonField<String> = JsonMissing.of()
                private var street: JsonField<String> = JsonMissing.of()
                private var taxId: JsonField<String> = JsonMissing.of()
                private var taxIdType: JsonField<String> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(business: Business) = apply {
                    city = business.city
                    country = business.country
                    countryOfRegistration = business.countryOfRegistration
                    entityType = business.entityType
                    legalName = business.legalName
                    postalCode = business.postalCode
                    state = business.state
                    street = business.street
                    taxId = business.taxId
                    taxIdType = business.taxIdType
                    url = business.url
                    additionalProperties = business.additionalProperties.toMutableMap()
                }

                /** City */
                fun city(city: String?) = city(JsonField.ofNullable(city))

                /** Alias for calling [Builder.city] with `city.orElse(null)`. */
                fun city(city: Optional<String>) = city(city.getOrNull())

                /**
                 * Sets [Builder.city] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.city] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun city(city: JsonField<String>) = apply { this.city = city }

                /** Country code (e.g., US, CA) */
                fun country(country: String?) = country(JsonField.ofNullable(country))

                /** Alias for calling [Builder.country] with `country.orElse(null)`. */
                fun country(country: Optional<String>) = country(country.getOrNull())

                /**
                 * Sets [Builder.country] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.country] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun country(country: JsonField<String>) = apply { this.country = country }

                /** Country where the business is registered */
                fun countryOfRegistration(countryOfRegistration: String?) =
                    countryOfRegistration(JsonField.ofNullable(countryOfRegistration))

                /**
                 * Alias for calling [Builder.countryOfRegistration] with
                 * `countryOfRegistration.orElse(null)`.
                 */
                fun countryOfRegistration(countryOfRegistration: Optional<String>) =
                    countryOfRegistration(countryOfRegistration.getOrNull())

                /**
                 * Sets [Builder.countryOfRegistration] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.countryOfRegistration] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun countryOfRegistration(countryOfRegistration: JsonField<String>) = apply {
                    this.countryOfRegistration = countryOfRegistration
                }

                /** Business entity type */
                fun entityType(entityType: String?) = entityType(JsonField.ofNullable(entityType))

                /** Alias for calling [Builder.entityType] with `entityType.orElse(null)`. */
                fun entityType(entityType: Optional<String>) = entityType(entityType.getOrNull())

                /**
                 * Sets [Builder.entityType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.entityType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun entityType(entityType: JsonField<String>) = apply {
                    this.entityType = entityType
                }

                /** Legal business name */
                fun legalName(legalName: String?) = legalName(JsonField.ofNullable(legalName))

                /** Alias for calling [Builder.legalName] with `legalName.orElse(null)`. */
                fun legalName(legalName: Optional<String>) = legalName(legalName.getOrNull())

                /**
                 * Sets [Builder.legalName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.legalName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun legalName(legalName: JsonField<String>) = apply { this.legalName = legalName }

                /** Postal/ZIP code */
                fun postalCode(postalCode: String?) = postalCode(JsonField.ofNullable(postalCode))

                /** Alias for calling [Builder.postalCode] with `postalCode.orElse(null)`. */
                fun postalCode(postalCode: Optional<String>) = postalCode(postalCode.getOrNull())

                /**
                 * Sets [Builder.postalCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.postalCode] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun postalCode(postalCode: JsonField<String>) = apply {
                    this.postalCode = postalCode
                }

                /** State/province code */
                fun state(state: String?) = state(JsonField.ofNullable(state))

                /** Alias for calling [Builder.state] with `state.orElse(null)`. */
                fun state(state: Optional<String>) = state(state.getOrNull())

                /**
                 * Sets [Builder.state] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.state] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun state(state: JsonField<String>) = apply { this.state = state }

                /** Street address */
                fun street(street: String?) = street(JsonField.ofNullable(street))

                /** Alias for calling [Builder.street] with `street.orElse(null)`. */
                fun street(street: Optional<String>) = street(street.getOrNull())

                /**
                 * Sets [Builder.street] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.street] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun street(street: JsonField<String>) = apply { this.street = street }

                /** Tax ID/EIN number */
                fun taxId(taxId: String?) = taxId(JsonField.ofNullable(taxId))

                /** Alias for calling [Builder.taxId] with `taxId.orElse(null)`. */
                fun taxId(taxId: Optional<String>) = taxId(taxId.getOrNull())

                /**
                 * Sets [Builder.taxId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.taxId] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun taxId(taxId: JsonField<String>) = apply { this.taxId = taxId }

                /** Type of tax ID (e.g., us_ein, ca_bn) */
                fun taxIdType(taxIdType: String?) = taxIdType(JsonField.ofNullable(taxIdType))

                /** Alias for calling [Builder.taxIdType] with `taxIdType.orElse(null)`. */
                fun taxIdType(taxIdType: Optional<String>) = taxIdType(taxIdType.getOrNull())

                /**
                 * Sets [Builder.taxIdType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.taxIdType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun taxIdType(taxIdType: JsonField<String>) = apply { this.taxIdType = taxIdType }

                /** Business website URL */
                fun url(url: String?) = url(JsonField.ofNullable(url))

                /** Alias for calling [Builder.url] with `url.orElse(null)`. */
                fun url(url: Optional<String>) = url(url.getOrNull())

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

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
                 * Returns an immutable instance of [Business].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Business =
                    Business(
                        city,
                        country,
                        countryOfRegistration,
                        entityType,
                        legalName,
                        postalCode,
                        state,
                        street,
                        taxId,
                        taxIdType,
                        url,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Business = apply {
                if (validated) {
                    return@apply
                }

                city()
                country()
                countryOfRegistration()
                entityType()
                legalName()
                postalCode()
                state()
                street()
                taxId()
                taxIdType()
                url()
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
                (if (city.asKnown().isPresent) 1 else 0) +
                    (if (country.asKnown().isPresent) 1 else 0) +
                    (if (countryOfRegistration.asKnown().isPresent) 1 else 0) +
                    (if (entityType.asKnown().isPresent) 1 else 0) +
                    (if (legalName.asKnown().isPresent) 1 else 0) +
                    (if (postalCode.asKnown().isPresent) 1 else 0) +
                    (if (state.asKnown().isPresent) 1 else 0) +
                    (if (street.asKnown().isPresent) 1 else 0) +
                    (if (taxId.asKnown().isPresent) 1 else 0) +
                    (if (taxIdType.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Business &&
                    city == other.city &&
                    country == other.country &&
                    countryOfRegistration == other.countryOfRegistration &&
                    entityType == other.entityType &&
                    legalName == other.legalName &&
                    postalCode == other.postalCode &&
                    state == other.state &&
                    street == other.street &&
                    taxId == other.taxId &&
                    taxIdType == other.taxIdType &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    city,
                    country,
                    countryOfRegistration,
                    entityType,
                    legalName,
                    postalCode,
                    state,
                    street,
                    taxId,
                    taxIdType,
                    url,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Business{city=$city, country=$country, countryOfRegistration=$countryOfRegistration, entityType=$entityType, legalName=$legalName, postalCode=$postalCode, state=$state, street=$street, taxId=$taxId, taxIdType=$taxIdType, url=$url, additionalProperties=$additionalProperties}"
        }

        /** Compliance and TCR-related information */
        class Compliance
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val brandRelationship: JsonField<TcrBrandRelationship>,
            private val destinationCountries: JsonField<List<DestinationCountry>>,
            private val expectedMessagingVolume: JsonField<String>,
            private val isTcrApplication: JsonField<Boolean>,
            private val notes: JsonField<String>,
            private val phoneNumberPrefix: JsonField<String>,
            private val primaryUseCase: JsonField<String>,
            private val vertical: JsonField<TcrVertical>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("brand_relationship")
                @ExcludeMissing
                brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of(),
                @JsonProperty("destination_countries")
                @ExcludeMissing
                destinationCountries: JsonField<List<DestinationCountry>> = JsonMissing.of(),
                @JsonProperty("expected_messaging_volume")
                @ExcludeMissing
                expectedMessagingVolume: JsonField<String> = JsonMissing.of(),
                @JsonProperty("is_tcr_application")
                @ExcludeMissing
                isTcrApplication: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phone_number_prefix")
                @ExcludeMissing
                phoneNumberPrefix: JsonField<String> = JsonMissing.of(),
                @JsonProperty("primary_use_case")
                @ExcludeMissing
                primaryUseCase: JsonField<String> = JsonMissing.of(),
                @JsonProperty("vertical")
                @ExcludeMissing
                vertical: JsonField<TcrVertical> = JsonMissing.of(),
            ) : this(
                brandRelationship,
                destinationCountries,
                expectedMessagingVolume,
                isTcrApplication,
                notes,
                phoneNumberPrefix,
                primaryUseCase,
                vertical,
                mutableMapOf(),
            )

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun brandRelationship(): Optional<TcrBrandRelationship> =
                brandRelationship.getOptional("brand_relationship")

            /**
             * List of destination countries for messaging
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun destinationCountries(): Optional<List<DestinationCountry>> =
                destinationCountries.getOptional("destination_countries")

            /**
             * Expected daily messaging volume
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun expectedMessagingVolume(): Optional<String> =
                expectedMessagingVolume.getOptional("expected_messaging_volume")

            /**
             * Whether this is a TCR (Campaign Registry) application
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun isTcrApplication(): Optional<Boolean> =
                isTcrApplication.getOptional("is_tcr_application")

            /**
             * Additional notes about the business or use case
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun notes(): Optional<String> = notes.getOptional("notes")

            /**
             * Phone number prefix for messaging (e.g., "+1")
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phoneNumberPrefix(): Optional<String> =
                phoneNumberPrefix.getOptional("phone_number_prefix")

            /**
             * Primary messaging use case description
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryUseCase(): Optional<String> = primaryUseCase.getOptional("primary_use_case")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vertical(): Optional<TcrVertical> = vertical.getOptional("vertical")

            /**
             * Returns the raw JSON value of [brandRelationship].
             *
             * Unlike [brandRelationship], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("brand_relationship")
            @ExcludeMissing
            fun _brandRelationship(): JsonField<TcrBrandRelationship> = brandRelationship

            /**
             * Returns the raw JSON value of [destinationCountries].
             *
             * Unlike [destinationCountries], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("destination_countries")
            @ExcludeMissing
            fun _destinationCountries(): JsonField<List<DestinationCountry>> = destinationCountries

            /**
             * Returns the raw JSON value of [expectedMessagingVolume].
             *
             * Unlike [expectedMessagingVolume], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("expected_messaging_volume")
            @ExcludeMissing
            fun _expectedMessagingVolume(): JsonField<String> = expectedMessagingVolume

            /**
             * Returns the raw JSON value of [isTcrApplication].
             *
             * Unlike [isTcrApplication], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("is_tcr_application")
            @ExcludeMissing
            fun _isTcrApplication(): JsonField<Boolean> = isTcrApplication

            /**
             * Returns the raw JSON value of [notes].
             *
             * Unlike [notes], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("notes") @ExcludeMissing fun _notes(): JsonField<String> = notes

            /**
             * Returns the raw JSON value of [phoneNumberPrefix].
             *
             * Unlike [phoneNumberPrefix], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("phone_number_prefix")
            @ExcludeMissing
            fun _phoneNumberPrefix(): JsonField<String> = phoneNumberPrefix

            /**
             * Returns the raw JSON value of [primaryUseCase].
             *
             * Unlike [primaryUseCase], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("primary_use_case")
            @ExcludeMissing
            fun _primaryUseCase(): JsonField<String> = primaryUseCase

            /**
             * Returns the raw JSON value of [vertical].
             *
             * Unlike [vertical], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("vertical")
            @ExcludeMissing
            fun _vertical(): JsonField<TcrVertical> = vertical

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

                private var brandRelationship: JsonField<TcrBrandRelationship> = JsonMissing.of()
                private var destinationCountries: JsonField<MutableList<DestinationCountry>>? = null
                private var expectedMessagingVolume: JsonField<String> = JsonMissing.of()
                private var isTcrApplication: JsonField<Boolean> = JsonMissing.of()
                private var notes: JsonField<String> = JsonMissing.of()
                private var phoneNumberPrefix: JsonField<String> = JsonMissing.of()
                private var primaryUseCase: JsonField<String> = JsonMissing.of()
                private var vertical: JsonField<TcrVertical> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(compliance: Compliance) = apply {
                    brandRelationship = compliance.brandRelationship
                    destinationCountries =
                        compliance.destinationCountries.map { it.toMutableList() }
                    expectedMessagingVolume = compliance.expectedMessagingVolume
                    isTcrApplication = compliance.isTcrApplication
                    notes = compliance.notes
                    phoneNumberPrefix = compliance.phoneNumberPrefix
                    primaryUseCase = compliance.primaryUseCase
                    vertical = compliance.vertical
                    additionalProperties = compliance.additionalProperties.toMutableMap()
                }

                fun brandRelationship(brandRelationship: TcrBrandRelationship?) =
                    brandRelationship(JsonField.ofNullable(brandRelationship))

                /**
                 * Alias for calling [Builder.brandRelationship] with
                 * `brandRelationship.orElse(null)`.
                 */
                fun brandRelationship(brandRelationship: Optional<TcrBrandRelationship>) =
                    brandRelationship(brandRelationship.getOrNull())

                /**
                 * Sets [Builder.brandRelationship] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.brandRelationship] with a well-typed
                 * [TcrBrandRelationship] value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun brandRelationship(brandRelationship: JsonField<TcrBrandRelationship>) = apply {
                    this.brandRelationship = brandRelationship
                }

                /** List of destination countries for messaging */
                fun destinationCountries(destinationCountries: List<DestinationCountry>) =
                    destinationCountries(JsonField.of(destinationCountries))

                /**
                 * Sets [Builder.destinationCountries] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.destinationCountries] with a well-typed
                 * `List<DestinationCountry>` value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun destinationCountries(
                    destinationCountries: JsonField<List<DestinationCountry>>
                ) = apply {
                    this.destinationCountries = destinationCountries.map { it.toMutableList() }
                }

                /**
                 * Adds a single [DestinationCountry] to [destinationCountries].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addDestinationCountry(destinationCountry: DestinationCountry) = apply {
                    destinationCountries =
                        (destinationCountries ?: JsonField.of(mutableListOf())).also {
                            checkKnown("destinationCountries", it).add(destinationCountry)
                        }
                }

                /** Expected daily messaging volume */
                fun expectedMessagingVolume(expectedMessagingVolume: String?) =
                    expectedMessagingVolume(JsonField.ofNullable(expectedMessagingVolume))

                /**
                 * Alias for calling [Builder.expectedMessagingVolume] with
                 * `expectedMessagingVolume.orElse(null)`.
                 */
                fun expectedMessagingVolume(expectedMessagingVolume: Optional<String>) =
                    expectedMessagingVolume(expectedMessagingVolume.getOrNull())

                /**
                 * Sets [Builder.expectedMessagingVolume] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.expectedMessagingVolume] with a well-typed
                 * [String] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun expectedMessagingVolume(expectedMessagingVolume: JsonField<String>) = apply {
                    this.expectedMessagingVolume = expectedMessagingVolume
                }

                /** Whether this is a TCR (Campaign Registry) application */
                fun isTcrApplication(isTcrApplication: Boolean) =
                    isTcrApplication(JsonField.of(isTcrApplication))

                /**
                 * Sets [Builder.isTcrApplication] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isTcrApplication] with a well-typed [Boolean]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun isTcrApplication(isTcrApplication: JsonField<Boolean>) = apply {
                    this.isTcrApplication = isTcrApplication
                }

                /** Additional notes about the business or use case */
                fun notes(notes: String?) = notes(JsonField.ofNullable(notes))

                /** Alias for calling [Builder.notes] with `notes.orElse(null)`. */
                fun notes(notes: Optional<String>) = notes(notes.getOrNull())

                /**
                 * Sets [Builder.notes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.notes] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun notes(notes: JsonField<String>) = apply { this.notes = notes }

                /** Phone number prefix for messaging (e.g., "+1") */
                fun phoneNumberPrefix(phoneNumberPrefix: String?) =
                    phoneNumberPrefix(JsonField.ofNullable(phoneNumberPrefix))

                /**
                 * Alias for calling [Builder.phoneNumberPrefix] with
                 * `phoneNumberPrefix.orElse(null)`.
                 */
                fun phoneNumberPrefix(phoneNumberPrefix: Optional<String>) =
                    phoneNumberPrefix(phoneNumberPrefix.getOrNull())

                /**
                 * Sets [Builder.phoneNumberPrefix] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.phoneNumberPrefix] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun phoneNumberPrefix(phoneNumberPrefix: JsonField<String>) = apply {
                    this.phoneNumberPrefix = phoneNumberPrefix
                }

                /** Primary messaging use case description */
                fun primaryUseCase(primaryUseCase: String?) =
                    primaryUseCase(JsonField.ofNullable(primaryUseCase))

                /**
                 * Alias for calling [Builder.primaryUseCase] with `primaryUseCase.orElse(null)`.
                 */
                fun primaryUseCase(primaryUseCase: Optional<String>) =
                    primaryUseCase(primaryUseCase.getOrNull())

                /**
                 * Sets [Builder.primaryUseCase] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.primaryUseCase] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun primaryUseCase(primaryUseCase: JsonField<String>) = apply {
                    this.primaryUseCase = primaryUseCase
                }

                fun vertical(vertical: TcrVertical?) = vertical(JsonField.ofNullable(vertical))

                /** Alias for calling [Builder.vertical] with `vertical.orElse(null)`. */
                fun vertical(vertical: Optional<TcrVertical>) = vertical(vertical.getOrNull())

                /**
                 * Sets [Builder.vertical] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vertical] with a well-typed [TcrVertical] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun vertical(vertical: JsonField<TcrVertical>) = apply { this.vertical = vertical }

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
                 * Returns an immutable instance of [Compliance].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Compliance =
                    Compliance(
                        brandRelationship,
                        (destinationCountries ?: JsonMissing.of()).map { it.toImmutable() },
                        expectedMessagingVolume,
                        isTcrApplication,
                        notes,
                        phoneNumberPrefix,
                        primaryUseCase,
                        vertical,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Compliance = apply {
                if (validated) {
                    return@apply
                }

                brandRelationship().ifPresent { it.validate() }
                destinationCountries().ifPresent { it.forEach { it.validate() } }
                expectedMessagingVolume()
                isTcrApplication()
                notes()
                phoneNumberPrefix()
                primaryUseCase()
                vertical().ifPresent { it.validate() }
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
                (brandRelationship.asKnown().getOrNull()?.validity() ?: 0) +
                    (destinationCountries.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                        ?: 0) +
                    (if (expectedMessagingVolume.asKnown().isPresent) 1 else 0) +
                    (if (isTcrApplication.asKnown().isPresent) 1 else 0) +
                    (if (notes.asKnown().isPresent) 1 else 0) +
                    (if (phoneNumberPrefix.asKnown().isPresent) 1 else 0) +
                    (if (primaryUseCase.asKnown().isPresent) 1 else 0) +
                    (vertical.asKnown().getOrNull()?.validity() ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Compliance &&
                    brandRelationship == other.brandRelationship &&
                    destinationCountries == other.destinationCountries &&
                    expectedMessagingVolume == other.expectedMessagingVolume &&
                    isTcrApplication == other.isTcrApplication &&
                    notes == other.notes &&
                    phoneNumberPrefix == other.phoneNumberPrefix &&
                    primaryUseCase == other.primaryUseCase &&
                    vertical == other.vertical &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    brandRelationship,
                    destinationCountries,
                    expectedMessagingVolume,
                    isTcrApplication,
                    notes,
                    phoneNumberPrefix,
                    primaryUseCase,
                    vertical,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Compliance{brandRelationship=$brandRelationship, destinationCountries=$destinationCountries, expectedMessagingVolume=$expectedMessagingVolume, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, primaryUseCase=$primaryUseCase, vertical=$vertical, additionalProperties=$additionalProperties}"
        }

        /** Contact information for the brand */
        class Contact
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val businessName: JsonField<String>,
            private val email: JsonField<String>,
            private val name: JsonField<String>,
            private val phone: JsonField<String>,
            private val phoneCountryCode: JsonField<String>,
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("business_name")
                @ExcludeMissing
                businessName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phone_country_code")
                @ExcludeMissing
                phoneCountryCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            ) : this(businessName, email, name, phone, phoneCountryCode, role, mutableMapOf())

            /**
             * Business/brand name
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun businessName(): Optional<String> = businessName.getOptional("business_name")

            /**
             * Contact email address
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun email(): Optional<String> = email.getOptional("email")

            /**
             * Primary contact name
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Contact phone number in E.164 format
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phone(): Optional<String> = phone.getOptional("phone")

            /**
             * Contact phone country code (e.g., "1" for US)
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phoneCountryCode(): Optional<String> =
                phoneCountryCode.getOptional("phone_country_code")

            /**
             * Contact's role in the business
             *
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [businessName].
             *
             * Unlike [businessName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("business_name")
            @ExcludeMissing
            fun _businessName(): JsonField<String> = businessName

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

            /**
             * Returns the raw JSON value of [phoneCountryCode].
             *
             * Unlike [phoneCountryCode], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("phone_country_code")
            @ExcludeMissing
            fun _phoneCountryCode(): JsonField<String> = phoneCountryCode

            /**
             * Returns the raw JSON value of [role].
             *
             * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

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

                /** Returns a mutable builder for constructing an instance of [Contact]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Contact]. */
            class Builder internal constructor() {

                private var businessName: JsonField<String> = JsonMissing.of()
                private var email: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var phone: JsonField<String> = JsonMissing.of()
                private var phoneCountryCode: JsonField<String> = JsonMissing.of()
                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(contact: Contact) = apply {
                    businessName = contact.businessName
                    email = contact.email
                    name = contact.name
                    phone = contact.phone
                    phoneCountryCode = contact.phoneCountryCode
                    role = contact.role
                    additionalProperties = contact.additionalProperties.toMutableMap()
                }

                /** Business/brand name */
                fun businessName(businessName: String?) =
                    businessName(JsonField.ofNullable(businessName))

                /** Alias for calling [Builder.businessName] with `businessName.orElse(null)`. */
                fun businessName(businessName: Optional<String>) =
                    businessName(businessName.getOrNull())

                /**
                 * Sets [Builder.businessName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.businessName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun businessName(businessName: JsonField<String>) = apply {
                    this.businessName = businessName
                }

                /** Contact email address */
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

                /** Primary contact name */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Contact phone number in E.164 format */
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

                /** Contact phone country code (e.g., "1" for US) */
                fun phoneCountryCode(phoneCountryCode: String?) =
                    phoneCountryCode(JsonField.ofNullable(phoneCountryCode))

                /**
                 * Alias for calling [Builder.phoneCountryCode] with
                 * `phoneCountryCode.orElse(null)`.
                 */
                fun phoneCountryCode(phoneCountryCode: Optional<String>) =
                    phoneCountryCode(phoneCountryCode.getOrNull())

                /**
                 * Sets [Builder.phoneCountryCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.phoneCountryCode] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun phoneCountryCode(phoneCountryCode: JsonField<String>) = apply {
                    this.phoneCountryCode = phoneCountryCode
                }

                /** Contact's role in the business */
                fun role(role: String?) = role(JsonField.ofNullable(role))

                /** Alias for calling [Builder.role] with `role.orElse(null)`. */
                fun role(role: Optional<String>) = role(role.getOrNull())

                /**
                 * Sets [Builder.role] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.role] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun role(role: JsonField<String>) = apply { this.role = role }

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
                 * Returns an immutable instance of [Contact].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Contact =
                    Contact(
                        businessName,
                        email,
                        name,
                        phone,
                        phoneCountryCode,
                        role,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Contact = apply {
                if (validated) {
                    return@apply
                }

                businessName()
                email()
                name()
                phone()
                phoneCountryCode()
                role()
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
                (if (businessName.asKnown().isPresent) 1 else 0) +
                    (if (email.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (phone.asKnown().isPresent) 1 else 0) +
                    (if (phoneCountryCode.asKnown().isPresent) 1 else 0) +
                    (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Contact &&
                    businessName == other.businessName &&
                    email == other.email &&
                    name == other.name &&
                    phone == other.phone &&
                    phoneCountryCode == other.phoneCountryCode &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    businessName,
                    email,
                    name,
                    phone,
                    phoneCountryCode,
                    role,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Contact{businessName=$businessName, email=$email, name=$name, phone=$phone, phoneCountryCode=$phoneCountryCode, role=$role, additionalProperties=$additionalProperties}"
        }

        class IdentityStatus
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val SELF_DECLARED = of("SELF_DECLARED")

                @JvmField val UNVERIFIED = of("UNVERIFIED")

                @JvmField val VERIFIED = of("VERIFIED")

                @JvmField val VETTED_VERIFIED = of("VETTED_VERIFIED")

                @JvmStatic fun of(value: String) = IdentityStatus(JsonField.of(value))
            }

            /** An enum containing [IdentityStatus]'s known values. */
            enum class Known {
                SELF_DECLARED,
                UNVERIFIED,
                VERIFIED,
                VETTED_VERIFIED,
            }

            /**
             * An enum containing [IdentityStatus]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [IdentityStatus] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                SELF_DECLARED,
                UNVERIFIED,
                VERIFIED,
                VETTED_VERIFIED,
                /**
                 * An enum member indicating that [IdentityStatus] was instantiated with an unknown
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
                    SELF_DECLARED -> Value.SELF_DECLARED
                    UNVERIFIED -> Value.UNVERIFIED
                    VERIFIED -> Value.VERIFIED
                    VETTED_VERIFIED -> Value.VETTED_VERIFIED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SentDmInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    SELF_DECLARED -> Known.SELF_DECLARED
                    UNVERIFIED -> Known.UNVERIFIED
                    VERIFIED -> Known.VERIFIED
                    VETTED_VERIFIED -> Known.VETTED_VERIFIED
                    else -> throw SentDmInvalidDataException("Unknown IdentityStatus: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentDmInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentDmInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): IdentityStatus = apply {
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
                } catch (e: SentDmInvalidDataException) {
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

                return other is IdentityStatus && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val ACTIVE = of("ACTIVE")

                @JvmField val INACTIVE = of("INACTIVE")

                @JvmField val SUSPENDED = of("SUSPENDED")

                @JvmStatic fun of(value: String) = Status(JsonField.of(value))
            }

            /** An enum containing [Status]'s known values. */
            enum class Known {
                ACTIVE,
                INACTIVE,
                SUSPENDED,
            }

            /**
             * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Status] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                ACTIVE,
                INACTIVE,
                SUSPENDED,
                /**
                 * An enum member indicating that [Status] was instantiated with an unknown value.
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
                    ACTIVE -> Value.ACTIVE
                    INACTIVE -> Value.INACTIVE
                    SUSPENDED -> Value.SUSPENDED
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws SentDmInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    ACTIVE -> Known.ACTIVE
                    INACTIVE -> Known.INACTIVE
                    SUSPENDED -> Known.SUSPENDED
                    else -> throw SentDmInvalidDataException("Unknown Status: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws SentDmInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    SentDmInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

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
                } catch (e: SentDmInvalidDataException) {
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

            return other is Brand &&
                id == other.id &&
                business == other.business &&
                compliance == other.compliance &&
                contact == other.contact &&
                createdAt == other.createdAt &&
                cspId == other.cspId &&
                identityStatus == other.identityStatus &&
                isInherited == other.isInherited &&
                status == other.status &&
                submittedAt == other.submittedAt &&
                submittedToTcr == other.submittedToTcr &&
                tcrBrandId == other.tcrBrandId &&
                universalEin == other.universalEin &&
                updatedAt == other.updatedAt &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                business,
                compliance,
                contact,
                createdAt,
                cspId,
                identityStatus,
                isInherited,
                status,
                submittedAt,
                submittedToTcr,
                tcrBrandId,
                universalEin,
                updatedAt,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Brand{id=$id, business=$business, compliance=$compliance, contact=$contact, createdAt=$createdAt, cspId=$cspId, identityStatus=$identityStatus, isInherited=$isInherited, status=$status, submittedAt=$submittedAt, submittedToTcr=$submittedToTcr, tcrBrandId=$tcrBrandId, universalEin=$universalEin, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
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
