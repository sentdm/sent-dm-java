// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandDeleteParamsTest {

    @Test
    fun create() {
        BrandDeleteParams.builder()
            .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
            .testMode(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            BrandDeleteParams.builder().brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890").build()

        assertThat(params._pathParam(0)).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BrandDeleteParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .testMode(false)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BrandDeleteParams.builder().brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890").build()

        val body = params._body()
    }
}
