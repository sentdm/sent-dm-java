// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import dm.sent.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileListParamsTest {

    @Test
    fun create() {
        SenderProfileListParams.builder().page(0).pageSize(0).build()
    }

    @Test
    fun queryParams() {
        val params = SenderProfileListParams.builder().page(0).pageSize(0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("page_size", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = SenderProfileListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
