// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseDataTest {

    @Test
    fun create() {
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                .builder()
                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                .addSampleMessage("string")
                .build()

        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                    .messagingUseCaseUs()
            )
            .isEqualTo(MessagingUseCaseUs.MARKETING)
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                    .sampleMessages()
            )
            .containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                .builder()
                .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                .addSampleMessage("string")
                .build()

        val roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                ),
                jacksonTypeRef<
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
                >(),
            )

        assertThat(
                roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
            )
            .isEqualTo(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsCampaignsCampaignUseCaseData
            )
    }
}
