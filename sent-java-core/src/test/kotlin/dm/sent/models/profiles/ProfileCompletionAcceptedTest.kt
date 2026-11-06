// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompletionAcceptedTest {

    @Test
    fun create() {
        val profileCompletionAccepted =
            ProfileCompletionAccepted.builder().message("message").build()

        assertThat(profileCompletionAccepted.message()).contains("message")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileCompletionAccepted =
            ProfileCompletionAccepted.builder().message("message").build()

        val roundtrippedProfileCompletionAccepted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileCompletionAccepted),
                jacksonTypeRef<ProfileCompletionAccepted>(),
            )

        assertThat(roundtrippedProfileCompletionAccepted).isEqualTo(profileCompletionAccepted)
    }
}
