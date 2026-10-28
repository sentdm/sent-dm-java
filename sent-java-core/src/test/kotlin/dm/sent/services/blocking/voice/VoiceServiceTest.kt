// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.voice

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.voice.voices.VoiceListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VoiceServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.voice().voices()

        val apiResponseOfVoiceCatalogue =
            voiceService.list(
                VoiceListParams.builder().xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        apiResponseOfVoiceCatalogue.validate()
    }
}
