// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.numbers.NumberLookupParams
import dm.sent.models.numbers.NumberLookupResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Manage and lookup phone numbers */
interface NumberServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberServiceAsync

    /**
     * Retrieves detailed information about a phone number including carrier, line type, porting
     * status, and VoIP detection. Uses the customer's messaging provider for rich data, with
     * fallback to the internal index.
     */
    fun lookup(phoneNumber: String): CompletableFuture<NumberLookupResponse> =
        lookup(phoneNumber, NumberLookupParams.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NumberLookupResponse> =
        lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
    ): CompletableFuture<NumberLookupResponse> = lookup(phoneNumber, params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: NumberLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NumberLookupResponse>

    /** @see lookup */
    fun lookup(params: NumberLookupParams): CompletableFuture<NumberLookupResponse> =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<NumberLookupResponse> =
        lookup(phoneNumber, NumberLookupParams.none(), requestOptions)

    /**
     * A view of [NumberServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NumberServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/numbers/lookup/{phoneNumber}`, but is otherwise
         * the same as [NumberServiceAsync.lookup].
         */
        fun lookup(phoneNumber: String): CompletableFuture<HttpResponseFor<NumberLookupResponse>> =
            lookup(phoneNumber, NumberLookupParams.none())

        /** @see lookup */
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NumberLookupResponse>> =
            lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see lookup */
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
        ): CompletableFuture<HttpResponseFor<NumberLookupResponse>> =
            lookup(phoneNumber, params, RequestOptions.none())

        /** @see lookup */
        fun lookup(
            params: NumberLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NumberLookupResponse>>

        /** @see lookup */
        fun lookup(
            params: NumberLookupParams
        ): CompletableFuture<HttpResponseFor<NumberLookupResponse>> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        fun lookup(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NumberLookupResponse>> =
            lookup(phoneNumber, NumberLookupParams.none(), requestOptions)
    }
}
