// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.voice.ApiResponseOfListOfVoiceNumber
import dm.sent.models.channels.voice.ApiResponseOfVoiceCallbackTest
import dm.sent.models.channels.voice.ApiResponseOfVoiceNumber
import dm.sent.models.channels.voice.ApiResponseOfVoiceNumberCreated
import dm.sent.models.channels.voice.ApiResponseOfVoiceSecret
import dm.sent.models.channels.voice.VoiceCreateParams
import dm.sent.models.channels.voice.VoiceListParams
import dm.sent.models.channels.voice.VoiceRetrieveParams
import dm.sent.models.channels.voice.VoiceRotateSecretParams
import dm.sent.models.channels.voice.VoiceTestParams
import dm.sent.models.channels.voice.VoiceUpdateParams
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
interface VoiceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceServiceAsync

    /**
     * Adds voice to one of the numbers you hold, or gives you a new one. Send `number` for a number
     * that is already yours (see `GET /v3/channels`); leave it out to be given a new US number,
     * optionally in a particular `area_code`. Sending both is refused. Nothing registers, so the
     * number can carry calls as soon as this returns.
     *
     * What happens on a call is decided by your `callback_url`: when a call arrives on the number,
     * or a caller presses a key on a menu, Sent POSTs a signed question there and follows the
     * answer. The response carries the `callback_secret` the questions are signed with, the one
     * time it is shown without rotating; verify a question the way you verify a webhook. `POST
     * /v3/channels/voice/{number}/test` sends a test question and reports the verdict.
     *
     * Send `agent_id` instead of `callback_url`, or with it, to have one of your voice agents (`GET
     * /v3/voice/agents`) answer calls to the number. The agent wins over the callback URL for calls
     * to the number; calls your app places from it still follow your app. `routes_to` in the
     * response says which answers, and reads `agent_pending` while the number is still being moved
     * to the agent. Calls follow the move within about an hour, as the provider applies it on its
     * own clock. While numbers cannot be bound to agents, a request with `agent_id` is refused with
     * `502` before any number is obtained or anything is written; send `callback_url` instead.
     *
     * Your first voice number becomes the line app-originated calls are placed from when a voice
     * token names no number; send `default_for_app_calls: true` to give that role to another
     * number. A number you turned off earlier is turned back on, and the same number with a
     * different `callback_url` has its URL replaced and keeps its secret.
     *
     * Read the number's settings with `GET /v3/channels/voice` and change them with `PATCH
     * /v3/channels/voice/{number}`.
     *
     * With `sandbox: true` the request is validated and a simulated number reported with `202`;
     * nothing is written and no number is bought.
     */
    fun create(): CompletableFuture<ApiResponseOfVoiceNumberCreated> =
        create(VoiceCreateParams.none())

    /** @see create */
    fun create(
        params: VoiceCreateParams = VoiceCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumberCreated>

    /** @see create */
    fun create(
        params: VoiceCreateParams = VoiceCreateParams.none()
    ): CompletableFuture<ApiResponseOfVoiceNumberCreated> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfVoiceNumberCreated> =
        create(VoiceCreateParams.none(), requestOptions)

    /**
     * Reads one of your voice numbers, active or inactive: its status, whether it is the default
     * line for calls placed from your app, and its callback URL. The signing secret is not on this
     * read.
     *
     * The same shape `GET /v3/channels/voice` lists, and the same shape `PATCH` on this path
     * accepts and returns, so what comes back can be sent back.
     *
     * The number is the E.164 value in the path with the plus sign URL-encoded (`%2B`).
     */
    fun retrieve(number: String): CompletableFuture<ApiResponseOfVoiceNumber> =
        retrieve(number, VoiceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        number: String,
        params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumber> =
        retrieve(params.toBuilder().number(number).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        number: String,
        params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumber> = retrieve(number, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VoiceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumber>

    /** @see retrieve */
    fun retrieve(params: VoiceRetrieveParams): CompletableFuture<ApiResponseOfVoiceNumber> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        number: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfVoiceNumber> =
        retrieve(number, VoiceRetrieveParams.none(), requestOptions)

    /**
     * Changes one of your voice numbers and answers with the number as stored, the same shape `GET`
     * on this path returns, so what comes back can be sent back.
     *
     * ## What it changes
     * |Body                                         |Effect                                                                                                                                                                                                                                                                                                                                                                                                    |
     * |---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     * |`"status": "ACTIVE"`                         |turns calls on again for a number you turned off; the callback URL and the secret it had are kept                                                                                                                                                                                                                                                                                                         |
     * |`"status": "INACTIVE"`                       |turns calls off; the callback URL and the secret stay on the number                                                                                                                                                                                                                                                                                                                                       |
     * |`"default_for_app_calls": true`              |makes this the line app-originated calls are placed from when a voice token names no number                                                                                                                                                                                                                                                                                                               |
     * |`"callback_url": "https://example.com/voice"`|replaces where Sent asks what to do with each call on the number; the signing secret and the status are kept                                                                                                                                                                                                                                                                                              |
     * |`"agent_id": "agent_…"`                      |one of your voice agents answers calls to the number, within about an hour of the change (the provider applies the move on its own clock, and `routes_to` reads `agent` as soon as it has recorded it); it wins over `callback_url` for calls to the number, and calls your app places from it still follow your app. `routes_to` reads `agent_pending` while the number is still being moved to the agent|
     * |`"agent_id": null`                           |unbinds the agent, so `callback_url` answers calls to the number again                                                                                                                                                                                                                                                                                                                                    |
     * |key omitted                                  |left exactly as it is                                                                                                                                                                                                                                                                                                                                                                                     |
     *
     * `status` is matched ignoring case. Any combination is accepted: `status: "ACTIVE"` with
     * `default_for_app_calls: true` turns a number on as the new default, and a `callback_url` sent
     * with either status is written too. `agent_id` is applied first, so a refusal to move the
     * number to or from the agent leaves everything as it was, and the `409` and `400` refusals
     * below are decided before anything is written, so they leave everything as it was too. A body
     * that names none of them is refused.
     *
     * A number can be on without a callback URL: calls placed from your app then connect straight
     * to the number or user they dial, and calls to the number are declined.
     *
     * ## What it will refuse
     *
     * **`default_for_app_calls: false` is `400`.** An account with active voice numbers always has
     * exactly one default, so the default moves by giving it to another number.
     *
     * **Turning the default line off is `409`** while other active voice numbers remain. Move the
     * default to another number first. Turning off your last voice number is allowed; that turns
     * phone calls off.
     *
     * **Making an inactive number the default is `400`.** Send `status: "ACTIVE"` in the same call.
     *
     * **A number you never turned voice on for is `404`**, and so is an `agent_id` that is not one
     * of your agents. Add the number with `POST /v3/channels/voice`.
     *
     * **`502` means the number could not be moved to or from the agent**, or an `agent_id` was sent
     * while numbers cannot be bound to agents; nothing was written.
     *
     * The number is the E.164 value in the path with the plus sign URL-encoded (`%2B`).
     *
     * With `sandbox: true` nothing is written: the request is validated against the stored number
     * and the number is reported with `200` as it would read after the change.
     */
    fun update(number: String): CompletableFuture<ApiResponseOfVoiceNumber> =
        update(number, VoiceUpdateParams.none())

    /** @see update */
    fun update(
        number: String,
        params: VoiceUpdateParams = VoiceUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumber> =
        update(params.toBuilder().number(number).build(), requestOptions)

    /** @see update */
    fun update(
        number: String,
        params: VoiceUpdateParams = VoiceUpdateParams.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumber> = update(number, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: VoiceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceNumber>

    /** @see update */
    fun update(params: VoiceUpdateParams): CompletableFuture<ApiResponseOfVoiceNumber> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        number: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfVoiceNumber> =
        update(number, VoiceUpdateParams.none(), requestOptions)

    /**
     * Every number you turned phone calls on for, active or inactive, oldest first. Each entry
     * carries the number's status, whether it is the default line for calls placed from your app,
     * and its callback URL. The signing secret is never on a read; it is shown when voice is turned
     * on and by `POST /v3/channels/voice/{number}/rotate-secret`.
     *
     * The same entries `GET /v3/channels` reports under `voice`, and the same shape `GET
     * /v3/channels/voice/{number}` returns for one of them. Change a number with `PATCH
     * /v3/channels/voice/{number}`.
     */
    fun list(): CompletableFuture<ApiResponseOfListOfVoiceNumber> = list(VoiceListParams.none())

    /** @see list */
    fun list(
        params: VoiceListParams = VoiceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfListOfVoiceNumber>

    /** @see list */
    fun list(
        params: VoiceListParams = VoiceListParams.none()
    ): CompletableFuture<ApiResponseOfListOfVoiceNumber> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfListOfVoiceNumber> =
        list(VoiceListParams.none(), requestOptions)

    /**
     * Generates a new signing secret for the questions Sent sends to this number's callback URL and
     * returns it. The previous secret stops signing immediately, so update your backend before the
     * next call reaches it. The number is the E.164 value in the path with the plus sign
     * URL-encoded (`%2B`).
     *
     * With `sandbox: true` a secret is generated and returned with `202`, and nothing is written.
     */
    fun rotateSecret(
        number: String,
        params: VoiceRotateSecretParams,
    ): CompletableFuture<ApiResponseOfVoiceSecret> =
        rotateSecret(number, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        number: String,
        params: VoiceRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceSecret> =
        rotateSecret(params.toBuilder().number(number).build(), requestOptions)

    /** @see rotateSecret */
    fun rotateSecret(params: VoiceRotateSecretParams): CompletableFuture<ApiResponseOfVoiceSecret> =
        rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: VoiceRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceSecret>

    /**
     * Sends a synthetic call.request question, flagged "test": true, to the number's callback URL,
     * signed with that number's real secret, and reports what came back. Use it to build and debug
     * your callback endpoint without placing calls: no call is placed, nothing is billed, and
     * nothing is stored. One attempt with the same deadline as a live call, no retry. The outcome
     * is ok when your endpoint answered 2xx with a valid answer; otherwise it is timeout,
     * connection_failed, http_error or invalid_answer, with the reason and, for an invalid answer,
     * the field at fault. The number is the E.164 value in the path with the plus sign URL-encoded
     * (`%2B`).
     *
     * With `sandbox: true` nothing is sent: the verdict comes back ok with `202` and no request or
     * response in it.
     */
    fun test(
        number: String,
        params: VoiceTestParams,
    ): CompletableFuture<ApiResponseOfVoiceCallbackTest> =
        test(number, params, RequestOptions.none())

    /** @see test */
    fun test(
        number: String,
        params: VoiceTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceCallbackTest> =
        test(params.toBuilder().number(number).build(), requestOptions)

    /** @see test */
    fun test(params: VoiceTestParams): CompletableFuture<ApiResponseOfVoiceCallbackTest> =
        test(params, RequestOptions.none())

    /** @see test */
    fun test(
        params: VoiceTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceCallbackTest>

    /** A view of [VoiceServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice`, but is otherwise the same as
         * [VoiceServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumberCreated>> =
            create(VoiceCreateParams.none())

        /** @see create */
        fun create(
            params: VoiceCreateParams = VoiceCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumberCreated>>

        /** @see create */
        fun create(
            params: VoiceCreateParams = VoiceCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumberCreated>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumberCreated>> =
            create(VoiceCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/channels/voice/{number}`, but is otherwise the
         * same as [VoiceServiceAsync.retrieve].
         */
        fun retrieve(number: String): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            retrieve(number, VoiceRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            number: String,
            params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            retrieve(params.toBuilder().number(number).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            number: String,
            params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            retrieve(number, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: VoiceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>>

        /** @see retrieve */
        fun retrieve(
            params: VoiceRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            number: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            retrieve(number, VoiceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/channels/voice/{number}`, but is otherwise the
         * same as [VoiceServiceAsync.update].
         */
        fun update(number: String): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            update(number, VoiceUpdateParams.none())

        /** @see update */
        fun update(
            number: String,
            params: VoiceUpdateParams = VoiceUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            update(params.toBuilder().number(number).build(), requestOptions)

        /** @see update */
        fun update(
            number: String,
            params: VoiceUpdateParams = VoiceUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            update(number, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: VoiceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>>

        /** @see update */
        fun update(
            params: VoiceUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            number: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceNumber>> =
            update(number, VoiceUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/channels/voice`, but is otherwise the same as
         * [VoiceServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<ApiResponseOfListOfVoiceNumber>> =
            list(VoiceListParams.none())

        /** @see list */
        fun list(
            params: VoiceListParams = VoiceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfListOfVoiceNumber>>

        /** @see list */
        fun list(
            params: VoiceListParams = VoiceListParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfListOfVoiceNumber>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfListOfVoiceNumber>> =
            list(VoiceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice/{number}/rotate-secret`, but is
         * otherwise the same as [VoiceServiceAsync.rotateSecret].
         */
        fun rotateSecret(
            number: String,
            params: VoiceRotateSecretParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceSecret>> =
            rotateSecret(number, params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            number: String,
            params: VoiceRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceSecret>> =
            rotateSecret(params.toBuilder().number(number).build(), requestOptions)

        /** @see rotateSecret */
        fun rotateSecret(
            params: VoiceRotateSecretParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceSecret>> =
            rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            params: VoiceRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceSecret>>

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice/{number}/test`, but is otherwise
         * the same as [VoiceServiceAsync.test].
         */
        fun test(
            number: String,
            params: VoiceTestParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceCallbackTest>> =
            test(number, params, RequestOptions.none())

        /** @see test */
        fun test(
            number: String,
            params: VoiceTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceCallbackTest>> =
            test(params.toBuilder().number(number).build(), requestOptions)

        /** @see test */
        fun test(
            params: VoiceTestParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceCallbackTest>> =
            test(params, RequestOptions.none())

        /** @see test */
        fun test(
            params: VoiceTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceCallbackTest>>
    }
}
