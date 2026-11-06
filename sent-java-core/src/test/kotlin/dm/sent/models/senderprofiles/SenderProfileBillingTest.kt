// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileBillingTest {

    @Test
    fun create() {
        val senderProfileBilling = SenderProfileBilling.builder().inherit(true).build()

        assertThat(senderProfileBilling.inherit()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val senderProfileBilling = SenderProfileBilling.builder().inherit(true).build()

        val roundtrippedSenderProfileBilling =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(senderProfileBilling),
                jacksonTypeRef<SenderProfileBilling>(),
            )

        assertThat(roundtrippedSenderProfileBilling).isEqualTo(senderProfileBilling)
    }
}
