// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageButtonTest {

    @Test
    fun create() {
        val messageButton =
            MessageButton.builder()
                .postbackData("postbackData")
                .text("text")
                .type("type")
                .value("value")
                .build()

        assertThat(messageButton.postbackData()).contains("postbackData")
        assertThat(messageButton.text()).contains("text")
        assertThat(messageButton.type()).contains("type")
        assertThat(messageButton.value()).contains("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageButton =
            MessageButton.builder()
                .postbackData("postbackData")
                .text("text")
                .type("type")
                .value("value")
                .build()

        val roundtrippedMessageButton =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageButton),
                jacksonTypeRef<MessageButton>(),
            )

        assertThat(roundtrippedMessageButton).isEqualTo(messageButton)
    }
}
