// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.numberlookup.NumberLookupRetrieveParams
import com.sent_dm.api.models.numberlookup.NumberLookupRetrieveResponse
import java.util.function.Consumer

interface NumberLookupService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberLookupService

    /**
     * Retrieves detailed information about a phone number including validation, formatting, country
     * information, and available messaging channels. The customer ID is extracted from the
     * authentication token.
     */
    fun retrieve(params: NumberLookupRetrieveParams): NumberLookupRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: NumberLookupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NumberLookupRetrieveResponse

    /**
     * A view of [NumberLookupService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NumberLookupService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/number-lookup`, but is otherwise the same as
         * [NumberLookupService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: NumberLookupRetrieveParams
        ): HttpResponseFor<NumberLookupRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: NumberLookupRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NumberLookupRetrieveResponse>
    }
}
