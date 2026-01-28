// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.TestServerExtension
import dm.sent.client.okhttp.SentDmOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class OrganizationServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun list() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val organizationService = client.organizations()

        val organizations = organizationService.list()

        organizations.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieveProfiles() {
        val client =
            SentDmOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .senderId("My Sender ID")
                .build()
        val organizationService = client.organizations()

        val response = organizationService.retrieveProfiles("6ba7b810-9dad-11d1-80b4-00c04fd430c8")

        response.validate()
    }
}
