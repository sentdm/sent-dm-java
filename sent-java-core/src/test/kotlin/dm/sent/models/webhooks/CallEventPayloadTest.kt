// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallEventPayloadTest {

    @Test
    fun create() {
        val callEventPayload =
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

        assertThat(callEventPayload.callId()).isEqualTo("call_id")
        assertThat(callEventPayload.accountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(callEventPayload.channel()).contains("channel")
        assertThat(callEventPayload.durationSeconds()).contains(0)
        assertThat(callEventPayload.number()).contains("number")
        assertThat(callEventPayload.price()).contains(0.0)
        assertThat(callEventPayload.reason()).contains("reason")
        assertThat(callEventPayload.recordingId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(callEventPayload.updatedAt()).contains("updated_at")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callEventPayload =
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

        val roundtrippedCallEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callEventPayload),
                jacksonTypeRef<CallEventPayload>(),
            )

        assertThat(roundtrippedCallEventPayload).isEqualTo(callEventPayload)
    }
}
