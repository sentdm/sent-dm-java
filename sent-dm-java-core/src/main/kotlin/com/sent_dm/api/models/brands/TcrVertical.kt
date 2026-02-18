// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.fasterxml.jackson.annotation.JsonCreator
import com.sent_dm.api.core.Enum
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.errors.SentDmInvalidDataException

class TcrVertical @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val PROFESSIONAL = of("PROFESSIONAL")

        @JvmField val REAL_ESTATE = of("REAL_ESTATE")

        @JvmField val HEALTHCARE = of("HEALTHCARE")

        @JvmField val HUMAN_RESOURCES = of("HUMAN_RESOURCES")

        @JvmField val ENERGY = of("ENERGY")

        @JvmField val ENTERTAINMENT = of("ENTERTAINMENT")

        @JvmField val RETAIL = of("RETAIL")

        @JvmField val TRANSPORTATION = of("TRANSPORTATION")

        @JvmField val AGRICULTURE = of("AGRICULTURE")

        @JvmField val INSURANCE = of("INSURANCE")

        @JvmField val POSTAL = of("POSTAL")

        @JvmField val EDUCATION = of("EDUCATION")

        @JvmField val HOSPITALITY = of("HOSPITALITY")

        @JvmField val FINANCIAL = of("FINANCIAL")

        @JvmField val POLITICAL = of("POLITICAL")

        @JvmField val GAMBLING = of("GAMBLING")

        @JvmField val LEGAL = of("LEGAL")

        @JvmField val CONSTRUCTION = of("CONSTRUCTION")

        @JvmField val NGO = of("NGO")

        @JvmField val MANUFACTURING = of("MANUFACTURING")

        @JvmField val GOVERNMENT = of("GOVERNMENT")

        @JvmField val TECHNOLOGY = of("TECHNOLOGY")

        @JvmField val COMMUNICATION = of("COMMUNICATION")

        @JvmStatic fun of(value: String) = TcrVertical(JsonField.of(value))
    }

    /** An enum containing [TcrVertical]'s known values. */
    enum class Known {
        PROFESSIONAL,
        REAL_ESTATE,
        HEALTHCARE,
        HUMAN_RESOURCES,
        ENERGY,
        ENTERTAINMENT,
        RETAIL,
        TRANSPORTATION,
        AGRICULTURE,
        INSURANCE,
        POSTAL,
        EDUCATION,
        HOSPITALITY,
        FINANCIAL,
        POLITICAL,
        GAMBLING,
        LEGAL,
        CONSTRUCTION,
        NGO,
        MANUFACTURING,
        GOVERNMENT,
        TECHNOLOGY,
        COMMUNICATION,
    }

    /**
     * An enum containing [TcrVertical]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [TcrVertical] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        PROFESSIONAL,
        REAL_ESTATE,
        HEALTHCARE,
        HUMAN_RESOURCES,
        ENERGY,
        ENTERTAINMENT,
        RETAIL,
        TRANSPORTATION,
        AGRICULTURE,
        INSURANCE,
        POSTAL,
        EDUCATION,
        HOSPITALITY,
        FINANCIAL,
        POLITICAL,
        GAMBLING,
        LEGAL,
        CONSTRUCTION,
        NGO,
        MANUFACTURING,
        GOVERNMENT,
        TECHNOLOGY,
        COMMUNICATION,
        /** An enum member indicating that [TcrVertical] was instantiated with an unknown value. */
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
            PROFESSIONAL -> Value.PROFESSIONAL
            REAL_ESTATE -> Value.REAL_ESTATE
            HEALTHCARE -> Value.HEALTHCARE
            HUMAN_RESOURCES -> Value.HUMAN_RESOURCES
            ENERGY -> Value.ENERGY
            ENTERTAINMENT -> Value.ENTERTAINMENT
            RETAIL -> Value.RETAIL
            TRANSPORTATION -> Value.TRANSPORTATION
            AGRICULTURE -> Value.AGRICULTURE
            INSURANCE -> Value.INSURANCE
            POSTAL -> Value.POSTAL
            EDUCATION -> Value.EDUCATION
            HOSPITALITY -> Value.HOSPITALITY
            FINANCIAL -> Value.FINANCIAL
            POLITICAL -> Value.POLITICAL
            GAMBLING -> Value.GAMBLING
            LEGAL -> Value.LEGAL
            CONSTRUCTION -> Value.CONSTRUCTION
            NGO -> Value.NGO
            MANUFACTURING -> Value.MANUFACTURING
            GOVERNMENT -> Value.GOVERNMENT
            TECHNOLOGY -> Value.TECHNOLOGY
            COMMUNICATION -> Value.COMMUNICATION
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
            PROFESSIONAL -> Known.PROFESSIONAL
            REAL_ESTATE -> Known.REAL_ESTATE
            HEALTHCARE -> Known.HEALTHCARE
            HUMAN_RESOURCES -> Known.HUMAN_RESOURCES
            ENERGY -> Known.ENERGY
            ENTERTAINMENT -> Known.ENTERTAINMENT
            RETAIL -> Known.RETAIL
            TRANSPORTATION -> Known.TRANSPORTATION
            AGRICULTURE -> Known.AGRICULTURE
            INSURANCE -> Known.INSURANCE
            POSTAL -> Known.POSTAL
            EDUCATION -> Known.EDUCATION
            HOSPITALITY -> Known.HOSPITALITY
            FINANCIAL -> Known.FINANCIAL
            POLITICAL -> Known.POLITICAL
            GAMBLING -> Known.GAMBLING
            LEGAL -> Known.LEGAL
            CONSTRUCTION -> Known.CONSTRUCTION
            NGO -> Known.NGO
            MANUFACTURING -> Known.MANUFACTURING
            GOVERNMENT -> Known.GOVERNMENT
            TECHNOLOGY -> Known.TECHNOLOGY
            COMMUNICATION -> Known.COMMUNICATION
            else -> throw SentDmInvalidDataException("Unknown TcrVertical: $value")
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

    fun validate(): TcrVertical = apply {
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

        return other is TcrVertical && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
