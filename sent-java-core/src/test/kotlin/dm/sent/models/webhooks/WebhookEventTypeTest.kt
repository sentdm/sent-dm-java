// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEventTypeTest {

    @Test
    fun create() {
        val webhookEventType =
            WebhookEventType.builder()
                .description("description")
                .displayName("display_name")
                .eventType("event_type")
                .isActive(true)
                .name("name")
                .subTypes(listOf())
                .build()

        assertThat(webhookEventType.description()).contains("description")
        assertThat(webhookEventType.displayName()).contains("display_name")
        assertThat(webhookEventType.eventType()).contains("event_type")
        assertThat(webhookEventType.isActive()).contains(true)
        assertThat(webhookEventType.name()).contains("name")
        assertThat(webhookEventType.subTypes().getOrNull()).containsExactly()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEventType =
            WebhookEventType.builder()
                .description("description")
                .displayName("display_name")
                .eventType("event_type")
                .isActive(true)
                .name("name")
                .subTypes(listOf())
                .build()

        val roundtrippedWebhookEventType =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEventType),
                jacksonTypeRef<WebhookEventType>(),
            )

        assertThat(roundtrippedWebhookEventType).isEqualTo(webhookEventType)
    }
}
