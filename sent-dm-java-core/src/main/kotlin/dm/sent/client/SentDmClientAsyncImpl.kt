// File generated from our OpenAPI spec by Stainless.

package dm.sent.client

import dm.sent.core.ClientOptions
import dm.sent.core.getPackageVersion
import dm.sent.services.async.ContactServiceAsync
import dm.sent.services.async.ContactServiceAsyncImpl
import dm.sent.services.async.MessageServiceAsync
import dm.sent.services.async.MessageServiceAsyncImpl
import dm.sent.services.async.NumberLookupServiceAsync
import dm.sent.services.async.NumberLookupServiceAsyncImpl
import dm.sent.services.async.TemplateServiceAsync
import dm.sent.services.async.TemplateServiceAsyncImpl
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

    private val contacts: ContactServiceAsync by lazy {
        ContactServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val templates: TemplateServiceAsync by lazy {
        TemplateServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val numberLookup: NumberLookupServiceAsync by lazy {
        NumberLookupServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): SentDmClient = sync

    override fun withRawResponse(): SentDmClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SentDmClientAsync =
        SentDmClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun contacts(): ContactServiceAsync = contacts

    override fun messages(): MessageServiceAsync = messages

    override fun templates(): TemplateServiceAsync = templates

    override fun numberLookup(): NumberLookupServiceAsync = numberLookup

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SentDmClientAsync.WithRawResponse {

        private val contacts: ContactServiceAsync.WithRawResponse by lazy {
            ContactServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val templates: TemplateServiceAsync.WithRawResponse by lazy {
            TemplateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val numberLookup: NumberLookupServiceAsync.WithRawResponse by lazy {
            NumberLookupServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SentDmClientAsync.WithRawResponse =
            SentDmClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun contacts(): ContactServiceAsync.WithRawResponse = contacts

        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        override fun templates(): TemplateServiceAsync.WithRawResponse = templates

        override fun numberLookup(): NumberLookupServiceAsync.WithRawResponse = numberLookup
    }
}
