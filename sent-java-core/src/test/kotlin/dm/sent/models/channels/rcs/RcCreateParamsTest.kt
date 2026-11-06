// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.rcs

import dm.sent.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RcCreateParamsTest {

    @Test
    fun create() {
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
            .helpMessage("For help, visit https://example.com/support or call 1-800-555-0100.")
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
            .startMessage("Welcome to Example Retail! Reply HELP for help or STOP to opt out.")
            .stopMessage("You have been unsubscribed from Example Retail notifications.")
            .termsAndConditionsUrl("https://example.com/terms")
            .websiteUrl("https://example.com")
            .build()
    }

    @Test
    fun headers() {
        val params =
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
                .helpMessage("For help, visit https://example.com/support or call 1-800-555-0100.")
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
                .startMessage("Welcome to Example Retail! Reply HELP for help or STOP to opt out.")
                .stopMessage("You have been unsubscribed from Example Retail notifications.")
                .termsAndConditionsUrl("https://example.com/terms")
                .websiteUrl("https://example.com")
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
        val params = RcCreateParams.builder().build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                .helpMessage("For help, visit https://example.com/support or call 1-800-555-0100.")
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
                .startMessage("Welcome to Example Retail! Reply HELP for help or STOP to opt out.")
                .stopMessage("You have been unsubscribed from Example Retail notifications.")
                .termsAndConditionsUrl("https://example.com/terms")
                .websiteUrl("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.agentUseCase()).contains(RcCreateParams.AgentUseCase.NOTIFICATIONS)
        assertThat(body.bannerUrl()).contains("https://example.com/assets/banner-1440x448.png")
        assertThat(body.brandColor()).contains("#1a73e8")
        assertThat(body.brandEmail()).contains("hello@example.com")
        assertThat(body.brandName()).contains("Example Retail")
        assertThat(body.brandPhoneNumber()).contains("+12125550100")
        assertThat(body.briefCompanyDescription())
            .contains("Example Retail sells home goods across the US and ships to 48 states.")
        assertThat(body.companyEin()).contains("12-3456789")
        assertThat(body.contactNameAndTitle()).contains("Jane Smith, Head of Marketing")
        assertThat(body.customerSupportEmail()).contains("support@example.com")
        assertThat(body.customerSupportPhoneNumber()).contains("+18005550100")
        assertThat(body.description())
            .contains("Order and delivery notifications for Example Retail customers.")
        assertThat(body.displayName()).contains("Example Retail")
        assertThat(body.entityType()).contains("PRIVATE_PROFIT")
        assertThat(body.helpMessage())
            .contains("For help, visit https://example.com/support or call 1-800-555-0100.")
        assertThat(body.logoUrl()).contains("https://example.com/assets/logo-224x224.png")
        assertThat(body.officialAddress())
            .contains(
                RcsAddress.builder()
                    .city("New York")
                    .country("US")
                    .postalCode("10001")
                    .state("NY")
                    .street("123 Main St")
                    .build()
            )
        assertThat(body.optInProcessDescription())
            .contains("Customers opt in at checkout by checking the SMS/RCS notifications box.")
        assertThat(body.optInScreenshotUrl()).isEmpty
        assertThat(body.privacyPolicyUrl()).contains("https://example.com/privacy")
        assertThat(body.sampleMessages().getOrNull())
            .containsExactly("Your order #12345 has shipped and will arrive tomorrow.")
        assertThat(body.startMessage())
            .contains("Welcome to Example Retail! Reply HELP for help or STOP to opt out.")
        assertThat(body.stopMessage())
            .contains("You have been unsubscribed from Example Retail notifications.")
        assertThat(body.termsAndConditionsUrl()).contains("https://example.com/terms")
        assertThat(body.websiteUrl()).contains("https://example.com")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = RcCreateParams.builder().build()

        val body = params._body()
    }
}
