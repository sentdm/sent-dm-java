// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookResponseTest {

    @Test
    fun create() {
        val webhookResponse =
            WebhookResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .consecutiveFailures(0)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .displayName("display_name")
                .endpointUrl("endpoint_url")
                .eventFilters(
                    WebhookResponse.EventFilters.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .addEventType("string")
                .isActive(true)
                .isInheritable(true)
                .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .retryCount(0)
                .senderProfile(
                    WebhookResponse.SenderProfile.builder()
                        .eventFilters(
                            WebhookResponse.SenderProfile.EventFilters.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .addEventType("string")
                        .build()
                )
                .signingSecret("signing_secret")
                .timeoutSeconds(0)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .webhookVersion(0L)
                .build()

        assertThat(webhookResponse.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(webhookResponse.consecutiveFailures()).contains(0)
        assertThat(webhookResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.customerId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(webhookResponse.displayName()).contains("display_name")
        assertThat(webhookResponse.endpointUrl()).contains("endpoint_url")
        assertThat(webhookResponse.eventFilters())
            .contains(
                WebhookResponse.EventFilters.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                    .build()
            )
        assertThat(webhookResponse.eventTypes().getOrNull()).containsExactly("string")
        assertThat(webhookResponse.isActive()).contains(true)
        assertThat(webhookResponse.isInheritable()).contains(true)
        assertThat(webhookResponse.lastDeliveryAttemptAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.lastSuccessfulDeliveryAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.retryCount()).contains(0)
        assertThat(webhookResponse.senderProfile())
            .contains(
                WebhookResponse.SenderProfile.builder()
                    .eventFilters(
                        WebhookResponse.SenderProfile.EventFilters.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .addEventType("string")
                    .build()
            )
        assertThat(webhookResponse.signingSecret()).contains("signing_secret")
        assertThat(webhookResponse.timeoutSeconds()).contains(0)
        assertThat(webhookResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.webhookVersion()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookResponse =
            WebhookResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .consecutiveFailures(0)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .displayName("display_name")
                .endpointUrl("endpoint_url")
                .eventFilters(
                    WebhookResponse.EventFilters.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .addEventType("string")
                .isActive(true)
                .isInheritable(true)
                .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .retryCount(0)
                .senderProfile(
                    WebhookResponse.SenderProfile.builder()
                        .eventFilters(
                            WebhookResponse.SenderProfile.EventFilters.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .addEventType("string")
                        .build()
                )
                .signingSecret("signing_secret")
                .timeoutSeconds(0)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .webhookVersion(0L)
                .build()

        val roundtrippedWebhookResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookResponse),
                jacksonTypeRef<WebhookResponse>(),
            )

        assertThat(roundtrippedWebhookResponse).isEqualTo(webhookResponse)
    }
}
