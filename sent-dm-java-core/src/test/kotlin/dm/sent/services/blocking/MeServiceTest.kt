// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MeServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val meService = client.me()

        val me = meService.retrieve()

        me.validate()
    }
}
