// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChannelEventPayloadTest {

    @Test
    fun create() {
        val channelEventPayload =
            ChannelEventPayload.builder()
                .country("country")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channel("channel")
                .numberType("number_type")
                .reason("reason")
                .senderValue("sender_value")
                .status("status")
                .updatedAt("updated_at")
                .build()

        assertThat(channelEventPayload.country()).isEqualTo("country")
        assertThat(channelEventPayload.accountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(channelEventPayload.channel()).contains("channel")
        assertThat(channelEventPayload.numberType()).contains("number_type")
        assertThat(channelEventPayload.reason()).contains("reason")
        assertThat(channelEventPayload.senderValue()).contains("sender_value")
        assertThat(channelEventPayload.status()).contains("status")
        assertThat(channelEventPayload.updatedAt()).contains("updated_at")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val channelEventPayload =
            ChannelEventPayload.builder()
                .country("country")
                .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .channel("channel")
                .numberType("number_type")
                .reason("reason")
                .senderValue("sender_value")
                .status("status")
                .updatedAt("updated_at")
                .build()

        val roundtrippedChannelEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(channelEventPayload),
                jacksonTypeRef<ChannelEventPayload>(),
            )

        assertThat(roundtrippedChannelEventPayload).isEqualTo(channelEventPayload)
    }
}
