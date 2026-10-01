// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls.participants

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ParticipantAddParamsTest {

    @Test
    fun create() {
        ParticipantAddParams.builder()
            .id("call_9f2ab000-0000-4000-8000-000000000001")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .callerId("+12025550123")
            .to(CallParticipantTarget.builder().kind("number").value("+14155551234").build())
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ParticipantAddParams.builder().id("call_9f2ab000-0000-4000-8000-000000000001").build()

        assertThat(params._pathParam(0)).isEqualTo("call_9f2ab000-0000-4000-8000-000000000001")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ParticipantAddParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .callerId("+12025550123")
                .to(CallParticipantTarget.builder().kind("number").value("+14155551234").build())
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
            ParticipantAddParams.builder().id("call_9f2ab000-0000-4000-8000-000000000001").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ParticipantAddParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .callerId("+12025550123")
                .to(CallParticipantTarget.builder().kind("number").value("+14155551234").build())
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.callerId()).contains("+12025550123")
        assertThat(body.to())
            .contains(CallParticipantTarget.builder().kind("number").value("+14155551234").build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ParticipantAddParams.builder().id("call_9f2ab000-0000-4000-8000-000000000001").build()

        val body = params._body()
    }
}
