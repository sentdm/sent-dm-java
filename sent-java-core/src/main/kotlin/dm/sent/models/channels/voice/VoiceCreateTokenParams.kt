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
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Mints a short-lived token for one of your app users. Call this from your backend and return the
 * token to your app, which passes it to the voice client SDK to register. The identity is bound to
 * the given number, or to your default app-call number when omitted, and calls placed by that
 * identity are routed through the bound number. Minting again re-binds the identity, so an identity
 * can move between numbers.
 */
class VoiceCreateTokenParams
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
     * Your identifier for the app user, such as an agent or account id. Letters, digits, hyphens
     * and underscores only, up to 200 characters.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun identity(): Optional<String> = body.identity()

    /**
     * One of your voice-enabled phone numbers in E.164 format. Calls placed by this identity are
     * routed through that number. Omit to use your default app-call number.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun number(): Optional<String> = body.number()

    /**
     * Token lifetime in seconds. Defaults to 600 and cannot exceed 3600.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun ttl(): Optional<Int> = body.ttl()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [identity].
     *
     * Unlike [identity], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _identity(): JsonField<String> = body._identity()

    /**
     * Returns the raw JSON value of [number].
     *
     * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _number(): JsonField<String> = body._number()

    /**
     * Returns the raw JSON value of [ttl].
     *
     * Unlike [ttl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _ttl(): JsonField<Int> = body._ttl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): VoiceCreateTokenParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [VoiceCreateTokenParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceCreateTokenParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(voiceCreateTokenParams: VoiceCreateTokenParams) = apply {
            idempotencyKey = voiceCreateTokenParams.idempotencyKey
            xProfileId = voiceCreateTokenParams.xProfileId
            body = voiceCreateTokenParams.body.toBuilder()
            additionalHeaders = voiceCreateTokenParams.additionalHeaders.toBuilder()
            additionalQueryParams = voiceCreateTokenParams.additionalQueryParams.toBuilder()
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
         * - [identity]
         * - [number]
         * - [ttl]
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
         * Your identifier for the app user, such as an agent or account id. Letters, digits,
         * hyphens and underscores only, up to 200 characters.
         */
        fun identity(identity: String) = apply { body.identity(identity) }

        /**
         * Sets [Builder.identity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.identity] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun identity(identity: JsonField<String>) = apply { body.identity(identity) }

        /**
         * One of your voice-enabled phone numbers in E.164 format. Calls placed by this identity
         * are routed through that number. Omit to use your default app-call number.
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

        /** Token lifetime in seconds. Defaults to 600 and cannot exceed 3600. */
        fun ttl(ttl: Int?) = apply { body.ttl(ttl) }

        /**
         * Alias for [Builder.ttl].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun ttl(ttl: Int) = ttl(ttl as Int?)

        /** Alias for calling [Builder.ttl] with `ttl.orElse(null)`. */
        fun ttl(ttl: Optional<Int>) = ttl(ttl.getOrNull())

        /**
         * Sets [Builder.ttl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ttl] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ttl(ttl: JsonField<Int>) = apply { body.ttl(ttl) }

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
         * Returns an immutable instance of [VoiceCreateTokenParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VoiceCreateTokenParams =
            VoiceCreateTokenParams(
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

    /** Request to mint a voice token for one of your app users */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val sandbox: JsonField<Boolean>,
        private val identity: JsonField<String>,
        private val number: JsonField<String>,
        private val ttl: JsonField<Int>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("identity")
            @ExcludeMissing
            identity: JsonField<String> = JsonMissing.of(),
            @JsonProperty("number") @ExcludeMissing number: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ttl") @ExcludeMissing ttl: JsonField<Int> = JsonMissing.of(),
        ) : this(sandbox, identity, number, ttl, mutableMapOf())

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
         * Your identifier for the app user, such as an agent or account id. Letters, digits,
         * hyphens and underscores only, up to 200 characters.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun identity(): Optional<String> = identity.getOptional("identity")

        /**
         * One of your voice-enabled phone numbers in E.164 format. Calls placed by this identity
         * are routed through that number. Omit to use your default app-call number.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun number(): Optional<String> = number.getOptional("number")

        /**
         * Token lifetime in seconds. Defaults to 600 and cannot exceed 3600.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun ttl(): Optional<Int> = ttl.getOptional("ttl")

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [identity].
         *
         * Unlike [identity], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("identity") @ExcludeMissing fun _identity(): JsonField<String> = identity

        /**
         * Returns the raw JSON value of [number].
         *
         * Unlike [number], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<String> = number

        /**
         * Returns the raw JSON value of [ttl].
         *
         * Unlike [ttl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ttl") @ExcludeMissing fun _ttl(): JsonField<Int> = ttl

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
            private var identity: JsonField<String> = JsonMissing.of()
            private var number: JsonField<String> = JsonMissing.of()
            private var ttl: JsonField<Int> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                sandbox = body.sandbox
                identity = body.identity
                number = body.number
                ttl = body.ttl
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
             * Your identifier for the app user, such as an agent or account id. Letters, digits,
             * hyphens and underscores only, up to 200 characters.
             */
            fun identity(identity: String) = identity(JsonField.of(identity))

            /**
             * Sets [Builder.identity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.identity] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun identity(identity: JsonField<String>) = apply { this.identity = identity }

            /**
             * One of your voice-enabled phone numbers in E.164 format. Calls placed by this
             * identity are routed through that number. Omit to use your default app-call number.
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

            /** Token lifetime in seconds. Defaults to 600 and cannot exceed 3600. */
            fun ttl(ttl: Int?) = ttl(JsonField.ofNullable(ttl))

            /**
             * Alias for [Builder.ttl].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun ttl(ttl: Int) = ttl(ttl as Int?)

            /** Alias for calling [Builder.ttl] with `ttl.orElse(null)`. */
            fun ttl(ttl: Optional<Int>) = ttl(ttl.getOrNull())

            /**
             * Sets [Builder.ttl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ttl] with a well-typed [Int] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ttl(ttl: JsonField<Int>) = apply { this.ttl = ttl }

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
                Body(sandbox, identity, number, ttl, additionalProperties.toMutableMap())
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
            identity()
            number()
            ttl()
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
                (if (identity.asKnown().isPresent) 1 else 0) +
                (if (number.asKnown().isPresent) 1 else 0) +
                (if (ttl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                sandbox == other.sandbox &&
                identity == other.identity &&
                number == other.number &&
                ttl == other.ttl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(sandbox, identity, number, ttl, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{sandbox=$sandbox, identity=$identity, number=$number, ttl=$ttl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceCreateTokenParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "VoiceCreateTokenParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
