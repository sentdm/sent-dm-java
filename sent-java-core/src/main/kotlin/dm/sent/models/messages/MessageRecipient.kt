// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

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

/** What one recipient of a send got, as the API reports it. */
class MessageRecipient
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val body: JsonField<String>,
    private val channel: JsonField<String>,
    private val messageId: JsonField<String>,
    private val to: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("body") @ExcludeMissing body: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("to") @ExcludeMissing to: JsonField<String> = JsonMissing.of(),
    ) : this(body, channel, messageId, to, mutableMapOf())

    /**
     * Resolved template body for this recipient's channel, or null when the channel is
     * auto-detected.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun body(): Optional<String> = body.getOptional("body")

    /**
     * Channel this message will be sent on — sms, whatsapp — or null to auto-detect.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * Identifier for tracking this recipient's message.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * Phone number in E.164 format.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun to(): Optional<String> = to.getOptional("to")

    /**
     * Returns the raw JSON value of [body].
     *
     * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [to].
     *
     * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<String> = to

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

        /** Returns a mutable builder for constructing an instance of [MessageRecipient]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageRecipient]. */
    class Builder internal constructor() {

        private var body: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var to: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageRecipient: MessageRecipient) = apply {
            body = messageRecipient.body
            channel = messageRecipient.channel
            messageId = messageRecipient.messageId
            to = messageRecipient.to
            additionalProperties = messageRecipient.additionalProperties.toMutableMap()
        }

        /**
         * Resolved template body for this recipient's channel, or null when the channel is
         * auto-detected.
         */
        fun body(body: String?) = body(JsonField.ofNullable(body))

        /** Alias for calling [Builder.body] with `body.orElse(null)`. */
        fun body(body: Optional<String>) = body(body.getOrNull())

        /**
         * Sets [Builder.body] to an arbitrary JSON value.
         *
         * You should usually call [Builder.body] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun body(body: JsonField<String>) = apply { this.body = body }

        /** Channel this message will be sent on — sms, whatsapp — or null to auto-detect. */
        fun channel(channel: String?) = channel(JsonField.ofNullable(channel))

        /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
        fun channel(channel: Optional<String>) = channel(channel.getOrNull())

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** Identifier for tracking this recipient's message. */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /** Phone number in E.164 format. */
        fun to(to: String) = to(JsonField.of(to))

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<String>) = apply { this.to = to }

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
         * Returns an immutable instance of [MessageRecipient].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageRecipient =
            MessageRecipient(body, channel, messageId, to, additionalProperties.toMutableMap())
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
    fun validate(): MessageRecipient = apply {
        if (validated) {
            return@apply
        }

        body()
        channel()
        messageId()
        to()
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
        (if (body.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (to.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageRecipient &&
            body == other.body &&
            channel == other.channel &&
            messageId == other.messageId &&
            to == other.to &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(body, channel, messageId, to, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageRecipient{body=$body, channel=$channel, messageId=$messageId, to=$to, additionalProperties=$additionalProperties}"
}
