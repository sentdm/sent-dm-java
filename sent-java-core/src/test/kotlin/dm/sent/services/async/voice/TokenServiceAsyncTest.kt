// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.voice

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.voice.tokens.TokenCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tokenServiceAsync = client.voice().tokens()

        val apiResponseOfVoiceTokenFuture =
            tokenServiceAsync.create(
                TokenCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .identity("agent-42")
                    .number("+12025550123")
                    .ttl(600)
                    .build()
            )

        val apiResponseOfVoiceToken = apiResponseOfVoiceTokenFuture.get()
        apiResponseOfVoiceToken.validate()
    }
}
