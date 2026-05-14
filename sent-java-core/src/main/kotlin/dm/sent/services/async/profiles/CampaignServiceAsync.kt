// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.profiles

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.profiles.campaigns.ApiResponseOfTcrCampaignWithUseCases
import dm.sent.models.profiles.campaigns.CampaignCreateParams
import dm.sent.models.profiles.campaigns.CampaignDeleteParams
import dm.sent.models.profiles.campaigns.CampaignListParams
import dm.sent.models.profiles.campaigns.CampaignListResponse
import dm.sent.models.profiles.campaigns.CampaignUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Manage organization profiles */
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
     * Creates a new campaign scoped under the brand of the specified profile. Each campaign must
     * include at least one use case with sample messages.
     */
    fun create(
        profileId: String,
        params: CampaignCreateParams,
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases> =
        create(profileId, params, RequestOptions.none())

    /** @see create */
    fun create(
        profileId: String,
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases> =
        create(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see create */
    fun create(
        params: CampaignCreateParams
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases>

    /**
     * Updates an existing campaign under the brand of the specified profile. Cannot update
     * campaigns that have already been submitted to TCR.
     */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases> =
        update(campaignId, params, RequestOptions.none())

    /** @see update */
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases> =
        update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see update */
    fun update(
        params: CampaignUpdateParams
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfTcrCampaignWithUseCases>

    /**
     * Retrieves all campaigns linked to the profile's brand, including use cases and sample
     * messages. Returns inherited campaigns if inherit_tcr_campaign=true.
     */
    fun list(profileId: String): CompletableFuture<CampaignListResponse> =
        list(profileId, CampaignListParams.none())

    /** @see list */
    fun list(
        profileId: String,
        params: CampaignListParams = CampaignListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignListResponse> =
        list(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see list */
    fun list(
        profileId: String,
        params: CampaignListParams = CampaignListParams.none(),
    ): CompletableFuture<CampaignListResponse> = list(profileId, params, RequestOptions.none())

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
        profileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CampaignListResponse> =
        list(profileId, CampaignListParams.none(), requestOptions)

    /**
     * Deletes a campaign by ID from the brand of the specified profile. The profile must belong to
     * the authenticated organization.
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
         * Returns a raw HTTP response for `post /v3/profiles/{profileId}/campaigns`, but is
         * otherwise the same as [CampaignServiceAsync.create].
         */
        fun create(
            profileId: String,
            params: CampaignCreateParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>> =
            create(profileId, params, RequestOptions.none())

        /** @see create */
        fun create(
            profileId: String,
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>> =
            create(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see create */
        fun create(
            params: CampaignCreateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>>

        /**
         * Returns a raw HTTP response for `put /v3/profiles/{profileId}/campaigns/{campaignId}`,
         * but is otherwise the same as [CampaignServiceAsync.update].
         */
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>> =
            update(campaignId, params, RequestOptions.none())

        /** @see update */
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>> =
            update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see update */
        fun update(
            params: CampaignUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfTcrCampaignWithUseCases>>

        /**
         * Returns a raw HTTP response for `get /v3/profiles/{profileId}/campaigns`, but is
         * otherwise the same as [CampaignServiceAsync.list].
         */
        fun list(profileId: String): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(profileId, CampaignListParams.none())

        /** @see list */
        fun list(
            profileId: String,
            params: CampaignListParams = CampaignListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see list */
        fun list(
            profileId: String,
            params: CampaignListParams = CampaignListParams.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(profileId, params, RequestOptions.none())

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
            profileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(profileId, CampaignListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/profiles/{profileId}/campaigns/{campaignId}`,
         * but is otherwise the same as [CampaignServiceAsync.delete].
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
