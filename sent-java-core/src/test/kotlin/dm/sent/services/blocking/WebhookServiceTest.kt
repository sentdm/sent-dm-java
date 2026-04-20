// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.JsonValue
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

internal class WebhookServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.create(
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
            )

        apiResponseWebhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.retrieve(
                WebhookRetrieveParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseWebhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.update(
                WebhookUpdateParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .displayName("Updated Order Notifications")
                    .endpointUrl("https://example.com/webhooks/orders-v2")
                    .eventFilters(
                        WebhookUpdateParams.EventFilters.builder()
                            .putAdditionalProperty(
                                "message",
                                JsonValue.from(listOf("delivered", "failed")),
                            )
                            .build()
                    )
                    .addEventType("message")
                    .addEventType("templates")
                    .retryCount(5)
                    .timeoutSeconds(60)
                    .build()
            )

        apiResponseWebhook.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val webhooks =
            webhookService.list(
                WebhookListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .isActive(true)
                    .search("search")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        webhooks.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        webhookService.delete(
            WebhookDeleteParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listEventTypes() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response =
            webhookService.listEventTypes(
                WebhookListEventTypesParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listEvents() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response =
            webhookService.listEvents(
                WebhookListEventsParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .page(0)
                    .pageSize(0)
                    .search("search")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rotateSecret() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response =
            webhookService.rotateSecret(
                WebhookRotateSecretParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun test() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val response =
            webhookService.test(
                WebhookTestParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .eventType("message.sent")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun toggleStatus() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val webhookService = client.webhooks()

        val apiResponseWebhook =
            webhookService.toggleStatus(
                WebhookToggleStatusParams.builder()
                    .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .isActive(false)
                    .build()
            )

        apiResponseWebhook.validate()
    }
}
