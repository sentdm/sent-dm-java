// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
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
import com.sent_dm.api.models.numberlookup.NumberLookupRetrieveParams
import com.sent_dm.api.models.numberlookup.NumberLookupRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class NumberLookupServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    NumberLookupServiceAsync {

    private val withRawResponse: NumberLookupServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): NumberLookupServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): NumberLookupServiceAsync =
        NumberLookupServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: NumberLookupRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<NumberLookupRetrieveResponse> =
        // get /v2/number-lookup
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        NumberLookupServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): NumberLookupServiceAsync.WithRawResponse =
            NumberLookupServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<NumberLookupRetrieveResponse> =
            jsonHandler<NumberLookupRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: NumberLookupRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<NumberLookupRetrieveResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "number-lookup")
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
    }
}
