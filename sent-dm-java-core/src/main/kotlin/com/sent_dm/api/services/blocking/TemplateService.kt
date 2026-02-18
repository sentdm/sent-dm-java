// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface TemplateService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateService

    /**
     * Creates a new message template with header, body, footer, and buttons. The template can be
     * submitted for review immediately or saved as draft for later submission.
     */
    fun create(): ApiResponseTemplate = create(TemplateCreateParams.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams = TemplateCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTemplate

    /** @see create */
    fun create(params: TemplateCreateParams = TemplateCreateParams.none()): ApiResponseTemplate =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiResponseTemplate =
        create(TemplateCreateParams.none(), requestOptions)

    /**
     * Retrieves a specific template by its ID. Returns template details including name, category,
     * language, status, and definition.
     */
    fun retrieve(id: String): ApiResponseTemplate = retrieve(id, TemplateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTemplate = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
    ): ApiResponseTemplate = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTemplate

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): ApiResponseTemplate =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): ApiResponseTemplate =
        retrieve(id, TemplateRetrieveParams.none(), requestOptions)

    /**
     * Updates an existing template's name, category, language, definition, or submits it for
     * review.
     */
    fun update(id: String): ApiResponseTemplate = update(id, TemplateUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTemplate = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: TemplateUpdateParams = TemplateUpdateParams.none(),
    ): ApiResponseTemplate = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: TemplateUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTemplate

    /** @see update */
    fun update(params: TemplateUpdateParams): ApiResponseTemplate =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(id: String, requestOptions: RequestOptions): ApiResponseTemplate =
        update(id, TemplateUpdateParams.none(), requestOptions)

    /**
     * Retrieves a paginated list of message templates for the authenticated customer. Supports
     * filtering by status, category, and search term.
     */
    fun list(params: TemplateListParams): TemplateListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateListResponse

    /**
     * Deletes a template by ID. Optionally, you can also delete the template from WhatsApp/Meta by
     * setting delete_from_meta=true.
     */
    fun delete(id: String) = delete(id, TemplateDeleteParams.none())

    /** @see delete */
    fun delete(
        id: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(id: String, params: TemplateDeleteParams = TemplateDeleteParams.none()) =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: TemplateDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: TemplateDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(id: String, requestOptions: RequestOptions) =
        delete(id, TemplateDeleteParams.none(), requestOptions)

    /** A view of [TemplateService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/templates`, but is otherwise the same as
         * [TemplateService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ApiResponseTemplate> = create(TemplateCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTemplate>

        /** @see create */
        @MustBeClosed
        fun create(
            params: TemplateCreateParams = TemplateCreateParams.none()
        ): HttpResponseFor<ApiResponseTemplate> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiResponseTemplate> =
            create(TemplateCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/templates/{id}`, but is otherwise the same as
         * [TemplateService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<ApiResponseTemplate> =
            retrieve(id, TemplateRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTemplate> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        ): HttpResponseFor<ApiResponseTemplate> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTemplate>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TemplateRetrieveParams): HttpResponseFor<ApiResponseTemplate> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseTemplate> =
            retrieve(id, TemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v3/templates/{id}`, but is otherwise the same as
         * [TemplateService.update].
         */
        @MustBeClosed
        fun update(id: String): HttpResponseFor<ApiResponseTemplate> =
            update(id, TemplateUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTemplate> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            params: TemplateUpdateParams = TemplateUpdateParams.none(),
        ): HttpResponseFor<ApiResponseTemplate> = update(id, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: TemplateUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTemplate>

        /** @see update */
        @MustBeClosed
        fun update(params: TemplateUpdateParams): HttpResponseFor<ApiResponseTemplate> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseTemplate> =
            update(id, TemplateUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/templates`, but is otherwise the same as
         * [TemplateService.list].
         */
        @MustBeClosed
        fun list(params: TemplateListParams): HttpResponseFor<TemplateListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: TemplateListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TemplateListResponse>

        /**
         * Returns a raw HTTP response for `delete /v3/templates/{id}`, but is otherwise the same as
         * [TemplateService.delete].
         */
        @MustBeClosed fun delete(id: String): HttpResponse = delete(id, TemplateDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            id: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
        ): HttpResponse = delete(id, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: TemplateDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(id: String, requestOptions: RequestOptions): HttpResponse =
            delete(id, TemplateDeleteParams.none(), requestOptions)
    }
}
