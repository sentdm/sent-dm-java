// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandBusinessInfoTest {

    @Test
    fun create() {
        val brandBusinessInfo =
            BrandBusinessInfo.builder()
                .city("city")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .entityType(BrandBusinessInfo.EntityType.PRIVATE_PROFIT)
                .legalName("legalName")
                .postalCode("postalCode")
                .state("state")
                .street("street")
                .taxId("taxId")
                .taxIdType("taxIdType")
                .url("https://example.com")
                .build()

        assertThat(brandBusinessInfo.city()).contains("city")
        assertThat(brandBusinessInfo.country()).contains("country")
        assertThat(brandBusinessInfo.countryOfRegistration()).contains("countryOfRegistration")
        assertThat(brandBusinessInfo.entityType())
            .contains(BrandBusinessInfo.EntityType.PRIVATE_PROFIT)
        assertThat(brandBusinessInfo.legalName()).contains("legalName")
        assertThat(brandBusinessInfo.postalCode()).contains("postalCode")
        assertThat(brandBusinessInfo.state()).contains("state")
        assertThat(brandBusinessInfo.street()).contains("street")
        assertThat(brandBusinessInfo.taxId()).contains("taxId")
        assertThat(brandBusinessInfo.taxIdType()).contains("taxIdType")
        assertThat(brandBusinessInfo.url()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandBusinessInfo =
            BrandBusinessInfo.builder()
                .city("city")
                .country("country")
                .countryOfRegistration("countryOfRegistration")
                .entityType(BrandBusinessInfo.EntityType.PRIVATE_PROFIT)
                .legalName("legalName")
                .postalCode("postalCode")
                .state("state")
                .street("street")
                .taxId("taxId")
                .taxIdType("taxIdType")
                .url("https://example.com")
                .build()

        val roundtrippedBrandBusinessInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandBusinessInfo),
                jacksonTypeRef<BrandBusinessInfo>(),
            )

        assertThat(roundtrippedBrandBusinessInfo).isEqualTo(brandBusinessInfo)
    }
}
