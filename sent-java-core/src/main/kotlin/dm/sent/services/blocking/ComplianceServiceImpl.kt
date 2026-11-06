// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

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
import dm.sent.models.compliance.ApiResponseOfComplianceRequirements
import dm.sent.models.compliance.ComplianceRetrieveRequirementsParams
import java.util.function.Consumer

/**
 * What a market demands, before you have it.
 *
 * Requirements vary enormously and change without notice. US `TEN_DLC` registers a brand and a
 * campaign with The Campaign Registry and asks a substantial set of questions; an alphanumeric
 * sender pre-registers with documents in one country and needs nothing in another.
 *
 * This is the authoritative answer for whichever market you ask about, and it is generated from the
 * same declaration that validates the calls themselves — so it cannot drift from what is actually
 * enforced. The response includes the request body to send, with every key that market wants
 * already present and blank.
 *
 * What you supplied, as opposed to what is asked of you, is reported on the market under
 * **Channels**.
 */
class ComplianceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ComplianceService {

    private val withRawResponse: ComplianceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ComplianceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ComplianceService =
        ComplianceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieveRequirements(
        params: ComplianceRetrieveRequirementsParams,
        requestOptions: RequestOptions,
    ): ApiResponseOfComplianceRequirements =
        // get /v3/compliance/requirements
        withRawResponse().retrieveRequirements(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ComplianceService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ComplianceService.WithRawResponse =
            ComplianceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveRequirementsHandler: Handler<ApiResponseOfComplianceRequirements> =
            jsonHandler<ApiResponseOfComplianceRequirements>(clientOptions.jsonMapper)

        override fun retrieveRequirements(
            params: ComplianceRetrieveRequirementsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiResponseOfComplianceRequirements> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v3", "compliance", "requirements")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveRequirementsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
