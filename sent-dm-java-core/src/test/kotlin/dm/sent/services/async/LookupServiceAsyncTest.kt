// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class LookupServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrievePhoneInfo() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val lookupServiceAsync = client.lookup()

        val responseFuture = lookupServiceAsync.retrievePhoneInfo("phoneNumber")

        val response = responseFuture.get()
        response.validate()
    }
}
