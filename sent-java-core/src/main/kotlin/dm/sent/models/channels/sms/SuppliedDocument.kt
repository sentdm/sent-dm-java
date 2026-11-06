// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

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

/** A document a market asked for and has been given. */
class SuppliedDocument
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val documentId: JsonField<String>,
    private val fileName: JsonField<String>,
    private val key: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("document_id")
        @ExcludeMissing
        documentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("file_name") @ExcludeMissing fileName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
    ) : this(documentId, fileName, key, mutableMapOf())

    /**
     * Identifier of the upload, for fetching it back through the documents endpoints.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun documentId(): Optional<String> = documentId.getOptional("document_id")

    /**
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun fileName(): Optional<String> = fileName.getOptional("file_name")

    /**
     * The catalog's name for this document, matching the requirement it satisfies.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun key(): Optional<String> = key.getOptional("key")

    /**
     * Returns the raw JSON value of [documentId].
     *
     * Unlike [documentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("document_id") @ExcludeMissing fun _documentId(): JsonField<String> = documentId

    /**
     * Returns the raw JSON value of [fileName].
     *
     * Unlike [fileName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

    /**
     * Returns the raw JSON value of [key].
     *
     * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

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

        /** Returns a mutable builder for constructing an instance of [SuppliedDocument]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SuppliedDocument]. */
    class Builder internal constructor() {

        private var documentId: JsonField<String> = JsonMissing.of()
        private var fileName: JsonField<String> = JsonMissing.of()
        private var key: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(suppliedDocument: SuppliedDocument) = apply {
            documentId = suppliedDocument.documentId
            fileName = suppliedDocument.fileName
            key = suppliedDocument.key
            additionalProperties = suppliedDocument.additionalProperties.toMutableMap()
        }

        /** Identifier of the upload, for fetching it back through the documents endpoints. */
        fun documentId(documentId: String?) = documentId(JsonField.ofNullable(documentId))

        /** Alias for calling [Builder.documentId] with `documentId.orElse(null)`. */
        fun documentId(documentId: Optional<String>) = documentId(documentId.getOrNull())

        /**
         * Sets [Builder.documentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.documentId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun documentId(documentId: JsonField<String>) = apply { this.documentId = documentId }

        fun fileName(fileName: String?) = fileName(JsonField.ofNullable(fileName))

        /** Alias for calling [Builder.fileName] with `fileName.orElse(null)`. */
        fun fileName(fileName: Optional<String>) = fileName(fileName.getOrNull())

        /**
         * Sets [Builder.fileName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

        /** The catalog's name for this document, matching the requirement it satisfies. */
        fun key(key: String) = key(JsonField.of(key))

        /**
         * Sets [Builder.key] to an arbitrary JSON value.
         *
         * You should usually call [Builder.key] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun key(key: JsonField<String>) = apply { this.key = key }

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
         * Returns an immutable instance of [SuppliedDocument].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SuppliedDocument =
            SuppliedDocument(documentId, fileName, key, additionalProperties.toMutableMap())
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
    fun validate(): SuppliedDocument = apply {
        if (validated) {
            return@apply
        }

        documentId()
        fileName()
        key()
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
        (if (documentId.asKnown().isPresent) 1 else 0) +
            (if (fileName.asKnown().isPresent) 1 else 0) +
            (if (key.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SuppliedDocument &&
            documentId == other.documentId &&
            fileName == other.fileName &&
            key == other.key &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(documentId, fileName, key, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SuppliedDocument{documentId=$documentId, fileName=$fileName, key=$key, additionalProperties=$additionalProperties}"
}
