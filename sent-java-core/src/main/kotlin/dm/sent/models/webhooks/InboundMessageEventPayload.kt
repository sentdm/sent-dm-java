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

/** Body of a message.received event. Delivered when a contact messages one of your numbers. */
class InboundMessageEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val accountId: JsonField<String>,
    private val channel: JsonField<String>,
    private val inboundNumber: JsonField<String>,
    private val messageId: JsonField<String>,
    private val outboundNumber: JsonField<String>,
    private val receivedAt: JsonField<String>,
    private val text: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inbound_number")
        @ExcludeMissing
        inboundNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("outbound_number")
        @ExcludeMissing
        outboundNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("received_at")
        @ExcludeMissing
        receivedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        accountId,
        channel,
        inboundNumber,
        messageId,
        outboundNumber,
        receivedAt,
        text,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The account the message belongs to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * The channel the message arrived on, for example sms or whatsapp.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * The contact's number in E.164 format, meaning the number the message came from.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inboundNumber(): Optional<String> = inboundNumber.getOptional("inbound_number")

    /**
     * The inbound message.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * Your number in E.164 format, meaning the number the message was addressed to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun outboundNumber(): Optional<String> = outboundNumber.getOptional("outbound_number")

    /**
     * When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ).
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun receivedAt(): Optional<String> = receivedAt.getOptional("received_at")

    /**
     * The message body. Sent as null when the inbound message carried no text, for example a
     * media-only message. The field is always present, so read it and check for null rather than
     * checking whether the key exists.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun text(): Optional<String> = text.getOptional("text")

    /**
     * When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ). Same value as ReceivedAt, kept
     * for envelope consistency with outbound events.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [inboundNumber].
     *
     * Unlike [inboundNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inbound_number")
    @ExcludeMissing
    fun _inboundNumber(): JsonField<String> = inboundNumber

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [outboundNumber].
     *
     * Unlike [outboundNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("outbound_number")
    @ExcludeMissing
    fun _outboundNumber(): JsonField<String> = outboundNumber

    /**
     * Returns the raw JSON value of [receivedAt].
     *
     * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("received_at") @ExcludeMissing fun _receivedAt(): JsonField<String> = receivedAt

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<String> = updatedAt

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
         * Returns a mutable builder for constructing an instance of [InboundMessageEventPayload].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboundMessageEventPayload]. */
    class Builder internal constructor() {

        private var accountId: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var inboundNumber: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var outboundNumber: JsonField<String> = JsonMissing.of()
        private var receivedAt: JsonField<String> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboundMessageEventPayload: InboundMessageEventPayload) = apply {
            accountId = inboundMessageEventPayload.accountId
            channel = inboundMessageEventPayload.channel
            inboundNumber = inboundMessageEventPayload.inboundNumber
            messageId = inboundMessageEventPayload.messageId
            outboundNumber = inboundMessageEventPayload.outboundNumber
            receivedAt = inboundMessageEventPayload.receivedAt
            text = inboundMessageEventPayload.text
            updatedAt = inboundMessageEventPayload.updatedAt
            additionalProperties = inboundMessageEventPayload.additionalProperties.toMutableMap()
        }

        /** The account the message belongs to. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** The channel the message arrived on, for example sms or whatsapp. */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** The contact's number in E.164 format, meaning the number the message came from. */
        fun inboundNumber(inboundNumber: String) = inboundNumber(JsonField.of(inboundNumber))

        /**
         * Sets [Builder.inboundNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inboundNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inboundNumber(inboundNumber: JsonField<String>) = apply {
            this.inboundNumber = inboundNumber
        }

        /** The inbound message. */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /** Your number in E.164 format, meaning the number the message was addressed to. */
        fun outboundNumber(outboundNumber: String) = outboundNumber(JsonField.of(outboundNumber))

        /**
         * Sets [Builder.outboundNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outboundNumber] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun outboundNumber(outboundNumber: JsonField<String>) = apply {
            this.outboundNumber = outboundNumber
        }

        /** When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ). */
        fun receivedAt(receivedAt: String) = receivedAt(JsonField.of(receivedAt))

        /**
         * Sets [Builder.receivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.receivedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun receivedAt(receivedAt: JsonField<String>) = apply { this.receivedAt = receivedAt }

        /**
         * The message body. Sent as null when the inbound message carried no text, for example a
         * media-only message. The field is always present, so read it and check for null rather
         * than checking whether the key exists.
         */
        fun text(text: String?) = text(JsonField.ofNullable(text))

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<String>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ). Same value as ReceivedAt,
         * kept for envelope consistency with outbound events.
         */
        fun updatedAt(updatedAt: String) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun updatedAt(updatedAt: JsonField<String>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [InboundMessageEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InboundMessageEventPayload =
            InboundMessageEventPayload(
                accountId,
                channel,
                inboundNumber,
                messageId,
                outboundNumber,
                receivedAt,
                text,
                updatedAt,
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
    fun validate(): InboundMessageEventPayload = apply {
        if (validated) {
            return@apply
        }

        accountId()
        channel()
        inboundNumber()
        messageId()
        outboundNumber()
        receivedAt()
        text()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (inboundNumber.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (outboundNumber.asKnown().isPresent) 1 else 0) +
            (if (receivedAt.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboundMessageEventPayload &&
            accountId == other.accountId &&
            channel == other.channel &&
            inboundNumber == other.inboundNumber &&
            messageId == other.messageId &&
            outboundNumber == other.outboundNumber &&
            receivedAt == other.receivedAt &&
            text == other.text &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            accountId,
            channel,
            inboundNumber,
            messageId,
            outboundNumber,
            receivedAt,
            text,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboundMessageEventPayload{accountId=$accountId, channel=$channel, inboundNumber=$inboundNumber, messageId=$messageId, outboundNumber=$outboundNumber, receivedAt=$receivedAt, text=$text, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
