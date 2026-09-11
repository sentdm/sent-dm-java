// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListEventsResponseTest {

    @Test
    fun create() {
        val webhookListEventsResponse =
            WebhookListEventsResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deliveryAttempts(0)
                .deliveryStatus("delivery_status")
                .errorMessage("error_message")
                .eventData(
                    MessageEvent.builder()
                        .event("event")
                        .field("field")
                        .payload(
                            MessageEventPayload.builder()
                                .messageStatus("message_status")
                                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .agentId("agent_id")
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .outboundNumber("outbound_number")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
                                .updatedAt("updated_at")
                                .build()
                        )
                        .timestamp("timestamp")
                        .build()
                )
                .eventType("event_type")
                .httpStatusCode(0)
                .processingCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .processingStartedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .responseBody("response_body")
                .build()

        assertThat(webhookListEventsResponse.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(webhookListEventsResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookListEventsResponse.deliveryAttempts()).contains(0)
        assertThat(webhookListEventsResponse.deliveryStatus()).contains("delivery_status")
        assertThat(webhookListEventsResponse.errorMessage()).contains("error_message")
        assertThat(webhookListEventsResponse.eventData())
            .contains(
                WebhookListEventsResponse.EventData.ofMessageEvent(
                    MessageEvent.builder()
                        .event("event")
                        .field("field")
                        .payload(
                            MessageEventPayload.builder()
                                .messageStatus("message_status")
                                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .agentId("agent_id")
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .outboundNumber("outbound_number")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
                                .updatedAt("updated_at")
                                .build()
                        )
                        .timestamp("timestamp")
                        .build()
                )
            )
        assertThat(webhookListEventsResponse.eventType()).contains("event_type")
        assertThat(webhookListEventsResponse.httpStatusCode()).contains(0)
        assertThat(webhookListEventsResponse.processingCompletedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookListEventsResponse.processingStartedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookListEventsResponse.responseBody()).contains("response_body")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListEventsResponse =
            WebhookListEventsResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deliveryAttempts(0)
                .deliveryStatus("delivery_status")
                .errorMessage("error_message")
                .eventData(
                    MessageEvent.builder()
                        .event("event")
                        .field("field")
                        .payload(
                            MessageEventPayload.builder()
                                .messageStatus("message_status")
                                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .agentId("agent_id")
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .outboundNumber("outbound_number")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
                                .updatedAt("updated_at")
                                .build()
                        )
                        .timestamp("timestamp")
                        .build()
                )
                .eventType("event_type")
                .httpStatusCode(0)
                .processingCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .processingStartedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .responseBody("response_body")
                .build()

        val roundtrippedWebhookListEventsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListEventsResponse),
                jacksonTypeRef<WebhookListEventsResponse>(),
            )

        assertThat(roundtrippedWebhookListEventsResponse).isEqualTo(webhookListEventsResponse)
    }
}
