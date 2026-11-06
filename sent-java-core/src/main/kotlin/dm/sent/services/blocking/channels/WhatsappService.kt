// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.whatsapp.ApiResponseOfWhatsappChannel
import dm.sent.models.channels.whatsapp.WhatsappCreateParams
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
interface WhatsappService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): WhatsappService

    /**
     * Connects a WhatsApp Business Account shared with us through a Multi-Partner Solution to the
     * calling sender profile. Send `x-profile-id` for the profile the account belongs to.
     *
     * **Two fields, because everything else is derived.** `waba_id` says which of your
     * organization's shared accounts this is — you hold one per client, and nothing else can say
     * which. `phone_number_id` names the account's number, which is what assigns it to the profile
     * as the number it sends from.
     *
     * The solution the account arrived through, the client business portfolio that owns it, the
     * access token and its expiry are all resolved from your organization. They are not accepted
     * here: the first two are Meta's answer about provenance, and the token is minted per client
     * business and rotates roughly every sixty days, so a value you sent would be stale before it
     * was useful.
     *
     * `phone_number_id` is optional. Omit it to connect the account now and settle the number later
     * — the channel reads as `ACTION_NEEDED` with `reason_code` `CHANNEL_007`, and the profile's
     * WhatsApp messages fail until a number is named. They do not fall back to your organization's
     * account. Call this endpoint again with `phone_number_id` to name one.
     *
     * The same resolution runs behind `channels.whatsapp` on `POST /v3/sender-profiles`, so
     * connecting at create and connecting afterwards fill the same fields.
     *
     * Returns **the account**, not every channel you have — adding one cannot change a market or an
     * RCS agent, and `GET /v3/channels` is the whole picture. Giving an account up is not
     * self-service: ask support, because deregistering a number lands in your own Meta business.
     */
    fun create(): ApiResponseOfWhatsappChannel = create(WhatsappCreateParams.none())

    /** @see create */
    fun create(
        params: WhatsappCreateParams = WhatsappCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfWhatsappChannel

    /** @see create */
    fun create(
        params: WhatsappCreateParams = WhatsappCreateParams.none()
    ): ApiResponseOfWhatsappChannel = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): ApiResponseOfWhatsappChannel =
        create(WhatsappCreateParams.none(), requestOptions)

    /** A view of [WhatsappService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): WhatsappService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/channels/whatsapp`, but is otherwise the same
         * as [WhatsappService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<ApiResponseOfWhatsappChannel> =
            create(WhatsappCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: WhatsappCreateParams = WhatsappCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfWhatsappChannel>

        /** @see create */
        @MustBeClosed
        fun create(
            params: WhatsappCreateParams = WhatsappCreateParams.none()
        ): HttpResponseFor<ApiResponseOfWhatsappChannel> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfWhatsappChannel> =
            create(WhatsappCreateParams.none(), requestOptions)
    }
}
