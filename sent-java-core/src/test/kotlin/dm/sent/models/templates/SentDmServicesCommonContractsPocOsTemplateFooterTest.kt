// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesCommonContractsPocOsTemplateFooterTest {

    @Test
    fun create() {
        val sentDmServicesCommonContractsPocOsTemplateFooter =
            SentDmServicesCommonContractsPocOsTemplateFooter.builder()
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

        assertThat(sentDmServicesCommonContractsPocOsTemplateFooter.template())
            .isEqualTo("template")
        assertThat(sentDmServicesCommonContractsPocOsTemplateFooter.type()).contains("type")
        assertThat(sentDmServicesCommonContractsPocOsTemplateFooter.variables().getOrNull())
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
        val sentDmServicesCommonContractsPocOsTemplateFooter =
            SentDmServicesCommonContractsPocOsTemplateFooter.builder()
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

        val roundtrippedSentDmServicesCommonContractsPocOsTemplateFooter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sentDmServicesCommonContractsPocOsTemplateFooter),
                jacksonTypeRef<SentDmServicesCommonContractsPocOsTemplateFooter>(),
            )

        assertThat(roundtrippedSentDmServicesCommonContractsPocOsTemplateFooter)
            .isEqualTo(sentDmServicesCommonContractsPocOsTemplateFooter)
    }
}
