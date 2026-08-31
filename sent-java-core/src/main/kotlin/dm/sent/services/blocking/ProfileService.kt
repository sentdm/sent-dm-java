// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.profiles.ProfileCompleteParams
import dm.sent.models.profiles.ProfileCompleteResponse
import dm.sent.models.profiles.ProfileCreateParams
import dm.sent.models.profiles.ProfileCreateResponse
import dm.sent.models.profiles.ProfileDeleteParams
import dm.sent.models.profiles.ProfileListParams
import dm.sent.models.profiles.ProfileListResponse
import dm.sent.models.profiles.ProfileRetrieveParams
import dm.sent.models.profiles.ProfileRetrieveResponse
import dm.sent.models.profiles.ProfileUpdateParams
import dm.sent.models.profiles.ProfileUpdateResponse
import dm.sent.services.blocking.profiles.CampaignService
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
     * **Deprecated — use Sender Profiles.**
     *
     * The original profile resource, kept because it has live callers. It still works, and its
     * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
     * instead of across three.
     *
     * New integrations should not start here.
     */
    fun campaigns(): CampaignService

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Creates a new sender profile within an organization. Profiles represent different brands,
     * departments, or use cases, each with their own messaging configuration and settings. Requires
     * admin role in the organization.
     *
     * ## WhatsApp Business Account
     *
     * Every profile owns its own WhatsApp Business Account — accounts are never shared between
     * profiles or inherited from the organization. Provide a `whatsapp_business_account` object
     * with `waba_id`, `phone_number_id`, and `access_token`. Obtain these from Meta Business
     * Manager by creating a System User with `whatsapp_business_messaging` and
     * `whatsapp_business_management` permissions.
     *
     * Omit the field and the profile is created without WhatsApp, staying incomplete until it has
     * an account of its own.
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
    @Deprecated("deprecated")
    fun create(): ProfileCreateResponse = create(ProfileCreateParams.none())

    /** @see create */
    @Deprecated("deprecated")
    fun create(
        params: ProfileCreateParams = ProfileCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileCreateResponse

    /** @see create */
    @Deprecated("deprecated")
    fun create(params: ProfileCreateParams = ProfileCreateParams.none()): ProfileCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("deprecated")
    fun create(requestOptions: RequestOptions): ProfileCreateResponse =
        create(ProfileCreateParams.none(), requestOptions)

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Retrieves detailed information about a specific sender profile within an organization,
     * including brand and KYC information if a brand has been configured.
     */
    @Deprecated("deprecated")
    fun retrieve(profileId: String): ProfileRetrieveResponse =
        retrieve(profileId, ProfileRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("deprecated")
    fun retrieve(
        profileId: String,
        params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileRetrieveResponse =
        retrieve(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("deprecated")
    fun retrieve(
        profileId: String,
        params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
    ): ProfileRetrieveResponse = retrieve(profileId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("deprecated")
    fun retrieve(
        params: ProfileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileRetrieveResponse

    /** @see retrieve */
    @Deprecated("deprecated")
    fun retrieve(params: ProfileRetrieveParams): ProfileRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("deprecated")
    fun retrieve(profileId: String, requestOptions: RequestOptions): ProfileRetrieveResponse =
        retrieve(profileId, ProfileRetrieveParams.none(), requestOptions)

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
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
     *
     * ## Deprecated fields
     *
     * `sending_phone_number_profile_id` and `sending_whatsapp_number_profile_id` are **accepted and
     * ignored**. Sender borrowing is gone: a profile cannot send from another profile's number,
     * because two profiles behind one sender makes an inbound reply and a delivery receipt
     * ambiguous about whose they are.
     *
     * Sending either **changes nothing and still returns `200`** — they are kept on the contract so
     * an existing integration keeps working. Reads carry both keys too and always answer `null`,
     * which is how you can confirm the value did not take.
     *
     * Give the profile a sender of its own instead — `POST /v3/channels/sms` or `POST
     * /v3/channels/whatsapp`, sent with the `x-profile-id` header naming it.
     */
    @Deprecated("deprecated")
    fun update(profileId: String): ProfileUpdateResponse =
        update(profileId, ProfileUpdateParams.none())

    /** @see update */
    @Deprecated("deprecated")
    fun update(
        profileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileUpdateResponse =
        update(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see update */
    @Deprecated("deprecated")
    fun update(
        profileId: String,
        params: ProfileUpdateParams = ProfileUpdateParams.none(),
    ): ProfileUpdateResponse = update(profileId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("deprecated")
    fun update(
        params: ProfileUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileUpdateResponse

    /** @see update */
    @Deprecated("deprecated")
    fun update(params: ProfileUpdateParams): ProfileUpdateResponse =
        update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("deprecated")
    fun update(profileId: String, requestOptions: RequestOptions): ProfileUpdateResponse =
        update(profileId, ProfileUpdateParams.none(), requestOptions)

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Retrieves all sender profiles within an organization, including brand information for each
     * profile. Profiles represent different brands, departments, or use cases within an
     * organization, each with their own messaging configuration.
     */
    @Deprecated("deprecated") fun list(): ProfileListResponse = list(ProfileListParams.none())

    /** @see list */
    @Deprecated("deprecated")
    fun list(
        params: ProfileListParams = ProfileListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileListResponse

    /** @see list */
    @Deprecated("deprecated")
    fun list(params: ProfileListParams = ProfileListParams.none()): ProfileListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("deprecated")
    fun list(requestOptions: RequestOptions): ProfileListResponse =
        list(ProfileListParams.none(), requestOptions)

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Soft deletes a sender profile. The profile will be marked as deleted but data is retained.
     * Anything it still held is released first: phone numbers return to our inventory and can go to
     * whoever asks next, its own WhatsApp account is deregistered, and its routing rules stop being
     * used. Requires admin role in the organization.
     */
    @Deprecated("deprecated")
    fun delete(profileId: String) = delete(profileId, ProfileDeleteParams.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(
        profileId: String,
        params: ProfileDeleteParams = ProfileDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(profileId: String, params: ProfileDeleteParams = ProfileDeleteParams.none()) =
        delete(profileId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(params: ProfileDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(params: ProfileDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("deprecated")
    fun delete(profileId: String, requestOptions: RequestOptions) =
        delete(profileId, ProfileDeleteParams.none(), requestOptions)

    /**
     * **Deprecated.** This endpoint is replaced by `/v3/sender-profiles` and will be removed in a
     * future release. It still behaves exactly as before, so nothing needs to change today — but
     * new integrations should use `/v3/sender-profiles`, which models a profile's markets,
     * compliance, brand, campaigns and billing explicitly.
     *
     * Final step in the profile compliance workflow. Validates all prerequisites (KYC, brand,
     * campaigns, required documents), connects the profile to the SMS and WhatsApp channels, and
     * marks it onboarded. Prerequisites are always validated first: if any fail the call returns
     * 400 naming every unmet one, and nothing is started. If they pass and the profile is already
     * onboarded, the call returns 200 and does nothing. Otherwise it returns 202 and calls the
     * provided webhook URL when background processing finishes.
     *
     * Callable with the organization's API key or the profile's own key. The key's user must be an
     * admin or owner of the profile, or of the organization it belongs to.
     *
     * Prerequisites (all but the last are checked before the already-onboarded short-circuit,
     * matching the previous contract; the last is checked after it, so a profile that is already
     * onboarded is never rejected by it):
     * - Profile must have a name, short name, and description (short name max 50 characters,
     *   description max 5000)
     * - webHookUrl must be supplied on the request
     * - A KYC form submission is required
     * - A brand is required, either on the profile or inherited from the parent organization
     * - TCR applications must have at least one campaign, own or inherited
     * - Destination countries marked as main must have their required compliance documents uploaded
     * - TCR applications must state whether they inherit the organization's TCR brand and campaign
     *
     * Outcome:
     * - Once the prerequisites pass and background processing succeeds, the profile's
     *   conversionFlowStatus becomes ONBOARDED and its public status reads `approved`
     * - A profile with no WhatsApp channel, or one still awaiting TCR registration or country
     *   documents, is onboarded like any other. Those are answered by the brand and campaign
     *   records, not by a status on the profile
     * - If background processing fails, the profile keeps the status it already had and the webhook
     *   reports the reason
     */
    @Deprecated("deprecated")
    fun complete(profileId: String, params: ProfileCompleteParams): ProfileCompleteResponse =
        complete(profileId, params, RequestOptions.none())

    /** @see complete */
    @Deprecated("deprecated")
    fun complete(
        profileId: String,
        params: ProfileCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProfileCompleteResponse =
        complete(params.toBuilder().profileId(profileId).build(), requestOptions)

    /** @see complete */
    @Deprecated("deprecated")
    fun complete(params: ProfileCompleteParams): ProfileCompleteResponse =
        complete(params, RequestOptions.none())

    /** @see complete */
    @Deprecated("deprecated")
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
         * **Deprecated — use Sender Profiles.**
         *
         * The original profile resource, kept because it has live callers. It still works, and its
         * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one
         * call instead of across three.
         *
         * New integrations should not start here.
         */
        fun campaigns(): CampaignService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/profiles`, but is otherwise the same as
         * [ProfileService.create].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun create(): HttpResponseFor<ProfileCreateResponse> = create(ProfileCreateParams.none())

        /** @see create */
        @Deprecated("deprecated")
        @MustBeClosed
        fun create(
            params: ProfileCreateParams = ProfileCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileCreateResponse>

        /** @see create */
        @Deprecated("deprecated")
        @MustBeClosed
        fun create(
            params: ProfileCreateParams = ProfileCreateParams.none()
        ): HttpResponseFor<ProfileCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("deprecated")
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ProfileCreateResponse> =
            create(ProfileCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/profiles/{profileId}`, but is otherwise the same
         * as [ProfileService.retrieve].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun retrieve(profileId: String): HttpResponseFor<ProfileRetrieveResponse> =
            retrieve(profileId, ProfileRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("deprecated")
        @MustBeClosed
        fun retrieve(
            profileId: String,
            params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileRetrieveResponse> =
            retrieve(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("deprecated")
        @MustBeClosed
        fun retrieve(
            profileId: String,
            params: ProfileRetrieveParams = ProfileRetrieveParams.none(),
        ): HttpResponseFor<ProfileRetrieveResponse> =
            retrieve(profileId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("deprecated")
        @MustBeClosed
        fun retrieve(
            params: ProfileRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileRetrieveResponse>

        /** @see retrieve */
        @Deprecated("deprecated")
        @MustBeClosed
        fun retrieve(params: ProfileRetrieveParams): HttpResponseFor<ProfileRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("deprecated")
        @MustBeClosed
        fun retrieve(
            profileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileRetrieveResponse> =
            retrieve(profileId, ProfileRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/profiles/{profileId}`, but is otherwise the
         * same as [ProfileService.update].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun update(profileId: String): HttpResponseFor<ProfileUpdateResponse> =
            update(profileId, ProfileUpdateParams.none())

        /** @see update */
        @Deprecated("deprecated")
        @MustBeClosed
        fun update(
            profileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileUpdateResponse> =
            update(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see update */
        @Deprecated("deprecated")
        @MustBeClosed
        fun update(
            profileId: String,
            params: ProfileUpdateParams = ProfileUpdateParams.none(),
        ): HttpResponseFor<ProfileUpdateResponse> = update(profileId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("deprecated")
        @MustBeClosed
        fun update(
            params: ProfileUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileUpdateResponse>

        /** @see update */
        @Deprecated("deprecated")
        @MustBeClosed
        fun update(params: ProfileUpdateParams): HttpResponseFor<ProfileUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("deprecated")
        @MustBeClosed
        fun update(
            profileId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileUpdateResponse> =
            update(profileId, ProfileUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/profiles`, but is otherwise the same as
         * [ProfileService.list].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun list(): HttpResponseFor<ProfileListResponse> = list(ProfileListParams.none())

        /** @see list */
        @Deprecated("deprecated")
        @MustBeClosed
        fun list(
            params: ProfileListParams = ProfileListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileListResponse>

        /** @see list */
        @Deprecated("deprecated")
        @MustBeClosed
        fun list(
            params: ProfileListParams = ProfileListParams.none()
        ): HttpResponseFor<ProfileListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("deprecated")
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ProfileListResponse> =
            list(ProfileListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/profiles/{profileId}`, but is otherwise the
         * same as [ProfileService.delete].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(profileId: String): HttpResponse = delete(profileId, ProfileDeleteParams.none())

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(
            profileId: String,
            params: ProfileDeleteParams = ProfileDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(
            profileId: String,
            params: ProfileDeleteParams = ProfileDeleteParams.none(),
        ): HttpResponse = delete(profileId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(
            params: ProfileDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(params: ProfileDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun delete(profileId: String, requestOptions: RequestOptions): HttpResponse =
            delete(profileId, ProfileDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/profiles/{profileId}/complete`, but is
         * otherwise the same as [ProfileService.complete].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun complete(
            profileId: String,
            params: ProfileCompleteParams,
        ): HttpResponseFor<ProfileCompleteResponse> =
            complete(profileId, params, RequestOptions.none())

        /** @see complete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun complete(
            profileId: String,
            params: ProfileCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileCompleteResponse> =
            complete(params.toBuilder().profileId(profileId).build(), requestOptions)

        /** @see complete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun complete(params: ProfileCompleteParams): HttpResponseFor<ProfileCompleteResponse> =
            complete(params, RequestOptions.none())

        /** @see complete */
        @Deprecated("deprecated")
        @MustBeClosed
        fun complete(
            params: ProfileCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProfileCompleteResponse>
    }
}
