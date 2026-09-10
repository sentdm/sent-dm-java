// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ConversationServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val pageFuture = conversationServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listMessages() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val pageFuture =
            conversationServiceAsync.listMessages("08fab313-c9e2-502c-975e-08b0356c432e")

        val page = pageFuture.get()
        page.response().validate()
    }
}
