// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import dm.sent.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateListParamsTest {

    @Test
    fun create() {
        TemplateListParams.builder()
            .page(0)
            .pageSize(0)
            .category("category")
            .search("search")
            .status("status")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            TemplateListParams.builder()
                .page(0)
                .pageSize(0)
                .category("category")
                .search("search")
                .status("status")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("page", "0")
                    .put("pageSize", "0")
                    .put("category", "category")
                    .put("search", "search")
                    .put("status", "status")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = TemplateListParams.builder().page(0).pageSize(0).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("page", "0").put("pageSize", "0").build())
    }
}
