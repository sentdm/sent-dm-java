// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingContactInfoTest {

    @Test
    fun create() {
        val billingContactInfo =
            BillingContactInfo.builder()
                .email("dev@stainless.com")
                .name("x")
                .address("address")
                .phone("phone")
                .build()

        assertThat(billingContactInfo.email()).isEqualTo("dev@stainless.com")
        assertThat(billingContactInfo.name()).isEqualTo("x")
        assertThat(billingContactInfo.address()).contains("address")
        assertThat(billingContactInfo.phone()).contains("phone")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val billingContactInfo =
            BillingContactInfo.builder()
                .email("dev@stainless.com")
                .name("x")
                .address("address")
                .phone("phone")
                .build()

        val roundtrippedBillingContactInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(billingContactInfo),
                jacksonTypeRef<BillingContactInfo>(),
            )

        assertThat(roundtrippedBillingContactInfo).isEqualTo(billingContactInfo)
    }
}
