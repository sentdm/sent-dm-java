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

        assertThat(sentDmServicesCommonContractsPocOsTemplateFooter.template()).contains("template")
        assertThat(sentDmServicesCommonContractsPocOsTemplateFooter.type()).contains("type")
        assertThat(sentDmServicesCommonContractsPocOsTemplateFooter.variables().getOrNull())
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
        val sentDmServicesCommonContractsPocOsTemplateFooter =
            SentDmServicesCommonContractsPocOsTemplateFooter.builder()
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

        val roundtrippedSentDmServicesCommonContractsPocOsTemplateFooter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sentDmServicesCommonContractsPocOsTemplateFooter),
                jacksonTypeRef<SentDmServicesCommonContractsPocOsTemplateFooter>(),
            )

        assertThat(roundtrippedSentDmServicesCommonContractsPocOsTemplateFooter)
            .isEqualTo(sentDmServicesCommonContractsPocOsTemplateFooter)
    }
}
