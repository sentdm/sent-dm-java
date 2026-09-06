// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateEventPayloadTest {

    @Test
    fun create() {
        val templateEventPayload =
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

        assertThat(templateEventPayload.status()).isEqualTo("status")
        assertThat(templateEventPayload.whatsappTemplateId()).isEqualTo("whatsapp_template_id")
        assertThat(templateEventPayload.accountId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(templateEventPayload.category()).contains("category")
        assertThat(templateEventPayload.channel()).contains("channel")
        assertThat(templateEventPayload.language()).contains("language")
        assertThat(templateEventPayload.reason()).contains("reason")
        assertThat(templateEventPayload.templateId())
            .contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(templateEventPayload.templateName()).contains("template_name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateEventPayload =
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

        val roundtrippedTemplateEventPayload =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateEventPayload),
                jacksonTypeRef<TemplateEventPayload>(),
            )

        assertThat(roundtrippedTemplateEventPayload).isEqualTo(templateEventPayload)
    }
}
