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
class InboundMessageEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val event: JsonField<String>,
    private val field: JsonField<String>,
    private val payload: JsonField<InboundMessageEventPayload>,
    private val timestamp: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
        @JsonProperty("field") @ExcludeMissing field: JsonField<String> = JsonMissing.of(),
        @JsonProperty("payload")
        @ExcludeMissing
        payload: JsonField<InboundMessageEventPayload> = JsonMissing.of(),
        @JsonProperty("timestamp") @ExcludeMissing timestamp: JsonField<String> = JsonMissing.of(),
    ) : this(event, field, payload, timestamp, mutableMapOf())

    /**
     * The specific event within the family, for example message.delivered or message.received.
     * Absent on events that have no subtype, so treat it as optional.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun event(): Optional<String> = event.getOptional("event")

    /**
     * The event family, for example message or templates. Route on this first, then on event for
     * the specific change.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun field(): Optional<String> = field.getOptional("field")

    /**
     * Body of a message.received event. Delivered when a contact messages one of your numbers.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun payload(): Optional<InboundMessageEventPayload> = payload.getOptional("payload")

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
    @JsonProperty("payload")
    @ExcludeMissing
    fun _payload(): JsonField<InboundMessageEventPayload> = payload

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

        /** Returns a mutable builder for constructing an instance of [InboundMessageEvent]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboundMessageEvent]. */
    class Builder internal constructor() {

        private var event: JsonField<String> = JsonMissing.of()
        private var field: JsonField<String> = JsonMissing.of()
        private var payload: JsonField<InboundMessageEventPayload> = JsonMissing.of()
        private var timestamp: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboundMessageEvent: InboundMessageEvent) = apply {
            event = inboundMessageEvent.event
            field = inboundMessageEvent.field
            payload = inboundMessageEvent.payload
            timestamp = inboundMessageEvent.timestamp
            additionalProperties = inboundMessageEvent.additionalProperties.toMutableMap()
        }

        /**
         * The specific event within the family, for example message.delivered or message.received.
         * Absent on events that have no subtype, so treat it as optional.
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
         * The event family, for example message or templates. Route on this first, then on event
         * for the specific change.
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
         * Body of a message.received event. Delivered when a contact messages one of your numbers.
         */
        fun payload(payload: InboundMessageEventPayload?) = payload(JsonField.ofNullable(payload))

        /** Alias for calling [Builder.payload] with `payload.orElse(null)`. */
        fun payload(payload: Optional<InboundMessageEventPayload>) = payload(payload.getOrNull())

        /**
         * Sets [Builder.payload] to an arbitrary JSON value.
         *
         * You should usually call [Builder.payload] with a well-typed [InboundMessageEventPayload]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun payload(payload: JsonField<InboundMessageEventPayload>) = apply {
            this.payload = payload
        }

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
         * Returns an immutable instance of [InboundMessageEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InboundMessageEvent =
            InboundMessageEvent(
                event,
                field,
                payload,
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
    fun validate(): InboundMessageEvent = apply {
        if (validated) {
            return@apply
        }

        event()
        field()
        payload().ifPresent { it.validate() }
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
            (if (timestamp.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboundMessageEvent &&
            event == other.event &&
            field == other.field &&
            payload == other.payload &&
            timestamp == other.timestamp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(event, field, payload, timestamp, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboundMessageEvent{event=$event, field=$field, payload=$payload, timestamp=$timestamp, additionalProperties=$additionalProperties}"
}
