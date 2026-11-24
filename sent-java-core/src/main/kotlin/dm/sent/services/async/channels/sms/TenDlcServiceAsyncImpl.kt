// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels.sms

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
import dm.sent.core.prepareAsync
import dm.sent.models.channels.markets.ApiResponseOfChannelMarket
import dm.sent.models.channels.sms.tendlc.TenDlcAddCampaignParams
import dm.sent.models.channels.sms.tendlc.TenDlcListCampaignsParams
import dm.sent.models.channels.sms.tendlc.TenDlcListCampaignsResponse
import dm.sent.models.channels.sms.tendlc.TenDlcUpdateCampaignParams
import java.util.concurrent.CompletableFuture
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
class TenDlcServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TenDlcServiceAsync {

    private val withRawResponse: TenDlcServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TenDlcServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TenDlcServiceAsync =
        TenDlcServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun addCampaign(
        params: TenDlcAddCampaignParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfChannelMarket> =
        // post /v3/channels/sms/US/TEN_DLC/campaigns
        withRawResponse().addCampaign(params, requestOptions).thenApply { it.parse() }

    override fun listCampaigns(
        params: TenDlcListCampaignsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TenDlcListCampaignsResponse> =
        // get /v3/channels/sms/US/TEN_DLC/campaigns
        withRawResponse().listCampaigns(params, requestOptions).thenApply { it.parse() }

    override fun updateCampaign(
        params: TenDlcUpdateCampaignParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfChannelMarket> =
        // patch /v3/channels/sms/US/TEN_DLC/campaigns/{campaignId}
        withRawResponse().updateCampaign(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TenDlcServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TenDlcServiceAsync.WithRawResponse =
            TenDlcServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val addCampaignHandler: Handler<ApiResponseOfChannelMarket> =
            jsonHandler<ApiResponseOfChannelMarket>(clientOptions.jsonMapper)

        override fun addCampaign(
            params: TenDlcAddCampaignParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "sms", "US", "TEN_DLC", "campaigns")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { addCampaignHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listCampaignsHandler: Handler<TenDlcListCampaignsResponse> =
            jsonHandler<TenDlcListCampaignsResponse>(clientOptions.jsonMapper)

        override fun listCampaigns(
            params: TenDlcListCampaignsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TenDlcListCampaignsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "sms", "US", "TEN_DLC", "campaigns")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listCampaignsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateCampaignHandler: Handler<ApiResponseOfChannelMarket> =
            jsonHandler<ApiResponseOfChannelMarket>(clientOptions.jsonMapper)

        override fun updateCampaign(
            params: TenDlcUpdateCampaignParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("campaignId", params.campaignId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        "sms",
                        "US",
                        "TEN_DLC",
                        "campaigns",
                        params._pathParam(0),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateCampaignHandler.handle(it) }
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
