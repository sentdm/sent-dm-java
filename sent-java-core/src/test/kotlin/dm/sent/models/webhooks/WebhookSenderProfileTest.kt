// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookSenderProfileTest {

    @Test
    fun create() {
        val webhookSenderProfile =
            WebhookSenderProfile.builder()
                .eventFilters(
                    WebhookSenderProfile.EventFilters.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .addEventType("string")
                .build()

        assertThat(webhookSenderProfile.eventFilters())
            .contains(
                WebhookSenderProfile.EventFilters.builder()
                    .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                    .build()
            )
        assertThat(webhookSenderProfile.eventTypes().getOrNull()).containsExactly("string")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookSenderProfile =
            WebhookSenderProfile.builder()
                .eventFilters(
                    WebhookSenderProfile.EventFilters.builder()
                        .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                        .build()
                )
                .addEventType("string")
                .build()

        val roundtrippedWebhookSenderProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookSenderProfile),
                jacksonTypeRef<WebhookSenderProfile>(),
            )

        assertThat(roundtrippedWebhookSenderProfile).isEqualTo(webhookSenderProfile)
    }
}
