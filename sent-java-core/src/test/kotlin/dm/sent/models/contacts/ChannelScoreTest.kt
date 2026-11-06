// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelScoreTest {

    @Test
    fun create() {
        val channelScore =
            ChannelScore.builder().channel("channel").failScore(0).successScore(0).build()

        assertThat(channelScore.channel()).contains("channel")
        assertThat(channelScore.failScore()).contains(0)
        assertThat(channelScore.successScore()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val channelScore =
            ChannelScore.builder().channel("channel").failScore(0).successScore(0).build()

        val roundtrippedChannelScore =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelScore),
                jacksonTypeRef<ChannelScore>(),
            )

        assertThat(roundtrippedChannelScore).isEqualTo(channelScore)
    }
}
