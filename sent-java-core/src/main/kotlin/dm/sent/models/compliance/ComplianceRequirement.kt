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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** One value a market expects in a channel call's compliance map. */
class ComplianceRequirement
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val format: JsonField<String>,
    private val itemFields: JsonField<List<ComplianceRequirement>>,
    private val key: JsonField<String>,
    private val label: JsonField<String>,
    private val maxItems: JsonField<Int>,
    private val minLength: JsonField<Int>,
    private val notes: JsonField<String>,
    private val options: JsonField<List<String>>,
    private val required: JsonField<Boolean>,
    private val requiredWhen: JsonField<String>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("format") @ExcludeMissing format: JsonField<String> = JsonMissing.of(),
        @JsonProperty("item_fields")
        @ExcludeMissing
        itemFields: JsonField<List<ComplianceRequirement>> = JsonMissing.of(),
        @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
        @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
        @JsonProperty("max_items") @ExcludeMissing maxItems: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("min_length") @ExcludeMissing minLength: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
        @JsonProperty("options")
        @ExcludeMissing
        options: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("required") @ExcludeMissing required: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("required_when")
        @ExcludeMissing
        requiredWhen: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(
        format,
        itemFields,
        key,
        label,
        maxItems,
        minLength,
        notes,
        options,
        required,
        requiredWhen,
        type,
        mutableMapOf(),
    )

    /**
     * Refinement of type where the market demands a specific shape, e.g. e164, url, email,
     * iso3166_alpha2, csv_keywords.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun format(): Optional<String> = format.getOptional("format")

    /**
     * Shape of each entry, when this requirement is a list of objects rather than of scalars.
     *
     * The compliance value stays null in the setup body like every other blank — a body that
     * carries a half-filled object is one the endpoint refuses, which would break the promise that
     * the published body can be sent as it stands. So the shape is described here instead, and each
     * entry the caller composes has these keys.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun itemFields(): Optional<List<ComplianceRequirement>> = itemFields.getOptional("item_fields")

    /**
     * Key to use in the compliance map.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun key(): Optional<String> = key.getOptional("key")

    /**
     * Human label, suitable for a form field.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun label(): Optional<String> = label.getOptional("label")

    /**
     * Most entries this value accepts, where the market caps it.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun maxItems(): Optional<Int> = maxItems.getOptional("max_items")

    /**
     * Shortest acceptable value, where the market sets one. TCR refuses a consent narrative under
     * 40 characters, and finding that out at submission time is the round trip this exists to save.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun minLength(): Optional<Int> = minLength.getOptional("min_length")

    /**
     * Why the market asks for this.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun notes(): Optional<String> = notes.getOptional("notes")

    /**
     * Accepted values, when the type is an enum or a constrained array.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun options(): Optional<List<String>> = options.getOptional("options")

    /**
     * Whether the market always demands this value.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun required(): Optional<Boolean> = required.getOptional("required")

    /**
     * Condition that makes this value required, when it is only required in some cases — e.g.
     * brand.entity_type == PUBLIC_PROFIT. Evaluate it against your own payload to know whether to
     * collect the field.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun requiredWhen(): Optional<String> = requiredWhen.getOptional("required_when")

    /**
     * Value type: string, number, boolean, date, enum, object, array or document.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * Returns the raw JSON value of [format].
     *
     * Unlike [format], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("format") @ExcludeMissing fun _format(): JsonField<String> = format

    /**
     * Returns the raw JSON value of [itemFields].
     *
     * Unlike [itemFields], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item_fields")
    @ExcludeMissing
    fun _itemFields(): JsonField<List<ComplianceRequirement>> = itemFields

    /**
     * Returns the raw JSON value of [key].
     *
     * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

    /**
     * Returns the raw JSON value of [label].
     *
     * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

    /**
     * Returns the raw JSON value of [maxItems].
     *
     * Unlike [maxItems], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("max_items") @ExcludeMissing fun _maxItems(): JsonField<Int> = maxItems

    /**
     * Returns the raw JSON value of [minLength].
     *
     * Unlike [minLength], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("min_length") @ExcludeMissing fun _minLength(): JsonField<Int> = minLength

    /**
     * Returns the raw JSON value of [notes].
     *
     * Unlike [notes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("notes") @ExcludeMissing fun _notes(): JsonField<String> = notes

    /**
     * Returns the raw JSON value of [options].
     *
     * Unlike [options], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("options") @ExcludeMissing fun _options(): JsonField<List<String>> = options

    /**
     * Returns the raw JSON value of [required].
     *
     * Unlike [required], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required") @ExcludeMissing fun _required(): JsonField<Boolean> = required

    /**
     * Returns the raw JSON value of [requiredWhen].
     *
     * Unlike [requiredWhen], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("required_when")
    @ExcludeMissing
    fun _requiredWhen(): JsonField<String> = requiredWhen

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

        /** Returns a mutable builder for constructing an instance of [ComplianceRequirement]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ComplianceRequirement]. */
    class Builder internal constructor() {

        private var format: JsonField<String> = JsonMissing.of()
        private var itemFields: JsonField<MutableList<ComplianceRequirement>>? = null
        private var key: JsonField<String> = JsonMissing.of()
        private var label: JsonField<String> = JsonMissing.of()
        private var maxItems: JsonField<Int> = JsonMissing.of()
        private var minLength: JsonField<Int> = JsonMissing.of()
        private var notes: JsonField<String> = JsonMissing.of()
        private var options: JsonField<MutableList<String>>? = null
        private var required: JsonField<Boolean> = JsonMissing.of()
        private var requiredWhen: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(complianceRequirement: ComplianceRequirement) = apply {
            format = complianceRequirement.format
            itemFields = complianceRequirement.itemFields.map { it.toMutableList() }
            key = complianceRequirement.key
            label = complianceRequirement.label
            maxItems = complianceRequirement.maxItems
            minLength = complianceRequirement.minLength
            notes = complianceRequirement.notes
            options = complianceRequirement.options.map { it.toMutableList() }
            required = complianceRequirement.required
            requiredWhen = complianceRequirement.requiredWhen
            type = complianceRequirement.type
            additionalProperties = complianceRequirement.additionalProperties.toMutableMap()
        }

        /**
         * Refinement of type where the market demands a specific shape, e.g. e164, url, email,
         * iso3166_alpha2, csv_keywords.
         */
        fun format(format: String?) = format(JsonField.ofNullable(format))

        /** Alias for calling [Builder.format] with `format.orElse(null)`. */
        fun format(format: Optional<String>) = format(format.getOrNull())

        /**
         * Sets [Builder.format] to an arbitrary JSON value.
         *
         * You should usually call [Builder.format] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun format(format: JsonField<String>) = apply { this.format = format }

        /**
         * Shape of each entry, when this requirement is a list of objects rather than of scalars.
         *
         * The compliance value stays null in the setup body like every other blank — a body that
         * carries a half-filled object is one the endpoint refuses, which would break the promise
         * that the published body can be sent as it stands. So the shape is described here instead,
         * and each entry the caller composes has these keys.
         */
        fun itemFields(itemFields: List<ComplianceRequirement>?) =
            itemFields(JsonField.ofNullable(itemFields))

        /** Alias for calling [Builder.itemFields] with `itemFields.orElse(null)`. */
        fun itemFields(itemFields: Optional<List<ComplianceRequirement>>) =
            itemFields(itemFields.getOrNull())

        /**
         * Sets [Builder.itemFields] to an arbitrary JSON value.
         *
         * You should usually call [Builder.itemFields] with a well-typed
         * `List<ComplianceRequirement>` value instead. This method is primarily for setting the
         * field to an undocumented or not yet supported value.
         */
        fun itemFields(itemFields: JsonField<List<ComplianceRequirement>>) = apply {
            this.itemFields = itemFields.map { it.toMutableList() }
        }

        /**
         * Adds a single [ComplianceRequirement] to [itemFields].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItemField(itemField: ComplianceRequirement) = apply {
            itemFields =
                (itemFields ?: JsonField.of(mutableListOf())).also {
                    checkKnown("itemFields", it).add(itemField)
                }
        }

        /** Key to use in the compliance map. */
        fun key(key: String) = key(JsonField.of(key))

        /**
         * Sets [Builder.key] to an arbitrary JSON value.
         *
         * You should usually call [Builder.key] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun key(key: JsonField<String>) = apply { this.key = key }

        /** Human label, suitable for a form field. */
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

        /** Most entries this value accepts, where the market caps it. */
        fun maxItems(maxItems: Int?) = maxItems(JsonField.ofNullable(maxItems))

        /**
         * Alias for [Builder.maxItems].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun maxItems(maxItems: Int) = maxItems(maxItems as Int?)

        /** Alias for calling [Builder.maxItems] with `maxItems.orElse(null)`. */
        fun maxItems(maxItems: Optional<Int>) = maxItems(maxItems.getOrNull())

        /**
         * Sets [Builder.maxItems] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maxItems] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun maxItems(maxItems: JsonField<Int>) = apply { this.maxItems = maxItems }

        /**
         * Shortest acceptable value, where the market sets one. TCR refuses a consent narrative
         * under 40 characters, and finding that out at submission time is the round trip this
         * exists to save.
         */
        fun minLength(minLength: Int?) = minLength(JsonField.ofNullable(minLength))

        /**
         * Alias for [Builder.minLength].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun minLength(minLength: Int) = minLength(minLength as Int?)

        /** Alias for calling [Builder.minLength] with `minLength.orElse(null)`. */
        fun minLength(minLength: Optional<Int>) = minLength(minLength.getOrNull())

        /**
         * Sets [Builder.minLength] to an arbitrary JSON value.
         *
         * You should usually call [Builder.minLength] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun minLength(minLength: JsonField<Int>) = apply { this.minLength = minLength }

        /** Why the market asks for this. */
        fun notes(notes: String?) = notes(JsonField.ofNullable(notes))

        /** Alias for calling [Builder.notes] with `notes.orElse(null)`. */
        fun notes(notes: Optional<String>) = notes(notes.getOrNull())

        /**
         * Sets [Builder.notes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notes] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun notes(notes: JsonField<String>) = apply { this.notes = notes }

        /** Accepted values, when the type is an enum or a constrained array. */
        fun options(options: List<String>?) = options(JsonField.ofNullable(options))

        /** Alias for calling [Builder.options] with `options.orElse(null)`. */
        fun options(options: Optional<List<String>>) = options(options.getOrNull())

        /**
         * Sets [Builder.options] to an arbitrary JSON value.
         *
         * You should usually call [Builder.options] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun options(options: JsonField<List<String>>) = apply {
            this.options = options.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [options].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOption(option: String) = apply {
            options =
                (options ?: JsonField.of(mutableListOf())).also {
                    checkKnown("options", it).add(option)
                }
        }

        /** Whether the market always demands this value. */
        fun required(required: Boolean) = required(JsonField.of(required))

        /**
         * Sets [Builder.required] to an arbitrary JSON value.
         *
         * You should usually call [Builder.required] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun required(required: JsonField<Boolean>) = apply { this.required = required }

        /**
         * Condition that makes this value required, when it is only required in some cases — e.g.
         * brand.entity_type == PUBLIC_PROFIT. Evaluate it against your own payload to know whether
         * to collect the field.
         */
        fun requiredWhen(requiredWhen: String?) = requiredWhen(JsonField.ofNullable(requiredWhen))

        /** Alias for calling [Builder.requiredWhen] with `requiredWhen.orElse(null)`. */
        fun requiredWhen(requiredWhen: Optional<String>) = requiredWhen(requiredWhen.getOrNull())

        /**
         * Sets [Builder.requiredWhen] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requiredWhen] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requiredWhen(requiredWhen: JsonField<String>) = apply {
            this.requiredWhen = requiredWhen
        }

        /** Value type: string, number, boolean, date, enum, object, array or document. */
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
         * Returns an immutable instance of [ComplianceRequirement].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ComplianceRequirement =
            ComplianceRequirement(
                format,
                (itemFields ?: JsonMissing.of()).map { it.toImmutable() },
                key,
                label,
                maxItems,
                minLength,
                notes,
                (options ?: JsonMissing.of()).map { it.toImmutable() },
                required,
                requiredWhen,
                type,
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
    fun validate(): ComplianceRequirement = apply {
        if (validated) {
            return@apply
        }

        format()
        itemFields().ifPresent { it.forEach { it.validate() } }
        key()
        label()
        maxItems()
        minLength()
        notes()
        options()
        required()
        requiredWhen()
        type()
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
        (if (format.asKnown().isPresent) 1 else 0) +
            (itemFields.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (key.asKnown().isPresent) 1 else 0) +
            (if (label.asKnown().isPresent) 1 else 0) +
            (if (maxItems.asKnown().isPresent) 1 else 0) +
            (if (minLength.asKnown().isPresent) 1 else 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (options.asKnown().getOrNull()?.size ?: 0) +
            (if (required.asKnown().isPresent) 1 else 0) +
            (if (requiredWhen.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ComplianceRequirement &&
            format == other.format &&
            itemFields == other.itemFields &&
            key == other.key &&
            label == other.label &&
            maxItems == other.maxItems &&
            minLength == other.minLength &&
            notes == other.notes &&
            options == other.options &&
            required == other.required &&
            requiredWhen == other.requiredWhen &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            format,
            itemFields,
            key,
            label,
            maxItems,
            minLength,
            notes,
            options,
            required,
            requiredWhen,
            type,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ComplianceRequirement{format=$format, itemFields=$itemFields, key=$key, label=$label, maxItems=$maxItems, minLength=$minLength, notes=$notes, options=$options, required=$required, requiredWhen=$requiredWhen, type=$type, additionalProperties=$additionalProperties}"
}
