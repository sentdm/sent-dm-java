// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.sent_dm.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactRetrieveIdParamsTest {

    @Test
    fun create() {
        ContactRetrieveIdParams.builder().id("id").build()
    }

    @Test
    fun queryParams() {
        val params = ContactRetrieveIdParams.builder().id("id").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("id", "id").build())
    }
}
