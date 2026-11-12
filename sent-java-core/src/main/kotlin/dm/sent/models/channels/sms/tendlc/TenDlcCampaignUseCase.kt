// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

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
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class TenDlcCampaignUseCase
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val sampleMessages: JsonField<List<JsonValue>>,
    private val useCase: JsonField<UseCase>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("sample_messages")
        @ExcludeMissing
        sampleMessages: JsonField<List<JsonValue>> = JsonMissing.of(),
        @JsonProperty("use_case") @ExcludeMissing useCase: JsonField<UseCase> = JsonMissing.of(),
    ) : this(sampleMessages, useCase, mutableMapOf())

    /**
     * Sample messages. TCR sample1..sample5 for this use case. One to five, each carrying the brand
     * name and an opt-out instruction.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sampleMessages(): List<JsonValue> = sampleMessages.getRequired("sample_messages")

    /**
     * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides those.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun useCase(): UseCase = useCase.getRequired("use_case")

    /**
     * Returns the raw JSON value of [sampleMessages].
     *
     * Unlike [sampleMessages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sample_messages")
    @ExcludeMissing
    fun _sampleMessages(): JsonField<List<JsonValue>> = sampleMessages

    /**
     * Returns the raw JSON value of [useCase].
     *
     * Unlike [useCase], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("use_case") @ExcludeMissing fun _useCase(): JsonField<UseCase> = useCase

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
         * Returns a mutable builder for constructing an instance of [TenDlcCampaignUseCase].
         *
         * The following fields are required:
         * ```java
         * .sampleMessages()
         * .useCase()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TenDlcCampaignUseCase]. */
    class Builder internal constructor() {

        private var sampleMessages: JsonField<MutableList<JsonValue>>? = null
        private var useCase: JsonField<UseCase>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(tenDlcCampaignUseCase: TenDlcCampaignUseCase) = apply {
            sampleMessages = tenDlcCampaignUseCase.sampleMessages.map { it.toMutableList() }
            useCase = tenDlcCampaignUseCase.useCase
            additionalProperties = tenDlcCampaignUseCase.additionalProperties.toMutableMap()
        }

        /**
         * Sample messages. TCR sample1..sample5 for this use case. One to five, each carrying the
         * brand name and an opt-out instruction.
         */
        fun sampleMessages(sampleMessages: List<JsonValue>) =
            sampleMessages(JsonField.of(sampleMessages))

        /**
         * Sets [Builder.sampleMessages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sampleMessages] with a well-typed `List<JsonValue>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun sampleMessages(sampleMessages: JsonField<List<JsonValue>>) = apply {
            this.sampleMessages = sampleMessages.map { it.toMutableList() }
        }

        /**
         * Adds a single [JsonValue] to [sampleMessages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSampleMessage(sampleMessage: JsonValue) = apply {
            sampleMessages =
                (sampleMessages ?: JsonField.of(mutableListOf())).also {
                    checkKnown("sampleMessages", it).add(sampleMessage)
                }
        }

        /**
         * Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides those.
         */
        fun useCase(useCase: UseCase) = useCase(JsonField.of(useCase))

        /**
         * Sets [Builder.useCase] to an arbitrary JSON value.
         *
         * You should usually call [Builder.useCase] with a well-typed [UseCase] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun useCase(useCase: JsonField<UseCase>) = apply { this.useCase = useCase }

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
         * Returns an immutable instance of [TenDlcCampaignUseCase].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .sampleMessages()
         * .useCase()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TenDlcCampaignUseCase =
            TenDlcCampaignUseCase(
                checkRequired("sampleMessages", sampleMessages).map { it.toImmutable() },
                checkRequired("useCase", useCase),
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
    fun validate(): TenDlcCampaignUseCase = apply {
        if (validated) {
            return@apply
        }

        sampleMessages()
        useCase().validate()
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
        (sampleMessages.asKnown().getOrNull()?.size ?: 0) +
            (useCase.asKnown().getOrNull()?.validity() ?: 0)

    /** Use case. What this entry sends. MIXED and LOW_VOLUME are refused — volume decides those. */
    class UseCase @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MARKETING = of("MARKETING")

            @JvmField val ACCOUNT_NOTIFICATION = of("ACCOUNT_NOTIFICATION")

            @JvmField val CUSTOMER_CARE = of("CUSTOMER_CARE")

            @JvmField val FRAUD_ALERT = of("FRAUD_ALERT")

            @JvmField val _2_FA = of("2FA")

            @JvmField val DELIVERY_NOTIFICATION = of("DELIVERY_NOTIFICATION")

            @JvmField val SECURITY_ALERT = of("SECURITY_ALERT")

            @JvmField val M2_M = of("M2M")

            @JvmField val HIGHER_EDUCATION = of("HIGHER_EDUCATION")

            @JvmField val POLLING_VOTING = of("POLLING_VOTING")

            @JvmField val PUBLIC_SERVICE_ANNOUNCEMENT = of("PUBLIC_SERVICE_ANNOUNCEMENT")

            @JvmStatic fun of(value: String) = UseCase(JsonField.of(value))
        }

        /** An enum containing [UseCase]'s known values. */
        enum class Known {
            MARKETING,
            ACCOUNT_NOTIFICATION,
            CUSTOMER_CARE,
            FRAUD_ALERT,
            _2_FA,
            DELIVERY_NOTIFICATION,
            SECURITY_ALERT,
            M2_M,
            HIGHER_EDUCATION,
            POLLING_VOTING,
            PUBLIC_SERVICE_ANNOUNCEMENT,
        }

        /**
         * An enum containing [UseCase]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UseCase] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MARKETING,
            ACCOUNT_NOTIFICATION,
            CUSTOMER_CARE,
            FRAUD_ALERT,
            _2_FA,
            DELIVERY_NOTIFICATION,
            SECURITY_ALERT,
            M2_M,
            HIGHER_EDUCATION,
            POLLING_VOTING,
            PUBLIC_SERVICE_ANNOUNCEMENT,
            /** An enum member indicating that [UseCase] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                MARKETING -> Value.MARKETING
                ACCOUNT_NOTIFICATION -> Value.ACCOUNT_NOTIFICATION
                CUSTOMER_CARE -> Value.CUSTOMER_CARE
                FRAUD_ALERT -> Value.FRAUD_ALERT
                _2_FA -> Value._2_FA
                DELIVERY_NOTIFICATION -> Value.DELIVERY_NOTIFICATION
                SECURITY_ALERT -> Value.SECURITY_ALERT
                M2_M -> Value.M2_M
                HIGHER_EDUCATION -> Value.HIGHER_EDUCATION
                POLLING_VOTING -> Value.POLLING_VOTING
                PUBLIC_SERVICE_ANNOUNCEMENT -> Value.PUBLIC_SERVICE_ANNOUNCEMENT
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                MARKETING -> Known.MARKETING
                ACCOUNT_NOTIFICATION -> Known.ACCOUNT_NOTIFICATION
                CUSTOMER_CARE -> Known.CUSTOMER_CARE
                FRAUD_ALERT -> Known.FRAUD_ALERT
                _2_FA -> Known._2_FA
                DELIVERY_NOTIFICATION -> Known.DELIVERY_NOTIFICATION
                SECURITY_ALERT -> Known.SECURITY_ALERT
                M2_M -> Known.M2_M
                HIGHER_EDUCATION -> Known.HIGHER_EDUCATION
                POLLING_VOTING -> Known.POLLING_VOTING
                PUBLIC_SERVICE_ANNOUNCEMENT -> Known.PUBLIC_SERVICE_ANNOUNCEMENT
                else -> throw SentInvalidDataException("Unknown UseCase: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentInvalidDataException("Value is not a String") }

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
        fun validate(): UseCase = apply {
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

            return other is UseCase && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TenDlcCampaignUseCase &&
            sampleMessages == other.sampleMessages &&
            useCase == other.useCase &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(sampleMessages, useCase, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TenDlcCampaignUseCase{sampleMessages=$sampleMessages, useCase=$useCase, additionalProperties=$additionalProperties}"
}
