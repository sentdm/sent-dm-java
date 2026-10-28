// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.core.ClientOptions
import dm.sent.services.blocking.voice.AgentService
import dm.sent.services.blocking.voice.CallService
import dm.sent.services.blocking.voice.CatalogueService
import dm.sent.services.blocking.voice.TokenService
import java.util.function.Consumer

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
    fun calls(): CallService

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
    fun tokens(): TokenService

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
    fun agents(): AgentService

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
    fun catalogue(): CatalogueService

    /** A view of [VoiceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceService.WithRawResponse

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
        fun calls(): CallService.WithRawResponse

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
        fun tokens(): TokenService.WithRawResponse

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
        fun agents(): AgentService.WithRawResponse

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
        fun catalogue(): CatalogueService.WithRawResponse
    }
}
