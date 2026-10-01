// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.channels.voice.VoiceCreateParams
import dm.sent.models.channels.voice.VoiceCreateTokenParams
import dm.sent.models.channels.voice.VoiceListParams
import dm.sent.models.channels.voice.VoiceRetrieveParams
import dm.sent.models.channels.voice.VoiceRotateSecretParams
import dm.sent.models.channels.voice.VoiceTestParams
import dm.sent.models.channels.voice.VoiceUpdateParams
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VoiceServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfVoiceNumberCreated =
            voiceService.create(
                VoiceCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .callbackUrl("https://example.com/voice")
                    .areaCode(null)
                    .defaultForAppCalls(false)
                    .number("+12125550100")
                    .build()
            )

        apiResponseOfVoiceNumberCreated.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfVoiceNumber =
            voiceService.retrieve(
                VoiceRetrieveParams.builder()
                    .number("+12125550100")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfVoiceNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfVoiceNumber =
            voiceService.update(
                VoiceUpdateParams.builder()
                    .number("+12125550100")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .callbackUrl("https://example.com/voice")
                    .defaultForAppCalls(true)
                    .status(VoiceUpdateParams.Status.ACTIVE)
                    .build()
            )

        apiResponseOfVoiceNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfListOfVoiceNumber =
            voiceService.list(
                VoiceListParams.builder().xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        apiResponseOfListOfVoiceNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun createToken() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfVoiceToken =
            voiceService.createToken(
                VoiceCreateTokenParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .identity("agent-42")
                    .number("+12025550123")
                    .ttl(600)
                    .build()
            )

        apiResponseOfVoiceToken.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rotateSecret() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfVoiceSecret =
            voiceService.rotateSecret(
                VoiceRotateSecretParams.builder()
                    .number("+12125550100")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        apiResponseOfVoiceSecret.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun test() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val voiceService = client.channels().voice()

        val apiResponseOfVoiceCallbackTest =
            voiceService.test(
                VoiceTestParams.builder()
                    .number("+12025550123")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        apiResponseOfVoiceCallbackTest.validate()
    }
}
