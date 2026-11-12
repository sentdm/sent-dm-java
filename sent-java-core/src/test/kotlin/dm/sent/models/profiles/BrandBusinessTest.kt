// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandBusinessTest {

    @Test
    fun create() {
        val brandBusiness =
            BrandBusiness.builder()
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

        assertThat(brandBusiness.city()).contains("city")
        assertThat(brandBusiness.country()).contains("country")
        assertThat(brandBusiness.countryOfRegistration()).contains("country_of_registration")
        assertThat(brandBusiness.entityType()).contains("entity_type")
        assertThat(brandBusiness.legalName()).contains("legal_name")
        assertThat(brandBusiness.postalCode()).contains("postal_code")
        assertThat(brandBusiness.state()).contains("state")
        assertThat(brandBusiness.street()).contains("street")
        assertThat(brandBusiness.taxId()).contains("tax_id")
        assertThat(brandBusiness.taxIdType()).contains("tax_id_type")
        assertThat(brandBusiness.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandBusiness =
            BrandBusiness.builder()
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

        val roundtrippedBrandBusiness =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandBusiness),
                jacksonTypeRef<BrandBusiness>(),
            )

        assertThat(roundtrippedBrandBusiness).isEqualTo(brandBusiness)
    }
}
