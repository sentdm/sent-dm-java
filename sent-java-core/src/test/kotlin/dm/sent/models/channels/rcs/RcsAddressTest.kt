// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.channels.rcs

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RcsAddressTest {

    @Test
    fun create() {
        val rcsAddress =
            RcsAddress.builder()
                .city("city")
                .country("country")
                .postalCode("postal_code")
                .state("state")
                .street("street")
                .build()

        assertThat(rcsAddress.city()).contains("city")
        assertThat(rcsAddress.country()).contains("country")
        assertThat(rcsAddress.postalCode()).contains("postal_code")
        assertThat(rcsAddress.state()).contains("state")
        assertThat(rcsAddress.street()).contains("street")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rcsAddress =
            RcsAddress.builder()
                .city("city")
                .country("country")
                .postalCode("postal_code")
                .state("state")
                .street("street")
                .build()

        val roundtrippedRcsAddress =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rcsAddress),
                jacksonTypeRef<RcsAddress>(),
            )

        assertThat(roundtrippedRcsAddress).isEqualTo(rcsAddress)
    }
}
