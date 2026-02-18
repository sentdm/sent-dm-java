// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.profiles

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompleteParamsTest {

    @Test
    fun create() {
        ProfileCompleteParams.builder()
            .profileId("660e8400-e29b-41d4-a716-446655440000")
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .webHookUrl("https://your-app.com/webhook/profile-complete")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ProfileCompleteParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("660e8400-e29b-41d4-a716-446655440000")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ProfileCompleteParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            ProfileCompleteParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ProfileCompleteParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.webHookUrl()).isEqualTo("https://your-app.com/webhook/profile-complete")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ProfileCompleteParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val body = params._body()

        assertThat(body.webHookUrl()).isEqualTo("https://your-app.com/webhook/profile-complete")
    }
}
