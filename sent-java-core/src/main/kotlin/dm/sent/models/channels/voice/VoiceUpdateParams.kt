// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.Enum
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Changes one of your voice numbers and answers with the number as stored, the same shape `GET` on
 * this path returns, so what comes back can be sent back.
 *
 * ## What it changes
 * |Body                                         |Effect                                                                                                                                                    |
 * |---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
 * |`"status": "ACTIVE"`                         |turns calls on again for a number you turned off; the callback URL and the secret it had are kept                                                         |
 * |`"status": "INACTIVE"`                       |turns calls off; the callback URL and the secret stay on the number                                                                                       |
 * |`"default_for_app_calls": true`              |makes this the line app-originated calls are placed from when a voice token names no number                                                               |
 * |`"callback_url": "https://example.com/voice"`|replaces where Sent asks what to do with each call on the number; the signing secret is kept, and a number that was waiting for its first URL is turned on|
 * |key omitted                                  |left exactly as it is                                                                                                                                     |
 *
 * `status` is matched ignoring case. Any combination is accepted: `status: "ACTIVE"` with
 * `default_for_app_calls: true` turns a number on as the new default, and a `callback_url` sent
 * with either status is written too. A body that names none of the three is refused.
 *
 * ## What it will refuse
 *
 * **`default_for_app_calls: false` is `400`.** An account with active voice numbers always has
 * exactly one default, so the default moves by giving it to another number.
 *
 * **Turning the default line off is `409`** while other active voice numbers remain. Move the
 * default to another number first. Turning off your last voice number is allowed; that turns phone
 * calls off.
 *
 * **Making an inactive number the default is `400`.** Send `status: "ACTIVE"` in the same call.
 *
 * A number added without a `callback_url` is `INACTIVE` for that one reason, so sending it a
 * `callback_url` turns it on by itself, and it becomes your default line if you have no other
 * active voice number. A number you turned off while it had a URL stays off.
 *
 * **A number you never turned voice on for is `404`.** Add it with `POST /v3/channels/voice`.
 *
 * The number is the E.164 value in the path with the plus sign URL-encoded (`%2B`).
 *
 * With `sandbox: true` nothing is written: the request is validated against the stored number and
 * the number is reported with `200` as it would read after the change.
 */
