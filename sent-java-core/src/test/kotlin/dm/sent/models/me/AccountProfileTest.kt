// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccountProfileTest {

    @Test
    fun create() {
        val accountProfile =
            AccountProfile.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .icon("icon")
                .name("name")
                .role("role")
                .settings(
                    ProfileSettings.builder()
                        .allowContactSharing(true)
                        .allowTemplateSharing(true)
                        .billingModel("billing_model")
                        .inheritContacts(true)
                        .inheritTcrBrand(true)
                        .inheritTcrCampaign(true)
                        .inheritTemplates(true)
                        .build()
                )
                .shortName("short_name")
                .status("status")
                .build()

        assertThat(accountProfile.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(accountProfile.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(accountProfile.description()).contains("description")
        assertThat(accountProfile.icon()).contains("icon")
        assertThat(accountProfile.name()).contains("name")
        assertThat(accountProfile.role()).contains("role")
        assertThat(accountProfile.settings())
            .contains(
                ProfileSettings.builder()
                    .allowContactSharing(true)
                    .allowTemplateSharing(true)
                    .billingModel("billing_model")
                    .inheritContacts(true)
                    .inheritTcrBrand(true)
                    .inheritTcrCampaign(true)
                    .inheritTemplates(true)
                    .build()
            )
        assertThat(accountProfile.shortName()).contains("short_name")
        assertThat(accountProfile.status()).contains("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accountProfile =
            AccountProfile.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .icon("icon")
                .name("name")
                .role("role")
                .settings(
                    ProfileSettings.builder()
                        .allowContactSharing(true)
                        .allowTemplateSharing(true)
                        .billingModel("billing_model")
                        .inheritContacts(true)
                        .inheritTcrBrand(true)
                        .inheritTcrCampaign(true)
                        .inheritTemplates(true)
                        .build()
                )
                .shortName("short_name")
                .status("status")
                .build()

        val roundtrippedAccountProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accountProfile),
                jacksonTypeRef<AccountProfile>(),
            )

        assertThat(roundtrippedAccountProfile).isEqualTo(accountProfile)
    }
}
