// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfCallsListTest {

    @Test
    fun create() {
        val apiResponseOfCallsList =
            ApiResponseOfCallsList.builder()
                .data(
                    CallsList.builder()
                        .addCall(
                            Call.builder()
                                .id("id")
                                .answeredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .direction("direction")
                                .durationSeconds(0)
                                .endedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .failureReason("failure_reason")
                                .from(CallParty.builder().kind("kind").value("value").build())
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
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
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

        assertThat(apiResponseOfCallsList.data())
            .contains(
                CallsList.builder()
                    .addCall(
                        Call.builder()
                            .id("id")
                            .answeredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .direction("direction")
                            .durationSeconds(0)
                            .endedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .failureReason("failure_reason")
                            .from(CallParty.builder().kind("kind").value("value").build())
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
                    .pagination(
                        PaginationMeta.builder()
                            .cursors(
                                PaginationMeta.Cursors.builder()
                                    .after("after")
                                    .before("before")
                                    .build()
                            )
                            .hasMore(true)
                            .page(0)
                            .pageSize(0)
                            .totalCount(0)
                            .totalPages(0)
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfCallsList.error())
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
        assertThat(apiResponseOfCallsList.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfCallsList.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfCallsList =
            ApiResponseOfCallsList.builder()
                .data(
                    CallsList.builder()
                        .addCall(
                            Call.builder()
                                .id("id")
                                .answeredAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .direction("direction")
                                .durationSeconds(0)
                                .endedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .failureReason("failure_reason")
                                .from(CallParty.builder().kind("kind").value("value").build())
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
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
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

        val roundtrippedApiResponseOfCallsList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfCallsList),
                jacksonTypeRef<ApiResponseOfCallsList>(),
            )

        assertThat(roundtrippedApiResponseOfCallsList).isEqualTo(apiResponseOfCallsList)
    }
}
