// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiMeta
import dm.sent.models.webhooks.ErrorDetail
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageRetrieveActivitiesResponseTest {

    @Test
    fun create() {
        val messageRetrieveActivitiesResponse =
            MessageRetrieveActivitiesResponse.builder()
                .data(
                    MessageRetrieveActivitiesResponse.Data.builder()
                        .addActivity(
                            MessageRetrieveActivitiesResponse.Data.Activity.builder()
                                .activeContactPrice("active_contact_price")
                                .description("description")
                                .price("price")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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

        assertThat(messageRetrieveActivitiesResponse.data())
            .contains(
                MessageRetrieveActivitiesResponse.Data.builder()
                    .addActivity(
                        MessageRetrieveActivitiesResponse.Data.Activity.builder()
                            .activeContactPrice("active_contact_price")
                            .description("description")
                            .price("price")
                            .status("status")
                            .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        assertThat(messageRetrieveActivitiesResponse.error())
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
        assertThat(messageRetrieveActivitiesResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(messageRetrieveActivitiesResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageRetrieveActivitiesResponse =
            MessageRetrieveActivitiesResponse.builder()
                .data(
                    MessageRetrieveActivitiesResponse.Data.builder()
                        .addActivity(
                            MessageRetrieveActivitiesResponse.Data.Activity.builder()
                                .activeContactPrice("active_contact_price")
                                .description("description")
                                .price("price")
                                .status("status")
                                .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .messageId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
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

        val roundtrippedMessageRetrieveActivitiesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageRetrieveActivitiesResponse),
                jacksonTypeRef<MessageRetrieveActivitiesResponse>(),
            )

        assertThat(roundtrippedMessageRetrieveActivitiesResponse)
            .isEqualTo(messageRetrieveActivitiesResponse)
    }
}
