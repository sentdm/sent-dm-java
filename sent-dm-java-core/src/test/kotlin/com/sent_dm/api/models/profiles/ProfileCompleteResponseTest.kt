// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.profiles

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProfileCompleteResponseTest {

    @Test
    fun create() {
        val profileCompleteResponse = ProfileCompleteResponse.builder().build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val profileCompleteResponse = ProfileCompleteResponse.builder().build()

        val roundtrippedProfileCompleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(profileCompleteResponse),
                jacksonTypeRef<ProfileCompleteResponse>(),
            )

        assertThat(roundtrippedProfileCompleteResponse).isEqualTo(profileCompleteResponse)
    }
}
