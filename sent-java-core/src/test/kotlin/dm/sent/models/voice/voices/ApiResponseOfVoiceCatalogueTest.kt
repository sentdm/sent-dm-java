// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.voices

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfVoiceCatalogueTest {

    @Test
    fun create() {
        val apiResponseOfVoiceCatalogue =
            ApiResponseOfVoiceCatalogue.builder()
                .data(
                    VoiceCatalogue.builder()
                        .addLanguage("string")
                        .addVoice(
                            VoiceCatalogueVoice.builder()
                                .default_(true)
                                .description("description")
                                .language("language")
                                .name("name")
                                .build()
                        )
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

        assertThat(apiResponseOfVoiceCatalogue.data())
            .contains(
                VoiceCatalogue.builder()
                    .addLanguage("string")
                    .addVoice(
                        VoiceCatalogueVoice.builder()
                            .default_(true)
                            .description("description")
                            .language("language")
                            .name("name")
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfVoiceCatalogue.error())
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
        assertThat(apiResponseOfVoiceCatalogue.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfVoiceCatalogue.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfVoiceCatalogue =
            ApiResponseOfVoiceCatalogue.builder()
                .data(
                    VoiceCatalogue.builder()
                        .addLanguage("string")
                        .addVoice(
                            VoiceCatalogueVoice.builder()
                                .default_(true)
                                .description("description")
                                .language("language")
                                .name("name")
                                .build()
                        )
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

        val roundtrippedApiResponseOfVoiceCatalogue =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfVoiceCatalogue),
                jacksonTypeRef<ApiResponseOfVoiceCatalogue>(),
            )

        assertThat(roundtrippedApiResponseOfVoiceCatalogue).isEqualTo(apiResponseOfVoiceCatalogue)
    }
}
