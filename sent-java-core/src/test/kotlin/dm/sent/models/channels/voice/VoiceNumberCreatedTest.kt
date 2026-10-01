// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceNumberCreatedTest {

    @Test
    fun create() {
        val voiceNumberCreated =
            VoiceNumberCreated.builder()
                .callbackUrl("callback_url")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .defaultForAppCalls(true)
                .number("number")
                .status("status")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .callbackSecret("callback_secret")
                .build()

        assertThat(voiceNumberCreated.callbackUrl()).contains("callback_url")
        assertThat(voiceNumberCreated.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(voiceNumberCreated.defaultForAppCalls()).contains(true)
        assertThat(voiceNumberCreated.number()).contains("number")
        assertThat(voiceNumberCreated.status()).contains("status")
        assertThat(voiceNumberCreated.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(voiceNumberCreated.callbackSecret()).contains("callback_secret")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceNumberCreated =
            VoiceNumberCreated.builder()
                .callbackUrl("callback_url")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .defaultForAppCalls(true)
                .number("number")
                .status("status")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .callbackSecret("callback_secret")
                .build()

        val roundtrippedVoiceNumberCreated =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceNumberCreated),
                jacksonTypeRef<VoiceNumberCreated>(),
            )

        assertThat(roundtrippedVoiceNumberCreated).isEqualTo(voiceNumberCreated)
    }
}
