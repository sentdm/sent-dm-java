// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarketComplianceTest {

    @Test
    fun create() {
        val marketCompliance =
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
                                .useCase(MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING)
                                .build()
                        )
                        .volume("volume")
                        .build()
                )
                .build()

        assertThat(marketCompliance.brand())
            .contains(
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
        assertThat(marketCompliance.campaign())
            .contains(
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
                            .useCase(MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING)
                            .build()
                    )
                    .volume("volume")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val marketCompliance =
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
                                .useCase(MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING)
                                .build()
                        )
                        .volume("volume")
                        .build()
                )
                .build()

        val roundtrippedMarketCompliance =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(marketCompliance),
                jacksonTypeRef<MarketCompliance>(),
            )

        assertThat(roundtrippedMarketCompliance).isEqualTo(marketCompliance)
    }
}
