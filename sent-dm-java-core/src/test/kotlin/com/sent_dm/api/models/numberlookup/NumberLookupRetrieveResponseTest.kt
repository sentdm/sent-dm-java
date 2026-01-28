// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.numberlookup

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class NumberLookupRetrieveResponseTest {

    @Test
    fun create() {
        val numberLookupRetrieveResponse =
            NumberLookupRetrieveResponse.builder()
                .countryCode("countryCode")
                .formatE164("formatE164")
                .formatInternational("formatInternational")
                .formatNational("formatNational")
                .formatRfc("formatRfc")
                .numberType("numberType")
                .phoneNumber("phoneNumber")
                .phoneTimezones("phoneTimezones")
                .regionCode("regionCode")
                .build()

        assertThat(numberLookupRetrieveResponse.countryCode()).contains("countryCode")
        assertThat(numberLookupRetrieveResponse.formatE164()).contains("formatE164")
        assertThat(numberLookupRetrieveResponse.formatInternational())
            .contains("formatInternational")
        assertThat(numberLookupRetrieveResponse.formatNational()).contains("formatNational")
        assertThat(numberLookupRetrieveResponse.formatRfc()).contains("formatRfc")
        assertThat(numberLookupRetrieveResponse.numberType()).contains("numberType")
        assertThat(numberLookupRetrieveResponse.phoneNumber()).contains("phoneNumber")
        assertThat(numberLookupRetrieveResponse.phoneTimezones()).contains("phoneTimezones")
        assertThat(numberLookupRetrieveResponse.regionCode()).contains("regionCode")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val numberLookupRetrieveResponse =
            NumberLookupRetrieveResponse.builder()
                .countryCode("countryCode")
                .formatE164("formatE164")
                .formatInternational("formatInternational")
                .formatNational("formatNational")
                .formatRfc("formatRfc")
                .numberType("numberType")
                .phoneNumber("phoneNumber")
                .phoneTimezones("phoneTimezones")
                .regionCode("regionCode")
                .build()

        val roundtrippedNumberLookupRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(numberLookupRetrieveResponse),
                jacksonTypeRef<NumberLookupRetrieveResponse>(),
            )

        assertThat(roundtrippedNumberLookupRetrieveResponse).isEqualTo(numberLookupRetrieveResponse)
    }
}
