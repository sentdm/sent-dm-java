// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClientAsync
import com.sent_dm.api.models.numberlookup.NumberLookupRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class NumberLookupServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val numberLookupServiceAsync = client.numberLookup()

        val numberLookupFuture =
            numberLookupServiceAsync.retrieve(
                NumberLookupRetrieveParams.builder()
                    .phoneNumber("phoneNumber")
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .build()
            )

        val numberLookup = numberLookupFuture.get()
        numberLookup.validate()
    }
}
