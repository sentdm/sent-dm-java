// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactListParamsTest {

    @Test
    fun create() {
        ContactListParams.builder()
            .page(0)
            .pageSize(0)
            .channel("channel")
            .phone("phone")
            .search("search")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ContactListParams.builder()
                .page(0)
                .pageSize(0)
                .channel("channel")
                .phone("phone")
                .search("search")
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
        val params = ContactListParams.builder().page(0).pageSize(0).build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            ContactListParams.builder()
                .page(0)
                .pageSize(0)
                .channel("channel")
                .phone("phone")
                .search("search")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("page", "0")
                    .put("page_size", "0")
                    .put("channel", "channel")
                    .put("phone", "phone")
                    .put("search", "search")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ContactListParams.builder().page(0).pageSize(0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("page_size", "0").build())
    }
}
