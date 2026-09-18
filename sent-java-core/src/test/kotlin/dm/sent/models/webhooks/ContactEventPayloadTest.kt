// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactEventPayloadTest {

    @Test
    fun create() {
        val contactEventPayload =
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

        assertThat(contactEventPayload.optOut()).isEqualTo(true)
        assertThat(contactEventPayload.source()).isEqualTo("source")
        assertThat(contactEventPayload.accountId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(contactEventPayload.channel()).contains("channel")
        assertThat(contactEventPayload.contactId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(contactEventPayload.messageId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(contactEventPayload.phoneNumber()).contains("phone_number")
        assertThat(contactEventPayload.text()).contains("text")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactEventPayload =
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

        val roundtrippedContactEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactEventPayload),
                jacksonTypeRef<ContactEventPayload>(),
            )

        assertThat(roundtrippedContactEventPayload).isEqualTo(contactEventPayload)
    }
}
