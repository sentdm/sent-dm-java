// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactListResponseTest {

    @Test
    fun create() {
        val contactListResponse =
            ContactListResponse.builder()
                .addItem(
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
                )
                .page(0)
                .pageSize(0)
                .totalCount(0)
                .totalPages(0)
                .build()

        assertThat(contactListResponse.items().getOrNull())
            .containsExactly(
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
            )
        assertThat(contactListResponse.page()).contains(0)
        assertThat(contactListResponse.pageSize()).contains(0)
        assertThat(contactListResponse.totalCount()).contains(0)
        assertThat(contactListResponse.totalPages()).contains(0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactListResponse =
            ContactListResponse.builder()
                .addItem(
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
                )
                .page(0)
                .pageSize(0)
                .totalCount(0)
                .totalPages(0)
                .build()

        val roundtrippedContactListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactListResponse),
                jacksonTypeRef<ContactListResponse>(),
            )

        assertThat(roundtrippedContactListResponse).isEqualTo(contactListResponse)
    }
}
