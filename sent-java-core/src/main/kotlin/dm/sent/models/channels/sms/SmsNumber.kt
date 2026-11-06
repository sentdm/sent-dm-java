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

/** One number of an SMS market. */
class SmsNumber
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val areaCode: JsonField<String>,
    private val senderValue: JsonField<String>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("area_code") @ExcludeMissing areaCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sender_value")
        @ExcludeMissing
        senderValue: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(areaCode, senderValue, status, mutableMapOf())

    /**
     * The number's area code, e.g. 212. While the number is still to be assigned, the area code it
     * was asked for, or null when it was asked for in any area code.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun areaCode(): Optional<String> = areaCode.getOptional("area_code")

    /**
     * The number, or null while it is still to be assigned.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

    /**
     * ACTIVE once the number can send; PROVISIONING while it is still to be assigned; INACTIVE once
     * it could send and no longer can.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [areaCode].
     *
     * Unlike [areaCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("area_code") @ExcludeMissing fun _areaCode(): JsonField<String> = areaCode

    /**
     * Returns the raw JSON value of [senderValue].
     *
     * Unlike [senderValue], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_value")
    @ExcludeMissing
    fun _senderValue(): JsonField<String> = senderValue

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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

        /** Returns a mutable builder for constructing an instance of [SmsNumber]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SmsNumber]. */
    class Builder internal constructor() {

        private var areaCode: JsonField<String> = JsonMissing.of()
        private var senderValue: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(smsNumber: SmsNumber) = apply {
            areaCode = smsNumber.areaCode
            senderValue = smsNumber.senderValue
            status = smsNumber.status
            additionalProperties = smsNumber.additionalProperties.toMutableMap()
        }

        /**
         * The number's area code, e.g. 212. While the number is still to be assigned, the area code
         * it was asked for, or null when it was asked for in any area code.
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

        /** The number, or null while it is still to be assigned. */
        fun senderValue(senderValue: String?) = senderValue(JsonField.ofNullable(senderValue))

        /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
        fun senderValue(senderValue: Optional<String>) = senderValue(senderValue.getOrNull())

        /**
         * Sets [Builder.senderValue] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderValue] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun senderValue(senderValue: JsonField<String>) = apply { this.senderValue = senderValue }

        /**
         * ACTIVE once the number can send; PROVISIONING while it is still to be assigned; INACTIVE
         * once it could send and no longer can.
         */
        fun status(status: String?) = status(JsonField.ofNullable(status))

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [SmsNumber].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SmsNumber =
            SmsNumber(areaCode, senderValue, status, additionalProperties.toMutableMap())
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
    fun validate(): SmsNumber = apply {
        if (validated) {
            return@apply
        }

        areaCode()
        senderValue()
        status()
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
        (if (areaCode.asKnown().isPresent) 1 else 0) +
            (if (senderValue.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SmsNumber &&
            areaCode == other.areaCode &&
            senderValue == other.senderValue &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(areaCode, senderValue, status, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SmsNumber{areaCode=$areaCode, senderValue=$senderValue, status=$status, additionalProperties=$additionalProperties}"
}
