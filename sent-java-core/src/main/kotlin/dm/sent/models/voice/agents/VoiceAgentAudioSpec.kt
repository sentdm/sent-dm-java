// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

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
import kotlin.jvm.optionals.getOrNull

class VoiceAgentAudioSpec
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val sampleRate: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("sample_rate") @ExcludeMissing sampleRate: JsonField<Int> = JsonMissing.of()
    ) : this(sampleRate, mutableMapOf())

    /**
     * Samples per second of the audio exchanged: 8000, 16000 or 24000. Default 16000.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sampleRate(): Optional<Int> = sampleRate.getOptional("sample_rate")

    /**
     * Returns the raw JSON value of [sampleRate].
     *
     * Unlike [sampleRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sample_rate") @ExcludeMissing fun _sampleRate(): JsonField<Int> = sampleRate

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

        /** Returns a mutable builder for constructing an instance of [VoiceAgentAudioSpec]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceAgentAudioSpec]. */
    class Builder internal constructor() {

        private var sampleRate: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceAgentAudioSpec: VoiceAgentAudioSpec) = apply {
            sampleRate = voiceAgentAudioSpec.sampleRate
            additionalProperties = voiceAgentAudioSpec.additionalProperties.toMutableMap()
        }

        /** Samples per second of the audio exchanged: 8000, 16000 or 24000. Default 16000. */
        fun sampleRate(sampleRate: Int?) = sampleRate(JsonField.ofNullable(sampleRate))

        /**
         * Alias for [Builder.sampleRate].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun sampleRate(sampleRate: Int) = sampleRate(sampleRate as Int?)

        /** Alias for calling [Builder.sampleRate] with `sampleRate.orElse(null)`. */
        fun sampleRate(sampleRate: Optional<Int>) = sampleRate(sampleRate.getOrNull())

        /**
         * Sets [Builder.sampleRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sampleRate] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sampleRate(sampleRate: JsonField<Int>) = apply { this.sampleRate = sampleRate }

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
         * Returns an immutable instance of [VoiceAgentAudioSpec].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceAgentAudioSpec =
            VoiceAgentAudioSpec(sampleRate, additionalProperties.toMutableMap())
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
    fun validate(): VoiceAgentAudioSpec = apply {
        if (validated) {
            return@apply
        }

        sampleRate()
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
    @JvmSynthetic internal fun validity(): Int = (if (sampleRate.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceAgentAudioSpec &&
            sampleRate == other.sampleRate &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(sampleRate, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceAgentAudioSpec{sampleRate=$sampleRate, additionalProperties=$additionalProperties}"
}
