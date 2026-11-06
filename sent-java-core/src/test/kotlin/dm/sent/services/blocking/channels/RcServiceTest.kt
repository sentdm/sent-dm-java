// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.channels.rcs.RcCreateParams
import dm.sent.models.channels.rcs.RcsAddress
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RcServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val rcService = client.channels().rcs()

        val apiResponseOfRcsAgent =
            rcService.create(
                RcCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .agentUseCase(RcCreateParams.AgentUseCase.NOTIFICATIONS)
                    .bannerUrl("https://example.com/assets/banner-1440x448.png")
                    .brandColor("#1a73e8")
                    .brandEmail("hello@example.com")
                    .brandName("Example Retail")
                    .brandPhoneNumber("+12125550100")
                    .briefCompanyDescription(
                        "Example Retail sells home goods across the US and ships to 48 states."
                    )
                    .companyEin("12-3456789")
                    .contactNameAndTitle("Jane Smith, Head of Marketing")
                    .customerSupportEmail("support@example.com")
                    .customerSupportPhoneNumber("+18005550100")
                    .description("Order and delivery notifications for Example Retail customers.")
                    .displayName("Example Retail")
                    .entityType("PRIVATE_PROFIT")
                    .helpMessage(
                        "For help, visit https://example.com/support or call 1-800-555-0100."
                    )
                    .logoUrl("https://example.com/assets/logo-224x224.png")
                    .officialAddress(
                        RcsAddress.builder()
                            .city("New York")
                            .country("US")
                            .postalCode("10001")
                            .state("NY")
                            .street("123 Main St")
                            .build()
                    )
                    .optInProcessDescription(
                        "Customers opt in at checkout by checking the SMS/RCS notifications box."
                    )
                    .optInScreenshotUrl(null)
                    .privacyPolicyUrl("https://example.com/privacy")
                    .addSampleMessage("Your order #12345 has shipped and will arrive tomorrow.")
                    .startMessage(
                        "Welcome to Example Retail! Reply HELP for help or STOP to opt out."
                    )
                    .stopMessage("You have been unsubscribed from Example Retail notifications.")
                    .termsAndConditionsUrl("https://example.com/terms")
                    .websiteUrl("https://example.com")
                    .build()
            )

        apiResponseOfRcsAgent.validate()
    }
}
