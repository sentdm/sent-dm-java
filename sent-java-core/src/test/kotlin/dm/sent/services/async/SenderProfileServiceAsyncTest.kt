// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.core.JsonValue
import dm.sent.models.channels.rcs.RcsAddress
import dm.sent.models.channels.sms.MarketCompliance
import dm.sent.models.channels.sms.SmsNumberRequest
import dm.sent.models.senderprofiles.SenderProfileBillingRequest
import dm.sent.models.senderprofiles.SenderProfileChannels
import dm.sent.models.senderprofiles.SenderProfileCreateParams
import dm.sent.models.senderprofiles.SenderProfileRcs
import dm.sent.models.senderprofiles.SenderProfileSms
import dm.sent.models.senderprofiles.SenderProfileUpdateParams
import dm.sent.models.senderprofiles.SenderProfileWhatsapp
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SenderProfileServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderProfileServiceAsync = client.senderProfiles()

        val apiResponseOfSenderProfileFuture =
            senderProfileServiceAsync.create(
                SenderProfileCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .sandbox(false)
                    .billing(SenderProfileBillingRequest.builder().inherit(true).build())
                    .channels(
                        SenderProfileChannels.builder()
                            .rcs(
                                SenderProfileRcs.builder()
                                    .description("description")
                                    .agentUseCase("agent_use_case")
                                    .bannerUrl("banner_url")
                                    .billingCategory("billing_category")
                                    .brandColor("brand_color")
                                    .brandEmail("brand_email")
                                    .brandName("brand_name")
                                    .brandPhoneNumber("brand_phone_number")
                                    .briefCompanyDescription("brief_company_description")
                                    .companyEin("company_ein")
                                    .contactNameAndTitle("contact_name_and_title")
                                    .customerSupportEmail("customer_support_email")
                                    .customerSupportPhoneNumber("customer_support_phone_number")
                                    .displayName("display_name")
                                    .entityType("entity_type")
                                    .helpMessage("help_message")
                                    .hostingRegion("hosting_region")
                                    .logoUrl("logo_url")
                                    .officialAddress(
                                        RcsAddress.builder()
                                            .city("city")
                                            .country("country")
                                            .postalCode("postal_code")
                                            .state("state")
                                            .street("street")
                                            .build()
                                    )
                                    .optInProcessDescription("opt_in_process_description")
                                    .optInScreenshotUrl("opt_in_screenshot_url")
                                    .privacyPolicyUrl("privacy_policy_url")
                                    .addSampleMessage("string")
                                    .startMessage("start_message")
                                    .stopMessage("stop_message")
                                    .termsAndConditionsUrl("terms_and_conditions_url")
                                    .websiteUrl("website_url")
                                    .build()
                            )
                            .sms(
                                SenderProfileSms.builder()
                                    .country("US")
                                    .addAreaCode("string")
                                    .numberType("TEN_DLC")
                                    .addNumber(
                                        SmsNumberRequest.builder()
                                            .areaCode("area_code")
                                            .quantity(0)
                                            .build()
                                    )
                                    .senderValue("sender_value")
                                    .build()
                            )
                            .whatsapp(
                                SenderProfileWhatsapp.builder()
                                    .phoneNumberId("phone_number_id")
                                    .wabaId("waba_id")
                                    .build()
                            )
                            .build()
                    )
                    .compliance(
                        MarketCompliance.builder()
                            .brand(
                                MarketCompliance.Brand.builder()
                                    .businessName("business_name")
                                    .city("city")
                                    .contactEmail("dev@stainless.com")
                                    .contactName("contact_name")
                                    .contactPhone("contact_phone")
                                    .country("country")
                                    .einIssuingCountry("ein_issuing_country")
                                    .entityType(MarketCompliance.Brand.EntityType.PRIVATE_PROFIT)
                                    .inherit(true)
                                    .legalName("legal_name")
                                    .postalCode("postal_code")
                                    .state("state")
                                    .street("street")
                                    .taxId("tax_id")
                                    .taxIdType("tax_id_type")
                                    .website("website")
                                    .build()
                            )
                            .campaign(
                                MarketCompliance.Campaign.builder()
                                    .description("description")
                                    .helpKeywords("help_keywords")
                                    .helpMessage("help_message")
                                    .inherit(true)
                                    .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                                    .optInKeywords("opt_in_keywords")
                                    .optInMessage("opt_in_message")
                                    .optOutKeywords("opt_out_keywords")
                                    .optOutMessage("opt_out_message")
                                    .privacyPolicyLink("privacy_policy_link")
                                    .termsAndConditionsLink("terms_and_conditions_link")
                                    .addUseCase(
                                        MarketCompliance.Campaign.UseCase.builder()
                                            .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                                            .useCase(
                                                MarketCompliance.Campaign.UseCase.InnerUseCase
                                                    .MARKETING
                                            )
                                            .build()
                                    )
                                    .volume("volume")
                                    .build()
                            )
                            .build()
                    )
                    .description(null)
                    .name("Example Retail")
                    .notifications(null)
                    .shortName("Example")
                    .build()
            )

        val apiResponseOfSenderProfile = apiResponseOfSenderProfileFuture.get()
        apiResponseOfSenderProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderProfileServiceAsync = client.senderProfiles()

        val apiResponseOfSenderProfileFuture =
            senderProfileServiceAsync.retrieve("770e8400-e29b-41d4-a716-446655440002")

        val apiResponseOfSenderProfile = apiResponseOfSenderProfileFuture.get()
        apiResponseOfSenderProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderProfileServiceAsync = client.senderProfiles()

        val apiResponseOfSenderProfileFuture =
            senderProfileServiceAsync.update(
                SenderProfileUpdateParams.builder()
                    .id("770e8400-e29b-41d4-a716-446655440002")
                    .idempotencyKey("req_abc123_retry1")
                    .sandbox(false)
                    .description(null)
                    .name("Example Retail Renamed")
                    .notifications(null)
                    .shortName("EXMPL")
                    .build()
            )

        val apiResponseOfSenderProfile = apiResponseOfSenderProfileFuture.get()
        apiResponseOfSenderProfile.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderProfileServiceAsync = client.senderProfiles()

        val pageFuture = senderProfileServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderProfileServiceAsync = client.senderProfiles()

        val future = senderProfileServiceAsync.delete("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val response = future.get()
    }
}
