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
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepareAsync
import com.sent_dm.api.models.lookup.LookupRetrievePhoneInfoParams
import com.sent_dm.api.models.lookup.LookupRetrievePhoneInfoResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class LookupServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    LookupServiceAsync {

    private val withRawResponse: LookupServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LookupServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): LookupServiceAsync =
        LookupServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrievePhoneInfo(
        params: LookupRetrievePhoneInfoParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<LookupRetrievePhoneInfoResponse> =
        // get /v3/lookup/number/{phoneNumber}
        withRawResponse().retrievePhoneInfo(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LookupServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LookupServiceAsync.WithRawResponse =
            LookupServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrievePhoneInfoHandler: Handler<LookupRetrievePhoneInfoResponse> =
            jsonHandler<LookupRetrievePhoneInfoResponse>(clientOptions.jsonMapper)

        override fun retrievePhoneInfo(
            params: LookupRetrievePhoneInfoParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<LookupRetrievePhoneInfoResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("phoneNumber", params.phoneNumber().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "lookup", "number", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrievePhoneInfoHandler.handle(it) }
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
