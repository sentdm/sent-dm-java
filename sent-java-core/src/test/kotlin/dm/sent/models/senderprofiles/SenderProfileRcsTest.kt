// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.channels.rcs.RcsAddress
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileRcsTest {

    @Test
    fun create() {
        val senderProfileRcs =
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

        assertThat(senderProfileRcs.description()).isEqualTo("description")
        assertThat(senderProfileRcs.agentUseCase()).contains("agent_use_case")
        assertThat(senderProfileRcs.bannerUrl()).contains("banner_url")
        assertThat(senderProfileRcs.billingCategory()).contains("billing_category")
        assertThat(senderProfileRcs.brandColor()).contains("brand_color")
        assertThat(senderProfileRcs.brandEmail()).contains("brand_email")
        assertThat(senderProfileRcs.brandName()).contains("brand_name")
        assertThat(senderProfileRcs.brandPhoneNumber()).contains("brand_phone_number")
        assertThat(senderProfileRcs.briefCompanyDescription()).contains("brief_company_description")
        assertThat(senderProfileRcs.companyEin()).contains("company_ein")
        assertThat(senderProfileRcs.contactNameAndTitle()).contains("contact_name_and_title")
        assertThat(senderProfileRcs.customerSupportEmail()).contains("customer_support_email")
        assertThat(senderProfileRcs.customerSupportPhoneNumber())
            .contains("customer_support_phone_number")
        assertThat(senderProfileRcs.displayName()).contains("display_name")
        assertThat(senderProfileRcs.entityType()).contains("entity_type")
        assertThat(senderProfileRcs.helpMessage()).contains("help_message")
        assertThat(senderProfileRcs.hostingRegion()).contains("hosting_region")
        assertThat(senderProfileRcs.logoUrl()).contains("logo_url")
        assertThat(senderProfileRcs.officialAddress())
            .contains(
                RcsAddress.builder()
                    .city("city")
                    .country("country")
                    .postalCode("postal_code")
                    .state("state")
                    .street("street")
                    .build()
            )
        assertThat(senderProfileRcs.optInProcessDescription())
            .contains("opt_in_process_description")
        assertThat(senderProfileRcs.optInScreenshotUrl()).contains("opt_in_screenshot_url")
        assertThat(senderProfileRcs.privacyPolicyUrl()).contains("privacy_policy_url")
        assertThat(senderProfileRcs.sampleMessages().getOrNull()).containsExactly("string")
        assertThat(senderProfileRcs.startMessage()).contains("start_message")
        assertThat(senderProfileRcs.stopMessage()).contains("stop_message")
        assertThat(senderProfileRcs.termsAndConditionsUrl()).contains("terms_and_conditions_url")
        assertThat(senderProfileRcs.websiteUrl()).contains("website_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val senderProfileRcs =
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

        val roundtrippedSenderProfileRcs =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(senderProfileRcs),
                jacksonTypeRef<SenderProfileRcs>(),
            )

        assertThat(roundtrippedSenderProfileRcs).isEqualTo(senderProfileRcs)
    }
}
