// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.lookup.LookupRetrievePhoneInfoParams
import dm.sent.models.lookup.LookupRetrievePhoneInfoResponse
import java.util.function.Consumer

interface LookupService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LookupService

    /**
     * Validates a phone number and retrieves formatting, country, and timezone information from the
     * internal index. Provider-agnostic and works for all customers.
     */
    fun retrievePhoneInfo(phoneNumber: String): LookupRetrievePhoneInfoResponse =
        retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none())

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        phoneNumber: String,
        params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LookupRetrievePhoneInfoResponse =
        retrievePhoneInfo(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        phoneNumber: String,
        params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
    ): LookupRetrievePhoneInfoResponse =
        retrievePhoneInfo(phoneNumber, params, RequestOptions.none())

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        params: LookupRetrievePhoneInfoParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LookupRetrievePhoneInfoResponse

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(params: LookupRetrievePhoneInfoParams): LookupRetrievePhoneInfoResponse =
        retrievePhoneInfo(params, RequestOptions.none())

    /** @see retrievePhoneInfo */
    fun retrievePhoneInfo(
        phoneNumber: String,
        requestOptions: RequestOptions,
    ): LookupRetrievePhoneInfoResponse =
        retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none(), requestOptions)

    /** A view of [LookupService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LookupService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/lookup/number/{phoneNumber}`, but is otherwise
         * the same as [LookupService.retrievePhoneInfo].
         */
        @MustBeClosed
        fun retrievePhoneInfo(
            phoneNumber: String
        ): HttpResponseFor<LookupRetrievePhoneInfoResponse> =
            retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none())

        /** @see retrievePhoneInfo */
        @MustBeClosed
        fun retrievePhoneInfo(
            phoneNumber: String,
            params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LookupRetrievePhoneInfoResponse> =
            retrievePhoneInfo(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see retrievePhoneInfo */
        @MustBeClosed
        fun retrievePhoneInfo(
            phoneNumber: String,
            params: LookupRetrievePhoneInfoParams = LookupRetrievePhoneInfoParams.none(),
        ): HttpResponseFor<LookupRetrievePhoneInfoResponse> =
            retrievePhoneInfo(phoneNumber, params, RequestOptions.none())

        /** @see retrievePhoneInfo */
        @MustBeClosed
        fun retrievePhoneInfo(
            params: LookupRetrievePhoneInfoParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LookupRetrievePhoneInfoResponse>

        /** @see retrievePhoneInfo */
        @MustBeClosed
        fun retrievePhoneInfo(
            params: LookupRetrievePhoneInfoParams
        ): HttpResponseFor<LookupRetrievePhoneInfoResponse> =
            retrievePhoneInfo(params, RequestOptions.none())

        /** @see retrievePhoneInfo */
        @MustBeClosed
        fun retrievePhoneInfo(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LookupRetrievePhoneInfoResponse> =
            retrievePhoneInfo(phoneNumber, LookupRetrievePhoneInfoParams.none(), requestOptions)
    }
}
