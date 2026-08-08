// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignUseCaseDataTest {

    @Test
    fun create() {
        val campaignUseCaseData =
            CampaignUseCaseData.builder()
                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                .addSampleMessage("string")
                .build()

        assertThat(campaignUseCaseData.messagingUseCaseUs()).isEqualTo(MessagingUseCaseUs.MARKETING)
        assertThat(campaignUseCaseData.sampleMessages()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val campaignUseCaseData =
            CampaignUseCaseData.builder()
                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                .addSampleMessage("string")
                .build()

        val roundtrippedCampaignUseCaseData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(campaignUseCaseData),
                jacksonTypeRef<CampaignUseCaseData>(),
            )

        assertThat(roundtrippedCampaignUseCaseData).isEqualTo(campaignUseCaseData)
    }
}
