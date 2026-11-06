// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.annotation.JsonCreator
import dm.sent.core.Enum
import dm.sent.core.JsonField
import dm.sent.errors.SentInvalidDataException

class TcrBrandIdentityStatus
@JsonCreator
private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val SELF_DECLARED = of("SELF_DECLARED")

        @JvmField val UNVERIFIED = of("UNVERIFIED")

        @JvmField val VERIFIED = of("VERIFIED")

        @JvmField val VETTED_VERIFIED = of("VETTED_VERIFIED")

        @JvmStatic fun of(value: String) = TcrBrandIdentityStatus(JsonField.of(value))
    }

    /** An enum containing [TcrBrandIdentityStatus]'s known values. */
    enum class Known {
        SELF_DECLARED,
        UNVERIFIED,
        VERIFIED,
        VETTED_VERIFIED,
    }

    /**
     * An enum containing [TcrBrandIdentityStatus]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [TcrBrandIdentityStatus] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        SELF_DECLARED,
        UNVERIFIED,
        VERIFIED,
        VETTED_VERIFIED,
        /**
         * An enum member indicating that [TcrBrandIdentityStatus] was instantiated with an unknown
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
            SELF_DECLARED -> Value.SELF_DECLARED
            UNVERIFIED -> Value.UNVERIFIED
            VERIFIED -> Value.VERIFIED
            VETTED_VERIFIED -> Value.VETTED_VERIFIED
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws SentInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            SELF_DECLARED -> Known.SELF_DECLARED
            UNVERIFIED -> Known.UNVERIFIED
            VERIFIED -> Known.VERIFIED
            VETTED_VERIFIED -> Known.VETTED_VERIFIED
            else -> throw SentInvalidDataException("Unknown TcrBrandIdentityStatus: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws SentInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { SentInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): TcrBrandIdentityStatus = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TcrBrandIdentityStatus && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
