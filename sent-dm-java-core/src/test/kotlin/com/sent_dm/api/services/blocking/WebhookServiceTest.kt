// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.models.webhooks.WebhookCreateParams
import com.sent_dm.api.models.webhooks.WebhookListEventsParams
import com.sent_dm.api.models.webhooks.WebhookListParams
import com.sent_dm.api.models.webhooks.WebhookRotateSecretParams
import com.sent_dm.api.models.webhooks.WebhookTestParams
import com.sent_dm.api.models.webhooks.WebhookToggleStatusParams
import com.sent_dm.api.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class WebhookServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.create(
                WebhookCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .displayName("Order Notifications")
                    .endpointUrl("https://example.com/webhooks/orders")
                    .addEventType("messages")
                    .addEventType("templates")
                    .retryCount(3)
                    .timeoutSeconds(30)
                    .build()
            )

        apiResponseWebhook.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val apiResponseWebhook = webhookService.retrieve("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")

        apiResponseWebhook.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.update(
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
            )

        apiResponseWebhook.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val webhooks =
            webhookService.list(
                WebhookListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .isActive(true)
                    .search("search")
                    .build()
            )

        webhooks.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        webhookService.delete("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun listEventTypes() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val response = webhookService.listEventTypes()

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun listEvents() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val response =
            webhookService.listEvents(
                WebhookListEventsParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .page(0)
                    .pageSize(0)
                    .search("search")
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun rotateSecret() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val response =
            webhookService.rotateSecret(
                WebhookRotateSecretParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun test() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val response =
            webhookService.test(
                WebhookTestParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .eventType("message.sent")
                    .build()
            )

        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun toggleStatus() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.toggleStatus(
                WebhookToggleStatusParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .isActive(false)
                    .build()
            )

        apiResponseWebhook.validate()
    }
}
