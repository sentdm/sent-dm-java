// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.voice

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.voice.agents.AgentCreateParams
import dm.sent.models.voice.agents.AgentDeleteParams
import dm.sent.models.voice.agents.AgentRetrieveParams
import dm.sent.models.voice.agents.AgentRotateSecretParams
import dm.sent.models.voice.agents.AgentUpdateParams
import dm.sent.models.voice.agents.VoiceAgentAudioSpec
import dm.sent.models.voice.agents.VoiceAgentLimitsSpec
import dm.sent.models.voice.agents.VoiceAgentPartySpec
import dm.sent.models.voice.agents.VoiceAgentSpeechSpec
import dm.sent.models.voice.agents.VoiceAgentTranscriptsSpec
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AgentServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val agentService = client.voice().agents()

        val apiResponseOfVoiceAgent =
            agentService.create(
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
            )

        apiResponseOfVoiceAgent.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val agentService = client.voice().agents()

        val apiResponseOfVoiceAgent =
            agentService.retrieve(
                AgentRetrieveParams.builder()
                    .id("id")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfVoiceAgent.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val agentService = client.voice().agents()

        val apiResponseOfVoiceAgent =
            agentService.update(
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
            )

        apiResponseOfVoiceAgent.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val agentService = client.voice().agents()

        val page = agentService.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val agentService = client.voice().agents()

        agentService.delete(
            AgentDeleteParams.builder()
                .id("id")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rotateSecret() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val agentService = client.voice().agents()

        val apiResponseOfVoiceAgentSecret =
            agentService.rotateSecret(
                AgentRotateSecretParams.builder()
                    .id("id")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        apiResponseOfVoiceAgentSecret.validate()
    }
}
