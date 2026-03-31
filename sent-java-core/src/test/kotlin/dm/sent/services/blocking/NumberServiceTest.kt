// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.numbers.NumberLookupParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NumberServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun lookup() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val numberService = client.numbers()

        val response =
            numberService.lookup(
                NumberLookupParams.builder()
                    .phoneNumber("+12025551234")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        response.validate()
    }
}
