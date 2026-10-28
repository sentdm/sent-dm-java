// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.voice

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.checkRequired
import dm.sent.core.handlers.emptyHandler
import dm.sent.core.handlers.errorBodyHandler
import dm.sent.core.handlers.errorHandler
import dm.sent.core.handlers.jsonHandler
import dm.sent.core.http.HttpMethod
import dm.sent.core.http.HttpRequest
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler
import dm.sent.core.http.HttpResponseFor
import dm.sent.core.http.json
import dm.sent.core.http.parseable
import dm.sent.core.prepareAsync
import dm.sent.models.voice.calls.ApiResponseOfCall
import dm.sent.models.voice.calls.ApiResponseOfCallRecordings
import dm.sent.models.voice.calls.ApiResponseOfCallsList
import dm.sent.models.voice.calls.CallHangupParams
import dm.sent.models.voice.calls.CallListPageAsync
import dm.sent.models.voice.calls.CallListParams
import dm.sent.models.voice.calls.CallListRecordingsParams
import dm.sent.models.voice.calls.CallRecordParams
import dm.sent.models.voice.calls.CallRetrieveParams
import dm.sent.services.async.voice.calls.ParticipantServiceAsync
import dm.sent.services.async.voice.calls.ParticipantServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

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
class CallServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CallServiceAsync {

    private val withRawResponse: CallServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val participants: ParticipantServiceAsync by lazy {
        ParticipantServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): CallServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallServiceAsync =
        CallServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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
    override fun participants(): ParticipantServiceAsync = participants

    override fun retrieve(
        params: CallRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfCall> =
        // get /v3/voice/calls/{id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: CallListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CallListPageAsync> =
        // get /v3/voice/calls
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun hangup(
        params: CallHangupParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /v3/voice/calls/{id}/hangup
        withRawResponse().hangup(params, requestOptions).thenAccept {}

    override fun listRecordings(
        params: CallListRecordingsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ApiResponseOfCallRecordings> =
        // get /v3/voice/calls/{id}/recordings
        withRawResponse().listRecordings(params, requestOptions).thenApply { it.parse() }

    override fun record(
        params: CallRecordParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /v3/voice/calls/{id}/recordings
        withRawResponse().record(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CallServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val participants: ParticipantServiceAsync.WithRawResponse by lazy {
            ParticipantServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CallServiceAsync.WithRawResponse =
            CallServiceAsyncImpl.WithRawResponseImpl(
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
        override fun participants(): ParticipantServiceAsync.WithRawResponse = participants

        private val retrieveHandler: Handler<ApiResponseOfCall> =
            jsonHandler<ApiResponseOfCall>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CallRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCall>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "voice", "calls", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ApiResponseOfCallsList> =
            jsonHandler<ApiResponseOfCallsList>(clientOptions.jsonMapper)

        override fun list(
            params: CallListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CallListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "voice", "calls")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                CallListPageAsync.builder()
                                    .service(CallServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val hangupHandler: Handler<Void?> = emptyHandler()

        override fun hangup(
            params: CallHangupParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "voice", "calls", params._pathParam(0), "hangup")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { hangupHandler.handle(it) }
                    }
                }
        }

        private val listRecordingsHandler: Handler<ApiResponseOfCallRecordings> =
            jsonHandler<ApiResponseOfCallRecordings>(clientOptions.jsonMapper)

        override fun listRecordings(
            params: CallListRecordingsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ApiResponseOfCallRecordings>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "voice", "calls", params._pathParam(0), "recordings")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listRecordingsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val recordHandler: Handler<Void?> = emptyHandler()

        override fun record(
            params: CallRecordParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "voice", "calls", params._pathParam(0), "recordings")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { recordHandler.handle(it) }
                    }
                }
        }
    }
}
