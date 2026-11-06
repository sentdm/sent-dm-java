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
 * Structured message body format for database storage. Preserves channel-specific components
 * (header, header media, body, footer, buttons, MMS subject and media).
 *
 * Persisted as the messageBody jsonb column on Messages. Every write path goes through
 * MessageUtils.MessageBodyJsonOptions, which writes nulls, so the envelope shape is stable
 * regardless of channel or status. Anything that rebuilds this object field by field — the four
 * IMessageBodyStrategy implementations and MessageUtils.BuildSegmentBody — has to carry every
 * member, or that member is silently dropped on whichever path forgot it.
 */
class MessageBody
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val buttons: JsonField<List<MessageButton>>,
    private val content: JsonField<String>,
    private val footer: JsonField<String>,
    private val header: JsonField<String>,
    private val headerMedia: JsonField<MessageHeaderMedia>,
    private val media: JsonField<List<MessageMedia>>,
    private val subject: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("buttons")
        @ExcludeMissing
        buttons: JsonField<List<MessageButton>> = JsonMissing.of(),
        @JsonProperty("content") @ExcludeMissing content: JsonField<String> = JsonMissing.of(),
        @JsonProperty("footer") @ExcludeMissing footer: JsonField<String> = JsonMissing.of(),
        @JsonProperty("header") @ExcludeMissing header: JsonField<String> = JsonMissing.of(),
        @JsonProperty("headerMedia")
        @ExcludeMissing
        headerMedia: JsonField<MessageHeaderMedia> = JsonMissing.of(),
        @JsonProperty("media")
        @ExcludeMissing
        media: JsonField<List<MessageMedia>> = JsonMissing.of(),
        @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
    ) : this(buttons, content, footer, header, headerMedia, media, subject, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun buttons(): Optional<List<MessageButton>> = buttons.getOptional("buttons")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun content(): Optional<String> = content.getOptional("content")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun footer(): Optional<String> = footer.getOptional("footer")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun header(): Optional<String> = header.getOptional("header")

    /**
     * The media asset that rode a message's header, recorded as sent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun headerMedia(): Optional<MessageHeaderMedia> = headerMedia.getOptional("headerMedia")

    /**
     * MMS attachments, as the publicly fetchable URLs handed to the carrier. Null on every other
     * channel.
     *
     * Persisted rather than derived because a resend and a curfew release rebuild the send from the
     * stored row — MessageReplayCommandBuilder reads templateId and templateVariables and nothing
     * else — so media that lives only on the original request would silently turn a replayed MMS
     * into a text message.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun media(): Optional<List<MessageMedia>> = media.getOptional("media")

    /**
     * MMS subject line. Null on every other channel.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun subject(): Optional<String> = subject.getOptional("subject")

    /**
     * Returns the raw JSON value of [buttons].
     *
     * Unlike [buttons], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("buttons")
    @ExcludeMissing
    fun _buttons(): JsonField<List<MessageButton>> = buttons

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

    /**
     * Returns the raw JSON value of [headerMedia].
     *
     * Unlike [headerMedia], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("headerMedia")
    @ExcludeMissing
    fun _headerMedia(): JsonField<MessageHeaderMedia> = headerMedia

    /**
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<MessageMedia>> = media

    /**
     * Returns the raw JSON value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

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

        private var buttons: JsonField<MutableList<MessageButton>>? = null
        private var content: JsonField<String> = JsonMissing.of()
        private var footer: JsonField<String> = JsonMissing.of()
        private var header: JsonField<String> = JsonMissing.of()
        private var headerMedia: JsonField<MessageHeaderMedia> = JsonMissing.of()
        private var media: JsonField<MutableList<MessageMedia>>? = null
        private var subject: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageBody: MessageBody) = apply {
            buttons = messageBody.buttons.map { it.toMutableList() }
            content = messageBody.content
            footer = messageBody.footer
            header = messageBody.header
            headerMedia = messageBody.headerMedia
            media = messageBody.media.map { it.toMutableList() }
            subject = messageBody.subject
            additionalProperties = messageBody.additionalProperties.toMutableMap()
        }

        fun buttons(buttons: List<MessageButton>?) = buttons(JsonField.ofNullable(buttons))

        /** Alias for calling [Builder.buttons] with `buttons.orElse(null)`. */
        fun buttons(buttons: Optional<List<MessageButton>>) = buttons(buttons.getOrNull())

        /**
         * Sets [Builder.buttons] to an arbitrary JSON value.
         *
         * You should usually call [Builder.buttons] with a well-typed `List<MessageButton>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun buttons(buttons: JsonField<List<MessageButton>>) = apply {
            this.buttons = buttons.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageButton] to [buttons].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addButton(button: MessageButton) = apply {
            buttons =
                (buttons ?: JsonField.of(mutableListOf())).also {
                    checkKnown("buttons", it).add(button)
                }
        }

        fun content(content: String) = content(JsonField.of(content))

        /**
         * Sets [Builder.content] to an arbitrary JSON value.
         *
         * You should usually call [Builder.content] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun content(content: JsonField<String>) = apply { this.content = content }

        fun footer(footer: String?) = footer(JsonField.ofNullable(footer))

        /** Alias for calling [Builder.footer] with `footer.orElse(null)`. */
        fun footer(footer: Optional<String>) = footer(footer.getOrNull())

        /**
         * Sets [Builder.footer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.footer] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun footer(footer: JsonField<String>) = apply { this.footer = footer }

        fun header(header: String?) = header(JsonField.ofNullable(header))

        /** Alias for calling [Builder.header] with `header.orElse(null)`. */
        fun header(header: Optional<String>) = header(header.getOrNull())

        /**
         * Sets [Builder.header] to an arbitrary JSON value.
         *
         * You should usually call [Builder.header] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun header(header: JsonField<String>) = apply { this.header = header }

        /** The media asset that rode a message's header, recorded as sent. */
        fun headerMedia(headerMedia: MessageHeaderMedia?) =
            headerMedia(JsonField.ofNullable(headerMedia))

        /** Alias for calling [Builder.headerMedia] with `headerMedia.orElse(null)`. */
        fun headerMedia(headerMedia: Optional<MessageHeaderMedia>) =
            headerMedia(headerMedia.getOrNull())

        /**
         * Sets [Builder.headerMedia] to an arbitrary JSON value.
         *
         * You should usually call [Builder.headerMedia] with a well-typed [MessageHeaderMedia]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun headerMedia(headerMedia: JsonField<MessageHeaderMedia>) = apply {
            this.headerMedia = headerMedia
        }

        /**
         * MMS attachments, as the publicly fetchable URLs handed to the carrier. Null on every
         * other channel.
         *
         * Persisted rather than derived because a resend and a curfew release rebuild the send from
         * the stored row — MessageReplayCommandBuilder reads templateId and templateVariables and
         * nothing else — so media that lives only on the original request would silently turn a
         * replayed MMS into a text message.
         */
        fun media(media: List<MessageMedia>?) = media(JsonField.ofNullable(media))

        /** Alias for calling [Builder.media] with `media.orElse(null)`. */
        fun media(media: Optional<List<MessageMedia>>) = media(media.getOrNull())

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed `List<MessageMedia>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun media(media: JsonField<List<MessageMedia>>) = apply {
            this.media = media.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageMedia] to [Builder.media].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMedia(media: MessageMedia) = apply {
            this.media =
                (this.media ?: JsonField.of(mutableListOf())).also {
                    checkKnown("media", it).add(media)
                }
        }

        /** MMS subject line. Null on every other channel. */
        fun subject(subject: String?) = subject(JsonField.ofNullable(subject))

        /** Alias for calling [Builder.subject] with `subject.orElse(null)`. */
        fun subject(subject: Optional<String>) = subject(subject.getOrNull())

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

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
                headerMedia,
                (media ?: JsonMissing.of()).map { it.toImmutable() },
                subject,
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
    fun validate(): MessageBody = apply {
        if (validated) {
            return@apply
        }

        buttons().ifPresent { it.forEach { it.validate() } }
        content()
        footer()
        header()
        headerMedia().ifPresent { it.validate() }
        media().ifPresent { it.forEach { it.validate() } }
        subject()
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
        (buttons.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (content.asKnown().isPresent) 1 else 0) +
            (if (footer.asKnown().isPresent) 1 else 0) +
            (if (header.asKnown().isPresent) 1 else 0) +
            (headerMedia.asKnown().getOrNull()?.validity() ?: 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (subject.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageBody &&
            buttons == other.buttons &&
            content == other.content &&
            footer == other.footer &&
            header == other.header &&
            headerMedia == other.headerMedia &&
            media == other.media &&
            subject == other.subject &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            buttons,
            content,
            footer,
            header,
            headerMedia,
            media,
            subject,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageBody{buttons=$buttons, content=$content, footer=$footer, header=$header, headerMedia=$headerMedia, media=$media, subject=$subject, additionalProperties=$additionalProperties}"
}
