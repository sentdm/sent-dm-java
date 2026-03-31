// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import dm.sent.core.Params
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Retrieves a paginated list of message templates for the authenticated customer. Supports
 * filtering by status, category, and search term.
 */
class TemplateListParams
private constructor(
    private val page: Int,
    private val pageSize: Int,
    private val category: String?,
    private val isWelcomePlayground: Boolean?,
    private val search: String?,
    private val status: String?,
    private val xProfileId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Page number (1-indexed) */
    fun page(): Int = page

    /** Number of items per page */
    fun pageSize(): Int = pageSize

    /** Optional category filter: MARKETING, UTILITY, AUTHENTICATION */
    fun category(): Optional<String> = Optional.ofNullable(category)

    /** Optional filter by welcome playground flag */
    fun isWelcomePlayground(): Optional<Boolean> = Optional.ofNullable(isWelcomePlayground)

    /** Optional search term for filtering templates */
    fun search(): Optional<String> = Optional.ofNullable(search)

    /** Optional status filter: APPROVED, PENDING, REJECTED */
    fun status(): Optional<String> = Optional.ofNullable(status)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TemplateListParams].
         *
         * The following fields are required:
         * ```java
         * .page()
         * .pageSize()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateListParams]. */
    class Builder internal constructor() {

        private var page: Int? = null
        private var pageSize: Int? = null
        private var category: String? = null
        private var isWelcomePlayground: Boolean? = null
        private var search: String? = null
        private var status: String? = null
        private var xProfileId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(templateListParams: TemplateListParams) = apply {
            page = templateListParams.page
            pageSize = templateListParams.pageSize
            category = templateListParams.category
            isWelcomePlayground = templateListParams.isWelcomePlayground
            search = templateListParams.search
            status = templateListParams.status
            xProfileId = templateListParams.xProfileId
            additionalHeaders = templateListParams.additionalHeaders.toBuilder()
            additionalQueryParams = templateListParams.additionalQueryParams.toBuilder()
        }

        /** Page number (1-indexed) */
        fun page(page: Int) = apply { this.page = page }

        /** Number of items per page */
        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        /** Optional category filter: MARKETING, UTILITY, AUTHENTICATION */
        fun category(category: String?) = apply { this.category = category }

        /** Alias for calling [Builder.category] with `category.orElse(null)`. */
        fun category(category: Optional<String>) = category(category.getOrNull())

        /** Optional filter by welcome playground flag */
        fun isWelcomePlayground(isWelcomePlayground: Boolean?) = apply {
            this.isWelcomePlayground = isWelcomePlayground
        }

        /**
         * Alias for [Builder.isWelcomePlayground].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun isWelcomePlayground(isWelcomePlayground: Boolean) =
            isWelcomePlayground(isWelcomePlayground as Boolean?)

        /**
         * Alias for calling [Builder.isWelcomePlayground] with `isWelcomePlayground.orElse(null)`.
         */
        fun isWelcomePlayground(isWelcomePlayground: Optional<Boolean>) =
            isWelcomePlayground(isWelcomePlayground.getOrNull())

        /** Optional search term for filtering templates */
        fun search(search: String?) = apply { this.search = search }

        /** Alias for calling [Builder.search] with `search.orElse(null)`. */
        fun search(search: Optional<String>) = search(search.getOrNull())

        /** Optional status filter: APPROVED, PENDING, REJECTED */
        fun status(status: String?) = apply { this.status = status }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        fun xProfileId(xProfileId: String?) = apply { this.xProfileId = xProfileId }

        /** Alias for calling [Builder.xProfileId] with `xProfileId.orElse(null)`. */
        fun xProfileId(xProfileId: Optional<String>) = xProfileId(xProfileId.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [TemplateListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .page()
         * .pageSize()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TemplateListParams =
            TemplateListParams(
                checkRequired("page", page),
                checkRequired("pageSize", pageSize),
                category,
                isWelcomePlayground,
                search,
                status,
                xProfileId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("page", page.toString())
                put("page_size", pageSize.toString())
                category?.let { put("category", it) }
                isWelcomePlayground?.let { put("is_welcome_playground", it.toString()) }
                search?.let { put("search", it) }
                status?.let { put("status", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateListParams &&
            page == other.page &&
            pageSize == other.pageSize &&
            category == other.category &&
            isWelcomePlayground == other.isWelcomePlayground &&
            search == other.search &&
            status == other.status &&
            xProfileId == other.xProfileId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            page,
            pageSize,
            category,
            isWelcomePlayground,
            search,
            status,
            xProfileId,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "TemplateListParams{page=$page, pageSize=$pageSize, category=$category, isWelcomePlayground=$isWelcomePlayground, search=$search, status=$status, xProfileId=$xProfileId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
