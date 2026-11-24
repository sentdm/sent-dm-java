// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels.sms

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.core.JsonValue
import dm.sent.models.channels.sms.tendlc.TenDlcAddCampaignParams
import dm.sent.models.channels.sms.tendlc.TenDlcCampaignUseCase
import dm.sent.models.channels.sms.tendlc.TenDlcListCampaignsParams
import dm.sent.models.channels.sms.tendlc.TenDlcUpdateCampaignParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TenDlcServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun addCampaign() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tenDlcServiceAsync = client.channels().sms().tenDlc()

        val apiResponseOfChannelMarketFuture =
            tenDlcServiceAsync.addCampaign(
                TenDlcAddCampaignParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .description("Appointment reminders for patients who opted in when booking.")
                    .helpKeywords("help_keywords")
                    .helpMessage("xxxxxxxxxxxxxxxxxxxx")
                    .messageFlow("Patients opt in on the booking form by checking a consent box.")
                    .optInKeywords("opt_in_keywords")
                    .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                    .optOutKeywords("opt_out_keywords")
                    .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
                    .privacyPolicyLink("privacy_policy_link")
                    .termsAndConditionsLink("terms_and_conditions_link")
                    .addUseCase(
                        TenDlcCampaignUseCase.builder()
                            .addSampleMessage(
                                JsonValue.from(
                                    "Reminder: your appointment is tomorrow at 10:00. Reply STOP to opt out."
                                )
                            )
                            .useCase(TenDlcCampaignUseCase.UseCase.ACCOUNT_NOTIFICATION)
                            .build()
                    )
                    .volume("volume")
                    .sandbox(false)
                    .build()
            )

        val apiResponseOfChannelMarket = apiResponseOfChannelMarketFuture.get()
        apiResponseOfChannelMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listCampaigns() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tenDlcServiceAsync = client.channels().sms().tenDlc()

        val responseFuture =
            tenDlcServiceAsync.listCampaigns(
                TenDlcListCampaignsParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateCampaign() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val tenDlcServiceAsync = client.channels().sms().tenDlc()

        val apiResponseOfChannelMarketFuture =
            tenDlcServiceAsync.updateCampaign(
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
            )

        val apiResponseOfChannelMarket = apiResponseOfChannelMarketFuture.get()
        apiResponseOfChannelMarket.validate()
    }
}
