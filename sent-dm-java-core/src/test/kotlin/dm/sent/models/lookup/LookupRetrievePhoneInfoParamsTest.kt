// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.lookup

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LookupRetrievePhoneInfoParamsTest {

    @Test
    fun create() {
        LookupRetrievePhoneInfoParams.builder().phoneNumber("phoneNumber").build()
    }

    @Test
    fun pathParams() {
        val params = LookupRetrievePhoneInfoParams.builder().phoneNumber("phoneNumber").build()

        assertThat(params._pathParam(0)).isEqualTo("phoneNumber")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
