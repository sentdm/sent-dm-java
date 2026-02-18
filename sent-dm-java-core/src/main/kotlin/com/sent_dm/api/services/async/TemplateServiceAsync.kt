// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.templates.ApiResponseTemplate
import com.sent_dm.api.models.templates.TemplateCreateParams
import com.sent_dm.api.models.templates.TemplateDeleteParams
import com.sent_dm.api.models.templates.TemplateListParams
import com.sent_dm.api.models.templates.TemplateListResponse
import com.sent_dm.api.models.templates.TemplateRetrieveParams
import com.sent_dm.api.models.templates.TemplateUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TemplateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateServiceAsync

    /**
     * Creates a new message template with header, body, footer, and buttons. The template can be
     * submitted for review immediately or saved as draft for later submission.
     */
    fun create(): CompletableFuture<ApiResponseTemplate> = create(TemplateCreateParams.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams = TemplateCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTemplate>

    /** @see create */
    fun create(
        params: TemplateCreateParams = TemplateCreateParams.none()
    ): CompletableFuture<ApiResponseTemplate> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseTemplate> =
        create(TemplateCreateParams.none(), requestOptions)

    /**
     * Retrieves a specific template by its ID. Returns template details including name, category,
     * language, status, and definition.
     */
    fun retrieve(id: String): CompletableFuture<ApiResponseTemplate> =
        retrieve(id, TemplateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTemplate> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
    ): CompletableFuture<ApiResponseTemplate> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTemplate>

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): CompletableFuture<ApiResponseTemplate> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseTemplate> =
        retrieve(id, TemplateRetrieveParams.none(), requestOptions)

    /**
     * Updates an existing template's name, category, language, definition, or submits it for
     * review.
     */
    fun update(id: String): CompletableFuture<ApiResponseTemplate> =
        update(id, TemplateUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTemplate> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
    ): CompletableFuture<ApiResponseTemplate> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: TemplateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTemplate>

    /** @see update */
    fun update(params: TemplateUpdateParams): CompletableFuture<ApiResponseTemplate> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): CompletableFuture<ApiResponseTemplate> =
        update(id, TemplateUpdateParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of message templates for the authenticated customer. Supports
     * filtering by status, category, and search term.
     */
    fun list(params: TemplateListParams): CompletableFuture<TemplateListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateListResponse>

    /**
     * Deletes a template by ID. Optionally, you can also delete the template from WhatsApp/Meta by
     * setting delete_from_meta=true.
     */
    fun delete(id: String): CompletableFuture<Void?> = delete(id, TemplateDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(
        id: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TemplateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: TemplateDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(id, TemplateDeleteParams.none(), requestOptions)

    /**
     * A view of [TemplateServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TemplateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/templates`, but is otherwise the same as
         * [TemplateServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            create(TemplateCreateParams.none())

        /** @see create */
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>>

        /** @see create */
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            create(TemplateCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/templates/{id}`, but is otherwise the same as
         * [TemplateServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            retrieve(id, TemplateRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>>

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            retrieve(id, TemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v3/templates/{id}`, but is otherwise the same as
         * [TemplateServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            update(id, TemplateUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: TemplateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>>

        /** @see update */
        fun update(
            params: TemplateUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseTemplate>> =
            update(id, TemplateUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/templates`, but is otherwise the same as
         * [TemplateServiceAsync.list].
         */
        fun list(
            params: TemplateListParams
        ): CompletableFuture<HttpResponseFor<TemplateListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: TemplateListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateListResponse>>

        /**
         * Returns a raw HTTP response for `delete /v3/templates/{id}`, but is otherwise the same as
         * [TemplateServiceAsync.delete].
         */
        fun delete(id: String): CompletableFuture<HttpResponse> =
            delete(id, TemplateDeleteParams.none())

        /** @see delete */
        fun delete(
            id: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(
            id: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: TemplateDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(id: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
            delete(id, TemplateDeleteParams.none(), requestOptions)
    }
}
