// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.profiles.ApiResponseOfProfileDetail
import dm.sent.models.profiles.ProfileCompleteParams
import dm.sent.models.profiles.ProfileCompleteResponse
import dm.sent.models.profiles.ProfileCreateParams
import dm.sent.models.profiles.ProfileDeleteParams
import dm.sent.models.profiles.ProfileListParams
import dm.sent.models.profiles.ProfileListResponse
import dm.sent.models.profiles.ProfileRetrieveParams
import dm.sent.models.profiles.ProfileUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ProfileServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileServiceAsync

    /**
     * Creates a new sender profile within an organization. Profiles represent different brands,
     * departments, or use cases, each with their own messaging configuration and settings. Requires
     * admin role in the organization.
     */
    fun create(): CompletableFuture<ApiResponseOfProfileDetail> = create(ProfileCreateParams.none())

    /** @see create */
    fun create(
        params: ProfileCreateParams = ProfileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail>

    /** @see create */
    fun create(
        params: ProfileCreateParams = ProfileCreateParams.none()
    ): CompletableFuture<ApiResponseOfProfileDetail> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfProfileDetail> =
        create(ProfileCreateParams.none(), requestOptions)

    /** Retrieves detailed information about a specific sender profile within an organization. */
    fun retrieve(profileId: String): CompletableFuture<ApiResponseOfProfileDetail> =
        retrieve(profileId, ProfileRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        profileId: String,
        params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        retrieve(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        profileId: String,
        params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        retrieve(profileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ProfileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail>

    /** @see retrieve */
    fun retrieve(params: ProfileRetrieveParams): CompletableFuture<ApiResponseOfProfileDetail> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        profileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        retrieve(profileId, ProfileRetrieveParams.none(), requestOptions)

    /**
     * Updates a profile's configuration and settings. Requires admin role in the organization. Only
     * provided fields will be updated (partial update).
     */
    fun update(pathProfileId: String): CompletableFuture<ApiResponseOfProfileDetail> =
        update(pathProfileId, ProfileUpdateParams.none())

    /** @see update */
    fun update(
        pathProfileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        update(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

    /** @see update */
    fun update(
        pathProfileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        update(pathProfileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ProfileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfProfileDetail>

    /** @see update */
    fun update(params: ProfileUpdateParams): CompletableFuture<ApiResponseOfProfileDetail> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        pathProfileId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        update(pathProfileId, ProfileUpdateParams.none(), requestOptions)

    /**
     * Retrieves all sender profiles within an organization. Profiles represent different brands,
     * departments, or use cases within an organization, each with their own messaging
     * configuration.
     */
    fun list(): CompletableFuture<ProfileListResponse> = list(ProfileListParams.none())

    /** @see list */
    fun list(
        params: ProfileListParams = ProfileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProfileListResponse>

    /** @see list */
    fun list(
        params: ProfileListParams = ProfileListParams.none()
    ): CompletableFuture<ProfileListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ProfileListResponse> =
        list(ProfileListParams.none(), requestOptions)

    /**
     * Soft deletes a sender profile. The profile will be marked as deleted but data is retained.
     * Requires admin role in the organization.
     */
    fun delete(pathProfileId: String): CompletableFuture<Void?> =
        delete(pathProfileId, ProfileDeleteParams.none())

    /** @see delete */
    fun delete(
        pathProfileId: String,
        params: ProfileDeleteParams = ProfileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

    /** @see delete */
    fun delete(
        pathProfileId: String,
        params: ProfileDeleteParams = ProfileDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(pathProfileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ProfileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: ProfileDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(pathProfileId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(pathProfileId, ProfileDeleteParams.none(), requestOptions)

    /**
     * Final step in profile compliance workflow. Validates all prerequisites (general data, brand,
     * campaigns), connects profile to Telnyx/WhatsApp, and sets status based on configuration. The
     * process runs in the background and calls the provided webhook URL when finished.
     *
     *                 Prerequisites:
     *                 - Profile must be completed
     *                 - If inheritTcrBrand=false: Profile must have existing brand
     *                 - If inheritTcrBrand=true: Parent must have existing brand
     *                 - If TCR application: Must have at least one campaign (own or inherited)
     *                 - If inheritTcrCampaign=false: Profile should have campaigns
     *                 - If inheritTcrCampaign=true: Parent must have campaigns
     *                 Status Logic:
     *                 - If both SMS and WhatsApp channels are missing → SUBMITTED
     *                 - If TCR application and not inheriting brand/campaigns → SUBMITTED
     *                 - If non-TCR with destination country (IsMain=true) → SUBMITTED
     *                 - Otherwise → COMPLETED
     */
    fun complete(
        profileId: String,
        params: ProfileCompleteParams,
    ): CompletableFuture<ProfileCompleteResponse> =
        complete(profileId, params, RequestOptions.none())

    /** @see complete */
    fun complete(
        profileId: String,
        params: ProfileCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProfileCompleteResponse> =
        complete(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see complete */
    fun complete(params: ProfileCompleteParams): CompletableFuture<ProfileCompleteResponse> =
        complete(params, RequestOptions.none())

    /** @see complete */
    fun complete(
        params: ProfileCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProfileCompleteResponse>

    /**
     * A view of [ProfileServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProfileServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/profiles`, but is otherwise the same as
         * [ProfileServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            create(ProfileCreateParams.none())

        /** @see create */
        fun create(
            params: ProfileCreateParams = ProfileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>>

        /** @see create */
        fun create(
            params: ProfileCreateParams = ProfileCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            create(ProfileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/profiles/{profileId}`, but is otherwise the same
         * as [ProfileServiceAsync.retrieve].
         */
        fun retrieve(
            profileId: String
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            retrieve(profileId, ProfileRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            profileId: String,
            params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            retrieve(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            profileId: String,
            params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            retrieve(profileId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ProfileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>>

        /** @see retrieve */
        fun retrieve(
            params: ProfileRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            profileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            retrieve(profileId, ProfileRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/profiles/{profileId}`, but is otherwise the
         * same as [ProfileServiceAsync.update].
         */
        fun update(
            pathProfileId: String
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            update(pathProfileId, ProfileUpdateParams.none())

        /** @see update */
        fun update(
            pathProfileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            update(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

        /** @see update */
        fun update(
            pathProfileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            update(pathProfileId, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ProfileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>>

        /** @see update */
        fun update(
            params: ProfileUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            pathProfileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> =
            update(pathProfileId, ProfileUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/profiles`, but is otherwise the same as
         * [ProfileServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ProfileListResponse>> =
            list(ProfileListParams.none())

        /** @see list */
        fun list(
            params: ProfileListParams = ProfileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProfileListResponse>>

        /** @see list */
        fun list(
            params: ProfileListParams = ProfileListParams.none()
        ): CompletableFuture<HttpResponseFor<ProfileListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ProfileListResponse>> =
            list(ProfileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/profiles/{profileId}`, but is otherwise the
         * same as [ProfileServiceAsync.delete].
         */
        fun delete(pathProfileId: String): CompletableFuture<HttpResponse> =
            delete(pathProfileId, ProfileDeleteParams.none())

        /** @see delete */
        fun delete(
            pathProfileId: String,
            params: ProfileDeleteParams = ProfileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

        /** @see delete */
        fun delete(
            pathProfileId: String,
            params: ProfileDeleteParams = ProfileDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(pathProfileId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ProfileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: ProfileDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            pathProfileId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            delete(pathProfileId, ProfileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/profiles/{profileId}/complete`, but is
         * otherwise the same as [ProfileServiceAsync.complete].
         */
        fun complete(
            profileId: String,
            params: ProfileCompleteParams,
        ): CompletableFuture<HttpResponseFor<ProfileCompleteResponse>> =
            complete(profileId, params, RequestOptions.none())

        /** @see complete */
        fun complete(
            profileId: String,
            params: ProfileCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProfileCompleteResponse>> =
            complete(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see complete */
        fun complete(
            params: ProfileCompleteParams
        ): CompletableFuture<HttpResponseFor<ProfileCompleteResponse>> =
            complete(params, RequestOptions.none())

        /** @see complete */
        fun complete(
            params: ProfileCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProfileCompleteResponse>>
    }
}
