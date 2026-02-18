// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignCreateParamsTest {

    @Test
    fun create() {
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
                    .helpMessage("Reply STOP to unsubscribe or contact support@acmecorp.com")
                    .messageFlow(
                        "User signs up on website and opts in to receive SMS notifications"
                    )
                    .optinKeywords("YES, START, SUBSCRIBE")
                    .optinMessage(
                        "You have opted in to Acme Corp notifications. Reply STOP to opt out."
                    )
                    .optoutKeywords("STOP, UNSUBSCRIBE, END")
                    .optoutMessage("You have been unsubscribed. Reply START to opt back in.")
                    .privacyPolicyLink("https://acmecorp.com/privacy")
                    .termsAndConditionsLink("https://acmecorp.com/terms")
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CampaignCreateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
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
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
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
                        .helpMessage("Reply STOP to unsubscribe or contact support@acmecorp.com")
                        .messageFlow(
                            "User signs up on website and opts in to receive SMS notifications"
                        )
                        .optinKeywords("YES, START, SUBSCRIBE")
                        .optinMessage(
                            "You have opted in to Acme Corp notifications. Reply STOP to opt out."
                        )
                        .optoutKeywords("STOP, UNSUBSCRIBE, END")
                        .optoutMessage("You have been unsubscribed. Reply START to opt back in.")
                        .privacyPolicyLink("https://acmecorp.com/privacy")
                        .termsAndConditionsLink("https://acmecorp.com/terms")
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
            CampaignCreateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
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
                        .build()
                )
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                        .helpMessage("Reply STOP to unsubscribe or contact support@acmecorp.com")
                        .messageFlow(
                            "User signs up on website and opts in to receive SMS notifications"
                        )
                        .optinKeywords("YES, START, SUBSCRIBE")
                        .optinMessage(
                            "You have opted in to Acme Corp notifications. Reply STOP to opt out."
                        )
                        .optoutKeywords("STOP, UNSUBSCRIBE, END")
                        .optoutMessage("You have been unsubscribed. Reply START to opt back in.")
                        .privacyPolicyLink("https://acmecorp.com/privacy")
                        .termsAndConditionsLink("https://acmecorp.com/terms")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.campaign())
            .isEqualTo(
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
                    .helpMessage("Reply STOP to unsubscribe or contact support@acmecorp.com")
                    .messageFlow(
                        "User signs up on website and opts in to receive SMS notifications"
                    )
                    .optinKeywords("YES, START, SUBSCRIBE")
                    .optinMessage(
                        "You have opted in to Acme Corp notifications. Reply STOP to opt out."
                    )
                    .optoutKeywords("STOP, UNSUBSCRIBE, END")
                    .optoutMessage("You have been unsubscribed. Reply START to opt back in.")
                    .privacyPolicyLink("https://acmecorp.com/privacy")
                    .termsAndConditionsLink("https://acmecorp.com/terms")
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CampaignCreateParams.builder()
                .brandId("a1b2c3d4-e5f6-7890-abcd-ef1234567890")
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
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.campaign())
            .isEqualTo(
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
                    .build()
            )
    }
}
