// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookRotateSecretParamsTest {

    @Test
    fun create() {
        WebhookRotateSecretParams.builder()
            .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            WebhookRotateSecretParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        assertThat(params._pathParam(0)).isEqualTo("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            WebhookRotateSecretParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            WebhookRotateSecretParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            WebhookRotateSecretParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WebhookRotateSecretParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        val body = params._body()
    }
}
