// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandsBrandDataTest {

    @Test
    fun create() {
        val brandsBrandData =
            BrandsBrandData.builder()
                .compliance(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                        .builder()
                        .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                        .vertical(TcrVertical.PROFESSIONAL)
                        .addDestinationCountry(
                            DestinationCountry.builder().id("id").isMain(true).build()
                        )
                        .expectedMessagingVolume("expectedMessagingVolume")
                        .isTcrApplication(true)
                        .notes("notes")
                        .phoneNumberPrefix("phoneNumberPrefix")
                        .primaryUseCase("primaryUseCase")
                        .build()
                )
                .contact(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                        .builder()
                        .name("x")
                        .businessName("businessName")
                        .email("dev@stainless.com")
                        .phone("phone")
                        .phoneCountryCode("phoneCountryCode")
                        .role("role")
                        .build()
                )
                .business(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                        .builder()
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
                )
                .build()

        assertThat(brandsBrandData.compliance())
            .isEqualTo(
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                    .builder()
                    .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                    .vertical(TcrVertical.PROFESSIONAL)
                    .addDestinationCountry(
                        DestinationCountry.builder().id("id").isMain(true).build()
                    )
                    .expectedMessagingVolume("expectedMessagingVolume")
                    .isTcrApplication(true)
                    .notes("notes")
                    .phoneNumberPrefix("phoneNumberPrefix")
                    .primaryUseCase("primaryUseCase")
                    .build()
            )
        assertThat(brandsBrandData.contact())
            .isEqualTo(
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                    .builder()
                    .name("x")
                    .businessName("businessName")
                    .email("dev@stainless.com")
                    .phone("phone")
                    .phoneCountryCode("phoneCountryCode")
                    .role("role")
                    .build()
            )
        assertThat(brandsBrandData.business())
            .contains(
                SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                    .builder()
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandsBrandData =
            BrandsBrandData.builder()
                .compliance(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandComplianceInfo
                        .builder()
                        .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                        .vertical(TcrVertical.PROFESSIONAL)
                        .addDestinationCountry(
                            DestinationCountry.builder().id("id").isMain(true).build()
                        )
                        .expectedMessagingVolume("expectedMessagingVolume")
                        .isTcrApplication(true)
                        .notes("notes")
                        .phoneNumberPrefix("phoneNumberPrefix")
                        .primaryUseCase("primaryUseCase")
                        .build()
                )
                .contact(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandContactInfo
                        .builder()
                        .name("x")
                        .businessName("businessName")
                        .email("dev@stainless.com")
                        .phone("phone")
                        .phoneCountryCode("phoneCountryCode")
                        .role("role")
                        .build()
                )
                .business(
                    SentDmServicesEndpointsCustomerApIv3ContractsRequestsBrandsBrandBusinessInfo
                        .builder()
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
                )
                .build()

        val roundtrippedBrandsBrandData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandsBrandData),
                jacksonTypeRef<BrandsBrandData>(),
            )

        assertThat(roundtrippedBrandsBrandData).isEqualTo(brandsBrandData)
    }
}
