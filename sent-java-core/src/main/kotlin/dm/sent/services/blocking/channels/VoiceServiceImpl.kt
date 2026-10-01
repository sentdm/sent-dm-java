// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import dm.sent.core.ClientOptions
import dm.sent.core.RequestOptions
import dm.sent.core.checkRequired
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
import kotlin.jvm.optionals.getOrNull

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
class VoiceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VoiceService {

    private val withRawResponse: VoiceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VoiceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceService =
        VoiceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: VoiceCreateParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceNumberCreated =
        // post /v3/channels/voice
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: VoiceRetrieveParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceNumber =
        // get /v3/channels/voice/{number}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: VoiceUpdateParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceNumber =
        // patch /v3/channels/voice/{number}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: VoiceListParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfListOfVoiceNumber =
        // get /v3/channels/voice
        withRawResponse().list(params, requestOptions).parse()

    override fun createToken(
        params: VoiceCreateTokenParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceToken =
        // post /v3/channels/voice/tokens
        withRawResponse().createToken(params, requestOptions).parse()

    override fun rotateSecret(
        params: VoiceRotateSecretParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceSecret =
        // post /v3/channels/voice/{number}/rotate-secret
        withRawResponse().rotateSecret(params, requestOptions).parse()

    override fun test(
        params: VoiceTestParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfVoiceCallbackTest =
        // post /v3/channels/voice/{number}/test
        withRawResponse().test(params, requestOptions).parse()

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

        private val createHandler: Handler<ApiResponseOfVoiceNumberCreated> =
            jsonHandler<ApiResponseOfVoiceNumberCreated>(clientOptions.jsonMapper)

        override fun create(
            params: VoiceCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceNumberCreated> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "voice")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<ApiResponseOfVoiceNumber> =
            jsonHandler<ApiResponseOfVoiceNumber>(clientOptions.jsonMapper)

        override fun retrieve(
            params: VoiceRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceNumber> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("number", params.number().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "voice", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<ApiResponseOfVoiceNumber> =
            jsonHandler<ApiResponseOfVoiceNumber>(clientOptions.jsonMapper)

        override fun update(
            params: VoiceUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceNumber> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("number", params.number().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "voice", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<ApiResponseOfListOfVoiceNumber> =
            jsonHandler<ApiResponseOfListOfVoiceNumber>(clientOptions.jsonMapper)

        override fun list(
            params: VoiceListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfListOfVoiceNumber> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "voice")
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

        private val createTokenHandler: Handler<ApiResponseOfVoiceToken> =
            jsonHandler<ApiResponseOfVoiceToken>(clientOptions.jsonMapper)

        override fun createToken(
            params: VoiceCreateTokenParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceToken> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "voice", "tokens")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createTokenHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val rotateSecretHandler: Handler<ApiResponseOfVoiceSecret> =
            jsonHandler<ApiResponseOfVoiceSecret>(clientOptions.jsonMapper)

        override fun rotateSecret(
            params: VoiceRotateSecretParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceSecret> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("number", params.number().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "channels",
                        "voice",
                        params._pathParam(0),
                        "rotate-secret",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { rotateSecretHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val testHandler: Handler<ApiResponseOfVoiceCallbackTest> =
            jsonHandler<ApiResponseOfVoiceCallbackTest>(clientOptions.jsonMapper)

        override fun test(
            params: VoiceTestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfVoiceCallbackTest> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("number", params.number().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "channels", "voice", params._pathParam(0), "test")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { testHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
