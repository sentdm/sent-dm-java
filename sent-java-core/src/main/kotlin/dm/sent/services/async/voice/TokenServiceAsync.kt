// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.voice

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.voice.tokens.ApiResponseOfVoiceToken
import dm.sent.models.voice.tokens.TokenCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Phone calls from the numbers you hold, driven by your own callback URL.
 *
 * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to do
 * with each call on it, and `POST /v3/voice/tokens` mints a short-lived token that lets a user of
 * your app place and receive calls as that number. When a call arrives or a caller presses a key, a
 * signed question is POSTed to the callback URL and the answer decides the call; `POST
 * /v3/channels/voice/{number}/test` checks the URL answers the way we need before a real call
 * reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The
 * call events themselves (`call.completed` and the rest) arrive through your webhooks.
 *
 * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is ready,
 * hang it up, start or stop recording, and add, mute or remove conference participants while it is
 * live. A leg to a phone number runs for at most what your balance affords at the destination's
 * rate.
 *
 * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the Sent
 * Voice Gateway: `session_type` says whether Sent carries the call as text (speech recognised and
 * spoken for the agent) or as audio, `websocket_url` is where the gateway dials the agent for each
 * call (leave it out and the agent dials in with your API key), and `tools`, `transfer_targets`,
 * `fallback` and `limits` say what it may do on a call. The agent's `signing_secret` is shown on
 * create and on `POST /v3/voice/agents/{id}/rotate-secret` only. Voices and languages for text
 * sessions come from `GET /v3/voice/voices`. A number takes calls to an agent once it is bound to
 * it on `/v3/channels/voice`.
 */
interface TokenServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TokenServiceAsync

    /**
     * Mints a short-lived token for one of your app users. Call this from your backend and return
     * the token to your app, which passes it to the voice client SDK to register. The identity is
     * bound to the given number, or to your default app-call number when omitted, and calls placed
     * by that identity are routed through the bound number. Minting again re-binds the identity, so
     * an identity can move between numbers.
     */
    fun create(): CompletableFuture<ApiResponseOfVoiceToken> = create(TokenCreateParams.none())

    /** @see create */
    fun create(
        params: TokenCreateParams = TokenCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceToken>

    /** @see create */
    fun create(
        params: TokenCreateParams = TokenCreateParams.none()
    ): CompletableFuture<ApiResponseOfVoiceToken> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfVoiceToken> =
        create(TokenCreateParams.none(), requestOptions)

    /** A view of [TokenServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TokenServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/voice/tokens`, but is otherwise the same as
         * [TokenServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceToken>> =
            create(TokenCreateParams.none())

        /** @see create */
        fun create(
            params: TokenCreateParams = TokenCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceToken>>

        /** @see create */
        fun create(
            params: TokenCreateParams = TokenCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceToken>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceToken>> =
            create(TokenCreateParams.none(), requestOptions)
    }
}
