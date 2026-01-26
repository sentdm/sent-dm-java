// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.client

import com.sent_dm.api.core.ClientOptions
import com.sent_dm.api.core.getPackageVersion
import com.sent_dm.api.services.async.ContactServiceAsync
import com.sent_dm.api.services.async.ContactServiceAsyncImpl
import com.sent_dm.api.services.async.MessageServiceAsync
import com.sent_dm.api.services.async.MessageServiceAsyncImpl
import com.sent_dm.api.services.async.NumberLookupServiceAsync
import com.sent_dm.api.services.async.NumberLookupServiceAsyncImpl
import com.sent_dm.api.services.async.OrganizationServiceAsync
import com.sent_dm.api.services.async.OrganizationServiceAsyncImpl
import com.sent_dm.api.services.async.TemplateServiceAsync
import com.sent_dm.api.services.async.TemplateServiceAsyncImpl
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

    private val templates: TemplateServiceAsync by lazy {
        TemplateServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val contacts: ContactServiceAsync by lazy {
        ContactServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val numberLookup: NumberLookupServiceAsync by lazy {
        NumberLookupServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val organizations: OrganizationServiceAsync by lazy {
        OrganizationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): SentDmClient = sync

    override fun withRawResponse(): SentDmClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClientAsync =
        SentDmClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun templates(): TemplateServiceAsync = templates

    override fun contacts(): ContactServiceAsync = contacts

    override fun messages(): MessageServiceAsync = messages

    override fun numberLookup(): NumberLookupServiceAsync = numberLookup

    override fun organizations(): OrganizationServiceAsync = organizations

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentDmClientAsync.WithRawResponse {

        private val templates: TemplateServiceAsync.WithRawResponse by lazy {
            TemplateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val contacts: ContactServiceAsync.WithRawResponse by lazy {
            ContactServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val numberLookup: NumberLookupServiceAsync.WithRawResponse by lazy {
            NumberLookupServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val organizations: OrganizationServiceAsync.WithRawResponse by lazy {
            OrganizationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentDmClientAsync.WithRawResponse =
            SentDmClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun templates(): TemplateServiceAsync.WithRawResponse = templates

        override fun contacts(): ContactServiceAsync.WithRawResponse = contacts

        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        override fun numberLookup(): NumberLookupServiceAsync.WithRawResponse = numberLookup

        override fun organizations(): OrganizationServiceAsync.WithRawResponse = organizations
    }
}
