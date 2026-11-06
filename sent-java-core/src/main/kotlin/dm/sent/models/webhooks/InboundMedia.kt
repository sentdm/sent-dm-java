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

/** One attachment on an inbound message. */
class InboundMedia
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val hashSha256: JsonField<String>,
    private val mimeType: JsonField<String>,
    private val sizeBytes: JsonField<Long>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("hash_sha256")
        @ExcludeMissing
        hashSha256: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mime_type") @ExcludeMissing mimeType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("size_bytes") @ExcludeMissing sizeBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(hashSha256, mimeType, sizeBytes, url, mutableMapOf())

    /**
     * SHA-256 of the file as the carrier declared it, when it declares one. Verify what you
     * download against this — sent.dm never reads the bytes, so it is the only integrity signal
     * available.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun hashSha256(): Optional<String> = hashSha256.getOptional("hash_sha256")

    /**
     * Content type as the carrier reported it, for example image/jpeg.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mimeType(): Optional<String> = mimeType.getOptional("mime_type")

    /**
     * Size in bytes as the carrier declared it. Absent when it declared none.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sizeBytes(): Optional<Long> = sizeBytes.getOptional("size_bytes")

    /**
     * Where the carrier hosts the attachment.
     *
     * This link expires and is not authenticated. sent.dm relays it rather than copying the file,
     * so how long it stays fetchable is the carrier's decision and differs between them — assume
     * days, not months. Anyone holding the URL can fetch it until it lapses. Copy the file on
     * receipt if you need it to outlive that window; do not store this URL as a permanent
     * reference.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [hashSha256].
     *
     * Unlike [hashSha256], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("hash_sha256") @ExcludeMissing fun _hashSha256(): JsonField<String> = hashSha256

    /**
     * Returns the raw JSON value of [mimeType].
     *
     * Unlike [mimeType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mime_type") @ExcludeMissing fun _mimeType(): JsonField<String> = mimeType

    /**
     * Returns the raw JSON value of [sizeBytes].
     *
     * Unlike [sizeBytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("size_bytes") @ExcludeMissing fun _sizeBytes(): JsonField<Long> = sizeBytes

    /**
     * Returns the raw JSON value of [url].
     *
     * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

        /** Returns a mutable builder for constructing an instance of [InboundMedia]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboundMedia]. */
    class Builder internal constructor() {

        private var hashSha256: JsonField<String> = JsonMissing.of()
        private var mimeType: JsonField<String> = JsonMissing.of()
        private var sizeBytes: JsonField<Long> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboundMedia: InboundMedia) = apply {
            hashSha256 = inboundMedia.hashSha256
            mimeType = inboundMedia.mimeType
            sizeBytes = inboundMedia.sizeBytes
            url = inboundMedia.url
            additionalProperties = inboundMedia.additionalProperties.toMutableMap()
        }

        /**
         * SHA-256 of the file as the carrier declared it, when it declares one. Verify what you
         * download against this — sent.dm never reads the bytes, so it is the only integrity signal
         * available.
         */
        fun hashSha256(hashSha256: String?) = hashSha256(JsonField.ofNullable(hashSha256))

        /** Alias for calling [Builder.hashSha256] with `hashSha256.orElse(null)`. */
        fun hashSha256(hashSha256: Optional<String>) = hashSha256(hashSha256.getOrNull())

        /**
         * Sets [Builder.hashSha256] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hashSha256] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hashSha256(hashSha256: JsonField<String>) = apply { this.hashSha256 = hashSha256 }

        /** Content type as the carrier reported it, for example image/jpeg. */
        fun mimeType(mimeType: String?) = mimeType(JsonField.ofNullable(mimeType))

        /** Alias for calling [Builder.mimeType] with `mimeType.orElse(null)`. */
        fun mimeType(mimeType: Optional<String>) = mimeType(mimeType.getOrNull())

        /**
         * Sets [Builder.mimeType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mimeType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mimeType(mimeType: JsonField<String>) = apply { this.mimeType = mimeType }

        /** Size in bytes as the carrier declared it. Absent when it declared none. */
        fun sizeBytes(sizeBytes: Long?) = sizeBytes(JsonField.ofNullable(sizeBytes))

        /**
         * Alias for [Builder.sizeBytes].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun sizeBytes(sizeBytes: Long) = sizeBytes(sizeBytes as Long?)

        /** Alias for calling [Builder.sizeBytes] with `sizeBytes.orElse(null)`. */
        fun sizeBytes(sizeBytes: Optional<Long>) = sizeBytes(sizeBytes.getOrNull())

        /**
         * Sets [Builder.sizeBytes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sizeBytes] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sizeBytes(sizeBytes: JsonField<Long>) = apply { this.sizeBytes = sizeBytes }

        /**
         * Where the carrier hosts the attachment.
         *
         * This link expires and is not authenticated. sent.dm relays it rather than copying the
         * file, so how long it stays fetchable is the carrier's decision and differs between them —
         * assume days, not months. Anyone holding the URL can fetch it until it lapses. Copy the
         * file on receipt if you need it to outlive that window; do not store this URL as a
         * permanent reference.
         */
        fun url(url: String?) = url(JsonField.ofNullable(url))

        /** Alias for calling [Builder.url] with `url.orElse(null)`. */
        fun url(url: Optional<String>) = url(url.getOrNull())

        /**
         * Sets [Builder.url] to an arbitrary JSON value.
         *
         * You should usually call [Builder.url] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun url(url: JsonField<String>) = apply { this.url = url }

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
         * Returns an immutable instance of [InboundMedia].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InboundMedia =
            InboundMedia(hashSha256, mimeType, sizeBytes, url, additionalProperties.toMutableMap())
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
    fun validate(): InboundMedia = apply {
        if (validated) {
            return@apply
        }

        hashSha256()
        mimeType()
        sizeBytes()
        url()
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
        (if (hashSha256.asKnown().isPresent) 1 else 0) +
            (if (mimeType.asKnown().isPresent) 1 else 0) +
            (if (sizeBytes.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboundMedia &&
            hashSha256 == other.hashSha256 &&
            mimeType == other.mimeType &&
            sizeBytes == other.sizeBytes &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(hashSha256, mimeType, sizeBytes, url, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboundMedia{hashSha256=$hashSha256, mimeType=$mimeType, sizeBytes=$sizeBytes, url=$url, additionalProperties=$additionalProperties}"
}
