// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.organizations.OrganizationListParams
import com.sent_dm.api.models.organizations.OrganizationListResponse
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesParams
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesResponse
import com.sent_dm.api.services.blocking.organizations.UserService
import java.util.function.Consumer

interface OrganizationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService

    fun users(): UserService

    /**
     * Retrieves all organizations that the authenticated user has access to, including the sender
     * profiles within each organization that the user can access. Returns organization details with
     * nested profiles filtered by user permissions.
     */
    fun list(): OrganizationListResponse = list(OrganizationListParams.none())

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationListResponse

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none()
    ): OrganizationListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): OrganizationListResponse =
        list(OrganizationListParams.none(), requestOptions)

    /**
     * Retrieves all sender profiles within an organization that the authenticated user has access
     * to. Returns filtered list based on user's permissions.
     */
    fun retrieveProfiles(orgId: String): OrganizationRetrieveProfilesResponse =
        retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none())

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        orgId: String,
        params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationRetrieveProfilesResponse =
        retrieveProfiles(params.toBuilder().orgId(orgId).build(), requestOptions)

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        orgId: String,
        params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
    ): OrganizationRetrieveProfilesResponse = retrieveProfiles(orgId, params, RequestOptions.none())

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        params: OrganizationRetrieveProfilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OrganizationRetrieveProfilesResponse

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        params: OrganizationRetrieveProfilesParams
    ): OrganizationRetrieveProfilesResponse = retrieveProfiles(params, RequestOptions.none())

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        orgId: String,
        requestOptions: RequestOptions,
    ): OrganizationRetrieveProfilesResponse =
        retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none(), requestOptions)

    /**
     * A view of [OrganizationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse

        fun users(): UserService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/organizations`, but is otherwise the same as
         * [OrganizationService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<OrganizationListResponse> = list(OrganizationListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrganizationListParams = OrganizationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: OrganizationListParams = OrganizationListParams.none()
        ): HttpResponseFor<OrganizationListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<OrganizationListResponse> =
            list(OrganizationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v2/organizations/{orgId}/profiles`, but is
         * otherwise the same as [OrganizationService.retrieveProfiles].
         */
        @MustBeClosed
        fun retrieveProfiles(orgId: String): HttpResponseFor<OrganizationRetrieveProfilesResponse> =
            retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none())

        /** @see retrieveProfiles */
        @MustBeClosed
        fun retrieveProfiles(
            orgId: String,
            params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationRetrieveProfilesResponse> =
            retrieveProfiles(params.toBuilder().orgId(orgId).build(), requestOptions)

        /** @see retrieveProfiles */
        @MustBeClosed
        fun retrieveProfiles(
            orgId: String,
            params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
        ): HttpResponseFor<OrganizationRetrieveProfilesResponse> =
            retrieveProfiles(orgId, params, RequestOptions.none())

        /** @see retrieveProfiles */
        @MustBeClosed
        fun retrieveProfiles(
            params: OrganizationRetrieveProfilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OrganizationRetrieveProfilesResponse>

        /** @see retrieveProfiles */
        @MustBeClosed
        fun retrieveProfiles(
            params: OrganizationRetrieveProfilesParams
        ): HttpResponseFor<OrganizationRetrieveProfilesResponse> =
            retrieveProfiles(params, RequestOptions.none())

        /** @see retrieveProfiles */
        @MustBeClosed
        fun retrieveProfiles(
            orgId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationRetrieveProfilesResponse> =
            retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none(), requestOptions)
    }
}
