// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateHeaderLocationTest {

    @Test
    fun create() {
        val templateHeaderLocation =
            TemplateHeaderLocation.builder()
                .address("x")
                .latitude("x")
                .longitude("x")
                .name("x")
                .build()

        assertThat(templateHeaderLocation.address()).isEqualTo("x")
        assertThat(templateHeaderLocation.latitude()).isEqualTo("x")
        assertThat(templateHeaderLocation.longitude()).isEqualTo("x")
        assertThat(templateHeaderLocation.name()).isEqualTo("x")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateHeaderLocation =
            TemplateHeaderLocation.builder()
                .address("x")
                .latitude("x")
                .longitude("x")
                .name("x")
                .build()

        val roundtrippedTemplateHeaderLocation =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateHeaderLocation),
                jacksonTypeRef<TemplateHeaderLocation>(),
            )

        assertThat(roundtrippedTemplateHeaderLocation).isEqualTo(templateHeaderLocation)
    }
}
