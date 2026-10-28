// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentLimitsSpecTest {

    @Test
    fun create() {
        val voiceAgentLimitsSpec =
            VoiceAgentLimitsSpec.builder()
                .addAllowedCountry("string")
                .maxCallSeconds(0)
                .maxConcurrentCalls(0)
                .build()

        assertThat(voiceAgentLimitsSpec.allowedCountries().getOrNull()).containsExactly("string")
        assertThat(voiceAgentLimitsSpec.maxCallSeconds()).contains(0)
        assertThat(voiceAgentLimitsSpec.maxConcurrentCalls()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgentLimitsSpec =
            VoiceAgentLimitsSpec.builder()
                .addAllowedCountry("string")
                .maxCallSeconds(0)
                .maxConcurrentCalls(0)
                .build()

        val roundtrippedVoiceAgentLimitsSpec =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgentLimitsSpec),
                jacksonTypeRef<VoiceAgentLimitsSpec>(),
            )

        assertThat(roundtrippedVoiceAgentLimitsSpec).isEqualTo(voiceAgentLimitsSpec)
    }
}
