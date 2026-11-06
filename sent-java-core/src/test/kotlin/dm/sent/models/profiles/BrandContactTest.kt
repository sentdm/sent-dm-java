// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandContactTest {

    @Test
    fun create() {
        val brandContact =
            BrandContact.builder()
                .businessName("business_name")
                .email("email")
                .name("name")
                .phone("phone")
                .phoneCountryCode("phone_country_code")
                .role("role")
                .build()

        assertThat(brandContact.businessName()).contains("business_name")
        assertThat(brandContact.email()).contains("email")
        assertThat(brandContact.name()).contains("name")
        assertThat(brandContact.phone()).contains("phone")
        assertThat(brandContact.phoneCountryCode()).contains("phone_country_code")
        assertThat(brandContact.role()).contains("role")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandContact =
            BrandContact.builder()
                .businessName("business_name")
                .email("email")
                .name("name")
                .phone("phone")
                .phoneCountryCode("phone_country_code")
                .role("role")
                .build()

        val roundtrippedBrandContact =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandContact),
                jacksonTypeRef<BrandContact>(),
            )

        assertThat(roundtrippedBrandContact).isEqualTo(brandContact)
    }
}
