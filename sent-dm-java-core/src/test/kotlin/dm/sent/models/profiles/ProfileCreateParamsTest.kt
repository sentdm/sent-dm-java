// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCreateParamsTest {

    @Test
    fun create() {
        ProfileCreateParams.builder()
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .allowContactSharing(true)
            .allowTemplateSharing(false)
            .billingModel("profile")
            .description("Sales department sender profile")
            .icon("https://example.com/sales-icon.png")
            .inheritContacts(true)
            .inheritTcrBrand(true)
            .inheritTcrCampaign(true)
            .inheritTemplates(true)
            .name("Sales Team")
            .shortName("SALES")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ProfileCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .allowContactSharing(true)
                .allowTemplateSharing(false)
                .billingModel("profile")
                .description("Sales department sender profile")
                .icon("https://example.com/sales-icon.png")
                .inheritContacts(true)
                .inheritTcrBrand(true)
                .inheritTcrCampaign(true)
                .inheritTemplates(true)
                .name("Sales Team")
                .shortName("SALES")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = ProfileCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ProfileCreateParams.builder()
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .allowContactSharing(true)
                .allowTemplateSharing(false)
                .billingModel("profile")
                .description("Sales department sender profile")
                .icon("https://example.com/sales-icon.png")
                .inheritContacts(true)
                .inheritTcrBrand(true)
                .inheritTcrCampaign(true)
                .inheritTemplates(true)
                .name("Sales Team")
                .shortName("SALES")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.allowContactSharing()).contains(true)
        assertThat(body.allowTemplateSharing()).contains(false)
        assertThat(body.billingModel()).contains("profile")
        assertThat(body.description()).contains("Sales department sender profile")
        assertThat(body.icon()).contains("https://example.com/sales-icon.png")
        assertThat(body.inheritContacts()).contains(true)
        assertThat(body.inheritTcrBrand()).contains(true)
        assertThat(body.inheritTcrCampaign()).contains(true)
        assertThat(body.inheritTemplates()).contains(true)
        assertThat(body.name()).contains("Sales Team")
        assertThat(body.shortName()).contains("SALES")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProfileCreateParams.builder().build()

        val body = params._body()
    }
}
