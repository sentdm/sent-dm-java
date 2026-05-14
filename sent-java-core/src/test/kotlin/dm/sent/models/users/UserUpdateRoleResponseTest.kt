// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateRoleResponseTest {

    @Test
    fun create() {
        val userUpdateRoleResponse =
            UserUpdateRoleResponse.builder()
                .data(
                    UserUpdateRoleResponse.Data.builder()
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
                    UserUpdateRoleResponse.Error.builder()
                        .code("code")
                        .details(
                            UserUpdateRoleResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    UserUpdateRoleResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(userUpdateRoleResponse.data())
            .contains(
                UserUpdateRoleResponse.Data.builder()
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
        assertThat(userUpdateRoleResponse.error())
            .contains(
                UserUpdateRoleResponse.Error.builder()
                    .code("code")
                    .details(
                        UserUpdateRoleResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(userUpdateRoleResponse.meta())
            .contains(
                UserUpdateRoleResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(userUpdateRoleResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userUpdateRoleResponse =
            UserUpdateRoleResponse.builder()
                .data(
                    UserUpdateRoleResponse.Data.builder()
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
                    UserUpdateRoleResponse.Error.builder()
                        .code("code")
                        .details(
                            UserUpdateRoleResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    UserUpdateRoleResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedUserUpdateRoleResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userUpdateRoleResponse),
                jacksonTypeRef<UserUpdateRoleResponse>(),
            )

        assertThat(roundtrippedUserUpdateRoleResponse).isEqualTo(userUpdateRoleResponse)
    }
}
