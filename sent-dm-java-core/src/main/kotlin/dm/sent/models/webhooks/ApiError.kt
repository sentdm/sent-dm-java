// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.core.toImmutable
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Error information */
class ApiError
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<String>,
    private val details: JsonField<Details>,
    private val docUrl: JsonField<String>,
    private val message: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
        @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
        @JsonProperty("doc_url") @ExcludeMissing docUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
    ) : this(code, details, docUrl, message, mutableMapOf())

    /**
     * Machine-readable error code (e.g., "RESOURCE_001")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun code(): Optional<String> = code.getOptional("code")

    /**
     * Additional validation error details (field-level errors)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun details(): Optional<Details> = details.getOptional("details")

    /**
     * URL to documentation about this error
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun docUrl(): Optional<String> = docUrl.getOptional("doc_url")

    /**
     * Human-readable error message
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun message(): Optional<String> = message.getOptional("message")

    /**
     * Returns the raw JSON value of [code].
     *
     * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /**
     * Returns the raw JSON value of [details].
     *
     * Unlike [details], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

    /**
     * Returns the raw JSON value of [docUrl].
     *
     * Unlike [docUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("doc_url") @ExcludeMissing fun _docUrl(): JsonField<String> = docUrl

    /**
     * Returns the raw JSON value of [message].
     *
     * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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

        /** Returns a mutable builder for constructing an instance of [ApiError]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiError]. */
    class Builder internal constructor() {

        private var code: JsonField<String> = JsonMissing.of()
        private var details: JsonField<Details> = JsonMissing.of()
        private var docUrl: JsonField<String> = JsonMissing.of()
        private var message: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(apiError: ApiError) = apply {
            code = apiError.code
            details = apiError.details
            docUrl = apiError.docUrl
            message = apiError.message
            additionalProperties = apiError.additionalProperties.toMutableMap()
        }

        /** Machine-readable error code (e.g., "RESOURCE_001") */
        fun code(code: String) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** Additional validation error details (field-level errors) */
        fun details(details: Details?) = details(JsonField.ofNullable(details))

        /** Alias for calling [Builder.details] with `details.orElse(null)`. */
        fun details(details: Optional<Details>) = details(details.getOrNull())

        /**
         * Sets [Builder.details] to an arbitrary JSON value.
         *
         * You should usually call [Builder.details] with a well-typed [Details] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun details(details: JsonField<Details>) = apply { this.details = details }

        /** URL to documentation about this error */
        fun docUrl(docUrl: String?) = docUrl(JsonField.ofNullable(docUrl))

        /** Alias for calling [Builder.docUrl] with `docUrl.orElse(null)`. */
        fun docUrl(docUrl: Optional<String>) = docUrl(docUrl.getOrNull())

        /**
         * Sets [Builder.docUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.docUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun docUrl(docUrl: JsonField<String>) = apply { this.docUrl = docUrl }

        /** Human-readable error message */
        fun message(message: String) = message(JsonField.of(message))

        /**
         * Sets [Builder.message] to an arbitrary JSON value.
         *
         * You should usually call [Builder.message] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun message(message: JsonField<String>) = apply { this.message = message }

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
         * Returns an immutable instance of [ApiError].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ApiError =
            ApiError(code, details, docUrl, message, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ApiError = apply {
        if (validated) {
            return@apply
        }

        code()
        details().ifPresent { it.validate() }
        docUrl()
        message()
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
        (if (code.asKnown().isPresent) 1 else 0) +
            (details.asKnown().getOrNull()?.validity() ?: 0) +
            (if (docUrl.asKnown().isPresent) 1 else 0) +
            (if (message.asKnown().isPresent) 1 else 0)

    /** Additional validation error details (field-level errors) */
    class Details
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

            /** Returns a mutable builder for constructing an instance of [Details]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Details]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(details: Details) = apply {
                additionalProperties = details.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Details].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Details = Details(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Details = apply {
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

            return other is Details && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Details{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiError &&
            code == other.code &&
            details == other.details &&
            docUrl == other.docUrl &&
            message == other.message &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(code, details, docUrl, message, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ApiError{code=$code, details=$details, docUrl=$docUrl, message=$message, additionalProperties=$additionalProperties}"
}
