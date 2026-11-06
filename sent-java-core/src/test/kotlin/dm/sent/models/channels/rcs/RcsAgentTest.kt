// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.rcs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RcsAgentTest {

    @Test
    fun create() {
        val rcsAgent =
            RcsAgent.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .agentUseCase("agent_use_case")
                .brandColor("brand_color")
                .brandEmail("brand_email")
                .brandName("brand_name")
                .brandPhoneNumber("brand_phone_number")
                .briefCompanyDescription("brief_company_description")
                .companyEin("company_ein")
                .contactNameAndTitle("contact_name_and_title")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerSupportEmail("customer_support_email")
                .customerSupportPhoneNumber("customer_support_phone_number")
                .description("description")
                .displayName("display_name")
                .entityType("entity_type")
                .helpMessage("help_message")
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
                .phoneNumber("phone_number")
                .privacyPolicyUrl("privacy_policy_url")
                .reason("reason")
                .reasonCode("reason_code")
                .addSampleMessage("string")
                .startMessage("start_message")
                .status(RcsAgent.Status.PROVISIONING)
                .stopMessage("stop_message")
                .termsAndConditionsUrl("terms_and_conditions_url")
                .websiteUrl("website_url")
                .build()

        assertThat(rcsAgent.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(rcsAgent.agentUseCase()).contains("agent_use_case")
        assertThat(rcsAgent.brandColor()).contains("brand_color")
        assertThat(rcsAgent.brandEmail()).contains("brand_email")
        assertThat(rcsAgent.brandName()).contains("brand_name")
        assertThat(rcsAgent.brandPhoneNumber()).contains("brand_phone_number")
        assertThat(rcsAgent.briefCompanyDescription()).contains("brief_company_description")
        assertThat(rcsAgent.companyEin()).contains("company_ein")
        assertThat(rcsAgent.contactNameAndTitle()).contains("contact_name_and_title")
        assertThat(rcsAgent.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(rcsAgent.customerSupportEmail()).contains("customer_support_email")
        assertThat(rcsAgent.customerSupportPhoneNumber()).contains("customer_support_phone_number")
        assertThat(rcsAgent.description()).contains("description")
        assertThat(rcsAgent.displayName()).contains("display_name")
        assertThat(rcsAgent.entityType()).contains("entity_type")
        assertThat(rcsAgent.helpMessage()).contains("help_message")
        assertThat(rcsAgent.officialAddress())
            .contains(
                RcsAddress.builder()
                    .city("city")
                    .country("country")
                    .postalCode("postal_code")
                    .state("state")
                    .street("street")
                    .build()
            )
        assertThat(rcsAgent.optInProcessDescription()).contains("opt_in_process_description")
        assertThat(rcsAgent.phoneNumber()).contains("phone_number")
        assertThat(rcsAgent.privacyPolicyUrl()).contains("privacy_policy_url")
        assertThat(rcsAgent.reason()).contains("reason")
        assertThat(rcsAgent.reasonCode()).contains("reason_code")
        assertThat(rcsAgent.sampleMessages().getOrNull()).containsExactly("string")
        assertThat(rcsAgent.startMessage()).contains("start_message")
        assertThat(rcsAgent.status()).contains(RcsAgent.Status.PROVISIONING)
        assertThat(rcsAgent.stopMessage()).contains("stop_message")
        assertThat(rcsAgent.termsAndConditionsUrl()).contains("terms_and_conditions_url")
        assertThat(rcsAgent.websiteUrl()).contains("website_url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rcsAgent =
            RcsAgent.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .agentUseCase("agent_use_case")
                .brandColor("brand_color")
                .brandEmail("brand_email")
                .brandName("brand_name")
                .brandPhoneNumber("brand_phone_number")
                .briefCompanyDescription("brief_company_description")
                .companyEin("company_ein")
                .contactNameAndTitle("contact_name_and_title")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerSupportEmail("customer_support_email")
                .customerSupportPhoneNumber("customer_support_phone_number")
                .description("description")
                .displayName("display_name")
                .entityType("entity_type")
                .helpMessage("help_message")
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
                .phoneNumber("phone_number")
                .privacyPolicyUrl("privacy_policy_url")
                .reason("reason")
                .reasonCode("reason_code")
                .addSampleMessage("string")
                .startMessage("start_message")
                .status(RcsAgent.Status.PROVISIONING)
                .stopMessage("stop_message")
                .termsAndConditionsUrl("terms_and_conditions_url")
                .websiteUrl("website_url")
                .build()

        val roundtrippedRcsAgent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rcsAgent),
                jacksonTypeRef<RcsAgent>(),
            )

        assertThat(roundtrippedRcsAgent).isEqualTo(rcsAgent)
    }
}
