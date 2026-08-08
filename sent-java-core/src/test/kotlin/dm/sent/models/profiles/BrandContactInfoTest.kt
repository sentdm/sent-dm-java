// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandContactInfoTest {

    @Test
    fun create() {
        val brandContactInfo =
            BrandContactInfo.builder()
                .name("x")
                .businessName("businessName")
                .email("dev@stainless.com")
                .phone("phone")
                .phoneCountryCode("phoneCountryCode")
                .role("role")
                .build()

        assertThat(brandContactInfo.name()).isEqualTo("x")
        assertThat(brandContactInfo.businessName()).contains("businessName")
        assertThat(brandContactInfo.email()).contains("dev@stainless.com")
        assertThat(brandContactInfo.phone()).contains("phone")
        assertThat(brandContactInfo.phoneCountryCode()).contains("phoneCountryCode")
        assertThat(brandContactInfo.role()).contains("role")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val brandContactInfo =
            BrandContactInfo.builder()
                .name("x")
                .businessName("businessName")
                .email("dev@stainless.com")
                .phone("phone")
                .phoneCountryCode("phoneCountryCode")
                .role("role")
                .build()

        val roundtrippedBrandContactInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(brandContactInfo),
                jacksonTypeRef<BrandContactInfo>(),
            )

        assertThat(roundtrippedBrandContactInfo).isEqualTo(brandContactInfo)
    }
}
