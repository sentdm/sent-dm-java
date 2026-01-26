// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

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
     * Creates a new message template for the authenticated customer with comprehensive template
     * definitions including headers, body, footer, and interactive buttons. Supports automatic
     * metadata generation using AI (display name, language, category). Optionally submits the
     * template for WhatsApp review. The customer ID is extracted from the authentication token.
     */
    fun create(params: TemplateCreateParams): CompletableFuture<TemplateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateResponse>

    /**
     * Retrieves a specific message template by its unique identifier for the authenticated customer
     * with comprehensive template definitions including headers, body, footer, and interactive
     * buttons. The customer ID is extracted from the authentication token.
     */
    fun retrieve(id: String, params: TemplateRetrieveParams): CompletableFuture<TemplateResponse> =
        retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateResponse> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): CompletableFuture<TemplateResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateResponse>

    /**
     * Retrieves all message templates available for the authenticated customer with comprehensive
     * template definitions including headers, body, footer, and interactive buttons. Supports
     * advanced filtering by search term, status, and category, plus pagination. The customer ID is
     * extracted from the authentication token.
     */
    fun list(params: TemplateListParams): CompletableFuture<TemplateListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateListResponse>

    /**
     * Deletes a specific message template by its unique identifier for the authenticated customer
     * with smart deletion strategy. Deletion behavior: - If template has NO messages: Permanently
     * deleted from database (hard delete). - If template has messages: Marked as deleted but
     * preserved for message history (soft delete with snapshot). The template must exist and belong
     * to the authenticated customer to be deleted successfully. The customer ID is extracted from
     * the authentication token.
     */
    fun delete(id: String, params: TemplateDeleteParams): CompletableFuture<Void?> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: TemplateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: TemplateDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: TemplateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

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
         * Returns a raw HTTP response for `post /v2/templates`, but is otherwise the same as
         * [TemplateServiceAsync.create].
         */
        fun create(
            params: TemplateCreateParams
        ): CompletableFuture<HttpResponseFor<TemplateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TemplateCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponse>>

        /**
         * Returns a raw HTTP response for `get /v2/templates/{id}`, but is otherwise the same as
         * [TemplateServiceAsync.retrieve].
         */
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams,
        ): CompletableFuture<HttpResponseFor<TemplateResponse>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponse>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams
        ): CompletableFuture<HttpResponseFor<TemplateResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponse>>

        /**
         * Returns a raw HTTP response for `get /v2/templates`, but is otherwise the same as
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
         * Returns a raw HTTP response for `delete /v2/templates/{id}`, but is otherwise the same as
         * [TemplateServiceAsync.delete].
         */
        fun delete(id: String, params: TemplateDeleteParams): CompletableFuture<HttpResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(params: TemplateDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
