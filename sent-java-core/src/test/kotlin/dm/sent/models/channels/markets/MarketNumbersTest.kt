// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.markets

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MarketNumbersTest {

    @Test
    fun create() {
        val marketNumbers =
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

        assertThat(marketNumbers.channel()).contains("channel")
        assertThat(marketNumbers.country()).contains("country")
        assertThat(marketNumbers.numbers().getOrNull())
            .containsExactly(
                MarketNumber.builder()
                    .areaCode("area_code")
                    .campaignId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .senderValue("sender_value")
                    .status("status")
                    .type("type")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val marketNumbers =
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

        val roundtrippedMarketNumbers =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(marketNumbers),
                jacksonTypeRef<MarketNumbers>(),
            )

        assertThat(roundtrippedMarketNumbers).isEqualTo(marketNumbers)
    }
}
