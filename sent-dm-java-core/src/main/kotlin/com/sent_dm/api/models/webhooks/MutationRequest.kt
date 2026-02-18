// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class MutationRequest
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val testMode: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("test_mode") @ExcludeMissing testMode: JsonField<Boolean> = JsonMissing.of()
    ) : this(testMode, mutableMapOf())

    /**
     * Test mode flag - when true, the operation is simulated without side effects Useful for
     * testing integrations without actual execution
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun testMode(): Optional<Boolean> = testMode.getOptional("test_mode")

    /**
     * Returns the raw JSON value of [testMode].
     *
     * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("test_mode") @ExcludeMissing fun _testMode(): JsonField<Boolean> = testMode

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

        private var testMode: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(mutationRequest: MutationRequest) = apply {
            testMode = mutationRequest.testMode
            additionalProperties = mutationRequest.additionalProperties.toMutableMap()
        }

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun testMode(testMode: Boolean) = testMode(JsonField.of(testMode))

        /**
         * Sets [Builder.testMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun testMode(testMode: JsonField<Boolean>) = apply { this.testMode = testMode }

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
        fun build(): MutationRequest =
            MutationRequest(testMode, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): MutationRequest = apply {
        if (validated) {
            return@apply
        }

        testMode()
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
    @JvmSynthetic internal fun validity(): Int = (if (testMode.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MutationRequest &&
            testMode == other.testMode &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(testMode, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MutationRequest{testMode=$testMode, additionalProperties=$additionalProperties}"
}
