// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.sent_dm.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactListParamsTest {

    @Test
    fun create() {
        ContactListParams.builder().page(0).pageSize(0).build()
    }

    @Test
    fun queryParams() {
        val params = ContactListParams.builder().page(0).pageSize(0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("pageSize", "0").build())
    }
}
