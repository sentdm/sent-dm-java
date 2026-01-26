// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.sent_dm.api.core.ExcludeMissing
import com.sent_dm.api.core.JsonField
import com.sent_dm.api.core.JsonMissing
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.checkKnown
import com.sent_dm.api.core.toImmutable
import com.sent_dm.api.errors.SentDmInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContactListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val items: JsonField<List<ContactListItem>>,
    private val page: JsonField<Int>,
    private val pageSize: JsonField<Int>,
    private val totalCount: JsonField<Int>,
    private val totalPages: JsonField<Int>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("items")
        @ExcludeMissing
        items: JsonField<List<ContactListItem>> = JsonMissing.of(),
        @JsonProperty("page") @ExcludeMissing page: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("pageSize") @ExcludeMissing pageSize: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("totalCount") @ExcludeMissing totalCount: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("totalPages") @ExcludeMissing totalPages: JsonField<Int> = JsonMissing.of(),
    ) : this(items, page, pageSize, totalCount, totalPages, mutableMapOf())

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun items(): Optional<List<ContactListItem>> = items.getOptional("items")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun page(): Optional<Int> = page.getOptional("page")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pageSize(): Optional<Int> = pageSize.getOptional("pageSize")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun totalCount(): Optional<Int> = totalCount.getOptional("totalCount")

    /**
     * @throws SentDmInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun totalPages(): Optional<Int> = totalPages.getOptional("totalPages")

    /**
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("items") @ExcludeMissing fun _items(): JsonField<List<ContactListItem>> = items

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
    @JsonProperty("pageSize") @ExcludeMissing fun _pageSize(): JsonField<Int> = pageSize

    /**
     * Returns the raw JSON value of [totalCount].
     *
     * Unlike [totalCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalCount") @ExcludeMissing fun _totalCount(): JsonField<Int> = totalCount

    /**
     * Returns the raw JSON value of [totalPages].
     *
     * Unlike [totalPages], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totalPages") @ExcludeMissing fun _totalPages(): JsonField<Int> = totalPages

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

        /** Returns a mutable builder for constructing an instance of [ContactListResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactListResponse]. */
    class Builder internal constructor() {

        private var items: JsonField<MutableList<ContactListItem>>? = null
        private var page: JsonField<Int> = JsonMissing.of()
        private var pageSize: JsonField<Int> = JsonMissing.of()
        private var totalCount: JsonField<Int> = JsonMissing.of()
        private var totalPages: JsonField<Int> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contactListResponse: ContactListResponse) = apply {
            items = contactListResponse.items.map { it.toMutableList() }
            page = contactListResponse.page
            pageSize = contactListResponse.pageSize
            totalCount = contactListResponse.totalCount
            totalPages = contactListResponse.totalPages
            additionalProperties = contactListResponse.additionalProperties.toMutableMap()
        }

        fun items(items: List<ContactListItem>) = items(JsonField.of(items))

        /**
         * Sets [Builder.items] to an arbitrary JSON value.
         *
         * You should usually call [Builder.items] with a well-typed `List<ContactListItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun items(items: JsonField<List<ContactListItem>>) = apply {
            this.items = items.map { it.toMutableList() }
        }

        /**
         * Adds a single [ContactListItem] to [items].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItem(item: ContactListItem) = apply {
            items =
                (items ?: JsonField.of(mutableListOf())).also { checkKnown("items", it).add(item) }
        }

        fun page(page: Int) = page(JsonField.of(page))

        /**
         * Sets [Builder.page] to an arbitrary JSON value.
         *
         * You should usually call [Builder.page] with a well-typed [Int] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun page(page: JsonField<Int>) = apply { this.page = page }

        fun pageSize(pageSize: Int) = pageSize(JsonField.of(pageSize))

        /**
         * Sets [Builder.pageSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageSize] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pageSize(pageSize: JsonField<Int>) = apply { this.pageSize = pageSize }

        fun totalCount(totalCount: Int) = totalCount(JsonField.of(totalCount))

        /**
         * Sets [Builder.totalCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalCount] with a well-typed [Int] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun totalCount(totalCount: JsonField<Int>) = apply { this.totalCount = totalCount }

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
         * Returns an immutable instance of [ContactListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContactListResponse =
            ContactListResponse(
                (items ?: JsonMissing.of()).map { it.toImmutable() },
                page,
                pageSize,
                totalCount,
                totalPages,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContactListResponse = apply {
        if (validated) {
            return@apply
        }

        items().ifPresent { it.forEach { it.validate() } }
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
        (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (page.asKnown().isPresent) 1 else 0) +
            (if (pageSize.asKnown().isPresent) 1 else 0) +
            (if (totalCount.asKnown().isPresent) 1 else 0) +
            (if (totalPages.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactListResponse &&
            items == other.items &&
            page == other.page &&
            pageSize == other.pageSize &&
            totalCount == other.totalCount &&
            totalPages == other.totalPages &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(items, page, pageSize, totalCount, totalPages, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContactListResponse{items=$items, page=$page, pageSize=$pageSize, totalCount=$totalCount, totalPages=$totalPages, additionalProperties=$additionalProperties}"
}
