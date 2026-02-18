// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.brands

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.models.brands.campaigns.CampaignCreateParams
import dm.sent.models.brands.campaigns.CampaignData
import dm.sent.models.brands.campaigns.CampaignDeleteParams
import dm.sent.models.brands.campaigns.CampaignUpdateParams
import dm.sent.models.brands.campaigns.MessagingUseCaseUs
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CampaignServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val campaignService = client.brands().campaigns()

        val apiResponseTcrCampaignWithUseCases =
            campaignService.create(
                CampaignCreateParams.builder()
                    .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
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

        apiResponseTcrCampaignWithUseCases.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val campaignService = client.brands().campaigns()

        val apiResponseTcrCampaignWithUseCases =
            campaignService.update(
                CampaignUpdateParams.builder()
                    .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                    .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
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

        apiResponseTcrCampaignWithUseCases.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val campaignService = client.brands().campaigns()

        val campaigns = campaignService.list("a1b2c3d4-e5f6-7890-abcd-ef1234567890")

        campaigns.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val campaignService = client.brands().campaigns()

        campaignService.delete(
            CampaignDeleteParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .testMode(false)
                .build()
        )
    }
}
