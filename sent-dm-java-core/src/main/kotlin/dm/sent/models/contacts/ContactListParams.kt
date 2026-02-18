// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.Params
import dm.sent.core.checkRequired
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Retrieves a paginated list of contacts for the authenticated customer. Supports filtering by
 * search term, channel, or phone number.
 */
class ContactListParams
private constructor(
    private val page: Int,
    private val pageSize: Int,
    private val channel: String?,
    private val phone: String?,
    private val search: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Page number (1-indexed) */
    fun page(): Int = page

    fun pageSize(): Int = pageSize

    /** Optional channel filter (sms, whatsapp) */
    fun channel(): Optional<String> = Optional.ofNullable(channel)

    /** Optional phone number filter (alternative to list view) */
    fun phone(): Optional<String> = Optional.ofNullable(phone)

    /** Optional search term for filtering contacts */
    fun search(): Optional<String> = Optional.ofNullable(search)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContactListParams].
         *
         * The following fields are required:
         * ```java
         * .page()
         * .pageSize()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactListParams]. */
    class Builder internal constructor() {

        private var page: Int? = null
        private var pageSize: Int? = null
        private var channel: String? = null
        private var phone: String? = null
        private var search: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(contactListParams: ContactListParams) = apply {
            page = contactListParams.page
            pageSize = contactListParams.pageSize
            channel = contactListParams.channel
            phone = contactListParams.phone
            search = contactListParams.search
            additionalHeaders = contactListParams.additionalHeaders.toBuilder()
            additionalQueryParams = contactListParams.additionalQueryParams.toBuilder()
        }

        /** Page number (1-indexed) */
        fun page(page: Int) = apply { this.page = page }

        fun pageSize(pageSize: Int) = apply { this.pageSize = pageSize }

        /** Optional channel filter (sms, whatsapp) */
        fun channel(channel: String?) = apply { this.channel = channel }

        /** Alias for calling [Builder.channel] with `channel.orElse(null)`. */
        fun channel(channel: Optional<String>) = channel(channel.getOrNull())

        /** Optional phone number filter (alternative to list view) */
        fun phone(phone: String?) = apply { this.phone = phone }

        /** Alias for calling [Builder.phone] with `phone.orElse(null)`. */
        fun phone(phone: Optional<String>) = phone(phone.getOrNull())

        /** Optional search term for filtering contacts */
        fun search(search: String?) = apply { this.search = search }

        /** Alias for calling [Builder.search] with `search.orElse(null)`. */
        fun search(search: Optional<String>) = search(search.getOrNull())

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
         * Returns an immutable instance of [ContactListParams].
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
        fun build(): ContactListParams =
            ContactListParams(
                checkRequired("page", page),
                checkRequired("pageSize", pageSize),
                channel,
                phone,
                search,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("page", page.toString())
                put("pageSize", pageSize.toString())
                channel?.let { put("channel", it) }
                phone?.let { put("phone", it) }
                search?.let { put("search", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactListParams &&
            page == other.page &&
            pageSize == other.pageSize &&
            channel == other.channel &&
            phone == other.phone &&
            search == other.search &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            page,
            pageSize,
            channel,
            phone,
            search,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ContactListParams{page=$page, pageSize=$pageSize, channel=$channel, phone=$phone, search=$search, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
