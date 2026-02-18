// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserResponseTest {

    @Test
    fun create() {
        val userResponse =
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

        assertThat(userResponse.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(userResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(userResponse.email()).contains("email")
        assertThat(userResponse.invitedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(userResponse.lastLoginAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(userResponse.name()).contains("name")
        assertThat(userResponse.role()).contains("role")
        assertThat(userResponse.status()).contains("status")
        assertThat(userResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val userResponse =
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

        val roundtrippedUserResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(userResponse),
                jacksonTypeRef<UserResponse>(),
            )

        assertThat(roundtrippedUserResponse).isEqualTo(userResponse)
    }
}
