// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageTest {

    @Test
    fun create() {
        val message =
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
                        .headerMedia(MessageHeaderMedia.builder().type("type").url("url").build())
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

        assertThat(message.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(message.activeContactPrice()).contains(0.0)
        assertThat(message.channel()).contains("channel")
        assertThat(message.contactId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(message.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(message.customerId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(message.direction()).contains("direction")
        assertThat(message.events().getOrNull())
            .containsExactly(
                MessageStatusEvent.builder()
                    .status("status")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .description("description")
                    .reason("reason")
                    .reasonCode("reason_code")
                    .build()
            )
        assertThat(message.messageBody())
            .contains(
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
                    .headerMedia(MessageHeaderMedia.builder().type("type").url("url").build())
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
        assertThat(message.phone()).contains("phone")
        assertThat(message.phoneInternational()).contains("phone_international")
        assertThat(message.price()).contains(0.0)
        assertThat(message.reason()).contains("reason")
        assertThat(message.reasonCode()).contains("reason_code")
        assertThat(message.regionCode()).contains("region_code")
        assertThat(message.status()).contains("status")
        assertThat(message.templateCategory()).contains("template_category")
        assertThat(message.templateId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(message.templateName()).contains("template_name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val message =
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
                        .headerMedia(MessageHeaderMedia.builder().type("type").url("url").build())
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

        val roundtrippedMessage =
            jsonMapper.readValue(jsonMapper.writeValueAsString(message), jacksonTypeRef<Message>())

        assertThat(roundtrippedMessage).isEqualTo(message)
    }
}
