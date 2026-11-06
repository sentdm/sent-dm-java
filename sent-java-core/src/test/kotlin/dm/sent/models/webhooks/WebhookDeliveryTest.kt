// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeliveryTest {

    @Test
    fun create() {
        val webhookDelivery =
            WebhookDelivery.builder()
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
                                .body("body")
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .outboundNumber("outbound_number")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .scheduleReason("schedule_reason")
                                .scheduledAt("scheduled_at")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
                                .updatedAt("updated_at")
                                .build()
                        )
                        .requestId("request_id")
                        .timestamp("timestamp")
                        .build()
                )
                .eventType("event_type")
                .httpStatusCode(0)
                .processingCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .processingStartedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .responseBody("response_body")
                .build()

        assertThat(webhookDelivery.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(webhookDelivery.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookDelivery.deliveryAttempts()).contains(0)
        assertThat(webhookDelivery.deliveryStatus()).contains("delivery_status")
        assertThat(webhookDelivery.errorMessage()).contains("error_message")
        assertThat(webhookDelivery.eventData())
            .contains(
                WebhookDelivery.EventData.ofMessageEvent(
                    MessageEvent.builder()
                        .event("event")
                        .field("field")
                        .payload(
                            MessageEventPayload.builder()
                                .messageStatus("message_status")
                                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .agentId("agent_id")
                                .body("body")
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .outboundNumber("outbound_number")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .scheduleReason("schedule_reason")
                                .scheduledAt("scheduled_at")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
                                .updatedAt("updated_at")
                                .build()
                        )
                        .requestId("request_id")
                        .timestamp("timestamp")
                        .build()
                )
            )
        assertThat(webhookDelivery.eventType()).contains("event_type")
        assertThat(webhookDelivery.httpStatusCode()).contains(0)
        assertThat(webhookDelivery.processingCompletedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookDelivery.processingStartedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookDelivery.responseBody()).contains("response_body")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookDelivery =
            WebhookDelivery.builder()
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
                                .body("body")
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .outboundNumber("outbound_number")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .scheduleReason("schedule_reason")
                                .scheduledAt("scheduled_at")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
                                .updatedAt("updated_at")
                                .build()
                        )
                        .requestId("request_id")
                        .timestamp("timestamp")
                        .build()
                )
                .eventType("event_type")
                .httpStatusCode(0)
                .processingCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .processingStartedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .responseBody("response_body")
                .build()

        val roundtrippedWebhookDelivery =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookDelivery),
                jacksonTypeRef<WebhookDelivery>(),
            )

        assertThat(roundtrippedWebhookDelivery).isEqualTo(webhookDelivery)
    }
}
