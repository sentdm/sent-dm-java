// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageStatusEventTest {

    @Test
    fun create() {
        val messageStatusEvent =
            MessageStatusEvent.builder()
                .status("status")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .reason("reason")
                .reasonCode("reason_code")
                .build()

        assertThat(messageStatusEvent.status()).isEqualTo("status")
        assertThat(messageStatusEvent.timestamp())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(messageStatusEvent.description()).contains("description")
        assertThat(messageStatusEvent.reason()).contains("reason")
        assertThat(messageStatusEvent.reasonCode()).contains("reason_code")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageStatusEvent =
            MessageStatusEvent.builder()
                .status("status")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .reason("reason")
                .reasonCode("reason_code")
                .build()

        val roundtrippedMessageStatusEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageStatusEvent),
                jacksonTypeRef<MessageStatusEvent>(),
            )

        assertThat(roundtrippedMessageStatusEvent).isEqualTo(messageStatusEvent)
    }
}
