// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.contacts.ContactListItem
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactListResponse
import dm.sent.models.contacts.ContactRetrieveByPhoneParams
import dm.sent.models.contacts.ContactRetrieveIdParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ContactServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContactServiceAsync

    /**
     * Retrieves a paginated list of contacts for the authenticated customer. Supports server-side
     * pagination with configurable page size. The customer ID is extracted from the authentication
     * token.
     */
    fun list(params: ContactListParams): CompletableFuture<ContactListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactListResponse>

    /**
     * Retrieves a contact by their phone number for the authenticated customer. Phone number should
     * be in international format (e.g., +1234567890). The customer ID is extracted from the
     * authentication token.
     */
    fun retrieveByPhone(params: ContactRetrieveByPhoneParams): CompletableFuture<ContactListItem> =
        retrieveByPhone(params, RequestOptions.none())

    /** @see retrieveByPhone */
    fun retrieveByPhone(
        params: ContactRetrieveByPhoneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactListItem>

    /**
     * Retrieves a specific contact by their unique identifier for the authenticated customer. The
     * customer ID is extracted from the authentication token. Returns detailed contact information
     * including phone number and creation timestamp.
     */
    fun retrieveId(params: ContactRetrieveIdParams): CompletableFuture<ContactListItem> =
        retrieveId(params, RequestOptions.none())

    /** @see retrieveId */
    fun retrieveId(
        params: ContactRetrieveIdParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactListItem>

    /**
     * A view of [ContactServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContactServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/contacts`, but is otherwise the same as
         * [ContactServiceAsync.list].
         */
        fun list(
            params: ContactListParams
        ): CompletableFuture<HttpResponseFor<ContactListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: ContactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactListResponse>>

        /**
         * Returns a raw HTTP response for `get /v2/contacts/phone`, but is otherwise the same as
         * [ContactServiceAsync.retrieveByPhone].
         */
        fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams
        ): CompletableFuture<HttpResponseFor<ContactListItem>> =
            retrieveByPhone(params, RequestOptions.none())

        /** @see retrieveByPhone */
        fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactListItem>>

        /**
         * Returns a raw HTTP response for `get /v2/contacts/id`, but is otherwise the same as
         * [ContactServiceAsync.retrieveId].
         */
        fun retrieveId(
            params: ContactRetrieveIdParams
        ): CompletableFuture<HttpResponseFor<ContactListItem>> =
            retrieveId(params, RequestOptions.none())

        /** @see retrieveId */
        fun retrieveId(
            params: ContactRetrieveIdParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactListItem>>
    }
}
