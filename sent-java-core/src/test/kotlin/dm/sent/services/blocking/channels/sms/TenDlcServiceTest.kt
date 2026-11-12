// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels.sms

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.models.channels.sms.SmsNumberRequest
import dm.sent.models.channels.sms.tendlc.TenDlcAddCampaignParams
import dm.sent.models.channels.sms.tendlc.TenDlcAddNumbersParams
import dm.sent.models.channels.sms.tendlc.TenDlcCampaignUseCase
import dm.sent.models.channels.sms.tendlc.TenDlcRetrieveComplianceParams
import dm.sent.models.channels.sms.tendlc.TenDlcUpdateCampaignParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TenDlcServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun addCampaign() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSmsMarket =
            tenDlcService.addCampaign(
                TenDlcAddCampaignParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .description("description")
                    .helpKeywords("help_keywords")
                    .helpMessage("help_message")
                    .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    .optInKeywords("opt_in_keywords")
                    .optInMessage("opt_in_message")
                    .optOutKeywords("opt_out_keywords")
                    .optOutMessage("opt_out_message")
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
            )

        apiResponseOfSmsMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun addNumbers() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSmsMarket =
            tenDlcService.addNumbers(
                TenDlcAddNumbersParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                    .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                    .build()
            )

        apiResponseOfSmsMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCompliance() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSuppliedCompliance =
            tenDlcService.retrieveCompliance(
                TenDlcRetrieveComplianceParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfSuppliedCompliance.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateCampaign() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSmsMarket =
            tenDlcService.updateCampaign(
                TenDlcUpdateCampaignParams.builder()
                    .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .description("description")
                    .helpKeywords("help_keywords")
                    .helpMessage("help_message")
                    .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    .optInKeywords("opt_in_keywords")
                    .optInMessage("opt_in_message")
                    .optOutKeywords("opt_out_keywords")
                    .optOutMessage("opt_out_message")
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
            )

        apiResponseOfSmsMarket.validate()
    }
}
