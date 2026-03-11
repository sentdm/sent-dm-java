// File generated from our OpenAPI spec by Stainless.

package dm.sent.services.blocking

import dm.sent.client.okhttp.SentDmOkHttpClient
import dm.sent.models.profiles.ProfileCompleteParams
import dm.sent.models.profiles.ProfileCreateParams
import dm.sent.models.profiles.ProfileDeleteParams
import dm.sent.models.profiles.ProfileUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ProfileServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.profiles()

        val apiResponseOfProfileDetail =
            profileService.create(
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

        apiResponseOfProfileDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.profiles()

        val apiResponseOfProfileDetail =
            profileService.retrieve("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")

        apiResponseOfProfileDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.profiles()

        val apiResponseOfProfileDetail =
            profileService.update(
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

        apiResponseOfProfileDetail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.profiles()

        val profiles = profileService.list()

        profiles.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.profiles()

        profileService.delete(
            ProfileDeleteParams.builder()
                .pathProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .testMode(false)
                .bodyProfileId("770e8400-e29b-41d4-a716-446655440002")
                .build()
        )
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun complete() {
        val client = SentDmOkHttpClient.builder().apiKey("My API Key").build()
        val profileService = client.profiles()

        val response =
            profileService.complete(
                ProfileCompleteParams.builder()
                    .profileId("660e8400-e29b-41d4-a716-446655440000")
                    .idempotencyKey("req_abc123_retry1")
                    .testMode(false)
                    .webHookUrl("https://your-app.com/webhook/profile-complete")
                    .build()
            )

        response.validate()
    }
}
