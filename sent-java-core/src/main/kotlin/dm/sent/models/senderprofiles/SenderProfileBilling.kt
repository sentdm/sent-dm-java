// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

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

/**
 * Who pays for a sender profile's traffic, as a read reports it.
 *
 * Its own type, field for field the same as BillingRequest. Same reason as the brand: a response is
 * not a request, whatever it carries.
 */
class SenderProfileBilling
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val inherit: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("inherit") @ExcludeMissing inherit: JsonField<Boolean> = JsonMissing.of()
    ) : this(inherit, mutableMapOf())

    /**
     * Whether the organization pays, rather than the profile.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inherit(): Optional<Boolean> = inherit.getOptional("inherit")

    /**
     * Returns the raw JSON value of [inherit].
     *
     * Unlike [inherit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inherit") @ExcludeMissing fun _inherit(): JsonField<Boolean> = inherit

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

        /** Returns a mutable builder for constructing an instance of [SenderProfileBilling]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileBilling]. */
    class Builder internal constructor() {

        private var inherit: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfileBilling: SenderProfileBilling) = apply {
            inherit = senderProfileBilling.inherit
            additionalProperties = senderProfileBilling.additionalProperties.toMutableMap()
        }

        /** Whether the organization pays, rather than the profile. */
        fun inherit(inherit: Boolean) = inherit(JsonField.of(inherit))

        /**
         * Sets [Builder.inherit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inherit] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun inherit(inherit: JsonField<Boolean>) = apply { this.inherit = inherit }

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
         * Returns an immutable instance of [SenderProfileBilling].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfileBilling =
            SenderProfileBilling(inherit, additionalProperties.toMutableMap())
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
    fun validate(): SenderProfileBilling = apply {
        if (validated) {
            return@apply
        }

        inherit()
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
    @JvmSynthetic internal fun validity(): Int = (if (inherit.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SenderProfileBilling &&
            inherit == other.inherit &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(inherit, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfileBilling{inherit=$inherit, additionalProperties=$additionalProperties}"
}
