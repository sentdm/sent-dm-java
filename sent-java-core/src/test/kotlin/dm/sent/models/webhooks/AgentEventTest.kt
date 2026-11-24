// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentEventTest {

    @Test
    fun create() {
        val agentEvent =
            AgentEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    AgentEventPayload.builder()
                        .eventId("event_id")
                        .occurredAt("occurred_at")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .actor("actor")
                        .agentId("agent_id")
                        .agentName("agent_name")
                        .agentVersion(0)
                        .contactId("contact_id")
                        .contactPhoneNumber("contact_phone_number")
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .instanceId("instance_id")
                        .sequence(0L)
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        assertThat(agentEvent.event()).contains("event")
        assertThat(agentEvent.field()).contains("field")
        assertThat(agentEvent.payload())
            .contains(
                AgentEventPayload.builder()
                    .eventId("event_id")
                    .occurredAt("occurred_at")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .actor("actor")
                    .agentId("agent_id")
                    .agentName("agent_name")
                    .agentVersion(0)
                    .contactId("contact_id")
                    .contactPhoneNumber("contact_phone_number")
                    .data(JsonValue.from(mapOf<String, Any>()))
                    .instanceId("instance_id")
                    .sequence(0L)
                    .build()
            )
        assertThat(agentEvent.requestId()).contains("request_id")
        assertThat(agentEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentEvent =
            AgentEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    AgentEventPayload.builder()
                        .eventId("event_id")
                        .occurredAt("occurred_at")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .actor("actor")
                        .agentId("agent_id")
                        .agentName("agent_name")
                        .agentVersion(0)
                        .contactId("contact_id")
                        .contactPhoneNumber("contact_phone_number")
                        .data(JsonValue.from(mapOf<String, Any>()))
                        .instanceId("instance_id")
                        .sequence(0L)
                        .build()
                )
                .requestId("request_id")
                .timestamp("timestamp")
                .build()

        val roundtrippedAgentEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentEvent),
                jacksonTypeRef<AgentEvent>(),
            )

        assertThat(roundtrippedAgentEvent).isEqualTo(agentEvent)
    }
}
