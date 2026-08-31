// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactDeleteParamsTest {

    @Test
    fun create() {
        ContactDeleteParams.builder()
            .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ContactDeleteParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
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
            ContactDeleteParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContactDeleteParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        val body = params._body()
    }
}
