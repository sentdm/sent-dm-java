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
import dm.sent.core.Params
import dm.sent.core.checkKnown
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Sends a message to one or more recipients using a template. Supports multi-channel broadcast —
 * when multiple channels are specified (e.g. ["sms", "whatsapp"]), a separate message is created
 * for each (recipient, channel) pair. To choose which of your own numbers a send goes out from, use
 * 'channels': {"sms": [{"from": ["+12125550000", "+14155550000"]}]}. Each channel holds a list of
 * entries, each with 'from' and optionally 'country' and 'strategy'; 'country' and 'strategy' are
 * stored but not acted on yet, so every entry's numbers apply to every recipient on that channel.
 * Every number listed must be an active sender on your account. Like the other account-level
 * preconditions below, that is checked per message rather than when the request is received: the
 * request is still accepted with 202, and each affected message is reported as BLOCKED with error
 * code BUSINESS_029 on GET /messages/{id} and the message.blocked webhook. Each channel's numbers
 * restrict which numbers that channel may use; it does not choose channels — 'channel' does, and
 * the two can be combined. With 'channel' left at auto-detect, a recipient best served by a channel
 * you listed no numbers for still goes out on it. Where several of the listed numbers could serve a
 * recipient, routing prefers the one whose area code matches theirs. Keys: sms, whatsapp, rcs, mms.
 * Returns immediately with per-recipient message IDs for async tracking via webhooks or the GET
 * /messages/{id} endpoint. Sends gated before any delivery attempt do not reject the request — an
 * account-level precondition such as insufficient balance, a template not approved for sending, or
 * free-form content with no open conversation with the contact. The send is accepted with 202 and
 * the affected messages are reported as BLOCKED on GET /messages/{id} and the message.blocked
 * webhook. To send later, set scheduled_at (ISO-8601 with an explicit UTC offset; a value without
 * one is rejected) between 1 minute and 30 days ahead: the response is a
 * ScheduledSendMessageResponse (the same fields plus scheduled_at; status is still QUEUED), each
 * message then moves to SCHEDULED, is held and released at that time (within a few minutes), and a
 * message.scheduled webhook fires once it is held. Balance and template approval are evaluated at
 * release, not at acceptance. Quiet hours are not checked when the request is accepted: if the time
 * falls inside a legally protected quiet-hours window for a recipient, that message is moved to the
 * next allowed time at release and a second message.scheduled webhook reports the new scheduled_at.
 * An account may hold at most 1,000,000 scheduled messages at once (429 LIMIT_001).
 */
