// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateEventTest {

    @Test
    fun create() {
        val templateEvent =
            TemplateEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    TemplateEventPayload.builder()
                        .status("status")
                        .whatsappTemplateId("whatsapp_template_id")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .category("category")
                        .channel("channel")
                        .language("language")
                        .reason("reason")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
                        .build()
                )
                .timestamp("timestamp")
                .build()

        assertThat(templateEvent.event()).contains("event")
        assertThat(templateEvent.field()).contains("field")
        assertThat(templateEvent.payload())
            .contains(
                TemplateEventPayload.builder()
                    .status("status")
                    .whatsappTemplateId("whatsapp_template_id")
                    .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .category("category")
                    .channel("channel")
                    .language("language")
                    .reason("reason")
                    .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .templateName("template_name")
                    .build()
            )
        assertThat(templateEvent.timestamp()).contains("timestamp")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateEvent =
            TemplateEvent.builder()
                .event("event")
                .field("field")
                .payload(
                    TemplateEventPayload.builder()
                        .status("status")
                        .whatsappTemplateId("whatsapp_template_id")
                        .accountId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .category("category")
                        .channel("channel")
                        .language("language")
                        .reason("reason")
                        .templateId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .templateName("template_name")
                        .build()
                )
                .timestamp("timestamp")
                .build()

        val roundtrippedTemplateEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateEvent),
                jacksonTypeRef<TemplateEvent>(),
            )

        assertThat(roundtrippedTemplateEvent).isEqualTo(templateEvent)
    }
}
