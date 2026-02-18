// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRetrieveActivitiesResponseTest {

    @Test
    fun create() {
        val messageRetrieveActivitiesResponse =
            MessageRetrieveActivitiesResponse.builder()
                .data(
                    MessageRetrieveActivitiesResponse.Data.builder()
                        .addActivity(
                            MessageRetrieveActivitiesResponse.Data.Activity.builder()
                                .content("content")
                                .description("description")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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

        assertThat(messageRetrieveActivitiesResponse.data())
            .contains(
                MessageRetrieveActivitiesResponse.Data.builder()
                    .addActivity(
                        MessageRetrieveActivitiesResponse.Data.Activity.builder()
                            .content("content")
                            .description("description")
                            .status("status")
                            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(messageRetrieveActivitiesResponse.error())
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
        assertThat(messageRetrieveActivitiesResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(messageRetrieveActivitiesResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageRetrieveActivitiesResponse =
            MessageRetrieveActivitiesResponse.builder()
                .data(
                    MessageRetrieveActivitiesResponse.Data.builder()
                        .addActivity(
                            MessageRetrieveActivitiesResponse.Data.Activity.builder()
                                .content("content")
                                .description("description")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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

        val roundtrippedMessageRetrieveActivitiesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRetrieveActivitiesResponse),
                jacksonTypeRef<MessageRetrieveActivitiesResponse>(),
            )

        assertThat(roundtrippedMessageRetrieveActivitiesResponse)
            .isEqualTo(messageRetrieveActivitiesResponse)
    }
}
