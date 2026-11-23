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

class WebhookDelivery
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

        /** Returns a mutable builder for constructing an instance of [WebhookDelivery]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookDelivery]. */
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
        internal fun from(webhookDelivery: WebhookDelivery) = apply {
            id = webhookDelivery.id
            createdAt = webhookDelivery.createdAt
            deliveryAttempts = webhookDelivery.deliveryAttempts
            deliveryStatus = webhookDelivery.deliveryStatus
            errorMessage = webhookDelivery.errorMessage
            eventData = webhookDelivery.eventData
            eventType = webhookDelivery.eventType
            httpStatusCode = webhookDelivery.httpStatusCode
            processingCompletedAt = webhookDelivery.processingCompletedAt
            processingStartedAt = webhookDelivery.processingStartedAt
            responseBody = webhookDelivery.responseBody
            additionalProperties = webhookDelivery.additionalProperties.toMutableMap()
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

        /** Alias for calling [eventData] with `EventData.ofLinkEvent(linkEvent)`. */
        fun eventData(linkEvent: LinkEvent) = eventData(EventData.ofLinkEvent(linkEvent))

        /** Alias for calling [eventData] with `EventData.ofCallEvent(callEvent)`. */
        fun eventData(callEvent: CallEvent) = eventData(EventData.ofCallEvent(callEvent))

        /**
         * Alias for calling [eventData] with
         * `EventData.ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload)`.
         */
        fun eventData(
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
                EventData.SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
        ) =
            eventData(
                EventData
                    .ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
         * Returns an immutable instance of [WebhookDelivery].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookDelivery =
            WebhookDelivery(
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
    fun validate(): WebhookDelivery = apply {
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
        private val linkEvent: LinkEvent? = null,
        private val callEvent: CallEvent? = null,
        private val sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload? =
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
        fun linkEvent(): Optional<LinkEvent> = Optional.ofNullable(linkEvent)

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun callEvent(): Optional<CallEvent> = Optional.ofNullable(callEvent)

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload():
            Optional<
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
            > =
            Optional.ofNullable(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
            )

        fun isMessageEvent(): Boolean = messageEvent != null

        fun isInboundMessageEvent(): Boolean = inboundMessageEvent != null

        fun isTemplateEvent(): Boolean = templateEvent != null

        fun isChannelEvent(): Boolean = channelEvent != null

        fun isContactEvent(): Boolean = contactEvent != null

        fun isLinkEvent(): Boolean = linkEvent != null

        fun isCallEvent(): Boolean = callEvent != null

        fun isSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload():
            Boolean =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload != null

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
        fun asLinkEvent(): LinkEvent = linkEvent.getOrThrow("linkEvent")

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asCallEvent(): CallEvent = callEvent.getOrThrow("callEvent")

        /**
         * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape
         * and varies only in Payload.
         */
        fun asSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload():
            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload =
            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                .getOrThrow(
                    "sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload"
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
                linkEvent != null -> visitor.visitLinkEvent(linkEvent)
                callEvent != null -> visitor.visitCallEvent(callEvent)
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload !=
                    null ->
                    visitor
                        .visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
                            sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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

                    override fun visitLinkEvent(linkEvent: LinkEvent) {
                        linkEvent.validate()
                    }

                    override fun visitCallEvent(callEvent: CallEvent) {
                        callEvent.validate()
                    }

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                    ) {
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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

                    override fun visitLinkEvent(linkEvent: LinkEvent) = linkEvent.validity()

                    override fun visitCallEvent(callEvent: CallEvent) = callEvent.validity()

                    override fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
                            SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                    ) =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
                linkEvent == other.linkEvent &&
                callEvent == other.callEvent &&
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload ==
                    other
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
        }

        override fun hashCode(): Int =
            Objects.hash(
                messageEvent,
                inboundMessageEvent,
                templateEvent,
                channelEvent,
                contactEvent,
                linkEvent,
                callEvent,
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload,
            )

        override fun toString(): String =
            when {
                messageEvent != null -> "EventData{messageEvent=$messageEvent}"
                inboundMessageEvent != null -> "EventData{inboundMessageEvent=$inboundMessageEvent}"
                templateEvent != null -> "EventData{templateEvent=$templateEvent}"
                channelEvent != null -> "EventData{channelEvent=$channelEvent}"
                contactEvent != null -> "EventData{contactEvent=$contactEvent}"
                linkEvent != null -> "EventData{linkEvent=$linkEvent}"
                callEvent != null -> "EventData{callEvent=$callEvent}"
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload !=
                    null ->
                    "EventData{sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload=$sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload}"
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
            @JvmStatic fun ofLinkEvent(linkEvent: LinkEvent) = EventData(linkEvent = linkEvent)

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic fun ofCallEvent(callEvent: CallEvent) = EventData(callEvent = callEvent)

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            @JvmStatic
            fun ofSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
            ) =
                EventData(
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
            fun visitLinkEvent(linkEvent: LinkEvent): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitCallEvent(callEvent: CallEvent): T

            /**
             * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this
             * shape and varies only in Payload.
             */
            fun visitSentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
                sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
                            tryDeserialize(node, jacksonTypeRef<LinkEvent>())?.let {
                                EventData(linkEvent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<CallEvent>())?.let {
                                EventData(callEvent = it, _json = json)
                            },
                            tryDeserialize(
                                    node,
                                    jacksonTypeRef<
                                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                                    >(),
                                )
                                ?.let {
                                    EventData(
                                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload =
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
                    value.linkEvent != null -> generator.writeObject(value.linkEvent)
                    value.callEvent != null -> generator.writeObject(value.callEvent)
                    value
                        .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload !=
                        null ->
                        generator.writeObject(
                            value
                                .sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
        class SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
             * Body of an agent.* webhook (Sent Agents). The event is the agent service's own
             * record, forwarded without renaming: EventId is its id, so a subscriber can dedupe a
             * redelivery.
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
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /**
             * A builder for
             * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload].
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
                    sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload:
                        SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                ) = apply {
                    event =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                            .event
                    field =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                            .field
                    payload =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                            .payload
                    requestId =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                            .requestId
                    timestamp =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
                            .timestamp
                    additionalProperties =
                        sentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload
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
                 * Body of an agent.* webhook (Sent Agents). The event is the agent service's own
                 * record, forwarded without renaming: EventId is its id, so a subscriber can dedupe
                 * a redelivery.
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
                 * [SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build():
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload =
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload(
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
                SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload =
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
             * Body of an agent.* webhook (Sent Agents). The event is the agent service's own
             * record, forwarded without renaming: EventId is its id, so a subscriber can dedupe a
             * redelivery.
             */
            class Payload
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val eventId: JsonField<String>,
                private val occurredAt: JsonField<String>,
                private val accountId: JsonField<String>,
                private val actor: JsonField<String>,
                private val agentId: JsonField<String>,
                private val agentName: JsonField<String>,
                private val agentVersion: JsonField<Int>,
                private val contactId: JsonField<String>,
                private val contactPhoneNumber: JsonField<String>,
                private val data: JsonValue,
                private val instanceId: JsonField<String>,
                private val sequence: JsonField<Long>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("event_id")
                    @ExcludeMissing
                    eventId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("occurred_at")
                    @ExcludeMissing
                    occurredAt: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("account_id")
                    @ExcludeMissing
                    accountId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("actor")
                    @ExcludeMissing
                    actor: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("agent_id")
                    @ExcludeMissing
                    agentId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("agent_name")
                    @ExcludeMissing
                    agentName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("agent_version")
                    @ExcludeMissing
                    agentVersion: JsonField<Int> = JsonMissing.of(),
                    @JsonProperty("contact_id")
                    @ExcludeMissing
                    contactId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("contact_phone_number")
                    @ExcludeMissing
                    contactPhoneNumber: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
                    @JsonProperty("instance_id")
                    @ExcludeMissing
                    instanceId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("sequence")
                    @ExcludeMissing
                    sequence: JsonField<Long> = JsonMissing.of(),
                ) : this(
                    eventId,
                    occurredAt,
                    accountId,
                    actor,
                    agentId,
                    agentName,
                    agentVersion,
                    contactId,
                    contactPhoneNumber,
                    data,
                    instanceId,
                    sequence,
                    mutableMapOf(),
                )

                /**
                 * The agent service's event id. The same event is never delivered under two ids.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun eventId(): String = eventId.getRequired("event_id")

                /**
                 * When the agent service recorded it, UTC, to the millisecond.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun occurredAt(): String = occurredAt.getRequired("occurred_at")

                /**
                 * The sender profile the agent runs on.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun accountId(): Optional<String> = accountId.getOptional("account_id")

                /**
                 * Who caused it: system, the agent service's customer, or an approver.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun actor(): Optional<String> = actor.getOptional("actor")

                /**
                 * The agent.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun agentId(): Optional<String> = agentId.getOptional("agent_id")

                /**
                 * The agent's name, as it is listed. Absent for an agent services no longer holds.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun agentName(): Optional<String> = agentName.getOptional("agent_name")

                /**
                 * The version of the agent the event is of: the one its conversation runs, or the
                 * active one for an event of the agent itself. Absent when the agent service does
                 * not say it.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun agentVersion(): Optional<Int> = agentVersion.getOptional("agent_version")

                /**
                 * The contact of that conversation; absent on agent-level events.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun contactId(): Optional<String> = contactId.getOptional("contact_id")

                /**
                 * The contact's phone number, in E.164, so a receiver knows who the event is about
                 * without asking for the contact. Read from the account's contacts as the webhook
                 * is built: the agent service's own record names a contact by id only. Absent on
                 * agent-level events, and for a contact the account no longer holds.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun contactPhoneNumber(): Optional<String> =
                    contactPhoneNumber.getOptional("contact_phone_number")

                /**
                 * The event's own fields (outcome, reason, ...), exactly as the agent service
                 * recorded them.
                 *
                 * This arbitrary value can be deserialized into a custom type using the `convert`
                 * method:
                 * ```java
                 * MyClass myObject = payload.data().convert(MyClass.class);
                 * ```
                 */
                @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

                /**
                 * The conversation (agent × contact) the event belongs to; absent on agent-level
                 * events.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun instanceId(): Optional<String> = instanceId.getOptional("instance_id")

                /**
                 * Where the event stands among the agent's events: a number that grows with each,
                 * so two events of the same second are put in order by it. Not a count: there are
                 * gaps between an agent's own. Absent from an agent service that does not say it.
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun sequence(): Optional<Long> = sequence.getOptional("sequence")

                /**
                 * Returns the raw JSON value of [eventId].
                 *
                 * Unlike [eventId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("event_id")
                @ExcludeMissing
                fun _eventId(): JsonField<String> = eventId

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
                 * Returns the raw JSON value of [accountId].
                 *
                 * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("account_id")
                @ExcludeMissing
                fun _accountId(): JsonField<String> = accountId

                /**
                 * Returns the raw JSON value of [actor].
                 *
                 * Unlike [actor], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<String> = actor

                /**
                 * Returns the raw JSON value of [agentId].
                 *
                 * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("agent_id")
                @ExcludeMissing
                fun _agentId(): JsonField<String> = agentId

                /**
                 * Returns the raw JSON value of [agentName].
                 *
                 * Unlike [agentName], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("agent_name")
                @ExcludeMissing
                fun _agentName(): JsonField<String> = agentName

                /**
                 * Returns the raw JSON value of [agentVersion].
                 *
                 * Unlike [agentVersion], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("agent_version")
                @ExcludeMissing
                fun _agentVersion(): JsonField<Int> = agentVersion

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
                 * Returns the raw JSON value of [contactPhoneNumber].
                 *
                 * Unlike [contactPhoneNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("contact_phone_number")
                @ExcludeMissing
                fun _contactPhoneNumber(): JsonField<String> = contactPhoneNumber

                /**
                 * Returns the raw JSON value of [instanceId].
                 *
                 * Unlike [instanceId], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("instance_id")
                @ExcludeMissing
                fun _instanceId(): JsonField<String> = instanceId

                /**
                 * Returns the raw JSON value of [sequence].
                 *
                 * Unlike [sequence], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("sequence")
                @ExcludeMissing
                fun _sequence(): JsonField<Long> = sequence

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
                     * .eventId()
                     * .occurredAt()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Payload]. */
                class Builder internal constructor() {

                    private var eventId: JsonField<String>? = null
                    private var occurredAt: JsonField<String>? = null
                    private var accountId: JsonField<String> = JsonMissing.of()
                    private var actor: JsonField<String> = JsonMissing.of()
                    private var agentId: JsonField<String> = JsonMissing.of()
                    private var agentName: JsonField<String> = JsonMissing.of()
                    private var agentVersion: JsonField<Int> = JsonMissing.of()
                    private var contactId: JsonField<String> = JsonMissing.of()
                    private var contactPhoneNumber: JsonField<String> = JsonMissing.of()
                    private var data: JsonValue = JsonMissing.of()
                    private var instanceId: JsonField<String> = JsonMissing.of()
                    private var sequence: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(payload: Payload) = apply {
                        eventId = payload.eventId
                        occurredAt = payload.occurredAt
                        accountId = payload.accountId
                        actor = payload.actor
                        agentId = payload.agentId
                        agentName = payload.agentName
                        agentVersion = payload.agentVersion
                        contactId = payload.contactId
                        contactPhoneNumber = payload.contactPhoneNumber
                        data = payload.data
                        instanceId = payload.instanceId
                        sequence = payload.sequence
                        additionalProperties = payload.additionalProperties.toMutableMap()
                    }

                    /**
                     * The agent service's event id. The same event is never delivered under two
                     * ids.
                     */
                    fun eventId(eventId: String) = eventId(JsonField.of(eventId))

                    /**
                     * Sets [Builder.eventId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.eventId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun eventId(eventId: JsonField<String>) = apply { this.eventId = eventId }

                    /** When the agent service recorded it, UTC, to the millisecond. */
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

                    /** The sender profile the agent runs on. */
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

                    /** Who caused it: system, the agent service's customer, or an approver. */
                    fun actor(actor: String?) = actor(JsonField.ofNullable(actor))

                    /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
                    fun actor(actor: Optional<String>) = actor(actor.getOrNull())

                    /**
                     * Sets [Builder.actor] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.actor] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun actor(actor: JsonField<String>) = apply { this.actor = actor }

                    /** The agent. */
                    fun agentId(agentId: String) = agentId(JsonField.of(agentId))

                    /**
                     * Sets [Builder.agentId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.agentId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

                    /**
                     * The agent's name, as it is listed. Absent for an agent services no longer
                     * holds.
                     */
                    fun agentName(agentName: String?) = agentName(JsonField.ofNullable(agentName))

                    /** Alias for calling [Builder.agentName] with `agentName.orElse(null)`. */
                    fun agentName(agentName: Optional<String>) = agentName(agentName.getOrNull())

                    /**
                     * Sets [Builder.agentName] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.agentName] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun agentName(agentName: JsonField<String>) = apply {
                        this.agentName = agentName
                    }

                    /**
                     * The version of the agent the event is of: the one its conversation runs, or
                     * the active one for an event of the agent itself. Absent when the agent
                     * service does not say it.
                     */
                    fun agentVersion(agentVersion: Int?) =
                        agentVersion(JsonField.ofNullable(agentVersion))

                    /**
                     * Alias for [Builder.agentVersion].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun agentVersion(agentVersion: Int) = agentVersion(agentVersion as Int?)

                    /**
                     * Alias for calling [Builder.agentVersion] with `agentVersion.orElse(null)`.
                     */
                    fun agentVersion(agentVersion: Optional<Int>) =
                        agentVersion(agentVersion.getOrNull())

                    /**
                     * Sets [Builder.agentVersion] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.agentVersion] with a well-typed [Int] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun agentVersion(agentVersion: JsonField<Int>) = apply {
                        this.agentVersion = agentVersion
                    }

                    /** The contact of that conversation; absent on agent-level events. */
                    fun contactId(contactId: String?) = contactId(JsonField.ofNullable(contactId))

                    /** Alias for calling [Builder.contactId] with `contactId.orElse(null)`. */
                    fun contactId(contactId: Optional<String>) = contactId(contactId.getOrNull())

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
                     * The contact's phone number, in E.164, so a receiver knows who the event is
                     * about without asking for the contact. Read from the account's contacts as the
                     * webhook is built: the agent service's own record names a contact by id only.
                     * Absent on agent-level events, and for a contact the account no longer holds.
                     */
                    fun contactPhoneNumber(contactPhoneNumber: String?) =
                        contactPhoneNumber(JsonField.ofNullable(contactPhoneNumber))

                    /**
                     * Alias for calling [Builder.contactPhoneNumber] with
                     * `contactPhoneNumber.orElse(null)`.
                     */
                    fun contactPhoneNumber(contactPhoneNumber: Optional<String>) =
                        contactPhoneNumber(contactPhoneNumber.getOrNull())

                    /**
                     * Sets [Builder.contactPhoneNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.contactPhoneNumber] with a well-typed
                     * [String] value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun contactPhoneNumber(contactPhoneNumber: JsonField<String>) = apply {
                        this.contactPhoneNumber = contactPhoneNumber
                    }

                    /**
                     * The event's own fields (outcome, reason, ...), exactly as the agent service
                     * recorded them.
                     */
                    fun data(data: JsonValue) = apply { this.data = data }

                    /**
                     * The conversation (agent × contact) the event belongs to; absent on
                     * agent-level events.
                     */
                    fun instanceId(instanceId: String?) =
                        instanceId(JsonField.ofNullable(instanceId))

                    /** Alias for calling [Builder.instanceId] with `instanceId.orElse(null)`. */
                    fun instanceId(instanceId: Optional<String>) =
                        instanceId(instanceId.getOrNull())

                    /**
                     * Sets [Builder.instanceId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.instanceId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun instanceId(instanceId: JsonField<String>) = apply {
                        this.instanceId = instanceId
                    }

                    /**
                     * Where the event stands among the agent's events: a number that grows with
                     * each, so two events of the same second are put in order by it. Not a count:
                     * there are gaps between an agent's own. Absent from an agent service that does
                     * not say it.
                     */
                    fun sequence(sequence: Long?) = sequence(JsonField.ofNullable(sequence))

                    /**
                     * Alias for [Builder.sequence].
                     *
                     * This unboxed primitive overload exists for backwards compatibility.
                     */
                    fun sequence(sequence: Long) = sequence(sequence as Long?)

                    /** Alias for calling [Builder.sequence] with `sequence.orElse(null)`. */
                    fun sequence(sequence: Optional<Long>) = sequence(sequence.getOrNull())

                    /**
                     * Sets [Builder.sequence] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.sequence] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun sequence(sequence: JsonField<Long>) = apply { this.sequence = sequence }

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
                     * .eventId()
                     * .occurredAt()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Payload =
                        Payload(
                            checkRequired("eventId", eventId),
                            checkRequired("occurredAt", occurredAt),
                            accountId,
                            actor,
                            agentId,
                            agentName,
                            agentVersion,
                            contactId,
                            contactPhoneNumber,
                            data,
                            instanceId,
                            sequence,
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

                    eventId()
                    occurredAt()
                    accountId()
                    actor()
                    agentId()
                    agentName()
                    agentVersion()
                    contactId()
                    contactPhoneNumber()
                    instanceId()
                    sequence()
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
                    (if (eventId.asKnown().isPresent) 1 else 0) +
                        (if (occurredAt.asKnown().isPresent) 1 else 0) +
                        (if (accountId.asKnown().isPresent) 1 else 0) +
                        (if (actor.asKnown().isPresent) 1 else 0) +
                        (if (agentId.asKnown().isPresent) 1 else 0) +
                        (if (agentName.asKnown().isPresent) 1 else 0) +
                        (if (agentVersion.asKnown().isPresent) 1 else 0) +
                        (if (contactId.asKnown().isPresent) 1 else 0) +
                        (if (contactPhoneNumber.asKnown().isPresent) 1 else 0) +
                        (if (instanceId.asKnown().isPresent) 1 else 0) +
                        (if (sequence.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Payload &&
                        eventId == other.eventId &&
                        occurredAt == other.occurredAt &&
                        accountId == other.accountId &&
                        actor == other.actor &&
                        agentId == other.agentId &&
                        agentName == other.agentName &&
                        agentVersion == other.agentVersion &&
                        contactId == other.contactId &&
                        contactPhoneNumber == other.contactPhoneNumber &&
                        data == other.data &&
                        instanceId == other.instanceId &&
                        sequence == other.sequence &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        eventId,
                        occurredAt,
                        accountId,
                        actor,
                        agentId,
                        agentName,
                        agentVersion,
                        contactId,
                        contactPhoneNumber,
                        data,
                        instanceId,
                        sequence,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Payload{eventId=$eventId, occurredAt=$occurredAt, accountId=$accountId, actor=$actor, agentId=$agentId, agentName=$agentName, agentVersion=$agentVersion, contactId=$contactId, contactPhoneNumber=$contactPhoneNumber, data=$data, instanceId=$instanceId, sequence=$sequence, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is
                    SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload &&
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
                "SentDmServicesCommonServicesWebhooksContractsWebhookEventOfAgentWebhookPayload{event=$event, field=$field, payload=$payload, requestId=$requestId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookDelivery &&
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
        "WebhookDelivery{id=$id, createdAt=$createdAt, deliveryAttempts=$deliveryAttempts, deliveryStatus=$deliveryStatus, errorMessage=$errorMessage, eventData=$eventData, eventType=$eventType, httpStatusCode=$httpStatusCode, processingCompletedAt=$processingCompletedAt, processingStartedAt=$processingStartedAt, responseBody=$responseBody, additionalProperties=$additionalProperties}"
}
