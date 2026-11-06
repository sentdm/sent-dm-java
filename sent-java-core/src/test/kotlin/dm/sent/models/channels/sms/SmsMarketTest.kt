// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmsMarketTest {

    @Test
    fun create() {
        val smsMarket =
            SmsMarket.builder()
                .compliance(
                    SuppliedCompliance.builder()
                        .brand(
                            SuppliedCompliance.Brand.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .campaign(
                            SuppliedCompliance.Campaign.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addDocument(
                            SuppliedDocument.builder()
                                .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .fileName("file_name")
                                .key("key")
                                .build()
                        )
                        .build()
                )
                .country("country")
                .numberType("number_type")
                .addNumber(
                    SmsNumber.builder()
                        .areaCode("area_code")
                        .senderValue("sender_value")
                        .status("status")
                        .build()
                )
                .reason("reason")
                .reasonCode("reason_code")
                .senderValue("sender_value")
                .status(SmsMarket.Status.PROVISIONING)
                .build()

        assertThat(smsMarket.compliance())
            .contains(
                SuppliedCompliance.builder()
                    .brand(
                        SuppliedCompliance.Brand.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .campaign(
                        SuppliedCompliance.Campaign.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .addDocument(
                        SuppliedDocument.builder()
                            .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .fileName("file_name")
                            .key("key")
                            .build()
                    )
                    .build()
            )
        assertThat(smsMarket.country()).contains("country")
        assertThat(smsMarket.numberType()).contains("number_type")
        assertThat(smsMarket.numbers().getOrNull())
            .containsExactly(
                SmsNumber.builder()
                    .areaCode("area_code")
                    .senderValue("sender_value")
                    .status("status")
                    .build()
            )
        assertThat(smsMarket.reason()).contains("reason")
        assertThat(smsMarket.reasonCode()).contains("reason_code")
        assertThat(smsMarket.senderValue()).contains("sender_value")
        assertThat(smsMarket.status()).contains(SmsMarket.Status.PROVISIONING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val smsMarket =
            SmsMarket.builder()
                .compliance(
                    SuppliedCompliance.builder()
                        .brand(
                            SuppliedCompliance.Brand.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .campaign(
                            SuppliedCompliance.Campaign.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addDocument(
                            SuppliedDocument.builder()
                                .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .fileName("file_name")
                                .key("key")
                                .build()
                        )
                        .build()
                )
                .country("country")
                .numberType("number_type")
                .addNumber(
                    SmsNumber.builder()
                        .areaCode("area_code")
                        .senderValue("sender_value")
                        .status("status")
                        .build()
                )
                .reason("reason")
                .reasonCode("reason_code")
                .senderValue("sender_value")
                .status(SmsMarket.Status.PROVISIONING)
                .build()

        val roundtrippedSmsMarket =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(smsMarket),
                jacksonTypeRef<SmsMarket>(),
            )

        assertThat(roundtrippedSmsMarket).isEqualTo(smsMarket)
    }
}
