// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.brands

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DestinationCountryTest {

    @Test
    fun create() {
        val destinationCountry = DestinationCountry.builder().id("id").isMain(true).build()

        assertThat(destinationCountry.id()).contains("id")
        assertThat(destinationCountry.isMain()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val destinationCountry = DestinationCountry.builder().id("id").isMain(true).build()

        val roundtrippedDestinationCountry =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(destinationCountry),
                jacksonTypeRef<DestinationCountry>(),
            )

        assertThat(roundtrippedDestinationCountry).isEqualTo(destinationCountry)
    }
}
