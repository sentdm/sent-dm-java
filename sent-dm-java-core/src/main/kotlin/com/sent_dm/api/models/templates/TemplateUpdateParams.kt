// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.templates

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
 * Updates an existing template's name, category, language, definition, or submits it for review.
 */
class TemplateUpdateParams
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
     * Template category: MARKETING, UTILITY, AUTHENTICATION
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun category(): Optional<String> = body.category()

    /**
     * Template definition including header, body, footer, and buttons
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun definition(): Optional<TemplateDefinition> = body.definition()

    /**
     * Template language code (e.g., en_US)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<String> = body.language()

    /**
     * Template display name
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Whether to submit the template for review after updating (default: false)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun submitForReview(): Optional<Boolean> = body.submitForReview()

    /**
     * Returns the raw JSON value of [testMode].
     *
     * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _testMode(): JsonField<Boolean> = body._testMode()

    /**
     * Returns the raw JSON value of [category].
     *
     * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _category(): JsonField<String> = body._category()

    /**
     * Returns the raw JSON value of [definition].
     *
     * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _definition(): JsonField<TemplateDefinition> = body._definition()

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _language(): JsonField<String> = body._language()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

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

        @JvmStatic fun none(): TemplateUpdateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [TemplateUpdateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateUpdateParams]. */
    class Builder internal constructor() {

        private var id: String? = null
        private var idempotencyKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(templateUpdateParams: TemplateUpdateParams) = apply {
            id = templateUpdateParams.id
            idempotencyKey = templateUpdateParams.idempotencyKey
            body = templateUpdateParams.body.toBuilder()
            additionalHeaders = templateUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = templateUpdateParams.additionalQueryParams.toBuilder()
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
         * - [category]
         * - [definition]
         * - [language]
         * - [name]
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

        /** Template category: MARKETING, UTILITY, AUTHENTICATION */
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

        /** Template definition including header, body, footer, and buttons */
        fun definition(definition: TemplateDefinition?) = apply { body.definition(definition) }

        /** Alias for calling [Builder.definition] with `definition.orElse(null)`. */
        fun definition(definition: Optional<TemplateDefinition>) =
            definition(definition.getOrNull())

        /**
         * Sets [Builder.definition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.definition] with a well-typed [TemplateDefinition] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun definition(definition: JsonField<TemplateDefinition>) = apply {
            body.definition(definition)
        }

        /** Template language code (e.g., en_US) */
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

        /** Template display name */
        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /** Whether to submit the template for review after updating (default: false) */
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
         * Returns an immutable instance of [TemplateUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateUpdateParams =
            TemplateUpdateParams(
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

    /** Request to update an existing template */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val testMode: JsonField<Boolean>,
        private val category: JsonField<String>,
        private val definition: JsonField<TemplateDefinition>,
        private val language: JsonField<String>,
        private val name: JsonField<String>,
        private val submitForReview: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("test_mode")
            @ExcludeMissing
            testMode: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("category")
            @ExcludeMissing
            category: JsonField<String> = JsonMissing.of(),
            @JsonProperty("definition")
            @ExcludeMissing
            definition: JsonField<TemplateDefinition> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("submit_for_review")
            @ExcludeMissing
            submitForReview: JsonField<Boolean> = JsonMissing.of(),
        ) : this(testMode, category, definition, language, name, submitForReview, mutableMapOf())

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
         * Template category: MARKETING, UTILITY, AUTHENTICATION
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun category(): Optional<String> = category.getOptional("category")

        /**
         * Template definition including header, body, footer, and buttons
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun definition(): Optional<TemplateDefinition> = definition.getOptional("definition")

        /**
         * Template language code (e.g., en_US)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * Template display name
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Whether to submit the template for review after updating (default: false)
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submitForReview(): Optional<Boolean> = submitForReview.getOptional("submit_for_review")

        /**
         * Returns the raw JSON value of [testMode].
         *
         * Unlike [testMode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("test_mode") @ExcludeMissing fun _testMode(): JsonField<Boolean> = testMode

        /**
         * Returns the raw JSON value of [category].
         *
         * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

        /**
         * Returns the raw JSON value of [definition].
         *
         * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("definition")
        @ExcludeMissing
        fun _definition(): JsonField<TemplateDefinition> = definition

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [name].
         *
         * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

            private var testMode: JsonField<Boolean> = JsonMissing.of()
            private var category: JsonField<String> = JsonMissing.of()
            private var definition: JsonField<TemplateDefinition> = JsonMissing.of()
            private var language: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var submitForReview: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                testMode = body.testMode
                category = body.category
                definition = body.definition
                language = body.language
                name = body.name
                submitForReview = body.submitForReview
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

            /** Template category: MARKETING, UTILITY, AUTHENTICATION */
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

            /** Template definition including header, body, footer, and buttons */
            fun definition(definition: TemplateDefinition?) =
                definition(JsonField.ofNullable(definition))

            /** Alias for calling [Builder.definition] with `definition.orElse(null)`. */
            fun definition(definition: Optional<TemplateDefinition>) =
                definition(definition.getOrNull())

            /**
             * Sets [Builder.definition] to an arbitrary JSON value.
             *
             * You should usually call [Builder.definition] with a well-typed [TemplateDefinition]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun definition(definition: JsonField<TemplateDefinition>) = apply {
                this.definition = definition
            }

            /** Template language code (e.g., en_US) */
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

            /** Template display name */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Whether to submit the template for review after updating (default: false) */
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
                    testMode,
                    category,
                    definition,
                    language,
                    name,
                    submitForReview,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            testMode()
            category()
            definition().ifPresent { it.validate() }
            language()
            name()
            submitForReview()
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
                (if (category.asKnown().isPresent) 1 else 0) +
                (definition.asKnown().getOrNull()?.validity() ?: 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (submitForReview.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                testMode == other.testMode &&
                category == other.category &&
                definition == other.definition &&
                language == other.language &&
                name == other.name &&
                submitForReview == other.submitForReview &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                testMode,
                category,
                definition,
                language,
                name,
                submitForReview,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{testMode=$testMode, category=$category, definition=$definition, language=$language, name=$name, submitForReview=$submitForReview, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateUpdateParams &&
            id == other.id &&
            idempotencyKey == other.idempotencyKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(id, idempotencyKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TemplateUpdateParams{id=$id, idempotencyKey=$idempotencyKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
