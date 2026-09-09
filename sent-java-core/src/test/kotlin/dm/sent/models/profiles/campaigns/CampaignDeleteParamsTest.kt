// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles.campaigns

import dm.sent.core.http.Headers
import dm.sent.models.webhooks.MutationRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignDeleteParamsTest {

    @Test
    fun create() {
        CampaignDeleteParams.builder()
            .profileId("770e8400-e29b-41d4-a716-446655440002")
            .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
            .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .mutationRequest(MutationRequest.builder().sandbox(false).build())
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            CampaignDeleteParams.builder()
                .profileId("770e8400-e29b-41d4-a716-446655440002")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        assertThat(params._pathParam(0)).isEqualTo("770e8400-e29b-41d4-a716-446655440002")
        assertThat(params._pathParam(1)).isEqualTo("b2c3d4e5-f6a7-8901-bcde-f12345678901")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun headers() {
        val params =
            CampaignDeleteParams.builder()
                .profileId("770e8400-e29b-41d4-a716-446655440002")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(
                Headers.builder()
                    .put("x-profile-id", "182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params =
            CampaignDeleteParams.builder()
                .profileId("770e8400-e29b-41d4-a716-446655440002")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        val headers = params._headers()

        assertThat(headers).isEqualTo(Headers.builder().build())
    }

    @Test
    fun body() {
        val params =
            CampaignDeleteParams.builder()
                .profileId("770e8400-e29b-41d4-a716-446655440002")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .xProfileId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .mutationRequest(MutationRequest.builder().sandbox(false).build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(MutationRequest.builder().sandbox(false).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CampaignDeleteParams.builder()
                .profileId("770e8400-e29b-41d4-a716-446655440002")
                .campaignId("b2c3d4e5-f6a7-8901-bcde-f12345678901")
                .mutationRequest(MutationRequest.builder().build())
                .build()

        val body = params._body()

        assertThat(body).isEqualTo(MutationRequest.builder().build())
    }
}
