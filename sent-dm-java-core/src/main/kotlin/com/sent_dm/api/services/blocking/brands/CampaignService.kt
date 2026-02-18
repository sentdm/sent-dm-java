// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking.brands

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.brands.campaigns.ApiResponseTcrCampaignWithUseCases
import com.sent_dm.api.models.brands.campaigns.CampaignCreateParams
import com.sent_dm.api.models.brands.campaigns.CampaignDeleteParams
import com.sent_dm.api.models.brands.campaigns.CampaignListParams
import com.sent_dm.api.models.brands.campaigns.CampaignListResponse
import com.sent_dm.api.models.brands.campaigns.CampaignUpdateParams
import java.util.function.Consumer

interface CampaignService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CampaignService

    /**
     * Creates a new campaign scoped under a specific brand. The campaign is linked to the specified
     * brand. Each campaign must include at least one use case with sample messages.
     */
    fun create(brandId: String, params: CampaignCreateParams): ApiResponseTcrCampaignWithUseCases =
        create(brandId, params, RequestOptions.none())

    /** @see create */
    fun create(
        brandId: String,
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTcrCampaignWithUseCases =
        create(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see create */
    fun create(params: CampaignCreateParams): ApiResponseTcrCampaignWithUseCases =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTcrCampaignWithUseCases

    /**
     * Updates an existing campaign scoped under a specific brand. Cannot update campaigns that have
     * already been submitted to TCR.
     */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
    ): ApiResponseTcrCampaignWithUseCases = update(campaignId, params, RequestOptions.none())

    /** @see update */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTcrCampaignWithUseCases =
        update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see update */
    fun update(params: CampaignUpdateParams): ApiResponseTcrCampaignWithUseCases =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseTcrCampaignWithUseCases

    /**
     * Retrieves all campaigns linked to a specific brand, including their use cases and sample
     * messages.
     */
    fun list(brandId: String): CampaignListResponse = list(brandId, CampaignListParams.none())

    /** @see list */
    fun list(
        brandId: String,
        params: CampaignListParams = CampaignListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignListResponse = list(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see list */
    fun list(
        brandId: String,
        params: CampaignListParams = CampaignListParams.none(),
    ): CampaignListResponse = list(brandId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignListResponse

    /** @see list */
    fun list(params: CampaignListParams): CampaignListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(brandId: String, requestOptions: RequestOptions): CampaignListResponse =
        list(brandId, CampaignListParams.none(), requestOptions)

    /**
     * Deletes a campaign by ID within a specific brand. The brand must belong to the authenticated
     * customer.
     */
    fun delete(campaignId: String, params: CampaignDeleteParams) =
        delete(campaignId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        campaignId: String,
        params: CampaignDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see delete */
    fun delete(params: CampaignDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(params: CampaignDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** A view of [CampaignService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CampaignService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/brands/{brandId}/campaigns`, but is otherwise
         * the same as [CampaignService.create].
         */
        @MustBeClosed
        fun create(
            brandId: String,
            params: CampaignCreateParams,
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> =
            create(brandId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            brandId: String,
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> =
            create(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            params: CampaignCreateParams
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases>

        /**
         * Returns a raw HTTP response for `put /v3/brands/{brandId}/campaigns/{campaignId}`, but is
         * otherwise the same as [CampaignService.update].
         */
        @MustBeClosed
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> =
            update(campaignId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> =
            update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            params: CampaignUpdateParams
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases>

        /**
         * Returns a raw HTTP response for `get /v3/brands/{brandId}/campaigns`, but is otherwise
         * the same as [CampaignService.list].
         */
        @MustBeClosed
        fun list(brandId: String): HttpResponseFor<CampaignListResponse> =
            list(brandId, CampaignListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            brandId: String,
            params: CampaignListParams = CampaignListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignListResponse> =
            list(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            brandId: String,
            params: CampaignListParams = CampaignListParams.none(),
        ): HttpResponseFor<CampaignListResponse> = list(brandId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CampaignListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignListResponse>

        /** @see list */
        @MustBeClosed
        fun list(params: CampaignListParams): HttpResponseFor<CampaignListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            brandId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CampaignListResponse> =
            list(brandId, CampaignListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/brands/{brandId}/campaigns/{campaignId}`, but
         * is otherwise the same as [CampaignService.delete].
         */
        @MustBeClosed
        fun delete(campaignId: String, params: CampaignDeleteParams): HttpResponse =
            delete(campaignId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            campaignId: String,
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: CampaignDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
