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
import dm.sent.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Pagination metadata for list responses */
class PaginationMeta
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
        @JsonProperty("cursors") @ExcludeMissing cursors: JsonField<Cursors> = JsonMissing.of(),
        @JsonProperty("has_more") @ExcludeMissing hasMore: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("page") @ExcludeMissing page: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("page_size") @ExcludeMissing pageSize: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("total_count") @ExcludeMissing totalCount: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("total_pages") @ExcludeMissing totalPages: JsonField<Int> = JsonMissing.of(),
    ) : this(cursors, hasMore, page, pageSize, totalCount, totalPages, mutableMapOf())

    /**
     * Cursor-based pagination (optional)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cursors(): Optional<Cursors> = cursors.getOptional("cursors")

    /**
     * Whether there are more pages after this one
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasMore(): Optional<Boolean> = hasMore.getOptional("has_more")

    /**
     * Current page number (1-indexed)
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun page(): Optional<Int> = page.getOptional("page")

    /**
     * Number of items per page
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pageSize(): Optional<Int> = pageSize.getOptional("page_size")

    /**
     * Total number of items across all pages
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun totalCount(): Optional<Int> = totalCount.getOptional("total_count")

    /**
     * Total number of pages
     *
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
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
     * Unlike [pageSize], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("page_size") @ExcludeMissing fun _pageSize(): JsonField<Int> = pageSize

    /**
     * Returns the raw JSON value of [totalCount].
     *
     * Unlike [totalCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_count") @ExcludeMissing fun _totalCount(): JsonField<Int> = totalCount

    /**
     * Returns the raw JSON value of [totalPages].
     *
     * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("total_pages") @ExcludeMissing fun _totalPages(): JsonField<Int> = totalPages

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

        /** Returns a mutable builder for constructing an instance of [PaginationMeta]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PaginationMeta]. */
    class Builder internal constructor() {

        private var cursors: JsonField<Cursors> = JsonMissing.of()
        private var hasMore: JsonField<Boolean> = JsonMissing.of()
        private var page: JsonField<Int> = JsonMissing.of()
        private var pageSize: JsonField<Int> = JsonMissing.of()
        private var totalCount: JsonField<Int> = JsonMissing.of()
        private var totalPages: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(paginationMeta: PaginationMeta) = apply {
            cursors = paginationMeta.cursors
            hasMore = paginationMeta.hasMore
            page = paginationMeta.page
            pageSize = paginationMeta.pageSize
            totalCount = paginationMeta.totalCount
            totalPages = paginationMeta.totalPages
            additionalProperties = paginationMeta.additionalProperties.toMutableMap()
        }

        /** Cursor-based pagination (optional) */
        fun cursors(cursors: Cursors?) = cursors(JsonField.ofNullable(cursors))

        /** Alias for calling [Builder.cursors] with `cursors.orElse(null)`. */
        fun cursors(cursors: Optional<Cursors>) = cursors(cursors.getOrNull())

        /**
         * Sets [Builder.cursors] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cursors] with a well-typed [Cursors] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun cursors(cursors: JsonField<Cursors>) = apply { this.cursors = cursors }

        /** Whether there are more pages after this one */
        fun hasMore(hasMore: Boolean) = hasMore(JsonField.of(hasMore))

        /**
         * Sets [Builder.hasMore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasMore] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasMore(hasMore: JsonField<Boolean>) = apply { this.hasMore = hasMore }

        /** Current page number (1-indexed) */
        fun page(page: Int) = page(JsonField.of(page))

        /**
         * Sets [Builder.page] to an arbitrary JSON value.
         *
         * You should usually call [Builder.page] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun page(page: JsonField<Int>) = apply { this.page = page }

        /** Number of items per page */
        fun pageSize(pageSize: Int) = pageSize(JsonField.of(pageSize))

        /**
         * Sets [Builder.pageSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageSize] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pageSize(pageSize: JsonField<Int>) = apply { this.pageSize = pageSize }

        /** Total number of items across all pages */
        fun totalCount(totalCount: Int) = totalCount(JsonField.of(totalCount))

        /**
         * Sets [Builder.totalCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalCount] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun totalCount(totalCount: JsonField<Int>) = apply { this.totalCount = totalCount }

        /** Total number of pages */
        fun totalPages(totalPages: Int) = totalPages(JsonField.of(totalPages))

        /**
         * Sets [Builder.totalPages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalPages] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun totalPages(totalPages: JsonField<Int>) = apply { this.totalPages = totalPages }

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
         * Returns an immutable instance of [PaginationMeta].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): PaginationMeta =
            PaginationMeta(
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

    fun validate(): PaginationMeta = apply {
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
        (cursors.asKnown().getOrNull()?.validity() ?: 0) +
            (if (hasMore.asKnown().isPresent) 1 else 0) +
            (if (page.asKnown().isPresent) 1 else 0) +
            (if (pageSize.asKnown().isPresent) 1 else 0) +
            (if (totalCount.asKnown().isPresent) 1 else 0) +
            (if (totalPages.asKnown().isPresent) 1 else 0)

    /** Cursor-based pagination (optional) */
    class Cursors
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
         * Cursor to fetch the next page
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun after(): Optional<String> = after.getOptional("after")

        /**
         * Cursor to fetch the previous page
         *
         * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
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
             * You should usually call [Builder.after] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun after(after: JsonField<String>) = apply { this.after = after }

            /** Cursor to fetch the previous page */
            fun before(before: String?) = before(JsonField.ofNullable(before))

            /** Alias for calling [Builder.before] with `before.orElse(null)`. */
            fun before(before: Optional<String>) = before(before.getOrNull())

            /**
             * Sets [Builder.before] to an arbitrary JSON value.
             *
             * You should usually call [Builder.before] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Cursors].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Cursors = Cursors(after, before, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

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
            } catch (e: SentDmInvalidDataException) {
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
            (if (after.asKnown().isPresent) 1 else 0) + (if (before.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Cursors &&
                after == other.after &&
                before == other.before &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(after, before, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Cursors{after=$after, before=$before, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PaginationMeta &&
            cursors == other.cursors &&
            hasMore == other.hasMore &&
            page == other.page &&
            pageSize == other.pageSize &&
            totalCount == other.totalCount &&
            totalPages == other.totalPages &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(cursors, hasMore, page, pageSize, totalCount, totalPages, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PaginationMeta{cursors=$cursors, hasMore=$hasMore, page=$page, pageSize=$pageSize, totalCount=$totalCount, totalPages=$totalPages, additionalProperties=$additionalProperties}"
}
