// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LinkEventTest {

    @Test
    fun create() {
        val linkEvent =
            LinkEvent.builder()
                .event("event")
                .field("field")
                .payload(
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
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        assertThat(linkEvent.event()).contains("event")
        assertThat(linkEvent.field()).contains("field")
        assertThat(linkEvent.payload())
            .contains(
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
            )
        assertThat(linkEvent.requestId()).contains("request_id")
        assertThat(linkEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val linkEvent =
            LinkEvent.builder()
                .event("event")
                .field("field")
                .payload(
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
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        val roundtrippedLinkEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(linkEvent),
                jacksonTypeRef<LinkEvent>(),
            )

        assertThat(roundtrippedLinkEvent).isEqualTo(linkEvent)
    }
}
