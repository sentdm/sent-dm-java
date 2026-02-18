// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseWebhookTest {

    @Test
    fun create() {
        val apiResponseWebhook =
            ApiResponseWebhook.builder()
                .data(
                    WebhookResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .addEventType("string")
                        .isActive(true)
                        .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .retryCount(0)
                        .signingSecret("signing_secret")
                        .timeoutSeconds(0)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        assertThat(apiResponseWebhook.data())
            .contains(
                WebhookResponse.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .consecutiveFailures(0)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .displayName("display_name")
                    .endpointUrl("endpoint_url")
                    .addEventType("string")
                    .isActive(true)
                    .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .retryCount(0)
                    .signingSecret("signing_secret")
                    .timeoutSeconds(0)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(apiResponseWebhook.error())
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
        assertThat(apiResponseWebhook.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseWebhook.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseWebhook =
            ApiResponseWebhook.builder()
                .data(
                    WebhookResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .addEventType("string")
                        .isActive(true)
                        .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .retryCount(0)
                        .signingSecret("signing_secret")
                        .timeoutSeconds(0)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        val roundtrippedApiResponseWebhook =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseWebhook),
                jacksonTypeRef<ApiResponseWebhook>(),
            )

        assertThat(roundtrippedApiResponseWebhook).isEqualTo(apiResponseWebhook)
    }
}
