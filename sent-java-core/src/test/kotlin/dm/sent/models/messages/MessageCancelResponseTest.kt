// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageCancelResponseTest {

    @Test
    fun create() {
        val messageCancelResponse =
            MessageCancelResponse.builder()
                .data(
                    MessageCancelResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .activeContactPrice(0.0)
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .direction("direction")
                        .addEvent(
                            MessageCancelResponse.Data.Event.builder()
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .build()
                        )
                        .messageBody(
                            MessageCancelResponse.Data.MessageBody.builder()
                                .addButton(
                                    MessageCancelResponse.Data.MessageBody.Button.builder()
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
                                    MessageCancelResponse.Data.MessageBody.HeaderMedia.builder()
                                        .type("type")
                                        .url("url")
                                        .build()
                                )
                                .addMedia(
                                    MessageCancelResponse.Data.MessageBody.Media.builder()
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
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .templateCategory("template_category")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
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

        assertThat(messageCancelResponse.data())
            .contains(
                MessageCancelResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .activeContactPrice(0.0)
                    .channel("channel")
                    .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .direction("direction")
                    .addEvent(
                        MessageCancelResponse.Data.Event.builder()
                            .status("status")
                            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .description("description")
                            .reason("reason")
                            .reasonCode("reason_code")
                            .build()
                    )
                    .messageBody(
                        MessageCancelResponse.Data.MessageBody.builder()
                            .addButton(
                                MessageCancelResponse.Data.MessageBody.Button.builder()
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
                                MessageCancelResponse.Data.MessageBody.HeaderMedia.builder()
                                    .type("type")
                                    .url("url")
                                    .build()
                            )
                            .addMedia(
                                MessageCancelResponse.Data.MessageBody.Media.builder()
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
                    .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .status("status")
                    .templateCategory("template_category")
                    .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .templateName("template_name")
                    .build()
            )
        assertThat(messageCancelResponse.error())
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
        assertThat(messageCancelResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(messageCancelResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageCancelResponse =
            MessageCancelResponse.builder()
                .data(
                    MessageCancelResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .activeContactPrice(0.0)
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .direction("direction")
                        .addEvent(
                            MessageCancelResponse.Data.Event.builder()
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .reason("reason")
                                .reasonCode("reason_code")
                                .build()
                        )
                        .messageBody(
                            MessageCancelResponse.Data.MessageBody.builder()
                                .addButton(
                                    MessageCancelResponse.Data.MessageBody.Button.builder()
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
                                    MessageCancelResponse.Data.MessageBody.HeaderMedia.builder()
                                        .type("type")
                                        .url("url")
                                        .build()
                                )
                                .addMedia(
                                    MessageCancelResponse.Data.MessageBody.Media.builder()
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
                        .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .status("status")
                        .templateCategory("template_category")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
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

        val roundtrippedMessageCancelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageCancelResponse),
                jacksonTypeRef<MessageCancelResponse>(),
            )

        assertThat(roundtrippedMessageCancelResponse).isEqualTo(messageCancelResponse)
    }
}
