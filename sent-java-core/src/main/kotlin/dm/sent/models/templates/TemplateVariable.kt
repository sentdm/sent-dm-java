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
    private val props: JsonField<TemplateVariableProps>,
    private val type: JsonField<String>,
    private val id: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("props")
        @ExcludeMissing
        props: JsonField<TemplateVariableProps> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
    ) : this(name, props, type, id, mutableMapOf())

    /**
     * The variable's name, and the key callers use for it in a send request's parameters object.
     * Must start with a letter and hold only letters, digits and underscores.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun props(): TemplateVariableProps = props.getRequired("props")

    /**
     * One of variable, link or media. Decides which Props fields are required.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * The variable's index, and the number its {{index:variable}} placeholder refers to.
     *
     * Omitting it is only safe for a section holding a single variable. The field is a non-nullable
     * int, so every variable that leaves it out defaults to 0, and a section with two such
     * variables is refused by the unique-id rule ("variables must have unique IDs"). Number them
     * from 0 in the order they appear.
     *
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
    @JsonProperty("props") @ExcludeMissing fun _props(): JsonField<TemplateVariableProps> = props

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
        private var props: JsonField<TemplateVariableProps>? = null
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

        /**
         * The variable's name, and the key callers use for it in a send request's parameters
         * object. Must start with a letter and hold only letters, digits and underscores.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        fun props(props: TemplateVariableProps) = props(JsonField.of(props))

        /**
         * Sets [Builder.props] to an arbitrary JSON value.
         *
         * You should usually call [Builder.props] with a well-typed [TemplateVariableProps] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun props(props: JsonField<TemplateVariableProps>) = apply { this.props = props }

        /** One of variable, link or media. Decides which Props fields are required. */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /**
         * The variable's index, and the number its {{index:variable}} placeholder refers to.
         *
         * Omitting it is only safe for a section holding a single variable. The field is a
         * non-nullable int, so every variable that leaves it out defaults to 0, and a section with
         * two such variables is refused by the unique-id rule ("variables must have unique IDs").
         * Number them from 0 in the order they appear.
         */
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

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws SentInvalidDataException if any value type in this object doesn't match its expected
     *   type.
     */
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
