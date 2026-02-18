// File generated from our OpenAPI spec by Stainless.

package dm.sent.models.contacts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContactTest {

    @Test
    fun create() {
        val contact =
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

        assertThat(contact.id()).contains("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(contact.availableChannels()).contains("available_channels")
        assertThat(contact.countryCode()).contains("country_code")
        assertThat(contact.createdAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(contact.defaultChannel()).contains("default_channel")
        assertThat(contact.formatE164()).contains("format_e164")
        assertThat(contact.formatInternational()).contains("format_international")
        assertThat(contact.formatNational()).contains("format_national")
        assertThat(contact.formatRfc()).contains("format_rfc")
        assertThat(contact.isInherited()).contains(true)
        assertThat(contact.optOut()).contains(true)
        assertThat(contact.phoneNumber()).contains("phone_number")
        assertThat(contact.regionCode()).contains("region_code")
        assertThat(contact.updatedAt()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val contact =
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

        val roundtrippedContact =
            jsonMapper.readValue(jsonMapper.writeValueAsString(contact), jacksonTypeRef<Contact>())

        assertThat(roundtrippedContact).isEqualTo(contact)
    }
}
