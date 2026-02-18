// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.RequestOptions
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponseFor
import com.sent_dm.api.models.brands.ApiResponseBrandWithKyc
import com.sent_dm.api.models.brands.BrandCreateParams
import com.sent_dm.api.models.brands.BrandDeleteParams
import com.sent_dm.api.models.brands.BrandListParams
import com.sent_dm.api.models.brands.BrandListResponse
import com.sent_dm.api.models.brands.BrandUpdateParams
import com.sent_dm.api.services.async.brands.CampaignServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BrandServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BrandServiceAsync

    fun campaigns(): CampaignServiceAsync

    /**
     * Creates a new brand and associated information. This endpoint automatically sets
     * inheritTcrBrand=false when a brand is created.
     */
    fun create(params: BrandCreateParams): CompletableFuture<ApiResponseBrandWithKyc> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: BrandCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseBrandWithKyc>

    /**
     * Updates an existing brand and its associated information. Cannot update brands that have
     * already been submitted to TCR or inherited brands.
     */
    fun update(
        brandId: String,
        params: BrandUpdateParams,
    ): CompletableFuture<ApiResponseBrandWithKyc> = update(brandId, params, RequestOptions.none())

    /** @see update */
    fun update(
        brandId: String,
        params: BrandUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseBrandWithKyc> =
        update(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see update */
    fun update(params: BrandUpdateParams): CompletableFuture<ApiResponseBrandWithKyc> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: BrandUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ApiResponseBrandWithKyc>

    /**
     * Retrieves all brands for the authenticated customer with information in a flattened
     * structure. Includes inherited brands if inheritTcrBrand=true.
     */
    fun list(): CompletableFuture<BrandListResponse> = list(BrandListParams.none())

    /** @see list */
    fun list(
        params: BrandListParams = BrandListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BrandListResponse>

    /** @see list */
    fun list(
        params: BrandListParams = BrandListParams.none()
    ): CompletableFuture<BrandListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<BrandListResponse> =
        list(BrandListParams.none(), requestOptions)

    /** Delete a brand by ID. The brand must belong to the authenticated customer. */
    fun delete(brandId: String): CompletableFuture<Void?> =
        delete(brandId, BrandDeleteParams.none())

    /** @see delete */
    fun delete(
        brandId: String,
        params: BrandDeleteParams = BrandDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see delete */
    fun delete(
        brandId: String,
        params: BrandDeleteParams = BrandDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(brandId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: BrandDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: BrandDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(brandId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(brandId, BrandDeleteParams.none(), requestOptions)

    /** A view of [BrandServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BrandServiceAsync.WithRawResponse

        fun campaigns(): CampaignServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v3/brands`, but is otherwise the same as
         * [BrandServiceAsync.create].
         */
        fun create(
            params: BrandCreateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseBrandWithKyc>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: BrandCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseBrandWithKyc>>

        /**
         * Returns a raw HTTP response for `put /v3/brands/{brandId}`, but is otherwise the same as
         * [BrandServiceAsync.update].
         */
        fun update(
            brandId: String,
            params: BrandUpdateParams,
        ): CompletableFuture<HttpResponseFor<ApiResponseBrandWithKyc>> =
            update(brandId, params, RequestOptions.none())

        /** @see update */
        fun update(
            brandId: String,
            params: BrandUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseBrandWithKyc>> =
            update(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see update */
        fun update(
            params: BrandUpdateParams
        ): CompletableFuture<HttpResponseFor<ApiResponseBrandWithKyc>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: BrandUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ApiResponseBrandWithKyc>>

        /**
         * Returns a raw HTTP response for `get /v3/brands`, but is otherwise the same as
         * [BrandServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<BrandListResponse>> =
            list(BrandListParams.none())

        /** @see list */
        fun list(
            params: BrandListParams = BrandListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BrandListResponse>>

        /** @see list */
        fun list(
            params: BrandListParams = BrandListParams.none()
        ): CompletableFuture<HttpResponseFor<BrandListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BrandListResponse>> =
            list(BrandListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v3/brands/{brandId}`, but is otherwise the same
         * as [BrandServiceAsync.delete].
         */
        fun delete(brandId: String): CompletableFuture<HttpResponse> =
            delete(brandId, BrandDeleteParams.none())

        /** @see delete */
        fun delete(
            brandId: String,
            params: BrandDeleteParams = BrandDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see delete */
        fun delete(
            brandId: String,
            params: BrandDeleteParams = BrandDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(brandId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: BrandDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: BrandDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            brandId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            delete(brandId, BrandDeleteParams.none(), requestOptions)
    }
}
