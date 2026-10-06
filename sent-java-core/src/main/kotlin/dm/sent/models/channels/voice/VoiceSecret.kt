// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

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

/** A freshly rotated callback signing secret */
class VoiceSecret
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val callbackSecret: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("callback_secret")
        @ExcludeMissing
        callbackSecret: JsonField<String> = JsonMissing.of()
    ) : this(callbackSecret, mutableMapOf())

    /**
     * The new whsec_ secret. The previous one stopped signing the moment this was returned, so
     * update your backend before the next call reaches it. Shown once.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun callbackSecret(): Optional<String> = callbackSecret.getOptional("callback_secret")

    /**
     * Returns the raw JSON value of [callbackSecret].
     *
     * Unlike [callbackSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("callback_secret")
    @ExcludeMissing
    fun _callbackSecret(): JsonField<String> = callbackSecret

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

        /** Returns a mutable builder for constructing an instance of [VoiceSecret]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceSecret]. */
    class Builder internal constructor() {

        private var callbackSecret: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceSecret: VoiceSecret) = apply {
            callbackSecret = voiceSecret.callbackSecret
            additionalProperties = voiceSecret.additionalProperties.toMutableMap()
        }

        /**
         * The new whsec_ secret. The previous one stopped signing the moment this was returned, so
         * update your backend before the next call reaches it. Shown once.
         */
        fun callbackSecret(callbackSecret: String) = callbackSecret(JsonField.of(callbackSecret))

        /**
         * Sets [Builder.callbackSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callbackSecret] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun callbackSecret(callbackSecret: JsonField<String>) = apply {
            this.callbackSecret = callbackSecret
        }

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
         * Returns an immutable instance of [VoiceSecret].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceSecret = VoiceSecret(callbackSecret, additionalProperties.toMutableMap())
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
    fun validate(): VoiceSecret = apply {
        if (validated) {
            return@apply
        }

        callbackSecret()
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
    @JvmSynthetic internal fun validity(): Int = (if (callbackSecret.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceSecret &&
            callbackSecret == other.callbackSecret &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(callbackSecret, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceSecret{callbackSecret=$callbackSecret, additionalProperties=$additionalProperties}"
}
