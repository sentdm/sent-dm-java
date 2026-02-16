// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

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
import dm.sent.models.templates.TemplateCreateParams
import dm.sent.models.templates.TemplateDeleteParams
import dm.sent.models.templates.TemplateListParams
import dm.sent.models.templates.TemplateListResponse
import dm.sent.models.templates.TemplateResponseV2
import dm.sent.models.templates.TemplateRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class TemplateServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TemplateService {

    private val withRawResponse: TemplateService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TemplateService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TemplateService =
        TemplateServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions,
    ): TemplateResponseV2 =
        // post /v2/templates
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions,
    ): TemplateResponseV2 =
        // get /v2/templates/{id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: TemplateListParams,
        requestOptions: RequestOptions,
    ): TemplateListResponse =
        // get /v2/templates
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: TemplateDeleteParams, requestOptions: RequestOptions) {
        // delete /v2/templates/{id}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TemplateService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TemplateService.WithRawResponse =
            TemplateServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<TemplateResponseV2> =
            jsonHandler<TemplateResponseV2>(clientOptions.jsonMapper)

        override fun create(
            params: TemplateCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TemplateResponseV2> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "templates")
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

        private val retrieveHandler: Handler<TemplateResponseV2> =
            jsonHandler<TemplateResponseV2>(clientOptions.jsonMapper)

        override fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TemplateResponseV2> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "templates", params._pathParam(0))
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

        private val listHandler: Handler<TemplateListResponse> =
            jsonHandler<TemplateListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: TemplateListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TemplateListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "templates")
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("id", params.id().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "templates", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }
    }
}
