// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.contacts.ContactCreateParams
import dm.sent.models.contacts.ContactDeleteParams
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactRetrieveParams
import dm.sent.models.contacts.ContactUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContactServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val apiResponseOfContactFuture =
            contactServiceAsync.create(
                ContactCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .phoneNumber("+1234567890")
                    .build()
            )

        val apiResponseOfContact = apiResponseOfContactFuture.get()
        apiResponseOfContact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val apiResponseOfContactFuture =
            contactServiceAsync.retrieve(
                ContactRetrieveParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val apiResponseOfContact = apiResponseOfContactFuture.get()
        apiResponseOfContact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val apiResponseOfContactFuture =
            contactServiceAsync.update(
                ContactUpdateParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .defaultChannel("whatsapp")
                    .optOut(false)
                    .build()
            )

        val apiResponseOfContact = apiResponseOfContactFuture.get()
        apiResponseOfContact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val contactsFuture =
            contactServiceAsync.list(
                ContactListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .channel("channel")
                    .phone("phone")
                    .search("search")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        val contacts = contactsFuture.get()
        contacts.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val future =
            contactServiceAsync.delete(
                ContactDeleteParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .build()
            )

        val response = future.get()
    }
}
