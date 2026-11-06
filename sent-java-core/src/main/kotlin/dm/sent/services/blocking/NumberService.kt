// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.numbers.ApiResponseOfNumberLookupResult
import dm.sent.models.numbers.NumberLookupParams
import java.util.function.Consumer

/**
 * What a phone number actually is, before you send to it.
 *
 * A lookup returns the number's country, line type and carrier, which is what decides whether it is
 * reachable on a channel and what it costs. Worth doing on import rather than on send: a landline
 * in a contact list is a message that can never be delivered.
 */
interface NumberService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberService

    /**
     * Retrieves detailed information about a phone number including carrier, line type, porting
     * status, and VoIP detection. Uses the customer's messaging provider for rich data, with
     * fallback to the internal index.
     */
    fun lookup(phoneNumber: String): ApiResponseOfNumberLookupResult =
        lookup(phoneNumber, NumberLookupParams.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfNumberLookupResult =
        lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
    ): ApiResponseOfNumberLookupResult = lookup(phoneNumber, params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: NumberLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfNumberLookupResult

    /** @see lookup */
    fun lookup(params: NumberLookupParams): ApiResponseOfNumberLookupResult =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        requestOptions: RequestOptions,
    ): ApiResponseOfNumberLookupResult =
        lookup(phoneNumber, NumberLookupParams.none(), requestOptions)

    /** A view of [NumberService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/numbers/lookup/{phoneNumber}`, but is otherwise
         * the same as [NumberService.lookup].
         */
        @MustBeClosed
        fun lookup(phoneNumber: String): HttpResponseFor<ApiResponseOfNumberLookupResult> =
            lookup(phoneNumber, NumberLookupParams.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfNumberLookupResult> =
            lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
        ): HttpResponseFor<ApiResponseOfNumberLookupResult> =
            lookup(phoneNumber, params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: NumberLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfNumberLookupResult>

        /** @see lookup */
        @MustBeClosed
        fun lookup(params: NumberLookupParams): HttpResponseFor<ApiResponseOfNumberLookupResult> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfNumberLookupResult> =
            lookup(phoneNumber, NumberLookupParams.none(), requestOptions)
    }
}
