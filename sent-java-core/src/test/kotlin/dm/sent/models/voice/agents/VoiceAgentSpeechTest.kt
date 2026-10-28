// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentSpeechTest {

    @Test
    fun create() {
        val voiceAgentSpeech =
            VoiceAgentSpeech.builder()
                .language("language")
                .setting("setting")
                .voice("voice")
                .build()

        assertThat(voiceAgentSpeech.language()).contains("language")
        assertThat(voiceAgentSpeech.setting()).contains("setting")
        assertThat(voiceAgentSpeech.voice()).contains("voice")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentSpeech =
            VoiceAgentSpeech.builder()
                .language("language")
                .setting("setting")
                .voice("voice")
                .build()

        val roundtrippedVoiceAgentSpeech =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentSpeech),
                jacksonTypeRef<VoiceAgentSpeech>(),
            )

        assertThat(roundtrippedVoiceAgentSpeech).isEqualTo(voiceAgentSpeech)
    }
}
