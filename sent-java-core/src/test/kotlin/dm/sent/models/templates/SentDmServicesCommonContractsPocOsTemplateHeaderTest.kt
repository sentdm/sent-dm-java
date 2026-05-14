// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesCommonContractsPocOsTemplateHeaderTest {

    @Test
    fun create() {
        val sentDmServicesCommonContractsPocOsTemplateHeader =
            SentDmServicesCommonContractsPocOsTemplateHeader.builder()
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

        assertThat(sentDmServicesCommonContractsPocOsTemplateHeader.template())
            .isEqualTo("template")
        assertThat(sentDmServicesCommonContractsPocOsTemplateHeader.type()).contains("type")
        assertThat(sentDmServicesCommonContractsPocOsTemplateHeader.variables().getOrNull())
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
        val sentDmServicesCommonContractsPocOsTemplateHeader =
            SentDmServicesCommonContractsPocOsTemplateHeader.builder()
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

        val roundtrippedSentDmServicesCommonContractsPocOsTemplateHeader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sentDmServicesCommonContractsPocOsTemplateHeader),
                jacksonTypeRef<SentDmServicesCommonContractsPocOsTemplateHeader>(),
            )

        assertThat(roundtrippedSentDmServicesCommonContractsPocOsTemplateHeader)
            .isEqualTo(sentDmServicesCommonContractsPocOsTemplateHeader)
    }
}
