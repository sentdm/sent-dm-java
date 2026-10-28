// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentPartyTest {

    @Test
    fun create() {
        val voiceAgentParty = VoiceAgentParty.builder().kind("kind").value("value").build()

        assertThat(voiceAgentParty.kind()).contains("kind")
        assertThat(voiceAgentParty.value()).contains("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentParty = VoiceAgentParty.builder().kind("kind").value("value").build()

        val roundtrippedVoiceAgentParty =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentParty),
                jacksonTypeRef<VoiceAgentParty>(),
            )

        assertThat(roundtrippedVoiceAgentParty).isEqualTo(voiceAgentParty)
    }
}
