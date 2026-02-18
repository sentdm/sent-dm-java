// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRetrieveStatusResponseTest {

    @Test
    fun create() {
        val messageRetrieveStatusResponse =
            MessageRetrieveStatusResponse.builder()
                .data(
                    MessageRetrieveStatusResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addEvent(
                            MessageRetrieveStatusResponse.Data.Event.builder()
                                .description("description")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageBody(
                            MessageRetrieveStatusResponse.Data.MessageBody.builder()
                                .addButton(
                                    MessageRetrieveStatusResponse.Data.MessageBody.Button.builder()
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

        assertThat(messageRetrieveStatusResponse.data())
            .contains(
                MessageRetrieveStatusResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .channel("channel")
                    .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addEvent(
                        MessageRetrieveStatusResponse.Data.Event.builder()
                            .description("description")
                            .status("status")
                            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .messageBody(
                        MessageRetrieveStatusResponse.Data.MessageBody.builder()
                            .addButton(
                                MessageRetrieveStatusResponse.Data.MessageBody.Button.builder()
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
        assertThat(messageRetrieveStatusResponse.error())
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
        assertThat(messageRetrieveStatusResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(messageRetrieveStatusResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageRetrieveStatusResponse =
            MessageRetrieveStatusResponse.builder()
                .data(
                    MessageRetrieveStatusResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .addEvent(
                            MessageRetrieveStatusResponse.Data.Event.builder()
                                .description("description")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageBody(
                            MessageRetrieveStatusResponse.Data.MessageBody.builder()
                                .addButton(
                                    MessageRetrieveStatusResponse.Data.MessageBody.Button.builder()
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

        val roundtrippedMessageRetrieveStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRetrieveStatusResponse),
                jacksonTypeRef<MessageRetrieveStatusResponse>(),
            )

        assertThat(roundtrippedMessageRetrieveStatusResponse)
            .isEqualTo(messageRetrieveStatusResponse)
    }
}
