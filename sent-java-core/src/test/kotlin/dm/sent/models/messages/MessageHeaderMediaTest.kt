// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageHeaderMediaTest {

    @Test
    fun create() {
        val messageHeaderMedia = MessageHeaderMedia.builder().type("type").url("url").build()

        assertThat(messageHeaderMedia.type()).contains("type")
        assertThat(messageHeaderMedia.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageHeaderMedia = MessageHeaderMedia.builder().type("type").url("url").build()

        val roundtrippedMessageHeaderMedia =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageHeaderMedia),
                jacksonTypeRef<MessageHeaderMedia>(),
            )

        assertThat(roundtrippedMessageHeaderMedia).isEqualTo(messageHeaderMedia)
    }
}
