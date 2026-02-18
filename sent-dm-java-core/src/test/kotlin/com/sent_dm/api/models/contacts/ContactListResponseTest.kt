// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.jsonMapper
import com.sent_dm.api.models.webhooks.ApiError
import com.sent_dm.api.models.webhooks.ApiMeta
import com.sent_dm.api.models.webhooks.PaginationMeta
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactListResponseTest {

    @Test
    fun create() {
        val contactListResponse =
            ContactListResponse.builder()
                .data(
                    ContactListResponse.Data.builder()
                        .addContact(
                            Contact.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .availableChannels("available_channels")
                                .countryCode("country_code")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(contactListResponse.data())
            .contains(
                ContactListResponse.Data.builder()
                    .addContact(
                        Contact.builder()
                            .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .availableChannels("available_channels")
                            .countryCode("country_code")
                            .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                                PaginationMeta.Cursors.builder()
                                    .after("after")
                                    .before("before")
                                    .build()
                            )
                            .hasMore(true)
                            .page(0)
                            .pageSize(0)
                            .totalCount(0)
                            .totalPages(0)
                            .build()
                    )
                    .build()
            )
        assertThat(contactListResponse.error())
            .contains(
                ApiError.builder()
                    .code("code")
                    .details(
                        ApiError.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(contactListResponse.meta())
            .contains(
                ApiMeta.builder()
                    .requestId("request_id")
                    .responseTimeMs(0L)
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(contactListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactListResponse =
            ContactListResponse.builder()
                .data(
                    ContactListResponse.Data.builder()
                        .addContact(
                            Contact.builder()
                                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                .availableChannels("available_channels")
                                .countryCode("country_code")
                                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
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
                                    PaginationMeta.Cursors.builder()
                                        .after("after")
                                        .before("before")
                                        .build()
                                )
                                .hasMore(true)
                                .page(0)
                                .pageSize(0)
                                .totalCount(0)
                                .totalPages(0)
                                .build()
                        )
                        .build()
                )
                .error(
                    ApiError.builder()
                        .code("code")
                        .details(
                            ApiError.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ApiMeta.builder()
                        .requestId("request_id")
                        .responseTimeMs(0L)
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedContactListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactListResponse),
                jacksonTypeRef<ContactListResponse>(),
            )

        assertThat(roundtrippedContactListResponse).isEqualTo(contactListResponse)
    }
}
