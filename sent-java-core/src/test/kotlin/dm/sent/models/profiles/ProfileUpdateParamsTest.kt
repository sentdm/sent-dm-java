// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import dm.sent.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileUpdateParamsTest {

    @Test
    fun create() {
        ProfileUpdateParams.builder()
            .profileId("profileId")
            .idempotencyKey("req_abc123_retry1")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .sandbox(false)
            .allowContactSharing(true)
            .allowNumberChangeDuringOnboarding(null)
            .allowTemplateSharing(null)
            .billingContact(
                BillingContactInfo.builder()
                    .email("dev@stainless.com")
                    .name("x")
                    .address("address")
                    .phone("phone")
                    .build()
            )
            .billingModel("organization")
            .brand(
                BrandsBrandData.builder()
                    .compliance(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                            .builder()
                            .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                            .vertical(TcrVertical.PROFESSIONAL)
                            .addDestinationCountry(
                                DestinationCountry.builder().id("US").isMain(false).build()
                            )
                            .expectedMessagingVolume("10000")
                            .isTcrApplication(true)
                            .notes(null)
                            .phoneNumberPrefix("+1")
                            .primaryUseCase("Customer notifications and appointment reminders")
                            .build()
                    )
                    .contact(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                            .builder()
                            .name("John Smith")
                            .businessName("Acme Corp")
                            .email("john@acmecorp.com")
                            .phone("+12025551234")
                            .phoneCountryCode("1")
                            .role("CEO")
                            .build()
                    )
                    .business(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                            .builder()
                            .city("New York")
                            .country("US")
                            .countryOfRegistration("US")
                            .entityType(
                                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                                    .EntityType
                                    .PRIVATE_PROFIT
                            )
                            .legalName("Acme Corporation LLC")
                            .postalCode("10001")
                            .state("NY")
                            .street("123 Main Street")
                            .taxId("12-3456789")
                            .taxIdType("us_ein")
                            .url("https://acmecorp.com")
                            .build()
                    )
                    .build()
            )
            .description("Updated sales department sender profile")
            .icon(null)
            .inheritContacts(null)
            .inheritTcrBrand(null)
            .inheritTcrCampaign(null)
            .inheritTemplates(null)
            .name("Sales Team - Updated")
            .paymentDetails(
                PaymentDetails.builder()
                    .cardNumber("3216699102256101")
                    .cvc("3216")
                    .expiry("11/66")
                    .zipCode("x")
                    .build()
            )
            .sendingPhoneNumber(null)
            .sendingPhoneNumberProfileId(null)
            .sendingWhatsappNumberProfileId(null)
            .shortName("SALES")
            .whatsappPhoneNumber(null)
            .build()
    }

    @Test
    fun pathParams() {
        val params = ProfileUpdateParams.builder().profileId("profileId").build()

        assertThat(params._pathParam(0)).isEqualTo("profileId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            ProfileUpdateParams.builder()
                .profileId("profileId")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .allowContactSharing(true)
                .allowNumberChangeDuringOnboarding(null)
                .allowTemplateSharing(null)
                .billingContact(
                    BillingContactInfo.builder()
                        .email("dev@stainless.com")
                        .name("x")
                        .address("address")
                        .phone("phone")
                        .build()
                )
                .billingModel("organization")
                .brand(
                    BrandsBrandData.builder()
                        .compliance(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                                .builder()
                                .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                                .vertical(TcrVertical.PROFESSIONAL)
                                .addDestinationCountry(
                                    DestinationCountry.builder().id("US").isMain(false).build()
                                )
                                .expectedMessagingVolume("10000")
                                .isTcrApplication(true)
                                .notes(null)
                                .phoneNumberPrefix("+1")
                                .primaryUseCase("Customer notifications and appointment reminders")
                                .build()
                        )
                        .contact(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                                .builder()
                                .name("John Smith")
                                .businessName("Acme Corp")
                                .email("john@acmecorp.com")
                                .phone("+12025551234")
                                .phoneCountryCode("1")
                                .role("CEO")
                                .build()
                        )
                        .business(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                                .builder()
                                .city("New York")
                                .country("US")
                                .countryOfRegistration("US")
                                .entityType(
                                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                                        .EntityType
                                        .PRIVATE_PROFIT
                                )
                                .legalName("Acme Corporation LLC")
                                .postalCode("10001")
                                .state("NY")
                                .street("123 Main Street")
                                .taxId("12-3456789")
                                .taxIdType("us_ein")
                                .url("https://acmecorp.com")
                                .build()
                        )
                        .build()
                )
                .description("Updated sales department sender profile")
                .icon(null)
                .inheritContacts(null)
                .inheritTcrBrand(null)
                .inheritTcrCampaign(null)
                .inheritTemplates(null)
                .name("Sales Team - Updated")
                .paymentDetails(
                    PaymentDetails.builder()
                        .cardNumber("3216699102256101")
                        .cvc("3216")
                        .expiry("11/66")
                        .zipCode("x")
                        .build()
                )
                .sendingPhoneNumber(null)
                .sendingPhoneNumberProfileId(null)
                .sendingWhatsappNumberProfileId(null)
                .shortName("SALES")
                .whatsappPhoneNumber(null)
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
        val params = ProfileUpdateParams.builder().profileId("profileId").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            ProfileUpdateParams.builder()
                .profileId("profileId")
                .idempotencyKey("req_abc123_retry1")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .allowContactSharing(true)
                .allowNumberChangeDuringOnboarding(null)
                .allowTemplateSharing(null)
                .billingContact(
                    BillingContactInfo.builder()
                        .email("dev@stainless.com")
                        .name("x")
                        .address("address")
                        .phone("phone")
                        .build()
                )
                .billingModel("organization")
                .brand(
                    BrandsBrandData.builder()
                        .compliance(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                                .builder()
                                .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                                .vertical(TcrVertical.PROFESSIONAL)
                                .addDestinationCountry(
                                    DestinationCountry.builder().id("US").isMain(false).build()
                                )
                                .expectedMessagingVolume("10000")
                                .isTcrApplication(true)
                                .notes(null)
                                .phoneNumberPrefix("+1")
                                .primaryUseCase("Customer notifications and appointment reminders")
                                .build()
                        )
                        .contact(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                                .builder()
                                .name("John Smith")
                                .businessName("Acme Corp")
                                .email("john@acmecorp.com")
                                .phone("+12025551234")
                                .phoneCountryCode("1")
                                .role("CEO")
                                .build()
                        )
                        .business(
                            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                                .builder()
                                .city("New York")
                                .country("US")
                                .countryOfRegistration("US")
                                .entityType(
                                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                                        .EntityType
                                        .PRIVATE_PROFIT
                                )
                                .legalName("Acme Corporation LLC")
                                .postalCode("10001")
                                .state("NY")
                                .street("123 Main Street")
                                .taxId("12-3456789")
                                .taxIdType("us_ein")
                                .url("https://acmecorp.com")
                                .build()
                        )
                        .build()
                )
                .description("Updated sales department sender profile")
                .icon(null)
                .inheritContacts(null)
                .inheritTcrBrand(null)
                .inheritTcrCampaign(null)
                .inheritTemplates(null)
                .name("Sales Team - Updated")
                .paymentDetails(
                    PaymentDetails.builder()
                        .cardNumber("3216699102256101")
                        .cvc("3216")
                        .expiry("11/66")
                        .zipCode("x")
                        .build()
                )
                .sendingPhoneNumber(null)
                .sendingPhoneNumberProfileId(null)
                .sendingWhatsappNumberProfileId(null)
                .shortName("SALES")
                .whatsappPhoneNumber(null)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.allowContactSharing()).contains(true)
        assertThat(body.allowNumberChangeDuringOnboarding()).isEmpty
        assertThat(body.allowTemplateSharing()).isEmpty
        assertThat(body.billingContact())
            .contains(
                BillingContactInfo.builder()
                    .email("dev@stainless.com")
                    .name("x")
                    .address("address")
                    .phone("phone")
                    .build()
            )
        assertThat(body.billingModel()).contains("organization")
        assertThat(body.brand())
            .contains(
                BrandsBrandData.builder()
                    .compliance(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                            .builder()
                            .brandRelationship(TcrBrandRelationship.SMALL_ACCOUNT)
                            .vertical(TcrVertical.PROFESSIONAL)
                            .addDestinationCountry(
                                DestinationCountry.builder().id("US").isMain(false).build()
                            )
                            .expectedMessagingVolume("10000")
                            .isTcrApplication(true)
                            .notes(null)
                            .phoneNumberPrefix("+1")
                            .primaryUseCase("Customer notifications and appointment reminders")
                            .build()
                    )
                    .contact(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                            .builder()
                            .name("John Smith")
                            .businessName("Acme Corp")
                            .email("john@acmecorp.com")
                            .phone("+12025551234")
                            .phoneCountryCode("1")
                            .role("CEO")
                            .build()
                    )
                    .business(
                        SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                            .builder()
                            .city("New York")
                            .country("US")
                            .countryOfRegistration("US")
                            .entityType(
                                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                                    .EntityType
                                    .PRIVATE_PROFIT
                            )
                            .legalName("Acme Corporation LLC")
                            .postalCode("10001")
                            .state("NY")
                            .street("123 Main Street")
                            .taxId("12-3456789")
                            .taxIdType("us_ein")
                            .url("https://acmecorp.com")
                            .build()
                    )
                    .build()
            )
        assertThat(body.description()).contains("Updated sales department sender profile")
        assertThat(body.icon()).isEmpty
        assertThat(body.inheritContacts()).isEmpty
        assertThat(body.inheritTcrBrand()).isEmpty
        assertThat(body.inheritTcrCampaign()).isEmpty
        assertThat(body.inheritTemplates()).isEmpty
        assertThat(body.name()).contains("Sales Team - Updated")
        assertThat(body.paymentDetails())
            .contains(
                PaymentDetails.builder()
                    .cardNumber("3216699102256101")
                    .cvc("3216")
                    .expiry("11/66")
                    .zipCode("x")
                    .build()
            )
        assertThat(body.sendingPhoneNumber()).isEmpty
        assertThat(body.sendingPhoneNumberProfileId()).isEmpty
        assertThat(body.sendingWhatsappNumberProfileId()).isEmpty
        assertThat(body.shortName()).contains("SALES")
        assertThat(body.whatsappPhoneNumber()).isEmpty
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ProfileUpdateParams.builder().profileId("profileId").build()

        val body = params._body()
    }
}
