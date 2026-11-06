// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import dm.sent.models.webhooks.PaginationCursors
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfUsersListTest {

    @Test
    fun create() {
        val apiResponseOfUsersList =
            ApiResponseOfUsersList.builder()
                .data(
                    UsersList.builder()
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationCursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
                        .addUser(
                            UserResponse.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .email("email")
                                .invitedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .name("name")
                                .role("role")
                                .status("status")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        assertThat(apiResponseOfUsersList.data())
            .contains(
                UsersList.builder()
                    .pagination(
                        PaginationMeta.builder()
                            .cursors(
                                PaginationCursors.builder().after("after").before("before").build()
                            )
                            .hasMore(true)
                            .page(0)
                            .pageSize(0)
                            .totalCount(0)
                            .totalPages(0)
                            .build()
                    )
                    .addUser(
                        UserResponse.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .email("email")
                            .invitedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .name("name")
                            .role("role")
                            .status("status")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfUsersList.error())
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
        assertThat(apiResponseOfUsersList.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfUsersList.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfUsersList =
            ApiResponseOfUsersList.builder()
                .data(
                    UsersList.builder()
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationCursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
                        .addUser(
                            UserResponse.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .email("email")
                                .invitedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .name("name")
                                .role("role")
                                .status("status")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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

        val roundtrippedApiResponseOfUsersList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfUsersList),
                jacksonTypeRef<ApiResponseOfUsersList>(),
            )

        assertThat(roundtrippedApiResponseOfUsersList).isEqualTo(apiResponseOfUsersList)
    }
}
