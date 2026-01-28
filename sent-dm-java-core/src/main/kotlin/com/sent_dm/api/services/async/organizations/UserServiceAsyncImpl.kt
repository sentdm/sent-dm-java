// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async.organizations

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.handlers.emptyHandler
import com.sent_dm.api.core.handlers.errorBodyHandler
import com.sent_dm.api.core.handlers.errorHandler
import com.sent_dm.api.core.handlers.jsonHandler
import com.sent_dm.api.core.http.HttpMethod
import com.sent_dm.api.core.http.HttpRequest
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponse.Handler
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.core.http.json
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepareAsync
import com.sent_dm.api.models.organizations.users.CustomerUser
import com.sent_dm.api.models.organizations.users.UserDeleteParams
import com.sent_dm.api.models.organizations.users.UserInviteParams
import com.sent_dm.api.models.organizations.users.UserListParams
import com.sent_dm.api.models.organizations.users.UserListResponse
import com.sent_dm.api.models.organizations.users.UserRetrieveParams
import com.sent_dm.api.models.organizations.users.UserUpdateRoleParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class UserServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UserServiceAsync {

    private val withRawResponse: UserServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UserServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UserServiceAsync =
        UserServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomerUser> =
        // get /v2/organizations/{customerId}/users/{userId}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: UserListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UserListResponse> =
        // get /v2/organizations/{customerId}/users
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: UserDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v2/organizations/{customerId}/users/{userId}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun invite(
        params: UserInviteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomerUser> =
        // post /v2/organizations/{customerId}/users
        withRawResponse().invite(params, requestOptions).thenApply { it.parse() }

    override fun updateRole(
        params: UserUpdateRoleParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CustomerUser> =
        // put /v2/organizations/{customerId}/users/{userId}
        withRawResponse().updateRole(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UserServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UserServiceAsync.WithRawResponse =
            UserServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<CustomerUser> =
            jsonHandler<CustomerUser>(clientOptions.jsonMapper)

        override fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomerUser>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v2",
                        "organizations",
                        params._pathParam(0),
                        "users",
                        params._pathParam(1),
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<UserListResponse> =
            jsonHandler<UserListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: UserListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UserListResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("customerId", params.customerId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "organizations", params._pathParam(0), "users")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: UserDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v2",
                        "organizations",
                        params._pathParam(0),
                        "users",
                        params._pathParam(1),
                    )
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }

        private val inviteHandler: Handler<CustomerUser> =
            jsonHandler<CustomerUser>(clientOptions.jsonMapper)

        override fun invite(
            params: UserInviteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomerUser>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("customerId", params.customerId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "organizations", params._pathParam(0), "users")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { inviteHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateRoleHandler: Handler<CustomerUser> =
            jsonHandler<CustomerUser>(clientOptions.jsonMapper)

        override fun updateRole(
            params: UserUpdateRoleParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CustomerUser>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("userId", params.userId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v2",
                        "organizations",
                        params._pathParam(0),
                        "users",
                        params._pathParam(1),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateRoleHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
