// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.calls.CallHangupParams
import dm.sent.models.calls.CallListRecordingsParams
import dm.sent.models.calls.CallRecordParams
import dm.sent.models.calls.CallRetrieveParams
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CallServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val callService = client.calls()

        val apiResponseOfCall =
            callService.retrieve(
                CallRetrieveParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfCall.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val callService = client.calls()

        val page = callService.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun hangup() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val callService = client.calls()

        callService.hangup(
            CallHangupParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listRecordings() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val callService = client.calls()

        val apiResponseOfCallRecordings =
            callService.listRecordings(
                CallListRecordingsParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfCallRecordings.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun record() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val callService = client.calls()

        callService.record(
            CallRecordParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .action("start")
                .build()
        )
    }
}
