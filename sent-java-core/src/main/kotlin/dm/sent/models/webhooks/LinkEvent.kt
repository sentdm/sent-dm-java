// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

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

/**
 * The envelope Sent POSTs to a subscribed webhook endpoint. Every event shares this shape and
 * varies only in Payload.
 */
class LinkEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val event: JsonField<String>,
    private val field: JsonField<String>,
    private val payload: JsonField<LinkEventPayload>,
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
        payload: JsonField<LinkEventPayload> = JsonMissing.of(),
        @JsonProperty("request_id") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timestamp") @ExcludeMissing timestamp: JsonField<String> = JsonMissing.of(),
    ) : this(event, field, payload, requestId, timestamp, mutableMapOf())

    /**
     * The specific event within the family, for example message.delivered, message.received or
     * contact.opt_out. Absent on events that have no subtype, so treat it as optional.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun event(): Optional<String> = event.getOptional("event")

    /**
     * The event family, for example message, templates or contact. Route on this first, then on
     * event for the specific change.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun field(): Optional<String> = field.getOptional("field")

    /**
     * Body of a link event: something happened to a tracked link Sent published on the customer's
     * behalf. A link points either at a URL the customer supplied or at a file Sent hosts for them;
     * LinkKind says which. Delivered when an eligible request is served, or when a published link
     * reaches the end of its life.
     *
     * A click is a request, not a read receipt. link.clicked means the redirect was served;
     * link.downloaded means bytes went out. Neither proves a person saw anything — messaging
     * providers and link scanners fetch URLs on their own, which is what TrafficClass exists to
     * tell apart. Filter on it before reporting a click-through rate; treat likely_human as a hint,
     * never as delivery confirmation.
     *
     * RecordId identifies the link; the X-Webhook-Event-ID header identifies the delivery. One link
     * is hit many times, so those are the two keys a subscriber needs: group by the first,
     * deduplicate on the second — exactly as on every other family. The payload carries no event
     * identifier of its own, for the same reason none of the others do.
     *
     * Nothing here identifies the visitor. No IP address and no visitor token crosses this
     * boundary. Country, Device and Browser are coarse buckets derived at the edge and are absent
     * whenever the request did not supply enough to derive them.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun payload(): Optional<LinkEventPayload> = payload.getOptional("payload")

    /**
     * The event-specific body.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun requestId(): Optional<String> = requestId.getOptional("request_id")

    /**
     * When Sent emitted the event, in UTC (yyyy-MM-ddTHH:mm:ssZ). This is the emission time, not
     * the time the underlying change happened. Use the timestamp inside the payload for the latter.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
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
    @JsonProperty("payload") @ExcludeMissing fun _payload(): JsonField<LinkEventPayload> = payload

    /**
     * Returns the raw JSON value of [requestId].
     *
     * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

    /**
     * Returns the raw JSON value of [timestamp].
     *
     * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timestamp") @ExcludeMissing fun _timestamp(): JsonField<String> = timestamp

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

        /** Returns a mutable builder for constructing an instance of [LinkEvent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LinkEvent]. */
    class Builder internal constructor() {

        private var event: JsonField<String> = JsonMissing.of()
        private var field: JsonField<String> = JsonMissing.of()
        private var payload: JsonField<LinkEventPayload> = JsonMissing.of()
        private var requestId: JsonField<String> = JsonMissing.of()
        private var timestamp: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(linkEvent: LinkEvent) = apply {
            event = linkEvent.event
            field = linkEvent.field
            payload = linkEvent.payload
            requestId = linkEvent.requestId
            timestamp = linkEvent.timestamp
            additionalProperties = linkEvent.additionalProperties.toMutableMap()
        }

        /**
         * The specific event within the family, for example message.delivered, message.received or
         * contact.opt_out. Absent on events that have no subtype, so treat it as optional.
         */
        fun event(event: String?) = event(JsonField.ofNullable(event))

        /** Alias for calling [Builder.event] with `event.orElse(null)`. */
        fun event(event: Optional<String>) = event(event.getOrNull())

        /**
         * Sets [Builder.event] to an arbitrary JSON value.
         *
         * You should usually call [Builder.event] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun event(event: JsonField<String>) = apply { this.event = event }

        /**
         * The event family, for example message, templates or contact. Route on this first, then on
         * event for the specific change.
         */
        fun field(field: String) = field(JsonField.of(field))

        /**
         * Sets [Builder.field] to an arbitrary JSON value.
         *
         * You should usually call [Builder.field] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun field(field: JsonField<String>) = apply { this.field = field }

        /**
         * Body of a link event: something happened to a tracked link Sent published on the
         * customer's behalf. A link points either at a URL the customer supplied or at a file Sent
         * hosts for them; LinkKind says which. Delivered when an eligible request is served, or
         * when a published link reaches the end of its life.
         *
         * A click is a request, not a read receipt. link.clicked means the redirect was served;
         * link.downloaded means bytes went out. Neither proves a person saw anything — messaging
         * providers and link scanners fetch URLs on their own, which is what TrafficClass exists to
         * tell apart. Filter on it before reporting a click-through rate; treat likely_human as a
         * hint, never as delivery confirmation.
         *
         * RecordId identifies the link; the X-Webhook-Event-ID header identifies the delivery. One
         * link is hit many times, so those are the two keys a subscriber needs: group by the first,
         * deduplicate on the second — exactly as on every other family. The payload carries no
         * event identifier of its own, for the same reason none of the others do.
         *
         * Nothing here identifies the visitor. No IP address and no visitor token crosses this
         * boundary. Country, Device and Browser are coarse buckets derived at the edge and are
         * absent whenever the request did not supply enough to derive them.
         */
        fun payload(payload: LinkEventPayload?) = payload(JsonField.ofNullable(payload))

        /** Alias for calling [Builder.payload] with `payload.orElse(null)`. */
        fun payload(payload: Optional<LinkEventPayload>) = payload(payload.getOrNull())

        /**
         * Sets [Builder.payload] to an arbitrary JSON value.
         *
         * You should usually call [Builder.payload] with a well-typed [LinkEventPayload] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun payload(payload: JsonField<LinkEventPayload>) = apply { this.payload = payload }

        /** The event-specific body. */
        fun requestId(requestId: String?) = requestId(JsonField.ofNullable(requestId))

        /** Alias for calling [Builder.requestId] with `requestId.orElse(null)`. */
        fun requestId(requestId: Optional<String>) = requestId(requestId.getOrNull())

        /**
         * Sets [Builder.requestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

        /**
         * When Sent emitted the event, in UTC (yyyy-MM-ddTHH:mm:ssZ). This is the emission time,
         * not the time the underlying change happened. Use the timestamp inside the payload for the
         * latter.
         */
        fun timestamp(timestamp: String) = timestamp(JsonField.of(timestamp))

        /**
         * Sets [Builder.timestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timestamp] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun timestamp(timestamp: JsonField<String>) = apply { this.timestamp = timestamp }

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
         * Returns an immutable instance of [LinkEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): LinkEvent =
            LinkEvent(
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
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): LinkEvent = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LinkEvent &&
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
        "LinkEvent{event=$event, field=$field, payload=$payload, requestId=$requestId, timestamp=$timestamp, additionalProperties=$additionalProperties}"
}
