// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfCallRecordingsTest {

    @Test
    fun create() {
        val apiResponseOfCallRecordings =
            ApiResponseOfCallRecordings.builder()
                .data(
                    CallRecordings.builder()
                        .addRecording(
                            CallRecording.builder()
                                .downloadUrl("download_url")
                                .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        assertThat(apiResponseOfCallRecordings.data())
            .contains(
                CallRecordings.builder()
                    .addRecording(
                        CallRecording.builder()
                            .downloadUrl("download_url")
                            .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfCallRecordings.error())
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
        assertThat(apiResponseOfCallRecordings.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfCallRecordings.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfCallRecordings =
            ApiResponseOfCallRecordings.builder()
                .data(
                    CallRecordings.builder()
                        .addRecording(
                            CallRecording.builder()
                                .downloadUrl("download_url")
                                .recordingId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .urlExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        val roundtrippedApiResponseOfCallRecordings =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfCallRecordings),
                jacksonTypeRef<ApiResponseOfCallRecordings>(),
            )

        assertThat(roundtrippedApiResponseOfCallRecordings).isEqualTo(apiResponseOfCallRecordings)
    }
}
