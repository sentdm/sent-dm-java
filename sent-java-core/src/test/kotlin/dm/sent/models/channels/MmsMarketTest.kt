// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MmsMarketTest {

    @Test
    fun create() {
        val mmsMarket =
            MmsMarket.builder()
                .country("country")
                .numberType("number_type")
                .senderValue("sender_value")
                .status("status")
                .build()

        assertThat(mmsMarket.country()).contains("country")
        assertThat(mmsMarket.numberType()).contains("number_type")
        assertThat(mmsMarket.senderValue()).contains("sender_value")
        assertThat(mmsMarket.status()).contains("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mmsMarket =
            MmsMarket.builder()
                .country("country")
                .numberType("number_type")
                .senderValue("sender_value")
                .status("status")
                .build()

        val roundtrippedMmsMarket =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mmsMarket),
                jacksonTypeRef<MmsMarket>(),
            )

        assertThat(roundtrippedMmsMarket).isEqualTo(mmsMarket)
    }
}
