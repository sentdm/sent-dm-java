// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

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

class MutationRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val sandbox: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of()
    ) : this(sandbox, mutableMapOf())

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

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

        /** Returns a mutable builder for constructing an instance of [MutationRequest]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MutationRequest]. */
    class Builder internal constructor() {

        private var sandbox: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mutationRequest: MutationRequest) = apply {
            sandbox = mutationRequest.sandbox
            additionalProperties = mutationRequest.additionalProperties.toMutableMap()
        }

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun sandbox(sandbox: Boolean) = sandbox(JsonField.of(sandbox))

        /**
         * Sets [Builder.sandbox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sandbox(sandbox: JsonField<Boolean>) = apply { this.sandbox = sandbox }

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
         * Returns an immutable instance of [MutationRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MutationRequest = MutationRequest(sandbox, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): MutationRequest = apply {
        if (validated) {
            return@apply
        }

        sandbox()
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
    @JvmSynthetic internal fun validity(): Int = (if (sandbox.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MutationRequest &&
            sandbox == other.sandbox &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(sandbox, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MutationRequest{sandbox=$sandbox, additionalProperties=$additionalProperties}"
}
