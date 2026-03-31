// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.contacts.ApiResponseOfContact
import dm.sent.models.contacts.ContactCreateParams
import dm.sent.models.contacts.ContactDeleteParams
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactListResponse
import dm.sent.models.contacts.ContactRetrieveParams
import dm.sent.models.contacts.ContactUpdateParams
import java.util.function.Consumer

/** Create, update, and manage customer contact lists */
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
    fun create(): ApiResponseOfContact = create(ContactCreateParams.none())

    /** @see create */
    fun create(
        params: ContactCreateParams = ContactCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfContact

    /** @see create */
    fun create(params: ContactCreateParams = ContactCreateParams.none()): ApiResponseOfContact =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiResponseOfContact =
        create(ContactCreateParams.none(), requestOptions)

    /**
     * Retrieves a specific contact by their unique identifier. Returns detailed contact information
     * including phone formats, available channels, and opt-out status.
     */
    fun retrieve(id: String): ApiResponseOfContact = retrieve(id, ContactRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfContact = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
    ): ApiResponseOfContact = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfContact

    /** @see retrieve */
    fun retrieve(params: ContactRetrieveParams): ApiResponseOfContact =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ApiResponseOfContact =
        retrieve(id, ContactRetrieveParams.none(), requestOptions)

    /**
     * Updates a contact's default channel and/or opt-out status. Inherited contacts cannot be
     * updated.
     */
    fun update(id: String): ApiResponseOfContact = update(id, ContactUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfContact = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
    ): ApiResponseOfContact = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ContactUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfContact

    /** @see update */
    fun update(params: ContactUpdateParams): ApiResponseOfContact =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): ApiResponseOfContact =
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
     * Dissociates a contact from the authenticated customer. Inherited contacts cannot be deleted.
     */
    fun delete(id: String) = delete(id, ContactDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: ContactDeleteParams = ContactDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: ContactDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: ContactDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, ContactDeleteParams.none(), requestOptions)

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
        fun create(): HttpResponseFor<ApiResponseOfContact> = create(ContactCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ContactCreateParams = ContactCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfContact>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ContactCreateParams = ContactCreateParams.none()
        ): HttpResponseFor<ApiResponseOfContact> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfContact> =
            create(ContactCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/contacts/{id}`, but is otherwise the same as
         * [ContactService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ApiResponseOfContact> =
            retrieve(id, ContactRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfContact> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
        ): HttpResponseFor<ApiResponseOfContact> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ContactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfContact>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ContactRetrieveParams): HttpResponseFor<ApiResponseOfContact> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfContact> =
            retrieve(id, ContactRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/contacts/{id}`, but is otherwise the same as
         * [ContactService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<ApiResponseOfContact> =
            update(id, ContactUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfContact> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
        ): HttpResponseFor<ApiResponseOfContact> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ContactUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfContact>

        /** @see update */
        @MustBeClosed
        fun update(params: ContactUpdateParams): HttpResponseFor<ApiResponseOfContact> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfContact> =
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
        @MustBeClosed fun delete(id: String): HttpResponse = delete(id, ContactDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ContactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: ContactDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, ContactDeleteParams.none(), requestOptions)
    }
}
