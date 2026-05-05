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
import dm.sent.core.Params
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a new sender profile within an organization. Profiles represent different brands,
 * departments, or use cases, each with their own messaging configuration and settings. Requires
 * admin role in the organization.
 *
 * ## WhatsApp Business Account
 *
 * Every profile must be linked to a WhatsApp Business Account. There are two ways to do this:
 *
 * **1. Inherit from organization (default)** — Omit the `whatsapp_business_account` field. The
 * profile will share the organization's WhatsApp Business Account, which must have been set up via
 * WhatsApp Embedded Signup. This is the recommended path for most use cases.
 *
 * **2. Direct credentials** — Provide a `whatsapp_business_account` object with `waba_id`,
 * `phone_number_id`, and `access_token`. Use this when the profile needs its own independent
 * WhatsApp Business Account. Obtain these from Meta Business Manager by creating a System User with
 * `whatsapp_business_messaging` and `whatsapp_business_management` permissions.
 *
 * If the `whatsapp_business_account` field is omitted and the organization has no WhatsApp Business
 * Account configured, the request will be rejected with HTTP 422.
 *
 * ## Brand
 *
 * Include the optional `brand` field to create the brand for this profile at the same time. Cannot
 * be used when `inherit_tcr_brand` is `true`.
 *
 * ## Payment Details
 *
 * When `billing_model` is `"profile"` or `"profile_and_organization"` you may include a
 * `payment_details` object containing the card number, expiry (MM/YY), CVC, and billing ZIP code.
 * Payment details are **never stored** on our servers and are forwarded directly to the payment
 * processor. Providing `payment_details` when `billing_model` is `"organization"` is not allowed.
 */
