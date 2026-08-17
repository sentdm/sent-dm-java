// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageEventTest {

    @Test
    fun create() {
        val messageEvent =
            MessageEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    MessageEventPayload.builder()
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .agentId("agent_id")
                        .channel("channel")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .messageStatus("message_status")
                        .outboundNumber("outbound_number")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
                        .updatedAt("updated_at")
                        .build()
                )
                .timestamp("timestamp")
                .build()

        assertThat(messageEvent.event()).contains("event")
        assertThat(messageEvent.field()).contains("field")
        assertThat(messageEvent.payload())
            .contains(
                MessageEventPayload.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .agentId("agent_id")
                    .channel("channel")
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .messageStatus("message_status")
                    .outboundNumber("outbound_number")
                    .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .templateName("template_name")
                    .updatedAt("updated_at")
                    .build()
            )
        assertThat(messageEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageEvent =
            MessageEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    MessageEventPayload.builder()
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .agentId("agent_id")
                        .channel("channel")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .messageStatus("message_status")
                        .outboundNumber("outbound_number")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
                        .updatedAt("updated_at")
                        .build()
                )
                .timestamp("timestamp")
                .build()

        val roundtrippedMessageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageEvent),
                jacksonTypeRef<MessageEvent>(),
            )

        assertThat(roundtrippedMessageEvent).isEqualTo(messageEvent)
    }
}
