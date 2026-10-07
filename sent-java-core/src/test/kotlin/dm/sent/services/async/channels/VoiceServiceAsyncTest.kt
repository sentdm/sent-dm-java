// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels

import dm.sent.client.okhttp.SentOkHttpClientAsync
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

internal class VoiceServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfVoiceNumberCreatedFuture =
            voiceServiceAsync.create(
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

        val apiResponseOfVoiceNumberCreated = apiResponseOfVoiceNumberCreatedFuture.get()
        apiResponseOfVoiceNumberCreated.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfVoiceNumberFuture =
            voiceServiceAsync.retrieve(
                VoiceRetrieveParams.builder()
                    .number("+12125550100")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfVoiceNumber = apiResponseOfVoiceNumberFuture.get()
        apiResponseOfVoiceNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfVoiceNumberFuture =
            voiceServiceAsync.update(
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

        val apiResponseOfVoiceNumber = apiResponseOfVoiceNumberFuture.get()
        apiResponseOfVoiceNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfListOfVoiceNumberFuture =
            voiceServiceAsync.list(
                VoiceListParams.builder().xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        val apiResponseOfListOfVoiceNumber = apiResponseOfListOfVoiceNumberFuture.get()
        apiResponseOfListOfVoiceNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun createToken() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfVoiceTokenFuture =
            voiceServiceAsync.createToken(
                VoiceCreateTokenParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .identity("agent-42")
                    .number("+12025550123")
                    .ttl(600)
                    .build()
            )

        val apiResponseOfVoiceToken = apiResponseOfVoiceTokenFuture.get()
        apiResponseOfVoiceToken.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun rotateSecret() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfVoiceSecretFuture =
            voiceServiceAsync.rotateSecret(
                VoiceRotateSecretParams.builder()
                    .number("+12125550100")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        val apiResponseOfVoiceSecret = apiResponseOfVoiceSecretFuture.get()
        apiResponseOfVoiceSecret.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun test() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val voiceServiceAsync = client.channels().voice()

        val apiResponseOfVoiceCallbackTestFuture =
            voiceServiceAsync.test(
                VoiceTestParams.builder()
                    .number("+12025550123")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        val apiResponseOfVoiceCallbackTest = apiResponseOfVoiceCallbackTestFuture.get()
        apiResponseOfVoiceCallbackTest.validate()
    }
}
