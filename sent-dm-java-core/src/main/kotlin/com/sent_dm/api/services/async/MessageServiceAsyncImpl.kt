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
import com.sent_dm.api.core.http.json
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepareAsync
import com.sent_dm.api.models.messages.MessageRetrieveActivitiesParams
import com.sent_dm.api.models.messages.MessageRetrieveActivitiesResponse
import com.sent_dm.api.models.messages.MessageRetrieveStatusParams
import com.sent_dm.api.models.messages.MessageRetrieveStatusResponse
import com.sent_dm.api.models.messages.MessageSendParams
import com.sent_dm.api.models.messages.MessageSendResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MessageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageServiceAsync {

    private val withRawResponse: MessageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageServiceAsync =
        MessageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveActivities(
        params: MessageRetrieveActivitiesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageRetrieveActivitiesResponse> =
        // get /v3/messages/{id}/activities
        withRawResponse().retrieveActivities(params, requestOptions).thenApply { it.parse() }

    override fun retrieveStatus(
        params: MessageRetrieveStatusParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageRetrieveStatusResponse> =
        // get /v3/messages/{id}
        withRawResponse().retrieveStatus(params, requestOptions).thenApply { it.parse() }

    override fun send(
        params: MessageSendParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MessageSendResponse> =
        // post /v3/messages
        withRawResponse().send(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageServiceAsync.WithRawResponse =
            MessageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveActivitiesHandler: Handler<MessageRetrieveActivitiesResponse> =
            jsonHandler<MessageRetrieveActivitiesResponse>(clientOptions.jsonMapper)

        override fun retrieveActivities(
            params: MessageRetrieveActivitiesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageRetrieveActivitiesResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "messages", params._pathParam(0), "activities")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveActivitiesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveStatusHandler: Handler<MessageRetrieveStatusResponse> =
            jsonHandler<MessageRetrieveStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveStatus(
            params: MessageRetrieveStatusParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageRetrieveStatusResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "messages", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveStatusHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val sendHandler: Handler<MessageSendResponse> =
            jsonHandler<MessageSendResponse>(clientOptions.jsonMapper)

        override fun send(
            params: MessageSendParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MessageSendResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "messages")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { sendHandler.handle(it) }
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
