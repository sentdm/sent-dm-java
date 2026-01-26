// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.blocking

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClient
import com.sent_dm.api.models.contacts.ContactListParams
import com.sent_dm.api.models.contacts.ContactRetrieveByPhoneParams
import com.sent_dm.api.models.contacts.ContactRetrieveIdParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContactServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val contactService = client.contacts()

        val contacts =
            contactService.list(
                ContactListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .build()
            )

        contacts.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveByPhone() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val contactService = client.contacts()

        val contactListItem =
            contactService.retrieveByPhone(
                ContactRetrieveByPhoneParams.builder()
                    .phoneNumber("phoneNumber")
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .build()
            )

        contactListItem.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveId() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val contactService = client.contacts()

        val contactListItem =
            contactService.retrieveId(
                ContactRetrieveIdParams.builder()
                    .id("id")
                    .xApiKey("")
                    .xSenderId("00000000-0000-0000-0000-000000000000")
                    .build()
            )

        contactListItem.validate()
    }
}
