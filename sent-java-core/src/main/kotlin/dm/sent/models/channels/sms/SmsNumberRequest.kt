// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * One entry of numbers: how many numbers to assign in one area code, or in any area code when
 * AreaCode is omitted.
 */
class SmsNumberRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val areaCode: JsonField<String>,
    private val quantity: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("area_code") @ExcludeMissing areaCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Int> = JsonMissing.of(),
    ) : this(areaCode, quantity, mutableMapOf())

    /**
     * The area code, e.g. 212, validated against the request's country. Omit it for numbers in any
     * area code.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun areaCode(): Optional<String> = areaCode.getOptional("area_code")

    /**
     * How many numbers. At least 1; omitted means 1.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun quantity(): Optional<Int> = quantity.getOptional("quantity")

    /**
     * Returns the raw JSON value of [areaCode].
     *
     * Unlike [areaCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("area_code") @ExcludeMissing fun _areaCode(): JsonField<String> = areaCode

    /**
     * Returns the raw JSON value of [quantity].
     *
     * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Int> = quantity

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

        /** Returns a mutable builder for constructing an instance of [SmsNumberRequest]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SmsNumberRequest]. */
    class Builder internal constructor() {

        private var areaCode: JsonField<String> = JsonMissing.of()
        private var quantity: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(smsNumberRequest: SmsNumberRequest) = apply {
            areaCode = smsNumberRequest.areaCode
            quantity = smsNumberRequest.quantity
            additionalProperties = smsNumberRequest.additionalProperties.toMutableMap()
        }

        /**
         * The area code, e.g. 212, validated against the request's country. Omit it for numbers in
         * any area code.
         */
        fun areaCode(areaCode: String?) = areaCode(JsonField.ofNullable(areaCode))

        /** Alias for calling [Builder.areaCode] with `areaCode.orElse(null)`. */
        fun areaCode(areaCode: Optional<String>) = areaCode(areaCode.getOrNull())

        /**
         * Sets [Builder.areaCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.areaCode] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun areaCode(areaCode: JsonField<String>) = apply { this.areaCode = areaCode }

        /** How many numbers. At least 1; omitted means 1. */
        fun quantity(quantity: Int?) = quantity(JsonField.ofNullable(quantity))

        /**
         * Alias for [Builder.quantity].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun quantity(quantity: Int) = quantity(quantity as Int?)

        /** Alias for calling [Builder.quantity] with `quantity.orElse(null)`. */
        fun quantity(quantity: Optional<Int>) = quantity(quantity.getOrNull())

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quantity(quantity: JsonField<Int>) = apply { this.quantity = quantity }

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
         * Returns an immutable instance of [SmsNumberRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SmsNumberRequest =
            SmsNumberRequest(areaCode, quantity, additionalProperties.toMutableMap())
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
    fun validate(): SmsNumberRequest = apply {
        if (validated) {
            return@apply
        }

        areaCode()
        quantity()
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
        (if (areaCode.asKnown().isPresent) 1 else 0) + (if (quantity.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SmsNumberRequest &&
            areaCode == other.areaCode &&
            quantity == other.quantity &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(areaCode, quantity, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SmsNumberRequest{areaCode=$areaCode, quantity=$quantity, additionalProperties=$additionalProperties}"
}
