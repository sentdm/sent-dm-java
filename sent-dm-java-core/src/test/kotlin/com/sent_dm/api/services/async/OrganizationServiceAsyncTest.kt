// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClientAsync
import com.sent_dm.api.models.organizations.OrganizationRetrieveProfilesParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrganizationServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val organizationServiceAsync = client.organizations()

        val organizationsFuture = organizationServiceAsync.list()

        val organizations = organizationsFuture.get()
        organizations.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveProfiles() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val organizationServiceAsync = client.organizations()

        val responseFuture =
            organizationServiceAsync.retrieveProfiles(
                OrganizationRetrieveProfilesParams.builder()
                    .orgId("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
