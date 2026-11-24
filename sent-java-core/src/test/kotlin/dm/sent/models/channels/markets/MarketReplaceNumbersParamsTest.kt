// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import dm.sent.core.http.Headers
import dm.sent.models.channels.sms.SmsNumberRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarketReplaceNumbersParamsTest {

    @Test
    fun create() {
        MarketReplaceNumbersParams.builder()
            .channel("sms")
            .country("US")
            .type("TEN_DLC")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
            .addNumber(SmsNumberRequest.builder().areaCode("212").quantity(1).build())
            .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MarketReplaceNumbersParams.builder()
                .channel("sms")
                .country("US")
                .type("TEN_DLC")
                .addNumber(SmsNumberRequest.builder().build())
                .addNumber(SmsNumberRequest.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("sms")
        assertThat(params._pathParam(1)).isEqualTo("US")
        assertThat(params._pathParam(2)).isEqualTo("TEN_DLC")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            MarketReplaceNumbersParams.builder()
                .channel("sms")
                .country("US")
                .type("TEN_DLC")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                .addNumber(SmsNumberRequest.builder().areaCode("212").quantity(1).build())
                .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
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
            MarketReplaceNumbersParams.builder()
                .channel("sms")
                .country("US")
                .type("TEN_DLC")
                .addNumber(SmsNumberRequest.builder().build())
                .addNumber(SmsNumberRequest.builder().build())
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            MarketReplaceNumbersParams.builder()
                .channel("sms")
                .country("US")
                .type("TEN_DLC")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                .addNumber(SmsNumberRequest.builder().areaCode("212").quantity(1).build())
                .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.numbers())
            .containsExactly(
                SmsNumberRequest.builder().areaCode("415").quantity(2).build(),
                SmsNumberRequest.builder().areaCode("212").quantity(1).build(),
            )
        assertThat(body.campaignId()).contains("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            MarketReplaceNumbersParams.builder()
                .channel("sms")
                .country("US")
                .type("TEN_DLC")
                .addNumber(SmsNumberRequest.builder().build())
                .addNumber(SmsNumberRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body.numbers())
            .containsExactly(SmsNumberRequest.builder().build(), SmsNumberRequest.builder().build())
    }
}
