// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.contacts.ContactCreateParams
import dm.sent.models.contacts.ContactCreateResponse
import dm.sent.models.contacts.ContactDeleteParams
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactListResponse
import dm.sent.models.contacts.ContactRetrieveMessageSummaryParams
import dm.sent.models.contacts.ContactRetrieveMessageSummaryResponse
import dm.sent.models.contacts.ContactRetrieveParams
import dm.sent.models.contacts.ContactRetrieveResponse
import dm.sent.models.contacts.ContactUpdateParams
import dm.sent.models.contacts.ContactUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * The people you message, and their channel identities.
 *
 * A contact holds one identity per channel — a phone number, a WhatsApp number — so routing can
 * choose between them for the same person. Opt-out is recorded against the contact and honoured on
 * every send, whichever channel it came through.
 *
 * `GET /v3/contacts/{id}/message-summary` is the per-contact view of what you have sent and what
 * happened to it.
 */
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

    /** Creates a new contact by phone number and associates it with the authenticated customer. */
    fun create(params: ContactCreateParams): CompletableFuture<ContactCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactCreateResponse>

    /**
     * Retrieves a specific contact by their unique identifier. Returns detailed contact information
     * including phone formats, available channels, and opt-out status.
     */
    fun retrieve(id: String): CompletableFuture<ContactRetrieveResponse> =
        retrieve(id, ContactRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactRetrieveResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
    ): CompletableFuture<ContactRetrieveResponse> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactRetrieveResponse>

    /** @see retrieve */
    fun retrieve(params: ContactRetrieveParams): CompletableFuture<ContactRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContactRetrieveResponse> =
        retrieve(id, ContactRetrieveParams.none(), requestOptions)

    /** Updates a contact's default channel and/or opt-out status. */
    fun update(id: String): CompletableFuture<ContactUpdateResponse> =
        update(id, ContactUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactUpdateResponse> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
    ): CompletableFuture<ContactUpdateResponse> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ContactUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactUpdateResponse>

    /** @see update */
    fun update(params: ContactUpdateParams): CompletableFuture<ContactUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContactUpdateResponse> =
        update(id, ContactUpdateParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of contacts for the authenticated customer. Supports filtering by
     * search term, channel, or phone number.
     */
    fun list(params: ContactListParams): CompletableFuture<ContactListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactListResponse>

    /**
     * **Deprecated.** Use `PATCH /v3/contacts/{id}` with `{"opt_out": true}` instead, and expect
     * this to be removed in a future release. It still behaves exactly as before, so nothing needs
     * to change today.
     *
     * Opting a contact out stops every send to them, which is what deleting one was mostly used for
     * — and it keeps the record of who they were and that they asked. A delete discards the consent
     * history along with the contact, which is the part you need if anyone ever asks why you
     * stopped, or why you started again.
     *
     * Dissociates a contact from the authenticated customer.
     */
    @Deprecated("deprecated")
    fun delete(id: String): CompletableFuture<Void?> = delete(id, ContactDeleteParams.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(
        id: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(
        id: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(
        params: ContactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(params: ContactDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, ContactDeleteParams.none(), requestOptions)

    /**
     * Returns aggregate message counts, time bounds, channels used, and per-channel success/fail
     * scores (each as a percentage 0-100 of messages on that channel) for one of your contacts.
     * Successful terminal states: SENT/DELIVERED/READ for outbound, RECEIVED for inbound. Fail:
     * FAILED.
     */
    fun retrieveMessageSummary(
        contactId: String
    ): CompletableFuture<ContactRetrieveMessageSummaryResponse> =
        retrieveMessageSummary(contactId, ContactRetrieveMessageSummaryParams.none())

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        contactId: String,
        params: ContactRetrieveMessageSummaryParams = ContactRetrieveMessageSummaryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactRetrieveMessageSummaryResponse> =
        retrieveMessageSummary(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        contactId: String,
        params: ContactRetrieveMessageSummaryParams = ContactRetrieveMessageSummaryParams.none(),
    ): CompletableFuture<ContactRetrieveMessageSummaryResponse> =
        retrieveMessageSummary(contactId, params, RequestOptions.none())

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        params: ContactRetrieveMessageSummaryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContactRetrieveMessageSummaryResponse>

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        params: ContactRetrieveMessageSummaryParams
    ): CompletableFuture<ContactRetrieveMessageSummaryResponse> =
        retrieveMessageSummary(params, RequestOptions.none())

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        contactId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ContactRetrieveMessageSummaryResponse> =
        retrieveMessageSummary(
            contactId,
            ContactRetrieveMessageSummaryParams.none(),
            requestOptions,
        )

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
         * Returns a raw HTTP response for `post /v3/contacts`, but is otherwise the same as
         * [ContactServiceAsync.create].
         */
        fun create(
            params: ContactCreateParams
        ): CompletableFuture<HttpResponseFor<ContactCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ContactCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /v3/contacts/{id}`, but is otherwise the same as
         * [ContactServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ContactRetrieveResponse>> =
            retrieve(id, ContactRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactRetrieveResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ContactRetrieveResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ContactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ContactRetrieveParams
        ): CompletableFuture<HttpResponseFor<ContactRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContactRetrieveResponse>> =
            retrieve(id, ContactRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/contacts/{id}`, but is otherwise the same as
         * [ContactServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<ContactUpdateResponse>> =
            update(id, ContactUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactUpdateResponse>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ContactUpdateResponse>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ContactUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactUpdateResponse>>

        /** @see update */
        fun update(
            params: ContactUpdateParams
        ): CompletableFuture<HttpResponseFor<ContactUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContactUpdateResponse>> =
            update(id, ContactUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/contacts`, but is otherwise the same as
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
         * Returns a raw HTTP response for `delete /v3/contacts/{id}`, but is otherwise the same as
         * [ContactServiceAsync.delete].
         */
        @Deprecated("deprecated")
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, ContactDeleteParams.none())

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(
            params: ContactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(params: ContactDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, ContactDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/contacts/{contactId}/message-summary`, but is
         * otherwise the same as [ContactServiceAsync.retrieveMessageSummary].
         */
        fun retrieveMessageSummary(
            contactId: String
        ): CompletableFuture<HttpResponseFor<ContactRetrieveMessageSummaryResponse>> =
            retrieveMessageSummary(contactId, ContactRetrieveMessageSummaryParams.none())

        /** @see retrieveMessageSummary */
        fun retrieveMessageSummary(
            contactId: String,
            params: ContactRetrieveMessageSummaryParams =
                ContactRetrieveMessageSummaryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactRetrieveMessageSummaryResponse>> =
            retrieveMessageSummary(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see retrieveMessageSummary */
        fun retrieveMessageSummary(
            contactId: String,
            params: ContactRetrieveMessageSummaryParams = ContactRetrieveMessageSummaryParams.none(),
        ): CompletableFuture<HttpResponseFor<ContactRetrieveMessageSummaryResponse>> =
            retrieveMessageSummary(contactId, params, RequestOptions.none())

        /** @see retrieveMessageSummary */
        fun retrieveMessageSummary(
            params: ContactRetrieveMessageSummaryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContactRetrieveMessageSummaryResponse>>

        /** @see retrieveMessageSummary */
        fun retrieveMessageSummary(
            params: ContactRetrieveMessageSummaryParams
        ): CompletableFuture<HttpResponseFor<ContactRetrieveMessageSummaryResponse>> =
            retrieveMessageSummary(params, RequestOptions.none())

        /** @see retrieveMessageSummary */
        fun retrieveMessageSummary(
            contactId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ContactRetrieveMessageSummaryResponse>> =
            retrieveMessageSummary(
                contactId,
                ContactRetrieveMessageSummaryParams.none(),
                requestOptions,
            )
    }
}
