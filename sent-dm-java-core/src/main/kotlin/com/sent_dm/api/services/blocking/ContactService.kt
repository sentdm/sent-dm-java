// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.contacts.ContactListItem
import com.sent_dm.api.models.contacts.ContactListParams
import com.sent_dm.api.models.contacts.ContactListResponse
import com.sent_dm.api.models.contacts.ContactRetrieveByPhoneParams
import com.sent_dm.api.models.contacts.ContactRetrieveIdParams
import java.util.function.Consumer

interface ContactService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContactService

    /**
     * Retrieves a paginated list of contacts for the authenticated customer. Supports server-side
     * pagination with configurable page size. The customer ID is extracted from the authentication
     * token.
     */
    fun list(params: ContactListParams): ContactListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListResponse

    /**
     * Retrieves a contact by their phone number for the authenticated customer. Phone number should
     * be in international format (e.g., +1234567890). The customer ID is extracted from the
     * authentication token.
     */
    fun retrieveByPhone(params: ContactRetrieveByPhoneParams): ContactListItem =
        retrieveByPhone(params, RequestOptions.none())

    /** @see retrieveByPhone */
    fun retrieveByPhone(
        params: ContactRetrieveByPhoneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListItem

    /**
     * Retrieves a specific contact by their unique identifier for the authenticated customer. The
     * customer ID is extracted from the authentication token. Returns detailed contact information
     * including phone number and creation timestamp.
     */
    fun retrieveId(params: ContactRetrieveIdParams): ContactListItem =
        retrieveId(params, RequestOptions.none())

    /** @see retrieveId */
    fun retrieveId(
        params: ContactRetrieveIdParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListItem

    /** A view of [ContactService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContactService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/contacts`, but is otherwise the same as
         * [ContactService.list].
         */
        @MustBeClosed
        fun list(params: ContactListParams): HttpResponseFor<ContactListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ContactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListResponse>

        /**
         * Returns a raw HTTP response for `get /v2/contacts/phone`, but is otherwise the same as
         * [ContactService.retrieveByPhone].
         */
        @MustBeClosed
        fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams
        ): HttpResponseFor<ContactListItem> = retrieveByPhone(params, RequestOptions.none())

        /** @see retrieveByPhone */
        @MustBeClosed
        fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListItem>

        /**
         * Returns a raw HTTP response for `get /v2/contacts/id`, but is otherwise the same as
         * [ContactService.retrieveId].
         */
        @MustBeClosed
        fun retrieveId(params: ContactRetrieveIdParams): HttpResponseFor<ContactListItem> =
            retrieveId(params, RequestOptions.none())

        /** @see retrieveId */
        @MustBeClosed
        fun retrieveId(
            params: ContactRetrieveIdParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListItem>
    }
}
