// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AgentEventPayloadTest {

    @Test
    fun create() {
        val agentEventPayload =
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

        assertThat(agentEventPayload.eventId()).isEqualTo("event_id")
        assertThat(agentEventPayload.occurredAt()).isEqualTo("occurred_at")
        assertThat(agentEventPayload.accountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(agentEventPayload.actor()).contains("actor")
        assertThat(agentEventPayload.agentId()).contains("agent_id")
        assertThat(agentEventPayload.agentName()).contains("agent_name")
        assertThat(agentEventPayload.agentVersion()).contains(0)
        assertThat(agentEventPayload.contactId()).contains("contact_id")
        assertThat(agentEventPayload.contactPhoneNumber()).contains("contact_phone_number")
        assertThat(agentEventPayload._data()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(agentEventPayload.instanceId()).contains("instance_id")
        assertThat(agentEventPayload.sequence()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val agentEventPayload =
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

        val roundtrippedAgentEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(agentEventPayload),
                jacksonTypeRef<AgentEventPayload>(),
            )

        assertThat(roundtrippedAgentEventPayload).isEqualTo(agentEventPayload)
    }
}
