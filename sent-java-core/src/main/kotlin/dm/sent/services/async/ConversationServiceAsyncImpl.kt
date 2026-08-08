// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.checkRequired
import dm.sent.core.handlers.errorBodyHandler
import dm.sent.core.handlers.errorHandler
import dm.sent.core.handlers.jsonHandler
import dm.sent.core.http.HttpMethod
import dm.sent.core.http.HttpRequest
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler
import dm.sent.core.http.HttpResponseFor
import dm.sent.core.http.parseable
import dm.sent.core.prepareAsync
import dm.sent.models.conversations.ApiResponseOfConversationMessagesList
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ConversationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ConversationServiceAsync {

    private val withRawResponse: ConversationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ConversationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ConversationServiceAsync =
        ConversationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: ConversationListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfConversationMessagesList> =
        // get /v3/conversations
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfConversationMessagesList> =
        // get /v3/conversations/{id}
        withRawResponse().listMessages(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ConversationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ConversationServiceAsync.WithRawResponse =
            ConversationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ApiResponseOfConversationMessagesList> =
            jsonHandler<ApiResponseOfConversationMessagesList>(clientOptions.jsonMapper)

        override fun list(
            params: ConversationListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfConversationMessagesList>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "conversations")
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

        private val listMessagesHandler: Handler<ApiResponseOfConversationMessagesList> =
            jsonHandler<ApiResponseOfConversationMessagesList>(clientOptions.jsonMapper)

        override fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfConversationMessagesList>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "conversations", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listMessagesHandler.handle(it) }
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
