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

internal class CampaignCreateResponseTest {

    @Test
    fun create() {
        val campaignCreateResponse =
            CampaignCreateResponse.builder()
                .data(
                    CampaignCreateResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .billedDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .brandId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .cost(0.0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .dcaElectionsComplete(true)
                        .dcaElectionsCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .hasSubmissionTransaction(true)
                        .helpKeywords("helpKeywords")
                        .helpMessage("helpMessage")
                        .messageFlow("messageFlow")
                        .name("name")
                        .optinKeywords("optinKeywords")
                        .optinMessage("optinMessage")
                        .optoutKeywords("optoutKeywords")
                        .optoutMessage("optoutMessage")
                        .privacyPolicyLink("privacyPolicyLink")
                        .status(CampaignCreateResponse.Data.Status.SENT_CREATED)
                        .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .submittedToTcr(true)
                        .tcrCampaignId("tcrCampaignId")
                        .tcrSyncError("tcrSyncError")
                        .termsAndConditionsLink("termsAndConditionsLink")
                        .type("type")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addUseCase(
                            CampaignCreateResponse.Data.UseCase.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                                .addSampleMessage("string")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .volume("volume")
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

        assertThat(campaignCreateResponse.data())
            .contains(
                CampaignCreateResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .billedDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .brandId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .cost(0.0)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .dcaElectionsComplete(true)
                    .dcaElectionsCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .description("description")
                    .hasSubmissionTransaction(true)
                    .helpKeywords("helpKeywords")
                    .helpMessage("helpMessage")
                    .messageFlow("messageFlow")
                    .name("name")
                    .optinKeywords("optinKeywords")
                    .optinMessage("optinMessage")
                    .optoutKeywords("optoutKeywords")
                    .optoutMessage("optoutMessage")
                    .privacyPolicyLink("privacyPolicyLink")
                    .status(CampaignCreateResponse.Data.Status.SENT_CREATED)
                    .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .submittedToTcr(true)
                    .tcrCampaignId("tcrCampaignId")
                    .tcrSyncError("tcrSyncError")
                    .termsAndConditionsLink("termsAndConditionsLink")
                    .type("type")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addUseCase(
                        CampaignCreateResponse.Data.UseCase.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                            .addSampleMessage("string")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .volume("volume")
                    .build()
            )
        assertThat(campaignCreateResponse.error())
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
        assertThat(campaignCreateResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(campaignCreateResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val campaignCreateResponse =
            CampaignCreateResponse.builder()
                .data(
                    CampaignCreateResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .billedDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .brandId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .cost(0.0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .dcaElectionsComplete(true)
                        .dcaElectionsCompletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .hasSubmissionTransaction(true)
                        .helpKeywords("helpKeywords")
                        .helpMessage("helpMessage")
                        .messageFlow("messageFlow")
                        .name("name")
                        .optinKeywords("optinKeywords")
                        .optinMessage("optinMessage")
                        .optoutKeywords("optoutKeywords")
                        .optoutMessage("optoutMessage")
                        .privacyPolicyLink("privacyPolicyLink")
                        .status(CampaignCreateResponse.Data.Status.SENT_CREATED)
                        .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .submittedToTcr(true)
                        .tcrCampaignId("tcrCampaignId")
                        .tcrSyncError("tcrSyncError")
                        .termsAndConditionsLink("termsAndConditionsLink")
                        .type("type")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addUseCase(
                            CampaignCreateResponse.Data.UseCase.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                                .addSampleMessage("string")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .volume("volume")
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

        val roundtrippedCampaignCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(campaignCreateResponse),
                jacksonTypeRef<CampaignCreateResponse>(),
            )

        assertThat(roundtrippedCampaignCreateResponse).isEqualTo(campaignCreateResponse)
    }
}
