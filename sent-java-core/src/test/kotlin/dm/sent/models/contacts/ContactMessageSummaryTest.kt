// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactMessageSummaryTest {

    @Test
    fun create() {
        val contactMessageSummary =
            ContactMessageSummary.builder()
                .addChannelScore(
                    ContactMessageSummary.ChannelScore.builder()
                        .channel("channel")
                        .failScore(0)
                        .successScore(0)
                        .build()
                )
                .addChannelsUsed("string")
                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .messageCount(0)
                .build()

        assertThat(contactMessageSummary.channelScores().getOrNull())
            .containsExactly(
                ContactMessageSummary.ChannelScore.builder()
                    .channel("channel")
                    .failScore(0)
                    .successScore(0)
                    .build()
            )
        assertThat(contactMessageSummary.channelsUsed().getOrNull()).containsExactly("string")
        assertThat(contactMessageSummary.contactId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(contactMessageSummary.firstMessageAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(contactMessageSummary.lastMessageAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(contactMessageSummary.messageCount()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactMessageSummary =
            ContactMessageSummary.builder()
                .addChannelScore(
                    ContactMessageSummary.ChannelScore.builder()
                        .channel("channel")
                        .failScore(0)
                        .successScore(0)
                        .build()
                )
                .addChannelsUsed("string")
                .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .messageCount(0)
                .build()

        val roundtrippedContactMessageSummary =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactMessageSummary),
                jacksonTypeRef<ContactMessageSummary>(),
            )

        assertThat(roundtrippedContactMessageSummary).isEqualTo(contactMessageSummary)
    }
}
