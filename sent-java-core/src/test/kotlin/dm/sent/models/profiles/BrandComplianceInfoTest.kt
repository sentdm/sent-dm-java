// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandComplianceInfoTest {

    @Test
    fun create() {
        val brandComplianceInfo =
            BrandComplianceInfo.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .vertical(TcrVertical.PROFESSIONAL)
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .primaryUseCase("primaryUseCase")
                .build()

        assertThat(brandComplianceInfo.brandRelationship())
            .isEqualTo(TcrBrandRelationship.BASIC_ACCOUNT)
        assertThat(brandComplianceInfo.vertical()).isEqualTo(TcrVertical.PROFESSIONAL)
        assertThat(brandComplianceInfo.destinationCountries().getOrNull())
            .containsExactly(DestinationCountry.builder().id("id").isMain(true).build())
        assertThat(brandComplianceInfo.isTcrApplication()).contains(true)
        assertThat(brandComplianceInfo.notes()).contains("notes")
        assertThat(brandComplianceInfo.phoneNumberPrefix()).contains("phoneNumberPrefix")
        assertThat(brandComplianceInfo.primaryUseCase()).contains("primaryUseCase")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandComplianceInfo =
            BrandComplianceInfo.builder()
                .brandRelationship(TcrBrandRelationship.BASIC_ACCOUNT)
                .vertical(TcrVertical.PROFESSIONAL)
                .addDestinationCountry(DestinationCountry.builder().id("id").isMain(true).build())
                .isTcrApplication(true)
                .notes("notes")
                .phoneNumberPrefix("phoneNumberPrefix")
                .primaryUseCase("primaryUseCase")
                .build()

        val roundtrippedBrandComplianceInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandComplianceInfo),
                jacksonTypeRef<BrandComplianceInfo>(),
            )

        assertThat(roundtrippedBrandComplianceInfo).isEqualTo(brandComplianceInfo)
    }
}
