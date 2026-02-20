// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentDmOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LookupServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrievePhoneInfo() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val lookupService = client.lookup()

        val response = lookupService.retrievePhoneInfo("phoneNumber")

        response.validate()
    }
}
