// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.numbers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberLookupResultTest {

    @Test
    fun create() {
        val numberLookupResult =
            NumberLookupResult.builder()
                .carrierName("carrier_name")
                .countryCode("country_code")
                .isPorted(true)
                .isValid_(true)
                .isVoip(true)
                .lineType("line_type")
                .mobileCountryCode("mobile_country_code")
                .mobileNetworkCode("mobile_network_code")
                .phoneNumber("phone_number")
                .build()

        assertThat(numberLookupResult.carrierName()).contains("carrier_name")
        assertThat(numberLookupResult.countryCode()).contains("country_code")
        assertThat(numberLookupResult.isPorted()).contains(true)
        assertThat(numberLookupResult.isValid_()).contains(true)
        assertThat(numberLookupResult.isVoip()).contains(true)
        assertThat(numberLookupResult.lineType()).contains("line_type")
        assertThat(numberLookupResult.mobileCountryCode()).contains("mobile_country_code")
        assertThat(numberLookupResult.mobileNetworkCode()).contains("mobile_network_code")
        assertThat(numberLookupResult.phoneNumber()).contains("phone_number")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val numberLookupResult =
            NumberLookupResult.builder()
                .carrierName("carrier_name")
                .countryCode("country_code")
                .isPorted(true)
                .isValid_(true)
                .isVoip(true)
                .lineType("line_type")
                .mobileCountryCode("mobile_country_code")
                .mobileNetworkCode("mobile_network_code")
                .phoneNumber("phone_number")
                .build()

        val roundtrippedNumberLookupResult =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(numberLookupResult),
                jacksonTypeRef<NumberLookupResult>(),
            )

        assertThat(roundtrippedNumberLookupResult).isEqualTo(numberLookupResult)
    }
}
