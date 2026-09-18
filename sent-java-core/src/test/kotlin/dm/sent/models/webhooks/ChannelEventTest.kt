// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelEventTest {

    @Test
    fun create() {
        val channelEvent =
            ChannelEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    ChannelEventPayload.builder()
                        .country("country")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .numberType("number_type")
                        .reason("reason")
                        .senderValue("sender_value")
                        .status("status")
                        .updatedAt("updated_at")
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        assertThat(channelEvent.event()).contains("event")
        assertThat(channelEvent.field()).contains("field")
        assertThat(channelEvent.payload())
            .contains(
                ChannelEventPayload.builder()
                    .country("country")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .channel("channel")
                    .numberType("number_type")
                    .reason("reason")
                    .senderValue("sender_value")
                    .status("status")
                    .updatedAt("updated_at")
                    .build()
            )
        assertThat(channelEvent.requestId()).contains("request_id")
        assertThat(channelEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val channelEvent =
            ChannelEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    ChannelEventPayload.builder()
                        .country("country")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .numberType("number_type")
                        .reason("reason")
                        .senderValue("sender_value")
                        .status("status")
                        .updatedAt("updated_at")
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        val roundtrippedChannelEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelEvent),
                jacksonTypeRef<ChannelEvent>(),
            )

        assertThat(roundtrippedChannelEvent).isEqualTo(channelEvent)
    }
}
