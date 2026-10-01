// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls.participants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallParticipantTargetTest {

    @Test
    fun create() {
        val callParticipantTarget =
            CallParticipantTarget.builder().kind("kind").value("value").build()

        assertThat(callParticipantTarget.kind()).contains("kind")
        assertThat(callParticipantTarget.value()).contains("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callParticipantTarget =
            CallParticipantTarget.builder().kind("kind").value("value").build()

        val roundtrippedCallParticipantTarget =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callParticipantTarget),
                jacksonTypeRef<CallParticipantTarget>(),
            )

        assertThat(roundtrippedCallParticipantTarget).isEqualTo(callParticipantTarget)
    }
}
