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
                .activeFor(0)
                .autofillText("autofillText")
                .countryCode("countryCode")
                .offerCode("offerCode")
                .otpType("otpType")
                .packageName("packageName")
                .phoneNumber("phoneNumber")
                .quickReplyType("quickReplyType")
                .signatureHash("signatureHash")
                .text("text")
                .url("url")
                .urlType("urlType")
                .build()

        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.activeFor()).contains(0)
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.autofillText())
            .contains("autofillText")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.countryCode())
            .contains("countryCode")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.offerCode())
            .contains("offerCode")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.otpType())
            .contains("otpType")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.packageName())
            .contains("packageName")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.phoneNumber())
            .contains("phoneNumber")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.quickReplyType())
            .contains("quickReplyType")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.signatureHash())
            .contains("signatureHash")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.text()).contains("text")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.url()).contains("url")
        assertThat(sentDmServicesCommonContractsPocOsTemplateButtonProps.urlType())
            .contains("urlType")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesCommonContractsPocOsTemplateButtonProps =
            SentDmServicesCommonContractsPocOsTemplateButtonProps.builder()
                .activeFor(0)
                .autofillText("autofillText")
                .countryCode("countryCode")
                .offerCode("offerCode")
                .otpType("otpType")
                .packageName("packageName")
                .phoneNumber("phoneNumber")
                .quickReplyType("quickReplyType")
                .signatureHash("signatureHash")
                .text("text")
                .url("url")
                .urlType("urlType")
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
