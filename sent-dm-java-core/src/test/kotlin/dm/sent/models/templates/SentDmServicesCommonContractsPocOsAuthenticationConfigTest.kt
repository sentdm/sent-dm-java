// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SentDmServicesCommonContractsPocOsAuthenticationConfigTest {

    @Test
    fun create() {
        val sentDmServicesCommonContractsPocOsAuthenticationConfig =
            SentDmServicesCommonContractsPocOsAuthenticationConfig.builder()
                .addSecurityRecommendation(true)
                .codeExpirationMinutes(0)
                .build()

        assertThat(
                sentDmServicesCommonContractsPocOsAuthenticationConfig.addSecurityRecommendation()
            )
            .contains(true)
        assertThat(sentDmServicesCommonContractsPocOsAuthenticationConfig.codeExpirationMinutes())
            .contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sentDmServicesCommonContractsPocOsAuthenticationConfig =
            SentDmServicesCommonContractsPocOsAuthenticationConfig.builder()
                .addSecurityRecommendation(true)
                .codeExpirationMinutes(0)
                .build()

        val roundtrippedSentDmServicesCommonContractsPocOsAuthenticationConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(
                    sentDmServicesCommonContractsPocOsAuthenticationConfig
                ),
                jacksonTypeRef<SentDmServicesCommonContractsPocOsAuthenticationConfig>(),
            )

        assertThat(roundtrippedSentDmServicesCommonContractsPocOsAuthenticationConfig)
            .isEqualTo(sentDmServicesCommonContractsPocOsAuthenticationConfig)
    }
}
