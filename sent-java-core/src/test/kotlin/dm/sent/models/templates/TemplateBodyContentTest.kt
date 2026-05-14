// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateBodyContentTest {

    @Test
    fun create() {
        val templateBodyContent =
            TemplateBodyContent.builder()
                .template("template")
                .type("type")
                .addVariable(
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
                )
                .build()

        assertThat(templateBodyContent.template()).isEqualTo("template")
        assertThat(templateBodyContent.type()).contains("type")
        assertThat(templateBodyContent.variables().getOrNull())
            .containsExactly(
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
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateBodyContent =
            TemplateBodyContent.builder()
                .template("template")
                .type("type")
                .addVariable(
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
                )
                .build()

        val roundtrippedTemplateBodyContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateBodyContent),
                jacksonTypeRef<TemplateBodyContent>(),
            )

        assertThat(roundtrippedTemplateBodyContent).isEqualTo(templateBodyContent)
    }
}
