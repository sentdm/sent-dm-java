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
            .channel("channel")
            .page(0)
            .pageSize(0)
            .phone("phone")
            .search("search")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ContactListParams.builder()
                .channel("channel")
                .page(0)
                .pageSize(0)
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
        val params = ContactListParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            ContactListParams.builder()
                .channel("channel")
                .page(0)
                .pageSize(0)
                .phone("phone")
                .search("search")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("channel", "channel")
                    .put("page", "0")
                    .put("page_size", "0")
                    .put("phone", "phone")
                    .put("search", "search")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ContactListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
