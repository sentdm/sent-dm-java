// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.profiles

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.profiles.campaigns.CampaignCreateParams
import dm.sent.models.profiles.campaigns.CampaignCreateResponse
import dm.sent.models.profiles.campaigns.CampaignDeleteParams
import dm.sent.models.profiles.campaigns.CampaignListParams
import dm.sent.models.profiles.campaigns.CampaignListResponse
import dm.sent.models.profiles.campaigns.CampaignUpdateParams
import dm.sent.models.profiles.campaigns.CampaignUpdateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * **Deprecated — use Sender Profiles.**
 *
 * The original profile resource, kept because it has live callers. It still works, and its
 * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
 * instead of across three.
 *
 * New integrations should not start here.
 */
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
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Creates a new campaign scoped under the brand of the specified profile. Each campaign must
     * include at least one use case with sample messages.
     */
    @Deprecated("deprecated")
    fun create(
        profileId: String,
        params: CampaignCreateParams,
    ): CompletableFuture<CampaignCreateResponse> = create(profileId, params, RequestOptions.none())

    /** @see create */
    @Deprecated("deprecated")
    fun create(
        profileId: String,
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignCreateResponse> =
        create(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see create */
    @Deprecated("deprecated")
    fun create(params: CampaignCreateParams): CompletableFuture<CampaignCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("deprecated")
    fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignCreateResponse>

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Updates an existing campaign under the brand of the specified profile. Cannot update
     * campaigns that have already been submitted to TCR.
     */
    @Deprecated("deprecated")
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
    ): CompletableFuture<CampaignUpdateResponse> = update(campaignId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("deprecated")
    fun update(
        campaignId: String,
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignUpdateResponse> =
        update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see update */
    @Deprecated("deprecated")
    fun update(params: CampaignUpdateParams): CompletableFuture<CampaignUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("deprecated")
    fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignUpdateResponse>

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Retrieves all campaigns linked to the profile's brand, including use cases and sample
     * messages. Returns inherited campaigns if inherit_tcr_campaign=true.
     */
    @Deprecated("deprecated")
    fun list(profileId: String): CompletableFuture<CampaignListResponse> =
        list(profileId, CampaignListParams.none())

    /** @see list */
    @Deprecated("deprecated")
    fun list(
        profileId: String,
        params: CampaignListParams = CampaignListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignListResponse> =
        list(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see list */
    @Deprecated("deprecated")
    fun list(
        profileId: String,
        params: CampaignListParams = CampaignListParams.none(),
    ): CompletableFuture<CampaignListResponse> = list(profileId, params, RequestOptions.none())

    /** @see list */
    @Deprecated("deprecated")
    fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CampaignListResponse>

    /** @see list */
    @Deprecated("deprecated")
    fun list(params: CampaignListParams): CompletableFuture<CampaignListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("deprecated")
    fun list(
        profileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CampaignListResponse> =
        list(profileId, CampaignListParams.none(), requestOptions)

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Deletes a campaign by ID from the brand of the specified profile. The profile must belong to
     * the authenticated organization.
     */
    @Deprecated("deprecated")
    fun delete(campaignId: String, params: CampaignDeleteParams): CompletableFuture<Void?> =
        delete(campaignId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(
        campaignId: String,
        params: CampaignDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(params: CampaignDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
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
        @Deprecated("deprecated")
        fun create(
            profileId: String,
            params: CampaignCreateParams,
        ): CompletableFuture<HttpResponseFor<CampaignCreateResponse>> =
            create(profileId, params, RequestOptions.none())

        /** @see create */
        @Deprecated("deprecated")
        fun create(
            profileId: String,
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignCreateResponse>> =
            create(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see create */
        @Deprecated("deprecated")
        fun create(
            params: CampaignCreateParams
        ): CompletableFuture<HttpResponseFor<CampaignCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("deprecated")
        fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignCreateResponse>>

        /**
         * Returns a raw HTTP response for `put /v3/profiles/{profileId}/campaigns/{campaignId}`,
         * but is otherwise the same as [CampaignServiceAsync.update].
         */
        @Deprecated("deprecated")
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
        ): CompletableFuture<HttpResponseFor<CampaignUpdateResponse>> =
            update(campaignId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("deprecated")
        fun update(
            campaignId: String,
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignUpdateResponse>> =
            update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see update */
        @Deprecated("deprecated")
        fun update(
            params: CampaignUpdateParams
        ): CompletableFuture<HttpResponseFor<CampaignUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("deprecated")
        fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignUpdateResponse>>

        /**
         * Returns a raw HTTP response for `get /v3/profiles/{profileId}/campaigns`, but is
         * otherwise the same as [CampaignServiceAsync.list].
         */
        @Deprecated("deprecated")
        fun list(profileId: String): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(profileId, CampaignListParams.none())

        /** @see list */
        @Deprecated("deprecated")
        fun list(
            profileId: String,
            params: CampaignListParams = CampaignListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see list */
        @Deprecated("deprecated")
        fun list(
            profileId: String,
            params: CampaignListParams = CampaignListParams.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(profileId, params, RequestOptions.none())

        /** @see list */
        @Deprecated("deprecated")
        fun list(
            params: CampaignListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>>

        /** @see list */
        @Deprecated("deprecated")
        fun list(
            params: CampaignListParams
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("deprecated")
        fun list(
            profileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CampaignListResponse>> =
            list(profileId, CampaignListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/profiles/{profileId}/campaigns/{campaignId}`,
         * but is otherwise the same as [CampaignServiceAsync.delete].
         */
        @Deprecated("deprecated")
        fun delete(
            campaignId: String,
            params: CampaignDeleteParams,
        ): CompletableFuture<HttpResponse> = delete(campaignId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(
            campaignId: String,
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(params: CampaignDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        fun delete(
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
