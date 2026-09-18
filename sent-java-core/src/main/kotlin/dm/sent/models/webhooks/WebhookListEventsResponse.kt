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
import dm.sent.core.checkRequired
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
     * The exact event body that was delivered, or attempted, for this record. One of the four
     * webhook envelopes: a message status change, an inbound message, a template status change, or
     * a contact consent signal. Read field and event to tell which, the same way your endpoint
     * does.
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
         * The exact event body that was delivered, or attempted, for this record. One of the four
         * webhook envelopes: a message status change, an inbound message, a template status change,
         * or a contact consent signal. Read field and event to tell which, the same way your
         * endpoint does.
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

        /**
         * Alias for calling [eventData] with
         * `EventData.ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload)`.
         */
        fun eventData(
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
                EventData.SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
        ) =
            eventData(
                EventData
                    .ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                    )
            )

        /**
         * Alias for calling [eventData] with
         * `EventData.ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload)`.
         */
        fun eventData(
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
                EventData.SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
        ) =
            eventData(
                EventData
                    .ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                    )
            )

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
     * The exact event body that was delivered, or attempted, for this record. One of the four
     * webhook envelopes: a message status change, an inbound message, a template status change, or
     * a contact consent signal. Read field and event to tell which, the same way your endpoint
     * does.
     */
    @JsonDeserialize(using = EventData.Deserializer::class)
    @JsonSerialize(using = EventData.Serializer::class)
    class EventData
    private constructor(
        private val messageEvent: MessageEvent? = null,
        private val inboundMessageEvent: InboundMessageEvent? = null,
        private val templateEvent: TemplateEvent? = null,
        private val sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload? =
            null,
        private val sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload? =
            null,
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

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload():
            Optional<
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
            > =
            Optional.ofNullable(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
            )

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload():
            Optional<
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
            > =
            Optional.ofNullable(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
            )

        fun isMessageEvent(): Boolean = messageEvent != null

        fun isInboundMessageEvent(): Boolean = inboundMessageEvent != null

        fun isTemplateEvent(): Boolean = templateEvent != null

        fun isSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload():
            Boolean =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload != null

        fun isSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload():
            Boolean =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload != null

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

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload():
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                .getOrThrow(
                    "sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload"
                )

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload():
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                .getOrThrow(
                    "sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload"
                )

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
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload !=
                    null ->
                    visitor
                        .visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                        )
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload !=
                    null ->
                    visitor
                        .visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                        )
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

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                    ) {
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .validate()
                    }

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                    ) {
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .validate()
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

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                    ) =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .validity()

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                    ) =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .validity()

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
                templateEvent == other.templateEvent &&
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload ==
                    other
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload &&
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload ==
                    other
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
        }

        override fun hashCode(): Int =
            Objects.hash(
                messageEvent,
                inboundMessageEvent,
                templateEvent,
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload,
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload,
            )

        override fun toString(): String =
            when {
                messageEvent != null -> "EventData{messageEvent=$messageEvent}"
                inboundMessageEvent != null -> "EventData{inboundMessageEvent=$inboundMessageEvent}"
                templateEvent != null -> "EventData{templateEvent=$templateEvent}"
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload !=
                    null ->
                    "EventData{sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload=$sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload}"
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload !=
                    null ->
                    "EventData{sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload=$sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload}"
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

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
            ) =
                EventData(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                )

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
            ) =
                EventData(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                )
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
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
            ): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
            ): T

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
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<
                                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                                    >(),
                                )
                                ?.let {
                                    EventData(
                                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload =
                                            it,
                                        _json = json,
                                    )
                                },
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<
                                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                                    >(),
                                )
                                ?.let {
                                    EventData(
                                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload =
                                            it,
                                        _json = json,
                                    )
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
                    value
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload !=
                        null ->
                        generator.writeObject(
                            value
                                .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                        )
                    value
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload !=
                        null ->
                        generator.writeObject(
                            value
                                .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                        )
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid EventData")
                }
            }
        }

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        class SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val event: JsonField<String>,
            private val field: JsonField<String>,
            private val payload: JsonField<Payload>,
            private val requestId: JsonField<String>,
            private val timestamp: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
                @JsonProperty("field") @ExcludeMissing field: JsonField<String> = JsonMissing.of(),
                @JsonProperty("payload")
                @ExcludeMissing
                payload: JsonField<Payload> = JsonMissing.of(),
                @JsonProperty("request_id")
                @ExcludeMissing
                requestId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<String> = JsonMissing.of(),
            ) : this(event, field, payload, requestId, timestamp, mutableMapOf())

            /**
             * The specific event within the family, for example message.delivered, message.received
             * or contact.opt_out. Absent on events that have no subtype, so treat it as optional.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun event(): Optional<String> = event.getOptional("event")

            /**
             * The event family, for example message, templates or contact. Route on this first,
             * then on event for the specific change.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun field(): Optional<String> = field.getOptional("field")

            /**
             * Body of a channel event: where one of the customer's channels stands in provisioning
             * and compliance. Delivered when a milestone moves — a registration filed, a verdict
             * returned, a resubmission asked for, a sender gone live — so a customer's own
             * onboarding UI does not have to poll GET /v3/channels.
             *
             * The subject is one item, never the account. A customer's "SMS channel" has no status;
             * a market does. Country, NumberType and SenderValue name which one, so a customer
             * terminating only to Kosovo never receives an event about US 10DLC.
             *
             * Status is the stable half of the contract. It is the same four-value set GET
             * /v3/channels publishes, computed through the same code, so an event and a read of the
             * same market cannot disagree. A subscriber that reads nothing but the status and the
             * subject fields is a correct subscriber. The sub-type on the envelope names the
             * specific milestone and is additive — that vocabulary comes from registries and
             * carriers, which are parties Sent does not control.
             *
             * Status means provisioning and compliance are complete, not that a send will succeed
             * right now. An account can be suspended, or a destination blocked by a routing rule,
             * without either showing up here. Those are separate surfaces and deliberately not
             * modelled on this payload.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun payload(): Optional<Payload> = payload.getOptional("payload")

            /**
             * The event-specific body.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun requestId(): Optional<String> = requestId.getOptional("request_id")

            /**
             * When Sent emitted the event, in UTC (yyyy-MM-ddTHH:mm:ssZ). This is the emission
             * time, not the time the underlying change happened. Use the timestamp inside the
             * payload for the latter.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timestamp(): Optional<String> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [event].
             *
             * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<String> = event

            /**
             * Returns the raw JSON value of [field].
             *
             * Unlike [field], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("field") @ExcludeMissing fun _field(): JsonField<String> = field

            /**
             * Returns the raw JSON value of [payload].
             *
             * Unlike [payload], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("payload") @ExcludeMissing fun _payload(): JsonField<Payload> = payload

            /**
             * Returns the raw JSON value of [requestId].
             *
             * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("request_id")
            @ExcludeMissing
            fun _requestId(): JsonField<String> = requestId

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<String> = timestamp

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
                 * Returns a mutable builder for constructing an instance of
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /**
             * A builder for
             * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload].
             */
            class Builder internal constructor() {

                private var event: JsonField<String> = JsonMissing.of()
                private var field: JsonField<String> = JsonMissing.of()
                private var payload: JsonField<Payload> = JsonMissing.of()
                private var requestId: JsonField<String> = JsonMissing.of()
                private var timestamp: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload:
                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                ) = apply {
                    event =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .event
                    field =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .field
                    payload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .payload
                    requestId =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .requestId
                    timestamp =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .timestamp
                    additionalProperties =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload
                            .additionalProperties
                            .toMutableMap()
                }

                /**
                 * The specific event within the family, for example message.delivered,
                 * message.received or contact.opt_out. Absent on events that have no subtype, so
                 * treat it as optional.
                 */
                fun event(event: String?) = event(JsonField.ofNullable(event))

                /** Alias for calling [Builder.event] with `event.orElse(null)`. */
                fun event(event: Optional<String>) = event(event.getOrNull())

                /**
                 * Sets [Builder.event] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.event] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun event(event: JsonField<String>) = apply { this.event = event }

                /**
                 * The event family, for example message, templates or contact. Route on this first,
                 * then on event for the specific change.
                 */
                fun field(field: String) = field(JsonField.of(field))

                /**
                 * Sets [Builder.field] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.field] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun field(field: JsonField<String>) = apply { this.field = field }

                /**
                 * Body of a channel event: where one of the customer's channels stands in
                 * provisioning and compliance. Delivered when a milestone moves — a registration
                 * filed, a verdict returned, a resubmission asked for, a sender gone live — so a
                 * customer's own onboarding UI does not have to poll GET /v3/channels.
                 *
                 * The subject is one item, never the account. A customer's "SMS channel" has no
                 * status; a market does. Country, NumberType and SenderValue name which one, so a
                 * customer terminating only to Kosovo never receives an event about US 10DLC.
                 *
                 * Status is the stable half of the contract. It is the same four-value set GET
                 * /v3/channels publishes, computed through the same code, so an event and a read of
                 * the same market cannot disagree. A subscriber that reads nothing but the status
                 * and the subject fields is a correct subscriber. The sub-type on the envelope
                 * names the specific milestone and is additive — that vocabulary comes from
                 * registries and carriers, which are parties Sent does not control.
                 *
                 * Status means provisioning and compliance are complete, not that a send will
                 * succeed right now. An account can be suspended, or a destination blocked by a
                 * routing rule, without either showing up here. Those are separate surfaces and
                 * deliberately not modelled on this payload.
                 */
                fun payload(payload: Payload?) = payload(JsonField.ofNullable(payload))

                /** Alias for calling [Builder.payload] with `payload.orElse(null)`. */
                fun payload(payload: Optional<Payload>) = payload(payload.getOrNull())

                /**
                 * Sets [Builder.payload] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.payload] with a well-typed [Payload] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun payload(payload: JsonField<Payload>) = apply { this.payload = payload }

                /** The event-specific body. */
                fun requestId(requestId: String?) = requestId(JsonField.ofNullable(requestId))

                /** Alias for calling [Builder.requestId] with `requestId.orElse(null)`. */
                fun requestId(requestId: Optional<String>) = requestId(requestId.getOrNull())

                /**
                 * Sets [Builder.requestId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

                /**
                 * When Sent emitted the event, in UTC (yyyy-MM-ddTHH:mm:ssZ). This is the emission
                 * time, not the time the underlying change happened. Use the timestamp inside the
                 * payload for the latter.
                 */
                fun timestamp(timestamp: String) = timestamp(JsonField.of(timestamp))

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<String>) = apply { this.timestamp = timestamp }

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
                 * Returns an immutable instance of
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build():
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload =
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload(
                        event,
                        field,
                        payload,
                        requestId,
                        timestamp,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate():
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload =
                apply {
                    if (validated) {
                        return@apply
                    }

                    event()
                    field()
                    payload().ifPresent { it.validate() }
                    requestId()
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
                (if (event.asKnown().isPresent) 1 else 0) +
                    (if (field.asKnown().isPresent) 1 else 0) +
                    (payload.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (requestId.asKnown().isPresent) 1 else 0) +
                    (if (timestamp.asKnown().isPresent) 1 else 0)

            /**
             * Body of a channel event: where one of the customer's channels stands in provisioning
             * and compliance. Delivered when a milestone moves — a registration filed, a verdict
             * returned, a resubmission asked for, a sender gone live — so a customer's own
             * onboarding UI does not have to poll GET /v3/channels.
             *
             * The subject is one item, never the account. A customer's "SMS channel" has no status;
             * a market does. Country, NumberType and SenderValue name which one, so a customer
             * terminating only to Kosovo never receives an event about US 10DLC.
             *
             * Status is the stable half of the contract. It is the same four-value set GET
             * /v3/channels publishes, computed through the same code, so an event and a read of the
             * same market cannot disagree. A subscriber that reads nothing but the status and the
             * subject fields is a correct subscriber. The sub-type on the envelope names the
             * specific milestone and is additive — that vocabulary comes from registries and
             * carriers, which are parties Sent does not control.
             *
             * Status means provisioning and compliance are complete, not that a send will succeed
             * right now. An account can be suspended, or a destination blocked by a routing rule,
             * without either showing up here. Those are separate surfaces and deliberately not
             * modelled on this payload.
             */
            class Payload
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val country: JsonField<String>,
                private val accountId: JsonField<String>,
                private val channel: JsonField<String>,
                private val numberType: JsonField<String>,
                private val reason: JsonField<String>,
                private val senderValue: JsonField<String>,
                private val status: JsonField<String>,
                private val updatedAt: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("country")
                    @ExcludeMissing
                    country: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("account_id")
                    @ExcludeMissing
                    accountId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("channel")
                    @ExcludeMissing
                    channel: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("number_type")
                    @ExcludeMissing
                    numberType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("reason")
                    @ExcludeMissing
                    reason: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("sender_value")
                    @ExcludeMissing
                    senderValue: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("status")
                    @ExcludeMissing
                    status: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("updated_at")
                    @ExcludeMissing
                    updatedAt: JsonField<String> = JsonMissing.of(),
                ) : this(
                    country,
                    accountId,
                    channel,
                    numberType,
                    reason,
                    senderValue,
                    status,
                    updatedAt,
                    mutableMapOf(),
                )

                /**
                 * The market's destination country as an ISO 3166-1 alpha-2 code, for example XK.
                 * Always present, and the property that identifies this payload among the delivered
                 * envelopes — see DeliveredWebhookEvents. Every event in this family reports one
                 * market, and a market has a country.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun country(): String = country.getRequired("country")

                /**
                 * The account whose market this is, named as on every other family. When an
                 * organization receives an event for one of its sender profiles this is the
                 * profile, so a reseller compares it with its own id and anything different is one
                 * of its profiles.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun accountId(): Optional<String> = accountId.getOptional("account_id")

                /**
                 * The channel this market belongs to: sms, whatsapp, or rcs. Never sent — that
                 * value belongs to message events, where it names the smart-routing brand rather
                 * than a channel that can be provisioned.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun channel(): Optional<String> = channel.getOptional("channel")

                /**
                 * The kind of sender the market uses, for example TEN_DLC, LOCAL, or ALPHANUMERIC.
                 * Omitted when the subject has no sender type of its own.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun numberType(): Optional<String> = numberType.getOptional("number_type")

                /**
                 * Why the market reached this state, when a reason was given — a correction
                 * explained, or a campaign lapse. Free text, passed through from the registry or
                 * carrier that wrote it, so treat it as a message to show a human rather than a
                 * value to branch on.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun reason(): Optional<String> = reason.getOptional("reason")

                /**
                 * The sender itself — a number in E.164, or an alphanumeric sender ID.
                 *
                 * Always present, and null until a sender exists. The key is on every delivery so a
                 * subscriber reads one shape rather than branching on whether the field arrived —
                 * the same choice template_id makes on the message payload.
                 *
                 * It can carry a value at any point in the lifecycle, not only once the market is
                 * live: a number ordered and not yet active at the carrier is already known during
                 * PROVISIONING, and an alphanumeric sender the customer chose themselves is known
                 * before anything is filed. It is null while the market is still waiting on a
                 * number, which for a US 10DLC registration is every event up to channel.activated.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun senderValue(): Optional<String> = senderValue.getOptional("sender_value")

                /**
                 * Where the market stands: PENDING_REVIEW, ACTION_NEEDED, PROVISIONING, ACTIVE or
                 * INACTIVE. PENDING_REVIEW means a registry or a carrier holds it and the wait is
                 * theirs; ACTION_NEEDED means it is yours; PROVISIONING means the verdict is in and
                 * Sent is acquiring the sender; INACTIVE means it had a working sender and no
                 * longer does.
                 *
                 * Each event name is the transition into one of these, but the two are separate
                 * fields and may legitimately differ. A resubmission filed against a market whose
                 * sender is already live is channel.submitted carrying ACTIVE: a correction is with
                 * the registry and the sender keeps working. Read both.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun status(): Optional<String> = status.getOptional("status")

                /**
                 * When the transition happened, in UTC (yyyy-MM-ddTHH:mm:ssZ).
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

                /**
                 * Returns the raw JSON value of [country].
                 *
                 * Unlike [country], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

                /**
                 * Returns the raw JSON value of [accountId].
                 *
                 * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("account_id")
                @ExcludeMissing
                fun _accountId(): JsonField<String> = accountId

                /**
                 * Returns the raw JSON value of [channel].
                 *
                 * Unlike [channel], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

                /**
                 * Returns the raw JSON value of [numberType].
                 *
                 * Unlike [numberType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("number_type")
                @ExcludeMissing
                fun _numberType(): JsonField<String> = numberType

                /**
                 * Returns the raw JSON value of [reason].
                 *
                 * Unlike [reason], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

                /**
                 * Returns the raw JSON value of [senderValue].
                 *
                 * Unlike [senderValue], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("sender_value")
                @ExcludeMissing
                fun _senderValue(): JsonField<String> = senderValue

                /**
                 * Returns the raw JSON value of [status].
                 *
                 * Unlike [status], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

                /**
                 * Returns the raw JSON value of [updatedAt].
                 *
                 * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("updated_at")
                @ExcludeMissing
                fun _updatedAt(): JsonField<String> = updatedAt

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
                     * Returns a mutable builder for constructing an instance of [Payload].
                     *
                     * The following fields are required:
                     * ```java
                     * .country()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Payload]. */
                class Builder internal constructor() {

                    private var country: JsonField<String>? = null
                    private var accountId: JsonField<String> = JsonMissing.of()
                    private var channel: JsonField<String> = JsonMissing.of()
                    private var numberType: JsonField<String> = JsonMissing.of()
                    private var reason: JsonField<String> = JsonMissing.of()
                    private var senderValue: JsonField<String> = JsonMissing.of()
                    private var status: JsonField<String> = JsonMissing.of()
                    private var updatedAt: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(payload: Payload) = apply {
                        country = payload.country
                        accountId = payload.accountId
                        channel = payload.channel
                        numberType = payload.numberType
                        reason = payload.reason
                        senderValue = payload.senderValue
                        status = payload.status
                        updatedAt = payload.updatedAt
                        additionalProperties = payload.additionalProperties.toMutableMap()
                    }

                    /**
                     * The market's destination country as an ISO 3166-1 alpha-2 code, for example
                     * XK. Always present, and the property that identifies this payload among the
                     * delivered envelopes — see DeliveredWebhookEvents. Every event in this family
                     * reports one market, and a market has a country.
                     */
                    fun country(country: String) = country(JsonField.of(country))

                    /**
                     * Sets [Builder.country] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.country] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun country(country: JsonField<String>) = apply { this.country = country }

                    /**
                     * The account whose market this is, named as on every other family. When an
                     * organization receives an event for one of its sender profiles this is the
                     * profile, so a reseller compares it with its own id and anything different is
                     * one of its profiles.
                     */
                    fun accountId(accountId: String) = accountId(JsonField.of(accountId))

                    /**
                     * Sets [Builder.accountId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.accountId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun accountId(accountId: JsonField<String>) = apply {
                        this.accountId = accountId
                    }

                    /**
                     * The channel this market belongs to: sms, whatsapp, or rcs. Never sent — that
                     * value belongs to message events, where it names the smart-routing brand
                     * rather than a channel that can be provisioned.
                     */
                    fun channel(channel: String) = channel(JsonField.of(channel))

                    /**
                     * Sets [Builder.channel] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.channel] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun channel(channel: JsonField<String>) = apply { this.channel = channel }

                    /**
                     * The kind of sender the market uses, for example TEN_DLC, LOCAL, or
                     * ALPHANUMERIC. Omitted when the subject has no sender type of its own.
                     */
                    fun numberType(numberType: String?) =
                        numberType(JsonField.ofNullable(numberType))

                    /** Alias for calling [Builder.numberType] with `numberType.orElse(null)`. */
                    fun numberType(numberType: Optional<String>) =
                        numberType(numberType.getOrNull())

                    /**
                     * Sets [Builder.numberType] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.numberType] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun numberType(numberType: JsonField<String>) = apply {
                        this.numberType = numberType
                    }

                    /**
                     * Why the market reached this state, when a reason was given — a correction
                     * explained, or a campaign lapse. Free text, passed through from the registry
                     * or carrier that wrote it, so treat it as a message to show a human rather
                     * than a value to branch on.
                     */
                    fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

                    /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
                    fun reason(reason: Optional<String>) = reason(reason.getOrNull())

                    /**
                     * Sets [Builder.reason] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.reason] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun reason(reason: JsonField<String>) = apply { this.reason = reason }

                    /**
                     * The sender itself — a number in E.164, or an alphanumeric sender ID.
                     *
                     * Always present, and null until a sender exists. The key is on every delivery
                     * so a subscriber reads one shape rather than branching on whether the field
                     * arrived — the same choice template_id makes on the message payload.
                     *
                     * It can carry a value at any point in the lifecycle, not only once the market
                     * is live: a number ordered and not yet active at the carrier is already known
                     * during PROVISIONING, and an alphanumeric sender the customer chose themselves
                     * is known before anything is filed. It is null while the market is still
                     * waiting on a number, which for a US 10DLC registration is every event up to
                     * channel.activated.
                     */
                    fun senderValue(senderValue: String?) =
                        senderValue(JsonField.ofNullable(senderValue))

                    /** Alias for calling [Builder.senderValue] with `senderValue.orElse(null)`. */
                    fun senderValue(senderValue: Optional<String>) =
                        senderValue(senderValue.getOrNull())

                    /**
                     * Sets [Builder.senderValue] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.senderValue] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun senderValue(senderValue: JsonField<String>) = apply {
                        this.senderValue = senderValue
                    }

                    /**
                     * Where the market stands: PENDING_REVIEW, ACTION_NEEDED, PROVISIONING, ACTIVE
                     * or INACTIVE. PENDING_REVIEW means a registry or a carrier holds it and the
                     * wait is theirs; ACTION_NEEDED means it is yours; PROVISIONING means the
                     * verdict is in and Sent is acquiring the sender; INACTIVE means it had a
                     * working sender and no longer does.
                     *
                     * Each event name is the transition into one of these, but the two are separate
                     * fields and may legitimately differ. A resubmission filed against a market
                     * whose sender is already live is channel.submitted carrying ACTIVE: a
                     * correction is with the registry and the sender keeps working. Read both.
                     */
                    fun status(status: String) = status(JsonField.of(status))

                    /**
                     * Sets [Builder.status] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.status] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun status(status: JsonField<String>) = apply { this.status = status }

                    /** When the transition happened, in UTC (yyyy-MM-ddTHH:mm:ssZ). */
                    fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

                    /**
                     * Sets [Builder.updatedAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.updatedAt] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun updatedAt(updatedAt: JsonField<String>) = apply {
                        this.updatedAt = updatedAt
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
                     * Returns an immutable instance of [Payload].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .country()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Payload =
                        Payload(
                            checkRequired("country", country),
                            accountId,
                            channel,
                            numberType,
                            reason,
                            senderValue,
                            status,
                            updatedAt,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Payload = apply {
                    if (validated) {
                        return@apply
                    }

                    country()
                    accountId()
                    channel()
                    numberType()
                    reason()
                    senderValue()
                    status()
                    updatedAt()
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
                    (if (country.asKnown().isPresent) 1 else 0) +
                        (if (accountId.asKnown().isPresent) 1 else 0) +
                        (if (channel.asKnown().isPresent) 1 else 0) +
                        (if (numberType.asKnown().isPresent) 1 else 0) +
                        (if (reason.asKnown().isPresent) 1 else 0) +
                        (if (senderValue.asKnown().isPresent) 1 else 0) +
                        (if (status.asKnown().isPresent) 1 else 0) +
                        (if (updatedAt.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Payload &&
                        country == other.country &&
                        accountId == other.accountId &&
                        channel == other.channel &&
                        numberType == other.numberType &&
                        reason == other.reason &&
                        senderValue == other.senderValue &&
                        status == other.status &&
                        updatedAt == other.updatedAt &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        country,
                        accountId,
                        channel,
                        numberType,
                        reason,
                        senderValue,
                        status,
                        updatedAt,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Payload{country=$country, accountId=$accountId, channel=$channel, numberType=$numberType, reason=$reason, senderValue=$senderValue, status=$status, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload &&
                    event == other.event &&
                    field == other.field &&
                    payload == other.payload &&
                    requestId == other.requestId &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(event, field, payload, requestId, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SentDmServicesCommonServicesWebhooksContractsWebhookEventOfChannelWebhookPayload{event=$event, field=$field, payload=$payload, requestId=$requestId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        class SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val event: JsonField<String>,
            private val field: JsonField<String>,
            private val payload: JsonField<Payload>,
            private val requestId: JsonField<String>,
            private val timestamp: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
                @JsonProperty("field") @ExcludeMissing field: JsonField<String> = JsonMissing.of(),
                @JsonProperty("payload")
                @ExcludeMissing
                payload: JsonField<Payload> = JsonMissing.of(),
                @JsonProperty("request_id")
                @ExcludeMissing
                requestId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timestamp")
                @ExcludeMissing
                timestamp: JsonField<String> = JsonMissing.of(),
            ) : this(event, field, payload, requestId, timestamp, mutableMapOf())

            /**
             * The specific event within the family, for example message.delivered, message.received
             * or contact.opt_out. Absent on events that have no subtype, so treat it as optional.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun event(): Optional<String> = event.getOptional("event")

            /**
             * The event family, for example message, templates or contact. Route on this first,
             * then on event for the specific change.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun field(): Optional<String> = field.getOptional("field")

            /**
             * Body of a contact.opt_in, contact.opt_out or contact.help event. Delivered when a
             * contact signals a consent change or asks for help.
             *
             * These events state the signal outright, so you do not have to recognise keywords in
             * the text of a message.received event. They also cover cases that produce no inbound
             * message at all, such as a network handling an opt-out on your behalf.
             *
             * Fields are ordered identity → resulting state → provenance → join key. Nothing here
             * restates the envelope: which of the three signals occurred is the envelope's event,
             * and when it was emitted is its timestamp. Retries carry the same X-Webhook-Event-ID
             * header, which is what to deduplicate on.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun payload(): Optional<Payload> = payload.getOptional("payload")

            /**
             * The event-specific body.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun requestId(): Optional<String> = requestId.getOptional("request_id")

            /**
             * When Sent emitted the event, in UTC (yyyy-MM-ddTHH:mm:ssZ). This is the emission
             * time, not the time the underlying change happened. Use the timestamp inside the
             * payload for the latter.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timestamp(): Optional<String> = timestamp.getOptional("timestamp")

            /**
             * Returns the raw JSON value of [event].
             *
             * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<String> = event

            /**
             * Returns the raw JSON value of [field].
             *
             * Unlike [field], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("field") @ExcludeMissing fun _field(): JsonField<String> = field

            /**
             * Returns the raw JSON value of [payload].
             *
             * Unlike [payload], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("payload") @ExcludeMissing fun _payload(): JsonField<Payload> = payload

            /**
             * Returns the raw JSON value of [requestId].
             *
             * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("request_id")
            @ExcludeMissing
            fun _requestId(): JsonField<String> = requestId

            /**
             * Returns the raw JSON value of [timestamp].
             *
             * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("timestamp")
            @ExcludeMissing
            fun _timestamp(): JsonField<String> = timestamp

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
                 * Returns a mutable builder for constructing an instance of
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /**
             * A builder for
             * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload].
             */
            class Builder internal constructor() {

                private var event: JsonField<String> = JsonMissing.of()
                private var field: JsonField<String> = JsonMissing.of()
                private var payload: JsonField<Payload> = JsonMissing.of()
                private var requestId: JsonField<String> = JsonMissing.of()
                private var timestamp: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload:
                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                ) = apply {
                    event =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .event
                    field =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .field
                    payload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .payload
                    requestId =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .requestId
                    timestamp =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .timestamp
                    additionalProperties =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload
                            .additionalProperties
                            .toMutableMap()
                }

                /**
                 * The specific event within the family, for example message.delivered,
                 * message.received or contact.opt_out. Absent on events that have no subtype, so
                 * treat it as optional.
                 */
                fun event(event: String?) = event(JsonField.ofNullable(event))

                /** Alias for calling [Builder.event] with `event.orElse(null)`. */
                fun event(event: Optional<String>) = event(event.getOrNull())

                /**
                 * Sets [Builder.event] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.event] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun event(event: JsonField<String>) = apply { this.event = event }

                /**
                 * The event family, for example message, templates or contact. Route on this first,
                 * then on event for the specific change.
                 */
                fun field(field: String) = field(JsonField.of(field))

                /**
                 * Sets [Builder.field] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.field] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun field(field: JsonField<String>) = apply { this.field = field }

                /**
                 * Body of a contact.opt_in, contact.opt_out or contact.help event. Delivered when a
                 * contact signals a consent change or asks for help.
                 *
                 * These events state the signal outright, so you do not have to recognise keywords
                 * in the text of a message.received event. They also cover cases that produce no
                 * inbound message at all, such as a network handling an opt-out on your behalf.
                 *
                 * Fields are ordered identity → resulting state → provenance → join key. Nothing
                 * here restates the envelope: which of the three signals occurred is the envelope's
                 * event, and when it was emitted is its timestamp. Retries carry the same
                 * X-Webhook-Event-ID header, which is what to deduplicate on.
                 */
                fun payload(payload: Payload?) = payload(JsonField.ofNullable(payload))

                /** Alias for calling [Builder.payload] with `payload.orElse(null)`. */
                fun payload(payload: Optional<Payload>) = payload(payload.getOrNull())

                /**
                 * Sets [Builder.payload] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.payload] with a well-typed [Payload] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun payload(payload: JsonField<Payload>) = apply { this.payload = payload }

                /** The event-specific body. */
                fun requestId(requestId: String?) = requestId(JsonField.ofNullable(requestId))

                /** Alias for calling [Builder.requestId] with `requestId.orElse(null)`. */
                fun requestId(requestId: Optional<String>) = requestId(requestId.getOrNull())

                /**
                 * Sets [Builder.requestId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requestId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

                /**
                 * When Sent emitted the event, in UTC (yyyy-MM-ddTHH:mm:ssZ). This is the emission
                 * time, not the time the underlying change happened. Use the timestamp inside the
                 * payload for the latter.
                 */
                fun timestamp(timestamp: String) = timestamp(JsonField.of(timestamp))

                /**
                 * Sets [Builder.timestamp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timestamp] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timestamp(timestamp: JsonField<String>) = apply { this.timestamp = timestamp }

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
                 * Returns an immutable instance of
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build():
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload =
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload(
                        event,
                        field,
                        payload,
                        requestId,
                        timestamp,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate():
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload =
                apply {
                    if (validated) {
                        return@apply
                    }

                    event()
                    field()
                    payload().ifPresent { it.validate() }
                    requestId()
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
                (if (event.asKnown().isPresent) 1 else 0) +
                    (if (field.asKnown().isPresent) 1 else 0) +
                    (payload.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (requestId.asKnown().isPresent) 1 else 0) +
                    (if (timestamp.asKnown().isPresent) 1 else 0)

            /**
             * Body of a contact.opt_in, contact.opt_out or contact.help event. Delivered when a
             * contact signals a consent change or asks for help.
             *
             * These events state the signal outright, so you do not have to recognise keywords in
             * the text of a message.received event. They also cover cases that produce no inbound
             * message at all, such as a network handling an opt-out on your behalf.
             *
             * Fields are ordered identity → resulting state → provenance → join key. Nothing here
             * restates the envelope: which of the three signals occurred is the envelope's event,
             * and when it was emitted is its timestamp. Retries carry the same X-Webhook-Event-ID
             * header, which is what to deduplicate on.
             */
            class Payload
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val optOut: JsonField<Boolean>,
                private val source: JsonField<String>,
                private val accountId: JsonField<String>,
                private val channel: JsonField<String>,
                private val contactId: JsonField<String>,
                private val messageId: JsonField<String>,
                private val phoneNumber: JsonField<String>,
                private val text: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("opt_out")
                    @ExcludeMissing
                    optOut: JsonField<Boolean> = JsonMissing.of(),
                    @JsonProperty("source")
                    @ExcludeMissing
                    source: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("account_id")
                    @ExcludeMissing
                    accountId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("channel")
                    @ExcludeMissing
                    channel: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("contact_id")
                    @ExcludeMissing
                    contactId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("message_id")
                    @ExcludeMissing
                    messageId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("phone_number")
                    @ExcludeMissing
                    phoneNumber: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
                ) : this(
                    optOut,
                    source,
                    accountId,
                    channel,
                    contactId,
                    messageId,
                    phoneNumber,
                    text,
                    mutableMapOf(),
                )

                /**
                 * Whether the contact is opted out after this signal — the state to write to your
                 * own record. Same meaning as opt_out on the contact resource. On contact.help this
                 * reports the contact's existing state, which help does not change.
                 *
                 * Two signals from the same contact can arrive out of order, because each one is
                 * queued on its own rather than against the contact. Compare the envelope's
                 * timestamp before you overwrite a newer state with an older one. That timestamp is
                 * second-precision, so treat two signals stamped in the same second as unordered
                 * and read the contact resource to settle them.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun optOut(): Boolean = optOut.getRequired("opt_out")

                /**
                 * How the signal reached us. INBOUND_KEYWORD means the contact sent a message whose
                 * text matched one of the keywords; PROVIDER_SIGNAL means the network reported it.
                 * A provider signal usually carries no message_id or text, so read both for null
                 * rather than inferring them from this field.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun source(): String = source.getRequired("source")

                /**
                 * The account the contact belongs to. Present so one endpoint can serve several
                 * accounts.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun accountId(): Optional<String> = accountId.getOptional("account_id")

                /**
                 * The channel the signal arrived on, for example sms or whatsapp.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun channel(): Optional<String> = channel.getOptional("channel")

                /**
                 * The contact who raised the signal. Always populated, including for contact.help
                 * from a number you have not messaged before — the contact is created if it does
                 * not exist yet, so this identifier is always resolvable against the contacts API.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun contactId(): Optional<String> = contactId.getOptional("contact_id")

                /**
                 * The inbound message that carried the signal, matching message_id on the
                 * corresponding message.received event so the two can be joined.
                 *
                 * Sent as null when the signal did not arrive as a message — for example when a
                 * network processed an opt-out on your behalf — and also when the message belongs
                 * to a different account than this event, which can happen on a shared WhatsApp
                 * number. The field is always present, so read it and check for null rather than
                 * checking whether the key exists.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun messageId(): Optional<String> = messageId.getOptional("message_id")

                /**
                 * The contact's number in E.164 format. Same value as phone_number on the contact
                 * resource.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

                /**
                 * The text the contact sent, for example STOP or UNSUBSCRIBE. Sent as null when the
                 * signal did not arrive as text. The field is always present, so read it and check
                 * for null rather than checking whether the key exists.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun text(): Optional<String> = text.getOptional("text")

                /**
                 * Returns the raw JSON value of [optOut].
                 *
                 * Unlike [optOut], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("opt_out") @ExcludeMissing fun _optOut(): JsonField<Boolean> = optOut

                /**
                 * Returns the raw JSON value of [source].
                 *
                 * Unlike [source], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

                /**
                 * Returns the raw JSON value of [accountId].
                 *
                 * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("account_id")
                @ExcludeMissing
                fun _accountId(): JsonField<String> = accountId

                /**
                 * Returns the raw JSON value of [channel].
                 *
                 * Unlike [channel], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

                /**
                 * Returns the raw JSON value of [contactId].
                 *
                 * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("contact_id")
                @ExcludeMissing
                fun _contactId(): JsonField<String> = contactId

                /**
                 * Returns the raw JSON value of [messageId].
                 *
                 * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("message_id")
                @ExcludeMissing
                fun _messageId(): JsonField<String> = messageId

                /**
                 * Returns the raw JSON value of [phoneNumber].
                 *
                 * Unlike [phoneNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("phone_number")
                @ExcludeMissing
                fun _phoneNumber(): JsonField<String> = phoneNumber

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
                     * Returns a mutable builder for constructing an instance of [Payload].
                     *
                     * The following fields are required:
                     * ```java
                     * .optOut()
                     * .source()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Payload]. */
                class Builder internal constructor() {

                    private var optOut: JsonField<Boolean>? = null
                    private var source: JsonField<String>? = null
                    private var accountId: JsonField<String> = JsonMissing.of()
                    private var channel: JsonField<String> = JsonMissing.of()
                    private var contactId: JsonField<String> = JsonMissing.of()
                    private var messageId: JsonField<String> = JsonMissing.of()
                    private var phoneNumber: JsonField<String> = JsonMissing.of()
                    private var text: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(payload: Payload) = apply {
                        optOut = payload.optOut
                        source = payload.source
                        accountId = payload.accountId
                        channel = payload.channel
                        contactId = payload.contactId
                        messageId = payload.messageId
                        phoneNumber = payload.phoneNumber
                        text = payload.text
                        additionalProperties = payload.additionalProperties.toMutableMap()
                    }

                    /**
                     * Whether the contact is opted out after this signal — the state to write to
                     * your own record. Same meaning as opt_out on the contact resource. On
                     * contact.help this reports the contact's existing state, which help does not
                     * change.
                     *
                     * Two signals from the same contact can arrive out of order, because each one
                     * is queued on its own rather than against the contact. Compare the envelope's
                     * timestamp before you overwrite a newer state with an older one. That
                     * timestamp is second-precision, so treat two signals stamped in the same
                     * second as unordered and read the contact resource to settle them.
                     */
                    fun optOut(optOut: Boolean) = optOut(JsonField.of(optOut))

                    /**
                     * Sets [Builder.optOut] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.optOut] with a well-typed [Boolean] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun optOut(optOut: JsonField<Boolean>) = apply { this.optOut = optOut }

                    /**
                     * How the signal reached us. INBOUND_KEYWORD means the contact sent a message
                     * whose text matched one of the keywords; PROVIDER_SIGNAL means the network
                     * reported it. A provider signal usually carries no message_id or text, so read
                     * both for null rather than inferring them from this field.
                     */
                    fun source(source: String) = source(JsonField.of(source))

                    /**
                     * Sets [Builder.source] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.source] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun source(source: JsonField<String>) = apply { this.source = source }

                    /**
                     * The account the contact belongs to. Present so one endpoint can serve several
                     * accounts.
                     */
                    fun accountId(accountId: String) = accountId(JsonField.of(accountId))

                    /**
                     * Sets [Builder.accountId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.accountId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun accountId(accountId: JsonField<String>) = apply {
                        this.accountId = accountId
                    }

                    /** The channel the signal arrived on, for example sms or whatsapp. */
                    fun channel(channel: String) = channel(JsonField.of(channel))

                    /**
                     * Sets [Builder.channel] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.channel] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun channel(channel: JsonField<String>) = apply { this.channel = channel }

                    /**
                     * The contact who raised the signal. Always populated, including for
                     * contact.help from a number you have not messaged before — the contact is
                     * created if it does not exist yet, so this identifier is always resolvable
                     * against the contacts API.
                     */
                    fun contactId(contactId: String) = contactId(JsonField.of(contactId))

                    /**
                     * Sets [Builder.contactId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.contactId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun contactId(contactId: JsonField<String>) = apply {
                        this.contactId = contactId
                    }

                    /**
                     * The inbound message that carried the signal, matching message_id on the
                     * corresponding message.received event so the two can be joined.
                     *
                     * Sent as null when the signal did not arrive as a message — for example when a
                     * network processed an opt-out on your behalf — and also when the message
                     * belongs to a different account than this event, which can happen on a shared
                     * WhatsApp number. The field is always present, so read it and check for null
                     * rather than checking whether the key exists.
                     */
                    fun messageId(messageId: String?) = messageId(JsonField.ofNullable(messageId))

                    /** Alias for calling [Builder.messageId] with `messageId.orElse(null)`. */
                    fun messageId(messageId: Optional<String>) = messageId(messageId.getOrNull())

                    /**
                     * Sets [Builder.messageId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.messageId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun messageId(messageId: JsonField<String>) = apply {
                        this.messageId = messageId
                    }

                    /**
                     * The contact's number in E.164 format. Same value as phone_number on the
                     * contact resource.
                     */
                    fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

                    /**
                     * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.phoneNumber] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                        this.phoneNumber = phoneNumber
                    }

                    /**
                     * The text the contact sent, for example STOP or UNSUBSCRIBE. Sent as null when
                     * the signal did not arrive as text. The field is always present, so read it
                     * and check for null rather than checking whether the key exists.
                     */
                    fun text(text: String?) = text(JsonField.ofNullable(text))

                    /** Alias for calling [Builder.text] with `text.orElse(null)`. */
                    fun text(text: Optional<String>) = text(text.getOrNull())

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

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
                     * Returns an immutable instance of [Payload].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .optOut()
                     * .source()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Payload =
                        Payload(
                            checkRequired("optOut", optOut),
                            checkRequired("source", source),
                            accountId,
                            channel,
                            contactId,
                            messageId,
                            phoneNumber,
                            text,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Payload = apply {
                    if (validated) {
                        return@apply
                    }

                    optOut()
                    source()
                    accountId()
                    channel()
                    contactId()
                    messageId()
                    phoneNumber()
                    text()
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
                    (if (optOut.asKnown().isPresent) 1 else 0) +
                        (if (source.asKnown().isPresent) 1 else 0) +
                        (if (accountId.asKnown().isPresent) 1 else 0) +
                        (if (channel.asKnown().isPresent) 1 else 0) +
                        (if (contactId.asKnown().isPresent) 1 else 0) +
                        (if (messageId.asKnown().isPresent) 1 else 0) +
                        (if (phoneNumber.asKnown().isPresent) 1 else 0) +
                        (if (text.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Payload &&
                        optOut == other.optOut &&
                        source == other.source &&
                        accountId == other.accountId &&
                        channel == other.channel &&
                        contactId == other.contactId &&
                        messageId == other.messageId &&
                        phoneNumber == other.phoneNumber &&
                        text == other.text &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        optOut,
                        source,
                        accountId,
                        channel,
                        contactId,
                        messageId,
                        phoneNumber,
                        text,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Payload{optOut=$optOut, source=$source, accountId=$accountId, channel=$channel, contactId=$contactId, messageId=$messageId, phoneNumber=$phoneNumber, text=$text, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload &&
                    event == other.event &&
                    field == other.field &&
                    payload == other.payload &&
                    requestId == other.requestId &&
                    timestamp == other.timestamp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(event, field, payload, requestId, timestamp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SentDmServicesCommonServicesWebhooksContractsWebhookEventOfContactWebhookPayload{event=$event, field=$field, payload=$payload, requestId=$requestId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
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
