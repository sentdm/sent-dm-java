// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageSendResultTest {

    @Test
    fun create() {
        val messageSendResult =
            MessageSendResult.builder()
                .addRecipient(
                    MessageRecipient.builder()
                        .body("body")
                        .channel("channel")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .to("to")
                        .build()
                )
                .status("status")
                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .templateName("template_name")
                .build()

        assertThat(messageSendResult.recipients().getOrNull())
            .containsExactly(
                MessageRecipient.builder()
                    .body("body")
                    .channel("channel")
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .to("to")
                    .build()
            )
        assertThat(messageSendResult.status()).contains("status")
        assertThat(messageSendResult.templateId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageSendResult.templateName()).contains("template_name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageSendResult =
            MessageSendResult.builder()
                .addRecipient(
                    MessageRecipient.builder()
                        .body("body")
                        .channel("channel")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .to("to")
                        .build()
                )
                .status("status")
                .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .templateName("template_name")
                .build()

        val roundtrippedMessageSendResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageSendResult),
                jacksonTypeRef<MessageSendResult>(),
            )

        assertThat(roundtrippedMessageSendResult).isEqualTo(messageSendResult)
    }
}
