// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.conversations.ConversationListMessagesParams
import dm.sent.models.conversations.ConversationListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ConversationServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val conversationsFuture =
            conversationServiceAsync.list(
                ConversationListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val conversations = conversationsFuture.get()
        conversations.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listMessages() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val responseFuture =
            conversationServiceAsync.listMessages(
                ConversationListMessagesParams.builder()
                    .id("08fab313-c9e2-502c-975e-08b0356c432e")
                    .page(0)
                    .pageSize(0)
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
