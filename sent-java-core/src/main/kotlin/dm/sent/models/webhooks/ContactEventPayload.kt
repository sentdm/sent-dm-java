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
 * Body of a contact.opt_in, contact.opt_out or contact.help event. Delivered when a contact signals
 * a consent change or asks for help.
 *
 * These events state the signal outright, so you do not have to recognise keywords in the text of a
 * message.received event. They also cover cases that produce no inbound message at all, such as a
 * network handling an opt-out on your behalf.
 *
 * Fields are ordered identity → resulting state → provenance → join key. Nothing here restates the
 * envelope: which of the three signals occurred is the envelope's event, and when it was emitted is
 * its timestamp. Retries carry the same X-Webhook-Event-ID header, which is what to deduplicate on.
 */
class ContactEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val optOut: JsonField<Boolean>,
    private val source: JsonField<String>,
    private val accountId: JsonField<String>,
    private val channel: JsonField<String>,
    private val contactId: JsonField<String>,
    private val messageId: JsonField<String>,
    private val phoneNumber: JsonField<String>,
    private val text: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("opt_out") @ExcludeMissing optOut: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("contact_id") @ExcludeMissing contactId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone_number")
        @ExcludeMissing
        phoneNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
    ) : this(
        optOut,
        source,
        accountId,
        channel,
        contactId,
        messageId,
        phoneNumber,
        text,
        mutableMapOf(),
    )

    /**
     * Whether the contact is opted out after this signal — the state to write to your own record.
     * Same meaning as opt_out on the contact resource. On contact.help this reports the contact's
     * existing state, which help does not change.
     *
     * Two signals from the same contact can arrive out of order, because each one is queued on its
     * own rather than against the contact. Compare the envelope's timestamp before you overwrite a
     * newer state with an older one. That timestamp is second-precision, so treat two signals
     * stamped in the same second as unordered and read the contact resource to settle them.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun optOut(): Boolean = optOut.getRequired("opt_out")

    /**
     * How the signal reached us. INBOUND_KEYWORD means the contact sent a message whose text
     * matched one of the keywords; PROVIDER_SIGNAL means the network reported it. A provider signal
     * usually carries no message_id or text, so read both for null rather than inferring them from
     * this field.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun source(): String = source.getRequired("source")

    /**
     * The account the contact belongs to. Present so one endpoint can serve several accounts.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * The channel the signal arrived on, for example sms or whatsapp.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * The contact who raised the signal. Always populated, including for contact.help from a number
     * you have not messaged before — the contact is created if it does not exist yet, so this
     * identifier is always resolvable against the contacts API.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun contactId(): Optional<String> = contactId.getOptional("contact_id")

    /**
     * The inbound message that carried the signal, matching message_id on the corresponding
     * message.received event so the two can be joined.
     *
     * Sent as null when the signal did not arrive as a message — for example when a network
     * processed an opt-out on your behalf — and also when the message belongs to a different
     * account than this event, which can happen on a shared WhatsApp number. The field is always
     * present, so read it and check for null rather than checking whether the key exists.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * The contact's number in E.164 format. Same value as phone_number on the contact resource.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun phoneNumber(): Optional<String> = phoneNumber.getOptional("phone_number")

    /**
     * The text the contact sent, for example STOP or UNSUBSCRIBE. Sent as null when the signal did
     * not arrive as text. The field is always present, so read it and check for null rather than
     * checking whether the key exists.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun text(): Optional<String> = text.getOptional("text")

    /**
     * Returns the raw JSON value of [optOut].
     *
     * Unlike [optOut], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("opt_out") @ExcludeMissing fun _optOut(): JsonField<Boolean> = optOut

    /**
     * Returns the raw JSON value of [source].
     *
     * Unlike [source], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

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
     * Returns the raw JSON value of [contactId].
     *
     * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("contact_id") @ExcludeMissing fun _contactId(): JsonField<String> = contactId

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [phoneNumber].
     *
     * Unlike [phoneNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone_number")
    @ExcludeMissing
    fun _phoneNumber(): JsonField<String> = phoneNumber

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
         * Returns a mutable builder for constructing an instance of [ContactEventPayload].
         *
         * The following fields are required:
         * ```java
         * .optOut()
         * .source()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactEventPayload]. */
    class Builder internal constructor() {

        private var optOut: JsonField<Boolean>? = null
        private var source: JsonField<String>? = null
        private var accountId: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var contactId: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contactEventPayload: ContactEventPayload) = apply {
            optOut = contactEventPayload.optOut
            source = contactEventPayload.source
            accountId = contactEventPayload.accountId
            channel = contactEventPayload.channel
            contactId = contactEventPayload.contactId
            messageId = contactEventPayload.messageId
            phoneNumber = contactEventPayload.phoneNumber
            text = contactEventPayload.text
            additionalProperties = contactEventPayload.additionalProperties.toMutableMap()
        }

        /**
         * Whether the contact is opted out after this signal — the state to write to your own
         * record. Same meaning as opt_out on the contact resource. On contact.help this reports the
         * contact's existing state, which help does not change.
         *
         * Two signals from the same contact can arrive out of order, because each one is queued on
         * its own rather than against the contact. Compare the envelope's timestamp before you
         * overwrite a newer state with an older one. That timestamp is second-precision, so treat
         * two signals stamped in the same second as unordered and read the contact resource to
         * settle them.
         */
        fun optOut(optOut: Boolean) = optOut(JsonField.of(optOut))

        /**
         * Sets [Builder.optOut] to an arbitrary JSON value.
         *
         * You should usually call [Builder.optOut] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun optOut(optOut: JsonField<Boolean>) = apply { this.optOut = optOut }

        /**
         * How the signal reached us. INBOUND_KEYWORD means the contact sent a message whose text
         * matched one of the keywords; PROVIDER_SIGNAL means the network reported it. A provider
         * signal usually carries no message_id or text, so read both for null rather than inferring
         * them from this field.
         */
        fun source(source: String) = source(JsonField.of(source))

        /**
         * Sets [Builder.source] to an arbitrary JSON value.
         *
         * You should usually call [Builder.source] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun source(source: JsonField<String>) = apply { this.source = source }

        /**
         * The account the contact belongs to. Present so one endpoint can serve several accounts.
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

        /** The channel the signal arrived on, for example sms or whatsapp. */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /**
         * The contact who raised the signal. Always populated, including for contact.help from a
         * number you have not messaged before — the contact is created if it does not exist yet, so
         * this identifier is always resolvable against the contacts API.
         */
        fun contactId(contactId: String) = contactId(JsonField.of(contactId))

        /**
         * Sets [Builder.contactId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactId(contactId: JsonField<String>) = apply { this.contactId = contactId }

        /**
         * The inbound message that carried the signal, matching message_id on the corresponding
         * message.received event so the two can be joined.
         *
         * Sent as null when the signal did not arrive as a message — for example when a network
         * processed an opt-out on your behalf — and also when the message belongs to a different
         * account than this event, which can happen on a shared WhatsApp number. The field is
         * always present, so read it and check for null rather than checking whether the key
         * exists.
         */
        fun messageId(messageId: String?) = messageId(JsonField.ofNullable(messageId))

        /** Alias for calling [Builder.messageId] with `messageId.orElse(null)`. */
        fun messageId(messageId: Optional<String>) = messageId(messageId.getOrNull())

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /**
         * The contact's number in E.164 format. Same value as phone_number on the contact resource.
         */
        fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

        /**
         * Sets [Builder.phoneNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phoneNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        /**
         * The text the contact sent, for example STOP or UNSUBSCRIBE. Sent as null when the signal
         * did not arrive as text. The field is always present, so read it and check for null rather
         * than checking whether the key exists.
         */
        fun text(text: String?) = text(JsonField.ofNullable(text))

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<String>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

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
         * Returns an immutable instance of [ContactEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .optOut()
         * .source()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContactEventPayload =
            ContactEventPayload(
                checkRequired("optOut", optOut),
                checkRequired("source", source),
                accountId,
                channel,
                contactId,
                messageId,
                phoneNumber,
                text,
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
    fun validate(): ContactEventPayload = apply {
        if (validated) {
            return@apply
        }

        optOut()
        source()
        accountId()
        channel()
        contactId()
        messageId()
        phoneNumber()
        text()
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
        (if (optOut.asKnown().isPresent) 1 else 0) +
            (if (source.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (contactId.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (phoneNumber.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactEventPayload &&
            optOut == other.optOut &&
            source == other.source &&
            accountId == other.accountId &&
            channel == other.channel &&
            contactId == other.contactId &&
            messageId == other.messageId &&
            phoneNumber == other.phoneNumber &&
            text == other.text &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            optOut,
            source,
            accountId,
            channel,
            contactId,
            messageId,
            phoneNumber,
            text,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContactEventPayload{optOut=$optOut, source=$source, accountId=$accountId, channel=$channel, contactId=$contactId, messageId=$messageId, phoneNumber=$phoneNumber, text=$text, additionalProperties=$additionalProperties}"
}
