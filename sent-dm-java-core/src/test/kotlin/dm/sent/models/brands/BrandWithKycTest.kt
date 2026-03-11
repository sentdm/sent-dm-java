// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandWithKycTest {

    @Test
    fun create() {
        val brandWithKyc =
            BrandWithKyc.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .business(
                    BrandWithKyc.Business.builder()
                        .city("city")
                        .country("country")
                        .countryOfRegistration("country_of_registration")
                        .entityType("entity_type")
                        .legalName("legal_name")
                        .postalCode("postal_code")
                        .state("state")
                        .street("street")
                        .taxId("tax_id")
                        .taxIdType("tax_id_type")
                        .url("url")
                        .build()
                )
                .compliance(
                    BrandWithKyc.Compliance.builder()
                        .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                        .addDestinationCountry(
                            DestinationCountry.builder().id("id").isMain(true).build()
                        )
                        .expectedMessagingVolume("expected_messaging_volume")
                        .isTcrApplication(true)
                        .notes("notes")
                        .phoneNumberPrefix("phone_number_prefix")
                        .primaryUseCase("primary_use_case")
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .contact(
                    BrandWithKyc.Contact.builder()
                        .businessName("business_name")
                        .email("email")
                        .name("name")
                        .phone("phone")
                        .phoneCountryCode("phone_country_code")
                        .role("role")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cspId("csp_id")
                .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                .isInherited(true)
                .status(BrandWithKyc.Status.ACTIVE)
                .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .submittedToTcr(true)
                .tcrBrandId("tcr_brand_id")
                .universalEin("universal_ein")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(brandWithKyc.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(brandWithKyc.business())
            .contains(
                BrandWithKyc.Business.builder()
                    .city("city")
                    .country("country")
                    .countryOfRegistration("country_of_registration")
                    .entityType("entity_type")
                    .legalName("legal_name")
                    .postalCode("postal_code")
                    .state("state")
                    .street("street")
                    .taxId("tax_id")
                    .taxIdType("tax_id_type")
                    .url("url")
                    .build()
            )
        assertThat(brandWithKyc.compliance())
            .contains(
                BrandWithKyc.Compliance.builder()
                    .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                    .addDestinationCountry(
                        DestinationCountry.builder().id("id").isMain(true).build()
                    )
                    .expectedMessagingVolume("expected_messaging_volume")
                    .isTcrApplication(true)
                    .notes("notes")
                    .phoneNumberPrefix("phone_number_prefix")
                    .primaryUseCase("primary_use_case")
                    .vertical(TcrVertical.PROFESSIONAL)
                    .build()
            )
        assertThat(brandWithKyc.contact())
            .contains(
                BrandWithKyc.Contact.builder()
                    .businessName("business_name")
                    .email("email")
                    .name("name")
                    .phone("phone")
                    .phoneCountryCode("phone_country_code")
                    .role("role")
                    .build()
            )
        assertThat(brandWithKyc.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandWithKyc.cspId()).contains("csp_id")
        assertThat(brandWithKyc.identityStatus())
            .contains(BrandWithKyc.IdentityStatus.SELF_DECLARED)
        assertThat(brandWithKyc.isInherited()).contains(true)
        assertThat(brandWithKyc.status()).contains(BrandWithKyc.Status.ACTIVE)
        assertThat(brandWithKyc.submittedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(brandWithKyc.submittedToTcr()).contains(true)
        assertThat(brandWithKyc.tcrBrandId()).contains("tcr_brand_id")
        assertThat(brandWithKyc.universalEin()).contains("universal_ein")
        assertThat(brandWithKyc.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandWithKyc =
            BrandWithKyc.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .business(
                    BrandWithKyc.Business.builder()
                        .city("city")
                        .country("country")
                        .countryOfRegistration("country_of_registration")
                        .entityType("entity_type")
                        .legalName("legal_name")
                        .postalCode("postal_code")
                        .state("state")
                        .street("street")
                        .taxId("tax_id")
                        .taxIdType("tax_id_type")
                        .url("url")
                        .build()
                )
                .compliance(
                    BrandWithKyc.Compliance.builder()
                        .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                        .addDestinationCountry(
                            DestinationCountry.builder().id("id").isMain(true).build()
                        )
                        .expectedMessagingVolume("expected_messaging_volume")
                        .isTcrApplication(true)
                        .notes("notes")
                        .phoneNumberPrefix("phone_number_prefix")
                        .primaryUseCase("primary_use_case")
                        .vertical(TcrVertical.PROFESSIONAL)
                        .build()
                )
                .contact(
                    BrandWithKyc.Contact.builder()
                        .businessName("business_name")
                        .email("email")
                        .name("name")
                        .phone("phone")
                        .phoneCountryCode("phone_country_code")
                        .role("role")
                        .build()
                )
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cspId("csp_id")
                .identityStatus(BrandWithKyc.IdentityStatus.SELF_DECLARED)
                .isInherited(true)
                .status(BrandWithKyc.Status.ACTIVE)
                .submittedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .submittedToTcr(true)
                .tcrBrandId("tcr_brand_id")
                .universalEin("universal_ein")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedBrandWithKyc =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandWithKyc),
                jacksonTypeRef<BrandWithKyc>(),
            )

        assertThat(roundtrippedBrandWithKyc).isEqualTo(brandWithKyc)
    }
}
