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
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Body of a message.received event. Delivered when a contact messages one of your numbers. */
class InboundMessageEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val inboundNumber: JsonField<String>,
    private val receivedAt: JsonField<String>,
    private val accountId: JsonField<String>,
    private val channel: JsonField<String>,
    private val media: JsonField<List<Media>>,
    private val messageId: JsonField<String>,
    private val outboundNumber: JsonField<String>,
    private val text: JsonField<String>,
    private val updatedAt: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("inbound_number")
        @ExcludeMissing
        inboundNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("received_at")
        @ExcludeMissing
        receivedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("media") @ExcludeMissing media: JsonField<List<Media>> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("outbound_number")
        @ExcludeMissing
        outboundNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<String> = JsonMissing.of(),
    ) : this(
        inboundNumber,
        receivedAt,
        accountId,
        channel,
        media,
        messageId,
        outboundNumber,
        text,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The contact's number in E.164 format, meaning the number the message came from.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inboundNumber(): String = inboundNumber.getRequired("inbound_number")

    /**
     * When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ).
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun receivedAt(): String = receivedAt.getRequired("received_at")

    /**
     * The account the message belongs to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * The channel the message arrived on, for example sms or mms.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * Attachments the contact sent, present only on channels that carry them (mms today) and
     * omitted entirely otherwise.
     *
     * Each url points at the carrier's own copy of the file — sent.dm records where the attachment
     * is, not the attachment itself. The link is unauthenticated and expires on the carrier's
     * schedule, which differs between them: assume days, not months. Download what you need on
     * receipt; re-reading the message through GET /v3/messages/{id} returns the same stored link,
     * not a fresh one, so once it lapses the entry remains with whatever the carrier declared about
     * the file but the file is no longer reachable.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun media(): Optional<List<Media>> = media.getOptional("media")

    /**
     * The inbound message.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * Your number in E.164 format, meaning the number the message was addressed to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun outboundNumber(): Optional<String> = outboundNumber.getOptional("outbound_number")

    /**
     * The message body. Sent as null when the inbound message carried no text, for example a
     * media-only message. The field is always present, so read it and check for null rather than
     * checking whether the key exists.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun text(): Optional<String> = text.getOptional("text")

    /**
     * When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ). Same value as ReceivedAt, kept
     * for envelope consistency with outbound events.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<String> = updatedAt.getOptional("updated_at")

    /**
     * Returns the raw JSON value of [inboundNumber].
     *
     * Unlike [inboundNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inbound_number")
    @ExcludeMissing
    fun _inboundNumber(): JsonField<String> = inboundNumber

    /**
     * Returns the raw JSON value of [receivedAt].
     *
     * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("received_at") @ExcludeMissing fun _receivedAt(): JsonField<String> = receivedAt

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
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<Media>> = media

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [outboundNumber].
     *
     * Unlike [outboundNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("outbound_number")
    @ExcludeMissing
    fun _outboundNumber(): JsonField<String> = outboundNumber

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

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
         * Returns a mutable builder for constructing an instance of [InboundMessageEventPayload].
         *
         * The following fields are required:
         * ```java
         * .inboundNumber()
         * .receivedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboundMessageEventPayload]. */
    class Builder internal constructor() {

        private var inboundNumber: JsonField<String>? = null
        private var receivedAt: JsonField<String>? = null
        private var accountId: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var media: JsonField<MutableList<Media>>? = null
        private var messageId: JsonField<String> = JsonMissing.of()
        private var outboundNumber: JsonField<String> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboundMessageEventPayload: InboundMessageEventPayload) = apply {
            inboundNumber = inboundMessageEventPayload.inboundNumber
            receivedAt = inboundMessageEventPayload.receivedAt
            accountId = inboundMessageEventPayload.accountId
            channel = inboundMessageEventPayload.channel
            media = inboundMessageEventPayload.media.map { it.toMutableList() }
            messageId = inboundMessageEventPayload.messageId
            outboundNumber = inboundMessageEventPayload.outboundNumber
            text = inboundMessageEventPayload.text
            updatedAt = inboundMessageEventPayload.updatedAt
            additionalProperties = inboundMessageEventPayload.additionalProperties.toMutableMap()
        }

        /** The contact's number in E.164 format, meaning the number the message came from. */
        fun inboundNumber(inboundNumber: String) = inboundNumber(JsonField.of(inboundNumber))

        /**
         * Sets [Builder.inboundNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inboundNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inboundNumber(inboundNumber: JsonField<String>) = apply {
            this.inboundNumber = inboundNumber
        }

        /** When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ). */
        fun receivedAt(receivedAt: String) = receivedAt(JsonField.of(receivedAt))

        /**
         * Sets [Builder.receivedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.receivedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun receivedAt(receivedAt: JsonField<String>) = apply { this.receivedAt = receivedAt }

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

        /** The channel the message arrived on, for example sms or mms. */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /**
         * Attachments the contact sent, present only on channels that carry them (mms today) and
         * omitted entirely otherwise.
         *
         * Each url points at the carrier's own copy of the file — sent.dm records where the
         * attachment is, not the attachment itself. The link is unauthenticated and expires on the
         * carrier's schedule, which differs between them: assume days, not months. Download what
         * you need on receipt; re-reading the message through GET /v3/messages/{id} returns the
         * same stored link, not a fresh one, so once it lapses the entry remains with whatever the
         * carrier declared about the file but the file is no longer reachable.
         */
        fun media(media: List<Media>?) = media(JsonField.ofNullable(media))

        /** Alias for calling [Builder.media] with `media.orElse(null)`. */
        fun media(media: Optional<List<Media>>) = media(media.getOrNull())

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed `List<Media>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun media(media: JsonField<List<Media>>) = apply {
            this.media = media.map { it.toMutableList() }
        }

        /**
         * Adds a single [Media] to [Builder.media].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMedia(media: Media) = apply {
            this.media =
                (this.media ?: JsonField.of(mutableListOf())).also {
                    checkKnown("media", it).add(media)
                }
        }

        /** The inbound message. */
        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

        /** Your number in E.164 format, meaning the number the message was addressed to. */
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

        /**
         * The message body. Sent as null when the inbound message carried no text, for example a
         * media-only message. The field is always present, so read it and check for null rather
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

        /**
         * When the message was received, in UTC (yyyy-MM-ddTHH:mm:ssZ). Same value as ReceivedAt,
         * kept for envelope consistency with outbound events.
         */
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
         * Returns an immutable instance of [InboundMessageEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .inboundNumber()
         * .receivedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InboundMessageEventPayload =
            InboundMessageEventPayload(
                checkRequired("inboundNumber", inboundNumber),
                checkRequired("receivedAt", receivedAt),
                accountId,
                channel,
                (media ?: JsonMissing.of()).map { it.toImmutable() },
                messageId,
                outboundNumber,
                text,
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
    fun validate(): InboundMessageEventPayload = apply {
        if (validated) {
            return@apply
        }

        inboundNumber()
        receivedAt()
        accountId()
        channel()
        media().ifPresent { it.forEach { it.validate() } }
        messageId()
        outboundNumber()
        text()
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
        (if (inboundNumber.asKnown().isPresent) 1 else 0) +
            (if (receivedAt.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (outboundNumber.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    /** One attachment on an inbound message. */
    class Media
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val hashSha256: JsonField<String>,
        private val mimeType: JsonField<String>,
        private val sizeBytes: JsonField<Long>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("hash_sha256")
            @ExcludeMissing
            hashSha256: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mime_type")
            @ExcludeMissing
            mimeType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("size_bytes")
            @ExcludeMissing
            sizeBytes: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(hashSha256, mimeType, sizeBytes, url, mutableMapOf())

        /**
         * SHA-256 of the file as the carrier declared it, when it declares one. Verify what you
         * download against this — sent.dm never reads the bytes, so it is the only integrity signal
         * available.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun hashSha256(): Optional<String> = hashSha256.getOptional("hash_sha256")

        /**
         * Content type as the carrier reported it, for example image/jpeg.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mimeType(): Optional<String> = mimeType.getOptional("mime_type")

        /**
         * Size in bytes as the carrier declared it. Absent when it declared none.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sizeBytes(): Optional<Long> = sizeBytes.getOptional("size_bytes")

        /**
         * Where the carrier hosts the attachment.
         *
         * This link expires and is not authenticated. sent.dm relays it rather than copying the
         * file, so how long it stays fetchable is the carrier's decision and differs between them —
         * assume days, not months. Anyone holding the URL can fetch it until it lapses. Copy the
         * file on receipt if you need it to outlive that window; do not store this URL as a
         * permanent reference.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [hashSha256].
         *
         * Unlike [hashSha256], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("hash_sha256")
        @ExcludeMissing
        fun _hashSha256(): JsonField<String> = hashSha256

        /**
         * Returns the raw JSON value of [mimeType].
         *
         * Unlike [mimeType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mime_type") @ExcludeMissing fun _mimeType(): JsonField<String> = mimeType

        /**
         * Returns the raw JSON value of [sizeBytes].
         *
         * Unlike [sizeBytes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("size_bytes") @ExcludeMissing fun _sizeBytes(): JsonField<Long> = sizeBytes

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

            /** Returns a mutable builder for constructing an instance of [Media]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Media]. */
        class Builder internal constructor() {

            private var hashSha256: JsonField<String> = JsonMissing.of()
            private var mimeType: JsonField<String> = JsonMissing.of()
            private var sizeBytes: JsonField<Long> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(media: Media) = apply {
                hashSha256 = media.hashSha256
                mimeType = media.mimeType
                sizeBytes = media.sizeBytes
                url = media.url
                additionalProperties = media.additionalProperties.toMutableMap()
            }

            /**
             * SHA-256 of the file as the carrier declared it, when it declares one. Verify what you
             * download against this — sent.dm never reads the bytes, so it is the only integrity
             * signal available.
             */
            fun hashSha256(hashSha256: String?) = hashSha256(JsonField.ofNullable(hashSha256))

            /** Alias for calling [Builder.hashSha256] with `hashSha256.orElse(null)`. */
            fun hashSha256(hashSha256: Optional<String>) = hashSha256(hashSha256.getOrNull())

            /**
             * Sets [Builder.hashSha256] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hashSha256] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hashSha256(hashSha256: JsonField<String>) = apply { this.hashSha256 = hashSha256 }

            /** Content type as the carrier reported it, for example image/jpeg. */
            fun mimeType(mimeType: String?) = mimeType(JsonField.ofNullable(mimeType))

            /** Alias for calling [Builder.mimeType] with `mimeType.orElse(null)`. */
            fun mimeType(mimeType: Optional<String>) = mimeType(mimeType.getOrNull())

            /**
             * Sets [Builder.mimeType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mimeType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mimeType(mimeType: JsonField<String>) = apply { this.mimeType = mimeType }

            /** Size in bytes as the carrier declared it. Absent when it declared none. */
            fun sizeBytes(sizeBytes: Long?) = sizeBytes(JsonField.ofNullable(sizeBytes))

            /**
             * Alias for [Builder.sizeBytes].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun sizeBytes(sizeBytes: Long) = sizeBytes(sizeBytes as Long?)

            /** Alias for calling [Builder.sizeBytes] with `sizeBytes.orElse(null)`. */
            fun sizeBytes(sizeBytes: Optional<Long>) = sizeBytes(sizeBytes.getOrNull())

            /**
             * Sets [Builder.sizeBytes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sizeBytes] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sizeBytes(sizeBytes: JsonField<Long>) = apply { this.sizeBytes = sizeBytes }

            /**
             * Where the carrier hosts the attachment.
             *
             * This link expires and is not authenticated. sent.dm relays it rather than copying the
             * file, so how long it stays fetchable is the carrier's decision and differs between
             * them — assume days, not months. Anyone holding the URL can fetch it until it lapses.
             * Copy the file on receipt if you need it to outlive that window; do not store this URL
             * as a permanent reference.
             */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [Media].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Media =
                Media(hashSha256, mimeType, sizeBytes, url, additionalProperties.toMutableMap())
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
        fun validate(): Media = apply {
            if (validated) {
                return@apply
            }

            hashSha256()
            mimeType()
            sizeBytes()
            url()
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
            (if (hashSha256.asKnown().isPresent) 1 else 0) +
                (if (mimeType.asKnown().isPresent) 1 else 0) +
                (if (sizeBytes.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Media &&
                hashSha256 == other.hashSha256 &&
                mimeType == other.mimeType &&
                sizeBytes == other.sizeBytes &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(hashSha256, mimeType, sizeBytes, url, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Media{hashSha256=$hashSha256, mimeType=$mimeType, sizeBytes=$sizeBytes, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboundMessageEventPayload &&
            inboundNumber == other.inboundNumber &&
            receivedAt == other.receivedAt &&
            accountId == other.accountId &&
            channel == other.channel &&
            media == other.media &&
            messageId == other.messageId &&
            outboundNumber == other.outboundNumber &&
            text == other.text &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            inboundNumber,
            receivedAt,
            accountId,
            channel,
            media,
            messageId,
            outboundNumber,
            text,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboundMessageEventPayload{inboundNumber=$inboundNumber, receivedAt=$receivedAt, accountId=$accountId, channel=$channel, media=$media, messageId=$messageId, outboundNumber=$outboundNumber, text=$text, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
