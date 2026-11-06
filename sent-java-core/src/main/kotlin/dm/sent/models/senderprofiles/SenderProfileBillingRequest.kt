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
 * Who pays for what a sender profile sends.
 *
 * Ownership reads the same way as BrandRequest and CampaignRequest: inherit: true is the
 * organization paying; inherit: false (or an empty block) is the profile paying for itself.
 *
 * An absent block is the one place billing differs from brand and campaign: a profile still has to
 * be paid for, so omitting billing stores ProfileAndOrganizationBilling — the profile pays first
 * and its organization covers what the profile's balance cannot (see ResolveStored). { "name":
 * "..." } stays a complete request.
 *
 * Billing carries no fields of its own yet, so a profile paying for itself is { "inherit": false }
 * — or an empty block, which means the same. That is thinner than brand and campaign, where
 * supplying data is the act of owning; it becomes ordinary the moment billing gains a contact or a
 * payment method to carry.
 */
class SenderProfileBillingRequest
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
     * Whether the parent organization pays. false is the profile paying for itself.
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

        /**
         * Returns a mutable builder for constructing an instance of [SenderProfileBillingRequest].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SenderProfileBillingRequest]. */
    class Builder internal constructor() {

        private var inherit: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(senderProfileBillingRequest: SenderProfileBillingRequest) = apply {
            inherit = senderProfileBillingRequest.inherit
            additionalProperties = senderProfileBillingRequest.additionalProperties.toMutableMap()
        }

        /** Whether the parent organization pays. false is the profile paying for itself. */
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
         * Returns an immutable instance of [SenderProfileBillingRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SenderProfileBillingRequest =
            SenderProfileBillingRequest(inherit, additionalProperties.toMutableMap())
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
    fun validate(): SenderProfileBillingRequest = apply {
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

        return other is SenderProfileBillingRequest &&
            inherit == other.inherit &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(inherit, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SenderProfileBillingRequest{inherit=$inherit, additionalProperties=$additionalProperties}"
}
