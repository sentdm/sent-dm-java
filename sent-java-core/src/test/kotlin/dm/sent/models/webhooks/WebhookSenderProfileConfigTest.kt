// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookSenderProfileConfigTest {

    @Test
    fun create() {
        val webhookSenderProfileConfig =
            WebhookSenderProfileConfig.builder()
                .eventFilters(
                    WebhookSenderProfileConfig.EventFilters.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .addEventType("string")
                .build()

        assertThat(webhookSenderProfileConfig.eventFilters())
            .contains(
                WebhookSenderProfileConfig.EventFilters.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                    .build()
            )
        assertThat(webhookSenderProfileConfig.eventTypes().getOrNull()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookSenderProfileConfig =
            WebhookSenderProfileConfig.builder()
                .eventFilters(
                    WebhookSenderProfileConfig.EventFilters.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .addEventType("string")
                .build()

        val roundtrippedWebhookSenderProfileConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookSenderProfileConfig),
                jacksonTypeRef<WebhookSenderProfileConfig>(),
            )

        assertThat(roundtrippedWebhookSenderProfileConfig).isEqualTo(webhookSenderProfileConfig)
    }
}
