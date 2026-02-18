// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands

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

class DestinationCountry
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val isMain: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("isMain") @ExcludeMissing isMain: JsonField<Boolean> = JsonMissing.of(),
    ) : this(id, isMain, mutableMapOf())

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isMain(): Optional<Boolean> = isMain.getOptional("isMain")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [isMain].
     *
     * Unlike [isMain], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("isMain") @ExcludeMissing fun _isMain(): JsonField<Boolean> = isMain

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

        /** Returns a mutable builder for constructing an instance of [DestinationCountry]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DestinationCountry]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var isMain: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(destinationCountry: DestinationCountry) = apply {
            id = destinationCountry.id
            isMain = destinationCountry.isMain
            additionalProperties = destinationCountry.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun isMain(isMain: Boolean) = isMain(JsonField.of(isMain))

        /**
         * Sets [Builder.isMain] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isMain] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isMain(isMain: JsonField<Boolean>) = apply { this.isMain = isMain }

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
         * Returns an immutable instance of [DestinationCountry].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DestinationCountry =
            DestinationCountry(id, isMain, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): DestinationCountry = apply {
        if (validated) {
            return@apply
        }

        id()
        isMain()
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
        (if (id.asKnown().isPresent) 1 else 0) + (if (isMain.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DestinationCountry &&
            id == other.id &&
            isMain == other.isMain &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(id, isMain, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DestinationCountry{id=$id, isMain=$isMain, additionalProperties=$additionalProperties}"
}
