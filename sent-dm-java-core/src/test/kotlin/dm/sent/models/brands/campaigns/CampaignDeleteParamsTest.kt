// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignDeleteParamsTest {

    @Test
    fun create() {
        CampaignDeleteParams.builder()
            .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
            .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
            .testMode(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CampaignDeleteParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        assertThat(params._pathParam(1)).isEqualTo("b2c3d4e5-f6a7-8901-bcde-f12345678901")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CampaignDeleteParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .testMode(false)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CampaignDeleteParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .build()

        val body = params._body()
    }
}
