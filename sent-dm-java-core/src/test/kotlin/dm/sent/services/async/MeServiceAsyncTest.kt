// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MeServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val meServiceAsync = client.me()

        val meFuture = meServiceAsync.retrieve()

        val me = meFuture.get()
        me.validate()
    }
}
