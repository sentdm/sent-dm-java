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
import dm.sent.errors.SentInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** One attachment on an MMS template body. */
class TemplateMediaItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val mediaType: JsonField<String>,
    private val url: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("mediaType") @ExcludeMissing mediaType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
    ) : this(mediaType, url, mutableMapOf())

    /**
     * One of MmsMediaTypes. Advisory: the carrier reads the Content-Type off the fetched object,
     * not this field. It exists so an authoring UI can render the right preview and so a reviewer
     * can see what was intended.
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun mediaType(): Optional<String> = mediaType.getOptional("mediaType")

    /**
     * Publicly fetchable https URL. The carrier's MMSC fetches this at send time, so it has to stay
     * reachable and unauthenticated for the life of the send — including retries and a DLQ replay —
     * which is why a presigned URL is not a valid value here.
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

        /** Returns a mutable builder for constructing an instance of [TemplateMediaItem]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateMediaItem]. */
    class Builder internal constructor() {

        private var mediaType: JsonField<String> = JsonMissing.of()
        private var url: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(templateMediaItem: TemplateMediaItem) = apply {
            mediaType = templateMediaItem.mediaType
            url = templateMediaItem.url
            additionalProperties = templateMediaItem.additionalProperties.toMutableMap()
        }

        /**
         * One of MmsMediaTypes. Advisory: the carrier reads the Content-Type off the fetched
         * object, not this field. It exists so an authoring UI can render the right preview and so
         * a reviewer can see what was intended.
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

        /**
         * Publicly fetchable https URL. The carrier's MMSC fetches this at send time, so it has to
         * stay reachable and unauthenticated for the life of the send — including retries and a DLQ
         * replay — which is why a presigned URL is not a valid value here.
         */
        fun url(url: String) = url(JsonField.of(url))

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
         * Returns an immutable instance of [TemplateMediaItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateMediaItem =
            TemplateMediaItem(mediaType, url, additionalProperties.toMutableMap())
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
    fun validate(): TemplateMediaItem = apply {
        if (validated) {
            return@apply
        }

        mediaType()
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
        (if (mediaType.asKnown().isPresent) 1 else 0) + (if (url.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateMediaItem &&
            mediaType == other.mediaType &&
            url == other.url &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(mediaType, url, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TemplateMediaItem{mediaType=$mediaType, url=$url, additionalProperties=$additionalProperties}"
}
