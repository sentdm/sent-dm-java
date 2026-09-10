// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ConversationServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val conversationService = client.conversations()

        val page =
            conversationService.list(ConversationListParams.builder().page(0).pageSize(0).build())

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listMessages() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val conversationService = client.conversations()

        val page =
            conversationService.listMessages(
                ConversationListMessagesParams.builder()
                    .id("08fab313-c9e2-502c-975e-08b0356c432e")
                    .page(0)
                    .pageSize(0)
                    .build()
            )

        page.response().validate()
    }
}
