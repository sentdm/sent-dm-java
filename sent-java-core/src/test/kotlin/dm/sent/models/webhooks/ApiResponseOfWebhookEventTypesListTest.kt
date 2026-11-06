// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfWebhookEventTypesListTest {

    @Test
    fun create() {
        val apiResponseOfWebhookEventTypesList =
            ApiResponseOfWebhookEventTypesList.builder()
                .data(
                    WebhookEventTypesList.builder()
                        .addEventType(
                            WebhookEventType.builder()
                                .description("description")
                                .displayName("display_name")
                                .eventType("event_type")
                                .isActive(true)
                                .name("name")
                                .subTypes(listOf())
                                .build()
                        )
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

        assertThat(apiResponseOfWebhookEventTypesList.data())
            .contains(
                WebhookEventTypesList.builder()
                    .addEventType(
                        WebhookEventType.builder()
                            .description("description")
                            .displayName("display_name")
                            .eventType("event_type")
                            .isActive(true)
                            .name("name")
                            .subTypes(listOf())
                            .build()
                    )
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
        assertThat(apiResponseOfWebhookEventTypesList.error())
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
        assertThat(apiResponseOfWebhookEventTypesList.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfWebhookEventTypesList.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfWebhookEventTypesList =
            ApiResponseOfWebhookEventTypesList.builder()
                .data(
                    WebhookEventTypesList.builder()
                        .addEventType(
                            WebhookEventType.builder()
                                .description("description")
                                .displayName("display_name")
                                .eventType("event_type")
                                .isActive(true)
                                .name("name")
                                .subTypes(listOf())
                                .build()
                        )
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

        val roundtrippedApiResponseOfWebhookEventTypesList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfWebhookEventTypesList),
                jacksonTypeRef<ApiResponseOfWebhookEventTypesList>(),
            )

        assertThat(roundtrippedApiResponseOfWebhookEventTypesList)
            .isEqualTo(apiResponseOfWebhookEventTypesList)
    }
}
