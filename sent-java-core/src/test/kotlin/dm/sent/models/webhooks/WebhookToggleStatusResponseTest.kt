// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookToggleStatusResponseTest {

    @Test
    fun create() {
        val webhookToggleStatusResponse =
            WebhookToggleStatusResponse.builder()
                .data(
                    WebhookToggleStatusResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .eventFilters(
                            WebhookToggleStatusResponse.Data.EventFilters.builder()
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
                    WebhookToggleStatusResponse.Error.builder()
                        .code("code")
                        .details(
                            WebhookToggleStatusResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    WebhookToggleStatusResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(webhookToggleStatusResponse.data())
            .contains(
                WebhookToggleStatusResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .consecutiveFailures(0)
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .displayName("display_name")
                    .endpointUrl("endpoint_url")
                    .eventFilters(
                        WebhookToggleStatusResponse.Data.EventFilters.builder()
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
        assertThat(webhookToggleStatusResponse.error())
            .contains(
                WebhookToggleStatusResponse.Error.builder()
                    .code("code")
                    .details(
                        WebhookToggleStatusResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(webhookToggleStatusResponse.meta())
            .contains(
                WebhookToggleStatusResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(webhookToggleStatusResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookToggleStatusResponse =
            WebhookToggleStatusResponse.builder()
                .data(
                    WebhookToggleStatusResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .consecutiveFailures(0)
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .displayName("display_name")
                        .endpointUrl("endpoint_url")
                        .eventFilters(
                            WebhookToggleStatusResponse.Data.EventFilters.builder()
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
                    WebhookToggleStatusResponse.Error.builder()
                        .code("code")
                        .details(
                            WebhookToggleStatusResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    WebhookToggleStatusResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedWebhookToggleStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookToggleStatusResponse),
                jacksonTypeRef<WebhookToggleStatusResponse>(),
            )

        assertThat(roundtrippedWebhookToggleStatusResponse).isEqualTo(webhookToggleStatusResponse)
    }
}
