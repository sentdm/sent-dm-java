// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.templates

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateDeleteParamsTest {

    @Test
    fun create() {
        TemplateDeleteParams.builder()
            .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
            .testMode(false)
            .deleteFromMeta(false)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TemplateDeleteParams.builder().id("7ba7b820-9dad-11d1-80b4-00c04fd430c8").build()

        assertThat(params._pathParam(0)).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            TemplateDeleteParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .testMode(false)
                .deleteFromMeta(false)
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.deleteFromMeta()).contains(false)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TemplateDeleteParams.builder().id("7ba7b820-9dad-11d1-80b4-00c04fd430c8").build()

        val body = params._body()
    }
}
