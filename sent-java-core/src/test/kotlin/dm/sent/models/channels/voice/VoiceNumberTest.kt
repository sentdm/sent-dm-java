// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceNumberTest {

    @Test
    fun create() {
        val voiceNumber =
            VoiceNumber.builder()
                .callbackUrl("callback_url")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .defaultForAppCalls(true)
                .number("number")
                .status("status")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(voiceNumber.callbackUrl()).contains("callback_url")
        assertThat(voiceNumber.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(voiceNumber.defaultForAppCalls()).contains(true)
        assertThat(voiceNumber.number()).contains("number")
        assertThat(voiceNumber.status()).contains("status")
        assertThat(voiceNumber.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceNumber =
            VoiceNumber.builder()
                .callbackUrl("callback_url")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .defaultForAppCalls(true)
                .number("number")
                .status("status")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedVoiceNumber =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceNumber),
                jacksonTypeRef<VoiceNumber>(),
            )

        assertThat(roundtrippedVoiceNumber).isEqualTo(voiceNumber)
    }
}
