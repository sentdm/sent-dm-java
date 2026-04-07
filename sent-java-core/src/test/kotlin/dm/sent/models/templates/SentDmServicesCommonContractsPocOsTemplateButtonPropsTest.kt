// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesCommonContractsPocOsTemplateButtonPropsTest {

    @Test
    fun create() {
        val sentDmServicesCommonContractsPocOsTemplateButtonProps =
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

        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.activeFor()).isEqualTo(1)
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.countryCode())
            .isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.offerCode()).isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.phoneNumber())
            .isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.quickReplyType())
            .isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.text()).isEqualTo("text")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.url()).isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.urlType()).isEqualTo("x")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.autofillText())
            .contains("autofillText")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.otpType())
            .contains("otpType")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.packageName())
            .contains("packageName")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.signatureHash())
            .contains("signatureHash")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesCommonContractsPocOsTemplateButtonProps =
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

        val roundtrippedSentDmServicesCommonContractsPocOsTemplateButtonProps =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    sentDmServicesCommonContractsPocOsTemplateButtonProps
                ),
                jacksonTypeRef<SentDmServicesCommonContractsPocOsTemplateButtonProps>(),
            )

        assertThat(roundtrippedSentDmServicesCommonContractsPocOsTemplateButtonProps)
            .isEqualTo(sentDmServicesCommonContractsPocOsTemplateButtonProps)
    }
}
