// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.calls.CallHangupParams
import dm.sent.models.calls.CallListRecordingsParams
import dm.sent.models.calls.CallRecordParams
import dm.sent.models.calls.CallRetrieveParams
import dm.sent.models.webhooks.MutationRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CallServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val callServiceAsync = client.calls()

        val apiResponseOfCallFuture =
            callServiceAsync.retrieve(
                CallRetrieveParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfCall = apiResponseOfCallFuture.get()
        apiResponseOfCall.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val callServiceAsync = client.calls()

        val pageFuture = callServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun hangup() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val callServiceAsync = client.calls()

        val future =
            callServiceAsync.hangup(
                CallHangupParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .mutationRequest(MutationRequest.builder().sandbox(false).build())
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listRecordings() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val callServiceAsync = client.calls()

        val apiResponseOfCallRecordingsFuture =
            callServiceAsync.listRecordings(
                CallListRecordingsParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfCallRecordings = apiResponseOfCallRecordingsFuture.get()
        apiResponseOfCallRecordings.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun record() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val callServiceAsync = client.calls()

        val future =
            callServiceAsync.record(
                CallRecordParams.builder()
                    .id("call_9f2ab000-0000-4000-8000-000000000001")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .action("start")
                    .build()
            )

        val response = future.get()
    }
}
