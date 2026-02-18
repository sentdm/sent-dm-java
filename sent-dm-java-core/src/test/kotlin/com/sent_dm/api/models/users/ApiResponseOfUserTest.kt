// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfUserTest {

    @Test
    fun create() {
        val apiResponseOfUser =
            ApiResponseOfUser.builder()
                .data(
                    UserResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .email("email")
                        .invitedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .name("name")
                        .role("role")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
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
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfUser.data())
            .contains(
                UserResponse.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .email("email")
                    .invitedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .name("name")
                    .role("role")
                    .status("status")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(apiResponseOfUser.error())
            .contains(
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
            )
        assertThat(apiResponseOfUser.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfUser.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfUser =
            ApiResponseOfUser.builder()
                .data(
                    UserResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .email("email")
                        .invitedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .name("name")
                        .role("role")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
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
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfUser =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfUser),
                jacksonTypeRef<ApiResponseOfUser>(),
            )

        assertThat(roundtrippedApiResponseOfUser).isEqualTo(apiResponseOfUser)
    }
}
