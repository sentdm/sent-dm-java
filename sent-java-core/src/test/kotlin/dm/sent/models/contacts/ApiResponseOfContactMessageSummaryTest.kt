// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfContactMessageSummaryTest {

    @Test
    fun create() {
        val apiResponseOfContactMessageSummary =
            ApiResponseOfContactMessageSummary.builder()
                .data(
                    ContactMessageSummary.builder()
                        .addChannelScore(
                            ContactMessageSummary.ChannelScore.builder()
                                .channel("channel")
                                .failScore(0)
                                .successScore(0)
                                .build()
                        )
                        .addChannelsUsed("string")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .messageCount(0)
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

        assertThat(apiResponseOfContactMessageSummary.data())
            .contains(
                ContactMessageSummary.builder()
                    .addChannelScore(
                        ContactMessageSummary.ChannelScore.builder()
                            .channel("channel")
                            .failScore(0)
                            .successScore(0)
                            .build()
                    )
                    .addChannelsUsed("string")
                    .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .messageCount(0)
                    .build()
            )
        assertThat(apiResponseOfContactMessageSummary.error())
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
        assertThat(apiResponseOfContactMessageSummary.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfContactMessageSummary.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfContactMessageSummary =
            ApiResponseOfContactMessageSummary.builder()
                .data(
                    ContactMessageSummary.builder()
                        .addChannelScore(
                            ContactMessageSummary.ChannelScore.builder()
                                .channel("channel")
                                .failScore(0)
                                .successScore(0)
                                .build()
                        )
                        .addChannelsUsed("string")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .messageCount(0)
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

        val roundtrippedApiResponseOfContactMessageSummary =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfContactMessageSummary),
                jacksonTypeRef<ApiResponseOfContactMessageSummary>(),
            )

        assertThat(roundtrippedApiResponseOfContactMessageSummary)
            .isEqualTo(apiResponseOfContactMessageSummary)
    }
}
