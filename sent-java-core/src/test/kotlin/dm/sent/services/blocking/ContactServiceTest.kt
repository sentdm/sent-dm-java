// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentOkHttpClient
import dm.sent.models.contacts.ContactCreateParams
import dm.sent.models.contacts.ContactDeleteParams
import dm.sent.models.contacts.ContactListParams
import dm.sent.models.contacts.ContactRetrieveParams
import dm.sent.models.contacts.ContactUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContactServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val apiResponseOfContact =
            contactService.create(
                ContactCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .phoneNumber("+1234567890")
                    .build()
            )

        apiResponseOfContact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val apiResponseOfContact =
            contactService.retrieve(
                ContactRetrieveParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        apiResponseOfContact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val apiResponseOfContact =
            contactService.update(
                ContactUpdateParams.builder()
                    .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                    .idempotencyKey("req_abc123_retry1")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sandbox(false)
                    .defaultChannel("whatsapp")
                    .optOut(false)
                    .build()
            )

        apiResponseOfContact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        val contacts =
            contactService.list(
                ContactListParams.builder()
                    .page(0)
                    .pageSize(0)
                    .channel("channel")
                    .phone("phone")
                    .search("search")
                    .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        contacts.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentOkHttpClient.builder().apiKey("My API Key").build()
        val contactService = client.contacts()

        contactService.delete(
            ContactDeleteParams.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .sandbox(false)
                .build()
        )
    }
}
