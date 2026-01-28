// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.numberlookup.NumberLookupRetrieveParams
import dm.sent.models.numberlookup.NumberLookupRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface NumberLookupServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberLookupServiceAsync

    /**
     * Retrieves detailed information about a phone number including validation, formatting, country
     * information, and available messaging channels. The customer ID is extracted from the
     * authentication token.
     */
    fun retrieve(
        params: NumberLookupRetrieveParams
    ): CompletableFuture<NumberLookupRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: NumberLookupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<NumberLookupRetrieveResponse>

    /**
     * A view of [NumberLookupServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NumberLookupServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/number-lookup`, but is otherwise the same as
         * [NumberLookupServiceAsync.retrieve].
         */
        fun retrieve(
            params: NumberLookupRetrieveParams
        ): CompletableFuture<HttpResponseFor<NumberLookupRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: NumberLookupRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<NumberLookupRetrieveResponse>>
    }
}
