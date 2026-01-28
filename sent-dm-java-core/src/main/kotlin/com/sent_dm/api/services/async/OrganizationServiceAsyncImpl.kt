// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.handlers.errorBodyHandler
import com.sent_dm.api.core.handlers.errorHandler
import com.sent_dm.api.core.handlers.jsonHandler
import com.sent_dm.api.core.http.HttpMethod
import com.sent_dm.api.core.http.HttpRequest
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponse.Handler
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepareAsync
import com.sent_dm.api.models.organizations.OrganizationListParams
import com.sent_dm.api.models.organizations.OrganizationListResponse
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesParams
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesResponse
import com.sent_dm.api.services.async.organizations.UserServiceAsync
import com.sent_dm.api.services.async.organizations.UserServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrganizationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    OrganizationServiceAsync {

    private val withRawResponse: OrganizationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): OrganizationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationServiceAsync =
        OrganizationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun users(): UserServiceAsync = users

    override fun list(
        params: OrganizationListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationListResponse> =
        // get /v2/organizations
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun retrieveProfiles(
        params: OrganizationRetrieveProfilesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<OrganizationRetrieveProfilesResponse> =
        // get /v2/organizations/{orgId}/profiles
        withRawResponse().retrieveProfiles(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrganizationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationServiceAsync.WithRawResponse =
            OrganizationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun users(): UserServiceAsync.WithRawResponse = users

        private val listHandler: Handler<OrganizationListResponse> =
            jsonHandler<OrganizationListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: OrganizationListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "organizations")
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

        private val retrieveProfilesHandler: Handler<OrganizationRetrieveProfilesResponse> =
            jsonHandler<OrganizationRetrieveProfilesResponse>(clientOptions.jsonMapper)

        override fun retrieveProfiles(
            params: OrganizationRetrieveProfilesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<OrganizationRetrieveProfilesResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orgId", params.orgId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "organizations", params._pathParam(0), "profiles")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveProfilesHandler.handle(it) }
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
