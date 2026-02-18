// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactRetrieveParamsTest {

    @Test
    fun create() {
        ContactRetrieveParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()
    }

    @Test
    fun pathParams() {
        val params =
            ContactRetrieveParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
