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
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates a new message template for the authenticated customer with comprehensive template
 * definitions including headers, body, footer, and interactive buttons. Supports automatic metadata
 * generation using AI (display name, language, category). Optionally submits the template for
 * WhatsApp review. The customer ID is extracted from the authentication token.
 */
class TemplateCreateParams
private constructor(
    private val xApiKey: String,
    private val xSenderId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun xApiKey(): String = xApiKey

    fun xSenderId(): String = xSenderId

    /**
     * Template definition containing header, body, footer, and buttons
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun definition(): TemplateDefinition = body.definition()

    /**
     * The template category (e.g., MARKETING, UTILITY, AUTHENTICATION). Can only be set when
     * creating a new template. If not provided, will be auto-generated using AI.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun category(): Optional<String> = body.category()

    /**
     * The template language code (e.g., en_US, es_ES). Can only be set when creating a new
     * template. If not provided, will be auto-detected using AI.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<String> = body.language()

    /**
     * When false, the template will be saved as draft. When true, the template will be submitted
     * for review.
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun submitForReview(): Optional<Boolean> = body.submitForReview()

    /**
     * Returns the raw JSON value of [definition].
     *
     * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _definition(): JsonField<TemplateDefinition> = body._definition()

    /**
     * Returns the raw JSON value of [category].
     *
     * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _category(): JsonField<String> = body._category()

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _language(): JsonField<String> = body._language()

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

        /**
         * Returns a mutable builder for constructing an instance of [TemplateCreateParams].
         *
         * The following fields are required:
         * ```java
         * .xApiKey()
         * .xSenderId()
         * .definition()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateCreateParams]. */
    class Builder internal constructor() {

        private var xApiKey: String? = null
        private var xSenderId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(templateCreateParams: TemplateCreateParams) = apply {
            xApiKey = templateCreateParams.xApiKey
            xSenderId = templateCreateParams.xSenderId
            body = templateCreateParams.body.toBuilder()
            additionalHeaders = templateCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = templateCreateParams.additionalQueryParams.toBuilder()
        }

        fun xApiKey(xApiKey: String) = apply { this.xApiKey = xApiKey }

        fun xSenderId(xSenderId: String) = apply { this.xSenderId = xSenderId }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [definition]
         * - [category]
         * - [language]
         * - [submitForReview]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Template definition containing header, body, footer, and buttons */
        fun definition(definition: TemplateDefinition) = apply { body.definition(definition) }

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

        /**
         * The template category (e.g., MARKETING, UTILITY, AUTHENTICATION). Can only be set when
         * creating a new template. If not provided, will be auto-generated using AI.
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

        /**
         * The template language code (e.g., en_US, es_ES). Can only be set when creating a new
         * template. If not provided, will be auto-detected using AI.
         */
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
         * When false, the template will be saved as draft. When true, the template will be
         * submitted for review.
         */
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
         *
         * The following fields are required:
         * ```java
         * .xApiKey()
         * .xSenderId()
         * .definition()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TemplateCreateParams =
            TemplateCreateParams(
                checkRequired("xApiKey", xApiKey),
                checkRequired("xSenderId", xSenderId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                put("x-api-key", xApiKey)
                put("x-sender-id", xSenderId)
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val definition: JsonField<TemplateDefinition>,
        private val category: JsonField<String>,
        private val language: JsonField<String>,
        private val submitForReview: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("definition")
            @ExcludeMissing
            definition: JsonField<TemplateDefinition> = JsonMissing.of(),
            @JsonProperty("category")
            @ExcludeMissing
            category: JsonField<String> = JsonMissing.of(),
            @JsonProperty("language")
            @ExcludeMissing
            language: JsonField<String> = JsonMissing.of(),
            @JsonProperty("submitForReview")
            @ExcludeMissing
            submitForReview: JsonField<Boolean> = JsonMissing.of(),
        ) : this(definition, category, language, submitForReview, mutableMapOf())

        /**
         * Template definition containing header, body, footer, and buttons
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun definition(): TemplateDefinition = definition.getRequired("definition")

        /**
         * The template category (e.g., MARKETING, UTILITY, AUTHENTICATION). Can only be set when
         * creating a new template. If not provided, will be auto-generated using AI.
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun category(): Optional<String> = category.getOptional("category")

        /**
         * The template language code (e.g., en_US, es_ES). Can only be set when creating a new
         * template. If not provided, will be auto-detected using AI.
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun language(): Optional<String> = language.getOptional("language")

        /**
         * When false, the template will be saved as draft. When true, the template will be
         * submitted for review.
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun submitForReview(): Optional<Boolean> = submitForReview.getOptional("submitForReview")

        /**
         * Returns the raw JSON value of [definition].
         *
         * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("definition")
        @ExcludeMissing
        fun _definition(): JsonField<TemplateDefinition> = definition

        /**
         * Returns the raw JSON value of [category].
         *
         * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

        /**
         * Returns the raw JSON value of [language].
         *
         * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

        /**
         * Returns the raw JSON value of [submitForReview].
         *
         * Unlike [submitForReview], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("submitForReview")
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

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .definition()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var definition: JsonField<TemplateDefinition>? = null
            private var category: JsonField<String> = JsonMissing.of()
            private var language: JsonField<String> = JsonMissing.of()
            private var submitForReview: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                definition = body.definition
                category = body.category
                language = body.language
                submitForReview = body.submitForReview
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Template definition containing header, body, footer, and buttons */
            fun definition(definition: TemplateDefinition) = definition(JsonField.of(definition))

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

            /**
             * The template category (e.g., MARKETING, UTILITY, AUTHENTICATION). Can only be set
             * when creating a new template. If not provided, will be auto-generated using AI.
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

            /**
             * The template language code (e.g., en_US, es_ES). Can only be set when creating a new
             * template. If not provided, will be auto-detected using AI.
             */
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
             * When false, the template will be saved as draft. When true, the template will be
             * submitted for review.
             */
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
             *
             * The following fields are required:
             * ```java
             * .definition()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("definition", definition),
                    category,
                    language,
                    submitForReview,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            definition().validate()
            category()
            language()
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
            (definition.asKnown().getOrNull()?.validity() ?: 0) +
                (if (category.asKnown().isPresent) 1 else 0) +
                (if (language.asKnown().isPresent) 1 else 0) +
                (if (submitForReview.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                definition == other.definition &&
                category == other.category &&
                language == other.language &&
                submitForReview == other.submitForReview &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(definition, category, language, submitForReview, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{definition=$definition, category=$category, language=$language, submitForReview=$submitForReview, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateCreateParams &&
            xApiKey == other.xApiKey &&
            xSenderId == other.xSenderId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(xApiKey, xSenderId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TemplateCreateParams{xApiKey=$xApiKey, xSenderId=$xSenderId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
