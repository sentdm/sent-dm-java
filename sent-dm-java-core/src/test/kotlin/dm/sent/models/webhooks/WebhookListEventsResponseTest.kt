// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListEventsResponseTest {

    @Test
    fun create() {
        val webhookListEventsResponse =
            WebhookListEventsResponse.builder()
                .data(
                    WebhookListEventsResponse.Data.builder()
                        .addEvent(
                            WebhookListEventsResponse.Data.Event.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .deliveryAttempts(0)
                                .deliveryStatus("delivery_status")
                                .errorMessage("error_message")
                                .eventData(JsonValue.from(mapOf<String, Any>()))
                                .eventType("event_type")
                                .httpStatusCode(0)
                                .processingCompletedAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .processingStartedAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .responseBody("response_body")
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
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
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
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(webhookListEventsResponse.data())
            .contains(
                WebhookListEventsResponse.Data.builder()
                    .addEvent(
                        WebhookListEventsResponse.Data.Event.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .deliveryAttempts(0)
                            .deliveryStatus("delivery_status")
                            .errorMessage("error_message")
                            .eventData(JsonValue.from(mapOf<String, Any>()))
                            .eventType("event_type")
                            .httpStatusCode(0)
                            .processingCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .processingStartedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .responseBody("response_body")
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
        assertThat(webhookListEventsResponse.error())
            .contains(
                ApiError.builder()
                    .code("code")
                    .details(
                        ApiError.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(webhookListEventsResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(webhookListEventsResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListEventsResponse =
            WebhookListEventsResponse.builder()
                .data(
                    WebhookListEventsResponse.Data.builder()
                        .addEvent(
                            WebhookListEventsResponse.Data.Event.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .deliveryAttempts(0)
                                .deliveryStatus("delivery_status")
                                .errorMessage("error_message")
                                .eventData(JsonValue.from(mapOf<String, Any>()))
                                .eventType("event_type")
                                .httpStatusCode(0)
                                .processingCompletedAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .processingStartedAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .responseBody("response_body")
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
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
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
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedWebhookListEventsResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListEventsResponse),
                jacksonTypeRef<WebhookListEventsResponse>(),
            )

        assertThat(roundtrippedWebhookListEventsResponse).isEqualTo(webhookListEventsResponse)
    }
}
