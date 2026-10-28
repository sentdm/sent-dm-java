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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class VoiceAgentLimitsSpec
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowedCountries: JsonField<List<String>>,
    private val maxCallSeconds: JsonField<Int>,
    private val maxConcurrentCalls: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allowed_countries")
        @ExcludeMissing
        allowedCountries: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("max_call_seconds")
        @ExcludeMissing
        maxCallSeconds: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("max_concurrent_calls")
        @ExcludeMissing
        maxConcurrentCalls: JsonField<Int> = JsonMissing.of(),
    ) : this(allowedCountries, maxCallSeconds, maxConcurrentCalls, mutableMapOf())

    /**
     * ISO 3166-1 alpha-2 codes of the countries the agent may call or transfer to. Omit it to allow
     * every country. Stored now, applied when the agent places calls.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun allowedCountries(): Optional<List<String>> =
        allowedCountries.getOptional("allowed_countries")

    /**
     * The longest a call may last, 60 to 14,400 seconds. Default 3,600.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun maxCallSeconds(): Optional<Int> = maxCallSeconds.getOptional("max_call_seconds")

    /**
     * How many calls the agent may have going at once, from 1. Default 10.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun maxConcurrentCalls(): Optional<Int> = maxConcurrentCalls.getOptional("max_concurrent_calls")

    /**
     * Returns the raw JSON value of [allowedCountries].
     *
     * Unlike [allowedCountries], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allowed_countries")
    @ExcludeMissing
    fun _allowedCountries(): JsonField<List<String>> = allowedCountries

    /**
     * Returns the raw JSON value of [maxCallSeconds].
     *
     * Unlike [maxCallSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_call_seconds")
    @ExcludeMissing
    fun _maxCallSeconds(): JsonField<Int> = maxCallSeconds

    /**
     * Returns the raw JSON value of [maxConcurrentCalls].
     *
     * Unlike [maxConcurrentCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("max_concurrent_calls")
    @ExcludeMissing
    fun _maxConcurrentCalls(): JsonField<Int> = maxConcurrentCalls

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

        /** Returns a mutable builder for constructing an instance of [VoiceAgentLimitsSpec]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceAgentLimitsSpec]. */
    class Builder internal constructor() {

        private var allowedCountries: JsonField<MutableList<String>>? = null
        private var maxCallSeconds: JsonField<Int> = JsonMissing.of()
        private var maxConcurrentCalls: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceAgentLimitsSpec: VoiceAgentLimitsSpec) = apply {
            allowedCountries = voiceAgentLimitsSpec.allowedCountries.map { it.toMutableList() }
            maxCallSeconds = voiceAgentLimitsSpec.maxCallSeconds
            maxConcurrentCalls = voiceAgentLimitsSpec.maxConcurrentCalls
            additionalProperties = voiceAgentLimitsSpec.additionalProperties.toMutableMap()
        }

        /**
         * ISO 3166-1 alpha-2 codes of the countries the agent may call or transfer to. Omit it to
         * allow every country. Stored now, applied when the agent places calls.
         */
        fun allowedCountries(allowedCountries: List<String>?) =
            allowedCountries(JsonField.ofNullable(allowedCountries))

        /** Alias for calling [Builder.allowedCountries] with `allowedCountries.orElse(null)`. */
        fun allowedCountries(allowedCountries: Optional<List<String>>) =
            allowedCountries(allowedCountries.getOrNull())

        /**
         * Sets [Builder.allowedCountries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedCountries] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun allowedCountries(allowedCountries: JsonField<List<String>>) = apply {
            this.allowedCountries = allowedCountries.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [allowedCountries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedCountry(allowedCountry: String) = apply {
            allowedCountries =
                (allowedCountries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("allowedCountries", it).add(allowedCountry)
                }
        }

        /** The longest a call may last, 60 to 14,400 seconds. Default 3,600. */
        fun maxCallSeconds(maxCallSeconds: Int?) =
            maxCallSeconds(JsonField.ofNullable(maxCallSeconds))

        /**
         * Alias for [Builder.maxCallSeconds].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxCallSeconds(maxCallSeconds: Int) = maxCallSeconds(maxCallSeconds as Int?)

        /** Alias for calling [Builder.maxCallSeconds] with `maxCallSeconds.orElse(null)`. */
        fun maxCallSeconds(maxCallSeconds: Optional<Int>) =
            maxCallSeconds(maxCallSeconds.getOrNull())

        /**
         * Sets [Builder.maxCallSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxCallSeconds] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maxCallSeconds(maxCallSeconds: JsonField<Int>) = apply {
            this.maxCallSeconds = maxCallSeconds
        }

        /** How many calls the agent may have going at once, from 1. Default 10. */
        fun maxConcurrentCalls(maxConcurrentCalls: Int?) =
            maxConcurrentCalls(JsonField.ofNullable(maxConcurrentCalls))

        /**
         * Alias for [Builder.maxConcurrentCalls].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxConcurrentCalls(maxConcurrentCalls: Int) =
            maxConcurrentCalls(maxConcurrentCalls as Int?)

        /**
         * Alias for calling [Builder.maxConcurrentCalls] with `maxConcurrentCalls.orElse(null)`.
         */
        fun maxConcurrentCalls(maxConcurrentCalls: Optional<Int>) =
            maxConcurrentCalls(maxConcurrentCalls.getOrNull())

        /**
         * Sets [Builder.maxConcurrentCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxConcurrentCalls] with a well-typed [Int] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun maxConcurrentCalls(maxConcurrentCalls: JsonField<Int>) = apply {
            this.maxConcurrentCalls = maxConcurrentCalls
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
         * Returns an immutable instance of [VoiceAgentLimitsSpec].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceAgentLimitsSpec =
            VoiceAgentLimitsSpec(
                (allowedCountries ?: JsonMissing.of()).map { it.toImmutable() },
                maxCallSeconds,
                maxConcurrentCalls,
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
    fun validate(): VoiceAgentLimitsSpec = apply {
        if (validated) {
            return@apply
        }

        allowedCountries()
        maxCallSeconds()
        maxConcurrentCalls()
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
        (allowedCountries.asKnown().getOrNull()?.size ?: 0) +
            (if (maxCallSeconds.asKnown().isPresent) 1 else 0) +
            (if (maxConcurrentCalls.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceAgentLimitsSpec &&
            allowedCountries == other.allowedCountries &&
            maxCallSeconds == other.maxCallSeconds &&
            maxConcurrentCalls == other.maxConcurrentCalls &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(allowedCountries, maxCallSeconds, maxConcurrentCalls, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceAgentLimitsSpec{allowedCountries=$allowedCountries, maxCallSeconds=$maxCallSeconds, maxConcurrentCalls=$maxConcurrentCalls, additionalProperties=$additionalProperties}"
}
