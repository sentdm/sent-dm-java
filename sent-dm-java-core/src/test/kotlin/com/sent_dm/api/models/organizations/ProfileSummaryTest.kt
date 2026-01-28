// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileSummaryTest {

    @Test
    fun create() {
        val profileSummary =
            ProfileSummary.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .icon("icon")
                .name("name")
                .shortName("shortName")
                .build()

        assertThat(profileSummary.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(profileSummary.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(profileSummary.description()).contains("description")
        assertThat(profileSummary.icon()).contains("icon")
        assertThat(profileSummary.name()).contains("name")
        assertThat(profileSummary.shortName()).contains("shortName")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileSummary =
            ProfileSummary.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .icon("icon")
                .name("name")
                .shortName("shortName")
                .build()

        val roundtrippedProfileSummary =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileSummary),
                jacksonTypeRef<ProfileSummary>(),
            )

        assertThat(roundtrippedProfileSummary).isEqualTo(profileSummary)
    }
}
