// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationMessagesListTest {

    @Test
    fun create() {
        val conversationMessagesList =
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
                                    ConversationMessagesList.Message.MessageBody.Button.builder()
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
                            PaginationMeta.Cursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        assertThat(conversationMessagesList.messages().getOrNull())
            .containsExactly(
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
                                ConversationMessagesList.Message.MessageBody.Button.builder()
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
        assertThat(conversationMessagesList.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(
                        PaginationMeta.Cursors.builder().after("after").before("before").build()
                    )
                    .hasMore(true)
                    .page(0)
                    .pageSize(0)
                    .totalCount(0)
                    .totalPages(0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val conversationMessagesList =
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
                                    ConversationMessagesList.Message.MessageBody.Button.builder()
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
                            PaginationMeta.Cursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        val roundtrippedConversationMessagesList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationMessagesList),
                jacksonTypeRef<ConversationMessagesList>(),
            )

        assertThat(roundtrippedConversationMessagesList).isEqualTo(conversationMessagesList)
    }
}
