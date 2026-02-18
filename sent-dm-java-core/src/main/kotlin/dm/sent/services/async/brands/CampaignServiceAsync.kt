// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.brands

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.brands.campaigns.ApiResponseTcrCampaignWithUseCases
import dm.sent.models.brands.campaigns.CampaignCreateParams
import dm.sent.models.brands.campaigns.CampaignDeleteParams
import dm.sent.models.brands.campaigns.CampaignListParams
import dm.sent.models.brands.campaigns.CampaignListResponse
import dm.sent.models.brands.campaigns.CampaignUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CampaignServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CampaignServiceAsync

    /**
     * Creates a new campaign scoped under a specific brand. The campaign is linked to the specified
     * brand. Each campaign must include at least one use case with sample messages.
     */
    fun create(
        brandId: String,
        params: CampaignCreateParams,
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases> =
        create(brandId, params, RequestOptions.none())

    /** @see create */
    fun create(
        brandId: String,
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases> =
        create(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see create */
    fun create(
        params: CampaignCreateParams
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases> = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases>

    /**
     * Updates an existing campaign scoped under a specific brand. Cannot update campaigns that have
     * already been submitted to TCR.
     */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases> =
        update(campaignId, params, RequestOptions.none())

    /** @see update */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases> =
        update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see update */
    fun update(
        params: CampaignUpdateParams
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases> = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseTcrCampaignWithUseCases>

    /**
     * Retrieves all campaigns linked to a specific brand, including their use cases and sample
     * messages.
     */
    fun list(brandId: String): CompletableFuture<CampaignListResponse> =
        list(brandId, CampaignListParams.none())

    /** @see list */
    fun list(
        brandId: String,
        params: CampaignListParams = CampaignListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignListResponse> =
        list(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see list */
    fun list(
        brandId: String,
        params: CampaignListParams = CampaignListParams.none(),
    ): CompletableFuture<CampaignListResponse> = list(brandId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignListResponse>

    /** @see list */
    fun list(params: CampaignListParams): CompletableFuture<CampaignListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        brandId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CampaignListResponse> =
        list(brandId, CampaignListParams.none(), requestOptions)

    /**
     * Deletes a campaign by ID within a specific brand. The brand must belong to the authenticated
     * customer.
     */
    fun delete(campaignId: String, params: CampaignDeleteParams): CompletableFuture<Void?> =
        delete(campaignId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        campaignId: String,
        params: CampaignDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see delete */
    fun delete(params: CampaignDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: CampaignDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * A view of [CampaignServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CampaignServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/brands/{brandId}/campaigns`, but is otherwise
         * the same as [CampaignServiceAsync.create].
         */
        fun create(
            brandId: String,
            params: CampaignCreateParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>> =
            create(brandId, params, RequestOptions.none())

        /** @see create */
        fun create(
            brandId: String,
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>> =
            create(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see create */
        fun create(
            params: CampaignCreateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>>

        /**
         * Returns a raw HTTP response for `put /v3/brands/{brandId}/campaigns/{campaignId}`, but is
         * otherwise the same as [CampaignServiceAsync.update].
         */
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>> =
            update(campaignId, params, RequestOptions.none())

        /** @see update */
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>> =
            update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see update */
        fun update(
            params: CampaignUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseTcrCampaignWithUseCases>>

        /**
         * Returns a raw HTTP response for `get /v3/brands/{brandId}/campaigns`, but is otherwise
         * the same as [CampaignServiceAsync.list].
         */
        fun list(brandId: String): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(brandId, CampaignListParams.none())

        /** @see list */
        fun list(
            brandId: String,
            params: CampaignListParams = CampaignListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see list */
        fun list(
            brandId: String,
            params: CampaignListParams = CampaignListParams.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(brandId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: CampaignListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>>

        /** @see list */
        fun list(
            params: CampaignListParams
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            brandId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(brandId, CampaignListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/brands/{brandId}/campaigns/{campaignId}`, but
         * is otherwise the same as [CampaignServiceAsync.delete].
         */
        fun delete(
            campaignId: String,
            params: CampaignDeleteParams,
        ): CompletableFuture<HttpResponse> = delete(campaignId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            campaignId: String,
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see delete */
        fun delete(params: CampaignDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
