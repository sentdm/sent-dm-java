// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfCallTest {

    @Test
    fun create() {
        val apiResponseOfCall =
            ApiResponseOfCall.builder()
                .data(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfCall.data())
            .contains(
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
            )
        assertThat(apiResponseOfCall.error())
            .contains(
                ErrorDetail.builder()
                    .code("code")
                    .details(
                        ErrorDetail.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseOfCall.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfCall.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfCall =
            ApiResponseOfCall.builder()
                .data(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfCall =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfCall),
                jacksonTypeRef<ApiResponseOfCall>(),
            )

        assertThat(roundtrippedApiResponseOfCall).isEqualTo(apiResponseOfCall)
    }
}
