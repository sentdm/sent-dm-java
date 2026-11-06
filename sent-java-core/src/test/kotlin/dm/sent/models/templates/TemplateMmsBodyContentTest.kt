// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateMmsBodyContentTest {

    @Test
    fun create() {
        val templateMmsBodyContent =
            TemplateMmsBodyContent.builder()
                .template("template")
                .type("type")
                .addVariable(
                    TemplateVariable.builder()
                        .name("x")
                        .props(
                            TemplateVariableProps.builder()
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
                .addMedia(TemplateMediaItem.builder().mediaType("mediaType").url("url").build())
                .subject("subject")
                .build()

        assertThat(templateMmsBodyContent.template()).isEqualTo("template")
        assertThat(templateMmsBodyContent.type()).contains("type")
        assertThat(templateMmsBodyContent.variables().getOrNull())
            .containsExactly(
                TemplateVariable.builder()
                    .name("x")
                    .props(
                        TemplateVariableProps.builder()
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
        assertThat(templateMmsBodyContent.media().getOrNull())
            .containsExactly(TemplateMediaItem.builder().mediaType("mediaType").url("url").build())
        assertThat(templateMmsBodyContent.subject()).contains("subject")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateMmsBodyContent =
            TemplateMmsBodyContent.builder()
                .template("template")
                .type("type")
                .addVariable(
                    TemplateVariable.builder()
                        .name("x")
                        .props(
                            TemplateVariableProps.builder()
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
                .addMedia(TemplateMediaItem.builder().mediaType("mediaType").url("url").build())
                .subject("subject")
                .build()

        val roundtrippedTemplateMmsBodyContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateMmsBodyContent),
                jacksonTypeRef<TemplateMmsBodyContent>(),
            )

        assertThat(roundtrippedTemplateMmsBodyContent).isEqualTo(templateMmsBodyContent)
    }
}
