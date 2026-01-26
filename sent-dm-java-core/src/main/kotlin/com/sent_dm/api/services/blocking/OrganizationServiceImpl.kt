// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

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
import com.sent_dm.api.core.prepare
import com.sent_dm.api.models.organizations.OrganizationListParams
import com.sent_dm.api.models.organizations.OrganizationListResponse
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesParams
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesResponse
import com.sent_dm.api.services.blocking.organizations.UserService
import com.sent_dm.api.services.blocking.organizations.UserServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrganizationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrganizationService {

    private val withRawResponse: OrganizationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    override fun withRawResponse(): OrganizationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrganizationService =
        OrganizationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun users(): UserService = users

    override fun list(
        params: OrganizationListParams,
        requestOptions: RequestOptions,
    ): OrganizationListResponse =
        // get /v2/organizations
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveProfiles(
        params: OrganizationRetrieveProfilesParams,
        requestOptions: RequestOptions,
    ): OrganizationRetrieveProfilesResponse =
        // get /v2/organizations/{orgId}/profiles
        withRawResponse().retrieveProfiles(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrganizationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrganizationService.WithRawResponse =
            OrganizationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun users(): UserService.WithRawResponse = users

        private val listHandler: Handler<OrganizationListResponse> =
            jsonHandler<OrganizationListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: OrganizationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "organizations")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveProfilesHandler: Handler<OrganizationRetrieveProfilesResponse> =
            jsonHandler<OrganizationRetrieveProfilesResponse>(clientOptions.jsonMapper)

        override fun retrieveProfiles(
            params: OrganizationRetrieveProfilesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<OrganizationRetrieveProfilesResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orgId", params.orgId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "organizations", params._pathParam(0), "profiles")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
