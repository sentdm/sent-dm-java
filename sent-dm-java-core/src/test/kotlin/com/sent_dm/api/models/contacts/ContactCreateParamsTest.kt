// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactCreateParamsTest {

    @Test
    fun create() {
        ContactCreateParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .phoneNumber("+1234567890")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ContactCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .phoneNumber("+1234567890")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = ContactCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ContactCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .phoneNumber("+1234567890")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.phoneNumber()).contains("+1234567890")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContactCreateParams.builder().build()

        val body = params._body()
    }
}
