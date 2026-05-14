// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateVariableTest {

    @Test
    fun create() {
        val templateVariable =
            TemplateVariable.builder()
                .name("x")
                .props(
                    TemplateVariable.Props.builder()
                        .mediaType("x")
                        .sample("x")
                        .url("x")
                        .variableType("x")
                        .alt("alt")
                        .regex("regex")
                        .shortUrl("shortUrl")
                        .build()
                )
                .type("x")
                .id(0)
                .build()

        assertThat(templateVariable.name()).isEqualTo("x")
        assertThat(templateVariable.props())
            .isEqualTo(
                TemplateVariable.Props.builder()
                    .mediaType("x")
                    .sample("x")
                    .url("x")
                    .variableType("x")
                    .alt("alt")
                    .regex("regex")
                    .shortUrl("shortUrl")
                    .build()
            )
        assertThat(templateVariable.type()).isEqualTo("x")
        assertThat(templateVariable.id()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateVariable =
            TemplateVariable.builder()
                .name("x")
                .props(
                    TemplateVariable.Props.builder()
                        .mediaType("x")
                        .sample("x")
                        .url("x")
                        .variableType("x")
                        .alt("alt")
                        .regex("regex")
                        .shortUrl("shortUrl")
                        .build()
                )
                .type("x")
                .id(0)
                .build()

        val roundtrippedTemplateVariable =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateVariable),
                jacksonTypeRef<TemplateVariable>(),
            )

        assertThat(roundtrippedTemplateVariable).isEqualTo(templateVariable)
    }
}
