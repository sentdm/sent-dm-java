// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarketNumberTest {

    @Test
    fun create() {
        val marketNumber =
            MarketNumber.builder()
                .areaCode("area_code")
                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .senderValue("sender_value")
                .status("status")
                .type("type")
                .build()

        assertThat(marketNumber.areaCode()).contains("area_code")
        assertThat(marketNumber.campaignId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(marketNumber.senderValue()).contains("sender_value")
        assertThat(marketNumber.status()).contains("status")
        assertThat(marketNumber.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val marketNumber =
            MarketNumber.builder()
                .areaCode("area_code")
                .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .senderValue("sender_value")
                .status("status")
                .type("type")
                .build()

        val roundtrippedMarketNumber =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(marketNumber),
                jacksonTypeRef<MarketNumber>(),
            )

        assertThat(roundtrippedMarketNumber).isEqualTo(marketNumber)
    }
}
