// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.voice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfVoiceCallbackTestTest {

    @Test
    fun create() {
        val apiResponseOfVoiceCallbackTest =
            ApiResponseOfVoiceCallbackTest.builder()
                .data(
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
                            VoiceCallbackTestResponseInfo.builder()
                                .body("body")
                                .statusCode(0)
                                .build()
                        )
                        .build()
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfVoiceCallbackTest.data())
            .contains(
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
            )
        assertThat(apiResponseOfVoiceCallbackTest.error())
            .contains(
                ErrorDetail.builder()
                    .code("code")
                    .details(
                        ErrorDetail.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseOfVoiceCallbackTest.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfVoiceCallbackTest.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfVoiceCallbackTest =
            ApiResponseOfVoiceCallbackTest.builder()
                .data(
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
                            VoiceCallbackTestResponseInfo.builder()
                                .body("body")
                                .statusCode(0)
                                .build()
                        )
                        .build()
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfVoiceCallbackTest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfVoiceCallbackTest),
                jacksonTypeRef<ApiResponseOfVoiceCallbackTest>(),
            )

        assertThat(roundtrippedApiResponseOfVoiceCallbackTest)
            .isEqualTo(apiResponseOfVoiceCallbackTest)
    }
}
