// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.async.BrandServiceAsync
import dm.sent.services.async.BrandServiceAsyncImpl
import dm.sent.services.async.ContactServiceAsync
import dm.sent.services.async.ContactServiceAsyncImpl
import dm.sent.services.async.LookupServiceAsync
import dm.sent.services.async.LookupServiceAsyncImpl
import dm.sent.services.async.MeServiceAsync
import dm.sent.services.async.MeServiceAsyncImpl
import dm.sent.services.async.MessageServiceAsync
import dm.sent.services.async.MessageServiceAsyncImpl
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

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val lookup: LookupServiceAsync by lazy {
        LookupServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val contacts: ContactServiceAsync by lazy {
        ContactServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val brands: BrandServiceAsync by lazy {
        BrandServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val me: MeServiceAsync by lazy { MeServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): SentDmClient = sync

    override fun withRawResponse(): SentDmClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClientAsync =
        SentDmClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun webhooks(): WebhookServiceAsync = webhooks

    override fun users(): UserServiceAsync = users

    override fun templates(): TemplateServiceAsync = templates

    override fun profiles(): ProfileServiceAsync = profiles

    override fun messages(): MessageServiceAsync = messages

    override fun lookup(): LookupServiceAsync = lookup

    override fun contacts(): ContactServiceAsync = contacts

    override fun brands(): BrandServiceAsync = brands

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

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val lookup: LookupServiceAsync.WithRawResponse by lazy {
            LookupServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactServiceAsync.WithRawResponse by lazy {
            ContactServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val brands: BrandServiceAsync.WithRawResponse by lazy {
            BrandServiceAsyncImpl.WithRawResponseImpl(clientOptions)
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

        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        override fun users(): UserServiceAsync.WithRawResponse = users

        override fun templates(): TemplateServiceAsync.WithRawResponse = templates

        override fun profiles(): ProfileServiceAsync.WithRawResponse = profiles

        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        override fun lookup(): LookupServiceAsync.WithRawResponse = lookup

        override fun contacts(): ContactServiceAsync.WithRawResponse = contacts

        override fun brands(): BrandServiceAsync.WithRawResponse = brands

        override fun me(): MeServiceAsync.WithRawResponse = me
    }
}
