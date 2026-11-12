// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandComplianceTest {

    @Test
    fun create() {
        val brandCompliance =
            BrandCompliance.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phone_number_prefix")
                .primaryUseCase("primary_use_case")
                .vertical(TcrVertical.PROFESSIONAL)
                .build()

        assertThat(brandCompliance.brandRelationship()).contains(TcrBrandRelationship.BASIC_ACCOUNT)
        assertThat(brandCompliance.destinationCountries().getOrNull())
            .containsExactly(DestinationCountry.builder().id("id").isMain(true).build())
        assertThat(brandCompliance.isTcrApplication()).contains(true)
        assertThat(brandCompliance.notes()).contains("notes")
        assertThat(brandCompliance.phoneNumberPrefix()).contains("phone_number_prefix")
        assertThat(brandCompliance.primaryUseCase()).contains("primary_use_case")
        assertThat(brandCompliance.vertical()).contains(TcrVertical.PROFESSIONAL)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandCompliance =
            BrandCompliance.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phone_number_prefix")
                .primaryUseCase("primary_use_case")
                .vertical(TcrVertical.PROFESSIONAL)
                .build()

        val roundtrippedBrandCompliance =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandCompliance),
                jacksonTypeRef<BrandCompliance>(),
            )

        assertThat(roundtrippedBrandCompliance).isEqualTo(brandCompliance)
    }
}
