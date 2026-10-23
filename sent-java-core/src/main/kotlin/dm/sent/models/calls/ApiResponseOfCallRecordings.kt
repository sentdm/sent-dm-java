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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class ApiResponseOfCallRecordings
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<ErrorDetail>,
    private val meta: JsonField<ApiMeta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<ErrorDetail> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<ApiMeta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * The recordings of a call, each as a short-lived download link
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * Error information
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun error(): Optional<ErrorDetail> = error.getOptional("error")

    /**
     * Request and response metadata
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun meta(): Optional<ApiMeta> = meta.getOptional("meta")

    /**
     * Indicates whether the request was successful
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun success(): Optional<Boolean> = success.getOptional("success")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<ErrorDetail> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<ApiMeta> = meta

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

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
         * Returns a mutable builder for constructing an instance of [ApiResponseOfCallRecordings].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiResponseOfCallRecordings]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<ErrorDetail> = JsonMissing.of()
        private var meta: JsonField<ApiMeta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(apiResponseOfCallRecordings: ApiResponseOfCallRecordings) = apply {
            data = apiResponseOfCallRecordings.data
            error = apiResponseOfCallRecordings.error
            meta = apiResponseOfCallRecordings.meta
            success = apiResponseOfCallRecordings.success
            additionalProperties = apiResponseOfCallRecordings.additionalProperties.toMutableMap()
        }

        /** The recordings of a call, each as a short-lived download link */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Error information */
        fun error(error: ErrorDetail?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<ErrorDetail>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [ErrorDetail] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun error(error: JsonField<ErrorDetail>) = apply { this.error = error }

        /** Request and response metadata */
        fun meta(meta: ApiMeta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [ApiMeta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<ApiMeta>) = apply { this.meta = meta }

        /** Indicates whether the request was successful */
        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

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
         * Returns an immutable instance of [ApiResponseOfCallRecordings].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ApiResponseOfCallRecordings =
            ApiResponseOfCallRecordings(
                data,
                error,
                meta,
                success,
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
    fun validate(): ApiResponseOfCallRecordings = apply {
        if (validated) {
            return@apply
        }

        data().ifPresent { it.validate() }
        error().ifPresent { it.validate() }
        meta().ifPresent { it.validate() }
        success()
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (error.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    /** The recordings of a call, each as a short-lived download link */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val recordings: JsonField<List<Recording>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("recordings")
            @ExcludeMissing
            recordings: JsonField<List<Recording>> = JsonMissing.of()
        ) : this(recordings, mutableMapOf())

        /**
         * Every recording of the call, oldest first. Empty until the first call.recording_ready
         * webhook has been sent, and for a call that was never recorded
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recordings(): Optional<List<Recording>> = recordings.getOptional("recordings")

        /**
         * Returns the raw JSON value of [recordings].
         *
         * Unlike [recordings], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recordings")
        @ExcludeMissing
        fun _recordings(): JsonField<List<Recording>> = recordings

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var recordings: JsonField<MutableList<Recording>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                recordings = data.recordings.map { it.toMutableList() }
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /**
             * Every recording of the call, oldest first. Empty until the first call.recording_ready
             * webhook has been sent, and for a call that was never recorded
             */
            fun recordings(recordings: List<Recording>) = recordings(JsonField.of(recordings))

            /**
             * Sets [Builder.recordings] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recordings] with a well-typed `List<Recording>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun recordings(recordings: JsonField<List<Recording>>) = apply {
                this.recordings = recordings.map { it.toMutableList() }
            }

            /**
             * Adds a single [Recording] to [recordings].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecording(recording: Recording) = apply {
                recordings =
                    (recordings ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recordings", it).add(recording)
                    }
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    (recordings ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws SentInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            recordings().ifPresent { it.forEach { it.validate() } }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (recordings.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** A short-lived link to a call recording */
        class Recording
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
             * A pre-signed link that downloads the recording as an MP3 file. Anyone holding it can
             * download the recording until it expires
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun downloadUrl(): Optional<String> = downloadUrl.getOptional("download_url")

            /**
             * The recording's id, the one the call.recording_ready webhook announced it under
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun recordingId(): Optional<String> = recordingId.getOptional("recording_id")

            /**
             * When the link stops working (UTC). Request the recordings again for a fresh link
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun urlExpiresAt(): Optional<OffsetDateTime> =
                urlExpiresAt.getOptional("url_expires_at")

            /**
             * Returns the raw JSON value of [downloadUrl].
             *
             * Unlike [downloadUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("download_url")
            @ExcludeMissing
            fun _downloadUrl(): JsonField<String> = downloadUrl

            /**
             * Returns the raw JSON value of [recordingId].
             *
             * Unlike [recordingId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("recording_id")
            @ExcludeMissing
            fun _recordingId(): JsonField<String> = recordingId

            /**
             * Returns the raw JSON value of [urlExpiresAt].
             *
             * Unlike [urlExpiresAt], this method doesn't throw if the JSON field has an unexpected
             * type.
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

                /** Returns a mutable builder for constructing an instance of [Recording]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Recording]. */
            class Builder internal constructor() {

                private var downloadUrl: JsonField<String> = JsonMissing.of()
                private var recordingId: JsonField<String> = JsonMissing.of()
                private var urlExpiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(recording: Recording) = apply {
                    downloadUrl = recording.downloadUrl
                    recordingId = recording.recordingId
                    urlExpiresAt = recording.urlExpiresAt
                    additionalProperties = recording.additionalProperties.toMutableMap()
                }

                /**
                 * A pre-signed link that downloads the recording as an MP3 file. Anyone holding it
                 * can download the recording until it expires
                 */
                fun downloadUrl(downloadUrl: String) = downloadUrl(JsonField.of(downloadUrl))

                /**
                 * Sets [Builder.downloadUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.downloadUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun downloadUrl(downloadUrl: JsonField<String>) = apply {
                    this.downloadUrl = downloadUrl
                }

                /**
                 * The recording's id, the one the call.recording_ready webhook announced it under
                 */
                fun recordingId(recordingId: String) = recordingId(JsonField.of(recordingId))

                /**
                 * Sets [Builder.recordingId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.recordingId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun recordingId(recordingId: JsonField<String>) = apply {
                    this.recordingId = recordingId
                }

                /**
                 * When the link stops working (UTC). Request the recordings again for a fresh link
                 */
                fun urlExpiresAt(urlExpiresAt: OffsetDateTime) =
                    urlExpiresAt(JsonField.of(urlExpiresAt))

                /**
                 * Sets [Builder.urlExpiresAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.urlExpiresAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
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

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Recording].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Recording =
                    Recording(
                        downloadUrl,
                        recordingId,
                        urlExpiresAt,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws SentInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Recording = apply {
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
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

                return other is Recording &&
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
                "Recording{downloadUrl=$downloadUrl, recordingId=$recordingId, urlExpiresAt=$urlExpiresAt, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                recordings == other.recordings &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(recordings, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{recordings=$recordings, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ApiResponseOfCallRecordings &&
            data == other.data &&
            error == other.error &&
            meta == other.meta &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(data, error, meta, success, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ApiResponseOfCallRecordings{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
