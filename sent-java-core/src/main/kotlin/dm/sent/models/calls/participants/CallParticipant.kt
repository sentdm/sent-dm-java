// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls.participants

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

/** A participant of a conference call */
class CallParticipant
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val durationSeconds: JsonField<Int>,
    private val kind: JsonField<String>,
    private val muted: JsonField<Boolean>,
    private val value: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("duration_seconds")
        @ExcludeMissing
        durationSeconds: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("kind") @ExcludeMissing kind: JsonField<String> = JsonMissing.of(),
        @JsonProperty("muted") @ExcludeMissing muted: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
    ) : this(id, durationSeconds, kind, muted, value, mutableMapOf())

    /**
     * The participant's own call id: what the mute and remove endpoints take, and what GET
     * /v3/calls/{id} accepts
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * How long the participant has been connected to the room, in seconds
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun durationSeconds(): Optional<Int> = durationSeconds.getOptional("duration_seconds")

    /**
     * user for one of your app users, number for a phone number, anonymous for a caller who
     * withheld their number
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun kind(): Optional<String> = kind.getOptional("kind")

    /**
     * True while the room mutes this participant
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun muted(): Optional<Boolean> = muted.getOptional("muted")

    /**
     * The app user's identity or the phone number in E.164 format. Null when the kind is anonymous
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun value(): Optional<String> = value.getOptional("value")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [durationSeconds].
     *
     * Unlike [durationSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration_seconds")
    @ExcludeMissing
    fun _durationSeconds(): JsonField<Int> = durationSeconds

    /**
     * Returns the raw JSON value of [kind].
     *
     * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<String> = kind

    /**
     * Returns the raw JSON value of [muted].
     *
     * Unlike [muted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("muted") @ExcludeMissing fun _muted(): JsonField<Boolean> = muted

    /**
     * Returns the raw JSON value of [value].
     *
     * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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

        /** Returns a mutable builder for constructing an instance of [CallParticipant]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CallParticipant]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var durationSeconds: JsonField<Int> = JsonMissing.of()
        private var kind: JsonField<String> = JsonMissing.of()
        private var muted: JsonField<Boolean> = JsonMissing.of()
        private var value: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(callParticipant: CallParticipant) = apply {
            id = callParticipant.id
            durationSeconds = callParticipant.durationSeconds
            kind = callParticipant.kind
            muted = callParticipant.muted
            value = callParticipant.value
            additionalProperties = callParticipant.additionalProperties.toMutableMap()
        }

        /**
         * The participant's own call id: what the mute and remove endpoints take, and what GET
         * /v3/calls/{id} accepts
         */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** How long the participant has been connected to the room, in seconds */
        fun durationSeconds(durationSeconds: Int) = durationSeconds(JsonField.of(durationSeconds))

        /**
         * Sets [Builder.durationSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.durationSeconds] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun durationSeconds(durationSeconds: JsonField<Int>) = apply {
            this.durationSeconds = durationSeconds
        }

        /**
         * user for one of your app users, number for a phone number, anonymous for a caller who
         * withheld their number
         */
        fun kind(kind: String) = kind(JsonField.of(kind))

        /**
         * Sets [Builder.kind] to an arbitrary JSON value.
         *
         * You should usually call [Builder.kind] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun kind(kind: JsonField<String>) = apply { this.kind = kind }

        /** True while the room mutes this participant */
        fun muted(muted: Boolean) = muted(JsonField.of(muted))

        /**
         * Sets [Builder.muted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.muted] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun muted(muted: JsonField<Boolean>) = apply { this.muted = muted }

        /**
         * The app user's identity or the phone number in E.164 format. Null when the kind is
         * anonymous
         */
        fun value(value: String?) = value(JsonField.ofNullable(value))

        /** Alias for calling [Builder.value] with `value.orElse(null)`. */
        fun value(value: Optional<String>) = value(value.getOrNull())

        /**
         * Sets [Builder.value] to an arbitrary JSON value.
         *
         * You should usually call [Builder.value] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun value(value: JsonField<String>) = apply { this.value = value }

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
         * Returns an immutable instance of [CallParticipant].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CallParticipant =
            CallParticipant(
                id,
                durationSeconds,
                kind,
                muted,
                value,
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
    fun validate(): CallParticipant = apply {
        if (validated) {
            return@apply
        }

        id()
        durationSeconds()
        kind()
        muted()
        value()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (durationSeconds.asKnown().isPresent) 1 else 0) +
            (if (kind.asKnown().isPresent) 1 else 0) +
            (if (muted.asKnown().isPresent) 1 else 0) +
            (if (value.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallParticipant &&
            id == other.id &&
            durationSeconds == other.durationSeconds &&
            kind == other.kind &&
            muted == other.muted &&
            value == other.value &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, durationSeconds, kind, muted, value, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CallParticipant{id=$id, durationSeconds=$durationSeconds, kind=$kind, muted=$muted, value=$value, additionalProperties=$additionalProperties}"
}
