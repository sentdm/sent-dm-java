// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentAudioSpecTest {

    @Test
    fun create() {
        val voiceAgentAudioSpec = VoiceAgentAudioSpec.builder().sampleRate(0).build()

        assertThat(voiceAgentAudioSpec.sampleRate()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentAudioSpec = VoiceAgentAudioSpec.builder().sampleRate(0).build()

        val roundtrippedVoiceAgentAudioSpec =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentAudioSpec),
                jacksonTypeRef<VoiceAgentAudioSpec>(),
            )

        assertThat(roundtrippedVoiceAgentAudioSpec).isEqualTo(voiceAgentAudioSpec)
    }
}
