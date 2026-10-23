// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.calls

import dm.sent.core.ClientOptions
import java.util.function.Consumer

class ParticipantServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ParticipantService {

    private val withRawResponse: ParticipantService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ParticipantService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ParticipantService =
        ParticipantServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ParticipantService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ParticipantService.WithRawResponse =
            ParticipantServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
