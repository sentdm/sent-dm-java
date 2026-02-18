// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

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
import com.sent_dm.api.models.brands.ApiResponseBrandWithKyc
import com.sent_dm.api.models.brands.BrandCreateParams
import com.sent_dm.api.models.brands.BrandDeleteParams
import com.sent_dm.api.models.brands.BrandListParams
import com.sent_dm.api.models.brands.BrandListResponse
import com.sent_dm.api.models.brands.BrandUpdateParams
import com.sent_dm.api.services.blocking.brands.CampaignService
import com.sent_dm.api.services.blocking.brands.CampaignServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class BrandServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BrandService {

    private val withRawResponse: BrandService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val campaigns: CampaignService by lazy { CampaignServiceImpl(clientOptions) }

    override fun withRawResponse(): BrandService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BrandService =
        BrandServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun campaigns(): CampaignService = campaigns

    override fun create(
        params: BrandCreateParams,
        requestOptions: RequestOptions,
    ): ApiResponseBrandWithKyc =
        // post /v3/brands
        withRawResponse().create(params, requestOptions).parse()

    override fun update(
        params: BrandUpdateParams,
        requestOptions: RequestOptions,
    ): ApiResponseBrandWithKyc =
        // put /v3/brands/{brandId}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: BrandListParams, requestOptions: RequestOptions): BrandListResponse =
        // get /v3/brands
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: BrandDeleteParams, requestOptions: RequestOptions) {
        // delete /v3/brands/{brandId}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BrandService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val campaigns: CampaignService.WithRawResponse by lazy {
            CampaignServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BrandService.WithRawResponse =
            BrandServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun campaigns(): CampaignService.WithRawResponse = campaigns

        private val createHandler: Handler<ApiResponseBrandWithKyc> =
            jsonHandler<ApiResponseBrandWithKyc>(clientOptions.jsonMapper)

        override fun create(
            params: BrandCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseBrandWithKyc> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "brands")
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

        private val updateHandler: Handler<ApiResponseBrandWithKyc> =
            jsonHandler<ApiResponseBrandWithKyc>(clientOptions.jsonMapper)

        override fun update(
            params: BrandUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseBrandWithKyc> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "brands", params._pathParam(0))
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

        private val listHandler: Handler<BrandListResponse> =
            jsonHandler<BrandListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: BrandListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "brands")
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
            params: BrandDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "brands", params._pathParam(0))
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
