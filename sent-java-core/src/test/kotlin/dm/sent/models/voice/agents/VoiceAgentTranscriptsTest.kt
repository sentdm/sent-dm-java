// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentTranscriptsTest {

    @Test
    fun create() {
        val voiceAgentTranscripts =
            VoiceAgentTranscripts.builder().retentionDays(0).store(true).build()

        assertThat(voiceAgentTranscripts.retentionDays()).contains(0)
        assertThat(voiceAgentTranscripts.store()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentTranscripts =
            VoiceAgentTranscripts.builder().retentionDays(0).store(true).build()

        val roundtrippedVoiceAgentTranscripts =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentTranscripts),
                jacksonTypeRef<VoiceAgentTranscripts>(),
            )

        assertThat(roundtrippedVoiceAgentTranscripts).isEqualTo(voiceAgentTranscripts)
    }
}
