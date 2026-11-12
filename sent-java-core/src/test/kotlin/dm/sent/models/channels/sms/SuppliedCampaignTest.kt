// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.sms

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SuppliedCampaignTest {

    @Test
    fun create() {
        val suppliedCampaign =
            SuppliedCampaign.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val suppliedCampaign =
            SuppliedCampaign.builder().putAdditionalProperty("foo", JsonValue.from("bar")).build()

        val roundtrippedSuppliedCampaign =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(suppliedCampaign),
                jacksonTypeRef<SuppliedCampaign>(),
            )

        assertThat(roundtrippedSuppliedCampaign).isEqualTo(suppliedCampaign)
    }
}
