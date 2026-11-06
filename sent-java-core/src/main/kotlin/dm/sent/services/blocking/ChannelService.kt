// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.ApiResponseOfChannelsState
import dm.sent.models.channels.ChannelListParams
import dm.sent.services.blocking.channels.RcService
import dm.sent.services.blocking.channels.SmsService
import dm.sent.services.blocking.channels.VoiceService
import dm.sent.services.blocking.channels.WhatsappService
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
interface ChannelService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChannelService

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
    fun sms(): SmsService

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
    fun rcs(): RcService

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
    fun whatsapp(): WhatsappService

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
    fun voice(): VoiceService

    /**
     * Every market you send SMS in, your WhatsApp account, your RCS agent and the numbers you carry
     * phone calls on — with each one's status, and what each market has supplied.
     *
     * **Status lives on the channel, never on you or your brand.** An identity has no lifecycle;
     * what has one is the registration of a sender in a market and the approval of a channel. So a
     * customer live in one country and mid-registration in another reports exactly that, rather
     * than one flattened answer.
     *
     * `sms[n].compliance` carries what each market holds: `brand` and `campaign` for markets that
     * register with a compliance regime such as US TEN_DLC, and `documents` for markets that
     * pre-register an alphanumeric or similar sender. Absent means the market registers with nobody
     * and nothing has been supplied. `GET /v3/compliance/requirements` says what a market demands
     * of any new customer; this says what you gave it.
     *
     * Send `x-profile-id` with an organization key to read one of your profiles' channels.
     */
    fun list(): ApiResponseOfChannelsState = list(ChannelListParams.none())

    /** @see list */
    fun list(
        params: ChannelListParams = ChannelListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelsState

    /** @see list */
    fun list(params: ChannelListParams = ChannelListParams.none()): ApiResponseOfChannelsState =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ApiResponseOfChannelsState =
        list(ChannelListParams.none(), requestOptions)

    /** A view of [ChannelService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChannelService.WithRawResponse

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
        fun sms(): SmsService.WithRawResponse

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
        fun rcs(): RcService.WithRawResponse

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
        fun whatsapp(): WhatsappService.WithRawResponse

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
        fun voice(): VoiceService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/channels`, but is otherwise the same as
         * [ChannelService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ApiResponseOfChannelsState> = list(ChannelListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: ChannelListParams = ChannelListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelsState>

        /** @see list */
        @MustBeClosed
        fun list(
            params: ChannelListParams = ChannelListParams.none()
        ): HttpResponseFor<ApiResponseOfChannelsState> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfChannelsState> =
            list(ChannelListParams.none(), requestOptions)
    }
}
