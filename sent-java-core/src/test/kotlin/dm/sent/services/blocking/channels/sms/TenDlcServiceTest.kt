// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels.sms

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.models.channels.sms.MarketCompliance
import dm.sent.models.channels.sms.SmsNumberRequest
import dm.sent.models.channels.sms.tendlc.TenDlcAddCampaignParams
import dm.sent.models.channels.sms.tendlc.TenDlcAddNumbersParams
import dm.sent.models.channels.sms.tendlc.TenDlcRetrieveComplianceParams
import dm.sent.models.channels.sms.tendlc.TenDlcUpdateCampaignParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TenDlcServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun addCampaign() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSmsMarket =
            tenDlcService.addCampaign(
                TenDlcAddCampaignParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
                    .sandbox(false)
                    .build()
            )

        apiResponseOfSmsMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun addNumbers() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSmsMarket =
            tenDlcService.addNumbers(
                TenDlcAddNumbersParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                    .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                    .build()
            )

        apiResponseOfSmsMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieveCompliance() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSuppliedCompliance =
            tenDlcService.retrieveCompliance(
                TenDlcRetrieveComplianceParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfSuppliedCompliance.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun updateCampaign() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val tenDlcService = client.channels().sms().tenDlc()

        val apiResponseOfSmsMarket =
            tenDlcService.updateCampaign(
                TenDlcUpdateCampaignParams.builder()
                    .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
                    .sandbox(false)
                    .build()
            )

        apiResponseOfSmsMarket.validate()
    }
}
