// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCallbackTestRequestInfoTest {

    @Test
    fun create() {
        val voiceCallbackTestRequestInfo =
            VoiceCallbackTestRequestInfo.builder()
                .body("body")
                .headers(
                    VoiceCallbackTestRequestInfo.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .url("url")
                .build()

        assertThat(voiceCallbackTestRequestInfo.body()).contains("body")
        assertThat(voiceCallbackTestRequestInfo.headers())
            .contains(
                VoiceCallbackTestRequestInfo.Headers.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(voiceCallbackTestRequestInfo.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceCallbackTestRequestInfo =
            VoiceCallbackTestRequestInfo.builder()
                .body("body")
                .headers(
                    VoiceCallbackTestRequestInfo.Headers.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .url("url")
                .build()

        val roundtrippedVoiceCallbackTestRequestInfo =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceCallbackTestRequestInfo),
                jacksonTypeRef<VoiceCallbackTestRequestInfo>(),
            )

        assertThat(roundtrippedVoiceCallbackTestRequestInfo).isEqualTo(voiceCallbackTestRequestInfo)
    }
}
