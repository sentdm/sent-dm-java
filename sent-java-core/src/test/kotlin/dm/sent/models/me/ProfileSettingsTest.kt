// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileSettingsTest {

    @Test
    fun create() {
        val profileSettings =
            ProfileSettings.builder()
                .allowContactSharing(true)
                .allowTemplateSharing(true)
                .billingModel("billing_model")
                .inheritContacts(true)
                .inheritTcrBrand(true)
                .inheritTcrCampaign(true)
                .inheritTemplates(true)
                .build()

        assertThat(profileSettings.allowContactSharing()).contains(true)
        assertThat(profileSettings.allowTemplateSharing()).contains(true)
        assertThat(profileSettings.billingModel()).contains("billing_model")
        assertThat(profileSettings.inheritContacts()).contains(true)
        assertThat(profileSettings.inheritTcrBrand()).contains(true)
        assertThat(profileSettings.inheritTcrCampaign()).contains(true)
        assertThat(profileSettings.inheritTemplates()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileSettings =
            ProfileSettings.builder()
                .allowContactSharing(true)
                .allowTemplateSharing(true)
                .billingModel("billing_model")
                .inheritContacts(true)
                .inheritTcrBrand(true)
                .inheritTcrCampaign(true)
                .inheritTemplates(true)
                .build()

        val roundtrippedProfileSettings =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileSettings),
                jacksonTypeRef<ProfileSettings>(),
            )

        assertThat(roundtrippedProfileSettings).isEqualTo(profileSettings)
    }
}
