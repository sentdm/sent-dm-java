// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import dm.sent.core.http.Headers
import dm.sent.models.webhooks.MutationRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactDeleteParamsTest {

    @Test
    fun create() {
        ContactDeleteParams.builder()
            .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .mutationRequest(MutationRequest.builder().sandbox(false).build())
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .mutationRequest(MutationRequest.builder().build())
                .build()

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
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
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
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(MutationRequest.builder().sandbox(false).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(MutationRequest.builder().build())
    }
}
