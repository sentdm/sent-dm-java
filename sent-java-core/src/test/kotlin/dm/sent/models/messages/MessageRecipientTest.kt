// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRecipientTest {

    @Test
    fun create() {
        val messageRecipient =
            MessageRecipient.builder()
                .body("body")
                .channel("channel")
                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .to("to")
                .build()

        assertThat(messageRecipient.body()).contains("body")
        assertThat(messageRecipient.channel()).contains("channel")
        assertThat(messageRecipient.messageId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(messageRecipient.to()).contains("to")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageRecipient =
            MessageRecipient.builder()
                .body("body")
                .channel("channel")
                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .to("to")
                .build()

        val roundtrippedMessageRecipient =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRecipient),
                jacksonTypeRef<MessageRecipient>(),
            )

        assertThat(roundtrippedMessageRecipient).isEqualTo(messageRecipient)
    }
}
