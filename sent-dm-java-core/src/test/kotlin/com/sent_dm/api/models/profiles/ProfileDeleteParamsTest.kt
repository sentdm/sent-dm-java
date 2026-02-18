// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.profiles

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileDeleteParamsTest {

    @Test
    fun create() {
        ProfileDeleteParams.builder()
            .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .testMode(false)
            .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ProfileDeleteParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ProfileDeleteParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .testMode(false)
                .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
                .build()

        val body = params._body()

        assertThat(body.testMode()).contains(false)
        assertThat(body.bodyProfileId()).contains("770e8400-e29b-41d4-a716-446655440002")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ProfileDeleteParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        val body = params._body()
    }
}
