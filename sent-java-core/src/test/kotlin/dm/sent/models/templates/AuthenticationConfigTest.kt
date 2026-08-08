// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.templates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AuthenticationConfigTest {

    @Test
    fun create() {
        val authenticationConfig =
            AuthenticationConfig.builder()
                .addSecurityRecommendation(true)
                .codeExpirationMinutes(0)
                .build()

        assertThat(authenticationConfig.addSecurityRecommendation()).contains(true)
        assertThat(authenticationConfig.codeExpirationMinutes()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val authenticationConfig =
            AuthenticationConfig.builder()
                .addSecurityRecommendation(true)
                .codeExpirationMinutes(0)
                .build()

        val roundtrippedAuthenticationConfig =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(authenticationConfig),
                jacksonTypeRef<AuthenticationConfig>(),
            )

        assertThat(roundtrippedAuthenticationConfig).isEqualTo(authenticationConfig)
    }
}
