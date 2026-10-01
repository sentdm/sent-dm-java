// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallRecordingsTest {

    @Test
    fun create() {
        val callRecordings =
            CallRecordings.builder()
                .addRecording(
                    CallRecording.builder()
                        .downloadUrl("download_url")
                        .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        assertThat(callRecordings.recordings().getOrNull())
            .containsExactly(
                CallRecording.builder()
                    .downloadUrl("download_url")
                    .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val callRecordings =
            CallRecordings.builder()
                .addRecording(
                    CallRecording.builder()
                        .downloadUrl("download_url")
                        .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val roundtrippedCallRecordings =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(callRecordings),
                jacksonTypeRef<CallRecordings>(),
            )

        assertThat(roundtrippedCallRecordings).isEqualTo(callRecordings)
    }
}
