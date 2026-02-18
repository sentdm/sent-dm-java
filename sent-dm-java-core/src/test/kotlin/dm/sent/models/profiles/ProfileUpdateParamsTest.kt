// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateParamsTest {

    @Test
    fun create() {
        ProfileUpdateParams.builder()
            .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .idempotencyKey("req_abc123_retry1")
            .testMode(false)
            .allowContactSharing(true)
            .allowNumberChangeDuringOnboarding(null)
            .allowTemplateSharing(null)
            .billingModel("organization")
            .description("Updated sales department sender profile")
            .icon(null)
            .inheritContacts(null)
            .inheritTcrBrand(null)
            .inheritTcrCampaign(null)
            .inheritTemplates(null)
            .name("Sales Team - Updated")
            .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
            .sendingPhoneNumber(null)
            .sendingPhoneNumberProfileId(null)
            .sendingWhatsappNumberProfileId(null)
            .shortName(null)
            .whatsappPhoneNumber(null)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ProfileUpdateParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ProfileUpdateParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .allowContactSharing(true)
                .allowNumberChangeDuringOnboarding(null)
                .allowTemplateSharing(null)
                .billingModel("organization")
                .description("Updated sales department sender profile")
                .icon(null)
                .inheritContacts(null)
                .inheritTcrBrand(null)
                .inheritTcrCampaign(null)
                .inheritTemplates(null)
                .name("Sales Team - Updated")
                .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
                .sendingPhoneNumber(null)
                .sendingPhoneNumberProfileId(null)
                .sendingWhatsappNumberProfileId(null)
                .shortName(null)
                .whatsappPhoneNumber(null)
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            ProfileUpdateParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ProfileUpdateParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .idempotencyKey("req_abc123_retry1")
                .testMode(false)
                .allowContactSharing(true)
                .allowNumberChangeDuringOnboarding(null)
                .allowTemplateSharing(null)
                .billingModel("organization")
                .description("Updated sales department sender profile")
                .icon(null)
                .inheritContacts(null)
                .inheritTcrBrand(null)
                .inheritTcrCampaign(null)
                .inheritTemplates(null)
                .name("Sales Team - Updated")
                .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
                .sendingPhoneNumber(null)
                .sendingPhoneNumberProfileId(null)
                .sendingWhatsappNumberProfileId(null)
                .shortName(null)
                .whatsappPhoneNumber(null)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.allowContactSharing()).contains(true)
        assertThat(body.allowNumberChangeDuringOnboarding()).isEmpty
        assertThat(body.allowTemplateSharing()).isEmpty
        assertThat(body.billingModel()).contains("organization")
        assertThat(body.description()).contains("Updated sales department sender profile")
        assertThat(body.icon()).isEmpty
        assertThat(body.inheritContacts()).isEmpty
        assertThat(body.inheritTcrBrand()).isEmpty
        assertThat(body.inheritTcrCampaign()).isEmpty
        assertThat(body.inheritTemplates()).isEmpty
        assertThat(body.name()).contains("Sales Team - Updated")
        assertThat(body.bodyProfileId()).contains("770e8400-e29b-41d4-a716-446655440002")
        assertThat(body.sendingPhoneNumber()).isEmpty
        assertThat(body.sendingPhoneNumberProfileId()).isEmpty
        assertThat(body.sendingWhatsappNumberProfileId()).isEmpty
        assertThat(body.shortName()).isEmpty
        assertThat(body.whatsappPhoneNumber()).isEmpty
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ProfileUpdateParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()
    }
}
