// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class WebhookListEventsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<ApiError>,
    private val meta: JsonField<ApiMeta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<ApiError> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<ApiMeta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * The response data (null if error)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error details (null if successful)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<ApiError> = error.getOptional("error")

    /**
     * Metadata about the request and response
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun meta(): Optional<ApiMeta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
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
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ApiError> = error

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

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListEventsResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListEventsResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<ApiError> = JsonMissing.of()
        private var meta: JsonField<ApiMeta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookListEventsResponse: WebhookListEventsResponse) = apply {
            data = webhookListEventsResponse.data
            error = webhookListEventsResponse.error
            meta = webhookListEventsResponse.meta
            success = webhookListEventsResponse.success
            additionalProperties = webhookListEventsResponse.additionalProperties.toMutableMap()
        }

        /** The response data (null if error) */
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

        /** Error details (null if successful) */
        fun error(error: ApiError?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ApiError>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [ApiError] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<ApiError>) = apply { this.error = error }

        /** Metadata about the request and response */
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
         * Returns an immutable instance of [WebhookListEventsResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookListEventsResponse =
            WebhookListEventsResponse(
                data,
                error,
                meta,
                success,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WebhookListEventsResponse = apply {
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
        } catch (e: SentDmInvalidDataException) {
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

    /** The response data (null if error) */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val events: JsonField<List<Event>>,
        private val pagination: JsonField<PaginationMeta>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("events")
            @ExcludeMissing
            events: JsonField<List<Event>> = JsonMissing.of(),
            @JsonProperty("pagination")
            @ExcludeMissing
            pagination: JsonField<PaginationMeta> = JsonMissing.of(),
        ) : this(events, pagination, mutableMapOf())

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun events(): Optional<List<Event>> = events.getOptional("events")

        /**
         * Pagination metadata for list responses
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun pagination(): Optional<PaginationMeta> = pagination.getOptional("pagination")

        /**
         * Returns the raw JSON value of [events].
         *
         * Unlike [events], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("events") @ExcludeMissing fun _events(): JsonField<List<Event>> = events

        /**
         * Returns the raw JSON value of [pagination].
         *
         * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pagination")
        @ExcludeMissing
        fun _pagination(): JsonField<PaginationMeta> = pagination

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

            private var events: JsonField<MutableList<Event>>? = null
            private var pagination: JsonField<PaginationMeta> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                events = data.events.map { it.toMutableList() }
                pagination = data.pagination
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun events(events: List<Event>) = events(JsonField.of(events))

            /**
             * Sets [Builder.events] to an arbitrary JSON value.
             *
             * You should usually call [Builder.events] with a well-typed `List<Event>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun events(events: JsonField<List<Event>>) = apply {
                this.events = events.map { it.toMutableList() }
            }

            /**
             * Adds a single [Event] to [events].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEvent(event: Event) = apply {
                events =
                    (events ?: JsonField.of(mutableListOf())).also {
                        checkKnown("events", it).add(event)
                    }
            }

            /** Pagination metadata for list responses */
            fun pagination(pagination: PaginationMeta) = pagination(JsonField.of(pagination))

            /**
             * Sets [Builder.pagination] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pagination] with a well-typed [PaginationMeta] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pagination(pagination: JsonField<PaginationMeta>) = apply {
                this.pagination = pagination
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    (events ?: JsonMissing.of()).map { it.toImmutable() },
                    pagination,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            events().ifPresent { it.forEach { it.validate() } }
            pagination().ifPresent { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: SentDmInvalidDataException) {
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
            (events.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (pagination.asKnown().getOrNull()?.validity() ?: 0)

        class Event
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val deliveryAttempts: JsonField<Int>,
            private val deliveryStatus: JsonField<String>,
            private val errorMessage: JsonField<String>,
            private val eventData: JsonValue,
            private val eventType: JsonField<String>,
            private val httpStatusCode: JsonField<Int>,
            private val processingCompletedAt: JsonField<OffsetDateTime>,
            private val processingStartedAt: JsonField<OffsetDateTime>,
            private val responseBody: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("created_at")
                @ExcludeMissing
                createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("delivery_attempts")
                @ExcludeMissing
                deliveryAttempts: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("delivery_status")
                @ExcludeMissing
                deliveryStatus: JsonField<String> = JsonMissing.of(),
                @JsonProperty("error_message")
                @ExcludeMissing
                errorMessage: JsonField<String> = JsonMissing.of(),
                @JsonProperty("event_data") @ExcludeMissing eventData: JsonValue = JsonMissing.of(),
                @JsonProperty("event_type")
                @ExcludeMissing
                eventType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("http_status_code")
                @ExcludeMissing
                httpStatusCode: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("processing_completed_at")
                @ExcludeMissing
                processingCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("processing_started_at")
                @ExcludeMissing
                processingStartedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("response_body")
                @ExcludeMissing
                responseBody: JsonField<String> = JsonMissing.of(),
            ) : this(
                id,
                createdAt,
                deliveryAttempts,
                deliveryStatus,
                errorMessage,
                eventData,
                eventType,
                httpStatusCode,
                processingCompletedAt,
                processingStartedAt,
                responseBody,
                mutableMapOf(),
            )

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun deliveryAttempts(): Optional<Int> =
                deliveryAttempts.getOptional("delivery_attempts")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun deliveryStatus(): Optional<String> = deliveryStatus.getOptional("delivery_status")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun errorMessage(): Optional<String> = errorMessage.getOptional("error_message")

            /**
             * This arbitrary value can be deserialized into a custom type using the `convert`
             * method:
             * ```java
             * MyClass myObject = event.eventData().convert(MyClass.class);
             * ```
             */
            @JsonProperty("event_data") @ExcludeMissing fun _eventData(): JsonValue = eventData

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun eventType(): Optional<String> = eventType.getOptional("event_type")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun httpStatusCode(): Optional<Int> = httpStatusCode.getOptional("http_status_code")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun processingCompletedAt(): Optional<OffsetDateTime> =
                processingCompletedAt.getOptional("processing_completed_at")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun processingStartedAt(): Optional<OffsetDateTime> =
                processingStartedAt.getOptional("processing_started_at")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun responseBody(): Optional<String> = responseBody.getOptional("response_body")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [deliveryAttempts].
             *
             * Unlike [deliveryAttempts], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("delivery_attempts")
            @ExcludeMissing
            fun _deliveryAttempts(): JsonField<Int> = deliveryAttempts

            /**
             * Returns the raw JSON value of [deliveryStatus].
             *
             * Unlike [deliveryStatus], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("delivery_status")
            @ExcludeMissing
            fun _deliveryStatus(): JsonField<String> = deliveryStatus

            /**
             * Returns the raw JSON value of [errorMessage].
             *
             * Unlike [errorMessage], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("error_message")
            @ExcludeMissing
            fun _errorMessage(): JsonField<String> = errorMessage

            /**
             * Returns the raw JSON value of [eventType].
             *
             * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("event_type")
            @ExcludeMissing
            fun _eventType(): JsonField<String> = eventType

            /**
             * Returns the raw JSON value of [httpStatusCode].
             *
             * Unlike [httpStatusCode], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("http_status_code")
            @ExcludeMissing
            fun _httpStatusCode(): JsonField<Int> = httpStatusCode

            /**
             * Returns the raw JSON value of [processingCompletedAt].
             *
             * Unlike [processingCompletedAt], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("processing_completed_at")
            @ExcludeMissing
            fun _processingCompletedAt(): JsonField<OffsetDateTime> = processingCompletedAt

            /**
             * Returns the raw JSON value of [processingStartedAt].
             *
             * Unlike [processingStartedAt], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("processing_started_at")
            @ExcludeMissing
            fun _processingStartedAt(): JsonField<OffsetDateTime> = processingStartedAt

            /**
             * Returns the raw JSON value of [responseBody].
             *
             * Unlike [responseBody], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("response_body")
            @ExcludeMissing
            fun _responseBody(): JsonField<String> = responseBody

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

                /** Returns a mutable builder for constructing an instance of [Event]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Event]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var deliveryAttempts: JsonField<Int> = JsonMissing.of()
                private var deliveryStatus: JsonField<String> = JsonMissing.of()
                private var errorMessage: JsonField<String> = JsonMissing.of()
                private var eventData: JsonValue = JsonMissing.of()
                private var eventType: JsonField<String> = JsonMissing.of()
                private var httpStatusCode: JsonField<Int> = JsonMissing.of()
                private var processingCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var processingStartedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var responseBody: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(event: Event) = apply {
                    id = event.id
                    createdAt = event.createdAt
                    deliveryAttempts = event.deliveryAttempts
                    deliveryStatus = event.deliveryStatus
                    errorMessage = event.errorMessage
                    eventData = event.eventData
                    eventType = event.eventType
                    httpStatusCode = event.httpStatusCode
                    processingCompletedAt = event.processingCompletedAt
                    processingStartedAt = event.processingStartedAt
                    responseBody = event.responseBody
                    additionalProperties = event.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                fun deliveryAttempts(deliveryAttempts: Int) =
                    deliveryAttempts(JsonField.of(deliveryAttempts))

                /**
                 * Sets [Builder.deliveryAttempts] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.deliveryAttempts] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun deliveryAttempts(deliveryAttempts: JsonField<Int>) = apply {
                    this.deliveryAttempts = deliveryAttempts
                }

                fun deliveryStatus(deliveryStatus: String) =
                    deliveryStatus(JsonField.of(deliveryStatus))

                /**
                 * Sets [Builder.deliveryStatus] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.deliveryStatus] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun deliveryStatus(deliveryStatus: JsonField<String>) = apply {
                    this.deliveryStatus = deliveryStatus
                }

                fun errorMessage(errorMessage: String?) =
                    errorMessage(JsonField.ofNullable(errorMessage))

                /** Alias for calling [Builder.errorMessage] with `errorMessage.orElse(null)`. */
                fun errorMessage(errorMessage: Optional<String>) =
                    errorMessage(errorMessage.getOrNull())

                /**
                 * Sets [Builder.errorMessage] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.errorMessage] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun errorMessage(errorMessage: JsonField<String>) = apply {
                    this.errorMessage = errorMessage
                }

                fun eventData(eventData: JsonValue) = apply { this.eventData = eventData }

                fun eventType(eventType: String) = eventType(JsonField.of(eventType))

                /**
                 * Sets [Builder.eventType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.eventType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun eventType(eventType: JsonField<String>) = apply { this.eventType = eventType }

                fun httpStatusCode(httpStatusCode: Int?) =
                    httpStatusCode(JsonField.ofNullable(httpStatusCode))

                /**
                 * Alias for [Builder.httpStatusCode].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun httpStatusCode(httpStatusCode: Int) = httpStatusCode(httpStatusCode as Int?)

                /**
                 * Alias for calling [Builder.httpStatusCode] with `httpStatusCode.orElse(null)`.
                 */
                fun httpStatusCode(httpStatusCode: Optional<Int>) =
                    httpStatusCode(httpStatusCode.getOrNull())

                /**
                 * Sets [Builder.httpStatusCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.httpStatusCode] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun httpStatusCode(httpStatusCode: JsonField<Int>) = apply {
                    this.httpStatusCode = httpStatusCode
                }

                fun processingCompletedAt(processingCompletedAt: OffsetDateTime?) =
                    processingCompletedAt(JsonField.ofNullable(processingCompletedAt))

                /**
                 * Alias for calling [Builder.processingCompletedAt] with
                 * `processingCompletedAt.orElse(null)`.
                 */
                fun processingCompletedAt(processingCompletedAt: Optional<OffsetDateTime>) =
                    processingCompletedAt(processingCompletedAt.getOrNull())

                /**
                 * Sets [Builder.processingCompletedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.processingCompletedAt] with a well-typed
                 * [OffsetDateTime] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun processingCompletedAt(processingCompletedAt: JsonField<OffsetDateTime>) =
                    apply {
                        this.processingCompletedAt = processingCompletedAt
                    }

                fun processingStartedAt(processingStartedAt: OffsetDateTime?) =
                    processingStartedAt(JsonField.ofNullable(processingStartedAt))

                /**
                 * Alias for calling [Builder.processingStartedAt] with
                 * `processingStartedAt.orElse(null)`.
                 */
                fun processingStartedAt(processingStartedAt: Optional<OffsetDateTime>) =
                    processingStartedAt(processingStartedAt.getOrNull())

                /**
                 * Sets [Builder.processingStartedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.processingStartedAt] with a well-typed
                 * [OffsetDateTime] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun processingStartedAt(processingStartedAt: JsonField<OffsetDateTime>) = apply {
                    this.processingStartedAt = processingStartedAt
                }

                fun responseBody(responseBody: String?) =
                    responseBody(JsonField.ofNullable(responseBody))

                /** Alias for calling [Builder.responseBody] with `responseBody.orElse(null)`. */
                fun responseBody(responseBody: Optional<String>) =
                    responseBody(responseBody.getOrNull())

                /**
                 * Sets [Builder.responseBody] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.responseBody] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun responseBody(responseBody: JsonField<String>) = apply {
                    this.responseBody = responseBody
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
                 * Returns an immutable instance of [Event].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Event =
                    Event(
                        id,
                        createdAt,
                        deliveryAttempts,
                        deliveryStatus,
                        errorMessage,
                        eventData,
                        eventType,
                        httpStatusCode,
                        processingCompletedAt,
                        processingStartedAt,
                        responseBody,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Event = apply {
                if (validated) {
                    return@apply
                }

                id()
                createdAt()
                deliveryAttempts()
                deliveryStatus()
                errorMessage()
                eventType()
                httpStatusCode()
                processingCompletedAt()
                processingStartedAt()
                responseBody()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: SentDmInvalidDataException) {
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
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (deliveryAttempts.asKnown().isPresent) 1 else 0) +
                    (if (deliveryStatus.asKnown().isPresent) 1 else 0) +
                    (if (errorMessage.asKnown().isPresent) 1 else 0) +
                    (if (eventType.asKnown().isPresent) 1 else 0) +
                    (if (httpStatusCode.asKnown().isPresent) 1 else 0) +
                    (if (processingCompletedAt.asKnown().isPresent) 1 else 0) +
                    (if (processingStartedAt.asKnown().isPresent) 1 else 0) +
                    (if (responseBody.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Event &&
                    id == other.id &&
                    createdAt == other.createdAt &&
                    deliveryAttempts == other.deliveryAttempts &&
                    deliveryStatus == other.deliveryStatus &&
                    errorMessage == other.errorMessage &&
                    eventData == other.eventData &&
                    eventType == other.eventType &&
                    httpStatusCode == other.httpStatusCode &&
                    processingCompletedAt == other.processingCompletedAt &&
                    processingStartedAt == other.processingStartedAt &&
                    responseBody == other.responseBody &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    createdAt,
                    deliveryAttempts,
                    deliveryStatus,
                    errorMessage,
                    eventData,
                    eventType,
                    httpStatusCode,
                    processingCompletedAt,
                    processingStartedAt,
                    responseBody,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Event{id=$id, createdAt=$createdAt, deliveryAttempts=$deliveryAttempts, deliveryStatus=$deliveryStatus, errorMessage=$errorMessage, eventData=$eventData, eventType=$eventType, httpStatusCode=$httpStatusCode, processingCompletedAt=$processingCompletedAt, processingStartedAt=$processingStartedAt, responseBody=$responseBody, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                events == other.events &&
                pagination == other.pagination &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(events, pagination, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{events=$events, pagination=$pagination, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListEventsResponse &&
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
        "WebhookListEventsResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
