// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.voice

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.voice.tokens.TokenCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TokenServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tokenService = client.voice().tokens()

        val apiResponseOfVoiceToken =
            tokenService.create(
                TokenCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .identity("agent-42")
                    .number("+12025550123")
                    .ttl(600)
                    .build()
            )

        apiResponseOfVoiceToken.validate()
    }
}
