// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking.brands

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.checkRequired
import com.sent_dm.api.core.handlers.emptyHandler
import com.sent_dm.api.core.handlers.errorBodyHandler
import com.sent_dm.api.core.handlers.errorHandler
import com.sent_dm.api.core.handlers.jsonHandler
import com.sent_dm.api.core.http.HttpMethod
import com.sent_dm.api.core.http.HttpRequest
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponse.Handler
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.core.http.json
import com.sent_dm.api.core.http.parseable
import com.sent_dm.api.core.prepare
import com.sent_dm.api.models.brands.campaigns.ApiResponseTcrCampaignWithUseCases
import com.sent_dm.api.models.brands.campaigns.CampaignCreateParams
import com.sent_dm.api.models.brands.campaigns.CampaignDeleteParams
import com.sent_dm.api.models.brands.campaigns.CampaignListParams
import com.sent_dm.api.models.brands.campaigns.CampaignListResponse
import com.sent_dm.api.models.brands.campaigns.CampaignUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CampaignServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CampaignService {

    private val withRawResponse: CampaignService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CampaignService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CampaignService =
        CampaignServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions,
    ): ApiResponseTcrCampaignWithUseCases =
        // post /v3/brands/{brandId}/campaigns
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions,
    ): ApiResponseTcrCampaignWithUseCases =
        // put /v3/brands/{brandId}/campaigns/{campaignId}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: CampaignListParams,
        requestOptions: RequestOptions,
    ): CampaignListResponse =
        // get /v3/brands/{brandId}/campaigns
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: CampaignDeleteParams, requestOptions: RequestOptions) {
        // delete /v3/brands/{brandId}/campaigns/{campaignId}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CampaignService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CampaignService.WithRawResponse =
            CampaignServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ApiResponseTcrCampaignWithUseCases> =
            jsonHandler<ApiResponseTcrCampaignWithUseCases>(clientOptions.jsonMapper)

        override fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "brands", params._pathParam(0), "campaigns")
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

        private val updateHandler: Handler<ApiResponseTcrCampaignWithUseCases> =
            jsonHandler<ApiResponseTcrCampaignWithUseCases>(clientOptions.jsonMapper)

        override fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseTcrCampaignWithUseCases> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("campaignId", params.campaignId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "brands",
                        params._pathParam(0),
                        "campaigns",
                        params._pathParam(1),
                    )
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

        private val listHandler: Handler<CampaignListResponse> =
            jsonHandler<CampaignListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CampaignListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CampaignListResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "brands", params._pathParam(0), "campaigns")
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
            params: CampaignDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("campaignId", params.campaignId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v3",
                        "brands",
                        params._pathParam(0),
                        "campaigns",
                        params._pathParam(1),
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
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
