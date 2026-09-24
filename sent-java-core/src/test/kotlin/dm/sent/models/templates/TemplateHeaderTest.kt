// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateHeaderTest {

    @Test
    fun create() {
        val templateHeader =
            TemplateHeader.builder()
                .template("template")
                .exampleUrl("example_url")
                .location(
                    TemplateHeader.Location.builder()
                        .address("x")
                        .latitude("x")
                        .longitude("x")
                        .name("x")
                        .build()
                )
                .staticResource(true)
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

        assertThat(templateHeader.template()).isEqualTo("template")
        assertThat(templateHeader.exampleUrl()).contains("example_url")
        assertThat(templateHeader.location())
            .contains(
                TemplateHeader.Location.builder()
                    .address("x")
                    .latitude("x")
                    .longitude("x")
                    .name("x")
                    .build()
            )
        assertThat(templateHeader.staticResource()).contains(true)
        assertThat(templateHeader.type()).contains("type")
        assertThat(templateHeader.variables().getOrNull())
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
        val templateHeader =
            TemplateHeader.builder()
                .template("template")
                .exampleUrl("example_url")
                .location(
                    TemplateHeader.Location.builder()
                        .address("x")
                        .latitude("x")
                        .longitude("x")
                        .name("x")
                        .build()
                )
                .staticResource(true)
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

        val roundtrippedTemplateHeader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateHeader),
                jacksonTypeRef<TemplateHeader>(),
            )

        assertThat(roundtrippedTemplateHeader).isEqualTo(templateHeader)
    }
}
