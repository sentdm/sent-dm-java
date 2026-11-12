// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CancelledMessageTest {

    @Test
    fun create() {
        val cancelledMessage =
            CancelledMessage.builder()
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
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(cancelledMessage.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(cancelledMessage.activeContactPrice()).contains(0.0)
        assertThat(cancelledMessage.channel()).contains("channel")
        assertThat(cancelledMessage.contactId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(cancelledMessage.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(cancelledMessage.customerId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(cancelledMessage.direction()).contains("direction")
        assertThat(cancelledMessage.events().getOrNull())
            .containsExactly(
                MessageStatusEvent.builder()
                    .status("status")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .description("description")
                    .reason("reason")
                    .reasonCode("reason_code")
                    .build()
            )
        assertThat(cancelledMessage.messageBody())
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
        assertThat(cancelledMessage.phone()).contains("phone")
        assertThat(cancelledMessage.phoneInternational()).contains("phone_international")
        assertThat(cancelledMessage.price()).contains(0.0)
        assertThat(cancelledMessage.reason()).contains("reason")
        assertThat(cancelledMessage.reasonCode()).contains("reason_code")
        assertThat(cancelledMessage.regionCode()).contains("region_code")
        assertThat(cancelledMessage.status()).contains("status")
        assertThat(cancelledMessage.templateCategory()).contains("template_category")
        assertThat(cancelledMessage.templateId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(cancelledMessage.templateName()).contains("template_name")
        assertThat(cancelledMessage.scheduledAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val cancelledMessage =
            CancelledMessage.builder()
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
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedCancelledMessage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(cancelledMessage),
                jacksonTypeRef<CancelledMessage>(),
            )

        assertThat(roundtrippedCancelledMessage).isEqualTo(cancelledMessage)
    }
}
