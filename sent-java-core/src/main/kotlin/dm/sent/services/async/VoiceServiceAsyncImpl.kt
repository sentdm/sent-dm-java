// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.services.async.VoiceServiceAsync
import dm.sent.services.async.VoiceServiceAsyncImpl
import dm.sent.services.async.voice.AgentServiceAsync
import dm.sent.services.async.voice.AgentServiceAsyncImpl
import dm.sent.services.async.voice.CallServiceAsync
import dm.sent.services.async.voice.CallServiceAsyncImpl
import dm.sent.services.async.voice.TokenServiceAsync
import dm.sent.services.async.voice.TokenServiceAsyncImpl
import dm.sent.services.async.voice.VoiceServiceAsync
import dm.sent.services.async.voice.VoiceServiceAsyncImpl
import java.util.function.Consumer

class VoiceServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VoiceServiceAsync {

    private val withRawResponse: VoiceServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val calls: CallServiceAsync by lazy { CallServiceAsyncImpl(clientOptions) }

    private val tokens: TokenServiceAsync by lazy { TokenServiceAsyncImpl(clientOptions) }

    private val agents: AgentServiceAsync by lazy { AgentServiceAsyncImpl(clientOptions) }

    private val voices: VoiceServiceAsync by lazy { VoiceServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): VoiceServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceServiceAsync =
        VoiceServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Phone calls from the numbers you hold, driven by your own callback URL.
     *
     * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to
     * do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token that lets a
     * user of your app place and receive calls as that number. When a call arrives or a caller
     * presses a key, a signed question is POSTed to the callback URL and the answer decides the
     * call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way we need before a
     * real call reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the
     * signing secret. The call events themselves (`call.completed` and the rest) arrive through
     * your webhooks.
     *
     * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
     * ready, hang it up, start or stop recording, and add, mute or remove conference participants
     * while it is live. A leg to a phone number runs for at most what your balance affords at the
     * destination's rate.
     *
     * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
     * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
     * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway dials
     * the agent for each call (leave it out and the agent dials in with your API key), and `tools`,
     * `transfer_targets`, `fallback` and `limits` say what it may do on a call. The agent's
     * `signing_secret` is shown on create and on `POST /v3/voice/agents/{id}/rotate-secret` only.
     * Voices and languages for text sessions come from `GET /v3/voice/voices`. A number takes calls
     * to an agent once it is bound to it on `/v3/channels/voice`.
     */
    override fun calls(): CallServiceAsync = calls

    /**
     * Phone calls from the numbers you hold, driven by your own callback URL.
     *
     * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to
     * do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token that lets a
     * user of your app place and receive calls as that number. When a call arrives or a caller
     * presses a key, a signed question is POSTed to the callback URL and the answer decides the
     * call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way we need before a
     * real call reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the
     * signing secret. The call events themselves (`call.completed` and the rest) arrive through
     * your webhooks.
     *
     * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
     * ready, hang it up, start or stop recording, and add, mute or remove conference participants
     * while it is live. A leg to a phone number runs for at most what your balance affords at the
     * destination's rate.
     *
     * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
     * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
     * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway dials
     * the agent for each call (leave it out and the agent dials in with your API key), and `tools`,
     * `transfer_targets`, `fallback` and `limits` say what it may do on a call. The agent's
     * `signing_secret` is shown on create and on `POST /v3/voice/agents/{id}/rotate-secret` only.
     * Voices and languages for text sessions come from `GET /v3/voice/voices`. A number takes calls
     * to an agent once it is bound to it on `/v3/channels/voice`.
     */
    override fun tokens(): TokenServiceAsync = tokens

    /**
     * Phone calls from the numbers you hold, driven by your own callback URL.
     *
     * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to
     * do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token that lets a
     * user of your app place and receive calls as that number. When a call arrives or a caller
     * presses a key, a signed question is POSTed to the callback URL and the answer decides the
     * call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way we need before a
     * real call reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the
     * signing secret. The call events themselves (`call.completed` and the rest) arrive through
     * your webhooks.
     *
     * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
     * ready, hang it up, start or stop recording, and add, mute or remove conference participants
     * while it is live. A leg to a phone number runs for at most what your balance affords at the
     * destination's rate.
     *
     * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
     * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
     * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway dials
     * the agent for each call (leave it out and the agent dials in with your API key), and `tools`,
     * `transfer_targets`, `fallback` and `limits` say what it may do on a call. The agent's
     * `signing_secret` is shown on create and on `POST /v3/voice/agents/{id}/rotate-secret` only.
     * Voices and languages for text sessions come from `GET /v3/voice/voices`. A number takes calls
     * to an agent once it is bound to it on `/v3/channels/voice`.
     */
    override fun agents(): AgentServiceAsync = agents

