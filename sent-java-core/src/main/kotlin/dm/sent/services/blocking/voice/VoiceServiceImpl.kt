// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.voice

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.handlers.errorBodyHandler
import dm.sent.core.handlers.errorHandler
import dm.sent.core.handlers.jsonHandler
import dm.sent.core.http.HttpMethod
import dm.sent.core.http.HttpRequest
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler
import dm.sent.core.http.HttpResponseFor
import dm.sent.core.http.parseable
import dm.sent.core.prepare
import dm.sent.models.voice.voices.ApiResponseOfVoiceCatalogue
import dm.sent.models.voice.voices.VoiceListParams
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
class VoiceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VoiceService {

    private val withRawResponse: VoiceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VoiceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceService =
        VoiceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: VoiceListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceCatalogue =
        // get /v3/voice/voices
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VoiceService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceService.WithRawResponse =
            VoiceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<ApiResponseOfVoiceCatalogue> =
            jsonHandler<ApiResponseOfVoiceCatalogue>(clientOptions.jsonMapper)

        override fun list(
            params: VoiceListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceCatalogue> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "voice", "voices")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
