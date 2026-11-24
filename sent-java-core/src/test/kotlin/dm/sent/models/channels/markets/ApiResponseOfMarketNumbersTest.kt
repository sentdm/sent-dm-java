// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfMarketNumbersTest {

    @Test
    fun create() {
        val apiResponseOfMarketNumbers =
            ApiResponseOfMarketNumbers.builder()
                .data(
                    MarketNumbers.builder()
                        .channel("channel")
                        .country("country")
                        .addNumber(
                            MarketNumber.builder()
                                .areaCode("area_code")
                                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .senderValue("sender_value")
                                .status("status")
                                .type("type")
                                .build()
                        )
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

        assertThat(apiResponseOfMarketNumbers.data())
            .contains(
                MarketNumbers.builder()
                    .channel("channel")
                    .country("country")
                    .addNumber(
                        MarketNumber.builder()
                            .areaCode("area_code")
                            .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .senderValue("sender_value")
                            .status("status")
                            .type("type")
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfMarketNumbers.error())
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
        assertThat(apiResponseOfMarketNumbers.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfMarketNumbers.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfMarketNumbers =
            ApiResponseOfMarketNumbers.builder()
                .data(
                    MarketNumbers.builder()
                        .channel("channel")
                        .country("country")
                        .addNumber(
                            MarketNumber.builder()
                                .areaCode("area_code")
                                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .senderValue("sender_value")
                                .status("status")
                                .type("type")
                                .build()
                        )
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

        val roundtrippedApiResponseOfMarketNumbers =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfMarketNumbers),
                jacksonTypeRef<ApiResponseOfMarketNumbers>(),
            )

        assertThat(roundtrippedApiResponseOfMarketNumbers).isEqualTo(apiResponseOfMarketNumbers)
    }
}
