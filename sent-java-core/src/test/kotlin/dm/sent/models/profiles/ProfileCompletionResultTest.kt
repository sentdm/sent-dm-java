// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompletionResultTest {

    @Test
    fun create() {
        val profileCompletionResult =
            ProfileCompletionResult.builder().message("message").status("status").build()

        assertThat(profileCompletionResult.message()).contains("message")
        assertThat(profileCompletionResult.status()).contains("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileCompletionResult =
            ProfileCompletionResult.builder().message("message").status("status").build()

        val roundtrippedProfileCompletionResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileCompletionResult),
                jacksonTypeRef<ProfileCompletionResult>(),
            )

        assertThat(roundtrippedProfileCompletionResult).isEqualTo(profileCompletionResult)
    }
}
