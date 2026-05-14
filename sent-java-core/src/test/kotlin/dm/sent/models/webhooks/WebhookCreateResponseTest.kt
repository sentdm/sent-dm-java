// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookCreateResponseTest {

    @Test
    fun create() {
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .data(
                    WebhookCreateResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .eventFilters(
                            WebhookCreateResponse.Data.EventFilters.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .addEventType("string")
                        .isActive(true)
                        .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .retryCount(0)
                        .signingSecret("signing_secret")
                        .timeoutSeconds(0)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
                    WebhookCreateResponse.Error.builder()
                        .code("code")
                        .details(
                            WebhookCreateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    WebhookCreateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(webhookCreateResponse.data())
            .contains(
                WebhookCreateResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .consecutiveFailures(0)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .displayName("display_name")
                    .endpointUrl("endpoint_url")
                    .eventFilters(
                        WebhookCreateResponse.Data.EventFilters.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .addEventType("string")
                    .isActive(true)
                    .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .retryCount(0)
                    .signingSecret("signing_secret")
                    .timeoutSeconds(0)
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(webhookCreateResponse.error())
            .contains(
                WebhookCreateResponse.Error.builder()
                    .code("code")
                    .details(
                        WebhookCreateResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(webhookCreateResponse.meta())
            .contains(
                WebhookCreateResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(webhookCreateResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookCreateResponse =
            WebhookCreateResponse.builder()
                .data(
                    WebhookCreateResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .eventFilters(
                            WebhookCreateResponse.Data.EventFilters.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .addEventType("string")
                        .isActive(true)
                        .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .retryCount(0)
                        .signingSecret("signing_secret")
                        .timeoutSeconds(0)
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .error(
                    WebhookCreateResponse.Error.builder()
                        .code("code")
                        .details(
                            WebhookCreateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    WebhookCreateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedWebhookCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookCreateResponse),
                jacksonTypeRef<WebhookCreateResponse>(),
            )

        assertThat(roundtrippedWebhookCreateResponse).isEqualTo(webhookCreateResponse)
    }
}
