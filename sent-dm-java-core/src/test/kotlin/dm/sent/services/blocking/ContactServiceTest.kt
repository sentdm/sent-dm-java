// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.models.contacts.ContactCreateParams
import dm.sent.models.contacts.ContactDeleteParams
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContactServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val apiResponseContact =
            contactService.create(
                ContactCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .phoneNumber("+1234567890")
                    .build()
            )

        apiResponseContact.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val apiResponseContact = contactService.retrieve("6ba7b810-9dad-11d1-80b4-00c04fd430c8")

        apiResponseContact.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val apiResponseContact =
            contactService.update(
                ContactUpdateParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .defaultChannel("whatsapp")
                    .optOut(false)
                    .build()
            )

        apiResponseContact.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val contacts =
            contactService.list(
                ContactListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .channel("channel")
                    .phone("phone")
                    .search("search")
                    .build()
            )

        contacts.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        contactService.delete(
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .testMode(false)
                .build()
        )
    }
}
