// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

import dm.sent.core.http.Headers
import dm.sent.models.channels.sms.SmsNumberRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenDlcAddNumbersParamsTest {

    @Test
    fun create() {
        TenDlcAddNumbersParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
            .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
            .build()
    }

    @Test
    fun headers() {
        val params =
            TenDlcAddNumbersParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
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
            TenDlcAddNumbersParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                .addNumber(SmsNumberRequest.builder().build())
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun body() {
        val params =
            TenDlcAddNumbersParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.campaignId()).isEqualTo("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
        assertThat(body.numbers())
            .containsExactly(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TenDlcAddNumbersParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                .addNumber(SmsNumberRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body.campaignId()).isEqualTo("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
        assertThat(body.numbers()).containsExactly(SmsNumberRequest.builder().build())
    }
}
