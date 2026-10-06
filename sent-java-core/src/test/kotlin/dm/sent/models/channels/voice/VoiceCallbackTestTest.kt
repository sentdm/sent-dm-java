// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceCallbackTestTest {

    @Test
    fun create() {
        val voiceCallbackTest =
            VoiceCallbackTest.builder()
                .answer(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .error(
                    VoiceCallbackTestErrorInfo.builder()
                        .message("message")
                        .path("path")
                        .reason("reason")
                        .build()
                )
                .outcome("outcome")
                .request(
                    VoiceCallbackTestRequestInfo.builder()
                        .body("body")
                        .headers(
                            VoiceCallbackTestRequestInfo.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .url("url")
                        .build()
                )
                .response(
                    VoiceCallbackTestResponseInfo.builder().body("body").statusCode(0).build()
                )
                .build()

        assertThat(voiceCallbackTest._answer()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(voiceCallbackTest.callId()).contains("call_id")
        assertThat(voiceCallbackTest.error())
            .contains(
                VoiceCallbackTestErrorInfo.builder()
                    .message("message")
                    .path("path")
                    .reason("reason")
                    .build()
            )
        assertThat(voiceCallbackTest.outcome()).contains("outcome")
        assertThat(voiceCallbackTest.request())
            .contains(
                VoiceCallbackTestRequestInfo.builder()
                    .body("body")
                    .headers(
                        VoiceCallbackTestRequestInfo.Headers.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .url("url")
                    .build()
            )
        assertThat(voiceCallbackTest.response())
            .contains(VoiceCallbackTestResponseInfo.builder().body("body").statusCode(0).build())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val voiceCallbackTest =
            VoiceCallbackTest.builder()
                .answer(JsonValue.from(mapOf<String, Any>()))
                .callId("call_id")
                .error(
                    VoiceCallbackTestErrorInfo.builder()
                        .message("message")
                        .path("path")
                        .reason("reason")
                        .build()
                )
                .outcome("outcome")
                .request(
                    VoiceCallbackTestRequestInfo.builder()
                        .body("body")
                        .headers(
                            VoiceCallbackTestRequestInfo.Headers.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .url("url")
                        .build()
                )
                .response(
                    VoiceCallbackTestResponseInfo.builder().body("body").statusCode(0).build()
                )
                .build()

        val roundtrippedVoiceCallbackTest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceCallbackTest),
                jacksonTypeRef<VoiceCallbackTest>(),
            )

        assertThat(roundtrippedVoiceCallbackTest).isEqualTo(voiceCallbackTest)
    }
}
