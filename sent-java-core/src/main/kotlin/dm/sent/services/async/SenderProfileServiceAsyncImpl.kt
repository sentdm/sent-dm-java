// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.checkRequired
import dm.sent.core.handlers.emptyHandler
import dm.sent.core.handlers.errorBodyHandler
import dm.sent.core.handlers.errorHandler
import dm.sent.core.handlers.jsonHandler
import dm.sent.core.http.HttpMethod
import dm.sent.core.http.HttpRequest
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler
import dm.sent.core.http.HttpResponseFor
import dm.sent.core.http.json
import dm.sent.core.http.multipartFormData
import dm.sent.core.http.parseable
import dm.sent.core.prepareAsync
import dm.sent.models.senderprofiles.ApiResponseOfSenderProfile
import dm.sent.models.senderprofiles.ApiResponseOfSenderProfilesList
import dm.sent.models.senderprofiles.SenderProfileCreateParams
import dm.sent.models.senderprofiles.SenderProfileDeleteParams
import dm.sent.models.senderprofiles.SenderProfileListPageAsync
import dm.sent.models.senderprofiles.SenderProfileListParams
import dm.sent.models.senderprofiles.SenderProfileRetrieveParams
import dm.sent.models.senderprofiles.SenderProfileUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Your customers, each sending as itself.
 *
 * A sender profile is a tenant of yours: it has its own API key, its own balance, and can have its
 * own identity and senders — so your customers send under their own brand and never see Sent. Depth
 * is one; a profile cannot create profiles.
 *
 * **Everything is inherited unless the profile owns it.** `{ "name": "…" }` alone gives you a
 * usable profile immediately, running on your identity, your inbox and your billing. Supply a
 * capability's fields and the profile owns that one instead.
 *
 * **A sender is the exception.** A brand and a campaign can be inherited; a number cannot. A
 * profile either has a sender of its own or terminates through your shared routes.
 *
 * To act for a profile on any other resource, send `x-profile-id` with your organization key rather
 * than looking for a parallel set of endpoints.
 */
class SenderProfileServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SenderProfileServiceAsync {

    private val withRawResponse: SenderProfileServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SenderProfileServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SenderProfileServiceAsync =
        SenderProfileServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SenderProfileCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfSenderProfile> =
        // post /v3/sender-profiles
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: SenderProfileRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfSenderProfile> =
        // get /v3/sender-profiles/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: SenderProfileUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfSenderProfile> =
        // patch /v3/sender-profiles/{id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: SenderProfileListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SenderProfileListPageAsync> =
        // get /v3/sender-profiles
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: SenderProfileDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /v3/sender-profiles/{id}
        withRawResponse().delete(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SenderProfileServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SenderProfileServiceAsync.WithRawResponse =
            SenderProfileServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ApiResponseOfSenderProfile> =
            jsonHandler<ApiResponseOfSenderProfile>(clientOptions.jsonMapper)

        override fun create(
            params: SenderProfileCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSenderProfile>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "sender-profiles")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
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

        private val retrieveHandler: Handler<ApiResponseOfSenderProfile> =
            jsonHandler<ApiResponseOfSenderProfile>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SenderProfileRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSenderProfile>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "sender-profiles", params._pathParam(0))
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

        private val updateHandler: Handler<ApiResponseOfSenderProfile> =
            jsonHandler<ApiResponseOfSenderProfile>(clientOptions.jsonMapper)

        override fun update(
            params: SenderProfileUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSenderProfile>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "sender-profiles", params._pathParam(0))
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

        private val listHandler: Handler<ApiResponseOfSenderProfilesList> =
            jsonHandler<ApiResponseOfSenderProfilesList>(clientOptions.jsonMapper)

        override fun list(
            params: SenderProfileListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SenderProfileListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "sender-profiles")
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
                            .let {
                                SenderProfileListPageAsync.builder()
                                    .service(SenderProfileServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: SenderProfileDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "sender-profiles", params._pathParam(0))
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
    }
}
