// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.organizations.OrganizationListParams
import com.sent_dm.api.models.organizations.OrganizationListResponse
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesParams
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesResponse
import com.sent_dm.api.services.async.organizations.UserServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OrganizationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationServiceAsync

    fun users(): UserServiceAsync

    /**
     * Retrieves all organizations that the authenticated user has access to, including the sender
     * profiles within each organization that the user can access. Returns organization details with
     * nested profiles filtered by user permissions.
     */
    fun list(): CompletableFuture<OrganizationListResponse> = list(OrganizationListParams.none())

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationListResponse>

    /** @see list */
    fun list(
        params: OrganizationListParams = OrganizationListParams.none()
    ): CompletableFuture<OrganizationListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<OrganizationListResponse> =
        list(OrganizationListParams.none(), requestOptions)

    /**
     * Retrieves all sender profiles within an organization that the authenticated user has access
     * to. Returns filtered list based on user's permissions.
     */
    fun retrieveProfiles(orgId: String): CompletableFuture<OrganizationRetrieveProfilesResponse> =
        retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none())

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        orgId: String,
        params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationRetrieveProfilesResponse> =
        retrieveProfiles(params.toBuilder().orgId(orgId).build(), requestOptions)

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        orgId: String,
        params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
    ): CompletableFuture<OrganizationRetrieveProfilesResponse> =
        retrieveProfiles(orgId, params, RequestOptions.none())

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        params: OrganizationRetrieveProfilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OrganizationRetrieveProfilesResponse>

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        params: OrganizationRetrieveProfilesParams
    ): CompletableFuture<OrganizationRetrieveProfilesResponse> =
        retrieveProfiles(params, RequestOptions.none())

    /** @see retrieveProfiles */
    fun retrieveProfiles(
        orgId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationRetrieveProfilesResponse> =
        retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none(), requestOptions)

    /**
     * A view of [OrganizationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationServiceAsync.WithRawResponse

        fun users(): UserServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/organizations`, but is otherwise the same as
         * [OrganizationServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<OrganizationListResponse>> =
            list(OrganizationListParams.none())

        /** @see list */
        fun list(
            params: OrganizationListParams = OrganizationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationListResponse>>

        /** @see list */
        fun list(
            params: OrganizationListParams = OrganizationListParams.none()
        ): CompletableFuture<HttpResponseFor<OrganizationListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<OrganizationListResponse>> =
            list(OrganizationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v2/organizations/{orgId}/profiles`, but is
         * otherwise the same as [OrganizationServiceAsync.retrieveProfiles].
         */
        fun retrieveProfiles(
            orgId: String
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>> =
            retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none())

        /** @see retrieveProfiles */
        fun retrieveProfiles(
            orgId: String,
            params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>> =
            retrieveProfiles(params.toBuilder().orgId(orgId).build(), requestOptions)

        /** @see retrieveProfiles */
        fun retrieveProfiles(
            orgId: String,
            params: OrganizationRetrieveProfilesParams = OrganizationRetrieveProfilesParams.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>> =
            retrieveProfiles(orgId, params, RequestOptions.none())

        /** @see retrieveProfiles */
        fun retrieveProfiles(
            params: OrganizationRetrieveProfilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>>

        /** @see retrieveProfiles */
        fun retrieveProfiles(
            params: OrganizationRetrieveProfilesParams
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>> =
            retrieveProfiles(params, RequestOptions.none())

        /** @see retrieveProfiles */
        fun retrieveProfiles(
            orgId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>> =
            retrieveProfiles(orgId, OrganizationRetrieveProfilesParams.none(), requestOptions)
    }
}
