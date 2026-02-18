// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import com.sent_dm.api.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateListResponseTest {

    @Test
    fun create() {
        val templateListResponse =
            TemplateListResponse.builder()
                .data(
                    TemplateListResponse.Data.builder()
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
                        .addTemplate(
                            Template.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .category("category")
                                .addChannel("string")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .isPublished(true)
                                .language("language")
                                .name("name")
                                .status("status")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .addVariable("string")
                                .build()
                        )
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(templateListResponse.data())
            .contains(
                TemplateListResponse.Data.builder()
                    .pagination(
                        PaginationMeta.builder()
                            .cursors(
                                PaginationMeta.Cursors.builder()
                                    .after("after")
                                    .before("before")
                                    .build()
                            )
                            .hasMore(true)
                            .page(0)
                            .pageSize(0)
                            .totalCount(0)
                            .totalPages(0)
                            .build()
                    )
                    .addTemplate(
                        Template.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .category("category")
                            .addChannel("string")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .isPublished(true)
                            .language("language")
                            .name("name")
                            .status("status")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .addVariable("string")
                            .build()
                    )
                    .build()
            )
        assertThat(templateListResponse.error())
            .contains(
                ApiError.builder()
                    .code("code")
                    .details(
                        ApiError.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(templateListResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(templateListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateListResponse =
            TemplateListResponse.builder()
                .data(
                    TemplateListResponse.Data.builder()
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
                        .addTemplate(
                            Template.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .category("category")
                                .addChannel("string")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .isPublished(true)
                                .language("language")
                                .name("name")
                                .status("status")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .addVariable("string")
                                .build()
                        )
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedTemplateListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateListResponse),
                jacksonTypeRef<TemplateListResponse>(),
            )

        assertThat(roundtrippedTemplateListResponse).isEqualTo(templateListResponse)
    }
}
