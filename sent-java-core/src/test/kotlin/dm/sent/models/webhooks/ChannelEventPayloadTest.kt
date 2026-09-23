// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
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
                .compliance(
                    ChannelEventPayload.Compliance.builder()
                        .brand(
                            ChannelEventPayload.Compliance.Brand.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .campaign(
                            ChannelEventPayload.Compliance.Campaign.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addDocument(
                            ChannelEventPayload.Compliance.Document.builder()
                                .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .fileName("file_name")
                                .key("key")
                                .build()
                        )
                        .build()
                )
                .numberType("number_type")
                .reason("reason")
                .senderValue("sender_value")
                .status("status")
                .updatedAt("updated_at")
                .build()

        assertThat(channelEventPayload.country()).isEqualTo("country")
        assertThat(channelEventPayload.accountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(channelEventPayload.channel()).contains("channel")
        assertThat(channelEventPayload.compliance())
            .contains(
                ChannelEventPayload.Compliance.builder()
                    .brand(
                        ChannelEventPayload.Compliance.Brand.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .campaign(
                        ChannelEventPayload.Compliance.Campaign.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .addDocument(
                        ChannelEventPayload.Compliance.Document.builder()
                            .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .fileName("file_name")
                            .key("key")
                            .build()
                    )
                    .build()
            )
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
                .compliance(
                    ChannelEventPayload.Compliance.builder()
                        .brand(
                            ChannelEventPayload.Compliance.Brand.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .campaign(
                            ChannelEventPayload.Compliance.Campaign.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .addDocument(
                            ChannelEventPayload.Compliance.Document.builder()
                                .documentId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .fileName("file_name")
                                .key("key")
                                .build()
                        )
                        .build()
                )
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
