// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.Params
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Updates an existing webhook for the authenticated customer. */
class WebhookUpdateParams
private constructor(
    private val id: String?,
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun id(): Optional<String> = Optional.ofNullable(id)

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    /**
     * Test mode flag - when true, the operation is simulated without side effects Useful for
     * testing integrations without actual execution
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun testMode(): Optional<Boolean> = body.testMode()

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun displayName(): Optional<String> = body.displayName()

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endpointUrl(): Optional<String> = body.endpointUrl()

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventTypes(): Optional<List<String>> = body.eventTypes()

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun retryCount(): Optional<Int> = body.retryCount()

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timeoutSeconds(): Optional<Int> = body.timeoutSeconds()

    /**
     * Returns the raw JSON value of [testMode].
     *
     * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _testMode(): JsonField<Boolean> = body._testMode()

    /**
     * Returns the raw JSON value of [displayName].
     *
     * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _displayName(): JsonField<String> = body._displayName()

    /**
     * Returns the raw JSON value of [endpointUrl].
     *
     * Unlike [endpointUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _endpointUrl(): JsonField<String> = body._endpointUrl()

    /**
     * Returns the raw JSON value of [eventTypes].
     *
     * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _eventTypes(): JsonField<List<String>> = body._eventTypes()

    /**
     * Returns the raw JSON value of [retryCount].
     *
     * Unlike [retryCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _retryCount(): JsonField<Int> = body._retryCount()

    /**
     * Returns the raw JSON value of [timeoutSeconds].
     *
     * Unlike [timeoutSeconds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _timeoutSeconds(): JsonField<Int> = body._timeoutSeconds()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): WebhookUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [WebhookUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookUpdateParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(webhookUpdateParams: WebhookUpdateParams) = apply {
            id = webhookUpdateParams.id
            idempotencyKey = webhookUpdateParams.idempotencyKey
            body = webhookUpdateParams.body.toBuilder()
            additionalHeaders = webhookUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = webhookUpdateParams.additionalQueryParams.toBuilder()
        }

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [testMode]
         * - [displayName]
         * - [endpointUrl]
         * - [eventTypes]
         * - [retryCount]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         */
        fun testMode(testMode: Boolean) = apply { body.testMode(testMode) }

        /**
         * Sets [Builder.testMode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun testMode(testMode: JsonField<Boolean>) = apply { body.testMode(testMode) }

        fun displayName(displayName: String) = apply { body.displayName(displayName) }

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { body.displayName(displayName) }

        fun endpointUrl(endpointUrl: String) = apply { body.endpointUrl(endpointUrl) }

        /**
         * Sets [Builder.endpointUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endpointUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun endpointUrl(endpointUrl: JsonField<String>) = apply { body.endpointUrl(endpointUrl) }

        fun eventTypes(eventTypes: List<String>) = apply { body.eventTypes(eventTypes) }

        /**
         * Sets [Builder.eventTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventTypes] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun eventTypes(eventTypes: JsonField<List<String>>) = apply { body.eventTypes(eventTypes) }

        /**
         * Adds a single [String] to [eventTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEventType(eventType: String) = apply { body.addEventType(eventType) }

        fun retryCount(retryCount: Int) = apply { body.retryCount(retryCount) }

        /**
         * Sets [Builder.retryCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.retryCount] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun retryCount(retryCount: JsonField<Int>) = apply { body.retryCount(retryCount) }

        fun timeoutSeconds(timeoutSeconds: Int) = apply { body.timeoutSeconds(timeoutSeconds) }

        /**
         * Sets [Builder.timeoutSeconds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timeoutSeconds] with a well-typed [Int] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun timeoutSeconds(timeoutSeconds: JsonField<Int>) = apply {
            body.timeoutSeconds(timeoutSeconds)
        }

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
         * Returns an immutable instance of [WebhookUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookUpdateParams =
            WebhookUpdateParams(
                id,
                idempotencyKey,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val testMode: JsonField<Boolean>,
        private val displayName: JsonField<String>,
        private val endpointUrl: JsonField<String>,
        private val eventTypes: JsonField<List<String>>,
        private val retryCount: JsonField<Int>,
        private val timeoutSeconds: JsonField<Int>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("test_mode")
            @ExcludeMissing
            testMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("display_name")
            @ExcludeMissing
            displayName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("endpoint_url")
            @ExcludeMissing
            endpointUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("event_types")
            @ExcludeMissing
            eventTypes: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("retry_count")
            @ExcludeMissing
            retryCount: JsonField<Int> = JsonMissing.of(),
            @JsonProperty("timeout_seconds")
            @ExcludeMissing
            timeoutSeconds: JsonField<Int> = JsonMissing.of(),
        ) : this(
            testMode,
            displayName,
            endpointUrl,
            eventTypes,
            retryCount,
            timeoutSeconds,
            mutableMapOf(),
        )

        fun toMutationRequest(): MutationRequest =
            MutationRequest.builder().testMode(testMode).build()

        /**
         * Test mode flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun testMode(): Optional<Boolean> = testMode.getOptional("test_mode")

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
        fun retryCount(): Optional<Int> = retryCount.getOptional("retry_count")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timeoutSeconds(): Optional<Int> = timeoutSeconds.getOptional("timeout_seconds")

        /**
         * Returns the raw JSON value of [testMode].
         *
         * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("test_mode") @ExcludeMissing fun _testMode(): JsonField<Boolean> = testMode

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
         * Returns the raw JSON value of [retryCount].
         *
         * Unlike [retryCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("retry_count") @ExcludeMissing fun _retryCount(): JsonField<Int> = retryCount

        /**
         * Returns the raw JSON value of [timeoutSeconds].
         *
         * Unlike [timeoutSeconds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("timeout_seconds")
        @ExcludeMissing
        fun _timeoutSeconds(): JsonField<Int> = timeoutSeconds

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

            private var testMode: JsonField<Boolean> = JsonMissing.of()
            private var displayName: JsonField<String> = JsonMissing.of()
            private var endpointUrl: JsonField<String> = JsonMissing.of()
            private var eventTypes: JsonField<MutableList<String>>? = null
            private var retryCount: JsonField<Int> = JsonMissing.of()
            private var timeoutSeconds: JsonField<Int> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                testMode = body.testMode
                displayName = body.displayName
                endpointUrl = body.endpointUrl
                eventTypes = body.eventTypes.map { it.toMutableList() }
                retryCount = body.retryCount
                timeoutSeconds = body.timeoutSeconds
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Test mode flag - when true, the operation is simulated without side effects Useful
             * for testing integrations without actual execution
             */
            fun testMode(testMode: Boolean) = testMode(JsonField.of(testMode))

            /**
             * Sets [Builder.testMode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.testMode] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun testMode(testMode: JsonField<Boolean>) = apply { this.testMode = testMode }

            fun displayName(displayName: String) = displayName(JsonField.of(displayName))

            /**
             * Sets [Builder.displayName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.displayName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun displayName(displayName: JsonField<String>) = apply {
                this.displayName = displayName
            }

            fun endpointUrl(endpointUrl: String) = endpointUrl(JsonField.of(endpointUrl))

            /**
             * Sets [Builder.endpointUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endpointUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endpointUrl(endpointUrl: JsonField<String>) = apply {
                this.endpointUrl = endpointUrl
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

            fun retryCount(retryCount: Int) = retryCount(JsonField.of(retryCount))

            /**
             * Sets [Builder.retryCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.retryCount] with a well-typed [Int] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun retryCount(retryCount: JsonField<Int>) = apply { this.retryCount = retryCount }

            fun timeoutSeconds(timeoutSeconds: Int) = timeoutSeconds(JsonField.of(timeoutSeconds))

            /**
             * Sets [Builder.timeoutSeconds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeoutSeconds] with a well-typed [Int] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeoutSeconds(timeoutSeconds: JsonField<Int>) = apply {
                this.timeoutSeconds = timeoutSeconds
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
                    testMode,
                    displayName,
                    endpointUrl,
                    (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
                    retryCount,
                    timeoutSeconds,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            testMode()
            displayName()
            endpointUrl()
            eventTypes()
            retryCount()
            timeoutSeconds()
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
            (if (testMode.asKnown().isPresent) 1 else 0) +
                (if (displayName.asKnown().isPresent) 1 else 0) +
                (if (endpointUrl.asKnown().isPresent) 1 else 0) +
                (eventTypes.asKnown().getOrNull()?.size ?: 0) +
                (if (retryCount.asKnown().isPresent) 1 else 0) +
                (if (timeoutSeconds.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                testMode == other.testMode &&
                displayName == other.displayName &&
                endpointUrl == other.endpointUrl &&
                eventTypes == other.eventTypes &&
                retryCount == other.retryCount &&
                timeoutSeconds == other.timeoutSeconds &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                testMode,
                displayName,
                endpointUrl,
                eventTypes,
                retryCount,
                timeoutSeconds,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{testMode=$testMode, displayName=$displayName, endpointUrl=$endpointUrl, eventTypes=$eventTypes, retryCount=$retryCount, timeoutSeconds=$timeoutSeconds, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookUpdateParams &&
            id == other.id &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(id, idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "WebhookUpdateParams{id=$id, idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
