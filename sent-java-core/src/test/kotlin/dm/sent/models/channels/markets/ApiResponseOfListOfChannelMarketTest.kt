// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.channels.sms.SmsNumber
import dm.sent.models.channels.sms.SuppliedCampaign
import dm.sent.models.channels.sms.SuppliedCompliance
import dm.sent.models.channels.sms.SuppliedDocument
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfListOfChannelMarketTest {

    @Test
    fun create() {
        val apiResponseOfListOfChannelMarket =
            ApiResponseOfListOfChannelMarket.builder()
                .addData(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfListOfChannelMarket.data().getOrNull())
            .containsExactly(
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
            )
        assertThat(apiResponseOfListOfChannelMarket.error())
            .contains(
                ErrorDetail.builder()
                    .code("code")
                    .details(
                        ErrorDetail.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseOfListOfChannelMarket.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfListOfChannelMarket.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfListOfChannelMarket =
            ApiResponseOfListOfChannelMarket.builder()
                .addData(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfListOfChannelMarket =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfListOfChannelMarket),
                jacksonTypeRef<ApiResponseOfListOfChannelMarket>(),
            )

        assertThat(roundtrippedApiResponseOfListOfChannelMarket)
            .isEqualTo(apiResponseOfListOfChannelMarket)
    }
}
