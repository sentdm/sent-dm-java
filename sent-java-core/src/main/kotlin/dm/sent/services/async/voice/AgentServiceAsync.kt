// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.voice

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponseFor
import dm.sent.models.voice.agents.AgentCreateParams
import dm.sent.models.voice.agents.AgentDeleteParams
import dm.sent.models.voice.agents.AgentListPageAsync
import dm.sent.models.voice.agents.AgentListParams
import dm.sent.models.voice.agents.AgentRetrieveParams
import dm.sent.models.voice.agents.AgentRotateSecretParams
import dm.sent.models.voice.agents.AgentUpdateParams
import dm.sent.models.voice.agents.ApiResponseOfVoiceAgent
import dm.sent.models.voice.agents.ApiResponseOfVoiceAgentSecret
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
interface AgentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AgentServiceAsync

    /**
     * Creates an agent that answers phone calls through the Sent Voice Gateway. `session_type` says
     * whether Sent carries the call as text (the caller's speech recognised for the agent, the
     * agent's text spoken) or as audio. With `websocket_url` the gateway dials your agent for each
     * call and signs the handshake with the `signing_secret` this response returns; without it,
     * your agent dials in with your API key and this agent's `id`.
     *
     * `tools`, `transfer_targets`, `fallback` and `limits` say what the agent may do on a call.
     * Voices and languages for text sessions come from `GET /v3/voice/voices`. Calls reach the
     * agent once a number is bound to it on `/v3/channels/voice`.
     *
     * `signing_secret` is shown here and on `POST /v3/voice/agents/{id}/rotate-secret` only; store
     * it now. With `sandbox: true` the request is validated and the agent reported with `202`;
     * nothing is written.
     */
    fun create(): CompletableFuture<ApiResponseOfVoiceAgent> = create(AgentCreateParams.none())

    /** @see create */
    fun create(
        params: AgentCreateParams = AgentCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent>

    /** @see create */
    fun create(
        params: AgentCreateParams = AgentCreateParams.none()
    ): CompletableFuture<ApiResponseOfVoiceAgent> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<ApiResponseOfVoiceAgent> =
        create(AgentCreateParams.none(), requestOptions)

    /** The agent as stored, without its signing secret. */
    fun retrieve(id: String): CompletableFuture<ApiResponseOfVoiceAgent> =
        retrieve(id, AgentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent> =
        retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent>

    /** @see retrieve */
    fun retrieve(params: AgentRetrieveParams): CompletableFuture<ApiResponseOfVoiceAgent> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfVoiceAgent> =
        retrieve(id, AgentRetrieveParams.none(), requestOptions)

    /**
     * Changes the fields you name and answers with the agent as stored, the same shape `GET`
     * returns.
     *
     * A key left out is left alone. A key sent as `null` clears an optional field (`websocket_url`
     * makes the agent dial in, `greeting` and `fallback` go, `speech`, `audio`, `tools`, `limits`
     * and `transcripts` return to their defaults). A key sent with a value replaces that field
     * whole: send the whole `limits` object, not one of its keys. Changing `session_type` drops
     * `speech`, `audio` and `greeting` unless the body sends them, since the other type cannot
     * carry them. The result is checked like a new agent, and a body that changes nothing is `400`.
     *
     * With `sandbox: true` nothing is written: the request is validated against the stored agent
     * and the agent is reported with `200` as it would read after the change.
     */
    fun update(id: String): CompletableFuture<ApiResponseOfVoiceAgent> =
        update(id, AgentUpdateParams.none())

    /** @see update */
    fun update(
        id: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent> =
        update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    fun update(
        id: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent> = update(id, params, RequestOptions.none())

    /** @see update */
    fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgent>

    /** @see update */
    fun update(params: AgentUpdateParams): CompletableFuture<ApiResponseOfVoiceAgent> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        id: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfVoiceAgent> =
        update(id, AgentUpdateParams.none(), requestOptions)

    /**
     * Your voice agents, newest first. `page` and `page_size` (1 to 100, default 20) page the list.
     * Signing secrets are never listed.
     */
    fun list(): CompletableFuture<AgentListPageAsync> = list(AgentListParams.none())

    /** @see list */
    fun list(
        params: AgentListParams = AgentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AgentListPageAsync>

    /** @see list */
    fun list(
        params: AgentListParams = AgentListParams.none()
    ): CompletableFuture<AgentListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<AgentListPageAsync> =
        list(AgentListParams.none(), requestOptions)

    /**
     * Removes the agent. Calls it already took keep their `agent_id`.
     *
     * An agent that one of your voice numbers routes to, or that another of your agents lists in
     * `transfer_targets`, is not deleted: the answer is `409` with a message naming those numbers
     * and agents. Unbind the numbers (`PATCH /v3/channels/voice/{number}` with `"agent_id": null`),
     * take the agent out of the others' `transfer_targets` or delete them, and try again.
     *
     * With `sandbox: true` nothing is written: the agent is looked up and the answer is the one a
     * real delete would give.
     */
    fun delete(id: String, params: AgentDeleteParams): CompletableFuture<Void?> =
        delete(id, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        id: String,
        params: AgentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> = delete(params.toBuilder().id(id).build(), requestOptions)

    /** @see delete */
    fun delete(params: AgentDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: AgentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * Generates a new `signing_secret` for the agent and returns it. The previous secret stops
     * signing immediately, so update your agent before the next call reaches it.
     *
     * With `sandbox: true` a secret is generated and returned with `202`, and nothing is written.
     */
    fun rotateSecret(
        id: String,
        params: AgentRotateSecretParams,
    ): CompletableFuture<ApiResponseOfVoiceAgentSecret> =
        rotateSecret(id, params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        id: String,
        params: AgentRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgentSecret> =
        rotateSecret(params.toBuilder().id(id).build(), requestOptions)

    /** @see rotateSecret */
    fun rotateSecret(
        params: AgentRotateSecretParams
    ): CompletableFuture<ApiResponseOfVoiceAgentSecret> =
        rotateSecret(params, RequestOptions.none())

    /** @see rotateSecret */
    fun rotateSecret(
        params: AgentRotateSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseOfVoiceAgentSecret>

    /** A view of [AgentServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AgentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/voice/agents`, but is otherwise the same as
         * [AgentServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            create(AgentCreateParams.none())

        /** @see create */
        fun create(
            params: AgentCreateParams = AgentCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>>

        /** @see create */
        fun create(
            params: AgentCreateParams = AgentCreateParams.none()
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            create(AgentCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/voice/agents/{id}`, but is otherwise the same as
         * [AgentServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            retrieve(id, AgentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>>

        /** @see retrieve */
        fun retrieve(
            params: AgentRetrieveParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            retrieve(id, AgentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v3/voice/agents/{id}`, but is otherwise the same
         * as [AgentServiceAsync.update].
         */
        fun update(id: String): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            update(id, AgentUpdateParams.none())

        /** @see update */
        fun update(
            id: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        fun update(
            id: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            update(id, params, RequestOptions.none())

        /** @see update */
        fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>>

        /** @see update */
        fun update(
            params: AgentUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgent>> =
            update(id, AgentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v3/voice/agents`, but is otherwise the same as
         * [AgentServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<AgentListPageAsync>> =
            list(AgentListParams.none())

        /** @see list */
        fun list(
            params: AgentListParams = AgentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AgentListPageAsync>>

        /** @see list */
        fun list(
            params: AgentListParams = AgentListParams.none()
        ): CompletableFuture<HttpResponseFor<AgentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AgentListPageAsync>> =
            list(AgentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/voice/agents/{id}`, but is otherwise the same
         * as [AgentServiceAsync.delete].
         */
        fun delete(id: String, params: AgentDeleteParams): CompletableFuture<HttpResponse> =
            delete(id, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            id: String,
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().id(id).build(), requestOptions)

        /** @see delete */
        fun delete(params: AgentDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /**
         * Returns a raw HTTP response for `post /v3/voice/agents/{id}/rotate-secret`, but is
         * otherwise the same as [AgentServiceAsync.rotateSecret].
         */
        fun rotateSecret(
            id: String,
            params: AgentRotateSecretParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgentSecret>> =
            rotateSecret(id, params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            id: String,
            params: AgentRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgentSecret>> =
            rotateSecret(params.toBuilder().id(id).build(), requestOptions)

        /** @see rotateSecret */
        fun rotateSecret(
            params: AgentRotateSecretParams
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgentSecret>> =
            rotateSecret(params, RequestOptions.none())

        /** @see rotateSecret */
        fun rotateSecret(
            params: AgentRotateSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseOfVoiceAgentSecret>>
    }
}
