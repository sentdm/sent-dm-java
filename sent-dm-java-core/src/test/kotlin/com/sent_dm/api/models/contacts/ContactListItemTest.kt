// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactListItemTest {

    @Test
    fun create() {
        val contactListItem =
            ContactListItem.builder()
                .id("id")
                .availableChannels("availableChannels")
                .countryCode("countryCode")
                .defaultChannel("defaultChannel")
                .formatE164("formatE164")
                .formatInternational("formatInternational")
                .formatNational("formatNational")
                .formatRfc("formatRfc")
                .phoneNumber("phoneNumber")
                .regionCode("regionCode")
                .build()

        assertThat(contactListItem.id()).contains("id")
        assertThat(contactListItem.availableChannels()).contains("availableChannels")
        assertThat(contactListItem.countryCode()).contains("countryCode")
        assertThat(contactListItem.defaultChannel()).contains("defaultChannel")
        assertThat(contactListItem.formatE164()).contains("formatE164")
        assertThat(contactListItem.formatInternational()).contains("formatInternational")
        assertThat(contactListItem.formatNational()).contains("formatNational")
        assertThat(contactListItem.formatRfc()).contains("formatRfc")
        assertThat(contactListItem.phoneNumber()).contains("phoneNumber")
        assertThat(contactListItem.regionCode()).contains("regionCode")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactListItem =
            ContactListItem.builder()
                .id("id")
                .availableChannels("availableChannels")
                .countryCode("countryCode")
                .defaultChannel("defaultChannel")
                .formatE164("formatE164")
                .formatInternational("formatInternational")
                .formatNational("formatNational")
                .formatRfc("formatRfc")
                .phoneNumber("phoneNumber")
                .regionCode("regionCode")
                .build()

        val roundtrippedContactListItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactListItem),
                jacksonTypeRef<ContactListItem>(),
            )

        assertThat(roundtrippedContactListItem).isEqualTo(contactListItem)
    }
}
