// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.channels.rcs.RcsAddress
import dm.sent.models.channels.sms.SmsNumberRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileChannelsTest {

    @Test
    fun create() {
        val senderProfileChannels =
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
                        .country("x")
                        .addAreaCode("string")
                        .numberType("number_type")
                        .addNumber(
                            SmsNumberRequest.builder().areaCode("area_code").quantity(0).build()
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

        assertThat(senderProfileChannels.rcs())
            .contains(
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
        assertThat(senderProfileChannels.sms())
            .contains(
                SenderProfileSms.builder()
                    .country("x")
                    .addAreaCode("string")
                    .numberType("number_type")
                    .addNumber(SmsNumberRequest.builder().areaCode("area_code").quantity(0).build())
                    .senderValue("sender_value")
                    .build()
            )
        assertThat(senderProfileChannels.whatsapp())
            .contains(
                SenderProfileWhatsapp.builder()
                    .phoneNumberId("phone_number_id")
                    .wabaId("waba_id")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val senderProfileChannels =
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
                        .country("x")
                        .addAreaCode("string")
                        .numberType("number_type")
                        .addNumber(
                            SmsNumberRequest.builder().areaCode("area_code").quantity(0).build()
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

        val roundtrippedSenderProfileChannels =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(senderProfileChannels),
                jacksonTypeRef<SenderProfileChannels>(),
            )

        assertThat(roundtrippedSenderProfileChannels).isEqualTo(senderProfileChannels)
    }
}
