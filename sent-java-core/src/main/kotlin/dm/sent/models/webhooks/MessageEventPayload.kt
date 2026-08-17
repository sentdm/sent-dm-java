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
 * Body of an outbound message lifecycle event. Delivered once per status change, so a single
 * message produces several of these as it moves toward a terminal status.
 */
class MessageEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val accountId: JsonField<String>,
    private val agentId: JsonField<String>,
    private val channel: JsonField<String>,
    private val messageId: JsonField<String>,
    private val messageStatus: JsonField<String>,
    private val outboundNumber: JsonField<String>,
    private val templateId: JsonField<String>,
    private val templateName: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_status")
        @ExcludeMissing
        messageStatus: JsonField<String> = JsonMissing.of(),
        @JsonProperty("outbound_number")
        @ExcludeMissing
        outboundNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_id")
        @ExcludeMissing
        templateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_name")
        @ExcludeMissing
        templateName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        accountId,
        agentId,
        channel,
        messageId,
        messageStatus,
        outboundNumber,
        templateId,
        templateName,
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
     * The agent attributed to the send, when the send was attributed to one.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentId(): Optional<String> = agentId.getOptional("agent_id")

    /**
     * The channel the message went out on, for example sms or whatsapp. A message that falls back
     * to another channel reports the channel actually used.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * The message this event describes. Stable across every event in the message's lifecycle, so
     * use it to correlate them.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * The status the message just reached, for example SENT, DELIVERED, or FAILED. Sent means
     * dispatched and delivered means confirmed, so treat them as distinct outcomes.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageStatus(): Optional<String> = messageStatus.getOptional("message_status")

    /**
     * The recipient's number in E.164 format.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun outboundNumber(): Optional<String> = outboundNumber.getOptional("outbound_number")

    /**
     * The template the message was sent from, when it was sent from one.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateId(): Optional<String> = templateId.getOptional("template_id")

    /**
     * Name of the template the message was sent from. Omitted when the message wasn't
     * template-based.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateName(): Optional<String> = templateName.getOptional("template_name")

    /**
     * When the message reached MessageStatus, in UTC (yyyy-MM-ddTHH:mm:ssZ).
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
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

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
     * Returns the raw JSON value of [messageStatus].
     *
     * Unlike [messageStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_status")
    @ExcludeMissing
    fun _messageStatus(): JsonField<String> = messageStatus

    /**
     * Returns the raw JSON value of [outboundNumber].
     *
     * Unlike [outboundNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("outbound_number")
    @ExcludeMissing
    fun _outboundNumber(): JsonField<String> = outboundNumber

    /**
     * Returns the raw JSON value of [templateId].
     *
     * Unlike [templateId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("template_id") @ExcludeMissing fun _templateId(): JsonField<String> = templateId

    /**
     * Returns the raw JSON value of [templateName].
     *
     * Unlike [templateName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("template_name")
    @ExcludeMissing
    fun _templateName(): JsonField<String> = templateName

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

        /** Returns a mutable builder for constructing an instance of [MessageEventPayload]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageEventPayload]. */
    class Builder internal constructor() {

        private var accountId: JsonField<String> = JsonMissing.of()
        private var agentId: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var messageStatus: JsonField<String> = JsonMissing.of()
        private var outboundNumber: JsonField<String> = JsonMissing.of()
        private var templateId: JsonField<String> = JsonMissing.of()
        private var templateName: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageEventPayload: MessageEventPayload) = apply {
            accountId = messageEventPayload.accountId
            agentId = messageEventPayload.agentId
            channel = messageEventPayload.channel
            messageId = messageEventPayload.messageId
            messageStatus = messageEventPayload.messageStatus
            outboundNumber = messageEventPayload.outboundNumber
            templateId = messageEventPayload.templateId
            templateName = messageEventPayload.templateName
            updatedAt = messageEventPayload.updatedAt
            additionalProperties = messageEventPayload.additionalProperties.toMutableMap()
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

        /** The agent attributed to the send, when the send was attributed to one. */
        fun agentId(agentId: String?) = agentId(JsonField.ofNullable(agentId))

        /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
        fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

        /**
         * The channel the message went out on, for example sms or whatsapp. A message that falls
         * back to another channel reports the channel actually used.
         */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /**
         * The message this event describes. Stable across every event in the message's lifecycle,
         * so use it to correlate them.
         */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /**
         * The status the message just reached, for example SENT, DELIVERED, or FAILED. Sent means
         * dispatched and delivered means confirmed, so treat them as distinct outcomes.
         */
        fun messageStatus(messageStatus: String) = messageStatus(JsonField.of(messageStatus))

        /**
         * Sets [Builder.messageStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageStatus] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageStatus(messageStatus: JsonField<String>) = apply {
            this.messageStatus = messageStatus
        }

        /** The recipient's number in E.164 format. */
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

        /** The template the message was sent from, when it was sent from one. */
        fun templateId(templateId: String?) = templateId(JsonField.ofNullable(templateId))

        /** Alias for calling [Builder.templateId] with `templateId.orElse(null)`. */
        fun templateId(templateId: Optional<String>) = templateId(templateId.getOrNull())

        /**
         * Sets [Builder.templateId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun templateId(templateId: JsonField<String>) = apply { this.templateId = templateId }

        /**
         * Name of the template the message was sent from. Omitted when the message wasn't
         * template-based.
         */
        fun templateName(templateName: String?) = templateName(JsonField.ofNullable(templateName))

        /** Alias for calling [Builder.templateName] with `templateName.orElse(null)`. */
        fun templateName(templateName: Optional<String>) = templateName(templateName.getOrNull())

        /**
         * Sets [Builder.templateName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun templateName(templateName: JsonField<String>) = apply {
            this.templateName = templateName
        }

        /** When the message reached MessageStatus, in UTC (yyyy-MM-ddTHH:mm:ssZ). */
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
         * Returns an immutable instance of [MessageEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageEventPayload =
            MessageEventPayload(
                accountId,
                agentId,
                channel,
                messageId,
                messageStatus,
                outboundNumber,
                templateId,
                templateName,
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
    fun validate(): MessageEventPayload = apply {
        if (validated) {
            return@apply
        }

        accountId()
        agentId()
        channel()
        messageId()
        messageStatus()
        outboundNumber()
        templateId()
        templateName()
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
            (if (agentId.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (messageStatus.asKnown().isPresent) 1 else 0) +
            (if (outboundNumber.asKnown().isPresent) 1 else 0) +
            (if (templateId.asKnown().isPresent) 1 else 0) +
            (if (templateName.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageEventPayload &&
            accountId == other.accountId &&
            agentId == other.agentId &&
            channel == other.channel &&
            messageId == other.messageId &&
            messageStatus == other.messageStatus &&
            outboundNumber == other.outboundNumber &&
            templateId == other.templateId &&
            templateName == other.templateName &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            accountId,
            agentId,
            channel,
            messageId,
            messageStatus,
            outboundNumber,
            templateId,
            templateName,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageEventPayload{accountId=$accountId, agentId=$agentId, channel=$channel, messageId=$messageId, messageStatus=$messageStatus, outboundNumber=$outboundNumber, templateId=$templateId, templateName=$templateName, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
