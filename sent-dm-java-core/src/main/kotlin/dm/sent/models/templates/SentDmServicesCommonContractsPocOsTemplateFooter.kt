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
import dm.sent.core.toImmutable
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Footer section of a message template */
class SentDmServicesCommonContractsPocOsTemplateFooter
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val template: JsonField<String>,
    private val type: JsonField<String>,
    private val variables: JsonField<List<TemplateVariable>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("template") @ExcludeMissing template: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("variables")
        @ExcludeMissing
        variables: JsonField<List<TemplateVariable>> = JsonMissing.of(),
    ) : this(template, type, variables, mutableMapOf())

    /**
     * The footer template text with optional variable placeholders
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun template(): Optional<String> = template.getOptional("template")

    /**
     * The type of footer (typically "text")
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * List of variables used in the footer template
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun variables(): Optional<List<TemplateVariable>> = variables.getOptional("variables")

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
         * Returns a mutable builder for constructing an instance of
         * [SentDmServicesCommonContractsPocOsTemplateFooter].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SentDmServicesCommonContractsPocOsTemplateFooter]. */
    class Builder internal constructor() {

        private var template: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var variables: JsonField<MutableList<TemplateVariable>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesCommonContractsPocOsTemplateFooter:
                SentDmServicesCommonContractsPocOsTemplateFooter
        ) = apply {
            template = sentDmServicesCommonContractsPocOsTemplateFooter.template
            type = sentDmServicesCommonContractsPocOsTemplateFooter.type
            variables =
                sentDmServicesCommonContractsPocOsTemplateFooter.variables.map {
                    it.toMutableList()
                }
            additionalProperties =
                sentDmServicesCommonContractsPocOsTemplateFooter.additionalProperties.toMutableMap()
        }

        /** The footer template text with optional variable placeholders */
        fun template(template: String) = template(JsonField.of(template))

        /**
         * Sets [Builder.template] to an arbitrary JSON value.
         *
         * You should usually call [Builder.template] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun template(template: JsonField<String>) = apply { this.template = template }

        /** The type of footer (typically "text") */
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

        /** List of variables used in the footer template */
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
         * Returns an immutable instance of [SentDmServicesCommonContractsPocOsTemplateFooter].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SentDmServicesCommonContractsPocOsTemplateFooter =
            SentDmServicesCommonContractsPocOsTemplateFooter(
                template,
                type,
                (variables ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesCommonContractsPocOsTemplateFooter = apply {
        if (validated) {
            return@apply
        }

        template()
        type()
        variables().ifPresent { it.forEach { it.validate() } }
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
        (if (template.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (variables.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SentDmServicesCommonContractsPocOsTemplateFooter &&
            template == other.template &&
            type == other.type &&
            variables == other.variables &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(template, type, variables, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesCommonContractsPocOsTemplateFooter{template=$template, type=$type, variables=$variables, additionalProperties=$additionalProperties}"
}
