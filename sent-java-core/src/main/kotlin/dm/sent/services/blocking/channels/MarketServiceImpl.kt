// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

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
import dm.sent.core.http.json
import dm.sent.core.http.parseable
import dm.sent.core.prepare
import dm.sent.models.channels.markets.ApiResponseOfChannelMarket
import dm.sent.models.channels.markets.ApiResponseOfListOfChannelMarket
import dm.sent.models.channels.markets.ApiResponseOfMarketNumbers
import dm.sent.models.channels.markets.MarketAddNumbersParams
import dm.sent.models.channels.markets.MarketListNumbersParams
import dm.sent.models.channels.markets.MarketListParams
import dm.sent.models.channels.markets.MarketReplaceNumbersParams
import dm.sent.models.channels.markets.MarketRetrieveParams
import dm.sent.models.channels.markets.MarketUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * The senders you send from, one per channel.
 *
 * **SMS is a list of markets**, each keyed by `(country, number_type)` — a customer can hold
 * `us/10dlc` and `gb/alphanumeric` at once, so a market is addressed by the pair rather than by
 * country alone. **WhatsApp and RCS are single**: a customer has one business account and one
 * agent. **Voice is per number**: each number you hold can carry phone calls on its own (`POST
 * /v3/channels/voice`), each with the callback URL Sent asks what to do with its calls, one of them
 * is the default line for calls placed from your app, and voice tokens are minted with `POST
 * /v3/voice/tokens`. Read your voice numbers with `GET /v3/channels/voice` and change one with
 * `PATCH /v3/channels/voice/{number}`.
 *
 * ## Compliance lives on the market
 *
 * Adding a market records everything that market registers with, in its `compliance` object. Only
 * **US `TEN_DLC`** registers with a regime — The Campaign Registry — and it is the only market
 * whose compliance carries `brand` and `campaign`. Everywhere else compliance is documents, and
 * many markets ask for none at all.
 *
 * `GET` and `PATCH` on a market return and accept the same shape, so what comes back can be sent
 * back: an omitted key is left alone, and a key reported in `requirements` is the path into the
 * body that clears it.
 *
 * Call `GET /v3/compliance/requirements` first — it answers what a market demands before you hold
 * it, with a body you can fill in and post.
 */
class MarketServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MarketService {

    private val withRawResponse: MarketService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MarketService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketService =
        MarketServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: MarketRetrieveParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfChannelMarket =
        // get /v3/channels/{channel}/{country}/{type}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: MarketUpdateParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfChannelMarket =
        // patch /v3/channels/{channel}/{country}/{type}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: MarketListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfListOfChannelMarket =
        // get /v3/channels/{channel}
        withRawResponse().list(params, requestOptions).parse()

    override fun addNumbers(
        params: MarketAddNumbersParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfChannelMarket =
        // post /v3/channels/{channel}/{country}/{type}/numbers
        withRawResponse().addNumbers(params, requestOptions).parse()

    override fun listNumbers(
        params: MarketListNumbersParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfMarketNumbers =
        // get /v3/channels/{channel}/{country}/{type}/numbers
        withRawResponse().listNumbers(params, requestOptions).parse()

    override fun replaceNumbers(
        params: MarketReplaceNumbersParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfChannelMarket =
        // patch /v3/channels/{channel}/{country}/{type}/numbers
        withRawResponse().replaceNumbers(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MarketService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MarketService.WithRawResponse =
            MarketServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ApiResponseOfChannelMarket> =
            jsonHandler<ApiResponseOfChannelMarket>(clientOptions.jsonMapper)

        override fun retrieve(
            params: MarketRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfChannelMarket> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("type", params.type().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        params._pathParam(0),
                        params._pathParam(1),
                        params._pathParam(2),
                    )
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

        private val updateHandler: Handler<ApiResponseOfChannelMarket> =
            jsonHandler<ApiResponseOfChannelMarket>(clientOptions.jsonMapper)

        override fun update(
            params: MarketUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfChannelMarket> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("type", params.type().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        params._pathParam(0),
                        params._pathParam(1),
                        params._pathParam(2),
                    )
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

        private val listHandler: Handler<ApiResponseOfListOfChannelMarket> =
            jsonHandler<ApiResponseOfListOfChannelMarket>(clientOptions.jsonMapper)

        override fun list(
            params: MarketListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfChannelMarket> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channel", params.channel().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", params._pathParam(0))
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

        private val addNumbersHandler: Handler<ApiResponseOfChannelMarket> =
            jsonHandler<ApiResponseOfChannelMarket>(clientOptions.jsonMapper)

        override fun addNumbers(
            params: MarketAddNumbersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfChannelMarket> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("type", params.type().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        params._pathParam(0),
                        params._pathParam(1),
                        params._pathParam(2),
                        "numbers",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addNumbersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listNumbersHandler: Handler<ApiResponseOfMarketNumbers> =
            jsonHandler<ApiResponseOfMarketNumbers>(clientOptions.jsonMapper)

        override fun listNumbers(
            params: MarketListNumbersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfMarketNumbers> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("type", params.type().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        params._pathParam(0),
                        params._pathParam(1),
                        params._pathParam(2),
                        "numbers",
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listNumbersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val replaceNumbersHandler: Handler<ApiResponseOfChannelMarket> =
            jsonHandler<ApiResponseOfChannelMarket>(clientOptions.jsonMapper)

        override fun replaceNumbers(
            params: MarketReplaceNumbersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfChannelMarket> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("type", params.type().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        params._pathParam(0),
                        params._pathParam(1),
                        params._pathParam(2),
                        "numbers",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { replaceNumbersHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
