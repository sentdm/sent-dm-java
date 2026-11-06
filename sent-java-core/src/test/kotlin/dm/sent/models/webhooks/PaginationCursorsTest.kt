// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PaginationCursorsTest {

    @Test
    fun create() {
        val paginationCursors = PaginationCursors.builder().after("after").before("before").build()

        assertThat(paginationCursors.after()).contains("after")
        assertThat(paginationCursors.before()).contains("before")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val paginationCursors = PaginationCursors.builder().after("after").before("before").build()

        val roundtrippedPaginationCursors =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(paginationCursors),
                jacksonTypeRef<PaginationCursors>(),
            )

        assertThat(roundtrippedPaginationCursors).isEqualTo(paginationCursors)
    }
}
