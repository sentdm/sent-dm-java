// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.calls

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
import dm.sent.core.prepare
import dm.sent.models.calls.ApiResponseOfCall
import dm.sent.models.calls.participants.ApiResponseOfListOfCallParticipant
import dm.sent.models.calls.participants.ParticipantAddParams
import dm.sent.models.calls.participants.ParticipantListParams
import dm.sent.models.calls.participants.ParticipantRemoveAllParams
import dm.sent.models.calls.participants.ParticipantRemoveParams
import dm.sent.models.calls.participants.ParticipantUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * Phone calls from the numbers you hold, driven by your own callback URL.
 *
 * `POST /v3/channels/voice` enables a number for calls, with the callback URL Sent asks what to do
 * with each call on it, and `POST /v3/channels/voice/tokens` mints a short-lived token that lets a
 * user of your app place and receive calls as that number. When a call arrives or a caller presses
 * a key, a signed question is POSTed to the callback URL and the answer decides the call; `POST
 * /v3/channels/voice/{number}/test` checks the URL answers the way we need before a real call
 * reaches it, and `POST /v3/channels/voice/{number}/rotate-secret` replaces the signing secret. The
 * call events themselves (`call.completed` and the rest) arrive through your webhooks.
 *
 * Every call is a record under `/v3/calls`: read it, list its recordings once one is ready, hang it
 * up, start or stop recording, and add, mute or remove conference participants while it is live. A
 * leg to a phone number runs for at most what your balance affords at the destination's rate.
 */
class ParticipantServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ParticipantService {

    private val withRawResponse: ParticipantService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ParticipantService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ParticipantService =
        ParticipantServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun update(params: ParticipantUpdateParams, requestOptions: RequestOptions) {
        // patch /v3/calls/{id}/participants/{participantId}
        withRawResponse().update(params, requestOptions)
    }

    override fun list(
        params: ParticipantListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfListOfCallParticipant =
        // get /v3/calls/{id}/participants
        withRawResponse().list(params, requestOptions).parse()

    override fun add(
        params: ParticipantAddParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfCall =
        // post /v3/calls/{id}/participants
        withRawResponse().add(params, requestOptions).parse()

    override fun remove(params: ParticipantRemoveParams, requestOptions: RequestOptions) {
        // delete /v3/calls/{id}/participants/{participantId}
        withRawResponse().remove(params, requestOptions)
    }

    override fun removeAll(params: ParticipantRemoveAllParams, requestOptions: RequestOptions) {
        // delete /v3/calls/{id}/participants
        withRawResponse().removeAll(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ParticipantService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ParticipantService.WithRawResponse =
            ParticipantServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val updateHandler: Handler<Void?> = emptyHandler()

        override fun update(
            params: ParticipantUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("participantId", params.participantId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "calls",
                        params._pathParam(0),
                        "participants",
                        params._pathParam(1),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { updateHandler.handle(it) }
            }
        }

        private val listHandler: Handler<ApiResponseOfListOfCallParticipant> =
            jsonHandler<ApiResponseOfListOfCallParticipant>(clientOptions.jsonMapper)

        override fun list(
            params: ParticipantListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfCallParticipant> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "calls", params._pathParam(0), "participants")
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

        private val addHandler: Handler<ApiResponseOfCall> =
            jsonHandler<ApiResponseOfCall>(clientOptions.jsonMapper)

        override fun add(
            params: ParticipantAddParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfCall> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "calls", params._pathParam(0), "participants")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val removeHandler: Handler<Void?> = emptyHandler()

        override fun remove(
            params: ParticipantRemoveParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("participantId", params.participantId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "calls",
                        params._pathParam(0),
                        "participants",
                        params._pathParam(1),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { removeHandler.handle(it) }
            }
        }

        private val removeAllHandler: Handler<Void?> = emptyHandler()

        override fun removeAll(
            params: ParticipantRemoveAllParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "calls", params._pathParam(0), "participants")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { removeAllHandler.handle(it) }
            }
        }
    }
}
