// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundMessageEventTest {

    @Test
    fun create() {
        val inboundMessageEvent =
            InboundMessageEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    InboundMessageEventPayload.builder()
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .inboundNumber("inbound_number")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .outboundNumber("outbound_number")
                        .receivedAt("received_at")
                        .text("text")
                        .updatedAt("updated_at")
                        .build()
                )
                .timestamp("timestamp")
                .build()

        assertThat(inboundMessageEvent.event()).contains("event")
        assertThat(inboundMessageEvent.field()).contains("field")
        assertThat(inboundMessageEvent.payload())
            .contains(
                InboundMessageEventPayload.builder()
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .channel("channel")
                    .inboundNumber("inbound_number")
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .outboundNumber("outbound_number")
                    .receivedAt("received_at")
                    .text("text")
                    .updatedAt("updated_at")
                    .build()
            )
        assertThat(inboundMessageEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundMessageEvent =
            InboundMessageEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    InboundMessageEventPayload.builder()
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .inboundNumber("inbound_number")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .outboundNumber("outbound_number")
                        .receivedAt("received_at")
                        .text("text")
                        .updatedAt("updated_at")
                        .build()
                )
                .timestamp("timestamp")
                .build()

        val roundtrippedInboundMessageEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundMessageEvent),
                jacksonTypeRef<InboundMessageEvent>(),
            )

        assertThat(roundtrippedInboundMessageEvent).isEqualTo(inboundMessageEvent)
    }
}
