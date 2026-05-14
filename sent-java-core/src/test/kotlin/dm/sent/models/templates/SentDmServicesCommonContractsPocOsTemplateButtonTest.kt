// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesCommonContractsPocOsTemplateButtonTest {

    @Test
    fun create() {
        val sentDmServicesCommonContractsPocOsTemplateButton =
            SentDmServicesCommonContractsPocOsTemplateButton.builder()
                .props(
                    SentDmServicesCommonContractsPocOsTemplateButtonProps.builder()
                        .activeFor(1)
                        .countryCode("x")
                        .offerCode("x")
                        .phoneNumber("x")
                        .quickReplyType("x")
                        .text("text")
                        .url("x")
                        .urlType("x")
                        .autofillText("autofillText")
                        .otpType("otpType")
                        .packageName("packageName")
                        .signatureHash("signatureHash")
                        .build()
                )
                .type("x")
                .id(0)
                .build()

        assertThat(sentDmServicesCommonContractsPocOsTemplateButton.props())
            .isEqualTo(
                SentDmServicesCommonContractsPocOsTemplateButtonProps.builder()
                    .activeFor(1)
                    .countryCode("x")
                    .offerCode("x")
                    .phoneNumber("x")
                    .quickReplyType("x")
                    .text("text")
                    .url("x")
                    .urlType("x")
                    .autofillText("autofillText")
                    .otpType("otpType")
                    .packageName("packageName")
                    .signatureHash("signatureHash")
                    .build()
            )
        assertThat(sentDmServicesCommonContractsPocOsTemplateButton.type()).isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButton.id()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesCommonContractsPocOsTemplateButton =
            SentDmServicesCommonContractsPocOsTemplateButton.builder()
                .props(
                    SentDmServicesCommonContractsPocOsTemplateButtonProps.builder()
                        .activeFor(1)
                        .countryCode("x")
                        .offerCode("x")
                        .phoneNumber("x")
                        .quickReplyType("x")
                        .text("text")
                        .url("x")
                        .urlType("x")
                        .autofillText("autofillText")
                        .otpType("otpType")
                        .packageName("packageName")
                        .signatureHash("signatureHash")
                        .build()
                )
                .type("x")
                .id(0)
                .build()

        val roundtrippedSentDmServicesCommonContractsPocOsTemplateButton =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sentDmServicesCommonContractsPocOsTemplateButton),
                jacksonTypeRef<SentDmServicesCommonContractsPocOsTemplateButton>(),
            )

        assertThat(roundtrippedSentDmServicesCommonContractsPocOsTemplateButton)
            .isEqualTo(sentDmServicesCommonContractsPocOsTemplateButton)
    }
}
