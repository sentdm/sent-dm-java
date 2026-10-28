// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

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

/** One number the profile carries phone calls on. */
class VoiceNumberCreated
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val agentId: JsonField<String>,
    private val callbackUrl: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val defaultForAppCalls: JsonField<Boolean>,
    private val number: JsonField<String>,
    private val routesTo: JsonField<String>,
    private val status: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val callbackSecret: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("agent_id") @ExcludeMissing agentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("callback_url")
        @ExcludeMissing
        callbackUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("default_for_app_calls")
        @ExcludeMissing
        defaultForAppCalls: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
        @JsonProperty("routes_to") @ExcludeMissing routesTo: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("callback_secret")
        @ExcludeMissing
        callbackSecret: JsonField<String> = JsonMissing.of(),
    ) : this(
        agentId,
        callbackUrl,
        createdAt,
        defaultForAppCalls,
        number,
        routesTo,
        status,
        updatedAt,
        callbackSecret,
        mutableMapOf(),
    )

    fun toVoiceNumber(): VoiceNumber =
        VoiceNumber.builder()
            .agentId(agentId)
            .callbackUrl(callbackUrl)
            .createdAt(createdAt)
            .defaultForAppCalls(defaultForAppCalls)
            .number(number)
            .routesTo(routesTo)
            .status(status)
            .updatedAt(updatedAt)
            .build()

    /**
     * The voice agent calls to this number go to, such as
     * agent_9f2ab000-0000-4000-8000-000000000001. It wins over callback_url for calls to the
     * number; calls your app places from the number still follow your app. Null when no agent
     * answers the number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun agentId(): Optional<String> = agentId.getOptional("agent_id")

    /**
     * Where Sent asks what to do with each call on this number: a signed question is POSTed here
     * when a call arrives or a caller presses a key, and the answer decides the call. The signing
     * secret is not on this read; it is shown when voice is turned on and by the rotate endpoint.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun callbackUrl(): Optional<String> = callbackUrl.getOptional("callback_url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Whether this is the line app-originated calls are placed from when a voice token names no
     * number. Exactly one active voice number carries it while the profile has any.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun defaultForAppCalls(): Optional<Boolean> =
        defaultForAppCalls.getOptional("default_for_app_calls")

    /**
     * The number, in E.164.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun number(): Optional<String> = number.getOptional("number")

    /**
     * Who answers calls to this number: agent, the voice agent in agent_id; agent_pending, that
     * agent once the number has finished moving to it, with calls possibly unanswered until then;
     * callback, your callback_url; or none, in which case calls to it are declined.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun routesTo(): Optional<String> = routesTo.getOptional("routes_to")

    /**
     * ACTIVE while the number carries calls, INACTIVE once it was turned off. Nothing provisions: a
     * number the customer holds can carry calls the moment voice is turned on for it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

    /**
     * The whsec_ secret every question to callback_url is signed with. Shown here and by POST
     * /v3/channels/voice/{number}/rotate-secret, nowhere else: store it now. Verify a question
     * exactly as you verify a webhook, with X-Webhook-ID, X-Webhook-Timestamp and the body.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun callbackSecret(): Optional<String> = callbackSecret.getOptional("callback_secret")

    /**
     * Returns the raw JSON value of [agentId].
     *
     * Unlike [agentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("agent_id") @ExcludeMissing fun _agentId(): JsonField<String> = agentId

    /**
     * Returns the raw JSON value of [callbackUrl].
     *
     * Unlike [callbackUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("callback_url")
    @ExcludeMissing
    fun _callbackUrl(): JsonField<String> = callbackUrl

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [defaultForAppCalls].
     *
     * Unlike [defaultForAppCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("default_for_app_calls")
    @ExcludeMissing
    fun _defaultForAppCalls(): JsonField<Boolean> = defaultForAppCalls

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

    /**
     * Returns the raw JSON value of [routesTo].
     *
     * Unlike [routesTo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("routes_to") @ExcludeMissing fun _routesTo(): JsonField<String> = routesTo

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [callbackSecret].
     *
     * Unlike [callbackSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("callback_secret")
    @ExcludeMissing
    fun _callbackSecret(): JsonField<String> = callbackSecret

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

        /** Returns a mutable builder for constructing an instance of [VoiceNumberCreated]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceNumberCreated]. */
    class Builder internal constructor() {

        private var agentId: JsonField<String> = JsonMissing.of()
        private var callbackUrl: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var defaultForAppCalls: JsonField<Boolean> = JsonMissing.of()
        private var number: JsonField<String> = JsonMissing.of()
        private var routesTo: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var callbackSecret: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(voiceNumberCreated: VoiceNumberCreated) = apply {
            agentId = voiceNumberCreated.agentId
            callbackUrl = voiceNumberCreated.callbackUrl
            createdAt = voiceNumberCreated.createdAt
            defaultForAppCalls = voiceNumberCreated.defaultForAppCalls
            number = voiceNumberCreated.number
            routesTo = voiceNumberCreated.routesTo
            status = voiceNumberCreated.status
            updatedAt = voiceNumberCreated.updatedAt
            callbackSecret = voiceNumberCreated.callbackSecret
            additionalProperties = voiceNumberCreated.additionalProperties.toMutableMap()
        }

        /**
         * The voice agent calls to this number go to, such as
         * agent_9f2ab000-0000-4000-8000-000000000001. It wins over callback_url for calls to the
         * number; calls your app places from the number still follow your app. Null when no agent
         * answers the number.
         */
        fun agentId(agentId: String?) = agentId(JsonField.ofNullable(agentId))

        /** Alias for calling [Builder.agentId] with `agentId.orElse(null)`. */
        fun agentId(agentId: Optional<String>) = agentId(agentId.getOrNull())

        /**
         * Sets [Builder.agentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agentId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agentId(agentId: JsonField<String>) = apply { this.agentId = agentId }

        /**
         * Where Sent asks what to do with each call on this number: a signed question is POSTed
         * here when a call arrives or a caller presses a key, and the answer decides the call. The
         * signing secret is not on this read; it is shown when voice is turned on and by the rotate
         * endpoint.
         */
        fun callbackUrl(callbackUrl: String?) = callbackUrl(JsonField.ofNullable(callbackUrl))

        /** Alias for calling [Builder.callbackUrl] with `callbackUrl.orElse(null)`. */
        fun callbackUrl(callbackUrl: Optional<String>) = callbackUrl(callbackUrl.getOrNull())

        /**
         * Sets [Builder.callbackUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callbackUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun callbackUrl(callbackUrl: JsonField<String>) = apply { this.callbackUrl = callbackUrl }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /**
         * Whether this is the line app-originated calls are placed from when a voice token names no
         * number. Exactly one active voice number carries it while the profile has any.
         */
        fun defaultForAppCalls(defaultForAppCalls: Boolean) =
            defaultForAppCalls(JsonField.of(defaultForAppCalls))

        /**
         * Sets [Builder.defaultForAppCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.defaultForAppCalls] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun defaultForAppCalls(defaultForAppCalls: JsonField<Boolean>) = apply {
            this.defaultForAppCalls = defaultForAppCalls
        }

        /** The number, in E.164. */
        fun number(number: String) = number(JsonField.of(number))

        /**
         * Sets [Builder.number] to an arbitrary JSON value.
         *
         * You should usually call [Builder.number] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun number(number: JsonField<String>) = apply { this.number = number }

        /**
         * Who answers calls to this number: agent, the voice agent in agent_id; agent_pending, that
         * agent once the number has finished moving to it, with calls possibly unanswered until
         * then; callback, your callback_url; or none, in which case calls to it are declined.
         */
        fun routesTo(routesTo: String) = routesTo(JsonField.of(routesTo))

        /**
         * Sets [Builder.routesTo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.routesTo] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun routesTo(routesTo: JsonField<String>) = apply { this.routesTo = routesTo }

        /**
         * ACTIVE while the number carries calls, INACTIVE once it was turned off. Nothing
         * provisions: a number the customer holds can carry calls the moment voice is turned on for
         * it.
         */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /**
         * The whsec_ secret every question to callback_url is signed with. Shown here and by POST
         * /v3/channels/voice/{number}/rotate-secret, nowhere else: store it now. Verify a question
         * exactly as you verify a webhook, with X-Webhook-ID, X-Webhook-Timestamp and the body.
         */
        fun callbackSecret(callbackSecret: String) = callbackSecret(JsonField.of(callbackSecret))

        /**
         * Sets [Builder.callbackSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callbackSecret] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun callbackSecret(callbackSecret: JsonField<String>) = apply {
            this.callbackSecret = callbackSecret
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
         * Returns an immutable instance of [VoiceNumberCreated].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceNumberCreated =
            VoiceNumberCreated(
                agentId,
                callbackUrl,
                createdAt,
                defaultForAppCalls,
                number,
                routesTo,
                status,
                updatedAt,
                callbackSecret,
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
    fun validate(): VoiceNumberCreated = apply {
        if (validated) {
            return@apply
        }

        agentId()
        callbackUrl()
        createdAt()
        defaultForAppCalls()
        number()
        routesTo()
        status()
        updatedAt()
        callbackSecret()
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
        (if (agentId.asKnown().isPresent) 1 else 0) +
            (if (callbackUrl.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (defaultForAppCalls.asKnown().isPresent) 1 else 0) +
            (if (number.asKnown().isPresent) 1 else 0) +
            (if (routesTo.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (callbackSecret.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceNumberCreated &&
            agentId == other.agentId &&
            callbackUrl == other.callbackUrl &&
            createdAt == other.createdAt &&
            defaultForAppCalls == other.defaultForAppCalls &&
            number == other.number &&
            routesTo == other.routesTo &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            callbackSecret == other.callbackSecret &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            agentId,
            callbackUrl,
            createdAt,
            defaultForAppCalls,
            number,
            routesTo,
            status,
            updatedAt,
            callbackSecret,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VoiceNumberCreated{agentId=$agentId, callbackUrl=$callbackUrl, createdAt=$createdAt, defaultForAppCalls=$defaultForAppCalls, number=$number, routesTo=$routesTo, status=$status, updatedAt=$updatedAt, callbackSecret=$callbackSecret, additionalProperties=$additionalProperties}"
}
