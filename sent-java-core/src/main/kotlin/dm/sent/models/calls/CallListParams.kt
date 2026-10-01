// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import dm.sent.core.Params
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Retrieves a paginated list of your calls, most recent first. Filter by direction, status, the
 * owning number, and the time the call started (from and to are inclusive). Use the call webhooks
 * for real-time updates; this list is for looking calls up afterwards.
 */
class CallListParams
private constructor(
    private val direction: String?,
    private val from: OffsetDateTime?,
    private val number: String?,
    private val page: Int?,
    private val pageSize: Int?,
    private val status: String?,
    private val to: OffsetDateTime?,
    private val xProfileId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Optional direction filter: outbound for calls placed from your app, inbound for calls to one
     * of your numbers
     */
    fun direction(): Optional<String> = Optional.ofNullable(direction)

    /** Only calls started at or after this time (ISO 8601) */
    fun from(): Optional<OffsetDateTime> = Optional.ofNullable(from)

    /**
     * Optional filter on the number that owns the call, one of your voice-enabled numbers in E.164
     * format
     */
    fun number(): Optional<String> = Optional.ofNullable(number)

    /** Page number (1-indexed) */
    fun page(): Optional<Int> = Optional.ofNullable(page)

    /** Number of items per page */
    fun pageSize(): Optional<Int> = Optional.ofNullable(pageSize)

    /**
     * Optional status filter: initiated, ringing, answered, completed, failed, no_answer or
     * rejected
     */
    fun status(): Optional<String> = Optional.ofNullable(status)

    /** Only calls started at or before this time (ISO 8601) */
    fun to(): Optional<OffsetDateTime> = Optional.ofNullable(to)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): CallListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [CallListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CallListParams]. */
    class Builder internal constructor() {

        private var direction: String? = null
        private var from: OffsetDateTime? = null
        private var number: String? = null
        private var page: Int? = null
        private var pageSize: Int? = null
        private var status: String? = null
        private var to: OffsetDateTime? = null
        private var xProfileId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(callListParams: CallListParams) = apply {
            direction = callListParams.direction
            from = callListParams.from
            number = callListParams.number
            page = callListParams.page
            pageSize = callListParams.pageSize
            status = callListParams.status
            to = callListParams.to
            xProfileId = callListParams.xProfileId
            additionalHeaders = callListParams.additionalHeaders.toBuilder()
            additionalQueryParams = callListParams.additionalQueryParams.toBuilder()
        }

        /**
         * Optional direction filter: outbound for calls placed from your app, inbound for calls to
         * one of your numbers
         */
        fun direction(direction: String?) = apply { this.direction = direction }

        /** Alias for calling [Builder.direction] with `direction.orElse(null)`. */
        fun direction(direction: Optional<String>) = direction(direction.getOrNull())

        /** Only calls started at or after this time (ISO 8601) */
        fun from(from: OffsetDateTime?) = apply { this.from = from }

        /** Alias for calling [Builder.from] with `from.orElse(null)`. */
        fun from(from: Optional<OffsetDateTime>) = from(from.getOrNull())

        /**
         * Optional filter on the number that owns the call, one of your voice-enabled numbers in
         * E.164 format
         */
        fun number(number: String?) = apply { this.number = number }

        /** Alias for calling [Builder.number] with `number.orElse(null)`. */
        fun number(number: Optional<String>) = number(number.getOrNull())

        /** Page number (1-indexed) */
        fun page(page: Int?) = apply { this.page = page }

        /**
         * Alias for [Builder.page].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun page(page: Int) = page(page as Int?)

        /** Alias for calling [Builder.page] with `page.orElse(null)`. */
        fun page(page: Optional<Int>) = page(page.getOrNull())

        /** Number of items per page */
        fun pageSize(pageSize: Int?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Int) = pageSize(pageSize as Int?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Int>) = pageSize(pageSize.getOrNull())

        /**
         * Optional status filter: initiated, ringing, answered, completed, failed, no_answer or
         * rejected
         */
        fun status(status: String?) = apply { this.status = status }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<String>) = status(status.getOrNull())

        /** Only calls started at or before this time (ISO 8601) */
        fun to(to: OffsetDateTime?) = apply { this.to = to }

        /** Alias for calling [Builder.to] with `to.orElse(null)`. */
        fun to(to: Optional<OffsetDateTime>) = to(to.getOrNull())

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
         * Returns an immutable instance of [CallListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CallListParams =
            CallListParams(
                direction,
                from,
                number,
                page,
                pageSize,
                status,
                to,
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
                direction?.let { put("direction", it) }
                from?.let { put("from", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(it)) }
                number?.let { put("number", it) }
                page?.let { put("page", it.toString()) }
                pageSize?.let { put("page_size", it.toString()) }
                status?.let { put("status", it) }
                to?.let { put("to", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(it)) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallListParams &&
            direction == other.direction &&
            from == other.from &&
            number == other.number &&
            page == other.page &&
            pageSize == other.pageSize &&
            status == other.status &&
            to == other.to &&
            xProfileId == other.xProfileId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            direction,
            from,
            number,
            page,
            pageSize,
            status,
            to,
            xProfileId,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "CallListParams{direction=$direction, from=$from, number=$number, page=$page, pageSize=$pageSize, status=$status, to=$to, xProfileId=$xProfileId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
