// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import com.fasterxml.jackson.annotation.JsonCreator
import dm.sent.core.Enum
import dm.sent.core.JsonField
import dm.sent.errors.SentDmInvalidDataException

class MessagingUseCaseUs @JsonCreator private constructor(private val value: JsonField<String>) :
    Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val MARKETING = of("MARKETING")

        @JvmField val ACCOUNT_NOTIFICATION = of("ACCOUNT_NOTIFICATION")

        @JvmField val CUSTOMER_CARE = of("CUSTOMER_CARE")

        @JvmField val FRAUD_ALERT = of("FRAUD_ALERT")

        @JvmField val TWO_FA = of("TWO_FA")

        @JvmField val DELIVERY_NOTIFICATION = of("DELIVERY_NOTIFICATION")

        @JvmField val SECURITY_ALERT = of("SECURITY_ALERT")

        @JvmField val M2_M = of("M2M")

        @JvmField val MIXED = of("MIXED")

        @JvmField val HIGHER_EDUCATION = of("HIGHER_EDUCATION")

        @JvmField val POLLING_VOTING = of("POLLING_VOTING")

        @JvmField val PUBLIC_SERVICE_ANNOUNCEMENT = of("PUBLIC_SERVICE_ANNOUNCEMENT")

        @JvmField val LOW_VOLUME = of("LOW_VOLUME")

        @JvmStatic fun of(value: String) = MessagingUseCaseUs(JsonField.of(value))
    }

    /** An enum containing [MessagingUseCaseUs]'s known values. */
    enum class Known {
        MARKETING,
        ACCOUNT_NOTIFICATION,
        CUSTOMER_CARE,
        FRAUD_ALERT,
        TWO_FA,
        DELIVERY_NOTIFICATION,
        SECURITY_ALERT,
        M2_M,
        MIXED,
        HIGHER_EDUCATION,
        POLLING_VOTING,
        PUBLIC_SERVICE_ANNOUNCEMENT,
        LOW_VOLUME,
    }

    /**
     * An enum containing [MessagingUseCaseUs]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [MessagingUseCaseUs] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        MARKETING,
        ACCOUNT_NOTIFICATION,
        CUSTOMER_CARE,
        FRAUD_ALERT,
        TWO_FA,
        DELIVERY_NOTIFICATION,
        SECURITY_ALERT,
        M2_M,
        MIXED,
        HIGHER_EDUCATION,
        POLLING_VOTING,
        PUBLIC_SERVICE_ANNOUNCEMENT,
        LOW_VOLUME,
        /**
         * An enum member indicating that [MessagingUseCaseUs] was instantiated with an unknown
         * value.
         */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            MARKETING -> Value.MARKETING
            ACCOUNT_NOTIFICATION -> Value.ACCOUNT_NOTIFICATION
            CUSTOMER_CARE -> Value.CUSTOMER_CARE
            FRAUD_ALERT -> Value.FRAUD_ALERT
            TWO_FA -> Value.TWO_FA
            DELIVERY_NOTIFICATION -> Value.DELIVERY_NOTIFICATION
            SECURITY_ALERT -> Value.SECURITY_ALERT
            M2_M -> Value.M2_M
            MIXED -> Value.MIXED
            HIGHER_EDUCATION -> Value.HIGHER_EDUCATION
            POLLING_VOTING -> Value.POLLING_VOTING
            PUBLIC_SERVICE_ANNOUNCEMENT -> Value.PUBLIC_SERVICE_ANNOUNCEMENT
            LOW_VOLUME -> Value.LOW_VOLUME
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws SentDmInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            MARKETING -> Known.MARKETING
            ACCOUNT_NOTIFICATION -> Known.ACCOUNT_NOTIFICATION
            CUSTOMER_CARE -> Known.CUSTOMER_CARE
            FRAUD_ALERT -> Known.FRAUD_ALERT
            TWO_FA -> Known.TWO_FA
            DELIVERY_NOTIFICATION -> Known.DELIVERY_NOTIFICATION
            SECURITY_ALERT -> Known.SECURITY_ALERT
            M2_M -> Known.M2_M
            MIXED -> Known.MIXED
            HIGHER_EDUCATION -> Known.HIGHER_EDUCATION
            POLLING_VOTING -> Known.POLLING_VOTING
            PUBLIC_SERVICE_ANNOUNCEMENT -> Known.PUBLIC_SERVICE_ANNOUNCEMENT
            LOW_VOLUME -> Known.LOW_VOLUME
            else -> throw SentDmInvalidDataException("Unknown MessagingUseCaseUs: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws SentDmInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { SentDmInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    fun validate(): MessagingUseCaseUs = apply {
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
        } catch (e: SentDmInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessagingUseCaseUs && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
