// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.async.ContactServiceAsync
import dm.sent.services.async.ContactServiceAsyncImpl
import dm.sent.services.async.MeServiceAsync
import dm.sent.services.async.MeServiceAsyncImpl
import dm.sent.services.async.MessageServiceAsync
import dm.sent.services.async.MessageServiceAsyncImpl
import dm.sent.services.async.NumberServiceAsync
import dm.sent.services.async.NumberServiceAsyncImpl
import dm.sent.services.async.ProfileServiceAsync
import dm.sent.services.async.ProfileServiceAsyncImpl
import dm.sent.services.async.TemplateServiceAsync
import dm.sent.services.async.TemplateServiceAsyncImpl
import dm.sent.services.async.UserServiceAsync
import dm.sent.services.async.UserServiceAsyncImpl
import dm.sent.services.async.WebhookServiceAsync
import dm.sent.services.async.WebhookServiceAsyncImpl
import java.util.function.Consumer

class SentDmClientAsyncImpl(private val clientOptions: ClientOptions) : SentDmClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: SentDmClient by lazy { SentDmClientImpl(clientOptions) }

    private val withRawResponse: SentDmClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val templates: TemplateServiceAsync by lazy {
        TemplateServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val profiles: ProfileServiceAsync by lazy {
        ProfileServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val numbers: NumberServiceAsync by lazy {
        NumberServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val contacts: ContactServiceAsync by lazy {
        ContactServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val me: MeServiceAsync by lazy { MeServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): SentDmClient = sync

    override fun withRawResponse(): SentDmClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClientAsync =
        SentDmClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Configure webhook endpoints for real-time event delivery */
    override fun webhooks(): WebhookServiceAsync = webhooks

    /** Invite, update, and manage organization users and roles */
    override fun users(): UserServiceAsync = users

    /** Manage message templates with variable substitution */
    override fun templates(): TemplateServiceAsync = templates

    /** Manage organization profiles */
    override fun profiles(): ProfileServiceAsync = profiles

    /** Manage and lookup phone numbers */
    override fun numbers(): NumberServiceAsync = numbers

    /** Send and track SMS and WhatsApp messages */
    override fun messages(): MessageServiceAsync = messages

    /** Create, update, and manage customer contact lists */
    override fun contacts(): ContactServiceAsync = contacts

    /** Retrieve account details */
    override fun me(): MeServiceAsync = me

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentDmClientAsync.WithRawResponse {

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val users: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val templates: TemplateServiceAsync.WithRawResponse by lazy {
            TemplateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val profiles: ProfileServiceAsync.WithRawResponse by lazy {
            ProfileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val numbers: NumberServiceAsync.WithRawResponse by lazy {
            NumberServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactServiceAsync.WithRawResponse by lazy {
            ContactServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val me: MeServiceAsync.WithRawResponse by lazy {
            MeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentDmClientAsync.WithRawResponse =
            SentDmClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Configure webhook endpoints for real-time event delivery */
        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        /** Invite, update, and manage organization users and roles */
        override fun users(): UserServiceAsync.WithRawResponse = users

        /** Manage message templates with variable substitution */
        override fun templates(): TemplateServiceAsync.WithRawResponse = templates

        /** Manage organization profiles */
        override fun profiles(): ProfileServiceAsync.WithRawResponse = profiles

        /** Manage and lookup phone numbers */
        override fun numbers(): NumberServiceAsync.WithRawResponse = numbers

        /** Send and track SMS and WhatsApp messages */
        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        /** Create, update, and manage customer contact lists */
        override fun contacts(): ContactServiceAsync.WithRawResponse = contacts

        /** Retrieve account details */
        override fun me(): MeServiceAsync.WithRawResponse = me
    }
}
