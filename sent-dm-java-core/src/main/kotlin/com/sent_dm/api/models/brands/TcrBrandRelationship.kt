// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.fasterxml.jackson.annotation.JsonCreator
import com.sent_dm.api.core.Enum
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.errors.SentDmInvalidDataException

class TcrBrandRelationship @JsonCreator private constructor(private val value: JsonField<String>) :
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

        @JvmField val BASIC_ACCOUNT = of("BASIC_ACCOUNT")

        @JvmField val MEDIUM_ACCOUNT = of("MEDIUM_ACCOUNT")

        @JvmField val LARGE_ACCOUNT = of("LARGE_ACCOUNT")

        @JvmField val SMALL_ACCOUNT = of("SMALL_ACCOUNT")

        @JvmField val KEY_ACCOUNT = of("KEY_ACCOUNT")

        @JvmStatic fun of(value: String) = TcrBrandRelationship(JsonField.of(value))
    }

    /** An enum containing [TcrBrandRelationship]'s known values. */
    enum class Known {
        BASIC_ACCOUNT,
        MEDIUM_ACCOUNT,
        LARGE_ACCOUNT,
        SMALL_ACCOUNT,
        KEY_ACCOUNT,
    }

    /**
     * An enum containing [TcrBrandRelationship]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [TcrBrandRelationship] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        BASIC_ACCOUNT,
        MEDIUM_ACCOUNT,
        LARGE_ACCOUNT,
        SMALL_ACCOUNT,
        KEY_ACCOUNT,
        /**
         * An enum member indicating that [TcrBrandRelationship] was instantiated with an unknown
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
            BASIC_ACCOUNT -> Value.BASIC_ACCOUNT
            MEDIUM_ACCOUNT -> Value.MEDIUM_ACCOUNT
            LARGE_ACCOUNT -> Value.LARGE_ACCOUNT
            SMALL_ACCOUNT -> Value.SMALL_ACCOUNT
            KEY_ACCOUNT -> Value.KEY_ACCOUNT
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
            BASIC_ACCOUNT -> Known.BASIC_ACCOUNT
            MEDIUM_ACCOUNT -> Known.MEDIUM_ACCOUNT
            LARGE_ACCOUNT -> Known.LARGE_ACCOUNT
            SMALL_ACCOUNT -> Known.SMALL_ACCOUNT
            KEY_ACCOUNT -> Known.KEY_ACCOUNT
            else -> throw SentDmInvalidDataException("Unknown TcrBrandRelationship: $value")
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

    fun validate(): TcrBrandRelationship = apply {
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

        return other is TcrBrandRelationship && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
