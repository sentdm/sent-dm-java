// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListResponseTest {

    @Test
    fun create() {
        val webhookListResponse =
            WebhookListResponse.builder()
                .data(
                    WebhookListResponse.Data.builder()
                        .pagination(
                            WebhookListResponse.Data.Pagination.builder()
                                .cursors(
                                    WebhookListResponse.Data.Pagination.Cursors.builder()
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
                        .addWebhook(
                            WebhookListResponse.Data.Webhook.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .consecutiveFailures(0)
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .displayName("display_name")
                                .endpointUrl("endpoint_url")
                                .eventFilters(
                                    WebhookListResponse.Data.Webhook.EventFilters.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .addEventType("string")
                                .isActive(true)
                                .lastDeliveryAttemptAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .lastSuccessfulDeliveryAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .retryCount(0)
                                .signingSecret("signing_secret")
                                .timeoutSeconds(0)
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .error(
                    WebhookListResponse.Error.builder()
                        .code("code")
                        .details(
                            WebhookListResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    WebhookListResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(webhookListResponse.data())
            .contains(
                WebhookListResponse.Data.builder()
                    .pagination(
                        WebhookListResponse.Data.Pagination.builder()
                            .cursors(
                                WebhookListResponse.Data.Pagination.Cursors.builder()
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
                    .addWebhook(
                        WebhookListResponse.Data.Webhook.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .consecutiveFailures(0)
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .displayName("display_name")
                            .endpointUrl("endpoint_url")
                            .eventFilters(
                                WebhookListResponse.Data.Webhook.EventFilters.builder()
                                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                    .build()
                            )
                            .addEventType("string")
                            .isActive(true)
                            .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .lastSuccessfulDeliveryAt(
                                OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                            )
                            .retryCount(0)
                            .signingSecret("signing_secret")
                            .timeoutSeconds(0)
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )
        assertThat(webhookListResponse.error())
            .contains(
                WebhookListResponse.Error.builder()
                    .code("code")
                    .details(
                        WebhookListResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(webhookListResponse.meta())
            .contains(
                WebhookListResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(webhookListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListResponse =
            WebhookListResponse.builder()
                .data(
                    WebhookListResponse.Data.builder()
                        .pagination(
                            WebhookListResponse.Data.Pagination.builder()
                                .cursors(
                                    WebhookListResponse.Data.Pagination.Cursors.builder()
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
                        .addWebhook(
                            WebhookListResponse.Data.Webhook.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .consecutiveFailures(0)
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .displayName("display_name")
                                .endpointUrl("endpoint_url")
                                .eventFilters(
                                    WebhookListResponse.Data.Webhook.EventFilters.builder()
                                        .putAdditionalProperty(
                                            "foo",
                                            JsonValue.from(listOf("string")),
                                        )
                                        .build()
                                )
                                .addEventType("string")
                                .isActive(true)
                                .lastDeliveryAttemptAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .lastSuccessfulDeliveryAt(
                                    OffsetDateTime.parse("2019-12-27T18:11:19.117Z")
                                )
                                .retryCount(0)
                                .signingSecret("signing_secret")
                                .timeoutSeconds(0)
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .error(
                    WebhookListResponse.Error.builder()
                        .code("code")
                        .details(
                            WebhookListResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    WebhookListResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedWebhookListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListResponse),
                jacksonTypeRef<WebhookListResponse>(),
            )

        assertThat(roundtrippedWebhookListResponse).isEqualTo(webhookListResponse)
    }
}
