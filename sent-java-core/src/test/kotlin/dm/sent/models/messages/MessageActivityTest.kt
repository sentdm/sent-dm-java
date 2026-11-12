// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageActivityTest {

    @Test
    fun create() {
        val messageActivity =
            MessageActivity.builder()
                .activeContactPrice("active_contact_price")
                .description("description")
                .from("from")
                .price("price")
                .reason("reason")
                .reasonCode("reason_code")
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(messageActivity.activeContactPrice()).contains("active_contact_price")
        assertThat(messageActivity.description()).contains("description")
        assertThat(messageActivity.from()).contains("from")
        assertThat(messageActivity.price()).contains("price")
        assertThat(messageActivity.reason()).contains("reason")
        assertThat(messageActivity.reasonCode()).contains("reason_code")
        assertThat(messageActivity.scheduledAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(messageActivity.status()).contains("status")
        assertThat(messageActivity.timestamp())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageActivity =
            MessageActivity.builder()
                .activeContactPrice("active_contact_price")
                .description("description")
                .from("from")
                .price("price")
                .reason("reason")
                .reasonCode("reason_code")
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status("status")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedMessageActivity =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageActivity),
                jacksonTypeRef<MessageActivity>(),
            )

        assertThat(roundtrippedMessageActivity).isEqualTo(messageActivity)
    }
}
