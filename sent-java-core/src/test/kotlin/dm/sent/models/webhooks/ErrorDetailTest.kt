// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ErrorDetailTest {

    @Test
    fun create() {
        val errorDetail =
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

        assertThat(errorDetail.code()).contains("code")
        assertThat(errorDetail.details())
            .contains(
                ErrorDetail.Details.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                    .build()
            )
        assertThat(errorDetail.docUrl()).contains("doc_url")
        assertThat(errorDetail.message()).contains("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val errorDetail =
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

        val roundtrippedErrorDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(errorDetail),
                jacksonTypeRef<ErrorDetail>(),
            )

        assertThat(roundtrippedErrorDetail).isEqualTo(errorDetail)
    }
}
