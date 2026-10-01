// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceSecretTest {

    @Test
    fun create() {
        val voiceSecret = VoiceSecret.builder().callbackSecret("callback_secret").build()

        assertThat(voiceSecret.callbackSecret()).contains("callback_secret")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceSecret = VoiceSecret.builder().callbackSecret("callback_secret").build()

        val roundtrippedVoiceSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceSecret),
                jacksonTypeRef<VoiceSecret>(),
            )

        assertThat(roundtrippedVoiceSecret).isEqualTo(voiceSecret)
    }
}
