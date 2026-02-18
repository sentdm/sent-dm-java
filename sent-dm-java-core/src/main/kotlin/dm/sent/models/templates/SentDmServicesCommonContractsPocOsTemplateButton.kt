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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Interactive button in a message template */
class SentDmServicesCommonContractsPocOsTemplateButton
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<Int>,
    private val props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps>,
    private val type: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("props")
        @ExcludeMissing
        props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
    ) : this(id, props, type, mutableMapOf())

    /**
     * The unique identifier of the button (1-based index)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<Int> = id.getOptional("id")

    /**
     * Properties specific to the button type
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun props(): Optional<SentDmServicesCommonContractsPocOsTemplateButtonProps> =
        props.getOptional("props")

    /**
     * The type of button (e.g., QUICK_REPLY, URL, PHONE_NUMBER, VOICE_CALL, COPY_CODE)
     *
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
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SentDmServicesCommonContractsPocOsTemplateButton]. */
    class Builder internal constructor() {

        private var id: JsonField<Int> = JsonMissing.of()
        private var props: JsonField<SentDmServicesCommonContractsPocOsTemplateButtonProps> =
            JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            sentDmServicesCommonContractsPocOsTemplateButton:
                SentDmServicesCommonContractsPocOsTemplateButton
        ) = apply {
            id = sentDmServicesCommonContractsPocOsTemplateButton.id
            props = sentDmServicesCommonContractsPocOsTemplateButton.props
            type = sentDmServicesCommonContractsPocOsTemplateButton.type
            additionalProperties =
                sentDmServicesCommonContractsPocOsTemplateButton.additionalProperties.toMutableMap()
        }

        /** The unique identifier of the button (1-based index) */
        fun id(id: Int) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<Int>) = apply { this.id = id }

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
         */
        fun build(): SentDmServicesCommonContractsPocOsTemplateButton =
            SentDmServicesCommonContractsPocOsTemplateButton(
                id,
                props,
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SentDmServicesCommonContractsPocOsTemplateButton = apply {
        if (validated) {
            return@apply
        }

        id()
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
            (props.asKnown().getOrNull()?.validity() ?: 0) +
            (if (type.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SentDmServicesCommonContractsPocOsTemplateButton &&
            id == other.id &&
            props == other.props &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, props, type, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SentDmServicesCommonContractsPocOsTemplateButton{id=$id, props=$props, type=$type, additionalProperties=$additionalProperties}"
}
