// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.organizations.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListResponseTest {

    @Test
    fun create() {
        val userListResponse =
            UserListResponse.builder()
                .page(0)
                .pageSize(0)
                .totalCount(0)
                .addUser(
                    CustomerUser.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .email("email")
                        .invitationSentAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .invitationToken("invitationToken")
                        .invitationTokenExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .name("name")
                        .role("role")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        assertThat(userListResponse.page()).contains(0)
        assertThat(userListResponse.pageSize()).contains(0)
        assertThat(userListResponse.totalCount()).contains(0)
        assertThat(userListResponse.users().getOrNull())
            .containsExactly(
                CustomerUser.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .email("email")
                    .invitationSentAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .invitationToken("invitationToken")
                    .invitationTokenExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .name("name")
                    .role("role")
                    .status("status")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userListResponse =
            UserListResponse.builder()
                .page(0)
                .pageSize(0)
                .totalCount(0)
                .addUser(
                    CustomerUser.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .email("email")
                        .invitationSentAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .invitationToken("invitationToken")
                        .invitationTokenExpiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastLoginAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .name("name")
                        .role("role")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .build()

        val roundtrippedUserListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userListResponse),
                jacksonTypeRef<UserListResponse>(),
            )

        assertThat(roundtrippedUserListResponse).isEqualTo(userListResponse)
    }
}
