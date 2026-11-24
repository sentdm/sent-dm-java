// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.channels

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.core.JsonValue
import dm.sent.models.channels.sms.MarketCompliance
import dm.sent.models.channels.sms.SmsCreateParams
import dm.sent.models.channels.sms.SmsNumberRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SmsServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val smsServiceAsync = client.channels().sms()

        val apiResponseOfChannelMarketFuture =
            smsServiceAsync.create(
                SmsCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .numberType(SmsCreateParams.NumberType.TEN_DLC)
                    .addAreaCode("415")
                    .addAreaCode("628")
                    .compliance(
                        MarketCompliance.builder()
                            .brand(
                                MarketCompliance.Brand.builder()
                                    .businessName("xxx")
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
                                    .taxId("xx")
                                    .taxIdType("tax_id_type")
                                    .website("website")
                                    .build()
                            )
                            .campaign(
                                MarketCompliance.Campaign.builder()
                                    .description("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                                    .helpKeywords("help_keywords")
                                    .helpMessage("xxxxxxxxxxxxxxxxxxxx")
                                    .inherit(true)
                                    .messageFlow("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                                    .optInKeywords("opt_in_keywords")
                                    .optInMessage("xxxxxxxxxxxxxxxxxxxx")
                                    .optOutKeywords("opt_out_keywords")
                                    .optOutMessage("xxxxxxxxxxxxxxxxxxxx")
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
                    .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
                    .senderValue(null)
                    .build()
            )

        val apiResponseOfChannelMarket = apiResponseOfChannelMarketFuture.get()
        apiResponseOfChannelMarket.validate()
    }
}
