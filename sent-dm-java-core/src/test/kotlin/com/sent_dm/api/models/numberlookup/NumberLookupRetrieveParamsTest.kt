// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.numberlookup

import com.sent_dm.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberLookupRetrieveParamsTest {

    @Test
    fun create() {
        NumberLookupRetrieveParams.builder().phoneNumber("phoneNumber").build()
    }

    @Test
    fun queryParams() {
        val params = NumberLookupRetrieveParams.builder().phoneNumber("phoneNumber").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("phoneNumber", "phoneNumber").build())
    }
}
