// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.core.ClientOptions
import dm.sent.services.blocking.channels.VoiceService
import dm.sent.services.blocking.channels.VoiceServiceImpl
import java.util.function.Consumer

class ChannelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelService {

    private val withRawResponse: ChannelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

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
     * them is the default line for calls placed from your app, and voice tokens are minted under
     * `POST /v3/channels/voice/tokens`. Read your voice numbers with `GET /v3/channels/voice` and
     * change one with `PATCH /v3/channels/voice/{number}`.
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

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelService.WithRawResponse {

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
         * app, and voice tokens are minted under `POST /v3/channels/voice/tokens`. Read your voice
         * numbers with `GET /v3/channels/voice` and change one with `PATCH
         * /v3/channels/voice/{number}`.
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
    }
}
