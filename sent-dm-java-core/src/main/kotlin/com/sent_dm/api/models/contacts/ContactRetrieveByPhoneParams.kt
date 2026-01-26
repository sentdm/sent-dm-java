// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.sent_dm.api.core.Params
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import java.util.Objects

/**
 * Retrieves a contact by their phone number for the authenticated customer. Phone number should be
 * in international format (e.g., +1234567890). The customer ID is extracted from the authentication
 * token.
 */
class ContactRetrieveByPhoneParams
private constructor(
    private val phoneNumber: String,
    private val xApiKey: String,
    private val xSenderId: String,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** The phone number in international format (e.g., +1234567890) */
    fun phoneNumber(): String = phoneNumber

    fun xApiKey(): String = xApiKey

    fun xSenderId(): String = xSenderId

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContactRetrieveByPhoneParams].
         *
         * The following fields are required:
         * ```java
         * .phoneNumber()
         * .xApiKey()
         * .xSenderId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContactRetrieveByPhoneParams]. */
    class Builder internal constructor() {

        private var phoneNumber: String? = null
        private var xApiKey: String? = null
        private var xSenderId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(contactRetrieveByPhoneParams: ContactRetrieveByPhoneParams) = apply {
            phoneNumber = contactRetrieveByPhoneParams.phoneNumber
            xApiKey = contactRetrieveByPhoneParams.xApiKey
            xSenderId = contactRetrieveByPhoneParams.xSenderId
            additionalHeaders = contactRetrieveByPhoneParams.additionalHeaders.toBuilder()
            additionalQueryParams = contactRetrieveByPhoneParams.additionalQueryParams.toBuilder()
        }

        /** The phone number in international format (e.g., +1234567890) */
        fun phoneNumber(phoneNumber: String) = apply { this.phoneNumber = phoneNumber }

        fun xApiKey(xApiKey: String) = apply { this.xApiKey = xApiKey }

        fun xSenderId(xSenderId: String) = apply { this.xSenderId = xSenderId }

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
         * Returns an immutable instance of [ContactRetrieveByPhoneParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .phoneNumber()
         * .xApiKey()
         * .xSenderId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ContactRetrieveByPhoneParams =
            ContactRetrieveByPhoneParams(
                checkRequired("phoneNumber", phoneNumber),
                checkRequired("xApiKey", xApiKey),
                checkRequired("xSenderId", xSenderId),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                put("x-api-key", xApiKey)
                put("x-sender-id", xSenderId)
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("phoneNumber", phoneNumber)
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactRetrieveByPhoneParams &&
            phoneNumber == other.phoneNumber &&
            xApiKey == other.xApiKey &&
            xSenderId == other.xSenderId &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(phoneNumber, xApiKey, xSenderId, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ContactRetrieveByPhoneParams{phoneNumber=$phoneNumber, xApiKey=$xApiKey, xSenderId=$xSenderId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
