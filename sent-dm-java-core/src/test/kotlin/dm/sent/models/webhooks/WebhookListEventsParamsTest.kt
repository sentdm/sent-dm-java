// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookListEventsParamsTest {

    @Test
    fun create() {
        WebhookListEventsParams.builder()
            .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
            .page(0)
            .pageSize(0)
            .search("search")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            WebhookListEventsParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .page(0)
                .pageSize(0)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            WebhookListEventsParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .page(0)
                .pageSize(0)
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
        val params =
            WebhookListEventsParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .page(0)
                .pageSize(0)
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            WebhookListEventsParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .page(0)
                .pageSize(0)
                .search("search")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("page", "0")
                    .put("page_size", "0")
                    .put("search", "search")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            WebhookListEventsParams.builder()
                .id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
                .page(0)
                .pageSize(0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("page_size", "0").build())
    }
}
