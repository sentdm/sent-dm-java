// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.channels.whatsapp.WhatsappCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WhatsappServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val whatsappService = client.channels().whatsapp()

        val apiResponseOfWhatsappChannel =
            whatsappService.create(
                WhatsappCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .phoneNumberId("106540352242922")
                    .wabaId("102290129340398")
                    .build()
            )

        apiResponseOfWhatsappChannel.validate()
    }
}
