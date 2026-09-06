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
import dm.sent.core.checkRequired
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Body of a template status event. Delivered when a template's review outcome changes, so you can
 * react without polling.
 */
class TemplateEventPayload
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val status: JsonField<String>,
    private val whatsappTemplateId: JsonField<String>,
    private val accountId: JsonField<String>,
    private val category: JsonField<String>,
    private val channel: JsonField<String>,
    private val language: JsonField<String>,
    private val reason: JsonField<String>,
    private val templateId: JsonField<String>,
    private val templateName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("whatsapp_template_id")
        @ExcludeMissing
        whatsappTemplateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("account_id") @ExcludeMissing accountId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("category") @ExcludeMissing category: JsonField<String> = JsonMissing.of(),
        @JsonProperty("channel") @ExcludeMissing channel: JsonField<String> = JsonMissing.of(),
        @JsonProperty("language") @ExcludeMissing language: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_id")
        @ExcludeMissing
        templateId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("template_name")
        @ExcludeMissing
        templateName: JsonField<String> = JsonMissing.of(),
    ) : this(
        status,
        whatsappTemplateId,
        accountId,
        category,
        channel,
        language,
        reason,
        templateId,
        templateName,
        mutableMapOf(),
    )

    /**
     * The review status the template just reached, for example APPROVED or REJECTED.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): String = status.getRequired("status")

    /**
     * The template's identifier with Meta, assigned when the template is submitted for review.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun whatsappTemplateId(): String = whatsappTemplateId.getRequired("whatsapp_template_id")

    /**
     * The account the template belongs to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun accountId(): Optional<String> = accountId.getOptional("account_id")

    /**
     * The template's category, for example UTILITY, MARKETING, or AUTHENTICATION.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun category(): Optional<String> = category.getOptional("category")

    /**
     * The channel the template applies to.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun channel(): Optional<String> = channel.getOptional("channel")

    /**
     * The template's language code, for example en_US.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun language(): Optional<String> = language.getOptional("language")

    /**
     * Why the template reached Status, when a reason was given. Populated on a rejection.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun reason(): Optional<String> = reason.getOptional("reason")

    /**
     * The template in Sent.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateId(): Optional<String> = templateId.getOptional("template_id")

    /**
     * The template's display name.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun templateName(): Optional<String> = templateName.getOptional("template_name")

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [whatsappTemplateId].
     *
     * Unlike [whatsappTemplateId], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("whatsapp_template_id")
    @ExcludeMissing
    fun _whatsappTemplateId(): JsonField<String> = whatsappTemplateId

    /**
     * Returns the raw JSON value of [accountId].
     *
     * Unlike [accountId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("account_id") @ExcludeMissing fun _accountId(): JsonField<String> = accountId

    /**
     * Returns the raw JSON value of [category].
     *
     * Unlike [category], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("category") @ExcludeMissing fun _category(): JsonField<String> = category

    /**
     * Returns the raw JSON value of [channel].
     *
     * Unlike [channel], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel") @ExcludeMissing fun _channel(): JsonField<String> = channel

    /**
     * Returns the raw JSON value of [language].
     *
     * Unlike [language], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("language") @ExcludeMissing fun _language(): JsonField<String> = language

    /**
     * Returns the raw JSON value of [reason].
     *
     * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    /**
     * Returns the raw JSON value of [templateId].
     *
     * Unlike [templateId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("template_id") @ExcludeMissing fun _templateId(): JsonField<String> = templateId

    /**
     * Returns the raw JSON value of [templateName].
     *
     * Unlike [templateName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("template_name")
    @ExcludeMissing
    fun _templateName(): JsonField<String> = templateName

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
         * Returns a mutable builder for constructing an instance of [TemplateEventPayload].
         *
         * The following fields are required:
         * ```java
         * .status()
         * .whatsappTemplateId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateEventPayload]. */
    class Builder internal constructor() {

        private var status: JsonField<String>? = null
        private var whatsappTemplateId: JsonField<String>? = null
        private var accountId: JsonField<String> = JsonMissing.of()
        private var category: JsonField<String> = JsonMissing.of()
        private var channel: JsonField<String> = JsonMissing.of()
        private var language: JsonField<String> = JsonMissing.of()
        private var reason: JsonField<String> = JsonMissing.of()
        private var templateId: JsonField<String> = JsonMissing.of()
        private var templateName: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateEventPayload: TemplateEventPayload) = apply {
            status = templateEventPayload.status
            whatsappTemplateId = templateEventPayload.whatsappTemplateId
            accountId = templateEventPayload.accountId
            category = templateEventPayload.category
            channel = templateEventPayload.channel
            language = templateEventPayload.language
            reason = templateEventPayload.reason
            templateId = templateEventPayload.templateId
            templateName = templateEventPayload.templateName
            additionalProperties = templateEventPayload.additionalProperties.toMutableMap()
        }

        /** The review status the template just reached, for example APPROVED or REJECTED. */
        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        /**
         * The template's identifier with Meta, assigned when the template is submitted for review.
         */
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

        /** The account the template belongs to. */
        fun accountId(accountId: String) = accountId(JsonField.of(accountId))

        /**
         * Sets [Builder.accountId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accountId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun accountId(accountId: JsonField<String>) = apply { this.accountId = accountId }

        /** The template's category, for example UTILITY, MARKETING, or AUTHENTICATION. */
        fun category(category: String) = category(JsonField.of(category))

        /**
         * Sets [Builder.category] to an arbitrary JSON value.
         *
         * You should usually call [Builder.category] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun category(category: JsonField<String>) = apply { this.category = category }

        /** The channel the template applies to. */
        fun channel(channel: String) = channel(JsonField.of(channel))

        /**
         * Sets [Builder.channel] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channel] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun channel(channel: JsonField<String>) = apply { this.channel = channel }

        /** The template's language code, for example en_US. */
        fun language(language: String) = language(JsonField.of(language))

        /**
         * Sets [Builder.language] to an arbitrary JSON value.
         *
         * You should usually call [Builder.language] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun language(language: JsonField<String>) = apply { this.language = language }

        /** Why the template reached Status, when a reason was given. Populated on a rejection. */
        fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

        /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
        fun reason(reason: Optional<String>) = reason(reason.getOrNull())

        /**
         * Sets [Builder.reason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reason] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun reason(reason: JsonField<String>) = apply { this.reason = reason }

        /** The template in Sent. */
        fun templateId(templateId: String) = templateId(JsonField.of(templateId))

        /**
         * Sets [Builder.templateId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun templateId(templateId: JsonField<String>) = apply { this.templateId = templateId }

        /** The template's display name. */
        fun templateName(templateName: String) = templateName(JsonField.of(templateName))

        /**
         * Sets [Builder.templateName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.templateName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun templateName(templateName: JsonField<String>) = apply {
            this.templateName = templateName
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
         * Returns an immutable instance of [TemplateEventPayload].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .status()
         * .whatsappTemplateId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TemplateEventPayload =
            TemplateEventPayload(
                checkRequired("status", status),
                checkRequired("whatsappTemplateId", whatsappTemplateId),
                accountId,
                category,
                channel,
                language,
                reason,
                templateId,
                templateName,
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
    fun validate(): TemplateEventPayload = apply {
        if (validated) {
            return@apply
        }

        status()
        whatsappTemplateId()
        accountId()
        category()
        channel()
        language()
        reason()
        templateId()
        templateName()
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
        (if (status.asKnown().isPresent) 1 else 0) +
            (if (whatsappTemplateId.asKnown().isPresent) 1 else 0) +
            (if (accountId.asKnown().isPresent) 1 else 0) +
            (if (category.asKnown().isPresent) 1 else 0) +
            (if (channel.asKnown().isPresent) 1 else 0) +
            (if (language.asKnown().isPresent) 1 else 0) +
            (if (reason.asKnown().isPresent) 1 else 0) +
            (if (templateId.asKnown().isPresent) 1 else 0) +
            (if (templateName.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateEventPayload &&
            status == other.status &&
            whatsappTemplateId == other.whatsappTemplateId &&
            accountId == other.accountId &&
            category == other.category &&
            channel == other.channel &&
            language == other.language &&
            reason == other.reason &&
            templateId == other.templateId &&
            templateName == other.templateName &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            status,
            whatsappTemplateId,
            accountId,
            category,
            channel,
            language,
            reason,
            templateId,
            templateName,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateEventPayload{status=$status, whatsappTemplateId=$whatsappTemplateId, accountId=$accountId, category=$category, channel=$channel, language=$language, reason=$reason, templateId=$templateId, templateName=$templateName, additionalProperties=$additionalProperties}"
}
