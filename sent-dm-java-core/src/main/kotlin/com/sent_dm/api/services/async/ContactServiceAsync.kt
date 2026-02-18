// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.contacts.ApiResponseContact
import com.sent_dm.api.models.contacts.ContactCreateParams
import com.sent_dm.api.models.contacts.ContactDeleteParams
import com.sent_dm.api.models.contacts.ContactListParams
import com.sent_dm.api.models.contacts.ContactListResponse
import com.sent_dm.api.models.contacts.ContactRetrieveParams
import com.sent_dm.api.models.contacts.ContactUpdateParams
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

    /** Creates a new contact by phone number and associates it with the authenticated customer. */
    fun create(): CompletableFuture<ApiResponseContact> = create(ContactCreateParams.none())

    /** @see create */
    fun create(
        params: ContactCreateParams = ContactCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseContact>

    /** @see create */
    fun create(
        params: ContactCreateParams = ContactCreateParams.none()
    ): CompletableFuture<ApiResponseContact> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseContact> =
        create(ContactCreateParams.none(), requestOptions)

    /**
     * Retrieves a specific contact by their unique identifier. Returns detailed contact information
     * including phone formats, available channels, and opt-out status.
     */
    fun retrieve(id: String): CompletableFuture<ApiResponseContact> =
        retrieve(id, ContactRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseContact> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
    ): CompletableFuture<ApiResponseContact> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseContact>

    /** @see retrieve */
    fun retrieve(params: ContactRetrieveParams): CompletableFuture<ApiResponseContact> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseContact> =
        retrieve(id, ContactRetrieveParams.none(), requestOptions)

    /**
     * Updates a contact's default channel and/or opt-out status. Inherited contacts cannot be
     * updated.
     */
    fun update(id: String): CompletableFuture<ApiResponseContact> =
        update(id, ContactUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseContact> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
    ): CompletableFuture<ApiResponseContact> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ContactUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseContact>

    /** @see update */
    fun update(params: ContactUpdateParams): CompletableFuture<ApiResponseContact> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<ApiResponseContact> =
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
     * Dissociates a contact from the authenticated customer. Inherited contacts cannot be deleted.
     */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, ContactDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ContactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: ContactDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, ContactDeleteParams.none(), requestOptions)

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
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            create(ContactCreateParams.none())

        /** @see create */
        fun create(
            params: ContactCreateParams = ContactCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>>

        /** @see create */
        fun create(
            params: ContactCreateParams = ContactCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            create(ContactCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/contacts/{id}`, but is otherwise the same as
         * [ContactServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            retrieve(id, ContactRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ContactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>>

        /** @see retrieve */
        fun retrieve(
            params: ContactRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            retrieve(id, ContactRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/contacts/{id}`, but is otherwise the same as
         * [ContactServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            update(id, ContactUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ContactUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>>

        /** @see update */
        fun update(
            params: ContactUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseContact>> =
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
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, ContactDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ContactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: ContactDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, ContactDeleteParams.none(), requestOptions)
    }
}
