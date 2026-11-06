// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.PaginationCursors
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageActivitiesTest {

    @Test
    fun create() {
        val messageActivities =
            MessageActivities.builder()
                .addActivity(
                    MessageActivity.builder()
                        .activeContactPrice("active_contact_price")
                        .description("description")
                        .from("from")
                        .price("price")
                        .reason("reason")
                        .reasonCode("reason_code")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        assertThat(messageActivities.activities().getOrNull())
            .containsExactly(
                MessageActivity.builder()
                    .activeContactPrice("active_contact_price")
                    .description("description")
                    .from("from")
                    .price("price")
                    .reason("reason")
                    .reasonCode("reason_code")
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status("status")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(messageActivities.messageId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageActivities.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(PaginationCursors.builder().after("after").before("before").build())
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
        val messageActivities =
            MessageActivities.builder()
                .addActivity(
                    MessageActivity.builder()
                        .activeContactPrice("active_contact_price")
                        .description("description")
                        .from("from")
                        .price("price")
                        .reason("reason")
                        .reasonCode("reason_code")
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        val roundtrippedMessageActivities =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageActivities),
                jacksonTypeRef<MessageActivities>(),
            )

        assertThat(roundtrippedMessageActivities).isEqualTo(messageActivities)
    }
}
