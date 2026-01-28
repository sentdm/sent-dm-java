// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations.users

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserUpdateRoleParamsTest {

    @Test
    fun create() {
        UserUpdateRoleParams.builder()
            .customerId("550e8400-e29b-41d4-a716-446655440000")
            .userId("650e8400-e29b-41d4-a716-446655440000")
            .role("admin")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserUpdateRoleParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .userId("650e8400-e29b-41d4-a716-446655440000")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("550e8400-e29b-41d4-a716-446655440000")
        assertThat(params._pathParam(1)).isEqualTo("650e8400-e29b-41d4-a716-446655440000")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            UserUpdateRoleParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .userId("650e8400-e29b-41d4-a716-446655440000")
                .role("admin")
                .build()

        val body = params._body()

        assertThat(body.role()).contains("admin")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            UserUpdateRoleParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .userId("650e8400-e29b-41d4-a716-446655440000")
                .build()

        val body = params._body()
    }
}
