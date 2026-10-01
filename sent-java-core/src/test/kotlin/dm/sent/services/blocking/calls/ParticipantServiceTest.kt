// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.calls

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.calls.participants.CallParticipantTarget
import dm.sent.models.calls.participants.ParticipantAddParams
import dm.sent.models.calls.participants.ParticipantListParams
import dm.sent.models.calls.participants.ParticipantRemoveAllParams
import dm.sent.models.calls.participants.ParticipantRemoveParams
import dm.sent.models.calls.participants.ParticipantUpdateParams
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ParticipantServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val participantService = client.calls().participants()

        participantService.update(
            ParticipantUpdateParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .muted(true)
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val participantService = client.calls().participants()

        val apiResponseOfListOfCallParticipant =
            participantService.list(
                ParticipantListParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfListOfCallParticipant.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun add() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val participantService = client.calls().participants()

        val apiResponseOfCall =
            participantService.add(
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

        apiResponseOfCall.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun remove() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val participantService = client.calls().participants()

        participantService.remove(
            ParticipantRemoveParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun removeAll() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val participantService = client.calls().participants()

        participantService.removeAll(
            ParticipantRemoveAllParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()
        )
    }
}
