// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ComplianceRequirementTest {

    @Test
    fun create() {
        val complianceRequirement =
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

        assertThat(complianceRequirement.format()).contains("format")
        assertThat(complianceRequirement.itemFields().getOrNull()).containsExactly()
        assertThat(complianceRequirement.key()).contains("key")
        assertThat(complianceRequirement.label()).contains("label")
        assertThat(complianceRequirement.maxItems()).contains(0)
        assertThat(complianceRequirement.minLength()).contains(0)
        assertThat(complianceRequirement.notes()).contains("notes")
        assertThat(complianceRequirement.options().getOrNull()).containsExactly("string")
        assertThat(complianceRequirement.required()).contains(true)
        assertThat(complianceRequirement.requiredWhen()).contains("required_when")
        assertThat(complianceRequirement.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val complianceRequirement =
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

        val roundtrippedComplianceRequirement =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(complianceRequirement),
                jacksonTypeRef<ComplianceRequirement>(),
            )

        assertThat(roundtrippedComplianceRequirement).isEqualTo(complianceRequirement)
    }
}
