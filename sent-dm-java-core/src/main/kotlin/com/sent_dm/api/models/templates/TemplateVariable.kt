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
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TemplateVariable
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<Int>,
    private val name: JsonField<String>,
    private val props: JsonField<Props>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("props") @ExcludeMissing props: JsonField<Props> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(id, name, props, type, mutableMapOf())

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<Int> = id.getOptional("id")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun props(): Optional<Props> = props.getOptional("props")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<Int> = id

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

        /** Returns a mutable builder for constructing an instance of [TemplateVariable]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateVariable]. */
    class Builder internal constructor() {

        private var id: JsonField<Int> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var props: JsonField<Props> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateVariable: TemplateVariable) = apply {
            id = templateVariable.id
            name = templateVariable.name
            props = templateVariable.props
            type = templateVariable.type
            additionalProperties = templateVariable.additionalProperties.toMutableMap()
        }

        fun id(id: Int) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Int>) = apply { this.id = id }

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
         */
        fun build(): TemplateVariable =
            TemplateVariable(id, name, props, type, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): TemplateVariable = apply {
        if (validated) {
            return@apply
        }

        id()
        name()
        props().ifPresent { it.validate() }
        type()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (props.asKnown().getOrNull()?.validity() ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    class Props
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val alt: JsonField<String>,
        private val mediaType: JsonField<String>,
        private val sample: JsonField<String>,
        private val shortUrl: JsonField<String>,
        private val url: JsonField<String>,
        private val variableType: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("alt") @ExcludeMissing alt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mediaType")
            @ExcludeMissing
            mediaType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sample") @ExcludeMissing sample: JsonField<String> = JsonMissing.of(),
            @JsonProperty("shortUrl")
            @ExcludeMissing
            shortUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variableType")
            @ExcludeMissing
            variableType: JsonField<String> = JsonMissing.of(),
        ) : this(alt, mediaType, sample, shortUrl, url, variableType, mutableMapOf())

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun alt(): Optional<String> = alt.getOptional("alt")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mediaType(): Optional<String> = mediaType.getOptional("mediaType")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun sample(): Optional<String> = sample.getOptional("sample")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun shortUrl(): Optional<String> = shortUrl.getOptional("shortUrl")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun variableType(): Optional<String> = variableType.getOptional("variableType")

        /**
         * Returns the raw JSON value of [alt].
         *
         * Unlike [alt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("alt") @ExcludeMissing fun _alt(): JsonField<String> = alt

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
         * Returns the raw JSON value of [shortUrl].
         *
         * Unlike [shortUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("shortUrl") @ExcludeMissing fun _shortUrl(): JsonField<String> = shortUrl

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

            /** Returns a mutable builder for constructing an instance of [Props]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Props]. */
        class Builder internal constructor() {

            private var alt: JsonField<String> = JsonMissing.of()
            private var mediaType: JsonField<String> = JsonMissing.of()
            private var sample: JsonField<String> = JsonMissing.of()
            private var shortUrl: JsonField<String> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var variableType: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(props: Props) = apply {
                alt = props.alt
                mediaType = props.mediaType
                sample = props.sample
                shortUrl = props.shortUrl
                url = props.url
                variableType = props.variableType
                additionalProperties = props.additionalProperties.toMutableMap()
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

            fun mediaType(mediaType: String?) = mediaType(JsonField.ofNullable(mediaType))

            /** Alias for calling [Builder.mediaType] with `mediaType.orElse(null)`. */
            fun mediaType(mediaType: Optional<String>) = mediaType(mediaType.getOrNull())

            /**
             * Sets [Builder.mediaType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediaType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediaType(mediaType: JsonField<String>) = apply { this.mediaType = mediaType }

            fun sample(sample: String?) = sample(JsonField.ofNullable(sample))

            /** Alias for calling [Builder.sample] with `sample.orElse(null)`. */
            fun sample(sample: Optional<String>) = sample(sample.getOrNull())

            /**
             * Sets [Builder.sample] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sample] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sample(sample: JsonField<String>) = apply { this.sample = sample }

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

            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            fun variableType(variableType: String?) =
                variableType(JsonField.ofNullable(variableType))

            /** Alias for calling [Builder.variableType] with `variableType.orElse(null)`. */
            fun variableType(variableType: Optional<String>) =
                variableType(variableType.getOrNull())

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
             */
            fun build(): Props =
                Props(
                    alt,
                    mediaType,
                    sample,
                    shortUrl,
                    url,
                    variableType,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Props = apply {
            if (validated) {
                return@apply
            }

            alt()
            mediaType()
            sample()
            shortUrl()
            url()
            variableType()
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
            (if (alt.asKnown().isPresent) 1 else 0) +
                (if (mediaType.asKnown().isPresent) 1 else 0) +
                (if (sample.asKnown().isPresent) 1 else 0) +
                (if (shortUrl.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0) +
                (if (variableType.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Props &&
                alt == other.alt &&
                mediaType == other.mediaType &&
                sample == other.sample &&
                shortUrl == other.shortUrl &&
                url == other.url &&
                variableType == other.variableType &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(alt, mediaType, sample, shortUrl, url, variableType, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Props{alt=$alt, mediaType=$mediaType, sample=$sample, shortUrl=$shortUrl, url=$url, variableType=$variableType, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateVariable &&
            id == other.id &&
            name == other.name &&
            props == other.props &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, name, props, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateVariable{id=$id, name=$name, props=$props, type=$type, additionalProperties=$additionalProperties}"
}
