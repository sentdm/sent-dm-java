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
            .callbackUrl("https://example.com/voice")
            .areaCode(null)
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
                .callbackUrl("https://example.com/voice")
                .areaCode(null)
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
        val params = VoiceCreateParams.builder().callbackUrl("https://example.com/voice").build()

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
                .callbackUrl("https://example.com/voice")
                .areaCode(null)
                .defaultForAppCalls(false)
                .number("+12125550100")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.callbackUrl()).isEqualTo("https://example.com/voice")
        assertThat(body.areaCode()).isEmpty
        assertThat(body.defaultForAppCalls()).contains(false)
        assertThat(body.number()).contains("+12125550100")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VoiceCreateParams.builder().callbackUrl("https://example.com/voice").build()

        val body = params._body()

        assertThat(body.callbackUrl()).isEqualTo("https://example.com/voice")
    }
}
