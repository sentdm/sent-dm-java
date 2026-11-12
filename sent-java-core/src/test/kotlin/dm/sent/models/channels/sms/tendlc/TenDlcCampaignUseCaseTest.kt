// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms.tendlc

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TenDlcCampaignUseCaseTest {

    @Test
    fun create() {
        val tenDlcCampaignUseCase =
            TenDlcCampaignUseCase.builder()
                .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                .useCase(TenDlcCampaignUseCase.UseCase.MARKETING)
                .build()

        assertThat(tenDlcCampaignUseCase.sampleMessages())
            .containsExactly(JsonValue.from(mapOf<String, Any>()))
        assertThat(tenDlcCampaignUseCase.useCase())
            .isEqualTo(TenDlcCampaignUseCase.UseCase.MARKETING)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val tenDlcCampaignUseCase =
            TenDlcCampaignUseCase.builder()
                .addSampleMessage(JsonValue.from(mapOf<String, Any>()))
                .useCase(TenDlcCampaignUseCase.UseCase.MARKETING)
                .build()

        val roundtrippedTenDlcCampaignUseCase =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(tenDlcCampaignUseCase),
                jacksonTypeRef<TenDlcCampaignUseCase>(),
            )

        assertThat(roundtrippedTenDlcCampaignUseCase).isEqualTo(tenDlcCampaignUseCase)
    }
}
