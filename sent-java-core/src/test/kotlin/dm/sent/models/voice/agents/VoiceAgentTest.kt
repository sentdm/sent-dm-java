// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceAgentTest {

    @Test
    fun create() {
        val voiceAgent =
            VoiceAgent.builder()
                .id("id")
                .audio(VoiceAgentAudio.builder().sampleRate(0).build())
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fallback(VoiceAgentParty.builder().kind("kind").value("value").build())
                .greeting("greeting")
                .limits(
                    VoiceAgentLimits.builder()
                        .addAllowedCountry("string")
                        .maxCallSeconds(0)
                        .maxConcurrentCalls(0)
                        .build()
                )
                .name("name")
                .sessionType("session_type")
                .signingSecret("signing_secret")
                .speech(
                    VoiceAgentSpeech.builder()
                        .language("language")
                        .setting("setting")
                        .voice("voice")
                        .build()
                )
                .addTool("string")
                .transcripts(VoiceAgentTranscripts.builder().retentionDays(0).store(true).build())
                .addTransferTarget(VoiceAgentParty.builder().kind("kind").value("value").build())
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .websocketUrl("websocket_url")
                .build()

        assertThat(voiceAgent.id()).contains("id")
        assertThat(voiceAgent.audio()).contains(VoiceAgentAudio.builder().sampleRate(0).build())
        assertThat(voiceAgent.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(voiceAgent.fallback())
            .contains(VoiceAgentParty.builder().kind("kind").value("value").build())
        assertThat(voiceAgent.greeting()).contains("greeting")
        assertThat(voiceAgent.limits())
            .contains(
                VoiceAgentLimits.builder()
                    .addAllowedCountry("string")
                    .maxCallSeconds(0)
                    .maxConcurrentCalls(0)
                    .build()
            )
        assertThat(voiceAgent.name()).contains("name")
        assertThat(voiceAgent.sessionType()).contains("session_type")
        assertThat(voiceAgent.signingSecret()).contains("signing_secret")
        assertThat(voiceAgent.speech())
            .contains(
                VoiceAgentSpeech.builder()
                    .language("language")
                    .setting("setting")
                    .voice("voice")
                    .build()
            )
        assertThat(voiceAgent.tools().getOrNull()).containsExactly("string")
        assertThat(voiceAgent.transcripts())
            .contains(VoiceAgentTranscripts.builder().retentionDays(0).store(true).build())
        assertThat(voiceAgent.transferTargets().getOrNull())
            .containsExactly(VoiceAgentParty.builder().kind("kind").value("value").build())
        assertThat(voiceAgent.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(voiceAgent.websocketUrl()).contains("websocket_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceAgent =
            VoiceAgent.builder()
                .id("id")
                .audio(VoiceAgentAudio.builder().sampleRate(0).build())
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .fallback(VoiceAgentParty.builder().kind("kind").value("value").build())
                .greeting("greeting")
                .limits(
                    VoiceAgentLimits.builder()
                        .addAllowedCountry("string")
                        .maxCallSeconds(0)
                        .maxConcurrentCalls(0)
                        .build()
                )
                .name("name")
                .sessionType("session_type")
                .signingSecret("signing_secret")
                .speech(
                    VoiceAgentSpeech.builder()
                        .language("language")
                        .setting("setting")
                        .voice("voice")
                        .build()
                )
                .addTool("string")
                .transcripts(VoiceAgentTranscripts.builder().retentionDays(0).store(true).build())
                .addTransferTarget(VoiceAgentParty.builder().kind("kind").value("value").build())
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .websocketUrl("websocket_url")
                .build()

        val roundtrippedVoiceAgent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceAgent),
                jacksonTypeRef<VoiceAgent>(),
            )

        assertThat(roundtrippedVoiceAgent).isEqualTo(voiceAgent)
    }
}
