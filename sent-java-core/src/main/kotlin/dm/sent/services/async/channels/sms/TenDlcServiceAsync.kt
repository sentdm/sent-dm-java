// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels.sms

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.markets.ApiResponseOfChannelMarket
import dm.sent.models.channels.sms.tendlc.TenDlcAddCampaignParams
import dm.sent.models.channels.sms.tendlc.TenDlcListCampaignsParams
import dm.sent.models.channels.sms.tendlc.TenDlcListCampaignsResponse
import dm.sent.models.channels.sms.tendlc.TenDlcUpdateCampaignParams
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
interface TenDlcServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TenDlcServiceAsync

    /**
     * Registers **a new campaign** on the US `TEN_DLC` market you already hold — the one market
     * that registers campaigns. Use it when you want numbers for a different use case than the
     * market's existing campaign covers. The campaign is filed under the brand the market files
     * under — your organization's when you inherit its identity.
     *
     * ## What to send
     *
     * The new campaign's fields, at the top level of the body: use cases, consent narrative,
     * volume, sample messages and keywords, under their keys (`description`, `message_flow`,
     * `use_cases`, `volume`, …). It has to be complete. A rejected field is keyed by its name
     * (`description`). `id` and `inherit` are ignored, so an entry of `campaigns` can be sent as
     * read.
     *
     * The identity is the market's and is not sent here. A market whose identity has no
     * registration yet, or one not yet submitted for review, is `400`.
     *
     * ## What happens
     *
     * The campaign is recorded and goes for review; it is not filed with The Campaign Registry by
     * this call. **It comes without numbers**: send its `id` from `compliance.campaigns` to `POST
     * /v3/channels/sms/{country}/{type}/numbers` to give it some. **The campaign you already have,
     * and its numbers, are not touched** — including a campaign you run on from your organization.
     *
     * **Each call files a new campaign**, which is charged when it is submitted. Send an
     * `Idempotency-Key` so a retried request does not file a second one.
     *
     * To change a campaign, use `PATCH /v3/channels/sms/US/TEN_DLC/campaigns/{campaignId}`; `PATCH
     * /v3/channels/sms/US/TEN_DLC` changes the brand and documents only, and refuses a campaign or
     * numbers (`400`).
     *
     * Returns **the market**, in the shape `GET /v3/channels/sms/US/TEN_DLC` returns, with `202`.
     */
    fun addCampaign(
        params: TenDlcAddCampaignParams
    ): CompletableFuture<ApiResponseOfChannelMarket> = addCampaign(params, RequestOptions.none())

    /** @see addCampaign */
    fun addCampaign(
        params: TenDlcAddCampaignParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfChannelMarket>

    /**
     * Every campaign your US `TEN_DLC` market registers, oldest first, each with its `id`, where it
     * stands and `inherit` (`true` for your organization's) beside its fields — the list `GET
     * /v3/channels/sms/US/TEN_DLC` reports under `compliance.campaigns`. Add one with `POST` on
     * this path, and change one of your own with `PATCH
     * /v3/channels/sms/US/TEN_DLC/campaigns/{id}`.
     *
     * Each campaign has a `status` of its own, so a market on several says which is approved:
     * `ACTIVE` once the carriers have elected it, `PENDING_REVIEW` until then, `ACTION_NEEDED` when
     * it came back for correction, `DECLINED` when the carriers refused it, `INACTIVE` once it has
     * ended. Why the market is held up is the market's own `reason`, which names the campaign
     * concerned. `status` is read-only and ignored when the entry is sent back.
     *
     * A customer without a US `TEN_DLC` market is `404`.
     */
    fun listCampaigns(): CompletableFuture<TenDlcListCampaignsResponse> =
        listCampaigns(TenDlcListCampaignsParams.none())

    /** @see listCampaigns */
    fun listCampaigns(
        params: TenDlcListCampaignsParams = TenDlcListCampaignsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TenDlcListCampaignsResponse>

    /** @see listCampaigns */
    fun listCampaigns(
        params: TenDlcListCampaignsParams = TenDlcListCampaignsParams.none()
    ): CompletableFuture<TenDlcListCampaignsResponse> = listCampaigns(params, RequestOptions.none())

    /** @see listCampaigns */
    fun listCampaigns(
        requestOptions: RequestOptions
    ): CompletableFuture<TenDlcListCampaignsResponse> =
        listCampaigns(TenDlcListCampaignsParams.none(), requestOptions)

    /**
     * Changes **one campaign of your own** on the US `TEN_DLC` market, named by its `id` in the
     * market's `compliance.campaigns`.
     *
     * ## What to send
     *
     * The fields to change, at the top level of the body, under their keys (`description`,
     * `message_flow`, `use_cases`, `help_message`, …). A field you leave out keeps its value, and a
     * rejected one is keyed by its name. `id` and `"inherit": false` are ignored, so an entry of
     * `campaigns` can be sent as read; `"inherit": true` is `400`, because this call changes a
     * campaign's fields, not whose campaign you run on. The campaign only: add numbers with `POST
     * /v3/channels/sms/US/TEN_DLC/numbers`, and change the brand or documents with `PATCH
     * /v3/channels/sms/US/TEN_DLC`.
     *
     * ## When it can be changed
     *
     * Until it is filed with The Campaign Registry, and again when we ask you to correct it. That
     * correction sends it back for review. A filed campaign is otherwise `409`, and so is a change
     * between low and high volume once it is registered. A campaign you run on from your
     * organization is `409` too: it is the organization's to change. So is one out of service:
     * expired, deactivated or released.
     *
     * Returns **the market**, in the shape `GET /v3/channels/sms/US/TEN_DLC` returns.
     */
    fun updateCampaign(campaignId: String): CompletableFuture<ApiResponseOfChannelMarket> =
        updateCampaign(campaignId, TenDlcUpdateCampaignParams.none())

    /** @see updateCampaign */
    fun updateCampaign(
        campaignId: String,
        params: TenDlcUpdateCampaignParams = TenDlcUpdateCampaignParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfChannelMarket> =
        updateCampaign(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see updateCampaign */
    fun updateCampaign(
        campaignId: String,
        params: TenDlcUpdateCampaignParams = TenDlcUpdateCampaignParams.none(),
    ): CompletableFuture<ApiResponseOfChannelMarket> =
        updateCampaign(campaignId, params, RequestOptions.none())

    /** @see updateCampaign */
    fun updateCampaign(
        params: TenDlcUpdateCampaignParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfChannelMarket>

    /** @see updateCampaign */
    fun updateCampaign(
        params: TenDlcUpdateCampaignParams
    ): CompletableFuture<ApiResponseOfChannelMarket> = updateCampaign(params, RequestOptions.none())

    /** @see updateCampaign */
    fun updateCampaign(
        campaignId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfChannelMarket> =
        updateCampaign(campaignId, TenDlcUpdateCampaignParams.none(), requestOptions)

    /**
     * A view of [TenDlcServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TenDlcServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/channels/sms/US/TEN_DLC/campaigns`, but is
         * otherwise the same as [TenDlcServiceAsync.addCampaign].
         */
        fun addCampaign(
            params: TenDlcAddCampaignParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> =
            addCampaign(params, RequestOptions.none())

        /** @see addCampaign */
        fun addCampaign(
            params: TenDlcAddCampaignParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>>

        /**
         * Returns a raw HTTP response for `get /v3/channels/sms/US/TEN_DLC/campaigns`, but is
         * otherwise the same as [TenDlcServiceAsync.listCampaigns].
         */
        fun listCampaigns(): CompletableFuture<HttpResponseFor<TenDlcListCampaignsResponse>> =
            listCampaigns(TenDlcListCampaignsParams.none())

        /** @see listCampaigns */
        fun listCampaigns(
            params: TenDlcListCampaignsParams = TenDlcListCampaignsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TenDlcListCampaignsResponse>>

        /** @see listCampaigns */
        fun listCampaigns(
            params: TenDlcListCampaignsParams = TenDlcListCampaignsParams.none()
        ): CompletableFuture<HttpResponseFor<TenDlcListCampaignsResponse>> =
            listCampaigns(params, RequestOptions.none())

        /** @see listCampaigns */
        fun listCampaigns(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<TenDlcListCampaignsResponse>> =
            listCampaigns(TenDlcListCampaignsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch
         * /v3/channels/sms/US/TEN_DLC/campaigns/{campaignId}`, but is otherwise the same as
         * [TenDlcServiceAsync.updateCampaign].
         */
        fun updateCampaign(
            campaignId: String
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> =
            updateCampaign(campaignId, TenDlcUpdateCampaignParams.none())

        /** @see updateCampaign */
        fun updateCampaign(
            campaignId: String,
            params: TenDlcUpdateCampaignParams = TenDlcUpdateCampaignParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> =
            updateCampaign(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see updateCampaign */
        fun updateCampaign(
            campaignId: String,
            params: TenDlcUpdateCampaignParams = TenDlcUpdateCampaignParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> =
            updateCampaign(campaignId, params, RequestOptions.none())

        /** @see updateCampaign */
        fun updateCampaign(
            params: TenDlcUpdateCampaignParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>>

        /** @see updateCampaign */
        fun updateCampaign(
            params: TenDlcUpdateCampaignParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> =
            updateCampaign(params, RequestOptions.none())

        /** @see updateCampaign */
        fun updateCampaign(
            campaignId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfChannelMarket>> =
            updateCampaign(campaignId, TenDlcUpdateCampaignParams.none(), requestOptions)
    }
}
