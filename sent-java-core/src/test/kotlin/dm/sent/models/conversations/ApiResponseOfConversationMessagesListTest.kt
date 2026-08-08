// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfConversationMessagesListTest {

    @Test
    fun create() {
        val apiResponseOfConversationMessagesList =
            ApiResponseOfConversationMessagesList.builder()
                .data(
                    ConversationMessagesList.builder()
                        .addMessage(
                            ConversationMessagesList.Message.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .activeContactPrice(0.0)
                                .channel("channel")
                                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .direction("direction")
                                .addEvent(
                                    ConversationMessagesList.Message.Event.builder()
                                        .status("status")
                                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .description("description")
                                        .build()
                                )
                                .messageBody(
                                    ConversationMessagesList.Message.MessageBody.builder()
                                        .addButton(
                                            ConversationMessagesList.Message.MessageBody.Button
                                                .builder()
                                                .postbackData("postbackData")
                                                .text("text")
                                                .type("type")
                                                .value("value")
                                                .build()
                                        )
                                        .content("content")
                                        .footer("footer")
                                        .header("header")
                                        .build()
                                )
                                .phone("phone")
                                .phoneInternational("phone_international")
                                .price(0.0)
                                .regionCode("region_code")
                                .status("status")
                                .templateCategory("template_category")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
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

        assertThat(apiResponseOfConversationMessagesList.data())
            .contains(
                ConversationMessagesList.builder()
                    .addMessage(
                        ConversationMessagesList.Message.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .activeContactPrice(0.0)
                            .channel("channel")
                            .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .direction("direction")
                            .addEvent(
                                ConversationMessagesList.Message.Event.builder()
                                    .status("status")
                                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                    .description("description")
                                    .build()
                            )
                            .messageBody(
                                ConversationMessagesList.Message.MessageBody.builder()
                                    .addButton(
                                        ConversationMessagesList.Message.MessageBody.Button
                                            .builder()
                                            .postbackData("postbackData")
                                            .text("text")
                                            .type("type")
                                            .value("value")
                                            .build()
                                    )
                                    .content("content")
                                    .footer("footer")
                                    .header("header")
                                    .build()
                            )
                            .phone("phone")
                            .phoneInternational("phone_international")
                            .price(0.0)
                            .regionCode("region_code")
                            .status("status")
                            .templateCategory("template_category")
                            .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .templateName("template_name")
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
        assertThat(apiResponseOfConversationMessagesList.error())
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
        assertThat(apiResponseOfConversationMessagesList.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfConversationMessagesList.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfConversationMessagesList =
            ApiResponseOfConversationMessagesList.builder()
                .data(
                    ConversationMessagesList.builder()
                        .addMessage(
                            ConversationMessagesList.Message.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .activeContactPrice(0.0)
                                .channel("channel")
                                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .direction("direction")
                                .addEvent(
                                    ConversationMessagesList.Message.Event.builder()
                                        .status("status")
                                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                        .description("description")
                                        .build()
                                )
                                .messageBody(
                                    ConversationMessagesList.Message.MessageBody.builder()
                                        .addButton(
                                            ConversationMessagesList.Message.MessageBody.Button
                                                .builder()
                                                .postbackData("postbackData")
                                                .text("text")
                                                .type("type")
                                                .value("value")
                                                .build()
                                        )
                                        .content("content")
                                        .footer("footer")
                                        .header("header")
                                        .build()
                                )
                                .phone("phone")
                                .phoneInternational("phone_international")
                                .price(0.0)
                                .regionCode("region_code")
                                .status("status")
                                .templateCategory("template_category")
                                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .templateName("template_name")
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

        val roundtrippedApiResponseOfConversationMessagesList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfConversationMessagesList),
                jacksonTypeRef<ApiResponseOfConversationMessagesList>(),
            )

        assertThat(roundtrippedApiResponseOfConversationMessagesList)
            .isEqualTo(apiResponseOfConversationMessagesList)
    }
}
