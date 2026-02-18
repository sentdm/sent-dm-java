// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

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
import com.sent_dm.api.models.profiles.ApiResponseOfProfileDetail
import com.sent_dm.api.models.profiles.ProfileCompleteParams
import com.sent_dm.api.models.profiles.ProfileCompleteResponse
import com.sent_dm.api.models.profiles.ProfileCreateParams
import com.sent_dm.api.models.profiles.ProfileDeleteParams
import com.sent_dm.api.models.profiles.ProfileListParams
import com.sent_dm.api.models.profiles.ProfileListResponse
import com.sent_dm.api.models.profiles.ProfileRetrieveParams
import com.sent_dm.api.models.profiles.ProfileUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ProfileServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ProfileServiceAsync {

    private val withRawResponse: ProfileServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ProfileServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileServiceAsync =
        ProfileServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ProfileCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        // post /v3/profiles
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: ProfileRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        // get /v3/profiles/{profileId}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: ProfileUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfProfileDetail> =
        // patch /v3/profiles/{profileId}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ProfileListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProfileListResponse> =
        // get /v3/profiles
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ProfileDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v3/profiles/{profileId}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun complete(
        params: ProfileCompleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProfileCompleteResponse> =
        // post /v3/profiles/{profileId}/complete
        withRawResponse().complete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProfileServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProfileServiceAsync.WithRawResponse =
            ProfileServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ApiResponseOfProfileDetail> =
            jsonHandler<ApiResponseOfProfileDetail>(clientOptions.jsonMapper)

        override fun create(
            params: ProfileCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<ApiResponseOfProfileDetail> =
            jsonHandler<ApiResponseOfProfileDetail>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ProfileRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("profileId", params.profileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0))
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

        private val updateHandler: Handler<ApiResponseOfProfileDetail> =
            jsonHandler<ApiResponseOfProfileDetail>(clientOptions.jsonMapper)

        override fun update(
            params: ProfileUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfProfileDetail>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("pathProfileId", params.pathProfileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ProfileListResponse> =
            jsonHandler<ProfileListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ProfileListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProfileListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles")
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
            params: ProfileDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("pathProfileId", params.pathProfileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
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

        private val completeHandler: Handler<ProfileCompleteResponse> =
            jsonHandler<ProfileCompleteResponse>(clientOptions.jsonMapper)

        override fun complete(
            params: ProfileCompleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProfileCompleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("profileId", params.profileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0), "complete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { completeHandler.handle(it) }
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
