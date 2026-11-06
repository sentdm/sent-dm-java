// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import dm.sent.models.webhooks.PaginationCursors
import dm.sent.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactsListTest {

    @Test
    fun create() {
        val contactsList =
            ContactsList.builder()
                .addContact(
                    ContactResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .availableChannels("available_channels")
                        .countryCode("country_code")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .defaultChannel("default_channel")
                        .formatE164("format_e164")
                        .formatInternational("format_international")
                        .formatNational("format_national")
                        .formatRfc("format_rfc")
                        .isInherited(true)
                        .optOut(true)
                        .phoneNumber("phone_number")
                        .regionCode("region_code")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        assertThat(contactsList.contacts().getOrNull())
            .containsExactly(
                ContactResponse.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .availableChannels("available_channels")
                    .countryCode("country_code")
                    .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .defaultChannel("default_channel")
                    .formatE164("format_e164")
                    .formatInternational("format_international")
                    .formatNational("format_national")
                    .formatRfc("format_rfc")
                    .isInherited(true)
                    .optOut(true)
                    .phoneNumber("phone_number")
                    .regionCode("region_code")
                    .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(contactsList.pagination())
            .contains(
                PaginationMeta.builder()
                    .cursors(PaginationCursors.builder().after("after").before("before").build())
                    .hasMore(true)
                    .page(0)
                    .pageSize(0)
                    .totalCount(0)
                    .totalPages(0)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactsList =
            ContactsList.builder()
                .addContact(
                    ContactResponse.builder()
                        .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .availableChannels("available_channels")
                        .countryCode("country_code")
                        .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .customerId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                        .defaultChannel("default_channel")
                        .formatE164("format_e164")
                        .formatInternational("format_international")
                        .formatNational("format_national")
                        .formatRfc("format_rfc")
                        .isInherited(true)
                        .optOut(true)
                        .phoneNumber("phone_number")
                        .regionCode("region_code")
                        .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
                .pagination(
                    PaginationMeta.builder()
                        .cursors(
                            PaginationCursors.builder().after("after").before("before").build()
                        )
                        .hasMore(true)
                        .page(0)
                        .pageSize(0)
                        .totalCount(0)
                        .totalPages(0)
                        .build()
                )
                .build()

        val roundtrippedContactsList =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactsList),
                jacksonTypeRef<ContactsList>(),
            )

        assertThat(roundtrippedContactsList).isEqualTo(contactsList)
    }
}
