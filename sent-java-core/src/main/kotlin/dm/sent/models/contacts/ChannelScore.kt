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
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

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
        @JsonProperty("fail_score") @ExcludeMissing failScore: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("success_score")
        @ExcludeMissing
        successScore: JsonField<Int> = JsonMissing.of(),
    ) : this(channel, failScore, successScore, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * Percentage (0-100) of messages on this channel that ended in FAILED.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun failScore(): Optional<Int> = failScore.getOptional("fail_score")

    /**
     * Percentage (0-100) of messages on this channel that reached a successful terminal state:
     * SENT/DELIVERED/READ for outbound, RECEIVED for inbound.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
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
     * Unlike [successScore], this method doesn't throw if the JSON field has an unexpected type.
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
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** Percentage (0-100) of messages on this channel that ended in FAILED. */
        fun failScore(failScore: Int) = failScore(JsonField.of(failScore))

        /**
         * Sets [Builder.failScore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failScore] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun failScore(failScore: JsonField<Int>) = apply { this.failScore = failScore }

        /**
         * Percentage (0-100) of messages on this channel that reached a successful terminal state:
         * SENT/DELIVERED/READ for outbound, RECEIVED for inbound.
         */
        fun successScore(successScore: Int) = successScore(JsonField.of(successScore))

        /**
         * Sets [Builder.successScore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.successScore] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun successScore(successScore: JsonField<Int>) = apply { this.successScore = successScore }

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
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
