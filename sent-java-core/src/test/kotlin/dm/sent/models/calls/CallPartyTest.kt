// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallPartyTest {

    @Test
    fun create() {
        val callParty = CallParty.builder().kind("kind").value("value").build()

        assertThat(callParty.kind()).contains("kind")
        assertThat(callParty.value()).contains("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callParty = CallParty.builder().kind("kind").value("value").build()

        val roundtrippedCallParty =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callParty),
                jacksonTypeRef<CallParty>(),
            )

        assertThat(roundtrippedCallParty).isEqualTo(callParty)
    }
}
