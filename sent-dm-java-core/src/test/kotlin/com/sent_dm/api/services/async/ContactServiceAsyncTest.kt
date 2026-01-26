// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.services.async

import com.sent_dm.api.TestServerExtension
import com.sent_dm.api.client.okhttp.SentDmOkHttpClientAsync
import com.sent_dm.api.models.contacts.ContactListParams
import com.sent_dm.api.models.contacts.ContactRetrieveByPhoneParams
import com.sent_dm.api.models.contacts.ContactRetrieveIdParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContactServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val contactServiceAsync = client.contacts()

        val contactsFuture =
            contactServiceAsync.list(ContactListParams.builder().page(0).pageSize(0).build())

        val contacts = contactsFuture.get()
        contacts.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveByPhone() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val contactServiceAsync = client.contacts()

        val contactListItemFuture =
            contactServiceAsync.retrieveByPhone(
                ContactRetrieveByPhoneParams.builder().phoneNumber("phoneNumber").build()
            )

        val contactListItem = contactListItemFuture.get()
        contactListItem.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveId() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .adminAuthScheme("My Admin Auth Scheme")
                .customerAuthScheme("My Customer Auth Scheme")
                .build()
        val contactServiceAsync = client.contacts()

        val contactListItemFuture =
            contactServiceAsync.retrieveId(ContactRetrieveIdParams.builder().id("id").build())

        val contactListItem = contactListItemFuture.get()
        contactListItem.validate()
    }
}
