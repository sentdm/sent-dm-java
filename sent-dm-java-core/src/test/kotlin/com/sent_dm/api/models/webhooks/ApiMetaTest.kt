// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiMetaTest {

    @Test
    fun create() {
        val apiMeta =
            ApiMeta.builder()
                .requestId("request_id")
                .responseTimeMs(0L)
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .version("version")
                .build()

        assertThat(apiMeta.requestId()).contains("request_id")
        assertThat(apiMeta.responseTimeMs()).contains(0L)
        assertThat(apiMeta.timestamp()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(apiMeta.version()).contains("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiMeta =
            ApiMeta.builder()
                .requestId("request_id")
                .responseTimeMs(0L)
                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .version("version")
                .build()

        val roundtrippedApiMeta =
            jsonMapper.readValue(jsonMapper.writeValueAsString(apiMeta), jacksonTypeRef<ApiMeta>())

        assertThat(roundtrippedApiMeta).isEqualTo(apiMeta)
    }
}
