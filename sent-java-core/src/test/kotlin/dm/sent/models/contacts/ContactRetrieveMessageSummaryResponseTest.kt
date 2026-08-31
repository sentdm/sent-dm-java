// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactRetrieveMessageSummaryResponseTest {

    @Test
    fun create() {
        val contactRetrieveMessageSummaryResponse =
            ContactRetrieveMessageSummaryResponse.builder()
                .data(
                    ContactRetrieveMessageSummaryResponse.Data.builder()
                        .addChannelScore(
                            ContactRetrieveMessageSummaryResponse.Data.ChannelScore.builder()
                                .channel("channel")
                                .failScore(0)
                                .successScore(0)
                                .build()
                        )
                        .addChannelsUsed("string")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .messageCount(0)
                        .build()
                )
                .error(
                    ContactRetrieveMessageSummaryResponse.Error.builder()
                        .code("code")
                        .details(
                            ContactRetrieveMessageSummaryResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ContactRetrieveMessageSummaryResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(contactRetrieveMessageSummaryResponse.data())
            .contains(
                ContactRetrieveMessageSummaryResponse.Data.builder()
                    .addChannelScore(
                        ContactRetrieveMessageSummaryResponse.Data.ChannelScore.builder()
                            .channel("channel")
                            .failScore(0)
                            .successScore(0)
                            .build()
                    )
                    .addChannelsUsed("string")
                    .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .messageCount(0)
                    .build()
            )
        assertThat(contactRetrieveMessageSummaryResponse.error())
            .contains(
                ContactRetrieveMessageSummaryResponse.Error.builder()
                    .code("code")
                    .details(
                        ContactRetrieveMessageSummaryResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(contactRetrieveMessageSummaryResponse.meta())
            .contains(
                ContactRetrieveMessageSummaryResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(contactRetrieveMessageSummaryResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactRetrieveMessageSummaryResponse =
            ContactRetrieveMessageSummaryResponse.builder()
                .data(
                    ContactRetrieveMessageSummaryResponse.Data.builder()
                        .addChannelScore(
                            ContactRetrieveMessageSummaryResponse.Data.ChannelScore.builder()
                                .channel("channel")
                                .failScore(0)
                                .successScore(0)
                                .build()
                        )
                        .addChannelsUsed("string")
                        .contactId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .firstMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastMessageAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .messageCount(0)
                        .build()
                )
                .error(
                    ContactRetrieveMessageSummaryResponse.Error.builder()
                        .code("code")
                        .details(
                            ContactRetrieveMessageSummaryResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ContactRetrieveMessageSummaryResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedContactRetrieveMessageSummaryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactRetrieveMessageSummaryResponse),
                jacksonTypeRef<ContactRetrieveMessageSummaryResponse>(),
            )

        assertThat(roundtrippedContactRetrieveMessageSummaryResponse)
            .isEqualTo(contactRetrieveMessageSummaryResponse)
    }
}
