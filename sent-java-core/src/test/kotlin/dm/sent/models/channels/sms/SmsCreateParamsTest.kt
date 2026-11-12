// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import dm.sent.core.JsonValue
import dm.sent.core.http.Headers
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmsCreateParamsTest {

    @Test
    fun create() {
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
            .country("US")
            .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
            .senderValue(null)
            .build()
    }

    @Test
    fun headers() {
        val params =
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
                .country("US")
                .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
                .senderValue(null)
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
            SmsCreateParams.builder().numberType(SmsCreateParams.NumberType.TEN_DLC).build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
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
                .country("US")
                .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
                .senderValue(null)
                .build()

        val body = params._body()

        assertThat(body.sandbox()).contains(false)
        assertThat(body.numberType()).isEqualTo(SmsCreateParams.NumberType.TEN_DLC)
        assertThat(body.areaCodes().getOrNull()).containsExactly("415", "628")
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
        assertThat(body.country()).contains("US")
        assertThat(body.numbers().getOrNull())
            .containsExactly(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
        assertThat(body.senderValue()).isEmpty
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SmsCreateParams.builder().numberType(SmsCreateParams.NumberType.TEN_DLC).build()

        val body = params._body()

        assertThat(body.numberType()).isEqualTo(SmsCreateParams.NumberType.TEN_DLC)
    }
}
