// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileRetrieveParamsTest {

    @Test
    fun create() {
        SenderProfileRetrieveParams.builder().id("770e8400-e29b-41d4-a716-446655440002").build()
    }

    @Test
    fun pathParams() {
        val params =
            SenderProfileRetrieveParams.builder().id("770e8400-e29b-41d4-a716-446655440002").build()

        assertThat(params._pathParam(0)).isEqualTo("770e8400-e29b-41d4-a716-446655440002")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
