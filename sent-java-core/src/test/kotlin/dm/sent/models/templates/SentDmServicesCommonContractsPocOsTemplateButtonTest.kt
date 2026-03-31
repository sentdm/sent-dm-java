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
                .id(0)
                .props(
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
                )
                .type("type")
                .build()

        assertThat(sentDmServicesCommonContractsPocOsTemplateButton.id()).contains(0)
        assertThat(sentDmServicesCommonContractsPocOsTemplateButton.props())
            .contains(
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
            )
        assertThat(sentDmServicesCommonContractsPocOsTemplateButton.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesCommonContractsPocOsTemplateButton =
            SentDmServicesCommonContractsPocOsTemplateButton.builder()
                .id(0)
                .props(
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
                )
                .type("type")
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
