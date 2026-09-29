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
     * The exact event body that was delivered, or attempted, for this record. One of the six
     * webhook envelopes:
     *
     * message — an outbound message changed status. message with event: message.received — someone
     * replied to you. templates — a template was approved, rejected, paused or similar. channel —
     * one of your markets moved in provisioning or compliance. contact — a consent signal: opt-in,
     * opt-out or help. link — a tracked short link was clicked or a hosted file downloaded, or one
     * expired or was revoked.
     *
     * Read field and event to tell which, the same way your endpoint does. The two message
     * envelopes are the reason that is two fields and not one: they share a field and differ by
     * event.
     *
     * Treat the list as open. It has grown twice — channel and then link — and a handler that
     * rejects an envelope it does not recognise will break on the next addition rather than ignore
     * it.
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
         * The exact event body that was delivered, or attempted, for this record. One of the six
         * webhook envelopes:
         *
         * message — an outbound message changed status. message with event: message.received —
         * someone replied to you. templates — a template was approved, rejected, paused or similar.
         * channel — one of your markets moved in provisioning or compliance. contact — a consent
         * signal: opt-in, opt-out or help. link — a tracked short link was clicked or a hosted file
         * downloaded, or one expired or was revoked.
         *
         * Read field and event to tell which, the same way your endpoint does. The two message
         * envelopes are the reason that is two fields and not one: they share a field and differ by
         * event.
         *
         * Treat the list as open. It has grown twice — channel and then link — and a handler that
         * rejects an envelope it does not recognise will break on the next addition rather than
         * ignore it.
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

        /** Alias for calling [eventData] with `EventData.ofChannelEvent(channelEvent)`. */
        fun eventData(channelEvent: ChannelEvent) =
            eventData(EventData.ofChannelEvent(channelEvent))

        /** Alias for calling [eventData] with `EventData.ofContactEvent(contactEvent)`. */
        fun eventData(contactEvent: ContactEvent) =
            eventData(EventData.ofContactEvent(contactEvent))

        /**
         * Alias for calling [eventData] with
         * `EventData.ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload)`.
         */
        fun eventData(
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
                EventData.SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
        ) =
            eventData(
                EventData
                    .ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                    )
            )

        /**
         * Alias for calling [eventData] with
         * `EventData.ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload)`.
         */
        fun eventData(
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
                EventData.SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
        ) =
            eventData(
                EventData
                    .ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
     * The exact event body that was delivered, or attempted, for this record. One of the six
     * webhook envelopes:
     *
     * message — an outbound message changed status. message with event: message.received — someone
     * replied to you. templates — a template was approved, rejected, paused or similar. channel —
     * one of your markets moved in provisioning or compliance. contact — a consent signal: opt-in,
     * opt-out or help. link — a tracked short link was clicked or a hosted file downloaded, or one
     * expired or was revoked.
     *
     * Read field and event to tell which, the same way your endpoint does. The two message
     * envelopes are the reason that is two fields and not one: they share a field and differ by
     * event.
     *
     * Treat the list as open. It has grown twice — channel and then link — and a handler that
     * rejects an envelope it does not recognise will break on the next addition rather than ignore
     * it.
     */
    @JsonDeserialize(using = EventData.Deserializer::class)
    @JsonSerialize(using = EventData.Serializer::class)
    class EventData
    private constructor(
        private val messageEvent: MessageEvent? = null,
        private val inboundMessageEvent: InboundMessageEvent? = null,
        private val templateEvent: TemplateEvent? = null,
        private val channelEvent: ChannelEvent? = null,
        private val contactEvent: ContactEvent? = null,
        private val sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload? =
            null,
        private val sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload? =
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
        fun channelEvent(): Optional<ChannelEvent> = Optional.ofNullable(channelEvent)

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun contactEvent(): Optional<ContactEvent> = Optional.ofNullable(contactEvent)

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload():
            Optional<
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
            > =
            Optional.ofNullable(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
            )

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload():
            Optional<
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
            > =
            Optional.ofNullable(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
            )

        fun isMessageEvent(): Boolean = messageEvent != null

        fun isInboundMessageEvent(): Boolean = inboundMessageEvent != null

        fun isTemplateEvent(): Boolean = templateEvent != null

        fun isChannelEvent(): Boolean = channelEvent != null

        fun isContactEvent(): Boolean = contactEvent != null

        fun isSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload():
            Boolean =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload != null

        fun isSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload():
            Boolean =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload != null

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
        fun asChannelEvent(): ChannelEvent = channelEvent.getOrThrow("channelEvent")

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asContactEvent(): ContactEvent = contactEvent.getOrThrow("contactEvent")

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload():
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                .getOrThrow(
                    "sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload"
                )

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload():
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                .getOrThrow(
                    "sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload"
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
                channelEvent != null -> visitor.visitChannelEvent(channelEvent)
                contactEvent != null -> visitor.visitContactEvent(contactEvent)
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload !=
                    null ->
                    visitor
                        .visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
                            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                        )
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload !=
                    null ->
                    visitor
                        .visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
                            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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

                    override fun visitChannelEvent(channelEvent: ChannelEvent) {
                        channelEvent.validate()
                    }

                    override fun visitContactEvent(contactEvent: ContactEvent) {
                        contactEvent.validate()
                    }

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                    ) {
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .validate()
                    }

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                    ) {
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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

                    override fun visitChannelEvent(channelEvent: ChannelEvent) =
                        channelEvent.validity()

                    override fun visitContactEvent(contactEvent: ContactEvent) =
                        contactEvent.validity()

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                    ) =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .validity()

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                    ) =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
                channelEvent == other.channelEvent &&
                contactEvent == other.contactEvent &&
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload ==
                    other
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload &&
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload ==
                    other
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
        }

        override fun hashCode(): Int =
            Objects.hash(
                messageEvent,
                inboundMessageEvent,
                templateEvent,
                channelEvent,
                contactEvent,
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload,
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload,
            )

        override fun toString(): String =
            when {
                messageEvent != null -> "EventData{messageEvent=$messageEvent}"
                inboundMessageEvent != null -> "EventData{inboundMessageEvent=$inboundMessageEvent}"
                templateEvent != null -> "EventData{templateEvent=$templateEvent}"
                channelEvent != null -> "EventData{channelEvent=$channelEvent}"
                contactEvent != null -> "EventData{contactEvent=$contactEvent}"
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload !=
                    null ->
                    "EventData{sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload=$sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload}"
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload !=
                    null ->
                    "EventData{sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload=$sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload}"
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
            fun ofChannelEvent(channelEvent: ChannelEvent) = EventData(channelEvent = channelEvent)

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofContactEvent(contactEvent: ContactEvent) = EventData(contactEvent = contactEvent)

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
            ) =
                EventData(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                )

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
            ) =
                EventData(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
            fun visitChannelEvent(channelEvent: ChannelEvent): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitContactEvent(contactEvent: ContactEvent): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
            ): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
                            tryDeserialize(node, jacksonTypeRef<ChannelEvent>())?.let {
                                EventData(channelEvent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<ContactEvent>())?.let {
                                EventData(contactEvent = it, _json = json)
                            },
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<
                                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                                    >(),
                                )
                                ?.let {
                                    EventData(
                                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload =
                                            it,
                                        _json = json,
                                    )
                                },
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<
                                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                                    >(),
                                )
                                ?.let {
                                    EventData(
                                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload =
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
                    value.channelEvent != null -> generator.writeObject(value.channelEvent)
                    value.contactEvent != null -> generator.writeObject(value.contactEvent)
                    value
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload !=
                        null ->
                        generator.writeObject(
                            value
                                .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                        )
                    value
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload !=
                        null ->
                        generator.writeObject(
                            value
                                .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
        class SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
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
             * Body of a link event: something happened to a tracked link Sent published on the
             * customer's behalf. A link points either at a URL the customer supplied or at a file
             * Sent hosts for them; LinkKind says which. Delivered when an eligible request is
             * served, or when a published link reaches the end of its life.
             *
             * A click is a request, not a read receipt. link.clicked means the redirect was served;
             * link.downloaded means bytes went out. Neither proves a person saw anything —
             * messaging providers and link scanners fetch URLs on their own, which is what
             * TrafficClass exists to tell apart. Filter on it before reporting a click-through
             * rate; treat likely_human as a hint, never as delivery confirmation.
             *
             * RecordId identifies the link; the X-Webhook-Event-ID header identifies the delivery.
             * One link is hit many times, so those are the two keys a subscriber needs: group by
             * the first, deduplicate on the second — exactly as on every other family. The payload
             * carries no event identifier of its own, for the same reason none of the others do.
             *
             * Nothing here identifies the visitor. No IP address and no visitor token crosses this
             * boundary. Country, Device and Browser are coarse buckets derived at the edge and are
             * absent whenever the request did not supply enough to derive them.
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
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /**
             * A builder for
             * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload].
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
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload:
                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                ) = apply {
                    event =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .event
                    field =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .field
                    payload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .payload
                    requestId =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .requestId
                    timestamp =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
                            .timestamp
                    additionalProperties =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload
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
                 * Body of a link event: something happened to a tracked link Sent published on the
                 * customer's behalf. A link points either at a URL the customer supplied or at a
                 * file Sent hosts for them; LinkKind says which. Delivered when an eligible request
                 * is served, or when a published link reaches the end of its life.
                 *
                 * A click is a request, not a read receipt. link.clicked means the redirect was
                 * served; link.downloaded means bytes went out. Neither proves a person saw
                 * anything — messaging providers and link scanners fetch URLs on their own, which
                 * is what TrafficClass exists to tell apart. Filter on it before reporting a
                 * click-through rate; treat likely_human as a hint, never as delivery confirmation.
                 *
                 * RecordId identifies the link; the X-Webhook-Event-ID header identifies the
                 * delivery. One link is hit many times, so those are the two keys a subscriber
                 * needs: group by the first, deduplicate on the second — exactly as on every other
                 * family. The payload carries no event identifier of its own, for the same reason
                 * none of the others do.
                 *
                 * Nothing here identifies the visitor. No IP address and no visitor token crosses
                 * this boundary. Country, Device and Browser are coarse buckets derived at the edge
                 * and are absent whenever the request did not supply enough to derive them.
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
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build():
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload =
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload(
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
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload =
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
             * Body of a link event: something happened to a tracked link Sent published on the
             * customer's behalf. A link points either at a URL the customer supplied or at a file
             * Sent hosts for them; LinkKind says which. Delivered when an eligible request is
             * served, or when a published link reaches the end of its life.
             *
             * A click is a request, not a read receipt. link.clicked means the redirect was served;
             * link.downloaded means bytes went out. Neither proves a person saw anything —
             * messaging providers and link scanners fetch URLs on their own, which is what
             * TrafficClass exists to tell apart. Filter on it before reporting a click-through
             * rate; treat likely_human as a hint, never as delivery confirmation.
             *
             * RecordId identifies the link; the X-Webhook-Event-ID header identifies the delivery.
             * One link is hit many times, so those are the two keys a subscriber needs: group by
             * the first, deduplicate on the second — exactly as on every other family. The payload
             * carries no event identifier of its own, for the same reason none of the others do.
             *
             * Nothing here identifies the visitor. No IP address and no visitor token crosses this
             * boundary. Country, Device and Browser are coarse buckets derived at the edge and are
             * absent whenever the request did not supply enough to derive them.
             */
            class Payload
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val recordId: JsonField<String>,
                private val accessCountry: JsonField<String>,
                private val accessOutcome: JsonField<String>,
                private val browser: JsonField<String>,
                private val bytesServed: JsonField<Long>,
                private val channel: JsonField<String>,
                private val customerId: JsonField<String>,
                private val device: JsonField<String>,
                private val linkKind: JsonField<String>,
                private val messageId: JsonField<String>,
                private val occurredAt: JsonField<String>,
                private val referenceKey: JsonField<String>,
                private val referrerHost: JsonField<String>,
                private val requestMethod: JsonField<String>,
                private val senderProfileId: JsonField<String>,
                private val statusCode: JsonField<Int>,
                private val trafficClass: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("record_id")
                    @ExcludeMissing
                    recordId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("access_country")
                    @ExcludeMissing
                    accessCountry: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("access_outcome")
                    @ExcludeMissing
                    accessOutcome: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("browser")
                    @ExcludeMissing
                    browser: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("bytes_served")
                    @ExcludeMissing
                    bytesServed: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("channel")
                    @ExcludeMissing
                    channel: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("customer_id")
                    @ExcludeMissing
                    customerId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("device")
                    @ExcludeMissing
                    device: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("link_kind")
                    @ExcludeMissing
                    linkKind: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("message_id")
                    @ExcludeMissing
                    messageId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("occurred_at")
                    @ExcludeMissing
                    occurredAt: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("reference_key")
                    @ExcludeMissing
                    referenceKey: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("referrer_host")
                    @ExcludeMissing
                    referrerHost: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("request_method")
                    @ExcludeMissing
                    requestMethod: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("sender_profile_id")
                    @ExcludeMissing
                    senderProfileId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("status_code")
                    @ExcludeMissing
                    statusCode: JsonField<Int> = JsonMissing.of(),
                    @JsonProperty("traffic_class")
                    @ExcludeMissing
                    trafficClass: JsonField<String> = JsonMissing.of(),
                ) : this(
                    recordId,
                    accessCountry,
                    accessOutcome,
                    browser,
                    bytesServed,
                    channel,
                    customerId,
                    device,
                    linkKind,
                    messageId,
                    occurredAt,
                    referenceKey,
                    referrerHost,
                    requestMethod,
                    senderProfileId,
                    statusCode,
                    trafficClass,
                    mutableMapOf(),
                )

                /**
                 * The link's public identifier — the eight-character code in the short URL, for
                 * example A78B2BU0. Unique across both kinds, and never reused, so it is the stable
                 * key to group one link's events by.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun recordId(): String = recordId.getRequired("record_id")

                /**
                 * Where the request appeared to come from, as an ISO 3166-1 alpha-2 code. Named
                 * separately from the country on a channel event, which is a destination market the
                 * customer registered for — this one is a property of a single visitor and is
                 * absent when the edge could not resolve it.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun accessCountry(): Optional<String> = accessCountry.getOptional("access_country")

                /**
                 * How the request was served, when the edge recorded it. Free text describing the
                 * outcome — show it to a human rather than branching on it.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun accessOutcome(): Optional<String> = accessOutcome.getOptional("access_outcome")

                /**
                 * The requesting browser family, for example chrome or safari, or unknown. Derived
                 * from the user agent.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun browser(): Optional<String> = browser.getOptional("browser")

                /**
                 * How many bytes were served, for a file access. A ranged request reports the bytes
                 * in that range, not the size of the file, so several accesses of one file can each
                 * report a part.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun bytesServed(): Optional<Long> = bytesServed.getOptional("bytes_served")

                /**
                 * The channel the message carrying this link went out on: sms, whatsapp, or rcs.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun channel(): Optional<String> = channel.getOptional("channel")

                /**
                 * The organization the link belongs to. Always the parent account, never a sender
                 * profile — read SenderProfileId for that.
                 *
                 * This family publishes the owner as an explicit pair rather than the single
                 * account_id the other families use. The pair says which organization and which
                 * profile without the subscriber deriving either, which is the trade: one more key
                 * against not having to know that account_id silently becomes the profile when one
                 * exists.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun customerId(): Optional<String> = customerId.getOptional("customer_id")

                /**
                 * The requesting device class: mobile, tablet, desktop or unknown. Derived from the
                 * user agent.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun device(): Optional<String> = device.getOptional("device")

                /**
                 * What the link points at: url for a destination the customer supplied, file for
                 * media Sent hosts. Always present, and implied by the event — link.clicked is
                 * always url and link.downloaded always file — but published as its own field so a
                 * subscriber can branch on the kind without parsing the event name, the same
                 * separation the channel family keeps between its event and its status.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun linkKind(): Optional<String> = linkKind.getOptional("link_kind")

                /**
                 * The message the link was published in.
                 *
                 * The event can arrive before the message is readable through GET /v3/messages: a
                 * provider may fetch a link within milliseconds of the send, and nothing here waits
                 * for the message row. Retry the read rather than treating an unknown id as an
                 * error.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun messageId(): Optional<String> = messageId.getOptional("message_id")

                /**
                 * When the access or lifecycle change actually happened, in UTC
                 * (yyyy-MM-ddTHH:mm:ssZ). The envelope's timestamp is when Sent emitted the event;
                 * this is when the thing occurred, and the two differ by the ingest delay.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun occurredAt(): Optional<String> = occurredAt.getOptional("occurred_at")

                /**
                 * The caller-supplied label tying this link back to a position in the message, for
                 * example body:0 for the first link in the body. Present when the link was created
                 * with one.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun referenceKey(): Optional<String> = referenceKey.getOptional("reference_key")

                /**
                 * The host of the page that linked here, when the request supplied one. The host
                 * only — never a full referring URL.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun referrerHost(): Optional<String> = referrerHost.getOptional("referrer_host")

                /**
                 * The HTTP method of the request that was served, for an access event. Omitted on
                 * link.expired and link.revoked, which describe no request.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun requestMethod(): Optional<String> = requestMethod.getOptional("request_method")

                /**
                 * The sender profile that owns the link, or null when the organization owns it
                 * directly. Always on the wire so a handler reads one shape rather than branching
                 * on whether the key arrived.
                 *
                 * sender_profile_id, not profile_id: the API already publishes messaging_profile_id
                 * and sending_phone_number_profile_id for provider-side profiles, which are a
                 * different thing entirely. The unqualified name would read as one of those.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun senderProfileId(): Optional<String> =
                    senderProfileId.getOptional("sender_profile_id")

                /**
                 * The HTTP status Sent answered the request with: 302 for a link, 200 or 206 for a
                 * file. Omitted on lifecycle events.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun statusCode(): Optional<Int> = statusCode.getOptional("status_code")

                /**
                 * A coarse guess at what made the request: likely_human, provider (a messaging
                 * platform prefetching the link), bot, or unknown. Derived from the user agent, so
                 * it is a hint for filtering noise rather than a fact to bill or report on.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun trafficClass(): Optional<String> = trafficClass.getOptional("traffic_class")

                /**
                 * Returns the raw JSON value of [recordId].
                 *
                 * Unlike [recordId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("record_id")
                @ExcludeMissing
                fun _recordId(): JsonField<String> = recordId

                /**
                 * Returns the raw JSON value of [accessCountry].
                 *
                 * Unlike [accessCountry], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("access_country")
                @ExcludeMissing
                fun _accessCountry(): JsonField<String> = accessCountry

                /**
                 * Returns the raw JSON value of [accessOutcome].
                 *
                 * Unlike [accessOutcome], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("access_outcome")
                @ExcludeMissing
                fun _accessOutcome(): JsonField<String> = accessOutcome

                /**
                 * Returns the raw JSON value of [browser].
                 *
                 * Unlike [browser], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("browser") @ExcludeMissing fun _browser(): JsonField<String> = browser

                /**
                 * Returns the raw JSON value of [bytesServed].
                 *
                 * Unlike [bytesServed], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("bytes_served")
                @ExcludeMissing
                fun _bytesServed(): JsonField<Long> = bytesServed

                /**
                 * Returns the raw JSON value of [channel].
                 *
                 * Unlike [channel], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

                /**
                 * Returns the raw JSON value of [customerId].
                 *
                 * Unlike [customerId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("customer_id")
                @ExcludeMissing
                fun _customerId(): JsonField<String> = customerId

                /**
                 * Returns the raw JSON value of [device].
                 *
                 * Unlike [device], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("device") @ExcludeMissing fun _device(): JsonField<String> = device

                /**
                 * Returns the raw JSON value of [linkKind].
                 *
                 * Unlike [linkKind], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("link_kind")
                @ExcludeMissing
                fun _linkKind(): JsonField<String> = linkKind

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
                 * Returns the raw JSON value of [occurredAt].
                 *
                 * Unlike [occurredAt], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("occurred_at")
                @ExcludeMissing
                fun _occurredAt(): JsonField<String> = occurredAt

                /**
                 * Returns the raw JSON value of [referenceKey].
                 *
                 * Unlike [referenceKey], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("reference_key")
                @ExcludeMissing
                fun _referenceKey(): JsonField<String> = referenceKey

                /**
                 * Returns the raw JSON value of [referrerHost].
                 *
                 * Unlike [referrerHost], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("referrer_host")
                @ExcludeMissing
                fun _referrerHost(): JsonField<String> = referrerHost

                /**
                 * Returns the raw JSON value of [requestMethod].
                 *
                 * Unlike [requestMethod], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("request_method")
                @ExcludeMissing
                fun _requestMethod(): JsonField<String> = requestMethod

                /**
                 * Returns the raw JSON value of [senderProfileId].
                 *
                 * Unlike [senderProfileId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("sender_profile_id")
                @ExcludeMissing
                fun _senderProfileId(): JsonField<String> = senderProfileId

                /**
                 * Returns the raw JSON value of [statusCode].
                 *
                 * Unlike [statusCode], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("status_code")
                @ExcludeMissing
                fun _statusCode(): JsonField<Int> = statusCode

                /**
                 * Returns the raw JSON value of [trafficClass].
                 *
                 * Unlike [trafficClass], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("traffic_class")
                @ExcludeMissing
                fun _trafficClass(): JsonField<String> = trafficClass

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
                     * .recordId()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Payload]. */
                class Builder internal constructor() {

                    private var recordId: JsonField<String>? = null
                    private var accessCountry: JsonField<String> = JsonMissing.of()
                    private var accessOutcome: JsonField<String> = JsonMissing.of()
                    private var browser: JsonField<String> = JsonMissing.of()
                    private var bytesServed: JsonField<Long> = JsonMissing.of()
                    private var channel: JsonField<String> = JsonMissing.of()
                    private var customerId: JsonField<String> = JsonMissing.of()
                    private var device: JsonField<String> = JsonMissing.of()
                    private var linkKind: JsonField<String> = JsonMissing.of()
                    private var messageId: JsonField<String> = JsonMissing.of()
                    private var occurredAt: JsonField<String> = JsonMissing.of()
                    private var referenceKey: JsonField<String> = JsonMissing.of()
                    private var referrerHost: JsonField<String> = JsonMissing.of()
                    private var requestMethod: JsonField<String> = JsonMissing.of()
                    private var senderProfileId: JsonField<String> = JsonMissing.of()
                    private var statusCode: JsonField<Int> = JsonMissing.of()
                    private var trafficClass: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(payload: Payload) = apply {
                        recordId = payload.recordId
                        accessCountry = payload.accessCountry
                        accessOutcome = payload.accessOutcome
                        browser = payload.browser
                        bytesServed = payload.bytesServed
                        channel = payload.channel
                        customerId = payload.customerId
                        device = payload.device
                        linkKind = payload.linkKind
                        messageId = payload.messageId
                        occurredAt = payload.occurredAt
                        referenceKey = payload.referenceKey
                        referrerHost = payload.referrerHost
                        requestMethod = payload.requestMethod
                        senderProfileId = payload.senderProfileId
                        statusCode = payload.statusCode
                        trafficClass = payload.trafficClass
                        additionalProperties = payload.additionalProperties.toMutableMap()
                    }

                    /**
                     * The link's public identifier — the eight-character code in the short URL, for
                     * example A78B2BU0. Unique across both kinds, and never reused, so it is the
                     * stable key to group one link's events by.
                     */
                    fun recordId(recordId: String) = recordId(JsonField.of(recordId))

                    /**
                     * Sets [Builder.recordId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.recordId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun recordId(recordId: JsonField<String>) = apply { this.recordId = recordId }

                    /**
                     * Where the request appeared to come from, as an ISO 3166-1 alpha-2 code. Named
                     * separately from the country on a channel event, which is a destination market
                     * the customer registered for — this one is a property of a single visitor and
                     * is absent when the edge could not resolve it.
                     */
                    fun accessCountry(accessCountry: String?) =
                        accessCountry(JsonField.ofNullable(accessCountry))

                    /**
                     * Alias for calling [Builder.accessCountry] with `accessCountry.orElse(null)`.
                     */
                    fun accessCountry(accessCountry: Optional<String>) =
                        accessCountry(accessCountry.getOrNull())

                    /**
                     * Sets [Builder.accessCountry] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.accessCountry] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun accessCountry(accessCountry: JsonField<String>) = apply {
                        this.accessCountry = accessCountry
                    }

                    /**
                     * How the request was served, when the edge recorded it. Free text describing
                     * the outcome — show it to a human rather than branching on it.
                     */
                    fun accessOutcome(accessOutcome: String?) =
                        accessOutcome(JsonField.ofNullable(accessOutcome))

                    /**
                     * Alias for calling [Builder.accessOutcome] with `accessOutcome.orElse(null)`.
                     */
                    fun accessOutcome(accessOutcome: Optional<String>) =
                        accessOutcome(accessOutcome.getOrNull())

                    /**
                     * Sets [Builder.accessOutcome] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.accessOutcome] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun accessOutcome(accessOutcome: JsonField<String>) = apply {
                        this.accessOutcome = accessOutcome
                    }

                    /**
                     * The requesting browser family, for example chrome or safari, or unknown.
                     * Derived from the user agent.
                     */
                    fun browser(browser: String?) = browser(JsonField.ofNullable(browser))

                    /** Alias for calling [Builder.browser] with `browser.orElse(null)`. */
                    fun browser(browser: Optional<String>) = browser(browser.getOrNull())

                    /**
                     * Sets [Builder.browser] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.browser] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun browser(browser: JsonField<String>) = apply { this.browser = browser }

                    /**
                     * How many bytes were served, for a file access. A ranged request reports the
                     * bytes in that range, not the size of the file, so several accesses of one
                     * file can each report a part.
                     */
                    fun bytesServed(bytesServed: Long?) =
                        bytesServed(JsonField.ofNullable(bytesServed))

                    /**
                     * Alias for [Builder.bytesServed].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun bytesServed(bytesServed: Long) = bytesServed(bytesServed as Long?)

                    /** Alias for calling [Builder.bytesServed] with `bytesServed.orElse(null)`. */
                    fun bytesServed(bytesServed: Optional<Long>) =
                        bytesServed(bytesServed.getOrNull())

                    /**
                     * Sets [Builder.bytesServed] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.bytesServed] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun bytesServed(bytesServed: JsonField<Long>) = apply {
                        this.bytesServed = bytesServed
                    }

                    /**
                     * The channel the message carrying this link went out on: sms, whatsapp, or
                     * rcs.
                     */
                    fun channel(channel: String?) = channel(JsonField.ofNullable(channel))

                    /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
                    fun channel(channel: Optional<String>) = channel(channel.getOrNull())

                    /**
                     * Sets [Builder.channel] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.channel] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun channel(channel: JsonField<String>) = apply { this.channel = channel }

                    /**
                     * The organization the link belongs to. Always the parent account, never a
                     * sender profile — read SenderProfileId for that.
                     *
                     * This family publishes the owner as an explicit pair rather than the single
                     * account_id the other families use. The pair says which organization and which
                     * profile without the subscriber deriving either, which is the trade: one more
                     * key against not having to know that account_id silently becomes the profile
                     * when one exists.
                     */
                    fun customerId(customerId: String) = customerId(JsonField.of(customerId))

                    /**
                     * Sets [Builder.customerId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.customerId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun customerId(customerId: JsonField<String>) = apply {
                        this.customerId = customerId
                    }

                    /**
                     * The requesting device class: mobile, tablet, desktop or unknown. Derived from
                     * the user agent.
                     */
                    fun device(device: String?) = device(JsonField.ofNullable(device))

                    /** Alias for calling [Builder.device] with `device.orElse(null)`. */
                    fun device(device: Optional<String>) = device(device.getOrNull())

                    /**
                     * Sets [Builder.device] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.device] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun device(device: JsonField<String>) = apply { this.device = device }

                    /**
                     * What the link points at: url for a destination the customer supplied, file
                     * for media Sent hosts. Always present, and implied by the event — link.clicked
                     * is always url and link.downloaded always file — but published as its own
                     * field so a subscriber can branch on the kind without parsing the event name,
                     * the same separation the channel family keeps between its event and its
                     * status.
                     */
                    fun linkKind(linkKind: String) = linkKind(JsonField.of(linkKind))

                    /**
                     * Sets [Builder.linkKind] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.linkKind] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun linkKind(linkKind: JsonField<String>) = apply { this.linkKind = linkKind }

                    /**
                     * The message the link was published in.
                     *
                     * The event can arrive before the message is readable through GET /v3/messages:
                     * a provider may fetch a link within milliseconds of the send, and nothing here
                     * waits for the message row. Retry the read rather than treating an unknown id
                     * as an error.
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
                     * When the access or lifecycle change actually happened, in UTC
                     * (yyyy-MM-ddTHH:mm:ssZ). The envelope's timestamp is when Sent emitted the
                     * event; this is when the thing occurred, and the two differ by the ingest
                     * delay.
                     */
                    fun occurredAt(occurredAt: String) = occurredAt(JsonField.of(occurredAt))

                    /**
                     * Sets [Builder.occurredAt] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.occurredAt] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun occurredAt(occurredAt: JsonField<String>) = apply {
                        this.occurredAt = occurredAt
                    }

                    /**
                     * The caller-supplied label tying this link back to a position in the message,
                     * for example body:0 for the first link in the body. Present when the link was
                     * created with one.
                     */
                    fun referenceKey(referenceKey: String?) =
                        referenceKey(JsonField.ofNullable(referenceKey))

                    /**
                     * Alias for calling [Builder.referenceKey] with `referenceKey.orElse(null)`.
                     */
                    fun referenceKey(referenceKey: Optional<String>) =
                        referenceKey(referenceKey.getOrNull())

                    /**
                     * Sets [Builder.referenceKey] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.referenceKey] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun referenceKey(referenceKey: JsonField<String>) = apply {
                        this.referenceKey = referenceKey
                    }

                    /**
                     * The host of the page that linked here, when the request supplied one. The
                     * host only — never a full referring URL.
                     */
                    fun referrerHost(referrerHost: String?) =
                        referrerHost(JsonField.ofNullable(referrerHost))

                    /**
                     * Alias for calling [Builder.referrerHost] with `referrerHost.orElse(null)`.
                     */
                    fun referrerHost(referrerHost: Optional<String>) =
                        referrerHost(referrerHost.getOrNull())

                    /**
                     * Sets [Builder.referrerHost] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.referrerHost] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun referrerHost(referrerHost: JsonField<String>) = apply {
                        this.referrerHost = referrerHost
                    }

                    /**
                     * The HTTP method of the request that was served, for an access event. Omitted
                     * on link.expired and link.revoked, which describe no request.
                     */
                    fun requestMethod(requestMethod: String?) =
                        requestMethod(JsonField.ofNullable(requestMethod))

                    /**
                     * Alias for calling [Builder.requestMethod] with `requestMethod.orElse(null)`.
                     */
                    fun requestMethod(requestMethod: Optional<String>) =
                        requestMethod(requestMethod.getOrNull())

                    /**
                     * Sets [Builder.requestMethod] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.requestMethod] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun requestMethod(requestMethod: JsonField<String>) = apply {
                        this.requestMethod = requestMethod
                    }

                    /**
                     * The sender profile that owns the link, or null when the organization owns it
                     * directly. Always on the wire so a handler reads one shape rather than
                     * branching on whether the key arrived.
                     *
                     * sender_profile_id, not profile_id: the API already publishes
                     * messaging_profile_id and sending_phone_number_profile_id for provider-side
                     * profiles, which are a different thing entirely. The unqualified name would
                     * read as one of those.
                     */
                    fun senderProfileId(senderProfileId: String?) =
                        senderProfileId(JsonField.ofNullable(senderProfileId))

                    /**
                     * Alias for calling [Builder.senderProfileId] with
                     * `senderProfileId.orElse(null)`.
                     */
                    fun senderProfileId(senderProfileId: Optional<String>) =
                        senderProfileId(senderProfileId.getOrNull())

                    /**
                     * Sets [Builder.senderProfileId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.senderProfileId] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun senderProfileId(senderProfileId: JsonField<String>) = apply {
                        this.senderProfileId = senderProfileId
                    }

                    /**
                     * The HTTP status Sent answered the request with: 302 for a link, 200 or 206
                     * for a file. Omitted on lifecycle events.
                     */
                    fun statusCode(statusCode: Int?) = statusCode(JsonField.ofNullable(statusCode))

                    /**
                     * Alias for [Builder.statusCode].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun statusCode(statusCode: Int) = statusCode(statusCode as Int?)

                    /** Alias for calling [Builder.statusCode] with `statusCode.orElse(null)`. */
                    fun statusCode(statusCode: Optional<Int>) = statusCode(statusCode.getOrNull())

                    /**
                     * Sets [Builder.statusCode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.statusCode] with a well-typed [Int] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun statusCode(statusCode: JsonField<Int>) = apply {
                        this.statusCode = statusCode
                    }

                    /**
                     * A coarse guess at what made the request: likely_human, provider (a messaging
                     * platform prefetching the link), bot, or unknown. Derived from the user agent,
                     * so it is a hint for filtering noise rather than a fact to bill or report on.
                     */
                    fun trafficClass(trafficClass: String?) =
                        trafficClass(JsonField.ofNullable(trafficClass))

                    /**
                     * Alias for calling [Builder.trafficClass] with `trafficClass.orElse(null)`.
                     */
                    fun trafficClass(trafficClass: Optional<String>) =
                        trafficClass(trafficClass.getOrNull())

                    /**
                     * Sets [Builder.trafficClass] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.trafficClass] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun trafficClass(trafficClass: JsonField<String>) = apply {
                        this.trafficClass = trafficClass
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
                     * .recordId()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Payload =
                        Payload(
                            checkRequired("recordId", recordId),
                            accessCountry,
                            accessOutcome,
                            browser,
                            bytesServed,
                            channel,
                            customerId,
                            device,
                            linkKind,
                            messageId,
                            occurredAt,
                            referenceKey,
                            referrerHost,
                            requestMethod,
                            senderProfileId,
                            statusCode,
                            trafficClass,
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

                    recordId()
                    accessCountry()
                    accessOutcome()
                    browser()
                    bytesServed()
                    channel()
                    customerId()
                    device()
                    linkKind()
                    messageId()
                    occurredAt()
                    referenceKey()
                    referrerHost()
                    requestMethod()
                    senderProfileId()
                    statusCode()
                    trafficClass()
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
                    (if (recordId.asKnown().isPresent) 1 else 0) +
                        (if (accessCountry.asKnown().isPresent) 1 else 0) +
                        (if (accessOutcome.asKnown().isPresent) 1 else 0) +
                        (if (browser.asKnown().isPresent) 1 else 0) +
                        (if (bytesServed.asKnown().isPresent) 1 else 0) +
                        (if (channel.asKnown().isPresent) 1 else 0) +
                        (if (customerId.asKnown().isPresent) 1 else 0) +
                        (if (device.asKnown().isPresent) 1 else 0) +
                        (if (linkKind.asKnown().isPresent) 1 else 0) +
                        (if (messageId.asKnown().isPresent) 1 else 0) +
                        (if (occurredAt.asKnown().isPresent) 1 else 0) +
                        (if (referenceKey.asKnown().isPresent) 1 else 0) +
                        (if (referrerHost.asKnown().isPresent) 1 else 0) +
                        (if (requestMethod.asKnown().isPresent) 1 else 0) +
                        (if (senderProfileId.asKnown().isPresent) 1 else 0) +
                        (if (statusCode.asKnown().isPresent) 1 else 0) +
                        (if (trafficClass.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Payload &&
                        recordId == other.recordId &&
                        accessCountry == other.accessCountry &&
                        accessOutcome == other.accessOutcome &&
                        browser == other.browser &&
                        bytesServed == other.bytesServed &&
                        channel == other.channel &&
                        customerId == other.customerId &&
                        device == other.device &&
                        linkKind == other.linkKind &&
                        messageId == other.messageId &&
                        occurredAt == other.occurredAt &&
                        referenceKey == other.referenceKey &&
                        referrerHost == other.referrerHost &&
                        requestMethod == other.requestMethod &&
                        senderProfileId == other.senderProfileId &&
                        statusCode == other.statusCode &&
                        trafficClass == other.trafficClass &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        recordId,
                        accessCountry,
                        accessOutcome,
                        browser,
                        bytesServed,
                        channel,
                        customerId,
                        device,
                        linkKind,
                        messageId,
                        occurredAt,
                        referenceKey,
                        referrerHost,
                        requestMethod,
                        senderProfileId,
                        statusCode,
                        trafficClass,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Payload{recordId=$recordId, accessCountry=$accessCountry, accessOutcome=$accessOutcome, browser=$browser, bytesServed=$bytesServed, channel=$channel, customerId=$customerId, device=$device, linkKind=$linkKind, messageId=$messageId, occurredAt=$occurredAt, referenceKey=$referenceKey, referrerHost=$referrerHost, requestMethod=$requestMethod, senderProfileId=$senderProfileId, statusCode=$statusCode, trafficClass=$trafficClass, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload &&
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
                "SentDmServicesCommonServicesWebhooksContractsWebhookEventOfLinkWebhookPayload{event=$event, field=$field, payload=$payload, requestId=$requestId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        class SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
             * Body of a call.initiated, call.answered, call.completed, call.failed or
             * call.recording_ready event. Which of them occurred is the envelope's event.
             *
             * Shaped like the message, inbound, template and channel payloads: account_id names the
             * account the event is about, channel names the channel, and updated_at is when the
             * change happened on the call, in the same yyyy-MM-ddTHH:mm:ssZ form. duration_seconds
             * and price are added on call.completed, reason on call.failed and recording_id on
             * call.recording_ready; each is omitted rather than sent as null when it does not
             * apply.
             *
             * Casing is snake_case because these ride the same webhook stream customers already
             * parse message_id from; the question/answer contract is a separate surface and stays
             * camelCase. Nothing here is provider-shaped: no provider call id, no namespaced
             * identity.
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
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /**
             * A builder for
             * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload].
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
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload:
                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                ) = apply {
                    event =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                            .event
                    field =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                            .field
                    payload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                            .payload
                    requestId =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                            .requestId
                    timestamp =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
                            .timestamp
                    additionalProperties =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload
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
                 * Body of a call.initiated, call.answered, call.completed, call.failed or
                 * call.recording_ready event. Which of them occurred is the envelope's event.
                 *
                 * Shaped like the message, inbound, template and channel payloads: account_id names
                 * the account the event is about, channel names the channel, and updated_at is when
                 * the change happened on the call, in the same yyyy-MM-ddTHH:mm:ssZ form.
                 * duration_seconds and price are added on call.completed, reason on call.failed and
                 * recording_id on call.recording_ready; each is omitted rather than sent as null
                 * when it does not apply.
                 *
                 * Casing is snake_case because these ride the same webhook stream customers already
                 * parse message_id from; the question/answer contract is a separate surface and
                 * stays camelCase. Nothing here is provider-shaped: no provider call id, no
                 * namespaced identity.
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
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build():
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload =
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload(
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
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload =
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
             * Body of a call.initiated, call.answered, call.completed, call.failed or
             * call.recording_ready event. Which of them occurred is the envelope's event.
             *
             * Shaped like the message, inbound, template and channel payloads: account_id names the
             * account the event is about, channel names the channel, and updated_at is when the
             * change happened on the call, in the same yyyy-MM-ddTHH:mm:ssZ form. duration_seconds
             * and price are added on call.completed, reason on call.failed and recording_id on
             * call.recording_ready; each is omitted rather than sent as null when it does not
             * apply.
             *
             * Casing is snake_case because these ride the same webhook stream customers already
             * parse message_id from; the question/answer contract is a separate surface and stays
             * camelCase. Nothing here is provider-shaped: no provider call id, no namespaced
             * identity.
             */
            class Payload
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val callId: JsonField<String>,
                private val accountId: JsonField<String>,
                private val channel: JsonField<String>,
                private val durationSeconds: JsonField<Int>,
                private val number: JsonField<String>,
                private val price: JsonField<Double>,
                private val reason: JsonField<String>,
                private val recordingId: JsonField<String>,
                private val updatedAt: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("call_id")
                    @ExcludeMissing
                    callId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("account_id")
                    @ExcludeMissing
                    accountId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("channel")
                    @ExcludeMissing
                    channel: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("duration_seconds")
                    @ExcludeMissing
                    durationSeconds: JsonField<Int> = JsonMissing.of(),
                    @JsonProperty("number")
                    @ExcludeMissing
                    number: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("price")
                    @ExcludeMissing
                    price: JsonField<Double> = JsonMissing.of(),
                    @JsonProperty("reason")
                    @ExcludeMissing
                    reason: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("recording_id")
                    @ExcludeMissing
                    recordingId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("updated_at")
                    @ExcludeMissing
                    updatedAt: JsonField<String> = JsonMissing.of(),
                ) : this(
                    callId,
                    accountId,
                    channel,
                    durationSeconds,
                    number,
                    price,
                    reason,
                    recordingId,
                    updatedAt,
                    mutableMapOf(),
                )

                /**
                 * Sent's call id, the same one the customer saw on the first question.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun callId(): String = callId.getRequired("call_id")

                /**
                 * The account the call belongs to: the key's own customer, or the sender profile it
                 * acted as.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun accountId(): Optional<String> = accountId.getOptional("account_id")

                /**
                 * Always voice.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun channel(): Optional<String> = channel.getOptional("channel")

                /**
                 * How long the call lasted. Only on call.completed.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun durationSeconds(): Optional<Int> =
                    durationSeconds.getOptional("duration_seconds")

                /**
                 * The customer number that owns the call, in E.164 format.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun number(): Optional<String> = number.getOptional("number")

                /**
                 * What the call was charged. Only on call.completed, and omitted there until
                 * billing has recorded the charge.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun price(): Optional<Double> = price.getOptional("price")

                /**
                 * The machine-readable reason the call did not complete. Only on call.failed, and
                 * omitted when no reason was recorded.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun reason(): Optional<String> = reason.getOptional("reason")

                /**
                 * The recording that became available, the same id GET /v3/calls/{id}/recordings
                 * lists it under. Only on call.recording_ready, which is sent once per recording.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun recordingId(): Optional<String> = recordingId.getOptional("recording_id")

                /**
                 * When the change happened on the call, as opposed to when the event was emitted.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

                /**
                 * Returns the raw JSON value of [callId].
                 *
                 * Unlike [callId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
                 * Returns the raw JSON value of [durationSeconds].
                 *
                 * Unlike [durationSeconds], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("duration_seconds")
                @ExcludeMissing
                fun _durationSeconds(): JsonField<Int> = durationSeconds

                /**
                 * Returns the raw JSON value of [number].
                 *
                 * Unlike [number], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

                /**
                 * Returns the raw JSON value of [price].
                 *
                 * Unlike [price], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Double> = price

                /**
                 * Returns the raw JSON value of [reason].
                 *
                 * Unlike [reason], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

                /**
                 * Returns the raw JSON value of [recordingId].
                 *
                 * Unlike [recordingId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("recording_id")
                @ExcludeMissing
                fun _recordingId(): JsonField<String> = recordingId

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
                     * .callId()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Payload]. */
                class Builder internal constructor() {

                    private var callId: JsonField<String>? = null
                    private var accountId: JsonField<String> = JsonMissing.of()
                    private var channel: JsonField<String> = JsonMissing.of()
                    private var durationSeconds: JsonField<Int> = JsonMissing.of()
                    private var number: JsonField<String> = JsonMissing.of()
                    private var price: JsonField<Double> = JsonMissing.of()
                    private var reason: JsonField<String> = JsonMissing.of()
                    private var recordingId: JsonField<String> = JsonMissing.of()
                    private var updatedAt: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(payload: Payload) = apply {
                        callId = payload.callId
                        accountId = payload.accountId
                        channel = payload.channel
                        durationSeconds = payload.durationSeconds
                        number = payload.number
                        price = payload.price
                        reason = payload.reason
                        recordingId = payload.recordingId
                        updatedAt = payload.updatedAt
                        additionalProperties = payload.additionalProperties.toMutableMap()
                    }

                    /** Sent's call id, the same one the customer saw on the first question. */
                    fun callId(callId: String) = callId(JsonField.of(callId))

                    /**
                     * Sets [Builder.callId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.callId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun callId(callId: JsonField<String>) = apply { this.callId = callId }

                    /**
                     * The account the call belongs to: the key's own customer, or the sender
                     * profile it acted as.
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

                    /** Always voice. */
                    fun channel(channel: String) = channel(JsonField.of(channel))

                    /**
                     * Sets [Builder.channel] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.channel] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun channel(channel: JsonField<String>) = apply { this.channel = channel }

                    /** How long the call lasted. Only on call.completed. */
                    fun durationSeconds(durationSeconds: Int?) =
                        durationSeconds(JsonField.ofNullable(durationSeconds))

                    /**
                     * Alias for [Builder.durationSeconds].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun durationSeconds(durationSeconds: Int) =
                        durationSeconds(durationSeconds as Int?)

                    /**
                     * Alias for calling [Builder.durationSeconds] with
                     * `durationSeconds.orElse(null)`.
                     */
                    fun durationSeconds(durationSeconds: Optional<Int>) =
                        durationSeconds(durationSeconds.getOrNull())

                    /**
                     * Sets [Builder.durationSeconds] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.durationSeconds] with a well-typed [Int]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun durationSeconds(durationSeconds: JsonField<Int>) = apply {
                        this.durationSeconds = durationSeconds
                    }

                    /** The customer number that owns the call, in E.164 format. */
                    fun number(number: String) = number(JsonField.of(number))

                    /**
                     * Sets [Builder.number] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.number] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun number(number: JsonField<String>) = apply { this.number = number }

                    /**
                     * What the call was charged. Only on call.completed, and omitted there until
                     * billing has recorded the charge.
                     */
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
                     * You should usually call [Builder.price] with a well-typed [Double] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun price(price: JsonField<Double>) = apply { this.price = price }

                    /**
                     * The machine-readable reason the call did not complete. Only on call.failed,
                     * and omitted when no reason was recorded.
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
                     * The recording that became available, the same id GET
                     * /v3/calls/{id}/recordings lists it under. Only on call.recording_ready, which
                     * is sent once per recording.
                     */
                    fun recordingId(recordingId: String?) =
                        recordingId(JsonField.ofNullable(recordingId))

                    /** Alias for calling [Builder.recordingId] with `recordingId.orElse(null)`. */
                    fun recordingId(recordingId: Optional<String>) =
                        recordingId(recordingId.getOrNull())

                    /**
                     * Sets [Builder.recordingId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.recordingId] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun recordingId(recordingId: JsonField<String>) = apply {
                        this.recordingId = recordingId
                    }

                    /**
                     * When the change happened on the call, as opposed to when the event was
                     * emitted.
                     */
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
                     * .callId()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Payload =
                        Payload(
                            checkRequired("callId", callId),
                            accountId,
                            channel,
                            durationSeconds,
                            number,
                            price,
                            reason,
                            recordingId,
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

                    callId()
                    accountId()
                    channel()
                    durationSeconds()
                    number()
                    price()
                    reason()
                    recordingId()
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
                    (if (callId.asKnown().isPresent) 1 else 0) +
                        (if (accountId.asKnown().isPresent) 1 else 0) +
                        (if (channel.asKnown().isPresent) 1 else 0) +
                        (if (durationSeconds.asKnown().isPresent) 1 else 0) +
                        (if (number.asKnown().isPresent) 1 else 0) +
                        (if (price.asKnown().isPresent) 1 else 0) +
                        (if (reason.asKnown().isPresent) 1 else 0) +
                        (if (recordingId.asKnown().isPresent) 1 else 0) +
                        (if (updatedAt.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Payload &&
                        callId == other.callId &&
                        accountId == other.accountId &&
                        channel == other.channel &&
                        durationSeconds == other.durationSeconds &&
                        number == other.number &&
                        price == other.price &&
                        reason == other.reason &&
                        recordingId == other.recordingId &&
                        updatedAt == other.updatedAt &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        callId,
                        accountId,
                        channel,
                        durationSeconds,
                        number,
                        price,
                        reason,
                        recordingId,
                        updatedAt,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Payload{callId=$callId, accountId=$accountId, channel=$channel, durationSeconds=$durationSeconds, number=$number, price=$price, reason=$reason, recordingId=$recordingId, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload &&
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
                "SentDmServicesCommonServicesWebhooksContractsWebhookEventOfCallWebhookPayload{event=$event, field=$field, payload=$payload, requestId=$requestId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
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
