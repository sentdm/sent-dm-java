// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompleteSetupResponseTest {

    @Test
    fun create() {
        val profileCompleteSetupResponse = ProfileCompleteSetupResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileCompleteSetupResponse = ProfileCompleteSetupResponse.builder().build()

        val roundtrippedProfileCompleteSetupResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileCompleteSetupResponse),
                jacksonTypeRef<ProfileCompleteSetupResponse>(),
            )

        assertThat(roundtrippedProfileCompleteSetupResponse).isEqualTo(profileCompleteSetupResponse)
    }
}
