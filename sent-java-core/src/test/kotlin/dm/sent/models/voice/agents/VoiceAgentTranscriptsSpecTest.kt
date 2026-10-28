// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentTranscriptsSpecTest {

    @Test
    fun create() {
        val voiceAgentTranscriptsSpec =
            VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build()

        assertThat(voiceAgentTranscriptsSpec.retentionDays()).contains(0)
        assertThat(voiceAgentTranscriptsSpec.store()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentTranscriptsSpec =
            VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build()

        val roundtrippedVoiceAgentTranscriptsSpec =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentTranscriptsSpec),
                jacksonTypeRef<VoiceAgentTranscriptsSpec>(),
            )

        assertThat(roundtrippedVoiceAgentTranscriptsSpec).isEqualTo(voiceAgentTranscriptsSpec)
    }
}
