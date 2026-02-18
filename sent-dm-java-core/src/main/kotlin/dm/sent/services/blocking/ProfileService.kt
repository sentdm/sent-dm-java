// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import java.util.function.Consumer

interface ProfileService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileService

    /**
     * Creates a new sender profile within an organization. Profiles represent different brands,
     * departments, or use cases, each with their own messaging configuration and settings. Requires
     * admin role in the organization.
     */
    fun create(): ApiResponseOfProfileDetail = create(ProfileCreateParams.none())

    /** @see create */
    fun create(
        params: ProfileCreateParams = ProfileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail

    /** @see create */
    fun create(
        params: ProfileCreateParams = ProfileCreateParams.none()
    ): ApiResponseOfProfileDetail = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiResponseOfProfileDetail =
        create(ProfileCreateParams.none(), requestOptions)

    /** Retrieves detailed information about a specific sender profile within an organization. */
    fun retrieve(profileId: String): ApiResponseOfProfileDetail =
        retrieve(profileId, ProfileRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        profileId: String,
        params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail =
        retrieve(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        profileId: String,
        params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
    ): ApiResponseOfProfileDetail = retrieve(profileId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ProfileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail

    /** @see retrieve */
    fun retrieve(params: ProfileRetrieveParams): ApiResponseOfProfileDetail =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(profileId: String, requestOptions: RequestOptions): ApiResponseOfProfileDetail =
        retrieve(profileId, ProfileRetrieveParams.none(), requestOptions)

    /**
     * Updates a profile's configuration and settings. Requires admin role in the organization. Only
     * provided fields will be updated (partial update).
     */
    fun update(pathProfileId: String): ApiResponseOfProfileDetail =
        update(pathProfileId, ProfileUpdateParams.none())

    /** @see update */
    fun update(
        pathProfileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail =
        update(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

    /** @see update */
    fun update(
        pathProfileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
    ): ApiResponseOfProfileDetail = update(pathProfileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ProfileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail

    /** @see update */
    fun update(params: ProfileUpdateParams): ApiResponseOfProfileDetail =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(pathProfileId: String, requestOptions: RequestOptions): ApiResponseOfProfileDetail =
        update(pathProfileId, ProfileUpdateParams.none(), requestOptions)

    /**
     * Retrieves all sender profiles within an organization. Profiles represent different brands,
     * departments, or use cases within an organization, each with their own messaging
     * configuration.
     */
    fun list(): ProfileListResponse = list(ProfileListParams.none())

    /** @see list */
    fun list(
        params: ProfileListParams = ProfileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileListResponse

    /** @see list */
    fun list(params: ProfileListParams = ProfileListParams.none()): ProfileListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ProfileListResponse =
        list(ProfileListParams.none(), requestOptions)

    /**
     * Soft deletes a sender profile. The profile will be marked as deleted but data is retained.
     * Requires admin role in the organization.
     */
    fun delete(pathProfileId: String) = delete(pathProfileId, ProfileDeleteParams.none())

    /** @see delete */
    fun delete(
        pathProfileId: String,
        params: ProfileDeleteParams = ProfileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

    /** @see delete */
    fun delete(pathProfileId: String, params: ProfileDeleteParams = ProfileDeleteParams.none()) =
        delete(pathProfileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: ProfileDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: ProfileDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(pathProfileId: String, requestOptions: RequestOptions) =
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
    fun complete(profileId: String, params: ProfileCompleteParams): ProfileCompleteResponse =
        complete(profileId, params, RequestOptions.none())

    /** @see complete */
    fun complete(
        profileId: String,
        params: ProfileCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileCompleteResponse =
        complete(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see complete */
    fun complete(params: ProfileCompleteParams): ProfileCompleteResponse =
        complete(params, RequestOptions.none())

    /** @see complete */
    fun complete(
        params: ProfileCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileCompleteResponse

    /** A view of [ProfileService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/profiles`, but is otherwise the same as
         * [ProfileService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ApiResponseOfProfileDetail> =
            create(ProfileCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ProfileCreateParams = ProfileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ProfileCreateParams = ProfileCreateParams.none()
        ): HttpResponseFor<ApiResponseOfProfileDetail> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfProfileDetail> =
            create(ProfileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/profiles/{profileId}`, but is otherwise the same
         * as [ProfileService.retrieve].
         */
        @MustBeClosed
        fun retrieve(profileId: String): HttpResponseFor<ApiResponseOfProfileDetail> =
            retrieve(profileId, ProfileRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            profileId: String,
            params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            retrieve(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            profileId: String,
            params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            retrieve(profileId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ProfileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ProfileRetrieveParams): HttpResponseFor<ApiResponseOfProfileDetail> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            profileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            retrieve(profileId, ProfileRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/profiles/{profileId}`, but is otherwise the
         * same as [ProfileService.update].
         */
        @MustBeClosed
        fun update(pathProfileId: String): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(pathProfileId, ProfileUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            pathProfileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            pathProfileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(pathProfileId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ProfileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail>

        /** @see update */
        @MustBeClosed
        fun update(params: ProfileUpdateParams): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            pathProfileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(pathProfileId, ProfileUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/profiles`, but is otherwise the same as
         * [ProfileService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ProfileListResponse> = list(ProfileListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ProfileListParams = ProfileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ProfileListParams = ProfileListParams.none()
        ): HttpResponseFor<ProfileListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ProfileListResponse> =
            list(ProfileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/profiles/{profileId}`, but is otherwise the
         * same as [ProfileService.delete].
         */
        @MustBeClosed
        fun delete(pathProfileId: String): HttpResponse =
            delete(pathProfileId, ProfileDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            pathProfileId: String,
            params: ProfileDeleteParams = ProfileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            delete(params.toBuilder().pathProfileId(pathProfileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            pathProfileId: String,
            params: ProfileDeleteParams = ProfileDeleteParams.none(),
        ): HttpResponse = delete(pathProfileId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ProfileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: ProfileDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(pathProfileId: String, requestOptions: RequestOptions): HttpResponse =
            delete(pathProfileId, ProfileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/profiles/{profileId}/complete`, but is
         * otherwise the same as [ProfileService.complete].
         */
        @MustBeClosed
        fun complete(
            profileId: String,
            params: ProfileCompleteParams,
        ): HttpResponseFor<ProfileCompleteResponse> =
            complete(profileId, params, RequestOptions.none())

        /** @see complete */
        @MustBeClosed
        fun complete(
            profileId: String,
            params: ProfileCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileCompleteResponse> =
            complete(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see complete */
        @MustBeClosed
        fun complete(params: ProfileCompleteParams): HttpResponseFor<ProfileCompleteResponse> =
            complete(params, RequestOptions.none())

        /** @see complete */
        @MustBeClosed
        fun complete(
            params: ProfileCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileCompleteResponse>
    }
}
