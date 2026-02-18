// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands.campaigns

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignDataTest {

    @Test
    fun create() {
        val campaignData =
            CampaignData.builder()
                .description("x")
                .name("x")
                .type("x")
                .addUseCase(
                    CampaignData.UseCase.builder()
                        .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                        .addSampleMessage("string")
                        .build()
                )
                .helpKeywords("helpKeywords")
                .helpMessage("helpMessage")
                .messageFlow("messageFlow")
                .optinKeywords("optinKeywords")
                .optinMessage("optinMessage")
                .optoutKeywords("optoutKeywords")
                .optoutMessage("optoutMessage")
                .privacyPolicyLink("https://example.com")
                .termsAndConditionsLink("https://example.com")
                .build()

        assertThat(campaignData.description()).isEqualTo("x")
        assertThat(campaignData.name()).isEqualTo("x")
        assertThat(campaignData.type()).isEqualTo("x")
        assertThat(campaignData.useCases())
            .containsExactly(
                CampaignData.UseCase.builder()
                    .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                    .addSampleMessage("string")
                    .build()
            )
        assertThat(campaignData.helpKeywords()).contains("helpKeywords")
        assertThat(campaignData.helpMessage()).contains("helpMessage")
        assertThat(campaignData.messageFlow()).contains("messageFlow")
        assertThat(campaignData.optinKeywords()).contains("optinKeywords")
        assertThat(campaignData.optinMessage()).contains("optinMessage")
        assertThat(campaignData.optoutKeywords()).contains("optoutKeywords")
        assertThat(campaignData.optoutMessage()).contains("optoutMessage")
        assertThat(campaignData.privacyPolicyLink()).contains("https://example.com")
        assertThat(campaignData.termsAndConditionsLink()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val campaignData =
            CampaignData.builder()
                .description("x")
                .name("x")
                .type("x")
                .addUseCase(
                    CampaignData.UseCase.builder()
                        .messagingUseCaseUs(MessagingUseCaseUs.MARKETING)
                        .addSampleMessage("string")
                        .build()
                )
                .helpKeywords("helpKeywords")
                .helpMessage("helpMessage")
                .messageFlow("messageFlow")
                .optinKeywords("optinKeywords")
                .optinMessage("optinMessage")
                .optoutKeywords("optoutKeywords")
                .optoutMessage("optoutMessage")
                .privacyPolicyLink("https://example.com")
                .termsAndConditionsLink("https://example.com")
                .build()

        val roundtrippedCampaignData =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(campaignData),
                jacksonTypeRef<CampaignData>(),
            )

        assertThat(roundtrippedCampaignData).isEqualTo(campaignData)
    }
}
