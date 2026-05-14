// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileDeleteParamsTest {

    @Test
    fun create() {
        ProfileDeleteParams.builder()
            .profileId("profileId")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ProfileDeleteParams.builder().profileId("profileId").build()

        assertThat(params._pathParam(0)).isEqualTo("profileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ProfileDeleteParams.builder()
                .profileId("profileId")
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
        val params = ProfileDeleteParams.builder().profileId("profileId").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ProfileDeleteParams.builder()
                .profileId("profileId")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProfileDeleteParams.builder().profileId("profileId").build()

        val body = params._body()
    }
}
