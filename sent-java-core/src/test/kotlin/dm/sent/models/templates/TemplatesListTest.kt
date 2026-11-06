// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.PaginationCursors
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplatesListTest {

    @Test
    fun create() {
        val templatesList =
            TemplatesList.builder()
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
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
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .autoReplyAction("auto_reply_action")
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

        assertThat(templatesList.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(PaginationCursors.builder().after("after").before("before").build())
                    .hasMore(true)
                    .page(0)
                    .pageSize(0)
                    .totalCount(0)
                    .totalPages(0)
                    .build()
            )
        assertThat(templatesList.templates().getOrNull())
            .containsExactly(
                Template.builder()
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .autoReplyAction("auto_reply_action")
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
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templatesList =
            TemplatesList.builder()
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
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
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .autoReplyAction("auto_reply_action")
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

        val roundtrippedTemplatesList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templatesList),
                jacksonTypeRef<TemplatesList>(),
            )

        assertThat(roundtrippedTemplatesList).isEqualTo(templatesList)
    }
}
