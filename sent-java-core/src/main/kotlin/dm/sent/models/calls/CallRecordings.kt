// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

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

/** The recordings of a call, each as a short-lived download link */
class CallRecordings
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val recordings: JsonField<List<CallRecording>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("recordings")
        @ExcludeMissing
        recordings: JsonField<List<CallRecording>> = JsonMissing.of()
    ) : this(recordings, mutableMapOf())

    /**
     * Every recording of the call, oldest first. Empty until the first call.recording_ready webhook
     * has been sent, and for a call that was never recorded
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun recordings(): Optional<List<CallRecording>> = recordings.getOptional("recordings")

    /**
     * Returns the raw JSON value of [recordings].
     *
     * Unlike [recordings], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recordings")
    @ExcludeMissing
    fun _recordings(): JsonField<List<CallRecording>> = recordings

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

        /** Returns a mutable builder for constructing an instance of [CallRecordings]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CallRecordings]. */
    class Builder internal constructor() {

        private var recordings: JsonField<MutableList<CallRecording>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(callRecordings: CallRecordings) = apply {
            recordings = callRecordings.recordings.map { it.toMutableList() }
            additionalProperties = callRecordings.additionalProperties.toMutableMap()
        }

        /**
         * Every recording of the call, oldest first. Empty until the first call.recording_ready
         * webhook has been sent, and for a call that was never recorded
         */
        fun recordings(recordings: List<CallRecording>) = recordings(JsonField.of(recordings))

        /**
         * Sets [Builder.recordings] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recordings] with a well-typed `List<CallRecording>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun recordings(recordings: JsonField<List<CallRecording>>) = apply {
            this.recordings = recordings.map { it.toMutableList() }
        }

        /**
         * Adds a single [CallRecording] to [recordings].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecording(recording: CallRecording) = apply {
            recordings =
                (recordings ?: JsonField.of(mutableListOf())).also {
                    checkKnown("recordings", it).add(recording)
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
         * Returns an immutable instance of [CallRecordings].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CallRecordings =
            CallRecordings(
                (recordings ?: JsonMissing.of()).map { it.toImmutable() },
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
    fun validate(): CallRecordings = apply {
        if (validated) {
            return@apply
        }

        recordings().ifPresent { it.forEach { it.validate() } }
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
        (recordings.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallRecordings &&
            recordings == other.recordings &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(recordings, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CallRecordings{recordings=$recordings, additionalProperties=$additionalProperties}"
}
