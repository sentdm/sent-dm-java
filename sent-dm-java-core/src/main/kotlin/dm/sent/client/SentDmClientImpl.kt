// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.blocking.ContactService
import dm.sent.services.blocking.ContactServiceImpl
import dm.sent.services.blocking.MeService
import dm.sent.services.blocking.MeServiceImpl
import dm.sent.services.blocking.MessageService
import dm.sent.services.blocking.MessageServiceImpl
import dm.sent.services.blocking.NumberService
import dm.sent.services.blocking.NumberServiceImpl
import dm.sent.services.blocking.ProfileService
import dm.sent.services.blocking.ProfileServiceImpl
import dm.sent.services.blocking.TemplateService
import dm.sent.services.blocking.TemplateServiceImpl
import dm.sent.services.blocking.UserService
import dm.sent.services.blocking.UserServiceImpl
import dm.sent.services.blocking.WebhookService
import dm.sent.services.blocking.WebhookServiceImpl
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

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    private val templates: TemplateService by lazy {
        TemplateServiceImpl(clientOptionsWithUserAgent)
    }

    private val profiles: ProfileService by lazy { ProfileServiceImpl(clientOptionsWithUserAgent) }

    private val numbers: NumberService by lazy { NumberServiceImpl(clientOptionsWithUserAgent) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptionsWithUserAgent) }

    private val me: MeService by lazy { MeServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): SentDmClientAsync = async

    override fun withRawResponse(): SentDmClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClient =
        SentDmClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Configure webhook endpoints for real-time event delivery */
    override fun webhooks(): WebhookService = webhooks

    /** Invite, update, and manage organization users and roles */
    override fun users(): UserService = users

    /** Manage message templates with variable substitution */
    override fun templates(): TemplateService = templates

    /** Manage organization profiles */
    override fun profiles(): ProfileService = profiles

    /** Manage and lookup phone numbers */
    override fun numbers(): NumberService = numbers

    /** Send and track SMS and WhatsApp messages */
    override fun messages(): MessageService = messages

    /** Create, update, and manage customer contact lists */
    override fun contacts(): ContactService = contacts

    /** Retrieve account details */
    override fun me(): MeService = me

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentDmClient.WithRawResponse {

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val templates: TemplateService.WithRawResponse by lazy {
            TemplateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val profiles: ProfileService.WithRawResponse by lazy {
            ProfileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val numbers: NumberService.WithRawResponse by lazy {
            NumberServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactService.WithRawResponse by lazy {
            ContactServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val me: MeService.WithRawResponse by lazy {
            MeServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentDmClient.WithRawResponse =
            SentDmClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Configure webhook endpoints for real-time event delivery */
        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        /** Invite, update, and manage organization users and roles */
        override fun users(): UserService.WithRawResponse = users

        /** Manage message templates with variable substitution */
        override fun templates(): TemplateService.WithRawResponse = templates

        /** Manage organization profiles */
        override fun profiles(): ProfileService.WithRawResponse = profiles

        /** Manage and lookup phone numbers */
        override fun numbers(): NumberService.WithRawResponse = numbers

        /** Send and track SMS and WhatsApp messages */
        override fun messages(): MessageService.WithRawResponse = messages

        /** Create, update, and manage customer contact lists */
        override fun contacts(): ContactService.WithRawResponse = contacts

        /** Retrieve account details */
        override fun me(): MeService.WithRawResponse = me
    }
}
