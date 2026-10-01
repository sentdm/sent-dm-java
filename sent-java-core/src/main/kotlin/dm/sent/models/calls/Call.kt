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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A call record */
class Call
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val answeredAt: JsonField<OffsetDateTime>,
    private val direction: JsonField<String>,
    private val durationSeconds: JsonField<Int>,
    private val endedAt: JsonField<OffsetDateTime>,
    private val failureReason: JsonField<String>,
    private val from: JsonField<CallParty>,
    private val number: JsonField<String>,
    private val price: JsonField<Double>,
    private val recordingAvailable: JsonField<Boolean>,
    private val startedAt: JsonField<OffsetDateTime>,
    private val status: JsonField<String>,
    private val timeline: JsonField<List<CallTimelineEntry>>,
    private val to: JsonField<CallParty>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("answered_at")
        @ExcludeMissing
        answeredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("direction") @ExcludeMissing direction: JsonField<String> = JsonMissing.of(),
        @JsonProperty("duration_seconds")
        @ExcludeMissing
        durationSeconds: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("ended_at")
        @ExcludeMissing
        endedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("failure_reason")
        @ExcludeMissing
        failureReason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("from") @ExcludeMissing from: JsonField<CallParty> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("recording_available")
        @ExcludeMissing
        recordingAvailable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("started_at")
        @ExcludeMissing
        startedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timeline")
        @ExcludeMissing
        timeline: JsonField<List<CallTimelineEntry>> = JsonMissing.of(),
        @JsonProperty("to") @ExcludeMissing to: JsonField<CallParty> = JsonMissing.of(),
    ) : this(
        id,
        answeredAt,
        direction,
        durationSeconds,
        endedAt,
        failureReason,
        from,
        number,
        price,
        recordingAvailable,
        startedAt,
        status,
        timeline,
        to,
        mutableMapOf(),
    )

    /**
     * The call id, the same one carried by the call.request question and every call webhook
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * When the call was answered (UTC). Null until then, and always null for a call between two of
     * your app users
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun answeredAt(): Optional<OffsetDateTime> = answeredAt.getOptional("answered_at")

    /**
     * outbound for a call placed from your app, inbound for a call to one of your numbers
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun direction(): Optional<String> = direction.getOptional("direction")

    /**
     * Billable duration in seconds. Null while the call is live
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun durationSeconds(): Optional<Int> = durationSeconds.getOptional("duration_seconds")

    /**
     * When the call ended (UTC). Null while the call is live
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun endedAt(): Optional<OffsetDateTime> = endedAt.getOptional("ended_at")

    /**
     * Why the call did not complete: callback_timeout, invalid_answer, insufficient_balance,
     * destination_blocked, rejected or no_answer. Null while the call is live, when it completed,
     * and when it failed without a recorded reason
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun failureReason(): Optional<String> = failureReason.getOptional("failure_reason")

    /**
     * One end of a call
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun from(): Optional<CallParty> = from.getOptional("from")

    /**
     * Your number that owns the call, in E.164 format: the dialed number for an inbound call, the
     * caller's bound number for a call placed from your app
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun number(): Optional<String> = number.getOptional("number")

    /**
     * What the call cost. Null until it has been priced
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun price(): Optional<Double> = price.getOptional("price")

    /**
     * True once a recording of the call is available
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun recordingAvailable(): Optional<Boolean> =
        recordingAvailable.getOptional("recording_available")

    /**
     * When the call was placed (UTC)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun startedAt(): Optional<OffsetDateTime> = startedAt.getOptional("started_at")

    /**
     * initiated, ringing, answered, completed, failed, no_answer or rejected
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * When the call entered each status, oldest first. Only returned when reading one call
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun timeline(): Optional<List<CallTimelineEntry>> = timeline.getOptional("timeline")

    /**
     * One end of a call
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun to(): Optional<CallParty> = to.getOptional("to")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [answeredAt].
     *
     * Unlike [answeredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("answered_at")
    @ExcludeMissing
    fun _answeredAt(): JsonField<OffsetDateTime> = answeredAt

    /**
     * Returns the raw JSON value of [direction].
     *
     * Unlike [direction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("direction") @ExcludeMissing fun _direction(): JsonField<String> = direction

    /**
     * Returns the raw JSON value of [durationSeconds].
     *
     * Unlike [durationSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration_seconds")
    @ExcludeMissing
    fun _durationSeconds(): JsonField<Int> = durationSeconds

    /**
     * Returns the raw JSON value of [endedAt].
     *
     * Unlike [endedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ended_at") @ExcludeMissing fun _endedAt(): JsonField<OffsetDateTime> = endedAt

    /**
     * Returns the raw JSON value of [failureReason].
     *
     * Unlike [failureReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failure_reason")
    @ExcludeMissing
    fun _failureReason(): JsonField<String> = failureReason

    /**
     * Returns the raw JSON value of [from].
     *
     * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<CallParty> = from

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Double> = price

    /**
     * Returns the raw JSON value of [recordingAvailable].
     *
     * Unlike [recordingAvailable], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("recording_available")
    @ExcludeMissing
    fun _recordingAvailable(): JsonField<Boolean> = recordingAvailable

    /**
     * Returns the raw JSON value of [startedAt].
     *
     * Unlike [startedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("started_at")
    @ExcludeMissing
    fun _startedAt(): JsonField<OffsetDateTime> = startedAt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [timeline].
     *
     * Unlike [timeline], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timeline")
    @ExcludeMissing
    fun _timeline(): JsonField<List<CallTimelineEntry>> = timeline

    /**
     * Returns the raw JSON value of [to].
     *
     * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<CallParty> = to

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

        /** Returns a mutable builder for constructing an instance of [Call]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Call]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var answeredAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var direction: JsonField<String> = JsonMissing.of()
        private var durationSeconds: JsonField<Int> = JsonMissing.of()
        private var endedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var failureReason: JsonField<String> = JsonMissing.of()
        private var from: JsonField<CallParty> = JsonMissing.of()
        private var number: JsonField<String> = JsonMissing.of()
        private var price: JsonField<Double> = JsonMissing.of()
        private var recordingAvailable: JsonField<Boolean> = JsonMissing.of()
        private var startedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var timeline: JsonField<MutableList<CallTimelineEntry>>? = null
        private var to: JsonField<CallParty> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(call: Call) = apply {
            id = call.id
            answeredAt = call.answeredAt
            direction = call.direction
            durationSeconds = call.durationSeconds
            endedAt = call.endedAt
            failureReason = call.failureReason
            from = call.from
            number = call.number
            price = call.price
            recordingAvailable = call.recordingAvailable
            startedAt = call.startedAt
            status = call.status
            timeline = call.timeline.map { it.toMutableList() }
            to = call.to
            additionalProperties = call.additionalProperties.toMutableMap()
        }

        /** The call id, the same one carried by the call.request question and every call webhook */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * When the call was answered (UTC). Null until then, and always null for a call between two
         * of your app users
         */
        fun answeredAt(answeredAt: OffsetDateTime?) = answeredAt(JsonField.ofNullable(answeredAt))

        /** Alias for calling [Builder.answeredAt] with `answeredAt.orElse(null)`. */
        fun answeredAt(answeredAt: Optional<OffsetDateTime>) = answeredAt(answeredAt.getOrNull())

        /**
         * Sets [Builder.answeredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.answeredAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun answeredAt(answeredAt: JsonField<OffsetDateTime>) = apply {
            this.answeredAt = answeredAt
        }

        /** outbound for a call placed from your app, inbound for a call to one of your numbers */
        fun direction(direction: String) = direction(JsonField.of(direction))

        /**
         * Sets [Builder.direction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.direction] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun direction(direction: JsonField<String>) = apply { this.direction = direction }

        /** Billable duration in seconds. Null while the call is live */
        fun durationSeconds(durationSeconds: Int?) =
            durationSeconds(JsonField.ofNullable(durationSeconds))

        /**
         * Alias for [Builder.durationSeconds].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun durationSeconds(durationSeconds: Int) = durationSeconds(durationSeconds as Int?)

        /** Alias for calling [Builder.durationSeconds] with `durationSeconds.orElse(null)`. */
        fun durationSeconds(durationSeconds: Optional<Int>) =
            durationSeconds(durationSeconds.getOrNull())

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

        /** When the call ended (UTC). Null while the call is live */
        fun endedAt(endedAt: OffsetDateTime?) = endedAt(JsonField.ofNullable(endedAt))

        /** Alias for calling [Builder.endedAt] with `endedAt.orElse(null)`. */
        fun endedAt(endedAt: Optional<OffsetDateTime>) = endedAt(endedAt.getOrNull())

        /**
         * Sets [Builder.endedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun endedAt(endedAt: JsonField<OffsetDateTime>) = apply { this.endedAt = endedAt }

        /**
         * Why the call did not complete: callback_timeout, invalid_answer, insufficient_balance,
         * destination_blocked, rejected or no_answer. Null while the call is live, when it
         * completed, and when it failed without a recorded reason
         */
        fun failureReason(failureReason: String?) =
            failureReason(JsonField.ofNullable(failureReason))

        /** Alias for calling [Builder.failureReason] with `failureReason.orElse(null)`. */
        fun failureReason(failureReason: Optional<String>) =
            failureReason(failureReason.getOrNull())

        /**
         * Sets [Builder.failureReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failureReason] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun failureReason(failureReason: JsonField<String>) = apply {
            this.failureReason = failureReason
        }

        /** One end of a call */
        fun from(from: CallParty) = from(JsonField.of(from))

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed [CallParty] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun from(from: JsonField<CallParty>) = apply { this.from = from }

        /**
         * Your number that owns the call, in E.164 format: the dialed number for an inbound call,
         * the caller's bound number for a call placed from your app
         */
        fun number(number: String) = number(JsonField.of(number))

        /**
         * Sets [Builder.number] to an arbitrary JSON value.
         *
         * You should usually call [Builder.number] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun number(number: JsonField<String>) = apply { this.number = number }

        /** What the call cost. Null until it has been priced */
        fun price(price: Double?) = price(JsonField.ofNullable(price))

        /**
         * Alias for [Builder.price].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun price(price: Double) = price(price as Double?)

        /** Alias for calling [Builder.price] with `price.orElse(null)`. */
        fun price(price: Optional<Double>) = price(price.getOrNull())

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<Double>) = apply { this.price = price }

        /** True once a recording of the call is available */
        fun recordingAvailable(recordingAvailable: Boolean) =
            recordingAvailable(JsonField.of(recordingAvailable))

        /**
         * Sets [Builder.recordingAvailable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recordingAvailable] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recordingAvailable(recordingAvailable: JsonField<Boolean>) = apply {
            this.recordingAvailable = recordingAvailable
        }

        /** When the call was placed (UTC) */
        fun startedAt(startedAt: OffsetDateTime) = startedAt(JsonField.of(startedAt))

        /**
         * Sets [Builder.startedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun startedAt(startedAt: JsonField<OffsetDateTime>) = apply { this.startedAt = startedAt }

        /** initiated, ringing, answered, completed, failed, no_answer or rejected */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** When the call entered each status, oldest first. Only returned when reading one call */
        fun timeline(timeline: List<CallTimelineEntry>?) = timeline(JsonField.ofNullable(timeline))

        /** Alias for calling [Builder.timeline] with `timeline.orElse(null)`. */
        fun timeline(timeline: Optional<List<CallTimelineEntry>>) = timeline(timeline.getOrNull())

        /**
         * Sets [Builder.timeline] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timeline] with a well-typed `List<CallTimelineEntry>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun timeline(timeline: JsonField<List<CallTimelineEntry>>) = apply {
            this.timeline = timeline.map { it.toMutableList() }
        }

        /**
         * Adds a single [CallTimelineEntry] to [Builder.timeline].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTimeline(timeline: CallTimelineEntry) = apply {
            this.timeline =
                (this.timeline ?: JsonField.of(mutableListOf())).also {
                    checkKnown("timeline", it).add(timeline)
                }
        }

        /** One end of a call */
        fun to(to: CallParty) = to(JsonField.of(to))

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed [CallParty] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<CallParty>) = apply { this.to = to }

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
         * Returns an immutable instance of [Call].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Call =
            Call(
                id,
                answeredAt,
                direction,
                durationSeconds,
                endedAt,
                failureReason,
                from,
                number,
                price,
                recordingAvailable,
                startedAt,
                status,
                (timeline ?: JsonMissing.of()).map { it.toImmutable() },
                to,
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
    fun validate(): Call = apply {
        if (validated) {
            return@apply
        }

        id()
        answeredAt()
        direction()
        durationSeconds()
        endedAt()
        failureReason()
        from().ifPresent { it.validate() }
        number()
        price()
        recordingAvailable()
        startedAt()
        status()
        timeline().ifPresent { it.forEach { it.validate() } }
        to().ifPresent { it.validate() }
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
            (if (answeredAt.asKnown().isPresent) 1 else 0) +
            (if (direction.asKnown().isPresent) 1 else 0) +
            (if (durationSeconds.asKnown().isPresent) 1 else 0) +
            (if (endedAt.asKnown().isPresent) 1 else 0) +
            (if (failureReason.asKnown().isPresent) 1 else 0) +
            (from.asKnown().getOrNull()?.validity() ?: 0) +
            (if (number.asKnown().isPresent) 1 else 0) +
            (if (price.asKnown().isPresent) 1 else 0) +
            (if (recordingAvailable.asKnown().isPresent) 1 else 0) +
            (if (startedAt.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (timeline.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (to.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Call &&
            id == other.id &&
            answeredAt == other.answeredAt &&
            direction == other.direction &&
            durationSeconds == other.durationSeconds &&
            endedAt == other.endedAt &&
            failureReason == other.failureReason &&
            from == other.from &&
            number == other.number &&
            price == other.price &&
            recordingAvailable == other.recordingAvailable &&
            startedAt == other.startedAt &&
            status == other.status &&
            timeline == other.timeline &&
            to == other.to &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            answeredAt,
            direction,
            durationSeconds,
            endedAt,
            failureReason,
            from,
            number,
            price,
            recordingAvailable,
            startedAt,
            status,
            timeline,
            to,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Call{id=$id, answeredAt=$answeredAt, direction=$direction, durationSeconds=$durationSeconds, endedAt=$endedAt, failureReason=$failureReason, from=$from, number=$number, price=$price, recordingAvailable=$recordingAvailable, startedAt=$startedAt, status=$status, timeline=$timeline, to=$to, additionalProperties=$additionalProperties}"
}
