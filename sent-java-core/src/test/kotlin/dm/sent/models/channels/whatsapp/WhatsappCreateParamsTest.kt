// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.whatsapp

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WhatsappCreateParamsTest {

    @Test
    fun create() {
        WhatsappCreateParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .phoneNumberId("106540352242922")
            .wabaId("102290129340398")
            .build()
    }

    @Test
    fun headers() {
        val params =
            WhatsappCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .phoneNumberId("106540352242922")
                .wabaId("102290129340398")
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
        val params = WhatsappCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            WhatsappCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .phoneNumberId("106540352242922")
                .wabaId("102290129340398")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.phoneNumberId()).contains("106540352242922")
        assertThat(body.wabaId()).contains("102290129340398")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WhatsappCreateParams.builder().build()

        val body = params._body()
    }
}