    /**
     * Phone calls from the numbers you hold, driven by your own callback URL.
     *
     * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to
     * do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token that lets a
     * user of your app place and receive calls as that number. When a call arrives or a caller
     * presses a key, a signed question is POSTed to the callback URL and the answer decides the
     * call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way we need before a
     * real call reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the
     * signing secret. The call events themselves (`call.completed` and the rest) arrive through
     * your webhooks.
     *
     * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
     * ready, hang it up, start or stop recording, and add, mute or remove conference participants
     * while it is live. A leg to a phone number runs for at most what your balance affords at the
     * destination's rate.
     *
     * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
     * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
     * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway dials
     * the agent for each call (leave it out and the agent dials in with your API key), and `tools`,
     * `transfer_targets`, `fallback` and `limits` say what it may do on a call. The agent's
     * `signing_secret` is shown on create and on `POST /v3/voice/agents/{id}/rotate-secret` only.
     * Voices and languages for text sessions come from `GET /v3/voice/voices`. A number takes calls
     * to an agent once it is bound to it on `/v3/channels/voice`.
     */
    override fun voices(): VoiceServiceAsync = voices

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VoiceServiceAsync.WithRawResponse {

        private val calls: CallServiceAsync.WithRawResponse by lazy {
            CallServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val tokens: TokenServiceAsync.WithRawResponse by lazy {
            TokenServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val agents: AgentServiceAsync.WithRawResponse by lazy {
            AgentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val voices: VoiceServiceAsync.WithRawResponse by lazy {
            VoiceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceServiceAsync.WithRawResponse =
            VoiceServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Phone calls from the numbers you hold, driven by your own callback URL.
         *
         * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks
         * what to do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token
         * that lets a user of your app place and receive calls as that number. When a call arrives
         * or a caller presses a key, a signed question is POSTed to the callback URL and the answer
         * decides the call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way
         * we need before a real call reaches it, and `POST
         * /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The call events
         * themselves (`call.completed` and the rest) arrive through your webhooks.
         *
         * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
         * ready, hang it up, start or stop recording, and add, mute or remove conference
         * participants while it is live. A leg to a phone number runs for at most what your balance
         * affords at the destination's rate.
         *
         * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
         * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
         * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway
         * dials the agent for each call (leave it out and the agent dials in with your API key),
         * and `tools`, `transfer_targets`, `fallback` and `limits` say what it may do on a call.
         * The agent's `signing_secret` is shown on create and on `POST
         * /v3/voice/agents/{id}/rotate-secret` only. Voices and languages for text sessions come
         * from `GET /v3/voice/voices`. A number takes calls to an agent once it is bound to it on
         * `/v3/channels/voice`.
         */
        override fun calls(): CallServiceAsync.WithRawResponse = calls

        /**
         * Phone calls from the numbers you hold, driven by your own callback URL.
         *
         * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks
         * what to do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token
         * that lets a user of your app place and receive calls as that number. When a call arrives
         * or a caller presses a key, a signed question is POSTed to the callback URL and the answer
         * decides the call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way
         * we need before a real call reaches it, and `POST
         * /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The call events
         * themselves (`call.completed` and the rest) arrive through your webhooks.
         *
         * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
         * ready, hang it up, start or stop recording, and add, mute or remove conference
         * participants while it is live. A leg to a phone number runs for at most what your balance
         * affords at the destination's rate.
         *
         * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
         * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
         * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway
         * dials the agent for each call (leave it out and the agent dials in with your API key),
         * and `tools`, `transfer_targets`, `fallback` and `limits` say what it may do on a call.
         * The agent's `signing_secret` is shown on create and on `POST
         * /v3/voice/agents/{id}/rotate-secret` only. Voices and languages for text sessions come
         * from `GET /v3/voice/voices`. A number takes calls to an agent once it is bound to it on
         * `/v3/channels/voice`.
         */
        override fun tokens(): TokenServiceAsync.WithRawResponse = tokens

        /**
         * Phone calls from the numbers you hold, driven by your own callback URL.
         *
         * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks
         * what to do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token
         * that lets a user of your app place and receive calls as that number. When a call arrives
         * or a caller presses a key, a signed question is POSTed to the callback URL and the answer
         * decides the call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way
         * we need before a real call reaches it, and `POST
         * /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The call events
         * themselves (`call.completed` and the rest) arrive through your webhooks.
         *
         * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
         * ready, hang it up, start or stop recording, and add, mute or remove conference
         * participants while it is live. A leg to a phone number runs for at most what your balance
         * affords at the destination's rate.
         *
         * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
         * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
         * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway
         * dials the agent for each call (leave it out and the agent dials in with your API key),
         * and `tools`, `transfer_targets`, `fallback` and `limits` say what it may do on a call.
         * The agent's `signing_secret` is shown on create and on `POST
         * /v3/voice/agents/{id}/rotate-secret` only. Voices and languages for text sessions come
         * from `GET /v3/voice/voices`. A number takes calls to an agent once it is bound to it on
         * `/v3/channels/voice`.
         */
        override fun agents(): AgentServiceAsync.WithRawResponse = agents

        /**
         * Phone calls from the numbers you hold, driven by your own callback URL.
         *
         * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks
         * what to do with each call on it, and `POST /v3/voice/tokens` mints a short-lived token
         * that lets a user of your app place and receive calls as that number. When a call arrives
         * or a caller presses a key, a signed question is POSTed to the callback URL and the answer
         * decides the call; `POST /v3/channels/voice/{number}/test` checks the URL answers the way
         * we need before a real call reaches it, and `POST
         * /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The call events
         * themselves (`call.completed` and the rest) arrive through your webhooks.
         *
         * Every call is a record under `/v3/voice/calls`: read it, list its recordings once one is
         * ready, hang it up, start or stop recording, and add, mute or remove conference
         * participants while it is live. A leg to a phone number runs for at most what your balance
         * affords at the destination's rate.
         *
         * **Voice agents.** `POST /v3/voice/agents` creates an agent that answers calls through the
         * Sent Voice Gateway: `session_type` says whether Sent carries the call as text (speech
         * recognised and spoken for the agent) or as audio, `websocket_url` is where the gateway
         * dials the agent for each call (leave it out and the agent dials in with your API key),
         * and `tools`, `transfer_targets`, `fallback` and `limits` say what it may do on a call.
         * The agent's `signing_secret` is shown on create and on `POST
         * /v3/voice/agents/{id}/rotate-secret` only. Voices and languages for text sessions come
         * from `GET /v3/voice/voices`. A number takes calls to an agent once it is bound to it on
         * `/v3/channels/voice`.
         */
        override fun voices(): VoiceServiceAsync.WithRawResponse = voices
    }
}
