// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundMessageEventPayloadTest {

    @Test
    fun create() {
        val inboundMessageEventPayload =
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

        assertThat(inboundMessageEventPayload.accountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(inboundMessageEventPayload.channel()).contains("channel")
        assertThat(inboundMessageEventPayload.inboundNumber()).contains("inbound_number")
        assertThat(inboundMessageEventPayload.messageId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(inboundMessageEventPayload.outboundNumber()).contains("outbound_number")
        assertThat(inboundMessageEventPayload.receivedAt()).contains("received_at")
        assertThat(inboundMessageEventPayload.text()).contains("text")
        assertThat(inboundMessageEventPayload.updatedAt()).contains("updated_at")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundMessageEventPayload =
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

        val roundtrippedInboundMessageEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundMessageEventPayload),
                jacksonTypeRef<InboundMessageEventPayload>(),
            )

        assertThat(roundtrippedInboundMessageEventPayload).isEqualTo(inboundMessageEventPayload)
    }
}
