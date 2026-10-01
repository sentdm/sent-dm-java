// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import com.google.errorprone.annotations.MustBeClosed
import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.channels.voice.ApiResponseOfListOfVoiceNumber
import dm.sent.models.channels.voice.ApiResponseOfVoiceCallbackTest
import dm.sent.models.channels.voice.ApiResponseOfVoiceNumber
import dm.sent.models.channels.voice.ApiResponseOfVoiceNumberCreated
import dm.sent.models.channels.voice.ApiResponseOfVoiceSecret
import dm.sent.models.channels.voice.ApiResponseOfVoiceToken
import dm.sent.models.channels.voice.VoiceCreateParams
import dm.sent.models.channels.voice.VoiceCreateTokenParams
import dm.sent.models.channels.voice.VoiceListParams
import dm.sent.models.channels.voice.VoiceRetrieveParams
import dm.sent.models.channels.voice.VoiceRotateSecretParams
import dm.sent.models.channels.voice.VoiceTestParams
import dm.sent.models.channels.voice.VoiceUpdateParams
import java.util.function.Consumer

/**
 * The senders you send from, one per channel.
 *
 * **SMS is a list of markets**, each keyed by `(country, number_type)` — a customer can hold
 * `us/10dlc` and `gb/alphanumeric` at once, so a market is addressed by the pair rather than by
 * country alone. **WhatsApp and RCS are single**: a customer has one business account and one
 * agent. **Voice is per number**: each number you hold can carry phone calls on its own (`POST
 * /v3/channels/voice`), each with the callback URL Sent asks what to do with its calls, one of them
 * is the default line for calls placed from your app, and voice tokens are minted under `POST
 * /v3/channels/voice/tokens`. Read your voice numbers with `GET /v3/channels/voice` and change one
 * with `PATCH /v3/channels/voice/{number}`.
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
interface VoiceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceService

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
    fun create(params: VoiceCreateParams): ApiResponseOfVoiceNumberCreated =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VoiceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceNumberCreated

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
    fun retrieve(number: String): ApiResponseOfVoiceNumber =
        retrieve(number, VoiceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        number: String,
        params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceNumber =
        retrieve(params.toBuilder().number(number).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        number: String,
        params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
    ): ApiResponseOfVoiceNumber = retrieve(number, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VoiceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceNumber

    /** @see retrieve */
    fun retrieve(params: VoiceRetrieveParams): ApiResponseOfVoiceNumber =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(number: String, requestOptions: RequestOptions): ApiResponseOfVoiceNumber =
        retrieve(number, VoiceRetrieveParams.none(), requestOptions)

    /**
     * Changes one of your voice numbers and answers with the number as stored, the same shape `GET`
     * on this path returns, so what comes back can be sent back.
     *
     * ## What it changes
     * |Body                                         |Effect                                                                                                                                                    |
     * |---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
     * |`"status": "ACTIVE"`                         |turns calls on again for a number you turned off; the callback URL and the secret it had are kept                                                         |
     * |`"status": "INACTIVE"`                       |turns calls off; the callback URL and the secret stay on the number                                                                                       |
     * |`"default_for_app_calls": true`              |makes this the line app-originated calls are placed from when a voice token names no number                                                               |
     * |`"callback_url": "https://example.com/voice"`|replaces where Sent asks what to do with each call on the number; the signing secret is kept, and a number that was waiting for its first URL is turned on|
     * |key omitted                                  |left exactly as it is                                                                                                                                     |
     *
     * `status` is matched ignoring case. Any combination is accepted: `status: "ACTIVE"` with
     * `default_for_app_calls: true` turns a number on as the new default, and a `callback_url` sent
     * with either status is written too. A body that names none of the three is refused.
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
     * A number added without a `callback_url` is `INACTIVE` for that one reason, so sending it a
     * `callback_url` turns it on by itself, and it becomes your default line if you have no other
     * active voice number. A number you turned off while it had a URL stays off.
     *
     * **A number you never turned voice on for is `404`.** Add it with `POST /v3/channels/voice`.
     *
     * The number is the E.164 value in the path with the plus sign URL-encoded (`%2B`).
     *
     * With `sandbox: true` nothing is written: the request is validated against the stored number
     * and the number is reported with `200` as it would read after the change.
     */
    fun update(number: String): ApiResponseOfVoiceNumber = update(number, VoiceUpdateParams.none())

    /** @see update */
    fun update(
        number: String,
        params: VoiceUpdateParams = VoiceUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceNumber = update(params.toBuilder().number(number).build(), requestOptions)

    /** @see update */
    fun update(
        number: String,
        params: VoiceUpdateParams = VoiceUpdateParams.none(),
    ): ApiResponseOfVoiceNumber = update(number, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: VoiceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceNumber

    /** @see update */
    fun update(params: VoiceUpdateParams): ApiResponseOfVoiceNumber =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(number: String, requestOptions: RequestOptions): ApiResponseOfVoiceNumber =
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
    fun list(): ApiResponseOfListOfVoiceNumber = list(VoiceListParams.none())

    /** @see list */
    fun list(
        params: VoiceListParams = VoiceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfListOfVoiceNumber

    /** @see list */
    fun list(params: VoiceListParams = VoiceListParams.none()): ApiResponseOfListOfVoiceNumber =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): ApiResponseOfListOfVoiceNumber =
        list(VoiceListParams.none(), requestOptions)

    /**
     * Mints a short-lived token for one of your app users. Call this from your backend and return
     * the token to your app, which passes it to the voice client SDK to register. The identity is
     * bound to the given number, or to your default app-call number when omitted, and calls placed
     * by that identity are routed through the bound number. Minting again re-binds the identity, so
     * an identity can move between numbers.
     */
    fun createToken(): ApiResponseOfVoiceToken = createToken(VoiceCreateTokenParams.none())

    /** @see createToken */
    fun createToken(
        params: VoiceCreateTokenParams = VoiceCreateTokenParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceToken

    /** @see createToken */
    fun createToken(
        params: VoiceCreateTokenParams = VoiceCreateTokenParams.none()
    ): ApiResponseOfVoiceToken = createToken(params, RequestOptions.none())

    /** @see createToken */
    fun createToken(requestOptions: RequestOptions): ApiResponseOfVoiceToken =
        createToken(VoiceCreateTokenParams.none(), requestOptions)

    /**
     * Generates a new signing secret for the questions Sent sends to this number's callback URL and
     * returns it. The previous secret stops signing immediately, so update your backend before the
     * next call reaches it. The number is the E.164 value in the path with the plus sign
     * URL-encoded (`%2B`).
     *
     * With `sandbox: true` a secret is generated and returned with `202`, and nothing is written.
     */
    fun rotateSecret(number: String, params: VoiceRotateSecretParams): ApiResponseOfVoiceSecret =
        rotateSecret(number, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        number: String,
        params: VoiceRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceSecret =
        rotateSecret(params.toBuilder().number(number).build(), requestOptions)

    /** @see rotateSecret */
    fun rotateSecret(params: VoiceRotateSecretParams): ApiResponseOfVoiceSecret =
        rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: VoiceRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceSecret

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
    fun test(number: String, params: VoiceTestParams): ApiResponseOfVoiceCallbackTest =
        test(number, params, RequestOptions.none())

    /** @see test */
    fun test(
        number: String,
        params: VoiceTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceCallbackTest =
        test(params.toBuilder().number(number).build(), requestOptions)

    /** @see test */
    fun test(params: VoiceTestParams): ApiResponseOfVoiceCallbackTest =
        test(params, RequestOptions.none())

    /** @see test */
    fun test(
        params: VoiceTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiResponseOfVoiceCallbackTest

    /** A view of [VoiceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice`, but is otherwise the same as
         * [VoiceService.create].
         */
        @MustBeClosed
        fun create(params: VoiceCreateParams): HttpResponseFor<ApiResponseOfVoiceNumberCreated> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: VoiceCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumberCreated>

        /**
         * Returns a raw HTTP response for `get /v3/channels/voice/{number}`, but is otherwise the
         * same as [VoiceService.retrieve].
         */
        @MustBeClosed
        fun retrieve(number: String): HttpResponseFor<ApiResponseOfVoiceNumber> =
            retrieve(number, VoiceRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            number: String,
            params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumber> =
            retrieve(params.toBuilder().number(number).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            number: String,
            params: VoiceRetrieveParams = VoiceRetrieveParams.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumber> =
            retrieve(number, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: VoiceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumber>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: VoiceRetrieveParams): HttpResponseFor<ApiResponseOfVoiceNumber> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            number: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceNumber> =
            retrieve(number, VoiceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/channels/voice/{number}`, but is otherwise the
         * same as [VoiceService.update].
         */
        @MustBeClosed
        fun update(number: String): HttpResponseFor<ApiResponseOfVoiceNumber> =
            update(number, VoiceUpdateParams.none())

        /** @see update */
        @MustBeClosed
        fun update(
            number: String,
            params: VoiceUpdateParams = VoiceUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumber> =
            update(params.toBuilder().number(number).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            number: String,
            params: VoiceUpdateParams = VoiceUpdateParams.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumber> = update(number, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: VoiceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceNumber>

        /** @see update */
        @MustBeClosed
        fun update(params: VoiceUpdateParams): HttpResponseFor<ApiResponseOfVoiceNumber> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            number: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceNumber> =
            update(number, VoiceUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/channels/voice`, but is otherwise the same as
         * [VoiceService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<ApiResponseOfListOfVoiceNumber> = list(VoiceListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VoiceListParams = VoiceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfListOfVoiceNumber>

        /** @see list */
        @MustBeClosed
        fun list(
            params: VoiceListParams = VoiceListParams.none()
        ): HttpResponseFor<ApiResponseOfListOfVoiceNumber> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfListOfVoiceNumber> =
            list(VoiceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice/tokens`, but is otherwise the
         * same as [VoiceService.createToken].
         */
        @MustBeClosed
        fun createToken(): HttpResponseFor<ApiResponseOfVoiceToken> =
            createToken(VoiceCreateTokenParams.none())

        /** @see createToken */
        @MustBeClosed
        fun createToken(
            params: VoiceCreateTokenParams = VoiceCreateTokenParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceToken>

        /** @see createToken */
        @MustBeClosed
        fun createToken(
            params: VoiceCreateTokenParams = VoiceCreateTokenParams.none()
        ): HttpResponseFor<ApiResponseOfVoiceToken> = createToken(params, RequestOptions.none())

        /** @see createToken */
        @MustBeClosed
        fun createToken(requestOptions: RequestOptions): HttpResponseFor<ApiResponseOfVoiceToken> =
            createToken(VoiceCreateTokenParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice/{number}/rotate-secret`, but is
         * otherwise the same as [VoiceService.rotateSecret].
         */
        @MustBeClosed
        fun rotateSecret(
            number: String,
            params: VoiceRotateSecretParams,
        ): HttpResponseFor<ApiResponseOfVoiceSecret> =
            rotateSecret(number, params, RequestOptions.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            number: String,
            params: VoiceRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceSecret> =
            rotateSecret(params.toBuilder().number(number).build(), requestOptions)

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            params: VoiceRotateSecretParams
        ): HttpResponseFor<ApiResponseOfVoiceSecret> = rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        @MustBeClosed
        fun rotateSecret(
            params: VoiceRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceSecret>

        /**
         * Returns a raw HTTP response for `post /v3/channels/voice/{number}/test`, but is otherwise
         * the same as [VoiceService.test].
         */
        @MustBeClosed
        fun test(
            number: String,
            params: VoiceTestParams,
        ): HttpResponseFor<ApiResponseOfVoiceCallbackTest> =
            test(number, params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(
            number: String,
            params: VoiceTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceCallbackTest> =
            test(params.toBuilder().number(number).build(), requestOptions)

        /** @see test */
        @MustBeClosed
        fun test(params: VoiceTestParams): HttpResponseFor<ApiResponseOfVoiceCallbackTest> =
            test(params, RequestOptions.none())

        /** @see test */
        @MustBeClosed
        fun test(
            params: VoiceTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiResponseOfVoiceCallbackTest>
    }
}
