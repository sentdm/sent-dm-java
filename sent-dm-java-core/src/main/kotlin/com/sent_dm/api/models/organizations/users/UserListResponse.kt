// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations.users

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

class UserListResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val page: JsonField<Int>,
    private val pageSize: JsonField<Int>,
    private val totalCount: JsonField<Int>,
    private val users: JsonField<List<CustomerUser>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("page") @ExcludeMissing page: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("pageSize") @ExcludeMissing pageSize: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("totalCount") @ExcludeMissing totalCount: JsonField<Int> = JsonMissing.of(),
        @JsonProperty("users")
        @ExcludeMissing
        users: JsonField<List<CustomerUser>> = JsonMissing.of(),
    ) : this(page, pageSize, totalCount, users, mutableMapOf())

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
    fun users(): Optional<List<CustomerUser>> = users.getOptional("users")

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
     * Returns the raw JSON value of [users].
     *
     * Unlike [users], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("users") @ExcludeMissing fun _users(): JsonField<List<CustomerUser>> = users

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

        /** Returns a mutable builder for constructing an instance of [UserListResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserListResponse]. */
    class Builder internal constructor() {

        private var page: JsonField<Int> = JsonMissing.of()
        private var pageSize: JsonField<Int> = JsonMissing.of()
        private var totalCount: JsonField<Int> = JsonMissing.of()
        private var users: JsonField<MutableList<CustomerUser>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(userListResponse: UserListResponse) = apply {
            page = userListResponse.page
            pageSize = userListResponse.pageSize
            totalCount = userListResponse.totalCount
            users = userListResponse.users.map { it.toMutableList() }
            additionalProperties = userListResponse.additionalProperties.toMutableMap()
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

        fun users(users: List<CustomerUser>) = users(JsonField.of(users))

        /**
         * Sets [Builder.users] to an arbitrary JSON value.
         *
         * You should usually call [Builder.users] with a well-typed `List<CustomerUser>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun users(users: JsonField<List<CustomerUser>>) = apply {
            this.users = users.map { it.toMutableList() }
        }

        /**
         * Adds a single [CustomerUser] to [users].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addUser(user: CustomerUser) = apply {
            users =
                (users ?: JsonField.of(mutableListOf())).also { checkKnown("users", it).add(user) }
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
         * Returns an immutable instance of [UserListResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UserListResponse =
            UserListResponse(
                page,
                pageSize,
                totalCount,
                (users ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): UserListResponse = apply {
        if (validated) {
            return@apply
        }

        page()
        pageSize()
        totalCount()
        users().ifPresent { it.forEach { it.validate() } }
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
        (if (page.asKnown().isPresent) 1 else 0) +
            (if (pageSize.asKnown().isPresent) 1 else 0) +
            (if (totalCount.asKnown().isPresent) 1 else 0) +
            (users.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserListResponse &&
            page == other.page &&
            pageSize == other.pageSize &&
            totalCount == other.totalCount &&
            users == other.users &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(page, pageSize, totalCount, users, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UserListResponse{page=$page, pageSize=$pageSize, totalCount=$totalCount, users=$users, additionalProperties=$additionalProperties}"
}
