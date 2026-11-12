// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.rcs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfRcsAgentTest {

    @Test
    fun create() {
        val apiResponseOfRcsAgent =
            ApiResponseOfRcsAgent.builder()
                .data(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfRcsAgent.data())
            .contains(
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
            )
        assertThat(apiResponseOfRcsAgent.error())
            .contains(
                ErrorDetail.builder()
                    .code("code")
                    .details(
                        ErrorDetail.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseOfRcsAgent.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfRcsAgent.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfRcsAgent =
            ApiResponseOfRcsAgent.builder()
                .data(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfRcsAgent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfRcsAgent),
                jacksonTypeRef<ApiResponseOfRcsAgent>(),
            )

        assertThat(roundtrippedApiResponseOfRcsAgent).isEqualTo(apiResponseOfRcsAgent)
    }
}
