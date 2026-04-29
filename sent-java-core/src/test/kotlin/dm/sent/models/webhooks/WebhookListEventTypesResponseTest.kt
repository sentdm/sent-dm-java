// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListEventTypesResponseTest {

    @Test
    fun create() {
        val webhookListEventTypesResponse =
            WebhookListEventTypesResponse.builder()
                .data(
                    WebhookListEventTypesResponse.Data.builder()
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

        assertThat(webhookListEventTypesResponse.data())
            .contains(
                WebhookListEventTypesResponse.Data.builder()
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
                    .build()
            )
        assertThat(webhookListEventTypesResponse.error())
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
        assertThat(webhookListEventTypesResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(webhookListEventTypesResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookListEventTypesResponse =
            WebhookListEventTypesResponse.builder()
                .data(
                    WebhookListEventTypesResponse.Data.builder()
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

        val roundtrippedWebhookListEventTypesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListEventTypesResponse),
                jacksonTypeRef<WebhookListEventTypesResponse>(),
            )

        assertThat(roundtrippedWebhookListEventTypesResponse)
            .isEqualTo(webhookListEventTypesResponse)
    }
}
