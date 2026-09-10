// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.BaseDeserializer
import dm.sent.core.BaseSerializer
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.allMaxBy
import dm.sent.core.getOrThrow
import dm.sent.errors.SentInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class WebhookListEventsResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val deliveryAttempts: JsonField<Int>,
    private val deliveryStatus: JsonField<String>,
    private val errorMessage: JsonField<String>,
    private val eventData: JsonField<EventData>,
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
        @JsonProperty("event_data")
        @ExcludeMissing
        eventData: JsonField<EventData> = JsonMissing.of(),
        @JsonProperty("event_type") @ExcludeMissing eventType: JsonField<String> = JsonMissing.of(),
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
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun deliveryAttempts(): Optional<Int> = deliveryAttempts.getOptional("delivery_attempts")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun deliveryStatus(): Optional<String> = deliveryStatus.getOptional("delivery_status")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun errorMessage(): Optional<String> = errorMessage.getOptional("error_message")

    /**
     * The exact event body that was delivered, or attempted, for this record. One of the three
     * webhook envelopes: a message status change, an inbound message, or a template status change.
     * Read field and event to tell which, the same way your endpoint does.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun eventData(): Optional<EventData> = eventData.getOptional("event_data")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun eventType(): Optional<String> = eventType.getOptional("event_type")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun httpStatusCode(): Optional<Int> = httpStatusCode.getOptional("http_status_code")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun processingCompletedAt(): Optional<OffsetDateTime> =
        processingCompletedAt.getOptional("processing_completed_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun processingStartedAt(): Optional<OffsetDateTime> =
        processingStartedAt.getOptional("processing_started_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
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
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [deliveryAttempts].
     *
     * Unlike [deliveryAttempts], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("delivery_attempts")
    @ExcludeMissing
    fun _deliveryAttempts(): JsonField<Int> = deliveryAttempts

    /**
     * Returns the raw JSON value of [deliveryStatus].
     *
     * Unlike [deliveryStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("delivery_status")
    @ExcludeMissing
    fun _deliveryStatus(): JsonField<String> = deliveryStatus

    /**
     * Returns the raw JSON value of [errorMessage].
     *
     * Unlike [errorMessage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_message")
    @ExcludeMissing
    fun _errorMessage(): JsonField<String> = errorMessage

    /**
     * Returns the raw JSON value of [eventData].
     *
     * Unlike [eventData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_data") @ExcludeMissing fun _eventData(): JsonField<EventData> = eventData

    /**
     * Returns the raw JSON value of [eventType].
     *
     * Unlike [eventType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_type") @ExcludeMissing fun _eventType(): JsonField<String> = eventType

    /**
     * Returns the raw JSON value of [httpStatusCode].
     *
     * Unlike [httpStatusCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("http_status_code")
    @ExcludeMissing
    fun _httpStatusCode(): JsonField<Int> = httpStatusCode

    /**
     * Returns the raw JSON value of [processingCompletedAt].
     *
     * Unlike [processingCompletedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("processing_completed_at")
    @ExcludeMissing
    fun _processingCompletedAt(): JsonField<OffsetDateTime> = processingCompletedAt

    /**
     * Returns the raw JSON value of [processingStartedAt].
     *
     * Unlike [processingStartedAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("processing_started_at")
    @ExcludeMissing
    fun _processingStartedAt(): JsonField<OffsetDateTime> = processingStartedAt

    /**
     * Returns the raw JSON value of [responseBody].
     *
     * Unlike [responseBody], this method doesn't throw if the JSON field has an unexpected type.
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

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListEventsResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListEventsResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var deliveryAttempts: JsonField<Int> = JsonMissing.of()
        private var deliveryStatus: JsonField<String> = JsonMissing.of()
        private var errorMessage: JsonField<String> = JsonMissing.of()
        private var eventData: JsonField<EventData> = JsonMissing.of()
        private var eventType: JsonField<String> = JsonMissing.of()
        private var httpStatusCode: JsonField<Int> = JsonMissing.of()
        private var processingCompletedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var processingStartedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var responseBody: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookListEventsResponse: WebhookListEventsResponse) = apply {
            id = webhookListEventsResponse.id
            createdAt = webhookListEventsResponse.createdAt
            deliveryAttempts = webhookListEventsResponse.deliveryAttempts
            deliveryStatus = webhookListEventsResponse.deliveryStatus
            errorMessage = webhookListEventsResponse.errorMessage
            eventData = webhookListEventsResponse.eventData
            eventType = webhookListEventsResponse.eventType
            httpStatusCode = webhookListEventsResponse.httpStatusCode
            processingCompletedAt = webhookListEventsResponse.processingCompletedAt
            processingStartedAt = webhookListEventsResponse.processingStartedAt
            responseBody = webhookListEventsResponse.responseBody
            additionalProperties = webhookListEventsResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun deliveryAttempts(deliveryAttempts: Int) =
            deliveryAttempts(JsonField.of(deliveryAttempts))

        /**
         * Sets [Builder.deliveryAttempts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveryAttempts] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun deliveryAttempts(deliveryAttempts: JsonField<Int>) = apply {
            this.deliveryAttempts = deliveryAttempts
        }

        fun deliveryStatus(deliveryStatus: String) = deliveryStatus(JsonField.of(deliveryStatus))

        /**
         * Sets [Builder.deliveryStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveryStatus] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveryStatus(deliveryStatus: JsonField<String>) = apply {
            this.deliveryStatus = deliveryStatus
        }

        fun errorMessage(errorMessage: String?) = errorMessage(JsonField.ofNullable(errorMessage))

        /** Alias for calling [Builder.errorMessage] with `errorMessage.orElse(null)`. */
        fun errorMessage(errorMessage: Optional<String>) = errorMessage(errorMessage.getOrNull())

        /**
         * Sets [Builder.errorMessage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorMessage] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun errorMessage(errorMessage: JsonField<String>) = apply {
            this.errorMessage = errorMessage
        }

        /**
         * The exact event body that was delivered, or attempted, for this record. One of the three
         * webhook envelopes: a message status change, an inbound message, or a template status
         * change. Read field and event to tell which, the same way your endpoint does.
         */
        fun eventData(eventData: EventData) = eventData(JsonField.of(eventData))

        /**
         * Sets [Builder.eventData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventData] with a well-typed [EventData] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun eventData(eventData: JsonField<EventData>) = apply { this.eventData = eventData }

        /** Alias for calling [eventData] with `EventData.ofMessageEvent(messageEvent)`. */
        fun eventData(messageEvent: MessageEvent) =
            eventData(EventData.ofMessageEvent(messageEvent))

        /**
         * Alias for calling [eventData] with
         * `EventData.ofInboundMessageEvent(inboundMessageEvent)`.
         */
        fun eventData(inboundMessageEvent: InboundMessageEvent) =
            eventData(EventData.ofInboundMessageEvent(inboundMessageEvent))

        /** Alias for calling [eventData] with `EventData.ofTemplateEvent(templateEvent)`. */
        fun eventData(templateEvent: TemplateEvent) =
            eventData(EventData.ofTemplateEvent(templateEvent))

        fun eventType(eventType: String) = eventType(JsonField.of(eventType))

        /**
         * Sets [Builder.eventType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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

        /** Alias for calling [Builder.httpStatusCode] with `httpStatusCode.orElse(null)`. */
        fun httpStatusCode(httpStatusCode: Optional<Int>) =
            httpStatusCode(httpStatusCode.getOrNull())

        /**
         * Sets [Builder.httpStatusCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.httpStatusCode] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun processingCompletedAt(processingCompletedAt: JsonField<OffsetDateTime>) = apply {
            this.processingCompletedAt = processingCompletedAt
        }

        fun processingStartedAt(processingStartedAt: OffsetDateTime?) =
            processingStartedAt(JsonField.ofNullable(processingStartedAt))

        /**
         * Alias for calling [Builder.processingStartedAt] with `processingStartedAt.orElse(null)`.
         */
        fun processingStartedAt(processingStartedAt: Optional<OffsetDateTime>) =
            processingStartedAt(processingStartedAt.getOrNull())

        /**
         * Sets [Builder.processingStartedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.processingStartedAt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun processingStartedAt(processingStartedAt: JsonField<OffsetDateTime>) = apply {
            this.processingStartedAt = processingStartedAt
        }

        fun responseBody(responseBody: String?) = responseBody(JsonField.ofNullable(responseBody))

        /** Alias for calling [Builder.responseBody] with `responseBody.orElse(null)`. */
        fun responseBody(responseBody: Optional<String>) = responseBody(responseBody.getOrNull())

        /**
         * Sets [Builder.responseBody] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseBody] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): WebhookListEventsResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        deliveryAttempts()
        deliveryStatus()
        errorMessage()
        eventData().ifPresent { it.validate() }
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
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (deliveryAttempts.asKnown().isPresent) 1 else 0) +
            (if (deliveryStatus.asKnown().isPresent) 1 else 0) +
            (if (errorMessage.asKnown().isPresent) 1 else 0) +
            (eventData.asKnown().getOrNull()?.validity() ?: 0) +
            (if (eventType.asKnown().isPresent) 1 else 0) +
            (if (httpStatusCode.asKnown().isPresent) 1 else 0) +
            (if (processingCompletedAt.asKnown().isPresent) 1 else 0) +
            (if (processingStartedAt.asKnown().isPresent) 1 else 0) +
            (if (responseBody.asKnown().isPresent) 1 else 0)

    /**
     * The exact event body that was delivered, or attempted, for this record. One of the three
     * webhook envelopes: a message status change, an inbound message, or a template status change.
     * Read field and event to tell which, the same way your endpoint does.
     */
    @JsonDeserialize(using = EventData.Deserializer::class)
    @JsonSerialize(using = EventData.Serializer::class)
    class EventData
    private constructor(
        private val messageEvent: MessageEvent? = null,
        private val inboundMessageEvent: InboundMessageEvent? = null,
        private val templateEvent: TemplateEvent? = null,
        private val _json: JsonValue? = null,
    ) {

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun messageEvent(): Optional<MessageEvent> = Optional.ofNullable(messageEvent)

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun inboundMessageEvent(): Optional<InboundMessageEvent> =
            Optional.ofNullable(inboundMessageEvent)

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun templateEvent(): Optional<TemplateEvent> = Optional.ofNullable(templateEvent)

        fun isMessageEvent(): Boolean = messageEvent != null

        fun isInboundMessageEvent(): Boolean = inboundMessageEvent != null

        fun isTemplateEvent(): Boolean = templateEvent != null

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asMessageEvent(): MessageEvent = messageEvent.getOrThrow("messageEvent")

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asInboundMessageEvent(): InboundMessageEvent =
            inboundMessageEvent.getOrThrow("inboundMessageEvent")

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asTemplateEvent(): TemplateEvent = templateEvent.getOrThrow("templateEvent")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import dm.sent.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = eventData.accept(new EventData.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitMessageEvent(MessageEvent messageEvent) {
         *         return Optional.of(messageEvent.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws SentInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
         *   the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                messageEvent != null -> visitor.visitMessageEvent(messageEvent)
                inboundMessageEvent != null -> visitor.visitInboundMessageEvent(inboundMessageEvent)
                templateEvent != null -> visitor.visitTemplateEvent(templateEvent)
                else -> visitor.unknown(_json)
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
        fun validate(): EventData = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMessageEvent(messageEvent: MessageEvent) {
                        messageEvent.validate()
                    }

                    override fun visitInboundMessageEvent(
                        inboundMessageEvent: InboundMessageEvent
                    ) {
                        inboundMessageEvent.validate()
                    }

                    override fun visitTemplateEvent(templateEvent: TemplateEvent) {
                        templateEvent.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitMessageEvent(messageEvent: MessageEvent) =
                        messageEvent.validity()

                    override fun visitInboundMessageEvent(
                        inboundMessageEvent: InboundMessageEvent
                    ) = inboundMessageEvent.validity()

                    override fun visitTemplateEvent(templateEvent: TemplateEvent) =
                        templateEvent.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EventData &&
                messageEvent == other.messageEvent &&
                inboundMessageEvent == other.inboundMessageEvent &&
                templateEvent == other.templateEvent
        }

        override fun hashCode(): Int =
            Objects.hash(messageEvent, inboundMessageEvent, templateEvent)

        override fun toString(): String =
            when {
                messageEvent != null -> "EventData{messageEvent=$messageEvent}"
                inboundMessageEvent != null -> "EventData{inboundMessageEvent=$inboundMessageEvent}"
                templateEvent != null -> "EventData{templateEvent=$templateEvent}"
                _json != null -> "EventData{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid EventData")
            }

        companion object {

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofMessageEvent(messageEvent: MessageEvent) = EventData(messageEvent = messageEvent)

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofInboundMessageEvent(inboundMessageEvent: InboundMessageEvent) =
                EventData(inboundMessageEvent = inboundMessageEvent)

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofTemplateEvent(templateEvent: TemplateEvent) =
                EventData(templateEvent = templateEvent)
        }

        /**
         * An interface that defines how to map each variant of [EventData] to a value of type [T].
         */
        interface Visitor<out T> {

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitMessageEvent(messageEvent: MessageEvent): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitInboundMessageEvent(inboundMessageEvent: InboundMessageEvent): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitTemplateEvent(templateEvent: TemplateEvent): T

            /**
             * Maps an unknown variant of [EventData] to a value of type [T].
             *
             * An instance of [EventData] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws SentInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw SentInvalidDataException("Unknown EventData: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<EventData>(EventData::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): EventData {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<MessageEvent>())?.let {
                                EventData(messageEvent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<InboundMessageEvent>())?.let {
                                EventData(inboundMessageEvent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<TemplateEvent>())?.let {
                                EventData(templateEvent = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> EventData(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<EventData>(EventData::class) {

            override fun serialize(
                value: EventData,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.messageEvent != null -> generator.writeObject(value.messageEvent)
                    value.inboundMessageEvent != null ->
                        generator.writeObject(value.inboundMessageEvent)
                    value.templateEvent != null -> generator.writeObject(value.templateEvent)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid EventData")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListEventsResponse &&
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
        "WebhookListEventsResponse{id=$id, createdAt=$createdAt, deliveryAttempts=$deliveryAttempts, deliveryStatus=$deliveryStatus, errorMessage=$errorMessage, eventData=$eventData, eventType=$eventType, httpStatusCode=$httpStatusCode, processingCompletedAt=$processingCompletedAt, processingStartedAt=$processingStartedAt, responseBody=$responseBody, additionalProperties=$additionalProperties}"
}
