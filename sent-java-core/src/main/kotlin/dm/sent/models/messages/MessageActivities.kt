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
import dm.sent.models.webhooks.PaginationMeta
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Response for GET /messages/{id}/activities */
class MessageActivities
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val activities: JsonField<List<MessageActivity>>,
    private val messageId: JsonField<String>,
    private val pagination: JsonField<PaginationMeta>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("activities")
        @ExcludeMissing
        activities: JsonField<List<MessageActivity>> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pagination")
        @ExcludeMissing
        pagination: JsonField<PaginationMeta> = JsonMissing.of(),
    ) : this(activities, messageId, pagination, mutableMapOf())

    /**
     * List of activity events ordered by most recent first
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun activities(): Optional<List<MessageActivity>> = activities.getOptional("activities")

    /**
     * The message ID these activities belong to
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * Pagination metadata for list responses
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun pagination(): Optional<PaginationMeta> = pagination.getOptional("pagination")

    /**
     * Returns the raw JSON value of [activities].
     *
     * Unlike [activities], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("activities")
    @ExcludeMissing
    fun _activities(): JsonField<List<MessageActivity>> = activities

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [pagination].
     *
     * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("pagination")
    @ExcludeMissing
    fun _pagination(): JsonField<PaginationMeta> = pagination

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

        /** Returns a mutable builder for constructing an instance of [MessageActivities]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageActivities]. */
    class Builder internal constructor() {

        private var activities: JsonField<MutableList<MessageActivity>>? = null
        private var messageId: JsonField<String> = JsonMissing.of()
        private var pagination: JsonField<PaginationMeta> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageActivities: MessageActivities) = apply {
            activities = messageActivities.activities.map { it.toMutableList() }
            messageId = messageActivities.messageId
            pagination = messageActivities.pagination
            additionalProperties = messageActivities.additionalProperties.toMutableMap()
        }

        /** List of activity events ordered by most recent first */
        fun activities(activities: List<MessageActivity>) = activities(JsonField.of(activities))

        /**
         * Sets [Builder.activities] to an arbitrary JSON value.
         *
         * You should usually call [Builder.activities] with a well-typed `List<MessageActivity>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun activities(activities: JsonField<List<MessageActivity>>) = apply {
            this.activities = activities.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageActivity] to [activities].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addActivity(activity: MessageActivity) = apply {
            activities =
                (activities ?: JsonField.of(mutableListOf())).also {
                    checkKnown("activities", it).add(activity)
                }
        }

        /** The message ID these activities belong to */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /** Pagination metadata for list responses */
        fun pagination(pagination: PaginationMeta) = pagination(JsonField.of(pagination))

        /**
         * Sets [Builder.pagination] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pagination] with a well-typed [PaginationMeta] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun pagination(pagination: JsonField<PaginationMeta>) = apply {
            this.pagination = pagination
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
         * Returns an immutable instance of [MessageActivities].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageActivities =
            MessageActivities(
                (activities ?: JsonMissing.of()).map { it.toImmutable() },
                messageId,
                pagination,
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
    fun validate(): MessageActivities = apply {
        if (validated) {
            return@apply
        }

        activities().ifPresent { it.forEach { it.validate() } }
        messageId()
        pagination().ifPresent { it.validate() }
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
        (activities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (pagination.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageActivities &&
            activities == other.activities &&
            messageId == other.messageId &&
            pagination == other.pagination &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(activities, messageId, pagination, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageActivities{activities=$activities, messageId=$messageId, pagination=$pagination, additionalProperties=$additionalProperties}"
}
