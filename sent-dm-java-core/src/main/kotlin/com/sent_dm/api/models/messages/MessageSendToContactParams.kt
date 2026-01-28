// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

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
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Sends a message to a specific contact using a template. The message can be sent via SMS or
 * WhatsApp depending on the contact's capabilities. Optionally specify a webhook URL to receive
 * delivery status updates. The customer ID is extracted from the authentication token.
 */
class MessageSendToContactParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The unique identifier of the contact to send the message to
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun contactId(): String = body.contactId()

    /**
     * The unique identifier of the template to use for the message
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun templateId(): String = body.templateId()

    /**
     * Optional key-value pairs of template variables to replace in the template body. For example,
     * if your template contains "Hello {{name}}", you would provide { "name": "John Doe" }
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun templateVariables(): Optional<TemplateVariables> = body.templateVariables()

    /**
     * Returns the raw JSON value of [contactId].
     *
     * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _contactId(): JsonField<String> = body._contactId()

    /**
     * Returns the raw JSON value of [templateId].
     *
     * Unlike [templateId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _templateId(): JsonField<String> = body._templateId()

    /**
     * Returns the raw JSON value of [templateVariables].
     *
     * Unlike [templateVariables], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _templateVariables(): JsonField<TemplateVariables> = body._templateVariables()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageSendToContactParams].
         *
         * The following fields are required:
         * ```java
         * .contactId()
         * .templateId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageSendToContactParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(messageSendToContactParams: MessageSendToContactParams) = apply {
            body = messageSendToContactParams.body.toBuilder()
            additionalHeaders = messageSendToContactParams.additionalHeaders.toBuilder()
            additionalQueryParams = messageSendToContactParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [contactId]
         * - [templateId]
         * - [templateVariables]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The unique identifier of the contact to send the message to */
        fun contactId(contactId: String) = apply { body.contactId(contactId) }

        /**
         * Sets [Builder.contactId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contactId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contactId(contactId: JsonField<String>) = apply { body.contactId(contactId) }

        /** The unique identifier of the template to use for the message */
        fun templateId(templateId: String) = apply { body.templateId(templateId) }

        /**
         * Sets [Builder.templateId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun templateId(templateId: JsonField<String>) = apply { body.templateId(templateId) }

        /**
         * Optional key-value pairs of template variables to replace in the template body. For
         * example, if your template contains "Hello {{name}}", you would provide { "name": "John
         * Doe" }
         */
        fun templateVariables(templateVariables: TemplateVariables?) = apply {
            body.templateVariables(templateVariables)
        }

        /** Alias for calling [Builder.templateVariables] with `templateVariables.orElse(null)`. */
        fun templateVariables(templateVariables: Optional<TemplateVariables>) =
            templateVariables(templateVariables.getOrNull())

        /**
         * Sets [Builder.templateVariables] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateVariables] with a well-typed [TemplateVariables]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun templateVariables(templateVariables: JsonField<TemplateVariables>) = apply {
            body.templateVariables(templateVariables)
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
         * Returns an immutable instance of [MessageSendToContactParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .contactId()
         * .templateId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageSendToContactParams =
            MessageSendToContactParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val contactId: JsonField<String>,
        private val templateId: JsonField<String>,
        private val templateVariables: JsonField<TemplateVariables>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("contactId")
            @ExcludeMissing
            contactId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("templateId")
            @ExcludeMissing
            templateId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("templateVariables")
            @ExcludeMissing
            templateVariables: JsonField<TemplateVariables> = JsonMissing.of(),
        ) : this(contactId, templateId, templateVariables, mutableMapOf())

        /**
         * The unique identifier of the contact to send the message to
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun contactId(): String = contactId.getRequired("contactId")

        /**
         * The unique identifier of the template to use for the message
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun templateId(): String = templateId.getRequired("templateId")

        /**
         * Optional key-value pairs of template variables to replace in the template body. For
         * example, if your template contains "Hello {{name}}", you would provide { "name": "John
         * Doe" }
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun templateVariables(): Optional<TemplateVariables> =
            templateVariables.getOptional("templateVariables")

        /**
         * Returns the raw JSON value of [contactId].
         *
         * Unlike [contactId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contactId") @ExcludeMissing fun _contactId(): JsonField<String> = contactId

        /**
         * Returns the raw JSON value of [templateId].
         *
         * Unlike [templateId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("templateId")
        @ExcludeMissing
        fun _templateId(): JsonField<String> = templateId

        /**
         * Returns the raw JSON value of [templateVariables].
         *
         * Unlike [templateVariables], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("templateVariables")
        @ExcludeMissing
        fun _templateVariables(): JsonField<TemplateVariables> = templateVariables

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
             * .contactId()
             * .templateId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var contactId: JsonField<String>? = null
            private var templateId: JsonField<String>? = null
            private var templateVariables: JsonField<TemplateVariables> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                contactId = body.contactId
                templateId = body.templateId
                templateVariables = body.templateVariables
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The unique identifier of the contact to send the message to */
            fun contactId(contactId: String) = contactId(JsonField.of(contactId))

            /**
             * Sets [Builder.contactId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contactId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contactId(contactId: JsonField<String>) = apply { this.contactId = contactId }

            /** The unique identifier of the template to use for the message */
            fun templateId(templateId: String) = templateId(JsonField.of(templateId))

            /**
             * Sets [Builder.templateId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.templateId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun templateId(templateId: JsonField<String>) = apply { this.templateId = templateId }

            /**
             * Optional key-value pairs of template variables to replace in the template body. For
             * example, if your template contains "Hello {{name}}", you would provide { "name":
             * "John Doe" }
             */
            fun templateVariables(templateVariables: TemplateVariables?) =
                templateVariables(JsonField.ofNullable(templateVariables))

            /**
             * Alias for calling [Builder.templateVariables] with `templateVariables.orElse(null)`.
             */
            fun templateVariables(templateVariables: Optional<TemplateVariables>) =
                templateVariables(templateVariables.getOrNull())

            /**
             * Sets [Builder.templateVariables] to an arbitrary JSON value.
             *
             * You should usually call [Builder.templateVariables] with a well-typed
             * [TemplateVariables] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun templateVariables(templateVariables: JsonField<TemplateVariables>) = apply {
                this.templateVariables = templateVariables
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
             * .contactId()
             * .templateId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("contactId", contactId),
                    checkRequired("templateId", templateId),
                    templateVariables,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            contactId()
            templateId()
            templateVariables().ifPresent { it.validate() }
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
            (if (contactId.asKnown().isPresent) 1 else 0) +
                (if (templateId.asKnown().isPresent) 1 else 0) +
                (templateVariables.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                contactId == other.contactId &&
                templateId == other.templateId &&
                templateVariables == other.templateVariables &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(contactId, templateId, templateVariables, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{contactId=$contactId, templateId=$templateId, templateVariables=$templateVariables, additionalProperties=$additionalProperties}"
    }

    /**
     * Optional key-value pairs of template variables to replace in the template body. For example,
     * if your template contains "Hello {{name}}", you would provide { "name": "John Doe" }
     */
    class TemplateVariables
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

            /** Returns a mutable builder for constructing an instance of [TemplateVariables]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TemplateVariables]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(templateVariables: TemplateVariables) = apply {
                additionalProperties = templateVariables.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [TemplateVariables].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): TemplateVariables = TemplateVariables(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): TemplateVariables = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TemplateVariables && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "TemplateVariables{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageSendToContactParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "MessageSendToContactParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
