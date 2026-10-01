// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.calls.participants

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfListOfCallParticipantTest {

    @Test
    fun create() {
        val apiResponseOfListOfCallParticipant =
            ApiResponseOfListOfCallParticipant.builder()
                .addData(
                    CallParticipant.builder()
                        .id("id")
                        .durationSeconds(0)
                        .kind("kind")
                        .muted(true)
                        .value("value")
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

        assertThat(apiResponseOfListOfCallParticipant.data().getOrNull())
            .containsExactly(
                CallParticipant.builder()
                    .id("id")
                    .durationSeconds(0)
                    .kind("kind")
                    .muted(true)
                    .value("value")
                    .build()
            )
        assertThat(apiResponseOfListOfCallParticipant.error())
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
        assertThat(apiResponseOfListOfCallParticipant.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfListOfCallParticipant.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfListOfCallParticipant =
            ApiResponseOfListOfCallParticipant.builder()
                .addData(
                    CallParticipant.builder()
                        .id("id")
                        .durationSeconds(0)
                        .kind("kind")
                        .muted(true)
                        .value("value")
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

        val roundtrippedApiResponseOfListOfCallParticipant =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfListOfCallParticipant),
                jacksonTypeRef<ApiResponseOfListOfCallParticipant>(),
            )

        assertThat(roundtrippedApiResponseOfListOfCallParticipant)
            .isEqualTo(apiResponseOfListOfCallParticipant)
    }
}
