// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallRecordingTest {

    @Test
    fun create() {
        val callRecording =
            CallRecording.builder()
                .downloadUrl("download_url")
                .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(callRecording.downloadUrl()).contains("download_url")
        assertThat(callRecording.recordingId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(callRecording.urlExpiresAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callRecording =
            CallRecording.builder()
                .downloadUrl("download_url")
                .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedCallRecording =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callRecording),
                jacksonTypeRef<CallRecording>(),
            )

        assertThat(roundtrippedCallRecording).isEqualTo(callRecording)
    }
}
