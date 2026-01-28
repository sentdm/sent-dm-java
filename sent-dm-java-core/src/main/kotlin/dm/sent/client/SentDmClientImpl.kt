// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.blocking.ContactService
import dm.sent.services.blocking.ContactServiceImpl
import dm.sent.services.blocking.MessageService
import dm.sent.services.blocking.MessageServiceImpl
import dm.sent.services.blocking.NumberLookupService
import dm.sent.services.blocking.NumberLookupServiceImpl
import dm.sent.services.blocking.OrganizationService
import dm.sent.services.blocking.OrganizationServiceImpl
import dm.sent.services.blocking.TemplateService
import dm.sent.services.blocking.TemplateServiceImpl
import java.util.function.Consumer

class SentDmClientImpl(private val clientOptions: ClientOptions) : SentDmClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: SentDmClientAsync by lazy { SentDmClientAsyncImpl(clientOptions) }

    private val withRawResponse: SentDmClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val templates: TemplateService by lazy {
        TemplateServiceImpl(clientOptionsWithUserAgent)
    }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptionsWithUserAgent) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val numberLookup: NumberLookupService by lazy {
        NumberLookupServiceImpl(clientOptionsWithUserAgent)
    }

    private val organizations: OrganizationService by lazy {
        OrganizationServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): SentDmClientAsync = async

    override fun withRawResponse(): SentDmClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClient =
        SentDmClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun templates(): TemplateService = templates

    override fun contacts(): ContactService = contacts

    override fun messages(): MessageService = messages

    override fun numberLookup(): NumberLookupService = numberLookup

    override fun organizations(): OrganizationService = organizations

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentDmClient.WithRawResponse {

        private val templates: TemplateService.WithRawResponse by lazy {
            TemplateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactService.WithRawResponse by lazy {
            ContactServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val numberLookup: NumberLookupService.WithRawResponse by lazy {
            NumberLookupServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val organizations: OrganizationService.WithRawResponse by lazy {
            OrganizationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentDmClient.WithRawResponse =
            SentDmClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun templates(): TemplateService.WithRawResponse = templates

        override fun contacts(): ContactService.WithRawResponse = contacts

        override fun messages(): MessageService.WithRawResponse = messages

        override fun numberLookup(): NumberLookupService.WithRawResponse = numberLookup

        override fun organizations(): OrganizationService.WithRawResponse = organizations
    }
}
