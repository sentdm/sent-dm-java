// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookEventsListTest {

    @Test
    fun create() {
        val webhookEventsList =
            WebhookEventsList.builder()
                .addEvent(
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
                )
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        assertThat(webhookEventsList.events().getOrNull())
            .containsExactly(
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
            )
        assertThat(webhookEventsList.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(PaginationCursors.builder().after("after").before("before").build())
                    .hasMore(true)
                    .page(0)
                    .pageSize(0)
                    .totalCount(0)
                    .totalPages(0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookEventsList =
            WebhookEventsList.builder()
                .addEvent(
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
                )
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        val roundtrippedWebhookEventsList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookEventsList),
                jacksonTypeRef<WebhookEventsList>(),
            )

        assertThat(roundtrippedWebhookEventsList).isEqualTo(webhookEventsList)
    }
}
