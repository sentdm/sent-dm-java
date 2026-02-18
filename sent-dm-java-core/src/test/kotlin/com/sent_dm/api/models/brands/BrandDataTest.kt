// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandDataTest {

    @Test
    fun create() {
        val brandData =
            BrandData.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .contactName("x")
                .vertical(TcrVertical.PROFESSIONAL)
                .brandName("brandName")
                .businessLegalName("businessLegalName")
                .businessName("businessName")
                .businessRole("businessRole")
                .businessUrl("https://example.com")
                .city("city")
                .contactEmail("dev@stainless.com")
                .contactPhone("contactPhone")
                .contactPhoneCountryCode("contactPhoneCountryCode")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .entityType(BrandData.EntityType.PRIVATE_PROFIT)
                .expectedMessagingVolume("expectedMessagingVolume")
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .postalCode("postalCode")
                .primaryUseCase("primaryUseCase")
                .state("state")
                .street("street")
                .taxId("taxId")
                .taxIdType("taxIdType")
                .build()

        assertThat(brandData.brandRelationship()).isEqualTo(TcrBrandRelationship.BASIC_ACCOUNT)
        assertThat(brandData.contactName()).isEqualTo("x")
        assertThat(brandData.vertical()).isEqualTo(TcrVertical.PROFESSIONAL)
        assertThat(brandData.brandName()).contains("brandName")
        assertThat(brandData.businessLegalName()).contains("businessLegalName")
        assertThat(brandData.businessName()).contains("businessName")
        assertThat(brandData.businessRole()).contains("businessRole")
        assertThat(brandData.businessUrl()).contains("https://example.com")
        assertThat(brandData.city()).contains("city")
        assertThat(brandData.contactEmail()).contains("dev@stainless.com")
        assertThat(brandData.contactPhone()).contains("contactPhone")
        assertThat(brandData.contactPhoneCountryCode()).contains("contactPhoneCountryCode")
        assertThat(brandData.country()).contains("country")
        assertThat(brandData.countryOfRegistration()).contains("countryOfRegistration")
        assertThat(brandData.destinationCountries().getOrNull())
            .containsExactly(DestinationCountry.builder().id("id").isMain(true).build())
        assertThat(brandData.entityType()).contains(BrandData.EntityType.PRIVATE_PROFIT)
        assertThat(brandData.expectedMessagingVolume()).contains("expectedMessagingVolume")
        assertThat(brandData.isTcrApplication()).contains(true)
        assertThat(brandData.notes()).contains("notes")
        assertThat(brandData.phoneNumberPrefix()).contains("phoneNumberPrefix")
        assertThat(brandData.postalCode()).contains("postalCode")
        assertThat(brandData.primaryUseCase()).contains("primaryUseCase")
        assertThat(brandData.state()).contains("state")
        assertThat(brandData.street()).contains("street")
        assertThat(brandData.taxId()).contains("taxId")
        assertThat(brandData.taxIdType()).contains("taxIdType")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandData =
            BrandData.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .contactName("x")
                .vertical(TcrVertical.PROFESSIONAL)
                .brandName("brandName")
                .businessLegalName("businessLegalName")
                .businessName("businessName")
                .businessRole("businessRole")
                .businessUrl("https://example.com")
                .city("city")
                .contactEmail("dev@stainless.com")
                .contactPhone("contactPhone")
                .contactPhoneCountryCode("contactPhoneCountryCode")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .entityType(BrandData.EntityType.PRIVATE_PROFIT)
                .expectedMessagingVolume("expectedMessagingVolume")
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .postalCode("postalCode")
                .primaryUseCase("primaryUseCase")
                .state("state")
                .street("street")
                .taxId("taxId")
                .taxIdType("taxIdType")
                .build()

        val roundtrippedBrandData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandData),
                jacksonTypeRef<BrandData>(),
            )

        assertThat(roundtrippedBrandData).isEqualTo(brandData)
    }
}
