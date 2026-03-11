// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompleteSetupParamsTest {

    @Test
    fun create() {
        ProfileCompleteSetupParams.builder()
            .profileId("660e8400-e29b-41d4-a716-446655440000")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .webHookUrl("https://your-app.com/webhook/profile-complete")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ProfileCompleteSetupParams.builder()
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
            ProfileCompleteSetupParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .webHookUrl("https://your-app.com/webhook/profile-complete")
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
        val params =
            ProfileCompleteSetupParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ProfileCompleteSetupParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.webHookUrl()).isEqualTo("https://your-app.com/webhook/profile-complete")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ProfileCompleteSetupParams.builder()
                .profileId("660e8400-e29b-41d4-a716-446655440000")
                .webHookUrl("https://your-app.com/webhook/profile-complete")
                .build()

        val body = params._body()

        assertThat(body.webHookUrl()).isEqualTo("https://your-app.com/webhook/profile-complete")
    }
}
