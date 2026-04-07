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

/** Interactive button in a message template */
class SentDmServicesCommonContractsPocOsTemplateButton
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps>,
    private val type: JsonField<String>,
    private val id: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("props")
        @ExcludeMissing
        props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
    ) : this(props, type, id, mutableMapOf())

    /**
     * Properties specific to the button type
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun props(): SentDmServicesCommonContractsPocOsTemplateButtonProps = props.getRequired("props")

    /**
     * The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): String = type.getRequired("type")

    /**
     * The unique identifier of the button (1-based index)
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<Int> = id.getOptional("id")

    /**
     * Returns the raw JSON value of [props].
     *
     * Unlike [props], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("props")
    @ExcludeMissing
    fun _props(): JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps> = props

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
         * Returns a mutable builder for constructing an instance of
         * [SentDmServicesCommonContractsPocOsTemplateButton].
         *
         * The following fields are required:
         * ```java
         * .props()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SentDmServicesCommonContractsPocOsTemplateButton]. */
    class Builder internal constructor() {

        private var props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps>? = null
        private var type: JsonField<String>? = null
        private var id: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesCommonContractsPocOsTemplateButton:
                SentDmServicesCommonContractsPocOsTemplateButton
        ) = apply {
            props = sentDmServicesCommonContractsPocOsTemplateButton.props
            type = sentDmServicesCommonContractsPocOsTemplateButton.type
            id = sentDmServicesCommonContractsPocOsTemplateButton.id
            additionalProperties =
                sentDmServicesCommonContractsPocOsTemplateButton.additionalProperties.toMutableMap()
        }

        /** Properties specific to the button type */
        fun props(props: SentDmServicesCommonContractsPocOsTemplateButtonProps) =
            props(JsonField.of(props))

        /**
         * Sets [Builder.props] to an arbitrary JSON value.
         *
         * You should usually call [Builder.props] with a well-typed
         * [SentDmServicesCommonContractsPocOsTemplateButtonProps] value instead. This method is
         * primarily for setting the field to an undocumented or not yet supported value.
         */
        fun props(props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps>) = apply {
            this.props = props
        }

        /** The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE) */
        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** The unique identifier of the button (1-based index) */
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
         * Returns an immutable instance of [SentDmServicesCommonContractsPocOsTemplateButton].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .props()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SentDmServicesCommonContractsPocOsTemplateButton =
            SentDmServicesCommonContractsPocOsTemplateButton(
                checkRequired("props", props),
                checkRequired("type", type),
                id,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesCommonContractsPocOsTemplateButton = apply {
        if (validated) {
            return@apply
        }

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
        (props.asKnown().getOrNull()?.validity() ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (id.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SentDmServicesCommonContractsPocOsTemplateButton &&
            props == other.props &&
            type == other.type &&
            id == other.id &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(props, type, id, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesCommonContractsPocOsTemplateButton{props=$props, type=$type, id=$id, additionalProperties=$additionalProperties}"
}
