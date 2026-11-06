// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.compliance

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfComplianceRequirementsTest {

    @Test
    fun create() {
        val apiResponseOfComplianceRequirements =
            ApiResponseOfComplianceRequirements.builder()
                .data(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(apiResponseOfComplianceRequirements.data())
            .contains(
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
            )
        assertThat(apiResponseOfComplianceRequirements.error())
            .contains(
                ErrorDetail.builder()
                    .code("code")
                    .details(
                        ErrorDetail.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(apiResponseOfComplianceRequirements.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfComplianceRequirements.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfComplianceRequirements =
            ApiResponseOfComplianceRequirements.builder()
                .data(
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
                )
                .error(
                    ErrorDetail.builder()
                        .code("code")
                        .details(
                            ErrorDetail.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedApiResponseOfComplianceRequirements =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfComplianceRequirements),
                jacksonTypeRef<ApiResponseOfComplianceRequirements>(),
            )

        assertThat(roundtrippedApiResponseOfComplianceRequirements)
            .isEqualTo(apiResponseOfComplianceRequirements)
    }
}
