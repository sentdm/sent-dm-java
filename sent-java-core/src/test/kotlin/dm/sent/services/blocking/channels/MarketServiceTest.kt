// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking.channels

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.core.JsonValue
import dm.sent.models.channels.markets.MarketAddNumbersParams
import dm.sent.models.channels.markets.MarketListNumbersParams
import dm.sent.models.channels.markets.MarketListParams
import dm.sent.models.channels.markets.MarketReplaceNumbersParams
import dm.sent.models.channels.markets.MarketRetrieveParams
import dm.sent.models.channels.markets.MarketUpdateParams
import dm.sent.models.channels.sms.MarketCompliance
import dm.sent.models.channels.sms.SmsNumberRequest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MarketServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val marketService = client.channels().markets()

        val apiResponseOfChannelMarket =
            marketService.retrieve(
                MarketRetrieveParams.builder()
                    .channel("sms")
                    .country("US")
                    .type("ten_dlc")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfChannelMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val marketService = client.channels().markets()

        val apiResponseOfChannelMarket =
            marketService.update(
                MarketUpdateParams.builder()
                    .channel("sms")
                    .country("US")
                    .type("ten_dlc")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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
                    .sandbox(false)
                    .build()
            )

        apiResponseOfChannelMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val marketService = client.channels().markets()

        val apiResponseOfListOfChannelMarket =
            marketService.list(
                MarketListParams.builder()
                    .channel("channel")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfListOfChannelMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun addNumbers() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val marketService = client.channels().markets()

        val apiResponseOfChannelMarket =
            marketService.addNumbers(
                MarketAddNumbersParams.builder()
                    .channel("sms")
                    .country("US")
                    .type("TEN_DLC")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                    .addNumber(SmsNumberRequest.builder().areaCode("212").quantity(1).build())
                    .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                    .build()
            )

        apiResponseOfChannelMarket.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listNumbers() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val marketService = client.channels().markets()

        val apiResponseOfMarketNumbers =
            marketService.listNumbers(
                MarketListNumbersParams.builder()
                    .channel("channel")
                    .country("country")
                    .type("type")
                    .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfMarketNumbers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun replaceNumbers() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val marketService = client.channels().markets()

        val apiResponseOfChannelMarket =
            marketService.replaceNumbers(
                MarketReplaceNumbersParams.builder()
                    .channel("sms")
                    .country("US")
                    .type("TEN_DLC")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .addNumber(SmsNumberRequest.builder().areaCode("415").quantity(2).build())
                    .addNumber(SmsNumberRequest.builder().areaCode("212").quantity(1).build())
                    .campaignId("8f14e45f-ceea-467f-a8f0-7c2a3d1b9e01")
                    .build()
            )

        apiResponseOfChannelMarket.validate()
    }
}
