// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.contacts.ContactCreateParams
import dm.sent.models.contacts.ContactDeleteParams
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContactServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contactServiceAsync = client.contacts()

        val apiResponseContactFuture =
            contactServiceAsync.create(
                ContactCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .phoneNumber("+1234567890")
                    .build()
            )

        val apiResponseContact = apiResponseContactFuture.get()
        apiResponseContact.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contactServiceAsync = client.contacts()

        val apiResponseContactFuture =
            contactServiceAsync.retrieve("6ba7b810-9dad-11d1-80b4-00c04fd430c8")

        val apiResponseContact = apiResponseContactFuture.get()
        apiResponseContact.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contactServiceAsync = client.contacts()

        val apiResponseContactFuture =
            contactServiceAsync.update(
                ContactUpdateParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .defaultChannel("whatsapp")
                    .optOut(false)
                    .build()
            )

        val apiResponseContact = apiResponseContactFuture.get()
        apiResponseContact.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contactServiceAsync = client.contacts()

        val contactsFuture =
            contactServiceAsync.list(
                ContactListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .channel("channel")
                    .phone("phone")
                    .search("search")
                    .build()
            )

        val contacts = contactsFuture.get()
        contacts.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            SentDmOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val contactServiceAsync = client.contacts()

        val future =
            contactServiceAsync.delete(
                ContactDeleteParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .testMode(false)
                    .build()
            )

        val response = future.get()
    }
}
