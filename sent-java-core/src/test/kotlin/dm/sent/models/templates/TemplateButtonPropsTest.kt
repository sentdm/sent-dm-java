// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateButtonPropsTest {

    @Test
    fun create() {
        val templateButtonProps =
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

        assertThat(templateButtonProps.activeFor()).isEqualTo(1)
        assertThat(templateButtonProps.countryCode()).isEqualTo("x")
        assertThat(templateButtonProps.offerCode()).isEqualTo("x")
        assertThat(templateButtonProps.phoneNumber()).isEqualTo("x")
        assertThat(templateButtonProps.quickReplyType()).isEqualTo("x")
        assertThat(templateButtonProps.text()).isEqualTo("text")
        assertThat(templateButtonProps.url()).isEqualTo("url")
        assertThat(templateButtonProps.urlType()).isEqualTo("x")
        assertThat(templateButtonProps.variables())
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
        assertThat(templateButtonProps.autofillText()).contains("autofillText")
        assertThat(templateButtonProps.otpType()).contains("otpType")
        assertThat(templateButtonProps.packageName()).contains("packageName")
        assertThat(templateButtonProps.signatureHash()).contains("signatureHash")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateButtonProps =
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

        val roundtrippedTemplateButtonProps =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateButtonProps),
                jacksonTypeRef<TemplateButtonProps>(),
            )

        assertThat(roundtrippedTemplateButtonProps).isEqualTo(templateButtonProps)
    }
}
