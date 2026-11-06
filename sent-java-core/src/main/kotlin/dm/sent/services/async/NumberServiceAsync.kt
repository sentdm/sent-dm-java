// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.numbers.ApiResponseOfNumberLookupResult
import dm.sent.models.numbers.NumberLookupParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * What a phone number actually is, before you send to it.
 *
 * A lookup returns the number's country, line type and carrier, which is what decides whether it is
 * reachable on a channel and what it costs. Worth doing on import rather than on send: a landline
 * in a contact list is a message that can never be delivered.
 */
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
    fun lookup(phoneNumber: String): CompletableFuture<ApiResponseOfNumberLookupResult> =
        lookup(phoneNumber, NumberLookupParams.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfNumberLookupResult> =
        lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
    ): CompletableFuture<ApiResponseOfNumberLookupResult> =
        lookup(phoneNumber, params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: NumberLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfNumberLookupResult>

    /** @see lookup */
    fun lookup(params: NumberLookupParams): CompletableFuture<ApiResponseOfNumberLookupResult> =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfNumberLookupResult> =
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
        fun lookup(
            phoneNumber: String
        ): CompletableFuture<HttpResponseFor<ApiResponseOfNumberLookupResult>> =
            lookup(phoneNumber, NumberLookupParams.none())

        /** @see lookup */
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfNumberLookupResult>> =
            lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see lookup */
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfNumberLookupResult>> =
            lookup(phoneNumber, params, RequestOptions.none())

        /** @see lookup */
        fun lookup(
            params: NumberLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfNumberLookupResult>>

        /** @see lookup */
        fun lookup(
            params: NumberLookupParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfNumberLookupResult>> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        fun lookup(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfNumberLookupResult>> =
            lookup(phoneNumber, NumberLookupParams.none(), requestOptions)
    }
}
