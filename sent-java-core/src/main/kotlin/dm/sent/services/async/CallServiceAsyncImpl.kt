// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.core.ClientOptions
import dm.sent.services.async.calls.ParticipantServiceAsync
import dm.sent.services.async.calls.ParticipantServiceAsyncImpl
import java.util.function.Consumer

class CallServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CallServiceAsync {

    private val withRawResponse: CallServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val participants: ParticipantServiceAsync by lazy {
        ParticipantServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): CallServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallServiceAsync =
        CallServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun participants(): ParticipantServiceAsync = participants

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CallServiceAsync.WithRawResponse {

        private val participants: ParticipantServiceAsync.WithRawResponse by lazy {
            ParticipantServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CallServiceAsync.WithRawResponse =
            CallServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun participants(): ParticipantServiceAsync.WithRawResponse = participants
    }
}
