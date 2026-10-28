// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCreateParamsTest {

    @Test
    fun create() {
        VoiceCreateParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .agentId(null)
            .areaCode(null)
            .callbackUrl("https://example.com/voice")
            .defaultForAppCalls(false)
            .number("+12125550100")
            .build()
    }

    @Test
    fun headers() {
        val params =
            VoiceCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .agentId(null)
                .areaCode(null)
                .callbackUrl("https://example.com/voice")
                .defaultForAppCalls(false)
                .number("+12125550100")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("Idempotency-Key", "req_abc123_retry1")
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = VoiceCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            VoiceCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .agentId(null)
                .areaCode(null)
                .callbackUrl("https://example.com/voice")
                .defaultForAppCalls(false)
                .number("+12125550100")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.agentId()).isEmpty
        assertThat(body.areaCode()).isEmpty
        assertThat(body.callbackUrl()).contains("https://example.com/voice")
        assertThat(body.defaultForAppCalls()).contains(false)
        assertThat(body.number()).contains("+12125550100")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VoiceCreateParams.builder().build()

        val body = params._body()
    }
}
