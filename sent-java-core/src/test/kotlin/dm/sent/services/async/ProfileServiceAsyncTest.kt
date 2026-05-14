// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.profiles.ProfileCompleteParams
import dm.sent.models.profiles.ProfileCreateParams
import dm.sent.models.profiles.ProfileDeleteParams
import dm.sent.models.profiles.ProfileListParams
import dm.sent.models.profiles.ProfileRetrieveParams
import dm.sent.models.profiles.ProfileUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProfileServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val profileFuture =
            profileServiceAsync.create(
                ProfileCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .allowContactSharing(true)
                    .allowTemplateSharing(false)
                    .billingContact(
                        ProfileCreateParams.BillingContact.builder()
                            .email("billing@acmecorp.com")
                            .name("Acme Corp")
                            .address("123 Main Street, New York, NY 10001, US")
                            .phone("+12025551234")
                            .build()
                    )
                    .billingModel("profile")
                    .brand(
                        ProfileCreateParams.Brand.builder()
                            .compliance(
                                ProfileCreateParams.Brand.Compliance.builder()
                                    .brandRelationship(
                                        ProfileCreateParams.Brand.Compliance.BrandRelationship
                                            .SMALL_ACCOUNT
                                    )
                                    .vertical(
                                        ProfileCreateParams.Brand.Compliance.Vertical.PROFESSIONAL
                                    )
                                    .addDestinationCountry(
                                        ProfileCreateParams.Brand.Compliance.DestinationCountry
                                            .builder()
                                            .id("US")
                                            .isMain(false)
                                            .build()
                                    )
                                    .expectedMessagingVolume("10000")
                                    .isTcrApplication(true)
                                    .notes(null)
                                    .phoneNumberPrefix("+1")
                                    .primaryUseCase(
                                        "Customer notifications and appointment reminders"
                                    )
                                    .build()
                            )
                            .contact(
                                ProfileCreateParams.Brand.Contact.builder()
                                    .name("John Smith")
                                    .businessName("Acme Corp")
                                    .email("john@acmecorp.com")
                                    .phone("+12025551234")
                                    .phoneCountryCode("1")
                                    .role("CEO")
                                    .build()
                            )
                            .business(
                                ProfileCreateParams.Brand.Business.builder()
                                    .city("New York")
                                    .country("US")
                                    .countryOfRegistration("US")
                                    .entityType(
                                        ProfileCreateParams.Brand.Business.EntityType.PRIVATE_PROFIT
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
                    .description("Sales department sender profile")
                    .icon("https://example.com/sales-icon.png")
                    .inheritContacts(true)
                    .inheritTcrBrand(false)
                    .inheritTcrCampaign(false)
                    .inheritTemplates(true)
                    .name("Sales Team")
                    .paymentDetails(
                        ProfileCreateParams.PaymentDetails.builder()
                            .cardNumber("4111111111111111")
                            .cvc("123")
                            .expiry("09/27")
                            .zipCode("10001")
                            .build()
                    )
                    .sandbox(false)
                    .shortName("SALES")
                    .whatsappBusinessAccount(
                        ProfileCreateParams.WhatsappBusinessAccount.builder()
                            .accessToken("EAAxxxxxxxxxxxxxxx")
                            .wabaId("123456789012345")
                            .phoneNumberId("987654321098765")
                            .build()
                    )
                    .build()
            )

        val profile = profileFuture.get()
        profile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val profileFuture =
            profileServiceAsync.retrieve(
                ProfileRetrieveParams.builder()
                    .profileId("profileId")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val profile = profileFuture.get()
        profile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val profileFuture =
            profileServiceAsync.update(
                ProfileUpdateParams.builder()
                    .profileId("profileId")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .allowContactSharing(true)
                    .allowNumberChangeDuringOnboarding(null)
                    .allowTemplateSharing(null)
                    .billingContact(
                        ProfileUpdateParams.BillingContact.builder()
                            .email("dev@stainless.com")
                            .name("x")
                            .address("address")
                            .phone("phone")
                            .build()
                    )
                    .billingModel("organization")
                    .brand(
                        ProfileUpdateParams.Brand.builder()
                            .compliance(
                                ProfileUpdateParams.Brand.Compliance.builder()
                                    .brandRelationship(
                                        ProfileUpdateParams.Brand.Compliance.BrandRelationship
                                            .SMALL_ACCOUNT
                                    )
                                    .vertical(
                                        ProfileUpdateParams.Brand.Compliance.Vertical.PROFESSIONAL
                                    )
                                    .addDestinationCountry(
                                        ProfileUpdateParams.Brand.Compliance.DestinationCountry
                                            .builder()
                                            .id("US")
                                            .isMain(false)
                                            .build()
                                    )
                                    .expectedMessagingVolume("10000")
                                    .isTcrApplication(true)
                                    .notes(null)
                                    .phoneNumberPrefix("+1")
                                    .primaryUseCase(
                                        "Customer notifications and appointment reminders"
                                    )
                                    .build()
                            )
                            .contact(
                                ProfileUpdateParams.Brand.Contact.builder()
                                    .name("John Smith")
                                    .businessName("Acme Corp")
                                    .email("john@acmecorp.com")
                                    .phone("+12025551234")
                                    .phoneCountryCode("1")
                                    .role("CEO")
                                    .build()
                            )
                            .business(
                                ProfileUpdateParams.Brand.Business.builder()
                                    .city("New York")
                                    .country("US")
                                    .countryOfRegistration("US")
                                    .entityType(
                                        ProfileUpdateParams.Brand.Business.EntityType.PRIVATE_PROFIT
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
                        ProfileUpdateParams.PaymentDetails.builder()
                            .cardNumber("3216699102256101")
                            .cvc("3216")
                            .expiry("11/66")
                            .zipCode("x")
                            .build()
                    )
                    .sandbox(false)
                    .sendingPhoneNumber(null)
                    .sendingPhoneNumberProfileId(null)
                    .sendingWhatsappNumberProfileId(null)
                    .shortName("SALES")
                    .whatsappPhoneNumber(null)
                    .build()
            )

        val profile = profileFuture.get()
        profile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val profilesFuture =
            profileServiceAsync.list(
                ProfileListParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val profiles = profilesFuture.get()
        profiles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val future =
            profileServiceAsync.delete(
                ProfileDeleteParams.builder()
                    .profileId("profileId")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun complete() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val responseFuture =
            profileServiceAsync.complete(
                ProfileCompleteParams.builder()
                    .profileId("660e8400-e29b-41d4-a716-446655440000")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .webHookUrl("https://your-app.com/webhook/profile-complete")
                    .sandbox(false)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
