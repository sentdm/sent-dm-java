// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.channels.whatsapp.WhatsappCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WhatsappServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val whatsappServiceAsync = client.channels().whatsapp()

        val apiResponseOfWhatsappChannelFuture =
            whatsappServiceAsync.create(
                WhatsappCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .phoneNumberId("106540352242922")
                    .wabaId("102290129340398")
                    .build()
            )

        val apiResponseOfWhatsappChannel = apiResponseOfWhatsappChannelFuture.get()
        apiResponseOfWhatsappChannel.validate()
    }
}
