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
import dm.sent.errors.SentInvalidDataException
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
    private val customerId: JsonField<String>,
    private val displayName: JsonField<String>,
    private val endpointUrl: JsonField<String>,
    private val eventFilters: JsonField<EventFilters>,
    private val eventTypes: JsonField<List<String>>,
    private val isActive: JsonField<Boolean>,
    private val isInheritable: JsonField<Boolean>,
    private val lastDeliveryAttemptAt: JsonField<OffsetDateTime>,
    private val lastSuccessfulDeliveryAt: JsonField<OffsetDateTime>,
    private val retryCount: JsonField<Int>,
    private val senderProfile: JsonField<SenderProfile>,
    private val signingSecret: JsonField<String>,
    private val timeoutSeconds: JsonField<Int>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val webhookVersion: JsonField<Long>,
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
        @JsonProperty("customer_id")
        @ExcludeMissing
        customerId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("display_name")
        @ExcludeMissing
        displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("endpoint_url")
        @ExcludeMissing
        endpointUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("event_filters")
        @ExcludeMissing
        eventFilters: JsonField<EventFilters> = JsonMissing.of(),
        @JsonProperty("event_types")
        @ExcludeMissing
        eventTypes: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("is_active") @ExcludeMissing isActive: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_inheritable")
        @ExcludeMissing
        isInheritable: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("last_delivery_attempt_at")
        @ExcludeMissing
        lastDeliveryAttemptAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("last_successful_delivery_at")
        @ExcludeMissing
        lastSuccessfulDeliveryAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("retry_count") @ExcludeMissing retryCount: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("sender_profile")
        @ExcludeMissing
        senderProfile: JsonField<SenderProfile> = JsonMissing.of(),
        @JsonProperty("signing_secret")
        @ExcludeMissing
        signingSecret: JsonField<String> = JsonMissing.of(),
        @JsonProperty("timeout_seconds")
        @ExcludeMissing
        timeoutSeconds: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("webhook_version")
        @ExcludeMissing
        webhookVersion: JsonField<Long> = JsonMissing.of(),
    ) : this(
        id,
        consecutiveFailures,
        createdAt,
        customerId,
        displayName,
        endpointUrl,
        eventFilters,
        eventTypes,
        isActive,
        isInheritable,
        lastDeliveryAttemptAt,
        lastSuccessfulDeliveryAt,
        retryCount,
        senderProfile,
        signingSecret,
        timeoutSeconds,
        updatedAt,
        webhookVersion,
        mutableMapOf(),
    )

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Failed attempts since the last success. Version 1 only: always 0 on a version 2 webhook,
     * whose deliveries are in its events (GET /v3/webhooks/{id}/events).
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun consecutiveFailures(): Optional<Int> =
        consecutiveFailures.getOptional("consecutive_failures")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

    /**
     * Which customer owns this — the key's own, or the profile named in x-profile-id. Says whose
     * resource this is, which the resource's own id does not.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun customerId(): Optional<String> = customerId.getOptional("customer_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun displayName(): Optional<String> = displayName.getOptional("display_name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun endpointUrl(): Optional<String> = endpointUrl.getOptional("endpoint_url")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun eventFilters(): Optional<EventFilters> = eventFilters.getOptional("event_filters")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun eventTypes(): Optional<List<String>> = eventTypes.getOptional("event_types")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun isActive(): Optional<Boolean> = isActive.getOptional("is_active")

    /**
     * Whether the webhook also receives its organization's sender profiles' events, and each
     * profile sees it and reads the events about itself. Always false on a version 1 webhook.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun isInheritable(): Optional<Boolean> = isInheritable.getOptional("is_inheritable")

    /**
     * When the webhook was last attempted. Version 1 only: always null on a version 2 webhook.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun lastDeliveryAttemptAt(): Optional<OffsetDateTime> =
        lastDeliveryAttemptAt.getOptional("last_delivery_attempt_at")

    /**
     * When the webhook last received an event. Version 1 only: always null on a version 2 webhook.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun lastSuccessfulDeliveryAt(): Optional<OffsetDateTime> =
        lastSuccessfulDeliveryAt.getOptional("last_successful_delivery_at")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun retryCount(): Optional<Int> = retryCount.getOptional("retry_count")

    /**
     * The events a version 1 webhook's sender profile clones receive, as a response reports them.
     *
     * Its own type, field for field the same as the request's sender_profile. A response is not a
     * request, whatever it carries.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun senderProfile(): Optional<SenderProfile> = senderProfile.getOptional("sender_profile")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun signingSecret(): Optional<String> = signingSecret.getOptional("signing_secret")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun timeoutSeconds(): Optional<Int> = timeoutSeconds.getOptional("timeout_seconds")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

    /**
     * Who delivers the webhook: 1 the older delivery, which will be retired, or 2 Svix. A webhook
     * is created as version 2 unless the request asks for 1.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun webhookVersion(): Optional<Long> = webhookVersion.getOptional("webhook_version")

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
     * Returns the raw JSON value of [customerId].
     *
     * Unlike [customerId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customer_id") @ExcludeMissing fun _customerId(): JsonField<String> = customerId

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
     * Returns the raw JSON value of [eventFilters].
     *
     * Unlike [eventFilters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("event_filters")
    @ExcludeMissing
    fun _eventFilters(): JsonField<EventFilters> = eventFilters

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
     * Returns the raw JSON value of [isInheritable].
     *
     * Unlike [isInheritable], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_inheritable")
    @ExcludeMissing
    fun _isInheritable(): JsonField<Boolean> = isInheritable

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
     * Returns the raw JSON value of [senderProfile].
     *
     * Unlike [senderProfile], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sender_profile")
    @ExcludeMissing
    fun _senderProfile(): JsonField<SenderProfile> = senderProfile

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

    /**
     * Returns the raw JSON value of [webhookVersion].
     *
     * Unlike [webhookVersion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("webhook_version")
    @ExcludeMissing
    fun _webhookVersion(): JsonField<Long> = webhookVersion

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
        private var customerId: JsonField<String> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var endpointUrl: JsonField<String> = JsonMissing.of()
        private var eventFilters: JsonField<EventFilters> = JsonMissing.of()
        private var eventTypes: JsonField<MutableList<String>>? = null
        private var isActive: JsonField<Boolean> = JsonMissing.of()
        private var isInheritable: JsonField<Boolean> = JsonMissing.of()
        private var lastDeliveryAttemptAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var lastSuccessfulDeliveryAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var retryCount: JsonField<Int> = JsonMissing.of()
        private var senderProfile: JsonField<SenderProfile> = JsonMissing.of()
        private var signingSecret: JsonField<String> = JsonMissing.of()
        private var timeoutSeconds: JsonField<Int> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var webhookVersion: JsonField<Long> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookResponse: WebhookResponse) = apply {
            id = webhookResponse.id
            consecutiveFailures = webhookResponse.consecutiveFailures
            createdAt = webhookResponse.createdAt
            customerId = webhookResponse.customerId
            displayName = webhookResponse.displayName
            endpointUrl = webhookResponse.endpointUrl
            eventFilters = webhookResponse.eventFilters
            eventTypes = webhookResponse.eventTypes.map { it.toMutableList() }
            isActive = webhookResponse.isActive
            isInheritable = webhookResponse.isInheritable
            lastDeliveryAttemptAt = webhookResponse.lastDeliveryAttemptAt
            lastSuccessfulDeliveryAt = webhookResponse.lastSuccessfulDeliveryAt
            retryCount = webhookResponse.retryCount
            senderProfile = webhookResponse.senderProfile
            signingSecret = webhookResponse.signingSecret
            timeoutSeconds = webhookResponse.timeoutSeconds
            updatedAt = webhookResponse.updatedAt
            webhookVersion = webhookResponse.webhookVersion
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

        /**
         * Failed attempts since the last success. Version 1 only: always 0 on a version 2 webhook,
         * whose deliveries are in its events (GET /v3/webhooks/{id}/events).
         */
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

        /**
         * Which customer owns this — the key's own, or the profile named in x-profile-id. Says
         * whose resource this is, which the resource's own id does not.
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

        fun eventFilters(eventFilters: EventFilters?) =
            eventFilters(JsonField.ofNullable(eventFilters))

        /** Alias for calling [Builder.eventFilters] with `eventFilters.orElse(null)`. */
        fun eventFilters(eventFilters: Optional<EventFilters>) =
            eventFilters(eventFilters.getOrNull())

        /**
         * Sets [Builder.eventFilters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventFilters] with a well-typed [EventFilters] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventFilters(eventFilters: JsonField<EventFilters>) = apply {
            this.eventFilters = eventFilters
        }

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

        /**
         * Whether the webhook also receives its organization's sender profiles' events, and each
         * profile sees it and reads the events about itself. Always false on a version 1 webhook.
         */
        fun isInheritable(isInheritable: Boolean) = isInheritable(JsonField.of(isInheritable))

        /**
         * Sets [Builder.isInheritable] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isInheritable] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isInheritable(isInheritable: JsonField<Boolean>) = apply {
            this.isInheritable = isInheritable
        }

        /**
         * When the webhook was last attempted. Version 1 only: always null on a version 2 webhook.
         */
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

        /**
         * When the webhook last received an event. Version 1 only: always null on a version 2
         * webhook.
         */
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

        /**
         * The events a version 1 webhook's sender profile clones receive, as a response reports
         * them.
         *
         * Its own type, field for field the same as the request's sender_profile. A response is not
         * a request, whatever it carries.
         */
        fun senderProfile(senderProfile: SenderProfile?) =
            senderProfile(JsonField.ofNullable(senderProfile))

        /** Alias for calling [Builder.senderProfile] with `senderProfile.orElse(null)`. */
        fun senderProfile(senderProfile: Optional<SenderProfile>) =
            senderProfile(senderProfile.getOrNull())

        /**
         * Sets [Builder.senderProfile] to an arbitrary JSON value.
         *
         * You should usually call [Builder.senderProfile] with a well-typed [SenderProfile] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun senderProfile(senderProfile: JsonField<SenderProfile>) = apply {
            this.senderProfile = senderProfile
        }

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

        /**
         * Who delivers the webhook: 1 the older delivery, which will be retired, or 2 Svix. A
         * webhook is created as version 2 unless the request asks for 1.
         */
        fun webhookVersion(webhookVersion: Long) = webhookVersion(JsonField.of(webhookVersion))

        /**
         * Sets [Builder.webhookVersion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webhookVersion] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun webhookVersion(webhookVersion: JsonField<Long>) = apply {
            this.webhookVersion = webhookVersion
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
         * Returns an immutable instance of [WebhookResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookResponse =
            WebhookResponse(
                id,
                consecutiveFailures,
                createdAt,
                customerId,
                displayName,
                endpointUrl,
                eventFilters,
                (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
                isActive,
                isInheritable,
                lastDeliveryAttemptAt,
                lastSuccessfulDeliveryAt,
                retryCount,
                senderProfile,
                signingSecret,
                timeoutSeconds,
                updatedAt,
                webhookVersion,
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
    fun validate(): WebhookResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        consecutiveFailures()
        createdAt()
        customerId()
        displayName()
        endpointUrl()
        eventFilters().ifPresent { it.validate() }
        eventTypes()
        isActive()
        isInheritable()
        lastDeliveryAttemptAt()
        lastSuccessfulDeliveryAt()
        retryCount()
        senderProfile().ifPresent { it.validate() }
        signingSecret()
        timeoutSeconds()
        updatedAt()
        webhookVersion()
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
            (if (consecutiveFailures.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (if (customerId.asKnown().isPresent) 1 else 0) +
            (if (displayName.asKnown().isPresent) 1 else 0) +
            (if (endpointUrl.asKnown().isPresent) 1 else 0) +
            (eventFilters.asKnown().getOrNull()?.validity() ?: 0) +
            (eventTypes.asKnown().getOrNull()?.size ?: 0) +
            (if (isActive.asKnown().isPresent) 1 else 0) +
            (if (isInheritable.asKnown().isPresent) 1 else 0) +
            (if (lastDeliveryAttemptAt.asKnown().isPresent) 1 else 0) +
            (if (lastSuccessfulDeliveryAt.asKnown().isPresent) 1 else 0) +
            (if (retryCount.asKnown().isPresent) 1 else 0) +
            (senderProfile.asKnown().getOrNull()?.validity() ?: 0) +
            (if (signingSecret.asKnown().isPresent) 1 else 0) +
            (if (timeoutSeconds.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (webhookVersion.asKnown().isPresent) 1 else 0)

    class EventFilters
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

            /** Returns a mutable builder for constructing an instance of [EventFilters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [EventFilters]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(eventFilters: EventFilters) = apply {
                additionalProperties = eventFilters.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [EventFilters].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): EventFilters = EventFilters(additionalProperties.toImmutable())
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
        fun validate(): EventFilters = apply {
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

            return other is EventFilters && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "EventFilters{additionalProperties=$additionalProperties}"
    }

    /**
     * The events a version 1 webhook's sender profile clones receive, as a response reports them.
     *
     * Its own type, field for field the same as the request's sender_profile. A response is not a
     * request, whatever it carries.
     */
    class SenderProfile
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val eventFilters: JsonField<EventFilters>,
        private val eventTypes: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("event_filters")
            @ExcludeMissing
            eventFilters: JsonField<EventFilters> = JsonMissing.of(),
            @JsonProperty("event_types")
            @ExcludeMissing
            eventTypes: JsonField<List<String>> = JsonMissing.of(),
        ) : this(eventFilters, eventTypes, mutableMapOf())

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun eventFilters(): Optional<EventFilters> = eventFilters.getOptional("event_filters")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun eventTypes(): Optional<List<String>> = eventTypes.getOptional("event_types")

        /**
         * Returns the raw JSON value of [eventFilters].
         *
         * Unlike [eventFilters], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("event_filters")
        @ExcludeMissing
        fun _eventFilters(): JsonField<EventFilters> = eventFilters

        /**
         * Returns the raw JSON value of [eventTypes].
         *
         * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event_types")
        @ExcludeMissing
        fun _eventTypes(): JsonField<List<String>> = eventTypes

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

            /** Returns a mutable builder for constructing an instance of [SenderProfile]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SenderProfile]. */
        class Builder internal constructor() {

            private var eventFilters: JsonField<EventFilters> = JsonMissing.of()
            private var eventTypes: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(senderProfile: SenderProfile) = apply {
                eventFilters = senderProfile.eventFilters
                eventTypes = senderProfile.eventTypes.map { it.toMutableList() }
                additionalProperties = senderProfile.additionalProperties.toMutableMap()
            }

            fun eventFilters(eventFilters: EventFilters?) =
                eventFilters(JsonField.ofNullable(eventFilters))

            /** Alias for calling [Builder.eventFilters] with `eventFilters.orElse(null)`. */
            fun eventFilters(eventFilters: Optional<EventFilters>) =
                eventFilters(eventFilters.getOrNull())

            /**
             * Sets [Builder.eventFilters] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventFilters] with a well-typed [EventFilters] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun eventFilters(eventFilters: JsonField<EventFilters>) = apply {
                this.eventFilters = eventFilters
            }

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
             * Returns an immutable instance of [SenderProfile].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): SenderProfile =
                SenderProfile(
                    eventFilters,
                    (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): SenderProfile = apply {
            if (validated) {
                return@apply
            }

            eventFilters().ifPresent { it.validate() }
            eventTypes()
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
            (eventFilters.asKnown().getOrNull()?.validity() ?: 0) +
                (eventTypes.asKnown().getOrNull()?.size ?: 0)

        class EventFilters
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

                /** Returns a mutable builder for constructing an instance of [EventFilters]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EventFilters]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(eventFilters: EventFilters) = apply {
                    additionalProperties = eventFilters.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [EventFilters].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): EventFilters = EventFilters(additionalProperties.toImmutable())
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
            fun validate(): EventFilters = apply {
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

                return other is EventFilters && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "EventFilters{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SenderProfile &&
                eventFilters == other.eventFilters &&
                eventTypes == other.eventTypes &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(eventFilters, eventTypes, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SenderProfile{eventFilters=$eventFilters, eventTypes=$eventTypes, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookResponse &&
            id == other.id &&
            consecutiveFailures == other.consecutiveFailures &&
            createdAt == other.createdAt &&
            customerId == other.customerId &&
            displayName == other.displayName &&
            endpointUrl == other.endpointUrl &&
            eventFilters == other.eventFilters &&
            eventTypes == other.eventTypes &&
            isActive == other.isActive &&
            isInheritable == other.isInheritable &&
            lastDeliveryAttemptAt == other.lastDeliveryAttemptAt &&
            lastSuccessfulDeliveryAt == other.lastSuccessfulDeliveryAt &&
            retryCount == other.retryCount &&
            senderProfile == other.senderProfile &&
            signingSecret == other.signingSecret &&
            timeoutSeconds == other.timeoutSeconds &&
            updatedAt == other.updatedAt &&
            webhookVersion == other.webhookVersion &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            consecutiveFailures,
            createdAt,
            customerId,
            displayName,
            endpointUrl,
            eventFilters,
            eventTypes,
            isActive,
            isInheritable,
            lastDeliveryAttemptAt,
            lastSuccessfulDeliveryAt,
            retryCount,
            senderProfile,
            signingSecret,
            timeoutSeconds,
            updatedAt,
            webhookVersion,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WebhookResponse{id=$id, consecutiveFailures=$consecutiveFailures, createdAt=$createdAt, customerId=$customerId, displayName=$displayName, endpointUrl=$endpointUrl, eventFilters=$eventFilters, eventTypes=$eventTypes, isActive=$isActive, isInheritable=$isInheritable, lastDeliveryAttemptAt=$lastDeliveryAttemptAt, lastSuccessfulDeliveryAt=$lastSuccessfulDeliveryAt, retryCount=$retryCount, senderProfile=$senderProfile, signingSecret=$signingSecret, timeoutSeconds=$timeoutSeconds, updatedAt=$updatedAt, webhookVersion=$webhookVersion, additionalProperties=$additionalProperties}"
}
