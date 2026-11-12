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
import dm.sent.models.channels.sms.ApiResponseOfListOfSmsMarket
import dm.sent.models.channels.sms.ApiResponseOfSmsMarket
import dm.sent.models.channels.sms.SmsCreateParams
import dm.sent.models.channels.sms.SmsListParams
import dm.sent.models.channels.sms.SmsRetrieveParams
import dm.sent.models.channels.sms.SmsUpdateParams
import dm.sent.services.blocking.channels.sms.TenDlcService
import dm.sent.services.blocking.channels.sms.TenDlcServiceImpl
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
class SmsServiceImpl internal constructor(private val clientOptions: ClientOptions) : SmsService {

    private val withRawResponse: SmsService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val tenDlc: TenDlcService by lazy { TenDlcServiceImpl(clientOptions) }

    override fun withRawResponse(): SmsService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmsService =
        SmsServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * The senders you send from, one per channel.
     *
     * **SMS is a list of markets**, each keyed by `(country, number_type)` — a customer can hold
     * `us/10dlc` and `gb/alphanumeric` at once, so a market is addressed by the pair rather than by
     * country alone. **WhatsApp and RCS are single**: a customer has one business account and one
     * agent. **Voice is per number**: each number you hold can carry phone calls on its own (`POST
     * /v3/channels/voice`), each with the callback URL Sent asks what to do with its calls, one of
     * them is the default line for calls placed from your app, and voice tokens are minted with
     * `POST /v3/voice/tokens`. Read your voice numbers with `GET /v3/channels/voice` and change one
     * with `PATCH /v3/channels/voice/{number}`.
     *
     * ## Compliance lives on the market
     *
     * Adding a market records everything that market registers with, in its `compliance` object.
     * Only **US `TEN_DLC`** registers with a regime — The Campaign Registry — and it is the only
     * market whose compliance carries `brand` and `campaign`. Everywhere else compliance is
     * documents, and many markets ask for none at all.
     *
     * `GET` and `PATCH` on a market return and accept the same shape, so what comes back can be
     * sent back: an omitted key is left alone, and a key reported in `requirements` is the path
     * into the body that clears it.
     *
     * Call `GET /v3/compliance/requirements` first — it answers what a market demands before you
     * hold it, with a body you can fill in and post.
     */
    override fun tenDlc(): TenDlcService = tenDlc

    override fun create(
        params: SmsCreateParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSmsMarket =
        // post /v3/channels/sms
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: SmsRetrieveParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSmsMarket =
        // get /v3/channels/sms/{country}/{type}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: SmsUpdateParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfSmsMarket =
        // patch /v3/channels/sms/{country}/{type}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: SmsListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfListOfSmsMarket =
        // get /v3/channels/sms
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SmsService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val tenDlc: TenDlcService.WithRawResponse by lazy {
            TenDlcServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SmsService.WithRawResponse =
            SmsServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * The senders you send from, one per channel.
         *
         * **SMS is a list of markets**, each keyed by `(country, number_type)` — a customer can
         * hold `us/10dlc` and `gb/alphanumeric` at once, so a market is addressed by the pair
         * rather than by country alone. **WhatsApp and RCS are single**: a customer has one
         * business account and one agent. **Voice is per number**: each number you hold can carry
         * phone calls on its own (`POST /v3/channels/voice`), each with the callback URL Sent asks
         * what to do with its calls, one of them is the default line for calls placed from your
         * app, and voice tokens are minted with `POST /v3/voice/tokens`. Read your voice numbers
         * with `GET /v3/channels/voice` and change one with `PATCH /v3/channels/voice/{number}`.
         *
         * ## Compliance lives on the market
         *
         * Adding a market records everything that market registers with, in its `compliance`
         * object. Only **US `TEN_DLC`** registers with a regime — The Campaign Registry — and it is
         * the only market whose compliance carries `brand` and `campaign`. Everywhere else
         * compliance is documents, and many markets ask for none at all.
         *
         * `GET` and `PATCH` on a market return and accept the same shape, so what comes back can be
         * sent back: an omitted key is left alone, and a key reported in `requirements` is the path
         * into the body that clears it.
         *
         * Call `GET /v3/compliance/requirements` first — it answers what a market demands before
         * you hold it, with a body you can fill in and post.
         */
        override fun tenDlc(): TenDlcService.WithRawResponse = tenDlc

        private val createHandler: Handler<ApiResponseOfSmsMarket> =
            jsonHandler<ApiResponseOfSmsMarket>(clientOptions.jsonMapper)

        override fun create(
            params: SmsCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSmsMarket> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "sms")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<ApiResponseOfSmsMarket> =
            jsonHandler<ApiResponseOfSmsMarket>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SmsRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSmsMarket> {
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
                        "sms",
                        params._pathParam(0),
                        params._pathParam(1),
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

        private val updateHandler: Handler<ApiResponseOfSmsMarket> =
            jsonHandler<ApiResponseOfSmsMarket>(clientOptions.jsonMapper)

        override fun update(
            params: SmsUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfSmsMarket> {
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
                        "sms",
                        params._pathParam(0),
                        params._pathParam(1),
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

        private val listHandler: Handler<ApiResponseOfListOfSmsMarket> =
            jsonHandler<ApiResponseOfListOfSmsMarket>(clientOptions.jsonMapper)

        override fun list(
            params: SmsListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfSmsMarket> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "sms")
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
    }
}
