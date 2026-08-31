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
import dm.sent.models.profiles.ProfileCompleteParams
import dm.sent.models.profiles.ProfileCompleteResponse
import dm.sent.models.profiles.ProfileCreateParams
import dm.sent.models.profiles.ProfileCreateResponse
import dm.sent.models.profiles.ProfileDeleteParams
import dm.sent.models.profiles.ProfileListParams
import dm.sent.models.profiles.ProfileListResponse
import dm.sent.models.profiles.ProfileRetrieveParams
import dm.sent.models.profiles.ProfileRetrieveResponse
import dm.sent.models.profiles.ProfileUpdateParams
import dm.sent.models.profiles.ProfileUpdateResponse
import dm.sent.services.blocking.profiles.CampaignService
import dm.sent.services.blocking.profiles.CampaignServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/**
 * **Deprecated — use Sender Profiles.**
 *
 * The original profile resource, kept because it has live callers. It still works, and its
 * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
 * instead of across three.
 *
 * New integrations should not start here.
 */
class ProfileServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ProfileService {

    private val withRawResponse: ProfileService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val campaigns: CampaignService by lazy { CampaignServiceImpl(clientOptions) }

    override fun withRawResponse(): ProfileService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ProfileService =
        ProfileServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * **Deprecated — use Sender Profiles.**
     *
     * The original profile resource, kept because it has live callers. It still works, and its
     * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one call
     * instead of across three.
     *
     * New integrations should not start here.
     */
    override fun campaigns(): CampaignService = campaigns

    @Deprecated("deprecated")
    override fun create(
        params: ProfileCreateParams,
        requestOptions: RequestOptions,
    ): ProfileCreateResponse =
        // post /v3/profiles
        withRawResponse().create(params, requestOptions).parse()

    @Deprecated("deprecated")
    override fun retrieve(
        params: ProfileRetrieveParams,
        requestOptions: RequestOptions,
    ): ProfileRetrieveResponse =
        // get /v3/profiles/{profileId}
        withRawResponse().retrieve(params, requestOptions).parse()

    @Deprecated("deprecated")
    override fun update(
        params: ProfileUpdateParams,
        requestOptions: RequestOptions,
    ): ProfileUpdateResponse =
        // patch /v3/profiles/{profileId}
        withRawResponse().update(params, requestOptions).parse()

    @Deprecated("deprecated")
    override fun list(
        params: ProfileListParams,
        requestOptions: RequestOptions,
    ): ProfileListResponse =
        // get /v3/profiles
        withRawResponse().list(params, requestOptions).parse()

    @Deprecated("deprecated")
    override fun delete(params: ProfileDeleteParams, requestOptions: RequestOptions) {
        // delete /v3/profiles/{profileId}
        withRawResponse().delete(params, requestOptions)
    }

    @Deprecated("deprecated")
    override fun complete(
        params: ProfileCompleteParams,
        requestOptions: RequestOptions,
    ): ProfileCompleteResponse =
        // post /v3/profiles/{profileId}/complete
        withRawResponse().complete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProfileService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val campaigns: CampaignService.WithRawResponse by lazy {
            CampaignServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ProfileService.WithRawResponse =
            ProfileServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * **Deprecated — use Sender Profiles.**
         *
         * The original profile resource, kept because it has live callers. It still works, and its
         * replacement is `/v3/sender-profiles`, which takes the identity and the campaign in one
         * call instead of across three.
         *
         * New integrations should not start here.
         */
        override fun campaigns(): CampaignService.WithRawResponse = campaigns

        private val createHandler: Handler<ProfileCreateResponse> =
            jsonHandler<ProfileCreateResponse>(clientOptions.jsonMapper)

        @Deprecated("deprecated")
        override fun create(
            params: ProfileCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles")
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

        private val retrieveHandler: Handler<ProfileRetrieveResponse> =
            jsonHandler<ProfileRetrieveResponse>(clientOptions.jsonMapper)

        @Deprecated("deprecated")
        override fun retrieve(
            params: ProfileRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("profileId", params.profileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0))
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

        private val updateHandler: Handler<ProfileUpdateResponse> =
            jsonHandler<ProfileUpdateResponse>(clientOptions.jsonMapper)

        @Deprecated("deprecated")
        override fun update(
            params: ProfileUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("profileId", params.profileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0))
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

        private val listHandler: Handler<ProfileListResponse> =
            jsonHandler<ProfileListResponse>(clientOptions.jsonMapper)

        @Deprecated("deprecated")
        override fun list(
            params: ProfileListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles")
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

        @Deprecated("deprecated")
        override fun delete(
            params: ProfileDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("profileId", params.profileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val completeHandler: Handler<ProfileCompleteResponse> =
            jsonHandler<ProfileCompleteResponse>(clientOptions.jsonMapper)

        @Deprecated("deprecated")
        override fun complete(
            params: ProfileCompleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProfileCompleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("profileId", params.profileId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "profiles", params._pathParam(0), "complete")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { completeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
