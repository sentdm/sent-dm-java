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
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Body of a call.initiated, call.answered, call.completed, call.failed or call.recording_ready
 * event. Which of them occurred is the envelope's event.
 *
 * Shaped like the message, inbound, template and channel payloads: account_id names the account the
 * event is about, channel names the channel, and updated_at is when the change happened on the
 * call, in the same yyyy-MM-ddTHH:mm:ssZ form. duration_seconds and price are added on
 * call.completed, reason on call.failed and recording_id on call.recording_ready; each is omitted
 * rather than sent as null when it does not apply.
 *
 * Casing is snake_case because these ride the same webhook stream customers already parse
 * message_id from; the question/answer contract is a separate surface and stays camelCase. Nothing
 * here is provider-shaped: no provider call id, no namespaced identity.
 */
class CallEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val callId: JsonField<String>,
    private val accountId: JsonField<String>,
    private val channel: JsonField<String>,
    private val durationSeconds: JsonField<Int>,
    private val number: JsonField<String>,
    private val price: JsonField<Double>,
    private val reason: JsonField<String>,
    private val recordingId: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("call_id") @ExcludeMissing callId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("duration_seconds")
        @ExcludeMissing
        durationSeconds: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recording_id")
        @ExcludeMissing
        recordingId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        callId,
        accountId,
        channel,
        durationSeconds,
        number,
        price,
        reason,
        recordingId,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * Sent's call id, the same one the customer saw on the first question.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun callId(): String = callId.getRequired("call_id")

    /**
     * The account the call belongs to: the key's own customer, or the sender profile it acted as.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * Always voice.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * How long the call lasted. Only on call.completed.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun durationSeconds(): Optional<Int> = durationSeconds.getOptional("duration_seconds")

    /**
     * The customer number that owns the call, in E.164 format.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun number(): Optional<String> = number.getOptional("number")

    /**
     * What the call was charged. Only on call.completed, and omitted there until billing has
     * recorded the charge.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun price(): Optional<Double> = price.getOptional("price")

    /**
     * The machine-readable reason the call did not complete. Only on call.failed, and omitted when
     * no reason was recorded.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * The recording that became available, the same id GET /v3/calls/{id}/recordings lists it
     * under. Only on call.recording_ready, which is sent once per recording.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun recordingId(): Optional<String> = recordingId.getOptional("recording_id")

    /**
     * When the change happened on the call, as opposed to when the event was emitted.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

    /**
     * Returns the raw JSON value of [callId].
     *
     * Unlike [callId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("call_id") @ExcludeMissing fun _callId(): JsonField<String> = callId

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
     * Returns the raw JSON value of [durationSeconds].
     *
     * Unlike [durationSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("duration_seconds")
    @ExcludeMissing
    fun _durationSeconds(): JsonField<Int> = durationSeconds

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Double> = price

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [recordingId].
     *
     * Unlike [recordingId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recording_id")
    @ExcludeMissing
    fun _recordingId(): JsonField<String> = recordingId

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
         * Returns a mutable builder for constructing an instance of [CallEventPayload].
         *
         * The following fields are required:
         * ```java
         * .callId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CallEventPayload]. */
    class Builder internal constructor() {

        private var callId: JsonField<String>? = null
        private var accountId: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var durationSeconds: JsonField<Int> = JsonMissing.of()
        private var number: JsonField<String> = JsonMissing.of()
        private var price: JsonField<Double> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var recordingId: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(callEventPayload: CallEventPayload) = apply {
            callId = callEventPayload.callId
            accountId = callEventPayload.accountId
            channel = callEventPayload.channel
            durationSeconds = callEventPayload.durationSeconds
            number = callEventPayload.number
            price = callEventPayload.price
            reason = callEventPayload.reason
            recordingId = callEventPayload.recordingId
            updatedAt = callEventPayload.updatedAt
            additionalProperties = callEventPayload.additionalProperties.toMutableMap()
        }

        /** Sent's call id, the same one the customer saw on the first question. */
        fun callId(callId: String) = callId(JsonField.of(callId))

        /**
         * Sets [Builder.callId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun callId(callId: JsonField<String>) = apply { this.callId = callId }

        /**
         * The account the call belongs to: the key's own customer, or the sender profile it acted
         * as.
         */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** Always voice. */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** How long the call lasted. Only on call.completed. */
        fun durationSeconds(durationSeconds: Int?) =
            durationSeconds(JsonField.ofNullable(durationSeconds))

        /**
         * Alias for [Builder.durationSeconds].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun durationSeconds(durationSeconds: Int) = durationSeconds(durationSeconds as Int?)

        /** Alias for calling [Builder.durationSeconds] with `durationSeconds.orElse(null)`. */
        fun durationSeconds(durationSeconds: Optional<Int>) =
            durationSeconds(durationSeconds.getOrNull())

        /**
         * Sets [Builder.durationSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.durationSeconds] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun durationSeconds(durationSeconds: JsonField<Int>) = apply {
            this.durationSeconds = durationSeconds
        }

        /** The customer number that owns the call, in E.164 format. */
        fun number(number: String) = number(JsonField.of(number))

        /**
         * Sets [Builder.number] to an arbitrary JSON value.
         *
         * You should usually call [Builder.number] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun number(number: JsonField<String>) = apply { this.number = number }

        /**
         * What the call was charged. Only on call.completed, and omitted there until billing has
         * recorded the charge.
         */
        fun price(price: Double?) = price(JsonField.ofNullable(price))

        /**
         * Alias for [Builder.price].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun price(price: Double) = price(price as Double?)

        /** Alias for calling [Builder.price] with `price.orElse(null)`. */
        fun price(price: Optional<Double>) = price(price.getOrNull())

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<Double>) = apply { this.price = price }

        /**
         * The machine-readable reason the call did not complete. Only on call.failed, and omitted
         * when no reason was recorded.
         */
        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        /**
         * The recording that became available, the same id GET /v3/calls/{id}/recordings lists it
         * under. Only on call.recording_ready, which is sent once per recording.
         */
        fun recordingId(recordingId: String?) = recordingId(JsonField.ofNullable(recordingId))

        /** Alias for calling [Builder.recordingId] with `recordingId.orElse(null)`. */
        fun recordingId(recordingId: Optional<String>) = recordingId(recordingId.getOrNull())

        /**
         * Sets [Builder.recordingId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recordingId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun recordingId(recordingId: JsonField<String>) = apply { this.recordingId = recordingId }

        /** When the change happened on the call, as opposed to when the event was emitted. */
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
         * Returns an immutable instance of [CallEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .callId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CallEventPayload =
            CallEventPayload(
                checkRequired("callId", callId),
                accountId,
                channel,
                durationSeconds,
                number,
                price,
                reason,
                recordingId,
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
    fun validate(): CallEventPayload = apply {
        if (validated) {
            return@apply
        }

        callId()
        accountId()
        channel()
        durationSeconds()
        number()
        price()
        reason()
        recordingId()
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
        (if (callId.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (durationSeconds.asKnown().isPresent) 1 else 0) +
            (if (number.asKnown().isPresent) 1 else 0) +
            (if (price.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (recordingId.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallEventPayload &&
            callId == other.callId &&
            accountId == other.accountId &&
            channel == other.channel &&
            durationSeconds == other.durationSeconds &&
            number == other.number &&
            price == other.price &&
            reason == other.reason &&
            recordingId == other.recordingId &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            callId,
            accountId,
            channel,
            durationSeconds,
            number,
            price,
            reason,
            recordingId,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CallEventPayload{callId=$callId, accountId=$accountId, channel=$channel, durationSeconds=$durationSeconds, number=$number, price=$price, reason=$reason, recordingId=$recordingId, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
