// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.JsonValue
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactResponseTest {

    @Test
    fun create() {
        val contactResponse =
            ContactResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .availableChannels("available_channels")
                .channelConsent(
                    ContactResponse.ChannelConsent.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
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

        assertThat(contactResponse.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(contactResponse.availableChannels()).contains("available_channels")
        assertThat(contactResponse.channelConsent())
            .contains(
                ContactResponse.ChannelConsent.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(contactResponse.countryCode()).contains("country_code")
        assertThat(contactResponse.createdAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(contactResponse.defaultChannel()).contains("default_channel")
        assertThat(contactResponse.formatE164()).contains("format_e164")
        assertThat(contactResponse.formatInternational()).contains("format_international")
        assertThat(contactResponse.formatNational()).contains("format_national")
        assertThat(contactResponse.formatRfc()).contains("format_rfc")
        assertThat(contactResponse.isInherited()).contains(true)
        assertThat(contactResponse.optOut()).contains(true)
        assertThat(contactResponse.phoneNumber()).contains("phone_number")
        assertThat(contactResponse.regionCode()).contains("region_code")
        assertThat(contactResponse.updatedAt())
            .contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contactResponse =
            ContactResponse.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .availableChannels("available_channels")
                .channelConsent(
                    ContactResponse.ChannelConsent.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
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

        val roundtrippedContactResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(contactResponse),
                jacksonTypeRef<ContactResponse>(),
            )

        assertThat(roundtrippedContactResponse).isEqualTo(contactResponse)
    }
}
