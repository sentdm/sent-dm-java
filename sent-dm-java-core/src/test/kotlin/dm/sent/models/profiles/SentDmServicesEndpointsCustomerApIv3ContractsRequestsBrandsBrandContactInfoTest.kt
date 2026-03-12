// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfoTest {

    @Test
    fun create() {
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo.builder()
                .name("x")
                .businessName("businessName")
                .email("dev@stainless.com")
                .phone("phone")
                .phoneCountryCode("phoneCountryCode")
                .role("role")
                .build()

        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo.name()
            )
            .isEqualTo("x")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                    .businessName()
            )
            .contains("businessName")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo.email()
            )
            .contains("dev@stainless.com")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo.phone()
            )
            .contains("phone")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                    .phoneCountryCode()
            )
            .contains("phoneCountryCode")
        assertThat(
                sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo.role()
            )
            .contains("role")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo =
            SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo.builder()
                .name("x")
                .businessName("businessName")
                .email("dev@stainless.com")
                .phone("phone")
                .phoneCountryCode("phoneCountryCode")
                .role("role")
                .build()

        val roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                ),
                jacksonTypeRef<
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                >(),
            )

        assertThat(
                roundtrippedSentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
            )
            .isEqualTo(sentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo)
    }
}
