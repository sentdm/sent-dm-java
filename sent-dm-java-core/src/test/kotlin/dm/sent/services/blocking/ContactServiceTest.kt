// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactRetrieveByPhoneParams
import dm.sent.models.contacts.ContactRetrieveIdParams
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

        val contacts = contactService.list(ContactListParams.builder().page(0).pageSize(0).build())

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
                ContactRetrieveByPhoneParams.builder().phoneNumber("phoneNumber").build()
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
                ContactRetrieveIdParams.builder().id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        contactListItem.validate()
    }
}
