// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandCampaignTest {

    @Test
    fun create() {
        val brandCampaign =
            BrandCampaign.builder()
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
                .status(BrandCampaign.Status.SENT_CREATED)
                .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .submittedToTcr(true)
                .tcrCampaignId("tcrCampaignId")
                .tcrSyncError("tcrSyncError")
                .termsAndConditionsLink("termsAndConditionsLink")
                .type("type")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addUseCase(
                    CampaignUseCase.builder()
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

        assertThat(brandCampaign.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(brandCampaign.billedDate())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandCampaign.brandId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(brandCampaign.cost()).contains(0.0)
        assertThat(brandCampaign.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandCampaign.customerId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(brandCampaign.dcaElectionsComplete()).contains(true)
        assertThat(brandCampaign.dcaElectionsCompletedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandCampaign.description()).contains("description")
        assertThat(brandCampaign.hasSubmissionTransaction()).contains(true)
        assertThat(brandCampaign.helpKeywords()).contains("helpKeywords")
        assertThat(brandCampaign.helpMessage()).contains("helpMessage")
        assertThat(brandCampaign.messageFlow()).contains("messageFlow")
        assertThat(brandCampaign.name()).contains("name")
        assertThat(brandCampaign.optinKeywords()).contains("optinKeywords")
        assertThat(brandCampaign.optinMessage()).contains("optinMessage")
        assertThat(brandCampaign.optoutKeywords()).contains("optoutKeywords")
        assertThat(brandCampaign.optoutMessage()).contains("optoutMessage")
        assertThat(brandCampaign.privacyPolicyLink()).contains("privacyPolicyLink")
        assertThat(brandCampaign.status()).contains(BrandCampaign.Status.SENT_CREATED)
        assertThat(brandCampaign.submittedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandCampaign.submittedToTcr()).contains(true)
        assertThat(brandCampaign.tcrCampaignId()).contains("tcrCampaignId")
        assertThat(brandCampaign.tcrSyncError()).contains("tcrSyncError")
        assertThat(brandCampaign.termsAndConditionsLink()).contains("termsAndConditionsLink")
        assertThat(brandCampaign.type()).contains("type")
        assertThat(brandCampaign.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandCampaign.useCases().getOrNull())
            .containsExactly(
                CampaignUseCase.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                    .addSampleMessage("string")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(brandCampaign.volume()).contains("volume")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandCampaign =
            BrandCampaign.builder()
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
                .status(BrandCampaign.Status.SENT_CREATED)
                .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .submittedToTcr(true)
                .tcrCampaignId("tcrCampaignId")
                .tcrSyncError("tcrSyncError")
                .termsAndConditionsLink("termsAndConditionsLink")
                .type("type")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .addUseCase(
                    CampaignUseCase.builder()
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

        val roundtrippedBrandCampaign =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandCampaign),
                jacksonTypeRef<BrandCampaign>(),
            )

        assertThat(roundtrippedBrandCampaign).isEqualTo(brandCampaign)
    }
}
