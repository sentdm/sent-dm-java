// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallTimelineEntryTest {

    @Test
    fun create() {
        val callTimelineEntry =
            CallTimelineEntry.builder()
                .status("status")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(callTimelineEntry.status()).contains("status")
        assertThat(callTimelineEntry.timestamp())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callTimelineEntry =
            CallTimelineEntry.builder()
                .status("status")
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedCallTimelineEntry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callTimelineEntry),
                jacksonTypeRef<CallTimelineEntry>(),
            )

        assertThat(roundtrippedCallTimelineEntry).isEqualTo(callTimelineEntry)
    }
}
