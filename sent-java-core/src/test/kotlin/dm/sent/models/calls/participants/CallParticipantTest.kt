// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls.participants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallParticipantTest {

    @Test
    fun create() {
        val callParticipant =
            CallParticipant.builder()
                .id("id")
                .durationSeconds(0)
                .kind("kind")
                .muted(true)
                .value("value")
                .build()

        assertThat(callParticipant.id()).contains("id")
        assertThat(callParticipant.durationSeconds()).contains(0)
        assertThat(callParticipant.kind()).contains("kind")
        assertThat(callParticipant.muted()).contains(true)
        assertThat(callParticipant.value()).contains("value")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callParticipant =
            CallParticipant.builder()
                .id("id")
                .durationSeconds(0)
                .kind("kind")
                .muted(true)
                .value("value")
                .build()

        val roundtrippedCallParticipant =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callParticipant),
                jacksonTypeRef<CallParticipant>(),
            )

        assertThat(roundtrippedCallParticipant).isEqualTo(callParticipant)
    }
}
