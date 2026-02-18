// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.users.ApiResponseOfUser
import com.sent_dm.api.models.users.UserInviteParams
import com.sent_dm.api.models.users.UserListParams
import com.sent_dm.api.models.users.UserListResponse
import com.sent_dm.api.models.users.UserRemoveParams
import com.sent_dm.api.models.users.UserRetrieveParams
import com.sent_dm.api.models.users.UserUpdateRoleParams
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
     * Retrieves detailed information about a specific user in an organization or profile. Requires
     * developer role or higher.
     */
    fun retrieve(userId: String): CompletableFuture<ApiResponseOfUser> =
        retrieve(userId, UserRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfUser> =
        retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
    ): CompletableFuture<ApiResponseOfUser> = retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfUser>

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): CompletableFuture<ApiResponseOfUser> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfUser> =
        retrieve(userId, UserRetrieveParams.none(), requestOptions)

    /**
     * Retrieves all users who have access to the organization or profile identified by the API key,
     * including their roles and status. Shows invited users (pending acceptance) and active users.
     * Requires developer role or higher.
     */
    fun list(): CompletableFuture<UserListResponse> = list(UserListParams.none())

    /** @see list */
    fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UserListResponse>

    /** @see list */
    fun list(params: UserListParams = UserListParams.none()): CompletableFuture<UserListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<UserListResponse> =
        list(UserListParams.none(), requestOptions)

    /**
     * Sends an invitation to a user to join the organization or profile with a specific role.
     * Requires admin role. The user will receive an invitation email with a token to accept.
     * Invitation tokens expire after 7 days.
     */
    fun invite(): CompletableFuture<ApiResponseOfUser> = invite(UserInviteParams.none())

    /** @see invite */
    fun invite(
        params: UserInviteParams = UserInviteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfUser>

    /** @see invite */
    fun invite(
        params: UserInviteParams = UserInviteParams.none()
    ): CompletableFuture<ApiResponseOfUser> = invite(params, RequestOptions.none())

    /** @see invite */
    fun invite(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfUser> =
        invite(UserInviteParams.none(), requestOptions)

    /**
     * Removes a user's access to an organization or profile. Requires admin role. You cannot remove
     * yourself or remove the last admin.
     */
    fun remove(pathUserId: String): CompletableFuture<Void?> =
        remove(pathUserId, UserRemoveParams.none())

    /** @see remove */
    fun remove(
        pathUserId: String,
        params: UserRemoveParams = UserRemoveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        remove(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

    /** @see remove */
    fun remove(
        pathUserId: String,
        params: UserRemoveParams = UserRemoveParams.none(),
    ): CompletableFuture<Void?> = remove(pathUserId, params, RequestOptions.none())

    /** @see remove */
    fun remove(
        params: UserRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see remove */
    fun remove(params: UserRemoveParams): CompletableFuture<Void?> =
        remove(params, RequestOptions.none())

    /** @see remove */
    fun remove(pathUserId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        remove(pathUserId, UserRemoveParams.none(), requestOptions)

    /**
     * Updates a user's role in the organization or profile. Requires admin role. You cannot change
     * your own role or demote the last admin.
     */
    fun updateRole(pathUserId: String): CompletableFuture<ApiResponseOfUser> =
        updateRole(pathUserId, UserUpdateRoleParams.none())

    /** @see updateRole */
    fun updateRole(
        pathUserId: String,
        params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfUser> =
        updateRole(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

    /** @see updateRole */
    fun updateRole(
        pathUserId: String,
        params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
    ): CompletableFuture<ApiResponseOfUser> = updateRole(pathUserId, params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfUser>

    /** @see updateRole */
    fun updateRole(params: UserUpdateRoleParams): CompletableFuture<ApiResponseOfUser> =
        updateRole(params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        pathUserId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfUser> =
        updateRole(pathUserId, UserUpdateRoleParams.none(), requestOptions)

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/users/{userId}`, but is otherwise the same as
         * [UserServiceAsync.retrieve].
         */
        fun retrieve(userId: String): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            retrieve(userId, UserRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>>

        /** @see retrieve */
        fun retrieve(
            params: UserRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            userId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            retrieve(userId, UserRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/users`, but is otherwise the same as
         * [UserServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<UserListResponse>> =
            list(UserListParams.none())

        /** @see list */
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UserListResponse>>

        /** @see list */
        fun list(
            params: UserListParams = UserListParams.none()
        ): CompletableFuture<HttpResponseFor<UserListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UserListResponse>> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/users`, but is otherwise the same as
         * [UserServiceAsync.invite].
         */
        fun invite(): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            invite(UserInviteParams.none())

        /** @see invite */
        fun invite(
            params: UserInviteParams = UserInviteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>>

        /** @see invite */
        fun invite(
            params: UserInviteParams = UserInviteParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            invite(params, RequestOptions.none())

        /** @see invite */
        fun invite(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            invite(UserInviteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/users/{userId}`, but is otherwise the same as
         * [UserServiceAsync.remove].
         */
        fun remove(pathUserId: String): CompletableFuture<HttpResponse> =
            remove(pathUserId, UserRemoveParams.none())

        /** @see remove */
        fun remove(
            pathUserId: String,
            params: UserRemoveParams = UserRemoveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            remove(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

        /** @see remove */
        fun remove(
            pathUserId: String,
            params: UserRemoveParams = UserRemoveParams.none(),
        ): CompletableFuture<HttpResponse> = remove(pathUserId, params, RequestOptions.none())

        /** @see remove */
        fun remove(
            params: UserRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see remove */
        fun remove(params: UserRemoveParams): CompletableFuture<HttpResponse> =
            remove(params, RequestOptions.none())

        /** @see remove */
        fun remove(
            pathUserId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            remove(pathUserId, UserRemoveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/users/{userId}`, but is otherwise the same as
         * [UserServiceAsync.updateRole].
         */
        fun updateRole(pathUserId: String): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            updateRole(pathUserId, UserUpdateRoleParams.none())

        /** @see updateRole */
        fun updateRole(
            pathUserId: String,
            params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            updateRole(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

        /** @see updateRole */
        fun updateRole(
            pathUserId: String,
            params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            updateRole(pathUserId, params, RequestOptions.none())

        /** @see updateRole */
        fun updateRole(
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>>

        /** @see updateRole */
        fun updateRole(
            params: UserUpdateRoleParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            updateRole(params, RequestOptions.none())

        /** @see updateRole */
        fun updateRole(
            pathUserId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfUser>> =
            updateRole(pathUserId, UserUpdateRoleParams.none(), requestOptions)
    }
}
