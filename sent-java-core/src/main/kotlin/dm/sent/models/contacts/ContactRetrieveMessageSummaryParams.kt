// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.Params
import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns aggregate message counts, time bounds, channels used, and per-channel success/fail scores
 * (each as a percentage 0-100 of messages on that channel) for one of your contacts. Successful
 * terminal states: SENT/DELIVERED/READ for outbound, RECEIVED for inbound. Fail: FAILED.
 */
class ContactRetrieveMessageSummaryParams
private constructor(
    private val contactId: String?,
    private val xProfileId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun contactId(): Optional<String> = Optional.ofNullable(contactId)

    fun xProfileId(): Optional<String> = Optional.ofNullable(xProfileId)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ContactRetrieveMessageSummaryParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [ContactRetrieveMessageSummaryParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactRetrieveMessageSummaryParams]. */
    class Builder internal constructor() {

        private var contactId: String? = null
        private var xProfileId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(
            contactRetrieveMessageSummaryParams: ContactRetrieveMessageSummaryParams
        ) = apply {
            contactId = contactRetrieveMessageSummaryParams.contactId
            xProfileId = contactRetrieveMessageSummaryParams.xProfileId
            additionalHeaders = contactRetrieveMessageSummaryParams.additionalHeaders.toBuilder()
            additionalQueryParams =
                contactRetrieveMessageSummaryParams.additionalQueryParams.toBuilder()
        }

        fun contactId(contactId: String?) = apply { this.contactId = contactId }

        /** Alias for calling [Builder.contactId] with `contactId.orElse(null)`. */
        fun contactId(contactId: Optional<String>) = contactId(contactId.getOrNull())

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
         * Returns an immutable instance of [ContactRetrieveMessageSummaryParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContactRetrieveMessageSummaryParams =
            ContactRetrieveMessageSummaryParams(
                contactId,
                xProfileId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> contactId ?: ""
            else -> ""
        }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                xProfileId?.let { put("x-profile-id", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactRetrieveMessageSummaryParams &&
            contactId == other.contactId &&
            xProfileId == other.xProfileId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(contactId, xProfileId, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ContactRetrieveMessageSummaryParams{contactId=$contactId, xProfileId=$xProfileId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
