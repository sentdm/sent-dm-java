// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import dm.sent.core.JsonValue
import dm.sent.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateParamsTest {

    @Test
    fun create() {
        WebhookCreateParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .displayName("Order Notifications")
            .endpointUrl("https://example.com/webhooks/orders")
            .eventFilters(
                WebhookCreateParams.EventFilters.builder()
                    .putAdditionalProperty("message", JsonValue.from(listOf("delivered", "failed")))
                    .build()
            )
            .addEventType("message")
            .addEventType("templates")
            .retryCount(3)
            .timeoutSeconds(30)
            .build()
    }

    @Test
    fun headers() {
        val params =
            WebhookCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .displayName("Order Notifications")
                .endpointUrl("https://example.com/webhooks/orders")
                .eventFilters(
                    WebhookCreateParams.EventFilters.builder()
                        .putAdditionalProperty(
                            "message",
                            JsonValue.from(listOf("delivered", "failed")),
                        )
                        .build()
                )
                .addEventType("message")
                .addEventType("templates")
                .retryCount(3)
                .timeoutSeconds(30)
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
        val params = WebhookCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            WebhookCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .displayName("Order Notifications")
                .endpointUrl("https://example.com/webhooks/orders")
                .eventFilters(
                    WebhookCreateParams.EventFilters.builder()
                        .putAdditionalProperty(
                            "message",
                            JsonValue.from(listOf("delivered", "failed")),
                        )
                        .build()
                )
                .addEventType("message")
                .addEventType("templates")
                .retryCount(3)
                .timeoutSeconds(30)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.displayName()).contains("Order Notifications")
        assertThat(body.endpointUrl()).contains("https://example.com/webhooks/orders")
        assertThat(body.eventFilters())
            .contains(
                WebhookCreateParams.EventFilters.builder()
                    .putAdditionalProperty("message", JsonValue.from(listOf("delivered", "failed")))
                    .build()
            )
        assertThat(body.eventTypes().getOrNull()).containsExactly("message", "templates")
        assertThat(body.retryCount()).contains(3)
        assertThat(body.timeoutSeconds()).contains(30)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = WebhookCreateParams.builder().build()

        val body = params._body()
    }
}
