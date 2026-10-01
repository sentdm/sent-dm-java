// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallsListTest {

    @Test
    fun create() {
        val callsList =
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
                            PaginationMeta.Cursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        assertThat(callsList.calls().getOrNull())
            .containsExactly(
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
        assertThat(callsList.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(
                        PaginationMeta.Cursors.builder().after("after").before("before").build()
                    )
                    .hasMore(true)
                    .page(0)
                    .pageSize(0)
                    .totalCount(0)
                    .totalPages(0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callsList =
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
                            PaginationMeta.Cursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        val roundtrippedCallsList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callsList),
                jacksonTypeRef<CallsList>(),
            )

        assertThat(roundtrippedCallsList).isEqualTo(callsList)
    }
}
