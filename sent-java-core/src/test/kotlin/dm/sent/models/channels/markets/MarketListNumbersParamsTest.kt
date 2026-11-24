// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarketListNumbersParamsTest {

    @Test
    fun create() {
        MarketListNumbersParams.builder()
            .channel("channel")
            .country("country")
            .type("type")
            .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MarketListNumbersParams.builder()
                .channel("channel")
                .country("country")
                .type("type")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("channel")
        assertThat(params._pathParam(1)).isEqualTo("country")
        assertThat(params._pathParam(2)).isEqualTo("type")
        // out-of-bound path param
        assertThat(params._pathParam(3)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            MarketListNumbersParams.builder()
                .channel("channel")
                .country("country")
                .type("type")
                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
            MarketListNumbersParams.builder()
                .channel("channel")
                .country("country")
                .type("type")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            MarketListNumbersParams.builder()
                .channel("channel")
                .country("country")
                .type("type")
                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("campaign_id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            MarketListNumbersParams.builder()
                .channel("channel")
                .country("country")
                .type("type")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
