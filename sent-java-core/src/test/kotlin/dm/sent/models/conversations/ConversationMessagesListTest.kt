// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.messages.Message
import dm.sent.models.messages.MessageBody
import dm.sent.models.messages.MessageButton
import dm.sent.models.messages.MessageHeaderMedia
import dm.sent.models.messages.MessageMedia
import dm.sent.models.messages.MessageStatusEvent
import dm.sent.models.webhooks.PaginationCursors
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
                    Message.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .activeContactPrice(0.0)
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .direction("direction")
                        .addEvent(
                            MessageStatusEvent.builder()
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .build()
                        )
                        .messageBody(
                            MessageBody.builder()
                                .addButton(
                                    MessageButton.builder()
                                        .postbackData("postbackData")
                                        .text("text")
                                        .type("type")
                                        .value("value")
                                        .build()
                                )
                                .content("content")
                                .footer("footer")
                                .header("header")
                                .headerMedia(
                                    MessageHeaderMedia.builder().type("type").url("url").build()
                                )
                                .addMedia(
                                    MessageMedia.builder()
                                        .mediaType("mediaType")
                                        .mimeType("mimeType")
                                        .sizeBytes(0L)
                                        .sourceHashSha256("sourceHashSha256")
                                        .url("url")
                                        .build()
                                )
                                .subject("subject")
                                .build()
                        )
                        .phone("phone")
                        .phoneInternational("phone_international")
                        .price(0.0)
                        .reason("reason")
                        .reasonCode("reason_code")
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

        assertThat(conversationMessagesList.messages().getOrNull())
            .containsExactly(
                Message.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .activeContactPrice(0.0)
                    .channel("channel")
                    .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .direction("direction")
                    .addEvent(
                        MessageStatusEvent.builder()
                            .status("status")
                            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .description("description")
                            .reason("reason")
                            .reasonCode("reason_code")
                            .build()
                    )
                    .messageBody(
                        MessageBody.builder()
                            .addButton(
                                MessageButton.builder()
                                    .postbackData("postbackData")
                                    .text("text")
                                    .type("type")
                                    .value("value")
                                    .build()
                            )
                            .content("content")
                            .footer("footer")
                            .header("header")
                            .headerMedia(
                                MessageHeaderMedia.builder().type("type").url("url").build()
                            )
                            .addMedia(
                                MessageMedia.builder()
                                    .mediaType("mediaType")
                                    .mimeType("mimeType")
                                    .sizeBytes(0L)
                                    .sourceHashSha256("sourceHashSha256")
                                    .url("url")
                                    .build()
                            )
                            .subject("subject")
                            .build()
                    )
                    .phone("phone")
                    .phoneInternational("phone_international")
                    .price(0.0)
                    .reason("reason")
                    .reasonCode("reason_code")
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
                    .cursors(PaginationCursors.builder().after("after").before("before").build())
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
                    Message.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .activeContactPrice(0.0)
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .direction("direction")
                        .addEvent(
                            MessageStatusEvent.builder()
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .build()
                        )
                        .messageBody(
                            MessageBody.builder()
                                .addButton(
                                    MessageButton.builder()
                                        .postbackData("postbackData")
                                        .text("text")
                                        .type("type")
                                        .value("value")
                                        .build()
                                )
                                .content("content")
                                .footer("footer")
                                .header("header")
                                .headerMedia(
                                    MessageHeaderMedia.builder().type("type").url("url").build()
                                )
                                .addMedia(
                                    MessageMedia.builder()
                                        .mediaType("mediaType")
                                        .mimeType("mimeType")
                                        .sizeBytes(0L)
                                        .sourceHashSha256("sourceHashSha256")
                                        .url("url")
                                        .build()
                                )
                                .subject("subject")
                                .build()
                        )
                        .phone("phone")
                        .phoneInternational("phone_international")
                        .price(0.0)
                        .reason("reason")
                        .reasonCode("reason_code")
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

        val roundtrippedConversationMessagesList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(conversationMessagesList),
                jacksonTypeRef<ConversationMessagesList>(),
            )

        assertThat(roundtrippedConversationMessagesList).isEqualTo(conversationMessagesList)
    }
}
