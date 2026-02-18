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
import dm.sent.core.toImmutable
import dm.sent.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class WebhookResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val consecutiveFailures: JsonField<Int>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val displayName: JsonField<String>,
    private val endpointUrl: JsonField<String>,
    private val eventTypes: JsonField<List<String>>,
    private val isActive: JsonField<Boolean>,
    private val lastDeliveryAttemptAt: JsonField<OffsetDateTime>,
    private val lastSuccessfulDeliveryAt: JsonField<OffsetDateTime>,
    private val retryCount: JsonField<Int>,
    private val signingSecret: JsonField<String>,
    private val timeoutSeconds: JsonField<Int>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("consecutive_failures")
        @ExcludeMissing
        consecutiveFailures: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("created_at")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("display_name")
        @ExcludeMissing
        displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("endpoint_url")
        @ExcludeMissing
        endpointUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event_types")
        @ExcludeMissing
        eventTypes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("is_active") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_delivery_attempt_at")
        @ExcludeMissing
        lastDeliveryAttemptAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("last_successful_delivery_at")
        @ExcludeMissing
        lastSuccessfulDeliveryAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("retry_count") @ExcludeMissing retryCount: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("signing_secret")
        @ExcludeMissing
        signingSecret: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timeout_seconds")
        @ExcludeMissing
        timeoutSeconds: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(
        id,
        consecutiveFailures,
        createdAt,
        displayName,
        endpointUrl,
        eventTypes,
        isActive,
        lastDeliveryAttemptAt,
        lastSuccessfulDeliveryAt,
        retryCount,
        signingSecret,
        timeoutSeconds,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun consecutiveFailures(): Optional<Int> =
        consecutiveFailures.getOptional("consecutive_failures")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun displayName(): Optional<String> = displayName.getOptional("display_name")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endpointUrl(): Optional<String> = endpointUrl.getOptional("endpoint_url")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventTypes(): Optional<List<String>> = eventTypes.getOptional("event_types")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isActive(): Optional<Boolean> = isActive.getOptional("is_active")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastDeliveryAttemptAt(): Optional<OffsetDateTime> =
        lastDeliveryAttemptAt.getOptional("last_delivery_attempt_at")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastSuccessfulDeliveryAt(): Optional<OffsetDateTime> =
        lastSuccessfulDeliveryAt.getOptional("last_successful_delivery_at")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun retryCount(): Optional<Int> = retryCount.getOptional("retry_count")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun signingSecret(): Optional<String> = signingSecret.getOptional("signing_secret")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timeoutSeconds(): Optional<Int> = timeoutSeconds.getOptional("timeout_seconds")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [consecutiveFailures].
     *
     * Unlike [consecutiveFailures], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("consecutive_failures")
    @ExcludeMissing
    fun _consecutiveFailures(): JsonField<Int> = consecutiveFailures

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [displayName].
     *
     * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("display_name")
    @ExcludeMissing
    fun _displayName(): JsonField<String> = displayName

    /**
     * Returns the raw JSON value of [endpointUrl].
     *
     * Unlike [endpointUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("endpoint_url")
    @ExcludeMissing
    fun _endpointUrl(): JsonField<String> = endpointUrl

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_types")
    @ExcludeMissing
    fun _eventTypes(): JsonField<List<String>> = eventTypes

    /**
     * Returns the raw JSON value of [isActive].
     *
     * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_active") @ExcludeMissing fun _isActive(): JsonField<Boolean> = isActive

    /**
     * Returns the raw JSON value of [lastDeliveryAttemptAt].
     *
     * Unlike [lastDeliveryAttemptAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("last_delivery_attempt_at")
    @ExcludeMissing
    fun _lastDeliveryAttemptAt(): JsonField<OffsetDateTime> = lastDeliveryAttemptAt

    /**
     * Returns the raw JSON value of [lastSuccessfulDeliveryAt].
     *
     * Unlike [lastSuccessfulDeliveryAt], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("last_successful_delivery_at")
    @ExcludeMissing
    fun _lastSuccessfulDeliveryAt(): JsonField<OffsetDateTime> = lastSuccessfulDeliveryAt

    /**
     * Returns the raw JSON value of [retryCount].
     *
     * Unlike [retryCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("retry_count") @ExcludeMissing fun _retryCount(): JsonField<Int> = retryCount

    /**
     * Returns the raw JSON value of [signingSecret].
     *
     * Unlike [signingSecret], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("signing_secret")
    @ExcludeMissing
    fun _signingSecret(): JsonField<String> = signingSecret

    /**
     * Returns the raw JSON value of [timeoutSeconds].
     *
     * Unlike [timeoutSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timeout_seconds")
    @ExcludeMissing
    fun _timeoutSeconds(): JsonField<Int> = timeoutSeconds

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

        /** Returns a mutable builder for constructing an instance of [WebhookResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var consecutiveFailures: JsonField<Int> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var endpointUrl: JsonField<String> = JsonMissing.of()
        private var eventTypes: JsonField<MutableList<String>>? = null
        private var isActive: JsonField<Boolean> = JsonMissing.of()
        private var lastDeliveryAttemptAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastSuccessfulDeliveryAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var retryCount: JsonField<Int> = JsonMissing.of()
        private var signingSecret: JsonField<String> = JsonMissing.of()
        private var timeoutSeconds: JsonField<Int> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookResponse: WebhookResponse) = apply {
            id = webhookResponse.id
            consecutiveFailures = webhookResponse.consecutiveFailures
            createdAt = webhookResponse.createdAt
            displayName = webhookResponse.displayName
            endpointUrl = webhookResponse.endpointUrl
            eventTypes = webhookResponse.eventTypes.map { it.toMutableList() }
            isActive = webhookResponse.isActive
            lastDeliveryAttemptAt = webhookResponse.lastDeliveryAttemptAt
            lastSuccessfulDeliveryAt = webhookResponse.lastSuccessfulDeliveryAt
            retryCount = webhookResponse.retryCount
            signingSecret = webhookResponse.signingSecret
            timeoutSeconds = webhookResponse.timeoutSeconds
            updatedAt = webhookResponse.updatedAt
            additionalProperties = webhookResponse.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun consecutiveFailures(consecutiveFailures: Int) =
            consecutiveFailures(JsonField.of(consecutiveFailures))

        /**
         * Sets [Builder.consecutiveFailures] to an arbitrary JSON value.
         *
         * You should usually call [Builder.consecutiveFailures] with a well-typed [Int] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun consecutiveFailures(consecutiveFailures: JsonField<Int>) = apply {
            this.consecutiveFailures = consecutiveFailures
        }

        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun displayName(displayName: String) = displayName(JsonField.of(displayName))

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        fun endpointUrl(endpointUrl: String) = endpointUrl(JsonField.of(endpointUrl))

        /**
         * Sets [Builder.endpointUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endpointUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun endpointUrl(endpointUrl: JsonField<String>) = apply { this.endpointUrl = endpointUrl }

        fun eventTypes(eventTypes: List<String>) = eventTypes(JsonField.of(eventTypes))

        /**
         * Sets [Builder.eventTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventTypes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventTypes(eventTypes: JsonField<List<String>>) = apply {
            this.eventTypes = eventTypes.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: String) = apply {
            eventTypes =
                (eventTypes ?: JsonField.of(mutableListOf())).also {
                    checkKnown("eventTypes", it).add(eventType)
                }
        }

        fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

        /**
         * Sets [Builder.isActive] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isActive] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

        fun lastDeliveryAttemptAt(lastDeliveryAttemptAt: OffsetDateTime?) =
            lastDeliveryAttemptAt(JsonField.ofNullable(lastDeliveryAttemptAt))

        /**
         * Alias for calling [Builder.lastDeliveryAttemptAt] with
         * `lastDeliveryAttemptAt.orElse(null)`.
         */
        fun lastDeliveryAttemptAt(lastDeliveryAttemptAt: Optional<OffsetDateTime>) =
            lastDeliveryAttemptAt(lastDeliveryAttemptAt.getOrNull())

        /**
         * Sets [Builder.lastDeliveryAttemptAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastDeliveryAttemptAt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun lastDeliveryAttemptAt(lastDeliveryAttemptAt: JsonField<OffsetDateTime>) = apply {
            this.lastDeliveryAttemptAt = lastDeliveryAttemptAt
        }

        fun lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt: OffsetDateTime?) =
            lastSuccessfulDeliveryAt(JsonField.ofNullable(lastSuccessfulDeliveryAt))

        /**
         * Alias for calling [Builder.lastSuccessfulDeliveryAt] with
         * `lastSuccessfulDeliveryAt.orElse(null)`.
         */
        fun lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt: Optional<OffsetDateTime>) =
            lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt.getOrNull())

        /**
         * Sets [Builder.lastSuccessfulDeliveryAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastSuccessfulDeliveryAt] with a well-typed
         * [OffsetDateTime] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt: JsonField<OffsetDateTime>) = apply {
            this.lastSuccessfulDeliveryAt = lastSuccessfulDeliveryAt
        }

        fun retryCount(retryCount: Int) = retryCount(JsonField.of(retryCount))

        /**
         * Sets [Builder.retryCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retryCount] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun retryCount(retryCount: JsonField<Int>) = apply { this.retryCount = retryCount }

        fun signingSecret(signingSecret: String?) =
            signingSecret(JsonField.ofNullable(signingSecret))

        /** Alias for calling [Builder.signingSecret] with `signingSecret.orElse(null)`. */
        fun signingSecret(signingSecret: Optional<String>) =
            signingSecret(signingSecret.getOrNull())

        /**
         * Sets [Builder.signingSecret] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signingSecret] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signingSecret(signingSecret: JsonField<String>) = apply {
            this.signingSecret = signingSecret
        }

        fun timeoutSeconds(timeoutSeconds: Int) = timeoutSeconds(JsonField.of(timeoutSeconds))

        /**
         * Sets [Builder.timeoutSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timeoutSeconds] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun timeoutSeconds(timeoutSeconds: JsonField<Int>) = apply {
            this.timeoutSeconds = timeoutSeconds
        }

        fun updatedAt(updatedAt: OffsetDateTime?) = updatedAt(JsonField.ofNullable(updatedAt))

        /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
        fun updatedAt(updatedAt: Optional<OffsetDateTime>) = updatedAt(updatedAt.getOrNull())

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [WebhookResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookResponse =
            WebhookResponse(
                id,
                consecutiveFailures,
                createdAt,
                displayName,
                endpointUrl,
                (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
                isActive,
                lastDeliveryAttemptAt,
                lastSuccessfulDeliveryAt,
                retryCount,
                signingSecret,
                timeoutSeconds,
                updatedAt,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WebhookResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        consecutiveFailures()
        createdAt()
        displayName()
        endpointUrl()
        eventTypes()
        isActive()
        lastDeliveryAttemptAt()
        lastSuccessfulDeliveryAt()
        retryCount()
        signingSecret()
        timeoutSeconds()
        updatedAt()
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
            (if (consecutiveFailures.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (displayName.asKnown().isPresent) 1 else 0) +
            (if (endpointUrl.asKnown().isPresent) 1 else 0) +
            (eventTypes.asKnown().getOrNull()?.size ?: 0) +
            (if (isActive.asKnown().isPresent) 1 else 0) +
            (if (lastDeliveryAttemptAt.asKnown().isPresent) 1 else 0) +
            (if (lastSuccessfulDeliveryAt.asKnown().isPresent) 1 else 0) +
            (if (retryCount.asKnown().isPresent) 1 else 0) +
            (if (signingSecret.asKnown().isPresent) 1 else 0) +
            (if (timeoutSeconds.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookResponse &&
            id == other.id &&
            consecutiveFailures == other.consecutiveFailures &&
            createdAt == other.createdAt &&
            displayName == other.displayName &&
            endpointUrl == other.endpointUrl &&
            eventTypes == other.eventTypes &&
            isActive == other.isActive &&
            lastDeliveryAttemptAt == other.lastDeliveryAttemptAt &&
            lastSuccessfulDeliveryAt == other.lastSuccessfulDeliveryAt &&
            retryCount == other.retryCount &&
            signingSecret == other.signingSecret &&
            timeoutSeconds == other.timeoutSeconds &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            consecutiveFailures,
            createdAt,
            displayName,
            endpointUrl,
            eventTypes,
            isActive,
            lastDeliveryAttemptAt,
            lastSuccessfulDeliveryAt,
            retryCount,
            signingSecret,
            timeoutSeconds,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookResponse{id=$id, consecutiveFailures=$consecutiveFailures, createdAt=$createdAt, displayName=$displayName, endpointUrl=$endpointUrl, eventTypes=$eventTypes, isActive=$isActive, lastDeliveryAttemptAt=$lastDeliveryAttemptAt, lastSuccessfulDeliveryAt=$lastSuccessfulDeliveryAt, retryCount=$retryCount, signingSecret=$signingSecret, timeoutSeconds=$timeoutSeconds, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
