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
import dm.sent.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents a sent message with comprehensive delivery and template information (v2) */
class MessageRetrieveResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val channel: JsonField<String>,
    private val contactId: JsonField<String>,
    private val correctedPrice: JsonField<Double>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val customerId: JsonField<String>,
    private val events: JsonField<List<Event>>,
    private val messageBody: JsonField<MessageBody>,
    private val phoneNumber: JsonField<String>,
    private val phoneNumberInternational: JsonField<String>,
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
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contactId") @ExcludeMissing contactId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("correctedPrice")
        @ExcludeMissing
        correctedPrice: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("customerId")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("events") @ExcludeMissing events: JsonField<List<Event>> = JsonMissing.of(),
        @JsonProperty("messageBody")
        @ExcludeMissing
        messageBody: JsonField<MessageBody> = JsonMissing.of(),
        @JsonProperty("phoneNumber")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phoneNumberInternational")
        @ExcludeMissing
        phoneNumberInternational: JsonField<String> = JsonMissing.of(),
        @JsonProperty("regionCode")
        @ExcludeMissing
        regionCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("templateCategory")
        @ExcludeMissing
        templateCategory: JsonField<String> = JsonMissing.of(),
        @JsonProperty("templateId")
        @ExcludeMissing
        templateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("templateName")
        @ExcludeMissing
        templateName: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        channel,
        contactId,
        correctedPrice,
        createdAt,
        customerId,
        events,
        messageBody,
        phoneNumber,
        phoneNumberInternational,
        regionCode,
        status,
        templateCategory,
        templateId,
        templateName,
        mutableMapOf(),
    )

    /**
     * The unique identifier of the message
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * The messaging channel used (e.g., SMS, WhatsApp)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * The unique identifier of the contact who received the message
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun contactId(): Optional<String> = contactId.getOptional("contactId")

    /**
     * The final price charged for sending this message
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun correctedPrice(): Optional<Double> = correctedPrice.getOptional("correctedPrice")

    /**
     * The date and time when the message was created
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * The unique identifier of the customer who sent the message
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customerId")

    /**
     * A chronological list of status change events for this message. Each event includes a status
     * and timestamp, following industry standards (Twilio, SendGrid, Mailgun). Events are ordered
     * chronologically from oldest to newest.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun events(): Optional<List<Event>> = events.getOptional("events")

    /**
     * The message body content with variables substituted
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun messageBody(): Optional<MessageBody> = messageBody.getOptional("messageBody")

    /**
     * The phone number of the recipient (E.164 format)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phoneNumber")

    /**
     * The phone number in international format
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phoneNumberInternational(): Optional<String> =
        phoneNumberInternational.getOptional("phoneNumberInternational")

    /**
     * The region code of the phone number (e.g., US, GB, DE)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun regionCode(): Optional<String> = regionCode.getOptional("regionCode")

    /**
     * The delivery status of the message (e.g., sent, delivered, failed, read)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * The category of the template (e.g., MARKETING, UTILITY, AUTHENTICATION)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun templateCategory(): Optional<String> = templateCategory.getOptional("templateCategory")

    /**
     * The unique identifier of the template used for this message (null if no template was used)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun templateId(): Optional<String> = templateId.getOptional("templateId")

    /**
     * The display name of the template
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun templateName(): Optional<String> = templateName.getOptional("templateName")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
    @JsonProperty("contactId") @ExcludeMissing fun _contactId(): JsonField<String> = contactId

    /**
     * Returns the raw JSON value of [correctedPrice].
     *
     * Unlike [correctedPrice], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("correctedPrice")
    @ExcludeMissing
    fun _correctedPrice(): JsonField<Double> = correctedPrice

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customerId") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [events].
     *
     * Unlike [events], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("events") @ExcludeMissing fun _events(): JsonField<List<Event>> = events

    /**
     * Returns the raw JSON value of [messageBody].
     *
     * Unlike [messageBody], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("messageBody")
    @ExcludeMissing
    fun _messageBody(): JsonField<MessageBody> = messageBody

    /**
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phoneNumber") @ExcludeMissing fun _phoneNumber(): JsonField<String> = phoneNumber

    /**
     * Returns the raw JSON value of [phoneNumberInternational].
     *
     * Unlike [phoneNumberInternational], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("phoneNumberInternational")
    @ExcludeMissing
    fun _phoneNumberInternational(): JsonField<String> = phoneNumberInternational

    /**
     * Returns the raw JSON value of [regionCode].
     *
     * Unlike [regionCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("regionCode") @ExcludeMissing fun _regionCode(): JsonField<String> = regionCode

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
    @JsonProperty("templateCategory")
    @ExcludeMissing
    fun _templateCategory(): JsonField<String> = templateCategory

    /**
     * Returns the raw JSON value of [templateId].
     *
     * Unlike [templateId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("templateId") @ExcludeMissing fun _templateId(): JsonField<String> = templateId

    /**
     * Returns the raw JSON value of [templateName].
     *
     * Unlike [templateName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("templateName")
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

        /** Returns a mutable builder for constructing an instance of [MessageRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageRetrieveResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var contactId: JsonField<String> = JsonMissing.of()
        private var correctedPrice: JsonField<Double> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
        private var events: JsonField<MutableList<Event>>? = null
        private var messageBody: JsonField<MessageBody> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var phoneNumberInternational: JsonField<String> = JsonMissing.of()
        private var regionCode: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var templateCategory: JsonField<String> = JsonMissing.of()
        private var templateId: JsonField<String> = JsonMissing.of()
        private var templateName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageRetrieveResponse: MessageRetrieveResponse) = apply {
            id = messageRetrieveResponse.id
            channel = messageRetrieveResponse.channel
            contactId = messageRetrieveResponse.contactId
            correctedPrice = messageRetrieveResponse.correctedPrice
            createdAt = messageRetrieveResponse.createdAt
            customerId = messageRetrieveResponse.customerId
            events = messageRetrieveResponse.events.map { it.toMutableList() }
            messageBody = messageRetrieveResponse.messageBody
            phoneNumber = messageRetrieveResponse.phoneNumber
            phoneNumberInternational = messageRetrieveResponse.phoneNumberInternational
            regionCode = messageRetrieveResponse.regionCode
            status = messageRetrieveResponse.status
            templateCategory = messageRetrieveResponse.templateCategory
            templateId = messageRetrieveResponse.templateId
            templateName = messageRetrieveResponse.templateName
            additionalProperties = messageRetrieveResponse.additionalProperties.toMutableMap()
        }

        /** The unique identifier of the message */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The messaging channel used (e.g., SMS, WhatsApp) */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** The unique identifier of the contact who received the message */
        fun contactId(contactId: String) = contactId(JsonField.of(contactId))

        /**
         * Sets [Builder.contactId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactId(contactId: JsonField<String>) = apply { this.contactId = contactId }

        /** The final price charged for sending this message */
        fun correctedPrice(correctedPrice: Double?) =
            correctedPrice(JsonField.ofNullable(correctedPrice))

        /**
         * Alias for [Builder.correctedPrice].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun correctedPrice(correctedPrice: Double) = correctedPrice(correctedPrice as Double?)

        /** Alias for calling [Builder.correctedPrice] with `correctedPrice.orElse(null)`. */
        fun correctedPrice(correctedPrice: Optional<Double>) =
            correctedPrice(correctedPrice.getOrNull())

        /**
         * Sets [Builder.correctedPrice] to an arbitrary JSON value.
         *
         * You should usually call [Builder.correctedPrice] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun correctedPrice(correctedPrice: JsonField<Double>) = apply {
            this.correctedPrice = correctedPrice
        }

        /** The date and time when the message was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** The unique identifier of the customer who sent the message */
        fun customerId(customerId: String) = customerId(JsonField.of(customerId))

        /**
         * Sets [Builder.customerId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customerId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customerId(customerId: JsonField<String>) = apply { this.customerId = customerId }

        /**
         * A chronological list of status change events for this message. Each event includes a
         * status and timestamp, following industry standards (Twilio, SendGrid, Mailgun). Events
         * are ordered chronologically from oldest to newest.
         */
        fun events(events: List<Event>?) = events(JsonField.ofNullable(events))

        /** Alias for calling [Builder.events] with `events.orElse(null)`. */
        fun events(events: Optional<List<Event>>) = events(events.getOrNull())

        /**
         * Sets [Builder.events] to an arbitrary JSON value.
         *
         * You should usually call [Builder.events] with a well-typed `List<Event>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun events(events: JsonField<List<Event>>) = apply {
            this.events = events.map { it.toMutableList() }
        }

        /**
         * Adds a single [Event] to [events].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEvent(event: Event) = apply {
            events =
                (events ?: JsonField.of(mutableListOf())).also {
                    checkKnown("events", it).add(event)
                }
        }

        /** The message body content with variables substituted */
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

        /** The phone number of the recipient (E.164 format) */
        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /** The phone number in international format */
        fun phoneNumberInternational(phoneNumberInternational: String) =
            phoneNumberInternational(JsonField.of(phoneNumberInternational))

        /**
         * Sets [Builder.phoneNumberInternational] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumberInternational] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun phoneNumberInternational(phoneNumberInternational: JsonField<String>) = apply {
            this.phoneNumberInternational = phoneNumberInternational
        }

        /** The region code of the phone number (e.g., US, GB, DE) */
        fun regionCode(regionCode: String) = regionCode(JsonField.of(regionCode))

        /**
         * Sets [Builder.regionCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.regionCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun regionCode(regionCode: JsonField<String>) = apply { this.regionCode = regionCode }

        /** The delivery status of the message (e.g., sent, delivered, failed, read) */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** The category of the template (e.g., MARKETING, UTILITY, AUTHENTICATION) */
        fun templateCategory(templateCategory: String) =
            templateCategory(JsonField.of(templateCategory))

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

        /**
         * The unique identifier of the template used for this message (null if no template was
         * used)
         */
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

        /** The display name of the template */
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
         * Returns an immutable instance of [MessageRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageRetrieveResponse =
            MessageRetrieveResponse(
                id,
                channel,
                contactId,
                correctedPrice,
                createdAt,
                customerId,
                (events ?: JsonMissing.of()).map { it.toImmutable() },
                messageBody,
                phoneNumber,
                phoneNumberInternational,
                regionCode,
                status,
                templateCategory,
                templateId,
                templateName,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageRetrieveResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        channel()
        contactId()
        correctedPrice()
        createdAt()
        customerId()
        events().ifPresent { it.forEach { it.validate() } }
        messageBody().ifPresent { it.validate() }
        phoneNumber()
        phoneNumberInternational()
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
        } catch (e: SentDmInvalidDataException) {
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
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (contactId.asKnown().isPresent) 1 else 0) +
            (if (correctedPrice.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (events.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (messageBody.asKnown().getOrNull()?.validity() ?: 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (phoneNumberInternational.asKnown().isPresent) 1 else 0) +
            (if (regionCode.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (templateCategory.asKnown().isPresent) 1 else 0) +
            (if (templateId.asKnown().isPresent) 1 else 0) +
            (if (templateName.asKnown().isPresent) 1 else 0)

    /**
     * Represents a status change event in a message's lifecycle Follows industry standards (Twilio,
     * SendGrid, Mailgun pattern)
     */
    class Event
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val description: JsonField<String>,
        private val status: JsonField<String>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(description, status, timestamp, mutableMapOf())

        /**
         * Optional human-readable description of the event Useful for error messages or additional
         * context
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * The status of the message at this point in time Examples: "queued", "sent", "delivered",
         * "read", "failed"
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<String> = status.getOptional("status")

        /**
         * When this status change occurred (ISO 8601 format)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

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

            /** Returns a mutable builder for constructing an instance of [Event]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Event]. */
        class Builder internal constructor() {

            private var description: JsonField<String> = JsonMissing.of()
            private var status: JsonField<String> = JsonMissing.of()
            private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(event: Event) = apply {
                description = event.description
                status = event.status
                timestamp = event.timestamp
                additionalProperties = event.additionalProperties.toMutableMap()
            }

            /**
             * Optional human-readable description of the event Useful for error messages or
             * additional context
             */
            fun description(description: String?) = description(JsonField.ofNullable(description))

            /** Alias for calling [Builder.description] with `description.orElse(null)`. */
            fun description(description: Optional<String>) = description(description.getOrNull())

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            /**
             * The status of the message at this point in time Examples: "queued", "sent",
             * "delivered", "read", "failed"
             */
            fun status(status: String) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<String>) = apply { this.status = status }

            /** When this status change occurred (ISO 8601 format) */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
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
             * Returns an immutable instance of [Event].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Event =
                Event(description, status, timestamp, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Event = apply {
            if (validated) {
                return@apply
            }

            description()
            status()
            timestamp()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: SentDmInvalidDataException) {
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
            (if (description.asKnown().isPresent) 1 else 0) +
                (if (status.asKnown().isPresent) 1 else 0) +
                (if (timestamp.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Event &&
                description == other.description &&
                status == other.status &&
                timestamp == other.timestamp &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(description, status, timestamp, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Event{description=$description, status=$status, timestamp=$timestamp, additionalProperties=$additionalProperties}"
    }

    /** The message body content with variables substituted */
    class MessageBody
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val buttons: JsonField<List<Button>>,
        private val content: JsonField<String>,
        private val footer: JsonField<String>,
        private val header: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("buttons")
            @ExcludeMissing
            buttons: JsonField<List<Button>> = JsonMissing.of(),
            @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of(),
            @JsonProperty("footer") @ExcludeMissing footer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("header") @ExcludeMissing header: JsonField<String> = JsonMissing.of(),
        ) : this(buttons, content, footer, header, mutableMapOf())

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun buttons(): Optional<List<Button>> = buttons.getOptional("buttons")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun content(): Optional<String> = content.getOptional("content")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun footer(): Optional<String> = footer.getOptional("footer")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun header(): Optional<String> = header.getOptional("header")

        /**
         * Returns the raw JSON value of [buttons].
         *
         * Unlike [buttons], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("buttons") @ExcludeMissing fun _buttons(): JsonField<List<Button>> = buttons

        /**
         * Returns the raw JSON value of [content].
         *
         * Unlike [content], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonField<String> = content

        /**
         * Returns the raw JSON value of [footer].
         *
         * Unlike [footer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("footer") @ExcludeMissing fun _footer(): JsonField<String> = footer

        /**
         * Returns the raw JSON value of [header].
         *
         * Unlike [header], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("header") @ExcludeMissing fun _header(): JsonField<String> = header

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

            /** Returns a mutable builder for constructing an instance of [MessageBody]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MessageBody]. */
        class Builder internal constructor() {

            private var buttons: JsonField<MutableList<Button>>? = null
            private var content: JsonField<String> = JsonMissing.of()
            private var footer: JsonField<String> = JsonMissing.of()
            private var header: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(messageBody: MessageBody) = apply {
                buttons = messageBody.buttons.map { it.toMutableList() }
                content = messageBody.content
                footer = messageBody.footer
                header = messageBody.header
                additionalProperties = messageBody.additionalProperties.toMutableMap()
            }

            fun buttons(buttons: List<Button>?) = buttons(JsonField.ofNullable(buttons))

            /** Alias for calling [Builder.buttons] with `buttons.orElse(null)`. */
            fun buttons(buttons: Optional<List<Button>>) = buttons(buttons.getOrNull())

            /**
             * Sets [Builder.buttons] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buttons] with a well-typed `List<Button>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun buttons(buttons: JsonField<List<Button>>) = apply {
                this.buttons = buttons.map { it.toMutableList() }
            }

            /**
             * Adds a single [Button] to [buttons].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addButton(button: Button) = apply {
                buttons =
                    (buttons ?: JsonField.of(mutableListOf())).also {
                        checkKnown("buttons", it).add(button)
                    }
            }

            fun content(content: String) = content(JsonField.of(content))

            /**
             * Sets [Builder.content] to an arbitrary JSON value.
             *
             * You should usually call [Builder.content] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun content(content: JsonField<String>) = apply { this.content = content }

            fun footer(footer: String?) = footer(JsonField.ofNullable(footer))

            /** Alias for calling [Builder.footer] with `footer.orElse(null)`. */
            fun footer(footer: Optional<String>) = footer(footer.getOrNull())

            /**
             * Sets [Builder.footer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.footer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun footer(footer: JsonField<String>) = apply { this.footer = footer }

            fun header(header: String?) = header(JsonField.ofNullable(header))

            /** Alias for calling [Builder.header] with `header.orElse(null)`. */
            fun header(header: Optional<String>) = header(header.getOrNull())

            /**
             * Sets [Builder.header] to an arbitrary JSON value.
             *
             * You should usually call [Builder.header] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun header(header: JsonField<String>) = apply { this.header = header }

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
             * Returns an immutable instance of [MessageBody].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): MessageBody =
                MessageBody(
                    (buttons ?: JsonMissing.of()).map { it.toImmutable() },
                    content,
                    footer,
                    header,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): MessageBody = apply {
            if (validated) {
                return@apply
            }

            buttons().ifPresent { it.forEach { it.validate() } }
            content()
            footer()
            header()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: SentDmInvalidDataException) {
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
            (buttons.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (content.asKnown().isPresent) 1 else 0) +
                (if (footer.asKnown().isPresent) 1 else 0) +
                (if (header.asKnown().isPresent) 1 else 0)

        class Button
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val type: JsonField<String>,
            private val value: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            ) : this(type, value, mutableMapOf())

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<String> = type.getOptional("type")

            /**
             * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun value(): Optional<String> = value.getOptional("value")

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            /**
             * Returns the raw JSON value of [value].
             *
             * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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

                /** Returns a mutable builder for constructing an instance of [Button]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Button]. */
            class Builder internal constructor() {

                private var type: JsonField<String> = JsonMissing.of()
                private var value: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(button: Button) = apply {
                    type = button.type
                    value = button.value
                    additionalProperties = button.additionalProperties.toMutableMap()
                }

                fun type(type: String) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<String>) = apply { this.type = type }

                fun value(value: String) = value(JsonField.of(value))

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<String>) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Button].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Button = Button(type, value, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Button = apply {
                if (validated) {
                    return@apply
                }

                type()
                value()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: SentDmInvalidDataException) {
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
                (if (type.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Button &&
                    type == other.type &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(type, value, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Button{type=$type, value=$value, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MessageBody &&
                buttons == other.buttons &&
                content == other.content &&
                footer == other.footer &&
                header == other.header &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(buttons, content, footer, header, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MessageBody{buttons=$buttons, content=$content, footer=$footer, header=$header, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageRetrieveResponse &&
            id == other.id &&
            channel == other.channel &&
            contactId == other.contactId &&
            correctedPrice == other.correctedPrice &&
            createdAt == other.createdAt &&
            customerId == other.customerId &&
            events == other.events &&
            messageBody == other.messageBody &&
            phoneNumber == other.phoneNumber &&
            phoneNumberInternational == other.phoneNumberInternational &&
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
            channel,
            contactId,
            correctedPrice,
            createdAt,
            customerId,
            events,
            messageBody,
            phoneNumber,
            phoneNumberInternational,
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
        "MessageRetrieveResponse{id=$id, channel=$channel, contactId=$contactId, correctedPrice=$correctedPrice, createdAt=$createdAt, customerId=$customerId, events=$events, messageBody=$messageBody, phoneNumber=$phoneNumber, phoneNumberInternational=$phoneNumberInternational, regionCode=$regionCode, status=$status, templateCategory=$templateCategory, templateId=$templateId, templateName=$templateName, additionalProperties=$additionalProperties}"
}
