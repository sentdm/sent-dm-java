// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.profiles

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.profiles.campaigns.CampaignCreateParams
import dm.sent.models.profiles.campaigns.CampaignData
import dm.sent.models.profiles.campaigns.CampaignDeleteParams
import dm.sent.models.profiles.campaigns.CampaignListParams
import dm.sent.models.profiles.campaigns.CampaignUpdateParams
import dm.sent.models.profiles.campaigns.MessagingUseCaseUs
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CampaignServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.profiles().campaigns()

        val apiResponseOfTcrCampaignWithUseCasesFuture =
            campaignServiceAsync.create(
                CampaignCreateParams.builder()
                    .profileId("770e8400-e29b-41d4-a716-446655440002")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .campaign(
                        CampaignData.builder()
                            .description("Appointment reminders and account notifications")
                            .name("Customer Notifications")
                            .type("App")
                            .addUseCase(
                                CampaignData.UseCase.builder()
                                    .messagingUseCaseUs(MessagingUseCaseUs.ACCOUNT_NOTIFICATION)
                                    .addSampleMessage(
                                        "Hi {name}, your appointment is confirmed for {date} at {time}."
                                    )
                                    .addSampleMessage(
                                        "Your order #{order_id} has been shipped. Track at {url}"
                                    )
                                    .build()
                            )
                            .helpKeywords("HELP, INFO, SUPPORT")
                            .helpMessage(
                                "Reply STOP to unsubscribe or contact support@acmecorp.com"
                            )
                            .messageFlow(
                                "User signs up on website and opts in to receive SMS notifications"
                            )
                            .optinKeywords("YES, START, SUBSCRIBE")
                            .optinMessage(
                                "You have opted in to Acme Corp notifications. Reply STOP to opt out."
                            )
                            .optoutKeywords("STOP, UNSUBSCRIBE, END")
                            .optoutMessage(
                                "You have been unsubscribed. Reply START to opt back in."
                            )
                            .privacyPolicyLink("https://acmecorp.com/privacy")
                            .termsAndConditionsLink("https://acmecorp.com/terms")
                            .build()
                    )
                    .build()
            )

        val apiResponseOfTcrCampaignWithUseCases = apiResponseOfTcrCampaignWithUseCasesFuture.get()
        apiResponseOfTcrCampaignWithUseCases.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.profiles().campaigns()

        val apiResponseOfTcrCampaignWithUseCasesFuture =
            campaignServiceAsync.update(
                CampaignUpdateParams.builder()
                    .profileId("770e8400-e29b-41d4-a716-446655440002")
                    .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .campaign(
                        CampaignData.builder()
                            .description("Updated appointment reminders and account notifications")
                            .name("Customer Notifications Updated")
                            .type("App")
                            .addUseCase(
                                CampaignData.UseCase.builder()
                                    .messagingUseCaseUs(MessagingUseCaseUs.ACCOUNT_NOTIFICATION)
                                    .addSampleMessage(
                                        "Hi {name}, your appointment is confirmed for {date} at {time}."
                                    )
                                    .addSampleMessage(
                                        "Your order #{order_id} has been shipped. Track at {url}"
                                    )
                                    .build()
                            )
                            .helpKeywords(null)
                            .helpMessage(null)
                            .messageFlow(
                                "User signs up on website and opts in to receive SMS notifications"
                            )
                            .optinKeywords(null)
                            .optinMessage(null)
                            .optoutKeywords(null)
                            .optoutMessage(null)
                            .privacyPolicyLink(null)
                            .termsAndConditionsLink(null)
                            .build()
                    )
                    .build()
            )

        val apiResponseOfTcrCampaignWithUseCases = apiResponseOfTcrCampaignWithUseCasesFuture.get()
        apiResponseOfTcrCampaignWithUseCases.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.profiles().campaigns()

        val campaignsFuture =
            campaignServiceAsync.list(
                CampaignListParams.builder()
                    .profileId("770e8400-e29b-41d4-a716-446655440002")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val campaigns = campaignsFuture.get()
        campaigns.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.profiles().campaigns()

        val future =
            campaignServiceAsync.delete(
                CampaignDeleteParams.builder()
                    .profileId("770e8400-e29b-41d4-a716-446655440002")
                    .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .build()
            )

        val response = future.get()
    }
}
