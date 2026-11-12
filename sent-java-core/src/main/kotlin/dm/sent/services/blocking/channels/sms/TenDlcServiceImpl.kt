// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels.sms

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
import dm.sent.models.channels.sms.ApiResponseOfSmsMarket
import dm.sent.models.channels.sms.tendlc.ApiResponseOfSuppliedCompliance
import dm.sent.models.channels.sms.tendlc.TenDlcAddCampaignParams
import dm.sent.models.channels.sms.tendlc.TenDlcAddNumbersParams
import dm.sent.models.channels.sms.tendlc.TenDlcRetrieveComplianceParams
import dm.sent.models.channels.sms.tendlc.TenDlcUpdateCampaignParams
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
class TenDlcServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TenDlcService {

    private val withRawResponse: TenDlcService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TenDlcService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TenDlcService =
        TenDlcServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun addCampaign(
        params: TenDlcAddCampaignParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSmsMarket =
        // post /v3/channels/sms/compliances/US/TEN_DLC/campaigns
        withRawResponse().addCampaign(params, requestOptions).parse()

    override fun addNumbers(
        params: TenDlcAddNumbersParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSmsMarket =
        // post /v3/channels/sms/numbers/US/TEN_DLC
        withRawResponse().addNumbers(params, requestOptions).parse()

    override fun retrieveCompliance(
        params: TenDlcRetrieveComplianceParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSuppliedCompliance =
        // get /v3/channels/sms/compliances/US/TEN_DLC
        withRawResponse().retrieveCompliance(params, requestOptions).parse()

    override fun updateCampaign(
        params: TenDlcUpdateCampaignParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSmsMarket =
        // patch /v3/channels/sms/compliances/US/TEN_DLC/campaigns/{campaignId}
        withRawResponse().updateCampaign(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TenDlcService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TenDlcService.WithRawResponse =
            TenDlcServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val addCampaignHandler: Handler<ApiResponseOfSmsMarket> =
            jsonHandler<ApiResponseOfSmsMarket>(clientOptions.jsonMapper)

        override fun addCampaign(
            params: TenDlcAddCampaignParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSmsMarket> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        "sms",
                        "compliances",
                        "US",
                        "TEN_DLC",
                        "campaigns",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addCampaignHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val addNumbersHandler: Handler<ApiResponseOfSmsMarket> =
            jsonHandler<ApiResponseOfSmsMarket>(clientOptions.jsonMapper)

        override fun addNumbers(
            params: TenDlcAddNumbersParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSmsMarket> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "sms", "numbers", "US", "TEN_DLC")
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

        private val retrieveComplianceHandler: Handler<ApiResponseOfSuppliedCompliance> =
            jsonHandler<ApiResponseOfSuppliedCompliance>(clientOptions.jsonMapper)

        override fun retrieveCompliance(
            params: TenDlcRetrieveComplianceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSuppliedCompliance> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "sms", "compliances", "US", "TEN_DLC")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveComplianceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateCampaignHandler: Handler<ApiResponseOfSmsMarket> =
            jsonHandler<ApiResponseOfSmsMarket>(clientOptions.jsonMapper)

        override fun updateCampaign(
            params: TenDlcUpdateCampaignParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSmsMarket> {
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
                        "compliances",
                        "US",
                        "TEN_DLC",
                        "campaigns",
                        params._pathParam(0),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
