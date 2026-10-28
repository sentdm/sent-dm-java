// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.core.ClientOptions
import dm.sent.services.blocking.VoiceService
import dm.sent.services.blocking.VoiceServiceImpl
import dm.sent.services.blocking.voice.AgentService
import dm.sent.services.blocking.voice.AgentServiceImpl
import dm.sent.services.blocking.voice.CallService
import dm.sent.services.blocking.voice.CallServiceImpl
import dm.sent.services.blocking.voice.TokenService
import dm.sent.services.blocking.voice.TokenServiceImpl
import dm.sent.services.blocking.voice.VoiceService
import dm.sent.services.blocking.voice.VoiceServiceImpl
import java.util.function.Consumer

class VoiceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VoiceService {

    private val withRawResponse: VoiceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val calls: CallService by lazy { CallServiceImpl(clientOptions) }

    private val tokens: TokenService by lazy { TokenServiceImpl(clientOptions) }

    private val agents: AgentService by lazy { AgentServiceImpl(clientOptions) }

    private val voices: VoiceService by lazy { VoiceServiceImpl(clientOptions) }

    override fun withRawResponse(): VoiceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceService =
        VoiceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
    override fun calls(): CallService = calls

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
    override fun tokens(): TokenService = tokens

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
    override fun agents(): AgentService = agents

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
    override fun voices(): VoiceService = voices

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VoiceService.WithRawResponse {

        private val calls: CallService.WithRawResponse by lazy {
            CallServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val tokens: TokenService.WithRawResponse by lazy {
            TokenServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val agents: AgentService.WithRawResponse by lazy {
            AgentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val voices: VoiceService.WithRawResponse by lazy {
            VoiceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceService.WithRawResponse =
            VoiceServiceImpl.WithRawResponseImpl(
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
        override fun calls(): CallService.WithRawResponse = calls

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
        override fun tokens(): TokenService.WithRawResponse = tokens

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
        override fun agents(): AgentService.WithRawResponse = agents

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
        override fun voices(): VoiceService.WithRawResponse = voices
    }
}
