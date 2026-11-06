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
 * Body of a link event: something happened to a tracked link Sent published on the customer's
 * behalf. A link points either at a URL the customer supplied or at a file Sent hosts for them;
 * LinkKind says which. Delivered when an eligible request is served, or when a published link
 * reaches the end of its life.
 *
 * A click is a request, not a read receipt. link.clicked means the redirect was served;
 * link.downloaded means bytes went out. Neither proves a person saw anything — messaging providers
 * and link scanners fetch URLs on their own, which is what TrafficClass exists to tell apart.
 * Filter on it before reporting a click-through rate; treat likely_human as a hint, never as
 * delivery confirmation.
 *
 * RecordId identifies the link; the X-Webhook-Event-ID header identifies the delivery. One link is
 * hit many times, so those are the two keys a subscriber needs: group by the first, deduplicate on
 * the second — exactly as on every other family. The payload carries no event identifier of its
 * own, for the same reason none of the others do.
 *
 * Nothing here identifies the visitor. No IP address and no visitor token crosses this boundary.
 * Country, Device and Browser are coarse buckets derived at the edge and are absent whenever the
 * request did not supply enough to derive them.
 */
class LinkEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val recordId: JsonField<String>,
    private val accessCountry: JsonField<String>,
    private val accessOutcome: JsonField<String>,
    private val browser: JsonField<String>,
    private val bytesServed: JsonField<Long>,
    private val channel: JsonField<String>,
    private val customerId: JsonField<String>,
    private val device: JsonField<String>,
    private val linkKind: JsonField<String>,
    private val messageId: JsonField<String>,
    private val occurredAt: JsonField<String>,
    private val referenceKey: JsonField<String>,
    private val referrerHost: JsonField<String>,
    private val requestMethod: JsonField<String>,
    private val senderProfileId: JsonField<String>,
    private val statusCode: JsonField<Int>,
    private val trafficClass: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("record_id") @ExcludeMissing recordId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("access_country")
        @ExcludeMissing
        accessCountry: JsonField<String> = JsonMissing.of(),
        @JsonProperty("access_outcome")
        @ExcludeMissing
        accessOutcome: JsonField<String> = JsonMissing.of(),
        @JsonProperty("browser") @ExcludeMissing browser: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bytes_served")
        @ExcludeMissing
        bytesServed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customer_id")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("device") @ExcludeMissing device: JsonField<String> = JsonMissing.of(),
        @JsonProperty("link_kind") @ExcludeMissing linkKind: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("occurred_at")
        @ExcludeMissing
        occurredAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reference_key")
        @ExcludeMissing
        referenceKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("referrer_host")
        @ExcludeMissing
        referrerHost: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request_method")
        @ExcludeMissing
        requestMethod: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sender_profile_id")
        @ExcludeMissing
        senderProfileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status_code") @ExcludeMissing statusCode: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("traffic_class")
        @ExcludeMissing
        trafficClass: JsonField<String> = JsonMissing.of(),
    ) : this(
        recordId,
        accessCountry,
        accessOutcome,
        browser,
        bytesServed,
        channel,
        customerId,
        device,
        linkKind,
        messageId,
        occurredAt,
        referenceKey,
        referrerHost,
        requestMethod,
        senderProfileId,
        statusCode,
        trafficClass,
        mutableMapOf(),
    )

    /**
     * The link's public identifier — the eight-character code in the short URL, for example
     * A78B2BU0. Unique across both kinds, and never reused, so it is the stable key to group one
     * link's events by.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recordId(): String = recordId.getRequired("record_id")

    /**
     * Where the request appeared to come from, as an ISO 3166-1 alpha-2 code. Named separately from
     * the country on a channel event, which is a destination market the customer registered for —
     * this one is a property of a single visitor and is absent when the edge could not resolve it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accessCountry(): Optional<String> = accessCountry.getOptional("access_country")

    /**
     * How the request was served, when the edge recorded it. Free text describing the outcome —
     * show it to a human rather than branching on it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accessOutcome(): Optional<String> = accessOutcome.getOptional("access_outcome")

    /**
     * The requesting browser family, for example chrome or safari, or unknown. Derived from the
     * user agent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun browser(): Optional<String> = browser.getOptional("browser")

    /**
     * How many bytes were served, for a file access. A ranged request reports the bytes in that
     * range, not the size of the file, so several accesses of one file can each report a part.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun bytesServed(): Optional<Long> = bytesServed.getOptional("bytes_served")

    /**
     * The channel the message carrying this link went out on: sms, whatsapp, or rcs.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * The organization the link belongs to. Always the parent account, never a sender profile —
     * read SenderProfileId for that.
     *
     * This family publishes the owner as an explicit pair rather than the single account_id the
     * other families use. The pair says which organization and which profile without the subscriber
     * deriving either, which is the trade: one more key against not having to know that account_id
     * silently becomes the profile when one exists.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customer_id")

    /**
     * The requesting device class: mobile, tablet, desktop or unknown. Derived from the user agent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun device(): Optional<String> = device.getOptional("device")

    /**
     * What the link points at: url for a destination the customer supplied, file for media Sent
     * hosts. Always present, and implied by the event — link.clicked is always url and
     * link.downloaded always file — but published as its own field so a subscriber can branch on
     * the kind without parsing the event name, the same separation the channel family keeps between
     * its event and its status.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun linkKind(): Optional<String> = linkKind.getOptional("link_kind")

    /**
     * The message the link was published in.
     *
     * The event can arrive before the message is readable through GET /v3/messages: a provider may
     * fetch a link within milliseconds of the send, and nothing here waits for the message row.
     * Retry the read rather than treating an unknown id as an error.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun messageId(): Optional<String> = messageId.getOptional("message_id")

    /**
     * When the access or lifecycle change actually happened, in UTC (yyyy-MM-ddTHH:mm:ssZ). The
     * envelope's timestamp is when Sent emitted the event; this is when the thing occurred, and the
     * two differ by the ingest delay.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun occurredAt(): Optional<String> = occurredAt.getOptional("occurred_at")

    /**
     * The caller-supplied label tying this link back to a position in the message, for example
     * body:0 for the first link in the body. Present when the link was created with one.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun referenceKey(): Optional<String> = referenceKey.getOptional("reference_key")

    /**
     * The host of the page that linked here, when the request supplied one. The host only — never a
     * full referring URL.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun referrerHost(): Optional<String> = referrerHost.getOptional("referrer_host")

    /**
     * The HTTP method of the request that was served, for an access event. Omitted on link.expired
     * and link.revoked, which describe no request.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun requestMethod(): Optional<String> = requestMethod.getOptional("request_method")

    /**
     * The sender profile that owns the link, or null when the organization owns it directly. Always
     * on the wire so a handler reads one shape rather than branching on whether the key arrived.
     *
     * sender_profile_id, not profile_id: the API already publishes messaging_profile_id and
     * sending_phone_number_profile_id for provider-side profiles, which are a different thing
     * entirely. The unqualified name would read as one of those.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderProfileId(): Optional<String> = senderProfileId.getOptional("sender_profile_id")

    /**
     * The HTTP status Sent answered the request with: 302 for a link, 200 or 206 for a file.
     * Omitted on lifecycle events.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun statusCode(): Optional<Int> = statusCode.getOptional("status_code")

    /**
     * A coarse guess at what made the request: likely_human, provider (a messaging platform
     * prefetching the link), bot, or unknown. Derived from the user agent, so it is a hint for
     * filtering noise rather than a fact to bill or report on.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun trafficClass(): Optional<String> = trafficClass.getOptional("traffic_class")

    /**
     * Returns the raw JSON value of [recordId].
     *
     * Unlike [recordId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("record_id") @ExcludeMissing fun _recordId(): JsonField<String> = recordId

    /**
     * Returns the raw JSON value of [accessCountry].
     *
     * Unlike [accessCountry], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("access_country")
    @ExcludeMissing
    fun _accessCountry(): JsonField<String> = accessCountry

    /**
     * Returns the raw JSON value of [accessOutcome].
     *
     * Unlike [accessOutcome], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("access_outcome")
    @ExcludeMissing
    fun _accessOutcome(): JsonField<String> = accessOutcome

    /**
     * Returns the raw JSON value of [browser].
     *
     * Unlike [browser], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("browser") @ExcludeMissing fun _browser(): JsonField<String> = browser

    /**
     * Returns the raw JSON value of [bytesServed].
     *
     * Unlike [bytesServed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bytes_served") @ExcludeMissing fun _bytesServed(): JsonField<Long> = bytesServed

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customer_id") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

    /**
     * Returns the raw JSON value of [device].
     *
     * Unlike [device], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("device") @ExcludeMissing fun _device(): JsonField<String> = device

    /**
     * Returns the raw JSON value of [linkKind].
     *
     * Unlike [linkKind], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("link_kind") @ExcludeMissing fun _linkKind(): JsonField<String> = linkKind

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    /**
     * Returns the raw JSON value of [occurredAt].
     *
     * Unlike [occurredAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("occurred_at") @ExcludeMissing fun _occurredAt(): JsonField<String> = occurredAt

    /**
     * Returns the raw JSON value of [referenceKey].
     *
     * Unlike [referenceKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reference_key")
    @ExcludeMissing
    fun _referenceKey(): JsonField<String> = referenceKey

    /**
     * Returns the raw JSON value of [referrerHost].
     *
     * Unlike [referrerHost], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("referrer_host")
    @ExcludeMissing
    fun _referrerHost(): JsonField<String> = referrerHost

    /**
     * Returns the raw JSON value of [requestMethod].
     *
     * Unlike [requestMethod], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_method")
    @ExcludeMissing
    fun _requestMethod(): JsonField<String> = requestMethod

    /**
     * Returns the raw JSON value of [senderProfileId].
     *
     * Unlike [senderProfileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_profile_id")
    @ExcludeMissing
    fun _senderProfileId(): JsonField<String> = senderProfileId

    /**
     * Returns the raw JSON value of [statusCode].
     *
     * Unlike [statusCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status_code") @ExcludeMissing fun _statusCode(): JsonField<Int> = statusCode

    /**
     * Returns the raw JSON value of [trafficClass].
     *
     * Unlike [trafficClass], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("traffic_class")
    @ExcludeMissing
    fun _trafficClass(): JsonField<String> = trafficClass

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
         * Returns a mutable builder for constructing an instance of [LinkEventPayload].
         *
         * The following fields are required:
         * ```java
         * .recordId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LinkEventPayload]. */
    class Builder internal constructor() {

        private var recordId: JsonField<String>? = null
        private var accessCountry: JsonField<String> = JsonMissing.of()
        private var accessOutcome: JsonField<String> = JsonMissing.of()
        private var browser: JsonField<String> = JsonMissing.of()
        private var bytesServed: JsonField<Long> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var customerId: JsonField<String> = JsonMissing.of()
        private var device: JsonField<String> = JsonMissing.of()
        private var linkKind: JsonField<String> = JsonMissing.of()
        private var messageId: JsonField<String> = JsonMissing.of()
        private var occurredAt: JsonField<String> = JsonMissing.of()
        private var referenceKey: JsonField<String> = JsonMissing.of()
        private var referrerHost: JsonField<String> = JsonMissing.of()
        private var requestMethod: JsonField<String> = JsonMissing.of()
        private var senderProfileId: JsonField<String> = JsonMissing.of()
        private var statusCode: JsonField<Int> = JsonMissing.of()
        private var trafficClass: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(linkEventPayload: LinkEventPayload) = apply {
            recordId = linkEventPayload.recordId
            accessCountry = linkEventPayload.accessCountry
            accessOutcome = linkEventPayload.accessOutcome
            browser = linkEventPayload.browser
            bytesServed = linkEventPayload.bytesServed
            channel = linkEventPayload.channel
            customerId = linkEventPayload.customerId
            device = linkEventPayload.device
            linkKind = linkEventPayload.linkKind
            messageId = linkEventPayload.messageId
            occurredAt = linkEventPayload.occurredAt
            referenceKey = linkEventPayload.referenceKey
            referrerHost = linkEventPayload.referrerHost
            requestMethod = linkEventPayload.requestMethod
            senderProfileId = linkEventPayload.senderProfileId
            statusCode = linkEventPayload.statusCode
            trafficClass = linkEventPayload.trafficClass
            additionalProperties = linkEventPayload.additionalProperties.toMutableMap()
        }

        /**
         * The link's public identifier — the eight-character code in the short URL, for example
         * A78B2BU0. Unique across both kinds, and never reused, so it is the stable key to group
         * one link's events by.
         */
        fun recordId(recordId: String) = recordId(JsonField.of(recordId))

        /**
         * Sets [Builder.recordId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recordId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun recordId(recordId: JsonField<String>) = apply { this.recordId = recordId }

        /**
         * Where the request appeared to come from, as an ISO 3166-1 alpha-2 code. Named separately
         * from the country on a channel event, which is a destination market the customer
         * registered for — this one is a property of a single visitor and is absent when the edge
         * could not resolve it.
         */
        fun accessCountry(accessCountry: String?) =
            accessCountry(JsonField.ofNullable(accessCountry))

        /** Alias for calling [Builder.accessCountry] with `accessCountry.orElse(null)`. */
        fun accessCountry(accessCountry: Optional<String>) =
            accessCountry(accessCountry.getOrNull())

        /**
         * Sets [Builder.accessCountry] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accessCountry] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accessCountry(accessCountry: JsonField<String>) = apply {
            this.accessCountry = accessCountry
        }

        /**
         * How the request was served, when the edge recorded it. Free text describing the outcome —
         * show it to a human rather than branching on it.
         */
        fun accessOutcome(accessOutcome: String?) =
            accessOutcome(JsonField.ofNullable(accessOutcome))

        /** Alias for calling [Builder.accessOutcome] with `accessOutcome.orElse(null)`. */
        fun accessOutcome(accessOutcome: Optional<String>) =
            accessOutcome(accessOutcome.getOrNull())

        /**
         * Sets [Builder.accessOutcome] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accessOutcome] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accessOutcome(accessOutcome: JsonField<String>) = apply {
            this.accessOutcome = accessOutcome
        }

        /**
         * The requesting browser family, for example chrome or safari, or unknown. Derived from the
         * user agent.
         */
        fun browser(browser: String?) = browser(JsonField.ofNullable(browser))

        /** Alias for calling [Builder.browser] with `browser.orElse(null)`. */
        fun browser(browser: Optional<String>) = browser(browser.getOrNull())

        /**
         * Sets [Builder.browser] to an arbitrary JSON value.
         *
         * You should usually call [Builder.browser] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun browser(browser: JsonField<String>) = apply { this.browser = browser }

        /**
         * How many bytes were served, for a file access. A ranged request reports the bytes in that
         * range, not the size of the file, so several accesses of one file can each report a part.
         */
        fun bytesServed(bytesServed: Long?) = bytesServed(JsonField.ofNullable(bytesServed))

        /**
         * Alias for [Builder.bytesServed].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun bytesServed(bytesServed: Long) = bytesServed(bytesServed as Long?)

        /** Alias for calling [Builder.bytesServed] with `bytesServed.orElse(null)`. */
        fun bytesServed(bytesServed: Optional<Long>) = bytesServed(bytesServed.getOrNull())

        /**
         * Sets [Builder.bytesServed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bytesServed] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bytesServed(bytesServed: JsonField<Long>) = apply { this.bytesServed = bytesServed }

        /** The channel the message carrying this link went out on: sms, whatsapp, or rcs. */
        fun channel(channel: String?) = channel(JsonField.ofNullable(channel))

        /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
        fun channel(channel: Optional<String>) = channel(channel.getOrNull())

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /**
         * The organization the link belongs to. Always the parent account, never a sender profile —
         * read SenderProfileId for that.
         *
         * This family publishes the owner as an explicit pair rather than the single account_id the
         * other families use. The pair says which organization and which profile without the
         * subscriber deriving either, which is the trade: one more key against not having to know
         * that account_id silently becomes the profile when one exists.
         */
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
         * The requesting device class: mobile, tablet, desktop or unknown. Derived from the user
         * agent.
         */
        fun device(device: String?) = device(JsonField.ofNullable(device))

        /** Alias for calling [Builder.device] with `device.orElse(null)`. */
        fun device(device: Optional<String>) = device(device.getOrNull())

        /**
         * Sets [Builder.device] to an arbitrary JSON value.
         *
         * You should usually call [Builder.device] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun device(device: JsonField<String>) = apply { this.device = device }

        /**
         * What the link points at: url for a destination the customer supplied, file for media Sent
         * hosts. Always present, and implied by the event — link.clicked is always url and
         * link.downloaded always file — but published as its own field so a subscriber can branch
         * on the kind without parsing the event name, the same separation the channel family keeps
         * between its event and its status.
         */
        fun linkKind(linkKind: String) = linkKind(JsonField.of(linkKind))

        /**
         * Sets [Builder.linkKind] to an arbitrary JSON value.
         *
         * You should usually call [Builder.linkKind] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun linkKind(linkKind: JsonField<String>) = apply { this.linkKind = linkKind }

        /**
         * The message the link was published in.
         *
         * The event can arrive before the message is readable through GET /v3/messages: a provider
         * may fetch a link within milliseconds of the send, and nothing here waits for the message
         * row. Retry the read rather than treating an unknown id as an error.
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
         * When the access or lifecycle change actually happened, in UTC (yyyy-MM-ddTHH:mm:ssZ). The
         * envelope's timestamp is when Sent emitted the event; this is when the thing occurred, and
         * the two differ by the ingest delay.
         */
        fun occurredAt(occurredAt: String) = occurredAt(JsonField.of(occurredAt))

        /**
         * Sets [Builder.occurredAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.occurredAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun occurredAt(occurredAt: JsonField<String>) = apply { this.occurredAt = occurredAt }

        /**
         * The caller-supplied label tying this link back to a position in the message, for example
         * body:0 for the first link in the body. Present when the link was created with one.
         */
        fun referenceKey(referenceKey: String?) = referenceKey(JsonField.ofNullable(referenceKey))

        /** Alias for calling [Builder.referenceKey] with `referenceKey.orElse(null)`. */
        fun referenceKey(referenceKey: Optional<String>) = referenceKey(referenceKey.getOrNull())

        /**
         * Sets [Builder.referenceKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.referenceKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun referenceKey(referenceKey: JsonField<String>) = apply {
            this.referenceKey = referenceKey
        }

        /**
         * The host of the page that linked here, when the request supplied one. The host only —
         * never a full referring URL.
         */
        fun referrerHost(referrerHost: String?) = referrerHost(JsonField.ofNullable(referrerHost))

        /** Alias for calling [Builder.referrerHost] with `referrerHost.orElse(null)`. */
        fun referrerHost(referrerHost: Optional<String>) = referrerHost(referrerHost.getOrNull())

        /**
         * Sets [Builder.referrerHost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.referrerHost] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun referrerHost(referrerHost: JsonField<String>) = apply {
            this.referrerHost = referrerHost
        }

        /**
         * The HTTP method of the request that was served, for an access event. Omitted on
         * link.expired and link.revoked, which describe no request.
         */
        fun requestMethod(requestMethod: String?) =
            requestMethod(JsonField.ofNullable(requestMethod))

        /** Alias for calling [Builder.requestMethod] with `requestMethod.orElse(null)`. */
        fun requestMethod(requestMethod: Optional<String>) =
            requestMethod(requestMethod.getOrNull())

        /**
         * Sets [Builder.requestMethod] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestMethod] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestMethod(requestMethod: JsonField<String>) = apply {
            this.requestMethod = requestMethod
        }

        /**
         * The sender profile that owns the link, or null when the organization owns it directly.
         * Always on the wire so a handler reads one shape rather than branching on whether the key
         * arrived.
         *
         * sender_profile_id, not profile_id: the API already publishes messaging_profile_id and
         * sending_phone_number_profile_id for provider-side profiles, which are a different thing
         * entirely. The unqualified name would read as one of those.
         */
        fun senderProfileId(senderProfileId: String?) =
            senderProfileId(JsonField.ofNullable(senderProfileId))

        /** Alias for calling [Builder.senderProfileId] with `senderProfileId.orElse(null)`. */
        fun senderProfileId(senderProfileId: Optional<String>) =
            senderProfileId(senderProfileId.getOrNull())

        /**
         * Sets [Builder.senderProfileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderProfileId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun senderProfileId(senderProfileId: JsonField<String>) = apply {
            this.senderProfileId = senderProfileId
        }

        /**
         * The HTTP status Sent answered the request with: 302 for a link, 200 or 206 for a file.
         * Omitted on lifecycle events.
         */
        fun statusCode(statusCode: Int?) = statusCode(JsonField.ofNullable(statusCode))

        /**
         * Alias for [Builder.statusCode].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun statusCode(statusCode: Int) = statusCode(statusCode as Int?)

        /** Alias for calling [Builder.statusCode] with `statusCode.orElse(null)`. */
        fun statusCode(statusCode: Optional<Int>) = statusCode(statusCode.getOrNull())

        /**
         * Sets [Builder.statusCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.statusCode] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun statusCode(statusCode: JsonField<Int>) = apply { this.statusCode = statusCode }

        /**
         * A coarse guess at what made the request: likely_human, provider (a messaging platform
         * prefetching the link), bot, or unknown. Derived from the user agent, so it is a hint for
         * filtering noise rather than a fact to bill or report on.
         */
        fun trafficClass(trafficClass: String?) = trafficClass(JsonField.ofNullable(trafficClass))

        /** Alias for calling [Builder.trafficClass] with `trafficClass.orElse(null)`. */
        fun trafficClass(trafficClass: Optional<String>) = trafficClass(trafficClass.getOrNull())

        /**
         * Sets [Builder.trafficClass] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trafficClass] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun trafficClass(trafficClass: JsonField<String>) = apply {
            this.trafficClass = trafficClass
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
         * Returns an immutable instance of [LinkEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .recordId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): LinkEventPayload =
            LinkEventPayload(
                checkRequired("recordId", recordId),
                accessCountry,
                accessOutcome,
                browser,
                bytesServed,
                channel,
                customerId,
                device,
                linkKind,
                messageId,
                occurredAt,
                referenceKey,
                referrerHost,
                requestMethod,
                senderProfileId,
                statusCode,
                trafficClass,
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
    fun validate(): LinkEventPayload = apply {
        if (validated) {
            return@apply
        }

        recordId()
        accessCountry()
        accessOutcome()
        browser()
        bytesServed()
        channel()
        customerId()
        device()
        linkKind()
        messageId()
        occurredAt()
        referenceKey()
        referrerHost()
        requestMethod()
        senderProfileId()
        statusCode()
        trafficClass()
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
        (if (recordId.asKnown().isPresent) 1 else 0) +
            (if (accessCountry.asKnown().isPresent) 1 else 0) +
            (if (accessOutcome.asKnown().isPresent) 1 else 0) +
            (if (browser.asKnown().isPresent) 1 else 0) +
            (if (bytesServed.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (if (device.asKnown().isPresent) 1 else 0) +
            (if (linkKind.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0) +
            (if (occurredAt.asKnown().isPresent) 1 else 0) +
            (if (referenceKey.asKnown().isPresent) 1 else 0) +
            (if (referrerHost.asKnown().isPresent) 1 else 0) +
            (if (requestMethod.asKnown().isPresent) 1 else 0) +
            (if (senderProfileId.asKnown().isPresent) 1 else 0) +
            (if (statusCode.asKnown().isPresent) 1 else 0) +
            (if (trafficClass.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LinkEventPayload &&
            recordId == other.recordId &&
            accessCountry == other.accessCountry &&
            accessOutcome == other.accessOutcome &&
            browser == other.browser &&
            bytesServed == other.bytesServed &&
            channel == other.channel &&
            customerId == other.customerId &&
            device == other.device &&
            linkKind == other.linkKind &&
            messageId == other.messageId &&
            occurredAt == other.occurredAt &&
            referenceKey == other.referenceKey &&
            referrerHost == other.referrerHost &&
            requestMethod == other.requestMethod &&
            senderProfileId == other.senderProfileId &&
            statusCode == other.statusCode &&
            trafficClass == other.trafficClass &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            recordId,
            accessCountry,
            accessOutcome,
            browser,
            bytesServed,
            channel,
            customerId,
            device,
            linkKind,
            messageId,
            occurredAt,
            referenceKey,
            referrerHost,
            requestMethod,
            senderProfileId,
            statusCode,
            trafficClass,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "LinkEventPayload{recordId=$recordId, accessCountry=$accessCountry, accessOutcome=$accessOutcome, browser=$browser, bytesServed=$bytesServed, channel=$channel, customerId=$customerId, device=$device, linkKind=$linkKind, messageId=$messageId, occurredAt=$occurredAt, referenceKey=$referenceKey, referrerHost=$referrerHost, requestMethod=$requestMethod, senderProfileId=$senderProfileId, statusCode=$statusCode, trafficClass=$trafficClass, additionalProperties=$additionalProperties}"
}
