// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentPartySpecTest {

    @Test
    fun create() {
        val voiceAgentPartySpec = VoiceAgentPartySpec.builder().kind("kind").value("value").build()

        assertThat(voiceAgentPartySpec.kind()).contains("kind")
        assertThat(voiceAgentPartySpec.value()).contains("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentPartySpec = VoiceAgentPartySpec.builder().kind("kind").value("value").build()

        val roundtrippedVoiceAgentPartySpec =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentPartySpec),
                jacksonTypeRef<VoiceAgentPartySpec>(),
            )

        assertThat(roundtrippedVoiceAgentPartySpec).isEqualTo(voiceAgentPartySpec)
    }
}
