// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
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
import dm.sent.models.channels.ApiResponseOfChannelsState
import dm.sent.models.channels.ChannelListParams
import dm.sent.services.blocking.channels.RcService
import dm.sent.services.blocking.channels.RcServiceImpl
import dm.sent.services.blocking.channels.SmsService
import dm.sent.services.blocking.channels.SmsServiceImpl
import dm.sent.services.blocking.channels.VoiceService
import dm.sent.services.blocking.channels.VoiceServiceImpl
import dm.sent.services.blocking.channels.WhatsappService
import dm.sent.services.blocking.channels.WhatsappServiceImpl
import java.util.function.Consumer

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
class ChannelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelService {

    private val withRawResponse: ChannelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sms: SmsService by lazy { SmsServiceImpl(clientOptions) }

    private val rcs: RcService by lazy { RcServiceImpl(clientOptions) }

    private val whatsapp: WhatsappService by lazy { WhatsappServiceImpl(clientOptions) }

    private val voice: VoiceService by lazy { VoiceServiceImpl(clientOptions) }

    override fun withRawResponse(): ChannelService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChannelService =
        ChannelServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
    override fun sms(): SmsService = sms

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
    override fun rcs(): RcService = rcs

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
    override fun whatsapp(): WhatsappService = whatsapp

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
    override fun voice(): VoiceService = voice

    override fun list(
        params: ChannelListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfChannelsState =
        // get /v3/channels
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val sms: SmsService.WithRawResponse by lazy {
            SmsServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val rcs: RcService.WithRawResponse by lazy {
            RcServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val whatsapp: WhatsappService.WithRawResponse by lazy {
            WhatsappServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val voice: VoiceService.WithRawResponse by lazy {
            VoiceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChannelService.WithRawResponse =
            ChannelServiceImpl.WithRawResponseImpl(
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
        override fun sms(): SmsService.WithRawResponse = sms

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
        override fun rcs(): RcService.WithRawResponse = rcs

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
        override fun whatsapp(): WhatsappService.WithRawResponse = whatsapp

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
        override fun voice(): VoiceService.WithRawResponse = voice

        private val listHandler: Handler<ApiResponseOfChannelsState> =
            jsonHandler<ApiResponseOfChannelsState>(clientOptions.jsonMapper)

        override fun list(
            params: ChannelListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfChannelsState> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels")
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
