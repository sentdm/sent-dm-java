// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookDeleteParamsTest {

    @Test
    fun create() {
        WebhookDeleteParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()
    }

    @Test
    fun pathParams() {
        val params =
            WebhookDeleteParams.builder().id("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8").build()

        assertThat(params._pathParam(0)).isEqualTo("d4f5a6b7-c8d9-4e0f-a1b2-c3d4e5f6a7b8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
