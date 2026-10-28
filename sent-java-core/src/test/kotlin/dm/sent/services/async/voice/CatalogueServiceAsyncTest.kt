// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async.voice

import dm.sent.client.okhttp.SentOkHttpClientAsync
import dm.sent.models.voice.catalogue.CatalogueListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CatalogueServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClientAsync.builder().apiKey("My API Key").build()
        val catalogueServiceAsync = client.voice().catalogue()

        val apiResponseOfVoiceCatalogueFuture =
            catalogueServiceAsync.list(
                CatalogueListParams.builder()
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfVoiceCatalogue = apiResponseOfVoiceCatalogueFuture.get()
        apiResponseOfVoiceCatalogue.validate()
    }
}
