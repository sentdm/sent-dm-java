// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels.sms

import dm.sent.core.ClientOptions
import java.util.function.Consumer

class TenDlcServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TenDlcService {

    private val withRawResponse: TenDlcService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TenDlcService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TenDlcService =
        TenDlcServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TenDlcService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TenDlcService.WithRawResponse =
            TenDlcServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
