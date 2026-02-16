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
import dm.sent.errors.SentDmInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents a message template with comprehensive metadata including definition structure */
class TemplateResponseV2
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val category: JsonField<String>,
    private val createdAt: JsonField<OffsetDateTime>,
    private val definition: JsonField<TemplateDefinition>,
    private val displayName: JsonField<String>,
    private val isPublished: JsonField<Boolean>,
    private val language: JsonField<String>,
    private val status: JsonField<String>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val whatsappTemplateId: JsonField<String>,
    private val whatsappTemplateName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("category") @ExcludeMissing category: JsonField<String> = JsonMissing.of(),
        @JsonProperty("createdAt")
        @ExcludeMissing
        createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("definition")
        @ExcludeMissing
        definition: JsonField<TemplateDefinition> = JsonMissing.of(),
        @JsonProperty("displayName")
        @ExcludeMissing
        displayName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("isPublished")
        @ExcludeMissing
        isPublished: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("language") @ExcludeMissing language: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updatedAt")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("whatsappTemplateId")
        @ExcludeMissing
        whatsappTemplateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("whatsappTemplateName")
        @ExcludeMissing
        whatsappTemplateName: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        category,
        createdAt,
        definition,
        displayName,
        isPublished,
        language,
        status,
        updatedAt,
        whatsappTemplateId,
        whatsappTemplateName,
        mutableMapOf(),
    )

    /**
     * The unique identifier of the template
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * The template category (e.g., MARKETING, UTILITY, AUTHENTICATION)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun category(): Optional<String> = category.getOptional("category")

    /**
     * The date and time when the template was created
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("createdAt")

    /**
     * The complete template definition including header, body, footer, and buttons
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun definition(): Optional<TemplateDefinition> = definition.getOptional("definition")

    /**
     * The display name of the template (auto-generated if not provided)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun displayName(): Optional<String> = displayName.getOptional("displayName")

    /**
     * Indicates whether the template is published and available for use
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isPublished(): Optional<Boolean> = isPublished.getOptional("isPublished")

    /**
     * The template language code (e.g., en_US, es_ES)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun language(): Optional<String> = language.getOptional("language")

    /**
     * The approval status of the template (e.g., APPROVED, PENDING, REJECTED, DRAFT)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * The date and time when the template was last updated
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updatedAt")

    /**
     * The WhatsApp Business API template ID from Meta
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun whatsappTemplateId(): Optional<String> =
        whatsappTemplateId.getOptional("whatsappTemplateId")

    /**
     * The WhatsApp template name as registered with Meta
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun whatsappTemplateName(): Optional<String> =
        whatsappTemplateName.getOptional("whatsappTemplateName")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [category].
     *
     * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("createdAt")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    /**
     * Returns the raw JSON value of [definition].
     *
     * Unlike [definition], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("definition")
    @ExcludeMissing
    fun _definition(): JsonField<TemplateDefinition> = definition

    /**
     * Returns the raw JSON value of [displayName].
     *
     * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("displayName") @ExcludeMissing fun _displayName(): JsonField<String> = displayName

    /**
     * Returns the raw JSON value of [isPublished].
     *
     * Unlike [isPublished], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isPublished")
    @ExcludeMissing
    fun _isPublished(): JsonField<Boolean> = isPublished

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updatedAt")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [whatsappTemplateId].
     *
     * Unlike [whatsappTemplateId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("whatsappTemplateId")
    @ExcludeMissing
    fun _whatsappTemplateId(): JsonField<String> = whatsappTemplateId

    /**
     * Returns the raw JSON value of [whatsappTemplateName].
     *
     * Unlike [whatsappTemplateName], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("whatsappTemplateName")
    @ExcludeMissing
    fun _whatsappTemplateName(): JsonField<String> = whatsappTemplateName

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

        /** Returns a mutable builder for constructing an instance of [TemplateResponseV2]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateResponseV2]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var category: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var definition: JsonField<TemplateDefinition> = JsonMissing.of()
        private var displayName: JsonField<String> = JsonMissing.of()
        private var isPublished: JsonField<Boolean> = JsonMissing.of()
        private var language: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var whatsappTemplateId: JsonField<String> = JsonMissing.of()
        private var whatsappTemplateName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateResponseV2: TemplateResponseV2) = apply {
            id = templateResponseV2.id
            category = templateResponseV2.category
            createdAt = templateResponseV2.createdAt
            definition = templateResponseV2.definition
            displayName = templateResponseV2.displayName
            isPublished = templateResponseV2.isPublished
            language = templateResponseV2.language
            status = templateResponseV2.status
            updatedAt = templateResponseV2.updatedAt
            whatsappTemplateId = templateResponseV2.whatsappTemplateId
            whatsappTemplateName = templateResponseV2.whatsappTemplateName
            additionalProperties = templateResponseV2.additionalProperties.toMutableMap()
        }

        /** The unique identifier of the template */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The template category (e.g., MARKETING, UTILITY, AUTHENTICATION) */
        fun category(category: String) = category(JsonField.of(category))

        /**
         * Sets [Builder.category] to an arbitrary JSON value.
         *
         * You should usually call [Builder.category] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun category(category: JsonField<String>) = apply { this.category = category }

        /** The date and time when the template was created */
        fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        /** The complete template definition including header, body, footer, and buttons */
        fun definition(definition: TemplateDefinition) = definition(JsonField.of(definition))

        /**
         * Sets [Builder.definition] to an arbitrary JSON value.
         *
         * You should usually call [Builder.definition] with a well-typed [TemplateDefinition] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun definition(definition: JsonField<TemplateDefinition>) = apply {
            this.definition = definition
        }

        /** The display name of the template (auto-generated if not provided) */
        fun displayName(displayName: String) = displayName(JsonField.of(displayName))

        /**
         * Sets [Builder.displayName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.displayName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun displayName(displayName: JsonField<String>) = apply { this.displayName = displayName }

        /** Indicates whether the template is published and available for use */
        fun isPublished(isPublished: Boolean) = isPublished(JsonField.of(isPublished))

        /**
         * Sets [Builder.isPublished] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isPublished] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isPublished(isPublished: JsonField<Boolean>) = apply { this.isPublished = isPublished }

        /** The template language code (e.g., en_US, es_ES) */
        fun language(language: String) = language(JsonField.of(language))

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /** The approval status of the template (e.g., APPROVED, PENDING, REJECTED, DRAFT) */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /** The date and time when the template was last updated */
        fun updatedAt(updatedAt: OffsetDateTime?) = updatedAt(JsonField.ofNullable(updatedAt))

        /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
        fun updatedAt(updatedAt: Optional<OffsetDateTime>) = updatedAt(updatedAt.getOrNull())

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** The WhatsApp Business API template ID from Meta */
        fun whatsappTemplateId(whatsappTemplateId: String) =
            whatsappTemplateId(JsonField.of(whatsappTemplateId))

        /**
         * Sets [Builder.whatsappTemplateId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsappTemplateId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun whatsappTemplateId(whatsappTemplateId: JsonField<String>) = apply {
            this.whatsappTemplateId = whatsappTemplateId
        }

        /** The WhatsApp template name as registered with Meta */
        fun whatsappTemplateName(whatsappTemplateName: String) =
            whatsappTemplateName(JsonField.of(whatsappTemplateName))

        /**
         * Sets [Builder.whatsappTemplateName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.whatsappTemplateName] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun whatsappTemplateName(whatsappTemplateName: JsonField<String>) = apply {
            this.whatsappTemplateName = whatsappTemplateName
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
         * Returns an immutable instance of [TemplateResponseV2].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateResponseV2 =
            TemplateResponseV2(
                id,
                category,
                createdAt,
                definition,
                displayName,
                isPublished,
                language,
                status,
                updatedAt,
                whatsappTemplateId,
                whatsappTemplateName,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): TemplateResponseV2 = apply {
        if (validated) {
            return@apply
        }

        id()
        category()
        createdAt()
        definition().ifPresent { it.validate() }
        displayName()
        isPublished()
        language()
        status()
        updatedAt()
        whatsappTemplateId()
        whatsappTemplateName()
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
            (if (category.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (definition.asKnown().getOrNull()?.validity() ?: 0) +
            (if (displayName.asKnown().isPresent) 1 else 0) +
            (if (isPublished.asKnown().isPresent) 1 else 0) +
            (if (language.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (whatsappTemplateId.asKnown().isPresent) 1 else 0) +
            (if (whatsappTemplateName.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateResponseV2 &&
            id == other.id &&
            category == other.category &&
            createdAt == other.createdAt &&
            definition == other.definition &&
            displayName == other.displayName &&
            isPublished == other.isPublished &&
            language == other.language &&
            status == other.status &&
            updatedAt == other.updatedAt &&
            whatsappTemplateId == other.whatsappTemplateId &&
            whatsappTemplateName == other.whatsappTemplateName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            category,
            createdAt,
            definition,
            displayName,
            isPublished,
            language,
            status,
            updatedAt,
            whatsappTemplateId,
            whatsappTemplateName,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateResponseV2{id=$id, category=$category, createdAt=$createdAt, definition=$definition, displayName=$displayName, isPublished=$isPublished, language=$language, status=$status, updatedAt=$updatedAt, whatsappTemplateId=$whatsappTemplateId, whatsappTemplateName=$whatsappTemplateName, additionalProperties=$additionalProperties}"
}
