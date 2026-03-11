// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.users

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateRoleParamsTest {

    @Test
    fun create() {
        UserUpdateRoleParams.builder()
            .userId("userId")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .role("billing")
            .build()
    }

    @Test
    fun pathParams() {
        val params = UserUpdateRoleParams.builder().userId("userId").build()

        assertThat(params._pathParam(0)).isEqualTo("userId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            UserUpdateRoleParams.builder()
                .userId("userId")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .role("billing")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("Idempotency-Key", "req_abc123_retry1")
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = UserUpdateRoleParams.builder().userId("userId").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            UserUpdateRoleParams.builder()
                .userId("userId")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .role("billing")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.role()).contains("billing")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserUpdateRoleParams.builder().userId("userId").build()

        val body = params._body()
    }
}
