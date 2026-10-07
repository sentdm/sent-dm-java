// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import dm.sent.core.http.Headers
import dm.sent.models.webhooks.MutationRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallHangupParamsTest {

    @Test
    fun create() {
        CallHangupParams.builder()
            .id("call_9f2ab000-0000-4000-8000-000000000001")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .mutationRequest(MutationRequest.builder().sandbox(false).build())
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CallHangupParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("call_9f2ab000-0000-4000-8000-000000000001")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            CallHangupParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
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
        val params =
            CallHangupParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            CallHangupParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(MutationRequest.builder().sandbox(false).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CallHangupParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(MutationRequest.builder().build())
    }
}
