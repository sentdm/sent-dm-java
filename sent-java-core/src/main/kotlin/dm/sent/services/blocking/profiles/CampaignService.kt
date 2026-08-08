// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.profiles

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.profiles.campaigns.ApiResponseOfBrandCampaign
import dm.sent.models.profiles.campaigns.ApiResponseOfListOfBrandCampaign
import dm.sent.models.profiles.campaigns.CampaignCreateParams
import dm.sent.models.profiles.campaigns.CampaignDeleteParams
import dm.sent.models.profiles.campaigns.CampaignListParams
import dm.sent.models.profiles.campaigns.CampaignUpdateParams
import java.util.function.Consumer

/** Manage organization profiles */
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
     * Creates a new campaign scoped under the brand of the specified profile. Each campaign must
     * include at least one use case with sample messages.
     */
    fun create(profileId: String, params: CampaignCreateParams): ApiResponseOfBrandCampaign =
        create(profileId, params, RequestOptions.none())

    /** @see create */
    fun create(
        profileId: String,
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfBrandCampaign =
        create(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see create */
    fun create(params: CampaignCreateParams): ApiResponseOfBrandCampaign =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfBrandCampaign

    /**
     * Updates an existing campaign under the brand of the specified profile. Cannot update
     * campaigns that have already been submitted to TCR.
     */
    fun update(campaignId: String, params: CampaignUpdateParams): ApiResponseOfBrandCampaign =
        update(campaignId, params, RequestOptions.none())

    /** @see update */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfBrandCampaign =
        update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see update */
    fun update(params: CampaignUpdateParams): ApiResponseOfBrandCampaign =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfBrandCampaign

    /**
     * Retrieves all campaigns linked to the profile's brand, including use cases and sample
     * messages. Returns inherited campaigns if inherit_tcr_campaign=true.
     */
    fun list(profileId: String): ApiResponseOfListOfBrandCampaign =
        list(profileId, CampaignListParams.none())

    /** @see list */
    fun list(
        profileId: String,
        params: CampaignListParams = CampaignListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfBrandCampaign =
        list(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see list */
    fun list(
        profileId: String,
        params: CampaignListParams = CampaignListParams.none(),
    ): ApiResponseOfListOfBrandCampaign = list(profileId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfBrandCampaign

    /** @see list */
    fun list(params: CampaignListParams): ApiResponseOfListOfBrandCampaign =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(profileId: String, requestOptions: RequestOptions): ApiResponseOfListOfBrandCampaign =
        list(profileId, CampaignListParams.none(), requestOptions)

    /**
     * Deletes a campaign by ID from the brand of the specified profile. The profile must belong to
     * the authenticated organization.
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
         * Returns a raw HTTP response for `post /v3/profiles/{profileId}/campaigns`, but is
         * otherwise the same as [CampaignService.create].
         */
        @MustBeClosed
        fun create(
            profileId: String,
            params: CampaignCreateParams,
        ): HttpResponseFor<ApiResponseOfBrandCampaign> =
            create(profileId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            profileId: String,
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfBrandCampaign> =
            create(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: CampaignCreateParams): HttpResponseFor<ApiResponseOfBrandCampaign> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfBrandCampaign>

        /**
         * Returns a raw HTTP response for `put /v3/profiles/{profileId}/campaigns/{campaignId}`,
         * but is otherwise the same as [CampaignService.update].
         */
        @MustBeClosed
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
        ): HttpResponseFor<ApiResponseOfBrandCampaign> =
            update(campaignId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfBrandCampaign> =
            update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: CampaignUpdateParams): HttpResponseFor<ApiResponseOfBrandCampaign> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfBrandCampaign>

        /**
         * Returns a raw HTTP response for `get /v3/profiles/{profileId}/campaigns`, but is
         * otherwise the same as [CampaignService.list].
         */
        @MustBeClosed
        fun list(profileId: String): HttpResponseFor<ApiResponseOfListOfBrandCampaign> =
            list(profileId, CampaignListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            profileId: String,
            params: CampaignListParams = CampaignListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfBrandCampaign> =
            list(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            profileId: String,
            params: CampaignListParams = CampaignListParams.none(),
        ): HttpResponseFor<ApiResponseOfListOfBrandCampaign> =
            list(profileId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CampaignListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfBrandCampaign>

        /** @see list */
        @MustBeClosed
        fun list(params: CampaignListParams): HttpResponseFor<ApiResponseOfListOfBrandCampaign> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            profileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfBrandCampaign> =
            list(profileId, CampaignListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/profiles/{profileId}/campaigns/{campaignId}`,
         * but is otherwise the same as [CampaignService.delete].
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
