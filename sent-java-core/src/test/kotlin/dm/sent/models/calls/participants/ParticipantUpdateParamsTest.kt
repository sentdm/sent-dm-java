// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls.participants

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ParticipantUpdateParamsTest {

    @Test
    fun create() {
        ParticipantUpdateParams.builder()
            .id("call_9f2ab000-0000-4000-8000-000000000001")
            .participantId("call_9f2ab000-0000-4000-8000-000000000002")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .muted(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ParticipantUpdateParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("call_9f2ab000-0000-4000-8000-000000000001")
        assertThat(params._pathParam(1)).isEqualTo("call_9f2ab000-0000-4000-8000-000000000002")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ParticipantUpdateParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .muted(true)
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
            ParticipantUpdateParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ParticipantUpdateParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .muted(true)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.muted()).contains(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ParticipantUpdateParams.builder()
                .id("call_9f2ab000-0000-4000-8000-000000000001")
                .participantId("call_9f2ab000-0000-4000-8000-000000000002")
                .build()

        val body = params._body()
    }
}
