// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
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
                .displayName("display_name")
                .endpointUrl("endpoint_url")
                .addEventType("string")
                .isActive(true)
                .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .retryCount(0)
                .signingSecret("signing_secret")
                .timeoutSeconds(0)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(webhookResponse.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(webhookResponse.consecutiveFailures()).contains(0)
        assertThat(webhookResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.displayName()).contains("display_name")
        assertThat(webhookResponse.endpointUrl()).contains("endpoint_url")
        assertThat(webhookResponse.eventTypes().getOrNull()).containsExactly("string")
        assertThat(webhookResponse.isActive()).contains(true)
        assertThat(webhookResponse.lastDeliveryAttemptAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.lastSuccessfulDeliveryAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(webhookResponse.retryCount()).contains(0)
        assertThat(webhookResponse.signingSecret()).contains("signing_secret")
        assertThat(webhookResponse.timeoutSeconds()).contains(0)
        assertThat(webhookResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookResponse =
            WebhookResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .consecutiveFailures(0)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .displayName("display_name")
                .endpointUrl("endpoint_url")
                .addEventType("string")
                .isActive(true)
                .lastDeliveryAttemptAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .lastSuccessfulDeliveryAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .retryCount(0)
                .signingSecret("signing_secret")
                .timeoutSeconds(0)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedWebhookResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookResponse),
                jacksonTypeRef<WebhookResponse>(),
            )

        assertThat(roundtrippedWebhookResponse).isEqualTo(webhookResponse)
    }
}
