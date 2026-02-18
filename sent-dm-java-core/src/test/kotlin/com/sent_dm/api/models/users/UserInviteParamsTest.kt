// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.users

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserInviteParamsTest {

    @Test
    fun create() {
        UserInviteParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .email("newuser@example.com")
            .name("New User")
            .role("developer")
            .build()
    }

    @Test
    fun headers() {
        val params =
            UserInviteParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .email("newuser@example.com")
                .name("New User")
                .role("developer")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = UserInviteParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            UserInviteParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .email("newuser@example.com")
                .name("New User")
                .role("developer")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.email()).contains("newuser@example.com")
        assertThat(body.name()).contains("New User")
        assertThat(body.role()).contains("developer")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = UserInviteParams.builder().build()

        val body = params._body()
    }
}
