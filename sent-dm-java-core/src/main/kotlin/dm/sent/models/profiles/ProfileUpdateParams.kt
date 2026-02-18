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
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentDmInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates a profile's configuration and settings. Requires admin role in the organization. Only
 * provided fields will be updated (partial update).
 */
class ProfileUpdateParams
private constructor(
    private val pathProfileId: String?,
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun pathProfileId(): Optional<String> = Optional.ofNullable(pathProfileId)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    /**
     * Test mode flag - when true, the operation is simulated without side effects Useful for
     * testing integrations without actual execution
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun testMode(): Optional<Boolean> = body.testMode()

    /**
     * Whether contacts are shared across profiles (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowContactSharing(): Optional<Boolean> = body.allowContactSharing()

    /**
     * Whether number changes are allowed during onboarding (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowNumberChangeDuringOnboarding(): Optional<Boolean> =
        body.allowNumberChangeDuringOnboarding()

    /**
     * Whether templates are shared across profiles (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowTemplateSharing(): Optional<Boolean> = body.allowTemplateSharing()

    /**
     * Billing model: profile, organization, or profile_and_organization (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun billingModel(): Optional<String> = body.billingModel()

    /**
     * Profile description (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = body.description()

    /**
     * Profile icon URL (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun icon(): Optional<String> = body.icon()

    /**
     * Whether this profile inherits contacts from organization (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritContacts(): Optional<Boolean> = body.inheritContacts()

    /**
     * Whether this profile inherits TCR brand from organization (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrBrand(): Optional<Boolean> = body.inheritTcrBrand()

    /**
     * Whether this profile inherits TCR campaign from organization (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrCampaign(): Optional<Boolean> = body.inheritTcrCampaign()

    /**
     * Whether this profile inherits templates from organization (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTemplates(): Optional<Boolean> = body.inheritTemplates()

    /**
     * Profile name (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Profile ID from route parameter
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bodyProfileId(): Optional<String> = body.bodyProfileId()

    /**
     * Direct phone number for SMS sending (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sendingPhoneNumber(): Optional<String> = body.sendingPhoneNumber()

    /**
     * Reference to another profile to use for SMS/Telnyx configuration (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sendingPhoneNumberProfileId(): Optional<String> = body.sendingPhoneNumberProfileId()

    /**
     * Reference to another profile to use for WhatsApp configuration (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sendingWhatsappNumberProfileId(): Optional<String> = body.sendingWhatsappNumberProfileId()

    /**
     * Profile short name/abbreviation (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shortName(): Optional<String> = body.shortName()

    /**
     * Direct phone number for WhatsApp sending (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun whatsappPhoneNumber(): Optional<String> = body.whatsappPhoneNumber()

    /**
     * Returns the raw JSON value of [testMode].
     *
     * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _testMode(): JsonField<Boolean> = body._testMode()

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
     * Returns the raw JSON value of [billingModel].
     *
     * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _billingModel(): JsonField<String> = body._billingModel()

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
     * Returns the raw JSON value of [bodyProfileId].
     *
     * Unlike [bodyProfileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bodyProfileId(): JsonField<String> = body._bodyProfileId()

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

        private var pathProfileId: String? = null
        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(profileUpdateParams: ProfileUpdateParams) = apply {
            pathProfileId = profileUpdateParams.pathProfileId
            idempotencyKey = profileUpdateParams.idempotencyKey
            body = profileUpdateParams.body.toBuilder()
            additionalHeaders = profileUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = profileUpdateParams.additionalQueryParams.toBuilder()
        }

        fun pathProfileId(pathProfileId: String?) = apply { this.pathProfileId = pathProfileId }

        /** Alias for calling [Builder.pathProfileId] with `pathProfileId.orElse(null)`. */
        fun pathProfileId(pathProfileId: Optional<String>) =
            pathProfileId(pathProfileId.getOrNull())

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [testMode]
         * - [allowContactSharing]
         * - [allowNumberChangeDuringOnboarding]
         * - [allowTemplateSharing]
         * - [billingModel]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun testMode(testMode: Boolean) = apply { body.testMode(testMode) }

        /**
         * Sets [Builder.testMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun testMode(testMode: JsonField<Boolean>) = apply { body.testMode(testMode) }

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

        /** Billing model: profile, organization, or profile_and_organization (optional) */
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

        /** Profile ID from route parameter */
        fun bodyProfileId(bodyProfileId: String) = apply { body.bodyProfileId(bodyProfileId) }

        /**
         * Sets [Builder.bodyProfileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bodyProfileId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bodyProfileId(bodyProfileId: JsonField<String>) = apply {
            body.bodyProfileId(bodyProfileId)
        }

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

        /** Profile short name/abbreviation (optional) */
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
                pathProfileId,
                idempotencyKey,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> pathProfileId ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Request to update a profile */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val testMode: JsonField<Boolean>,
        private val allowContactSharing: JsonField<Boolean>,
        private val allowNumberChangeDuringOnboarding: JsonField<Boolean>,
        private val allowTemplateSharing: JsonField<Boolean>,
        private val billingModel: JsonField<String>,
        private val description: JsonField<String>,
        private val icon: JsonField<String>,
        private val inheritContacts: JsonField<Boolean>,
        private val inheritTcrBrand: JsonField<Boolean>,
        private val inheritTcrCampaign: JsonField<Boolean>,
        private val inheritTemplates: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val bodyProfileId: JsonField<String>,
        private val sendingPhoneNumber: JsonField<String>,
        private val sendingPhoneNumberProfileId: JsonField<String>,
        private val sendingWhatsappNumberProfileId: JsonField<String>,
        private val shortName: JsonField<String>,
        private val whatsappPhoneNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("test_mode")
            @ExcludeMissing
            testMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("allow_contact_sharing")
            @ExcludeMissing
            allowContactSharing: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("allow_number_change_during_onboarding")
            @ExcludeMissing
            allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("allow_template_sharing")
            @ExcludeMissing
            allowTemplateSharing: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("billing_model")
            @ExcludeMissing
            billingModel: JsonField<String> = JsonMissing.of(),
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
            @JsonProperty("profile_id")
            @ExcludeMissing
            bodyProfileId: JsonField<String> = JsonMissing.of(),
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
            testMode,
            allowContactSharing,
            allowNumberChangeDuringOnboarding,
            allowTemplateSharing,
            billingModel,
            description,
            icon,
            inheritContacts,
            inheritTcrBrand,
            inheritTcrCampaign,
            inheritTemplates,
            name,
            bodyProfileId,
            sendingPhoneNumber,
            sendingPhoneNumberProfileId,
            sendingWhatsappNumberProfileId,
            shortName,
            whatsappPhoneNumber,
            mutableMapOf(),
        )

        fun toMutationRequest(): MutationRequest =
            MutationRequest.builder().testMode(testMode).build()

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun testMode(): Optional<Boolean> = testMode.getOptional("test_mode")

        /**
         * Whether contacts are shared across profiles (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowContactSharing(): Optional<Boolean> =
            allowContactSharing.getOptional("allow_contact_sharing")

        /**
         * Whether number changes are allowed during onboarding (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowNumberChangeDuringOnboarding(): Optional<Boolean> =
            allowNumberChangeDuringOnboarding.getOptional("allow_number_change_during_onboarding")

        /**
         * Whether templates are shared across profiles (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowTemplateSharing(): Optional<Boolean> =
            allowTemplateSharing.getOptional("allow_template_sharing")

        /**
         * Billing model: profile, organization, or profile_and_organization (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun billingModel(): Optional<String> = billingModel.getOptional("billing_model")

        /**
         * Profile description (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * Profile icon URL (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun icon(): Optional<String> = icon.getOptional("icon")

        /**
         * Whether this profile inherits contacts from organization (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritContacts(): Optional<Boolean> = inheritContacts.getOptional("inherit_contacts")

        /**
         * Whether this profile inherits TCR brand from organization (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrBrand(): Optional<Boolean> = inheritTcrBrand.getOptional("inherit_tcr_brand")

        /**
         * Whether this profile inherits TCR campaign from organization (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrCampaign(): Optional<Boolean> =
            inheritTcrCampaign.getOptional("inherit_tcr_campaign")

        /**
         * Whether this profile inherits templates from organization (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTemplates(): Optional<Boolean> =
            inheritTemplates.getOptional("inherit_templates")

        /**
         * Profile name (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Profile ID from route parameter
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bodyProfileId(): Optional<String> = bodyProfileId.getOptional("profile_id")

        /**
         * Direct phone number for SMS sending (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingPhoneNumber(): Optional<String> =
            sendingPhoneNumber.getOptional("sending_phone_number")

        /**
         * Reference to another profile to use for SMS/Telnyx configuration (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingPhoneNumberProfileId(): Optional<String> =
            sendingPhoneNumberProfileId.getOptional("sending_phone_number_profile_id")

        /**
         * Reference to another profile to use for WhatsApp configuration (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sendingWhatsappNumberProfileId(): Optional<String> =
            sendingWhatsappNumberProfileId.getOptional("sending_whatsapp_number_profile_id")

        /**
         * Profile short name/abbreviation (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortName(): Optional<String> = shortName.getOptional("short_name")

        /**
         * Direct phone number for WhatsApp sending (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun whatsappPhoneNumber(): Optional<String> =
            whatsappPhoneNumber.getOptional("whatsapp_phone_number")

        /**
         * Returns the raw JSON value of [testMode].
         *
         * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("test_mode") @ExcludeMissing fun _testMode(): JsonField<Boolean> = testMode

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
         * Returns the raw JSON value of [billingModel].
         *
         * Unlike [billingModel], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("billing_model")
        @ExcludeMissing
        fun _billingModel(): JsonField<String> = billingModel

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
         * Returns the raw JSON value of [bodyProfileId].
         *
         * Unlike [bodyProfileId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("profile_id")
        @ExcludeMissing
        fun _bodyProfileId(): JsonField<String> = bodyProfileId

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

            private var testMode: JsonField<Boolean> = JsonMissing.of()
            private var allowContactSharing: JsonField<Boolean> = JsonMissing.of()
            private var allowNumberChangeDuringOnboarding: JsonField<Boolean> = JsonMissing.of()
            private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
            private var billingModel: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var icon: JsonField<String> = JsonMissing.of()
            private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
            private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var bodyProfileId: JsonField<String> = JsonMissing.of()
            private var sendingPhoneNumber: JsonField<String> = JsonMissing.of()
            private var sendingPhoneNumberProfileId: JsonField<String> = JsonMissing.of()
            private var sendingWhatsappNumberProfileId: JsonField<String> = JsonMissing.of()
            private var shortName: JsonField<String> = JsonMissing.of()
            private var whatsappPhoneNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                testMode = body.testMode
                allowContactSharing = body.allowContactSharing
                allowNumberChangeDuringOnboarding = body.allowNumberChangeDuringOnboarding
                allowTemplateSharing = body.allowTemplateSharing
                billingModel = body.billingModel
                description = body.description
                icon = body.icon
                inheritContacts = body.inheritContacts
                inheritTcrBrand = body.inheritTcrBrand
                inheritTcrCampaign = body.inheritTcrCampaign
                inheritTemplates = body.inheritTemplates
                name = body.name
                bodyProfileId = body.bodyProfileId
                sendingPhoneNumber = body.sendingPhoneNumber
                sendingPhoneNumberProfileId = body.sendingPhoneNumberProfileId
                sendingWhatsappNumberProfileId = body.sendingWhatsappNumberProfileId
                shortName = body.shortName
                whatsappPhoneNumber = body.whatsappPhoneNumber
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Test mode flag - when true, the operation is simulated without side effects Useful
             * for testing integrations without actual execution
             */
            fun testMode(testMode: Boolean) = testMode(JsonField.of(testMode))

            /**
             * Sets [Builder.testMode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun testMode(testMode: JsonField<Boolean>) = apply { this.testMode = testMode }

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

            /** Billing model: profile, organization, or profile_and_organization (optional) */
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

            /** Profile ID from route parameter */
            fun bodyProfileId(bodyProfileId: String) = bodyProfileId(JsonField.of(bodyProfileId))

            /**
             * Sets [Builder.bodyProfileId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bodyProfileId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bodyProfileId(bodyProfileId: JsonField<String>) = apply {
                this.bodyProfileId = bodyProfileId
            }

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

            /** Profile short name/abbreviation (optional) */
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
                    testMode,
                    allowContactSharing,
                    allowNumberChangeDuringOnboarding,
                    allowTemplateSharing,
                    billingModel,
                    description,
                    icon,
                    inheritContacts,
                    inheritTcrBrand,
                    inheritTcrCampaign,
                    inheritTemplates,
                    name,
                    bodyProfileId,
                    sendingPhoneNumber,
                    sendingPhoneNumberProfileId,
                    sendingWhatsappNumberProfileId,
                    shortName,
                    whatsappPhoneNumber,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            testMode()
            allowContactSharing()
            allowNumberChangeDuringOnboarding()
            allowTemplateSharing()
            billingModel()
            description()
            icon()
            inheritContacts()
            inheritTcrBrand()
            inheritTcrCampaign()
            inheritTemplates()
            name()
            bodyProfileId()
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
            (if (testMode.asKnown().isPresent) 1 else 0) +
                (if (allowContactSharing.asKnown().isPresent) 1 else 0) +
                (if (allowNumberChangeDuringOnboarding.asKnown().isPresent) 1 else 0) +
                (if (allowTemplateSharing.asKnown().isPresent) 1 else 0) +
                (if (billingModel.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (icon.asKnown().isPresent) 1 else 0) +
                (if (inheritContacts.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrBrand.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrCampaign.asKnown().isPresent) 1 else 0) +
                (if (inheritTemplates.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (bodyProfileId.asKnown().isPresent) 1 else 0) +
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
                testMode == other.testMode &&
                allowContactSharing == other.allowContactSharing &&
                allowNumberChangeDuringOnboarding == other.allowNumberChangeDuringOnboarding &&
                allowTemplateSharing == other.allowTemplateSharing &&
                billingModel == other.billingModel &&
                description == other.description &&
                icon == other.icon &&
                inheritContacts == other.inheritContacts &&
                inheritTcrBrand == other.inheritTcrBrand &&
                inheritTcrCampaign == other.inheritTcrCampaign &&
                inheritTemplates == other.inheritTemplates &&
                name == other.name &&
                bodyProfileId == other.bodyProfileId &&
                sendingPhoneNumber == other.sendingPhoneNumber &&
                sendingPhoneNumberProfileId == other.sendingPhoneNumberProfileId &&
                sendingWhatsappNumberProfileId == other.sendingWhatsappNumberProfileId &&
                shortName == other.shortName &&
                whatsappPhoneNumber == other.whatsappPhoneNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                testMode,
                allowContactSharing,
                allowNumberChangeDuringOnboarding,
                allowTemplateSharing,
                billingModel,
                description,
                icon,
                inheritContacts,
                inheritTcrBrand,
                inheritTcrCampaign,
                inheritTemplates,
                name,
                bodyProfileId,
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
            "Body{testMode=$testMode, allowContactSharing=$allowContactSharing, allowNumberChangeDuringOnboarding=$allowNumberChangeDuringOnboarding, allowTemplateSharing=$allowTemplateSharing, billingModel=$billingModel, description=$description, icon=$icon, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, name=$name, bodyProfileId=$bodyProfileId, sendingPhoneNumber=$sendingPhoneNumber, sendingPhoneNumberProfileId=$sendingPhoneNumberProfileId, sendingWhatsappNumberProfileId=$sendingWhatsappNumberProfileId, shortName=$shortName, whatsappPhoneNumber=$whatsappPhoneNumber, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileUpdateParams &&
            pathProfileId == other.pathProfileId &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(pathProfileId, idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ProfileUpdateParams{pathProfileId=$pathProfileId, idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
