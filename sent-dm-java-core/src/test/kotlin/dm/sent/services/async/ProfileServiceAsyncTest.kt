// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.async

import dm.sent.client.okhttp.SentDmOkHttpClientAsync
import dm.sent.models.profiles.ProfileCompleteParams
import dm.sent.models.profiles.ProfileCreateParams
import dm.sent.models.profiles.ProfileDeleteParams
import dm.sent.models.profiles.ProfileUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProfileServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val apiResponseOfProfileDetailFuture =
            profileServiceAsync.create(
                ProfileCreateParams.builder()
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .allowContactSharing(true)
                    .allowTemplateSharing(false)
                    .billingModel("profile")
                    .description("Sales department sender profile")
                    .icon("https://example.com/sales-icon.png")
                    .inheritContacts(true)
                    .inheritTcrBrand(true)
                    .inheritTcrCampaign(true)
                    .inheritTemplates(true)
                    .name("Sales Team")
                    .shortName("SALES")
                    .build()
            )

        val apiResponseOfProfileDetail = apiResponseOfProfileDetailFuture.get()
        apiResponseOfProfileDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val apiResponseOfProfileDetailFuture =
            profileServiceAsync.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        val apiResponseOfProfileDetail = apiResponseOfProfileDetailFuture.get()
        apiResponseOfProfileDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val apiResponseOfProfileDetailFuture =
            profileServiceAsync.update(
                ProfileUpdateParams.builder()
                    .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .allowContactSharing(true)
                    .allowNumberChangeDuringOnboarding(null)
                    .allowTemplateSharing(null)
                    .billingModel("organization")
                    .description("Updated sales department sender profile")
                    .icon(null)
                    .inheritContacts(null)
                    .inheritTcrBrand(null)
                    .inheritTcrCampaign(null)
                    .inheritTemplates(null)
                    .name("Sales Team - Updated")
                    .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
                    .sendingPhoneNumber(null)
                    .sendingPhoneNumberProfileId(null)
                    .sendingWhatsappNumberProfileId(null)
                    .shortName(null)
                    .whatsappPhoneNumber(null)
                    .build()
            )

        val apiResponseOfProfileDetail = apiResponseOfProfileDetailFuture.get()
        apiResponseOfProfileDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val profilesFuture = profileServiceAsync.list()

        val profiles = profilesFuture.get()
        profiles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val future =
            profileServiceAsync.delete(
                ProfileDeleteParams.builder()
                    .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .testMode(false)
                    .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
                    .build()
            )

        val response = future.get()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun complete() {
        val client = SentDmOkHttpClientAsync.builder().apiKey("My API Key").build()
        val profileServiceAsync = client.profiles()

        val responseFuture =
            profileServiceAsync.complete(
                ProfileCompleteParams.builder()
                    .profileId("660e8400-e29b-41d4-a716-446655440000")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .webHookUrl("https://your-app.com/webhook/profile-complete")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
