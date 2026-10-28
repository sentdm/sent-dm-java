// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallTest {

    @Test
    fun create() {
        val call =
            Call.builder()
                .id("id")
                .agentId("agent_id")
                .answeredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .callerIdUsed("caller_id_used")
                .connectedNumber("connected_number")
                .direction("direction")
                .durationSeconds(0)
                .endedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .failureReason("failure_reason")
                .from(CallParty.builder().kind("kind").value("value").build())
                .addLeg(
                    Call.Leg.builder()
                        .billedMinutes(0)
                        .cost(0.0)
                        .currency("currency")
                        .direction("direction")
                        .number("number")
                        .build()
                )
                .mode("mode")
                .number("number")
                .price(0.0)
                .recordingAvailable(true)
                .startedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .addTimeline(
                    CallTimelineEntry.builder()
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .to(CallParty.builder().kind("kind").value("value").build())
                .build()

        assertThat(call.id()).contains("id")
        assertThat(call.agentId()).contains("agent_id")
        assertThat(call.answeredAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(call.callerIdUsed()).contains("caller_id_used")
        assertThat(call.connectedNumber()).contains("connected_number")
        assertThat(call.direction()).contains("direction")
        assertThat(call.durationSeconds()).contains(0)
        assertThat(call.endedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(call.failureReason()).contains("failure_reason")
        assertThat(call.from()).contains(CallParty.builder().kind("kind").value("value").build())
        assertThat(call.legs().getOrNull())
            .containsExactly(
                Call.Leg.builder()
                    .billedMinutes(0)
                    .cost(0.0)
                    .currency("currency")
                    .direction("direction")
                    .number("number")
                    .build()
            )
        assertThat(call.mode()).contains("mode")
        assertThat(call.number()).contains("number")
        assertThat(call.price()).contains(0.0)
        assertThat(call.recordingAvailable()).contains(true)
        assertThat(call.startedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(call.status()).contains("status")
        assertThat(call.timeline().getOrNull())
            .containsExactly(
                CallTimelineEntry.builder()
                    .status("status")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(call.to()).contains(CallParty.builder().kind("kind").value("value").build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val call =
            Call.builder()
                .id("id")
                .agentId("agent_id")
                .answeredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .callerIdUsed("caller_id_used")
                .connectedNumber("connected_number")
                .direction("direction")
                .durationSeconds(0)
                .endedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .failureReason("failure_reason")
                .from(CallParty.builder().kind("kind").value("value").build())
                .addLeg(
                    Call.Leg.builder()
                        .billedMinutes(0)
                        .cost(0.0)
                        .currency("currency")
                        .direction("direction")
                        .number("number")
                        .build()
                )
                .mode("mode")
                .number("number")
                .price(0.0)
                .recordingAvailable(true)
                .startedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .addTimeline(
                    CallTimelineEntry.builder()
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .to(CallParty.builder().kind("kind").value("value").build())
                .build()

        val roundtrippedCall =
            jsonMapper.readValue(jsonMapper.writeValueAsString(call), jacksonTypeRef<Call>())

        assertThat(roundtrippedCall).isEqualTo(call)
    }
}
