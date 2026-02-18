// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.users

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.Params
import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import com.sent_dm.api.errors.SentDmInvalidDataException
import com.sent_dm.api.models.webhooks.MutationRequest
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates a user's role in the organization or profile. Requires admin role. You cannot change your
 * own role or demote the last admin.
 */
class UserUpdateRoleParams
private constructor(
    private val pathUserId: String?,
    private val idempotencyKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun pathUserId(): Optional<String> = Optional.ofNullable(pathUserId)

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
     * User role: admin, billing, or developer (required)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun role(): Optional<String> = body.role()

    /**
     * User ID from route parameter
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bodyUserId(): Optional<String> = body.bodyUserId()

    /**
     * Returns the raw JSON value of [testMode].
     *
     * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _testMode(): JsonField<Boolean> = body._testMode()

    /**
     * Returns the raw JSON value of [role].
     *
     * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _role(): JsonField<String> = body._role()

    /**
     * Returns the raw JSON value of [bodyUserId].
     *
     * Unlike [bodyUserId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _bodyUserId(): JsonField<String> = body._bodyUserId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): UserUpdateRoleParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [UserUpdateRoleParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserUpdateRoleParams]. */
    class Builder internal constructor() {

        private var pathUserId: String? = null
        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userUpdateRoleParams: UserUpdateRoleParams) = apply {
            pathUserId = userUpdateRoleParams.pathUserId
            idempotencyKey = userUpdateRoleParams.idempotencyKey
            body = userUpdateRoleParams.body.toBuilder()
            additionalHeaders = userUpdateRoleParams.additionalHeaders.toBuilder()
            additionalQueryParams = userUpdateRoleParams.additionalQueryParams.toBuilder()
        }

        fun pathUserId(pathUserId: String?) = apply { this.pathUserId = pathUserId }

        /** Alias for calling [Builder.pathUserId] with `pathUserId.orElse(null)`. */
        fun pathUserId(pathUserId: Optional<String>) = pathUserId(pathUserId.getOrNull())

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
         * - [role]
         * - [bodyUserId]
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

        /** User role: admin, billing, or developer (required) */
        fun role(role: String) = apply { body.role(role) }

        /**
         * Sets [Builder.role] to an arbitrary JSON value.
         *
         * You should usually call [Builder.role] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun role(role: JsonField<String>) = apply { body.role(role) }

        /** User ID from route parameter */
        fun bodyUserId(bodyUserId: String) = apply { body.bodyUserId(bodyUserId) }

        /**
         * Sets [Builder.bodyUserId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bodyUserId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bodyUserId(bodyUserId: JsonField<String>) = apply { body.bodyUserId(bodyUserId) }

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
         * Returns an immutable instance of [UserUpdateRoleParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserUpdateRoleParams =
            UserUpdateRoleParams(
                pathUserId,
                idempotencyKey,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> pathUserId ?: ""
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

    /** Request to update a user's role */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val testMode: JsonField<Boolean>,
        private val role: JsonField<String>,
        private val bodyUserId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("test_mode")
            @ExcludeMissing
            testMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("role") @ExcludeMissing role: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_id")
            @ExcludeMissing
            bodyUserId: JsonField<String> = JsonMissing.of(),
        ) : this(testMode, role, bodyUserId, mutableMapOf())

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
         * User role: admin, billing, or developer (required)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun role(): Optional<String> = role.getOptional("role")

        /**
         * User ID from route parameter
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun bodyUserId(): Optional<String> = bodyUserId.getOptional("user_id")

        /**
         * Returns the raw JSON value of [testMode].
         *
         * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("test_mode") @ExcludeMissing fun _testMode(): JsonField<Boolean> = testMode

        /**
         * Returns the raw JSON value of [role].
         *
         * Unlike [role], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("role") @ExcludeMissing fun _role(): JsonField<String> = role

        /**
         * Returns the raw JSON value of [bodyUserId].
         *
         * Unlike [bodyUserId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_id") @ExcludeMissing fun _bodyUserId(): JsonField<String> = bodyUserId

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
            private var role: JsonField<String> = JsonMissing.of()
            private var bodyUserId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                testMode = body.testMode
                role = body.role
                bodyUserId = body.bodyUserId
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

            /** User role: admin, billing, or developer (required) */
            fun role(role: String) = role(JsonField.of(role))

            /**
             * Sets [Builder.role] to an arbitrary JSON value.
             *
             * You should usually call [Builder.role] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun role(role: JsonField<String>) = apply { this.role = role }

            /** User ID from route parameter */
            fun bodyUserId(bodyUserId: String) = bodyUserId(JsonField.of(bodyUserId))

            /**
             * Sets [Builder.bodyUserId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.bodyUserId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun bodyUserId(bodyUserId: JsonField<String>) = apply { this.bodyUserId = bodyUserId }

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
                Body(testMode, role, bodyUserId, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            testMode()
            role()
            bodyUserId()
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
                (if (role.asKnown().isPresent) 1 else 0) +
                (if (bodyUserId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                testMode == other.testMode &&
                role == other.role &&
                bodyUserId == other.bodyUserId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(testMode, role, bodyUserId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{testMode=$testMode, role=$role, bodyUserId=$bodyUserId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserUpdateRoleParams &&
            pathUserId == other.pathUserId &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(pathUserId, idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "UserUpdateRoleParams{pathUserId=$pathUserId, idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
