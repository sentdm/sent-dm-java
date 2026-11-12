// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

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

class MessageButton
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val postbackData: JsonField<String>,
    private val text: JsonField<String>,
    private val type: JsonField<String>,
    private val value: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("postbackData")
        @ExcludeMissing
        postbackData: JsonField<String> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
        @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
    ) : this(postbackData, text, type, value, mutableMapOf())

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun postbackData(): Optional<String> = postbackData.getOptional("postbackData")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun text(): Optional<String> = text.getOptional("text")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun type(): Optional<String> = type.getOptional("type")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun value(): Optional<String> = value.getOptional("value")

    /**
     * Returns the raw JSON value of [postbackData].
     *
     * Unlike [postbackData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("postbackData")
    @ExcludeMissing
    fun _postbackData(): JsonField<String> = postbackData

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

    /**
     * Returns the raw JSON value of [value].
     *
     * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

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

        /** Returns a mutable builder for constructing an instance of [MessageButton]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageButton]. */
    class Builder internal constructor() {

        private var postbackData: JsonField<String> = JsonMissing.of()
        private var text: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var value: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageButton: MessageButton) = apply {
            postbackData = messageButton.postbackData
            text = messageButton.text
            type = messageButton.type
            value = messageButton.value
            additionalProperties = messageButton.additionalProperties.toMutableMap()
        }

        fun postbackData(postbackData: String?) = postbackData(JsonField.ofNullable(postbackData))

        /** Alias for calling [Builder.postbackData] with `postbackData.orElse(null)`. */
        fun postbackData(postbackData: Optional<String>) = postbackData(postbackData.getOrNull())

        /**
         * Sets [Builder.postbackData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.postbackData] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun postbackData(postbackData: JsonField<String>) = apply {
            this.postbackData = postbackData
        }

        fun text(text: String?) = text(JsonField.ofNullable(text))

        /** Alias for calling [Builder.text] with `text.orElse(null)`. */
        fun text(text: Optional<String>) = text(text.getOrNull())

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        fun type(type: String) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<String>) = apply { this.type = type }

        fun value(value: String) = value(JsonField.of(value))

        /**
         * Sets [Builder.value] to an arbitrary JSON value.
         *
         * You should usually call [Builder.value] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun value(value: JsonField<String>) = apply { this.value = value }

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
         * Returns an immutable instance of [MessageButton].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageButton =
            MessageButton(postbackData, text, type, value, additionalProperties.toMutableMap())
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
    fun validate(): MessageButton = apply {
        if (validated) {
            return@apply
        }

        postbackData()
        text()
        type()
        value()
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
        (if (postbackData.asKnown().isPresent) 1 else 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            (if (type.asKnown().isPresent) 1 else 0) +
            (if (value.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageButton &&
            postbackData == other.postbackData &&
            text == other.text &&
            type == other.type &&
            value == other.value &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(postbackData, text, type, value, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageButton{postbackData=$postbackData, text=$text, type=$type, value=$value, additionalProperties=$additionalProperties}"
}
