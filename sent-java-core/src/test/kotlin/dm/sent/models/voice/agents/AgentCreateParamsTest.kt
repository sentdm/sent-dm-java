// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import dm.sent.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentCreateParamsTest {

    @Test
    fun create() {
        AgentCreateParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .audio(VoiceAgentAudioSpec.builder().sampleRate(0).build())
            .fallback(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
            .greeting("Thanks for calling Example. How can I help?")
            .limits(
                VoiceAgentLimitsSpec.builder()
                    .addAllowedCountry("string")
                    .maxCallSeconds(0)
                    .maxConcurrentCalls(0)
                    .build()
            )
            .name("Receptionist")
            .sessionType("text")
            .speech(
                VoiceAgentSpeechSpec.builder()
                    .language("language")
                    .setting("setting")
                    .voice("voice")
                    .build()
            )
            .addTool("hangup")
            .addTool("transfer")
            .transcripts(VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build())
            .addTransferTarget(
                VoiceAgentPartySpec.builder().kind("number").value("+12125550100").build()
            )
            .websocketUrl("wss://agent.example.com/calls")
            .build()
    }

    @Test
    fun headers() {
        val params =
            AgentCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .audio(VoiceAgentAudioSpec.builder().sampleRate(0).build())
                .fallback(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
                .greeting("Thanks for calling Example. How can I help?")
                .limits(
                    VoiceAgentLimitsSpec.builder()
                        .addAllowedCountry("string")
                        .maxCallSeconds(0)
                        .maxConcurrentCalls(0)
                        .build()
                )
                .name("Receptionist")
                .sessionType("text")
                .speech(
                    VoiceAgentSpeechSpec.builder()
                        .language("language")
                        .setting("setting")
                        .voice("voice")
                        .build()
                )
                .addTool("hangup")
                .addTool("transfer")
                .transcripts(
                    VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build()
                )
                .addTransferTarget(
                    VoiceAgentPartySpec.builder().kind("number").value("+12125550100").build()
                )
                .websocketUrl("wss://agent.example.com/calls")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("Idempotency-Key", "req_abc123_retry1")
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = AgentCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            AgentCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .audio(VoiceAgentAudioSpec.builder().sampleRate(0).build())
                .fallback(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
                .greeting("Thanks for calling Example. How can I help?")
                .limits(
                    VoiceAgentLimitsSpec.builder()
                        .addAllowedCountry("string")
                        .maxCallSeconds(0)
                        .maxConcurrentCalls(0)
                        .build()
                )
                .name("Receptionist")
                .sessionType("text")
                .speech(
                    VoiceAgentSpeechSpec.builder()
                        .language("language")
                        .setting("setting")
                        .voice("voice")
                        .build()
                )
                .addTool("hangup")
                .addTool("transfer")
                .transcripts(
                    VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build()
                )
                .addTransferTarget(
                    VoiceAgentPartySpec.builder().kind("number").value("+12125550100").build()
                )
                .websocketUrl("wss://agent.example.com/calls")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.audio()).contains(VoiceAgentAudioSpec.builder().sampleRate(0).build())
        assertThat(body.fallback())
            .contains(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
        assertThat(body.greeting()).contains("Thanks for calling Example. How can I help?")
        assertThat(body.limits())
            .contains(
                VoiceAgentLimitsSpec.builder()
                    .addAllowedCountry("string")
                    .maxCallSeconds(0)
                    .maxConcurrentCalls(0)
                    .build()
            )
        assertThat(body.name()).contains("Receptionist")
        assertThat(body.sessionType()).contains("text")
        assertThat(body.speech())
            .contains(
                VoiceAgentSpeechSpec.builder()
                    .language("language")
                    .setting("setting")
                    .voice("voice")
                    .build()
            )
        assertThat(body.tools().getOrNull()).containsExactly("hangup", "transfer")
        assertThat(body.transcripts())
            .contains(VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build())
        assertThat(body.transferTargets().getOrNull())
            .containsExactly(
                VoiceAgentPartySpec.builder().kind("number").value("+12125550100").build()
            )
        assertThat(body.websocketUrl()).contains("wss://agent.example.com/calls")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AgentCreateParams.builder().build()

        val body = params._body()
    }
}
