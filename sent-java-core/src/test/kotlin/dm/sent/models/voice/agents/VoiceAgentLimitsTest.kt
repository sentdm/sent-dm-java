// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentLimitsTest {

    @Test
    fun create() {
        val voiceAgentLimits =
            VoiceAgentLimits.builder()
                .addAllowedCountry("string")
                .maxCallSeconds(0)
                .maxConcurrentCalls(0)
                .build()

        assertThat(voiceAgentLimits.allowedCountries().getOrNull()).containsExactly("string")
        assertThat(voiceAgentLimits.maxCallSeconds()).contains(0)
        assertThat(voiceAgentLimits.maxConcurrentCalls()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentLimits =
            VoiceAgentLimits.builder()
                .addAllowedCountry("string")
                .maxCallSeconds(0)
                .maxConcurrentCalls(0)
                .build()

        val roundtrippedVoiceAgentLimits =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentLimits),
                jacksonTypeRef<VoiceAgentLimits>(),
            )

        assertThat(roundtrippedVoiceAgentLimits).isEqualTo(voiceAgentLimits)
    }
}
