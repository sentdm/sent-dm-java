// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignListResponseTest {

    @Test
    fun create() {
        val campaignListResponse =
            CampaignListResponse.builder()
                .addData(
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
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
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
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(campaignListResponse.data().getOrNull())
            .containsExactly(
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
        assertThat(campaignListResponse.error())
            .contains(
                ApiError.builder()
                    .code("code")
                    .details(
                        ApiError.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(campaignListResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(campaignListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val campaignListResponse =
            CampaignListResponse.builder()
                .addData(
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
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
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
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedCampaignListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(campaignListResponse),
                jacksonTypeRef<CampaignListResponse>(),
            )

        assertThat(roundtrippedCampaignListResponse).isEqualTo(campaignListResponse)
    }
}
