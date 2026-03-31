// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfoTest {

    @Test
    fun create() {
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.builder()
                .city("city")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .entityType(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                        .EntityType
                        .PRIVATE_PROFIT
                )
                .legalName("legalName")
                .postalCode("postalCode")
                .state("state")
                .street("street")
                .taxId("taxId")
                .taxIdType("taxIdType")
                .url("https://example.com")
                .build()

        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.city()
            )
            .contains("city")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .country()
            )
            .contains("country")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .countryOfRegistration()
            )
            .contains("countryOfRegistration")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .entityType()
            )
            .contains(
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .EntityType
                    .PRIVATE_PROFIT
            )
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .legalName()
            )
            .contains("legalName")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .postalCode()
            )
            .contains("postalCode")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.state()
            )
            .contains("state")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .street()
            )
            .contains("street")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.taxId()
            )
            .contains("taxId")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .taxIdType()
            )
            .contains("taxIdType")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.url()
            )
            .contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo.builder()
                .city("city")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .entityType(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                        .EntityType
                        .PRIVATE_PROFIT
                )
                .legalName("legalName")
                .postalCode("postalCode")
                .state("state")
                .street("street")
                .taxId("taxId")
                .taxIdType("taxIdType")
                .url("https://example.com")
                .build()

        val roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                ),
                jacksonTypeRef<
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                >(),
            )

        assertThat(
                roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
            )
            .isEqualTo(sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo)
    }
}
