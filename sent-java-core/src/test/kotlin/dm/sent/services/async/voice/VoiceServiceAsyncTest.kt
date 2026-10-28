// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.voice

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.voice.voices.VoiceListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VoiceServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.voice().voices()

        val apiResponseOfVoiceCatalogueFuture =
            voiceServiceAsync.list(
                VoiceListParams.builder().xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        val apiResponseOfVoiceCatalogue = apiResponseOfVoiceCatalogueFuture.get()
        apiResponseOfVoiceCatalogue.validate()
    }
}
