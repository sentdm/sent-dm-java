// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.senderprofiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderProfileBillingRequestTest {

    @Test
    fun create() {
        val senderProfileBillingRequest =
            SenderProfileBillingRequest.builder().inherit(true).build()

        assertThat(senderProfileBillingRequest.inherit()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val senderProfileBillingRequest =
            SenderProfileBillingRequest.builder().inherit(true).build()

        val roundtrippedSenderProfileBillingRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(senderProfileBillingRequest),
                jacksonTypeRef<SenderProfileBillingRequest>(),
            )

        assertThat(roundtrippedSenderProfileBillingRequest).isEqualTo(senderProfileBillingRequest)
    }
}
