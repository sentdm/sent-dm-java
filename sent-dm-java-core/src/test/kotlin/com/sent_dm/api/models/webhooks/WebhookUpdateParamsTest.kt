// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.sent_dm.api.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookUpdateParamsTest {

    @Test
    fun create() {
        WebhookUpdateParams.builder()
            .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .displayName("Updated Order Notifications")
            .endpointUrl("https://example.com/webhooks/orders-v2")
            .addEventType("messages")
            .addEventType("templates")
            .retryCount(5)
            .timeoutSeconds(60)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            WebhookUpdateParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        assertThat(params._pathParam(0)).isEqualTo("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            WebhookUpdateParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .displayName("Updated Order Notifications")
                .endpointUrl("https://example.com/webhooks/orders-v2")
                .addEventType("messages")
                .addEventType("templates")
                .retryCount(5)
                .timeoutSeconds(60)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            WebhookUpdateParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            WebhookUpdateParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .displayName("Updated Order Notifications")
                .endpointUrl("https://example.com/webhooks/orders-v2")
                .addEventType("messages")
                .addEventType("templates")
                .retryCount(5)
                .timeoutSeconds(60)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.displayName()).contains("Updated Order Notifications")
        assertThat(body.endpointUrl()).contains("https://example.com/webhooks/orders-v2")
        assertThat(body.eventTypes().getOrNull()).containsExactly("messages", "templates")
        assertThat(body.retryCount()).contains(5)
        assertThat(body.timeoutSeconds()).contains(60)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            WebhookUpdateParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        val body = params._body()
    }
}
