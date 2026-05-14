// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateUpdateResponseTest {

    @Test
    fun create() {
        val templateUpdateResponse =
            TemplateUpdateResponse.builder()
                .data(
                    TemplateUpdateResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .category("category")
                        .addChannel("string")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isPublished(true)
                        .language("language")
                        .name("name")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addVariable("string")
                        .build()
                )
                .error(
                    TemplateUpdateResponse.Error.builder()
                        .code("code")
                        .details(
                            TemplateUpdateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    TemplateUpdateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(templateUpdateResponse.data())
            .contains(
                TemplateUpdateResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .category("category")
                    .addChannel("string")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .isPublished(true)
                    .language("language")
                    .name("name")
                    .status("status")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .addVariable("string")
                    .build()
            )
        assertThat(templateUpdateResponse.error())
            .contains(
                TemplateUpdateResponse.Error.builder()
                    .code("code")
                    .details(
                        TemplateUpdateResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(templateUpdateResponse.meta())
            .contains(
                TemplateUpdateResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(templateUpdateResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateUpdateResponse =
            TemplateUpdateResponse.builder()
                .data(
                    TemplateUpdateResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .category("category")
                        .addChannel("string")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .isPublished(true)
                        .language("language")
                        .name("name")
                        .status("status")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .addVariable("string")
                        .build()
                )
                .error(
                    TemplateUpdateResponse.Error.builder()
                        .code("code")
                        .details(
                            TemplateUpdateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    TemplateUpdateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedTemplateUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateUpdateResponse),
                jacksonTypeRef<TemplateUpdateResponse>(),
            )

        assertThat(roundtrippedTemplateUpdateResponse).isEqualTo(templateUpdateResponse)
    }
}
