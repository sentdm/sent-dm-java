// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.users

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserRemoveParamsTest {

    @Test
    fun create() {
        UserRemoveParams.builder()
            .userId("aa0e8400-e29b-41d4-a716-446655440005")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserRemoveParams.builder().userId("aa0e8400-e29b-41d4-a716-446655440005").build()

        assertThat(params._pathParam(0)).isEqualTo("aa0e8400-e29b-41d4-a716-446655440005")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            UserRemoveParams.builder()
                .userId("aa0e8400-e29b-41d4-a716-446655440005")
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
            UserRemoveParams.builder().userId("aa0e8400-e29b-41d4-a716-446655440005").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            UserRemoveParams.builder()
                .userId("aa0e8400-e29b-41d4-a716-446655440005")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserRemoveParams.builder().userId("aa0e8400-e29b-41d4-a716-446655440005").build()

        val body = params._body()
    }
}
