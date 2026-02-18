// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.users.ApiResponseOfUser
import dm.sent.models.users.UserInviteParams
import dm.sent.models.users.UserListParams
import dm.sent.models.users.UserListResponse
import dm.sent.models.users.UserRemoveParams
import dm.sent.models.users.UserRetrieveParams
import dm.sent.models.users.UserUpdateRoleParams
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
     * Retrieves detailed information about a specific user in an organization or profile. Requires
     * developer role or higher.
     */
    fun retrieve(userId: String): ApiResponseOfUser = retrieve(userId, UserRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfUser = retrieve(params.toBuilder().userId(userId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        userId: String,
        params: UserRetrieveParams = UserRetrieveParams.none(),
    ): ApiResponseOfUser = retrieve(userId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfUser

    /** @see retrieve */
    fun retrieve(params: UserRetrieveParams): ApiResponseOfUser =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(userId: String, requestOptions: RequestOptions): ApiResponseOfUser =
        retrieve(userId, UserRetrieveParams.none(), requestOptions)

    /**
     * Retrieves all users who have access to the organization or profile identified by the API key,
     * including their roles and status. Shows invited users (pending acceptance) and active users.
     * Requires developer role or higher.
     */
    fun list(): UserListResponse = list(UserListParams.none())

    /** @see list */
    fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListResponse

    /** @see list */
    fun list(params: UserListParams = UserListParams.none()): UserListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): UserListResponse =
        list(UserListParams.none(), requestOptions)

    /**
     * Sends an invitation to a user to join the organization or profile with a specific role.
     * Requires admin role. The user will receive an invitation email with a token to accept.
     * Invitation tokens expire after 7 days.
     */
    fun invite(): ApiResponseOfUser = invite(UserInviteParams.none())

    /** @see invite */
    fun invite(
        params: UserInviteParams = UserInviteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfUser

    /** @see invite */
    fun invite(params: UserInviteParams = UserInviteParams.none()): ApiResponseOfUser =
        invite(params, RequestOptions.none())

    /** @see invite */
    fun invite(requestOptions: RequestOptions): ApiResponseOfUser =
        invite(UserInviteParams.none(), requestOptions)

    /**
     * Removes a user's access to an organization or profile. Requires admin role. You cannot remove
     * yourself or remove the last admin.
     */
    fun remove(pathUserId: String) = remove(pathUserId, UserRemoveParams.none())

    /** @see remove */
    fun remove(
        pathUserId: String,
        params: UserRemoveParams = UserRemoveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = remove(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

    /** @see remove */
    fun remove(pathUserId: String, params: UserRemoveParams = UserRemoveParams.none()) =
        remove(pathUserId, params, RequestOptions.none())

    /** @see remove */
    fun remove(params: UserRemoveParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see remove */
    fun remove(params: UserRemoveParams) = remove(params, RequestOptions.none())

    /** @see remove */
    fun remove(pathUserId: String, requestOptions: RequestOptions) =
        remove(pathUserId, UserRemoveParams.none(), requestOptions)

    /**
     * Updates a user's role in the organization or profile. Requires admin role. You cannot change
     * your own role or demote the last admin.
     */
    fun updateRole(pathUserId: String): ApiResponseOfUser =
        updateRole(pathUserId, UserUpdateRoleParams.none())

    /** @see updateRole */
    fun updateRole(
        pathUserId: String,
        params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfUser =
        updateRole(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

    /** @see updateRole */
    fun updateRole(
        pathUserId: String,
        params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
    ): ApiResponseOfUser = updateRole(pathUserId, params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfUser

    /** @see updateRole */
    fun updateRole(params: UserUpdateRoleParams): ApiResponseOfUser =
        updateRole(params, RequestOptions.none())

    /** @see updateRole */
    fun updateRole(pathUserId: String, requestOptions: RequestOptions): ApiResponseOfUser =
        updateRole(pathUserId, UserUpdateRoleParams.none(), requestOptions)

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/users/{userId}`, but is otherwise the same as
         * [UserService.retrieve].
         */
        @MustBeClosed
        fun retrieve(userId: String): HttpResponseFor<ApiResponseOfUser> =
            retrieve(userId, UserRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfUser> =
            retrieve(params.toBuilder().userId(userId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            params: UserRetrieveParams = UserRetrieveParams.none(),
        ): HttpResponseFor<ApiResponseOfUser> = retrieve(userId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfUser>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: UserRetrieveParams): HttpResponseFor<ApiResponseOfUser> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            userId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfUser> =
            retrieve(userId, UserRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/users`, but is otherwise the same as
         * [UserService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<UserListResponse> = list(UserListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: UserListParams = UserListParams.none()
        ): HttpResponseFor<UserListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<UserListResponse> =
            list(UserListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/users`, but is otherwise the same as
         * [UserService.invite].
         */
        @MustBeClosed
        fun invite(): HttpResponseFor<ApiResponseOfUser> = invite(UserInviteParams.none())

        /** @see invite */
        @MustBeClosed
        fun invite(
            params: UserInviteParams = UserInviteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfUser>

        /** @see invite */
        @MustBeClosed
        fun invite(
            params: UserInviteParams = UserInviteParams.none()
        ): HttpResponseFor<ApiResponseOfUser> = invite(params, RequestOptions.none())

        /** @see invite */
        @MustBeClosed
        fun invite(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfUser> =
            invite(UserInviteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/users/{userId}`, but is otherwise the same as
         * [UserService.remove].
         */
        @MustBeClosed
        fun remove(pathUserId: String): HttpResponse = remove(pathUserId, UserRemoveParams.none())

        /** @see remove */
        @MustBeClosed
        fun remove(
            pathUserId: String,
            params: UserRemoveParams = UserRemoveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = remove(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

        /** @see remove */
        @MustBeClosed
        fun remove(
            pathUserId: String,
            params: UserRemoveParams = UserRemoveParams.none(),
        ): HttpResponse = remove(pathUserId, params, RequestOptions.none())

        /** @see remove */
        @MustBeClosed
        fun remove(
            params: UserRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see remove */
        @MustBeClosed
        fun remove(params: UserRemoveParams): HttpResponse = remove(params, RequestOptions.none())

        /** @see remove */
        @MustBeClosed
        fun remove(pathUserId: String, requestOptions: RequestOptions): HttpResponse =
            remove(pathUserId, UserRemoveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/users/{userId}`, but is otherwise the same as
         * [UserService.updateRole].
         */
        @MustBeClosed
        fun updateRole(pathUserId: String): HttpResponseFor<ApiResponseOfUser> =
            updateRole(pathUserId, UserUpdateRoleParams.none())

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(
            pathUserId: String,
            params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfUser> =
            updateRole(params.toBuilder().pathUserId(pathUserId).build(), requestOptions)

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(
            pathUserId: String,
            params: UserUpdateRoleParams = UserUpdateRoleParams.none(),
        ): HttpResponseFor<ApiResponseOfUser> =
            updateRole(pathUserId, params, RequestOptions.none())

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfUser>

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(params: UserUpdateRoleParams): HttpResponseFor<ApiResponseOfUser> =
            updateRole(params, RequestOptions.none())

        /** @see updateRole */
        @MustBeClosed
        fun updateRole(
            pathUserId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfUser> =
            updateRole(pathUserId, UserUpdateRoleParams.none(), requestOptions)
    }
}
