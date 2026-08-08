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
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Brand and KYC data grouped into contact, business, and compliance sections */
class BrandsBrandData
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val compliance: JsonField<BrandComplianceInfo>,
    private val contact: JsonField<BrandContactInfo>,
    private val business: JsonField<BrandBusinessInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("compliance")
        @ExcludeMissing
        compliance: JsonField<BrandComplianceInfo> = JsonMissing.of(),
        @JsonProperty("contact")
        @ExcludeMissing
        contact: JsonField<BrandContactInfo> = JsonMissing.of(),
        @JsonProperty("business")
        @ExcludeMissing
        business: JsonField<BrandBusinessInfo> = JsonMissing.of(),
    ) : this(compliance, contact, business, mutableMapOf())

    /**
     * Compliance and TCR information for brand registration
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun compliance(): BrandComplianceInfo = compliance.getRequired("compliance")

    /**
     * Contact information for brand KYC
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contact(): BrandContactInfo = contact.getRequired("contact")

    /**
     * Business details and address for brand KYC
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun business(): Optional<BrandBusinessInfo> = business.getOptional("business")

    /**
     * Returns the raw JSON value of [compliance].
     *
     * Unlike [compliance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("compliance")
    @ExcludeMissing
    fun _compliance(): JsonField<BrandComplianceInfo> = compliance

    /**
     * Returns the raw JSON value of [contact].
     *
     * Unlike [contact], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact") @ExcludeMissing fun _contact(): JsonField<BrandContactInfo> = contact

    /**
     * Returns the raw JSON value of [business].
     *
     * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("business")
    @ExcludeMissing
    fun _business(): JsonField<BrandBusinessInfo> = business

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
         * Returns a mutable builder for constructing an instance of [BrandsBrandData].
         *
         * The following fields are required:
         * ```java
         * .compliance()
         * .contact()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BrandsBrandData]. */
    class Builder internal constructor() {

        private var compliance: JsonField<BrandComplianceInfo>? = null
        private var contact: JsonField<BrandContactInfo>? = null
        private var business: JsonField<BrandBusinessInfo> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(brandsBrandData: BrandsBrandData) = apply {
            compliance = brandsBrandData.compliance
            contact = brandsBrandData.contact
            business = brandsBrandData.business
            additionalProperties = brandsBrandData.additionalProperties.toMutableMap()
        }

        /** Compliance and TCR information for brand registration */
        fun compliance(compliance: BrandComplianceInfo) = compliance(JsonField.of(compliance))

        /**
         * Sets [Builder.compliance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.compliance] with a well-typed [BrandComplianceInfo]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun compliance(compliance: JsonField<BrandComplianceInfo>) = apply {
            this.compliance = compliance
        }

        /** Contact information for brand KYC */
        fun contact(contact: BrandContactInfo) = contact(JsonField.of(contact))

        /**
         * Sets [Builder.contact] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contact] with a well-typed [BrandContactInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun contact(contact: JsonField<BrandContactInfo>) = apply { this.contact = contact }

        /** Business details and address for brand KYC */
        fun business(business: BrandBusinessInfo?) = business(JsonField.ofNullable(business))

        /** Alias for calling [Builder.business] with `business.orElse(null)`. */
        fun business(business: Optional<BrandBusinessInfo>) = business(business.getOrNull())

        /**
         * Sets [Builder.business] to an arbitrary JSON value.
         *
         * You should usually call [Builder.business] with a well-typed [BrandBusinessInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun business(business: JsonField<BrandBusinessInfo>) = apply { this.business = business }

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
         * Returns an immutable instance of [BrandsBrandData].
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
        fun build(): BrandsBrandData =
            BrandsBrandData(
                checkRequired("compliance", compliance),
                checkRequired("contact", contact),
                business,
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
    fun validate(): BrandsBrandData = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (compliance.asKnown().getOrNull()?.validity() ?: 0) +
            (contact.asKnown().getOrNull()?.validity() ?: 0) +
            (business.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandsBrandData &&
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
        "BrandsBrandData{compliance=$compliance, contact=$contact, business=$business, additionalProperties=$additionalProperties}"
}
