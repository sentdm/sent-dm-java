// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

import dm.sent.core.JsonValue
import dm.sent.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenDlcUpdateCampaignParamsTest {

    @Test
    fun create() {
        TenDlcUpdateCampaignParams.builder()
            .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .description("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
            .helpKeywords("help_keywords")
            .helpMessage("Example Clinic: for help call +1 212 555 0100. Reply STOP to opt out.")
            .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
            .optInKeywords("opt_in_keywords")
            .optInMessage("xxxxxxxxxxxxxxxxxxxx")
            .optOutKeywords("opt_out_keywords")
            .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
            .privacyPolicyLink("privacy_policy_link")
            .sandbox(false)
            .termsAndConditionsLink("terms_and_conditions_link")
            .addUseCase(
                TenDlcCampaignUseCase.builder()
                    .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                    .useCase(TenDlcCampaignUseCase.UseCase.MARKETING)
                    .build()
            )
            .volume("volume")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .description("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .helpKeywords("help_keywords")
                .helpMessage(
                    "Example Clinic: for help call +1 212 555 0100. Reply STOP to opt out."
                )
                .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .optInKeywords("opt_in_keywords")
                .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                .optOutKeywords("opt_out_keywords")
                .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                .privacyPolicyLink("privacy_policy_link")
                .sandbox(false)
                .termsAndConditionsLink("terms_and_conditions_link")
                .addUseCase(
                    TenDlcCampaignUseCase.builder()
                        .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                        .useCase(TenDlcCampaignUseCase.UseCase.MARKETING)
                        .build()
                )
                .volume("volume")
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
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .description("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .helpKeywords("help_keywords")
                .helpMessage(
                    "Example Clinic: for help call +1 212 555 0100. Reply STOP to opt out."
                )
                .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .optInKeywords("opt_in_keywords")
                .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                .optOutKeywords("opt_out_keywords")
                .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                .privacyPolicyLink("privacy_policy_link")
                .sandbox(false)
                .termsAndConditionsLink("terms_and_conditions_link")
                .addUseCase(
                    TenDlcCampaignUseCase.builder()
                        .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                        .useCase(TenDlcCampaignUseCase.UseCase.MARKETING)
                        .build()
                )
                .volume("volume")
                .build()

        val body = params._body()

        assertThat(body.description()).contains("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
        assertThat(body.helpKeywords()).contains("help_keywords")
        assertThat(body.helpMessage())
            .contains("Example Clinic: for help call +1 212 555 0100. Reply STOP to opt out.")
        assertThat(body.messageFlow()).contains("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
        assertThat(body.optInKeywords()).contains("opt_in_keywords")
        assertThat(body.optInMessage()).contains("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.optOutKeywords()).contains("opt_out_keywords")
        assertThat(body.optOutMessage()).contains("xxxxxxxxxxxxxxxxxxxx")
        assertThat(body.privacyPolicyLink()).contains("privacy_policy_link")
        assertThat(body.sandbox()).contains(false)
        assertThat(body.termsAndConditionsLink()).contains("terms_and_conditions_link")
        assertThat(body.useCases().getOrNull())
            .containsExactly(
                TenDlcCampaignUseCase.builder()
                    .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                    .useCase(TenDlcCampaignUseCase.UseCase.MARKETING)
                    .build()
            )
        assertThat(body.volume()).contains("volume")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .build()

        val body = params._body()
    }
}
