// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.channels.ChannelListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ChannelServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val channelServiceAsync = client.channels()

        val apiResponseOfChannelsStateFuture =
            channelServiceAsync.list(
                ChannelListParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfChannelsState = apiResponseOfChannelsStateFuture.get()
        apiResponseOfChannelsState.validate()
    }
}
