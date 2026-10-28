// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.voice.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiResponseOfVoiceAgentsListTest {

    @Test
    fun create() {
        val apiResponseOfVoiceAgentsList =
            ApiResponseOfVoiceAgentsList.builder()
                .data(
                    VoiceAgentsList.builder()
                        .addAgent(
                            VoiceAgent.builder()
                                .id("id")
                                .audio(VoiceAgentAudio.builder().sampleRate(0).build())
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .fallback(
                                    VoiceAgentParty.builder().kind("kind").value("value").build()
                                )
                                .greeting("greeting")
                                .limits(
                                    VoiceAgentLimits.builder()
                                        .addAllowedCountry("string")
                                        .maxCallSeconds(0)
                                        .maxConcurrentCalls(0)
                                        .build()
                                )
                                .name("name")
                                .sessionType("session_type")
                                .signingSecret("signing_secret")
                                .speech(
                                    VoiceAgentSpeech.builder()
                                        .language("language")
                                        .setting("setting")
                                        .voice("voice")
                                        .build()
                                )
                                .addTool("string")
                                .transcripts(
                                    VoiceAgentTranscripts.builder()
                                        .retentionDays(0)
                                        .store(true)
                                        .build()
                                )
                                .addTransferTarget(
                                    VoiceAgentParty.builder().kind("kind").value("value").build()
                                )
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .websocketUrl("websocket_url")
                                .build()
                        )
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
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

        assertThat(apiResponseOfVoiceAgentsList.data())
            .contains(
                VoiceAgentsList.builder()
                    .addAgent(
                        VoiceAgent.builder()
                            .id("id")
                            .audio(VoiceAgentAudio.builder().sampleRate(0).build())
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .fallback(VoiceAgentParty.builder().kind("kind").value("value").build())
                            .greeting("greeting")
                            .limits(
                                VoiceAgentLimits.builder()
                                    .addAllowedCountry("string")
                                    .maxCallSeconds(0)
                                    .maxConcurrentCalls(0)
                                    .build()
                            )
                            .name("name")
                            .sessionType("session_type")
                            .signingSecret("signing_secret")
                            .speech(
                                VoiceAgentSpeech.builder()
                                    .language("language")
                                    .setting("setting")
                                    .voice("voice")
                                    .build()
                            )
                            .addTool("string")
                            .transcripts(
                                VoiceAgentTranscripts.builder().retentionDays(0).store(true).build()
                            )
                            .addTransferTarget(
                                VoiceAgentParty.builder().kind("kind").value("value").build()
                            )
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .websocketUrl("websocket_url")
                            .build()
                    )
                    .pagination(
                        PaginationMeta.builder()
                            .cursors(
                                PaginationMeta.Cursors.builder()
                                    .after("after")
                                    .before("before")
                                    .build()
                            )
                            .hasMore(true)
                            .page(0)
                            .pageSize(0)
                            .totalCount(0)
                            .totalPages(0)
                            .build()
                    )
                    .build()
            )
        assertThat(apiResponseOfVoiceAgentsList.error())
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
        assertThat(apiResponseOfVoiceAgentsList.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(apiResponseOfVoiceAgentsList.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val apiResponseOfVoiceAgentsList =
            ApiResponseOfVoiceAgentsList.builder()
                .data(
                    VoiceAgentsList.builder()
                        .addAgent(
                            VoiceAgent.builder()
                                .id("id")
                                .audio(VoiceAgentAudio.builder().sampleRate(0).build())
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .fallback(
                                    VoiceAgentParty.builder().kind("kind").value("value").build()
                                )
                                .greeting("greeting")
                                .limits(
                                    VoiceAgentLimits.builder()
                                        .addAllowedCountry("string")
                                        .maxCallSeconds(0)
                                        .maxConcurrentCalls(0)
                                        .build()
                                )
                                .name("name")
                                .sessionType("session_type")
                                .signingSecret("signing_secret")
                                .speech(
                                    VoiceAgentSpeech.builder()
                                        .language("language")
                                        .setting("setting")
                                        .voice("voice")
                                        .build()
                                )
                                .addTool("string")
                                .transcripts(
                                    VoiceAgentTranscripts.builder()
                                        .retentionDays(0)
                                        .store(true)
                                        .build()
                                )
                                .addTransferTarget(
                                    VoiceAgentParty.builder().kind("kind").value("value").build()
                                )
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .websocketUrl("websocket_url")
                                .build()
                        )
                        .pagination(
                            PaginationMeta.builder()
                                .cursors(
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
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

        val roundtrippedApiResponseOfVoiceAgentsList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(apiResponseOfVoiceAgentsList),
                jacksonTypeRef<ApiResponseOfVoiceAgentsList>(),
            )

        assertThat(roundtrippedApiResponseOfVoiceAgentsList).isEqualTo(apiResponseOfVoiceAgentsList)
    }
}
