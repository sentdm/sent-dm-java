// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceUpdateParamsTest {

    @Test
    fun create() {
        VoiceUpdateParams.builder()
            .number("+12125550100")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .callbackUrl("https://example.com/voice")
            .defaultForAppCalls(true)
            .status(VoiceUpdateParams.Status.ACTIVE)
            .build()
    }

    @Test
    fun pathParams() {
        val params = VoiceUpdateParams.builder().number("+12125550100").build()

        assertThat(params._pathParam(0)).isEqualTo("+12125550100")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            VoiceUpdateParams.builder()
                .number("+12125550100")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .callbackUrl("https://example.com/voice")
                .defaultForAppCalls(true)
                .status(VoiceUpdateParams.Status.ACTIVE)
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
        val params = VoiceUpdateParams.builder().number("+12125550100").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            VoiceUpdateParams.builder()
                .number("+12125550100")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .callbackUrl("https://example.com/voice")
                .defaultForAppCalls(true)
                .status(VoiceUpdateParams.Status.ACTIVE)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.callbackUrl()).contains("https://example.com/voice")
        assertThat(body.defaultForAppCalls()).contains(true)
        assertThat(body.status()).contains(VoiceUpdateParams.Status.ACTIVE)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VoiceUpdateParams.builder().number("+12125550100").build()

        val body = params._body()
    }
}
