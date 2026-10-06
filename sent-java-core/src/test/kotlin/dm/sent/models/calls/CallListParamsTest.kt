// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallListParamsTest {

    @Test
    fun create() {
        CallListParams.builder()
            .direction("direction")
            .from(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .number("number")
            .page(0)
            .pageSize(0)
            .status("status")
            .to(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun headers() {
        val params =
            CallListParams.builder()
                .direction("direction")
                .from(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .number("number")
                .page(0)
                .pageSize(0)
                .status("status")
                .to(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
        val params = CallListParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            CallListParams.builder()
                .direction("direction")
                .from(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .number("number")
                .page(0)
                .pageSize(0)
                .status("status")
                .to(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("direction", "direction")
                    .put("from", "2019-12-27T18:11:19.117Z")
                    .put("number", "number")
                    .put("page", "0")
                    .put("page_size", "0")
                    .put("status", "status")
                    .put("to", "2019-12-27T18:11:19.117Z")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CallListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
