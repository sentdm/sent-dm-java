// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignUpdateParamsTest {

    @Test
    fun create() {
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
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                            .builder()
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
    }

    @Test
    fun pathParams() {
        val params =
            CampaignUpdateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .campaign(
                    CampaignData.builder()
                        .description("Updated appointment reminders and account notifications")
                        .name("Customer Notifications Updated")
                        .type("App")
                        .addUseCase(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                                .builder()
                                .messagingUseCaseUs(MessagingUseCaseUs.ACCOUNT_NOTIFICATION)
                                .addSampleMessage(
                                    "Hi {name}, your appointment is confirmed for {date} at {time}."
                                )
                                .addSampleMessage(
                                    "Your order #{order_id} has been shipped. Track at {url}"
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        assertThat(params._pathParam(1)).isEqualTo("b2c3d4e5-f6a7-8901-bcde-f12345678901")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
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
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                                .builder()
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

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("Idempotency-Key", "req_abc123_retry1").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            CampaignUpdateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .campaign(
                    CampaignData.builder()
                        .description("Updated appointment reminders and account notifications")
                        .name("Customer Notifications Updated")
                        .type("App")
                        .addUseCase(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                                .builder()
                                .messagingUseCaseUs(MessagingUseCaseUs.ACCOUNT_NOTIFICATION)
                                .addSampleMessage(
                                    "Hi {name}, your appointment is confirmed for {date} at {time}."
                                )
                                .addSampleMessage(
                                    "Your order #{order_id} has been shipped. Track at {url}"
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                                .builder()
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

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.campaign())
            .isEqualTo(
                CampaignData.builder()
                    .description("Updated appointment reminders and account notifications")
                    .name("Customer Notifications Updated")
                    .type("App")
                    .addUseCase(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                            .builder()
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
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CampaignUpdateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .campaign(
                    CampaignData.builder()
                        .description("Updated appointment reminders and account notifications")
                        .name("Customer Notifications Updated")
                        .type("App")
                        .addUseCase(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                                .builder()
                                .messagingUseCaseUs(MessagingUseCaseUs.ACCOUNT_NOTIFICATION)
                                .addSampleMessage(
                                    "Hi {name}, your appointment is confirmed for {date} at {time}."
                                )
                                .addSampleMessage(
                                    "Your order #{order_id} has been shipped. Track at {url}"
                                )
                                .build()
                        )
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.campaign())
            .isEqualTo(
                CampaignData.builder()
                    .description("Updated appointment reminders and account notifications")
                    .name("Customer Notifications Updated")
                    .type("App")
                    .addUseCase(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                            .builder()
                            .messagingUseCaseUs(MessagingUseCaseUs.ACCOUNT_NOTIFICATION)
                            .addSampleMessage(
                                "Hi {name}, your appointment is confirmed for {date} at {time}."
                            )
                            .addSampleMessage(
                                "Your order #{order_id} has been shipped. Track at {url}"
                            )
                            .build()
                    )
                    .build()
            )
    }
}
