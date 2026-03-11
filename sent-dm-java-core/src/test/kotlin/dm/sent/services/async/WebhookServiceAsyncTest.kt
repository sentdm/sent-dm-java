// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.webhooks.WebhookCreateParams
import dm.sent.models.webhooks.WebhookDeleteParams
import dm.sent.models.webhooks.WebhookListEventTypesParams
import dm.sent.models.webhooks.WebhookListEventsParams
import dm.sent.models.webhooks.WebhookListParams
import dm.sent.models.webhooks.WebhookRetrieveParams
import dm.sent.models.webhooks.WebhookRotateSecretParams
import dm.sent.models.webhooks.WebhookTestParams
import dm.sent.models.webhooks.WebhookToggleStatusParams
import dm.sent.models.webhooks.WebhookUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WebhookServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val apiResponseWebhookFuture =
            webhookServiceAsync.create(
                WebhookCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .displayName("Order Notifications")
                    .endpointUrl("https://example.com/webhooks/orders")
                    .addEventType("messages")
                    .addEventType("templates")
                    .retryCount(3)
                    .timeoutSeconds(30)
                    .build()
            )

        val apiResponseWebhook = apiResponseWebhookFuture.get()
        apiResponseWebhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val apiResponseWebhookFuture =
            webhookServiceAsync.retrieve(
                WebhookRetrieveParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseWebhook = apiResponseWebhookFuture.get()
        apiResponseWebhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val apiResponseWebhookFuture =
            webhookServiceAsync.update(
                WebhookUpdateParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .displayName("Updated Order Notifications")
                    .endpointUrl("https://example.com/webhooks/orders-v2")
                    .addEventType("messages")
                    .addEventType("templates")
                    .retryCount(5)
                    .timeoutSeconds(60)
                    .build()
            )

        val apiResponseWebhook = apiResponseWebhookFuture.get()
        apiResponseWebhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val webhooksFuture =
            webhookServiceAsync.list(
                WebhookListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .isActive(true)
                    .search("search")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val webhooks = webhooksFuture.get()
        webhooks.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val future =
            webhookServiceAsync.delete(
                WebhookDeleteParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listEventTypes() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture =
            webhookServiceAsync.listEventTypes(
                WebhookListEventTypesParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listEvents() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture =
            webhookServiceAsync.listEvents(
                WebhookListEventsParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .page(0)
                    .pageSize(0)
                    .search("search")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rotateSecret() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture =
            webhookServiceAsync.rotateSecret(
                WebhookRotateSecretParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun test() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val responseFuture =
            webhookServiceAsync.test(
                WebhookTestParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .eventType("message.sent")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun toggleStatus() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.webhooks()

        val apiResponseWebhookFuture =
            webhookServiceAsync.toggleStatus(
                WebhookToggleStatusParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .isActive(false)
                    .build()
            )

        val apiResponseWebhook = apiResponseWebhookFuture.get()
        apiResponseWebhook.validate()
    }
}
