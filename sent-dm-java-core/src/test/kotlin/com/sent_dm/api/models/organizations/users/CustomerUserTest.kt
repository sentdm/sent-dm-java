// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations.users

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomerUserTest {

    @Test
    fun create() {
        val customerUser =
            CustomerUser.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("customerId")
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

        assertThat(customerUser.id()).contains("id")
        assertThat(customerUser.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(customerUser.customerId()).contains("customerId")
        assertThat(customerUser.email()).contains("email")
        assertThat(customerUser.invitationSentAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(customerUser.invitationToken()).contains("invitationToken")
        assertThat(customerUser.invitationTokenExpiresAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(customerUser.lastLoginAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(customerUser.name()).contains("name")
        assertThat(customerUser.role()).contains("role")
        assertThat(customerUser.status()).contains("status")
        assertThat(customerUser.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customerUser =
            CustomerUser.builder()
                .id("id")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("customerId")
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

        val roundtrippedCustomerUser =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customerUser),
                jacksonTypeRef<CustomerUser>(),
            )

        assertThat(roundtrippedCustomerUser).isEqualTo(customerUser)
    }
}
