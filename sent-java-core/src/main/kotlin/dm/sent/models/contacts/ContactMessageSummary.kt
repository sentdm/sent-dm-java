// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContactMessageSummary
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val channelScores: JsonField<List<ChannelScore>>,
    private val channelsUsed: JsonField<List<String>>,
    private val contactId: JsonField<String>,
    private val firstMessageAt: JsonField<OffsetDateTime>,
    private val lastMessageAt: JsonField<OffsetDateTime>,
    private val messageCount: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("channel_scores")
        @ExcludeMissing
        channelScores: JsonField<List<ChannelScore>> = JsonMissing.of(),
        @JsonProperty("channels_used")
        @ExcludeMissing
        channelsUsed: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("contact_id") @ExcludeMissing contactId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("first_message_at")
        @ExcludeMissing
        firstMessageAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("last_message_at")
        @ExcludeMissing
        lastMessageAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("message_count")
        @ExcludeMissing
        messageCount: JsonField<Int> = JsonMissing.of(),
    ) : this(
        channelScores,
        channelsUsed,
        contactId,
        firstMessageAt,
        lastMessageAt,
        messageCount,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channelScores(): Optional<List<ChannelScore>> = channelScores.getOptional("channel_scores")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channelsUsed(): Optional<List<String>> = channelsUsed.getOptional("channels_used")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactId(): Optional<String> = contactId.getOptional("contact_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun firstMessageAt(): Optional<OffsetDateTime> = firstMessageAt.getOptional("first_message_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun lastMessageAt(): Optional<OffsetDateTime> = lastMessageAt.getOptional("last_message_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageCount(): Optional<Int> = messageCount.getOptional("message_count")

    /**
     * Returns the raw JSON value of [channelScores].
     *
     * Unlike [channelScores], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel_scores")
    @ExcludeMissing
    fun _channelScores(): JsonField<List<ChannelScore>> = channelScores

    /**
     * Returns the raw JSON value of [channelsUsed].
     *
     * Unlike [channelsUsed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channels_used")
    @ExcludeMissing
    fun _channelsUsed(): JsonField<List<String>> = channelsUsed

    /**
     * Returns the raw JSON value of [contactId].
     *
     * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact_id") @ExcludeMissing fun _contactId(): JsonField<String> = contactId

    /**
     * Returns the raw JSON value of [firstMessageAt].
     *
     * Unlike [firstMessageAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("first_message_at")
    @ExcludeMissing
    fun _firstMessageAt(): JsonField<OffsetDateTime> = firstMessageAt

    /**
     * Returns the raw JSON value of [lastMessageAt].
     *
     * Unlike [lastMessageAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("last_message_at")
    @ExcludeMissing
    fun _lastMessageAt(): JsonField<OffsetDateTime> = lastMessageAt

    /**
     * Returns the raw JSON value of [messageCount].
     *
     * Unlike [messageCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_count")
    @ExcludeMissing
    fun _messageCount(): JsonField<Int> = messageCount

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

        /** Returns a mutable builder for constructing an instance of [ContactMessageSummary]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactMessageSummary]. */
    class Builder internal constructor() {

        private var channelScores: JsonField<MutableList<ChannelScore>>? = null
        private var channelsUsed: JsonField<MutableList<String>>? = null
        private var contactId: JsonField<String> = JsonMissing.of()
        private var firstMessageAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastMessageAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var messageCount: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contactMessageSummary: ContactMessageSummary) = apply {
            channelScores = contactMessageSummary.channelScores.map { it.toMutableList() }
            channelsUsed = contactMessageSummary.channelsUsed.map { it.toMutableList() }
            contactId = contactMessageSummary.contactId
            firstMessageAt = contactMessageSummary.firstMessageAt
            lastMessageAt = contactMessageSummary.lastMessageAt
            messageCount = contactMessageSummary.messageCount
            additionalProperties = contactMessageSummary.additionalProperties.toMutableMap()
        }

        fun channelScores(channelScores: List<ChannelScore>) =
            channelScores(JsonField.of(channelScores))

        /**
         * Sets [Builder.channelScores] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelScores] with a well-typed `List<ChannelScore>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun channelScores(channelScores: JsonField<List<ChannelScore>>) = apply {
            this.channelScores = channelScores.map { it.toMutableList() }
        }

        /**
         * Adds a single [ChannelScore] to [channelScores].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChannelScore(channelScore: ChannelScore) = apply {
            channelScores =
                (channelScores ?: JsonField.of(mutableListOf())).also {
                    checkKnown("channelScores", it).add(channelScore)
                }
        }

        fun channelsUsed(channelsUsed: List<String>) = channelsUsed(JsonField.of(channelsUsed))

        /**
         * Sets [Builder.channelsUsed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelsUsed] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun channelsUsed(channelsUsed: JsonField<List<String>>) = apply {
            this.channelsUsed = channelsUsed.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [Builder.channelsUsed].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChannelsUsed(channelsUsed: String) = apply {
            this.channelsUsed =
                (this.channelsUsed ?: JsonField.of(mutableListOf())).also {
                    checkKnown("channelsUsed", it).add(channelsUsed)
                }
        }

        fun contactId(contactId: String) = contactId(JsonField.of(contactId))

        /**
         * Sets [Builder.contactId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactId(contactId: JsonField<String>) = apply { this.contactId = contactId }

        fun firstMessageAt(firstMessageAt: OffsetDateTime?) =
            firstMessageAt(JsonField.ofNullable(firstMessageAt))

        /** Alias for calling [Builder.firstMessageAt] with `firstMessageAt.orElse(null)`. */
        fun firstMessageAt(firstMessageAt: Optional<OffsetDateTime>) =
            firstMessageAt(firstMessageAt.getOrNull())

        /**
         * Sets [Builder.firstMessageAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.firstMessageAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun firstMessageAt(firstMessageAt: JsonField<OffsetDateTime>) = apply {
            this.firstMessageAt = firstMessageAt
        }

        fun lastMessageAt(lastMessageAt: OffsetDateTime?) =
            lastMessageAt(JsonField.ofNullable(lastMessageAt))

        /** Alias for calling [Builder.lastMessageAt] with `lastMessageAt.orElse(null)`. */
        fun lastMessageAt(lastMessageAt: Optional<OffsetDateTime>) =
            lastMessageAt(lastMessageAt.getOrNull())

        /**
         * Sets [Builder.lastMessageAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastMessageAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun lastMessageAt(lastMessageAt: JsonField<OffsetDateTime>) = apply {
            this.lastMessageAt = lastMessageAt
        }

        fun messageCount(messageCount: Int) = messageCount(JsonField.of(messageCount))

        /**
         * Sets [Builder.messageCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageCount] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageCount(messageCount: JsonField<Int>) = apply { this.messageCount = messageCount }

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
         * Returns an immutable instance of [ContactMessageSummary].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContactMessageSummary =
            ContactMessageSummary(
                (channelScores ?: JsonMissing.of()).map { it.toImmutable() },
                (channelsUsed ?: JsonMissing.of()).map { it.toImmutable() },
                contactId,
                firstMessageAt,
                lastMessageAt,
                messageCount,
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
    fun validate(): ContactMessageSummary = apply {
        if (validated) {
            return@apply
        }

        channelScores().ifPresent { it.forEach { it.validate() } }
        channelsUsed()
        contactId()
        firstMessageAt()
        lastMessageAt()
        messageCount()
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
        (channelScores.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (channelsUsed.asKnown().getOrNull()?.size ?: 0) +
            (if (contactId.asKnown().isPresent) 1 else 0) +
            (if (firstMessageAt.asKnown().isPresent) 1 else 0) +
            (if (lastMessageAt.asKnown().isPresent) 1 else 0) +
            (if (messageCount.asKnown().isPresent) 1 else 0)

    class ChannelScore
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val channel: JsonField<String>,
        private val failScore: JsonField<Int>,
        private val successScore: JsonField<Int>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fail_score")
            @ExcludeMissing
            failScore: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("success_score")
            @ExcludeMissing
            successScore: JsonField<Int> = JsonMissing.of(),
        ) : this(channel, failScore, successScore, mutableMapOf())

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channel(): Optional<String> = channel.getOptional("channel")

        /**
         * Percentage (0-100) of messages on this channel that ended in FAILED.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun failScore(): Optional<Int> = failScore.getOptional("fail_score")

        /**
         * Percentage (0-100) of messages on this channel that reached a successful terminal state:
         * SENT/DELIVERED/READ for outbound, RECEIVED for inbound.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun successScore(): Optional<Int> = successScore.getOptional("success_score")

        /**
         * Returns the raw JSON value of [channel].
         *
         * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

        /**
         * Returns the raw JSON value of [failScore].
         *
         * Unlike [failScore], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fail_score") @ExcludeMissing fun _failScore(): JsonField<Int> = failScore

        /**
         * Returns the raw JSON value of [successScore].
         *
         * Unlike [successScore], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("success_score")
        @ExcludeMissing
        fun _successScore(): JsonField<Int> = successScore

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

            /** Returns a mutable builder for constructing an instance of [ChannelScore]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ChannelScore]. */
        class Builder internal constructor() {

            private var channel: JsonField<String> = JsonMissing.of()
            private var failScore: JsonField<Int> = JsonMissing.of()
            private var successScore: JsonField<Int> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(channelScore: ChannelScore) = apply {
                channel = channelScore.channel
                failScore = channelScore.failScore
                successScore = channelScore.successScore
                additionalProperties = channelScore.additionalProperties.toMutableMap()
            }

            fun channel(channel: String) = channel(JsonField.of(channel))

            /**
             * Sets [Builder.channel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channel] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channel(channel: JsonField<String>) = apply { this.channel = channel }

            /** Percentage (0-100) of messages on this channel that ended in FAILED. */
            fun failScore(failScore: Int) = failScore(JsonField.of(failScore))

            /**
             * Sets [Builder.failScore] to an arbitrary JSON value.
             *
             * You should usually call [Builder.failScore] with a well-typed [Int] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun failScore(failScore: JsonField<Int>) = apply { this.failScore = failScore }

            /**
             * Percentage (0-100) of messages on this channel that reached a successful terminal
             * state: SENT/DELIVERED/READ for outbound, RECEIVED for inbound.
             */
            fun successScore(successScore: Int) = successScore(JsonField.of(successScore))

            /**
             * Sets [Builder.successScore] to an arbitrary JSON value.
             *
             * You should usually call [Builder.successScore] with a well-typed [Int] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun successScore(successScore: JsonField<Int>) = apply {
                this.successScore = successScore
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
             * Returns an immutable instance of [ChannelScore].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ChannelScore =
                ChannelScore(channel, failScore, successScore, additionalProperties.toMutableMap())
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
        fun validate(): ChannelScore = apply {
            if (validated) {
                return@apply
            }

            channel()
            failScore()
            successScore()
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
            (if (channel.asKnown().isPresent) 1 else 0) +
                (if (failScore.asKnown().isPresent) 1 else 0) +
                (if (successScore.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ChannelScore &&
                channel == other.channel &&
                failScore == other.failScore &&
                successScore == other.successScore &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(channel, failScore, successScore, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ChannelScore{channel=$channel, failScore=$failScore, successScore=$successScore, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactMessageSummary &&
            channelScores == other.channelScores &&
            channelsUsed == other.channelsUsed &&
            contactId == other.contactId &&
            firstMessageAt == other.firstMessageAt &&
            lastMessageAt == other.lastMessageAt &&
            messageCount == other.messageCount &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            channelScores,
            channelsUsed,
            contactId,
            firstMessageAt,
            lastMessageAt,
            messageCount,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContactMessageSummary{channelScores=$channelScores, channelsUsed=$channelsUsed, contactId=$contactId, firstMessageAt=$firstMessageAt, lastMessageAt=$lastMessageAt, messageCount=$messageCount, additionalProperties=$additionalProperties}"
}
