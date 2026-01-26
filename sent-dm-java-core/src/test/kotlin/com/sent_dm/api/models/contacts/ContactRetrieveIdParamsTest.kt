// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactRetrieveIdParamsTest {

    @Test
    fun create() {
        ContactRetrieveIdParams.builder()
            .id("id")
            .xApiKey("")
            .xSenderId("00000000-0000-0000-0000-000000000000")
            .build()
    }

    @Test
    fun headers() {
        val params =
            ContactRetrieveIdParams.builder()
                .id("id")
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("x-api-key", "")
                    .put("x-sender-id", "00000000-0000-0000-0000-000000000000")
                    .build()
            )
    }

    @Test
    fun queryParams() {
        val params =
            ContactRetrieveIdParams.builder()
                .id("id")
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("id", "id").build())
    }
}
