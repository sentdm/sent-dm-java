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

class VoiceAgentSpeechSpec
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val language: JsonField<String>,
    private val setting: JsonField<String>,
    private val voice: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("language") @ExcludeMissing language: JsonField<String> = JsonMissing.of(),
        @JsonProperty("setting") @ExcludeMissing setting: JsonField<String> = JsonMissing.of(),
        @JsonProperty("voice") @ExcludeMissing voice: JsonField<String> = JsonMissing.of(),
    ) : this(language, setting, voice, mutableMapOf())

    /**
     * The language spoken and listened for, a BCP 47 tag from GET /v3/voice/voices. Default en-US.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun language(): Optional<String> = language.getOptional("language")

    /**
     * standard, Sent's speech. Other settings are not available yet.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun setting(): Optional<String> = setting.getOptional("setting")

    /**
     * A voice name from GET /v3/voice/voices. Default: the catalogue's default voice.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun voice(): Optional<String> = voice.getOptional("voice")

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

    /**
     * Returns the raw JSON value of [setting].
     *
     * Unlike [setting], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("setting") @ExcludeMissing fun _setting(): JsonField<String> = setting

    /**
     * Returns the raw JSON value of [voice].
     *
     * Unlike [voice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("voice") @ExcludeMissing fun _voice(): JsonField<String> = voice

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

        /** Returns a mutable builder for constructing an instance of [VoiceAgentSpeechSpec]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceAgentSpeechSpec]. */
    class Builder internal constructor() {

        private var language: JsonField<String> = JsonMissing.of()
        private var setting: JsonField<String> = JsonMissing.of()
        private var voice: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceAgentSpeechSpec: VoiceAgentSpeechSpec) = apply {
            language = voiceAgentSpeechSpec.language
            setting = voiceAgentSpeechSpec.setting
            voice = voiceAgentSpeechSpec.voice
            additionalProperties = voiceAgentSpeechSpec.additionalProperties.toMutableMap()
        }

        /**
         * The language spoken and listened for, a BCP 47 tag from GET /v3/voice/voices. Default
         * en-US.
         */
        fun language(language: String?) = language(JsonField.ofNullable(language))

        /** Alias for calling [Builder.language] with `language.orElse(null)`. */
        fun language(language: Optional<String>) = language(language.getOrNull())

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /** standard, Sent's speech. Other settings are not available yet. */
        fun setting(setting: String?) = setting(JsonField.ofNullable(setting))

        /** Alias for calling [Builder.setting] with `setting.orElse(null)`. */
        fun setting(setting: Optional<String>) = setting(setting.getOrNull())

        /**
         * Sets [Builder.setting] to an arbitrary JSON value.
         *
         * You should usually call [Builder.setting] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun setting(setting: JsonField<String>) = apply { this.setting = setting }

        /** A voice name from GET /v3/voice/voices. Default: the catalogue's default voice. */
        fun voice(voice: String?) = voice(JsonField.ofNullable(voice))

        /** Alias for calling [Builder.voice] with `voice.orElse(null)`. */
        fun voice(voice: Optional<String>) = voice(voice.getOrNull())

        /**
         * Sets [Builder.voice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voice] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun voice(voice: JsonField<String>) = apply { this.voice = voice }

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
         * Returns an immutable instance of [VoiceAgentSpeechSpec].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceAgentSpeechSpec =
            VoiceAgentSpeechSpec(language, setting, voice, additionalProperties.toMutableMap())
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
    fun validate(): VoiceAgentSpeechSpec = apply {
        if (validated) {
            return@apply
        }

        language()
        setting()
        voice()
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
    @JvmSynthetic
    internal fun validity(): Int =
        (if (language.asKnown().isPresent) 1 else 0) +
            (if (setting.asKnown().isPresent) 1 else 0) +
            (if (voice.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceAgentSpeechSpec &&
            language == other.language &&
            setting == other.setting &&
            voice == other.voice &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(language, setting, voice, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceAgentSpeechSpec{language=$language, setting=$setting, voice=$voice, additionalProperties=$additionalProperties}"
}
