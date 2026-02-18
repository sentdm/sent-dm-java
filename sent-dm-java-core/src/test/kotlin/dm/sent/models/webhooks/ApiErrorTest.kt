// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiErrorTest {

    @Test
    fun create() {
        val apiError =
            ApiError.builder()
                .code("code")
                .details(
                    ApiError.Details.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .docUrl("doc_url")
                .message("message")
                .build()

        assertThat(apiError.code()).contains("code")
        assertThat(apiError.details())
            .contains(
                ApiError.Details.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                    .build()
            )
        assertThat(apiError.docUrl()).contains("doc_url")
        assertThat(apiError.message()).contains("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiError =
            ApiError.builder()
                .code("code")
                .details(
                    ApiError.Details.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .docUrl("doc_url")
                .message("message")
                .build()

        val roundtrippedApiError =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiError),
                jacksonTypeRef<ApiError>(),
            )

        assertThat(roundtrippedApiError).isEqualTo(apiError)
    }
}
