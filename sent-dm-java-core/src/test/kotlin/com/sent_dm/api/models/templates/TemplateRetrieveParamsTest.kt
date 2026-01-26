// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.templates

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateRetrieveParamsTest {

    @Test
    fun create() {
        TemplateRetrieveParams.builder()
            .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
            .xApiKey("")
            .xSenderId("00000000-0000-0000-0000-000000000000")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            TemplateRetrieveParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            TemplateRetrieveParams.builder()
                .id("7ba7b820-9dad-11d1-80b4-00c04fd430c8")
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
}
