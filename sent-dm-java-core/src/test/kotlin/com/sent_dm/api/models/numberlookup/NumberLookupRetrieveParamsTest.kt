// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.numberlookup

import com.sent_dm.api.core.http.Headers
import com.sent_dm.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberLookupRetrieveParamsTest {

    @Test
    fun create() {
        NumberLookupRetrieveParams.builder()
            .phoneNumber("phoneNumber")
            .xApiKey("")
            .xSenderId("00000000-0000-0000-0000-000000000000")
            .build()
    }

    @Test
    fun headers() {
        val params =
            NumberLookupRetrieveParams.builder()
                .phoneNumber("phoneNumber")
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
            NumberLookupRetrieveParams.builder()
                .phoneNumber("phoneNumber")
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("phoneNumber", "phoneNumber").build())
    }
}
