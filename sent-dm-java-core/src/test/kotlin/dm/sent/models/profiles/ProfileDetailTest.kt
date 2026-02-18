// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileDetailTest {

    @Test
    fun create() {
        val profileDetail =
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
                        .sendingPhoneNumberProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .sendingWhatsappNumberProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .whatsappPhoneNumber("whatsapp_phone_number")
                        .build()
                )
                .shortName("short_name")
                .status("status")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(profileDetail.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(profileDetail.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(profileDetail.description()).contains("description")
        assertThat(profileDetail.email()).contains("email")
        assertThat(profileDetail.icon()).contains("icon")
        assertThat(profileDetail.name()).contains("name")
        assertThat(profileDetail.organizationId()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(profileDetail.settings())
            .contains(
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
                    .sendingPhoneNumberProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .sendingWhatsappNumberProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .whatsappPhoneNumber("whatsapp_phone_number")
                    .build()
            )
        assertThat(profileDetail.shortName()).contains("short_name")
        assertThat(profileDetail.status()).contains("status")
        assertThat(profileDetail.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileDetail =
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
                        .sendingPhoneNumberProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .sendingWhatsappNumberProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .whatsappPhoneNumber("whatsapp_phone_number")
                        .build()
                )
                .shortName("short_name")
                .status("status")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedProfileDetail =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileDetail),
                jacksonTypeRef<ProfileDetail>(),
            )

        assertThat(roundtrippedProfileDetail).isEqualTo(profileDetail)
    }
}
