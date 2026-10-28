// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import dm.sent.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentUpdateParamsTest {

    @Test
    fun create() {
        AgentUpdateParams.builder()
            .id("id")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .audio(VoiceAgentAudioSpec.builder().sampleRate(0).build())
            .fallback(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
            .greeting("greeting")
            .limits(
                VoiceAgentLimitsSpec.builder()
                    .addAllowedCountry("string")
                    .maxCallSeconds(0)
                    .maxConcurrentCalls(0)
                    .build()
            )
            .name("name")
            .sessionType("session_type")
            .speech(
                VoiceAgentSpeechSpec.builder()
                    .language("language")
                    .setting("setting")
                    .voice("voice")
                    .build()
            )
            .addTool("string")
            .transcripts(VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build())
            .addTransferTarget(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
            .websocketUrl("websocket_url")
            .build()
    }

    @Test
    fun pathParams() {
        val params = AgentUpdateParams.builder().id("id").build()

        assertThat(params._pathParam(0)).isEqualTo("id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            AgentUpdateParams.builder()
                .id("id")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .audio(VoiceAgentAudioSpec.builder().sampleRate(0).build())
                .fallback(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
                .greeting("greeting")
                .limits(
                    VoiceAgentLimitsSpec.builder()
                        .addAllowedCountry("string")
                        .maxCallSeconds(0)
                        .maxConcurrentCalls(0)
                        .build()
                )
                .name("name")
                .sessionType("session_type")
                .speech(
                    VoiceAgentSpeechSpec.builder()
                        .language("language")
                        .setting("setting")
                        .voice("voice")
                        .build()
                )
                .addTool("string")
                .transcripts(
                    VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build()
                )
                .addTransferTarget(
                    VoiceAgentPartySpec.builder().kind("kind").value("value").build()
                )
                .websocketUrl("websocket_url")
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
        val params = AgentUpdateParams.builder().id("id").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            AgentUpdateParams.builder()
                .id("id")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .audio(VoiceAgentAudioSpec.builder().sampleRate(0).build())
                .fallback(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
                .greeting("greeting")
                .limits(
                    VoiceAgentLimitsSpec.builder()
                        .addAllowedCountry("string")
                        .maxCallSeconds(0)
                        .maxConcurrentCalls(0)
                        .build()
                )
                .name("name")
                .sessionType("session_type")
                .speech(
                    VoiceAgentSpeechSpec.builder()
                        .language("language")
                        .setting("setting")
                        .voice("voice")
                        .build()
                )
                .addTool("string")
                .transcripts(
                    VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build()
                )
                .addTransferTarget(
                    VoiceAgentPartySpec.builder().kind("kind").value("value").build()
                )
                .websocketUrl("websocket_url")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.audio()).contains(VoiceAgentAudioSpec.builder().sampleRate(0).build())
        assertThat(body.fallback())
            .contains(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
        assertThat(body.greeting()).contains("greeting")
        assertThat(body.limits())
            .contains(
                VoiceAgentLimitsSpec.builder()
                    .addAllowedCountry("string")
                    .maxCallSeconds(0)
                    .maxConcurrentCalls(0)
                    .build()
            )
        assertThat(body.name()).contains("name")
        assertThat(body.sessionType()).contains("session_type")
        assertThat(body.speech())
            .contains(
                VoiceAgentSpeechSpec.builder()
                    .language("language")
                    .setting("setting")
                    .voice("voice")
                    .build()
            )
        assertThat(body.tools().getOrNull()).containsExactly("string")
        assertThat(body.transcripts())
            .contains(VoiceAgentTranscriptsSpec.builder().retentionDays(0).store(true).build())
        assertThat(body.transferTargets().getOrNull())
            .containsExactly(VoiceAgentPartySpec.builder().kind("kind").value("value").build())
        assertThat(body.websocketUrl()).contains("websocket_url")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AgentUpdateParams.builder().id("id").build()

        val body = params._body()
    }
}
