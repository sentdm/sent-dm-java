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
import com.sent_dm.api.core.http.json
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepare
import com.sent_dm.api.models.messages.MessageRetrieveActivitiesParams
import com.sent_dm.api.models.messages.MessageRetrieveActivitiesResponse
import com.sent_dm.api.models.messages.MessageRetrieveStatusParams
import com.sent_dm.api.models.messages.MessageRetrieveStatusResponse
import com.sent_dm.api.models.messages.MessageSendParams
import com.sent_dm.api.models.messages.MessageSendResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MessageService =
        MessageServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveActivities(
        params: MessageRetrieveActivitiesParams,
        requestOptions: RequestOptions,
    ): MessageRetrieveActivitiesResponse =
        // get /v3/messages/{id}/activities
        withRawResponse().retrieveActivities(params, requestOptions).parse()

    override fun retrieveStatus(
        params: MessageRetrieveStatusParams,
        requestOptions: RequestOptions,
    ): MessageRetrieveStatusResponse =
        // get /v3/messages/{id}
        withRawResponse().retrieveStatus(params, requestOptions).parse()

    override fun send(
        params: MessageSendParams,
        requestOptions: RequestOptions,
    ): MessageSendResponse =
        // post /v3/messages
        withRawResponse().send(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MessageService.WithRawResponse =
            MessageServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveActivitiesHandler: Handler<MessageRetrieveActivitiesResponse> =
            jsonHandler<MessageRetrieveActivitiesResponse>(clientOptions.jsonMapper)

        override fun retrieveActivities(
            params: MessageRetrieveActivitiesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageRetrieveActivitiesResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "messages", params._pathParam(0), "activities")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveActivitiesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveStatusHandler: Handler<MessageRetrieveStatusResponse> =
            jsonHandler<MessageRetrieveStatusResponse>(clientOptions.jsonMapper)

        override fun retrieveStatus(
            params: MessageRetrieveStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageRetrieveStatusResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "messages", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val sendHandler: Handler<MessageSendResponse> =
            jsonHandler<MessageSendResponse>(clientOptions.jsonMapper)

        override fun send(
            params: MessageSendParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageSendResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "messages")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
