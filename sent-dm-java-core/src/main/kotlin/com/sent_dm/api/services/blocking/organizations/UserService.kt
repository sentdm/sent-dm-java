// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking.organizations

import com.google.errorprone.annotations.MustBeClosed
import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.organizations.users.CustomerUser
import com.sent_dm.api.models.organizations.users.UserDeleteParams
import com.sent_dm.api.models.organizations.users.UserInviteParams
import com.sent_dm.api.models.organizations.users.UserListParams
import com.sent_dm.api.models.organizations.users.UserListResponse
import com.sent_dm.api.models.organizations.users.UserRetrieveParams
import com.sent_dm.api.models.organizations.users.UserUpdateRoleParams
import java.util.function.Consumer

interface UserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService

    /**
     * Retrieves a specific user by their ID. Requires appropriate permissions. The customerId can
     * be either an organization ID or a profile ID.
     */
    fun retrieve(userId: String, params: UserRetrieveParams): CustomerUser =
        retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomerUser = retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): CustomerUser = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomerUser

    /**
     * Retrieves all users associated with an organization or sender profile. Requires appropriate
     * permissions. Supports pagination.
     */
    fun list(customerId: String, params: UserListParams): UserListResponse =
        list(customerId, params, RequestOptions.none())

    /** @see list */
    fun list(
        customerId: String,
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListResponse = list(params.toBuilder().customerId(customerId).build(), requestOptions)

    /** @see list */
    fun list(params: UserListParams): UserListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListResponse

    /**
     * Removes a user from an organization or sender profile. Requires admin permissions. This
     * action permanently deletes the user association.
     */
    fun delete(userId: String, params: UserDeleteParams) =
        delete(userId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see delete */
    fun delete(params: UserDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(params: UserDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /**
     * Invites a user to an organization or sender profile with a specified role. Requires
     * appropriate permissions. The customerId can be either an organization ID or a profile ID.
     */
    fun invite(customerId: String): CustomerUser = invite(customerId, UserInviteParams.none())

    /** @see invite */
    fun invite(
        customerId: String,
        params: UserInviteParams = UserInviteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomerUser = invite(params.toBuilder().customerId(customerId).build(), requestOptions)

    /** @see invite */
    fun invite(
        customerId: String,
        params: UserInviteParams = UserInviteParams.none(),
    ): CustomerUser = invite(customerId, params, RequestOptions.none())

    /** @see invite */
    fun invite(
        params: UserInviteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomerUser

    /** @see invite */
    fun invite(params: UserInviteParams): CustomerUser = invite(params, RequestOptions.none())

    /** @see invite */
    fun invite(customerId: String, requestOptions: RequestOptions): CustomerUser =
        invite(customerId, UserInviteParams.none(), requestOptions)

    /**
     * Updates a user's role within an organization or sender profile. Requires admin permissions.
     * Valid roles are: admin, billing, developer.
     */
    fun updateRole(userId: String, params: UserUpdateRoleParams): CustomerUser =
        updateRole(userId, params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        userId: String,
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomerUser = updateRole(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see updateRole */
    fun updateRole(params: UserUpdateRoleParams): CustomerUser =
        updateRole(params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CustomerUser

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/organizations/{customerId}/users/{userId}`, but
         * is otherwise the same as [UserService.retrieve].
         */
        @MustBeClosed
        fun retrieve(userId: String, params: UserRetrieveParams): HttpResponseFor<CustomerUser> =
            retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomerUser> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: UserRetrieveParams): HttpResponseFor<CustomerUser> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomerUser>

        /**
         * Returns a raw HTTP response for `get /v2/organizations/{customerId}/users`, but is
         * otherwise the same as [UserService.list].
         */
        @MustBeClosed
        fun list(customerId: String, params: UserListParams): HttpResponseFor<UserListResponse> =
            list(customerId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            customerId: String,
            params: UserListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListResponse> =
            list(params.toBuilder().customerId(customerId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(params: UserListParams): HttpResponseFor<UserListResponse> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: UserListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListResponse>

        /**
         * Returns a raw HTTP response for `delete /v2/organizations/{customerId}/users/{userId}`,
         * but is otherwise the same as [UserService.delete].
         */
        @MustBeClosed
        fun delete(userId: String, params: UserDeleteParams): HttpResponse =
            delete(userId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            userId: String,
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: UserDeleteParams): HttpResponse = delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /v2/organizations/{customerId}/users`, but is
         * otherwise the same as [UserService.invite].
         */
        @MustBeClosed
        fun invite(customerId: String): HttpResponseFor<CustomerUser> =
            invite(customerId, UserInviteParams.none())

        /** @see invite */
        @MustBeClosed
        fun invite(
            customerId: String,
            params: UserInviteParams = UserInviteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomerUser> =
            invite(params.toBuilder().customerId(customerId).build(), requestOptions)

        /** @see invite */
        @MustBeClosed
        fun invite(
            customerId: String,
            params: UserInviteParams = UserInviteParams.none(),
        ): HttpResponseFor<CustomerUser> = invite(customerId, params, RequestOptions.none())

        /** @see invite */
        @MustBeClosed
        fun invite(
            params: UserInviteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomerUser>

        /** @see invite */
        @MustBeClosed
        fun invite(params: UserInviteParams): HttpResponseFor<CustomerUser> =
            invite(params, RequestOptions.none())

        /** @see invite */
        @MustBeClosed
        fun invite(
            customerId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CustomerUser> =
            invite(customerId, UserInviteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v2/organizations/{customerId}/users/{userId}`, but
         * is otherwise the same as [UserService.updateRole].
         */
        @MustBeClosed
        fun updateRole(
            userId: String,
            params: UserUpdateRoleParams,
        ): HttpResponseFor<CustomerUser> = updateRole(userId, params, RequestOptions.none())

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(
            userId: String,
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomerUser> =
            updateRole(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(params: UserUpdateRoleParams): HttpResponseFor<CustomerUser> =
            updateRole(params, RequestOptions.none())

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CustomerUser>
    }
}
