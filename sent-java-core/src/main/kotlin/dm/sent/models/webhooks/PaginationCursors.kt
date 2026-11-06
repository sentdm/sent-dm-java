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
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Cursor-based pagination. Never populated — see Cursors. */
@Deprecated("deprecated")
class PaginationCursors
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val after: JsonField<String>,
    private val before: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("after") @ExcludeMissing after: JsonField<String> = JsonMissing.of(),
        @JsonProperty("before") @ExcludeMissing before: JsonField<String> = JsonMissing.of(),
    ) : this(after, before, mutableMapOf())

    /**
     * Cursor to fetch the next page.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun after(): Optional<String> = after.getOptional("after")

    /**
     * Cursor to fetch the previous page.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun before(): Optional<String> = before.getOptional("before")

    /**
     * Returns the raw JSON value of [after].
     *
     * Unlike [after], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("after") @ExcludeMissing fun _after(): JsonField<String> = after

    /**
     * Returns the raw JSON value of [before].
     *
     * Unlike [before], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("before") @ExcludeMissing fun _before(): JsonField<String> = before

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

        /** Returns a mutable builder for constructing an instance of [PaginationCursors]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PaginationCursors]. */
    class Builder internal constructor() {

        private var after: JsonField<String> = JsonMissing.of()
        private var before: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paginationCursors: PaginationCursors) = apply {
            after = paginationCursors.after
            before = paginationCursors.before
            additionalProperties = paginationCursors.additionalProperties.toMutableMap()
        }

        /** Cursor to fetch the next page. */
        fun after(after: String?) = after(JsonField.ofNullable(after))

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /**
         * Sets [Builder.after] to an arbitrary JSON value.
         *
         * You should usually call [Builder.after] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun after(after: JsonField<String>) = apply { this.after = after }

        /** Cursor to fetch the previous page. */
        fun before(before: String?) = before(JsonField.ofNullable(before))

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /**
         * Sets [Builder.before] to an arbitrary JSON value.
         *
         * You should usually call [Builder.before] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun before(before: JsonField<String>) = apply { this.before = before }

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
         * Returns an immutable instance of [PaginationCursors].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): PaginationCursors =
            PaginationCursors(after, before, additionalProperties.toMutableMap())
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
    fun validate(): PaginationCursors = apply {
        if (validated) {
            return@apply
        }

        after()
        before()
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
        (if (after.asKnown().isPresent) 1 else 0) + (if (before.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaginationCursors &&
            after == other.after &&
            before == other.before &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(after, before, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaginationCursors{after=$after, before=$before, additionalProperties=$additionalProperties}"
}
