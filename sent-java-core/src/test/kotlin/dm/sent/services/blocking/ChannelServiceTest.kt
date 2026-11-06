// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.channels.ChannelListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ChannelServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val channelService = client.channels()

        val apiResponseOfChannelsState =
            channelService.list(
                ChannelListParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfChannelsState.validate()
    }
}
