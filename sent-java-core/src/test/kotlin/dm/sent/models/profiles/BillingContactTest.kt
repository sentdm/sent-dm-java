// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BillingContactTest {

    @Test
    fun create() {
        val billingContact =
            BillingContact.builder()
                .address("address")
                .email("email")
                .name("name")
                .phone("phone")
                .build()

        assertThat(billingContact.address()).contains("address")
        assertThat(billingContact.email()).contains("email")
        assertThat(billingContact.name()).contains("name")
        assertThat(billingContact.phone()).contains("phone")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val billingContact =
            BillingContact.builder()
                .address("address")
                .email("email")
                .name("name")
                .phone("phone")
                .build()

        val roundtrippedBillingContact =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(billingContact),
                jacksonTypeRef<BillingContact>(),
            )

        assertThat(roundtrippedBillingContact).isEqualTo(billingContact)
    }
}
