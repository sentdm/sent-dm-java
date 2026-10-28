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

class VoiceAgentTranscriptsSpec
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val retentionDays: JsonField<Int>,
    private val store: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("retention_days")
        @ExcludeMissing
        retentionDays: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("store") @ExcludeMissing store: JsonField<Boolean> = JsonMissing.of(),
    ) : this(retentionDays, store, mutableMapOf())

    /**
     * How long a stored transcript is kept, 1 to 365 days. Default 30.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun retentionDays(): Optional<Int> = retentionDays.getOptional("retention_days")

    /**
     * Whether Sent keeps the call's transcript. Default false. Stored now, applied when transcripts
     * land.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun store(): Optional<Boolean> = store.getOptional("store")

    /**
     * Returns the raw JSON value of [retentionDays].
     *
     * Unlike [retentionDays], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retention_days")
    @ExcludeMissing
    fun _retentionDays(): JsonField<Int> = retentionDays

    /**
     * Returns the raw JSON value of [store].
     *
     * Unlike [store], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("store") @ExcludeMissing fun _store(): JsonField<Boolean> = store

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
         * Returns a mutable builder for constructing an instance of [VoiceAgentTranscriptsSpec].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceAgentTranscriptsSpec]. */
    class Builder internal constructor() {

        private var retentionDays: JsonField<Int> = JsonMissing.of()
        private var store: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceAgentTranscriptsSpec: VoiceAgentTranscriptsSpec) = apply {
            retentionDays = voiceAgentTranscriptsSpec.retentionDays
            store = voiceAgentTranscriptsSpec.store
            additionalProperties = voiceAgentTranscriptsSpec.additionalProperties.toMutableMap()
        }

        /** How long a stored transcript is kept, 1 to 365 days. Default 30. */
        fun retentionDays(retentionDays: Int?) = retentionDays(JsonField.ofNullable(retentionDays))

        /**
         * Alias for [Builder.retentionDays].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun retentionDays(retentionDays: Int) = retentionDays(retentionDays as Int?)

        /** Alias for calling [Builder.retentionDays] with `retentionDays.orElse(null)`. */
        fun retentionDays(retentionDays: Optional<Int>) = retentionDays(retentionDays.getOrNull())

        /**
         * Sets [Builder.retentionDays] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retentionDays] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun retentionDays(retentionDays: JsonField<Int>) = apply {
            this.retentionDays = retentionDays
        }

        /**
         * Whether Sent keeps the call's transcript. Default false. Stored now, applied when
         * transcripts land.
         */
        fun store(store: Boolean?) = store(JsonField.ofNullable(store))

        /**
         * Alias for [Builder.store].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun store(store: Boolean) = store(store as Boolean?)

        /** Alias for calling [Builder.store] with `store.orElse(null)`. */
        fun store(store: Optional<Boolean>) = store(store.getOrNull())

        /**
         * Sets [Builder.store] to an arbitrary JSON value.
         *
         * You should usually call [Builder.store] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun store(store: JsonField<Boolean>) = apply { this.store = store }

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
         * Returns an immutable instance of [VoiceAgentTranscriptsSpec].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceAgentTranscriptsSpec =
            VoiceAgentTranscriptsSpec(retentionDays, store, additionalProperties.toMutableMap())
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
    fun validate(): VoiceAgentTranscriptsSpec = apply {
        if (validated) {
            return@apply
        }

        retentionDays()
        store()
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
        (if (retentionDays.asKnown().isPresent) 1 else 0) +
            (if (store.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceAgentTranscriptsSpec &&
            retentionDays == other.retentionDays &&
            store == other.store &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(retentionDays, store, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceAgentTranscriptsSpec{retentionDays=$retentionDays, store=$store, additionalProperties=$additionalProperties}"
}
