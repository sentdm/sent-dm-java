// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageResendResponseDataTest {

    @Test
    fun create() {
        val messageResendResponseData =
            MessageResendResponseData.builder()
                .addRecipient(
                    MessageResendResponseData.Recipient.builder()
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

        assertThat(messageResendResponseData.recipients().getOrNull())
            .containsExactly(
                MessageResendResponseData.Recipient.builder()
                    .body("body")
                    .channel("channel")
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .to("to")
                    .build()
            )
        assertThat(messageResendResponseData.status()).contains("status")
        assertThat(messageResendResponseData.templateId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageResendResponseData.templateName()).contains("template_name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageResendResponseData =
            MessageResendResponseData.builder()
                .addRecipient(
                    MessageResendResponseData.Recipient.builder()
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

        val roundtrippedMessageResendResponseData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageResendResponseData),
                jacksonTypeRef<MessageResendResponseData>(),
            )

        assertThat(roundtrippedMessageResendResponseData).isEqualTo(messageResendResponseData)
    }
}
