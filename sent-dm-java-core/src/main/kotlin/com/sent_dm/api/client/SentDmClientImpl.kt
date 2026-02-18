// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.client

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.getPackageVersion
import com.sent_dm.api.services.blocking.BrandService
import com.sent_dm.api.services.blocking.BrandServiceImpl
import com.sent_dm.api.services.blocking.ContactService
import com.sent_dm.api.services.blocking.ContactServiceImpl
import com.sent_dm.api.services.blocking.LookupService
import com.sent_dm.api.services.blocking.LookupServiceImpl
import com.sent_dm.api.services.blocking.MeService
import com.sent_dm.api.services.blocking.MeServiceImpl
import com.sent_dm.api.services.blocking.MessageService
import com.sent_dm.api.services.blocking.MessageServiceImpl
import com.sent_dm.api.services.blocking.ProfileService
import com.sent_dm.api.services.blocking.ProfileServiceImpl
import com.sent_dm.api.services.blocking.TemplateService
import com.sent_dm.api.services.blocking.TemplateServiceImpl
import com.sent_dm.api.services.blocking.UserService
import com.sent_dm.api.services.blocking.UserServiceImpl
import com.sent_dm.api.services.blocking.WebhookService
import com.sent_dm.api.services.blocking.WebhookServiceImpl
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

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val lookup: LookupService by lazy { LookupServiceImpl(clientOptionsWithUserAgent) }

    private val contacts: ContactService by lazy { ContactServiceImpl(clientOptionsWithUserAgent) }

    private val brands: BrandService by lazy { BrandServiceImpl(clientOptionsWithUserAgent) }

    private val me: MeService by lazy { MeServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): SentDmClientAsync = async

    override fun withRawResponse(): SentDmClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClient =
        SentDmClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun webhooks(): WebhookService = webhooks

    override fun users(): UserService = users

    override fun templates(): TemplateService = templates

    override fun profiles(): ProfileService = profiles

    override fun messages(): MessageService = messages

    override fun lookup(): LookupService = lookup

    override fun contacts(): ContactService = contacts

    override fun brands(): BrandService = brands

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

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val lookup: LookupService.WithRawResponse by lazy {
            LookupServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactService.WithRawResponse by lazy {
            ContactServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val brands: BrandService.WithRawResponse by lazy {
            BrandServiceImpl.WithRawResponseImpl(clientOptions)
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

        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        override fun users(): UserService.WithRawResponse = users

        override fun templates(): TemplateService.WithRawResponse = templates

        override fun profiles(): ProfileService.WithRawResponse = profiles

        override fun messages(): MessageService.WithRawResponse = messages

        override fun lookup(): LookupService.WithRawResponse = lookup

        override fun contacts(): ContactService.WithRawResponse = contacts

        override fun brands(): BrandService.WithRawResponse = brands

        override fun me(): MeService.WithRawResponse = me
    }
}
