// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentAudioTest {

    @Test
    fun create() {
        val voiceAgentAudio = VoiceAgentAudio.builder().sampleRate(0).build()

        assertThat(voiceAgentAudio.sampleRate()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentAudio = VoiceAgentAudio.builder().sampleRate(0).build()

        val roundtrippedVoiceAgentAudio =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentAudio),
                jacksonTypeRef<VoiceAgentAudio>(),
            )

        assertThat(roundtrippedVoiceAgentAudio).isEqualTo(voiceAgentAudio)
    }
}
