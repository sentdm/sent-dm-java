// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarketRetrieveParamsTest {

    @Test
    fun create() {
        MarketRetrieveParams.builder()
            .channel("sms")
            .country("US")
            .type("ten_dlc")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MarketRetrieveParams.builder().channel("sms").country("US").type("ten_dlc").build()

        assertThat(params._pathParam(0)).isEqualTo("sms")
        assertThat(params._pathParam(1)).isEqualTo("US")
        assertThat(params._pathParam(2)).isEqualTo("ten_dlc")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            MarketRetrieveParams.builder()
                .channel("sms")
                .country("US")
                .type("ten_dlc")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            MarketRetrieveParams.builder().channel("sms").country("US").type("ten_dlc").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
