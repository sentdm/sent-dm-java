// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignListParamsTest {

    @Test
    fun create() {
        CampaignListParams.builder().brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890").build()
    }

    @Test
    fun pathParams() {
        val params =
            CampaignListParams.builder().brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890").build()

        assertThat(params._pathParam(0)).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
