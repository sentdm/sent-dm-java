// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.conversations

import dm.sent.core.http.Headers
import dm.sent.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConversationListMessagesParamsTest {

    @Test
    fun create() {
        ConversationListMessagesParams.builder()
            .id("08fab313-c9e2-502c-975e-08b0356c432e")
            .page(0)
            .pageSize(0)
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ConversationListMessagesParams.builder()
                .id("08fab313-c9e2-502c-975e-08b0356c432e")
                .page(0)
                .pageSize(0)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("08fab313-c9e2-502c-975e-08b0356c432e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ConversationListMessagesParams.builder()
                .id("08fab313-c9e2-502c-975e-08b0356c432e")
                .page(0)
                .pageSize(0)
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
            ConversationListMessagesParams.builder()
                .id("08fab313-c9e2-502c-975e-08b0356c432e")
                .page(0)
                .pageSize(0)
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun queryParams() {
        val params =
            ConversationListMessagesParams.builder()
                .id("08fab313-c9e2-502c-975e-08b0356c432e")
                .page(0)
                .pageSize(0)
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("page_size", "0").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            ConversationListMessagesParams.builder()
                .id("08fab313-c9e2-502c-975e-08b0356c432e")
                .page(0)
                .pageSize(0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("page_size", "0").build())
    }
}
