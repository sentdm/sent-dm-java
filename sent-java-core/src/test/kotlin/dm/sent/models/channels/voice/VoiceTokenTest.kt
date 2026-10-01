// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceTokenTest {

    @Test
    fun create() {
        val voiceToken =
            VoiceToken.builder()
                .token("token")
                .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .identity("identity")
                .number("number")
                .build()

        assertThat(voiceToken.token()).contains("token")
        assertThat(voiceToken.expiresAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(voiceToken.identity()).contains("identity")
        assertThat(voiceToken.number()).contains("number")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceToken =
            VoiceToken.builder()
                .token("token")
                .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .identity("identity")
                .number("number")
                .build()

        val roundtrippedVoiceToken =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceToken),
                jacksonTypeRef<VoiceToken>(),
            )

        assertThat(roundtrippedVoiceToken).isEqualTo(voiceToken)
    }
}
