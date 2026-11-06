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

/**
 * One attachment on a message, in either direction — and in both, a URL somebody else hosts.
 *
 * Outbound: the customer supplied a public URL and we handed it to the carrier. Inbound: the
 * carrier hosts the file and we record where. sent.dm never holds the bytes, so there is no key, no
 * expiry bookkeeping and nothing minted per read — what is stored is what is served.
 *
 * An inbound link expires on the carrier's own schedule and is unauthenticated. That is the
 * customer's to manage, and it is documented where they will see it rather than only here — a
 * recipient who needs an attachment to outlive that window copies it on receipt.
 *
 * Storing a presigned URL is the specific mistake this shape still avoids: M260826130000 and
 * M260826140000 exist because RCS assets were stored as signed URLs and went stale. Nothing here is
 * signed.
 */
class MessageMedia
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val mediaType: JsonField<String>,
    private val mimeType: JsonField<String>,
    private val sizeBytes: JsonField<Long>,
    private val sourceHashSha256: JsonField<String>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("mediaType") @ExcludeMissing mediaType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("mimeType") @ExcludeMissing mimeType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sizeBytes") @ExcludeMissing sizeBytes: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("sourceHashSha256")
        @ExcludeMissing
        sourceHashSha256: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(mediaType, mimeType, sizeBytes, sourceHashSha256, url, mutableMapOf())

    /**
     * One of MmsMediaTypes when the content type is known. Advisory — a reader should trust the
     * fetched object's own Content-Type.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mediaType(): Optional<String> = mediaType.getOptional("mediaType")

    /**
     * Content type as the provider declared it. Null when it declared none.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mimeType(): Optional<String> = mimeType.getOptional("mimeType")

    /**
     * Size as the provider declared it. Never measured here — nothing downloads the file.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sizeBytes(): Optional<Long> = sizeBytes.getOptional("sizeBytes")

    /**
     * Inbound only: the SHA-256 the provider declared alongside the attachment, when it declared
     * one. Relayed to the customer so they can verify what they fetch matches what the carrier said
     * it sent. It is the only integrity signal available on an attachment nobody here has read.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun sourceHashSha256(): Optional<String> = sourceHashSha256.getOptional("sourceHashSha256")

    /**
     * Where the file lives. Outbound: the URL the customer gave us and the carrier fetched.
     * Inbound: the URL the carrier hosts it at, relayed unchanged.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun url(): Optional<String> = url.getOptional("url")

    /**
     * Returns the raw JSON value of [mediaType].
     *
     * Unlike [mediaType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mediaType") @ExcludeMissing fun _mediaType(): JsonField<String> = mediaType

    /**
     * Returns the raw JSON value of [mimeType].
     *
     * Unlike [mimeType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mimeType") @ExcludeMissing fun _mimeType(): JsonField<String> = mimeType

    /**
     * Returns the raw JSON value of [sizeBytes].
     *
     * Unlike [sizeBytes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sizeBytes") @ExcludeMissing fun _sizeBytes(): JsonField<Long> = sizeBytes

    /**
     * Returns the raw JSON value of [sourceHashSha256].
     *
     * Unlike [sourceHashSha256], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("sourceHashSha256")
    @ExcludeMissing
    fun _sourceHashSha256(): JsonField<String> = sourceHashSha256

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

        /** Returns a mutable builder for constructing an instance of [MessageMedia]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageMedia]. */
    class Builder internal constructor() {

        private var mediaType: JsonField<String> = JsonMissing.of()
        private var mimeType: JsonField<String> = JsonMissing.of()
        private var sizeBytes: JsonField<Long> = JsonMissing.of()
        private var sourceHashSha256: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageMedia: MessageMedia) = apply {
            mediaType = messageMedia.mediaType
            mimeType = messageMedia.mimeType
            sizeBytes = messageMedia.sizeBytes
            sourceHashSha256 = messageMedia.sourceHashSha256
            url = messageMedia.url
            additionalProperties = messageMedia.additionalProperties.toMutableMap()
        }

        /**
         * One of MmsMediaTypes when the content type is known. Advisory — a reader should trust the
         * fetched object's own Content-Type.
         */
        fun mediaType(mediaType: String?) = mediaType(JsonField.ofNullable(mediaType))

        /** Alias for calling [Builder.mediaType] with `mediaType.orElse(null)`. */
        fun mediaType(mediaType: Optional<String>) = mediaType(mediaType.getOrNull())

        /**
         * Sets [Builder.mediaType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediaType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun mediaType(mediaType: JsonField<String>) = apply { this.mediaType = mediaType }

        /** Content type as the provider declared it. Null when it declared none. */
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

        /** Size as the provider declared it. Never measured here — nothing downloads the file. */
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
         * Inbound only: the SHA-256 the provider declared alongside the attachment, when it
         * declared one. Relayed to the customer so they can verify what they fetch matches what the
         * carrier said it sent. It is the only integrity signal available on an attachment nobody
         * here has read.
         */
        fun sourceHashSha256(sourceHashSha256: String?) =
            sourceHashSha256(JsonField.ofNullable(sourceHashSha256))

        /** Alias for calling [Builder.sourceHashSha256] with `sourceHashSha256.orElse(null)`. */
        fun sourceHashSha256(sourceHashSha256: Optional<String>) =
            sourceHashSha256(sourceHashSha256.getOrNull())

        /**
         * Sets [Builder.sourceHashSha256] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceHashSha256] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceHashSha256(sourceHashSha256: JsonField<String>) = apply {
            this.sourceHashSha256 = sourceHashSha256
        }

        /**
         * Where the file lives. Outbound: the URL the customer gave us and the carrier fetched.
         * Inbound: the URL the carrier hosts it at, relayed unchanged.
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
         * Returns an immutable instance of [MessageMedia].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MessageMedia =
            MessageMedia(
                mediaType,
                mimeType,
                sizeBytes,
                sourceHashSha256,
                url,
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
    fun validate(): MessageMedia = apply {
        if (validated) {
            return@apply
        }

        mediaType()
        mimeType()
        sizeBytes()
        sourceHashSha256()
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
        (if (mediaType.asKnown().isPresent) 1 else 0) +
            (if (mimeType.asKnown().isPresent) 1 else 0) +
            (if (sizeBytes.asKnown().isPresent) 1 else 0) +
            (if (sourceHashSha256.asKnown().isPresent) 1 else 0) +
            (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageMedia &&
            mediaType == other.mediaType &&
            mimeType == other.mimeType &&
            sizeBytes == other.sizeBytes &&
            sourceHashSha256 == other.sourceHashSha256 &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(mediaType, mimeType, sizeBytes, sourceHashSha256, url, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageMedia{mediaType=$mediaType, mimeType=$mimeType, sizeBytes=$sizeBytes, sourceHashSha256=$sourceHashSha256, url=$url, additionalProperties=$additionalProperties}"
}
