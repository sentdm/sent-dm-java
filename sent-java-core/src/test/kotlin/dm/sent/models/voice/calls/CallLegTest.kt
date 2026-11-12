// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallLegTest {

    @Test
    fun create() {
        val callLeg =
            CallLeg.builder()
                .billedMinutes(0)
                .cost(0.0)
                .currency("currency")
                .direction("direction")
                .number("number")
                .build()

        assertThat(callLeg.billedMinutes()).contains(0)
        assertThat(callLeg.cost()).contains(0.0)
        assertThat(callLeg.currency()).contains("currency")
        assertThat(callLeg.direction()).contains("direction")
        assertThat(callLeg.number()).contains("number")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callLeg =
            CallLeg.builder()
                .billedMinutes(0)
                .cost(0.0)
                .currency("currency")
                .direction("direction")
                .number("number")
                .build()

        val roundtrippedCallLeg =
            jsonMapper.readValue(jsonMapper.writeValueAsString(callLeg), jacksonTypeRef<CallLeg>())

        assertThat(roundtrippedCallLeg).isEqualTo(callLeg)
    }
}
