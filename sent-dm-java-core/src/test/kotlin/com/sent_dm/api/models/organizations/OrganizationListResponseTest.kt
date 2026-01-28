// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.organizations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OrganizationListResponseTest {

    @Test
    fun create() {
        val organizationListResponse =
            OrganizationListResponse.builder()
                .addOrganization(
                    OrganizationListResponse.Organization.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .icon("icon")
                        .name("name")
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
                )
                .build()

        assertThat(organizationListResponse.organizations().getOrNull())
            .containsExactly(
                OrganizationListResponse.Organization.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .description("description")
                    .icon("icon")
                    .name("name")
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val organizationListResponse =
            OrganizationListResponse.builder()
                .addOrganization(
                    OrganizationListResponse.Organization.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .icon("icon")
                        .name("name")
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
                )
                .build()

        val roundtrippedOrganizationListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(organizationListResponse),
                jacksonTypeRef<OrganizationListResponse>(),
            )

        assertThat(roundtrippedOrganizationListResponse).isEqualTo(organizationListResponse)
    }
}
