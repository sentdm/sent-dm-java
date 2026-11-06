// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComplianceRequirementsTest {

    @Test
    fun create() {
        val complianceRequirements =
            ComplianceRequirements.builder()
                .channel("channel")
                .country("country")
                .required(true)
                .addRequirement(
                    ComplianceRequirement.builder()
                        .format("format")
                        .itemFields(listOf())
                        .key("key")
                        .label("label")
                        .maxItems(0)
                        .minLength(0)
                        .notes("notes")
                        .addOption("string")
                        .required(true)
                        .requiredWhen("required_when")
                        .type("type")
                        .build()
                )
                .senderIdPattern("sender_id_pattern")
                .addSetup(
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
                )
                .type("type")
                .build()

        assertThat(complianceRequirements.channel()).contains("channel")
        assertThat(complianceRequirements.country()).contains("country")
        assertThat(complianceRequirements.required()).contains(true)
        assertThat(complianceRequirements.requirements().getOrNull())
            .containsExactly(
                ComplianceRequirement.builder()
                    .format("format")
                    .itemFields(listOf())
                    .key("key")
                    .label("label")
                    .maxItems(0)
                    .minLength(0)
                    .notes("notes")
                    .addOption("string")
                    .required(true)
                    .requiredWhen("required_when")
                    .type("type")
                    .build()
            )
        assertThat(complianceRequirements.senderIdPattern()).contains("sender_id_pattern")
        assertThat(complianceRequirements.setup().getOrNull())
            .containsExactly(
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
            )
        assertThat(complianceRequirements.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val complianceRequirements =
            ComplianceRequirements.builder()
                .channel("channel")
                .country("country")
                .required(true)
                .addRequirement(
                    ComplianceRequirement.builder()
                        .format("format")
                        .itemFields(listOf())
                        .key("key")
                        .label("label")
                        .maxItems(0)
                        .minLength(0)
                        .notes("notes")
                        .addOption("string")
                        .required(true)
                        .requiredWhen("required_when")
                        .type("type")
                        .build()
                )
                .senderIdPattern("sender_id_pattern")
                .addSetup(
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
                )
                .type("type")
                .build()

        val roundtrippedComplianceRequirements =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(complianceRequirements),
                jacksonTypeRef<ComplianceRequirements>(),
            )

        assertThat(roundtrippedComplianceRequirements).isEqualTo(complianceRequirements)
    }
}
