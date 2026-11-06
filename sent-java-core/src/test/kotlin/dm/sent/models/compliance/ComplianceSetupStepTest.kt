// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComplianceSetupStepTest {

    @Test
    fun create() {
        val complianceSetupStep =
            ComplianceSetupStep.builder()
                .addAttachment(
                    ComplianceAttachmentTemplate.builder()
                        .fieldName("field_name")
                        .label("label")
                        .required(true)
                        .build()
                )
                .body(JsonValue.from(mapOf<String, Any>()))
                .method("method")
                .path("path")
                .resource("resource")
                .step(0)
                .why("why")
                .build()

        assertThat(complianceSetupStep.attachments().getOrNull())
            .containsExactly(
                ComplianceAttachmentTemplate.builder()
                    .fieldName("field_name")
                    .label("label")
                    .required(true)
                    .build()
            )
        assertThat(complianceSetupStep._body()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(complianceSetupStep.method()).contains("method")
        assertThat(complianceSetupStep.path()).contains("path")
        assertThat(complianceSetupStep.resource()).contains("resource")
        assertThat(complianceSetupStep.step()).contains(0)
        assertThat(complianceSetupStep.why()).contains("why")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val complianceSetupStep =
            ComplianceSetupStep.builder()
                .addAttachment(
                    ComplianceAttachmentTemplate.builder()
                        .fieldName("field_name")
                        .label("label")
                        .required(true)
                        .build()
                )
                .body(JsonValue.from(mapOf<String, Any>()))
                .method("method")
                .path("path")
                .resource("resource")
                .step(0)
                .why("why")
                .build()

        val roundtrippedComplianceSetupStep =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(complianceSetupStep),
                jacksonTypeRef<ComplianceSetupStep>(),
            )

        assertThat(roundtrippedComplianceSetupStep).isEqualTo(complianceSetupStep)
    }
}
