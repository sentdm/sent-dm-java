// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateButtonTest {

    @Test
    fun create() {
        val templateButton =
            TemplateButton.builder()
                .props(
                    TemplateButtonProps.builder()
                        .activeFor(1)
                        .countryCode("x")
                        .offerCode("x")
                        .phoneNumber("x")
                        .quickReplyType("x")
                        .text("text")
                        .url("url")
                        .urlType("x")
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
                        .autofillText("autofillText")
                        .otpType("otpType")
                        .packageName("packageName")
                        .signatureHash("signatureHash")
                        .build()
                )
                .type("x")
                .id(0)
                .build()

        assertThat(templateButton.props())
            .isEqualTo(
                TemplateButtonProps.builder()
                    .activeFor(1)
                    .countryCode("x")
                    .offerCode("x")
                    .phoneNumber("x")
                    .quickReplyType("x")
                    .text("text")
                    .url("url")
                    .urlType("x")
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
                    .autofillText("autofillText")
                    .otpType("otpType")
                    .packageName("packageName")
                    .signatureHash("signatureHash")
                    .build()
            )
        assertThat(templateButton.type()).isEqualTo("x")
        assertThat(templateButton.id()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateButton =
            TemplateButton.builder()
                .props(
                    TemplateButtonProps.builder()
                        .activeFor(1)
                        .countryCode("x")
                        .offerCode("x")
                        .phoneNumber("x")
                        .quickReplyType("x")
                        .text("text")
                        .url("url")
                        .urlType("x")
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
                        .autofillText("autofillText")
                        .otpType("otpType")
                        .packageName("packageName")
                        .signatureHash("signatureHash")
                        .build()
                )
                .type("x")
                .id(0)
                .build()

        val roundtrippedTemplateButton =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateButton),
                jacksonTypeRef<TemplateButton>(),
            )

        assertThat(roundtrippedTemplateButton).isEqualTo(templateButton)
    }
}
