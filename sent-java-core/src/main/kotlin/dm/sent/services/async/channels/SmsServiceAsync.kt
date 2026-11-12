// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.sms.ApiResponseOfListOfSmsMarket
import dm.sent.models.channels.sms.ApiResponseOfSmsMarket
import dm.sent.models.channels.sms.SmsCreateParams
import dm.sent.models.channels.sms.SmsListParams
import dm.sent.models.channels.sms.SmsRetrieveParams
import dm.sent.models.channels.sms.SmsUpdateParams
import dm.sent.services.async.channels.sms.TenDlcServiceAsync
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
interface SmsServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmsServiceAsync

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
    fun tenDlc(): TenDlcServiceAsync

    /**
     * Gives the customer a sender in one country — the first market it sends in, and the fifth.
     *
     * ## What to have in place first
     *
     * **Call `GET /v3/compliance/requirements?country=US&type=TEN_DLC` first.** It returns this
     * request's body ready to fill in, plus the brand and campaign calls to make before it, in
     * order. You never have to track forty countries' rules yourself.
     *
     * **A market that registers with a compliance regime needs an identity, and this call takes
     * one.** US `TEN_DLC` registers with The Campaign Registry and files that registration against
     * a business identity. Send it in `compliance.brand` and it is recorded here, before the
     * registration that attaches to it — so a customer with no identity reaches a first 10DLC
     * market in one call.
     *
     * `{ "inherit": true }` runs on your organization's instead. A market with neither — none
     * stored, none sent — is `400`, because accepting it would write a channel that could never
     * register and leave it provisioning for ever with nothing saying why.
     *
     * **Everything the regime wants arrives in this request's `compliance`**, as two declared
     * objects: `brand` — the identity the registration is filed against — and `campaign`, with the
     * use case, the consent narrative, the volume, the sample messages and the keywords. There is
     * nothing to set up first. Nothing is submitted here either: the rows are what a submission is
     * later assembled from, and filing is externally rejectable so it happens on its own path.
     *
     * **A half you run yourself has to be complete here.** Whichever of `brand` and `campaign` is
     * your own rather than your organization's must carry every field the regime asks of it,
     * counting what you already hold — send the rest in this request. A missing one is `400` naming
     * each field, rather than a `202` for a market that could never be filed. A half you inherit is
     * asked for nothing.
     *
     * A market that registers with nobody — an alphanumeric sender in most countries — needs
     * neither, and may need documents instead.
     *
     * ## Sending it
     *
     * Takes the same fields `channels.sms` takes on `POST /v3/sender-profiles`, because it is the
     * same work, and both run one provisioning path. `compliance` is top-level and answers for the
     * market in this request, carrying `brand` and `campaign` where the market registers.
     *
     * **Accepts multipart as well as JSON**, with each file named after the compliance key it
     * satisfies — a market that pre-registers its sender needs its documents at the same moment it
     * needs the sender. Every required document must be attached to this request; a missing or
     * invalid file is rejected before the market is added.
     *
     * **`area_codes` puts the sender somewhere specific**, in your order of preference, for a
     * `LOCAL` sender in any country or a US `TEN_DLC` sender — a 10DLC number is an ordinary local
     * long code bound to a registered campaign, so both take the same codes out of the same
     * inventory. It is honoured exactly: you get a number in one of the codes you named or you get
     * none, never one in a code you left out.
     *
     * ## Several numbers
     *
     * **`numbers` lists the numbers you want, one entry per area code**, e.g. `[{"area_code":
     * "212", "quantity": 2}, {"quantity": 1}]` for two numbers in 212 and one in any area code.
     * `quantity` defaults to 1, and an entry without `area_code` means any area code. Omit
     * `numbers` for one number. It is for `LOCAL` and `TEN_DLC` only and cannot be combined with
     * `area_codes`. A market holds at most 49 numbers, counting the ones it already has.
     *
     * **On a `LOCAL` market you already hold, `numbers` adds those numbers to it** instead of
     * `409`. US `TEN_DLC` numbers belong to the market's campaign and are assigned when the
     * campaign is approved, not at request time. Until then they read as `PROVISIONING` in the
     * response's `numbers`, each with the area code it was asked for. A profile inheriting your
     * organization's campaign cannot request `numbers` (`400`). `numbers` on a `TEN_DLC` market you
     * already hold is `409`: change its campaign's numbers with `PATCH
     * /v3/channels/sms/{country}/{type}`, add numbers to one of its campaigns with `POST
     * /v3/channels/sms/numbers/US/TEN_DLC`, or add a new campaign with `POST
     * /v3/channels/sms/compliances/US/TEN_DLC/campaigns`.
     *
     * **A market you already send in is `409`**: adding what is already there is a mistake worth
     * reporting rather than a silent no-op. A market is a `(country, sender_type)` pair, so a
     * **second sender type in a country you already send in is fine** — `US TOLL_FREE` alongside
     * `US TEN_DLC` is the ordinary case. Two of the same type is not.
     *
     * **A market you hold that has no sender yet is not a duplicate**, and re-sending it re-asks
     * for a sender rather than being refused. That is the way out of an area-code request nothing
     * could fill: send the call again to name different codes, or no codes at all to take a number
     * anywhere in the country. It answers `201` with the sender when the pool has one, otherwise
     * `202` with the codes recorded — and changes nothing else; compliance on a market you hold is
     * `PATCH /v3/channels/sms/{country}/{type}`.
     *
     * One exception: while a market's sender type is still unassigned, adding any type to that
     * country is `409` once it has a sender, because the market you have may be about to become the
     * one you asked for.
     *
     * Returns **the market**, in the shape `GET` and `PATCH` on `/v3/channels/sms/{country}/{type}`
     * use — so what this answers can be read back and written back without reshaping. Not every
     * channel you have: adding a market cannot change an RCS agent or a WhatsApp account, and `GET
     * /v3/channels` is the whole picture. `201` when the market is ready; `202` while a sender or a
     * registration is still outstanding.
     *
     * Send `x-profile-id` with an organization key to add a market to one of your profiles.
     */
    fun create(params: SmsCreateParams): CompletableFuture<ApiResponseOfSmsMarket> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SmsCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfSmsMarket>

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
    fun retrieve(
        type: String,
        params: SmsRetrieveParams,
    ): CompletableFuture<ApiResponseOfSmsMarket> = retrieve(type, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        type: String,
        params: SmsRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfSmsMarket> =
        retrieve(params.toBuilder().type(type).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: SmsRetrieveParams): CompletableFuture<ApiResponseOfSmsMarket> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SmsRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfSmsMarket>

    /**
     * Supplies whatever this market is waiting on, and answers with the market as stored — the same
     * shape `GET` on this path returns, so **what comes back can be sent back**.
     *
     * **A market reporting `ACTION_NEEDED` is fixed here**, whatever it is waiting on:
     *
     * |Outstanding                                 |Send                                                                                                                                 |
     * |--------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
     * |a `brand` or `campaign` value (US `TEN_DLC`)|`compliance`, as below                                                                                                               |
     * |a document, in any market                   |a multipart file named after the document's key                                                                                      |
     * |a registration sent back for correction     |`compliance.brand` and/or `compliance.campaign` — the identity is accepted even once filed, and the registration goes back for review|
     * |different numbers                           |`numbers`, the list the market asks for from now on                                                                                  |
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
     * That leaves the campaign untouched, along with every other field of the identity.
     *
     * ## What a US `TEN_DLC` market holds
     *
     * Two halves, both singular: `brand`, the identity the registration is filed against, and
     * `campaign`, the programme filed against it. Each carries `inherit`.
     *
     * |Body                             |Effect                                                       |
     * |---------------------------------|-------------------------------------------------------------|
     * |`"brand": { … }`                 |supplies or corrects the identity, and takes one of your own |
     * |`"brand": { "inherit": true }`   |runs on your organization's, giving up your own              |
     * |`"brand": null`                  |the same thing, said the short way                           |
     * |`"campaign": { … }`              |supplies or corrects the programme, and takes one of your own|
     * |`"campaign": { "inherit": true }`|runs on your organization's                                  |
     * |key omitted                      |left exactly as it is                                        |
     *
     * **Nothing here creates a second anything.** One identity and one campaign per market, so a
     * write is an upsert and a replayed request lands on the row it already wrote. Sending the
     * campaign twice does not file two registrations.
     *
     * ## Every other market
     *
     * Markets that register with no regime have neither half, so `compliance` is `400` there. Their
     * compliance is documents, sent here as multipart.
     *
     * ## Documents
     *
     * Send `multipart/form-data` with **each file named after the compliance key it satisfies** —
     * the key the market's `requirements` names. A file that matches no document the market asks
     * for is `400` naming the keys that would, and a file the upload rules refuse (empty, too
     * large, an unsupported type) is `422`. `compliance` and `numbers` may ride in the same form as
     * text parts holding their JSON.
     *
     * ## Numbers
     *
     * `numbers` takes the list `POST /v3/channels/sms` takes, for a `LOCAL` or `TEN_DLC` market,
     * and **replaces** what the market asks for — send the list you want, not a difference. Numbers
     * already assigned stay; a list that leaves one of them out is `400`, because nothing here
     * releases a number.
     *
     * ```json
     * { "numbers": [ { "area_code": "415", "quantity": 2 }, { "quantity": 1 } ] }
     * ```
     *
     * A `LOCAL` market is claimed from inventory at once, and whatever inventory cannot cover stays
     * pending. A `TEN_DLC` market's numbers are recorded on its campaign and assigned once the
     * carriers elect it — on the next acquisition cycle when it already has been. They need a
     * campaign of the profile's own: one inherited from the organization is `400`.
     *
     * ## What it will refuse
     *
     * **A filed identity is `409`.** Once the registration has gone to The Campaign Registry they
     * hold a copy, and a local change would diverge from it silently. The campaign is not frozen —
     * omit `brand` and the same body is accepted. The exception is a registration sent back for
     * correction: the identity is accepted, and a correction to either half sends the registration
     * back for review. Refiling it with The Campaign Registry stays with Sent.
     *
     * **More than one campaign is `409`.** The schema permits several and an account built on the
     * admin side may hold them; this surface writes one, and editing whichever sorted first would
     * leave the others unmentioned and unedited.
     *
     * Nothing is submitted to a regime here. These are the rows a submission is later assembled
     * from, which is what lets them be corrected without waiting on something externally
     * rejectable.
     *
     * Send `x-profile-id` with an organization key to write one of your profiles' markets.
     */
    fun update(type: String, params: SmsUpdateParams): CompletableFuture<ApiResponseOfSmsMarket> =
        update(type, params, RequestOptions.none())

    /** @see update */
    fun update(
        type: String,
        params: SmsUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfSmsMarket> =
        update(params.toBuilder().type(type).build(), requestOptions)

    /** @see update */
    fun update(params: SmsUpdateParams): CompletableFuture<ApiResponseOfSmsMarket> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SmsUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfSmsMarket>

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
    fun list(): CompletableFuture<ApiResponseOfListOfSmsMarket> = list(SmsListParams.none())

    /** @see list */
    fun list(
        params: SmsListParams = SmsListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfListOfSmsMarket>

    /** @see list */
    fun list(
        params: SmsListParams = SmsListParams.none()
    ): CompletableFuture<ApiResponseOfListOfSmsMarket> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfListOfSmsMarket> =
        list(SmsListParams.none(), requestOptions)

    /** A view of [SmsServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmsServiceAsync.WithRawResponse

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
        fun tenDlc(): TenDlcServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/channels/sms`, but is otherwise the same as
         * [SmsServiceAsync.create].
         */
        fun create(
            params: SmsCreateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SmsCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>>

        /**
         * Returns a raw HTTP response for `get /v3/channels/sms/{country}/{type}`, but is otherwise
         * the same as [SmsServiceAsync.retrieve].
         */
        fun retrieve(
            type: String,
            params: SmsRetrieveParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            retrieve(type, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            type: String,
            params: SmsRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            retrieve(params.toBuilder().type(type).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: SmsRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: SmsRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>>

        /**
         * Returns a raw HTTP response for `patch /v3/channels/sms/{country}/{type}`, but is
         * otherwise the same as [SmsServiceAsync.update].
         */
        fun update(
            type: String,
            params: SmsUpdateParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            update(type, params, RequestOptions.none())

        /** @see update */
        fun update(
            type: String,
            params: SmsUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            update(params.toBuilder().type(type).build(), requestOptions)

        /** @see update */
        fun update(
            params: SmsUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SmsUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfSmsMarket>>

        /**
         * Returns a raw HTTP response for `get /v3/channels/sms`, but is otherwise the same as
         * [SmsServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ApiResponseOfListOfSmsMarket>> =
            list(SmsListParams.none())

        /** @see list */
        fun list(
            params: SmsListParams = SmsListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfListOfSmsMarket>>

        /** @see list */
        fun list(
            params: SmsListParams = SmsListParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfListOfSmsMarket>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfListOfSmsMarket>> =
            list(SmsListParams.none(), requestOptions)
    }
}
