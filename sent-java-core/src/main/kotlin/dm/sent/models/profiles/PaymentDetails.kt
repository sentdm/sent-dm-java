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

/**
 * Payment card details for a profile. Accepted when billing_model is "profile" or
 * "profile_and_organization". These details are not stored on our servers and will be forwarded to
 * the payment processor.
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
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cardNumber(): String = cardNumber.getRequired("card_number")

    /**
     * Card security code (3–4 digits)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cvc(): String = cvc.getRequired("cvc")

    /**
     * Card expiry date in MM/YY format (e.g. "09/27")
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun expiry(): String = expiry.getRequired("expiry")

    /**
     * Billing ZIP / postal code associated with the card
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun zipCode(): String = zipCode.getRequired("zip_code")

    /**
     * Returns the raw JSON value of [cardNumber].
     *
     * Unlike [cardNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("card_number") @ExcludeMissing fun _cardNumber(): JsonField<String> = cardNumber

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
         * You should usually call [Builder.cardNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun cardNumber(cardNumber: JsonField<String>) = apply { this.cardNumber = cardNumber }

        /** Card security code (3–4 digits) */
        fun cvc(cvc: String) = cvc(JsonField.of(cvc))

        /**
         * Sets [Builder.cvc] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cvc] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cvc(cvc: JsonField<String>) = apply { this.cvc = cvc }

        /** Card expiry date in MM/YY format (e.g. "09/27") */
        fun expiry(expiry: String) = expiry(JsonField.of(expiry))

        /**
         * Sets [Builder.expiry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiry] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiry(expiry: JsonField<String>) = apply { this.expiry = expiry }

        /** Billing ZIP / postal code associated with the card */
        fun zipCode(zipCode: String) = zipCode(JsonField.of(zipCode))

        /**
         * Sets [Builder.zipCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.zipCode] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
