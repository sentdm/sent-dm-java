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
 * Updates a profile's configuration and settings. Requires admin role in the organization. Only
 * provided fields will be updated (partial update).
 *
 * ## Brand Management
 *
 * Include the optional `brand` field to create or update the brand associated with this profile.
 * The brand holds KYC and TCR compliance data (legal business info, contact details, messaging
 * vertical). Once a brand has been submitted to TCR it cannot be modified. Setting
 * `inherit_tcr_brand: true` and providing `brand` in the same request is not allowed.
 *
 * ## Payment Details
 *
 * When `billing_model` is `"profile"` or `"profile_and_organization"` you may include a
 * `payment_details` object containing the card number, expiry (MM/YY), CVC, and billing ZIP code.
 * Payment details are **never stored** on our servers and are forwarded directly to the payment
 * processor. Providing `payment_details` when `billing_model` is `"organization"` is not allowed.
 */
class ProfileUpdateParams
private constructor(
    private val profileId: String?,
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun profileId(): Optional<String> = Optional.ofNullable(profileId)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * Whether contacts are shared across profiles (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun allowContactSharing(): Optional<Boolean> = body.allowContactSharing()

    /**
     * Whether number changes are allowed during onboarding (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun allowNumberChangeDuringOnboarding(): Optional<Boolean> =
        body.allowNumberChangeDuringOnboarding()

    /**
     * Whether templates are shared across profiles (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun allowTemplateSharing(): Optional<Boolean> = body.allowTemplateSharing()

    /**
     * Billing contact information for a profile. Required when billing_model is "profile" or
     * "profile_and_organization".
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun billingContact(): Optional<BillingContact> = body.billingContact()

    /**
     * Billing model: profile, organization, or profile_and_organization (optional).
     * - "organization": the organization's billing details are used; no profile-level billing info
     *   needed.
     * - "profile": the profile is billed independently; billing_contact is required.
     * - "profile_and_organization": the profile is billed first with the organization as fallback;
     *   billing_contact is required.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun billingModel(): Optional<String> = body.billingModel()

    /**
     * Brand and KYC data grouped into contact, business, and compliance sections
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun brand(): Optional<Brand> = body.brand()

    /**
     * Profile description (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * Profile icon URL (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun icon(): Optional<String> = body.icon()

    /**
     * Whether this profile inherits contacts from organization (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritContacts(): Optional<Boolean> = body.inheritContacts()

    /**
     * Whether this profile inherits TCR brand from organization (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritTcrBrand(): Optional<Boolean> = body.inheritTcrBrand()

    /**
     * Whether this profile inherits TCR campaign from organization (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritTcrCampaign(): Optional<Boolean> = body.inheritTcrCampaign()

    /**
     * Whether this profile inherits templates from organization (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritTemplates(): Optional<Boolean> = body.inheritTemplates()

    /**
     * Profile name (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Payment card details for a profile. Accepted when billing_model is "profile" or
     * "profile_and_organization". These details are not stored on our servers and will be forwarded
     * to the payment processor.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun paymentDetails(): Optional<PaymentDetails> = body.paymentDetails()

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Direct phone number for SMS sending (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sendingPhoneNumber(): Optional<String> = body.sendingPhoneNumber()

    /**
     * Reference to another profile to use for SMS/Telnyx configuration (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sendingPhoneNumberProfileId(): Optional<String> = body.sendingPhoneNumberProfileId()

    /**
     * Reference to another profile to use for WhatsApp configuration (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sendingWhatsappNumberProfileId(): Optional<String> = body.sendingWhatsappNumberProfileId()

    /**
     * Profile short name/abbreviation (optional). Must be 3–11 characters, contain only letters,
     * numbers, and spaces, and include at least one letter. Example: "SALES", "Mkt 2", "Support1".
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun shortName(): Optional<String> = body.shortName()

    /**
     * Direct phone number for WhatsApp sending (optional)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun whatsappPhoneNumber(): Optional<String> = body.whatsappPhoneNumber()

    /**
     * Returns the raw JSON value of [allowContactSharing].
     *
     * Unlike [allowContactSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _allowContactSharing(): JsonField<Boolean> = body._allowContactSharing()

    /**
     * Returns the raw JSON value of [allowNumberChangeDuringOnboarding].
     *
     * Unlike [allowNumberChangeDuringOnboarding], this method doesn't throw if the JSON field has
     * an unexpected type.
     */
    fun _allowNumberChangeDuringOnboarding(): JsonField<Boolean> =
        body._allowNumberChangeDuringOnboarding()

    /**
     * Returns the raw JSON value of [allowTemplateSharing].
     *
     * Unlike [allowTemplateSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _allowTemplateSharing(): JsonField<Boolean> = body._allowTemplateSharing()

    /**
     * Returns the raw JSON value of [billingContact].
     *
     * Unlike [billingContact], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _billingContact(): JsonField<BillingContact> = body._billingContact()

    /**
     * Returns the raw JSON value of [billingModel].
     *
     * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _billingModel(): JsonField<String> = body._billingModel()

    /**
     * Returns the raw JSON value of [brand].
     *
     * Unlike [brand], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _brand(): JsonField<Brand> = body._brand()

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _description(): JsonField<String> = body._description()

    /**
     * Returns the raw JSON value of [icon].
     *
     * Unlike [icon], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _icon(): JsonField<String> = body._icon()

    /**
     * Returns the raw JSON value of [inheritContacts].
     *
     * Unlike [inheritContacts], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inheritContacts(): JsonField<Boolean> = body._inheritContacts()

    /**
     * Returns the raw JSON value of [inheritTcrBrand].
     *
     * Unlike [inheritTcrBrand], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inheritTcrBrand(): JsonField<Boolean> = body._inheritTcrBrand()

    /**
     * Returns the raw JSON value of [inheritTcrCampaign].
     *
     * Unlike [inheritTcrCampaign], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _inheritTcrCampaign(): JsonField<Boolean> = body._inheritTcrCampaign()

    /**
     * Returns the raw JSON value of [inheritTemplates].
     *
     * Unlike [inheritTemplates], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _inheritTemplates(): JsonField<Boolean> = body._inheritTemplates()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [paymentDetails].
     *
     * Unlike [paymentDetails], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _paymentDetails(): JsonField<PaymentDetails> = body._paymentDetails()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [sendingPhoneNumber].
     *
     * Unlike [sendingPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _sendingPhoneNumber(): JsonField<String> = body._sendingPhoneNumber()

    /**
     * Returns the raw JSON value of [sendingPhoneNumberProfileId].
     *
     * Unlike [sendingPhoneNumberProfileId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _sendingPhoneNumberProfileId(): JsonField<String> = body._sendingPhoneNumberProfileId()

    /**
     * Returns the raw JSON value of [sendingWhatsappNumberProfileId].
     *
     * Unlike [sendingWhatsappNumberProfileId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _sendingWhatsappNumberProfileId(): JsonField<String> =
        body._sendingWhatsappNumberProfileId()

    /**
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _shortName(): JsonField<String> = body._shortName()

    /**
     * Returns the raw JSON value of [whatsappPhoneNumber].
     *
     * Unlike [whatsappPhoneNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _whatsappPhoneNumber(): JsonField<String> = body._whatsappPhoneNumber()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ProfileUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ProfileUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProfileUpdateParams]. */
    class Builder internal constructor() {

        private var profileId: String? = null
        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(profileUpdateParams: ProfileUpdateParams) = apply {
            profileId = profileUpdateParams.profileId
            idempotencyKey = profileUpdateParams.idempotencyKey
            xProfileId = profileUpdateParams.xProfileId
            body = profileUpdateParams.body.toBuilder()
            additionalHeaders = profileUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = profileUpdateParams.additionalQueryParams.toBuilder()
        }

        fun profileId(profileId: String?) = apply { this.profileId = profileId }

        /** Alias for calling [Builder.profileId] with `profileId.orElse(null)`. */
        fun profileId(profileId: Optional<String>) = profileId(profileId.getOrNull())

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
         * - [allowContactSharing]
         * - [allowNumberChangeDuringOnboarding]
         * - [allowTemplateSharing]
         * - [billingContact]
         * - [billingModel]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Whether contacts are shared across profiles (optional) */
        fun allowContactSharing(allowContactSharing: Boolean?) = apply {
            body.allowContactSharing(allowContactSharing)
        }

        /**
         * Alias for [Builder.allowContactSharing].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun allowContactSharing(allowContactSharing: Boolean) =
            allowContactSharing(allowContactSharing as Boolean?)

        /**
         * Alias for calling [Builder.allowContactSharing] with `allowContactSharing.orElse(null)`.
         */
        fun allowContactSharing(allowContactSharing: Optional<Boolean>) =
            allowContactSharing(allowContactSharing.getOrNull())

        /**
         * Sets [Builder.allowContactSharing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowContactSharing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowContactSharing(allowContactSharing: JsonField<Boolean>) = apply {
            body.allowContactSharing(allowContactSharing)
        }

        /** Whether number changes are allowed during onboarding (optional) */
        fun allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding: Boolean?) = apply {
            body.allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding)
        }

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
        ) = apply { body.allowNumberChangeDuringOnboarding(allowNumberChangeDuringOnboarding) }

        /** Whether templates are shared across profiles (optional) */
        fun allowTemplateSharing(allowTemplateSharing: Boolean?) = apply {
            body.allowTemplateSharing(allowTemplateSharing)
        }

        /**
         * Alias for [Builder.allowTemplateSharing].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun allowTemplateSharing(allowTemplateSharing: Boolean) =
            allowTemplateSharing(allowTemplateSharing as Boolean?)

        /**
         * Alias for calling [Builder.allowTemplateSharing] with
         * `allowTemplateSharing.orElse(null)`.
         */
        fun allowTemplateSharing(allowTemplateSharing: Optional<Boolean>) =
            allowTemplateSharing(allowTemplateSharing.getOrNull())

        /**
         * Sets [Builder.allowTemplateSharing] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowTemplateSharing] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowTemplateSharing(allowTemplateSharing: JsonField<Boolean>) = apply {
            body.allowTemplateSharing(allowTemplateSharing)
        }

        /**
         * Billing contact information for a profile. Required when billing_model is "profile" or
         * "profile_and_organization".
         */
        fun billingContact(billingContact: BillingContact?) = apply {
            body.billingContact(billingContact)
        }

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
            body.billingContact(billingContact)
        }

        /**
         * Billing model: profile, organization, or profile_and_organization (optional).
         * - "organization": the organization's billing details are used; no profile-level billing
         *   info needed.
         * - "profile": the profile is billed independently; billing_contact is required.
         * - "profile_and_organization": the profile is billed first with the organization as
         *   fallback; billing_contact is required.
         */
        fun billingModel(billingModel: String?) = apply { body.billingModel(billingModel) }

        /** Alias for calling [Builder.billingModel] with `billingModel.orElse(null)`. */
        fun billingModel(billingModel: Optional<String>) = billingModel(billingModel.getOrNull())

        /**
         * Sets [Builder.billingModel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billingModel] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billingModel(billingModel: JsonField<String>) = apply {
            body.billingModel(billingModel)
        }

        /** Brand and KYC data grouped into contact, business, and compliance sections */
        fun brand(brand: Brand?) = apply { body.brand(brand) }

        /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
        fun brand(brand: Optional<Brand>) = brand(brand.getOrNull())

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [Brand] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun brand(brand: JsonField<Brand>) = apply { body.brand(brand) }

        /** Profile description (optional) */
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

        /** Profile icon URL (optional) */
        fun icon(icon: String?) = apply { body.icon(icon) }

        /** Alias for calling [Builder.icon] with `icon.orElse(null)`. */
        fun icon(icon: Optional<String>) = icon(icon.getOrNull())

        /**
         * Sets [Builder.icon] to an arbitrary JSON value.
         *
         * You should usually call [Builder.icon] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun icon(icon: JsonField<String>) = apply { body.icon(icon) }

        /** Whether this profile inherits contacts from organization (optional) */
        fun inheritContacts(inheritContacts: Boolean?) = apply {
            body.inheritContacts(inheritContacts)
        }

        /**
         * Alias for [Builder.inheritContacts].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritContacts(inheritContacts: Boolean) = inheritContacts(inheritContacts as Boolean?)

        /** Alias for calling [Builder.inheritContacts] with `inheritContacts.orElse(null)`. */
        fun inheritContacts(inheritContacts: Optional<Boolean>) =
            inheritContacts(inheritContacts.getOrNull())

        /**
         * Sets [Builder.inheritContacts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritContacts] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritContacts(inheritContacts: JsonField<Boolean>) = apply {
            body.inheritContacts(inheritContacts)
        }

        /** Whether this profile inherits TCR brand from organization (optional) */
        fun inheritTcrBrand(inheritTcrBrand: Boolean?) = apply {
            body.inheritTcrBrand(inheritTcrBrand)
        }

        /**
         * Alias for [Builder.inheritTcrBrand].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritTcrBrand(inheritTcrBrand: Boolean) = inheritTcrBrand(inheritTcrBrand as Boolean?)

        /** Alias for calling [Builder.inheritTcrBrand] with `inheritTcrBrand.orElse(null)`. */
        fun inheritTcrBrand(inheritTcrBrand: Optional<Boolean>) =
            inheritTcrBrand(inheritTcrBrand.getOrNull())

        /**
         * Sets [Builder.inheritTcrBrand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTcrBrand] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTcrBrand(inheritTcrBrand: JsonField<Boolean>) = apply {
            body.inheritTcrBrand(inheritTcrBrand)
        }

        /** Whether this profile inherits TCR campaign from organization (optional) */
        fun inheritTcrCampaign(inheritTcrCampaign: Boolean?) = apply {
            body.inheritTcrCampaign(inheritTcrCampaign)
        }

        /**
         * Alias for [Builder.inheritTcrCampaign].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: Boolean) =
            inheritTcrCampaign(inheritTcrCampaign as Boolean?)

        /**
         * Alias for calling [Builder.inheritTcrCampaign] with `inheritTcrCampaign.orElse(null)`.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: Optional<Boolean>) =
            inheritTcrCampaign(inheritTcrCampaign.getOrNull())

        /**
         * Sets [Builder.inheritTcrCampaign] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTcrCampaign] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTcrCampaign(inheritTcrCampaign: JsonField<Boolean>) = apply {
            body.inheritTcrCampaign(inheritTcrCampaign)
        }

        /** Whether this profile inherits templates from organization (optional) */
        fun inheritTemplates(inheritTemplates: Boolean?) = apply {
            body.inheritTemplates(inheritTemplates)
        }

        /**
         * Alias for [Builder.inheritTemplates].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun inheritTemplates(inheritTemplates: Boolean) =
            inheritTemplates(inheritTemplates as Boolean?)

        /** Alias for calling [Builder.inheritTemplates] with `inheritTemplates.orElse(null)`. */
        fun inheritTemplates(inheritTemplates: Optional<Boolean>) =
            inheritTemplates(inheritTemplates.getOrNull())

        /**
         * Sets [Builder.inheritTemplates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inheritTemplates] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inheritTemplates(inheritTemplates: JsonField<Boolean>) = apply {
            body.inheritTemplates(inheritTemplates)
        }

        /** Profile name (optional) */
        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /**
         * Payment card details for a profile. Accepted when billing_model is "profile" or
         * "profile_and_organization". These details are not stored on our servers and will be
         * forwarded to the payment processor.
         */
        fun paymentDetails(paymentDetails: PaymentDetails?) = apply {
            body.paymentDetails(paymentDetails)
        }

        /** Alias for calling [Builder.paymentDetails] with `paymentDetails.orElse(null)`. */
        fun paymentDetails(paymentDetails: Optional<PaymentDetails>) =
            paymentDetails(paymentDetails.getOrNull())

        /**
         * Sets [Builder.paymentDetails] to an arbitrary JSON value.
         *
         * You should usually call [Builder.paymentDetails] with a well-typed [PaymentDetails] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun paymentDetails(paymentDetails: JsonField<PaymentDetails>) = apply {
            body.paymentDetails(paymentDetails)
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

        /** Direct phone number for SMS sending (optional) */
        fun sendingPhoneNumber(sendingPhoneNumber: String?) = apply {
            body.sendingPhoneNumber(sendingPhoneNumber)
        }

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
            body.sendingPhoneNumber(sendingPhoneNumber)
        }

        /** Reference to another profile to use for SMS/Telnyx configuration (optional) */
        fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: String?) = apply {
            body.sendingPhoneNumberProfileId(sendingPhoneNumberProfileId)
        }

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
            body.sendingPhoneNumberProfileId(sendingPhoneNumberProfileId)
        }

        /** Reference to another profile to use for WhatsApp configuration (optional) */
        fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: String?) = apply {
            body.sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId)
        }

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
                body.sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId)
            }

        /**
         * Profile short name/abbreviation (optional). Must be 3–11 characters, contain only
         * letters, numbers, and spaces, and include at least one letter. Example: "SALES", "Mkt 2",
         * "Support1".
         */
        fun shortName(shortName: String?) = apply { body.shortName(shortName) }

        /** Alias for calling [Builder.shortName] with `shortName.orElse(null)`. */
        fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

        /**
         * Sets [Builder.shortName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.shortName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun shortName(shortName: JsonField<String>) = apply { body.shortName(shortName) }

        /** Direct phone number for WhatsApp sending (optional) */
        fun whatsappPhoneNumber(whatsappPhoneNumber: String?) = apply {
            body.whatsappPhoneNumber(whatsappPhoneNumber)
        }

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
            body.whatsappPhoneNumber(whatsappPhoneNumber)
        }

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
         * Returns an immutable instance of [ProfileUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ProfileUpdateParams =
            ProfileUpdateParams(
                profileId,
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
            0 -> profileId ?: ""
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

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val allowContactSharing: JsonField<Boolean>,
        private val allowNumberChangeDuringOnboarding: JsonField<Boolean>,
        private val allowTemplateSharing: JsonField<Boolean>,
        private val billingContact: JsonField<BillingContact>,
        private val billingModel: JsonField<String>,
        private val brand: JsonField<Brand>,
        private val description: JsonField<String>,
        private val icon: JsonField<String>,
        private val inheritContacts: JsonField<Boolean>,
        private val inheritTcrBrand: JsonField<Boolean>,
        private val inheritTcrCampaign: JsonField<Boolean>,
        private val inheritTemplates: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val paymentDetails: JsonField<PaymentDetails>,
        private val sandbox: JsonField<Boolean>,
        private val sendingPhoneNumber: JsonField<String>,
        private val sendingPhoneNumberProfileId: JsonField<String>,
        private val sendingWhatsappNumberProfileId: JsonField<String>,
        private val shortName: JsonField<String>,
        private val whatsappPhoneNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
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
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
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
            @JsonProperty("payment_details")
            @ExcludeMissing
            paymentDetails: JsonField<PaymentDetails> = JsonMissing.of(),
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("sending_phone_number")
            @ExcludeMissing
            sendingPhoneNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sending_phone_number_profile_id")
            @ExcludeMissing
            sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sending_whatsapp_number_profile_id")
            @ExcludeMissing
            sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("short_name")
            @ExcludeMissing
            shortName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("whatsapp_phone_number")
            @ExcludeMissing
            whatsappPhoneNumber: JsonField<String> = JsonMissing.of(),
        ) : this(
            allowContactSharing,
            allowNumberChangeDuringOnboarding,
            allowTemplateSharing,
            billingContact,
            billingModel,
            brand,
            description,
            icon,
            inheritContacts,
            inheritTcrBrand,
            inheritTcrCampaign,
            inheritTemplates,
            name,
            paymentDetails,
            sandbox,
            sendingPhoneNumber,
            sendingPhoneNumberProfileId,
            sendingWhatsappNumberProfileId,
            shortName,
            whatsappPhoneNumber,
            mutableMapOf(),
        )

        /**
         * Whether contacts are shared across profiles (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowContactSharing(): Optional<Boolean> =
            allowContactSharing.getOptional("allow_contact_sharing")

        /**
         * Whether number changes are allowed during onboarding (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowNumberChangeDuringOnboarding(): Optional<Boolean> =
            allowNumberChangeDuringOnboarding.getOptional("allow_number_change_during_onboarding")

        /**
         * Whether templates are shared across profiles (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowTemplateSharing(): Optional<Boolean> =
            allowTemplateSharing.getOptional("allow_template_sharing")

        /**
         * Billing contact information for a profile. Required when billing_model is "profile" or
         * "profile_and_organization".
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun billingContact(): Optional<BillingContact> =
            billingContact.getOptional("billing_contact")

        /**
         * Billing model: profile, organization, or profile_and_organization (optional).
         * - "organization": the organization's billing details are used; no profile-level billing
         *   info needed.
         * - "profile": the profile is billed independently; billing_contact is required.
         * - "profile_and_organization": the profile is billed first with the organization as
         *   fallback; billing_contact is required.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun billingModel(): Optional<String> = billingModel.getOptional("billing_model")

        /**
         * Brand and KYC data grouped into contact, business, and compliance sections
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun brand(): Optional<Brand> = brand.getOptional("brand")

        /**
         * Profile description (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Profile icon URL (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun icon(): Optional<String> = icon.getOptional("icon")

        /**
         * Whether this profile inherits contacts from organization (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritContacts(): Optional<Boolean> = inheritContacts.getOptional("inherit_contacts")

        /**
         * Whether this profile inherits TCR brand from organization (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrBrand(): Optional<Boolean> = inheritTcrBrand.getOptional("inherit_tcr_brand")

        /**
         * Whether this profile inherits TCR campaign from organization (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrCampaign(): Optional<Boolean> =
            inheritTcrCampaign.getOptional("inherit_tcr_campaign")

        /**
         * Whether this profile inherits templates from organization (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTemplates(): Optional<Boolean> =
            inheritTemplates.getOptional("inherit_templates")

        /**
         * Profile name (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Payment card details for a profile. Accepted when billing_model is "profile" or
         * "profile_and_organization". These details are not stored on our servers and will be
         * forwarded to the payment processor.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun paymentDetails(): Optional<PaymentDetails> =
            paymentDetails.getOptional("payment_details")

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Direct phone number for SMS sending (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingPhoneNumber(): Optional<String> =
            sendingPhoneNumber.getOptional("sending_phone_number")

        /**
         * Reference to another profile to use for SMS/Telnyx configuration (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingPhoneNumberProfileId(): Optional<String> =
            sendingPhoneNumberProfileId.getOptional("sending_phone_number_profile_id")

        /**
         * Reference to another profile to use for WhatsApp configuration (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingWhatsappNumberProfileId(): Optional<String> =
            sendingWhatsappNumberProfileId.getOptional("sending_whatsapp_number_profile_id")

        /**
         * Profile short name/abbreviation (optional). Must be 3–11 characters, contain only
         * letters, numbers, and spaces, and include at least one letter. Example: "SALES", "Mkt 2",
         * "Support1".
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortName(): Optional<String> = shortName.getOptional("short_name")

        /**
         * Direct phone number for WhatsApp sending (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun whatsappPhoneNumber(): Optional<String> =
            whatsappPhoneNumber.getOptional("whatsapp_phone_number")

        /**
         * Returns the raw JSON value of [allowContactSharing].
         *
         * Unlike [allowContactSharing], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("allow_contact_sharing")
        @ExcludeMissing
        fun _allowContactSharing(): JsonField<Boolean> = allowContactSharing

        /**
         * Returns the raw JSON value of [allowNumberChangeDuringOnboarding].
         *
         * Unlike [allowNumberChangeDuringOnboarding], this method doesn't throw if the JSON field
         * has an unexpected type.
         */
        @JsonProperty("allow_number_change_during_onboarding")
        @ExcludeMissing
        fun _allowNumberChangeDuringOnboarding(): JsonField<Boolean> =
            allowNumberChangeDuringOnboarding

        /**
         * Returns the raw JSON value of [allowTemplateSharing].
         *
         * Unlike [allowTemplateSharing], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("allow_template_sharing")
        @ExcludeMissing
        fun _allowTemplateSharing(): JsonField<Boolean> = allowTemplateSharing

        /**
         * Returns the raw JSON value of [billingContact].
         *
         * Unlike [billingContact], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("billing_contact")
        @ExcludeMissing
        fun _billingContact(): JsonField<BillingContact> = billingContact

        /**
         * Returns the raw JSON value of [billingModel].
         *
         * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected
         * type.
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
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [icon].
         *
         * Unlike [icon], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("icon") @ExcludeMissing fun _icon(): JsonField<String> = icon

        /**
         * Returns the raw JSON value of [inheritContacts].
         *
         * Unlike [inheritContacts], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inherit_contacts")
        @ExcludeMissing
        fun _inheritContacts(): JsonField<Boolean> = inheritContacts

        /**
         * Returns the raw JSON value of [inheritTcrBrand].
         *
         * Unlike [inheritTcrBrand], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inherit_tcr_brand")
        @ExcludeMissing
        fun _inheritTcrBrand(): JsonField<Boolean> = inheritTcrBrand

        /**
         * Returns the raw JSON value of [inheritTcrCampaign].
         *
         * Unlike [inheritTcrCampaign], this method doesn't throw if the JSON field has an
         * unexpected type.
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
         * Returns the raw JSON value of [paymentDetails].
         *
         * Unlike [paymentDetails], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("payment_details")
        @ExcludeMissing
        fun _paymentDetails(): JsonField<PaymentDetails> = paymentDetails

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [sendingPhoneNumber].
         *
         * Unlike [sendingPhoneNumber], this method doesn't throw if the JSON field has an
         * unexpected type.
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
         * Unlike [sendingWhatsappNumberProfileId], this method doesn't throw if the JSON field has
         * an unexpected type.
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
         * Returns the raw JSON value of [whatsappPhoneNumber].
         *
         * Unlike [whatsappPhoneNumber], this method doesn't throw if the JSON field has an
         * unexpected type.
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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var allowContactSharing: JsonField<Boolean> = JsonMissing.of()
            private var allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of()
            private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
            private var billingContact: JsonField<BillingContact> = JsonMissing.of()
            private var billingModel: JsonField<String> = JsonMissing.of()
            private var brand: JsonField<Brand> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var icon: JsonField<String> = JsonMissing.of()
            private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
            private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var paymentDetails: JsonField<PaymentDetails> = JsonMissing.of()
            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var sendingPhoneNumber: JsonField<String> = JsonMissing.of()
            private var sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of()
            private var sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of()
            private var shortName: JsonField<String> = JsonMissing.of()
            private var whatsappPhoneNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                allowContactSharing = body.allowContactSharing
                allowNumberChangeDuringOnboarding = body.allowNumberChangeDuringOnboarding
                allowTemplateSharing = body.allowTemplateSharing
                billingContact = body.billingContact
                billingModel = body.billingModel
                brand = body.brand
                description = body.description
                icon = body.icon
                inheritContacts = body.inheritContacts
                inheritTcrBrand = body.inheritTcrBrand
                inheritTcrCampaign = body.inheritTcrCampaign
                inheritTemplates = body.inheritTemplates
                name = body.name
                paymentDetails = body.paymentDetails
                sandbox = body.sandbox
                sendingPhoneNumber = body.sendingPhoneNumber
                sendingPhoneNumberProfileId = body.sendingPhoneNumberProfileId
                sendingWhatsappNumberProfileId = body.sendingWhatsappNumberProfileId
                shortName = body.shortName
                whatsappPhoneNumber = body.whatsappPhoneNumber
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Whether contacts are shared across profiles (optional) */
            fun allowContactSharing(allowContactSharing: Boolean?) =
                allowContactSharing(JsonField.ofNullable(allowContactSharing))

            /**
             * Alias for [Builder.allowContactSharing].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun allowContactSharing(allowContactSharing: Boolean) =
                allowContactSharing(allowContactSharing as Boolean?)

            /**
             * Alias for calling [Builder.allowContactSharing] with
             * `allowContactSharing.orElse(null)`.
             */
            fun allowContactSharing(allowContactSharing: Optional<Boolean>) =
                allowContactSharing(allowContactSharing.getOrNull())

            /**
             * Sets [Builder.allowContactSharing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowContactSharing] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun allowContactSharing(allowContactSharing: JsonField<Boolean>) = apply {
                this.allowContactSharing = allowContactSharing
            }

            /** Whether number changes are allowed during onboarding (optional) */
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

            /** Whether templates are shared across profiles (optional) */
            fun allowTemplateSharing(allowTemplateSharing: Boolean?) =
                allowTemplateSharing(JsonField.ofNullable(allowTemplateSharing))

            /**
             * Alias for [Builder.allowTemplateSharing].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun allowTemplateSharing(allowTemplateSharing: Boolean) =
                allowTemplateSharing(allowTemplateSharing as Boolean?)

            /**
             * Alias for calling [Builder.allowTemplateSharing] with
             * `allowTemplateSharing.orElse(null)`.
             */
            fun allowTemplateSharing(allowTemplateSharing: Optional<Boolean>) =
                allowTemplateSharing(allowTemplateSharing.getOrNull())

            /**
             * Sets [Builder.allowTemplateSharing] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowTemplateSharing] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun allowTemplateSharing(allowTemplateSharing: JsonField<Boolean>) = apply {
                this.allowTemplateSharing = allowTemplateSharing
            }

            /**
             * Billing contact information for a profile. Required when billing_model is "profile"
             * or "profile_and_organization".
             */
            fun billingContact(billingContact: BillingContact?) =
                billingContact(JsonField.ofNullable(billingContact))

            /** Alias for calling [Builder.billingContact] with `billingContact.orElse(null)`. */
            fun billingContact(billingContact: Optional<BillingContact>) =
                billingContact(billingContact.getOrNull())

            /**
             * Sets [Builder.billingContact] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billingContact] with a well-typed [BillingContact]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun billingContact(billingContact: JsonField<BillingContact>) = apply {
                this.billingContact = billingContact
            }

            /**
             * Billing model: profile, organization, or profile_and_organization (optional).
             * - "organization": the organization's billing details are used; no profile-level
             *   billing info needed.
             * - "profile": the profile is billed independently; billing_contact is required.
             * - "profile_and_organization": the profile is billed first with the organization as
             *   fallback; billing_contact is required.
             */
            fun billingModel(billingModel: String?) =
                billingModel(JsonField.ofNullable(billingModel))

            /** Alias for calling [Builder.billingModel] with `billingModel.orElse(null)`. */
            fun billingModel(billingModel: Optional<String>) =
                billingModel(billingModel.getOrNull())

            /**
             * Sets [Builder.billingModel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billingModel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun billingModel(billingModel: JsonField<String>) = apply {
                this.billingModel = billingModel
            }

            /** Brand and KYC data grouped into contact, business, and compliance sections */
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

            /** Profile description (optional) */
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

            /** Profile icon URL (optional) */
            fun icon(icon: String?) = icon(JsonField.ofNullable(icon))

            /** Alias for calling [Builder.icon] with `icon.orElse(null)`. */
            fun icon(icon: Optional<String>) = icon(icon.getOrNull())

            /**
             * Sets [Builder.icon] to an arbitrary JSON value.
             *
             * You should usually call [Builder.icon] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun icon(icon: JsonField<String>) = apply { this.icon = icon }

            /** Whether this profile inherits contacts from organization (optional) */
            fun inheritContacts(inheritContacts: Boolean?) =
                inheritContacts(JsonField.ofNullable(inheritContacts))

            /**
             * Alias for [Builder.inheritContacts].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun inheritContacts(inheritContacts: Boolean) =
                inheritContacts(inheritContacts as Boolean?)

            /** Alias for calling [Builder.inheritContacts] with `inheritContacts.orElse(null)`. */
            fun inheritContacts(inheritContacts: Optional<Boolean>) =
                inheritContacts(inheritContacts.getOrNull())

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

            /** Whether this profile inherits TCR brand from organization (optional) */
            fun inheritTcrBrand(inheritTcrBrand: Boolean?) =
                inheritTcrBrand(JsonField.ofNullable(inheritTcrBrand))

            /**
             * Alias for [Builder.inheritTcrBrand].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun inheritTcrBrand(inheritTcrBrand: Boolean) =
                inheritTcrBrand(inheritTcrBrand as Boolean?)

            /** Alias for calling [Builder.inheritTcrBrand] with `inheritTcrBrand.orElse(null)`. */
            fun inheritTcrBrand(inheritTcrBrand: Optional<Boolean>) =
                inheritTcrBrand(inheritTcrBrand.getOrNull())

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

            /** Whether this profile inherits TCR campaign from organization (optional) */
            fun inheritTcrCampaign(inheritTcrCampaign: Boolean?) =
                inheritTcrCampaign(JsonField.ofNullable(inheritTcrCampaign))

            /**
             * Alias for [Builder.inheritTcrCampaign].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun inheritTcrCampaign(inheritTcrCampaign: Boolean) =
                inheritTcrCampaign(inheritTcrCampaign as Boolean?)

            /**
             * Alias for calling [Builder.inheritTcrCampaign] with
             * `inheritTcrCampaign.orElse(null)`.
             */
            fun inheritTcrCampaign(inheritTcrCampaign: Optional<Boolean>) =
                inheritTcrCampaign(inheritTcrCampaign.getOrNull())

            /**
             * Sets [Builder.inheritTcrCampaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inheritTcrCampaign] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun inheritTcrCampaign(inheritTcrCampaign: JsonField<Boolean>) = apply {
                this.inheritTcrCampaign = inheritTcrCampaign
            }

            /** Whether this profile inherits templates from organization (optional) */
            fun inheritTemplates(inheritTemplates: Boolean?) =
                inheritTemplates(JsonField.ofNullable(inheritTemplates))

            /**
             * Alias for [Builder.inheritTemplates].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun inheritTemplates(inheritTemplates: Boolean) =
                inheritTemplates(inheritTemplates as Boolean?)

            /**
             * Alias for calling [Builder.inheritTemplates] with `inheritTemplates.orElse(null)`.
             */
            fun inheritTemplates(inheritTemplates: Optional<Boolean>) =
                inheritTemplates(inheritTemplates.getOrNull())

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

            /** Profile name (optional) */
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

            /**
             * Payment card details for a profile. Accepted when billing_model is "profile" or
             * "profile_and_organization". These details are not stored on our servers and will be
             * forwarded to the payment processor.
             */
            fun paymentDetails(paymentDetails: PaymentDetails?) =
                paymentDetails(JsonField.ofNullable(paymentDetails))

            /** Alias for calling [Builder.paymentDetails] with `paymentDetails.orElse(null)`. */
            fun paymentDetails(paymentDetails: Optional<PaymentDetails>) =
                paymentDetails(paymentDetails.getOrNull())

            /**
             * Sets [Builder.paymentDetails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.paymentDetails] with a well-typed [PaymentDetails]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun paymentDetails(paymentDetails: JsonField<PaymentDetails>) = apply {
                this.paymentDetails = paymentDetails
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

            /** Direct phone number for SMS sending (optional) */
            fun sendingPhoneNumber(sendingPhoneNumber: String?) =
                sendingPhoneNumber(JsonField.ofNullable(sendingPhoneNumber))

            /**
             * Alias for calling [Builder.sendingPhoneNumber] with
             * `sendingPhoneNumber.orElse(null)`.
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

            /** Reference to another profile to use for SMS/Telnyx configuration (optional) */
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
             * You should usually call [Builder.sendingPhoneNumberProfileId] with a well-typed
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun sendingPhoneNumberProfileId(sendingPhoneNumberProfileId: JsonField<String>) =
                apply {
                    this.sendingPhoneNumberProfileId = sendingPhoneNumberProfileId
                }

            /** Reference to another profile to use for WhatsApp configuration (optional) */
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
             * [String] value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun sendingWhatsappNumberProfileId(sendingWhatsappNumberProfileId: JsonField<String>) =
                apply {
                    this.sendingWhatsappNumberProfileId = sendingWhatsappNumberProfileId
                }

            /**
             * Profile short name/abbreviation (optional). Must be 3–11 characters, contain only
             * letters, numbers, and spaces, and include at least one letter. Example: "SALES", "Mkt
             * 2", "Support1".
             */
            fun shortName(shortName: String?) = shortName(JsonField.ofNullable(shortName))

            /** Alias for calling [Builder.shortName] with `shortName.orElse(null)`. */
            fun shortName(shortName: Optional<String>) = shortName(shortName.getOrNull())

            /**
             * Sets [Builder.shortName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shortName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shortName(shortName: JsonField<String>) = apply { this.shortName = shortName }

            /** Direct phone number for WhatsApp sending (optional) */
            fun whatsappPhoneNumber(whatsappPhoneNumber: String?) =
                whatsappPhoneNumber(JsonField.ofNullable(whatsappPhoneNumber))

            /**
             * Alias for calling [Builder.whatsappPhoneNumber] with
             * `whatsappPhoneNumber.orElse(null)`.
             */
            fun whatsappPhoneNumber(whatsappPhoneNumber: Optional<String>) =
                whatsappPhoneNumber(whatsappPhoneNumber.getOrNull())

            /**
             * Sets [Builder.whatsappPhoneNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.whatsappPhoneNumber] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    allowContactSharing,
                    allowNumberChangeDuringOnboarding,
                    allowTemplateSharing,
                    billingContact,
                    billingModel,
                    brand,
                    description,
                    icon,
                    inheritContacts,
                    inheritTcrBrand,
                    inheritTcrCampaign,
                    inheritTemplates,
                    name,
                    paymentDetails,
                    sandbox,
                    sendingPhoneNumber,
                    sendingPhoneNumberProfileId,
                    sendingWhatsappNumberProfileId,
                    shortName,
                    whatsappPhoneNumber,
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

            allowContactSharing()
            allowNumberChangeDuringOnboarding()
            allowTemplateSharing()
            billingContact().ifPresent { it.validate() }
            billingModel()
            brand().ifPresent { it.validate() }
            description()
            icon()
            inheritContacts()
            inheritTcrBrand()
            inheritTcrCampaign()
            inheritTemplates()
            name()
            paymentDetails().ifPresent { it.validate() }
            sandbox()
            sendingPhoneNumber()
            sendingPhoneNumberProfileId()
            sendingWhatsappNumberProfileId()
            shortName()
            whatsappPhoneNumber()
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
            (if (allowContactSharing.asKnown().isPresent) 1 else 0) +
                (if (allowNumberChangeDuringOnboarding.asKnown().isPresent) 1 else 0) +
                (if (allowTemplateSharing.asKnown().isPresent) 1 else 0) +
                (billingContact.asKnown().getOrNull()?.validity() ?: 0) +
                (if (billingModel.asKnown().isPresent) 1 else 0) +
                (brand.asKnown().getOrNull()?.validity() ?: 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (icon.asKnown().isPresent) 1 else 0) +
                (if (inheritContacts.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrBrand.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrCampaign.asKnown().isPresent) 1 else 0) +
                (if (inheritTemplates.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (paymentDetails.asKnown().getOrNull()?.validity() ?: 0) +
                (if (sandbox.asKnown().isPresent) 1 else 0) +
                (if (sendingPhoneNumber.asKnown().isPresent) 1 else 0) +
                (if (sendingPhoneNumberProfileId.asKnown().isPresent) 1 else 0) +
                (if (sendingWhatsappNumberProfileId.asKnown().isPresent) 1 else 0) +
                (if (shortName.asKnown().isPresent) 1 else 0) +
                (if (whatsappPhoneNumber.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                allowContactSharing == other.allowContactSharing &&
                allowNumberChangeDuringOnboarding == other.allowNumberChangeDuringOnboarding &&
                allowTemplateSharing == other.allowTemplateSharing &&
                billingContact == other.billingContact &&
                billingModel == other.billingModel &&
                brand == other.brand &&
                description == other.description &&
                icon == other.icon &&
                inheritContacts == other.inheritContacts &&
                inheritTcrBrand == other.inheritTcrBrand &&
                inheritTcrCampaign == other.inheritTcrCampaign &&
                inheritTemplates == other.inheritTemplates &&
                name == other.name &&
                paymentDetails == other.paymentDetails &&
                sandbox == other.sandbox &&
                sendingPhoneNumber == other.sendingPhoneNumber &&
                sendingPhoneNumberProfileId == other.sendingPhoneNumberProfileId &&
                sendingWhatsappNumberProfileId == other.sendingWhatsappNumberProfileId &&
                shortName == other.shortName &&
                whatsappPhoneNumber == other.whatsappPhoneNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                allowContactSharing,
                allowNumberChangeDuringOnboarding,
                allowTemplateSharing,
                billingContact,
                billingModel,
                brand,
                description,
                icon,
                inheritContacts,
                inheritTcrBrand,
                inheritTcrCampaign,
                inheritTemplates,
                name,
                paymentDetails,
                sandbox,
                sendingPhoneNumber,
                sendingPhoneNumberProfileId,
                sendingWhatsappNumberProfileId,
                shortName,
                whatsappPhoneNumber,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{allowContactSharing=$allowContactSharing, allowNumberChangeDuringOnboarding=$allowNumberChangeDuringOnboarding, allowTemplateSharing=$allowTemplateSharing, billingContact=$billingContact, billingModel=$billingModel, brand=$brand, description=$description, icon=$icon, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, name=$name, paymentDetails=$paymentDetails, sandbox=$sandbox, sendingPhoneNumber=$sendingPhoneNumber, sendingPhoneNumberProfileId=$sendingPhoneNumberProfileId, sendingWhatsappNumberProfileId=$sendingWhatsappNumberProfileId, shortName=$shortName, whatsappPhoneNumber=$whatsappPhoneNumber, additionalProperties=$additionalProperties}"
    }

    /**
     * Billing contact information for a profile. Required when billing_model is "profile" or
     * "profile_and_organization".
     */
    class BillingContact
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val email: JsonField<String>,
        private val name: JsonField<String>,
        private val address: JsonField<String>,
        private val phone: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
        ) : this(email, name, address, phone, mutableMapOf())

        /**
         * Email address where invoices will be sent (required)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun email(): String = email.getRequired("email")

        /**
         * Full name of the billing contact or company (required)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun name(): String = name.getRequired("name")

        /**
         * Billing address (optional). Free-form text including street, city, state, postal code,
         * and country.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun address(): Optional<String> = address.getOptional("address")

        /**
         * Phone number for the billing contact (optional)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phone(): Optional<String> = phone.getOptional("phone")

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
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

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

            /**
             * Returns a mutable builder for constructing an instance of [BillingContact].
             *
             * The following fields are required:
             * ```java
             * .email()
             * .name()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [BillingContact]. */
        class Builder internal constructor() {

            private var email: JsonField<String>? = null
            private var name: JsonField<String>? = null
            private var address: JsonField<String> = JsonMissing.of()
            private var phone: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(billingContact: BillingContact) = apply {
                email = billingContact.email
                name = billingContact.name
                address = billingContact.address
                phone = billingContact.phone
                additionalProperties = billingContact.additionalProperties.toMutableMap()
            }

            /** Email address where invoices will be sent (required) */
            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            /** Full name of the billing contact or company (required) */
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
             * Billing address (optional). Free-form text including street, city, state, postal
             * code, and country.
             */
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

            /** Phone number for the billing contact (optional) */
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
             *
             * The following fields are required:
             * ```java
             * .email()
             * .name()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): BillingContact =
                BillingContact(
                    checkRequired("email", email),
                    checkRequired("name", name),
                    address,
                    phone,
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
        fun validate(): BillingContact = apply {
            if (validated) {
                return@apply
            }

            email()
            name()
            address()
            phone()
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
            (if (email.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (address.asKnown().isPresent) 1 else 0) +
                (if (phone.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is BillingContact &&
                email == other.email &&
                name == other.name &&
                address == other.address &&
                phone == other.phone &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(email, name, address, phone, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BillingContact{email=$email, name=$name, address=$address, phone=$phone, additionalProperties=$additionalProperties}"
    }

    /** Brand and KYC data grouped into contact, business, and compliance sections */
    class Brand
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val compliance: JsonField<Compliance>,
        private val contact: JsonField<Contact>,
        private val business: JsonField<Business>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("compliance")
            @ExcludeMissing
            compliance: JsonField<Compliance> = JsonMissing.of(),
            @JsonProperty("contact") @ExcludeMissing contact: JsonField<Contact> = JsonMissing.of(),
            @JsonProperty("business")
            @ExcludeMissing
            business: JsonField<Business> = JsonMissing.of(),
        ) : this(compliance, contact, business, mutableMapOf())

        /**
         * Compliance and TCR information for brand registration
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun compliance(): Compliance = compliance.getRequired("compliance")

        /**
         * Contact information for brand KYC
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contact(): Contact = contact.getRequired("contact")

        /**
         * Business details and address for brand KYC
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun business(): Optional<Business> = business.getOptional("business")

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
         * Returns the raw JSON value of [business].
         *
         * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("business") @ExcludeMissing fun _business(): JsonField<Business> = business

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
             * Returns a mutable builder for constructing an instance of [Brand].
             *
             * The following fields are required:
             * ```java
             * .compliance()
             * .contact()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Brand]. */
        class Builder internal constructor() {

            private var compliance: JsonField<Compliance>? = null
            private var contact: JsonField<Contact>? = null
            private var business: JsonField<Business> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(brand: Brand) = apply {
                compliance = brand.compliance
                contact = brand.contact
                business = brand.business
                additionalProperties = brand.additionalProperties.toMutableMap()
            }

            /** Compliance and TCR information for brand registration */
            fun compliance(compliance: Compliance) = compliance(JsonField.of(compliance))

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

            /** Contact information for brand KYC */
            fun contact(contact: Contact) = contact(JsonField.of(contact))

            /**
             * Sets [Builder.contact] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contact] with a well-typed [Contact] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contact(contact: JsonField<Contact>) = apply { this.contact = contact }

            /** Business details and address for brand KYC */
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
             *
             * The following fields are required:
             * ```java
             * .compliance()
             * .contact()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Brand =
                Brand(
                    checkRequired("compliance", compliance),
                    checkRequired("contact", contact),
                    business,
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
        fun validate(): Brand = apply {
            if (validated) {
                return@apply
            }

            compliance().validate()
            contact().validate()
            business().ifPresent { it.validate() }
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
            (compliance.asKnown().getOrNull()?.validity() ?: 0) +
                (contact.asKnown().getOrNull()?.validity() ?: 0) +
                (business.asKnown().getOrNull()?.validity() ?: 0)

        /** Compliance and TCR information for brand registration */
        class Compliance
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val brandRelationship: JsonField<BrandRelationship>,
            private val vertical: JsonField<Vertical>,
            private val destinationCountries: JsonField<List<DestinationCountry>>,
            private val expectedMessagingVolume: JsonField<String>,
            private val isTcrApplication: JsonField<Boolean>,
            private val notes: JsonField<String>,
            private val phoneNumberPrefix: JsonField<String>,
            private val primaryUseCase: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("brandRelationship")
                @ExcludeMissing
                brandRelationship: JsonField<BrandRelationship> = JsonMissing.of(),
                @JsonProperty("vertical")
                @ExcludeMissing
                vertical: JsonField<Vertical> = JsonMissing.of(),
                @JsonProperty("destinationCountries")
                @ExcludeMissing
                destinationCountries: JsonField<List<DestinationCountry>> = JsonMissing.of(),
                @JsonProperty("expectedMessagingVolume")
                @ExcludeMissing
                expectedMessagingVolume: JsonField<String> = JsonMissing.of(),
                @JsonProperty("isTcrApplication")
                @ExcludeMissing
                isTcrApplication: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phoneNumberPrefix")
                @ExcludeMissing
                phoneNumberPrefix: JsonField<String> = JsonMissing.of(),
                @JsonProperty("primaryUseCase")
                @ExcludeMissing
                primaryUseCase: JsonField<String> = JsonMissing.of(),
            ) : this(
                brandRelationship,
                vertical,
                destinationCountries,
                expectedMessagingVolume,
                isTcrApplication,
                notes,
                phoneNumberPrefix,
                primaryUseCase,
                mutableMapOf(),
            )

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun brandRelationship(): BrandRelationship =
                brandRelationship.getRequired("brandRelationship")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun vertical(): Vertical = vertical.getRequired("vertical")

            /**
             * List of destination countries for messaging
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun destinationCountries(): Optional<List<DestinationCountry>> =
                destinationCountries.getOptional("destinationCountries")

            /**
             * Expected daily messaging volume
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun expectedMessagingVolume(): Optional<String> =
                expectedMessagingVolume.getOptional("expectedMessagingVolume")

            /**
             * Whether this is a TCR (Campaign Registry) application
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun isTcrApplication(): Optional<Boolean> =
                isTcrApplication.getOptional("isTcrApplication")

            /**
             * Additional notes about the business or use case
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun notes(): Optional<String> = notes.getOptional("notes")

            /**
             * Phone number prefix for messaging (e.g., "+1")
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phoneNumberPrefix(): Optional<String> =
                phoneNumberPrefix.getOptional("phoneNumberPrefix")

            /**
             * Primary messaging use case description
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun primaryUseCase(): Optional<String> = primaryUseCase.getOptional("primaryUseCase")

            /**
             * Returns the raw JSON value of [brandRelationship].
             *
             * Unlike [brandRelationship], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("brandRelationship")
            @ExcludeMissing
            fun _brandRelationship(): JsonField<BrandRelationship> = brandRelationship

            /**
             * Returns the raw JSON value of [vertical].
             *
             * Unlike [vertical], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("vertical")
            @ExcludeMissing
            fun _vertical(): JsonField<Vertical> = vertical

            /**
             * Returns the raw JSON value of [destinationCountries].
             *
             * Unlike [destinationCountries], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("destinationCountries")
            @ExcludeMissing
            fun _destinationCountries(): JsonField<List<DestinationCountry>> = destinationCountries

            /**
             * Returns the raw JSON value of [expectedMessagingVolume].
             *
             * Unlike [expectedMessagingVolume], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("expectedMessagingVolume")
            @ExcludeMissing
            fun _expectedMessagingVolume(): JsonField<String> = expectedMessagingVolume

            /**
             * Returns the raw JSON value of [isTcrApplication].
             *
             * Unlike [isTcrApplication], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("isTcrApplication")
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
            @JsonProperty("phoneNumberPrefix")
            @ExcludeMissing
            fun _phoneNumberPrefix(): JsonField<String> = phoneNumberPrefix

            /**
             * Returns the raw JSON value of [primaryUseCase].
             *
             * Unlike [primaryUseCase], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("primaryUseCase")
            @ExcludeMissing
            fun _primaryUseCase(): JsonField<String> = primaryUseCase

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
                 * Returns a mutable builder for constructing an instance of [Compliance].
                 *
                 * The following fields are required:
                 * ```java
                 * .brandRelationship()
                 * .vertical()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Compliance]. */
            class Builder internal constructor() {

                private var brandRelationship: JsonField<BrandRelationship>? = null
                private var vertical: JsonField<Vertical>? = null
                private var destinationCountries: JsonField<MutableList<DestinationCountry>>? = null
                private var expectedMessagingVolume: JsonField<String> = JsonMissing.of()
                private var isTcrApplication: JsonField<Boolean> = JsonMissing.of()
                private var notes: JsonField<String> = JsonMissing.of()
                private var phoneNumberPrefix: JsonField<String> = JsonMissing.of()
                private var primaryUseCase: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(compliance: Compliance) = apply {
                    brandRelationship = compliance.brandRelationship
                    vertical = compliance.vertical
                    destinationCountries =
                        compliance.destinationCountries.map { it.toMutableList() }
                    expectedMessagingVolume = compliance.expectedMessagingVolume
                    isTcrApplication = compliance.isTcrApplication
                    notes = compliance.notes
                    phoneNumberPrefix = compliance.phoneNumberPrefix
                    primaryUseCase = compliance.primaryUseCase
                    additionalProperties = compliance.additionalProperties.toMutableMap()
                }

                fun brandRelationship(brandRelationship: BrandRelationship) =
                    brandRelationship(JsonField.of(brandRelationship))

                /**
                 * Sets [Builder.brandRelationship] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.brandRelationship] with a well-typed
                 * [BrandRelationship] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun brandRelationship(brandRelationship: JsonField<BrandRelationship>) = apply {
                    this.brandRelationship = brandRelationship
                }

                fun vertical(vertical: Vertical) = vertical(JsonField.of(vertical))

                /**
                 * Sets [Builder.vertical] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vertical] with a well-typed [Vertical] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun vertical(vertical: JsonField<Vertical>) = apply { this.vertical = vertical }

                /** List of destination countries for messaging */
                fun destinationCountries(destinationCountries: List<DestinationCountry>?) =
                    destinationCountries(JsonField.ofNullable(destinationCountries))

                /**
                 * Alias for calling [Builder.destinationCountries] with
                 * `destinationCountries.orElse(null)`.
                 */
                fun destinationCountries(destinationCountries: Optional<List<DestinationCountry>>) =
                    destinationCountries(destinationCountries.getOrNull())

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
                fun isTcrApplication(isTcrApplication: Boolean?) =
                    isTcrApplication(JsonField.ofNullable(isTcrApplication))

                /**
                 * Alias for [Builder.isTcrApplication].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun isTcrApplication(isTcrApplication: Boolean) =
                    isTcrApplication(isTcrApplication as Boolean?)

                /**
                 * Alias for calling [Builder.isTcrApplication] with
                 * `isTcrApplication.orElse(null)`.
                 */
                fun isTcrApplication(isTcrApplication: Optional<Boolean>) =
                    isTcrApplication(isTcrApplication.getOrNull())

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
                 *
                 * The following fields are required:
                 * ```java
                 * .brandRelationship()
                 * .vertical()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Compliance =
                    Compliance(
                        checkRequired("brandRelationship", brandRelationship),
                        checkRequired("vertical", vertical),
                        (destinationCountries ?: JsonMissing.of()).map { it.toImmutable() },
                        expectedMessagingVolume,
                        isTcrApplication,
                        notes,
                        phoneNumberPrefix,
                        primaryUseCase,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): Compliance = apply {
                if (validated) {
                    return@apply
                }

                brandRelationship().validate()
                vertical().validate()
                destinationCountries().ifPresent { it.forEach { it.validate() } }
                expectedMessagingVolume()
                isTcrApplication()
                notes()
                phoneNumberPrefix()
                primaryUseCase()
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
                (brandRelationship.asKnown().getOrNull()?.validity() ?: 0) +
                    (vertical.asKnown().getOrNull()?.validity() ?: 0) +
                    (destinationCountries.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                        ?: 0) +
                    (if (expectedMessagingVolume.asKnown().isPresent) 1 else 0) +
                    (if (isTcrApplication.asKnown().isPresent) 1 else 0) +
                    (if (notes.asKnown().isPresent) 1 else 0) +
                    (if (phoneNumberPrefix.asKnown().isPresent) 1 else 0) +
                    (if (primaryUseCase.asKnown().isPresent) 1 else 0)

            class BrandRelationship
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val BASIC_ACCOUNT = of("BASIC_ACCOUNT")

                    @JvmField val MEDIUM_ACCOUNT = of("MEDIUM_ACCOUNT")

                    @JvmField val LARGE_ACCOUNT = of("LARGE_ACCOUNT")

                    @JvmField val SMALL_ACCOUNT = of("SMALL_ACCOUNT")

                    @JvmField val KEY_ACCOUNT = of("KEY_ACCOUNT")

                    @JvmStatic fun of(value: String) = BrandRelationship(JsonField.of(value))
                }

                /** An enum containing [BrandRelationship]'s known values. */
                enum class Known {
                    BASIC_ACCOUNT,
                    MEDIUM_ACCOUNT,
                    LARGE_ACCOUNT,
                    SMALL_ACCOUNT,
                    KEY_ACCOUNT,
                }

                /**
                 * An enum containing [BrandRelationship]'s known values, as well as an [_UNKNOWN]
                 * member.
                 *
                 * An instance of [BrandRelationship] can contain an unknown value in a couple of
                 * cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    BASIC_ACCOUNT,
                    MEDIUM_ACCOUNT,
                    LARGE_ACCOUNT,
                    SMALL_ACCOUNT,
                    KEY_ACCOUNT,
                    /**
                     * An enum member indicating that [BrandRelationship] was instantiated with an
                     * unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        BASIC_ACCOUNT -> Value.BASIC_ACCOUNT
                        MEDIUM_ACCOUNT -> Value.MEDIUM_ACCOUNT
                        LARGE_ACCOUNT -> Value.LARGE_ACCOUNT
                        SMALL_ACCOUNT -> Value.SMALL_ACCOUNT
                        KEY_ACCOUNT -> Value.KEY_ACCOUNT
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
                        BASIC_ACCOUNT -> Known.BASIC_ACCOUNT
                        MEDIUM_ACCOUNT -> Known.MEDIUM_ACCOUNT
                        LARGE_ACCOUNT -> Known.LARGE_ACCOUNT
                        SMALL_ACCOUNT -> Known.SMALL_ACCOUNT
                        KEY_ACCOUNT -> Known.KEY_ACCOUNT
                        else -> throw SentInvalidDataException("Unknown BrandRelationship: $value")
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
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): BrandRelationship = apply {
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

                    return other is BrandRelationship && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class Vertical @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val PROFESSIONAL = of("PROFESSIONAL")

                    @JvmField val REAL_ESTATE = of("REAL_ESTATE")

                    @JvmField val HEALTHCARE = of("HEALTHCARE")

                    @JvmField val HUMAN_RESOURCES = of("HUMAN_RESOURCES")

                    @JvmField val ENERGY = of("ENERGY")

                    @JvmField val ENTERTAINMENT = of("ENTERTAINMENT")

                    @JvmField val RETAIL = of("RETAIL")

                    @JvmField val TRANSPORTATION = of("TRANSPORTATION")

                    @JvmField val AGRICULTURE = of("AGRICULTURE")

                    @JvmField val INSURANCE = of("INSURANCE")

                    @JvmField val POSTAL = of("POSTAL")

                    @JvmField val EDUCATION = of("EDUCATION")

                    @JvmField val HOSPITALITY = of("HOSPITALITY")

                    @JvmField val FINANCIAL = of("FINANCIAL")

                    @JvmField val POLITICAL = of("POLITICAL")

                    @JvmField val GAMBLING = of("GAMBLING")

                    @JvmField val LEGAL = of("LEGAL")

                    @JvmField val CONSTRUCTION = of("CONSTRUCTION")

                    @JvmField val NGO = of("NGO")

                    @JvmField val MANUFACTURING = of("MANUFACTURING")

                    @JvmField val GOVERNMENT = of("GOVERNMENT")

                    @JvmField val TECHNOLOGY = of("TECHNOLOGY")

                    @JvmField val COMMUNICATION = of("COMMUNICATION")

                    @JvmStatic fun of(value: String) = Vertical(JsonField.of(value))
                }

                /** An enum containing [Vertical]'s known values. */
                enum class Known {
                    PROFESSIONAL,
                    REAL_ESTATE,
                    HEALTHCARE,
                    HUMAN_RESOURCES,
                    ENERGY,
                    ENTERTAINMENT,
                    RETAIL,
                    TRANSPORTATION,
                    AGRICULTURE,
                    INSURANCE,
                    POSTAL,
                    EDUCATION,
                    HOSPITALITY,
                    FINANCIAL,
                    POLITICAL,
                    GAMBLING,
                    LEGAL,
                    CONSTRUCTION,
                    NGO,
                    MANUFACTURING,
                    GOVERNMENT,
                    TECHNOLOGY,
                    COMMUNICATION,
                }

                /**
                 * An enum containing [Vertical]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Vertical] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    PROFESSIONAL,
                    REAL_ESTATE,
                    HEALTHCARE,
                    HUMAN_RESOURCES,
                    ENERGY,
                    ENTERTAINMENT,
                    RETAIL,
                    TRANSPORTATION,
                    AGRICULTURE,
                    INSURANCE,
                    POSTAL,
                    EDUCATION,
                    HOSPITALITY,
                    FINANCIAL,
                    POLITICAL,
                    GAMBLING,
                    LEGAL,
                    CONSTRUCTION,
                    NGO,
                    MANUFACTURING,
                    GOVERNMENT,
                    TECHNOLOGY,
                    COMMUNICATION,
                    /**
                     * An enum member indicating that [Vertical] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        PROFESSIONAL -> Value.PROFESSIONAL
                        REAL_ESTATE -> Value.REAL_ESTATE
                        HEALTHCARE -> Value.HEALTHCARE
                        HUMAN_RESOURCES -> Value.HUMAN_RESOURCES
                        ENERGY -> Value.ENERGY
                        ENTERTAINMENT -> Value.ENTERTAINMENT
                        RETAIL -> Value.RETAIL
                        TRANSPORTATION -> Value.TRANSPORTATION
                        AGRICULTURE -> Value.AGRICULTURE
                        INSURANCE -> Value.INSURANCE
                        POSTAL -> Value.POSTAL
                        EDUCATION -> Value.EDUCATION
                        HOSPITALITY -> Value.HOSPITALITY
                        FINANCIAL -> Value.FINANCIAL
                        POLITICAL -> Value.POLITICAL
                        GAMBLING -> Value.GAMBLING
                        LEGAL -> Value.LEGAL
                        CONSTRUCTION -> Value.CONSTRUCTION
                        NGO -> Value.NGO
                        MANUFACTURING -> Value.MANUFACTURING
                        GOVERNMENT -> Value.GOVERNMENT
                        TECHNOLOGY -> Value.TECHNOLOGY
                        COMMUNICATION -> Value.COMMUNICATION
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
                        PROFESSIONAL -> Known.PROFESSIONAL
                        REAL_ESTATE -> Known.REAL_ESTATE
                        HEALTHCARE -> Known.HEALTHCARE
                        HUMAN_RESOURCES -> Known.HUMAN_RESOURCES
                        ENERGY -> Known.ENERGY
                        ENTERTAINMENT -> Known.ENTERTAINMENT
                        RETAIL -> Known.RETAIL
                        TRANSPORTATION -> Known.TRANSPORTATION
                        AGRICULTURE -> Known.AGRICULTURE
                        INSURANCE -> Known.INSURANCE
                        POSTAL -> Known.POSTAL
                        EDUCATION -> Known.EDUCATION
                        HOSPITALITY -> Known.HOSPITALITY
                        FINANCIAL -> Known.FINANCIAL
                        POLITICAL -> Known.POLITICAL
                        GAMBLING -> Known.GAMBLING
                        LEGAL -> Known.LEGAL
                        CONSTRUCTION -> Known.CONSTRUCTION
                        NGO -> Known.NGO
                        MANUFACTURING -> Known.MANUFACTURING
                        GOVERNMENT -> Known.GOVERNMENT
                        TECHNOLOGY -> Known.TECHNOLOGY
                        COMMUNICATION -> Known.COMMUNICATION
                        else -> throw SentInvalidDataException("Unknown Vertical: $value")
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
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Vertical = apply {
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

                    return other is Vertical && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class DestinationCountry
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val id: JsonField<String>,
                private val isMain: JsonField<Boolean>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("isMain")
                    @ExcludeMissing
                    isMain: JsonField<Boolean> = JsonMissing.of(),
                ) : this(id, isMain, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<String> = id.getOptional("id")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun isMain(): Optional<Boolean> = isMain.getOptional("isMain")

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

                /**
                 * Returns the raw JSON value of [isMain].
                 *
                 * Unlike [isMain], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("isMain") @ExcludeMissing fun _isMain(): JsonField<Boolean> = isMain

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
                     * Returns a mutable builder for constructing an instance of
                     * [DestinationCountry].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [DestinationCountry]. */
                class Builder internal constructor() {

                    private var id: JsonField<String> = JsonMissing.of()
                    private var isMain: JsonField<Boolean> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(destinationCountry: DestinationCountry) = apply {
                        id = destinationCountry.id
                        isMain = destinationCountry.isMain
                        additionalProperties =
                            destinationCountry.additionalProperties.toMutableMap()
                    }

                    fun id(id: String) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    fun isMain(isMain: Boolean) = isMain(JsonField.of(isMain))

                    /**
                     * Sets [Builder.isMain] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.isMain] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun isMain(isMain: JsonField<Boolean>) = apply { this.isMain = isMain }

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
                     * Returns an immutable instance of [DestinationCountry].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): DestinationCountry =
                        DestinationCountry(id, isMain, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): DestinationCountry = apply {
                    if (validated) {
                        return@apply
                    }

                    id()
                    isMain()
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
                    (if (id.asKnown().isPresent) 1 else 0) +
                        (if (isMain.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is DestinationCountry &&
                        id == other.id &&
                        isMain == other.isMain &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(id, isMain, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "DestinationCountry{id=$id, isMain=$isMain, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Compliance &&
                    brandRelationship == other.brandRelationship &&
                    vertical == other.vertical &&
                    destinationCountries == other.destinationCountries &&
                    expectedMessagingVolume == other.expectedMessagingVolume &&
                    isTcrApplication == other.isTcrApplication &&
                    notes == other.notes &&
                    phoneNumberPrefix == other.phoneNumberPrefix &&
                    primaryUseCase == other.primaryUseCase &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    brandRelationship,
                    vertical,
                    destinationCountries,
                    expectedMessagingVolume,
                    isTcrApplication,
                    notes,
                    phoneNumberPrefix,
                    primaryUseCase,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Compliance{brandRelationship=$brandRelationship, vertical=$vertical, destinationCountries=$destinationCountries, expectedMessagingVolume=$expectedMessagingVolume, isTcrApplication=$isTcrApplication, notes=$notes, phoneNumberPrefix=$phoneNumberPrefix, primaryUseCase=$primaryUseCase, additionalProperties=$additionalProperties}"
        }

        /** Contact information for brand KYC */
        class Contact
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val businessName: JsonField<String>,
            private val email: JsonField<String>,
            private val phone: JsonField<String>,
            private val phoneCountryCode: JsonField<String>,
            private val role: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("businessName")
                @ExcludeMissing
                businessName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
                @JsonProperty("phoneCountryCode")
                @ExcludeMissing
                phoneCountryCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            ) : this(name, businessName, email, phone, phoneCountryCode, role, mutableMapOf())

            /**
             * Primary contact name (required)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun name(): String = name.getRequired("name")

            /**
             * Business/brand name
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun businessName(): Optional<String> = businessName.getOptional("businessName")

            /**
             * Contact email address
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun email(): Optional<String> = email.getOptional("email")

            /**
             * Contact phone number in E.164 format
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phone(): Optional<String> = phone.getOptional("phone")

            /**
             * Contact phone country code (e.g., "1" for US)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun phoneCountryCode(): Optional<String> =
                phoneCountryCode.getOptional("phoneCountryCode")

            /**
             * Contact's role in the business
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun role(): Optional<String> = role.getOptional("role")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [businessName].
             *
             * Unlike [businessName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("businessName")
            @ExcludeMissing
            fun _businessName(): JsonField<String> = businessName

            /**
             * Returns the raw JSON value of [email].
             *
             * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

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
            @JsonProperty("phoneCountryCode")
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

                /**
                 * Returns a mutable builder for constructing an instance of [Contact].
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Contact]. */
            class Builder internal constructor() {

                private var name: JsonField<String>? = null
                private var businessName: JsonField<String> = JsonMissing.of()
                private var email: JsonField<String> = JsonMissing.of()
                private var phone: JsonField<String> = JsonMissing.of()
                private var phoneCountryCode: JsonField<String> = JsonMissing.of()
                private var role: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(contact: Contact) = apply {
                    name = contact.name
                    businessName = contact.businessName
                    email = contact.email
                    phone = contact.phone
                    phoneCountryCode = contact.phoneCountryCode
                    role = contact.role
                    additionalProperties = contact.additionalProperties.toMutableMap()
                }

                /** Primary contact name (required) */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

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
                 *
                 * The following fields are required:
                 * ```java
                 * .name()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Contact =
                    Contact(
                        checkRequired("name", name),
                        businessName,
                        email,
                        phone,
                        phoneCountryCode,
                        role,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): Contact = apply {
                if (validated) {
                    return@apply
                }

                name()
                businessName()
                email()
                phone()
                phoneCountryCode()
                role()
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
                (if (name.asKnown().isPresent) 1 else 0) +
                    (if (businessName.asKnown().isPresent) 1 else 0) +
                    (if (email.asKnown().isPresent) 1 else 0) +
                    (if (phone.asKnown().isPresent) 1 else 0) +
                    (if (phoneCountryCode.asKnown().isPresent) 1 else 0) +
                    (if (role.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Contact &&
                    name == other.name &&
                    businessName == other.businessName &&
                    email == other.email &&
                    phone == other.phone &&
                    phoneCountryCode == other.phoneCountryCode &&
                    role == other.role &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    name,
                    businessName,
                    email,
                    phone,
                    phoneCountryCode,
                    role,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Contact{name=$name, businessName=$businessName, email=$email, phone=$phone, phoneCountryCode=$phoneCountryCode, role=$role, additionalProperties=$additionalProperties}"
        }

        /** Business details and address for brand KYC */
        class Business
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val city: JsonField<String>,
            private val country: JsonField<String>,
            private val countryOfRegistration: JsonField<String>,
            private val entityType: JsonField<EntityType>,
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
                @JsonProperty("countryOfRegistration")
                @ExcludeMissing
                countryOfRegistration: JsonField<String> = JsonMissing.of(),
                @JsonProperty("entityType")
                @ExcludeMissing
                entityType: JsonField<EntityType> = JsonMissing.of(),
                @JsonProperty("legalName")
                @ExcludeMissing
                legalName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("postalCode")
                @ExcludeMissing
                postalCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
                @JsonProperty("street")
                @ExcludeMissing
                street: JsonField<String> = JsonMissing.of(),
                @JsonProperty("taxId") @ExcludeMissing taxId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("taxIdType")
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
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun city(): Optional<String> = city.getOptional("city")

            /**
             * Country code (e.g., US, CA)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun country(): Optional<String> = country.getOptional("country")

            /**
             * Country where the business is registered
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun countryOfRegistration(): Optional<String> =
                countryOfRegistration.getOptional("countryOfRegistration")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun entityType(): Optional<EntityType> = entityType.getOptional("entityType")

            /**
             * Legal business name
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun legalName(): Optional<String> = legalName.getOptional("legalName")

            /**
             * Postal/ZIP code
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun postalCode(): Optional<String> = postalCode.getOptional("postalCode")

            /**
             * State/province code
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun state(): Optional<String> = state.getOptional("state")

            /**
             * Street address
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun street(): Optional<String> = street.getOptional("street")

            /**
             * Tax ID/EIN number
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun taxId(): Optional<String> = taxId.getOptional("taxId")

            /**
             * Type of tax ID (e.g., us_ein, ca_bn)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun taxIdType(): Optional<String> = taxIdType.getOptional("taxIdType")

            /**
             * Business website URL
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
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
            @JsonProperty("countryOfRegistration")
            @ExcludeMissing
            fun _countryOfRegistration(): JsonField<String> = countryOfRegistration

            /**
             * Returns the raw JSON value of [entityType].
             *
             * Unlike [entityType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("entityType")
            @ExcludeMissing
            fun _entityType(): JsonField<EntityType> = entityType

            /**
             * Returns the raw JSON value of [legalName].
             *
             * Unlike [legalName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("legalName")
            @ExcludeMissing
            fun _legalName(): JsonField<String> = legalName

            /**
             * Returns the raw JSON value of [postalCode].
             *
             * Unlike [postalCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("postalCode")
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
            @JsonProperty("taxId") @ExcludeMissing fun _taxId(): JsonField<String> = taxId

            /**
             * Returns the raw JSON value of [taxIdType].
             *
             * Unlike [taxIdType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("taxIdType")
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
                private var entityType: JsonField<EntityType> = JsonMissing.of()
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

                fun entityType(entityType: EntityType?) =
                    entityType(JsonField.ofNullable(entityType))

                /** Alias for calling [Builder.entityType] with `entityType.orElse(null)`. */
                fun entityType(entityType: Optional<EntityType>) =
                    entityType(entityType.getOrNull())

                /**
                 * Sets [Builder.entityType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.entityType] with a well-typed [EntityType] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun entityType(entityType: JsonField<EntityType>) = apply {
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
            fun validate(): Business = apply {
                if (validated) {
                    return@apply
                }

                city()
                country()
                countryOfRegistration()
                entityType().ifPresent { it.validate() }
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
                (if (city.asKnown().isPresent) 1 else 0) +
                    (if (country.asKnown().isPresent) 1 else 0) +
                    (if (countryOfRegistration.asKnown().isPresent) 1 else 0) +
                    (entityType.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (legalName.asKnown().isPresent) 1 else 0) +
                    (if (postalCode.asKnown().isPresent) 1 else 0) +
                    (if (state.asKnown().isPresent) 1 else 0) +
                    (if (street.asKnown().isPresent) 1 else 0) +
                    (if (taxId.asKnown().isPresent) 1 else 0) +
                    (if (taxIdType.asKnown().isPresent) 1 else 0) +
                    (if (url.asKnown().isPresent) 1 else 0)

            class EntityType
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val PRIVATE_PROFIT = of("PRIVATE_PROFIT")

                    @JvmField val PUBLIC_PROFIT = of("PUBLIC_PROFIT")

                    @JvmField val NON_PROFIT = of("NON_PROFIT")

                    @JvmField val SOLE_PROPRIETOR = of("SOLE_PROPRIETOR")

                    @JvmField val GOVERNMENT = of("GOVERNMENT")

                    @JvmStatic fun of(value: String) = EntityType(JsonField.of(value))
                }

                /** An enum containing [EntityType]'s known values. */
                enum class Known {
                    PRIVATE_PROFIT,
                    PUBLIC_PROFIT,
                    NON_PROFIT,
                    SOLE_PROPRIETOR,
                    GOVERNMENT,
                }

                /**
                 * An enum containing [EntityType]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [EntityType] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    PRIVATE_PROFIT,
                    PUBLIC_PROFIT,
                    NON_PROFIT,
                    SOLE_PROPRIETOR,
                    GOVERNMENT,
                    /**
                     * An enum member indicating that [EntityType] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        PRIVATE_PROFIT -> Value.PRIVATE_PROFIT
                        PUBLIC_PROFIT -> Value.PUBLIC_PROFIT
                        NON_PROFIT -> Value.NON_PROFIT
                        SOLE_PROPRIETOR -> Value.SOLE_PROPRIETOR
                        GOVERNMENT -> Value.GOVERNMENT
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
                        PRIVATE_PROFIT -> Known.PRIVATE_PROFIT
                        PUBLIC_PROFIT -> Known.PUBLIC_PROFIT
                        NON_PROFIT -> Known.NON_PROFIT
                        SOLE_PROPRIETOR -> Known.SOLE_PROPRIETOR
                        GOVERNMENT -> Known.GOVERNMENT
                        else -> throw SentInvalidDataException("Unknown EntityType: $value")
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
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): EntityType = apply {
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

                    return other is EntityType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Brand &&
                compliance == other.compliance &&
                contact == other.contact &&
                business == other.business &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(compliance, contact, business, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Brand{compliance=$compliance, contact=$contact, business=$business, additionalProperties=$additionalProperties}"
    }

    /**
     * Payment card details for a profile. Accepted when billing_model is "profile" or
     * "profile_and_organization". These details are not stored on our servers and will be forwarded
     * to the payment processor.
     */
    class PaymentDetails
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val cardNumber: JsonField<String>,
        private val cvc: JsonField<String>,
        private val expiry: JsonField<String>,
        private val zipCode: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("card_number")
            @ExcludeMissing
            cardNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cvc") @ExcludeMissing cvc: JsonField<String> = JsonMissing.of(),
            @JsonProperty("expiry") @ExcludeMissing expiry: JsonField<String> = JsonMissing.of(),
            @JsonProperty("zip_code") @ExcludeMissing zipCode: JsonField<String> = JsonMissing.of(),
        ) : this(cardNumber, cvc, expiry, zipCode, mutableMapOf())

        /**
         * Card number (digits only, 13–19 characters)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun cardNumber(): String = cardNumber.getRequired("card_number")

        /**
         * Card security code (3–4 digits)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun cvc(): String = cvc.getRequired("cvc")

        /**
         * Card expiry date in MM/YY format (e.g. "09/27")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun expiry(): String = expiry.getRequired("expiry")

        /**
         * Billing ZIP / postal code associated with the card
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun zipCode(): String = zipCode.getRequired("zip_code")

        /**
         * Returns the raw JSON value of [cardNumber].
         *
         * Unlike [cardNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("card_number")
        @ExcludeMissing
        fun _cardNumber(): JsonField<String> = cardNumber

        /**
         * Returns the raw JSON value of [cvc].
         *
         * Unlike [cvc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cvc") @ExcludeMissing fun _cvc(): JsonField<String> = cvc

        /**
         * Returns the raw JSON value of [expiry].
         *
         * Unlike [expiry], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expiry") @ExcludeMissing fun _expiry(): JsonField<String> = expiry

        /**
         * Returns the raw JSON value of [zipCode].
         *
         * Unlike [zipCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("zip_code") @ExcludeMissing fun _zipCode(): JsonField<String> = zipCode

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
             * Returns a mutable builder for constructing an instance of [PaymentDetails].
             *
             * The following fields are required:
             * ```java
             * .cardNumber()
             * .cvc()
             * .expiry()
             * .zipCode()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PaymentDetails]. */
        class Builder internal constructor() {

            private var cardNumber: JsonField<String>? = null
            private var cvc: JsonField<String>? = null
            private var expiry: JsonField<String>? = null
            private var zipCode: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(paymentDetails: PaymentDetails) = apply {
                cardNumber = paymentDetails.cardNumber
                cvc = paymentDetails.cvc
                expiry = paymentDetails.expiry
                zipCode = paymentDetails.zipCode
                additionalProperties = paymentDetails.additionalProperties.toMutableMap()
            }

            /** Card number (digits only, 13–19 characters) */
            fun cardNumber(cardNumber: String) = cardNumber(JsonField.of(cardNumber))

            /**
             * Sets [Builder.cardNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cardNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cardNumber(cardNumber: JsonField<String>) = apply { this.cardNumber = cardNumber }

            /** Card security code (3–4 digits) */
            fun cvc(cvc: String) = cvc(JsonField.of(cvc))

            /**
             * Sets [Builder.cvc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cvc] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun cvc(cvc: JsonField<String>) = apply { this.cvc = cvc }

            /** Card expiry date in MM/YY format (e.g. "09/27") */
            fun expiry(expiry: String) = expiry(JsonField.of(expiry))

            /**
             * Sets [Builder.expiry] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiry] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiry(expiry: JsonField<String>) = apply { this.expiry = expiry }

            /** Billing ZIP / postal code associated with the card */
            fun zipCode(zipCode: String) = zipCode(JsonField.of(zipCode))

            /**
             * Sets [Builder.zipCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.zipCode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun zipCode(zipCode: JsonField<String>) = apply { this.zipCode = zipCode }

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
             * Returns an immutable instance of [PaymentDetails].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .cardNumber()
             * .cvc()
             * .expiry()
             * .zipCode()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PaymentDetails =
                PaymentDetails(
                    checkRequired("cardNumber", cardNumber),
                    checkRequired("cvc", cvc),
                    checkRequired("expiry", expiry),
                    checkRequired("zipCode", zipCode),
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
        fun validate(): PaymentDetails = apply {
            if (validated) {
                return@apply
            }

            cardNumber()
            cvc()
            expiry()
            zipCode()
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
            (if (cardNumber.asKnown().isPresent) 1 else 0) +
                (if (cvc.asKnown().isPresent) 1 else 0) +
                (if (expiry.asKnown().isPresent) 1 else 0) +
                (if (zipCode.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is PaymentDetails &&
                cardNumber == other.cardNumber &&
                cvc == other.cvc &&
                expiry == other.expiry &&
                zipCode == other.zipCode &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(cardNumber, cvc, expiry, zipCode, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PaymentDetails{cardNumber=$cardNumber, cvc=$cvc, expiry=$expiry, zipCode=$zipCode, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileUpdateParams &&
            profileId == other.profileId &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            profileId,
            idempotencyKey,
            xProfileId,
            body,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ProfileUpdateParams{profileId=$profileId, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
