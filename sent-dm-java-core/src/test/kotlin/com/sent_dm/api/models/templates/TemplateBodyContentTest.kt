// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
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
                        .id(0)
                        .name("name")
                        .props(
                            TemplateVariable.Props.builder()
                                .alt("alt")
                                .mediaType("mediaType")
                                .sample("sample")
                                .shortUrl("shortUrl")
                                .url("url")
                                .variableType("variableType")
                                .build()
                        )
                        .type("type")
                        .build()
                )
                .build()

        assertThat(templateBodyContent.template()).contains("template")
        assertThat(templateBodyContent.type()).contains("type")
        assertThat(templateBodyContent.variables().getOrNull())
            .containsExactly(
                TemplateVariable.builder()
                    .id(0)
                    .name("name")
                    .props(
                        TemplateVariable.Props.builder()
                            .alt("alt")
                            .mediaType("mediaType")
                            .sample("sample")
                            .shortUrl("shortUrl")
                            .url("url")
                            .variableType("variableType")
                            .build()
                    )
                    .type("type")
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
                        .id(0)
                        .name("name")
                        .props(
                            TemplateVariable.Props.builder()
                                .alt("alt")
                                .mediaType("mediaType")
                                .sample("sample")
                                .shortUrl("shortUrl")
                                .url("url")
                                .variableType("variableType")
                                .build()
                        )
                        .type("type")
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
