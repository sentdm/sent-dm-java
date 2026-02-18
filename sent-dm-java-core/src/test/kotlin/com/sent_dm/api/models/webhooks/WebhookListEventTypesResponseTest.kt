// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
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
                            WebhookListEventTypesResponse.Data.EventType.builder()
                                .description("description")
                                .displayName("display_name")
                                .isActive(true)
                                .name("name")
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

        assertThat(webhookListEventTypesResponse.data())
            .contains(
                WebhookListEventTypesResponse.Data.builder()
                    .addEventType(
                        WebhookListEventTypesResponse.Data.EventType.builder()
                            .description("description")
                            .displayName("display_name")
                            .isActive(true)
                            .name("name")
                            .build()
                    )
                    .build()
            )
        assertThat(webhookListEventTypesResponse.error())
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
        assertThat(webhookListEventTypesResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
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
                            WebhookListEventTypesResponse.Data.EventType.builder()
                                .description("description")
                                .displayName("display_name")
                                .isActive(true)
                                .name("name")
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

        val roundtrippedWebhookListEventTypesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookListEventTypesResponse),
                jacksonTypeRef<WebhookListEventTypesResponse>(),
            )

        assertThat(roundtrippedWebhookListEventTypesResponse)
            .isEqualTo(webhookListEventTypesResponse)
    }
}
