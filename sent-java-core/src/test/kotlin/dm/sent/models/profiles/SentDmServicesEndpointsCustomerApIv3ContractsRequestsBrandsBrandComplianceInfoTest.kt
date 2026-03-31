// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfoTest {

    @Test
    fun create() {
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .vertical(TcrVertical.PROFESSIONAL)
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .expectedMessagingVolume("expectedMessagingVolume")
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .primaryUseCase("primaryUseCase")
                .build()

        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .brandRelationship()
            )
            .isEqualTo(TcrBrandRelationship.BASIC_ACCOUNT)
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .vertical()
            )
            .isEqualTo(TcrVertical.PROFESSIONAL)
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .destinationCountries()
                    .getOrNull()
            )
            .containsExactly(DestinationCountry.builder().id("id").isMain(true).build())
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .expectedMessagingVolume()
            )
            .contains("expectedMessagingVolume")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .isTcrApplication()
            )
            .contains(true)
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .notes()
            )
            .contains("notes")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .phoneNumberPrefix()
            )
            .contains("phoneNumberPrefix")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .primaryUseCase()
            )
            .contains("primaryUseCase")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .vertical(TcrVertical.PROFESSIONAL)
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .expectedMessagingVolume("expectedMessagingVolume")
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .primaryUseCase("primaryUseCase")
                .build()

        val roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                ),
                jacksonTypeRef<
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                >(),
            )

        assertThat(
                roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
            )
            .isEqualTo(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
            )
    }
}
