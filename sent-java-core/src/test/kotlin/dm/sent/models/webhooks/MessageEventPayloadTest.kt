// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageEventPayloadTest {

    @Test
    fun create() {
        val messageEventPayload =
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

        assertThat(messageEventPayload.accountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageEventPayload.agentId()).contains("agent_id")
        assertThat(messageEventPayload.channel()).contains("channel")
        assertThat(messageEventPayload.messageId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageEventPayload.messageStatus()).contains("message_status")
        assertThat(messageEventPayload.outboundNumber()).contains("outbound_number")
        assertThat(messageEventPayload.templateId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageEventPayload.templateName()).contains("template_name")
        assertThat(messageEventPayload.updatedAt()).contains("updated_at")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageEventPayload =
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

        val roundtrippedMessageEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageEventPayload),
                jacksonTypeRef<MessageEventPayload>(),
            )

        assertThat(roundtrippedMessageEventPayload).isEqualTo(messageEventPayload)
    }
}
