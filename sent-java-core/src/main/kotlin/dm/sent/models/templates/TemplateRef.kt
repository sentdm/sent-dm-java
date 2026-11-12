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
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** SDK-style template reference: resolve by ID or by name, with optional parameters. */
class TemplateRef
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val name: JsonField<String>,
    private val parameters: JsonField<Parameters>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("parameters")
        @ExcludeMissing
        parameters: JsonField<Parameters> = JsonMissing.of(),
    ) : this(id, name, parameters, mutableMapOf())

    /**
     * Template ID (mutually exclusive with name)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * Template name (mutually exclusive with id)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Template variable parameters for personalization, keyed by variable name.
     *
     * Every variable the template declares is required; GET /v3/templates/{id} lists them.
     * Supplying a key the template does not declare is ignored.
     *
     * Media headers. A template whose header is an image (designed in WhatsApp Manager and imported
     * into Sent) declares a reserved header_image key. Its value is a publicly reachable https URL
     * that Meta fetches at send time — Sent does not host the asset, and the sample approved with
     * the template is not reused. The key is derived from the header's media type, so header_video
     * and header_document follow the same shape when those formats ship.
     *
     * "parameters": { "header_image": "https://cdn.example.com/banner.jpg", "name": "John Doe" }
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun parameters(): Optional<Parameters> = parameters.getOptional("parameters")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [parameters].
     *
     * Unlike [parameters], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("parameters")
    @ExcludeMissing
    fun _parameters(): JsonField<Parameters> = parameters

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

        /** Returns a mutable builder for constructing an instance of [TemplateRef]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateRef]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var parameters: JsonField<Parameters> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateRef: TemplateRef) = apply {
            id = templateRef.id
            name = templateRef.name
            parameters = templateRef.parameters
            additionalProperties = templateRef.additionalProperties.toMutableMap()
        }

        /** Template ID (mutually exclusive with name) */
        fun id(id: String?) = id(JsonField.ofNullable(id))

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Template name (mutually exclusive with id) */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /**
         * Template variable parameters for personalization, keyed by variable name.
         *
         * Every variable the template declares is required; GET /v3/templates/{id} lists them.
         * Supplying a key the template does not declare is ignored.
         *
         * Media headers. A template whose header is an image (designed in WhatsApp Manager and
         * imported into Sent) declares a reserved header_image key. Its value is a publicly
         * reachable https URL that Meta fetches at send time — Sent does not host the asset, and
         * the sample approved with the template is not reused. The key is derived from the header's
         * media type, so header_video and header_document follow the same shape when those formats
         * ship.
         *
         * "parameters": { "header_image": "https://cdn.example.com/banner.jpg", "name": "John Doe"
         * }
         */
        fun parameters(parameters: Parameters?) = parameters(JsonField.ofNullable(parameters))

        /** Alias for calling [Builder.parameters] with `parameters.orElse(null)`. */
        fun parameters(parameters: Optional<Parameters>) = parameters(parameters.getOrNull())

        /**
         * Sets [Builder.parameters] to an arbitrary JSON value.
         *
         * You should usually call [Builder.parameters] with a well-typed [Parameters] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun parameters(parameters: JsonField<Parameters>) = apply { this.parameters = parameters }

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
         * Returns an immutable instance of [TemplateRef].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateRef =
            TemplateRef(id, name, parameters, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
    fun validate(): TemplateRef = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        parameters().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (parameters.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Template variable parameters for personalization, keyed by variable name.
     *
     * Every variable the template declares is required; GET /v3/templates/{id} lists them.
     * Supplying a key the template does not declare is ignored.
     *
     * Media headers. A template whose header is an image (designed in WhatsApp Manager and imported
     * into Sent) declares a reserved header_image key. Its value is a publicly reachable https URL
     * that Meta fetches at send time — Sent does not host the asset, and the sample approved with
     * the template is not reused. The key is derived from the header's media type, so header_video
     * and header_document follow the same shape when those formats ship.
     *
     * "parameters": { "header_image": "https://cdn.example.com/banner.jpg", "name": "John Doe" }
     */
    class Parameters
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

            /** Returns a mutable builder for constructing an instance of [Parameters]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Parameters]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(parameters: Parameters) = apply {
                additionalProperties = parameters.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Parameters].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Parameters = Parameters(additionalProperties.toImmutable())
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
        fun validate(): Parameters = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Parameters && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Parameters{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateRef &&
            id == other.id &&
            name == other.name &&
            parameters == other.parameters &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, name, parameters, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateRef{id=$id, name=$name, parameters=$parameters, additionalProperties=$additionalProperties}"
}
