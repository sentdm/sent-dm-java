// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactEventTest {

    @Test
    fun create() {
        val contactEvent =
            ContactEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    ContactEventPayload.builder()
                        .optOut(true)
                        .source("source")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .phoneNumber("phone_number")
                        .text("text")
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        assertThat(contactEvent.event()).contains("event")
        assertThat(contactEvent.field()).contains("field")
        assertThat(contactEvent.payload())
            .contains(
                ContactEventPayload.builder()
                    .optOut(true)
                    .source("source")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .channel("channel")
                    .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .phoneNumber("phone_number")
                    .text("text")
                    .build()
            )
        assertThat(contactEvent.requestId()).contains("request_id")
        assertThat(contactEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactEvent =
            ContactEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    ContactEventPayload.builder()
                        .optOut(true)
                        .source("source")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .channel("channel")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .phoneNumber("phone_number")
                        .text("text")
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        val roundtrippedContactEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactEvent),
                jacksonTypeRef<ContactEvent>(),
            )

        assertThat(roundtrippedContactEvent).isEqualTo(contactEvent)
    }
}
