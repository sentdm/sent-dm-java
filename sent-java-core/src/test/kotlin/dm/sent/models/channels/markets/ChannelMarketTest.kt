// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.channels.sms.SmsNumber
import dm.sent.models.channels.sms.SuppliedCampaign
import dm.sent.models.channels.sms.SuppliedCompliance
import dm.sent.models.channels.sms.SuppliedDocument
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelMarketTest {

    @Test
    fun create() {
        val channelMarket =
            ChannelMarket.builder()
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
                        .addCampaign(
                            SuppliedCampaign.builder()
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
                        .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .senderValue("sender_value")
                        .status("status")
                        .build()
                )
                .reason("reason")
                .reasonCode("reason_code")
                .status(ChannelMarket.Status.PROVISIONING)
                .build()

        assertThat(channelMarket.compliance())
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
                    .addCampaign(
                        SuppliedCampaign.builder()
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
        assertThat(channelMarket.country()).contains("country")
        assertThat(channelMarket.numberType()).contains("number_type")
        assertThat(channelMarket.numbers().getOrNull())
            .containsExactly(
                SmsNumber.builder()
                    .areaCode("area_code")
                    .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .senderValue("sender_value")
                    .status("status")
                    .build()
            )
        assertThat(channelMarket.reason()).contains("reason")
        assertThat(channelMarket.reasonCode()).contains("reason_code")
        assertThat(channelMarket.status()).contains(ChannelMarket.Status.PROVISIONING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val channelMarket =
            ChannelMarket.builder()
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
                        .addCampaign(
                            SuppliedCampaign.builder()
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
                        .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .senderValue("sender_value")
                        .status("status")
                        .build()
                )
                .reason("reason")
                .reasonCode("reason_code")
                .status(ChannelMarket.Status.PROVISIONING)
                .build()

        val roundtrippedChannelMarket =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelMarket),
                jacksonTypeRef<ChannelMarket>(),
            )

        assertThat(roundtrippedChannelMarket).isEqualTo(channelMarket)
    }
}
