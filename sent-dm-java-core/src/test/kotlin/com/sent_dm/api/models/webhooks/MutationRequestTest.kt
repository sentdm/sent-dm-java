// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MutationRequestTest {

    @Test
    fun create() {
        val mutationRequest = MutationRequest.builder().testMode(false).build()

        assertThat(mutationRequest.testMode()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mutationRequest = MutationRequest.builder().testMode(false).build()

        val roundtrippedMutationRequest =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mutationRequest),
                jacksonTypeRef<MutationRequest>(),
            )

        assertThat(roundtrippedMutationRequest).isEqualTo(mutationRequest)
    }
}
