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
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class ApiResponseOfCall
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<ErrorDetail>,
    private val meta: JsonField<ApiMeta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<ErrorDetail> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<ApiMeta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * A call record
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error information
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun error(): Optional<ErrorDetail> = error.getOptional("error")

    /**
     * Request and response metadata
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun meta(): Optional<ApiMeta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun success(): Optional<Boolean> = success.getOptional("success")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ErrorDetail> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<ApiMeta> = meta

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

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

        /** Returns a mutable builder for constructing an instance of [ApiResponseOfCall]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiResponseOfCall]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<ErrorDetail> = JsonMissing.of()
        private var meta: JsonField<ApiMeta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(apiResponseOfCall: ApiResponseOfCall) = apply {
            data = apiResponseOfCall.data
            error = apiResponseOfCall.error
            meta = apiResponseOfCall.meta
            success = apiResponseOfCall.success
            additionalProperties = apiResponseOfCall.additionalProperties.toMutableMap()
        }

        /** A call record */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Error information */
        fun error(error: ErrorDetail?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ErrorDetail>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [ErrorDetail] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun error(error: JsonField<ErrorDetail>) = apply { this.error = error }

        /** Request and response metadata */
        fun meta(meta: ApiMeta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [ApiMeta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<ApiMeta>) = apply { this.meta = meta }

        /** Indicates whether the request was successful */
        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

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
         * Returns an immutable instance of [ApiResponseOfCall].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ApiResponseOfCall =
            ApiResponseOfCall(data, error, meta, success, additionalProperties.toMutableMap())
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
    fun validate(): ApiResponseOfCall = apply {
        if (validated) {
            return@apply
        }

        data().ifPresent { it.validate() }
        error().ifPresent { it.validate() }
        meta().ifPresent { it.validate() }
        success()
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    /** A call record */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val answeredAt: JsonField<OffsetDateTime>,
        private val direction: JsonField<String>,
        private val durationSeconds: JsonField<Int>,
        private val endedAt: JsonField<OffsetDateTime>,
        private val failureReason: JsonField<String>,
        private val from: JsonField<From>,
        private val mode: JsonField<String>,
        private val number: JsonField<String>,
        private val price: JsonField<Double>,
        private val recordingAvailable: JsonField<Boolean>,
        private val startedAt: JsonField<OffsetDateTime>,
        private val status: JsonField<String>,
        private val timeline: JsonField<List<Timeline>>,
        private val to: JsonField<To>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("answered_at")
            @ExcludeMissing
            answeredAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("direction")
            @ExcludeMissing
            direction: JsonField<String> = JsonMissing.of(),
            @JsonProperty("duration_seconds")
            @ExcludeMissing
            durationSeconds: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("ended_at")
            @ExcludeMissing
            endedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("failure_reason")
            @ExcludeMissing
            failureReason: JsonField<String> = JsonMissing.of(),
            @JsonProperty("from") @ExcludeMissing from: JsonField<From> = JsonMissing.of(),
            @JsonProperty("mode") @ExcludeMissing mode: JsonField<String> = JsonMissing.of(),
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
            timeline: JsonField<List<Timeline>> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<To> = JsonMissing.of(),
        ) : this(
            id,
            answeredAt,
            direction,
            durationSeconds,
            endedAt,
            failureReason,
            from,
            mode,
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
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * When the call was answered (UTC). Null until then, and always null for a call between two
         * of your app users
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun answeredAt(): Optional<OffsetDateTime> = answeredAt.getOptional("answered_at")

        /**
         * outbound for a call placed from your app, inbound for a call to one of your numbers
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun direction(): Optional<String> = direction.getOptional("direction")

        /**
         * Billable duration in seconds. Null while the call is live
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun durationSeconds(): Optional<Int> = durationSeconds.getOptional("duration_seconds")

        /**
         * When the call ended (UTC). Null while the call is live
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun endedAt(): Optional<OffsetDateTime> = endedAt.getOptional("ended_at")

        /**
         * Why the call did not complete: callback_timeout, invalid_answer, insufficient_balance,
         * destination_blocked, callback_not_configured, rejected or no_answer. Null while the call
         * is live, when it completed, and when it failed without a recorded reason
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun failureReason(): Optional<String> = failureReason.getOptional("failure_reason")

        /**
         * One end of a call
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun from(): Optional<From> = from.getOptional("from")

        /**
         * The calling mode: inapp for a call between people in your app and phone numbers, routed
         * by your number's callback URL
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mode(): Optional<String> = mode.getOptional("mode")

        /**
         * Your number that owns the call, in E.164 format: the dialed number for an inbound call,
         * the caller's bound number for a call placed from your app
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun number(): Optional<String> = number.getOptional("number")

        /**
         * What the call cost. Null until it has been priced
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun price(): Optional<Double> = price.getOptional("price")

        /**
         * True once a recording of the call is available
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recordingAvailable(): Optional<Boolean> =
            recordingAvailable.getOptional("recording_available")

        /**
         * When the call was placed (UTC)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun startedAt(): Optional<OffsetDateTime> = startedAt.getOptional("started_at")

        /**
         * INITIATED, RINGING, ANSWERED, COMPLETED, FAILED, NO_ANSWER or REJECTED
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<String> = status.getOptional("status")

        /**
         * When the call entered each status, oldest first. Only returned when reading one call
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timeline(): Optional<List<Timeline>> = timeline.getOptional("timeline")

        /**
         * One end of a call
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun to(): Optional<To> = to.getOptional("to")

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
         * Unlike [durationSeconds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("duration_seconds")
        @ExcludeMissing
        fun _durationSeconds(): JsonField<Int> = durationSeconds

        /**
         * Returns the raw JSON value of [endedAt].
         *
         * Unlike [endedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ended_at")
        @ExcludeMissing
        fun _endedAt(): JsonField<OffsetDateTime> = endedAt

        /**
         * Returns the raw JSON value of [failureReason].
         *
         * Unlike [failureReason], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("failure_reason")
        @ExcludeMissing
        fun _failureReason(): JsonField<String> = failureReason

        /**
         * Returns the raw JSON value of [from].
         *
         * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<From> = from

        /**
         * Returns the raw JSON value of [mode].
         *
         * Unlike [mode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mode") @ExcludeMissing fun _mode(): JsonField<String> = mode

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
         * Unlike [recordingAvailable], this method doesn't throw if the JSON field has an
         * unexpected type.
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
        fun _timeline(): JsonField<List<Timeline>> = timeline

        /**
         * Returns the raw JSON value of [to].
         *
         * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<To> = to

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var answeredAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var direction: JsonField<String> = JsonMissing.of()
            private var durationSeconds: JsonField<Int> = JsonMissing.of()
            private var endedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var failureReason: JsonField<String> = JsonMissing.of()
            private var from: JsonField<From> = JsonMissing.of()
            private var mode: JsonField<String> = JsonMissing.of()
            private var number: JsonField<String> = JsonMissing.of()
            private var price: JsonField<Double> = JsonMissing.of()
            private var recordingAvailable: JsonField<Boolean> = JsonMissing.of()
            private var startedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var status: JsonField<String> = JsonMissing.of()
            private var timeline: JsonField<MutableList<Timeline>>? = null
            private var to: JsonField<To> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                answeredAt = data.answeredAt
                direction = data.direction
                durationSeconds = data.durationSeconds
                endedAt = data.endedAt
                failureReason = data.failureReason
                from = data.from
                mode = data.mode
                number = data.number
                price = data.price
                recordingAvailable = data.recordingAvailable
                startedAt = data.startedAt
                status = data.status
                timeline = data.timeline.map { it.toMutableList() }
                to = data.to
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /**
             * The call id, the same one carried by the call.request question and every call webhook
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * When the call was answered (UTC). Null until then, and always null for a call between
             * two of your app users
             */
            fun answeredAt(answeredAt: OffsetDateTime?) =
                answeredAt(JsonField.ofNullable(answeredAt))

            /** Alias for calling [Builder.answeredAt] with `answeredAt.orElse(null)`. */
            fun answeredAt(answeredAt: Optional<OffsetDateTime>) =
                answeredAt(answeredAt.getOrNull())

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

            /**
             * outbound for a call placed from your app, inbound for a call to one of your numbers
             */
            fun direction(direction: String) = direction(JsonField.of(direction))

            /**
             * Sets [Builder.direction] to an arbitrary JSON value.
             *
             * You should usually call [Builder.direction] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.durationSeconds] with a well-typed [Int] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Why the call did not complete: callback_timeout, invalid_answer,
             * insufficient_balance, destination_blocked, callback_not_configured, rejected or
             * no_answer. Null while the call is live, when it completed, and when it failed without
             * a recorded reason
             */
            fun failureReason(failureReason: String?) =
                failureReason(JsonField.ofNullable(failureReason))

            /** Alias for calling [Builder.failureReason] with `failureReason.orElse(null)`. */
            fun failureReason(failureReason: Optional<String>) =
                failureReason(failureReason.getOrNull())

            /**
             * Sets [Builder.failureReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failureReason] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun failureReason(failureReason: JsonField<String>) = apply {
                this.failureReason = failureReason
            }

            /** One end of a call */
            fun from(from: From) = from(JsonField.of(from))

            /**
             * Sets [Builder.from] to an arbitrary JSON value.
             *
             * You should usually call [Builder.from] with a well-typed [From] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun from(from: JsonField<From>) = apply { this.from = from }

            /**
             * The calling mode: inapp for a call between people in your app and phone numbers,
             * routed by your number's callback URL
             */
            fun mode(mode: String) = mode(JsonField.of(mode))

            /**
             * Sets [Builder.mode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mode] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mode(mode: JsonField<String>) = apply { this.mode = mode }

            /**
             * Your number that owns the call, in E.164 format: the dialed number for an inbound
             * call, the caller's bound number for a call placed from your app
             */
            fun number(number: String) = number(JsonField.of(number))

            /**
             * Sets [Builder.number] to an arbitrary JSON value.
             *
             * You should usually call [Builder.number] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.price] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun price(price: JsonField<Double>) = apply { this.price = price }

            /** True once a recording of the call is available */
            fun recordingAvailable(recordingAvailable: Boolean) =
                recordingAvailable(JsonField.of(recordingAvailable))

            /**
             * Sets [Builder.recordingAvailable] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recordingAvailable] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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
            fun startedAt(startedAt: JsonField<OffsetDateTime>) = apply {
                this.startedAt = startedAt
            }

            /** INITIATED, RINGING, ANSWERED, COMPLETED, FAILED, NO_ANSWER or REJECTED */
            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            /**
             * When the call entered each status, oldest first. Only returned when reading one call
             */
            fun timeline(timeline: List<Timeline>?) = timeline(JsonField.ofNullable(timeline))

            /** Alias for calling [Builder.timeline] with `timeline.orElse(null)`. */
            fun timeline(timeline: Optional<List<Timeline>>) = timeline(timeline.getOrNull())

            /**
             * Sets [Builder.timeline] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeline] with a well-typed `List<Timeline>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeline(timeline: JsonField<List<Timeline>>) = apply {
                this.timeline = timeline.map { it.toMutableList() }
            }

            /**
             * Adds a single [Timeline] to [Builder.timeline].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTimeline(timeline: Timeline) = apply {
                this.timeline =
                    (this.timeline ?: JsonField.of(mutableListOf())).also {
                        checkKnown("timeline", it).add(timeline)
                    }
            }

            /** One end of a call */
            fun to(to: To) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed [To] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun to(to: JsonField<To>) = apply { this.to = to }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    id,
                    answeredAt,
                    direction,
                    durationSeconds,
                    endedAt,
                    failureReason,
                    from,
                    mode,
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
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws SentInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Data = apply {
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
            mode()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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
                (if (mode.asKnown().isPresent) 1 else 0) +
                (if (number.asKnown().isPresent) 1 else 0) +
                (if (price.asKnown().isPresent) 1 else 0) +
                (if (recordingAvailable.asKnown().isPresent) 1 else 0) +
                (if (startedAt.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (timeline.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (to.asKnown().getOrNull()?.validity() ?: 0)

        /** One end of a call */
        class From
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val kind: JsonField<String>,
            private val value: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("kind") @ExcludeMissing kind: JsonField<String> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            ) : this(kind, value, mutableMapOf())

            /**
             * user for one of your app users, number for a phone number, conference for a room,
             * anonymous for a caller who withheld their number
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun kind(): Optional<String> = kind.getOptional("kind")

            /**
             * The app user's identity, the phone number in E.164 format, or the room name. Null
             * when the kind is anonymous
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun value(): Optional<String> = value.getOptional("value")

            /**
             * Returns the raw JSON value of [kind].
             *
             * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<String> = kind

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

                /** Returns a mutable builder for constructing an instance of [From]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [From]. */
            class Builder internal constructor() {

                private var kind: JsonField<String> = JsonMissing.of()
                private var value: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(from: From) = apply {
                    kind = from.kind
                    value = from.value
                    additionalProperties = from.additionalProperties.toMutableMap()
                }

                /**
                 * user for one of your app users, number for a phone number, conference for a room,
                 * anonymous for a caller who withheld their number
                 */
                fun kind(kind: String) = kind(JsonField.of(kind))

                /**
                 * Sets [Builder.kind] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kind] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun kind(kind: JsonField<String>) = apply { this.kind = kind }

                /**
                 * The app user's identity, the phone number in E.164 format, or the room name. Null
                 * when the kind is anonymous
                 */
                fun value(value: String?) = value(JsonField.ofNullable(value))

                /** Alias for calling [Builder.value] with `value.orElse(null)`. */
                fun value(value: Optional<String>) = value(value.getOrNull())

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<String>) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [From].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): From = From(kind, value, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): From = apply {
                if (validated) {
                    return@apply
                }

                kind()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (kind.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is From &&
                    kind == other.kind &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(kind, value, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "From{kind=$kind, value=$value, additionalProperties=$additionalProperties}"
        }

        /** When a call entered a status */
        class Timeline
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val status: JsonField<String>,
            private val timestamp: JsonField<OffsetDateTime>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("status")
                @ExcludeMissing
                status: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            ) : this(status, timestamp, mutableMapOf())

            /**
             * INITIATED, RINGING, ANSWERED, COMPLETED, FAILED, NO_ANSWER or REJECTED
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun status(): Optional<String> = status.getOptional("status")

            /**
             * When the call entered this status (UTC)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [status].
             *
             * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<OffsetDateTime> = timestamp

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

                /** Returns a mutable builder for constructing an instance of [Timeline]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Timeline]. */
            class Builder internal constructor() {

                private var status: JsonField<String> = JsonMissing.of()
                private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(timeline: Timeline) = apply {
                    status = timeline.status
                    timestamp = timeline.timestamp
                    additionalProperties = timeline.additionalProperties.toMutableMap()
                }

                /** INITIATED, RINGING, ANSWERED, COMPLETED, FAILED, NO_ANSWER or REJECTED */
                fun status(status: String) = status(JsonField.of(status))

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<String>) = apply { this.status = status }

                /** When the call entered this status (UTC) */
                fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                    this.timestamp = timestamp
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Timeline].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Timeline =
                    Timeline(status, timestamp, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Timeline = apply {
                if (validated) {
                    return@apply
                }

                status()
                timestamp()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (status.asKnown().isPresent) 1 else 0) +
                    (if (timestamp.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Timeline &&
                    status == other.status &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(status, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Timeline{status=$status, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        /** One end of a call */
        class To
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val kind: JsonField<String>,
            private val value: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("kind") @ExcludeMissing kind: JsonField<String> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            ) : this(kind, value, mutableMapOf())

            /**
             * user for one of your app users, number for a phone number, conference for a room,
             * anonymous for a caller who withheld their number
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun kind(): Optional<String> = kind.getOptional("kind")

            /**
             * The app user's identity, the phone number in E.164 format, or the room name. Null
             * when the kind is anonymous
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun value(): Optional<String> = value.getOptional("value")

            /**
             * Returns the raw JSON value of [kind].
             *
             * Unlike [kind], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("kind") @ExcludeMissing fun _kind(): JsonField<String> = kind

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

                /** Returns a mutable builder for constructing an instance of [To]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [To]. */
            class Builder internal constructor() {

                private var kind: JsonField<String> = JsonMissing.of()
                private var value: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(to: To) = apply {
                    kind = to.kind
                    value = to.value
                    additionalProperties = to.additionalProperties.toMutableMap()
                }

                /**
                 * user for one of your app users, number for a phone number, conference for a room,
                 * anonymous for a caller who withheld their number
                 */
                fun kind(kind: String) = kind(JsonField.of(kind))

                /**
                 * Sets [Builder.kind] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kind] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun kind(kind: JsonField<String>) = apply { this.kind = kind }

                /**
                 * The app user's identity, the phone number in E.164 format, or the room name. Null
                 * when the kind is anonymous
                 */
                fun value(value: String?) = value(JsonField.ofNullable(value))

                /** Alias for calling [Builder.value] with `value.orElse(null)`. */
                fun value(value: Optional<String>) = value(value.getOrNull())

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<String>) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [To].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): To = To(kind, value, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): To = apply {
                if (validated) {
                    return@apply
                }

                kind()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (kind.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is To &&
                    kind == other.kind &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(kind, value, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "To{kind=$kind, value=$value, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                answeredAt == other.answeredAt &&
                direction == other.direction &&
                durationSeconds == other.durationSeconds &&
                endedAt == other.endedAt &&
                failureReason == other.failureReason &&
                from == other.from &&
                mode == other.mode &&
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
                mode,
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
            "Data{id=$id, answeredAt=$answeredAt, direction=$direction, durationSeconds=$durationSeconds, endedAt=$endedAt, failureReason=$failureReason, from=$from, mode=$mode, number=$number, price=$price, recordingAvailable=$recordingAvailable, startedAt=$startedAt, status=$status, timeline=$timeline, to=$to, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiResponseOfCall &&
            data == other.data &&
            error == other.error &&
            meta == other.meta &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, error, meta, success, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ApiResponseOfCall{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
