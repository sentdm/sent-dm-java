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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The result of a multi-recipient send.
 *
 * Declared here rather than in the service layer. POST /v3/messages used to publish
 * MessageSendResult — a type in Common.Services.Messaging.Contracts — so the public contract was
 * whatever the send service happened to return, and changing that service for an internal reason
 * changed the API. The service keeps its result; this is what a caller sees, and the mapping
 * between them is a decision the endpoint makes.
 *
 * The shape of an immediate send: it never has a scheduled_at key. A send that carried scheduled_at
 * is a ScheduledSendMessageResponse, and the endpoint decides which of the two to answer with. From
 * always returns this type.
 */
class MessageSendResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val recipients: JsonField<List<MessageRecipient>>,
    private val status: JsonField<String>,
    private val templateId: JsonField<String>,
    private val templateName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("recipients")
        @ExcludeMissing
        recipients: JsonField<List<MessageRecipient>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_id")
        @ExcludeMissing
        templateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_name")
        @ExcludeMissing
        templateName: JsonField<String> = JsonMissing.of(),
    ) : this(recipients, status, templateId, templateName, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun recipients(): Optional<List<MessageRecipient>> = recipients.getOptional("recipients")

    /**
     * QUEUED: the batch is accepted. A request that carried scheduled_at is QUEUED here too; each
     * message moves to SCHEDULED once it is held, as GET /v3/messages/{id} and the
     * message.scheduled webhook report.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateId(): Optional<String> = templateId.getOptional("template_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateName(): Optional<String> = templateName.getOptional("template_name")

    /**
     * Returns the raw JSON value of [recipients].
     *
     * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recipients")
    @ExcludeMissing
    fun _recipients(): JsonField<List<MessageRecipient>> = recipients

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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

        /** Returns a mutable builder for constructing an instance of [MessageSendResult]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageSendResult]. */
    class Builder internal constructor() {

        private var recipients: JsonField<MutableList<MessageRecipient>>? = null
        private var status: JsonField<String> = JsonMissing.of()
        private var templateId: JsonField<String> = JsonMissing.of()
        private var templateName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageSendResult: MessageSendResult) = apply {
            recipients = messageSendResult.recipients.map { it.toMutableList() }
            status = messageSendResult.status
            templateId = messageSendResult.templateId
            templateName = messageSendResult.templateName
            additionalProperties = messageSendResult.additionalProperties.toMutableMap()
        }

        fun recipients(recipients: List<MessageRecipient>) = recipients(JsonField.of(recipients))

        /**
         * Sets [Builder.recipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipients] with a well-typed `List<MessageRecipient>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun recipients(recipients: JsonField<List<MessageRecipient>>) = apply {
            this.recipients = recipients.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageRecipient] to [recipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipient(recipient: MessageRecipient) = apply {
            recipients =
                (recipients ?: JsonField.of(mutableListOf())).also {
                    checkKnown("recipients", it).add(recipient)
                }
        }

        /**
         * QUEUED: the batch is accepted. A request that carried scheduled_at is QUEUED here too;
         * each message moves to SCHEDULED once it is held, as GET /v3/messages/{id} and the
         * message.scheduled webhook report.
         */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun templateId(templateId: String) = templateId(JsonField.of(templateId))

        /**
         * Sets [Builder.templateId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun templateId(templateId: JsonField<String>) = apply { this.templateId = templateId }

        fun templateName(templateName: String) = templateName(JsonField.of(templateName))

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
         * Returns an immutable instance of [MessageSendResult].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageSendResult =
            MessageSendResult(
                (recipients ?: JsonMissing.of()).map { it.toImmutable() },
                status,
                templateId,
                templateName,
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
    fun validate(): MessageSendResult = apply {
        if (validated) {
            return@apply
        }

        recipients().ifPresent { it.forEach { it.validate() } }
        status()
        templateId()
        templateName()
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
        (recipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (templateId.asKnown().isPresent) 1 else 0) +
            (if (templateName.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageSendResult &&
            recipients == other.recipients &&
            status == other.status &&
            templateId == other.templateId &&
            templateName == other.templateName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(recipients, status, templateId, templateName, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageSendResult{recipients=$recipients, status=$status, templateId=$templateId, templateName=$templateName, additionalProperties=$additionalProperties}"
}
