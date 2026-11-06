// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LinkEventPayloadTest {

    @Test
    fun create() {
        val linkEventPayload =
            LinkEventPayload.builder()
                .recordId("record_id")
                .accessCountry("access_country")
                .accessOutcome("access_outcome")
                .browser("browser")
                .bytesServed(0L)
                .channel("channel")
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .device("device")
                .linkKind("link_kind")
                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .occurredAt("occurred_at")
                .referenceKey("reference_key")
                .referrerHost("referrer_host")
                .requestMethod("request_method")
                .senderProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .statusCode(0)
                .trafficClass("traffic_class")
                .build()

        assertThat(linkEventPayload.recordId()).isEqualTo("record_id")
        assertThat(linkEventPayload.accessCountry()).contains("access_country")
        assertThat(linkEventPayload.accessOutcome()).contains("access_outcome")
        assertThat(linkEventPayload.browser()).contains("browser")
        assertThat(linkEventPayload.bytesServed()).contains(0L)
        assertThat(linkEventPayload.channel()).contains("channel")
        assertThat(linkEventPayload.customerId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(linkEventPayload.device()).contains("device")
        assertThat(linkEventPayload.linkKind()).contains("link_kind")
        assertThat(linkEventPayload.messageId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(linkEventPayload.occurredAt()).contains("occurred_at")
        assertThat(linkEventPayload.referenceKey()).contains("reference_key")
        assertThat(linkEventPayload.referrerHost()).contains("referrer_host")
        assertThat(linkEventPayload.requestMethod()).contains("request_method")
        assertThat(linkEventPayload.senderProfileId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(linkEventPayload.statusCode()).contains(0)
        assertThat(linkEventPayload.trafficClass()).contains("traffic_class")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val linkEventPayload =
            LinkEventPayload.builder()
                .recordId("record_id")
                .accessCountry("access_country")
                .accessOutcome("access_outcome")
                .browser("browser")
                .bytesServed(0L)
                .channel("channel")
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .device("device")
                .linkKind("link_kind")
                .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .occurredAt("occurred_at")
                .referenceKey("reference_key")
                .referrerHost("referrer_host")
                .requestMethod("request_method")
                .senderProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .statusCode(0)
                .trafficClass("traffic_class")
                .build()

        val roundtrippedLinkEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(linkEventPayload),
                jacksonTypeRef<LinkEventPayload>(),
            )

        assertThat(roundtrippedLinkEventPayload).isEqualTo(linkEventPayload)
    }
}
