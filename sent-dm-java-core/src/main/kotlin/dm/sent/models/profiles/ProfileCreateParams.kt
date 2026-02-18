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
 * Creates a new sender profile within an organization. Profiles represent different brands,
 * departments, or use cases, each with their own messaging configuration and settings. Requires
 * admin role in the organization.
 */
class ProfileCreateParams
private constructor(
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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
     * Whether contacts are shared across profiles (default: false)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowContactSharing(): Optional<Boolean> = body.allowContactSharing()

    /**
     * Whether templates are shared across profiles (default: false)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowTemplateSharing(): Optional<Boolean> = body.allowTemplateSharing()

    /**
     * Billing model: profile, organization, or profile_and_organization (default: profile)
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
     * Whether this profile inherits contacts from organization (default: true)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritContacts(): Optional<Boolean> = body.inheritContacts()

    /**
     * Whether this profile inherits TCR brand from organization (default: true)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrBrand(): Optional<Boolean> = body.inheritTcrBrand()

    /**
     * Whether this profile inherits TCR campaign from organization (default: true)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTcrCampaign(): Optional<Boolean> = body.inheritTcrCampaign()

    /**
     * Whether this profile inherits templates from organization (default: true)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inheritTemplates(): Optional<Boolean> = body.inheritTemplates()

    /**
     * Profile name (required)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Profile short name/abbreviation (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun shortName(): Optional<String> = body.shortName()

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
     * Returns the raw JSON value of [shortName].
     *
     * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _shortName(): JsonField<String> = body._shortName()

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
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(profileCreateParams: ProfileCreateParams) = apply {
            idempotencyKey = profileCreateParams.idempotencyKey
            body = profileCreateParams.body.toBuilder()
            additionalHeaders = profileCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = profileCreateParams.additionalQueryParams.toBuilder()
        }

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
         * - [allowTemplateSharing]
         * - [billingModel]
         * - [description]
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

        /** Billing model: profile, organization, or profile_and_organization (default: profile) */
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
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Request to create a new profile */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val testMode: JsonField<Boolean>,
        private val allowContactSharing: JsonField<Boolean>,
        private val allowTemplateSharing: JsonField<Boolean>,
        private val billingModel: JsonField<String>,
        private val description: JsonField<String>,
        private val icon: JsonField<String>,
        private val inheritContacts: JsonField<Boolean>,
        private val inheritTcrBrand: JsonField<Boolean>,
        private val inheritTcrCampaign: JsonField<Boolean>,
        private val inheritTemplates: JsonField<Boolean>,
        private val name: JsonField<String>,
        private val shortName: JsonField<String>,
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
            @JsonProperty("short_name")
            @ExcludeMissing
            shortName: JsonField<String> = JsonMissing.of(),
        ) : this(
            testMode,
            allowContactSharing,
            allowTemplateSharing,
            billingModel,
            description,
            icon,
            inheritContacts,
            inheritTcrBrand,
            inheritTcrCampaign,
            inheritTemplates,
            name,
            shortName,
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
         * Whether contacts are shared across profiles (default: false)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowContactSharing(): Optional<Boolean> =
            allowContactSharing.getOptional("allow_contact_sharing")

        /**
         * Whether templates are shared across profiles (default: false)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowTemplateSharing(): Optional<Boolean> =
            allowTemplateSharing.getOptional("allow_template_sharing")

        /**
         * Billing model: profile, organization, or profile_and_organization (default: profile)
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
         * Whether this profile inherits contacts from organization (default: true)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritContacts(): Optional<Boolean> = inheritContacts.getOptional("inherit_contacts")

        /**
         * Whether this profile inherits TCR brand from organization (default: true)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrBrand(): Optional<Boolean> = inheritTcrBrand.getOptional("inherit_tcr_brand")

        /**
         * Whether this profile inherits TCR campaign from organization (default: true)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTcrCampaign(): Optional<Boolean> =
            inheritTcrCampaign.getOptional("inherit_tcr_campaign")

        /**
         * Whether this profile inherits templates from organization (default: true)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun inheritTemplates(): Optional<Boolean> =
            inheritTemplates.getOptional("inherit_templates")

        /**
         * Profile name (required)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Profile short name/abbreviation (optional)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortName(): Optional<String> = shortName.getOptional("short_name")

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
         * Returns the raw JSON value of [shortName].
         *
         * Unlike [shortName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("short_name") @ExcludeMissing fun _shortName(): JsonField<String> = shortName

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
            private var allowTemplateSharing: JsonField<Boolean> = JsonMissing.of()
            private var billingModel: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var icon: JsonField<String> = JsonMissing.of()
            private var inheritContacts: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrBrand: JsonField<Boolean> = JsonMissing.of()
            private var inheritTcrCampaign: JsonField<Boolean> = JsonMissing.of()
            private var inheritTemplates: JsonField<Boolean> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var shortName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                testMode = body.testMode
                allowContactSharing = body.allowContactSharing
                allowTemplateSharing = body.allowTemplateSharing
                billingModel = body.billingModel
                description = body.description
                icon = body.icon
                inheritContacts = body.inheritContacts
                inheritTcrBrand = body.inheritTcrBrand
                inheritTcrCampaign = body.inheritTcrCampaign
                inheritTemplates = body.inheritTemplates
                name = body.name
                shortName = body.shortName
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
             * Billing model: profile, organization, or profile_and_organization (default: profile)
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
                    allowTemplateSharing,
                    billingModel,
                    description,
                    icon,
                    inheritContacts,
                    inheritTcrBrand,
                    inheritTcrCampaign,
                    inheritTemplates,
                    name,
                    shortName,
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
            allowTemplateSharing()
            billingModel()
            description()
            icon()
            inheritContacts()
            inheritTcrBrand()
            inheritTcrCampaign()
            inheritTemplates()
            name()
            shortName()
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
                (if (allowTemplateSharing.asKnown().isPresent) 1 else 0) +
                (if (billingModel.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (if (icon.asKnown().isPresent) 1 else 0) +
                (if (inheritContacts.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrBrand.asKnown().isPresent) 1 else 0) +
                (if (inheritTcrCampaign.asKnown().isPresent) 1 else 0) +
                (if (inheritTemplates.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (shortName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                testMode == other.testMode &&
                allowContactSharing == other.allowContactSharing &&
                allowTemplateSharing == other.allowTemplateSharing &&
                billingModel == other.billingModel &&
                description == other.description &&
                icon == other.icon &&
                inheritContacts == other.inheritContacts &&
                inheritTcrBrand == other.inheritTcrBrand &&
                inheritTcrCampaign == other.inheritTcrCampaign &&
                inheritTemplates == other.inheritTemplates &&
                name == other.name &&
                shortName == other.shortName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                testMode,
                allowContactSharing,
                allowTemplateSharing,
                billingModel,
                description,
                icon,
                inheritContacts,
                inheritTcrBrand,
                inheritTcrCampaign,
                inheritTemplates,
                name,
                shortName,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{testMode=$testMode, allowContactSharing=$allowContactSharing, allowTemplateSharing=$allowTemplateSharing, billingModel=$billingModel, description=$description, icon=$icon, inheritContacts=$inheritContacts, inheritTcrBrand=$inheritTcrBrand, inheritTcrCampaign=$inheritTcrCampaign, inheritTemplates=$inheritTemplates, name=$name, shortName=$shortName, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProfileCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ProfileCreateParams{idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
