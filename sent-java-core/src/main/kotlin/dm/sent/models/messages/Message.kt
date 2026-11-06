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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Message response for v3 API — same shape as v2 with snake_case JSON conventions.
 *
 * The shape of a message that was sent immediately: it never has a scheduled_at key. A message that
 * is or was held for a later instant is a ScheduledMessageResponse, and the endpoint decides which
 * of the two to answer with. From always returns this type.
 */
class Message
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val activeContactPrice: JsonField<Double>,
    private val channel: JsonField<String>,
    private val contactId: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customerId: JsonField<String>,
    private val direction: JsonField<String>,
    private val events: JsonField<List<MessageStatusEvent>>,
    private val messageBody: JsonField<MessageBody>,
    private val phone: JsonField<String>,
    private val phoneInternational: JsonField<String>,
    private val price: JsonField<Double>,
    private val reason: JsonField<String>,
    private val reasonCode: JsonField<String>,
    private val regionCode: JsonField<String>,
    private val status: JsonField<String>,
    private val templateCategory: JsonField<String>,
    private val templateId: JsonField<String>,
    private val templateName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("active_contact_price")
        @ExcludeMissing
        activeContactPrice: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contact_id") @ExcludeMissing contactId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("customer_id")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("direction") @ExcludeMissing direction: JsonField<String> = JsonMissing.of(),
        @JsonProperty("events")
        @ExcludeMissing
        events: JsonField<List<MessageStatusEvent>> = JsonMissing.of(),
        @JsonProperty("message_body")
        @ExcludeMissing
        messageBody: JsonField<MessageBody> = JsonMissing.of(),
        @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_international")
        @ExcludeMissing
        phoneInternational: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason_code")
        @ExcludeMissing
        reasonCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("region_code")
        @ExcludeMissing
        regionCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_category")
        @ExcludeMissing
        templateCategory: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_id")
        @ExcludeMissing
        templateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_name")
        @ExcludeMissing
        templateName: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        activeContactPrice,
        channel,
        contactId,
        createdAt,
        customerId,
        direction,
        events,
        messageBody,
        phone,
        phoneInternational,
        price,
        reason,
        reasonCode,
        regionCode,
        status,
        templateCategory,
        templateId,
        templateName,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun activeContactPrice(): Optional<Double> =
        activeContactPrice.getOptional("active_contact_price")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactId(): Optional<String> = contactId.getOptional("contact_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customer_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun direction(): Optional<String> = direction.getOptional("direction")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun events(): Optional<List<MessageStatusEvent>> = events.getOptional("events")

    /**
     * Structured message body format for database storage. Preserves channel-specific components
     * (header, header media, body, footer, buttons, MMS subject and media).
     *
     * Persisted as the messageBody jsonb column on Messages. Every write path goes through
     * MessageUtils.MessageBodyJsonOptions, which writes nulls, so the envelope shape is stable
     * regardless of channel or status. Anything that rebuilds this object field by field — the four
     * IMessageBodyStrategy implementations and MessageUtils.BuildSegmentBody — has to carry every
     * member, or that member is silently dropped on whichever path forgot it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageBody(): Optional<MessageBody> = messageBody.getOptional("message_body")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phone(): Optional<String> = phone.getOptional("phone")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneInternational(): Optional<String> =
        phoneInternational.getOptional("phone_international")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun price(): Optional<Double> = price.getOptional("price")

    /**
     * A human-readable sentence for reason_code, for example "Insufficient balance". Omitted
     * whenever reason_code is.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * Why the message is at its current status, as a stable platform code such as DELIVERY_007,
     * BUSINESS_003 or DELIVERY_003. Present when the current status is FAILED, FILTERED or BLOCKED
     * and the lifecycle was loaded; omitted otherwise. Switch on this rather than on reason: the
     * code is stable, the wording may be improved. It is the platform's classification of the
     * outcome, never a carrier or vendor code.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reasonCode(): Optional<String> = reasonCode.getOptional("reason_code")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun regionCode(): Optional<String> = regionCode.getOptional("region_code")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateCategory(): Optional<String> = templateCategory.getOptional("template_category")

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
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [activeContactPrice].
     *
     * Unlike [activeContactPrice], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("active_contact_price")
    @ExcludeMissing
    fun _activeContactPrice(): JsonField<Double> = activeContactPrice

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [contactId].
     *
     * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact_id") @ExcludeMissing fun _contactId(): JsonField<String> = contactId

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customer_id") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [direction].
     *
     * Unlike [direction], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("direction") @ExcludeMissing fun _direction(): JsonField<String> = direction

    /**
     * Returns the raw JSON value of [events].
     *
     * Unlike [events], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("events")
    @ExcludeMissing
    fun _events(): JsonField<List<MessageStatusEvent>> = events

    /**
     * Returns the raw JSON value of [messageBody].
     *
     * Unlike [messageBody], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_body")
    @ExcludeMissing
    fun _messageBody(): JsonField<MessageBody> = messageBody

    /**
     * Returns the raw JSON value of [phone].
     *
     * Unlike [phone], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

    /**
     * Returns the raw JSON value of [phoneInternational].
     *
     * Unlike [phoneInternational], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("phone_international")
    @ExcludeMissing
    fun _phoneInternational(): JsonField<String> = phoneInternational

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
     * Returns the raw JSON value of [reasonCode].
     *
     * Unlike [reasonCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason_code") @ExcludeMissing fun _reasonCode(): JsonField<String> = reasonCode

    /**
     * Returns the raw JSON value of [regionCode].
     *
     * Unlike [regionCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("region_code") @ExcludeMissing fun _regionCode(): JsonField<String> = regionCode

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [templateCategory].
     *
     * Unlike [templateCategory], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("template_category")
    @ExcludeMissing
    fun _templateCategory(): JsonField<String> = templateCategory

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

        /** Returns a mutable builder for constructing an instance of [Message]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Message]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var activeContactPrice: JsonField<Double> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var contactId: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
        private var direction: JsonField<String> = JsonMissing.of()
        private var events: JsonField<MutableList<MessageStatusEvent>>? = null
        private var messageBody: JsonField<MessageBody> = JsonMissing.of()
        private var phone: JsonField<String> = JsonMissing.of()
        private var phoneInternational: JsonField<String> = JsonMissing.of()
        private var price: JsonField<Double> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var reasonCode: JsonField<String> = JsonMissing.of()
        private var regionCode: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var templateCategory: JsonField<String> = JsonMissing.of()
        private var templateId: JsonField<String> = JsonMissing.of()
        private var templateName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(message: Message) = apply {
            id = message.id
            activeContactPrice = message.activeContactPrice
            channel = message.channel
            contactId = message.contactId
            createdAt = message.createdAt
            customerId = message.customerId
            direction = message.direction
            events = message.events.map { it.toMutableList() }
            messageBody = message.messageBody
            phone = message.phone
            phoneInternational = message.phoneInternational
            price = message.price
            reason = message.reason
            reasonCode = message.reasonCode
            regionCode = message.regionCode
            status = message.status
            templateCategory = message.templateCategory
            templateId = message.templateId
            templateName = message.templateName
            additionalProperties = message.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun activeContactPrice(activeContactPrice: Double?) =
            activeContactPrice(JsonField.ofNullable(activeContactPrice))

        /**
         * Alias for [Builder.activeContactPrice].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun activeContactPrice(activeContactPrice: Double) =
            activeContactPrice(activeContactPrice as Double?)

        /**
         * Alias for calling [Builder.activeContactPrice] with `activeContactPrice.orElse(null)`.
         */
        fun activeContactPrice(activeContactPrice: Optional<Double>) =
            activeContactPrice(activeContactPrice.getOrNull())

        /**
         * Sets [Builder.activeContactPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.activeContactPrice] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun activeContactPrice(activeContactPrice: JsonField<Double>) = apply {
            this.activeContactPrice = activeContactPrice
        }

        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        fun contactId(contactId: String) = contactId(JsonField.of(contactId))

        /**
         * Sets [Builder.contactId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactId(contactId: JsonField<String>) = apply { this.contactId = contactId }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun customerId(customerId: String) = customerId(JsonField.of(customerId))

        /**
         * Sets [Builder.customerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

        fun direction(direction: String) = direction(JsonField.of(direction))

        /**
         * Sets [Builder.direction] to an arbitrary JSON value.
         *
         * You should usually call [Builder.direction] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun direction(direction: JsonField<String>) = apply { this.direction = direction }

        fun events(events: List<MessageStatusEvent>?) = events(JsonField.ofNullable(events))

        /** Alias for calling [Builder.events] with `events.orElse(null)`. */
        fun events(events: Optional<List<MessageStatusEvent>>) = events(events.getOrNull())

        /**
         * Sets [Builder.events] to an arbitrary JSON value.
         *
         * You should usually call [Builder.events] with a well-typed `List<MessageStatusEvent>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun events(events: JsonField<List<MessageStatusEvent>>) = apply {
            this.events = events.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageStatusEvent] to [events].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEvent(event: MessageStatusEvent) = apply {
            events =
                (events ?: JsonField.of(mutableListOf())).also {
                    checkKnown("events", it).add(event)
                }
        }

        /**
         * Structured message body format for database storage. Preserves channel-specific
         * components (header, header media, body, footer, buttons, MMS subject and media).
         *
         * Persisted as the messageBody jsonb column on Messages. Every write path goes through
         * MessageUtils.MessageBodyJsonOptions, which writes nulls, so the envelope shape is stable
         * regardless of channel or status. Anything that rebuilds this object field by field — the
         * four IMessageBodyStrategy implementations and MessageUtils.BuildSegmentBody — has to
         * carry every member, or that member is silently dropped on whichever path forgot it.
         */
        fun messageBody(messageBody: MessageBody?) = messageBody(JsonField.ofNullable(messageBody))

        /** Alias for calling [Builder.messageBody] with `messageBody.orElse(null)`. */
        fun messageBody(messageBody: Optional<MessageBody>) = messageBody(messageBody.getOrNull())

        /**
         * Sets [Builder.messageBody] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageBody] with a well-typed [MessageBody] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun messageBody(messageBody: JsonField<MessageBody>) = apply {
            this.messageBody = messageBody
        }

        fun phone(phone: String) = phone(JsonField.of(phone))

        /**
         * Sets [Builder.phone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun phone(phone: JsonField<String>) = apply { this.phone = phone }

        fun phoneInternational(phoneInternational: String) =
            phoneInternational(JsonField.of(phoneInternational))

        /**
         * Sets [Builder.phoneInternational] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneInternational] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun phoneInternational(phoneInternational: JsonField<String>) = apply {
            this.phoneInternational = phoneInternational
        }

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
         * A human-readable sentence for reason_code, for example "Insufficient balance". Omitted
         * whenever reason_code is.
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
         * Why the message is at its current status, as a stable platform code such as DELIVERY_007,
         * BUSINESS_003 or DELIVERY_003. Present when the current status is FAILED, FILTERED or
         * BLOCKED and the lifecycle was loaded; omitted otherwise. Switch on this rather than on
         * reason: the code is stable, the wording may be improved. It is the platform's
         * classification of the outcome, never a carrier or vendor code.
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

        fun regionCode(regionCode: String) = regionCode(JsonField.of(regionCode))

        /**
         * Sets [Builder.regionCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.regionCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun regionCode(regionCode: JsonField<String>) = apply { this.regionCode = regionCode }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun templateCategory(templateCategory: String?) =
            templateCategory(JsonField.ofNullable(templateCategory))

        /** Alias for calling [Builder.templateCategory] with `templateCategory.orElse(null)`. */
        fun templateCategory(templateCategory: Optional<String>) =
            templateCategory(templateCategory.getOrNull())

        /**
         * Sets [Builder.templateCategory] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateCategory] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun templateCategory(templateCategory: JsonField<String>) = apply {
            this.templateCategory = templateCategory
        }

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
         * Returns an immutable instance of [Message].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Message =
            Message(
                id,
                activeContactPrice,
                channel,
                contactId,
                createdAt,
                customerId,
                direction,
                (events ?: JsonMissing.of()).map { it.toImmutable() },
                messageBody,
                phone,
                phoneInternational,
                price,
                reason,
                reasonCode,
                regionCode,
                status,
                templateCategory,
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
    fun validate(): Message = apply {
        if (validated) {
            return@apply
        }

        id()
        activeContactPrice()
        channel()
        contactId()
        createdAt()
        customerId()
        direction()
        events().ifPresent { it.forEach { it.validate() } }
        messageBody().ifPresent { it.validate() }
        phone()
        phoneInternational()
        price()
        reason()
        reasonCode()
        regionCode()
        status()
        templateCategory()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (activeContactPrice.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (contactId.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (if (direction.asKnown().isPresent) 1 else 0) +
            (events.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (messageBody.asKnown().getOrNull()?.validity() ?: 0) +
            (if (phone.asKnown().isPresent) 1 else 0) +
            (if (phoneInternational.asKnown().isPresent) 1 else 0) +
            (if (price.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (reasonCode.asKnown().isPresent) 1 else 0) +
            (if (regionCode.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (templateCategory.asKnown().isPresent) 1 else 0) +
            (if (templateId.asKnown().isPresent) 1 else 0) +
            (if (templateName.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Message &&
            id == other.id &&
            activeContactPrice == other.activeContactPrice &&
            channel == other.channel &&
            contactId == other.contactId &&
            createdAt == other.createdAt &&
            customerId == other.customerId &&
            direction == other.direction &&
            events == other.events &&
            messageBody == other.messageBody &&
            phone == other.phone &&
            phoneInternational == other.phoneInternational &&
            price == other.price &&
            reason == other.reason &&
            reasonCode == other.reasonCode &&
            regionCode == other.regionCode &&
            status == other.status &&
            templateCategory == other.templateCategory &&
            templateId == other.templateId &&
            templateName == other.templateName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            activeContactPrice,
            channel,
            contactId,
            createdAt,
            customerId,
            direction,
            events,
            messageBody,
            phone,
            phoneInternational,
            price,
            reason,
            reasonCode,
            regionCode,
            status,
            templateCategory,
            templateId,
            templateName,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Message{id=$id, activeContactPrice=$activeContactPrice, channel=$channel, contactId=$contactId, createdAt=$createdAt, customerId=$customerId, direction=$direction, events=$events, messageBody=$messageBody, phone=$phone, phoneInternational=$phoneInternational, price=$price, reason=$reason, reasonCode=$reasonCode, regionCode=$regionCode, status=$status, templateCategory=$templateCategory, templateId=$templateId, templateName=$templateName, additionalProperties=$additionalProperties}"
}
