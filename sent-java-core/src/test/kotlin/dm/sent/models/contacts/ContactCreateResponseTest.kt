// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactCreateResponseTest {

    @Test
    fun create() {
        val contactCreateResponse =
            ContactCreateResponse.builder()
                .data(
                    ContactCreateResponse.Data.builder()
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
                .error(
                    ContactCreateResponse.Error.builder()
                        .code("code")
                        .details(
                            ContactCreateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ContactCreateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        assertThat(contactCreateResponse.data())
            .contains(
                ContactCreateResponse.Data.builder()
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
        assertThat(contactCreateResponse.error())
            .contains(
                ContactCreateResponse.Error.builder()
                    .code("code")
                    .details(
                        ContactCreateResponse.Error.Details.builder()
                            .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                            .build()
                    )
                    .docUrl("doc_url")
                    .message("message")
                    .build()
            )
        assertThat(contactCreateResponse.meta())
            .contains(
                ContactCreateResponse.Meta.builder()
                    .requestId("request_id")
                    .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .version("version")
                    .build()
            )
        assertThat(contactCreateResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactCreateResponse =
            ContactCreateResponse.builder()
                .data(
                    ContactCreateResponse.Data.builder()
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
                .error(
                    ContactCreateResponse.Error.builder()
                        .code("code")
                        .details(
                            ContactCreateResponse.Error.Details.builder()
                                .putAdditionalProperty("foo", JsonValue.from(listOf("string")))
                                .build()
                        )
                        .docUrl("doc_url")
                        .message("message")
                        .build()
                )
                .meta(
                    ContactCreateResponse.Meta.builder()
                        .requestId("request_id")
                        .timestamp(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .version("version")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedContactCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactCreateResponse),
                jacksonTypeRef<ContactCreateResponse>(),
            )

        assertThat(roundtrippedContactCreateResponse).isEqualTo(contactCreateResponse)
    }
}
