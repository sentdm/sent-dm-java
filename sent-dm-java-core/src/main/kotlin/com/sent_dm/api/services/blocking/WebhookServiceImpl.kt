// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

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
import com.sent_dm.api.core.prepare
import com.sent_dm.api.models.webhooks.ApiResponseWebhook
import com.sent_dm.api.models.webhooks.WebhookCreateParams
import com.sent_dm.api.models.webhooks.WebhookDeleteParams
import com.sent_dm.api.models.webhooks.WebhookListEventTypesParams
import com.sent_dm.api.models.webhooks.WebhookListEventTypesResponse
import com.sent_dm.api.models.webhooks.WebhookListEventsParams
import com.sent_dm.api.models.webhooks.WebhookListEventsResponse
import com.sent_dm.api.models.webhooks.WebhookListParams
import com.sent_dm.api.models.webhooks.WebhookListResponse
import com.sent_dm.api.models.webhooks.WebhookRetrieveParams
import com.sent_dm.api.models.webhooks.WebhookRotateSecretParams
import com.sent_dm.api.models.webhooks.WebhookRotateSecretResponse
import com.sent_dm.api.models.webhooks.WebhookTestParams
import com.sent_dm.api.models.webhooks.WebhookTestResponse
import com.sent_dm.api.models.webhooks.WebhookToggleStatusParams
import com.sent_dm.api.models.webhooks.WebhookUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WebhookServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    WebhookService {

    private val withRawResponse: WebhookService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): WebhookService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): WebhookService =
        WebhookServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: WebhookCreateParams,
        requestOptions: RequestOptions,
    ): ApiResponseWebhook =
        // post /v3/webhooks
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: WebhookRetrieveParams,
        requestOptions: RequestOptions,
    ): ApiResponseWebhook =
        // get /v3/webhooks/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: WebhookUpdateParams,
        requestOptions: RequestOptions,
    ): ApiResponseWebhook =
        // put /v3/webhooks/{id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: WebhookListParams,
        requestOptions: RequestOptions,
    ): WebhookListResponse =
        // get /v3/webhooks
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: WebhookDeleteParams, requestOptions: RequestOptions) {
        // delete /v3/webhooks/{id}
        withRawResponse().delete(params, requestOptions)
    }

    override fun listEventTypes(
        params: WebhookListEventTypesParams,
        requestOptions: RequestOptions,
    ): WebhookListEventTypesResponse =
        // get /v3/webhooks/event-types
        withRawResponse().listEventTypes(params, requestOptions).parse()

    override fun listEvents(
        params: WebhookListEventsParams,
        requestOptions: RequestOptions,
    ): WebhookListEventsResponse =
        // get /v3/webhooks/{id}/events
        withRawResponse().listEvents(params, requestOptions).parse()

    override fun rotateSecret(
        params: WebhookRotateSecretParams,
        requestOptions: RequestOptions,
    ): WebhookRotateSecretResponse =
        // post /v3/webhooks/{id}/rotate-secret
        withRawResponse().rotateSecret(params, requestOptions).parse()

    override fun test(
        params: WebhookTestParams,
        requestOptions: RequestOptions,
    ): WebhookTestResponse =
        // post /v3/webhooks/{id}/test
        withRawResponse().test(params, requestOptions).parse()

    override fun toggleStatus(
        params: WebhookToggleStatusParams,
        requestOptions: RequestOptions,
    ): ApiResponseWebhook =
        // patch /v3/webhooks/{id}/toggle-status
        withRawResponse().toggleStatus(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WebhookService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WebhookService.WithRawResponse =
            WebhookServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ApiResponseWebhook> =
            jsonHandler<ApiResponseWebhook>(clientOptions.jsonMapper)

        override fun create(
            params: WebhookCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<ApiResponseWebhook> =
            jsonHandler<ApiResponseWebhook>(clientOptions.jsonMapper)

        override fun retrieve(
            params: WebhookRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<ApiResponseWebhook> =
            jsonHandler<ApiResponseWebhook>(clientOptions.jsonMapper)

        override fun update(
            params: WebhookUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<WebhookListResponse> =
            jsonHandler<WebhookListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: WebhookListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks")
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: WebhookDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val listEventTypesHandler: Handler<WebhookListEventTypesResponse> =
            jsonHandler<WebhookListEventTypesResponse>(clientOptions.jsonMapper)

        override fun listEventTypes(
            params: WebhookListEventTypesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookListEventTypesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", "event-types")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listEventTypesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listEventsHandler: Handler<WebhookListEventsResponse> =
            jsonHandler<WebhookListEventsResponse>(clientOptions.jsonMapper)

        override fun listEvents(
            params: WebhookListEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookListEventsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0), "events")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listEventsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val rotateSecretHandler: Handler<WebhookRotateSecretResponse> =
            jsonHandler<WebhookRotateSecretResponse>(clientOptions.jsonMapper)

        override fun rotateSecret(
            params: WebhookRotateSecretParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookRotateSecretResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0), "rotate-secret")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { rotateSecretHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val testHandler: Handler<WebhookTestResponse> =
            jsonHandler<WebhookTestResponse>(clientOptions.jsonMapper)

        override fun test(
            params: WebhookTestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookTestResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0), "test")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { testHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val toggleStatusHandler: Handler<ApiResponseWebhook> =
            jsonHandler<ApiResponseWebhook>(clientOptions.jsonMapper)

        override fun toggleStatus(
            params: WebhookToggleStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseWebhook> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "webhooks", params._pathParam(0), "toggle-status")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { toggleStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
