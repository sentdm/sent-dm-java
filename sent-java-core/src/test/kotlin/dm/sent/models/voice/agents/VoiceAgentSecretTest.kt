// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentSecretTest {

    @Test
    fun create() {
        val voiceAgentSecret = VoiceAgentSecret.builder().signingSecret("signing_secret").build()

        assertThat(voiceAgentSecret.signingSecret()).contains("signing_secret")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentSecret = VoiceAgentSecret.builder().signingSecret("signing_secret").build()

        val roundtrippedVoiceAgentSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentSecret),
                jacksonTypeRef<VoiceAgentSecret>(),
            )

        assertThat(roundtrippedVoiceAgentSecret).isEqualTo(voiceAgentSecret)
    }
}
