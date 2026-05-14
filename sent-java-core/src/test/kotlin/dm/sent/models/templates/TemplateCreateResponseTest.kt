// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateCreateResponseTest {

    @Test
    fun create() {
        val templateCreateResponse =
            TemplateCreateResponse.builder()
                .data(
                    TemplateCreateResponse.Data.builder()
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
                    TemplateCreateResponse.Error.builder()
                        .code("code")
                        .details(
                            TemplateCreateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    TemplateCreateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(templateCreateResponse.data())
            .contains(
                TemplateCreateResponse.Data.builder()
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
        assertThat(templateCreateResponse.error())
            .contains(
                TemplateCreateResponse.Error.builder()
                    .code("code")
                    .details(
                        TemplateCreateResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(templateCreateResponse.meta())
            .contains(
                TemplateCreateResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(templateCreateResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val templateCreateResponse =
            TemplateCreateResponse.builder()
                .data(
                    TemplateCreateResponse.Data.builder()
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
                    TemplateCreateResponse.Error.builder()
                        .code("code")
                        .details(
                            TemplateCreateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    TemplateCreateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedTemplateCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(templateCreateResponse),
                jacksonTypeRef<TemplateCreateResponse>(),
            )

        assertThat(roundtrippedTemplateCreateResponse).isEqualTo(templateCreateResponse)
    }
}
