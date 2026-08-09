// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignUseCaseTest {

    @Test
    fun create() {
        val campaignUseCase =
            CampaignUseCase.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                .addSampleMessage("string")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(campaignUseCase.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(campaignUseCase.campaignId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(campaignUseCase.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(campaignUseCase.customerId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(campaignUseCase.messagingUseCaseUs()).contains(MessagingUseCaseUs.MARKETING)
        assertThat(campaignUseCase.sampleMessages().getOrNull()).containsExactly("string")
        assertThat(campaignUseCase.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val campaignUseCase =
            CampaignUseCase.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                .addSampleMessage("string")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedCampaignUseCase =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(campaignUseCase),
                jacksonTypeRef<CampaignUseCase>(),
            )

        assertThat(roundtrippedCampaignUseCase).isEqualTo(campaignUseCase)
    }
}
