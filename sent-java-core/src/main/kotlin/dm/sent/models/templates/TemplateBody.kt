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
 * Body section of a message template.
 *
 * A body picks one of two authoring strategies, and mixing them is refused
 * (TemplateDefinitionValidator.HaveValidChannelConfiguration): a shared multiChannel body on its
 * own, or an explicit sms + whatsapp pair, both present.
 *
 * multiChannel together with sms or whatsapp is rejected, and so is sms or whatsapp on its own —
 * every template is expected to be deliverable on every channel. rcs is the one true override: it
 * may accompany either strategy to vary the copy, but cannot stand alone.
 */
class TemplateBody
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val mms: JsonField<Mms>,
    private val multiChannel: JsonField<TemplateBodyContent>,
    private val rcs: JsonField<TemplateBodyContent>,
    private val sms: JsonField<TemplateBodyContent>,
    private val whatsapp: JsonField<TemplateBodyContent>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("mms") @ExcludeMissing mms: JsonField<Mms> = JsonMissing.of(),
        @JsonProperty("multiChannel")
        @ExcludeMissing
        multiChannel: JsonField<TemplateBodyContent> = JsonMissing.of(),
        @JsonProperty("rcs") @ExcludeMissing rcs: JsonField<TemplateBodyContent> = JsonMissing.of(),
        @JsonProperty("sms") @ExcludeMissing sms: JsonField<TemplateBodyContent> = JsonMissing.of(),
        @JsonProperty("whatsapp")
        @ExcludeMissing
        whatsapp: JsonField<TemplateBodyContent> = JsonMissing.of(),
    ) : this(mms, multiChannel, rcs, sms, whatsapp, mutableMapOf())

    /**
     * MMS-specific content — subject, text and attachments.
     *
     * Like Rcs, an override that cannot stand on its own: a template still needs a MultiChannel
     * body or the Sms + Whatsapp pair to be deliverable at all. Unlike Rcs, it has no fallback at
     * send time — MMS with no media is a more expensive SMS, so a template without this slot is
     * deliberately not MMS-capable and never produces an MMS route candidate.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mms(): Optional<Mms> = mms.getOptional("mms")

    /**
     * The shared body, used for every channel. One half of the choice described above.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun multiChannel(): Optional<TemplateBodyContent> = multiChannel.getOptional("multiChannel")

    /**
     * RCS-specific copy that overrides the chosen strategy for RCS only. The one true override:
     * optional on top of either strategy, but it cannot be the only body present. Its length cap is
     * the higher one described on Template.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun rcs(): Optional<TemplateBodyContent> = rcs.getOptional("rcs")

    /**
     * The SMS body. It does not override multiChannel, it replaces it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sms(): Optional<TemplateBodyContent> = sms.getOptional("sms")

    /**
     * The WhatsApp body. It does not override multiChannel, it replaces it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun whatsapp(): Optional<TemplateBodyContent> = whatsapp.getOptional("whatsapp")

    /**
     * Returns the raw JSON value of [mms].
     *
     * Unlike [mms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mms") @ExcludeMissing fun _mms(): JsonField<Mms> = mms

    /**
     * Returns the raw JSON value of [multiChannel].
     *
     * Unlike [multiChannel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("multiChannel")
    @ExcludeMissing
    fun _multiChannel(): JsonField<TemplateBodyContent> = multiChannel

    /**
     * Returns the raw JSON value of [rcs].
     *
     * Unlike [rcs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rcs") @ExcludeMissing fun _rcs(): JsonField<TemplateBodyContent> = rcs

    /**
     * Returns the raw JSON value of [sms].
     *
     * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<TemplateBodyContent> = sms

    /**
     * Returns the raw JSON value of [whatsapp].
     *
     * Unlike [whatsapp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("whatsapp")
    @ExcludeMissing
    fun _whatsapp(): JsonField<TemplateBodyContent> = whatsapp

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

        /** Returns a mutable builder for constructing an instance of [TemplateBody]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateBody]. */
    class Builder internal constructor() {

        private var mms: JsonField<Mms> = JsonMissing.of()
        private var multiChannel: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var rcs: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var sms: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var whatsapp: JsonField<TemplateBodyContent> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateBody: TemplateBody) = apply {
            mms = templateBody.mms
            multiChannel = templateBody.multiChannel
            rcs = templateBody.rcs
            sms = templateBody.sms
            whatsapp = templateBody.whatsapp
            additionalProperties = templateBody.additionalProperties.toMutableMap()
        }

        /**
         * MMS-specific content — subject, text and attachments.
         *
         * Like Rcs, an override that cannot stand on its own: a template still needs a MultiChannel
         * body or the Sms + Whatsapp pair to be deliverable at all. Unlike Rcs, it has no fallback
         * at send time — MMS with no media is a more expensive SMS, so a template without this slot
         * is deliberately not MMS-capable and never produces an MMS route candidate.
         */
        fun mms(mms: Mms?) = mms(JsonField.ofNullable(mms))

        /** Alias for calling [Builder.mms] with `mms.orElse(null)`. */
        fun mms(mms: Optional<Mms>) = mms(mms.getOrNull())

        /**
         * Sets [Builder.mms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mms] with a well-typed [Mms] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mms(mms: JsonField<Mms>) = apply { this.mms = mms }

        /** The shared body, used for every channel. One half of the choice described above. */
        fun multiChannel(multiChannel: TemplateBodyContent?) =
            multiChannel(JsonField.ofNullable(multiChannel))

        /** Alias for calling [Builder.multiChannel] with `multiChannel.orElse(null)`. */
        fun multiChannel(multiChannel: Optional<TemplateBodyContent>) =
            multiChannel(multiChannel.getOrNull())

        /**
         * Sets [Builder.multiChannel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.multiChannel] with a well-typed [TemplateBodyContent]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun multiChannel(multiChannel: JsonField<TemplateBodyContent>) = apply {
            this.multiChannel = multiChannel
        }

        /**
         * RCS-specific copy that overrides the chosen strategy for RCS only. The one true override:
         * optional on top of either strategy, but it cannot be the only body present. Its length
         * cap is the higher one described on Template.
         */
        fun rcs(rcs: TemplateBodyContent?) = rcs(JsonField.ofNullable(rcs))

        /** Alias for calling [Builder.rcs] with `rcs.orElse(null)`. */
        fun rcs(rcs: Optional<TemplateBodyContent>) = rcs(rcs.getOrNull())

        /**
         * Sets [Builder.rcs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rcs] with a well-typed [TemplateBodyContent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun rcs(rcs: JsonField<TemplateBodyContent>) = apply { this.rcs = rcs }

        /** The SMS body. It does not override multiChannel, it replaces it. */
        fun sms(sms: TemplateBodyContent?) = sms(JsonField.ofNullable(sms))

        /** Alias for calling [Builder.sms] with `sms.orElse(null)`. */
        fun sms(sms: Optional<TemplateBodyContent>) = sms(sms.getOrNull())

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed [TemplateBodyContent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sms(sms: JsonField<TemplateBodyContent>) = apply { this.sms = sms }

        /** The WhatsApp body. It does not override multiChannel, it replaces it. */
        fun whatsapp(whatsapp: TemplateBodyContent?) = whatsapp(JsonField.ofNullable(whatsapp))

        /** Alias for calling [Builder.whatsapp] with `whatsapp.orElse(null)`. */
        fun whatsapp(whatsapp: Optional<TemplateBodyContent>) = whatsapp(whatsapp.getOrNull())

        /**
         * Sets [Builder.whatsapp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsapp] with a well-typed [TemplateBodyContent] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun whatsapp(whatsapp: JsonField<TemplateBodyContent>) = apply { this.whatsapp = whatsapp }

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
         * Returns an immutable instance of [TemplateBody].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateBody =
            TemplateBody(mms, multiChannel, rcs, sms, whatsapp, additionalProperties.toMutableMap())
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
    fun validate(): TemplateBody = apply {
        if (validated) {
            return@apply
        }

        mms().ifPresent { it.validate() }
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (mms.asKnown().getOrNull()?.validity() ?: 0) +
            (multiChannel.asKnown().getOrNull()?.validity() ?: 0) +
            (rcs.asKnown().getOrNull()?.validity() ?: 0) +
            (sms.asKnown().getOrNull()?.validity() ?: 0) +
            (whatsapp.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * MMS-specific content — subject, text and attachments.
     *
     * Like Rcs, an override that cannot stand on its own: a template still needs a MultiChannel
     * body or the Sms + Whatsapp pair to be deliverable at all. Unlike Rcs, it has no fallback at
     * send time — MMS with no media is a more expensive SMS, so a template without this slot is
     * deliberately not MMS-capable and never produces an MMS route candidate.
     */
    class Mms
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val template: JsonField<String>,
        private val type: JsonField<String>,
        private val variables: JsonField<List<TemplateVariable>>,
        private val media: JsonField<List<Media>>,
        private val subject: JsonField<String>,
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
            variables: JsonField<List<TemplateVariable>> = JsonMissing.of(),
            @JsonProperty("media") @ExcludeMissing media: JsonField<List<Media>> = JsonMissing.of(),
            @JsonProperty("subject") @ExcludeMissing subject: JsonField<String> = JsonMissing.of(),
        ) : this(template, type, variables, media, subject, mutableMapOf())

        fun toTemplateBodyContent(): TemplateBodyContent =
            TemplateBodyContent.builder().template(template).type(type).variables(variables).build()

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
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun template(): String = template.getRequired("template")

        /**
         * The type of body content — send "text". It is dropped from the stored definition when
         * null, so a body posted without it is saved with no type key at all and the template
         * editor has nothing to render the block from.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun type(): Optional<String> = type.getOptional("type")

        /**
         * The variables referenced by the body copy, one entry per {{index:variable}} placeholder.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun variables(): Optional<List<TemplateVariable>> = variables.getOptional("variables")

        /**
         * Attachments carried by every send on this template, in order. A per-send media_urls on
         * the request replaces this list rather than adding to it, so a template can hold a default
         * creative and a caller can still send something recipient-specific.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun media(): Optional<List<Media>> = media.getOptional("media")

        /**
         * MMS subject line. Optional — most handsets render it above the body, some ignore it
         * entirely. Deliberately its own field rather than riding TemplateHeader: the header is
         * authored once and shared across every channel, and carries Meta's 60-character cap plus
         * its no-newline, no-emoji text rules, none of which describe an MMS subject.
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
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
        @JsonProperty("media") @ExcludeMissing fun _media(): JsonField<List<Media>> = media

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
             * Returns a mutable builder for constructing an instance of [Mms].
             *
             * The following fields are required:
             * ```java
             * .template()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Mms]. */
        class Builder internal constructor() {

            private var template: JsonField<String>? = null
            private var type: JsonField<String> = JsonMissing.of()
            private var variables: JsonField<MutableList<TemplateVariable>>? = null
            private var media: JsonField<MutableList<Media>>? = null
            private var subject: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mms: Mms) = apply {
                template = mms.template
                type = mms.type
                variables = mms.variables.map { it.toMutableList() }
                media = mms.media.map { it.toMutableList() }
                subject = mms.subject
                additionalProperties = mms.additionalProperties.toMutableMap()
            }

            /**
             * The body copy, with variables written as {{index:variable}}.
             *
             * Length cap depends on which channel this body belongs to:
             * TemplateContentLimits.MaxBodyLength (1024) for multiChannel, sms and whatsapp —
             * Meta's BODY limit, which a multiChannel body may be delivered under — and
             * TemplateContentLimits.MaxRcsBodyLength (3072) for an rcs body, which never reaches
             * Meta. The maxLength advertised on this schema is the 1024 one, because all four
             * channel bodies share this single schema — an rcs body between the two is accepted.
             *
             * Meta requires every variable to carry surrounding context, so a body is refused
             * unless it also satisfies all of the following (enforced by
             * TemplateDefinitionValidator): At least one letter before the first variable and after
             * the last — trailing punctuation such as "... {{1:variable}}." does not count. At
             * least (2 × variable count) + 1 words once the placeholders are removed. No two
             * variables adjacent with only whitespace between them. No leading or trailing newline,
             * no more than two consecutive line breaks, and no more than four consecutive spaces.
             *
             * Example: "Hello {{0:variable}}! Welcome to {{1:variable}}. We are glad to have you on
             * board." — two variables, so at least five words are required, and the copy after the
             * final variable contains letters.
             */
            fun template(template: String) = template(JsonField.of(template))

            /**
             * Sets [Builder.template] to an arbitrary JSON value.
             *
             * You should usually call [Builder.template] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun template(template: JsonField<String>) = apply { this.template = template }

            /**
             * The type of body content — send "text". It is dropped from the stored definition when
             * null, so a body posted without it is saved with no type key at all and the template
             * editor has nothing to render the block from.
             */
            fun type(type: String?) = type(JsonField.ofNullable(type))

            /** Alias for calling [Builder.type] with `type.orElse(null)`. */
            fun type(type: Optional<String>) = type(type.getOrNull())

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

            /**
             * The variables referenced by the body copy, one entry per {{index:variable}}
             * placeholder.
             */
            fun variables(variables: List<TemplateVariable>?) =
                variables(JsonField.ofNullable(variables))

            /** Alias for calling [Builder.variables] with `variables.orElse(null)`. */
            fun variables(variables: Optional<List<TemplateVariable>>) =
                variables(variables.getOrNull())

            /**
             * Sets [Builder.variables] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variables] with a well-typed
             * `List<TemplateVariable>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
             * Attachments carried by every send on this template, in order. A per-send media_urls
             * on the request replaces this list rather than adding to it, so a template can hold a
             * default creative and a caller can still send something recipient-specific.
             */
            fun media(media: List<Media>?) = media(JsonField.ofNullable(media))

            /** Alias for calling [Builder.media] with `media.orElse(null)`. */
            fun media(media: Optional<List<Media>>) = media(media.getOrNull())

            /**
             * Sets [Builder.media] to an arbitrary JSON value.
             *
             * You should usually call [Builder.media] with a well-typed `List<Media>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun media(media: JsonField<List<Media>>) = apply {
                this.media = media.map { it.toMutableList() }
            }

            /**
             * Adds a single [Media] to [Builder.media].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addMedia(media: Media) = apply {
                this.media =
                    (this.media ?: JsonField.of(mutableListOf())).also {
                        checkKnown("media", it).add(media)
                    }
            }

            /**
             * MMS subject line. Optional — most handsets render it above the body, some ignore it
             * entirely. Deliberately its own field rather than riding TemplateHeader: the header is
             * authored once and shared across every channel, and carries Meta's 60-character cap
             * plus its no-newline, no-emoji text rules, none of which describe an MMS subject.
             */
            fun subject(subject: String?) = subject(JsonField.ofNullable(subject))

            /** Alias for calling [Builder.subject] with `subject.orElse(null)`. */
            fun subject(subject: Optional<String>) = subject(subject.getOrNull())

            /**
             * Sets [Builder.subject] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subject] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Mms].
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
            fun build(): Mms =
                Mms(
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
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws SentInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Mms = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
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

        /** One attachment on an MMS template body. */
        class Media
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val mediaType: JsonField<String>,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("mediaType")
                @ExcludeMissing
                mediaType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(mediaType, url, mutableMapOf())

            /**
             * One of MmsMediaTypes. Advisory: the carrier reads the Content-Type off the fetched
             * object, not this field. It exists so an authoring UI can render the right preview and
             * so a reviewer can see what was intended.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun mediaType(): Optional<String> = mediaType.getOptional("mediaType")

            /**
             * Publicly fetchable https URL. The carrier's MMSC fetches this at send time, so it has
             * to stay reachable and unauthenticated for the life of the send — including retries
             * and a DLQ replay — which is why a presigned URL is not a valid value here.
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun url(): Optional<String> = url.getOptional("url")

            /**
             * Returns the raw JSON value of [mediaType].
             *
             * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mediaType")
            @ExcludeMissing
            fun _mediaType(): JsonField<String> = mediaType

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

                /** Returns a mutable builder for constructing an instance of [Media]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Media]. */
            class Builder internal constructor() {

                private var mediaType: JsonField<String> = JsonMissing.of()
                private var url: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(media: Media) = apply {
                    mediaType = media.mediaType
                    url = media.url
                    additionalProperties = media.additionalProperties.toMutableMap()
                }

                /**
                 * One of MmsMediaTypes. Advisory: the carrier reads the Content-Type off the
                 * fetched object, not this field. It exists so an authoring UI can render the right
                 * preview and so a reviewer can see what was intended.
                 */
                fun mediaType(mediaType: String?) = mediaType(JsonField.ofNullable(mediaType))

                /** Alias for calling [Builder.mediaType] with `mediaType.orElse(null)`. */
                fun mediaType(mediaType: Optional<String>) = mediaType(mediaType.getOrNull())

                /**
                 * Sets [Builder.mediaType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.mediaType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun mediaType(mediaType: JsonField<String>) = apply { this.mediaType = mediaType }

                /**
                 * Publicly fetchable https URL. The carrier's MMSC fetches this at send time, so it
                 * has to stay reachable and unauthenticated for the life of the send — including
                 * retries and a DLQ replay — which is why a presigned URL is not a valid value
                 * here.
                 */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

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
                 * Returns an immutable instance of [Media].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Media = Media(mediaType, url, additionalProperties.toMutableMap())
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
            fun validate(): Media = apply {
                if (validated) {
                    return@apply
                }

                mediaType()
                url()
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
                    (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Media &&
                    mediaType == other.mediaType &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(mediaType, url, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Media{mediaType=$mediaType, url=$url, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Mms &&
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
            "Mms{template=$template, type=$type, variables=$variables, media=$media, subject=$subject, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateBody &&
            mms == other.mms &&
            multiChannel == other.multiChannel &&
            rcs == other.rcs &&
            sms == other.sms &&
            whatsapp == other.whatsapp &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(mms, multiChannel, rcs, sms, whatsapp, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateBody{mms=$mms, multiChannel=$multiChannel, rcs=$rcs, sms=$sms, whatsapp=$whatsapp, additionalProperties=$additionalProperties}"
}
