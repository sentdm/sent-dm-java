// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import dm.sent.core.ExcludeMissing
import dm.sent.core.JsonField
import dm.sent.core.JsonMissing
import dm.sent.core.JsonValue
import dm.sent.errors.SentInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** A short-lived link to a call recording */
class CallRecording
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val downloadUrl: JsonField<String>,
    private val recordingId: JsonField<String>,
    private val urlExpiresAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("download_url")
        @ExcludeMissing
        downloadUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recording_id")
        @ExcludeMissing
        recordingId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("url_expires_at")
        @ExcludeMissing
        urlExpiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(downloadUrl, recordingId, urlExpiresAt, mutableMapOf())

    /**
     * A pre-signed link that downloads the recording as an MP3 file. Anyone holding it can download
     * the recording until it expires
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun downloadUrl(): Optional<String> = downloadUrl.getOptional("download_url")

    /**
     * The recording's id, the one the call.recording_ready webhook announced it under
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun recordingId(): Optional<String> = recordingId.getOptional("recording_id")

    /**
     * When the link stops working (UTC). Request the recordings again for a fresh link
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun urlExpiresAt(): Optional<OffsetDateTime> = urlExpiresAt.getOptional("url_expires_at")

    /**
     * Returns the raw JSON value of [downloadUrl].
     *
     * Unlike [downloadUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("download_url")
    @ExcludeMissing
    fun _downloadUrl(): JsonField<String> = downloadUrl

    /**
     * Returns the raw JSON value of [recordingId].
     *
     * Unlike [recordingId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recording_id")
    @ExcludeMissing
    fun _recordingId(): JsonField<String> = recordingId

    /**
     * Returns the raw JSON value of [urlExpiresAt].
     *
     * Unlike [urlExpiresAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("url_expires_at")
    @ExcludeMissing
    fun _urlExpiresAt(): JsonField<OffsetDateTime> = urlExpiresAt

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

        /** Returns a mutable builder for constructing an instance of [CallRecording]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CallRecording]. */
    class Builder internal constructor() {

        private var downloadUrl: JsonField<String> = JsonMissing.of()
        private var recordingId: JsonField<String> = JsonMissing.of()
        private var urlExpiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(callRecording: CallRecording) = apply {
            downloadUrl = callRecording.downloadUrl
            recordingId = callRecording.recordingId
            urlExpiresAt = callRecording.urlExpiresAt
            additionalProperties = callRecording.additionalProperties.toMutableMap()
        }

        /**
         * A pre-signed link that downloads the recording as an MP3 file. Anyone holding it can
         * download the recording until it expires
         */
        fun downloadUrl(downloadUrl: String) = downloadUrl(JsonField.of(downloadUrl))

        /**
         * Sets [Builder.downloadUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.downloadUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun downloadUrl(downloadUrl: JsonField<String>) = apply { this.downloadUrl = downloadUrl }

        /** The recording's id, the one the call.recording_ready webhook announced it under */
        fun recordingId(recordingId: String) = recordingId(JsonField.of(recordingId))

        /**
         * Sets [Builder.recordingId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recordingId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun recordingId(recordingId: JsonField<String>) = apply { this.recordingId = recordingId }

        /** When the link stops working (UTC). Request the recordings again for a fresh link */
        fun urlExpiresAt(urlExpiresAt: OffsetDateTime) = urlExpiresAt(JsonField.of(urlExpiresAt))

        /**
         * Sets [Builder.urlExpiresAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.urlExpiresAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun urlExpiresAt(urlExpiresAt: JsonField<OffsetDateTime>) = apply {
            this.urlExpiresAt = urlExpiresAt
        }

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
         * Returns an immutable instance of [CallRecording].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CallRecording =
            CallRecording(
                downloadUrl,
                recordingId,
                urlExpiresAt,
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
    fun validate(): CallRecording = apply {
        if (validated) {
            return@apply
        }

        downloadUrl()
        recordingId()
        urlExpiresAt()
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
        (if (downloadUrl.asKnown().isPresent) 1 else 0) +
            (if (recordingId.asKnown().isPresent) 1 else 0) +
            (if (urlExpiresAt.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallRecording &&
            downloadUrl == other.downloadUrl &&
            recordingId == other.recordingId &&
            urlExpiresAt == other.urlExpiresAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(downloadUrl, recordingId, urlExpiresAt, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CallRecording{downloadUrl=$downloadUrl, recordingId=$recordingId, urlExpiresAt=$urlExpiresAt, additionalProperties=$additionalProperties}"
}
