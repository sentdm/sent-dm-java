// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.calls

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.calls.participants.CallParticipantTarget
import dm.sent.models.calls.participants.ParticipantAddParams
import dm.sent.models.calls.participants.ParticipantListParams
import dm.sent.models.calls.participants.ParticipantRemoveAllParams
import dm.sent.models.calls.participants.ParticipantRemoveParams
import dm.sent.models.calls.participants.ParticipantUpdateParams
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ParticipantServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val participantServiceAsync = client.calls().participants()

        val future =
            participantServiceAsync.update(
                ParticipantUpdateParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .muted(true)
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val participantServiceAsync = client.calls().participants()

        val apiResponseOfListOfCallParticipantFuture =
            participantServiceAsync.list(
                ParticipantListParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfListOfCallParticipant = apiResponseOfListOfCallParticipantFuture.get()
        apiResponseOfListOfCallParticipant.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun add() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val participantServiceAsync = client.calls().participants()

        val apiResponseOfCallFuture =
            participantServiceAsync.add(
                ParticipantAddParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .callerId("+12025550123")
                    .to(
                        CallParticipantTarget.builder().kind("number").value("+14155551234").build()
                    )
                    .build()
            )

        val apiResponseOfCall = apiResponseOfCallFuture.get()
        apiResponseOfCall.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun remove() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val participantServiceAsync = client.calls().participants()

        val future =
            participantServiceAsync.remove(
                ParticipantRemoveParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun removeAll() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val participantServiceAsync = client.calls().participants()

        val future =
            participantServiceAsync.removeAll(
                ParticipantRemoveAllParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        val response = future.get()
    }
}
