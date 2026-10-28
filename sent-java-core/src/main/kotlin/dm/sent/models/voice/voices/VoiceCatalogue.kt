// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.voices

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The voices and languages a text-session agent may name in its speech settings: what GET
 * /v3/voice/voices and the admin GET /voice/voices answer, in one shape.
 */
class VoiceCatalogue
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val languages: JsonField<List<String>>,
    private val voices: JsonField<List<VoiceCatalogueVoice>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("languages")
        @ExcludeMissing
        languages: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("voices")
        @ExcludeMissing
        voices: JsonField<List<VoiceCatalogueVoice>> = JsonMissing.of(),
    ) : this(languages, voices, mutableMapOf())

    /**
     * BCP 47 tags accepted as speech.language.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun languages(): Optional<List<String>> = languages.getOptional("languages")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun voices(): Optional<List<VoiceCatalogueVoice>> = voices.getOptional("voices")

    /**
     * Returns the raw JSON value of [languages].
     *
     * Unlike [languages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("languages") @ExcludeMissing fun _languages(): JsonField<List<String>> = languages

    /**
     * Returns the raw JSON value of [voices].
     *
     * Unlike [voices], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("voices")
    @ExcludeMissing
    fun _voices(): JsonField<List<VoiceCatalogueVoice>> = voices

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

        /** Returns a mutable builder for constructing an instance of [VoiceCatalogue]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceCatalogue]. */
    class Builder internal constructor() {

        private var languages: JsonField<MutableList<String>>? = null
        private var voices: JsonField<MutableList<VoiceCatalogueVoice>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceCatalogue: VoiceCatalogue) = apply {
            languages = voiceCatalogue.languages.map { it.toMutableList() }
            voices = voiceCatalogue.voices.map { it.toMutableList() }
            additionalProperties = voiceCatalogue.additionalProperties.toMutableMap()
        }

        /** BCP 47 tags accepted as speech.language. */
        fun languages(languages: List<String>) = languages(JsonField.of(languages))

        /**
         * Sets [Builder.languages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.languages] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun languages(languages: JsonField<List<String>>) = apply {
            this.languages = languages.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [languages].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLanguage(language: String) = apply {
            languages =
                (languages ?: JsonField.of(mutableListOf())).also {
                    checkKnown("languages", it).add(language)
                }
        }

        fun voices(voices: List<VoiceCatalogueVoice>) = voices(JsonField.of(voices))

        /**
         * Sets [Builder.voices] to an arbitrary JSON value.
         *
         * You should usually call [Builder.voices] with a well-typed `List<VoiceCatalogueVoice>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun voices(voices: JsonField<List<VoiceCatalogueVoice>>) = apply {
            this.voices = voices.map { it.toMutableList() }
        }

        /**
         * Adds a single [VoiceCatalogueVoice] to [voices].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVoice(voice: VoiceCatalogueVoice) = apply {
            voices =
                (voices ?: JsonField.of(mutableListOf())).also {
                    checkKnown("voices", it).add(voice)
                }
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
         * Returns an immutable instance of [VoiceCatalogue].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceCatalogue =
            VoiceCatalogue(
                (languages ?: JsonMissing.of()).map { it.toImmutable() },
                (voices ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): VoiceCatalogue = apply {
        if (validated) {
            return@apply
        }

        languages()
        voices().ifPresent { it.forEach { it.validate() } }
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
        (languages.asKnown().getOrNull()?.size ?: 0) +
            (voices.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceCatalogue &&
            languages == other.languages &&
            voices == other.voices &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(languages, voices, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceCatalogue{languages=$languages, voices=$voices, additionalProperties=$additionalProperties}"
}
