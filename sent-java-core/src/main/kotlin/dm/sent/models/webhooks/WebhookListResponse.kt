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
import dm.sent.core.checkKnown
import dm.sent.core.toImmutable
import dm.sent.errors.SentInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Standard API response envelope for all v3 endpoints */
class WebhookListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<Error>,
    private val meta: JsonField<Meta>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<Error> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<Meta> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, meta, success, mutableMapOf())

    /**
     * The response data (null if error)
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
    fun error(): Optional<Error> = error.getOptional("error")

    /**
     * Request and response metadata
     *
     * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun meta(): Optional<Meta> = meta.getOptional("meta")

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
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<Error> = error

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<Meta> = meta

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

        /** Returns a mutable builder for constructing an instance of [WebhookListResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<Error> = JsonMissing.of()
        private var meta: JsonField<Meta> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(webhookListResponse: WebhookListResponse) = apply {
            data = webhookListResponse.data
            error = webhookListResponse.error
            meta = webhookListResponse.meta
            success = webhookListResponse.success
            additionalProperties = webhookListResponse.additionalProperties.toMutableMap()
        }

        /** The response data (null if error) */
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
        fun error(error: Error?) = error(JsonField.ofNullable(error))

        /** Alias for calling [Builder.error] with `error.orElse(null)`. */
        fun error(error: Optional<Error>) = error(error.getOrNull())

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [Error] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<Error>) = apply { this.error = error }

        /** Request and response metadata */
        fun meta(meta: Meta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [Meta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<Meta>) = apply { this.meta = meta }

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
         * Returns an immutable instance of [WebhookListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): WebhookListResponse =
            WebhookListResponse(data, error, meta, success, additionalProperties.toMutableMap())
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
    fun validate(): WebhookListResponse = apply {
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

    /** The response data (null if error) */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val pagination: JsonField<Pagination>,
        private val webhooks: JsonField<List<Webhook>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("pagination")
            @ExcludeMissing
            pagination: JsonField<Pagination> = JsonMissing.of(),
            @JsonProperty("webhooks")
            @ExcludeMissing
            webhooks: JsonField<List<Webhook>> = JsonMissing.of(),
        ) : this(pagination, webhooks, mutableMapOf())

        /**
         * Pagination metadata for list responses
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun pagination(): Optional<Pagination> = pagination.getOptional("pagination")

        /**
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun webhooks(): Optional<List<Webhook>> = webhooks.getOptional("webhooks")

        /**
         * Returns the raw JSON value of [pagination].
         *
         * Unlike [pagination], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pagination")
        @ExcludeMissing
        fun _pagination(): JsonField<Pagination> = pagination

        /**
         * Returns the raw JSON value of [webhooks].
         *
         * Unlike [webhooks], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("webhooks")
        @ExcludeMissing
        fun _webhooks(): JsonField<List<Webhook>> = webhooks

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

            private var pagination: JsonField<Pagination> = JsonMissing.of()
            private var webhooks: JsonField<MutableList<Webhook>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                pagination = data.pagination
                webhooks = data.webhooks.map { it.toMutableList() }
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** Pagination metadata for list responses */
            fun pagination(pagination: Pagination) = pagination(JsonField.of(pagination))

            /**
             * Sets [Builder.pagination] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pagination] with a well-typed [Pagination] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pagination(pagination: JsonField<Pagination>) = apply {
                this.pagination = pagination
            }

            fun webhooks(webhooks: List<Webhook>) = webhooks(JsonField.of(webhooks))

            /**
             * Sets [Builder.webhooks] to an arbitrary JSON value.
             *
             * You should usually call [Builder.webhooks] with a well-typed `List<Webhook>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun webhooks(webhooks: JsonField<List<Webhook>>) = apply {
                this.webhooks = webhooks.map { it.toMutableList() }
            }

            /**
             * Adds a single [Webhook] to [webhooks].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addWebhook(webhook: Webhook) = apply {
                webhooks =
                    (webhooks ?: JsonField.of(mutableListOf())).also {
                        checkKnown("webhooks", it).add(webhook)
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
                    pagination,
                    (webhooks ?: JsonMissing.of()).map { it.toImmutable() },
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

            pagination().ifPresent { it.validate() }
            webhooks().ifPresent { it.forEach { it.validate() } }
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
            (pagination.asKnown().getOrNull()?.validity() ?: 0) +
                (webhooks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        /** Pagination metadata for list responses */
        class Pagination
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val cursors: JsonField<Cursors>,
            private val hasMore: JsonField<Boolean>,
            private val page: JsonField<Int>,
            private val pageSize: JsonField<Int>,
            private val totalCount: JsonField<Int>,
            private val totalPages: JsonField<Int>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cursors")
                @ExcludeMissing
                cursors: JsonField<Cursors> = JsonMissing.of(),
                @JsonProperty("has_more")
                @ExcludeMissing
                hasMore: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("page") @ExcludeMissing page: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("page_size")
                @ExcludeMissing
                pageSize: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("total_count")
                @ExcludeMissing
                totalCount: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("total_pages")
                @ExcludeMissing
                totalPages: JsonField<Int> = JsonMissing.of(),
            ) : this(cursors, hasMore, page, pageSize, totalCount, totalPages, mutableMapOf())

            /**
             * Cursor-based pagination pointers
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun cursors(): Optional<Cursors> = cursors.getOptional("cursors")

            /**
             * Whether there are more pages after this one
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun hasMore(): Optional<Boolean> = hasMore.getOptional("has_more")

            /**
             * Current page number (1-indexed)
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun page(): Optional<Int> = page.getOptional("page")

            /**
             * Number of items per page
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun pageSize(): Optional<Int> = pageSize.getOptional("page_size")

            /**
             * Total number of items across all pages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun totalCount(): Optional<Int> = totalCount.getOptional("total_count")

            /**
             * Total number of pages
             *
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun totalPages(): Optional<Int> = totalPages.getOptional("total_pages")

            /**
             * Returns the raw JSON value of [cursors].
             *
             * Unlike [cursors], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cursors") @ExcludeMissing fun _cursors(): JsonField<Cursors> = cursors

            /**
             * Returns the raw JSON value of [hasMore].
             *
             * Unlike [hasMore], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

            /**
             * Returns the raw JSON value of [page].
             *
             * Unlike [page], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("page") @ExcludeMissing fun _page(): JsonField<Int> = page

            /**
             * Returns the raw JSON value of [pageSize].
             *
             * Unlike [pageSize], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("page_size") @ExcludeMissing fun _pageSize(): JsonField<Int> = pageSize

            /**
             * Returns the raw JSON value of [totalCount].
             *
             * Unlike [totalCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("total_count")
            @ExcludeMissing
            fun _totalCount(): JsonField<Int> = totalCount

            /**
             * Returns the raw JSON value of [totalPages].
             *
             * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("total_pages")
            @ExcludeMissing
            fun _totalPages(): JsonField<Int> = totalPages

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

                /** Returns a mutable builder for constructing an instance of [Pagination]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Pagination]. */
            class Builder internal constructor() {

                private var cursors: JsonField<Cursors> = JsonMissing.of()
                private var hasMore: JsonField<Boolean> = JsonMissing.of()
                private var page: JsonField<Int> = JsonMissing.of()
                private var pageSize: JsonField<Int> = JsonMissing.of()
                private var totalCount: JsonField<Int> = JsonMissing.of()
                private var totalPages: JsonField<Int> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(pagination: Pagination) = apply {
                    cursors = pagination.cursors
                    hasMore = pagination.hasMore
                    page = pagination.page
                    pageSize = pagination.pageSize
                    totalCount = pagination.totalCount
                    totalPages = pagination.totalPages
                    additionalProperties = pagination.additionalProperties.toMutableMap()
                }

                /** Cursor-based pagination pointers */
                fun cursors(cursors: Cursors?) = cursors(JsonField.ofNullable(cursors))

                /** Alias for calling [Builder.cursors] with `cursors.orElse(null)`. */
                fun cursors(cursors: Optional<Cursors>) = cursors(cursors.getOrNull())

                /**
                 * Sets [Builder.cursors] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cursors] with a well-typed [Cursors] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun cursors(cursors: JsonField<Cursors>) = apply { this.cursors = cursors }

                /** Whether there are more pages after this one */
                fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

                /**
                 * Sets [Builder.hasMore] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.hasMore] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

                /** Current page number (1-indexed) */
                fun page(page: Int) = page(JsonField.of(page))

                /**
                 * Sets [Builder.page] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.page] with a well-typed [Int] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun page(page: JsonField<Int>) = apply { this.page = page }

                /** Number of items per page */
                fun pageSize(pageSize: Int) = pageSize(JsonField.of(pageSize))

                /**
                 * Sets [Builder.pageSize] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pageSize] with a well-typed [Int] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun pageSize(pageSize: JsonField<Int>) = apply { this.pageSize = pageSize }

                /** Total number of items across all pages */
                fun totalCount(totalCount: Int) = totalCount(JsonField.of(totalCount))

                /**
                 * Sets [Builder.totalCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.totalCount] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun totalCount(totalCount: JsonField<Int>) = apply { this.totalCount = totalCount }

                /** Total number of pages */
                fun totalPages(totalPages: Int) = totalPages(JsonField.of(totalPages))

                /**
                 * Sets [Builder.totalPages] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.totalPages] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun totalPages(totalPages: JsonField<Int>) = apply { this.totalPages = totalPages }

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
                 * Returns an immutable instance of [Pagination].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Pagination =
                    Pagination(
                        cursors,
                        hasMore,
                        page,
                        pageSize,
                        totalCount,
                        totalPages,
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
            fun validate(): Pagination = apply {
                if (validated) {
                    return@apply
                }

                cursors().ifPresent { it.validate() }
                hasMore()
                page()
                pageSize()
                totalCount()
                totalPages()
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
                (cursors.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (hasMore.asKnown().isPresent) 1 else 0) +
                    (if (page.asKnown().isPresent) 1 else 0) +
                    (if (pageSize.asKnown().isPresent) 1 else 0) +
                    (if (totalCount.asKnown().isPresent) 1 else 0) +
                    (if (totalPages.asKnown().isPresent) 1 else 0)

            /** Cursor-based pagination pointers */
            class Cursors
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val after: JsonField<String>,
                private val before: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("after")
                    @ExcludeMissing
                    after: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("before")
                    @ExcludeMissing
                    before: JsonField<String> = JsonMissing.of(),
                ) : this(after, before, mutableMapOf())

                /**
                 * Cursor to fetch the next page
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun after(): Optional<String> = after.getOptional("after")

                /**
                 * Cursor to fetch the previous page
                 *
                 * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun before(): Optional<String> = before.getOptional("before")

                /**
                 * Returns the raw JSON value of [after].
                 *
                 * Unlike [after], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("after") @ExcludeMissing fun _after(): JsonField<String> = after

                /**
                 * Returns the raw JSON value of [before].
                 *
                 * Unlike [before], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    /** Returns a mutable builder for constructing an instance of [Cursors]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Cursors]. */
                class Builder internal constructor() {

                    private var after: JsonField<String> = JsonMissing.of()
                    private var before: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(cursors: Cursors) = apply {
                        after = cursors.after
                        before = cursors.before
                        additionalProperties = cursors.additionalProperties.toMutableMap()
                    }

                    /** Cursor to fetch the next page */
                    fun after(after: String?) = after(JsonField.ofNullable(after))

                    /** Alias for calling [Builder.after] with `after.orElse(null)`. */
                    fun after(after: Optional<String>) = after(after.getOrNull())

                    /**
                     * Sets [Builder.after] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.after] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun after(after: JsonField<String>) = apply { this.after = after }

                    /** Cursor to fetch the previous page */
                    fun before(before: String?) = before(JsonField.ofNullable(before))

                    /** Alias for calling [Builder.before] with `before.orElse(null)`. */
                    fun before(before: Optional<String>) = before(before.getOrNull())

                    /**
                     * Sets [Builder.before] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.before] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun before(before: JsonField<String>) = apply { this.before = before }

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
                     * Returns an immutable instance of [Cursors].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Cursors =
                        Cursors(after, before, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Cursors = apply {
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (after.asKnown().isPresent) 1 else 0) +
                        (if (before.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Cursors &&
                        after == other.after &&
                        before == other.before &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(after, before, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Cursors{after=$after, before=$before, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Pagination &&
                    cursors == other.cursors &&
                    hasMore == other.hasMore &&
                    page == other.page &&
                    pageSize == other.pageSize &&
                    totalCount == other.totalCount &&
                    totalPages == other.totalPages &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    cursors,
                    hasMore,
                    page,
                    pageSize,
                    totalCount,
                    totalPages,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Pagination{cursors=$cursors, hasMore=$hasMore, page=$page, pageSize=$pageSize, totalCount=$totalCount, totalPages=$totalPages, additionalProperties=$additionalProperties}"
        }

        class Webhook
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val id: JsonField<String>,
            private val consecutiveFailures: JsonField<Int>,
            private val createdAt: JsonField<OffsetDateTime>,
            private val displayName: JsonField<String>,
            private val endpointUrl: JsonField<String>,
            private val eventFilters: JsonField<EventFilters>,
            private val eventTypes: JsonField<List<String>>,
            private val isActive: JsonField<Boolean>,
            private val lastDeliveryAttemptAt: JsonField<OffsetDateTime>,
            private val lastSuccessfulDeliveryAt: JsonField<OffsetDateTime>,
            private val retryCount: JsonField<Int>,
            private val signingSecret: JsonField<String>,
            private val timeoutSeconds: JsonField<Int>,
            private val updatedAt: JsonField<OffsetDateTime>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
                @JsonProperty("consecutive_failures")
                @ExcludeMissing
                consecutiveFailures: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("created_at")
                @ExcludeMissing
                createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("display_name")
                @ExcludeMissing
                displayName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("endpoint_url")
                @ExcludeMissing
                endpointUrl: JsonField<String> = JsonMissing.of(),
                @JsonProperty("event_filters")
                @ExcludeMissing
                eventFilters: JsonField<EventFilters> = JsonMissing.of(),
                @JsonProperty("event_types")
                @ExcludeMissing
                eventTypes: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("is_active")
                @ExcludeMissing
                isActive: JsonField<Boolean> = JsonMissing.of(),
                @JsonProperty("last_delivery_attempt_at")
                @ExcludeMissing
                lastDeliveryAttemptAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("last_successful_delivery_at")
                @ExcludeMissing
                lastSuccessfulDeliveryAt: JsonField<OffsetDateTime> = JsonMissing.of(),
                @JsonProperty("retry_count")
                @ExcludeMissing
                retryCount: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("signing_secret")
                @ExcludeMissing
                signingSecret: JsonField<String> = JsonMissing.of(),
                @JsonProperty("timeout_seconds")
                @ExcludeMissing
                timeoutSeconds: JsonField<Int> = JsonMissing.of(),
                @JsonProperty("updated_at")
                @ExcludeMissing
                updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            ) : this(
                id,
                consecutiveFailures,
                createdAt,
                displayName,
                endpointUrl,
                eventFilters,
                eventTypes,
                isActive,
                lastDeliveryAttemptAt,
                lastSuccessfulDeliveryAt,
                retryCount,
                signingSecret,
                timeoutSeconds,
                updatedAt,
                mutableMapOf(),
            )

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun consecutiveFailures(): Optional<Int> =
                consecutiveFailures.getOptional("consecutive_failures")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun createdAt(): Optional<OffsetDateTime> = createdAt.getOptional("created_at")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun displayName(): Optional<String> = displayName.getOptional("display_name")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun endpointUrl(): Optional<String> = endpointUrl.getOptional("endpoint_url")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun eventFilters(): Optional<EventFilters> = eventFilters.getOptional("event_filters")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun eventTypes(): Optional<List<String>> = eventTypes.getOptional("event_types")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun isActive(): Optional<Boolean> = isActive.getOptional("is_active")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun lastDeliveryAttemptAt(): Optional<OffsetDateTime> =
                lastDeliveryAttemptAt.getOptional("last_delivery_attempt_at")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun lastSuccessfulDeliveryAt(): Optional<OffsetDateTime> =
                lastSuccessfulDeliveryAt.getOptional("last_successful_delivery_at")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun retryCount(): Optional<Int> = retryCount.getOptional("retry_count")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun signingSecret(): Optional<String> = signingSecret.getOptional("signing_secret")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun timeoutSeconds(): Optional<Int> = timeoutSeconds.getOptional("timeout_seconds")

            /**
             * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun updatedAt(): Optional<OffsetDateTime> = updatedAt.getOptional("updated_at")

            /**
             * Returns the raw JSON value of [id].
             *
             * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

            /**
             * Returns the raw JSON value of [consecutiveFailures].
             *
             * Unlike [consecutiveFailures], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("consecutive_failures")
            @ExcludeMissing
            fun _consecutiveFailures(): JsonField<Int> = consecutiveFailures

            /**
             * Returns the raw JSON value of [createdAt].
             *
             * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("created_at")
            @ExcludeMissing
            fun _createdAt(): JsonField<OffsetDateTime> = createdAt

            /**
             * Returns the raw JSON value of [displayName].
             *
             * Unlike [displayName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("display_name")
            @ExcludeMissing
            fun _displayName(): JsonField<String> = displayName

            /**
             * Returns the raw JSON value of [endpointUrl].
             *
             * Unlike [endpointUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("endpoint_url")
            @ExcludeMissing
            fun _endpointUrl(): JsonField<String> = endpointUrl

            /**
             * Returns the raw JSON value of [eventFilters].
             *
             * Unlike [eventFilters], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("event_filters")
            @ExcludeMissing
            fun _eventFilters(): JsonField<EventFilters> = eventFilters

            /**
             * Returns the raw JSON value of [eventTypes].
             *
             * Unlike [eventTypes], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("event_types")
            @ExcludeMissing
            fun _eventTypes(): JsonField<List<String>> = eventTypes

            /**
             * Returns the raw JSON value of [isActive].
             *
             * Unlike [isActive], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("is_active")
            @ExcludeMissing
            fun _isActive(): JsonField<Boolean> = isActive

            /**
             * Returns the raw JSON value of [lastDeliveryAttemptAt].
             *
             * Unlike [lastDeliveryAttemptAt], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("last_delivery_attempt_at")
            @ExcludeMissing
            fun _lastDeliveryAttemptAt(): JsonField<OffsetDateTime> = lastDeliveryAttemptAt

            /**
             * Returns the raw JSON value of [lastSuccessfulDeliveryAt].
             *
             * Unlike [lastSuccessfulDeliveryAt], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("last_successful_delivery_at")
            @ExcludeMissing
            fun _lastSuccessfulDeliveryAt(): JsonField<OffsetDateTime> = lastSuccessfulDeliveryAt

            /**
             * Returns the raw JSON value of [retryCount].
             *
             * Unlike [retryCount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("retry_count")
            @ExcludeMissing
            fun _retryCount(): JsonField<Int> = retryCount

            /**
             * Returns the raw JSON value of [signingSecret].
             *
             * Unlike [signingSecret], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("signing_secret")
            @ExcludeMissing
            fun _signingSecret(): JsonField<String> = signingSecret

            /**
             * Returns the raw JSON value of [timeoutSeconds].
             *
             * Unlike [timeoutSeconds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("timeout_seconds")
            @ExcludeMissing
            fun _timeoutSeconds(): JsonField<Int> = timeoutSeconds

            /**
             * Returns the raw JSON value of [updatedAt].
             *
             * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("updated_at")
            @ExcludeMissing
            fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

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

                /** Returns a mutable builder for constructing an instance of [Webhook]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Webhook]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var consecutiveFailures: JsonField<Int> = JsonMissing.of()
                private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var displayName: JsonField<String> = JsonMissing.of()
                private var endpointUrl: JsonField<String> = JsonMissing.of()
                private var eventFilters: JsonField<EventFilters> = JsonMissing.of()
                private var eventTypes: JsonField<MutableList<String>>? = null
                private var isActive: JsonField<Boolean> = JsonMissing.of()
                private var lastDeliveryAttemptAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var lastSuccessfulDeliveryAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var retryCount: JsonField<Int> = JsonMissing.of()
                private var signingSecret: JsonField<String> = JsonMissing.of()
                private var timeoutSeconds: JsonField<Int> = JsonMissing.of()
                private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(webhook: Webhook) = apply {
                    id = webhook.id
                    consecutiveFailures = webhook.consecutiveFailures
                    createdAt = webhook.createdAt
                    displayName = webhook.displayName
                    endpointUrl = webhook.endpointUrl
                    eventFilters = webhook.eventFilters
                    eventTypes = webhook.eventTypes.map { it.toMutableList() }
                    isActive = webhook.isActive
                    lastDeliveryAttemptAt = webhook.lastDeliveryAttemptAt
                    lastSuccessfulDeliveryAt = webhook.lastSuccessfulDeliveryAt
                    retryCount = webhook.retryCount
                    signingSecret = webhook.signingSecret
                    timeoutSeconds = webhook.timeoutSeconds
                    updatedAt = webhook.updatedAt
                    additionalProperties = webhook.additionalProperties.toMutableMap()
                }

                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                fun consecutiveFailures(consecutiveFailures: Int) =
                    consecutiveFailures(JsonField.of(consecutiveFailures))

                /**
                 * Sets [Builder.consecutiveFailures] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.consecutiveFailures] with a well-typed [Int]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun consecutiveFailures(consecutiveFailures: JsonField<Int>) = apply {
                    this.consecutiveFailures = consecutiveFailures
                }

                fun createdAt(createdAt: OffsetDateTime) = createdAt(JsonField.of(createdAt))

                /**
                 * Sets [Builder.createdAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.createdAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply {
                    this.createdAt = createdAt
                }

                fun displayName(displayName: String) = displayName(JsonField.of(displayName))

                /**
                 * Sets [Builder.displayName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.displayName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun displayName(displayName: JsonField<String>) = apply {
                    this.displayName = displayName
                }

                fun endpointUrl(endpointUrl: String) = endpointUrl(JsonField.of(endpointUrl))

                /**
                 * Sets [Builder.endpointUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.endpointUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun endpointUrl(endpointUrl: JsonField<String>) = apply {
                    this.endpointUrl = endpointUrl
                }

                fun eventFilters(eventFilters: EventFilters?) =
                    eventFilters(JsonField.ofNullable(eventFilters))

                /** Alias for calling [Builder.eventFilters] with `eventFilters.orElse(null)`. */
                fun eventFilters(eventFilters: Optional<EventFilters>) =
                    eventFilters(eventFilters.getOrNull())

                /**
                 * Sets [Builder.eventFilters] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.eventFilters] with a well-typed [EventFilters]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun eventFilters(eventFilters: JsonField<EventFilters>) = apply {
                    this.eventFilters = eventFilters
                }

                fun eventTypes(eventTypes: List<String>) = eventTypes(JsonField.of(eventTypes))

                /**
                 * Sets [Builder.eventTypes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.eventTypes] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun eventTypes(eventTypes: JsonField<List<String>>) = apply {
                    this.eventTypes = eventTypes.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [eventTypes].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addEventType(eventType: String) = apply {
                    eventTypes =
                        (eventTypes ?: JsonField.of(mutableListOf())).also {
                            checkKnown("eventTypes", it).add(eventType)
                        }
                }

                fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

                /**
                 * Sets [Builder.isActive] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isActive] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

                fun lastDeliveryAttemptAt(lastDeliveryAttemptAt: OffsetDateTime?) =
                    lastDeliveryAttemptAt(JsonField.ofNullable(lastDeliveryAttemptAt))

                /**
                 * Alias for calling [Builder.lastDeliveryAttemptAt] with
                 * `lastDeliveryAttemptAt.orElse(null)`.
                 */
                fun lastDeliveryAttemptAt(lastDeliveryAttemptAt: Optional<OffsetDateTime>) =
                    lastDeliveryAttemptAt(lastDeliveryAttemptAt.getOrNull())

                /**
                 * Sets [Builder.lastDeliveryAttemptAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.lastDeliveryAttemptAt] with a well-typed
                 * [OffsetDateTime] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun lastDeliveryAttemptAt(lastDeliveryAttemptAt: JsonField<OffsetDateTime>) =
                    apply {
                        this.lastDeliveryAttemptAt = lastDeliveryAttemptAt
                    }

                fun lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt: OffsetDateTime?) =
                    lastSuccessfulDeliveryAt(JsonField.ofNullable(lastSuccessfulDeliveryAt))

                /**
                 * Alias for calling [Builder.lastSuccessfulDeliveryAt] with
                 * `lastSuccessfulDeliveryAt.orElse(null)`.
                 */
                fun lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt: Optional<OffsetDateTime>) =
                    lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt.getOrNull())

                /**
                 * Sets [Builder.lastSuccessfulDeliveryAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.lastSuccessfulDeliveryAt] with a well-typed
                 * [OffsetDateTime] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun lastSuccessfulDeliveryAt(lastSuccessfulDeliveryAt: JsonField<OffsetDateTime>) =
                    apply {
                        this.lastSuccessfulDeliveryAt = lastSuccessfulDeliveryAt
                    }

                fun retryCount(retryCount: Int) = retryCount(JsonField.of(retryCount))

                /**
                 * Sets [Builder.retryCount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.retryCount] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun retryCount(retryCount: JsonField<Int>) = apply { this.retryCount = retryCount }

                fun signingSecret(signingSecret: String?) =
                    signingSecret(JsonField.ofNullable(signingSecret))

                /** Alias for calling [Builder.signingSecret] with `signingSecret.orElse(null)`. */
                fun signingSecret(signingSecret: Optional<String>) =
                    signingSecret(signingSecret.getOrNull())

                /**
                 * Sets [Builder.signingSecret] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.signingSecret] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun signingSecret(signingSecret: JsonField<String>) = apply {
                    this.signingSecret = signingSecret
                }

                fun timeoutSeconds(timeoutSeconds: Int) =
                    timeoutSeconds(JsonField.of(timeoutSeconds))

                /**
                 * Sets [Builder.timeoutSeconds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.timeoutSeconds] with a well-typed [Int] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun timeoutSeconds(timeoutSeconds: JsonField<Int>) = apply {
                    this.timeoutSeconds = timeoutSeconds
                }

                fun updatedAt(updatedAt: OffsetDateTime?) =
                    updatedAt(JsonField.ofNullable(updatedAt))

                /** Alias for calling [Builder.updatedAt] with `updatedAt.orElse(null)`. */
                fun updatedAt(updatedAt: Optional<OffsetDateTime>) =
                    updatedAt(updatedAt.getOrNull())

                /**
                 * Sets [Builder.updatedAt] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply {
                    this.updatedAt = updatedAt
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
                 * Returns an immutable instance of [Webhook].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Webhook =
                    Webhook(
                        id,
                        consecutiveFailures,
                        createdAt,
                        displayName,
                        endpointUrl,
                        eventFilters,
                        (eventTypes ?: JsonMissing.of()).map { it.toImmutable() },
                        isActive,
                        lastDeliveryAttemptAt,
                        lastSuccessfulDeliveryAt,
                        retryCount,
                        signingSecret,
                        timeoutSeconds,
                        updatedAt,
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
            fun validate(): Webhook = apply {
                if (validated) {
                    return@apply
                }

                id()
                consecutiveFailures()
                createdAt()
                displayName()
                endpointUrl()
                eventFilters().ifPresent { it.validate() }
                eventTypes()
                isActive()
                lastDeliveryAttemptAt()
                lastSuccessfulDeliveryAt()
                retryCount()
                signingSecret()
                timeoutSeconds()
                updatedAt()
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (consecutiveFailures.asKnown().isPresent) 1 else 0) +
                    (if (createdAt.asKnown().isPresent) 1 else 0) +
                    (if (displayName.asKnown().isPresent) 1 else 0) +
                    (if (endpointUrl.asKnown().isPresent) 1 else 0) +
                    (eventFilters.asKnown().getOrNull()?.validity() ?: 0) +
                    (eventTypes.asKnown().getOrNull()?.size ?: 0) +
                    (if (isActive.asKnown().isPresent) 1 else 0) +
                    (if (lastDeliveryAttemptAt.asKnown().isPresent) 1 else 0) +
                    (if (lastSuccessfulDeliveryAt.asKnown().isPresent) 1 else 0) +
                    (if (retryCount.asKnown().isPresent) 1 else 0) +
                    (if (signingSecret.asKnown().isPresent) 1 else 0) +
                    (if (timeoutSeconds.asKnown().isPresent) 1 else 0) +
                    (if (updatedAt.asKnown().isPresent) 1 else 0)

            class EventFilters
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [EventFilters]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [EventFilters]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(eventFilters: EventFilters) = apply {
                        additionalProperties = eventFilters.additionalProperties.toMutableMap()
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
                     * Returns an immutable instance of [EventFilters].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): EventFilters = EventFilters(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws SentInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): EventFilters = apply {
                    if (validated) {
                        return@apply
                    }

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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is EventFilters &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() = "EventFilters{additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Webhook &&
                    id == other.id &&
                    consecutiveFailures == other.consecutiveFailures &&
                    createdAt == other.createdAt &&
                    displayName == other.displayName &&
                    endpointUrl == other.endpointUrl &&
                    eventFilters == other.eventFilters &&
                    eventTypes == other.eventTypes &&
                    isActive == other.isActive &&
                    lastDeliveryAttemptAt == other.lastDeliveryAttemptAt &&
                    lastSuccessfulDeliveryAt == other.lastSuccessfulDeliveryAt &&
                    retryCount == other.retryCount &&
                    signingSecret == other.signingSecret &&
                    timeoutSeconds == other.timeoutSeconds &&
                    updatedAt == other.updatedAt &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    id,
                    consecutiveFailures,
                    createdAt,
                    displayName,
                    endpointUrl,
                    eventFilters,
                    eventTypes,
                    isActive,
                    lastDeliveryAttemptAt,
                    lastSuccessfulDeliveryAt,
                    retryCount,
                    signingSecret,
                    timeoutSeconds,
                    updatedAt,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Webhook{id=$id, consecutiveFailures=$consecutiveFailures, createdAt=$createdAt, displayName=$displayName, endpointUrl=$endpointUrl, eventFilters=$eventFilters, eventTypes=$eventTypes, isActive=$isActive, lastDeliveryAttemptAt=$lastDeliveryAttemptAt, lastSuccessfulDeliveryAt=$lastSuccessfulDeliveryAt, retryCount=$retryCount, signingSecret=$signingSecret, timeoutSeconds=$timeoutSeconds, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                pagination == other.pagination &&
                webhooks == other.webhooks &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(pagination, webhooks, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{pagination=$pagination, webhooks=$webhooks, additionalProperties=$additionalProperties}"
    }

    /** Error information */
    class Error
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val code: JsonField<String>,
        private val details: JsonField<Details>,
        private val docUrl: JsonField<String>,
        private val message: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("code") @ExcludeMissing code: JsonField<String> = JsonMissing.of(),
            @JsonProperty("details") @ExcludeMissing details: JsonField<Details> = JsonMissing.of(),
            @JsonProperty("doc_url") @ExcludeMissing docUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message") @ExcludeMissing message: JsonField<String> = JsonMissing.of(),
        ) : this(code, details, docUrl, message, mutableMapOf())

        /**
         * Machine-readable error code (e.g., "RESOURCE_001")
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun code(): Optional<String> = code.getOptional("code")

        /**
         * Additional validation error details (field-level errors)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun details(): Optional<Details> = details.getOptional("details")

        /**
         * URL to documentation about this error
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun docUrl(): Optional<String> = docUrl.getOptional("doc_url")

        /**
         * Human-readable error message
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun message(): Optional<String> = message.getOptional("message")

        /**
         * Returns the raw JSON value of [code].
         *
         * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

        /**
         * Returns the raw JSON value of [details].
         *
         * Unlike [details], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("details") @ExcludeMissing fun _details(): JsonField<Details> = details

        /**
         * Returns the raw JSON value of [docUrl].
         *
         * Unlike [docUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("doc_url") @ExcludeMissing fun _docUrl(): JsonField<String> = docUrl

        /**
         * Returns the raw JSON value of [message].
         *
         * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

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

            /** Returns a mutable builder for constructing an instance of [Error]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Error]. */
        class Builder internal constructor() {

            private var code: JsonField<String> = JsonMissing.of()
            private var details: JsonField<Details> = JsonMissing.of()
            private var docUrl: JsonField<String> = JsonMissing.of()
            private var message: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(error: Error) = apply {
                code = error.code
                details = error.details
                docUrl = error.docUrl
                message = error.message
                additionalProperties = error.additionalProperties.toMutableMap()
            }

            /** Machine-readable error code (e.g., "RESOURCE_001") */
            fun code(code: String) = code(JsonField.of(code))

            /**
             * Sets [Builder.code] to an arbitrary JSON value.
             *
             * You should usually call [Builder.code] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun code(code: JsonField<String>) = apply { this.code = code }

            /** Additional validation error details (field-level errors) */
            fun details(details: Details?) = details(JsonField.ofNullable(details))

            /** Alias for calling [Builder.details] with `details.orElse(null)`. */
            fun details(details: Optional<Details>) = details(details.getOrNull())

            /**
             * Sets [Builder.details] to an arbitrary JSON value.
             *
             * You should usually call [Builder.details] with a well-typed [Details] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun details(details: JsonField<Details>) = apply { this.details = details }

            /** URL to documentation about this error */
            fun docUrl(docUrl: String?) = docUrl(JsonField.ofNullable(docUrl))

            /** Alias for calling [Builder.docUrl] with `docUrl.orElse(null)`. */
            fun docUrl(docUrl: Optional<String>) = docUrl(docUrl.getOrNull())

            /**
             * Sets [Builder.docUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.docUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun docUrl(docUrl: JsonField<String>) = apply { this.docUrl = docUrl }

            /** Human-readable error message */
            fun message(message: String) = message(JsonField.of(message))

            /**
             * Sets [Builder.message] to an arbitrary JSON value.
             *
             * You should usually call [Builder.message] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun message(message: JsonField<String>) = apply { this.message = message }

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
             * Returns an immutable instance of [Error].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Error =
                Error(code, details, docUrl, message, additionalProperties.toMutableMap())
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
        fun validate(): Error = apply {
            if (validated) {
                return@apply
            }

            code()
            details().ifPresent { it.validate() }
            docUrl()
            message()
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
            (if (code.asKnown().isPresent) 1 else 0) +
                (details.asKnown().getOrNull()?.validity() ?: 0) +
                (if (docUrl.asKnown().isPresent) 1 else 0) +
                (if (message.asKnown().isPresent) 1 else 0)

        /** Additional validation error details (field-level errors) */
        class Details
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Details]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Details]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(details: Details) = apply {
                    additionalProperties = details.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [Details].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Details = Details(additionalProperties.toImmutable())
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
            fun validate(): Details = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Details && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Details{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Error &&
                code == other.code &&
                details == other.details &&
                docUrl == other.docUrl &&
                message == other.message &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(code, details, docUrl, message, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Error{code=$code, details=$details, docUrl=$docUrl, message=$message, additionalProperties=$additionalProperties}"
    }

    /** Request and response metadata */
    class Meta
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val requestId: JsonField<String>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val version: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
        ) : this(requestId, timestamp, version, mutableMapOf())

        /**
         * Unique identifier for this request (for tracing and support)
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

        /**
         * Server timestamp when the response was generated
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

        /**
         * API version used for this request
         *
         * @throws SentInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun version(): Optional<String> = version.getOptional("version")

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [timestamp].
         *
         * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timestamp")
        @ExcludeMissing
        fun _timestamp(): JsonField<OffsetDateTime> = timestamp

        /**
         * Returns the raw JSON value of [version].
         *
         * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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

            /** Returns a mutable builder for constructing an instance of [Meta]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Meta]. */
        class Builder internal constructor() {

            private var requestId: JsonField<String> = JsonMissing.of()
            private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
            private var version: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(meta: Meta) = apply {
                requestId = meta.requestId
                timestamp = meta.timestamp
                version = meta.version
                additionalProperties = meta.additionalProperties.toMutableMap()
            }

            /** Unique identifier for this request (for tracing and support) */
            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            /** Server timestamp when the response was generated */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
            }

            /** API version used for this request */
            fun version(version: String) = version(JsonField.of(version))

            /**
             * Sets [Builder.version] to an arbitrary JSON value.
             *
             * You should usually call [Builder.version] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun version(version: JsonField<String>) = apply { this.version = version }

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
             * Returns an immutable instance of [Meta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Meta =
                Meta(requestId, timestamp, version, additionalProperties.toMutableMap())
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
        fun validate(): Meta = apply {
            if (validated) {
                return@apply
            }

            requestId()
            timestamp()
            version()
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
            (if (requestId.asKnown().isPresent) 1 else 0) +
                (if (timestamp.asKnown().isPresent) 1 else 0) +
                (if (version.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Meta &&
                requestId == other.requestId &&
                timestamp == other.timestamp &&
                version == other.version &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(requestId, timestamp, version, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Meta{requestId=$requestId, timestamp=$timestamp, version=$version, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListResponse &&
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
        "WebhookListResponse{data=$data, error=$error, meta=$meta, success=$success, additionalProperties=$additionalProperties}"
}
