// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.calls

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

/** One leg of a call the price covers */
class CallLeg
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val billedMinutes: JsonField<Int>,
    private val cost: JsonField<Double>,
    private val currency: JsonField<String>,
    private val direction: JsonField<String>,
    private val number: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("billed_minutes")
        @ExcludeMissing
        billedMinutes: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("cost") @ExcludeMissing cost: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("currency") @ExcludeMissing currency: JsonField<String> = JsonMissing.of(),
        @JsonProperty("direction") @ExcludeMissing direction: JsonField<String> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
    ) : this(billedMinutes, cost, currency, direction, number, mutableMapOf())

    /**
     * The whole minutes the leg was billed for
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun billedMinutes(): Optional<Int> = billedMinutes.getOptional("billed_minutes")

    /**
     * What the leg cost, in the same unit as the call's price
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun cost(): Optional<Double> = cost.getOptional("cost")

    /**
     * The currency of the cost: USD
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun currency(): Optional<String> = currency.getOptional("currency")

    /**
     * inbound for the caller's leg to your number, outbound for a leg placed on your behalf
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun direction(): Optional<String> = direction.getOptional("direction")

    /**
     * The phone number the leg reached, in E.164 format: your number for the inbound leg, the
     * number dialed for an outbound one. Null for a leg to one of your app users or a room
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun number(): Optional<String> = number.getOptional("number")

    /**
     * Returns the raw JSON value of [billedMinutes].
     *
     * Unlike [billedMinutes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("billed_minutes")
    @ExcludeMissing
    fun _billedMinutes(): JsonField<Int> = billedMinutes

    /**
     * Returns the raw JSON value of [cost].
     *
     * Unlike [cost], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("cost") @ExcludeMissing fun _cost(): JsonField<Double> = cost

    /**
     * Returns the raw JSON value of [currency].
     *
     * Unlike [currency], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency") @ExcludeMissing fun _currency(): JsonField<String> = currency

    /**
     * Returns the raw JSON value of [direction].
     *
     * Unlike [direction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("direction") @ExcludeMissing fun _direction(): JsonField<String> = direction

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

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

        /** Returns a mutable builder for constructing an instance of [CallLeg]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CallLeg]. */
    class Builder internal constructor() {

        private var billedMinutes: JsonField<Int> = JsonMissing.of()
        private var cost: JsonField<Double> = JsonMissing.of()
        private var currency: JsonField<String> = JsonMissing.of()
        private var direction: JsonField<String> = JsonMissing.of()
        private var number: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(callLeg: CallLeg) = apply {
            billedMinutes = callLeg.billedMinutes
            cost = callLeg.cost
            currency = callLeg.currency
            direction = callLeg.direction
            number = callLeg.number
            additionalProperties = callLeg.additionalProperties.toMutableMap()
        }

        /** The whole minutes the leg was billed for */
        fun billedMinutes(billedMinutes: Int) = billedMinutes(JsonField.of(billedMinutes))

        /**
         * Sets [Builder.billedMinutes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.billedMinutes] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun billedMinutes(billedMinutes: JsonField<Int>) = apply {
            this.billedMinutes = billedMinutes
        }

        /** What the leg cost, in the same unit as the call's price */
        fun cost(cost: Double) = cost(JsonField.of(cost))

        /**
         * Sets [Builder.cost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cost] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cost(cost: JsonField<Double>) = apply { this.cost = cost }

        /** The currency of the cost: USD */
        fun currency(currency: String) = currency(JsonField.of(currency))

        /**
         * Sets [Builder.currency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currency] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun currency(currency: JsonField<String>) = apply { this.currency = currency }

        /** inbound for the caller's leg to your number, outbound for a leg placed on your behalf */
        fun direction(direction: String) = direction(JsonField.of(direction))

        /**
         * Sets [Builder.direction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.direction] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun direction(direction: JsonField<String>) = apply { this.direction = direction }

        /**
         * The phone number the leg reached, in E.164 format: your number for the inbound leg, the
         * number dialed for an outbound one. Null for a leg to one of your app users or a room
         */
        fun number(number: String?) = number(JsonField.ofNullable(number))

        /** Alias for calling [Builder.number] with `number.orElse(null)`. */
        fun number(number: Optional<String>) = number(number.getOrNull())

        /**
         * Sets [Builder.number] to an arbitrary JSON value.
         *
         * You should usually call [Builder.number] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun number(number: JsonField<String>) = apply { this.number = number }

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
         * Returns an immutable instance of [CallLeg].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CallLeg =
            CallLeg(
                billedMinutes,
                cost,
                currency,
                direction,
                number,
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
    fun validate(): CallLeg = apply {
        if (validated) {
            return@apply
        }

        billedMinutes()
        cost()
        currency()
        direction()
        number()
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
        (if (billedMinutes.asKnown().isPresent) 1 else 0) +
            (if (cost.asKnown().isPresent) 1 else 0) +
            (if (currency.asKnown().isPresent) 1 else 0) +
            (if (direction.asKnown().isPresent) 1 else 0) +
            (if (number.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallLeg &&
            billedMinutes == other.billedMinutes &&
            cost == other.cost &&
            currency == other.currency &&
            direction == other.direction &&
            number == other.number &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(billedMinutes, cost, currency, direction, number, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CallLeg{billedMinutes=$billedMinutes, cost=$cost, currency=$currency, direction=$direction, number=$number, additionalProperties=$additionalProperties}"
}
