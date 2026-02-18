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
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Request and response metadata */
class ApiMeta
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val requestId: JsonField<String>,
    private val responseTimeMs: JsonField<Long>,
    private val timestamp: JsonField<OffsetDateTime>,
    private val version: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("request_id") @ExcludeMissing requestId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("response_time_ms")
        @ExcludeMissing
        responseTimeMs: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("timestamp")
        @ExcludeMissing
        timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
    ) : this(requestId, responseTimeMs, timestamp, version, mutableMapOf())

    /**
     * Unique identifier for this request (for tracing and support)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun requestId(): Optional<String> = requestId.getOptional("request_id")

    /**
     * Response time in milliseconds (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun responseTimeMs(): Optional<Long> = responseTimeMs.getOptional("response_time_ms")

    /**
     * Server timestamp when the response was generated
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

    /**
     * API version used for this request
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun version(): Optional<String> = version.getOptional("version")

    /**
     * Returns the raw JSON value of [requestId].
     *
     * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

    /**
     * Returns the raw JSON value of [responseTimeMs].
     *
     * Unlike [responseTimeMs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response_time_ms")
    @ExcludeMissing
    fun _responseTimeMs(): JsonField<Long> = responseTimeMs

    /**
     * Returns the raw JSON value of [timestamp].
     *
     * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("timestamp")
    @ExcludeMissing
    fun _timestamp(): JsonField<OffsetDateTime> = timestamp

    /**
     * Returns the raw JSON value of [version].
     *
     * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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

        /** Returns a mutable builder for constructing an instance of [ApiMeta]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiMeta]. */
    class Builder internal constructor() {

        private var requestId: JsonField<String> = JsonMissing.of()
        private var responseTimeMs: JsonField<Long> = JsonMissing.of()
        private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
        private var version: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(apiMeta: ApiMeta) = apply {
            requestId = apiMeta.requestId
            responseTimeMs = apiMeta.responseTimeMs
            timestamp = apiMeta.timestamp
            version = apiMeta.version
            additionalProperties = apiMeta.additionalProperties.toMutableMap()
        }

        /** Unique identifier for this request (for tracing and support) */
        fun requestId(requestId: String) = requestId(JsonField.of(requestId))

        /**
         * Sets [Builder.requestId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

        /** Response time in milliseconds (optional) */
        fun responseTimeMs(responseTimeMs: Long?) =
            responseTimeMs(JsonField.ofNullable(responseTimeMs))

        /**
         * Alias for [Builder.responseTimeMs].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun responseTimeMs(responseTimeMs: Long) = responseTimeMs(responseTimeMs as Long?)

        /** Alias for calling [Builder.responseTimeMs] with `responseTimeMs.orElse(null)`. */
        fun responseTimeMs(responseTimeMs: Optional<Long>) =
            responseTimeMs(responseTimeMs.getOrNull())

        /**
         * Sets [Builder.responseTimeMs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseTimeMs] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseTimeMs(responseTimeMs: JsonField<Long>) = apply {
            this.responseTimeMs = responseTimeMs
        }

        /** Server timestamp when the response was generated */
        fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

        /**
         * Sets [Builder.timestamp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply { this.timestamp = timestamp }

        /** API version used for this request */
        fun version(version: String) = version(JsonField.of(version))

        /**
         * Sets [Builder.version] to an arbitrary JSON value.
         *
         * You should usually call [Builder.version] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun version(version: JsonField<String>) = apply { this.version = version }

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
         * Returns an immutable instance of [ApiMeta].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ApiMeta =
            ApiMeta(
                requestId,
                responseTimeMs,
                timestamp,
                version,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ApiMeta = apply {
        if (validated) {
            return@apply
        }

        requestId()
        responseTimeMs()
        timestamp()
        version()
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
        (if (requestId.asKnown().isPresent) 1 else 0) +
            (if (responseTimeMs.asKnown().isPresent) 1 else 0) +
            (if (timestamp.asKnown().isPresent) 1 else 0) +
            (if (version.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiMeta &&
            requestId == other.requestId &&
            responseTimeMs == other.responseTimeMs &&
            timestamp == other.timestamp &&
            version == other.version &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(requestId, responseTimeMs, timestamp, version, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ApiMeta{requestId=$requestId, responseTimeMs=$responseTimeMs, timestamp=$timestamp, version=$version, additionalProperties=$additionalProperties}"
}
