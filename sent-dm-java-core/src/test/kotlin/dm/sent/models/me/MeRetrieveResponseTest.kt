// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.me

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.ApiError
import dm.sent.models.webhooks.ApiMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MeRetrieveResponseTest {

    @Test
    fun create() {
        val meRetrieveResponse =
            MeRetrieveResponse.builder()
                .data(
                    MeRetrieveResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .icon("icon")
                        .name("name")
                        .addProfile(
                            MeRetrieveResponse.Data.Profile.builder()
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
                        )
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
                        .status("status")
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

        assertThat(meRetrieveResponse.data())
            .contains(
                MeRetrieveResponse.Data.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .description("description")
                    .icon("icon")
                    .name("name")
                    .addProfile(
                        MeRetrieveResponse.Data.Profile.builder()
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
                    )
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
                    .status("status")
                    .build()
            )
        assertThat(meRetrieveResponse.error())
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
        assertThat(meRetrieveResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(meRetrieveResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val meRetrieveResponse =
            MeRetrieveResponse.builder()
                .data(
                    MeRetrieveResponse.Data.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .description("description")
                        .icon("icon")
                        .name("name")
                        .addProfile(
                            MeRetrieveResponse.Data.Profile.builder()
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
                        )
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
                        .status("status")
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

        val roundtrippedMeRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(meRetrieveResponse),
                jacksonTypeRef<MeRetrieveResponse>(),
            )

        assertThat(roundtrippedMeRetrieveResponse).isEqualTo(meRetrieveResponse)
    }
}
