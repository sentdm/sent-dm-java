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
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TemplateVariable
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
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("props") @ExcludeMissing props: JsonField<Props> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
    ) : this(name, props, type, id, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun props(): Props = props.getRequired("props")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<Int> = id.getOptional("id")

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
         * Returns a mutable builder for constructing an instance of [TemplateVariable].
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

    /** A builder for [TemplateVariable]. */
    class Builder internal constructor() {

        private var name: JsonField<String>? = null
        private var props: JsonField<Props>? = null
        private var type: JsonField<String>? = null
        private var id: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateVariable: TemplateVariable) = apply {
            name = templateVariable.name
            props = templateVariable.props
            type = templateVariable.type
            id = templateVariable.id
            additionalProperties = templateVariable.additionalProperties.toMutableMap()
        }

        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun props(props: Props) = props(JsonField.of(props))

        /**
         * Sets [Builder.props] to an arbitrary JSON value.
         *
         * You should usually call [Builder.props] with a well-typed [Props] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun props(props: JsonField<Props>) = apply { this.props = props }

        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        fun id(id: Int) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Int>) = apply { this.id = id }

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
         * Returns an immutable instance of [TemplateVariable].
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
        fun build(): TemplateVariable =
            TemplateVariable(
                checkRequired("name", name),
                checkRequired("props", props),
                checkRequired("type", type),
                id,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TemplateVariable = apply {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
            @JsonProperty("sample") @ExcludeMissing sample: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variableType")
            @ExcludeMissing
            variableType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("alt") @ExcludeMissing alt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("regex") @ExcludeMissing regex: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shortUrl") @ExcludeMissing shortUrl: JsonField<String> = JsonMissing.of(),
        ) : this(mediaType, sample, url, variableType, alt, regex, shortUrl, mutableMapOf())

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun mediaType(): String = mediaType.getRequired("mediaType")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun sample(): String = sample.getRequired("sample")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun url(): String = url.getRequired("url")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun variableType(): String = variableType.getRequired("variableType")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun alt(): Optional<String> = alt.getOptional("alt")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun regex(): Optional<String> = regex.getOptional("regex")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

        /**
         * Returns the raw JSON value of [mediaType].
         *
         * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mediaType") @ExcludeMissing fun _mediaType(): JsonField<String> = mediaType

        /**
         * Returns the raw JSON value of [sample].
         *
         * Unlike [sample], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sample") @ExcludeMissing fun _sample(): JsonField<String> = sample

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        /**
         * Returns the raw JSON value of [variableType].
         *
         * Unlike [variableType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("variableType")
        @ExcludeMissing
        fun _variableType(): JsonField<String> = variableType

        /**
         * Returns the raw JSON value of [alt].
         *
         * Unlike [alt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

        /**
         * Returns the raw JSON value of [regex].
         *
         * Unlike [regex], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("regex") @ExcludeMissing fun _regex(): JsonField<String> = regex

        /**
         * Returns the raw JSON value of [shortUrl].
         *
         * Unlike [shortUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shortUrl") @ExcludeMissing fun _shortUrl(): JsonField<String> = shortUrl

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
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

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
             * You should usually call [Builder.mediaType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaType(mediaType: JsonField<String>) = apply { this.mediaType = mediaType }

            fun sample(sample: String) = sample(JsonField.of(sample))

            /**
             * Sets [Builder.sample] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sample] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sample(sample: JsonField<String>) = apply { this.sample = sample }

            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            fun variableType(variableType: String) = variableType(JsonField.of(variableType))

            /**
             * Sets [Builder.variableType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variableType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * You should usually call [Builder.alt] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun alt(alt: JsonField<String>) = apply { this.alt = alt }

            fun regex(regex: String?) = regex(JsonField.ofNullable(regex))

            /** Alias for calling [Builder.regex] with `regex.orElse(null)`. */
            fun regex(regex: Optional<String>) = regex(regex.getOrNull())

            /**
             * Sets [Builder.regex] to an arbitrary JSON value.
             *
             * You should usually call [Builder.regex] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun regex(regex: JsonField<String>) = apply { this.regex = regex }

            fun shortUrl(shortUrl: String?) = shortUrl(JsonField.ofNullable(shortUrl))

            /** Alias for calling [Builder.shortUrl] with `shortUrl.orElse(null)`. */
            fun shortUrl(shortUrl: Optional<String>) = shortUrl(shortUrl.getOrNull())

            /**
             * Sets [Builder.shortUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.shortUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun shortUrl(shortUrl: JsonField<String>) = apply { this.shortUrl = shortUrl }

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

        return other is TemplateVariable &&
            name == other.name &&
            props == other.props &&
            type == other.type &&
            id == other.id &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(name, props, type, id, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateVariable{name=$name, props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
}
