// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactRetrieveByPhoneParams
import dm.sent.models.contacts.ContactRetrieveIdParams
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
                .apiKey("My API Key")
                .senderId("My Sender ID")
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
                .apiKey("My API Key")
                .senderId("My Sender ID")
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
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val contactServiceAsync = client.contacts()

        val contactListItemFuture =
            contactServiceAsync.retrieveId(
                ContactRetrieveIdParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        val contactListItem = contactListItemFuture.get()
        contactListItem.validate()
    }
}
