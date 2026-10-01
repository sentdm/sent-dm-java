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

internal class ApiResponseOfVoiceNumberCreatedTest {

    @Test
    fun create() {
        val apiResponseOfVoiceNumberCreated =
            ApiResponseOfVoiceNumberCreated.builder()
                .data(
                    VoiceNumberCreated.builder()
                        .callbackUrl("callback_url")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .defaultForAppCalls(true)
                        .number("number")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .callbackSecret("callback_secret")
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

        assertThat(apiResponseOfVoiceNumberCreated.data())
            .contains(
                VoiceNumberCreated.builder()
                    .callbackUrl("callback_url")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .defaultForAppCalls(true)
                    .number("number")
                    .status("status")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .callbackSecret("callback_secret")
                    .build()
            )
        assertThat(apiResponseOfVoiceNumberCreated.error())
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
        assertThat(apiResponseOfVoiceNumberCreated.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfVoiceNumberCreated.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfVoiceNumberCreated =
            ApiResponseOfVoiceNumberCreated.builder()
                .data(
                    VoiceNumberCreated.builder()
                        .callbackUrl("callback_url")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .defaultForAppCalls(true)
                        .number("number")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .callbackSecret("callback_secret")
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

        val roundtrippedApiResponseOfVoiceNumberCreated =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfVoiceNumberCreated),
                jacksonTypeRef<ApiResponseOfVoiceNumberCreated>(),
            )

        assertThat(roundtrippedApiResponseOfVoiceNumberCreated)
            .isEqualTo(apiResponseOfVoiceNumberCreated)
    }
}
