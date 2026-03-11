// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandDataTest {

    @Test
    fun create() {
        val brandData =
            BrandData.builder()
                .compliance(
                    BrandData.Compliance.builder()
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
                    BrandData.Contact.builder()
                        .name("x")
                        .businessName("businessName")
                        .email("dev@stainless.com")
                        .phone("phone")
                        .phoneCountryCode("phoneCountryCode")
                        .role("role")
                        .build()
                )
                .business(
                    BrandData.Business.builder()
                        .city("city")
                        .country("country")
                        .countryOfRegistration("countryOfRegistration")
                        .entityType(BrandData.Business.EntityType.PRIVATE_PROFIT)
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

        assertThat(brandData.compliance())
            .isEqualTo(
                BrandData.Compliance.builder()
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
        assertThat(brandData.contact())
            .isEqualTo(
                BrandData.Contact.builder()
                    .name("x")
                    .businessName("businessName")
                    .email("dev@stainless.com")
                    .phone("phone")
                    .phoneCountryCode("phoneCountryCode")
                    .role("role")
                    .build()
            )
        assertThat(brandData.business())
            .contains(
                BrandData.Business.builder()
                    .city("city")
                    .country("country")
                    .countryOfRegistration("countryOfRegistration")
                    .entityType(BrandData.Business.EntityType.PRIVATE_PROFIT)
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
        val brandData =
            BrandData.builder()
                .compliance(
                    BrandData.Compliance.builder()
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
                    BrandData.Contact.builder()
                        .name("x")
                        .businessName("businessName")
                        .email("dev@stainless.com")
                        .phone("phone")
                        .phoneCountryCode("phoneCountryCode")
                        .role("role")
                        .build()
                )
                .business(
                    BrandData.Business.builder()
                        .city("city")
                        .country("country")
                        .countryOfRegistration("countryOfRegistration")
                        .entityType(BrandData.Business.EntityType.PRIVATE_PROFIT)
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

        val roundtrippedBrandData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandData),
                jacksonTypeRef<BrandData>(),
            )

        assertThat(roundtrippedBrandData).isEqualTo(brandData)
    }
}
