// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallEventTest {

    @Test
    fun create() {
        val callEvent =
            CallEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    CallEventPayload.builder()
                        .callId("call_id")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .durationSeconds(0)
                        .number("number")
                        .price(0.0)
                        .reason("reason")
                        .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .updatedAt("updated_at")
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        assertThat(callEvent.event()).contains("event")
        assertThat(callEvent.field()).contains("field")
        assertThat(callEvent.payload())
            .contains(
                CallEventPayload.builder()
                    .callId("call_id")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .channel("channel")
                    .durationSeconds(0)
                    .number("number")
                    .price(0.0)
                    .reason("reason")
                    .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .updatedAt("updated_at")
                    .build()
            )
        assertThat(callEvent.requestId()).contains("request_id")
        assertThat(callEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callEvent =
            CallEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    CallEventPayload.builder()
                        .callId("call_id")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .durationSeconds(0)
                        .number("number")
                        .price(0.0)
                        .reason("reason")
                        .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .updatedAt("updated_at")
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        val roundtrippedCallEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callEvent),
                jacksonTypeRef<CallEvent>(),
            )

        assertThat(roundtrippedCallEvent).isEqualTo(callEvent)
    }
}
