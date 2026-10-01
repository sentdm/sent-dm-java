// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCallbackTestErrorInfoTest {

    @Test
    fun create() {
        val voiceCallbackTestErrorInfo =
            VoiceCallbackTestErrorInfo.builder()
                .message("message")
                .path("path")
                .reason("reason")
                .build()

        assertThat(voiceCallbackTestErrorInfo.message()).contains("message")
        assertThat(voiceCallbackTestErrorInfo.path()).contains("path")
        assertThat(voiceCallbackTestErrorInfo.reason()).contains("reason")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceCallbackTestErrorInfo =
            VoiceCallbackTestErrorInfo.builder()
                .message("message")
                .path("path")
                .reason("reason")
                .build()

        val roundtrippedVoiceCallbackTestErrorInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceCallbackTestErrorInfo),
                jacksonTypeRef<VoiceCallbackTestErrorInfo>(),
            )

        assertThat(roundtrippedVoiceCallbackTestErrorInfo).isEqualTo(voiceCallbackTestErrorInfo)
    }
}
