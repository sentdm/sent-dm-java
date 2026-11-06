// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComplianceAttachmentTemplateTest {

    @Test
    fun create() {
        val complianceAttachmentTemplate =
            ComplianceAttachmentTemplate.builder()
                .fieldName("field_name")
                .label("label")
                .required(true)
                .build()

        assertThat(complianceAttachmentTemplate.fieldName()).contains("field_name")
        assertThat(complianceAttachmentTemplate.label()).contains("label")
        assertThat(complianceAttachmentTemplate.required()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val complianceAttachmentTemplate =
            ComplianceAttachmentTemplate.builder()
                .fieldName("field_name")
                .label("label")
                .required(true)
                .build()

        val roundtrippedComplianceAttachmentTemplate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(complianceAttachmentTemplate),
                jacksonTypeRef<ComplianceAttachmentTemplate>(),
            )

        assertThat(roundtrippedComplianceAttachmentTemplate).isEqualTo(complianceAttachmentTemplate)
    }
}
