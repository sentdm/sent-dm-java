// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileRetrieveParamsTest {

    @Test
    fun create() {
        ProfileRetrieveParams.builder()
            .profileId("profileId")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .build()
    }

    @Test
    fun pathParams() {
        val params = ProfileRetrieveParams.builder().profileId("profileId").build()

        assertThat(params._pathParam(0)).isEqualTo("profileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ProfileRetrieveParams.builder()
                .profileId("profileId")
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
        val params = ProfileRetrieveParams.builder().profileId("profileId").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }
}
