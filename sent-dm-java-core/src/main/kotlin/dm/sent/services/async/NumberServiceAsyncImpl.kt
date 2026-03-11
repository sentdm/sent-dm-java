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
import dm.sent.models.numbers.NumberLookupParams
import dm.sent.models.numbers.NumberLookupResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Manage and lookup phone numbers */
class NumberServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    NumberServiceAsync {

    private val withRawResponse: NumberServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): NumberServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberServiceAsync =
        NumberServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun lookup(
        params: NumberLookupParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NumberLookupResponse> =
        // get /v3/numbers/lookup/{phoneNumber}
        withRawResponse().lookup(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NumberServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NumberServiceAsync.WithRawResponse =
            NumberServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val lookupHandler: Handler<NumberLookupResponse> =
            jsonHandler<NumberLookupResponse>(clientOptions.jsonMapper)

        override fun lookup(
            params: NumberLookupParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NumberLookupResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("phoneNumber", params.phoneNumber().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "numbers", "lookup", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { lookupHandler.handle(it) }
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
