// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.templates.TemplateCreateParams
import com.sent_dm.api.models.templates.TemplateDeleteParams
import com.sent_dm.api.models.templates.TemplateListParams
import com.sent_dm.api.models.templates.TemplateListResponse
import com.sent_dm.api.models.templates.TemplateResponse
import com.sent_dm.api.models.templates.TemplateRetrieveParams
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
     * Creates a new message template for the authenticated customer with comprehensive template
     * definitions including headers, body, footer, and interactive buttons. Supports automatic
     * metadata generation using AI (display name, language, category). Optionally submits the
     * template for WhatsApp review. The customer ID is extracted from the authentication token.
     */
    fun create(params: TemplateCreateParams): TemplateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateResponse

    /**
     * Retrieves a specific message template by its unique identifier for the authenticated customer
     * with comprehensive template definitions including headers, body, footer, and interactive
     * buttons. The customer ID is extracted from the authentication token.
     */
    fun retrieve(id: String): TemplateResponse = retrieve(id, TemplateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
    ): TemplateResponse = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateResponse

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): TemplateResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): TemplateResponse =
        retrieve(id, TemplateRetrieveParams.none(), requestOptions)

    /**
     * Retrieves all message templates available for the authenticated customer with comprehensive
     * template definitions including headers, body, footer, and interactive buttons. Supports
     * advanced filtering by search term, status, and category, plus pagination. The customer ID is
     * extracted from the authentication token.
     */
    fun list(params: TemplateListParams): TemplateListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateListResponse

    /**
     * Deletes a specific message template by its unique identifier for the authenticated customer
     * with smart deletion strategy. Deletion behavior: - If template has NO messages: Permanently
     * deleted from database (hard delete). - If template has messages: Marked as deleted but
     * preserved for message history (soft delete with snapshot). The template must exist and belong
     * to the authenticated customer to be deleted successfully. The customer ID is extracted from
     * the authentication token.
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
         * Returns a raw HTTP response for `post /v2/templates`, but is otherwise the same as
         * [TemplateService.create].
         */
        @MustBeClosed
        fun create(params: TemplateCreateParams): HttpResponseFor<TemplateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: TemplateCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TemplateResponse>

        /**
         * Returns a raw HTTP response for `get /v2/templates/{id}`, but is otherwise the same as
         * [TemplateService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<TemplateResponse> =
            retrieve(id, TemplateRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TemplateResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        ): HttpResponseFor<TemplateResponse> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TemplateResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: TemplateRetrieveParams): HttpResponseFor<TemplateResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TemplateResponse> =
            retrieve(id, TemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v2/templates`, but is otherwise the same as
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
         * Returns a raw HTTP response for `delete /v2/templates/{id}`, but is otherwise the same as
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
