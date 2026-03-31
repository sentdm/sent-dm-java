// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.numbers.NumberLookupParams
import dm.sent.models.numbers.NumberLookupResponse
import java.util.function.Consumer

/** Manage and lookup phone numbers */
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
    fun lookup(phoneNumber: String): NumberLookupResponse =
        lookup(phoneNumber, NumberLookupParams.none())

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NumberLookupResponse =
        lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see lookup */
    fun lookup(
        phoneNumber: String,
        params: NumberLookupParams = NumberLookupParams.none(),
    ): NumberLookupResponse = lookup(phoneNumber, params, RequestOptions.none())

    /** @see lookup */
    fun lookup(
        params: NumberLookupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): NumberLookupResponse

    /** @see lookup */
    fun lookup(params: NumberLookupParams): NumberLookupResponse =
        lookup(params, RequestOptions.none())

    /** @see lookup */
    fun lookup(phoneNumber: String, requestOptions: RequestOptions): NumberLookupResponse =
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
        fun lookup(phoneNumber: String): HttpResponseFor<NumberLookupResponse> =
            lookup(phoneNumber, NumberLookupParams.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NumberLookupResponse> =
            lookup(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            phoneNumber: String,
            params: NumberLookupParams = NumberLookupParams.none(),
        ): HttpResponseFor<NumberLookupResponse> =
            lookup(phoneNumber, params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            params: NumberLookupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<NumberLookupResponse>

        /** @see lookup */
        @MustBeClosed
        fun lookup(params: NumberLookupParams): HttpResponseFor<NumberLookupResponse> =
            lookup(params, RequestOptions.none())

        /** @see lookup */
        @MustBeClosed
        fun lookup(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<NumberLookupResponse> =
            lookup(phoneNumber, NumberLookupParams.none(), requestOptions)
    }
}
