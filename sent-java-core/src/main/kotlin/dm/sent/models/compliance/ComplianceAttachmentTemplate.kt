// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A file this market wants, and the multipart field to send it as.
 *
 * Separate from compliance because a file is not JSON: the channel call accepts multipart, and each
 * file is named after the key it satisfies. Listing documents among the JSON entries would describe
 * a request nobody could send.
 */
class ComplianceAttachmentTemplate
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val fieldName: JsonField<String>,
    private val label: JsonField<String>,
    private val required: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("field_name") @ExcludeMissing fieldName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
        @JsonProperty("required") @ExcludeMissing required: JsonField<Boolean> = JsonMissing.of(),
    ) : this(fieldName, label, required, mutableMapOf())

    /**
     * The multipart field name to attach the file under.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun fieldName(): Optional<String> = fieldName.getOptional("field_name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun label(): Optional<String> = label.getOptional("label")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun required(): Optional<Boolean> = required.getOptional("required")

    /**
     * Returns the raw JSON value of [fieldName].
     *
     * Unlike [fieldName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("field_name") @ExcludeMissing fun _fieldName(): JsonField<String> = fieldName

    /**
     * Returns the raw JSON value of [label].
     *
     * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

    /**
     * Returns the raw JSON value of [required].
     *
     * Unlike [required], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required") @ExcludeMissing fun _required(): JsonField<Boolean> = required

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
         * Returns a mutable builder for constructing an instance of [ComplianceAttachmentTemplate].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComplianceAttachmentTemplate]. */
    class Builder internal constructor() {

        private var fieldName: JsonField<String> = JsonMissing.of()
        private var label: JsonField<String> = JsonMissing.of()
        private var required: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(complianceAttachmentTemplate: ComplianceAttachmentTemplate) = apply {
            fieldName = complianceAttachmentTemplate.fieldName
            label = complianceAttachmentTemplate.label
            required = complianceAttachmentTemplate.required
            additionalProperties = complianceAttachmentTemplate.additionalProperties.toMutableMap()
        }

        /** The multipart field name to attach the file under. */
        fun fieldName(fieldName: String) = fieldName(JsonField.of(fieldName))

        /**
         * Sets [Builder.fieldName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fieldName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fieldName(fieldName: JsonField<String>) = apply { this.fieldName = fieldName }

        fun label(label: String?) = label(JsonField.ofNullable(label))

        /** Alias for calling [Builder.label] with `label.orElse(null)`. */
        fun label(label: Optional<String>) = label(label.getOrNull())

        /**
         * Sets [Builder.label] to an arbitrary JSON value.
         *
         * You should usually call [Builder.label] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun label(label: JsonField<String>) = apply { this.label = label }

        fun required(required: Boolean) = required(JsonField.of(required))

        /**
         * Sets [Builder.required] to an arbitrary JSON value.
         *
         * You should usually call [Builder.required] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun required(required: JsonField<Boolean>) = apply { this.required = required }

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
         * Returns an immutable instance of [ComplianceAttachmentTemplate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ComplianceAttachmentTemplate =
            ComplianceAttachmentTemplate(
                fieldName,
                label,
                required,
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
    fun validate(): ComplianceAttachmentTemplate = apply {
        if (validated) {
            return@apply
        }

        fieldName()
        label()
        required()
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
        (if (fieldName.asKnown().isPresent) 1 else 0) +
            (if (label.asKnown().isPresent) 1 else 0) +
            (if (required.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComplianceAttachmentTemplate &&
            fieldName == other.fieldName &&
            label == other.label &&
            required == other.required &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(fieldName, label, required, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComplianceAttachmentTemplate{fieldName=$fieldName, label=$label, required=$required, additionalProperties=$additionalProperties}"
}
