// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateTest {

    @Test
    fun create() {
        val template =
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

        assertThat(template.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(template.category()).contains("category")
        assertThat(template.channels().getOrNull()).containsExactly("string")
        assertThat(template.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(template.isPublished()).contains(true)
        assertThat(template.language()).contains("language")
        assertThat(template.name()).contains("name")
        assertThat(template.status()).contains("status")
        assertThat(template.updatedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(template.variables().getOrNull()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val template =
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

        val roundtrippedTemplate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(template),
                jacksonTypeRef<Template>(),
            )

        assertThat(roundtrippedTemplate).isEqualTo(template)
    }
}
