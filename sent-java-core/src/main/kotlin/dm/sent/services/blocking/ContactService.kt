// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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

    /** Creates a new contact by phone number and associates it with the authenticated customer. */
    fun create(params: ContactCreateParams): ContactCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactCreateResponse

    /**
     * Retrieves a specific contact by their unique identifier. Returns detailed contact information
     * including phone formats, available channels, and opt-out status.
     */
    fun retrieve(id: String): ContactRetrieveResponse = retrieve(id, ContactRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
    ): ContactRetrieveResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: ContactRetrieveParams): ContactRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ContactRetrieveResponse =
        retrieve(id, ContactRetrieveParams.none(), requestOptions)

    /** Updates a contact's default channel and/or opt-out status. */
    fun update(id: String): ContactUpdateResponse = update(id, ContactUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
    ): ContactUpdateResponse = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ContactUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactUpdateResponse

    /** @see update */
    fun update(params: ContactUpdateParams): ContactUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): ContactUpdateResponse =
        update(id, ContactUpdateParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of contacts for the authenticated customer. Supports filtering by
     * search term, channel, or phone number.
     */
    fun list(params: ContactListParams): ContactListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListResponse

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
    @Deprecated("deprecated") fun delete(id: String) = delete(id, ContactDeleteParams.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(
        id: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(id: String, params: ContactDeleteParams = ContactDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(params: ContactDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(params: ContactDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, ContactDeleteParams.none(), requestOptions)

    /**
     * Returns aggregate message counts, time bounds, channels used, and per-channel success/fail
     * scores (each as a percentage 0-100 of messages on that channel) for one of your contacts.
     * Successful terminal states: SENT/DELIVERED/READ for outbound, RECEIVED for inbound. Fail:
     * FAILED.
     */
    fun retrieveMessageSummary(contactId: String): ContactRetrieveMessageSummaryResponse =
        retrieveMessageSummary(contactId, ContactRetrieveMessageSummaryParams.none())

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        contactId: String,
        params: ContactRetrieveMessageSummaryParams = ContactRetrieveMessageSummaryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactRetrieveMessageSummaryResponse =
        retrieveMessageSummary(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        contactId: String,
        params: ContactRetrieveMessageSummaryParams = ContactRetrieveMessageSummaryParams.none(),
    ): ContactRetrieveMessageSummaryResponse =
        retrieveMessageSummary(contactId, params, RequestOptions.none())

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        params: ContactRetrieveMessageSummaryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactRetrieveMessageSummaryResponse

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        params: ContactRetrieveMessageSummaryParams
    ): ContactRetrieveMessageSummaryResponse = retrieveMessageSummary(params, RequestOptions.none())

    /** @see retrieveMessageSummary */
    fun retrieveMessageSummary(
        contactId: String,
        requestOptions: RequestOptions,
    ): ContactRetrieveMessageSummaryResponse =
        retrieveMessageSummary(
            contactId,
            ContactRetrieveMessageSummaryParams.none(),
            requestOptions,
        )

    /** A view of [ContactService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContactService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/contacts`, but is otherwise the same as
         * [ContactService.create].
         */
        @MustBeClosed
        fun create(params: ContactCreateParams): HttpResponseFor<ContactCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ContactCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v3/contacts/{id}`, but is otherwise the same as
         * [ContactService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ContactRetrieveResponse> =
            retrieve(id, ContactRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
        ): HttpResponseFor<ContactRetrieveResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ContactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ContactRetrieveParams): HttpResponseFor<ContactRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactRetrieveResponse> =
            retrieve(id, ContactRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/contacts/{id}`, but is otherwise the same as
         * [ContactService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<ContactUpdateResponse> =
            update(id, ContactUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
        ): HttpResponseFor<ContactUpdateResponse> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ContactUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactUpdateResponse>

        /** @see update */
        @MustBeClosed
        fun update(params: ContactUpdateParams): HttpResponseFor<ContactUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactUpdateResponse> =
            update(id, ContactUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/contacts`, but is otherwise the same as
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
         * Returns a raw HTTP response for `delete /v3/contacts/{id}`, but is otherwise the same as
         * [ContactService.delete].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(id: String): HttpResponse = delete(id, ContactDeleteParams.none())

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(
            params: ContactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(params: ContactDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, ContactDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/contacts/{contactId}/message-summary`, but is
         * otherwise the same as [ContactService.retrieveMessageSummary].
         */
        @MustBeClosed
        fun retrieveMessageSummary(
            contactId: String
        ): HttpResponseFor<ContactRetrieveMessageSummaryResponse> =
            retrieveMessageSummary(contactId, ContactRetrieveMessageSummaryParams.none())

        /** @see retrieveMessageSummary */
        @MustBeClosed
        fun retrieveMessageSummary(
            contactId: String,
            params: ContactRetrieveMessageSummaryParams =
                ContactRetrieveMessageSummaryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactRetrieveMessageSummaryResponse> =
            retrieveMessageSummary(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see retrieveMessageSummary */
        @MustBeClosed
        fun retrieveMessageSummary(
            contactId: String,
            params: ContactRetrieveMessageSummaryParams = ContactRetrieveMessageSummaryParams.none(),
        ): HttpResponseFor<ContactRetrieveMessageSummaryResponse> =
            retrieveMessageSummary(contactId, params, RequestOptions.none())

        /** @see retrieveMessageSummary */
        @MustBeClosed
        fun retrieveMessageSummary(
            params: ContactRetrieveMessageSummaryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactRetrieveMessageSummaryResponse>

        /** @see retrieveMessageSummary */
        @MustBeClosed
        fun retrieveMessageSummary(
            params: ContactRetrieveMessageSummaryParams
        ): HttpResponseFor<ContactRetrieveMessageSummaryResponse> =
            retrieveMessageSummary(params, RequestOptions.none())

        /** @see retrieveMessageSummary */
        @MustBeClosed
        fun retrieveMessageSummary(
            contactId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactRetrieveMessageSummaryResponse> =
            retrieveMessageSummary(
                contactId,
                ContactRetrieveMessageSummaryParams.none(),
                requestOptions,
            )
    }
}
