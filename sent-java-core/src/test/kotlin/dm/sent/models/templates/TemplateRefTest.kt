// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateRefTest {

    @Test
    fun create() {
        val templateRef =
            TemplateRef.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("name")
                .parameters(
                    TemplateRef.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        assertThat(templateRef.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(templateRef.name()).contains("name")
        assertThat(templateRef.parameters())
            .contains(
                TemplateRef.Parameters.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateRef =
            TemplateRef.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("name")
                .parameters(
                    TemplateRef.Parameters.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val roundtrippedTemplateRef =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateRef),
                jacksonTypeRef<TemplateRef>(),
            )

        assertThat(roundtrippedTemplateRef).isEqualTo(templateRef)
    }
}
