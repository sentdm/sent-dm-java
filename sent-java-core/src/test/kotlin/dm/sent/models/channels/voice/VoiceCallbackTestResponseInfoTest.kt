// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCallbackTestResponseInfoTest {

    @Test
    fun create() {
        val voiceCallbackTestResponseInfo =
            VoiceCallbackTestResponseInfo.builder().body("body").statusCode(0).build()

        assertThat(voiceCallbackTestResponseInfo.body()).contains("body")
        assertThat(voiceCallbackTestResponseInfo.statusCode()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceCallbackTestResponseInfo =
            VoiceCallbackTestResponseInfo.builder().body("body").statusCode(0).build()

        val roundtrippedVoiceCallbackTestResponseInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceCallbackTestResponseInfo),
                jacksonTypeRef<VoiceCallbackTestResponseInfo>(),
            )

        assertThat(roundtrippedVoiceCallbackTestResponseInfo)
            .isEqualTo(voiceCallbackTestResponseInfo)
    }
}
