// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookSecretTest {

    @Test
    fun create() {
        val webhookSecret = WebhookSecret.builder().signingSecret("signing_secret").build()

        assertThat(webhookSecret.signingSecret()).contains("signing_secret")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookSecret = WebhookSecret.builder().signingSecret("signing_secret").build()

        val roundtrippedWebhookSecret =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookSecret),
                jacksonTypeRef<WebhookSecret>(),
            )

        assertThat(roundtrippedWebhookSecret).isEqualTo(webhookSecret)
    }
}