class ProfileCreateParams
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
     * Whether contacts are shared across profiles (default: false)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun allowContactSharing(): Optional<Boolean> = body.allowContactSharing()

    /**
     * Whether templates are shared across profiles (default: false)
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
    fun billingContact(): Optional<BillingContactInfo> = body.billingContact()

    /**
     * Billing model: profile, organization, or profile_and_organization (default: profile).
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
    fun brand(): Optional<BrandsBrandData> = body.brand()

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
     * Whether this profile inherits contacts from organization (default: true)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritContacts(): Optional<Boolean> = body.inheritContacts()

    /**
     * Whether this profile inherits TCR brand from organization (default: true)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritTcrBrand(): Optional<Boolean> = body.inheritTcrBrand()

    /**
     * Whether this profile inherits TCR campaign from organization (default: true)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritTcrCampaign(): Optional<Boolean> = body.inheritTcrCampaign()

    /**
     * Whether this profile inherits templates from organization (default: true)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inheritTemplates(): Optional<Boolean> = body.inheritTemplates()

    /**
     * Profile name (required)
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
     * Profile short name/abbreviation (optional). Must be 3–11 characters, contain only letters,
     * numbers, and spaces, and include at least one letter. Example: "SALES", "Mkt 2", "Support1".
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun shortName(): Optional<String> = body.shortName()

    /**
     * Direct WhatsApp Business Account credentials for a profile. Use this when the profile should
     * have its own WhatsApp Business Account instead of inheriting from the organization.
     * Credentials must be obtained from Meta Business Manager by creating a System User with
     * whatsapp_business_messaging and whatsapp_business_management scopes.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun whatsappBusinessAccount(): Optional<WhatsappBusinessAccount> =
        body.whatsappBusinessAccount()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [allowContactSharing].
     *
     * Unlike [allowContactSharing], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _allowContactSharing(): JsonField<Boolean> = body._allowContactSharing()

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
    fun _billingContact(): JsonField<BillingContactInfo> = body._billingContact()

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
    fun _brand(): JsonField<BrandsBrandData> = body._brand()

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
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _shortName(): JsonField<String> = body._shortName()

    /**
     * Returns the raw JSON value of [whatsappBusinessAccount].
     *
     * Unlike [whatsappBusinessAccount], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _whatsappBusinessAccount(): JsonField<WhatsappBusinessAccount> =
        body._whatsappBusinessAccount()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ProfileCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ProfileCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProfileCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(profileCreateParams: ProfileCreateParams) = apply {
            idempotencyKey = profileCreateParams.idempotencyKey
            xProfileId = profileCreateParams.xProfileId
            body = profileCreateParams.body.toBuilder()
            additionalHeaders = profileCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = profileCreateParams.additionalQueryParams.toBuilder()
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
         * - [allowContactSharing]
         * - [allowTemplateSharing]
         * - [billingContact]
         * - [billingModel]
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

        /** Whether contacts are shared across profiles (default: false) */
        fun allowContactSharing(allowContactSharing: Boolean) = apply {
            body.allowContactSharing(allowContactSharing)
        }

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

        /** Whether templates are shared across profiles (default: false) */
        fun allowTemplateSharing(allowTemplateSharing: Boolean) = apply {
            body.allowTemplateSharing(allowTemplateSharing)
        }

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
        fun billingContact(billingContact: BillingContactInfo?) = apply {
            body.billingContact(billingContact)
        }

        /** Alias for calling [Builder.billingContact] with `billingContact.orElse(null)`. */
        fun billingContact(billingContact: Optional<BillingContactInfo>) =
            billingContact(billingContact.getOrNull())

        /**
         * Sets [Builder.billingContact] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billingContact] with a well-typed [BillingContactInfo]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun billingContact(billingContact: JsonField<BillingContactInfo>) = apply {
            body.billingContact(billingContact)
        }

        /**
         * Billing model: profile, organization, or profile_and_organization (default: profile).
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
        fun brand(brand: BrandsBrandData?) = apply { body.brand(brand) }

        /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
        fun brand(brand: Optional<BrandsBrandData>) = brand(brand.getOrNull())

        /**
         * Sets [Builder.brand] to an arbitrary JSON value.
         *
         * You should usually call [Builder.brand] with a well-typed [BrandsBrandData] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun brand(brand: JsonField<BrandsBrandData>) = apply { body.brand(brand) }

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

        /** Whether this profile inherits contacts from organization (default: true) */
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

        /** Whether this profile inherits TCR brand from organization (default: true) */
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

        /** Whether this profile inherits TCR campaign from organization (default: true) */
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

        /** Whether this profile inherits templates from organization (default: true) */
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

        /** Profile name (required) */
        fun name(name: String) = apply { body.name(name) }

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

        /**
         * Direct WhatsApp Business Account credentials for a profile. Use this when the profile
         * should have its own WhatsApp Business Account instead of inheriting from the
         * organization. Credentials must be obtained from Meta Business Manager by creating a
         * System User with whatsapp_business_messaging and whatsapp_business_management scopes.
         */
        fun whatsappBusinessAccount(whatsappBusinessAccount: WhatsappBusinessAccount?) = apply {
            body.whatsappBusinessAccount(whatsappBusinessAccount)
        }

        /**
         * Alias for calling [Builder.whatsappBusinessAccount] with
         * `whatsappBusinessAccount.orElse(null)`.
         */
        fun whatsappBusinessAccount(whatsappBusinessAccount: Optional<WhatsappBusinessAccount>) =
            whatsappBusinessAccount(whatsappBusinessAccount.getOrNull())

        /**
         * Sets [Builder.whatsappBusinessAccount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsappBusinessAccount] with a well-typed
         * [WhatsappBusinessAccount] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun whatsappBusinessAccount(whatsappBusinessAccount: JsonField<WhatsappBusinessAccount>) =
            apply {
                body.whatsappBusinessAccount(whatsappBusinessAccount)
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
         * Returns an immutable instance of [ProfileCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ProfileCreateParams =
            ProfileCreateParams(
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

    /** Request to create a new profile */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val allowContactSharing: JsonField<Boolean>,
        private val allowTemplateSharing: JsonField<Boolean>,
        private val billingContact: JsonField<BillingContactInfo>,
        private val billingModel: JsonField<String>,
        private val brand: JsonField<BrandsBrandData>,
        private val description: JsonField<String>,
        private val icon: JsonField<String>,
        private val inheritContacts: JsonField<Boolean>,
        private val inheritTcrBrand: JsonField<Boolean>,
        private val inheritTcrCampaign: JsonField<Boolean>,
        private val inheritTemplates: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val paymentDetails: JsonField<PaymentDetails>,
        private val shortName: JsonField<String>,
        private val whatsappBusinessAccount: JsonField<WhatsappBusinessAccount>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("allow_contact_sharing")
            @ExcludeMissing
            allowContactSharing: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("allow_template_sharing")
            @ExcludeMissing
            allowTemplateSharing: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("billing_contact")
            @ExcludeMissing
            billingContact: JsonField<BillingContactInfo> = JsonMissing.of(),
            @JsonProperty("billing_model")
            @ExcludeMissing
            billingModel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("brand")
            @ExcludeMissing
            brand: JsonField<BrandsBrandData> = JsonMissing.of(),
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
            @JsonProperty("short_name")
            @ExcludeMissing
            shortName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("whatsapp_business_account")
            @ExcludeMissing
            whatsappBusinessAccount: JsonField<WhatsappBusinessAccount> = JsonMissing.of(),
        ) : this(
            sandbox,
            allowContactSharing,
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
            shortName,
            whatsappBusinessAccount,
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
         * Whether contacts are shared across profiles (default: false)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowContactSharing(): Optional<Boolean> =
            allowContactSharing.getOptional("allow_contact_sharing")

        /**
         * Whether templates are shared across profiles (default: false)
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
        fun billingContact(): Optional<BillingContactInfo> =
            billingContact.getOptional("billing_contact")

        /**
         * Billing model: profile, organization, or profile_and_organization (default: profile).
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
        fun brand(): Optional<BrandsBrandData> = brand.getOptional("brand")

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
         * Whether this profile inherits contacts from organization (default: true)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritContacts(): Optional<Boolean> = inheritContacts.getOptional("inherit_contacts")

        /**
         * Whether this profile inherits TCR brand from organization (default: true)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrBrand(): Optional<Boolean> = inheritTcrBrand.getOptional("inherit_tcr_brand")

        /**
         * Whether this profile inherits TCR campaign from organization (default: true)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrCampaign(): Optional<Boolean> =
            inheritTcrCampaign.getOptional("inherit_tcr_campaign")

        /**
         * Whether this profile inherits templates from organization (default: true)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTemplates(): Optional<Boolean> =
            inheritTemplates.getOptional("inherit_templates")

        /**
         * Profile name (required)
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
         * Profile short name/abbreviation (optional). Must be 3–11 characters, contain only
         * letters, numbers, and spaces, and include at least one letter. Example: "SALES", "Mkt 2",
         * "Support1".
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortName(): Optional<String> = shortName.getOptional("short_name")

        /**
         * Direct WhatsApp Business Account credentials for a profile. Use this when the profile
         * should have its own WhatsApp Business Account instead of inheriting from the
         * organization. Credentials must be obtained from Meta Business Manager by creating a
         * System User with whatsapp_business_messaging and whatsapp_business_management scopes.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun whatsappBusinessAccount(): Optional<WhatsappBusinessAccount> =
            whatsappBusinessAccount.getOptional("whatsapp_business_account")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

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
        fun _billingContact(): JsonField<BillingContactInfo> = billingContact

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
        @JsonProperty("brand") @ExcludeMissing fun _brand(): JsonField<BrandsBrandData> = brand

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
         * Returns the raw JSON value of [shortName].
         *
         * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("short_name") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

        /**
         * Returns the raw JSON value of [whatsappBusinessAccount].
         *
         * Unlike [whatsappBusinessAccount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("whatsapp_business_account")
        @ExcludeMissing
        fun _whatsappBusinessAccount(): JsonField<WhatsappBusinessAccount> = whatsappBusinessAccount

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
            private var allowContactSharing: JsonField<Boolean> = JsonMissing.of()
            private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
            private var billingContact: JsonField<BillingContactInfo> = JsonMissing.of()
            private var billingModel: JsonField<String> = JsonMissing.of()
            private var brand: JsonField<BrandsBrandData> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var icon: JsonField<String> = JsonMissing.of()
            private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
            private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var paymentDetails: JsonField<PaymentDetails> = JsonMissing.of()
            private var shortName: JsonField<String> = JsonMissing.of()
            private var whatsappBusinessAccount: JsonField<WhatsappBusinessAccount> =
                JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                allowContactSharing = body.allowContactSharing
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
                shortName = body.shortName
                whatsappBusinessAccount = body.whatsappBusinessAccount
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

            /** Whether contacts are shared across profiles (default: false) */
            fun allowContactSharing(allowContactSharing: Boolean) =
                allowContactSharing(JsonField.of(allowContactSharing))

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

            /** Whether templates are shared across profiles (default: false) */
            fun allowTemplateSharing(allowTemplateSharing: Boolean) =
                allowTemplateSharing(JsonField.of(allowTemplateSharing))

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
            fun billingContact(billingContact: BillingContactInfo?) =
                billingContact(JsonField.ofNullable(billingContact))

            /** Alias for calling [Builder.billingContact] with `billingContact.orElse(null)`. */
            fun billingContact(billingContact: Optional<BillingContactInfo>) =
                billingContact(billingContact.getOrNull())

            /**
             * Sets [Builder.billingContact] to an arbitrary JSON value.
             *
             * You should usually call [Builder.billingContact] with a well-typed
             * [BillingContactInfo] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun billingContact(billingContact: JsonField<BillingContactInfo>) = apply {
                this.billingContact = billingContact
            }

            /**
             * Billing model: profile, organization, or profile_and_organization (default: profile).
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
            fun brand(brand: BrandsBrandData?) = brand(JsonField.ofNullable(brand))

            /** Alias for calling [Builder.brand] with `brand.orElse(null)`. */
            fun brand(brand: Optional<BrandsBrandData>) = brand(brand.getOrNull())

            /**
             * Sets [Builder.brand] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brand] with a well-typed [BrandsBrandData] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brand(brand: JsonField<BrandsBrandData>) = apply { this.brand = brand }

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

            /** Whether this profile inherits contacts from organization (default: true) */
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

            /** Whether this profile inherits TCR brand from organization (default: true) */
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

            /** Whether this profile inherits TCR campaign from organization (default: true) */
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

            /** Whether this profile inherits templates from organization (default: true) */
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

            /** Profile name (required) */
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

            /**
             * Direct WhatsApp Business Account credentials for a profile. Use this when the profile
             * should have its own WhatsApp Business Account instead of inheriting from the
             * organization. Credentials must be obtained from Meta Business Manager by creating a
             * System User with whatsapp_business_messaging and whatsapp_business_management scopes.
             */
            fun whatsappBusinessAccount(whatsappBusinessAccount: WhatsappBusinessAccount?) =
                whatsappBusinessAccount(JsonField.ofNullable(whatsappBusinessAccount))

            /**
             * Alias for calling [Builder.whatsappBusinessAccount] with
             * `whatsappBusinessAccount.orElse(null)`.
             */
            fun whatsappBusinessAccount(
                whatsappBusinessAccount: Optional<WhatsappBusinessAccount>
            ) = whatsappBusinessAccount(whatsappBusinessAccount.getOrNull())

            /**
             * Sets [Builder.whatsappBusinessAccount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.whatsappBusinessAccount] with a well-typed
             * [WhatsappBusinessAccount] value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun whatsappBusinessAccount(
                whatsappBusinessAccount: JsonField<WhatsappBusinessAccount>
            ) = apply { this.whatsappBusinessAccount = whatsappBusinessAccount }

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
                    allowContactSharing,
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
                    shortName,
                    whatsappBusinessAccount,
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
            allowContactSharing()
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
            shortName()
            whatsappBusinessAccount().ifPresent { it.validate() }
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
                (if (allowContactSharing.asKnown().isPresent) 1 else 0) +
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
                (if (shortName.asKnown().isPresent) 1 else 0) +
                (whatsappBusinessAccount.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                allowContactSharing == other.allowContactSharing &&
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
                shortName == other.shortName &&
                whatsappBusinessAccount == other.whatsappBusinessAccount &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                allowContactSharing,
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
                shortName,
                whatsappBusinessAccount,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, allowContactSharing=$allowContactSharing, allowTemplateSharing=$allowTemplateSharing, billingContact=$billingContact, billingModel=$billingModel, brand=$brand, description=$description, icon=$icon, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, name=$name, paymentDetails=$paymentDetails, shortName=$shortName, whatsappBusinessAccount=$whatsappBusinessAccount, additionalProperties=$additionalProperties}"
    }

    /**
     * Direct WhatsApp Business Account credentials for a profile. Use this when the profile should
     * have its own WhatsApp Business Account instead of inheriting from the organization.
     * Credentials must be obtained from Meta Business Manager by creating a System User with
     * whatsapp_business_messaging and whatsapp_business_management scopes.
     */
    class WhatsappBusinessAccount
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val accessToken: JsonField<String>,
        private val wabaId: JsonField<String>,
        private val phoneNumberId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("access_token")
            @ExcludeMissing
            accessToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("waba_id") @ExcludeMissing wabaId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone_number_id")
            @ExcludeMissing
            phoneNumberId: JsonField<String> = JsonMissing.of(),
        ) : this(accessToken, wabaId, phoneNumberId, mutableMapOf())

        /**
         * System User access token with whatsapp_business_messaging and
         * whatsapp_business_management permissions. This value is stored securely and never
         * returned in API responses.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun accessToken(): String = accessToken.getRequired("access_token")

        /**
         * WhatsApp Business Account ID from Meta Business Manager
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun wabaId(): String = wabaId.getRequired("waba_id")

        /**
         * Phone Number ID of an existing number already registered under this WABA in Meta Business
         * Manager. Optional — when omitted, a number will be provisioned from our pool and
         * registered in the WABA during the onboarding flow. When provided, the number must already
         * exist in the WABA.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun phoneNumberId(): Optional<String> = phoneNumberId.getOptional("phone_number_id")

        /**
         * Returns the raw JSON value of [accessToken].
         *
         * Unlike [accessToken], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("access_token")
        @ExcludeMissing
        fun _accessToken(): JsonField<String> = accessToken

        /**
         * Returns the raw JSON value of [wabaId].
         *
         * Unlike [wabaId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("waba_id") @ExcludeMissing fun _wabaId(): JsonField<String> = wabaId

        /**
         * Returns the raw JSON value of [phoneNumberId].
         *
         * Unlike [phoneNumberId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("phone_number_id")
        @ExcludeMissing
        fun _phoneNumberId(): JsonField<String> = phoneNumberId

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
             * Returns a mutable builder for constructing an instance of [WhatsappBusinessAccount].
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * .wabaId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WhatsappBusinessAccount]. */
        class Builder internal constructor() {

            private var accessToken: JsonField<String>? = null
            private var wabaId: JsonField<String>? = null
            private var phoneNumberId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(whatsappBusinessAccount: WhatsappBusinessAccount) = apply {
                accessToken = whatsappBusinessAccount.accessToken
                wabaId = whatsappBusinessAccount.wabaId
                phoneNumberId = whatsappBusinessAccount.phoneNumberId
                additionalProperties = whatsappBusinessAccount.additionalProperties.toMutableMap()
            }

            /**
             * System User access token with whatsapp_business_messaging and
             * whatsapp_business_management permissions. This value is stored securely and never
             * returned in API responses.
             */
            fun accessToken(accessToken: String) = accessToken(JsonField.of(accessToken))

            /**
             * Sets [Builder.accessToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accessToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accessToken(accessToken: JsonField<String>) = apply {
                this.accessToken = accessToken
            }

            /** WhatsApp Business Account ID from Meta Business Manager */
            fun wabaId(wabaId: String) = wabaId(JsonField.of(wabaId))

            /**
             * Sets [Builder.wabaId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.wabaId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun wabaId(wabaId: JsonField<String>) = apply { this.wabaId = wabaId }

            /**
             * Phone Number ID of an existing number already registered under this WABA in Meta
             * Business Manager. Optional — when omitted, a number will be provisioned from our pool
             * and registered in the WABA during the onboarding flow. When provided, the number must
             * already exist in the WABA.
             */
            fun phoneNumberId(phoneNumberId: String?) =
                phoneNumberId(JsonField.ofNullable(phoneNumberId))

            /** Alias for calling [Builder.phoneNumberId] with `phoneNumberId.orElse(null)`. */
            fun phoneNumberId(phoneNumberId: Optional<String>) =
                phoneNumberId(phoneNumberId.getOrNull())

            /**
             * Sets [Builder.phoneNumberId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.phoneNumberId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun phoneNumberId(phoneNumberId: JsonField<String>) = apply {
                this.phoneNumberId = phoneNumberId
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
             * Returns an immutable instance of [WhatsappBusinessAccount].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * .wabaId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): WhatsappBusinessAccount =
                WhatsappBusinessAccount(
                    checkRequired("accessToken", accessToken),
                    checkRequired("wabaId", wabaId),
                    phoneNumberId,
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
        fun validate(): WhatsappBusinessAccount = apply {
            if (validated) {
                return@apply
            }

            accessToken()
            wabaId()
            phoneNumberId()
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
            (if (accessToken.asKnown().isPresent) 1 else 0) +
                (if (wabaId.asKnown().isPresent) 1 else 0) +
                (if (phoneNumberId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is WhatsappBusinessAccount &&
                accessToken == other.accessToken &&
                wabaId == other.wabaId &&
                phoneNumberId == other.phoneNumberId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(accessToken, wabaId, phoneNumberId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WhatsappBusinessAccount{accessToken=$accessToken, wabaId=$wabaId, phoneNumberId=$phoneNumberId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ProfileCreateParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
