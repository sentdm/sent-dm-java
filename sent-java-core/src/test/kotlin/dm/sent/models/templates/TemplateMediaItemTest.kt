// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateMediaItemTest {

    @Test
    fun create() {
        val templateMediaItem =
            TemplateMediaItem.builder().mediaType("mediaType").url("url").build()

        assertThat(templateMediaItem.mediaType()).contains("mediaType")
        assertThat(templateMediaItem.url()).contains("url")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateMediaItem =
            TemplateMediaItem.builder().mediaType("mediaType").url("url").build()

        val roundtrippedTemplateMediaItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateMediaItem),
                jacksonTypeRef<TemplateMediaItem>(),
            )

        assertThat(roundtrippedTemplateMediaItem).isEqualTo(templateMediaItem)
    }
}
