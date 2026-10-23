// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.core.ClientOptions
import dm.sent.services.blocking.calls.ParticipantService
import dm.sent.services.blocking.calls.ParticipantServiceImpl
import java.util.function.Consumer

class CallServiceImpl internal constructor(private val clientOptions: ClientOptions) : CallService {

    private val withRawResponse: CallService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val participants: ParticipantService by lazy { ParticipantServiceImpl(clientOptions) }

    override fun withRawResponse(): CallService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallService =
        CallServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun participants(): ParticipantService = participants

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CallService.WithRawResponse {

        private val participants: ParticipantService.WithRawResponse by lazy {
            ParticipantServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CallService.WithRawResponse =
            CallServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun participants(): ParticipantService.WithRawResponse = participants
    }
}