class VoiceUpdateParams
private constructor(
    private val number: String?,
    private val idempotencyKey: String?,
    private val xProfileId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun number(): Optional<String> = Optional.ofNullable(number)

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
     * A new callback URL for the number, active or not: an absolute HTTP or HTTPS URL on a public
     * host, where Sent asks what to do with each call. The signing secret is kept.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun callbackUrl(): Optional<String> = body.callbackUrl()

    /**
     * true makes this the line app-originated calls are placed from when a voice token names no
     * number. false is refused: an account with active voice numbers always has exactly one
     * default, so the default moves by giving it to another number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun defaultForAppCalls(): Optional<Boolean> = body.defaultForAppCalls()

    /**
     * ACTIVE turns calls on for the number again, INACTIVE turns them off. Matched ignoring case.
     * Turning the default line off is refused while other active voice numbers remain.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun status(): Optional<Status> = body.status()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [callbackUrl].
     *
     * Unlike [callbackUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _callbackUrl(): JsonField<String> = body._callbackUrl()

    /**
     * Returns the raw JSON value of [defaultForAppCalls].
     *
     * Unlike [defaultForAppCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _defaultForAppCalls(): JsonField<Boolean> = body._defaultForAppCalls()

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _status(): JsonField<Status> = body._status()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): VoiceUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [VoiceUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceUpdateParams]. */
    class Builder internal constructor() {

        private var number: String? = null
        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(voiceUpdateParams: VoiceUpdateParams) = apply {
            number = voiceUpdateParams.number
            idempotencyKey = voiceUpdateParams.idempotencyKey
            xProfileId = voiceUpdateParams.xProfileId
            body = voiceUpdateParams.body.toBuilder()
            additionalHeaders = voiceUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = voiceUpdateParams.additionalQueryParams.toBuilder()
        }

        fun number(number: String?) = apply { this.number = number }

        /** Alias for calling [Builder.number] with `number.orElse(null)`. */
        fun number(number: Optional<String>) = number(number.getOrNull())

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
         * - [callbackUrl]
         * - [defaultForAppCalls]
         * - [status]
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
         * A new callback URL for the number, active or not: an absolute HTTP or HTTPS URL on a
         * public host, where Sent asks what to do with each call. The signing secret is kept.
         */
        fun callbackUrl(callbackUrl: String?) = apply { body.callbackUrl(callbackUrl) }

        /** Alias for calling [Builder.callbackUrl] with `callbackUrl.orElse(null)`. */
        fun callbackUrl(callbackUrl: Optional<String>) = callbackUrl(callbackUrl.getOrNull())

        /**
         * Sets [Builder.callbackUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callbackUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun callbackUrl(callbackUrl: JsonField<String>) = apply { body.callbackUrl(callbackUrl) }

        /**
         * true makes this the line app-originated calls are placed from when a voice token names no
         * number. false is refused: an account with active voice numbers always has exactly one
         * default, so the default moves by giving it to another number.
         */
        fun defaultForAppCalls(defaultForAppCalls: Boolean?) = apply {
            body.defaultForAppCalls(defaultForAppCalls)
        }

        /**
         * Alias for [Builder.defaultForAppCalls].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun defaultForAppCalls(defaultForAppCalls: Boolean) =
            defaultForAppCalls(defaultForAppCalls as Boolean?)

        /**
         * Alias for calling [Builder.defaultForAppCalls] with `defaultForAppCalls.orElse(null)`.
         */
        fun defaultForAppCalls(defaultForAppCalls: Optional<Boolean>) =
            defaultForAppCalls(defaultForAppCalls.getOrNull())

        /**
         * Sets [Builder.defaultForAppCalls] to an arbitrary JSON value.
         *
         * You should usually call [Builder.defaultForAppCalls] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun defaultForAppCalls(defaultForAppCalls: JsonField<Boolean>) = apply {
            body.defaultForAppCalls(defaultForAppCalls)
        }

        /**
         * ACTIVE turns calls on for the number again, INACTIVE turns them off. Matched ignoring
         * case. Turning the default line off is refused while other active voice numbers remain.
         */
        fun status(status: Status?) = apply { body.status(status) }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { body.status(status) }

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
         * Returns an immutable instance of [VoiceUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceUpdateParams =
            VoiceUpdateParams(
                number,
                idempotencyKey,
                xProfileId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> number ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Changes one of your voice numbers: turns it on or off, makes it the default line for app
     * calls, or replaces its callback URL.
     *
     * Partial. An omitted field is left alone, so one field can be corrected without restating the
     * others. A body that names none of the three is refused rather than answered 200 for a write
     * that did not happen.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val callbackUrl: JsonField<String>,
        private val defaultForAppCalls: JsonField<Boolean>,
        private val status: JsonField<Status>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("callback_url")
            @ExcludeMissing
            callbackUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("default_for_app_calls")
            @ExcludeMissing
            defaultForAppCalls: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        ) : this(sandbox, callbackUrl, defaultForAppCalls, status, mutableMapOf())

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
         * A new callback URL for the number, active or not: an absolute HTTP or HTTPS URL on a
         * public host, where Sent asks what to do with each call. The signing secret is kept.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun callbackUrl(): Optional<String> = callbackUrl.getOptional("callback_url")

        /**
         * true makes this the line app-originated calls are placed from when a voice token names no
         * number. false is refused: an account with active voice numbers always has exactly one
         * default, so the default moves by giving it to another number.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun defaultForAppCalls(): Optional<Boolean> =
            defaultForAppCalls.getOptional("default_for_app_calls")

        /**
         * ACTIVE turns calls on for the number again, INACTIVE turns them off. Matched ignoring
         * case. Turning the default line off is refused while other active voice numbers remain.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Status> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [callbackUrl].
         *
         * Unlike [callbackUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("callback_url")
        @ExcludeMissing
        fun _callbackUrl(): JsonField<String> = callbackUrl

        /**
         * Returns the raw JSON value of [defaultForAppCalls].
         *
         * Unlike [defaultForAppCalls], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("default_for_app_calls")
        @ExcludeMissing
        fun _defaultForAppCalls(): JsonField<Boolean> = defaultForAppCalls

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
            private var callbackUrl: JsonField<String> = JsonMissing.of()
            private var defaultForAppCalls: JsonField<Boolean> = JsonMissing.of()
            private var status: JsonField<Status> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                callbackUrl = body.callbackUrl
                defaultForAppCalls = body.defaultForAppCalls
                status = body.status
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
             * A new callback URL for the number, active or not: an absolute HTTP or HTTPS URL on a
             * public host, where Sent asks what to do with each call. The signing secret is kept.
             */
            fun callbackUrl(callbackUrl: String?) = callbackUrl(JsonField.ofNullable(callbackUrl))

            /** Alias for calling [Builder.callbackUrl] with `callbackUrl.orElse(null)`. */
            fun callbackUrl(callbackUrl: Optional<String>) = callbackUrl(callbackUrl.getOrNull())

            /**
             * Sets [Builder.callbackUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callbackUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callbackUrl(callbackUrl: JsonField<String>) = apply {
                this.callbackUrl = callbackUrl
            }

            /**
             * true makes this the line app-originated calls are placed from when a voice token
             * names no number. false is refused: an account with active voice numbers always has
             * exactly one default, so the default moves by giving it to another number.
             */
            fun defaultForAppCalls(defaultForAppCalls: Boolean?) =
                defaultForAppCalls(JsonField.ofNullable(defaultForAppCalls))

            /**
             * Alias for [Builder.defaultForAppCalls].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun defaultForAppCalls(defaultForAppCalls: Boolean) =
                defaultForAppCalls(defaultForAppCalls as Boolean?)

            /**
             * Alias for calling [Builder.defaultForAppCalls] with
             * `defaultForAppCalls.orElse(null)`.
             */
            fun defaultForAppCalls(defaultForAppCalls: Optional<Boolean>) =
                defaultForAppCalls(defaultForAppCalls.getOrNull())

            /**
             * Sets [Builder.defaultForAppCalls] to an arbitrary JSON value.
             *
             * You should usually call [Builder.defaultForAppCalls] with a well-typed [Boolean]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun defaultForAppCalls(defaultForAppCalls: JsonField<Boolean>) = apply {
                this.defaultForAppCalls = defaultForAppCalls
            }

            /**
             * ACTIVE turns calls on for the number again, INACTIVE turns them off. Matched ignoring
             * case. Turning the default line off is refused while other active voice numbers
             * remain.
             */
            fun status(status: Status?) = status(JsonField.ofNullable(status))

            /** Alias for calling [Builder.status] with `status.orElse(null)`. */
            fun status(status: Optional<Status>) = status(status.getOrNull())

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Status] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun status(status: JsonField<Status>) = apply { this.status = status }

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
                    callbackUrl,
                    defaultForAppCalls,
                    status,
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
            callbackUrl()
            defaultForAppCalls()
            status().ifPresent { it.validate() }
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
                (if (callbackUrl.asKnown().isPresent) 1 else 0) +
                (if (defaultForAppCalls.asKnown().isPresent) 1 else 0) +
                (status.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                callbackUrl == other.callbackUrl &&
                defaultForAppCalls == other.defaultForAppCalls &&
                status == other.status &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sandbox, callbackUrl, defaultForAppCalls, status, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, callbackUrl=$callbackUrl, defaultForAppCalls=$defaultForAppCalls, status=$status, additionalProperties=$additionalProperties}"
    }

    /**
     * ACTIVE turns calls on for the number again, INACTIVE turns them off. Matched ignoring case.
     * Turning the default line off is refused while other active voice numbers remain.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            /**
             * Turns calls on for the number again. The callback URL and the signing secret it had
             * are kept; send `callback_url` in the same call to replace the URL.
             */
            @JvmField val ACTIVE = of("ACTIVE")

            /**
             * Turns calls off for the number. Refused while the number is the default line for app
             * calls and other active voice numbers remain; move the default first. The callback URL
             * and the secret stay on the number.
             */
            @JvmField val INACTIVE = of("INACTIVE")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            /**
             * Turns calls on for the number again. The callback URL and the signing secret it had
             * are kept; send `callback_url` in the same call to replace the URL.
             */
            ACTIVE,
            /**
             * Turns calls off for the number. Refused while the number is the default line for app
             * calls and other active voice numbers remain; move the default first. The callback URL
             * and the secret stay on the number.
             */
            INACTIVE,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            /**
             * Turns calls on for the number again. The callback URL and the signing secret it had
             * are kept; send `callback_url` in the same call to replace the URL.
             */
            ACTIVE,
            /**
             * Turns calls off for the number. Refused while the number is the default line for app
             * calls and other active voice numbers remain; move the default first. The callback URL
             * and the secret stay on the number.
             */
            INACTIVE,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                ACTIVE -> Value.ACTIVE
                INACTIVE -> Value.INACTIVE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws SentInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                ACTIVE -> Known.ACTIVE
                INACTIVE -> Known.INACTIVE
                else -> throw SentInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws SentInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { SentInvalidDataException("Value is not a String") }

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
        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceUpdateParams &&
            number == other.number &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            number,
            idempotencyKey,
            xProfileId,
            body,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "VoiceUpdateParams{number=$number, idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
