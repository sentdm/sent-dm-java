// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations.users

import com.sent_dm.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserListParamsTest {

    @Test
    fun create() {
        UserListParams.builder()
            .customerId("550e8400-e29b-41d4-a716-446655440000")
            .page(0)
            .pageSize(0)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            UserListParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .page(0)
                .pageSize(0)
                .build()

        assertThat(params._pathParam(0)).isEqualTo("550e8400-e29b-41d4-a716-446655440000")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            UserListParams.builder()
                .customerId("550e8400-e29b-41d4-a716-446655440000")
                .page(0)
                .pageSize(0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("pageSize", "0").build())
    }
}
