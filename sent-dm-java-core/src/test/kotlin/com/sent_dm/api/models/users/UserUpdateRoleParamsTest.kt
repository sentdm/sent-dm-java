// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.users

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateRoleParamsTest {

    @Test
    fun create() {
        UserUpdateRoleParams.builder()
            .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .role("billing")
            .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserUpdateRoleParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            UserUpdateRoleParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .role("billing")
                .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            UserUpdateRoleParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            UserUpdateRoleParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .role("billing")
                .bodyUserId("aa0e8400-e29b-41d4-a716-446655440005")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.role()).contains("billing")
        assertThat(body.bodyUserId()).contains("aa0e8400-e29b-41d4-a716-446655440005")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserUpdateRoleParams.builder()
                .pathUserId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()
    }
}
