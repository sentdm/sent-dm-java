// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCreateTokenParamsTest {

    @Test
    fun create() {
        VoiceCreateTokenParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .identity("agent-42")
            .number("+12025550123")
            .ttl(600)
            .build()
    }

    @Test
    fun headers() {
        val params =
            VoiceCreateTokenParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .identity("agent-42")
                .number("+12025550123")
                .ttl(600)
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
        val params = VoiceCreateTokenParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            VoiceCreateTokenParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .identity("agent-42")
                .number("+12025550123")
                .ttl(600)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.identity()).contains("agent-42")
        assertThat(body.number()).contains("+12025550123")
        assertThat(body.ttl()).contains(600)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = VoiceCreateTokenParams.builder().build()

        val body = params._body()
    }
}
