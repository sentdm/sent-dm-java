// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfTcrCampaignWithUseCasesTest {

    @Test
    fun create() {
        val apiResponseOfTcrCampaignWithUseCases =
            ApiResponseOfTcrCampaignWithUseCases.builder()
                .data(
                    TcrCampaignWithUseCases.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .billedDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .brandId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .cost(0.0)
                        .cspId("cspId")
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .description("description")
                        .helpKeywords("helpKeywords")
                        .helpMessage("helpMessage")
                        .kycSubmissionFormId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .messageFlow("messageFlow")
                        .name("name")
                        .optinKeywords("optinKeywords")
                        .optinMessage("optinMessage")
                        .optoutKeywords("optoutKeywords")
                        .optoutMessage("optoutMessage")
                        .privacyPolicyLink("privacyPolicyLink")
                        .resellerId("resellerId")
                        .sharingStatus(TcrCampaignWithUseCases.SharingStatus.PENDING)
                        .status(TcrCampaignWithUseCases.Status.SENT_CREATED)
                        .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .submittedToTcr(true)
                        .tcrCampaignId("tcrCampaignId")
                        .tcrSyncError("tcrSyncError")
                        .telnyxCampaignId("telnyxCampaignId")
                        .termsAndConditionsLink("termsAndConditionsLink")
                        .type("type")
                        .upstreamCnpId("upstreamCnpId")
                        .addUseCase(
                            TcrCampaignWithUseCases.UseCase.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                                .addSampleMessage("string")
                                .build()
                        )
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

        assertThat(apiResponseOfTcrCampaignWithUseCases.data())
            .contains(
                TcrCampaignWithUseCases.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .billedDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .brandId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .cost(0.0)
                    .cspId("cspId")
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .description("description")
                    .helpKeywords("helpKeywords")
                    .helpMessage("helpMessage")
                    .kycSubmissionFormId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .messageFlow("messageFlow")
                    .name("name")
                    .optinKeywords("optinKeywords")
                    .optinMessage("optinMessage")
                    .optoutKeywords("optoutKeywords")
                    .optoutMessage("optoutMessage")
                    .privacyPolicyLink("privacyPolicyLink")
                    .resellerId("resellerId")
                    .sharingStatus(TcrCampaignWithUseCases.SharingStatus.PENDING)
                    .status(TcrCampaignWithUseCases.Status.SENT_CREATED)
                    .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .submittedToTcr(true)
                    .tcrCampaignId("tcrCampaignId")
                    .tcrSyncError("tcrSyncError")
                    .telnyxCampaignId("telnyxCampaignId")
                    .termsAndConditionsLink("termsAndConditionsLink")
                    .type("type")
                    .upstreamCnpId("upstreamCnpId")
                    .addUseCase(
                        TcrCampaignWithUseCases.UseCase.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                            .addSampleMessage("string")
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfTcrCampaignWithUseCases.error())
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
        assertThat(apiResponseOfTcrCampaignWithUseCases.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfTcrCampaignWithUseCases.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfTcrCampaignWithUseCases =
            ApiResponseOfTcrCampaignWithUseCases.builder()
                .data(
                    TcrCampaignWithUseCases.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .billedDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .brandId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .cost(0.0)
                        .cspId("cspId")
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .description("description")
                        .helpKeywords("helpKeywords")
                        .helpMessage("helpMessage")
                        .kycSubmissionFormId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .messageFlow("messageFlow")
                        .name("name")
                        .optinKeywords("optinKeywords")
                        .optinMessage("optinMessage")
                        .optoutKeywords("optoutKeywords")
                        .optoutMessage("optoutMessage")
                        .privacyPolicyLink("privacyPolicyLink")
                        .resellerId("resellerId")
                        .sharingStatus(TcrCampaignWithUseCases.SharingStatus.PENDING)
                        .status(TcrCampaignWithUseCases.Status.SENT_CREATED)
                        .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .submittedToTcr(true)
                        .tcrCampaignId("tcrCampaignId")
                        .tcrSyncError("tcrSyncError")
                        .telnyxCampaignId("telnyxCampaignId")
                        .termsAndConditionsLink("termsAndConditionsLink")
                        .type("type")
                        .upstreamCnpId("upstreamCnpId")
                        .addUseCase(
                            TcrCampaignWithUseCases.UseCase.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                                .addSampleMessage("string")
                                .build()
                        )
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

        val roundtrippedApiResponseOfTcrCampaignWithUseCases =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfTcrCampaignWithUseCases),
                jacksonTypeRef<ApiResponseOfTcrCampaignWithUseCases>(),
            )

        assertThat(roundtrippedApiResponseOfTcrCampaignWithUseCases)
            .isEqualTo(apiResponseOfTcrCampaignWithUseCases)
    }
}
