// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileListResponseTest {

    @Test
    fun create() {
        val profileListResponse =
            ProfileListResponse.builder()
                .data(
                    ProfileListResponse.Data.builder()
                        .addProfile(
                            ProfileDetail.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .email("email")
                                .icon("icon")
                                .name("name")
                                .organizationId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .settings(
                                    ProfileDetail.Settings.builder()
                                        .allowContactSharing(true)
                                        .allowNumberChangeDuringOnboarding(true)
                                        .allowTemplateSharing(true)
                                        .billingModel("billing_model")
                                        .inheritContacts(true)
                                        .inheritTcrBrand(true)
                                        .inheritTcrCampaign(true)
                                        .inheritTemplates(true)
                                        .sendingPhoneNumber("sending_phone_number")
                                        .sendingPhoneNumberProfileId(
                                            "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                        )
                                        .sendingWhatsappNumberProfileId(
                                            "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                        )
                                        .whatsappPhoneNumber("whatsapp_phone_number")
                                        .build()
                                )
                                .shortName("short_name")
                                .status("status")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(profileListResponse.data())
            .contains(
                ProfileListResponse.Data.builder()
                    .addProfile(
                        ProfileDetail.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .description("description")
                            .email("email")
                            .icon("icon")
                            .name("name")
                            .organizationId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .settings(
                                ProfileDetail.Settings.builder()
                                    .allowContactSharing(true)
                                    .allowNumberChangeDuringOnboarding(true)
                                    .allowTemplateSharing(true)
                                    .billingModel("billing_model")
                                    .inheritContacts(true)
                                    .inheritTcrBrand(true)
                                    .inheritTcrCampaign(true)
                                    .inheritTemplates(true)
                                    .sendingPhoneNumber("sending_phone_number")
                                    .sendingPhoneNumberProfileId(
                                        "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                    )
                                    .sendingWhatsappNumberProfileId(
                                        "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                    )
                                    .whatsappPhoneNumber("whatsapp_phone_number")
                                    .build()
                            )
                            .shortName("short_name")
                            .status("status")
                            .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                    .build()
            )
        assertThat(profileListResponse.error())
            .contains(
                ApiError.builder()
                    .code("code")
                    .details(
                        ApiError.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(profileListResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(profileListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileListResponse =
            ProfileListResponse.builder()
                .data(
                    ProfileListResponse.Data.builder()
                        .addProfile(
                            ProfileDetail.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .description("description")
                                .email("email")
                                .icon("icon")
                                .name("name")
                                .organizationId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .settings(
                                    ProfileDetail.Settings.builder()
                                        .allowContactSharing(true)
                                        .allowNumberChangeDuringOnboarding(true)
                                        .allowTemplateSharing(true)
                                        .billingModel("billing_model")
                                        .inheritContacts(true)
                                        .inheritTcrBrand(true)
                                        .inheritTcrCampaign(true)
                                        .inheritTemplates(true)
                                        .sendingPhoneNumber("sending_phone_number")
                                        .sendingPhoneNumberProfileId(
                                            "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                        )
                                        .sendingWhatsappNumberProfileId(
                                            "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"
                                        )
                                        .whatsappPhoneNumber("whatsapp_phone_number")
                                        .build()
                                )
                                .shortName("short_name")
                                .status("status")
                                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                                .build()
                        )
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedProfileListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileListResponse),
                jacksonTypeRef<ProfileListResponse>(),
            )

        assertThat(roundtrippedProfileListResponse).isEqualTo(profileListResponse)
    }
}
