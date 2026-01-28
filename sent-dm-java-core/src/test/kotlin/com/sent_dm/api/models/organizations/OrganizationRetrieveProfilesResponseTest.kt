// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationRetrieveProfilesResponseTest {

    @Test
    fun create() {
        val organizationRetrieveProfilesResponse =
            OrganizationRetrieveProfilesResponse.builder()
                .organizationId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addProfile(
                    ProfileSummary.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .icon("icon")
                        .name("name")
                        .shortName("shortName")
                        .build()
                )
                .build()

        assertThat(organizationRetrieveProfilesResponse.organizationId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(organizationRetrieveProfilesResponse.profiles().getOrNull())
            .containsExactly(
                ProfileSummary.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .description("description")
                    .icon("icon")
                    .name("name")
                    .shortName("shortName")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationRetrieveProfilesResponse =
            OrganizationRetrieveProfilesResponse.builder()
                .organizationId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .addProfile(
                    ProfileSummary.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .icon("icon")
                        .name("name")
                        .shortName("shortName")
                        .build()
                )
                .build()

        val roundtrippedOrganizationRetrieveProfilesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationRetrieveProfilesResponse),
                jacksonTypeRef<OrganizationRetrieveProfilesResponse>(),
            )

        assertThat(roundtrippedOrganizationRetrieveProfilesResponse)
            .isEqualTo(organizationRetrieveProfilesResponse)
    }
}
