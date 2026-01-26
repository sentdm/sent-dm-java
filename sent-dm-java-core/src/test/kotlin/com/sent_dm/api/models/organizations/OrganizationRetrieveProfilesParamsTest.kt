// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations

import com.sent_dm.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationRetrieveProfilesParamsTest {

    @Test
    fun create() {
        OrganizationRetrieveProfilesParams.builder()
            .orgId("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .xApiKey("")
            .xSenderId("00000000-0000-0000-0000-000000000000")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            OrganizationRetrieveProfilesParams.builder()
                .orgId("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .xApiKey("")
                .xSenderId("00000000-0000-0000-0000-000000000000")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            OrganizationRetrieveProfilesParams.builder()
                .orgId("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
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
