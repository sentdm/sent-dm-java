// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

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
import dm.sent.core.prepare
import dm.sent.models.conversations.ApiResponseOfConversationMessagesList
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ConversationServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ConversationService {

    private val withRawResponse: ConversationService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ConversationService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ConversationService =
        ConversationServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: ConversationListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfConversationMessagesList =
        // get /v3/conversations
        withRawResponse().list(params, requestOptions).parse()

    override fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfConversationMessagesList =
        // get /v3/conversations/{id}
        withRawResponse().listMessages(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ConversationService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ConversationService.WithRawResponse =
            ConversationServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ApiResponseOfConversationMessagesList> =
            jsonHandler<ApiResponseOfConversationMessagesList>(clientOptions.jsonMapper)

        override fun list(
            params: ConversationListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfConversationMessagesList> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "conversations")
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

        private val listMessagesHandler: Handler<ApiResponseOfConversationMessagesList> =
            jsonHandler<ApiResponseOfConversationMessagesList>(clientOptions.jsonMapper)

        override fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfConversationMessagesList> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "conversations", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
