// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import dm.sent.core.JsonValue
import dm.sent.core.MultipartField
import dm.sent.core.http.Headers
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmsUpdateParamsTest {

    @Test
    fun create() {
        SmsUpdateParams.builder()
            .country("US")
            .type("ten_dlc")
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
        val params = SmsUpdateParams.builder().country("US").type("ten_dlc").build()

        assertThat(params._pathParam(0)).isEqualTo("US")
        assertThat(params._pathParam(1)).isEqualTo("ten_dlc")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            SmsUpdateParams.builder()
                .country("US")
                .type("ten_dlc")
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
        val params = SmsUpdateParams.builder().country("US").type("ten_dlc").build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            SmsUpdateParams.builder()
                .country("US")
                .type("ten_dlc")
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

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "compliance" to
                            MultipartField.of(
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
                                            .entityType(
                                                MarketCompliance.Brand.EntityType.PRIVATE_PROFIT
                                            )
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
                                                    .addSampleMessage(
                                                        JsonValue.from(mapOf<String, Any>())
                                                    )
                                                    .useCase(
                                                        MarketCompliance.Campaign.UseCase
                                                            .InnerUseCase
                                                            .MARKETING
                                                    )
                                                    .build()
                                            )
                                            .volume("volume")
                                            .build()
                                    )
                                    .build()
                            ),
                        "sandbox" to MultipartField.of(false),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SmsUpdateParams.builder().country("US").type("ten_dlc").build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() }).isEmpty()
    }
}
