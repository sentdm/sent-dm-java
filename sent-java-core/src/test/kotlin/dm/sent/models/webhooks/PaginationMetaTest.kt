// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginationMetaTest {

    @Test
    fun create() {
        val paginationMeta =
            PaginationMeta.builder()
                .cursors(PaginationMeta.Cursors.builder().after("after").before("before").build())
                .hasMore(true)
                .page(0)
                .pageSize(0)
                .totalCount(0)
                .totalPages(0)
                .build()

        assertThat(paginationMeta.cursors())
            .contains(PaginationMeta.Cursors.builder().after("after").before("before").build())
        assertThat(paginationMeta.hasMore()).contains(true)
        assertThat(paginationMeta.page()).contains(0)
        assertThat(paginationMeta.pageSize()).contains(0)
        assertThat(paginationMeta.totalCount()).contains(0)
        assertThat(paginationMeta.totalPages()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginationMeta =
            PaginationMeta.builder()
                .cursors(PaginationMeta.Cursors.builder().after("after").before("before").build())
                .hasMore(true)
                .page(0)
                .pageSize(0)
                .totalCount(0)
                .totalPages(0)
                .build()

        val roundtrippedPaginationMeta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginationMeta),
                jacksonTypeRef<PaginationMeta>(),
            )

        assertThat(roundtrippedPaginationMeta).isEqualTo(paginationMeta)
    }
}
