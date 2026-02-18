// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
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
