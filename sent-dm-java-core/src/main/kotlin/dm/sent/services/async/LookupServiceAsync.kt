// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.lookup.LookupRetrievePhoneInfoParams
import dm.sent.models.lookup.LookupRetrievePhoneInfoResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface LookupServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LookupServiceAsync

    /**
     * Validates a phone number and retrieves formatting, country, and timezone information from the
     * internal index. Provider-agnostic and works for all customers.
     */
    fun retrievePhoneInfo(phoneNumber: String): CompletableFuture<LookupRetrievePhoneInfoResponse> =
        retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none())

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        phoneNumber: String,
        params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LookupRetrievePhoneInfoResponse> =
        retrievePhoneInfo(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        phoneNumber: String,
        params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
    ): CompletableFuture<LookupRetrievePhoneInfoResponse> =
        retrievePhoneInfo(phoneNumber, params, RequestOptions.none())

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        params: LookupRetrievePhoneInfoParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LookupRetrievePhoneInfoResponse>

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        params: LookupRetrievePhoneInfoParams
    ): CompletableFuture<LookupRetrievePhoneInfoResponse> =
        retrievePhoneInfo(params, RequestOptions.none())

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        phoneNumber: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<LookupRetrievePhoneInfoResponse> =
        retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none(), requestOptions)

    /**
     * A view of [LookupServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LookupServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/lookup/number/{phoneNumber}`, but is otherwise
         * the same as [LookupServiceAsync.retrievePhoneInfo].
         */
        fun retrievePhoneInfo(
            phoneNumber: String
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>> =
            retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none())

        /** @see retrievePhoneInfo */
        fun retrievePhoneInfo(
            phoneNumber: String,
            params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>> =
            retrievePhoneInfo(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see retrievePhoneInfo */
        fun retrievePhoneInfo(
            phoneNumber: String,
            params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>> =
            retrievePhoneInfo(phoneNumber, params, RequestOptions.none())

        /** @see retrievePhoneInfo */
        fun retrievePhoneInfo(
            params: LookupRetrievePhoneInfoParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>>

        /** @see retrievePhoneInfo */
        fun retrievePhoneInfo(
            params: LookupRetrievePhoneInfoParams
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>> =
            retrievePhoneInfo(params, RequestOptions.none())

        /** @see retrievePhoneInfo */
        fun retrievePhoneInfo(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>> =
            retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none(), requestOptions)
    }
}
