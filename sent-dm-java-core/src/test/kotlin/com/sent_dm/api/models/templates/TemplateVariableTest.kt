// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateVariableTest {

    @Test
    fun create() {
        val templateVariable =
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

        assertThat(templateVariable.id()).contains(0)
        assertThat(templateVariable.name()).contains("name")
        assertThat(templateVariable.props())
            .contains(
                TemplateVariable.Props.builder()
                    .alt("alt")
                    .mediaType("mediaType")
                    .sample("sample")
                    .shortUrl("shortUrl")
                    .url("url")
                    .variableType("variableType")
                    .build()
            )
        assertThat(templateVariable.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateVariable =
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

        val roundtrippedTemplateVariable =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateVariable),
                jacksonTypeRef<TemplateVariable>(),
            )

        assertThat(roundtrippedTemplateVariable).isEqualTo(templateVariable)
    }
}
