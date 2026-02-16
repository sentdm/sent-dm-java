// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.templates.TemplateCreateParams
import dm.sent.models.templates.TemplateDeleteParams
import dm.sent.models.templates.TemplateListParams
import dm.sent.models.templates.TemplateListResponse
import dm.sent.models.templates.TemplateResponseV2
import dm.sent.models.templates.TemplateRetrieveParams
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
    fun create(params: TemplateCreateParams): CompletableFuture<TemplateResponseV2> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateResponseV2>

    /**
     * Retrieves a specific message template by its unique identifier for the authenticated customer
     * with comprehensive template definitions including headers, body, footer, and interactive
     * buttons. The customer ID is extracted from the authentication token.
     */
    fun retrieve(id: String): CompletableFuture<TemplateResponseV2> =
        retrieve(id, TemplateRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateResponseV2> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
    ): CompletableFuture<TemplateResponseV2> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TemplateResponseV2>

    /** @see retrieve */
    fun retrieve(params: TemplateRetrieveParams): CompletableFuture<TemplateResponseV2> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<TemplateResponseV2> =
        retrieve(id, TemplateRetrieveParams.none(), requestOptions)

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
         * Returns a raw HTTP response for `post /v2/templates`, but is otherwise the same as
         * [TemplateServiceAsync.create].
         */
        fun create(
            params: TemplateCreateParams
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TemplateCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>>

        /**
         * Returns a raw HTTP response for `get /v2/templates/{id}`, but is otherwise the same as
         * [TemplateServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<TemplateResponseV2>> =
            retrieve(id, TemplateRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>>

        /** @see retrieve */
        fun retrieve(
            params: TemplateRetrieveParams
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TemplateResponseV2>> =
            retrieve(id, TemplateRetrieveParams.none(), requestOptions)

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
