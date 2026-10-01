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
import dm.sent.core.Params
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Adds voice to one of the numbers you hold, or gives you a new one. Send `number` for a number
 * that is already yours (see `GET /v3/channels`); leave it out to be given a new US number,
 * optionally in a particular `area_code`. Sending both is refused. Nothing registers, so the number
 * can carry calls as soon as this returns.
 *
 * What happens on a call is decided by your `callback_url`: when a call arrives on the number, or a
 * caller presses a key on a menu, Sent POSTs a signed question there and follows the answer. The
 * response carries the `callback_secret` the questions are signed with, the one time it is shown
 * without rotating; verify a question the way you verify a webhook. `POST
 * /v3/channels/voice/{number}/test` sends a test question and reports the verdict.
 *
 * Your first voice number becomes the line app-originated calls are placed from when a voice token
 * names no number; send `default_for_app_calls: true` to give that role to another number. A number
 * you turned off earlier is turned back on, and the same number with a different `callback_url` has
 * its URL replaced and keeps its secret.
 *
 * Read the number's settings with `GET /v3/channels/voice` and change them with `PATCH
 * /v3/channels/voice/{number}`.
 *
 * With `sandbox: true` the request is validated and a simulated number reported with `202`; nothing
 * is written and no number is bought.
 */
class VoiceCreateParams
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
     * Where Sent asks what to do with each call on this number: an absolute HTTP or HTTPS URL on a
     * public host. A signed question is POSTed here when a call arrives or a caller presses a key,
     * and the answer decides the call. Every question is signed with the callback_secret the
     * response returns, the same way your webhooks are signed. Turning the number on again with a
     * different URL replaces it and keeps the secret.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun callbackUrl(): String = body.callbackUrl()

    /**
     * The US area code a new number should be in, as 212. Only for a request that leaves number out
     * — sending both says two different things about which number to use, and is refused. Omit it
     * too and the number comes from anywhere in the country.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun areaCode(): Optional<String> = body.areaCode()

    /**
     * Make this the line app-originated calls are placed from when a voice token names no number.
     * Omit it and your first voice number takes that role; a later one leaves it where it is.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun defaultForAppCalls(): Optional<Boolean> = body.defaultForAppCalls()

    /**
     * One of your phone numbers, in E.164 format. Leave the field out entirely to be given a new
     * one instead; sending it empty is a refused request rather than a request for a new number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun number(): Optional<String> = body.number()

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
     * Returns the raw JSON value of [areaCode].
     *
     * Unlike [areaCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _areaCode(): JsonField<String> = body._areaCode()

    /**
     * Returns the raw JSON value of [defaultForAppCalls].
     *
     * Unlike [defaultForAppCalls], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _defaultForAppCalls(): JsonField<Boolean> = body._defaultForAppCalls()

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _number(): JsonField<String> = body._number()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VoiceCreateParams].
         *
         * The following fields are required:
         * ```java
         * .callbackUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(voiceCreateParams: VoiceCreateParams) = apply {
            idempotencyKey = voiceCreateParams.idempotencyKey
            xProfileId = voiceCreateParams.xProfileId
            body = voiceCreateParams.body.toBuilder()
            additionalHeaders = voiceCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = voiceCreateParams.additionalQueryParams.toBuilder()
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
         * - [callbackUrl]
         * - [areaCode]
         * - [defaultForAppCalls]
         * - [number]
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
         * Where Sent asks what to do with each call on this number: an absolute HTTP or HTTPS URL
         * on a public host. A signed question is POSTed here when a call arrives or a caller
         * presses a key, and the answer decides the call. Every question is signed with the
         * callback_secret the response returns, the same way your webhooks are signed. Turning the
         * number on again with a different URL replaces it and keeps the secret.
         */
        fun callbackUrl(callbackUrl: String) = apply { body.callbackUrl(callbackUrl) }

        /**
         * Sets [Builder.callbackUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callbackUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun callbackUrl(callbackUrl: JsonField<String>) = apply { body.callbackUrl(callbackUrl) }

        /**
         * The US area code a new number should be in, as 212. Only for a request that leaves number
         * out — sending both says two different things about which number to use, and is refused.
         * Omit it too and the number comes from anywhere in the country.
         */
        fun areaCode(areaCode: String?) = apply { body.areaCode(areaCode) }

        /** Alias for calling [Builder.areaCode] with `areaCode.orElse(null)`. */
        fun areaCode(areaCode: Optional<String>) = areaCode(areaCode.getOrNull())

        /**
         * Sets [Builder.areaCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.areaCode] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun areaCode(areaCode: JsonField<String>) = apply { body.areaCode(areaCode) }

        /**
         * Make this the line app-originated calls are placed from when a voice token names no
         * number. Omit it and your first voice number takes that role; a later one leaves it where
         * it is.
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
         * One of your phone numbers, in E.164 format. Leave the field out entirely to be given a
         * new one instead; sending it empty is a refused request rather than a request for a new
         * number.
         */
        fun number(number: String?) = apply { body.number(number) }

        /** Alias for calling [Builder.number] with `number.orElse(null)`. */
        fun number(number: Optional<String>) = number(number.getOrNull())

        /**
         * Sets [Builder.number] to an arbitrary JSON value.
         *
         * You should usually call [Builder.number] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun number(number: JsonField<String>) = apply { body.number(number) }

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
         * Returns an immutable instance of [VoiceCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .callbackUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VoiceCreateParams =
            VoiceCreateParams(
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

    /**
     * Turns phone calls on for a number: one you already hold, or a new one.
     *
     * Voice is per number the way SMS is per market: each number you hold can carry calls on its
     * own, and each has its own callback URL, where Sent asks what to do with every call on it. The
     * first number you turn voice on for becomes the line app-originated calls are placed from when
     * a voice token names no number.
     *
     * Send number to add calls to a number you already hold, or leave it out to be given a new US
     * number — optionally in a particular area_code. The two are alternatives, not a pair.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val callbackUrl: JsonField<String>,
        private val areaCode: JsonField<String>,
        private val defaultForAppCalls: JsonField<Boolean>,
        private val number: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("callback_url")
            @ExcludeMissing
            callbackUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("area_code")
            @ExcludeMissing
            areaCode: JsonField<String> = JsonMissing.of(),
            @JsonProperty("default_for_app_calls")
            @ExcludeMissing
            defaultForAppCalls: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
        ) : this(sandbox, callbackUrl, areaCode, defaultForAppCalls, number, mutableMapOf())

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
         * Where Sent asks what to do with each call on this number: an absolute HTTP or HTTPS URL
         * on a public host. A signed question is POSTed here when a call arrives or a caller
         * presses a key, and the answer decides the call. Every question is signed with the
         * callback_secret the response returns, the same way your webhooks are signed. Turning the
         * number on again with a different URL replaces it and keeps the secret.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callbackUrl(): String = callbackUrl.getRequired("callback_url")

        /**
         * The US area code a new number should be in, as 212. Only for a request that leaves number
         * out — sending both says two different things about which number to use, and is refused.
         * Omit it too and the number comes from anywhere in the country.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun areaCode(): Optional<String> = areaCode.getOptional("area_code")

        /**
         * Make this the line app-originated calls are placed from when a voice token names no
         * number. Omit it and your first voice number takes that role; a later one leaves it where
         * it is.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun defaultForAppCalls(): Optional<Boolean> =
            defaultForAppCalls.getOptional("default_for_app_calls")

        /**
         * One of your phone numbers, in E.164 format. Leave the field out entirely to be given a
         * new one instead; sending it empty is a refused request rather than a request for a new
         * number.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun number(): Optional<String> = number.getOptional("number")

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
         * Returns the raw JSON value of [areaCode].
         *
         * Unlike [areaCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("area_code") @ExcludeMissing fun _areaCode(): JsonField<String> = areaCode

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
         * Returns the raw JSON value of [number].
         *
         * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .callbackUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var callbackUrl: JsonField<String>? = null
            private var areaCode: JsonField<String> = JsonMissing.of()
            private var defaultForAppCalls: JsonField<Boolean> = JsonMissing.of()
            private var number: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                callbackUrl = body.callbackUrl
                areaCode = body.areaCode
                defaultForAppCalls = body.defaultForAppCalls
                number = body.number
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
             * Where Sent asks what to do with each call on this number: an absolute HTTP or HTTPS
             * URL on a public host. A signed question is POSTed here when a call arrives or a
             * caller presses a key, and the answer decides the call. Every question is signed with
             * the callback_secret the response returns, the same way your webhooks are signed.
             * Turning the number on again with a different URL replaces it and keeps the secret.
             */
            fun callbackUrl(callbackUrl: String) = callbackUrl(JsonField.of(callbackUrl))

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
             * The US area code a new number should be in, as 212. Only for a request that leaves
             * number out — sending both says two different things about which number to use, and is
             * refused. Omit it too and the number comes from anywhere in the country.
             */
            fun areaCode(areaCode: String?) = areaCode(JsonField.ofNullable(areaCode))

            /** Alias for calling [Builder.areaCode] with `areaCode.orElse(null)`. */
            fun areaCode(areaCode: Optional<String>) = areaCode(areaCode.getOrNull())

            /**
             * Sets [Builder.areaCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.areaCode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun areaCode(areaCode: JsonField<String>) = apply { this.areaCode = areaCode }

            /**
             * Make this the line app-originated calls are placed from when a voice token names no
             * number. Omit it and your first voice number takes that role; a later one leaves it
             * where it is.
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
             * One of your phone numbers, in E.164 format. Leave the field out entirely to be given
             * a new one instead; sending it empty is a refused request rather than a request for a
             * new number.
             */
            fun number(number: String?) = number(JsonField.ofNullable(number))

            /** Alias for calling [Builder.number] with `number.orElse(null)`. */
            fun number(number: Optional<String>) = number(number.getOrNull())

            /**
             * Sets [Builder.number] to an arbitrary JSON value.
             *
             * You should usually call [Builder.number] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun number(number: JsonField<String>) = apply { this.number = number }

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
             *
             * The following fields are required:
             * ```java
             * .callbackUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    sandbox,
                    checkRequired("callbackUrl", callbackUrl),
                    areaCode,
                    defaultForAppCalls,
                    number,
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
            areaCode()
            defaultForAppCalls()
            number()
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
                (if (areaCode.asKnown().isPresent) 1 else 0) +
                (if (defaultForAppCalls.asKnown().isPresent) 1 else 0) +
                (if (number.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                callbackUrl == other.callbackUrl &&
                areaCode == other.areaCode &&
                defaultForAppCalls == other.defaultForAppCalls &&
                number == other.number &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                sandbox,
                callbackUrl,
                areaCode,
                defaultForAppCalls,
                number,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, callbackUrl=$callbackUrl, areaCode=$areaCode, defaultForAppCalls=$defaultForAppCalls, number=$number, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VoiceCreateParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
