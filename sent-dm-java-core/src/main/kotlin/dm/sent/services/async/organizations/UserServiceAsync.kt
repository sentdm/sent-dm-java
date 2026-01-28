// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.organizations

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.organizations.users.CustomerUser
import dm.sent.models.organizations.users.UserDeleteParams
import dm.sent.models.organizations.users.UserInviteParams
import dm.sent.models.organizations.users.UserListParams
import dm.sent.models.organizations.users.UserListResponse
import dm.sent.models.organizations.users.UserRetrieveParams
import dm.sent.models.organizations.users.UserUpdateRoleParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync

    /**
     * Retrieves a specific user by their ID. Requires appropriate permissions. The customerId can
     * be either an organization ID or a profile ID.
     */
    fun retrieve(userId: String, params: UserRetrieveParams): CompletableFuture<CustomerUser> =
        retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomerUser> =
        retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): CompletableFuture<CustomerUser> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomerUser>

    /**
     * Retrieves all users associated with an organization or sender profile. Requires appropriate
     * permissions. Supports pagination.
     */
    fun list(customerId: String, params: UserListParams): CompletableFuture<UserListResponse> =
        list(customerId, params, RequestOptions.none())

    /** @see list */
    fun list(
        customerId: String,
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListResponse> =
        list(params.toBuilder().customerId(customerId).build(), requestOptions)

    /** @see list */
    fun list(params: UserListParams): CompletableFuture<UserListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListResponse>

    /**
     * Removes a user from an organization or sender profile. Requires admin permissions. This
     * action permanently deletes the user association.
     */
    fun delete(userId: String, params: UserDeleteParams): CompletableFuture<Void?> =
        delete(userId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        userId: String,
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see delete */
    fun delete(params: UserDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * Invites a user to an organization or sender profile with a specified role. Requires
     * appropriate permissions. The customerId can be either an organization ID or a profile ID.
     */
    fun invite(customerId: String): CompletableFuture<CustomerUser> =
        invite(customerId, UserInviteParams.none())

    /** @see invite */
    fun invite(
        customerId: String,
        params: UserInviteParams = UserInviteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomerUser> =
        invite(params.toBuilder().customerId(customerId).build(), requestOptions)

    /** @see invite */
    fun invite(
        customerId: String,
        params: UserInviteParams = UserInviteParams.none(),
    ): CompletableFuture<CustomerUser> = invite(customerId, params, RequestOptions.none())

    /** @see invite */
    fun invite(
        params: UserInviteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomerUser>

    /** @see invite */
    fun invite(params: UserInviteParams): CompletableFuture<CustomerUser> =
        invite(params, RequestOptions.none())

    /** @see invite */
    fun invite(
        customerId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomerUser> = invite(customerId, UserInviteParams.none(), requestOptions)

    /**
     * Updates a user's role within an organization or sender profile. Requires admin permissions.
     * Valid roles are: admin, billing, developer.
     */
    fun updateRole(userId: String, params: UserUpdateRoleParams): CompletableFuture<CustomerUser> =
        updateRole(userId, params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        userId: String,
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomerUser> =
        updateRole(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see updateRole */
    fun updateRole(params: UserUpdateRoleParams): CompletableFuture<CustomerUser> =
        updateRole(params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CustomerUser>

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v2/organizations/{customerId}/users/{userId}`, but
         * is otherwise the same as [UserServiceAsync.retrieve].
         */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams,
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(params: UserRetrieveParams): CompletableFuture<HttpResponseFor<CustomerUser>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>>

        /**
         * Returns a raw HTTP response for `get /v2/organizations/{customerId}/users`, but is
         * otherwise the same as [UserServiceAsync.list].
         */
        fun list(
            customerId: String,
            params: UserListParams,
        ): CompletableFuture<HttpResponseFor<UserListResponse>> =
            list(customerId, params, RequestOptions.none())

        /** @see list */
        fun list(
            customerId: String,
            params: UserListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListResponse>> =
            list(params.toBuilder().customerId(customerId).build(), requestOptions)

        /** @see list */
        fun list(params: UserListParams): CompletableFuture<HttpResponseFor<UserListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: UserListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListResponse>>

        /**
         * Returns a raw HTTP response for `delete /v2/organizations/{customerId}/users/{userId}`,
         * but is otherwise the same as [UserServiceAsync.delete].
         */
        fun delete(userId: String, params: UserDeleteParams): CompletableFuture<HttpResponse> =
            delete(userId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            userId: String,
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see delete */
        fun delete(params: UserDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /v2/organizations/{customerId}/users`, but is
         * otherwise the same as [UserServiceAsync.invite].
         */
        fun invite(customerId: String): CompletableFuture<HttpResponseFor<CustomerUser>> =
            invite(customerId, UserInviteParams.none())

        /** @see invite */
        fun invite(
            customerId: String,
            params: UserInviteParams = UserInviteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            invite(params.toBuilder().customerId(customerId).build(), requestOptions)

        /** @see invite */
        fun invite(
            customerId: String,
            params: UserInviteParams = UserInviteParams.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            invite(customerId, params, RequestOptions.none())

        /** @see invite */
        fun invite(
            params: UserInviteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>>

        /** @see invite */
        fun invite(params: UserInviteParams): CompletableFuture<HttpResponseFor<CustomerUser>> =
            invite(params, RequestOptions.none())

        /** @see invite */
        fun invite(
            customerId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            invite(customerId, UserInviteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v2/organizations/{customerId}/users/{userId}`, but
         * is otherwise the same as [UserServiceAsync.updateRole].
         */
        fun updateRole(
            userId: String,
            params: UserUpdateRoleParams,
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            updateRole(userId, params, RequestOptions.none())

        /** @see updateRole */
        fun updateRole(
            userId: String,
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            updateRole(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see updateRole */
        fun updateRole(
            params: UserUpdateRoleParams
        ): CompletableFuture<HttpResponseFor<CustomerUser>> =
            updateRole(params, RequestOptions.none())

        /** @see updateRole */
        fun updateRole(
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CustomerUser>>
    }
}
