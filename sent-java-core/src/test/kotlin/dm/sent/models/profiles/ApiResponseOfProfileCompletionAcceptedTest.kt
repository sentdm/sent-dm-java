// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfProfileCompletionAcceptedTest {

    @Test
    fun create() {
        val apiResponseOfProfileCompletionAccepted =
            ApiResponseOfProfileCompletionAccepted.builder()
                .data(ProfileCompletionAccepted.builder().message("message").build())
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

        assertThat(apiResponseOfProfileCompletionAccepted.data())
            .contains(ProfileCompletionAccepted.builder().message("message").build())
        assertThat(apiResponseOfProfileCompletionAccepted.error())
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
        assertThat(apiResponseOfProfileCompletionAccepted.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfProfileCompletionAccepted.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfProfileCompletionAccepted =
            ApiResponseOfProfileCompletionAccepted.builder()
                .data(ProfileCompletionAccepted.builder().message("message").build())
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

        val roundtrippedApiResponseOfProfileCompletionAccepted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfProfileCompletionAccepted),
                jacksonTypeRef<ApiResponseOfProfileCompletionAccepted>(),
            )

        assertThat(roundtrippedApiResponseOfProfileCompletionAccepted)
            .isEqualTo(apiResponseOfProfileCompletionAccepted)
    }
}
