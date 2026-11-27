// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
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
interface MarketService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketService

    /**
     * Reads one market you send in — its sender, where that sender stands, and everything its
     * compliance holds.
     *
     * ## What `compliance` carries
     *
     * A market that registers with a compliance regime reports `brand` — the identity the
     * registration is filed against — and `campaign`, the programme filed against it. Each carries
     * `inherit`, saying whether it is yours or your organization's.
     *
     * `compliance.brand.vetting` is the brand's external vetting at The Campaign Registry,
     * read-only: `score` (0-100, the figure US carriers set 10DLC throughput by), `status`
     * (`PENDING`, `UNSCORE`, `ACTIVE`, `FAILED` or `EXPIRED`; carriers read the score of an
     * `ACTIVE` vet only), `vetted_at` and `expires_at`. It is `null` while no vetting record is
     * held for the brand, and `score` is `null` for a vet that has none yet. A profile on your
     * organization's brand reads your organization's vetting.
     *
     * A market that registers with nobody has neither, so **both keys are absent** rather than
     * null: absent says this market does not ask, where null would say it asks and you supplied
     * nothing. It reports `documents` instead.
     *
     * `GET /v3/compliance/requirements` says what a market demands of any new customer; this says
     * what you gave it.
     *
     * ## Writing it back
     *
     * **`PATCH` this same path**, with the `compliance` object from this response:
     * ```json
     * { "compliance": { "brand": { "tax_id": "12-3456789" } } }
     * ```
     *
     * Nothing else to learn — what comes back can be sent back, an omitted key is left alone. There
     * is no sub-resource for either half: both are singletons of the market, so both are written
     * here.
     *
     * `GET /v3/compliance/requirements` says what a market demands of anybody; this says what you
     * gave it.
     *
     * Send `x-profile-id` with an organization key to read one of your profiles' markets.
     */
    fun retrieve(type: String, params: MarketRetrieveParams): ApiResponseOfChannelMarket =
        retrieve(type, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        type: String,
        params: MarketRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket = retrieve(params.toBuilder().type(type).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: MarketRetrieveParams): ApiResponseOfChannelMarket =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: MarketRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket

    /**
     * Supplies the market's identity and documents, and answers with the market as stored — the
     * same shape `GET` on this path returns.
     *
     * |To change                              |Send                                                                                                    |
     * |---------------------------------------|--------------------------------------------------------------------------------------------------------|
     * |a `brand` value (US `TEN_DLC`)         |`compliance.brand`, as below                                                                            |
     * |a registration sent back for correction|`compliance.brand` — the identity is accepted even once filed, and the registration goes back for review|
     * |a document, in any market              |a multipart file named after the document's key                                                         |
     * |a campaign                             |`PATCH /v3/channels/sms/US/TEN_DLC/campaigns/{id}` — `compliance.campaign` here is `400`                |
     * |the numbers                            |`POST /v3/channels/{channel}/{country}/{type}/numbers` — `numbers` here is `400`                        |
     *
     * ## Partial, at every level
     *
     * **An omitted key is left alone. An explicit `null` clears it.** Those are different requests,
     * so `{}` changes nothing and is refused rather than silently accepted, and correcting one
     * field does not blank the others.
     *
     * ```json
     * { "compliance": { "brand": { "contact_phone": "+12125550123" } } }
     * ```
     *
     * |Body                          |Effect                                                      |
     * |------------------------------|------------------------------------------------------------|
     * |`"brand": { … }`              |supplies or corrects the identity, and takes one of your own|
     * |`"brand": { "inherit": true }`|runs on your organization's, giving up your own             |
     * |`"brand": null`               |the same thing, said the short way                          |
     * |key omitted                   |left exactly as it is                                       |
     *
     * The brand read on this path, its `id` and `vetting` included, can be sent back unchanged:
     * both are read-only and ignored.
     *
     * ## Every other market
     *
     * Markets that register with no regime have no brand, so `compliance` is `400` there. Their
     * compliance is documents, sent here as multipart.
     *
     * ## Documents
     *
     * Send `multipart/form-data` with **each file named after the compliance key it satisfies** —
     * the key `GET /v3/channels/{channel}/{country}/compliance` lists. A file that matches no
     * document the market asks for is `400` naming the keys that would, and a file the upload rules
     * refuse (empty, too large, an unsupported type) is `422`. `compliance` may ride in the same
     * form as a text part holding its JSON.
     *
     * ## What it will refuse
     *
     * **A filed identity is `409`.** Once the registration has gone to The Campaign Registry they
     * hold a copy, and a local change would diverge from it silently. The exception is a
     * registration sent back for correction: the identity is accepted, and the registration goes
     * back for review. Refiling it with The Campaign Registry stays with Sent.
     *
     * Nothing is submitted to a regime here. Send `x-profile-id` with an organization key to write
     * one of your profiles' markets.
     */
    fun update(type: String, params: MarketUpdateParams): ApiResponseOfChannelMarket =
        update(type, params, RequestOptions.none())

    /** @see update */
    fun update(
        type: String,
        params: MarketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket = update(params.toBuilder().type(type).build(), requestOptions)

    /** @see update */
    fun update(params: MarketUpdateParams): ApiResponseOfChannelMarket =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: MarketUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket

    /**
     * Every market you send SMS in, each with its sender, where that sender stands, and what its
     * compliance holds.
     *
     * The same entries `GET /v3/channels` reports under `sms`, and the same shape `GET
     * /v3/channels/sms/{country}/{type}` returns for one of them — so a list, a member read and the
     * all-channels read cannot describe a market differently.
     *
     * Send `x-profile-id` with an organization key to list one of your profiles' markets.
     */
    fun list(channel: String): ApiResponseOfListOfChannelMarket =
        list(channel, MarketListParams.none())

    /** @see list */
    fun list(
        channel: String,
        params: MarketListParams = MarketListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfChannelMarket =
        list(params.toBuilder().channel(channel).build(), requestOptions)

    /** @see list */
    fun list(
        channel: String,
        params: MarketListParams = MarketListParams.none(),
    ): ApiResponseOfListOfChannelMarket = list(channel, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: MarketListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfChannelMarket

    /** @see list */
    fun list(params: MarketListParams): ApiResponseOfListOfChannelMarket =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(channel: String, requestOptions: RequestOptions): ApiResponseOfListOfChannelMarket =
        list(channel, MarketListParams.none(), requestOptions)

    /**
     * Adds numbers to a market you hold. They are **added** to what it already asks for, never
     * replacing it — with one exception: a US `TEN_DLC` campaign opened without `numbers` asks for
     * one number in any area code by default, and while it holds no number yet, the first numbers
     * added replace that default. Once it holds one, they are added beside it.
     *
     * ## Where they go
     * - **SMS US `TEN_DLC`**: to **one campaign of your own**, named by `campaign_id` — the `id` of
     *   an entry in the market's `compliance.campaigns` (`GET /v3/channels/sms/US/TEN_DLC`).
     *   Required: left out it is `400` naming your campaigns in service. One you inherit from your
     *   organization is `400`: its numbers are the organization's. One out of service — expired,
     *   deactivated or released — is `409`. A campaign the carriers have not approved yet gets its
     *   numbers when they do; an approved one gets them now. With everything it asks for, a
     *   campaign holds at most 49 numbers, counting one for each sender profile inheriting it.
     * - **`LOCAL`**: to the market, claimed from inventory now; what inventory cannot cover stays
     *   pending. No `campaign_id`. A market holds at most 49 numbers.
     * - **Any other sender type** takes no numbers: `400`.
     *
     * ## What to send
     *
     * `numbers` — the list `POST /v3/channels/sms` takes, one entry per area code — and, on US
     * `TEN_DLC`, `campaign_id`, required.
     *
     * Until a number is assigned it reads as `PROVISIONING` in the market's `numbers`, with the
     * area code it was asked for. Returns **the market**, in the shape `GET
     * /v3/channels/sms/{country}/{type}` returns, with `202`.
     */
    fun addNumbers(type: String, params: MarketAddNumbersParams): ApiResponseOfChannelMarket =
        addNumbers(type, params, RequestOptions.none())

    /** @see addNumbers */
    fun addNumbers(
        type: String,
        params: MarketAddNumbersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket =
        addNumbers(params.toBuilder().type(type).build(), requestOptions)

    /** @see addNumbers */
    fun addNumbers(params: MarketAddNumbersParams): ApiResponseOfChannelMarket =
        addNumbers(params, RequestOptions.none())

    /** @see addNumbers */
    fun addNumbers(
        params: MarketAddNumbersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket

    /**
     * Every number you hold in one market (country and sender type): `ACTIVE` once it can send,
     * `PROVISIONING` while it is still to be assigned (it then has no `sender_value` yet),
     * `INACTIVE` once it could send and no longer can. US `TEN_DLC` numbers name their
     * `campaign_id`, and `?campaign_id=` keeps one campaign's.
     *
     * A market you do not hold is `404`. Add numbers with `POST` on the same path.
     */
    fun listNumbers(type: String, params: MarketListNumbersParams): ApiResponseOfMarketNumbers =
        listNumbers(type, params, RequestOptions.none())

    /** @see listNumbers */
    fun listNumbers(
        type: String,
        params: MarketListNumbersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfMarketNumbers =
        listNumbers(params.toBuilder().type(type).build(), requestOptions)

    /** @see listNumbers */
    fun listNumbers(params: MarketListNumbersParams): ApiResponseOfMarketNumbers =
        listNumbers(params, RequestOptions.none())

    /** @see listNumbers */
    fun listNumbers(
        params: MarketListNumbersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfMarketNumbers

    /**
     * Replaces the numbers a market you hold asks for — their area codes and counts — with the list
     * you send. To add to them instead, use `POST` on this path.
     *
     * ## Whose numbers
     * - **SMS US `TEN_DLC`**: **one campaign of your own**, named by `campaign_id` — the `id` of an
     *   entry in the market's `compliance.campaigns`. Required. So a campaign sent back for
     *   correction can change its area codes without being recreated. One you inherit from your
     *   organization is `400`; one out of service is `409`. With everything it asks for, a campaign
     *   holds at most 49 numbers, counting one for each sender profile inheriting it.
     * - **`LOCAL`**: the market's own, claimed from inventory now; what inventory cannot cover
     *   stays pending. No `campaign_id`.
     * - **Any other sender type** takes no numbers: `400`.
     *
     * ## What to send
     *
     * `numbers` — the list `POST /v3/channels/sms` takes, one entry per area code, an entry without
     * `area_code` meaning any — and, on US `TEN_DLC`, `campaign_id`.
     *
     * **Numbers already assigned are kept.** Nothing is released here, so a list that no longer
     * covers a number already held is `400`, naming how many it leaves out. Lowering a count
     * nothing has filled yet is fine.
     *
     * Until a number is assigned it reads as `PROVISIONING` in the market's `numbers`, with the
     * area code it was asked for. Returns **the market**, in the shape `GET
     * /v3/channels/sms/{country}/{type}` returns.
     */
    fun replaceNumbers(
        type: String,
        params: MarketReplaceNumbersParams,
    ): ApiResponseOfChannelMarket = replaceNumbers(type, params, RequestOptions.none())

    /** @see replaceNumbers */
    fun replaceNumbers(
        type: String,
        params: MarketReplaceNumbersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket =
        replaceNumbers(params.toBuilder().type(type).build(), requestOptions)

    /** @see replaceNumbers */
    fun replaceNumbers(params: MarketReplaceNumbersParams): ApiResponseOfChannelMarket =
        replaceNumbers(params, RequestOptions.none())

    /** @see replaceNumbers */
    fun replaceNumbers(
        params: MarketReplaceNumbersParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfChannelMarket

    /** A view of [MarketService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MarketService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v3/channels/{channel}/{country}/{type}`, but is
         * otherwise the same as [MarketService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            type: String,
            params: MarketRetrieveParams,
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            retrieve(type, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            type: String,
            params: MarketRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            retrieve(params.toBuilder().type(type).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: MarketRetrieveParams): HttpResponseFor<ApiResponseOfChannelMarket> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: MarketRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket>

        /**
         * Returns a raw HTTP response for `patch /v3/channels/{channel}/{country}/{type}`, but is
         * otherwise the same as [MarketService.update].
         */
        @MustBeClosed
        fun update(
            type: String,
            params: MarketUpdateParams,
        ): HttpResponseFor<ApiResponseOfChannelMarket> = update(type, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            type: String,
            params: MarketUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            update(params.toBuilder().type(type).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: MarketUpdateParams): HttpResponseFor<ApiResponseOfChannelMarket> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: MarketUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket>

        /**
         * Returns a raw HTTP response for `get /v3/channels/{channel}`, but is otherwise the same
         * as [MarketService.list].
         */
        @MustBeClosed
        fun list(channel: String): HttpResponseFor<ApiResponseOfListOfChannelMarket> =
            list(channel, MarketListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            channel: String,
            params: MarketListParams = MarketListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfChannelMarket> =
            list(params.toBuilder().channel(channel).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            channel: String,
            params: MarketListParams = MarketListParams.none(),
        ): HttpResponseFor<ApiResponseOfListOfChannelMarket> =
            list(channel, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: MarketListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfChannelMarket>

        /** @see list */
        @MustBeClosed
        fun list(params: MarketListParams): HttpResponseFor<ApiResponseOfListOfChannelMarket> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            channel: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfChannelMarket> =
            list(channel, MarketListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/channels/{channel}/{country}/{type}/numbers`,
         * but is otherwise the same as [MarketService.addNumbers].
         */
        @MustBeClosed
        fun addNumbers(
            type: String,
            params: MarketAddNumbersParams,
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            addNumbers(type, params, RequestOptions.none())

        /** @see addNumbers */
        @MustBeClosed
        fun addNumbers(
            type: String,
            params: MarketAddNumbersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            addNumbers(params.toBuilder().type(type).build(), requestOptions)

        /** @see addNumbers */
        @MustBeClosed
        fun addNumbers(
            params: MarketAddNumbersParams
        ): HttpResponseFor<ApiResponseOfChannelMarket> = addNumbers(params, RequestOptions.none())

        /** @see addNumbers */
        @MustBeClosed
        fun addNumbers(
            params: MarketAddNumbersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket>

        /**
         * Returns a raw HTTP response for `get /v3/channels/{channel}/{country}/{type}/numbers`,
         * but is otherwise the same as [MarketService.listNumbers].
         */
        @MustBeClosed
        fun listNumbers(
            type: String,
            params: MarketListNumbersParams,
        ): HttpResponseFor<ApiResponseOfMarketNumbers> =
            listNumbers(type, params, RequestOptions.none())

        /** @see listNumbers */
        @MustBeClosed
        fun listNumbers(
            type: String,
            params: MarketListNumbersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfMarketNumbers> =
            listNumbers(params.toBuilder().type(type).build(), requestOptions)

        /** @see listNumbers */
        @MustBeClosed
        fun listNumbers(
            params: MarketListNumbersParams
        ): HttpResponseFor<ApiResponseOfMarketNumbers> = listNumbers(params, RequestOptions.none())

        /** @see listNumbers */
        @MustBeClosed
        fun listNumbers(
            params: MarketListNumbersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfMarketNumbers>

        /**
         * Returns a raw HTTP response for `patch /v3/channels/{channel}/{country}/{type}/numbers`,
         * but is otherwise the same as [MarketService.replaceNumbers].
         */
        @MustBeClosed
        fun replaceNumbers(
            type: String,
            params: MarketReplaceNumbersParams,
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            replaceNumbers(type, params, RequestOptions.none())

        /** @see replaceNumbers */
        @MustBeClosed
        fun replaceNumbers(
            type: String,
            params: MarketReplaceNumbersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            replaceNumbers(params.toBuilder().type(type).build(), requestOptions)

        /** @see replaceNumbers */
        @MustBeClosed
        fun replaceNumbers(
            params: MarketReplaceNumbersParams
        ): HttpResponseFor<ApiResponseOfChannelMarket> =
            replaceNumbers(params, RequestOptions.none())

        /** @see replaceNumbers */
        @MustBeClosed
        fun replaceNumbers(
            params: MarketReplaceNumbersParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfChannelMarket>
    }
}
