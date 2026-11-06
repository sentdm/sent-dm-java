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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A single message activity event for v3 API.
 *
 * The activity list mixes statuses, so unlike a message it is one shape rather than two: a
 * SCHEDULED entry carries scheduled_at, and every other entry has no such key.
 */
class MessageActivity
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val activeContactPrice: JsonField<String>,
    private val description: JsonField<String>,
    private val from: JsonField<String>,
    private val price: JsonField<String>,
    private val reason: JsonField<String>,
    private val reasonCode: JsonField<String>,
    private val scheduledAt: JsonField<OffsetDateTime>,
    private val status: JsonField<String>,
    private val timestamp: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("active_contact_price")
        @ExcludeMissing
        activeContactPrice: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason_code")
        @ExcludeMissing
        reasonCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timestamp")
        @ExcludeMissing
        timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        activeContactPrice,
        description,
        from,
        price,
        reason,
        reasonCode,
        scheduledAt,
        status,
        timestamp,
        mutableMapOf(),
    )

    /**
     * Active contact markup applied on top of the channel cost, formatted to 4 decimal places.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun activeContactPrice(): Optional<String> =
        activeContactPrice.getOptional("active_contact_price")

    /**
     * Human-readable description of the activity
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Sender phone number for this activity (the customer's sending number for outbound, the
     * external sender for inbound). Null when not reported by the provider.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun from(): Optional<String> = from.getOptional("from")

    /**
     * Channel cost for this activity (e.g., SMS/WhatsApp provider cost), formatted to 4 decimal
     * places.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun price(): Optional<String> = price.getOptional("price")

    /**
     * A human-readable sentence for reason_code, for example "The recipient is not registered on
     * this channel" Omitted whenever reason_code is.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Why the message reached this status, as a stable platform code such as DELIVERY_007 or
     * BUSINESS_003. Present on FAILED, FILTERED and BLOCKED activities; omitted on every status
     * that needs no explanation. Switch on this rather than on reason: the code is stable, the
     * wording may be improved. Same wire name and vocabulary as on the message and the webhook.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reasonCode(): Optional<String> = reasonCode.getOptional("reason_code")

    /**
     * SCHEDULED and CANCELLED activities only, in UTC: on a SCHEDULED entry, when the held message
     * will be released for delivery; on a CANCELLED entry, the instant that was called off. Same
     * wire name as on the send response, the message and the webhook. Omitted on every other
     * activity. A message that quiet hours moved at release has two SCHEDULED entries, each
     * carrying the instant as it stood at that moment.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun scheduledAt(): Optional<OffsetDateTime> = scheduledAt.getOptional("scheduled_at")

    /**
     * Activity status. Outbound: QUEUED, PROCESSED, ROUTED, SCHEDULED, SENT, DELIVERED, READ,
     * FAILED. Inbound (from contact): RECEIVED (terminal).
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * When this activity occurred
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

    /**
     * Returns the raw JSON value of [activeContactPrice].
     *
     * Unlike [activeContactPrice], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("active_contact_price")
    @ExcludeMissing
    fun _activeContactPrice(): JsonField<String> = activeContactPrice

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [from].
     *
     * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<String> = price

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [reasonCode].
     *
     * Unlike [reasonCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason_code") @ExcludeMissing fun _reasonCode(): JsonField<String> = reasonCode

    /**
     * Returns the raw JSON value of [scheduledAt].
     *
     * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("scheduled_at")
    @ExcludeMissing
    fun _scheduledAt(): JsonField<OffsetDateTime> = scheduledAt

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [timestamp].
     *
     * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timestamp")
    @ExcludeMissing
    fun _timestamp(): JsonField<OffsetDateTime> = timestamp

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

        /** Returns a mutable builder for constructing an instance of [MessageActivity]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageActivity]. */
    class Builder internal constructor() {

        private var activeContactPrice: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var from: JsonField<String> = JsonMissing.of()
        private var price: JsonField<String> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var reasonCode: JsonField<String> = JsonMissing.of()
        private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageActivity: MessageActivity) = apply {
            activeContactPrice = messageActivity.activeContactPrice
            description = messageActivity.description
            from = messageActivity.from
            price = messageActivity.price
            reason = messageActivity.reason
            reasonCode = messageActivity.reasonCode
            scheduledAt = messageActivity.scheduledAt
            status = messageActivity.status
            timestamp = messageActivity.timestamp
            additionalProperties = messageActivity.additionalProperties.toMutableMap()
        }

        /**
         * Active contact markup applied on top of the channel cost, formatted to 4 decimal places.
         */
        fun activeContactPrice(activeContactPrice: String?) =
            activeContactPrice(JsonField.ofNullable(activeContactPrice))

        /**
         * Alias for calling [Builder.activeContactPrice] with `activeContactPrice.orElse(null)`.
         */
        fun activeContactPrice(activeContactPrice: Optional<String>) =
            activeContactPrice(activeContactPrice.getOrNull())

        /**
         * Sets [Builder.activeContactPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.activeContactPrice] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun activeContactPrice(activeContactPrice: JsonField<String>) = apply {
            this.activeContactPrice = activeContactPrice
        }

        /** Human-readable description of the activity */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /**
         * Sender phone number for this activity (the customer's sending number for outbound, the
         * external sender for inbound). Null when not reported by the provider.
         */
        fun from(from: String?) = from(JsonField.ofNullable(from))

        /** Alias for calling [Builder.from] with `from.orElse(null)`. */
        fun from(from: Optional<String>) = from(from.getOrNull())

        /**
         * Sets [Builder.from] to an arbitrary JSON value.
         *
         * You should usually call [Builder.from] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun from(from: JsonField<String>) = apply { this.from = from }

        /**
         * Channel cost for this activity (e.g., SMS/WhatsApp provider cost), formatted to 4 decimal
         * places.
         */
        fun price(price: String?) = price(JsonField.ofNullable(price))

        /** Alias for calling [Builder.price] with `price.orElse(null)`. */
        fun price(price: Optional<String>) = price(price.getOrNull())

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<String>) = apply { this.price = price }

        /**
         * A human-readable sentence for reason_code, for example "The recipient is not registered
         * on this channel" Omitted whenever reason_code is.
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
         * Why the message reached this status, as a stable platform code such as DELIVERY_007 or
         * BUSINESS_003. Present on FAILED, FILTERED and BLOCKED activities; omitted on every status
         * that needs no explanation. Switch on this rather than on reason: the code is stable, the
         * wording may be improved. Same wire name and vocabulary as on the message and the webhook.
         */
        fun reasonCode(reasonCode: String?) = reasonCode(JsonField.ofNullable(reasonCode))

        /** Alias for calling [Builder.reasonCode] with `reasonCode.orElse(null)`. */
        fun reasonCode(reasonCode: Optional<String>) = reasonCode(reasonCode.getOrNull())

        /**
         * Sets [Builder.reasonCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasonCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reasonCode(reasonCode: JsonField<String>) = apply { this.reasonCode = reasonCode }

        /**
         * SCHEDULED and CANCELLED activities only, in UTC: on a SCHEDULED entry, when the held
         * message will be released for delivery; on a CANCELLED entry, the instant that was called
         * off. Same wire name as on the send response, the message and the webhook. Omitted on
         * every other activity. A message that quiet hours moved at release has two SCHEDULED
         * entries, each carrying the instant as it stood at that moment.
         */
        fun scheduledAt(scheduledAt: OffsetDateTime?) =
            scheduledAt(JsonField.ofNullable(scheduledAt))

        /** Alias for calling [Builder.scheduledAt] with `scheduledAt.orElse(null)`. */
        fun scheduledAt(scheduledAt: Optional<OffsetDateTime>) =
            scheduledAt(scheduledAt.getOrNull())

        /**
         * Sets [Builder.scheduledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
            this.scheduledAt = scheduledAt
        }

        /**
         * Activity status. Outbound: QUEUED, PROCESSED, ROUTED, SCHEDULED, SENT, DELIVERED, READ,
         * FAILED. Inbound (from contact): RECEIVED (terminal).
         */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** When this activity occurred */
        fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

        /**
         * Sets [Builder.timestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply { this.timestamp = timestamp }

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
         * Returns an immutable instance of [MessageActivity].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageActivity =
            MessageActivity(
                activeContactPrice,
                description,
                from,
                price,
                reason,
                reasonCode,
                scheduledAt,
                status,
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
    fun validate(): MessageActivity = apply {
        if (validated) {
            return@apply
        }

        activeContactPrice()
        description()
        from()
        price()
        reason()
        reasonCode()
        scheduledAt()
        status()
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
        (if (activeContactPrice.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (from.asKnown().isPresent) 1 else 0) +
            (if (price.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (reasonCode.asKnown().isPresent) 1 else 0) +
            (if (scheduledAt.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (timestamp.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageActivity &&
            activeContactPrice == other.activeContactPrice &&
            description == other.description &&
            from == other.from &&
            price == other.price &&
            reason == other.reason &&
            reasonCode == other.reasonCode &&
            scheduledAt == other.scheduledAt &&
            status == other.status &&
            timestamp == other.timestamp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            activeContactPrice,
            description,
            from,
            price,
            reason,
            reasonCode,
            scheduledAt,
            status,
            timestamp,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageActivity{activeContactPrice=$activeContactPrice, description=$description, from=$from, price=$price, reason=$reason, reasonCode=$reasonCode, scheduledAt=$scheduledAt, status=$status, timestamp=$timestamp, additionalProperties=$additionalProperties}"
}