class MessageSendParams
private constructor(
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate message
     * per recipient. "sent" = auto-detect. Defaults to ["sent"] (auto-detect) if omitted.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<List<String>> = body.channel()

    /**
     * Which of your own numbers to send from, keyed by channel, each channel holding a list of
     * entries: {"sms": [{"country": "US", "from": ["+12125550000", "+14155550000"]}, {"from":
     * ["+447700800001"]}]}. Any real channel may be a key; sent, which is auto-detect rather than a
     * channel, is rejected. country and strategy are accepted and stored but not acted on yet:
     * every entry's numbers apply to every recipient on that channel.
     *
     * This does not choose channels — Channel does, and the two combine: "channel": ["sms"] with an
     * sms list sends on SMS from those numbers. Each list only narrows which of its own channel's
     * routes may win, so with Channel left at auto-detect a recipient best served by a channel with
     * no list still goes out on it. Routing itself is unchanged: the same rules are scored and
     * ranked the same way, with routes pinned to numbers you did not list removed from the running.
     *
     * Every number must be an active sender on your account. The request itself is still accepted
     * (202) if one is not — like every other send-time rule, that is decided per message, so each
     * affected message is recorded BLOCKED with error code BUSINESS_029 and reported on GET
     * /v3/messages and the status webhook.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channels(): Optional<Channels> = body.channels()

    /**
     * Attachments for this send, as publicly fetchable https URLs. Used by the MMS channel and
     * ignored by every other one.
     *
     * Supplying these replaces the media on the template's mms body rather than adding to it, so a
     * template can hold a default creative while a caller still sends something recipient-specific.
     *
     * Their presence is also what makes a message eligible for MMS on an auto-detect send: a
     * message with nothing attached is delivered as SMS, because an MMS with no media is a more
     * expensive text message.
     *
     * The recipient's carrier fetches each URL after the send is accepted, so it must stay publicly
     * reachable — a link that expires, or one behind auth, arrives as a failed message.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mediaUrls(): Optional<List<String>> = body.mediaUrls()

    /**
     * Optional future send time as an ISO-8601 timestamp with an explicit UTC offset, e.g.
     * 2026-10-01T09:00:00+02:00 or 2026-10-01T07:00:00Z. A value without an offset is rejected
     * (400) rather than read in the server's zone. The offset only fixes the instant: it is stored
     * and echoed in UTC as scheduled_at. Omit to send now. Must be at least one minute ahead and at
     * most 30 days ahead. Accepted messages report SCHEDULED and are released for delivery at this
     * time. Quiet hours, balance and template approval are evaluated at release, not at acceptance:
     * a message whose time falls inside a recipient's protected quiet-hours window is moved to the
     * next allowed time and a second message.scheduled webhook reports the new scheduled_at.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun scheduledAt(): Optional<OffsetDateTime> = body.scheduledAt()

    /**
     * Subject line for this send, overriding the template's. MMS only; ignored on every other
     * channel. Most handsets render it above the body, some ignore it entirely.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun subject(): Optional<String> = body.subject()

    /**
     * SDK-style template reference: resolve by ID or by name, with optional parameters.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun template(): Optional<Template> = body.template()

    /**
     * Plain-text (free-form) message body. Provide either Template or this.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun text(): Optional<String> = body.text()

    /**
     * List of recipient phone numbers in E.164 format (multi-recipient fan-out)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun to(): Optional<List<String>> = body.to()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channel(): JsonField<List<String>> = body._channel()

    /**
     * Returns the raw JSON value of [channels].
     *
     * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channels(): JsonField<Channels> = body._channels()

    /**
     * Returns the raw JSON value of [mediaUrls].
     *
     * Unlike [mediaUrls], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mediaUrls(): JsonField<List<String>> = body._mediaUrls()

    /**
     * Returns the raw JSON value of [scheduledAt].
     *
     * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scheduledAt(): JsonField<OffsetDateTime> = body._scheduledAt()

    /**
     * Returns the raw JSON value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subject(): JsonField<String> = body._subject()

    /**
     * Returns the raw JSON value of [template].
     *
     * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _template(): JsonField<Template> = body._template()

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _text(): JsonField<String> = body._text()

    /**
     * Returns the raw JSON value of [to].
     *
     * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _to(): JsonField<List<String>> = body._to()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): MessageSendParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [MessageSendParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageSendParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(messageSendParams: MessageSendParams) = apply {
            idempotencyKey = messageSendParams.idempotencyKey
            xProfileId = messageSendParams.xProfileId
            body = messageSendParams.body.toBuilder()
            additionalHeaders = messageSendParams.additionalHeaders.toBuilder()
            additionalQueryParams = messageSendParams.additionalQueryParams.toBuilder()
        }

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [sandbox]
         * - [channel]
         * - [channels]
         * - [mediaUrls]
         * - [scheduledAt]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun sandbox(sandbox: Boolean) = apply { body.sandbox(sandbox) }

        /**
         * Sets [Builder.sandbox] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sandbox(sandbox: JsonField<Boolean>) = apply { body.sandbox(sandbox) }

        /**
         * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate
         * message per recipient. "sent" = auto-detect. Defaults to ["sent"] (auto-detect) if
         * omitted.
         */
        fun channel(channel: List<String>?) = apply { body.channel(channel) }

        /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
        fun channel(channel: Optional<List<String>>) = channel(channel.getOrNull())

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun channel(channel: JsonField<List<String>>) = apply { body.channel(channel) }

        /**
         * Adds a single [String] to [Builder.channel].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addChannel(channel: String) = apply { body.addChannel(channel) }

        /**
         * Which of your own numbers to send from, keyed by channel, each channel holding a list of
         * entries: {"sms": [{"country": "US", "from": ["+12125550000", "+14155550000"]}, {"from":
         * ["+447700800001"]}]}. Any real channel may be a key; sent, which is auto-detect rather
         * than a channel, is rejected. country and strategy are accepted and stored but not acted
         * on yet: every entry's numbers apply to every recipient on that channel.
         *
         * This does not choose channels — Channel does, and the two combine: "channel": ["sms"]
         * with an sms list sends on SMS from those numbers. Each list only narrows which of its own
         * channel's routes may win, so with Channel left at auto-detect a recipient best served by
         * a channel with no list still goes out on it. Routing itself is unchanged: the same rules
         * are scored and ranked the same way, with routes pinned to numbers you did not list
         * removed from the running.
         *
         * Every number must be an active sender on your account. The request itself is still
         * accepted (202) if one is not — like every other send-time rule, that is decided per
         * message, so each affected message is recorded BLOCKED with error code BUSINESS_029 and
         * reported on GET /v3/messages and the status webhook.
         */
        fun channels(channels: Channels?) = apply { body.channels(channels) }

        /** Alias for calling [Builder.channels] with `channels.orElse(null)`. */
        fun channels(channels: Optional<Channels>) = channels(channels.getOrNull())

        /**
         * Sets [Builder.channels] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channels] with a well-typed [Channels] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun channels(channels: JsonField<Channels>) = apply { body.channels(channels) }

        /**
         * Attachments for this send, as publicly fetchable https URLs. Used by the MMS channel and
         * ignored by every other one.
         *
         * Supplying these replaces the media on the template's mms body rather than adding to it,
         * so a template can hold a default creative while a caller still sends something
         * recipient-specific.
         *
         * Their presence is also what makes a message eligible for MMS on an auto-detect send: a
         * message with nothing attached is delivered as SMS, because an MMS with no media is a more
         * expensive text message.
         *
         * The recipient's carrier fetches each URL after the send is accepted, so it must stay
         * publicly reachable — a link that expires, or one behind auth, arrives as a failed
         * message.
         */
        fun mediaUrls(mediaUrls: List<String>?) = apply { body.mediaUrls(mediaUrls) }

        /** Alias for calling [Builder.mediaUrls] with `mediaUrls.orElse(null)`. */
        fun mediaUrls(mediaUrls: Optional<List<String>>) = mediaUrls(mediaUrls.getOrNull())

        /**
         * Sets [Builder.mediaUrls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaUrls] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mediaUrls(mediaUrls: JsonField<List<String>>) = apply { body.mediaUrls(mediaUrls) }

        /**
         * Adds a single [String] to [mediaUrls].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMediaUrl(mediaUrl: String) = apply { body.addMediaUrl(mediaUrl) }

        /**
         * Optional future send time as an ISO-8601 timestamp with an explicit UTC offset, e.g.
         * 2026-10-01T09:00:00+02:00 or 2026-10-01T07:00:00Z. A value without an offset is rejected
         * (400) rather than read in the server's zone. The offset only fixes the instant: it is
         * stored and echoed in UTC as scheduled_at. Omit to send now. Must be at least one minute
         * ahead and at most 30 days ahead. Accepted messages report SCHEDULED and are released for
         * delivery at this time. Quiet hours, balance and template approval are evaluated at
         * release, not at acceptance: a message whose time falls inside a recipient's protected
         * quiet-hours window is moved to the next allowed time and a second message.scheduled
         * webhook reports the new scheduled_at.
         */
        fun scheduledAt(scheduledAt: OffsetDateTime?) = apply { body.scheduledAt(scheduledAt) }

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
            body.scheduledAt(scheduledAt)
        }

        /**
         * Subject line for this send, overriding the template's. MMS only; ignored on every other
         * channel. Most handsets render it above the body, some ignore it entirely.
         */
        fun subject(subject: String?) = apply { body.subject(subject) }

        /** Alias for calling [Builder.subject] with `subject.orElse(null)`. */
        fun subject(subject: Optional<String>) = subject(subject.getOrNull())

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { body.subject(subject) }

        /** SDK-style template reference: resolve by ID or by name, with optional parameters. */
        fun template(template: Template?) = apply { body.template(template) }

        /** Alias for calling [Builder.template] with `template.orElse(null)`. */
        fun template(template: Optional<Template>) = template(template.getOrNull())

        /**
         * Sets [Builder.template] to an arbitrary JSON value.
         *
         * You should usually call [Builder.template] with a well-typed [Template] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun template(template: JsonField<Template>) = apply { body.template(template) }

        /** Plain-text (free-form) message body. Provide either Template or this. */
        fun text(text: String?) = apply { body.text(text) }

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<String>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { body.text(text) }

        /** List of recipient phone numbers in E.164 format (multi-recipient fan-out) */
        fun to(to: List<String>) = apply { body.to(to) }

        /**
         * Sets [Builder.to] to an arbitrary JSON value.
         *
         * You should usually call [Builder.to] with a well-typed `List<String>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun to(to: JsonField<List<String>>) = apply { body.to(to) }

        /**
         * Adds a single [String] to [Builder.to].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTo(to: String) = apply { body.addTo(to) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [MessageSendParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageSendParams =
            MessageSendParams(
                idempotencyKey,
                xProfileId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Request to send a message (v3 SDK-style with multi-recipient and multi-channel broadcast) */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val channel: JsonField<List<String>>,
        private val channels: JsonField<Channels>,
        private val mediaUrls: JsonField<List<String>>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val subject: JsonField<String>,
        private val template: JsonField<Template>,
        private val text: JsonField<String>,
        private val to: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("channel")
            @ExcludeMissing
            channel: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("channels")
            @ExcludeMissing
            channels: JsonField<Channels> = JsonMissing.of(),
            @JsonProperty("media_urls")
            @ExcludeMissing
            mediaUrls: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
            @JsonProperty("template")
            @ExcludeMissing
            template: JsonField<Template> = JsonMissing.of(),
            @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to") @ExcludeMissing to: JsonField<List<String>> = JsonMissing.of(),
        ) : this(
            sandbox,
            channel,
            channels,
            mediaUrls,
            scheduledAt,
            subject,
            template,
            text,
            to,
            mutableMapOf(),
        )

        fun toMutationRequest(): MutationRequest =
            MutationRequest.builder().sandbox(sandbox).build()

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate
         * message per recipient. "sent" = auto-detect. Defaults to ["sent"] (auto-detect) if
         * omitted.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channel(): Optional<List<String>> = channel.getOptional("channel")

        /**
         * Which of your own numbers to send from, keyed by channel, each channel holding a list of
         * entries: {"sms": [{"country": "US", "from": ["+12125550000", "+14155550000"]}, {"from":
         * ["+447700800001"]}]}. Any real channel may be a key; sent, which is auto-detect rather
         * than a channel, is rejected. country and strategy are accepted and stored but not acted
         * on yet: every entry's numbers apply to every recipient on that channel.
         *
         * This does not choose channels — Channel does, and the two combine: "channel": ["sms"]
         * with an sms list sends on SMS from those numbers. Each list only narrows which of its own
         * channel's routes may win, so with Channel left at auto-detect a recipient best served by
         * a channel with no list still goes out on it. Routing itself is unchanged: the same rules
         * are scored and ranked the same way, with routes pinned to numbers you did not list
         * removed from the running.
         *
         * Every number must be an active sender on your account. The request itself is still
         * accepted (202) if one is not — like every other send-time rule, that is decided per
         * message, so each affected message is recorded BLOCKED with error code BUSINESS_029 and
         * reported on GET /v3/messages and the status webhook.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun channels(): Optional<Channels> = channels.getOptional("channels")

        /**
         * Attachments for this send, as publicly fetchable https URLs. Used by the MMS channel and
         * ignored by every other one.
         *
         * Supplying these replaces the media on the template's mms body rather than adding to it,
         * so a template can hold a default creative while a caller still sends something
         * recipient-specific.
         *
         * Their presence is also what makes a message eligible for MMS on an auto-detect send: a
         * message with nothing attached is delivered as SMS, because an MMS with no media is a more
         * expensive text message.
         *
         * The recipient's carrier fetches each URL after the send is accepted, so it must stay
         * publicly reachable — a link that expires, or one behind auth, arrives as a failed
         * message.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mediaUrls(): Optional<List<String>> = mediaUrls.getOptional("media_urls")

        /**
         * Optional future send time as an ISO-8601 timestamp with an explicit UTC offset, e.g.
         * 2026-10-01T09:00:00+02:00 or 2026-10-01T07:00:00Z. A value without an offset is rejected
         * (400) rather than read in the server's zone. The offset only fixes the instant: it is
         * stored and echoed in UTC as scheduled_at. Omit to send now. Must be at least one minute
         * ahead and at most 30 days ahead. Accepted messages report SCHEDULED and are released for
         * delivery at this time. Quiet hours, balance and template approval are evaluated at
         * release, not at acceptance: a message whose time falls inside a recipient's protected
         * quiet-hours window is moved to the next allowed time and a second message.scheduled
         * webhook reports the new scheduled_at.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun scheduledAt(): Optional<OffsetDateTime> = scheduledAt.getOptional("scheduled_at")

        /**
         * Subject line for this send, overriding the template's. MMS only; ignored on every other
         * channel. Most handsets render it above the body, some ignore it entirely.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun subject(): Optional<String> = subject.getOptional("subject")

        /**
         * SDK-style template reference: resolve by ID or by name, with optional parameters.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun template(): Optional<Template> = template.getOptional("template")

        /**
         * Plain-text (free-form) message body. Provide either Template or this.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun text(): Optional<String> = text.getOptional("text")

        /**
         * List of recipient phone numbers in E.164 format (multi-recipient fan-out)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun to(): Optional<List<String>> = to.getOptional("to")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [channel].
         *
         * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<List<String>> = channel

        /**
         * Returns the raw JSON value of [channels].
         *
         * Unlike [channels], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channels") @ExcludeMissing fun _channels(): JsonField<Channels> = channels

        /**
         * Returns the raw JSON value of [mediaUrls].
         *
         * Unlike [mediaUrls], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("media_urls")
        @ExcludeMissing
        fun _mediaUrls(): JsonField<List<String>> = mediaUrls

        /**
         * Returns the raw JSON value of [scheduledAt].
         *
         * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        fun _scheduledAt(): JsonField<OffsetDateTime> = scheduledAt

        /**
         * Returns the raw JSON value of [subject].
         *
         * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

        /**
         * Returns the raw JSON value of [template].
         *
         * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<Template> = template

        /**
         * Returns the raw JSON value of [text].
         *
         * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

        /**
         * Returns the raw JSON value of [to].
         *
         * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<List<String>> = to

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var channel: JsonField<MutableList<String>>? = null
            private var channels: JsonField<Channels> = JsonMissing.of()
            private var mediaUrls: JsonField<MutableList<String>>? = null
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var subject: JsonField<String> = JsonMissing.of()
            private var template: JsonField<Template> = JsonMissing.of()
            private var text: JsonField<String> = JsonMissing.of()
            private var to: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                channel = body.channel.map { it.toMutableList() }
                channels = body.channels
                mediaUrls = body.mediaUrls.map { it.toMutableList() }
                scheduledAt = body.scheduledAt
                subject = body.subject
                template = body.template
                text = body.text
                to = body.to.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Sandbox flag - when true, the operation is simulated without side effects Useful for
             * testing integrations without actual execution
             */
            fun sandbox(sandbox: Boolean) = sandbox(JsonField.of(sandbox))

            /**
             * Sets [Builder.sandbox] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sandbox] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sandbox(sandbox: JsonField<Boolean>) = apply { this.sandbox = sandbox }

            /**
             * Channels to broadcast on, e.g. ["whatsapp", "sms"]. Each channel produces a separate
             * message per recipient. "sent" = auto-detect. Defaults to ["sent"] (auto-detect) if
             * omitted.
             */
            fun channel(channel: List<String>?) = channel(JsonField.ofNullable(channel))

            /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
            fun channel(channel: Optional<List<String>>) = channel(channel.getOrNull())

            /**
             * Sets [Builder.channel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channel] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channel(channel: JsonField<List<String>>) = apply {
                this.channel = channel.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [Builder.channel].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addChannel(channel: String) = apply {
                this.channel =
                    (this.channel ?: JsonField.of(mutableListOf())).also {
                        checkKnown("channel", it).add(channel)
                    }
            }

            /**
             * Which of your own numbers to send from, keyed by channel, each channel holding a list
             * of entries: {"sms": [{"country": "US", "from": ["+12125550000", "+14155550000"]},
             * {"from": ["+447700800001"]}]}. Any real channel may be a key; sent, which is
             * auto-detect rather than a channel, is rejected. country and strategy are accepted and
             * stored but not acted on yet: every entry's numbers apply to every recipient on that
             * channel.
             *
             * This does not choose channels — Channel does, and the two combine: "channel": ["sms"]
             * with an sms list sends on SMS from those numbers. Each list only narrows which of its
             * own channel's routes may win, so with Channel left at auto-detect a recipient best
             * served by a channel with no list still goes out on it. Routing itself is unchanged:
             * the same rules are scored and ranked the same way, with routes pinned to numbers you
             * did not list removed from the running.
             *
             * Every number must be an active sender on your account. The request itself is still
             * accepted (202) if one is not — like every other send-time rule, that is decided per
             * message, so each affected message is recorded BLOCKED with error code BUSINESS_029
             * and reported on GET /v3/messages and the status webhook.
             */
            fun channels(channels: Channels?) = channels(JsonField.ofNullable(channels))

            /** Alias for calling [Builder.channels] with `channels.orElse(null)`. */
            fun channels(channels: Optional<Channels>) = channels(channels.getOrNull())

            /**
             * Sets [Builder.channels] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channels] with a well-typed [Channels] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channels(channels: JsonField<Channels>) = apply { this.channels = channels }

            /**
             * Attachments for this send, as publicly fetchable https URLs. Used by the MMS channel
             * and ignored by every other one.
             *
             * Supplying these replaces the media on the template's mms body rather than adding to
             * it, so a template can hold a default creative while a caller still sends something
             * recipient-specific.
             *
             * Their presence is also what makes a message eligible for MMS on an auto-detect send:
             * a message with nothing attached is delivered as SMS, because an MMS with no media is
             * a more expensive text message.
             *
             * The recipient's carrier fetches each URL after the send is accepted, so it must stay
             * publicly reachable — a link that expires, or one behind auth, arrives as a failed
             * message.
             */
            fun mediaUrls(mediaUrls: List<String>?) = mediaUrls(JsonField.ofNullable(mediaUrls))

            /** Alias for calling [Builder.mediaUrls] with `mediaUrls.orElse(null)`. */
            fun mediaUrls(mediaUrls: Optional<List<String>>) = mediaUrls(mediaUrls.getOrNull())

            /**
             * Sets [Builder.mediaUrls] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaUrls] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaUrls(mediaUrls: JsonField<List<String>>) = apply {
                this.mediaUrls = mediaUrls.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [mediaUrls].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMediaUrl(mediaUrl: String) = apply {
                mediaUrls =
                    (mediaUrls ?: JsonField.of(mutableListOf())).also {
                        checkKnown("mediaUrls", it).add(mediaUrl)
                    }
            }

            /**
             * Optional future send time as an ISO-8601 timestamp with an explicit UTC offset, e.g.
             * 2026-10-01T09:00:00+02:00 or 2026-10-01T07:00:00Z. A value without an offset is
             * rejected (400) rather than read in the server's zone. The offset only fixes the
             * instant: it is stored and echoed in UTC as scheduled_at. Omit to send now. Must be at
             * least one minute ahead and at most 30 days ahead. Accepted messages report SCHEDULED
             * and are released for delivery at this time. Quiet hours, balance and template
             * approval are evaluated at release, not at acceptance: a message whose time falls
             * inside a recipient's protected quiet-hours window is moved to the next allowed time
             * and a second message.scheduled webhook reports the new scheduled_at.
             */
            fun scheduledAt(scheduledAt: OffsetDateTime?) =
                scheduledAt(JsonField.ofNullable(scheduledAt))

            /** Alias for calling [Builder.scheduledAt] with `scheduledAt.orElse(null)`. */
            fun scheduledAt(scheduledAt: Optional<OffsetDateTime>) =
                scheduledAt(scheduledAt.getOrNull())

            /**
             * Sets [Builder.scheduledAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
                this.scheduledAt = scheduledAt
            }

            /**
             * Subject line for this send, overriding the template's. MMS only; ignored on every
             * other channel. Most handsets render it above the body, some ignore it entirely.
             */
            fun subject(subject: String?) = subject(JsonField.ofNullable(subject))

            /** Alias for calling [Builder.subject] with `subject.orElse(null)`. */
            fun subject(subject: Optional<String>) = subject(subject.getOrNull())

            /**
             * Sets [Builder.subject] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subject] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subject(subject: JsonField<String>) = apply { this.subject = subject }

            /** SDK-style template reference: resolve by ID or by name, with optional parameters. */
            fun template(template: Template?) = template(JsonField.ofNullable(template))

            /** Alias for calling [Builder.template] with `template.orElse(null)`. */
            fun template(template: Optional<Template>) = template(template.getOrNull())

            /**
             * Sets [Builder.template] to an arbitrary JSON value.
             *
             * You should usually call [Builder.template] with a well-typed [Template] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun template(template: JsonField<Template>) = apply { this.template = template }

            /** Plain-text (free-form) message body. Provide either Template or this. */
            fun text(text: String?) = text(JsonField.ofNullable(text))

            /** Alias for calling [Builder.text] with `text.orElse(null)`. */
            fun text(text: Optional<String>) = text(text.getOrNull())

            /**
             * Sets [Builder.text] to an arbitrary JSON value.
             *
             * You should usually call [Builder.text] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun text(text: JsonField<String>) = apply { this.text = text }

            /** List of recipient phone numbers in E.164 format (multi-recipient fan-out) */
            fun to(to: List<String>) = to(JsonField.of(to))

            /**
             * Sets [Builder.to] to an arbitrary JSON value.
             *
             * You should usually call [Builder.to] with a well-typed `List<String>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun to(to: JsonField<List<String>>) = apply { this.to = to.map { it.toMutableList() } }

            /**
             * Adds a single [String] to [Builder.to].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTo(to: String) = apply {
                this.to =
                    (this.to ?: JsonField.of(mutableListOf())).also { checkKnown("to", it).add(to) }
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    sandbox,
                    (channel ?: JsonMissing.of()).map { it.toImmutable() },
                    channels,
                    (mediaUrls ?: JsonMissing.of()).map { it.toImmutable() },
                    scheduledAt,
                    subject,
                    template,
                    text,
                    (to ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            sandbox()
            channel()
            channels().ifPresent { it.validate() }
            mediaUrls()
            scheduledAt()
            subject()
            template().ifPresent { it.validate() }
            text()
            to()
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
            (if (sandbox.asKnown().isPresent) 1 else 0) +
                (channel.asKnown().getOrNull()?.size ?: 0) +
                (channels.asKnown().getOrNull()?.validity() ?: 0) +
                (mediaUrls.asKnown().getOrNull()?.size ?: 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (if (subject.asKnown().isPresent) 1 else 0) +
                (template.asKnown().getOrNull()?.validity() ?: 0) +
                (if (text.asKnown().isPresent) 1 else 0) +
                (to.asKnown().getOrNull()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                channel == other.channel &&
                channels == other.channels &&
                mediaUrls == other.mediaUrls &&
                scheduledAt == other.scheduledAt &&
                subject == other.subject &&
                template == other.template &&
                text == other.text &&
                to == other.to &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                channel,
                channels,
                mediaUrls,
                scheduledAt,
                subject,
                template,
                text,
                to,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, channel=$channel, channels=$channels, mediaUrls=$mediaUrls, scheduledAt=$scheduledAt, subject=$subject, template=$template, text=$text, to=$to, additionalProperties=$additionalProperties}"
    }

    /**
     * Which of your own numbers to send from, keyed by channel, each channel holding a list of
     * entries: {"sms": [{"country": "US", "from": ["+12125550000", "+14155550000"]}, {"from":
     * ["+447700800001"]}]}. Any real channel may be a key; sent, which is auto-detect rather than a
     * channel, is rejected. country and strategy are accepted and stored but not acted on yet:
     * every entry's numbers apply to every recipient on that channel.
     *
     * This does not choose channels — Channel does, and the two combine: "channel": ["sms"] with an
     * sms list sends on SMS from those numbers. Each list only narrows which of its own channel's
     * routes may win, so with Channel left at auto-detect a recipient best served by a channel with
     * no list still goes out on it. Routing itself is unchanged: the same rules are scored and
     * ranked the same way, with routes pinned to numbers you did not list removed from the running.
     *
     * Every number must be an active sender on your account. The request itself is still accepted
     * (202) if one is not — like every other send-time rule, that is decided per message, so each
     * affected message is recorded BLOCKED with error code BUSINESS_029 and reported on GET
     * /v3/messages and the status webhook.
     */
    class Channels
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Channels]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Channels]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(channels: Channels) = apply {
                additionalProperties = channels.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Channels].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Channels = Channels(additionalProperties.toImmutable())
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
        fun validate(): Channels = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Channels && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Channels{additionalProperties=$additionalProperties}"
    }

    /** SDK-style template reference: resolve by ID or by name, with optional parameters. */
    class Template
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val name: JsonField<String>,
        private val parameters: JsonField<Parameters>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("parameters")
            @ExcludeMissing
            parameters: JsonField<Parameters> = JsonMissing.of(),
        ) : this(id, name, parameters, mutableMapOf())

        /**
         * Template ID (mutually exclusive with name)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * Template name (mutually exclusive with id)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Template variable parameters for personalization, keyed by variable name.
         *
         * Every variable the template declares is required; GET /v3/templates/{id} lists them.
         * Supplying a key the template does not declare is ignored.
         *
         * Media headers. A template whose header is an image (designed in WhatsApp Manager and
         * imported into Sent) declares a reserved header_image key. Its value is a publicly
         * reachable https URL that Meta fetches at send time — Sent does not host the asset, and
         * the sample approved with the template is not reused. The key is derived from the header's
         * media type, so header_video and header_document follow the same shape when those formats
         * ship.
         *
         * "parameters": { "header_image": "https://cdn.example.com/banner.jpg", "name": "John Doe"
         * }
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun parameters(): Optional<Parameters> = parameters.getOptional("parameters")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

        /**
         * Returns the raw JSON value of [parameters].
         *
         * Unlike [parameters], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("parameters")
        @ExcludeMissing
        fun _parameters(): JsonField<Parameters> = parameters

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

            /** Returns a mutable builder for constructing an instance of [Template]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Template]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var parameters: JsonField<Parameters> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(template: Template) = apply {
                id = template.id
                name = template.name
                parameters = template.parameters
                additionalProperties = template.additionalProperties.toMutableMap()
            }

            /** Template ID (mutually exclusive with name) */
            fun id(id: String?) = id(JsonField.ofNullable(id))

            /** Alias for calling [Builder.id] with `id.orElse(null)`. */
            fun id(id: Optional<String>) = id(id.getOrNull())

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Template name (mutually exclusive with id) */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /**
             * Template variable parameters for personalization, keyed by variable name.
             *
             * Every variable the template declares is required; GET /v3/templates/{id} lists them.
             * Supplying a key the template does not declare is ignored.
             *
             * Media headers. A template whose header is an image (designed in WhatsApp Manager and
             * imported into Sent) declares a reserved header_image key. Its value is a publicly
             * reachable https URL that Meta fetches at send time — Sent does not host the asset,
             * and the sample approved with the template is not reused. The key is derived from the
             * header's media type, so header_video and header_document follow the same shape when
             * those formats ship.
             *
             * "parameters": { "header_image": "https://cdn.example.com/banner.jpg", "name": "John
             * Doe" }
             */
            fun parameters(parameters: Parameters?) = parameters(JsonField.ofNullable(parameters))

            /** Alias for calling [Builder.parameters] with `parameters.orElse(null)`. */
            fun parameters(parameters: Optional<Parameters>) = parameters(parameters.getOrNull())

            /**
             * Sets [Builder.parameters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.parameters] with a well-typed [Parameters] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun parameters(parameters: JsonField<Parameters>) = apply {
                this.parameters = parameters
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
             * Returns an immutable instance of [Template].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Template =
                Template(id, name, parameters, additionalProperties.toMutableMap())
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
        fun validate(): Template = apply {
            if (validated) {
                return@apply
            }

            id()
            name()
            parameters().ifPresent { it.validate() }
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (parameters.asKnown().getOrNull()?.validity() ?: 0)

        /**
         * Template variable parameters for personalization, keyed by variable name.
         *
         * Every variable the template declares is required; GET /v3/templates/{id} lists them.
         * Supplying a key the template does not declare is ignored.
         *
         * Media headers. A template whose header is an image (designed in WhatsApp Manager and
         * imported into Sent) declares a reserved header_image key. Its value is a publicly
         * reachable https URL that Meta fetches at send time — Sent does not host the asset, and
         * the sample approved with the template is not reused. The key is derived from the header's
         * media type, so header_video and header_document follow the same shape when those formats
         * ship.
         *
         * "parameters": { "header_image": "https://cdn.example.com/banner.jpg", "name": "John Doe"
         * }
         */
        class Parameters
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Parameters]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Parameters]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(parameters: Parameters) = apply {
                    additionalProperties = parameters.additionalProperties.toMutableMap()
                }

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
                 * Returns an immutable instance of [Parameters].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Parameters = Parameters(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Parameters = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Parameters && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Parameters{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Template &&
                id == other.id &&
                name == other.name &&
                parameters == other.parameters &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, name, parameters, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Template{id=$id, name=$name, parameters=$parameters, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageSendParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MessageSendParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
