// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactDeleteParamsTest {

    @Test
    fun create() {
        ContactDeleteParams.builder()
            .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .testMode(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ContactDeleteParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .testMode(false)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ContactDeleteParams.builder().id("6ba7b810-9dad-11d1-80b4-00c04fd430c8").build()

        val body = params._body()
    }
}
