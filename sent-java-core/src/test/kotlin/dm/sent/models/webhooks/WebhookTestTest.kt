// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WebhookTestTest {

    @Test
    fun create() {
        val webhookTest = WebhookTest.builder().message("message").success(true).build()

        assertThat(webhookTest.message()).contains("message")
        assertThat(webhookTest.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val webhookTest = WebhookTest.builder().message("message").success(true).build()

        val roundtrippedWebhookTest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(webhookTest),
                jacksonTypeRef<WebhookTest>(),
            )

        assertThat(roundtrippedWebhookTest).isEqualTo(webhookTest)
    }
}
