// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

import dm.sent.core.JsonValue
import dm.sent.core.http.Headers
import dm.sent.models.channels.sms.MarketCompliance
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenDlcUpdateCampaignParamsTest {

    @Test
    fun create() {
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
                                        MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING
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
    }

    @Test
    fun pathParams() {
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
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
                                            MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING
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
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                                            MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING
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

        val body = params._body()

        assertThat(body.compliance())
            .contains(
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
                                        MarketCompliance.Campaign.UseCase.InnerUseCase.MARKETING
                                    )
                                    .build()
                            )
                            .volume("volume")
                            .build()
                    )
                    .build()
            )
        assertThat(body.sandbox()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TenDlcUpdateCampaignParams.builder()
                .campaignId("3f2a6c1e-8b4d-4e2a-9c7f-1d5b0a9e4c21")
                .build()

        val body = params._body()
    }
}
