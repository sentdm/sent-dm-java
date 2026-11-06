// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateVariablePropsTest {

    @Test
    fun create() {
        val templateVariableProps =
            TemplateVariableProps.builder()
                .mediaType("x")
                .sample("x")
                .url("x")
                .variableType("x")
                .alt("alt")
                .regex("regex")
                .shortUrl("shortUrl")
                .build()

        assertThat(templateVariableProps.mediaType()).isEqualTo("x")
        assertThat(templateVariableProps.sample()).isEqualTo("x")
        assertThat(templateVariableProps.url()).isEqualTo("x")
        assertThat(templateVariableProps.variableType()).isEqualTo("x")
        assertThat(templateVariableProps.alt()).contains("alt")
        assertThat(templateVariableProps.regex()).contains("regex")
        assertThat(templateVariableProps.shortUrl()).contains("shortUrl")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateVariableProps =
            TemplateVariableProps.builder()
                .mediaType("x")
                .sample("x")
                .url("x")
                .variableType("x")
                .alt("alt")
                .regex("regex")
                .shortUrl("shortUrl")
                .build()

        val roundtrippedTemplateVariableProps =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateVariableProps),
                jacksonTypeRef<TemplateVariableProps>(),
            )

        assertThat(roundtrippedTemplateVariableProps).isEqualTo(templateVariableProps)
    }
}
