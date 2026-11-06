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
import dm.sent.core.checkKnown
import dm.sent.core.checkRequired
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * MMS-specific body content.
 *
 * Why MMS needs its own type when the other channels share one: it is the only channel with a
 * subject line and the only one with attachments. Every other channel's body is text and variables,
 * which is exactly what TemplateBodyContent already is. Putting Subject and Media on the shared
 * type instead would give sms, whatsapp and rcs two members none of them can ever use.
 *
 * Derives from TemplateBodyContent so that every existing consumer of a body slot —
 * MessageUtils.ConvertVariableToReadable, TemplateDefinition.GetRequiredVariables,
 * TemplateDefinitionValidator.ApplyBodyContentRules — reads it with no change. The two extra
 * members are what the MMS strategy and the provider request need on top.
 */
class TemplateMmsBodyContent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val template: JsonField<String>,
    private val type: JsonField<String>,
    private val variables: JsonField<List<TemplateVariable>>,
    private val media: JsonField<List<TemplateMediaItem>>,
    private val subject: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("template") @ExcludeMissing template: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("variables")
        @ExcludeMissing
        variables: JsonField<List<TemplateVariable>> = JsonMissing.of(),
        @JsonProperty("media")
        @ExcludeMissing
        media: JsonField<List<TemplateMediaItem>> = JsonMissing.of(),
        @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
    ) : this(template, type, variables, media, subject, mutableMapOf())

    fun toTemplateBodyContent(): TemplateBodyContent =
        TemplateBodyContent.builder().template(template).type(type).variables(variables).build()

    /**
     * The body copy, with variables written as {{index:variable}}.
     *
     * Length cap depends on which channel this body belongs to: TemplateContentLimits.MaxBodyLength
     * (1024) for multiChannel, sms and whatsapp — Meta's BODY limit, which a multiChannel body may
     * be delivered under — and TemplateContentLimits.MaxRcsBodyLength (3072) for an rcs body, which
     * never reaches Meta. The maxLength advertised on this schema is the 1024 one, because all four
     * channel bodies share this single schema — an rcs body between the two is accepted.
     *
     * Meta requires every variable to carry surrounding context, so a body is refused unless it
     * also satisfies all of the following (enforced by TemplateDefinitionValidator): At least one
     * letter before the first variable and after the last — trailing punctuation such as "...
     * {{1:variable}}." does not count. At least (2 × variable count) + 1 words once the
     * placeholders are removed. No two variables adjacent with only whitespace between them. No
     * leading or trailing newline, no more than two consecutive line breaks, and no more than four
     * consecutive spaces.
     *
     * Example: "Hello {{0:variable}}! Welcome to {{1:variable}}. We are glad to have you on board."
     * — two variables, so at least five words are required, and the copy after the final variable
     * contains letters.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun template(): String = template.getRequired("template")

    /**
     * The type of body content. Defaults to "text" when omitted, which also fills it in when
     * reading stored bodies saved without it; the template editor refuses to load a body with no
     * type.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * The variables referenced by the body copy, one entry per {{index:variable}} placeholder.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun variables(): Optional<List<TemplateVariable>> = variables.getOptional("variables")

    /**
     * Attachments carried by every send on this template, in order. A per-send media_urls on the
     * request replaces this list rather than adding to it, so a template can hold a default
     * creative and a caller can still send something recipient-specific.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun media(): Optional<List<TemplateMediaItem>> = media.getOptional("media")

    /**
     * MMS subject line. Optional — most handsets render it above the body, some ignore it entirely.
     * Deliberately its own field rather than riding TemplateHeader: the header is authored once and
     * shared across every channel, and carries Meta's 60-character cap plus its no-newline,
     * no-emoji text rules, none of which describe an MMS subject.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun subject(): Optional<String> = subject.getOptional("subject")

    /**
     * Returns the raw JSON value of [template].
     *
     * Unlike [template], this method doesn't throw if the JSON field has an unexpected type.
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
     * Unlike [variables], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("variables")
    @ExcludeMissing
    fun _variables(): JsonField<List<TemplateVariable>> = variables

    /**
     * Returns the raw JSON value of [media].
     *
     * Unlike [media], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<TemplateMediaItem>> = media

    /**
     * Returns the raw JSON value of [subject].
     *
     * Unlike [subject], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("subject") @ExcludeMissing fun _subject(): JsonField<String> = subject

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
         * Returns a mutable builder for constructing an instance of [TemplateMmsBodyContent].
         *
         * The following fields are required:
         * ```java
         * .template()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateMmsBodyContent]. */
    class Builder internal constructor() {

        private var template: JsonField<String>? = null
        private var type: JsonField<String> = JsonMissing.of()
        private var variables: JsonField<MutableList<TemplateVariable>>? = null
        private var media: JsonField<MutableList<TemplateMediaItem>>? = null
        private var subject: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateMmsBodyContent: TemplateMmsBodyContent) = apply {
            template = templateMmsBodyContent.template
            type = templateMmsBodyContent.type
            variables = templateMmsBodyContent.variables.map { it.toMutableList() }
            media = templateMmsBodyContent.media.map { it.toMutableList() }
            subject = templateMmsBodyContent.subject
            additionalProperties = templateMmsBodyContent.additionalProperties.toMutableMap()
        }

        /**
         * The body copy, with variables written as {{index:variable}}.
         *
         * Length cap depends on which channel this body belongs to:
         * TemplateContentLimits.MaxBodyLength (1024) for multiChannel, sms and whatsapp — Meta's
         * BODY limit, which a multiChannel body may be delivered under — and
         * TemplateContentLimits.MaxRcsBodyLength (3072) for an rcs body, which never reaches Meta.
         * The maxLength advertised on this schema is the 1024 one, because all four channel bodies
         * share this single schema — an rcs body between the two is accepted.
         *
         * Meta requires every variable to carry surrounding context, so a body is refused unless it
         * also satisfies all of the following (enforced by TemplateDefinitionValidator): At least
         * one letter before the first variable and after the last — trailing punctuation such as
         * "... {{1:variable}}." does not count. At least (2 × variable count) + 1 words once the
         * placeholders are removed. No two variables adjacent with only whitespace between them. No
         * leading or trailing newline, no more than two consecutive line breaks, and no more than
         * four consecutive spaces.
         *
         * Example: "Hello {{0:variable}}! Welcome to {{1:variable}}. We are glad to have you on
         * board." — two variables, so at least five words are required, and the copy after the
         * final variable contains letters.
         */
        fun template(template: String) = template(JsonField.of(template))

        /**
         * Sets [Builder.template] to an arbitrary JSON value.
         *
         * You should usually call [Builder.template] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun template(template: JsonField<String>) = apply { this.template = template }

        /**
         * The type of body content. Defaults to "text" when omitted, which also fills it in when
         * reading stored bodies saved without it; the template editor refuses to load a body with
         * no type.
         */
        fun type(type: String?) = type(JsonField.ofNullable(type))

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /**
         * The variables referenced by the body copy, one entry per {{index:variable}} placeholder.
         */
        fun variables(variables: List<TemplateVariable>?) =
            variables(JsonField.ofNullable(variables))

        /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
        fun variables(variables: Optional<List<TemplateVariable>>) =
            variables(variables.getOrNull())

        /**
         * Sets [Builder.variables] to an arbitrary JSON value.
         *
         * You should usually call [Builder.variables] with a well-typed `List<TemplateVariable>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun variables(variables: JsonField<List<TemplateVariable>>) = apply {
            this.variables = variables.map { it.toMutableList() }
        }

        /**
         * Adds a single [TemplateVariable] to [variables].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addVariable(variable: TemplateVariable) = apply {
            variables =
                (variables ?: JsonField.of(mutableListOf())).also {
                    checkKnown("variables", it).add(variable)
                }
        }

        /**
         * Attachments carried by every send on this template, in order. A per-send media_urls on
         * the request replaces this list rather than adding to it, so a template can hold a default
         * creative and a caller can still send something recipient-specific.
         */
        fun media(media: List<TemplateMediaItem>?) = media(JsonField.ofNullable(media))

        /** Alias for calling [Builder.media] with `media.orElse(null)`. */
        fun media(media: Optional<List<TemplateMediaItem>>) = media(media.getOrNull())

        /**
         * Sets [Builder.media] to an arbitrary JSON value.
         *
         * You should usually call [Builder.media] with a well-typed `List<TemplateMediaItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun media(media: JsonField<List<TemplateMediaItem>>) = apply {
            this.media = media.map { it.toMutableList() }
        }

        /**
         * Adds a single [TemplateMediaItem] to [Builder.media].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMedia(media: TemplateMediaItem) = apply {
            this.media =
                (this.media ?: JsonField.of(mutableListOf())).also {
                    checkKnown("media", it).add(media)
                }
        }

        /**
         * MMS subject line. Optional — most handsets render it above the body, some ignore it
         * entirely. Deliberately its own field rather than riding TemplateHeader: the header is
         * authored once and shared across every channel, and carries Meta's 60-character cap plus
         * its no-newline, no-emoji text rules, none of which describe an MMS subject.
         */
        fun subject(subject: String?) = subject(JsonField.ofNullable(subject))

        /** Alias for calling [Builder.subject] with `subject.orElse(null)`. */
        fun subject(subject: Optional<String>) = subject(subject.getOrNull())

        /**
         * Sets [Builder.subject] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subject] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun subject(subject: JsonField<String>) = apply { this.subject = subject }

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
         * Returns an immutable instance of [TemplateMmsBodyContent].
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
        fun build(): TemplateMmsBodyContent =
            TemplateMmsBodyContent(
                checkRequired("template", template),
                type,
                (variables ?: JsonMissing.of()).map { it.toImmutable() },
                (media ?: JsonMissing.of()).map { it.toImmutable() },
                subject,
                additionalProperties.toMutableMap(),
            )
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
    fun validate(): TemplateMmsBodyContent = apply {
        if (validated) {
            return@apply
        }

        template()
        type()
        variables().ifPresent { it.forEach { it.validate() } }
        media().ifPresent { it.forEach { it.validate() } }
        subject()
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
        (if (template.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (media.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (subject.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateMmsBodyContent &&
            template == other.template &&
            type == other.type &&
            variables == other.variables &&
            media == other.media &&
            subject == other.subject &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(template, type, variables, media, subject, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateMmsBodyContent{template=$template, type=$type, variables=$variables, media=$media, subject=$subject, additionalProperties=$additionalProperties}"
}
