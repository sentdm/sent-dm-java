// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.Params
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a new message template with header, body, footer, and buttons. The template can be
 * submitted for review immediately or saved as draft for later submission.
 */
class TemplateCreateParams
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
     * Template category: MARKETING, UTILITY, AUTHENTICATION (optional, auto-detected if not
     * provided)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun category(): Optional<String> = body.category()

    /**
     * Source of template creation (default: from-api)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun creationSource(): Optional<String> = body.creationSource()

    /**
     * Complete definition of a message template including header, body, footer, and buttons
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun definition(): Optional<Definition> = body.definition()

    /**
     * Template language code (e.g., en_US) (optional, auto-detected if not provided)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun language(): Optional<String> = body.language()

    /**
     * Sandbox flag - when true, the operation is simulated without side effects Useful for testing
     * integrations without actual execution
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sandbox(): Optional<Boolean> = body.sandbox()

    /**
     * Whether to submit the template for review after creation (default: false)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun submitForReview(): Optional<Boolean> = body.submitForReview()

    /**
     * Returns the raw JSON value of [category].
     *
     * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _category(): JsonField<String> = body._category()

    /**
     * Returns the raw JSON value of [creationSource].
     *
     * Unlike [creationSource], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _creationSource(): JsonField<String> = body._creationSource()

    /**
     * Returns the raw JSON value of [definition].
     *
     * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _definition(): JsonField<Definition> = body._definition()

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _language(): JsonField<String> = body._language()

    /**
     * Returns the raw JSON value of [sandbox].
     *
     * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sandbox(): JsonField<Boolean> = body._sandbox()

    /**
     * Returns the raw JSON value of [submitForReview].
     *
     * Unlike [submitForReview], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _submitForReview(): JsonField<Boolean> = body._submitForReview()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TemplateCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [TemplateCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateCreateParams]. */
    class Builder internal constructor() {

        private var idempotencyKey: String? = null
        private var xProfileId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(templateCreateParams: TemplateCreateParams) = apply {
            idempotencyKey = templateCreateParams.idempotencyKey
            xProfileId = templateCreateParams.xProfileId
            body = templateCreateParams.body.toBuilder()
            additionalHeaders = templateCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = templateCreateParams.additionalQueryParams.toBuilder()
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
         * - [category]
         * - [creationSource]
         * - [definition]
         * - [language]
         * - [sandbox]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Template category: MARKETING, UTILITY, AUTHENTICATION (optional, auto-detected if not
         * provided)
         */
        fun category(category: String?) = apply { body.category(category) }

        /** Alias for calling [Builder.category] with `category.orElse(null)`. */
        fun category(category: Optional<String>) = category(category.getOrNull())

        /**
         * Sets [Builder.category] to an arbitrary JSON value.
         *
         * You should usually call [Builder.category] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun category(category: JsonField<String>) = apply { body.category(category) }

        /** Source of template creation (default: from-api) */
        fun creationSource(creationSource: String?) = apply { body.creationSource(creationSource) }

        /** Alias for calling [Builder.creationSource] with `creationSource.orElse(null)`. */
        fun creationSource(creationSource: Optional<String>) =
            creationSource(creationSource.getOrNull())

        /**
         * Sets [Builder.creationSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.creationSource] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun creationSource(creationSource: JsonField<String>) = apply {
            body.creationSource(creationSource)
        }

        /** Complete definition of a message template including header, body, footer, and buttons */
        fun definition(definition: Definition) = apply { body.definition(definition) }

        /**
         * Sets [Builder.definition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.definition] with a well-typed [Definition] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun definition(definition: JsonField<Definition>) = apply { body.definition(definition) }

        /** Template language code (e.g., en_US) (optional, auto-detected if not provided) */
        fun language(language: String?) = apply { body.language(language) }

        /** Alias for calling [Builder.language] with `language.orElse(null)`. */
        fun language(language: Optional<String>) = language(language.getOrNull())

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { body.language(language) }

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

        /** Whether to submit the template for review after creation (default: false) */
        fun submitForReview(submitForReview: Boolean) = apply {
            body.submitForReview(submitForReview)
        }

        /**
         * Sets [Builder.submitForReview] to an arbitrary JSON value.
         *
         * You should usually call [Builder.submitForReview] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun submitForReview(submitForReview: JsonField<Boolean>) = apply {
            body.submitForReview(submitForReview)
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
         * Returns an immutable instance of [TemplateCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateCreateParams =
            TemplateCreateParams(
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

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val category: JsonField<String>,
        private val creationSource: JsonField<String>,
        private val definition: JsonField<Definition>,
        private val language: JsonField<String>,
        private val sandbox: JsonField<Boolean>,
        private val submitForReview: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("category")
            @ExcludeMissing
            category: JsonField<String> = JsonMissing.of(),
            @JsonProperty("creation_source")
            @ExcludeMissing
            creationSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("definition")
            @ExcludeMissing
            definition: JsonField<Definition> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sandbox") @ExcludeMissing sandbox: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("submit_for_review")
            @ExcludeMissing
            submitForReview: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            category,
            creationSource,
            definition,
            language,
            sandbox,
            submitForReview,
            mutableMapOf(),
        )

        /**
         * Template category: MARKETING, UTILITY, AUTHENTICATION (optional, auto-detected if not
         * provided)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun category(): Optional<String> = category.getOptional("category")

        /**
         * Source of template creation (default: from-api)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun creationSource(): Optional<String> = creationSource.getOptional("creation_source")

        /**
         * Complete definition of a message template including header, body, footer, and buttons
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun definition(): Optional<Definition> = definition.getOptional("definition")

        /**
         * Template language code (e.g., en_US) (optional, auto-detected if not provided)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * Sandbox flag - when true, the operation is simulated without side effects Useful for
         * testing integrations without actual execution
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sandbox(): Optional<Boolean> = sandbox.getOptional("sandbox")

        /**
         * Whether to submit the template for review after creation (default: false)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submitForReview(): Optional<Boolean> = submitForReview.getOptional("submit_for_review")

        /**
         * Returns the raw JSON value of [category].
         *
         * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

        /**
         * Returns the raw JSON value of [creationSource].
         *
         * Unlike [creationSource], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("creation_source")
        @ExcludeMissing
        fun _creationSource(): JsonField<String> = creationSource

        /**
         * Returns the raw JSON value of [definition].
         *
         * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("definition")
        @ExcludeMissing
        fun _definition(): JsonField<Definition> = definition

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [sandbox].
         *
         * Unlike [sandbox], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sandbox") @ExcludeMissing fun _sandbox(): JsonField<Boolean> = sandbox

        /**
         * Returns the raw JSON value of [submitForReview].
         *
         * Unlike [submitForReview], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("submit_for_review")
        @ExcludeMissing
        fun _submitForReview(): JsonField<Boolean> = submitForReview

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

            private var category: JsonField<String> = JsonMissing.of()
            private var creationSource: JsonField<String> = JsonMissing.of()
            private var definition: JsonField<Definition> = JsonMissing.of()
            private var language: JsonField<String> = JsonMissing.of()
            private var sandbox: JsonField<Boolean> = JsonMissing.of()
            private var submitForReview: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                category = body.category
                creationSource = body.creationSource
                definition = body.definition
                language = body.language
                sandbox = body.sandbox
                submitForReview = body.submitForReview
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Template category: MARKETING, UTILITY, AUTHENTICATION (optional, auto-detected if not
             * provided)
             */
            fun category(category: String?) = category(JsonField.ofNullable(category))

            /** Alias for calling [Builder.category] with `category.orElse(null)`. */
            fun category(category: Optional<String>) = category(category.getOrNull())

            /**
             * Sets [Builder.category] to an arbitrary JSON value.
             *
             * You should usually call [Builder.category] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun category(category: JsonField<String>) = apply { this.category = category }

            /** Source of template creation (default: from-api) */
            fun creationSource(creationSource: String?) =
                creationSource(JsonField.ofNullable(creationSource))

            /** Alias for calling [Builder.creationSource] with `creationSource.orElse(null)`. */
            fun creationSource(creationSource: Optional<String>) =
                creationSource(creationSource.getOrNull())

            /**
             * Sets [Builder.creationSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.creationSource] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun creationSource(creationSource: JsonField<String>) = apply {
                this.creationSource = creationSource
            }

            /**
             * Complete definition of a message template including header, body, footer, and buttons
             */
            fun definition(definition: Definition) = definition(JsonField.of(definition))

            /**
             * Sets [Builder.definition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.definition] with a well-typed [Definition] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun definition(definition: JsonField<Definition>) = apply {
                this.definition = definition
            }

            /** Template language code (e.g., en_US) (optional, auto-detected if not provided) */
            fun language(language: String?) = language(JsonField.ofNullable(language))

            /** Alias for calling [Builder.language] with `language.orElse(null)`. */
            fun language(language: Optional<String>) = language(language.getOrNull())

            /**
             * Sets [Builder.language] to an arbitrary JSON value.
             *
             * You should usually call [Builder.language] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun language(language: JsonField<String>) = apply { this.language = language }

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

            /** Whether to submit the template for review after creation (default: false) */
            fun submitForReview(submitForReview: Boolean) =
                submitForReview(JsonField.of(submitForReview))

            /**
             * Sets [Builder.submitForReview] to an arbitrary JSON value.
             *
             * You should usually call [Builder.submitForReview] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun submitForReview(submitForReview: JsonField<Boolean>) = apply {
                this.submitForReview = submitForReview
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
                    category,
                    creationSource,
                    definition,
                    language,
                    sandbox,
                    submitForReview,
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

            category()
            creationSource()
            definition().ifPresent { it.validate() }
            language()
            sandbox()
            submitForReview()
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
            (if (category.asKnown().isPresent) 1 else 0) +
                (if (creationSource.asKnown().isPresent) 1 else 0) +
                (definition.asKnown().getOrNull()?.validity() ?: 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (sandbox.asKnown().isPresent) 1 else 0) +
                (if (submitForReview.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                category == other.category &&
                creationSource == other.creationSource &&
                definition == other.definition &&
                language == other.language &&
                sandbox == other.sandbox &&
                submitForReview == other.submitForReview &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                category,
                creationSource,
                definition,
                language,
                sandbox,
                submitForReview,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{category=$category, creationSource=$creationSource, definition=$definition, language=$language, sandbox=$sandbox, submitForReview=$submitForReview, additionalProperties=$additionalProperties}"
    }

    /** Complete definition of a message template including header, body, footer, and buttons */
    class Definition
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val body: JsonField<Body>,
        private val authenticationConfig: JsonField<AuthenticationConfig>,
        private val buttons: JsonField<List<Button>>,
        private val definitionVersion: JsonField<String>,
        private val footer: JsonField<Footer>,
        private val header: JsonField<Header>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<Body> = JsonMissing.of(),
            @JsonProperty("authenticationConfig")
            @ExcludeMissing
            authenticationConfig: JsonField<AuthenticationConfig> = JsonMissing.of(),
            @JsonProperty("buttons")
            @ExcludeMissing
            buttons: JsonField<List<Button>> = JsonMissing.of(),
            @JsonProperty("definitionVersion")
            @ExcludeMissing
            definitionVersion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("footer") @ExcludeMissing footer: JsonField<Footer> = JsonMissing.of(),
            @JsonProperty("header") @ExcludeMissing header: JsonField<Header> = JsonMissing.of(),
        ) : this(
            body,
            authenticationConfig,
            buttons,
            definitionVersion,
            footer,
            header,
            mutableMapOf(),
        )

        /**
         * Body section of a message template with channel-specific content
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun body(): Body = body.getRequired("body")

        /**
         * Configuration for AUTHENTICATION category templates
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun authenticationConfig(): Optional<AuthenticationConfig> =
            authenticationConfig.getOptional("authenticationConfig")

        /**
         * Optional list of interactive buttons (e.g., quick replies, URLs, phone numbers)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun buttons(): Optional<List<Button>> = buttons.getOptional("buttons")

        /**
         * The version of the template definition format
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun definitionVersion(): Optional<String> =
            definitionVersion.getOptional("definitionVersion")

        /**
         * Footer section of a message template
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun footer(): Optional<Footer> = footer.getOptional("footer")

        /**
         * Header section of a message template
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun header(): Optional<Header> = header.getOptional("header")

        /**
         * Returns the raw JSON value of [body].
         *
         * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<Body> = body

        /**
         * Returns the raw JSON value of [authenticationConfig].
         *
         * Unlike [authenticationConfig], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("authenticationConfig")
        @ExcludeMissing
        fun _authenticationConfig(): JsonField<AuthenticationConfig> = authenticationConfig

        /**
         * Returns the raw JSON value of [buttons].
         *
         * Unlike [buttons], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("buttons") @ExcludeMissing fun _buttons(): JsonField<List<Button>> = buttons

        /**
         * Returns the raw JSON value of [definitionVersion].
         *
         * Unlike [definitionVersion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("definitionVersion")
        @ExcludeMissing
        fun _definitionVersion(): JsonField<String> = definitionVersion

        /**
         * Returns the raw JSON value of [footer].
         *
         * Unlike [footer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("footer") @ExcludeMissing fun _footer(): JsonField<Footer> = footer

        /**
         * Returns the raw JSON value of [header].
         *
         * Unlike [header], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("header") @ExcludeMissing fun _header(): JsonField<Header> = header

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
             * Returns a mutable builder for constructing an instance of [Definition].
             *
             * The following fields are required:
             * ```java
             * .body()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Definition]. */
        class Builder internal constructor() {

            private var body: JsonField<Body>? = null
            private var authenticationConfig: JsonField<AuthenticationConfig> = JsonMissing.of()
            private var buttons: JsonField<MutableList<Button>>? = null
            private var definitionVersion: JsonField<String> = JsonMissing.of()
            private var footer: JsonField<Footer> = JsonMissing.of()
            private var header: JsonField<Header> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(definition: Definition) = apply {
                body = definition.body
                authenticationConfig = definition.authenticationConfig
                buttons = definition.buttons.map { it.toMutableList() }
                definitionVersion = definition.definitionVersion
                footer = definition.footer
                header = definition.header
                additionalProperties = definition.additionalProperties.toMutableMap()
            }

            /** Body section of a message template with channel-specific content */
            fun body(body: Body) = body(JsonField.of(body))

            /**
             * Sets [Builder.body] to an arbitrary JSON value.
             *
             * You should usually call [Builder.body] with a well-typed [Body] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun body(body: JsonField<Body>) = apply { this.body = body }

            /** Configuration for AUTHENTICATION category templates */
            fun authenticationConfig(authenticationConfig: AuthenticationConfig?) =
                authenticationConfig(JsonField.ofNullable(authenticationConfig))

            /**
             * Alias for calling [Builder.authenticationConfig] with
             * `authenticationConfig.orElse(null)`.
             */
            fun authenticationConfig(authenticationConfig: Optional<AuthenticationConfig>) =
                authenticationConfig(authenticationConfig.getOrNull())

            /**
             * Sets [Builder.authenticationConfig] to an arbitrary JSON value.
             *
             * You should usually call [Builder.authenticationConfig] with a well-typed
             * [AuthenticationConfig] value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun authenticationConfig(authenticationConfig: JsonField<AuthenticationConfig>) =
                apply {
                    this.authenticationConfig = authenticationConfig
                }

            /** Optional list of interactive buttons (e.g., quick replies, URLs, phone numbers) */
            fun buttons(buttons: List<Button>?) = buttons(JsonField.ofNullable(buttons))

            /** Alias for calling [Builder.buttons] with `buttons.orElse(null)`. */
            fun buttons(buttons: Optional<List<Button>>) = buttons(buttons.getOrNull())

            /**
             * Sets [Builder.buttons] to an arbitrary JSON value.
             *
             * You should usually call [Builder.buttons] with a well-typed `List<Button>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun buttons(buttons: JsonField<List<Button>>) = apply {
                this.buttons = buttons.map { it.toMutableList() }
            }

            /**
             * Adds a single [Button] to [buttons].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addButton(button: Button) = apply {
                buttons =
                    (buttons ?: JsonField.of(mutableListOf())).also {
                        checkKnown("buttons", it).add(button)
                    }
            }

            /** The version of the template definition format */
            fun definitionVersion(definitionVersion: String?) =
                definitionVersion(JsonField.ofNullable(definitionVersion))

            /**
             * Alias for calling [Builder.definitionVersion] with `definitionVersion.orElse(null)`.
             */
            fun definitionVersion(definitionVersion: Optional<String>) =
                definitionVersion(definitionVersion.getOrNull())

            /**
             * Sets [Builder.definitionVersion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.definitionVersion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun definitionVersion(definitionVersion: JsonField<String>) = apply {
                this.definitionVersion = definitionVersion
            }

            /** Footer section of a message template */
            fun footer(footer: Footer?) = footer(JsonField.ofNullable(footer))

            /** Alias for calling [Builder.footer] with `footer.orElse(null)`. */
            fun footer(footer: Optional<Footer>) = footer(footer.getOrNull())

            /**
             * Sets [Builder.footer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.footer] with a well-typed [Footer] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun footer(footer: JsonField<Footer>) = apply { this.footer = footer }

            /** Header section of a message template */
            fun header(header: Header?) = header(JsonField.ofNullable(header))

            /** Alias for calling [Builder.header] with `header.orElse(null)`. */
            fun header(header: Optional<Header>) = header(header.getOrNull())

            /**
             * Sets [Builder.header] to an arbitrary JSON value.
             *
             * You should usually call [Builder.header] with a well-typed [Header] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun header(header: JsonField<Header>) = apply { this.header = header }

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
             * Returns an immutable instance of [Definition].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .body()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Definition =
                Definition(
                    checkRequired("body", body),
                    authenticationConfig,
                    (buttons ?: JsonMissing.of()).map { it.toImmutable() },
                    definitionVersion,
                    footer,
                    header,
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
        fun validate(): Definition = apply {
            if (validated) {
                return@apply
            }

            body().validate()
            authenticationConfig().ifPresent { it.validate() }
            buttons().ifPresent { it.forEach { it.validate() } }
            definitionVersion()
            footer().ifPresent { it.validate() }
            header().ifPresent { it.validate() }
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
            (body.asKnown().getOrNull()?.validity() ?: 0) +
                (authenticationConfig.asKnown().getOrNull()?.validity() ?: 0) +
                (buttons.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (definitionVersion.asKnown().isPresent) 1 else 0) +
                (footer.asKnown().getOrNull()?.validity() ?: 0) +
                (header.asKnown().getOrNull()?.validity() ?: 0)

        /** Body section of a message template with channel-specific content */
        class Body
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val multiChannel: JsonField<MultiChannel>,
            private val rcs: JsonField<Rcs>,
            private val sms: JsonField<Sms>,
            private val whatsapp: JsonField<Whatsapp>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("multiChannel")
                @ExcludeMissing
                multiChannel: JsonField<MultiChannel> = JsonMissing.of(),
                @JsonProperty("rcs") @ExcludeMissing rcs: JsonField<Rcs> = JsonMissing.of(),
                @JsonProperty("sms") @ExcludeMissing sms: JsonField<Sms> = JsonMissing.of(),
                @JsonProperty("whatsapp")
                @ExcludeMissing
                whatsapp: JsonField<Whatsapp> = JsonMissing.of(),
            ) : this(multiChannel, rcs, sms, whatsapp, mutableMapOf())

            /**
             * Content that will be used for all channels (SMS and WhatsApp) unless channel-specific
             * content is provided
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun multiChannel(): Optional<MultiChannel> = multiChannel.getOptional("multiChannel")

            /**
             * RCS-specific content that overrides multi-channel content for RCS messages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun rcs(): Optional<Rcs> = rcs.getOptional("rcs")

            /**
             * SMS-specific content that overrides multi-channel content for SMS messages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun sms(): Optional<Sms> = sms.getOptional("sms")

            /**
             * WhatsApp-specific content that overrides multi-channel content for WhatsApp messages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun whatsapp(): Optional<Whatsapp> = whatsapp.getOptional("whatsapp")

            /**
             * Returns the raw JSON value of [multiChannel].
             *
             * Unlike [multiChannel], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("multiChannel")
            @ExcludeMissing
            fun _multiChannel(): JsonField<MultiChannel> = multiChannel

            /**
             * Returns the raw JSON value of [rcs].
             *
             * Unlike [rcs], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("rcs") @ExcludeMissing fun _rcs(): JsonField<Rcs> = rcs

            /**
             * Returns the raw JSON value of [sms].
             *
             * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<Sms> = sms

            /**
             * Returns the raw JSON value of [whatsapp].
             *
             * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("whatsapp")
            @ExcludeMissing
            fun _whatsapp(): JsonField<Whatsapp> = whatsapp

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

                private var multiChannel: JsonField<MultiChannel> = JsonMissing.of()
                private var rcs: JsonField<Rcs> = JsonMissing.of()
                private var sms: JsonField<Sms> = JsonMissing.of()
                private var whatsapp: JsonField<Whatsapp> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(body: Body) = apply {
                    multiChannel = body.multiChannel
                    rcs = body.rcs
                    sms = body.sms
                    whatsapp = body.whatsapp
                    additionalProperties = body.additionalProperties.toMutableMap()
                }

                /**
                 * Content that will be used for all channels (SMS and WhatsApp) unless
                 * channel-specific content is provided
                 */
                fun multiChannel(multiChannel: MultiChannel?) =
                    multiChannel(JsonField.ofNullable(multiChannel))

                /** Alias for calling [Builder.multiChannel] with `multiChannel.orElse(null)`. */
                fun multiChannel(multiChannel: Optional<MultiChannel>) =
                    multiChannel(multiChannel.getOrNull())

                /**
                 * Sets [Builder.multiChannel] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.multiChannel] with a well-typed [MultiChannel]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun multiChannel(multiChannel: JsonField<MultiChannel>) = apply {
                    this.multiChannel = multiChannel
                }

                /** RCS-specific content that overrides multi-channel content for RCS messages */
                fun rcs(rcs: Rcs?) = rcs(JsonField.ofNullable(rcs))

                /** Alias for calling [Builder.rcs] with `rcs.orElse(null)`. */
                fun rcs(rcs: Optional<Rcs>) = rcs(rcs.getOrNull())

                /**
                 * Sets [Builder.rcs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.rcs] with a well-typed [Rcs] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun rcs(rcs: JsonField<Rcs>) = apply { this.rcs = rcs }

                /** SMS-specific content that overrides multi-channel content for SMS messages */
                fun sms(sms: Sms?) = sms(JsonField.ofNullable(sms))

                /** Alias for calling [Builder.sms] with `sms.orElse(null)`. */
                fun sms(sms: Optional<Sms>) = sms(sms.getOrNull())

                /**
                 * Sets [Builder.sms] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sms] with a well-typed [Sms] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun sms(sms: JsonField<Sms>) = apply { this.sms = sms }

                /**
                 * WhatsApp-specific content that overrides multi-channel content for WhatsApp
                 * messages
                 */
                fun whatsapp(whatsapp: Whatsapp?) = whatsapp(JsonField.ofNullable(whatsapp))

                /** Alias for calling [Builder.whatsapp] with `whatsapp.orElse(null)`. */
                fun whatsapp(whatsapp: Optional<Whatsapp>) = whatsapp(whatsapp.getOrNull())

                /**
                 * Sets [Builder.whatsapp] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.whatsapp] with a well-typed [Whatsapp] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun whatsapp(whatsapp: JsonField<Whatsapp>) = apply { this.whatsapp = whatsapp }

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
                 * Returns an immutable instance of [Body].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Body =
                    Body(multiChannel, rcs, sms, whatsapp, additionalProperties.toMutableMap())
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
            fun validate(): Body = apply {
                if (validated) {
                    return@apply
                }

                multiChannel().ifPresent { it.validate() }
                rcs().ifPresent { it.validate() }
                sms().ifPresent { it.validate() }
                whatsapp().ifPresent { it.validate() }
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
                (multiChannel.asKnown().getOrNull()?.validity() ?: 0) +
                    (rcs.asKnown().getOrNull()?.validity() ?: 0) +
                    (sms.asKnown().getOrNull()?.validity() ?: 0) +
                    (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

            /**
             * Content that will be used for all channels (SMS and WhatsApp) unless channel-specific
             * content is provided
             */
            class MultiChannel
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val template: JsonField<String>,
                private val type: JsonField<String>,
                private val variables: JsonField<List<Variable>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("template")
                    @ExcludeMissing
                    template: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("variables")
                    @ExcludeMissing
                    variables: JsonField<List<Variable>> = JsonMissing.of(),
                ) : this(template, type, variables, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun template(): String = template.getRequired("template")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<String> = type.getOptional("type")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun variables(): Optional<List<Variable>> = variables.getOptional("variables")

                /**
                 * Returns the raw JSON value of [template].
                 *
                 * Unlike [template], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("template")
                @ExcludeMissing
                fun _template(): JsonField<String> = template

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [variables].
                 *
                 * Unlike [variables], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("variables")
                @ExcludeMissing
                fun _variables(): JsonField<List<Variable>> = variables

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
                     * Returns a mutable builder for constructing an instance of [MultiChannel].
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [MultiChannel]. */
                class Builder internal constructor() {

                    private var template: JsonField<String>? = null
                    private var type: JsonField<String> = JsonMissing.of()
                    private var variables: JsonField<MutableList<Variable>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(multiChannel: MultiChannel) = apply {
                        template = multiChannel.template
                        type = multiChannel.type
                        variables = multiChannel.variables.map { it.toMutableList() }
                        additionalProperties = multiChannel.additionalProperties.toMutableMap()
                    }

                    fun template(template: String) = template(JsonField.of(template))

                    /**
                     * Sets [Builder.template] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.template] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun template(template: JsonField<String>) = apply { this.template = template }

                    fun type(type: String?) = type(JsonField.ofNullable(type))

                    /** Alias for calling [Builder.type] with `type.orElse(null)`. */
                    fun type(type: Optional<String>) = type(type.getOrNull())

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun variables(variables: List<Variable>?) =
                        variables(JsonField.ofNullable(variables))

                    /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
                    fun variables(variables: Optional<List<Variable>>) =
                        variables(variables.getOrNull())

                    /**
                     * Sets [Builder.variables] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.variables] with a well-typed
                     * `List<Variable>` value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun variables(variables: JsonField<List<Variable>>) = apply {
                        this.variables = variables.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Variable] to [variables].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVariable(variable: Variable) = apply {
                        variables =
                            (variables ?: JsonField.of(mutableListOf())).also {
                                checkKnown("variables", it).add(variable)
                            }
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
                     * Returns an immutable instance of [MultiChannel].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): MultiChannel =
                        MultiChannel(
                            checkRequired("template", template),
                            type,
                            (variables ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): MultiChannel = apply {
                    if (validated) {
                        return@apply
                    }

                    template()
                    type()
                    variables().ifPresent { it.forEach { it.validate() } }
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
                    (if (template.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                class Variable
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val props: JsonField<Props>,
                    private val type: JsonField<String>,
                    private val id: JsonField<Int>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("props")
                        @ExcludeMissing
                        props: JsonField<Props> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
                    ) : this(name, props, type, id, mutableMapOf())

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun props(): Props = props.getRequired("props")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): String = type.getRequired("type")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun id(): Optional<Int> = id.getOptional("id")

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [props].
                     *
                     * Unlike [props], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                         * Returns a mutable builder for constructing an instance of [Variable].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Variable]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var props: JsonField<Props>? = null
                        private var type: JsonField<String>? = null
                        private var id: JsonField<Int> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(variable: Variable) = apply {
                            name = variable.name
                            props = variable.props
                            type = variable.type
                            id = variable.id
                            additionalProperties = variable.additionalProperties.toMutableMap()
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun props(props: Props) = props(JsonField.of(props))

                        /**
                         * Sets [Builder.props] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.props] with a well-typed [Props] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun props(props: JsonField<Props>) = apply { this.props = props }

                        fun type(type: String) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<String>) = apply { this.type = type }

                        fun id(id: Int) = id(JsonField.of(id))

                        /**
                         * Sets [Builder.id] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.id] with a well-typed [Int] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun id(id: JsonField<Int>) = apply { this.id = id }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Variable].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Variable =
                            Variable(
                                checkRequired("name", name),
                                checkRequired("props", props),
                                checkRequired("type", type),
                                id,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws SentInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Variable = apply {
                        if (validated) {
                            return@apply
                        }

                        name()
                        props().validate()
                        type()
                        id()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            (props.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (type.asKnown().isPresent) 1 else 0) +
                            (if (id.asKnown().isPresent) 1 else 0)

                    class Props
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val mediaType: JsonField<String>,
                        private val sample: JsonField<String>,
                        private val url: JsonField<String>,
                        private val variableType: JsonField<String>,
                        private val alt: JsonField<String>,
                        private val regex: JsonField<String>,
                        private val shortUrl: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("mediaType")
                            @ExcludeMissing
                            mediaType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("sample")
                            @ExcludeMissing
                            sample: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("url")
                            @ExcludeMissing
                            url: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("variableType")
                            @ExcludeMissing
                            variableType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("alt")
                            @ExcludeMissing
                            alt: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("regex")
                            @ExcludeMissing
                            regex: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("shortUrl")
                            @ExcludeMissing
                            shortUrl: JsonField<String> = JsonMissing.of(),
                        ) : this(
                            mediaType,
                            sample,
                            url,
                            variableType,
                            alt,
                            regex,
                            shortUrl,
                            mutableMapOf(),
                        )

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun mediaType(): String = mediaType.getRequired("mediaType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun sample(): String = sample.getRequired("sample")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun url(): String = url.getRequired("url")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun variableType(): String = variableType.getRequired("variableType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun alt(): Optional<String> = alt.getOptional("alt")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun regex(): Optional<String> = regex.getOptional("regex")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

                        /**
                         * Returns the raw JSON value of [mediaType].
                         *
                         * Unlike [mediaType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("mediaType")
                        @ExcludeMissing
                        fun _mediaType(): JsonField<String> = mediaType

                        /**
                         * Returns the raw JSON value of [sample].
                         *
                         * Unlike [sample], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("sample")
                        @ExcludeMissing
                        fun _sample(): JsonField<String> = sample

                        /**
                         * Returns the raw JSON value of [url].
                         *
                         * Unlike [url], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                        /**
                         * Returns the raw JSON value of [variableType].
                         *
                         * Unlike [variableType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("variableType")
                        @ExcludeMissing
                        fun _variableType(): JsonField<String> = variableType

                        /**
                         * Returns the raw JSON value of [alt].
                         *
                         * Unlike [alt], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

                        /**
                         * Returns the raw JSON value of [regex].
                         *
                         * Unlike [regex], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("regex")
                        @ExcludeMissing
                        fun _regex(): JsonField<String> = regex

                        /**
                         * Returns the raw JSON value of [shortUrl].
                         *
                         * Unlike [shortUrl], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("shortUrl")
                        @ExcludeMissing
                        fun _shortUrl(): JsonField<String> = shortUrl

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
                             * Returns a mutable builder for constructing an instance of [Props].
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Props]. */
                        class Builder internal constructor() {

                            private var mediaType: JsonField<String>? = null
                            private var sample: JsonField<String>? = null
                            private var url: JsonField<String>? = null
                            private var variableType: JsonField<String>? = null
                            private var alt: JsonField<String> = JsonMissing.of()
                            private var regex: JsonField<String> = JsonMissing.of()
                            private var shortUrl: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(props: Props) = apply {
                                mediaType = props.mediaType
                                sample = props.sample
                                url = props.url
                                variableType = props.variableType
                                alt = props.alt
                                regex = props.regex
                                shortUrl = props.shortUrl
                                additionalProperties = props.additionalProperties.toMutableMap()
                            }

                            fun mediaType(mediaType: String) = mediaType(JsonField.of(mediaType))

                            /**
                             * Sets [Builder.mediaType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.mediaType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun mediaType(mediaType: JsonField<String>) = apply {
                                this.mediaType = mediaType
                            }

                            fun sample(sample: String) = sample(JsonField.of(sample))

                            /**
                             * Sets [Builder.sample] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.sample] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun sample(sample: JsonField<String>) = apply { this.sample = sample }

                            fun url(url: String) = url(JsonField.of(url))

                            /**
                             * Sets [Builder.url] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.url] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun url(url: JsonField<String>) = apply { this.url = url }

                            fun variableType(variableType: String) =
                                variableType(JsonField.of(variableType))

                            /**
                             * Sets [Builder.variableType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.variableType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun variableType(variableType: JsonField<String>) = apply {
                                this.variableType = variableType
                            }

                            fun alt(alt: String?) = alt(JsonField.ofNullable(alt))

                            /** Alias for calling [Builder.alt] with `alt.orElse(null)`. */
                            fun alt(alt: Optional<String>) = alt(alt.getOrNull())

                            /**
                             * Sets [Builder.alt] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.alt] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun alt(alt: JsonField<String>) = apply { this.alt = alt }

                            fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

                            /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
                            fun regex(regex: Optional<String>) = regex(regex.getOrNull())

                            /**
                             * Sets [Builder.regex] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.regex] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun regex(regex: JsonField<String>) = apply { this.regex = regex }

                            fun shortUrl(shortUrl: String?) =
                                shortUrl(JsonField.ofNullable(shortUrl))

                            /**
                             * Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`.
                             */
                            fun shortUrl(shortUrl: Optional<String>) =
                                shortUrl(shortUrl.getOrNull())

                            /**
                             * Sets [Builder.shortUrl] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.shortUrl] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun shortUrl(shortUrl: JsonField<String>) = apply {
                                this.shortUrl = shortUrl
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Props].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Props =
                                Props(
                                    checkRequired("mediaType", mediaType),
                                    checkRequired("sample", sample),
                                    checkRequired("url", url),
                                    checkRequired("variableType", variableType),
                                    alt,
                                    regex,
                                    shortUrl,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws SentInvalidDataException if any value type in this object doesn't
                         *   match its expected type.
                         */
                        fun validate(): Props = apply {
                            if (validated) {
                                return@apply
                            }

                            mediaType()
                            sample()
                            url()
                            variableType()
                            alt()
                            regex()
                            shortUrl()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (mediaType.asKnown().isPresent) 1 else 0) +
                                (if (sample.asKnown().isPresent) 1 else 0) +
                                (if (url.asKnown().isPresent) 1 else 0) +
                                (if (variableType.asKnown().isPresent) 1 else 0) +
                                (if (alt.asKnown().isPresent) 1 else 0) +
                                (if (regex.asKnown().isPresent) 1 else 0) +
                                (if (shortUrl.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Props &&
                                mediaType == other.mediaType &&
                                sample == other.sample &&
                                url == other.url &&
                                variableType == other.variableType &&
                                alt == other.alt &&
                                regex == other.regex &&
                                shortUrl == other.shortUrl &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                mediaType,
                                sample,
                                url,
                                variableType,
                                alt,
                                regex,
                                shortUrl,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Props{mediaType=$mediaType, sample=$sample, url=$url, variableType=$variableType, alt=$alt, regex=$regex, shortUrl=$shortUrl, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Variable &&
                            name == other.name &&
                            props == other.props &&
                            type == other.type &&
                            id == other.id &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, props, type, id, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Variable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is MultiChannel &&
                        template == other.template &&
                        type == other.type &&
                        variables == other.variables &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(template, type, variables, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "MultiChannel{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
            }

            /** RCS-specific content that overrides multi-channel content for RCS messages */
            class Rcs
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val template: JsonField<String>,
                private val type: JsonField<String>,
                private val variables: JsonField<List<Variable>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("template")
                    @ExcludeMissing
                    template: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("variables")
                    @ExcludeMissing
                    variables: JsonField<List<Variable>> = JsonMissing.of(),
                ) : this(template, type, variables, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun template(): String = template.getRequired("template")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<String> = type.getOptional("type")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun variables(): Optional<List<Variable>> = variables.getOptional("variables")

                /**
                 * Returns the raw JSON value of [template].
                 *
                 * Unlike [template], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("template")
                @ExcludeMissing
                fun _template(): JsonField<String> = template

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [variables].
                 *
                 * Unlike [variables], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("variables")
                @ExcludeMissing
                fun _variables(): JsonField<List<Variable>> = variables

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
                     * Returns a mutable builder for constructing an instance of [Rcs].
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Rcs]. */
                class Builder internal constructor() {

                    private var template: JsonField<String>? = null
                    private var type: JsonField<String> = JsonMissing.of()
                    private var variables: JsonField<MutableList<Variable>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(rcs: Rcs) = apply {
                        template = rcs.template
                        type = rcs.type
                        variables = rcs.variables.map { it.toMutableList() }
                        additionalProperties = rcs.additionalProperties.toMutableMap()
                    }

                    fun template(template: String) = template(JsonField.of(template))

                    /**
                     * Sets [Builder.template] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.template] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun template(template: JsonField<String>) = apply { this.template = template }

                    fun type(type: String?) = type(JsonField.ofNullable(type))

                    /** Alias for calling [Builder.type] with `type.orElse(null)`. */
                    fun type(type: Optional<String>) = type(type.getOrNull())

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun variables(variables: List<Variable>?) =
                        variables(JsonField.ofNullable(variables))

                    /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
                    fun variables(variables: Optional<List<Variable>>) =
                        variables(variables.getOrNull())

                    /**
                     * Sets [Builder.variables] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.variables] with a well-typed
                     * `List<Variable>` value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun variables(variables: JsonField<List<Variable>>) = apply {
                        this.variables = variables.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Variable] to [variables].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVariable(variable: Variable) = apply {
                        variables =
                            (variables ?: JsonField.of(mutableListOf())).also {
                                checkKnown("variables", it).add(variable)
                            }
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
                     * Returns an immutable instance of [Rcs].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Rcs =
                        Rcs(
                            checkRequired("template", template),
                            type,
                            (variables ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Rcs = apply {
                    if (validated) {
                        return@apply
                    }

                    template()
                    type()
                    variables().ifPresent { it.forEach { it.validate() } }
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
                    (if (template.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                class Variable
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val props: JsonField<Props>,
                    private val type: JsonField<String>,
                    private val id: JsonField<Int>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("props")
                        @ExcludeMissing
                        props: JsonField<Props> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
                    ) : this(name, props, type, id, mutableMapOf())

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun props(): Props = props.getRequired("props")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): String = type.getRequired("type")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun id(): Optional<Int> = id.getOptional("id")

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [props].
                     *
                     * Unlike [props], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                         * Returns a mutable builder for constructing an instance of [Variable].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Variable]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var props: JsonField<Props>? = null
                        private var type: JsonField<String>? = null
                        private var id: JsonField<Int> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(variable: Variable) = apply {
                            name = variable.name
                            props = variable.props
                            type = variable.type
                            id = variable.id
                            additionalProperties = variable.additionalProperties.toMutableMap()
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun props(props: Props) = props(JsonField.of(props))

                        /**
                         * Sets [Builder.props] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.props] with a well-typed [Props] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun props(props: JsonField<Props>) = apply { this.props = props }

                        fun type(type: String) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<String>) = apply { this.type = type }

                        fun id(id: Int) = id(JsonField.of(id))

                        /**
                         * Sets [Builder.id] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.id] with a well-typed [Int] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun id(id: JsonField<Int>) = apply { this.id = id }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Variable].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Variable =
                            Variable(
                                checkRequired("name", name),
                                checkRequired("props", props),
                                checkRequired("type", type),
                                id,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws SentInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Variable = apply {
                        if (validated) {
                            return@apply
                        }

                        name()
                        props().validate()
                        type()
                        id()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            (props.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (type.asKnown().isPresent) 1 else 0) +
                            (if (id.asKnown().isPresent) 1 else 0)

                    class Props
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val mediaType: JsonField<String>,
                        private val sample: JsonField<String>,
                        private val url: JsonField<String>,
                        private val variableType: JsonField<String>,
                        private val alt: JsonField<String>,
                        private val regex: JsonField<String>,
                        private val shortUrl: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("mediaType")
                            @ExcludeMissing
                            mediaType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("sample")
                            @ExcludeMissing
                            sample: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("url")
                            @ExcludeMissing
                            url: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("variableType")
                            @ExcludeMissing
                            variableType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("alt")
                            @ExcludeMissing
                            alt: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("regex")
                            @ExcludeMissing
                            regex: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("shortUrl")
                            @ExcludeMissing
                            shortUrl: JsonField<String> = JsonMissing.of(),
                        ) : this(
                            mediaType,
                            sample,
                            url,
                            variableType,
                            alt,
                            regex,
                            shortUrl,
                            mutableMapOf(),
                        )

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun mediaType(): String = mediaType.getRequired("mediaType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun sample(): String = sample.getRequired("sample")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun url(): String = url.getRequired("url")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun variableType(): String = variableType.getRequired("variableType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun alt(): Optional<String> = alt.getOptional("alt")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun regex(): Optional<String> = regex.getOptional("regex")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

                        /**
                         * Returns the raw JSON value of [mediaType].
                         *
                         * Unlike [mediaType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("mediaType")
                        @ExcludeMissing
                        fun _mediaType(): JsonField<String> = mediaType

                        /**
                         * Returns the raw JSON value of [sample].
                         *
                         * Unlike [sample], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("sample")
                        @ExcludeMissing
                        fun _sample(): JsonField<String> = sample

                        /**
                         * Returns the raw JSON value of [url].
                         *
                         * Unlike [url], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                        /**
                         * Returns the raw JSON value of [variableType].
                         *
                         * Unlike [variableType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("variableType")
                        @ExcludeMissing
                        fun _variableType(): JsonField<String> = variableType

                        /**
                         * Returns the raw JSON value of [alt].
                         *
                         * Unlike [alt], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

                        /**
                         * Returns the raw JSON value of [regex].
                         *
                         * Unlike [regex], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("regex")
                        @ExcludeMissing
                        fun _regex(): JsonField<String> = regex

                        /**
                         * Returns the raw JSON value of [shortUrl].
                         *
                         * Unlike [shortUrl], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("shortUrl")
                        @ExcludeMissing
                        fun _shortUrl(): JsonField<String> = shortUrl

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
                             * Returns a mutable builder for constructing an instance of [Props].
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Props]. */
                        class Builder internal constructor() {

                            private var mediaType: JsonField<String>? = null
                            private var sample: JsonField<String>? = null
                            private var url: JsonField<String>? = null
                            private var variableType: JsonField<String>? = null
                            private var alt: JsonField<String> = JsonMissing.of()
                            private var regex: JsonField<String> = JsonMissing.of()
                            private var shortUrl: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(props: Props) = apply {
                                mediaType = props.mediaType
                                sample = props.sample
                                url = props.url
                                variableType = props.variableType
                                alt = props.alt
                                regex = props.regex
                                shortUrl = props.shortUrl
                                additionalProperties = props.additionalProperties.toMutableMap()
                            }

                            fun mediaType(mediaType: String) = mediaType(JsonField.of(mediaType))

                            /**
                             * Sets [Builder.mediaType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.mediaType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun mediaType(mediaType: JsonField<String>) = apply {
                                this.mediaType = mediaType
                            }

                            fun sample(sample: String) = sample(JsonField.of(sample))

                            /**
                             * Sets [Builder.sample] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.sample] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun sample(sample: JsonField<String>) = apply { this.sample = sample }

                            fun url(url: String) = url(JsonField.of(url))

                            /**
                             * Sets [Builder.url] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.url] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun url(url: JsonField<String>) = apply { this.url = url }

                            fun variableType(variableType: String) =
                                variableType(JsonField.of(variableType))

                            /**
                             * Sets [Builder.variableType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.variableType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun variableType(variableType: JsonField<String>) = apply {
                                this.variableType = variableType
                            }

                            fun alt(alt: String?) = alt(JsonField.ofNullable(alt))

                            /** Alias for calling [Builder.alt] with `alt.orElse(null)`. */
                            fun alt(alt: Optional<String>) = alt(alt.getOrNull())

                            /**
                             * Sets [Builder.alt] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.alt] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun alt(alt: JsonField<String>) = apply { this.alt = alt }

                            fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

                            /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
                            fun regex(regex: Optional<String>) = regex(regex.getOrNull())

                            /**
                             * Sets [Builder.regex] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.regex] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun regex(regex: JsonField<String>) = apply { this.regex = regex }

                            fun shortUrl(shortUrl: String?) =
                                shortUrl(JsonField.ofNullable(shortUrl))

                            /**
                             * Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`.
                             */
                            fun shortUrl(shortUrl: Optional<String>) =
                                shortUrl(shortUrl.getOrNull())

                            /**
                             * Sets [Builder.shortUrl] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.shortUrl] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun shortUrl(shortUrl: JsonField<String>) = apply {
                                this.shortUrl = shortUrl
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Props].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Props =
                                Props(
                                    checkRequired("mediaType", mediaType),
                                    checkRequired("sample", sample),
                                    checkRequired("url", url),
                                    checkRequired("variableType", variableType),
                                    alt,
                                    regex,
                                    shortUrl,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws SentInvalidDataException if any value type in this object doesn't
                         *   match its expected type.
                         */
                        fun validate(): Props = apply {
                            if (validated) {
                                return@apply
                            }

                            mediaType()
                            sample()
                            url()
                            variableType()
                            alt()
                            regex()
                            shortUrl()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (mediaType.asKnown().isPresent) 1 else 0) +
                                (if (sample.asKnown().isPresent) 1 else 0) +
                                (if (url.asKnown().isPresent) 1 else 0) +
                                (if (variableType.asKnown().isPresent) 1 else 0) +
                                (if (alt.asKnown().isPresent) 1 else 0) +
                                (if (regex.asKnown().isPresent) 1 else 0) +
                                (if (shortUrl.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Props &&
                                mediaType == other.mediaType &&
                                sample == other.sample &&
                                url == other.url &&
                                variableType == other.variableType &&
                                alt == other.alt &&
                                regex == other.regex &&
                                shortUrl == other.shortUrl &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                mediaType,
                                sample,
                                url,
                                variableType,
                                alt,
                                regex,
                                shortUrl,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Props{mediaType=$mediaType, sample=$sample, url=$url, variableType=$variableType, alt=$alt, regex=$regex, shortUrl=$shortUrl, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Variable &&
                            name == other.name &&
                            props == other.props &&
                            type == other.type &&
                            id == other.id &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, props, type, id, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Variable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Rcs &&
                        template == other.template &&
                        type == other.type &&
                        variables == other.variables &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(template, type, variables, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Rcs{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
            }

            /** SMS-specific content that overrides multi-channel content for SMS messages */
            class Sms
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val template: JsonField<String>,
                private val type: JsonField<String>,
                private val variables: JsonField<List<Variable>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("template")
                    @ExcludeMissing
                    template: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("variables")
                    @ExcludeMissing
                    variables: JsonField<List<Variable>> = JsonMissing.of(),
                ) : this(template, type, variables, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun template(): String = template.getRequired("template")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<String> = type.getOptional("type")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun variables(): Optional<List<Variable>> = variables.getOptional("variables")

                /**
                 * Returns the raw JSON value of [template].
                 *
                 * Unlike [template], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("template")
                @ExcludeMissing
                fun _template(): JsonField<String> = template

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [variables].
                 *
                 * Unlike [variables], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("variables")
                @ExcludeMissing
                fun _variables(): JsonField<List<Variable>> = variables

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
                     * Returns a mutable builder for constructing an instance of [Sms].
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Sms]. */
                class Builder internal constructor() {

                    private var template: JsonField<String>? = null
                    private var type: JsonField<String> = JsonMissing.of()
                    private var variables: JsonField<MutableList<Variable>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(sms: Sms) = apply {
                        template = sms.template
                        type = sms.type
                        variables = sms.variables.map { it.toMutableList() }
                        additionalProperties = sms.additionalProperties.toMutableMap()
                    }

                    fun template(template: String) = template(JsonField.of(template))

                    /**
                     * Sets [Builder.template] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.template] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun template(template: JsonField<String>) = apply { this.template = template }

                    fun type(type: String?) = type(JsonField.ofNullable(type))

                    /** Alias for calling [Builder.type] with `type.orElse(null)`. */
                    fun type(type: Optional<String>) = type(type.getOrNull())

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun variables(variables: List<Variable>?) =
                        variables(JsonField.ofNullable(variables))

                    /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
                    fun variables(variables: Optional<List<Variable>>) =
                        variables(variables.getOrNull())

                    /**
                     * Sets [Builder.variables] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.variables] with a well-typed
                     * `List<Variable>` value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun variables(variables: JsonField<List<Variable>>) = apply {
                        this.variables = variables.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Variable] to [variables].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVariable(variable: Variable) = apply {
                        variables =
                            (variables ?: JsonField.of(mutableListOf())).also {
                                checkKnown("variables", it).add(variable)
                            }
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
                     * Returns an immutable instance of [Sms].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Sms =
                        Sms(
                            checkRequired("template", template),
                            type,
                            (variables ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Sms = apply {
                    if (validated) {
                        return@apply
                    }

                    template()
                    type()
                    variables().ifPresent { it.forEach { it.validate() } }
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
                    (if (template.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                class Variable
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val props: JsonField<Props>,
                    private val type: JsonField<String>,
                    private val id: JsonField<Int>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("props")
                        @ExcludeMissing
                        props: JsonField<Props> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
                    ) : this(name, props, type, id, mutableMapOf())

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun props(): Props = props.getRequired("props")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): String = type.getRequired("type")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun id(): Optional<Int> = id.getOptional("id")

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [props].
                     *
                     * Unlike [props], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                         * Returns a mutable builder for constructing an instance of [Variable].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Variable]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var props: JsonField<Props>? = null
                        private var type: JsonField<String>? = null
                        private var id: JsonField<Int> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(variable: Variable) = apply {
                            name = variable.name
                            props = variable.props
                            type = variable.type
                            id = variable.id
                            additionalProperties = variable.additionalProperties.toMutableMap()
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun props(props: Props) = props(JsonField.of(props))

                        /**
                         * Sets [Builder.props] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.props] with a well-typed [Props] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun props(props: JsonField<Props>) = apply { this.props = props }

                        fun type(type: String) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<String>) = apply { this.type = type }

                        fun id(id: Int) = id(JsonField.of(id))

                        /**
                         * Sets [Builder.id] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.id] with a well-typed [Int] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun id(id: JsonField<Int>) = apply { this.id = id }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Variable].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Variable =
                            Variable(
                                checkRequired("name", name),
                                checkRequired("props", props),
                                checkRequired("type", type),
                                id,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws SentInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Variable = apply {
                        if (validated) {
                            return@apply
                        }

                        name()
                        props().validate()
                        type()
                        id()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            (props.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (type.asKnown().isPresent) 1 else 0) +
                            (if (id.asKnown().isPresent) 1 else 0)

                    class Props
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val mediaType: JsonField<String>,
                        private val sample: JsonField<String>,
                        private val url: JsonField<String>,
                        private val variableType: JsonField<String>,
                        private val alt: JsonField<String>,
                        private val regex: JsonField<String>,
                        private val shortUrl: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("mediaType")
                            @ExcludeMissing
                            mediaType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("sample")
                            @ExcludeMissing
                            sample: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("url")
                            @ExcludeMissing
                            url: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("variableType")
                            @ExcludeMissing
                            variableType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("alt")
                            @ExcludeMissing
                            alt: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("regex")
                            @ExcludeMissing
                            regex: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("shortUrl")
                            @ExcludeMissing
                            shortUrl: JsonField<String> = JsonMissing.of(),
                        ) : this(
                            mediaType,
                            sample,
                            url,
                            variableType,
                            alt,
                            regex,
                            shortUrl,
                            mutableMapOf(),
                        )

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun mediaType(): String = mediaType.getRequired("mediaType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun sample(): String = sample.getRequired("sample")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun url(): String = url.getRequired("url")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun variableType(): String = variableType.getRequired("variableType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun alt(): Optional<String> = alt.getOptional("alt")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun regex(): Optional<String> = regex.getOptional("regex")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

                        /**
                         * Returns the raw JSON value of [mediaType].
                         *
                         * Unlike [mediaType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("mediaType")
                        @ExcludeMissing
                        fun _mediaType(): JsonField<String> = mediaType

                        /**
                         * Returns the raw JSON value of [sample].
                         *
                         * Unlike [sample], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("sample")
                        @ExcludeMissing
                        fun _sample(): JsonField<String> = sample

                        /**
                         * Returns the raw JSON value of [url].
                         *
                         * Unlike [url], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                        /**
                         * Returns the raw JSON value of [variableType].
                         *
                         * Unlike [variableType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("variableType")
                        @ExcludeMissing
                        fun _variableType(): JsonField<String> = variableType

                        /**
                         * Returns the raw JSON value of [alt].
                         *
                         * Unlike [alt], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

                        /**
                         * Returns the raw JSON value of [regex].
                         *
                         * Unlike [regex], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("regex")
                        @ExcludeMissing
                        fun _regex(): JsonField<String> = regex

                        /**
                         * Returns the raw JSON value of [shortUrl].
                         *
                         * Unlike [shortUrl], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("shortUrl")
                        @ExcludeMissing
                        fun _shortUrl(): JsonField<String> = shortUrl

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
                             * Returns a mutable builder for constructing an instance of [Props].
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Props]. */
                        class Builder internal constructor() {

                            private var mediaType: JsonField<String>? = null
                            private var sample: JsonField<String>? = null
                            private var url: JsonField<String>? = null
                            private var variableType: JsonField<String>? = null
                            private var alt: JsonField<String> = JsonMissing.of()
                            private var regex: JsonField<String> = JsonMissing.of()
                            private var shortUrl: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(props: Props) = apply {
                                mediaType = props.mediaType
                                sample = props.sample
                                url = props.url
                                variableType = props.variableType
                                alt = props.alt
                                regex = props.regex
                                shortUrl = props.shortUrl
                                additionalProperties = props.additionalProperties.toMutableMap()
                            }

                            fun mediaType(mediaType: String) = mediaType(JsonField.of(mediaType))

                            /**
                             * Sets [Builder.mediaType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.mediaType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun mediaType(mediaType: JsonField<String>) = apply {
                                this.mediaType = mediaType
                            }

                            fun sample(sample: String) = sample(JsonField.of(sample))

                            /**
                             * Sets [Builder.sample] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.sample] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun sample(sample: JsonField<String>) = apply { this.sample = sample }

                            fun url(url: String) = url(JsonField.of(url))

                            /**
                             * Sets [Builder.url] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.url] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun url(url: JsonField<String>) = apply { this.url = url }

                            fun variableType(variableType: String) =
                                variableType(JsonField.of(variableType))

                            /**
                             * Sets [Builder.variableType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.variableType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun variableType(variableType: JsonField<String>) = apply {
                                this.variableType = variableType
                            }

                            fun alt(alt: String?) = alt(JsonField.ofNullable(alt))

                            /** Alias for calling [Builder.alt] with `alt.orElse(null)`. */
                            fun alt(alt: Optional<String>) = alt(alt.getOrNull())

                            /**
                             * Sets [Builder.alt] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.alt] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun alt(alt: JsonField<String>) = apply { this.alt = alt }

                            fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

                            /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
                            fun regex(regex: Optional<String>) = regex(regex.getOrNull())

                            /**
                             * Sets [Builder.regex] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.regex] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun regex(regex: JsonField<String>) = apply { this.regex = regex }

                            fun shortUrl(shortUrl: String?) =
                                shortUrl(JsonField.ofNullable(shortUrl))

                            /**
                             * Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`.
                             */
                            fun shortUrl(shortUrl: Optional<String>) =
                                shortUrl(shortUrl.getOrNull())

                            /**
                             * Sets [Builder.shortUrl] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.shortUrl] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun shortUrl(shortUrl: JsonField<String>) = apply {
                                this.shortUrl = shortUrl
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Props].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Props =
                                Props(
                                    checkRequired("mediaType", mediaType),
                                    checkRequired("sample", sample),
                                    checkRequired("url", url),
                                    checkRequired("variableType", variableType),
                                    alt,
                                    regex,
                                    shortUrl,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws SentInvalidDataException if any value type in this object doesn't
                         *   match its expected type.
                         */
                        fun validate(): Props = apply {
                            if (validated) {
                                return@apply
                            }

                            mediaType()
                            sample()
                            url()
                            variableType()
                            alt()
                            regex()
                            shortUrl()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (mediaType.asKnown().isPresent) 1 else 0) +
                                (if (sample.asKnown().isPresent) 1 else 0) +
                                (if (url.asKnown().isPresent) 1 else 0) +
                                (if (variableType.asKnown().isPresent) 1 else 0) +
                                (if (alt.asKnown().isPresent) 1 else 0) +
                                (if (regex.asKnown().isPresent) 1 else 0) +
                                (if (shortUrl.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Props &&
                                mediaType == other.mediaType &&
                                sample == other.sample &&
                                url == other.url &&
                                variableType == other.variableType &&
                                alt == other.alt &&
                                regex == other.regex &&
                                shortUrl == other.shortUrl &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                mediaType,
                                sample,
                                url,
                                variableType,
                                alt,
                                regex,
                                shortUrl,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Props{mediaType=$mediaType, sample=$sample, url=$url, variableType=$variableType, alt=$alt, regex=$regex, shortUrl=$shortUrl, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Variable &&
                            name == other.name &&
                            props == other.props &&
                            type == other.type &&
                            id == other.id &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, props, type, id, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Variable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Sms &&
                        template == other.template &&
                        type == other.type &&
                        variables == other.variables &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(template, type, variables, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Sms{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
            }

            /**
             * WhatsApp-specific content that overrides multi-channel content for WhatsApp messages
             */
            class Whatsapp
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val template: JsonField<String>,
                private val type: JsonField<String>,
                private val variables: JsonField<List<Variable>>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("template")
                    @ExcludeMissing
                    template: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("variables")
                    @ExcludeMissing
                    variables: JsonField<List<Variable>> = JsonMissing.of(),
                ) : this(template, type, variables, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun template(): String = template.getRequired("template")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun type(): Optional<String> = type.getOptional("type")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun variables(): Optional<List<Variable>> = variables.getOptional("variables")

                /**
                 * Returns the raw JSON value of [template].
                 *
                 * Unlike [template], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("template")
                @ExcludeMissing
                fun _template(): JsonField<String> = template

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [variables].
                 *
                 * Unlike [variables], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("variables")
                @ExcludeMissing
                fun _variables(): JsonField<List<Variable>> = variables

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
                     * Returns a mutable builder for constructing an instance of [Whatsapp].
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Whatsapp]. */
                class Builder internal constructor() {

                    private var template: JsonField<String>? = null
                    private var type: JsonField<String> = JsonMissing.of()
                    private var variables: JsonField<MutableList<Variable>>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(whatsapp: Whatsapp) = apply {
                        template = whatsapp.template
                        type = whatsapp.type
                        variables = whatsapp.variables.map { it.toMutableList() }
                        additionalProperties = whatsapp.additionalProperties.toMutableMap()
                    }

                    fun template(template: String) = template(JsonField.of(template))

                    /**
                     * Sets [Builder.template] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.template] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun template(template: JsonField<String>) = apply { this.template = template }

                    fun type(type: String?) = type(JsonField.ofNullable(type))

                    /** Alias for calling [Builder.type] with `type.orElse(null)`. */
                    fun type(type: Optional<String>) = type(type.getOrNull())

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun variables(variables: List<Variable>?) =
                        variables(JsonField.ofNullable(variables))

                    /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
                    fun variables(variables: Optional<List<Variable>>) =
                        variables(variables.getOrNull())

                    /**
                     * Sets [Builder.variables] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.variables] with a well-typed
                     * `List<Variable>` value instead. This method is primarily for setting the
                     * field to an undocumented or not yet supported value.
                     */
                    fun variables(variables: JsonField<List<Variable>>) = apply {
                        this.variables = variables.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Variable] to [variables].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addVariable(variable: Variable) = apply {
                        variables =
                            (variables ?: JsonField.of(mutableListOf())).also {
                                checkKnown("variables", it).add(variable)
                            }
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
                     * Returns an immutable instance of [Whatsapp].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .template()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Whatsapp =
                        Whatsapp(
                            checkRequired("template", template),
                            type,
                            (variables ?: JsonMissing.of()).map { it.toImmutable() },
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Whatsapp = apply {
                    if (validated) {
                        return@apply
                    }

                    template()
                    type()
                    variables().ifPresent { it.forEach { it.validate() } }
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
                    (if (template.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

                class Variable
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val name: JsonField<String>,
                    private val props: JsonField<Props>,
                    private val type: JsonField<String>,
                    private val id: JsonField<Int>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("props")
                        @ExcludeMissing
                        props: JsonField<Props> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
                    ) : this(name, props, type, id, mutableMapOf())

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun props(): Props = props.getRequired("props")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): String = type.getRequired("type")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun id(): Optional<Int> = id.getOptional("id")

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [props].
                     *
                     * Unlike [props], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                    /**
                     * Returns the raw JSON value of [id].
                     *
                     * Unlike [id], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                         * Returns a mutable builder for constructing an instance of [Variable].
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Variable]. */
                    class Builder internal constructor() {

                        private var name: JsonField<String>? = null
                        private var props: JsonField<Props>? = null
                        private var type: JsonField<String>? = null
                        private var id: JsonField<Int> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(variable: Variable) = apply {
                            name = variable.name
                            props = variable.props
                            type = variable.type
                            id = variable.id
                            additionalProperties = variable.additionalProperties.toMutableMap()
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun props(props: Props) = props(JsonField.of(props))

                        /**
                         * Sets [Builder.props] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.props] with a well-typed [Props] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun props(props: JsonField<Props>) = apply { this.props = props }

                        fun type(type: String) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<String>) = apply { this.type = type }

                        fun id(id: Int) = id(JsonField.of(id))

                        /**
                         * Sets [Builder.id] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.id] with a well-typed [Int] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun id(id: JsonField<Int>) = apply { this.id = id }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Variable].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .name()
                         * .props()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Variable =
                            Variable(
                                checkRequired("name", name),
                                checkRequired("props", props),
                                checkRequired("type", type),
                                id,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws SentInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Variable = apply {
                        if (validated) {
                            return@apply
                        }

                        name()
                        props().validate()
                        type()
                        id()
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
                        (if (name.asKnown().isPresent) 1 else 0) +
                            (props.asKnown().getOrNull()?.validity() ?: 0) +
                            (if (type.asKnown().isPresent) 1 else 0) +
                            (if (id.asKnown().isPresent) 1 else 0)

                    class Props
                    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                    private constructor(
                        private val mediaType: JsonField<String>,
                        private val sample: JsonField<String>,
                        private val url: JsonField<String>,
                        private val variableType: JsonField<String>,
                        private val alt: JsonField<String>,
                        private val regex: JsonField<String>,
                        private val shortUrl: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("mediaType")
                            @ExcludeMissing
                            mediaType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("sample")
                            @ExcludeMissing
                            sample: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("url")
                            @ExcludeMissing
                            url: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("variableType")
                            @ExcludeMissing
                            variableType: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("alt")
                            @ExcludeMissing
                            alt: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("regex")
                            @ExcludeMissing
                            regex: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("shortUrl")
                            @ExcludeMissing
                            shortUrl: JsonField<String> = JsonMissing.of(),
                        ) : this(
                            mediaType,
                            sample,
                            url,
                            variableType,
                            alt,
                            regex,
                            shortUrl,
                            mutableMapOf(),
                        )

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun mediaType(): String = mediaType.getRequired("mediaType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun sample(): String = sample.getRequired("sample")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun url(): String = url.getRequired("url")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   or is unexpectedly missing or null (e.g. if the server responded with
                         *   an unexpected value).
                         */
                        fun variableType(): String = variableType.getRequired("variableType")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun alt(): Optional<String> = alt.getOptional("alt")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun regex(): Optional<String> = regex.getOptional("regex")

                        /**
                         * @throws SentInvalidDataException if the JSON field has an unexpected type
                         *   (e.g. if the server responded with an unexpected value).
                         */
                        fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

                        /**
                         * Returns the raw JSON value of [mediaType].
                         *
                         * Unlike [mediaType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("mediaType")
                        @ExcludeMissing
                        fun _mediaType(): JsonField<String> = mediaType

                        /**
                         * Returns the raw JSON value of [sample].
                         *
                         * Unlike [sample], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("sample")
                        @ExcludeMissing
                        fun _sample(): JsonField<String> = sample

                        /**
                         * Returns the raw JSON value of [url].
                         *
                         * Unlike [url], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                        /**
                         * Returns the raw JSON value of [variableType].
                         *
                         * Unlike [variableType], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("variableType")
                        @ExcludeMissing
                        fun _variableType(): JsonField<String> = variableType

                        /**
                         * Returns the raw JSON value of [alt].
                         *
                         * Unlike [alt], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

                        /**
                         * Returns the raw JSON value of [regex].
                         *
                         * Unlike [regex], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("regex")
                        @ExcludeMissing
                        fun _regex(): JsonField<String> = regex

                        /**
                         * Returns the raw JSON value of [shortUrl].
                         *
                         * Unlike [shortUrl], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("shortUrl")
                        @ExcludeMissing
                        fun _shortUrl(): JsonField<String> = shortUrl

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
                             * Returns a mutable builder for constructing an instance of [Props].
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Props]. */
                        class Builder internal constructor() {

                            private var mediaType: JsonField<String>? = null
                            private var sample: JsonField<String>? = null
                            private var url: JsonField<String>? = null
                            private var variableType: JsonField<String>? = null
                            private var alt: JsonField<String> = JsonMissing.of()
                            private var regex: JsonField<String> = JsonMissing.of()
                            private var shortUrl: JsonField<String> = JsonMissing.of()
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(props: Props) = apply {
                                mediaType = props.mediaType
                                sample = props.sample
                                url = props.url
                                variableType = props.variableType
                                alt = props.alt
                                regex = props.regex
                                shortUrl = props.shortUrl
                                additionalProperties = props.additionalProperties.toMutableMap()
                            }

                            fun mediaType(mediaType: String) = mediaType(JsonField.of(mediaType))

                            /**
                             * Sets [Builder.mediaType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.mediaType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun mediaType(mediaType: JsonField<String>) = apply {
                                this.mediaType = mediaType
                            }

                            fun sample(sample: String) = sample(JsonField.of(sample))

                            /**
                             * Sets [Builder.sample] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.sample] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun sample(sample: JsonField<String>) = apply { this.sample = sample }

                            fun url(url: String) = url(JsonField.of(url))

                            /**
                             * Sets [Builder.url] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.url] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun url(url: JsonField<String>) = apply { this.url = url }

                            fun variableType(variableType: String) =
                                variableType(JsonField.of(variableType))

                            /**
                             * Sets [Builder.variableType] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.variableType] with a well-typed
                             * [String] value instead. This method is primarily for setting the
                             * field to an undocumented or not yet supported value.
                             */
                            fun variableType(variableType: JsonField<String>) = apply {
                                this.variableType = variableType
                            }

                            fun alt(alt: String?) = alt(JsonField.ofNullable(alt))

                            /** Alias for calling [Builder.alt] with `alt.orElse(null)`. */
                            fun alt(alt: Optional<String>) = alt(alt.getOrNull())

                            /**
                             * Sets [Builder.alt] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.alt] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun alt(alt: JsonField<String>) = apply { this.alt = alt }

                            fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

                            /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
                            fun regex(regex: Optional<String>) = regex(regex.getOrNull())

                            /**
                             * Sets [Builder.regex] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.regex] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun regex(regex: JsonField<String>) = apply { this.regex = regex }

                            fun shortUrl(shortUrl: String?) =
                                shortUrl(JsonField.ofNullable(shortUrl))

                            /**
                             * Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`.
                             */
                            fun shortUrl(shortUrl: Optional<String>) =
                                shortUrl(shortUrl.getOrNull())

                            /**
                             * Sets [Builder.shortUrl] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.shortUrl] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun shortUrl(shortUrl: JsonField<String>) = apply {
                                this.shortUrl = shortUrl
                            }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Props].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .mediaType()
                             * .sample()
                             * .url()
                             * .variableType()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Props =
                                Props(
                                    checkRequired("mediaType", mediaType),
                                    checkRequired("sample", sample),
                                    checkRequired("url", url),
                                    checkRequired("variableType", variableType),
                                    alt,
                                    regex,
                                    shortUrl,
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        /**
                         * Validates that the types of all values in this object match their
                         * expected types recursively.
                         *
                         * This method is _not_ forwards compatible with new types from the API for
                         * existing fields.
                         *
                         * @throws SentInvalidDataException if any value type in this object doesn't
                         *   match its expected type.
                         */
                        fun validate(): Props = apply {
                            if (validated) {
                                return@apply
                            }

                            mediaType()
                            sample()
                            url()
                            variableType()
                            alt()
                            regex()
                            shortUrl()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (mediaType.asKnown().isPresent) 1 else 0) +
                                (if (sample.asKnown().isPresent) 1 else 0) +
                                (if (url.asKnown().isPresent) 1 else 0) +
                                (if (variableType.asKnown().isPresent) 1 else 0) +
                                (if (alt.asKnown().isPresent) 1 else 0) +
                                (if (regex.asKnown().isPresent) 1 else 0) +
                                (if (shortUrl.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return other is Props &&
                                mediaType == other.mediaType &&
                                sample == other.sample &&
                                url == other.url &&
                                variableType == other.variableType &&
                                alt == other.alt &&
                                regex == other.regex &&
                                shortUrl == other.shortUrl &&
                                additionalProperties == other.additionalProperties
                        }

                        private val hashCode: Int by lazy {
                            Objects.hash(
                                mediaType,
                                sample,
                                url,
                                variableType,
                                alt,
                                regex,
                                shortUrl,
                                additionalProperties,
                            )
                        }

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Props{mediaType=$mediaType, sample=$sample, url=$url, variableType=$variableType, alt=$alt, regex=$regex, shortUrl=$shortUrl, additionalProperties=$additionalProperties}"
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Variable &&
                            name == other.name &&
                            props == other.props &&
                            type == other.type &&
                            id == other.id &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(name, props, type, id, additionalProperties)
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Variable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Whatsapp &&
                        template == other.template &&
                        type == other.type &&
                        variables == other.variables &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(template, type, variables, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Whatsapp{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Body &&
                    multiChannel == other.multiChannel &&
                    rcs == other.rcs &&
                    sms == other.sms &&
                    whatsapp == other.whatsapp &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(multiChannel, rcs, sms, whatsapp, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Body{multiChannel=$multiChannel, rcs=$rcs, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
        }

        /** Configuration for AUTHENTICATION category templates */
        class AuthenticationConfig
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val addSecurityRecommendation: JsonField<Boolean>,
            private val codeExpirationMinutes: JsonField<Int>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("addSecurityRecommendation")
                @ExcludeMissing
                addSecurityRecommendation: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("codeExpirationMinutes")
                @ExcludeMissing
                codeExpirationMinutes: JsonField<Int> = JsonMissing.of(),
            ) : this(addSecurityRecommendation, codeExpirationMinutes, mutableMapOf())

            /**
             * Whether to add the security recommendation text: "For your security, do not share
             * this code."
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun addSecurityRecommendation(): Optional<Boolean> =
                addSecurityRecommendation.getOptional("addSecurityRecommendation")

            /**
             * Code expiration time in minutes (1-90). If set, adds footer: "This code expires in X
             * minutes."
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun codeExpirationMinutes(): Optional<Int> =
                codeExpirationMinutes.getOptional("codeExpirationMinutes")

            /**
             * Returns the raw JSON value of [addSecurityRecommendation].
             *
             * Unlike [addSecurityRecommendation], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("addSecurityRecommendation")
            @ExcludeMissing
            fun _addSecurityRecommendation(): JsonField<Boolean> = addSecurityRecommendation

            /**
             * Returns the raw JSON value of [codeExpirationMinutes].
             *
             * Unlike [codeExpirationMinutes], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("codeExpirationMinutes")
            @ExcludeMissing
            fun _codeExpirationMinutes(): JsonField<Int> = codeExpirationMinutes

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
                 * Returns a mutable builder for constructing an instance of [AuthenticationConfig].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AuthenticationConfig]. */
            class Builder internal constructor() {

                private var addSecurityRecommendation: JsonField<Boolean> = JsonMissing.of()
                private var codeExpirationMinutes: JsonField<Int> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(authenticationConfig: AuthenticationConfig) = apply {
                    addSecurityRecommendation = authenticationConfig.addSecurityRecommendation
                    codeExpirationMinutes = authenticationConfig.codeExpirationMinutes
                    additionalProperties = authenticationConfig.additionalProperties.toMutableMap()
                }

                /**
                 * Whether to add the security recommendation text: "For your security, do not share
                 * this code."
                 */
                fun addSecurityRecommendation(addSecurityRecommendation: Boolean) =
                    addSecurityRecommendation(JsonField.of(addSecurityRecommendation))

                /**
                 * Sets [Builder.addSecurityRecommendation] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.addSecurityRecommendation] with a well-typed
                 * [Boolean] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun addSecurityRecommendation(addSecurityRecommendation: JsonField<Boolean>) =
                    apply {
                        this.addSecurityRecommendation = addSecurityRecommendation
                    }

                /**
                 * Code expiration time in minutes (1-90). If set, adds footer: "This code expires
                 * in X minutes."
                 */
                fun codeExpirationMinutes(codeExpirationMinutes: Int?) =
                    codeExpirationMinutes(JsonField.ofNullable(codeExpirationMinutes))

                /**
                 * Alias for [Builder.codeExpirationMinutes].
                 *
                 * This unboxed primitive overload exists for backwards compatibility.
                 */
                fun codeExpirationMinutes(codeExpirationMinutes: Int) =
                    codeExpirationMinutes(codeExpirationMinutes as Int?)

                /**
                 * Alias for calling [Builder.codeExpirationMinutes] with
                 * `codeExpirationMinutes.orElse(null)`.
                 */
                fun codeExpirationMinutes(codeExpirationMinutes: Optional<Int>) =
                    codeExpirationMinutes(codeExpirationMinutes.getOrNull())

                /**
                 * Sets [Builder.codeExpirationMinutes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.codeExpirationMinutes] with a well-typed [Int]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun codeExpirationMinutes(codeExpirationMinutes: JsonField<Int>) = apply {
                    this.codeExpirationMinutes = codeExpirationMinutes
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
                 * Returns an immutable instance of [AuthenticationConfig].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): AuthenticationConfig =
                    AuthenticationConfig(
                        addSecurityRecommendation,
                        codeExpirationMinutes,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): AuthenticationConfig = apply {
                if (validated) {
                    return@apply
                }

                addSecurityRecommendation()
                codeExpirationMinutes()
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
                (if (addSecurityRecommendation.asKnown().isPresent) 1 else 0) +
                    (if (codeExpirationMinutes.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AuthenticationConfig &&
                    addSecurityRecommendation == other.addSecurityRecommendation &&
                    codeExpirationMinutes == other.codeExpirationMinutes &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(addSecurityRecommendation, codeExpirationMinutes, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AuthenticationConfig{addSecurityRecommendation=$addSecurityRecommendation, codeExpirationMinutes=$codeExpirationMinutes, additionalProperties=$additionalProperties}"
        }

        /** Interactive button in a message template */
        class Button
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val props: JsonField<Props>,
            private val type: JsonField<String>,
            private val id: JsonField<Int>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("props") @ExcludeMissing props: JsonField<Props> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
            ) : this(props, type, id, mutableMapOf())

            /**
             * Properties specific to the button type
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun props(): Props = props.getRequired("props")

            /**
             * The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun type(): String = type.getRequired("type")

            /**
             * The unique identifier of the button (1-based index)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<Int> = id.getOptional("id")

            /**
             * Returns the raw JSON value of [props].
             *
             * Unlike [props], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                 * Returns a mutable builder for constructing an instance of [Button].
                 *
                 * The following fields are required:
                 * ```java
                 * .props()
                 * .type()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Button]. */
            class Builder internal constructor() {

                private var props: JsonField<Props>? = null
                private var type: JsonField<String>? = null
                private var id: JsonField<Int> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(button: Button) = apply {
                    props = button.props
                    type = button.type
                    id = button.id
                    additionalProperties = button.additionalProperties.toMutableMap()
                }

                /** Properties specific to the button type */
                fun props(props: Props) = props(JsonField.of(props))

                /**
                 * Sets [Builder.props] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.props] with a well-typed [Props] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun props(props: JsonField<Props>) = apply { this.props = props }

                /**
                 * The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE)
                 */
                fun type(type: String) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<String>) = apply { this.type = type }

                /** The unique identifier of the button (1-based index) */
                fun id(id: Int) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [Int] value instead. This
                 * method is primarily for setting the field to an undocumented or not yet supported
                 * value.
                 */
                fun id(id: JsonField<Int>) = apply { this.id = id }

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
                 * Returns an immutable instance of [Button].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .props()
                 * .type()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Button =
                    Button(
                        checkRequired("props", props),
                        checkRequired("type", type),
                        id,
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): Button = apply {
                if (validated) {
                    return@apply
                }

                props().validate()
                type()
                id()
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
                (props.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (type.asKnown().isPresent) 1 else 0) +
                    (if (id.asKnown().isPresent) 1 else 0)

            /** Properties specific to the button type */
            class Props
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val activeFor: JsonField<Int>,
                private val countryCode: JsonField<String>,
                private val offerCode: JsonField<String>,
                private val phoneNumber: JsonField<String>,
                private val quickReplyType: JsonField<String>,
                private val text: JsonField<String>,
                private val url: JsonField<String>,
                private val urlType: JsonField<String>,
                private val autofillText: JsonField<String>,
                private val otpType: JsonField<String>,
                private val packageName: JsonField<String>,
                private val signatureHash: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("activeFor")
                    @ExcludeMissing
                    activeFor: JsonField<Int> = JsonMissing.of(),
                    @JsonProperty("countryCode")
                    @ExcludeMissing
                    countryCode: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("offerCode")
                    @ExcludeMissing
                    offerCode: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("phoneNumber")
                    @ExcludeMissing
                    phoneNumber: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("quickReplyType")
                    @ExcludeMissing
                    quickReplyType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("text")
                    @ExcludeMissing
                    text: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("urlType")
                    @ExcludeMissing
                    urlType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("autofillText")
                    @ExcludeMissing
                    autofillText: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("otpType")
                    @ExcludeMissing
                    otpType: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("packageName")
                    @ExcludeMissing
                    packageName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("signatureHash")
                    @ExcludeMissing
                    signatureHash: JsonField<String> = JsonMissing.of(),
                ) : this(
                    activeFor,
                    countryCode,
                    offerCode,
                    phoneNumber,
                    quickReplyType,
                    text,
                    url,
                    urlType,
                    autofillText,
                    otpType,
                    packageName,
                    signatureHash,
                    mutableMapOf(),
                )

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun activeFor(): Int = activeFor.getRequired("activeFor")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun countryCode(): String = countryCode.getRequired("countryCode")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun offerCode(): String = offerCode.getRequired("offerCode")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun phoneNumber(): String = phoneNumber.getRequired("phoneNumber")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun quickReplyType(): String = quickReplyType.getRequired("quickReplyType")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun text(): String = text.getRequired("text")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun urlType(): String = urlType.getRequired("urlType")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun autofillText(): Optional<String> = autofillText.getOptional("autofillText")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun otpType(): Optional<String> = otpType.getOptional("otpType")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun packageName(): Optional<String> = packageName.getOptional("packageName")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun signatureHash(): Optional<String> = signatureHash.getOptional("signatureHash")

                /**
                 * Returns the raw JSON value of [activeFor].
                 *
                 * Unlike [activeFor], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("activeFor")
                @ExcludeMissing
                fun _activeFor(): JsonField<Int> = activeFor

                /**
                 * Returns the raw JSON value of [countryCode].
                 *
                 * Unlike [countryCode], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("countryCode")
                @ExcludeMissing
                fun _countryCode(): JsonField<String> = countryCode

                /**
                 * Returns the raw JSON value of [offerCode].
                 *
                 * Unlike [offerCode], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("offerCode")
                @ExcludeMissing
                fun _offerCode(): JsonField<String> = offerCode

                /**
                 * Returns the raw JSON value of [phoneNumber].
                 *
                 * Unlike [phoneNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("phoneNumber")
                @ExcludeMissing
                fun _phoneNumber(): JsonField<String> = phoneNumber

                /**
                 * Returns the raw JSON value of [quickReplyType].
                 *
                 * Unlike [quickReplyType], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("quickReplyType")
                @ExcludeMissing
                fun _quickReplyType(): JsonField<String> = quickReplyType

                /**
                 * Returns the raw JSON value of [text].
                 *
                 * Unlike [text], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                /**
                 * Returns the raw JSON value of [urlType].
                 *
                 * Unlike [urlType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("urlType") @ExcludeMissing fun _urlType(): JsonField<String> = urlType

                /**
                 * Returns the raw JSON value of [autofillText].
                 *
                 * Unlike [autofillText], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("autofillText")
                @ExcludeMissing
                fun _autofillText(): JsonField<String> = autofillText

                /**
                 * Returns the raw JSON value of [otpType].
                 *
                 * Unlike [otpType], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("otpType") @ExcludeMissing fun _otpType(): JsonField<String> = otpType

                /**
                 * Returns the raw JSON value of [packageName].
                 *
                 * Unlike [packageName], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("packageName")
                @ExcludeMissing
                fun _packageName(): JsonField<String> = packageName

                /**
                 * Returns the raw JSON value of [signatureHash].
                 *
                 * Unlike [signatureHash], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("signatureHash")
                @ExcludeMissing
                fun _signatureHash(): JsonField<String> = signatureHash

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
                     * Returns a mutable builder for constructing an instance of [Props].
                     *
                     * The following fields are required:
                     * ```java
                     * .activeFor()
                     * .countryCode()
                     * .offerCode()
                     * .phoneNumber()
                     * .quickReplyType()
                     * .text()
                     * .url()
                     * .urlType()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Props]. */
                class Builder internal constructor() {

                    private var activeFor: JsonField<Int>? = null
                    private var countryCode: JsonField<String>? = null
                    private var offerCode: JsonField<String>? = null
                    private var phoneNumber: JsonField<String>? = null
                    private var quickReplyType: JsonField<String>? = null
                    private var text: JsonField<String>? = null
                    private var url: JsonField<String>? = null
                    private var urlType: JsonField<String>? = null
                    private var autofillText: JsonField<String> = JsonMissing.of()
                    private var otpType: JsonField<String> = JsonMissing.of()
                    private var packageName: JsonField<String> = JsonMissing.of()
                    private var signatureHash: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(props: Props) = apply {
                        activeFor = props.activeFor
                        countryCode = props.countryCode
                        offerCode = props.offerCode
                        phoneNumber = props.phoneNumber
                        quickReplyType = props.quickReplyType
                        text = props.text
                        url = props.url
                        urlType = props.urlType
                        autofillText = props.autofillText
                        otpType = props.otpType
                        packageName = props.packageName
                        signatureHash = props.signatureHash
                        additionalProperties = props.additionalProperties.toMutableMap()
                    }

                    fun activeFor(activeFor: Int) = activeFor(JsonField.of(activeFor))

                    /**
                     * Sets [Builder.activeFor] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.activeFor] with a well-typed [Int] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun activeFor(activeFor: JsonField<Int>) = apply { this.activeFor = activeFor }

                    fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

                    /**
                     * Sets [Builder.countryCode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.countryCode] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun countryCode(countryCode: JsonField<String>) = apply {
                        this.countryCode = countryCode
                    }

                    fun offerCode(offerCode: String) = offerCode(JsonField.of(offerCode))

                    /**
                     * Sets [Builder.offerCode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.offerCode] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun offerCode(offerCode: JsonField<String>) = apply {
                        this.offerCode = offerCode
                    }

                    fun phoneNumber(phoneNumber: String) = phoneNumber(JsonField.of(phoneNumber))

                    /**
                     * Sets [Builder.phoneNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.phoneNumber] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun phoneNumber(phoneNumber: JsonField<String>) = apply {
                        this.phoneNumber = phoneNumber
                    }

                    fun quickReplyType(quickReplyType: String) =
                        quickReplyType(JsonField.of(quickReplyType))

                    /**
                     * Sets [Builder.quickReplyType] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.quickReplyType] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun quickReplyType(quickReplyType: JsonField<String>) = apply {
                        this.quickReplyType = quickReplyType
                    }

                    fun text(text: String) = text(JsonField.of(text))

                    /**
                     * Sets [Builder.text] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.text] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun text(text: JsonField<String>) = apply { this.text = text }

                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun url(url: JsonField<String>) = apply { this.url = url }

                    fun urlType(urlType: String) = urlType(JsonField.of(urlType))

                    /**
                     * Sets [Builder.urlType] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.urlType] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun urlType(urlType: JsonField<String>) = apply { this.urlType = urlType }

                    fun autofillText(autofillText: String?) =
                        autofillText(JsonField.ofNullable(autofillText))

                    /**
                     * Alias for calling [Builder.autofillText] with `autofillText.orElse(null)`.
                     */
                    fun autofillText(autofillText: Optional<String>) =
                        autofillText(autofillText.getOrNull())

                    /**
                     * Sets [Builder.autofillText] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.autofillText] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun autofillText(autofillText: JsonField<String>) = apply {
                        this.autofillText = autofillText
                    }

                    fun otpType(otpType: String?) = otpType(JsonField.ofNullable(otpType))

                    /** Alias for calling [Builder.otpType] with `otpType.orElse(null)`. */
                    fun otpType(otpType: Optional<String>) = otpType(otpType.getOrNull())

                    /**
                     * Sets [Builder.otpType] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.otpType] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun otpType(otpType: JsonField<String>) = apply { this.otpType = otpType }

                    fun packageName(packageName: String?) =
                        packageName(JsonField.ofNullable(packageName))

                    /** Alias for calling [Builder.packageName] with `packageName.orElse(null)`. */
                    fun packageName(packageName: Optional<String>) =
                        packageName(packageName.getOrNull())

                    /**
                     * Sets [Builder.packageName] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.packageName] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun packageName(packageName: JsonField<String>) = apply {
                        this.packageName = packageName
                    }

                    fun signatureHash(signatureHash: String?) =
                        signatureHash(JsonField.ofNullable(signatureHash))

                    /**
                     * Alias for calling [Builder.signatureHash] with `signatureHash.orElse(null)`.
                     */
                    fun signatureHash(signatureHash: Optional<String>) =
                        signatureHash(signatureHash.getOrNull())

                    /**
                     * Sets [Builder.signatureHash] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.signatureHash] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun signatureHash(signatureHash: JsonField<String>) = apply {
                        this.signatureHash = signatureHash
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
                     * Returns an immutable instance of [Props].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .activeFor()
                     * .countryCode()
                     * .offerCode()
                     * .phoneNumber()
                     * .quickReplyType()
                     * .text()
                     * .url()
                     * .urlType()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Props =
                        Props(
                            checkRequired("activeFor", activeFor),
                            checkRequired("countryCode", countryCode),
                            checkRequired("offerCode", offerCode),
                            checkRequired("phoneNumber", phoneNumber),
                            checkRequired("quickReplyType", quickReplyType),
                            checkRequired("text", text),
                            checkRequired("url", url),
                            checkRequired("urlType", urlType),
                            autofillText,
                            otpType,
                            packageName,
                            signatureHash,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Props = apply {
                    if (validated) {
                        return@apply
                    }

                    activeFor()
                    countryCode()
                    offerCode()
                    phoneNumber()
                    quickReplyType()
                    text()
                    url()
                    urlType()
                    autofillText()
                    otpType()
                    packageName()
                    signatureHash()
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
                    (if (activeFor.asKnown().isPresent) 1 else 0) +
                        (if (countryCode.asKnown().isPresent) 1 else 0) +
                        (if (offerCode.asKnown().isPresent) 1 else 0) +
                        (if (phoneNumber.asKnown().isPresent) 1 else 0) +
                        (if (quickReplyType.asKnown().isPresent) 1 else 0) +
                        (if (text.asKnown().isPresent) 1 else 0) +
                        (if (url.asKnown().isPresent) 1 else 0) +
                        (if (urlType.asKnown().isPresent) 1 else 0) +
                        (if (autofillText.asKnown().isPresent) 1 else 0) +
                        (if (otpType.asKnown().isPresent) 1 else 0) +
                        (if (packageName.asKnown().isPresent) 1 else 0) +
                        (if (signatureHash.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Props &&
                        activeFor == other.activeFor &&
                        countryCode == other.countryCode &&
                        offerCode == other.offerCode &&
                        phoneNumber == other.phoneNumber &&
                        quickReplyType == other.quickReplyType &&
                        text == other.text &&
                        url == other.url &&
                        urlType == other.urlType &&
                        autofillText == other.autofillText &&
                        otpType == other.otpType &&
                        packageName == other.packageName &&
                        signatureHash == other.signatureHash &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        activeFor,
                        countryCode,
                        offerCode,
                        phoneNumber,
                        quickReplyType,
                        text,
                        url,
                        urlType,
                        autofillText,
                        otpType,
                        packageName,
                        signatureHash,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Props{activeFor=$activeFor, countryCode=$countryCode, offerCode=$offerCode, phoneNumber=$phoneNumber, quickReplyType=$quickReplyType, text=$text, url=$url, urlType=$urlType, autofillText=$autofillText, otpType=$otpType, packageName=$packageName, signatureHash=$signatureHash, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Button &&
                    props == other.props &&
                    type == other.type &&
                    id == other.id &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(props, type, id, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Button{props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
        }

        /** Footer section of a message template */
        class Footer
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val template: JsonField<String>,
            private val type: JsonField<String>,
            private val variables: JsonField<List<Variable>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("template")
                @ExcludeMissing
                template: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("variables")
                @ExcludeMissing
                variables: JsonField<List<Variable>> = JsonMissing.of(),
            ) : this(template, type, variables, mutableMapOf())

            /**
             * The footer template text with optional variable placeholders
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun template(): String = template.getRequired("template")

            /**
             * The type of footer (typically "text")
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<String> = type.getOptional("type")

            /**
             * List of variables used in the footer template
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun variables(): Optional<List<Variable>> = variables.getOptional("variables")

            /**
             * Returns the raw JSON value of [template].
             *
             * Unlike [template], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<String> = template

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            /**
             * Returns the raw JSON value of [variables].
             *
             * Unlike [variables], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("variables")
            @ExcludeMissing
            fun _variables(): JsonField<List<Variable>> = variables

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
                 * Returns a mutable builder for constructing an instance of [Footer].
                 *
                 * The following fields are required:
                 * ```java
                 * .template()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Footer]. */
            class Builder internal constructor() {

                private var template: JsonField<String>? = null
                private var type: JsonField<String> = JsonMissing.of()
                private var variables: JsonField<MutableList<Variable>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(footer: Footer) = apply {
                    template = footer.template
                    type = footer.type
                    variables = footer.variables.map { it.toMutableList() }
                    additionalProperties = footer.additionalProperties.toMutableMap()
                }

                /** The footer template text with optional variable placeholders */
                fun template(template: String) = template(JsonField.of(template))

                /**
                 * Sets [Builder.template] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.template] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun template(template: JsonField<String>) = apply { this.template = template }

                /** The type of footer (typically "text") */
                fun type(type: String?) = type(JsonField.ofNullable(type))

                /** Alias for calling [Builder.type] with `type.orElse(null)`. */
                fun type(type: Optional<String>) = type(type.getOrNull())

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<String>) = apply { this.type = type }

                /** List of variables used in the footer template */
                fun variables(variables: List<Variable>?) =
                    variables(JsonField.ofNullable(variables))

                /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
                fun variables(variables: Optional<List<Variable>>) =
                    variables(variables.getOrNull())

                /**
                 * Sets [Builder.variables] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.variables] with a well-typed `List<Variable>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun variables(variables: JsonField<List<Variable>>) = apply {
                    this.variables = variables.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Variable] to [variables].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVariable(variable: Variable) = apply {
                    variables =
                        (variables ?: JsonField.of(mutableListOf())).also {
                            checkKnown("variables", it).add(variable)
                        }
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
                 * Returns an immutable instance of [Footer].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .template()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Footer =
                    Footer(
                        checkRequired("template", template),
                        type,
                        (variables ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): Footer = apply {
                if (validated) {
                    return@apply
                }

                template()
                type()
                variables().ifPresent { it.forEach { it.validate() } }
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
                (if (template.asKnown().isPresent) 1 else 0) +
                    (if (type.asKnown().isPresent) 1 else 0) +
                    (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            class Variable
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val name: JsonField<String>,
                private val props: JsonField<Props>,
                private val type: JsonField<String>,
                private val id: JsonField<Int>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("props")
                    @ExcludeMissing
                    props: JsonField<Props> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
                ) : this(name, props, type, id, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun name(): String = name.getRequired("name")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun props(): Props = props.getRequired("props")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): String = type.getRequired("type")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<Int> = id.getOptional("id")

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [props].
                 *
                 * Unlike [props], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                     * Returns a mutable builder for constructing an instance of [Variable].
                     *
                     * The following fields are required:
                     * ```java
                     * .name()
                     * .props()
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Variable]. */
                class Builder internal constructor() {

                    private var name: JsonField<String>? = null
                    private var props: JsonField<Props>? = null
                    private var type: JsonField<String>? = null
                    private var id: JsonField<Int> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(variable: Variable) = apply {
                        name = variable.name
                        props = variable.props
                        type = variable.type
                        id = variable.id
                        additionalProperties = variable.additionalProperties.toMutableMap()
                    }

                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    fun props(props: Props) = props(JsonField.of(props))

                    /**
                     * Sets [Builder.props] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.props] with a well-typed [Props] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun props(props: JsonField<Props>) = apply { this.props = props }

                    fun type(type: String) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun id(id: Int) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [Int] value instead.
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun id(id: JsonField<Int>) = apply { this.id = id }

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
                     * Returns an immutable instance of [Variable].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .name()
                     * .props()
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Variable =
                        Variable(
                            checkRequired("name", name),
                            checkRequired("props", props),
                            checkRequired("type", type),
                            id,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Variable = apply {
                    if (validated) {
                        return@apply
                    }

                    name()
                    props().validate()
                    type()
                    id()
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
                    (if (name.asKnown().isPresent) 1 else 0) +
                        (props.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (if (id.asKnown().isPresent) 1 else 0)

                class Props
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val mediaType: JsonField<String>,
                    private val sample: JsonField<String>,
                    private val url: JsonField<String>,
                    private val variableType: JsonField<String>,
                    private val alt: JsonField<String>,
                    private val regex: JsonField<String>,
                    private val shortUrl: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("mediaType")
                        @ExcludeMissing
                        mediaType: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("sample")
                        @ExcludeMissing
                        sample: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("url")
                        @ExcludeMissing
                        url: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("variableType")
                        @ExcludeMissing
                        variableType: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("alt")
                        @ExcludeMissing
                        alt: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("regex")
                        @ExcludeMissing
                        regex: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("shortUrl")
                        @ExcludeMissing
                        shortUrl: JsonField<String> = JsonMissing.of(),
                    ) : this(
                        mediaType,
                        sample,
                        url,
                        variableType,
                        alt,
                        regex,
                        shortUrl,
                        mutableMapOf(),
                    )

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun mediaType(): String = mediaType.getRequired("mediaType")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun sample(): String = sample.getRequired("sample")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun url(): String = url.getRequired("url")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun variableType(): String = variableType.getRequired("variableType")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun alt(): Optional<String> = alt.getOptional("alt")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun regex(): Optional<String> = regex.getOptional("regex")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

                    /**
                     * Returns the raw JSON value of [mediaType].
                     *
                     * Unlike [mediaType], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("mediaType")
                    @ExcludeMissing
                    fun _mediaType(): JsonField<String> = mediaType

                    /**
                     * Returns the raw JSON value of [sample].
                     *
                     * Unlike [sample], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("sample")
                    @ExcludeMissing
                    fun _sample(): JsonField<String> = sample

                    /**
                     * Returns the raw JSON value of [url].
                     *
                     * Unlike [url], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                    /**
                     * Returns the raw JSON value of [variableType].
                     *
                     * Unlike [variableType], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("variableType")
                    @ExcludeMissing
                    fun _variableType(): JsonField<String> = variableType

                    /**
                     * Returns the raw JSON value of [alt].
                     *
                     * Unlike [alt], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

                    /**
                     * Returns the raw JSON value of [regex].
                     *
                     * Unlike [regex], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("regex") @ExcludeMissing fun _regex(): JsonField<String> = regex

                    /**
                     * Returns the raw JSON value of [shortUrl].
                     *
                     * Unlike [shortUrl], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("shortUrl")
                    @ExcludeMissing
                    fun _shortUrl(): JsonField<String> = shortUrl

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
                         * Returns a mutable builder for constructing an instance of [Props].
                         *
                         * The following fields are required:
                         * ```java
                         * .mediaType()
                         * .sample()
                         * .url()
                         * .variableType()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Props]. */
                    class Builder internal constructor() {

                        private var mediaType: JsonField<String>? = null
                        private var sample: JsonField<String>? = null
                        private var url: JsonField<String>? = null
                        private var variableType: JsonField<String>? = null
                        private var alt: JsonField<String> = JsonMissing.of()
                        private var regex: JsonField<String> = JsonMissing.of()
                        private var shortUrl: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(props: Props) = apply {
                            mediaType = props.mediaType
                            sample = props.sample
                            url = props.url
                            variableType = props.variableType
                            alt = props.alt
                            regex = props.regex
                            shortUrl = props.shortUrl
                            additionalProperties = props.additionalProperties.toMutableMap()
                        }

                        fun mediaType(mediaType: String) = mediaType(JsonField.of(mediaType))

                        /**
                         * Sets [Builder.mediaType] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.mediaType] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun mediaType(mediaType: JsonField<String>) = apply {
                            this.mediaType = mediaType
                        }

                        fun sample(sample: String) = sample(JsonField.of(sample))

                        /**
                         * Sets [Builder.sample] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.sample] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun sample(sample: JsonField<String>) = apply { this.sample = sample }

                        fun url(url: String) = url(JsonField.of(url))

                        /**
                         * Sets [Builder.url] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.url] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun url(url: JsonField<String>) = apply { this.url = url }

                        fun variableType(variableType: String) =
                            variableType(JsonField.of(variableType))

                        /**
                         * Sets [Builder.variableType] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.variableType] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun variableType(variableType: JsonField<String>) = apply {
                            this.variableType = variableType
                        }

                        fun alt(alt: String?) = alt(JsonField.ofNullable(alt))

                        /** Alias for calling [Builder.alt] with `alt.orElse(null)`. */
                        fun alt(alt: Optional<String>) = alt(alt.getOrNull())

                        /**
                         * Sets [Builder.alt] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.alt] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun alt(alt: JsonField<String>) = apply { this.alt = alt }

                        fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

                        /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
                        fun regex(regex: Optional<String>) = regex(regex.getOrNull())

                        /**
                         * Sets [Builder.regex] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.regex] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun regex(regex: JsonField<String>) = apply { this.regex = regex }

                        fun shortUrl(shortUrl: String?) = shortUrl(JsonField.ofNullable(shortUrl))

                        /** Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`. */
                        fun shortUrl(shortUrl: Optional<String>) = shortUrl(shortUrl.getOrNull())

                        /**
                         * Sets [Builder.shortUrl] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.shortUrl] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun shortUrl(shortUrl: JsonField<String>) = apply {
                            this.shortUrl = shortUrl
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Props].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .mediaType()
                         * .sample()
                         * .url()
                         * .variableType()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Props =
                            Props(
                                checkRequired("mediaType", mediaType),
                                checkRequired("sample", sample),
                                checkRequired("url", url),
                                checkRequired("variableType", variableType),
                                alt,
                                regex,
                                shortUrl,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws SentInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Props = apply {
                        if (validated) {
                            return@apply
                        }

                        mediaType()
                        sample()
                        url()
                        variableType()
                        alt()
                        regex()
                        shortUrl()
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
                        (if (mediaType.asKnown().isPresent) 1 else 0) +
                            (if (sample.asKnown().isPresent) 1 else 0) +
                            (if (url.asKnown().isPresent) 1 else 0) +
                            (if (variableType.asKnown().isPresent) 1 else 0) +
                            (if (alt.asKnown().isPresent) 1 else 0) +
                            (if (regex.asKnown().isPresent) 1 else 0) +
                            (if (shortUrl.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Props &&
                            mediaType == other.mediaType &&
                            sample == other.sample &&
                            url == other.url &&
                            variableType == other.variableType &&
                            alt == other.alt &&
                            regex == other.regex &&
                            shortUrl == other.shortUrl &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            mediaType,
                            sample,
                            url,
                            variableType,
                            alt,
                            regex,
                            shortUrl,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Props{mediaType=$mediaType, sample=$sample, url=$url, variableType=$variableType, alt=$alt, regex=$regex, shortUrl=$shortUrl, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Variable &&
                        name == other.name &&
                        props == other.props &&
                        type == other.type &&
                        id == other.id &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(name, props, type, id, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Variable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Footer &&
                    template == other.template &&
                    type == other.type &&
                    variables == other.variables &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(template, type, variables, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Footer{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
        }

        /** Header section of a message template */
        class Header
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val template: JsonField<String>,
            private val type: JsonField<String>,
            private val variables: JsonField<List<Variable>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("template")
                @ExcludeMissing
                template: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
                @JsonProperty("variables")
                @ExcludeMissing
                variables: JsonField<List<Variable>> = JsonMissing.of(),
            ) : this(template, type, variables, mutableMapOf())

            /**
             * The header template text with optional variable placeholders (e.g., "Welcome to
             * {{0:variable}}")
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun template(): String = template.getRequired("template")

            /**
             * The type of header (e.g., "text", "image", "video", "document")
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun type(): Optional<String> = type.getOptional("type")

            /**
             * List of variables used in the header template
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun variables(): Optional<List<Variable>> = variables.getOptional("variables")

            /**
             * Returns the raw JSON value of [template].
             *
             * Unlike [template], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("template") @ExcludeMissing fun _template(): JsonField<String> = template

            /**
             * Returns the raw JSON value of [type].
             *
             * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

            /**
             * Returns the raw JSON value of [variables].
             *
             * Unlike [variables], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("variables")
            @ExcludeMissing
            fun _variables(): JsonField<List<Variable>> = variables

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
                 * Returns a mutable builder for constructing an instance of [Header].
                 *
                 * The following fields are required:
                 * ```java
                 * .template()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Header]. */
            class Builder internal constructor() {

                private var template: JsonField<String>? = null
                private var type: JsonField<String> = JsonMissing.of()
                private var variables: JsonField<MutableList<Variable>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(header: Header) = apply {
                    template = header.template
                    type = header.type
                    variables = header.variables.map { it.toMutableList() }
                    additionalProperties = header.additionalProperties.toMutableMap()
                }

                /**
                 * The header template text with optional variable placeholders (e.g., "Welcome to
                 * {{0:variable}}")
                 */
                fun template(template: String) = template(JsonField.of(template))

                /**
                 * Sets [Builder.template] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.template] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun template(template: JsonField<String>) = apply { this.template = template }

                /** The type of header (e.g., "text", "image", "video", "document") */
                fun type(type: String?) = type(JsonField.ofNullable(type))

                /** Alias for calling [Builder.type] with `type.orElse(null)`. */
                fun type(type: Optional<String>) = type(type.getOrNull())

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<String>) = apply { this.type = type }

                /** List of variables used in the header template */
                fun variables(variables: List<Variable>?) =
                    variables(JsonField.ofNullable(variables))

                /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
                fun variables(variables: Optional<List<Variable>>) =
                    variables(variables.getOrNull())

                /**
                 * Sets [Builder.variables] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.variables] with a well-typed `List<Variable>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun variables(variables: JsonField<List<Variable>>) = apply {
                    this.variables = variables.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Variable] to [variables].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVariable(variable: Variable) = apply {
                    variables =
                        (variables ?: JsonField.of(mutableListOf())).also {
                            checkKnown("variables", it).add(variable)
                        }
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
                 * Returns an immutable instance of [Header].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .template()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Header =
                    Header(
                        checkRequired("template", template),
                        type,
                        (variables ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
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
            fun validate(): Header = apply {
                if (validated) {
                    return@apply
                }

                template()
                type()
                variables().ifPresent { it.forEach { it.validate() } }
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
                (if (template.asKnown().isPresent) 1 else 0) +
                    (if (type.asKnown().isPresent) 1 else 0) +
                    (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            class Variable
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val name: JsonField<String>,
                private val props: JsonField<Props>,
                private val type: JsonField<String>,
                private val id: JsonField<Int>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("props")
                    @ExcludeMissing
                    props: JsonField<Props> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
                ) : this(name, props, type, id, mutableMapOf())

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun name(): String = name.getRequired("name")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun props(): Props = props.getRequired("props")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun type(): String = type.getRequired("type")

                /**
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun id(): Optional<Int> = id.getOptional("id")

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [props].
                 *
                 * Unlike [props], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<Props> = props

                /**
                 * Returns the raw JSON value of [type].
                 *
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [id].
                 *
                 * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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
                     * Returns a mutable builder for constructing an instance of [Variable].
                     *
                     * The following fields are required:
                     * ```java
                     * .name()
                     * .props()
                     * .type()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Variable]. */
                class Builder internal constructor() {

                    private var name: JsonField<String>? = null
                    private var props: JsonField<Props>? = null
                    private var type: JsonField<String>? = null
                    private var id: JsonField<Int> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(variable: Variable) = apply {
                        name = variable.name
                        props = variable.props
                        type = variable.type
                        id = variable.id
                        additionalProperties = variable.additionalProperties.toMutableMap()
                    }

                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    fun props(props: Props) = props(JsonField.of(props))

                    /**
                     * Sets [Builder.props] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.props] with a well-typed [Props] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun props(props: JsonField<Props>) = apply { this.props = props }

                    fun type(type: String) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    fun id(id: Int) = id(JsonField.of(id))

                    /**
                     * Sets [Builder.id] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.id] with a well-typed [Int] value instead.
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun id(id: JsonField<Int>) = apply { this.id = id }

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
                     * Returns an immutable instance of [Variable].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .name()
                     * .props()
                     * .type()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Variable =
                        Variable(
                            checkRequired("name", name),
                            checkRequired("props", props),
                            checkRequired("type", type),
                            id,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Variable = apply {
                    if (validated) {
                        return@apply
                    }

                    name()
                    props().validate()
                    type()
                    id()
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
                    (if (name.asKnown().isPresent) 1 else 0) +
                        (props.asKnown().getOrNull()?.validity() ?: 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (if (id.asKnown().isPresent) 1 else 0)

                class Props
                @JsonCreator(mode = JsonCreator.Mode.DISABLED)
                private constructor(
                    private val mediaType: JsonField<String>,
                    private val sample: JsonField<String>,
                    private val url: JsonField<String>,
                    private val variableType: JsonField<String>,
                    private val alt: JsonField<String>,
                    private val regex: JsonField<String>,
                    private val shortUrl: JsonField<String>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("mediaType")
                        @ExcludeMissing
                        mediaType: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("sample")
                        @ExcludeMissing
                        sample: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("url")
                        @ExcludeMissing
                        url: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("variableType")
                        @ExcludeMissing
                        variableType: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("alt")
                        @ExcludeMissing
                        alt: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("regex")
                        @ExcludeMissing
                        regex: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("shortUrl")
                        @ExcludeMissing
                        shortUrl: JsonField<String> = JsonMissing.of(),
                    ) : this(
                        mediaType,
                        sample,
                        url,
                        variableType,
                        alt,
                        regex,
                        shortUrl,
                        mutableMapOf(),
                    )

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun mediaType(): String = mediaType.getRequired("mediaType")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun sample(): String = sample.getRequired("sample")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun url(): String = url.getRequired("url")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun variableType(): String = variableType.getRequired("variableType")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun alt(): Optional<String> = alt.getOptional("alt")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun regex(): Optional<String> = regex.getOptional("regex")

                    /**
                     * @throws SentInvalidDataException if the JSON field has an unexpected type
                     *   (e.g. if the server responded with an unexpected value).
                     */
                    fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

                    /**
                     * Returns the raw JSON value of [mediaType].
                     *
                     * Unlike [mediaType], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("mediaType")
                    @ExcludeMissing
                    fun _mediaType(): JsonField<String> = mediaType

                    /**
                     * Returns the raw JSON value of [sample].
                     *
                     * Unlike [sample], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("sample")
                    @ExcludeMissing
                    fun _sample(): JsonField<String> = sample

                    /**
                     * Returns the raw JSON value of [url].
                     *
                     * Unlike [url], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

                    /**
                     * Returns the raw JSON value of [variableType].
                     *
                     * Unlike [variableType], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("variableType")
                    @ExcludeMissing
                    fun _variableType(): JsonField<String> = variableType

                    /**
                     * Returns the raw JSON value of [alt].
                     *
                     * Unlike [alt], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

                    /**
                     * Returns the raw JSON value of [regex].
                     *
                     * Unlike [regex], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("regex") @ExcludeMissing fun _regex(): JsonField<String> = regex

                    /**
                     * Returns the raw JSON value of [shortUrl].
                     *
                     * Unlike [shortUrl], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("shortUrl")
                    @ExcludeMissing
                    fun _shortUrl(): JsonField<String> = shortUrl

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
                         * Returns a mutable builder for constructing an instance of [Props].
                         *
                         * The following fields are required:
                         * ```java
                         * .mediaType()
                         * .sample()
                         * .url()
                         * .variableType()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Props]. */
                    class Builder internal constructor() {

                        private var mediaType: JsonField<String>? = null
                        private var sample: JsonField<String>? = null
                        private var url: JsonField<String>? = null
                        private var variableType: JsonField<String>? = null
                        private var alt: JsonField<String> = JsonMissing.of()
                        private var regex: JsonField<String> = JsonMissing.of()
                        private var shortUrl: JsonField<String> = JsonMissing.of()
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(props: Props) = apply {
                            mediaType = props.mediaType
                            sample = props.sample
                            url = props.url
                            variableType = props.variableType
                            alt = props.alt
                            regex = props.regex
                            shortUrl = props.shortUrl
                            additionalProperties = props.additionalProperties.toMutableMap()
                        }

                        fun mediaType(mediaType: String) = mediaType(JsonField.of(mediaType))

                        /**
                         * Sets [Builder.mediaType] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.mediaType] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun mediaType(mediaType: JsonField<String>) = apply {
                            this.mediaType = mediaType
                        }

                        fun sample(sample: String) = sample(JsonField.of(sample))

                        /**
                         * Sets [Builder.sample] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.sample] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun sample(sample: JsonField<String>) = apply { this.sample = sample }

                        fun url(url: String) = url(JsonField.of(url))

                        /**
                         * Sets [Builder.url] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.url] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun url(url: JsonField<String>) = apply { this.url = url }

                        fun variableType(variableType: String) =
                            variableType(JsonField.of(variableType))

                        /**
                         * Sets [Builder.variableType] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.variableType] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun variableType(variableType: JsonField<String>) = apply {
                            this.variableType = variableType
                        }

                        fun alt(alt: String?) = alt(JsonField.ofNullable(alt))

                        /** Alias for calling [Builder.alt] with `alt.orElse(null)`. */
                        fun alt(alt: Optional<String>) = alt(alt.getOrNull())

                        /**
                         * Sets [Builder.alt] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.alt] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun alt(alt: JsonField<String>) = apply { this.alt = alt }

                        fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

                        /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
                        fun regex(regex: Optional<String>) = regex(regex.getOrNull())

                        /**
                         * Sets [Builder.regex] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.regex] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun regex(regex: JsonField<String>) = apply { this.regex = regex }

                        fun shortUrl(shortUrl: String?) = shortUrl(JsonField.ofNullable(shortUrl))

                        /** Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`. */
                        fun shortUrl(shortUrl: Optional<String>) = shortUrl(shortUrl.getOrNull())

                        /**
                         * Sets [Builder.shortUrl] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.shortUrl] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun shortUrl(shortUrl: JsonField<String>) = apply {
                            this.shortUrl = shortUrl
                        }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Props].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .mediaType()
                         * .sample()
                         * .url()
                         * .variableType()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Props =
                            Props(
                                checkRequired("mediaType", mediaType),
                                checkRequired("sample", sample),
                                checkRequired("url", url),
                                checkRequired("variableType", variableType),
                                alt,
                                regex,
                                shortUrl,
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    /**
                     * Validates that the types of all values in this object match their expected
                     * types recursively.
                     *
                     * This method is _not_ forwards compatible with new types from the API for
                     * existing fields.
                     *
                     * @throws SentInvalidDataException if any value type in this object doesn't
                     *   match its expected type.
                     */
                    fun validate(): Props = apply {
                        if (validated) {
                            return@apply
                        }

                        mediaType()
                        sample()
                        url()
                        variableType()
                        alt()
                        regex()
                        shortUrl()
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
                        (if (mediaType.asKnown().isPresent) 1 else 0) +
                            (if (sample.asKnown().isPresent) 1 else 0) +
                            (if (url.asKnown().isPresent) 1 else 0) +
                            (if (variableType.asKnown().isPresent) 1 else 0) +
                            (if (alt.asKnown().isPresent) 1 else 0) +
                            (if (regex.asKnown().isPresent) 1 else 0) +
                            (if (shortUrl.asKnown().isPresent) 1 else 0)

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return other is Props &&
                            mediaType == other.mediaType &&
                            sample == other.sample &&
                            url == other.url &&
                            variableType == other.variableType &&
                            alt == other.alt &&
                            regex == other.regex &&
                            shortUrl == other.shortUrl &&
                            additionalProperties == other.additionalProperties
                    }

                    private val hashCode: Int by lazy {
                        Objects.hash(
                            mediaType,
                            sample,
                            url,
                            variableType,
                            alt,
                            regex,
                            shortUrl,
                            additionalProperties,
                        )
                    }

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Props{mediaType=$mediaType, sample=$sample, url=$url, variableType=$variableType, alt=$alt, regex=$regex, shortUrl=$shortUrl, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Variable &&
                        name == other.name &&
                        props == other.props &&
                        type == other.type &&
                        id == other.id &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(name, props, type, id, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Variable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Header &&
                    template == other.template &&
                    type == other.type &&
                    variables == other.variables &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(template, type, variables, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Header{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Definition &&
                body == other.body &&
                authenticationConfig == other.authenticationConfig &&
                buttons == other.buttons &&
                definitionVersion == other.definitionVersion &&
                footer == other.footer &&
                header == other.header &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                body,
                authenticationConfig,
                buttons,
                definitionVersion,
                footer,
                header,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Definition{body=$body, authenticationConfig=$authenticationConfig, buttons=$buttons, definitionVersion=$definitionVersion, footer=$footer, header=$header, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateCreateParams &&
            idempotencyKey == other.idempotencyKey &&
            xProfileId == other.xProfileId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(idempotencyKey, xProfileId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TemplateCreateParams{idempotencyKey=$idempotencyKey, xProfileId=$xProfileId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
