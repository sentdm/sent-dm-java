// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.rcs.ApiResponseOfRcsAgent
import dm.sent.models.channels.rcs.RcCreateParams
import java.util.concurrent.CompletableFuture
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
interface RcServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RcServiceAsync

    /**
     * Asks for an RCS agent and records the order form the carriers vet it against. Always `202`:
     * an agent is approved by the carriers, not by this call, and nothing here can make that happen
     * sooner.
     *
     * ## What it asks for
     *
     * The RCS Agent Order Form — the same one our team fills in on your behalf today, so nothing
     * has to be collected from you twice. **All fields are required** and must be submitted
     * together so the carrier review has everything it needs. The only exception is
     * `opt_in_screenshot_url`.
     *
     * **Agent identity:** `display_name`, `description`, `agent_use_case` (must be one of the
     * accepted use cases; the error names the set), `brand_color` (six-digit hex, `#RRGGBB`).
     *
     * **Brand identity:** `brand_name` — the brand this agent presents. Not taken from
     * `compliance.brand`: a business may present a different brand on RCS than the one its 10DLC
     * registration is filed against, and the carriers vet this one. `privacy_policy_url`,
     * `terms_and_conditions_url`, `website_url`, `logo_url`, and `banner_url` must be absolute
     * `http(s)` URLs that the carriers can fetch without authentication. The form specifies 224×224
     * px and 50 KB for the logo and 1440×448 px and 200 KB for the banner; these cannot be checked
     * without the image bytes.
     *
     * **Contact details:** `brand_phone_number`, `customer_support_phone_number`, `brand_email`,
     * `customer_support_email`, `contact_name_and_title`.
     *
     * **Company:** `company_ein`, `entity_type`, `official_address` (street, city, state,
     * postal_code, country), `brief_company_description`.
     *
     * **Consent and messages:** `opt_in_process_description`, `start_message`, `help_message`,
     * `stop_message`, `sample_messages` (at least one example message).
     *
     * **Optional:** `opt_in_screenshot_url` (validated as an http(s) URL if supplied).
     *
     * Anything supplied is checked against accepted values rather than passed through: a value the
     * provider rejects would otherwise surface days later, to somebody who cannot fix it without
     * asking you.
     *
     * **A customer has one agent.** Asking again while you have one is `409`.
     *
     * ## What comes back, and what does not
     *
     * Returns **the agent** — the form as stored, plus `id` and `status`. Not your other channels,
     * which this call cannot have changed.
     *
     * `status` is `PROVISIONING` until the agent is handed to the carriers and approved. **`GET
     * /v3/channels` reports `rcs: null` until then** — a channel row is what routing reads to
     * decide you are sendable, and writing one for an unapproved agent would claim a channel that
     * cannot carry traffic.
     *
     * Send `x-profile-id` with an organization key to ask for one of your profiles' agents.
     */
    fun create(): CompletableFuture<ApiResponseOfRcsAgent> = create(RcCreateParams.none())

    /** @see create */
    fun create(
        params: RcCreateParams = RcCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfRcsAgent>

    /** @see create */
    fun create(
        params: RcCreateParams = RcCreateParams.none()
    ): CompletableFuture<ApiResponseOfRcsAgent> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfRcsAgent> =
        create(RcCreateParams.none(), requestOptions)

    /** A view of [RcServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RcServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/channels/rcs`, but is otherwise the same as
         * [RcServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseOfRcsAgent>> =
            create(RcCreateParams.none())

        /** @see create */
        fun create(
            params: RcCreateParams = RcCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfRcsAgent>>

        /** @see create */
        fun create(
            params: RcCreateParams = RcCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfRcsAgent>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfRcsAgent>> =
            create(RcCreateParams.none(), requestOptions)
    }
}
