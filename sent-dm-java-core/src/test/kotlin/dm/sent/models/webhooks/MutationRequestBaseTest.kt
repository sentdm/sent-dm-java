// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.webhooks

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MutationRequestBaseTest {

    @Test
    fun create() {
        val mutationRequestBase = MutationRequestBase.builder().sandbox(false).build()

        assertThat(mutationRequestBase.sandbox()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val mutationRequestBase = MutationRequestBase.builder().sandbox(false).build()

        val roundtrippedMutationRequestBase =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mutationRequestBase),
                jacksonTypeRef<MutationRequestBase>(),
            )

        assertThat(roundtrippedMutationRequestBase).isEqualTo(mutationRequestBase)
    }
}
