// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandWithKycTest {

    @Test
    fun create() {
        val brandWithKyc =
            BrandWithKyc.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .businessLegalName("businessLegalName")
                .businessName("businessName")
                .businessRole("businessRole")
                .businessUrl("businessUrl")
                .city("city")
                .contactEmail("contactEmail")
                .contactName("contactName")
                .contactPhone("contactPhone")
                .contactPhoneCountryCode("contactPhoneCountryCode")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cspId("cspId")
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .entityType("entityType")
                .expectedMessagingVolume("expectedMessagingVolume")
                .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                .isInherited(true)
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .postalCode("postalCode")
                .primaryUseCase("primaryUseCase")
                .state("state")
                .status(BrandWithKyc.Status.ACTIVE)
                .street("street")
                .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .submittedToTcr(true)
                .taxId("taxId")
                .taxIdType("taxIdType")
                .tcrBrandId("tcrBrandId")
                .universalEin("universalEin")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .vertical(TcrVertical.PROFESSIONAL)
                .build()

        assertThat(brandWithKyc.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(brandWithKyc.brandRelationship()).contains(TcrBrandRelationship.BASIC_ACCOUNT)
        assertThat(brandWithKyc.businessLegalName()).contains("businessLegalName")
        assertThat(brandWithKyc.businessName()).contains("businessName")
        assertThat(brandWithKyc.businessRole()).contains("businessRole")
        assertThat(brandWithKyc.businessUrl()).contains("businessUrl")
        assertThat(brandWithKyc.city()).contains("city")
        assertThat(brandWithKyc.contactEmail()).contains("contactEmail")
        assertThat(brandWithKyc.contactName()).contains("contactName")
        assertThat(brandWithKyc.contactPhone()).contains("contactPhone")
        assertThat(brandWithKyc.contactPhoneCountryCode()).contains("contactPhoneCountryCode")
        assertThat(brandWithKyc.country()).contains("country")
        assertThat(brandWithKyc.countryOfRegistration()).contains("countryOfRegistration")
        assertThat(brandWithKyc.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandWithKyc.cspId()).contains("cspId")
        assertThat(brandWithKyc.destinationCountries().getOrNull())
            .containsExactly(DestinationCountry.builder().id("id").isMain(true).build())
        assertThat(brandWithKyc.entityType()).contains("entityType")
        assertThat(brandWithKyc.expectedMessagingVolume()).contains("expectedMessagingVolume")
        assertThat(brandWithKyc.identityStatus())
            .contains(BrandWithKyc.IdentityStatus.SELF_DECLARED)
        assertThat(brandWithKyc.isInherited()).contains(true)
        assertThat(brandWithKyc.isTcrApplication()).contains(true)
        assertThat(brandWithKyc.notes()).contains("notes")
        assertThat(brandWithKyc.phoneNumberPrefix()).contains("phoneNumberPrefix")
        assertThat(brandWithKyc.postalCode()).contains("postalCode")
        assertThat(brandWithKyc.primaryUseCase()).contains("primaryUseCase")
        assertThat(brandWithKyc.state()).contains("state")
        assertThat(brandWithKyc.status()).contains(BrandWithKyc.Status.ACTIVE)
        assertThat(brandWithKyc.street()).contains("street")
        assertThat(brandWithKyc.submittedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandWithKyc.submittedToTcr()).contains(true)
        assertThat(brandWithKyc.taxId()).contains("taxId")
        assertThat(brandWithKyc.taxIdType()).contains("taxIdType")
        assertThat(brandWithKyc.tcrBrandId()).contains("tcrBrandId")
        assertThat(brandWithKyc.universalEin()).contains("universalEin")
        assertThat(brandWithKyc.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandWithKyc.vertical()).contains(TcrVertical.PROFESSIONAL)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandWithKyc =
            BrandWithKyc.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .businessLegalName("businessLegalName")
                .businessName("businessName")
                .businessRole("businessRole")
                .businessUrl("businessUrl")
                .city("city")
                .contactEmail("contactEmail")
                .contactName("contactName")
                .contactPhone("contactPhone")
                .contactPhoneCountryCode("contactPhoneCountryCode")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cspId("cspId")
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .entityType("entityType")
                .expectedMessagingVolume("expectedMessagingVolume")
                .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                .isInherited(true)
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .postalCode("postalCode")
                .primaryUseCase("primaryUseCase")
                .state("state")
                .status(BrandWithKyc.Status.ACTIVE)
                .street("street")
                .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .submittedToTcr(true)
                .taxId("taxId")
                .taxIdType("taxIdType")
                .tcrBrandId("tcrBrandId")
                .universalEin("universalEin")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .vertical(TcrVertical.PROFESSIONAL)
                .build()

        val roundtrippedBrandWithKyc =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandWithKyc),
                jacksonTypeRef<BrandWithKyc>(),
            )

        assertThat(roundtrippedBrandWithKyc).isEqualTo(brandWithKyc)
    }
}
