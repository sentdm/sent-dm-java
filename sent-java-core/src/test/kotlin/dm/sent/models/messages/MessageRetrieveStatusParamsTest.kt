// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRetrieveStatusParamsTest {

    @Test
    fun create() {
        MessageRetrieveStatusParams.builder()
            .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            MessageRetrieveStatusParams.builder().id("8ba7b830-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            MessageRetrieveStatusParams.builder()
                .id("8ba7b830-9dad-11d1-80b4-00c04fd430c8")
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
            MessageRetrieveStatusParams.builder().id("8ba7b830-9dad-11d1-80b4-00c04fd430c8").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
