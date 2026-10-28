// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentSpeechSpecTest {

    @Test
    fun create() {
        val voiceAgentSpeechSpec =
            VoiceAgentSpeechSpec.builder()
                .language("language")
                .setting("setting")
                .voice("voice")
                .build()

        assertThat(voiceAgentSpeechSpec.language()).contains("language")
        assertThat(voiceAgentSpeechSpec.setting()).contains("setting")
        assertThat(voiceAgentSpeechSpec.voice()).contains("voice")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentSpeechSpec =
            VoiceAgentSpeechSpec.builder()
                .language("language")
                .setting("setting")
                .voice("voice")
                .build()

        val roundtrippedVoiceAgentSpeechSpec =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentSpeechSpec),
                jacksonTypeRef<VoiceAgentSpeechSpec>(),
            )

        assertThat(roundtrippedVoiceAgentSpeechSpec).isEqualTo(voiceAgentSpeechSpec)
    }
}
