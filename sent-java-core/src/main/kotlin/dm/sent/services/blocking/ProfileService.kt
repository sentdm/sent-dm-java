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
import dm.sent.services.blocking.profiles.CampaignService
import java.util.function.Consumer

/** Manage organization profiles */
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

    /** Manage organization profiles */
    fun campaigns(): CampaignService

    /**
     * Creates a new sender profile within an organization. Profiles represent different brands,
     * departments, or use cases, each with their own messaging configuration and settings. Requires
     * admin role in the organization.
     *
     * ## WhatsApp Business Account
     *
     * Every profile must be linked to a WhatsApp Business Account. There are two ways to do this:
     *
     * **1. Inherit from organization (default)** — Omit the `whatsapp_business_account` field. The
     * profile will share the organization's WhatsApp Business Account, which must have been set up
     * via WhatsApp Embedded Signup. This is the recommended path for most use cases.
     *
     * **2. Direct credentials** — Provide a `whatsapp_business_account` object with `waba_id`,
     * `phone_number_id`, and `access_token`. Use this when the profile needs its own independent
     * WhatsApp Business Account. Obtain these from Meta Business Manager by creating a System User
     * with `whatsapp_business_messaging` and `whatsapp_business_management` permissions.
     *
     * If the `whatsapp_business_account` field is omitted and the organization has no WhatsApp
     * Business Account configured, the request will be rejected with HTTP 422.
     *
     * ## Brand
     *
     * Include the optional `brand` field to create the brand for this profile at the same time.
     * Cannot be used when `inherit_tcr_brand` is `true`.
     *
     * ## Payment Details
     *
     * When `billing_model` is `"profile"` or `"profile_and_organization"` you may include a
     * `payment_details` object containing the card number, expiry (MM/YY), CVC, and billing ZIP
     * code. Payment details are **never stored** on our servers and are forwarded directly to the
     * payment processor. Providing `payment_details` when `billing_model` is `"organization"` is
     * not allowed.
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

    /**
     * Retrieves detailed information about a specific sender profile within an organization,
     * including brand and KYC information if a brand has been configured.
     */
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
     *
     * ## Brand Management
     *
     * Include the optional `brand` field to create or update the brand associated with this
     * profile. The brand holds KYC and TCR compliance data (legal business info, contact details,
     * messaging vertical). Once a brand has been submitted to TCR it cannot be modified. Setting
     * `inherit_tcr_brand: true` and providing `brand` in the same request is not allowed.
     *
     * ## Payment Details
     *
     * When `billing_model` is `"profile"` or `"profile_and_organization"` you may include a
     * `payment_details` object containing the card number, expiry (MM/YY), CVC, and billing ZIP
     * code. Payment details are **never stored** on our servers and are forwarded directly to the
     * payment processor. Providing `payment_details` when `billing_model` is `"organization"` is
     * not allowed.
     */
    fun update(profileId: String): ApiResponseOfProfileDetail =
        update(profileId, ProfileUpdateParams.none())

    /** @see update */
    fun update(
        profileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail =
        update(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see update */
    fun update(
        profileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
    ): ApiResponseOfProfileDetail = update(profileId, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ProfileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfProfileDetail

    /** @see update */
    fun update(params: ProfileUpdateParams): ApiResponseOfProfileDetail =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(profileId: String, requestOptions: RequestOptions): ApiResponseOfProfileDetail =
        update(profileId, ProfileUpdateParams.none(), requestOptions)

    /**
     * Retrieves all sender profiles within an organization, including brand information for each
     * profile. Profiles represent different brands, departments, or use cases within an
     * organization, each with their own messaging configuration.
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
    fun delete(profileId: String, params: ProfileDeleteParams) =
        delete(profileId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        profileId: String,
        params: ProfileDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ProfileDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(params: ProfileDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /**
     * Final step in the profile compliance workflow. Validates all prerequisites (KYC, brand,
     * campaigns, required documents), connects the profile to the SMS and WhatsApp channels, and
     * sets its status based on configuration. Prerequisites are always validated first: if any fail
     * the call returns 400. If they pass and the profile is already completed, the call returns 200
     * and does nothing. Otherwise it returns 202 and calls the provided webhook URL when background
     * processing finishes.
     *
     * Prerequisites:
     * - Profile must have a name, short name, and description (short name max 50 characters,
     *   description max 5000)
     * - webHookUrl must be supplied on the request
     * - A KYC form submission is required
     * - A brand is required, either on the profile or inherited from the parent organization
     * - TCR applications must have at least one campaign, own or inherited
     * - Destination countries marked as main must have their required compliance documents uploaded
     *
     * Resulting status:
     * - If either the SMS or WhatsApp channel is unconfigured, the profile is SUBMITTED
     * - For a TCR application that inherits both its brand and its campaigns, the profile is
     *   COMPLETED
     * - For a TCR application that owns either its brand or its campaigns, the profile is COMPLETED
     *   once both have been submitted to TCR, and SUBMITTED until then
     * - For a non-TCR application, the profile is SUBMITTED when a main destination country is set,
     *   and COMPLETED otherwise
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

        /** Manage organization profiles */
        fun campaigns(): CampaignService.WithRawResponse

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
        fun update(profileId: String): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(profileId, ProfileUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            profileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            profileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(profileId, params, RequestOptions.none())

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
            profileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfProfileDetail> =
            update(profileId, ProfileUpdateParams.none(), requestOptions)

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
        fun delete(profileId: String, params: ProfileDeleteParams): HttpResponse =
            delete(profileId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            profileId: String,
            params: ProfileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: ProfileDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ProfileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

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
