// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.calls

import dm.sent.core.ClientOptions
import java.util.function.Consumer

class ParticipantServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ParticipantServiceAsync {

    private val withRawResponse: ParticipantServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ParticipantServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ParticipantServiceAsync =
        ParticipantServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ParticipantServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ParticipantServiceAsync.WithRawResponse =
            ParticipantServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
