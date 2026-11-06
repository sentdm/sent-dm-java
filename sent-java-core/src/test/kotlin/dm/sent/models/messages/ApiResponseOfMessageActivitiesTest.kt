// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import dm.sent.models.webhooks.PaginationCursors
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfMessageActivitiesTest {

    @Test
    fun create() {
        val apiResponseOfMessageActivities =
            ApiResponseOfMessageActivities.builder()
                .data(
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
                                    PaginationCursors.builder()
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

        assertThat(apiResponseOfMessageActivities.data())
            .contains(
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
            )
        assertThat(apiResponseOfMessageActivities.error())
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
        assertThat(apiResponseOfMessageActivities.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfMessageActivities.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfMessageActivities =
            ApiResponseOfMessageActivities.builder()
                .data(
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
                                    PaginationCursors.builder()
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

        val roundtrippedApiResponseOfMessageActivities =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfMessageActivities),
                jacksonTypeRef<ApiResponseOfMessageActivities>(),
            )

        assertThat(roundtrippedApiResponseOfMessageActivities)
            .isEqualTo(apiResponseOfMessageActivities)
    }
}
