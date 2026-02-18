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

internal class MessageSendResponseTest {

    @Test
    fun create() {
        val messageSendResponse =
            MessageSendResponse.builder()
                .data(
                    MessageSendResponse.Data.builder()
                        .body("body")
                        .addRecipient(
                            MessageSendResponse.Data.Recipient.builder()
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .to("to")
                                .build()
                        )
                        .status("status")
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

        assertThat(messageSendResponse.data())
            .contains(
                MessageSendResponse.Data.builder()
                    .body("body")
                    .addRecipient(
                        MessageSendResponse.Data.Recipient.builder()
                            .channel("channel")
                            .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .to("to")
                            .build()
                    )
                    .status("status")
                    .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .templateName("template_name")
                    .build()
            )
        assertThat(messageSendResponse.error())
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
        assertThat(messageSendResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(messageSendResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageSendResponse =
            MessageSendResponse.builder()
                .data(
                    MessageSendResponse.Data.builder()
                        .body("body")
                        .addRecipient(
                            MessageSendResponse.Data.Recipient.builder()
                                .channel("channel")
                                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .to("to")
                                .build()
                        )
                        .status("status")
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

        val roundtrippedMessageSendResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageSendResponse),
                jacksonTypeRef<MessageSendResponse>(),
            )

        assertThat(roundtrippedMessageSendResponse).isEqualTo(messageSendResponse)
    }
}
